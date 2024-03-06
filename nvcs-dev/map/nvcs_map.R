# Chris Toney, 2023-01-19
# nvcs_map.R v.2
# 	- added LANDFIRE mapped km2 within ecosections

library(sf)
library(tmap)

key_ver = "v. 14.1 key, division level (2023-03-27) - 2017 test data"
pt.csv = "C:/ctoney/FIA/nvcs/key_output_div_v14_idxy_20230328.csv"
out_dir = "c:/ctoney/FIA/nvcs/maps/div_v14/"
file_ext = ".png"
# for using km2 LANDFIRE-mapped NVC by section:
ecomap_lut = "C:/ctoney/FIA/nvcs/NVC_macrogroups_km2_by_section.csv"
lut = read.csv(ecomap_lut)

west_states = c("WA","OR","CA","ID","MT","WY","UT","CO","AZ","NM","NV")
#west_states = c("WA","OR","CA","ID","MT","WY","UT","CO","AZ","NM","NV","ND","SD","NE","KS","OK","TX")

sec = st_read("c:/ctoney/gis/ecomap/S_USA.EcomapSections_Alb83.shp")
prov = st_read("c:/ctoney/gis/ecomap/S_USA.EcoMapProvinces_Alb83.shp")

state = st_read("c:/ctoney/gis/state/cb_2014_us_state_500k_Alb83.shp")
west = state[state$STUSPS %in% west_states,]

land = st_read("c:/ctoney/gis/NaturalEarth/ne_50m_land_conus_base_Alb83.shp")
ocean = st_read("c:/ctoney/gis/NaturalEarth/ne_50m_ocean_conus_base_Alb83.shp")

pt.df = read.csv(pt.csv)
#NAD83 EPSG 4269
pt.sf = st_as_sf(pt.df, crs=4269, stringsAsFactors=F, coords=c("ACTUAL_LON","ACTUAL_LAT"), agr="identity")
pt.sf$dot_color = "#253494"
pt.sf[pt.sf$BALIVE==0,]$dot_color = "#ca0020"

# fix overlapping labels for a couple of section polygons
sec$label_ymod = 0
sec[sec$MAP_UNIT_S=="M261B",]$label_ymod = -1
sec[sec$MAP_UNIT_S=="M261E",]$label_ymod = 1

classes = unique(pt.df[,c("node_desc","nvc_level","nvc_code")])
for (i in 1:nrow(classes)) {
	class_name = classes[i,"node_desc"]
	nvc_level = classes[i,"nvc_level"]
	nvc_code = classes[i,"nvc_code"]
	
	file_name = gsub(" ", "_", class_name)
	file_name = gsub("[\\(\\)]", "", file_name)
	file_name = paste0(file_name, file_ext)

	# for using km2 LANDFIRE-mapped NVC by section:
	if (nvc_level == "division" || nvc_level == "macrogroup" || nvc_level == "group") {
		this_lut = lut[lut$nvc_code==nvc_code,]
	}
	this_sec = merge(sec, this_lut)
	if (nrow(this_sec) > 0) {
		if (nrow(this_sec[is.null(this_sec$lf_km2),])) {
			this_sec[is.null(this_sec$lf_km2),]$lf_km2 = 0
		}
	}
	else {
		this_sec = sec
		this_sec$lf_km2 = 0
	}
	
	class_pts = pt.sf[pt.sf$node_desc==class_name,]

	map_title = paste0("NVCS West draft ", key_ver, "\n", class_name)
	breaks=c(0,0.000001,1,10,100,1000,50000)
	palette=c("#f7f7f7", "#ffffb2", "#fed976", "#feb24c", "#fd8d3c", "#f03b20")
	labels = c("0", ">0 to 1", "1 to 10", "10 to 100", "500 to 1,000", ">1,000")

	m = tm_shape(land, bbox=st_bbox(west)) + tm_fill(col="#cccccc") +
	tm_shape(ocean, bbox=st_bbox(west)) + tm_fill(col="#a6cae0") +
	tm_shape(this_sec, bbox=st_bbox(west)) + tm_borders(col="#969696", lwd=0.5) +
	tm_fill("lf_km2", breaks=breaks, palette=palette, labels=labels, title="LANDFIRE km2") + 
	tm_text("MAP_UNIT_S", col="#525252", size = 0.5, ymod="label_ymod") +
	tm_shape(prov, bbox=st_bbox(west)) + tm_borders(col="#636363", lwd=1) +
	tm_shape(state, bbox=st_bbox(west)) + tm_borders(col="#bebada", lwd=1.2, alpha=0.4) +
	tm_shape(class_pts) + tm_dots(col = "dot_color", size = 0.03) +
	#tm_text("CND_CN", col="#525252", size=0.2) +
	tm_layout(main.title = map_title, main.title.position = c("left", "top"), main.title.size=0.75) +
	tm_legend(legend.position=c("left","bottom"), legend.text.size=0.6, legend.title.size=0.6)

	tmap_save(m, paste0(out_dir, file_name), dpi=450)
	
	file_name = NULL
	class_pts = NULL
	map_title = NULL
	this_lut = NULL
	this_sec = NULL
	
	m = NULL
}

