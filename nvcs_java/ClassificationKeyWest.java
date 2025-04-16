package nvcs_java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import nvcs_java.nvcs_components.ClassificationKey;
import nvcs_java.nvcs_components.Node;
import nvcs_java.nvcs_components.Plot;
import nvcs_java.nvcs_interfaces.INodeMatch;
import nvcs_java.nvcs_patterns.Pattern;
import nvcs_java.nvcs_patterns.PatternList;

public class ClassificationKeyWest extends ClassificationKey {

    public Map<Integer,Node> nodes;
    public Node root_node;

    public ClassificationKeyWest() {

        Pattern.register("rscd", "Pattern");
        Pattern.register("state", "Pattern");
        Pattern.register("ecoregion", "_EcoregionPattern");
        Pattern.register("plantation", "Pattern");
        Pattern.register("hydric", "Pattern");
        Pattern.register("riverine", "Pattern");
        Pattern.register("species", "_EcoregionPattern");
        Pattern.register("wetland", "Pattern");
        Pattern.register("ruderal", "Pattern");
        Pattern.register("exotic", "Pattern");
        Pattern.register("softwoodhardwood", "Pattern");
        Pattern.register("planted", "Pattern");
        Pattern.register("tallytree", "Pattern");

        nodes = new LinkedHashMap<>();
        root_node = _setup();
    }

    public Node _setup() {
        nodes.put(0, new Node(0, null, new Object[] { "", "", (INodeMatch) plot -> true }, ""));
        nodes.put(  1,  new Node(  1,   0, element_001(), "Forest Plantations"));
        nodes.put(  2,  new Node(  2,   0, element_002(), "Natural (including ruderal) Forests"));
        nodes.put(  3,  new Node(  3,   2, element_003(), "Wetland Forest & Woodlands"));
        nodes.put(  4,  new Node(  4,   3, element_004(), "Temperate Flooded & Swamp Forest Formation"));
        nodes.put(  5,  new Node(  5,   4, element_005(), "Great Plains Temperate Flooded & Swamp Forests"));
        nodes.put(  6,  new Node(  6,   5, element_006(), "Eastern North American-Great Plains Flooded & Swamp Forest Division (D011)"));
        nodes.put(  7,  new Node(  7,   6, element_007(), "Great Plains Flooded & Swamp Forest (M028)"));
        nodes.put(  8,  new Node(  8,   7, element_008(), "Great Plains Cottonwood - Green Ash Floodplain Forest (G147)"));
        nodes.put(  9,  new Node(  9,   6, element_009(), "Eastern North American Ruderal Flooded & Swamp Forest (M302)"));
        nodes.put( 10,  new Node( 10,   5, element_010(), "Southeastern North American Flooded & Swamp Forest Division (D062)"));
        nodes.put( 11,  new Node( 11,  10, element_011(), "Southern Great Plains Floodplain Forest & Woodland (M154)"));
        nodes.put( 12,  new Node( 12,  11, element_012(), "Southeastern Great Plains Floodplain Forest (G784)"));
        nodes.put( 13,  new Node( 13,  10, element_013(), "Southeastern North American Ruderal Flooded & Swamp Forest (M310)"));
        nodes.put( 14,  new Node( 14,   4, element_014(), "Western North American Temperate Flooded & Swamp Forests"));
        nodes.put( 15,  new Node( 15,  14, element_015(), "Vancouverian Flooded & Swamp Forest Division (D193)"));
        nodes.put( 16,  new Node( 16,  15, element_016(), "Vancouverian Flooded & Swamp Forest (M035)"));
        nodes.put( 17,  new Node( 17,  16, element_017(), "North-Central Pacific Montane Riparian & Seepage Swamp Forest (G507)"));
        nodes.put( 18,  new Node( 18,  16, element_018(), "North-Central Pacific Maritime Lowland Swamp Forest (G853)"));
        nodes.put( 19,  new Node( 19,  16, element_019(), "North-Central Pacific Lowland Riparian Forest (G851)"));
        nodes.put( 20,  new Node( 20,  15, element_020(), "Western North American Flooded Ruderal Forests - Vancouverian"));
        nodes.put( 21,  new Node( 21,  14, element_021(), "Rocky Mountain-Great Basin Montane Flooded & Swamp Forest Division (D195)"));
        nodes.put( 22,  new Node( 22,  21, element_022(), "Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)"));
        nodes.put( 23,  new Node( 23,  22, element_023(), "Rocky Mountain-Great Basin Swamp Forest (G505)"));
        nodes.put( 24,  new Node( 24,  22, element_024(), "Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (G506)"));
        nodes.put( 25,  new Node( 25,  22, element_025(), "Central Rocky Mountain Lowland & Foothill Riparian Forest (G796)"));
        nodes.put( 26,  new Node( 26,  21, element_026(), "Western North American Flooded Ruderal Forests - Rocky Mountain"));
        nodes.put( 27,  new Node( 27,  14, element_027(), "Western North American Interior Flooded Forest Division (D013)"));
        nodes.put( 28,  new Node( 28,  27, element_028(), "Interior Warm & Cool Desert Riparian Forest (M036)"));
        nodes.put( 29,  new Node( 29,  28, element_029(), "Tamaulipan Riparian Scrub Forest (G549)"));
        nodes.put( 30,  new Node( 30,  28, element_030(), "Californian Mediterranean Riparian Forest (G113)"));
        nodes.put( 31,  new Node( 31,  28, element_031(), "Southwest Warm Desert Riparian Forest (G109)"));
        nodes.put( 32,  new Node( 32,  28, element_032(), "Great Basin-Colorado Plateau Semi-Desert Riparian Forest (G107)"));
        nodes.put( 33,  new Node( 33,  27, element_033(), "Interior West Ruderal Flooded & Swamp Forest & Woodland (M298)"));
        nodes.put( 34,  new Node( 34,   2, element_034(), "Upland Forest & Woodlands"));
        nodes.put( 35,  new Node( 35,  34, element_035(), "Temperate & Boreal Forest & Woodland Subclass"));
        nodes.put( 36,  new Node( 36,  35, element_036(), "Great Plains Temperate Forests"));
        nodes.put( 37,  new Node( 37,  36, element_037(), "North American Great Plains Forest & Woodland Division (D326)"));
        nodes.put( 38,  new Node( 38,  37, element_038(), "Southern Great Plains Forest & Woodland (M544)"));
        nodes.put( 39,  new Node( 39,  38, element_039(), "Cross Timbers Forest & Woodland (G887)"));
        nodes.put( 40,  new Node( 40,  38, element_040(), "Edwards Plateau Dry-Mesic Hardwood Forest (G028)"));
        nodes.put( 41,  new Node( 41,  38, element_041(), "Edwards Plateau Dry Woodland (G126)"));
        nodes.put( 42,  new Node( 42,  37, element_042(), "Northern Great Plains Forest & Woodland (M545)"));
        nodes.put( 43,  new Node( 43,  42, element_043(), "Great Plains Bur Oak Forest & Woodland(G329)"));
        nodes.put( 44,  new Node( 44,  42, element_044(), "Northeastern Great Plains Aspen Woodland (G146)"));
        nodes.put( 45,  new Node( 45,  42, element_045(), "Northwestern Great Plains Aspen Woodland (G328)"));
        nodes.put( 46,  new Node( 46,  42, element_046(), "Great Plains Mesic Forest & Woodland (G145)"));
        nodes.put( 47,  new Node( 47,  37, element_047(), "Great Plains Ruderal Woodland (M524)"));
        nodes.put( 48,  new Node( 48,  36, element_048(), "Southeastern North American Forest & Woodland Division (D006)"));
        nodes.put( 49,  new Node( 49,  48, element_049(), "Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)"));
        nodes.put( 50,  new Node( 50,  49, element_050(), "Coastal Live Oak - Hickory - Palmetto Forest (G798)"));
        nodes.put( 51,  new Node( 51,  49, element_051(), "Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)"));
        nodes.put( 52,  new Node( 52,  48, element_052(), "Southeastern North American Ruderal Forest (M305)"));
        nodes.put( 53,  new Node( 53,  36, element_053(), "Eastern North American Forest & Woodland Division (D008)"));
        nodes.put( 54,  new Node( 54,  53, element_054(), "Eastern North American Forest & Woodland Natural Forests"));
        nodes.put( 55,  new Node( 55,  54, element_055(), "Central Midwest Oak Forest, Woodland & Savanna (M012)"));
        nodes.put( 56,  new Node( 56,  55, element_056(), "North-Central Oak - Hickory Forest & Woodland (G649)"));
        nodes.put( 57,  new Node( 57,  54, element_057(), "Southern & South-Central Oak - Pine Forest & Woodland (M016)"));
        nodes.put( 58,  new Node( 58,  57, element_058(), "Western Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)"));
        nodes.put( 59,  new Node( 59,  53, element_059(), "Eastern North American Ruderal Forests"));
        nodes.put( 60,  new Node( 60,  59, element_060(), "Eastern North American Ruderal Forest (M013)"));
        nodes.put( 61,  new Node( 61,  35, element_061(), "Western North American Temperate Forests"));
        nodes.put( 62,  new Node( 62,  61, element_062(), "Warm Temperate Forest & Woodland Formation"));
        nodes.put( 63,  new Node( 63,  62, element_063(), "Californian Forest & Woodland Division (D007)"));
        nodes.put( 64,  new Node( 64,  63, element_064(), "Californian Forest & Woodland (M009)"));
        nodes.put( 65,  new Node( 65,  64, element_065(), "Californian Conifer Forest & Woodland (G198)"));
        nodes.put( 66,  new Node( 66,  64, element_066(), "Californian Broadleaf Forest & Woodland (G195)"));
        nodes.put( 67,  new Node( 67,  63, element_067(), "Californian Ruderal Forest (M513)"));
        nodes.put( 68,  new Node( 68,  62, element_068(), "Madrean Forest & Woodland Division (D331)"));
        nodes.put( 69,  new Node( 69,  68, element_069(), "Madrean Natural Forests & Woodlands"));
        nodes.put( 70,  new Node( 70,  69, element_070(), "Madrean Lowland Evergreen Woodland (M010)"));
        nodes.put( 71,  new Node( 71,  70, element_071(), "Madrean Pinyon - Juniper Woodland (G200)"));
        nodes.put( 72,  new Node( 72,  70, element_072(), "Madrean Encinal (G201)"));
        nodes.put( 73,  new Node( 73,  70, element_073(), "Madrean Juniper Open Woodland (G487)"));
        nodes.put( 74,  new Node( 74,  69, element_074(), "Madrean Montane Forest & Woodland (M011)"));
        nodes.put( 75,  new Node( 75,  74, element_075(), "Madrean Upper Montane Conifer - Oak Forest & Woodland (G202)"));
        nodes.put( 76,  new Node( 76,  74, element_076(), "Madrean Lower Montane Pine - Oak Forest & Woodland (G203)"));
        nodes.put( 77,  new Node( 77,  68, element_077(), "Western North American Ruderal Forests - Madrean-Balconian"));
        nodes.put( 78,  new Node( 78,  61, element_078(), "Cool Temperate Forest & Woodland Formation"));
        nodes.put( 79,  new Node( 79,  78, element_079(), "Pacific Coast Temperate Rainforest Division (D338)"));
        nodes.put( 80,  new Node( 80,  79, element_080(), "Vancouverian Coastal Rainforest (M024)"));
        nodes.put( 81,  new Node( 81,  80, element_081(), "Vancouverian Dry Coastal Beach Pine Forest & Woodland (G205)"));
        nodes.put( 82,  new Node( 82,  80, element_082(), "Californian Coastal Redwood Forest (G235)"));
        nodes.put( 83,  new Node( 83,  80, element_083(), "North Pacific Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)"));
        nodes.put( 84,  new Node( 84,  80, element_084(), "North Pacific Maritime Douglas-fir - Western Hemlock Rainforest (G240)"));
        nodes.put( 85,  new Node( 85,  80, element_085(), "North-Central Pacific Maritime Silver Fir - Western Hemlock Rainforest (G241)"));
        nodes.put( 86,  new Node( 86,  80, element_086(), "North-Central Pacific Western Hemlock - Sitka Spruce Rainforest (G751)"));
        nodes.put( 87,  new Node( 87,  78, element_087(), "Western North American Pinyon-Juniper Woodland & Scrub Division (D010)"));
        nodes.put( 88,  new Node( 88,  87, element_088(), "Intermountain Pinyon-Juniper Woodland (M896)"));
        nodes.put( 89,  new Node( 89,  88, element_089(), "Intermountain Western Juniper Open Woodland (G248)"));
        nodes.put( 90,  new Node( 90,  88, element_090(), "Intermountain Basins Curl-leaf Mountain-mahogany Woodland & Scrub (G249)"));
        nodes.put( 91,  new Node( 91,  88, element_091(), "Great Basin Pinyon - Juniper Woodland (G899)"));
        nodes.put( 92,  new Node( 92,  88, element_092(), "Colorado Plateau Pinyon - Juniper Woodland (G900)"));
        nodes.put( 93,  new Node( 93,  88, element_093(), "Intermountain Utah Juniper Open Woodland (G105)"));
        nodes.put( 94,  new Node( 94,  87, element_094(), "Southern Rocky Mountain Two-needle Pinyon-Juniper Woodland (M897)"));
        nodes.put( 95,  new Node( 95,  94, element_095(), "Southern Rocky Mountain Pinyon - Juniper Woodland (G253)"));
        nodes.put( 96,  new Node( 96,  94, element_096(), "Southern Rocky Mountain Juniper Open Woodland (G252)"));
        nodes.put( 97,  new Node( 97,  78, element_097(), "Pacific Mountains Forest & Woodland Division (D339)"));
        nodes.put( 98,  new Node( 98,  97, element_098(), "Southern Vancouverian Dry Foothill Forest & Woodland (M886)"));
        nodes.put( 99,  new Node( 99,  98, element_099(), "Cascadian Oregon White Oak - Conifer Forest & Woodland (G206)"));
        nodes.put(100,  new Node(100,  98, element_100(), "Californian Moist Coastal Mixed Evergreen Forest (G208)"));
        nodes.put(101,  new Node(101,  98, element_101(), "Southern Vancouverian Dry Douglas-fir - Madrone Woodland (G800)"));
        nodes.put(102,  new Node(102,  97, element_102(), "Southern Vancouverian Montane-Foothill Forest (M023)"));
        nodes.put(103,  new Node(103, 102, element_103(), "Californian Montane Conifer Forest & Woodland (G344)"));
        nodes.put(104,  new Node(104,  97, element_104(), "Vancouverian Ruderal Forest (M405)"));
        nodes.put(105,  new Node(105, 104, element_105(), "Vancouverian Ruderal Forest (G801)"));
        nodes.put(106,  new Node(106,  78, element_106(), "Rocky Mountain Foothills & Montane Forest & Woodland (D337)"));
        nodes.put(107,  new Node(107, 106, element_107(), "Southern Rocky Mountain Lower Montane Forest (M022)"));
        nodes.put(108,  new Node(108, 107, element_108(), "Southern Rocky Mountain Bristlecone Pine Forest & Woodland (G102)"));
        nodes.put(109,  new Node(109, 107, element_109(), "Southern Rocky Mountain Mesic-Moist Mixed Conifer Forest (G225)"));
        nodes.put(110,  new Node(110, 107, element_110(), "Southern Rocky Mountain Dry Mixed Conifer Forest & Woodland (G226)"));
        nodes.put(111,  new Node(111, 107, element_111(), "Southern Rocky Mountain Ponderosa Pine Forest & Woodland (G103)"));
        nodes.put(112,  new Node(112, 106, element_112(), "Central Rocky Mountain Dry Lower Montane-Foothill Forest (M501)"));
        nodes.put(113,  new Node(113, 112, element_113(), "Central Rocky Mountain Montane White Spruce Forest (G345)"));
        nodes.put(114,  new Node(114, 112, element_114(), "Black Hills-Northwestern Great Plains Ponderosa Pine Forest & Woodland (G216)"));
        nodes.put(115,  new Node(115, 112, element_115(), "Rocky Mountain Foothill-Rock Outcrop Limber Pine - Juniper Woodland (G209)"));
        nodes.put(116,  new Node(116, 112, element_116(), "Central Rocky Mountain Ponderosa Pine Forest & Woodland (G213)"));
        nodes.put(117,  new Node(117, 112, element_117(), "Central Rocky Mountain Mesic-Moist Mixed Conifer Forest (G215)"));
        nodes.put(118,  new Node(118, 112, element_118(), "Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)"));
        nodes.put(119,  new Node(119, 106, element_119(), "Central Rocky Mountain Mesic Lower Montane Forest (M500)"));
        nodes.put(120,  new Node(120, 119, element_120(), "East Cascades Moist-Mesic Grand Fir - Douglas-fir Forest (G212)"));
        nodes.put(121,  new Node(121, 119, element_121(), "Central Rocky Mountain-Interior Cedar - Hemlock Forest (G217)"));
        nodes.put(122,  new Node(122, 119, element_122(), "Central Rocky Mountain-Interior Mesic Grand Fir - Douglas-fir - Western Larch Forest (G211)"));
        nodes.put(123,  new Node(123,  78, element_123(), "Western Cordilleran Subalpine-High Montane Forest & Woodland (D336)"));
        nodes.put(124,  new Node(124, 123, element_124(), "Rocky Mountain Subalpine-High Montane Forest (M020)"));
        nodes.put(125,  new Node(125, 124, element_125(), "Rocky Mountain-Interior Subalpine-Montane Aspen Forest (G222)"));
        nodes.put(126,  new Node(126, 124, element_126(), "Rocky Mountain Subalpine Moist-Mesic Spruce - Fir Forest (G218)"));
        nodes.put(127,  new Node(127, 124, element_127(), "Rocky Mountain Subalpine Dry-Mesic Spruce - Fir Forest (G219)"));
        nodes.put(128,  new Node(128, 124, element_128(), "Rocky Mountain Lodgepole Pine Forest & Woodland (G220)"));
        nodes.put(129,  new Node(129, 124, element_129(), "Rocky Mountain Limber Pine Subalpine-Montane Woodland (G101)"));
        nodes.put(130,  new Node(130, 124, element_130(), "Central Rocky Mountain Whitebark Pine - Subalpine Larch Forest & Woodland (G223)"));
        nodes.put(131,  new Node(131, 123, element_131(), "Vancouverian Subalpine-High Montane Forest (M025)"));
        nodes.put(132,  new Node(132, 131, element_132(), "Sierra-Cascade Cold-Dry Subalpine Woodland (G243)"));
        nodes.put(133,  new Node(133, 131, element_133(), "Sierra-Cascade Red Fir - Mountain Hemlock Forest (G749)"));
        nodes.put(134,  new Node(134, 131, element_134(), "North-Central Pacific Mountain Hemlock - Silver Fir Woodland (G849)"));

        for (Map.Entry<Integer,Node> entry : nodes.entrySet()) {
            Integer ident = entry.getKey();
            Node element = entry.getValue();
            if (element.parent != null) {
                nodes.get(element.parent).children.add(nodes.get(ident));
            }
        }

        return nodes.get(0);
    }

    public Object[] element_001() {

        // Forest Plantations
        // 

        String level = "";
        String code = "";

        // Vegetation shows evidence of intensive human management as planted vegetation,
        // such as trees being planted in rows, often dominated by single-species, and even
        // aged.  The stand is identified as planted in the FIA database (Stand Origin Code
        // = 1 "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001).
        // AND the Stand Origin Species (STDORGSP) is EITHER a Populus spp. or Exotic.

        Map<String,String> PLANTATION_values = new HashMap<>();
        PLANTATION_values.put("plantation","yes");
        PatternList PLANTATION = new PatternList("PLANTATION", PLANTATION_values);

        Map<String,String> PLANTED_EXOTIC_values = new HashMap<>();
        PLANTED_EXOTIC_values.put("planted","yes");
        PLANTED_EXOTIC_values.put("exotic","yes");
        PatternList PLANTED_EXOTIC = new PatternList("PLANTED_EXOTIC", PLANTED_EXOTIC_values);

        Map<String,String> PLANTED_POPULUS_values = new HashMap<>();
        PLANTED_POPULUS_values.put("planted","yes");
        PLANTED_POPULUS_values.put("species","Populus");
        PatternList PLANTED_POPULUS = new PatternList("PLANTED_POPULUS", PLANTED_POPULUS_values);

        INodeMatch match = plot -> (
            plot.match(PLANTATION)
           && (plot.riv(PLANTED_EXOTIC) > 0 || plot.riv(PLANTED_POPULUS) > 0)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_002() {

        // Natural (including ruderal) Forests
        // C01

        String level = "class";
        String code = "C01";

        // Natural (including ruderal) forests

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_003() {

        // Wetland Forest & Woodlands
        // 

        String level = "class";
        String code = "";

        // Vegetation is a Western section wetland forest, where:
        // i.  The ecoregion (ECOREGION) is 315C-E, 315G, OR 321B [Southern Great Plains Floodplain Forest & Woodland] AND
        //  ia. If the physiographic class code is RIVERINE = Y
        //   OR
        //  ib. the combination of facultative wet (W2) and facultative (W3) tree (RIV =>50%) species
        //  Celtis laevigata var. reticulata, Fraxinus pennsylvanica, Populus deltoides, or Ulmus americana
        // OR
        // ii. If the physiographic class code is RIVERINE = Y, AND EITHER
        //  iia.  Facultative wet (W2) tree species have at least a combined RIV =>20%,
        //  and OBLigate wet (W1) understory species (See Appendix xx) have a combined SPCOV =>10%,
        //  OR
        //  iib.  Facultative wet (W2) tree species have at least a combined RIV => 20%,
        //  and the combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 40%,
        //  OR
        //  iic.  Facultative (W3) tree species have at least a combined RIV => 20%,
        //  The combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 50%,
        //  OR
        //  iid. Wetland indicators for trees (% RIV) or understory (% SPCOV) species W1, W2 (WI) > Upland indicators (UI).
        //  Do not include exotic species.
        //  OR
        //  iie. RIV Populus fremontii > 20% # test
        // OR
        // iii. If physiographic class code is HYDRIC = Y, OR if the physiographic class code is RIVERINE = Y, AND EITHER
        //  iiia. Facultative wet (W2) tree species have at least a combined RIV =>10%,
        //  and OBLigate wet (W1) understory species (See Appendix xx) have a combined SPCOV =>10%,
        //  OR
        //  iiib. Facultative wet (W2) tree species have at least a combined RIV => 10%,
        //  and the combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 50%,
        //  OR
        //  iiic. Facultative (W3) tree species have at least a combined RIV => 10%, and
        //  the combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 40%,
        //  OR
        //  iiid. Wetland indicators for trees (% RIV) or understory (% SPCOV) species W1, W2 (WI) > Upland indicators (UI).
        //  Do not include exotic species.
        //  OR
        //  iiie. RIV Populus fremontii > 20% # test
        //  OR
        // iv. If the ecoregion (ECOREGION ) is 242 AND
        //  iva. The facultative wet (W2) tree species have at least a combined RIV =>20%, and the combination of
        // obligate wet (W1) and facultative wet (W2) understory species and have a combined SPCOV =>50%
        //  OR
        //  va. The “facultative wet” (W2) tree species have at least a combined RIV =>520%, and the combination of “obligate wet” (W1) and “facultative wet” (W2) understory species and have a combined SPCOV =>50%

        Map<String,String> ECOREGIONS_SGP_values = new HashMap<>();
        ECOREGIONS_SGP_values.put("ecoregion","315Ce, 315G, 321B");
        PatternList ECOREGIONS_SGP = new PatternList("ECOREGIONS_SGP", ECOREGIONS_SGP_values);

        Map<String,String> ECOREGIONS_IV_values = new HashMap<>();
        ECOREGIONS_IV_values.put("ecoregion","242");
        PatternList ECOREGIONS_IV = new PatternList("ECOREGIONS_IV", ECOREGIONS_IV_values);

        Map<String,String> RIVERINE_values = new HashMap<>();
        RIVERINE_values.put("riverine","yes");
        PatternList RIVERINE = new PatternList("RIVERINE", RIVERINE_values);

        Map<String,String> HYDRIC_OR_RIVERINE_values = new HashMap<>();
        HYDRIC_OR_RIVERINE_values.put("hydric","yes");
        HYDRIC_OR_RIVERINE_values.put("riverine","yes");
        PatternList HYDRIC_OR_RIVERINE = new PatternList("HYDRIC_OR_RIVERINE", HYDRIC_OR_RIVERINE_values);

        Map<String,String> W1_values = new HashMap<>();
        W1_values.put("wetland","OBL");
        PatternList W1 = new PatternList("W1", W1_values);

        Map<String,String> W1_UNDERSTORY_values = new HashMap<>();
        W1_UNDERSTORY_values.put("wetland","OBL");
        W1_UNDERSTORY_values.put("tallytree","no");
        PatternList W1_UNDERSTORY = new PatternList("W1_UNDERSTORY", W1_UNDERSTORY_values);

        Map<String,String> W2_values = new HashMap<>();
        W2_values.put("wetland","FACW");
        PatternList W2 = new PatternList("W2", W2_values);

        Map<String,String> W2_UNDERSTORY_values = new HashMap<>();
        W2_UNDERSTORY_values.put("wetland","FACW");
        W2_UNDERSTORY_values.put("tallytree","no");
        PatternList W2_UNDERSTORY = new PatternList("W2_UNDERSTORY", W2_UNDERSTORY_values);

        Map<String,String> W3_values = new HashMap<>();
        W3_values.put("wetland","FAC");
        PatternList W3 = new PatternList("W3", W3_values);

        Map<String,String> WI_values = new HashMap<>();
        WI_values.put("wetland","OBL, FACW");
        WI_values.put("exotic","no");
        PatternList WI = new PatternList("WI", WI_values);

        Map<String,String> WI_UNDERSTORY_values = new HashMap<>();
        WI_UNDERSTORY_values.put("wetland","OBL, FACW");
        WI_UNDERSTORY_values.put("exotic","no");
        WI_UNDERSTORY_values.put("tallytree","no");
        PatternList WI_UNDERSTORY = new PatternList("WI_UNDERSTORY", WI_UNDERSTORY_values);

        Map<String,String> UI_values = new HashMap<>();
        UI_values.put("wetland","UPL");
        UI_values.put("exotic","no");
        PatternList UI = new PatternList("UI", UI_values);

        Map<String,String> UI_UNDERSTORY_values = new HashMap<>();
        UI_UNDERSTORY_values.put("wetland","UPL");
        UI_UNDERSTORY_values.put("exotic","no");
        UI_UNDERSTORY_values.put("tallytree","no");
        PatternList UI_UNDERSTORY = new PatternList("UI_UNDERSTORY", UI_UNDERSTORY_values);

        Map<String,String> Populus_fremontii_values = new HashMap<>();
        Populus_fremontii_values.put("species","Populus fremontii");
        PatternList Populus_fremontii = new PatternList("Populus_fremontii", Populus_fremontii_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_SGP) && ( plot.match(RIVERINE) || (plot.riv(W2) + plot.riv(W3) >= 50) ))
           || (plot.match(RIVERINE) && ( (plot.riv(W2) >= 20 && plot.spcov(W1_UNDERSTORY) >= 10)
                                     || (plot.riv(W2) >= 20 && plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 40)
                                     || (plot.riv(W3) >= 20 && plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 50)
                                     || (plot.riv(WI) > plot.riv(UI) || plot.spcov(WI_UNDERSTORY) > plot.spcov(UI_UNDERSTORY)) ))
                                     || (plot.riv(Populus_fremontii) >= 20)
           || (plot.match(HYDRIC_OR_RIVERINE) && ( (plot.riv(W2) >= 10 && plot.spcov(W1_UNDERSTORY) >= 10)
                                                || (plot.riv(W2) >= 10 && plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 50)
                                                || (plot.riv(W3) >= 10 && plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 40)
                                                || (plot.riv(WI) > plot.riv(UI) || plot.spcov(WI_UNDERSTORY) > plot.spcov(UI_UNDERSTORY)) ))
                                                || (plot.riv(Populus_fremontii) >= 20)
           || (plot.match(ECOREGIONS_IV) && (plot.riv(W2) >= 20 && plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 50))
           || (plot.riv(W2) >= 20 && plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >=50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_004() {

        // Temperate Flooded & Swamp Forest Formation
        // F026

        String level = "formation";
        String code = "F026";

        //   Tree-dominated wetlands in a temperate climate that is influenced by minerotrophic
        //   groundwater, either on mineral or organic soils. The vegetation is dominated by broad-leaved
        //   or needle-leaved trees, generally over 10% tree cover, and the substrate is either a
        //   wood-rich peat or a mineral soil on floodplains.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_005() {

        // Great Plains Temperate Flooded & Swamp Forests
        // F026

        String level = "formation";
        String code = "F026";

        // Forests found in ECOREGION 315, 331, 332, M334, AND
        // tree composition is dominated by one or more of Acer negundo, Betula occidentalis
        // Carya illinoinensis, Celtis laevigata, Celtis laevigata var. reticulata,
        // Celtis occidentalis, Fraxinus pennsylvanica, Juglans microcarpa,
        // Juglans nigra, Juglans major, Platanus occidentalis, Populus angustifolia Populus deltoides,
        // Quercus macrocarpa, Quercus shumardii, Quercus virginiana, Salix nigra,
        // Salix amygdaloides, Sapindus saponaria var. drummondii,
        // Sideroxylon lanuginosum ssp. lanuginosum, Taxodium distichum, or Ulmus americana
        // (=>20% RIV)

        Map<String,String> ECOREGIONS_GP_values = new HashMap<>();
        ECOREGIONS_GP_values.put("ecoregion","315, 331, 332, M334");
        PatternList ECOREGIONS_GP = new PatternList("ECOREGIONS_GP", ECOREGIONS_GP_values);

        Map<String,String> DIAGNOSTIC_SPECIES_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        DIAGNOSTIC_SPECIES_values.put("species","Carya illinoinensis");
        DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata var. reticulata");
        DIAGNOSTIC_SPECIES_values.put("species","Celtis occidentalis");
        DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        DIAGNOSTIC_SPECIES_values.put("species","Juglans microcarpa");
        DIAGNOSTIC_SPECIES_values.put("species","Juglans nigra");
        DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        DIAGNOSTIC_SPECIES_values.put("species","Platanus occidentalis");
        DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        DIAGNOSTIC_SPECIES_values.put("species","Quercus shumardii");
        DIAGNOSTIC_SPECIES_values.put("species","Quercus virginiana");
        DIAGNOSTIC_SPECIES_values.put("species","Salix nigra");
        DIAGNOSTIC_SPECIES_values.put("species","Salix amygdaloides");
        DIAGNOSTIC_SPECIES_values.put("species","Sapindus saponaria var. drummondii");
        DIAGNOSTIC_SPECIES_values.put("species","Sideroxylon lanuginosum ssp. lanuginosum");
        DIAGNOSTIC_SPECIES_values.put("species","Taxodium distichum");
        DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        DIAGNOSTIC_SPECIES_values.put("species","Betula occidentalis");
        DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        PatternList DIAGNOSTIC_SPECIES = new PatternList("DIAGNOSTIC_SPECIES", DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS_GP) && plot.riv(DIAGNOSTIC_SPECIES) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_006() {

        // Eastern North American-Great Plains Flooded & Swamp Forest Division (D011)
        // D011

        String level = "division";
        String code = "D011";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION ECOREGION 332, M334, 331 – exclude 331A, 
        // AND
        // ii. EITHER
        // a. Tree composition dominated by one or more of STRONG diagnostic tree species
        // Celtis occidentalis, Fraxinus pennsylvanica, Populus deltoides,
        // Salix nigra or Salix amygdaloides (=>50% RIV),
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species any combination of
        // Acer negundo, Acer saccharinum, Celtis laevigata, Platanus occidentalis, or Ulmus americana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","332, M334, 331");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> ECOREGIONS_EXCL_values = new HashMap<>();
        ECOREGIONS_EXCL_values.put("ecoregion","331A");
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Celtis occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix nigra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix amygdaloides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer saccharinum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Platanus occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_007() {

        // Great Plains Flooded & Swamp Forest (M028)
        // M028

        String level = "macrogroup";
        String code = "M028";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_008() {

        // Great Plains Cottonwood - Green Ash Floodplain Forest (G147)
        // G147

        String level = "group";
        String code = "G147";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315D, 332A, 332B, 315A, 315B, 315C, 315F,
        // 315G, M313B, 331 – exclude 331A and 331J, M332D, M334A, 332C, 332D,
        // 332F, 332E and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Populus deltoides (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer negundo, Fraxinus pennsylvanica, Salix nigra,
        // or Salix amygdaloides (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315D, 332A, 332B, 315A, 315B, 315C, 315F, 315G, M313B, 331, M332D, M334A, 332C, 332D, 332F, 332E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> ECOREGIONS_EXCL_values = new HashMap<>();
        ECOREGIONS_EXCL_values.put("ecoregion","331A, 331J");
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix amygdaloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL)) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_009() {

        // Eastern North American Ruderal Flooded & Swamp Forest (M302)
        // M302

        String level = "macrogroup";
        String code = "M302";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER] - needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_010() {

        // Southeastern North American Flooded & Swamp Forest Division (D062)
        // D062

        String level = "division";
        String code = "D062";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION 315 AND
        // tree composition dominated by one or more of Carya illinoinensis,
        // Quercus virginiana, or Sabal palmetto (=>20% RIV);
        // OR
        // ii. Located in ECOREGION 315 (in OK or TX), AND
        // tree composition dominated by one or more of Celtis laevigata,
        // Celtis laevigata var. reticulata, Celtis occidentalis, Fraxinus pennsylvanica,
        // Juglans microcarpa, Juglans nigra, Juglans major, Platanus occidentalis,
        // Populus deltoides, Salix nigra, Sapindus saponaria var. drummondii,
        // Sideroxylon lanuginosum, Taxodium distichum, Quercus macrocarpa, Quercus shumardii,
        // or Ulmus americana (=>50% RIV);
        // OR Tree composition as above, but with =>20% RIV; AND other species are
        // any combination of Acer negundo, Prosopis glandulosa
        // Fraxinus albicans, Prunus serotina, and Quercus fusiformis
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
        // [Additional tree species not tracked by FIA include Ulmus crassifolia]
        // OR
        // iii. Located in above ECOREGION and any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_1_values = new HashMap<>();
        ECOREGIONS_1_values.put("ecoregion","315");
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_values);

        Map<String,String> ECOREGIONS_2_values = new HashMap<>();
        ECOREGIONS_2_values.put("ecoregion","315");
        ECOREGIONS_2_values.put("state","OK, TX");
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_values);

        Map<String,String> SPECIES_1_values = new HashMap<>();
        SPECIES_1_values.put("species","Carya illinoinensis");
        SPECIES_1_values.put("species","Quercus virginiana");
        SPECIES_1_values.put("species","Sabal palmetto");
        PatternList SPECIES_1 = new PatternList("SPECIES_1", SPECIES_1_values);

        Map<String,String> SPECIES_2_values = new HashMap<>();
        SPECIES_2_values.put("species","Celtis laevigata");
        SPECIES_2_values.put("species","Celtis laevigata var. reticulata");
        SPECIES_2_values.put("species","Celtis occidentalis");
        SPECIES_2_values.put("species","Fraxinus pennsylvanica");
        SPECIES_2_values.put("species","Juglans microcarpa");
        SPECIES_2_values.put("species","Juglans nigra");
        SPECIES_2_values.put("species","Juglans major");
        SPECIES_2_values.put("species","Platanus occidentalis");
        SPECIES_2_values.put("species","Populus deltoides");
        SPECIES_2_values.put("species","Salix nigra");
        SPECIES_2_values.put("species","Sapindus saponaria var. drummondii");
        SPECIES_2_values.put("species","Sideroxylon lanuginosum");
        SPECIES_2_values.put("species","Taxodium distichum");
        SPECIES_2_values.put("species","Quercus macrocarpa");
        SPECIES_2_values.put("species","Quercus shumardii");
        SPECIES_2_values.put("species","Ulmus americana");
        PatternList SPECIES_2 = new PatternList("SPECIES_2", SPECIES_2_values);

        Map<String,String> SPECIES_3_values = new HashMap<>();
        SPECIES_3_values.put("species","Acer negundo");
        SPECIES_3_values.put("species","Prosopis glandulosa");
        SPECIES_3_values.put("species","Fraxinus albicans");
        SPECIES_3_values.put("species","Prunus serotina");
        SPECIES_3_values.put("species","Quercus fusiformis");
        PatternList SPECIES_3 = new PatternList("SPECIES_3", SPECIES_3_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            ( plot.match(ECOREGIONS_1) && plot.riv(SPECIES_1) >= 20 )
           || ( plot.match(ECOREGIONS_2) && ( plot.riv(SPECIES_2) >= 50 || (plot.riv(SPECIES_2) >= 20 && plot.riv(SPECIES_3) >= 30) ))
           || ( plot.match(ECOREGIONS_1) && plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_011() {

        // Southern Great Plains Floodplain Forest & Woodland (M154)
        // M154

        String level = "macrogroup";
        String code = "M154";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_012() {

        // Southeastern Great Plains Floodplain Forest (G784)
        // G784

        String level = "group";
        String code = "G784";

        // i. Located in ECOREGION 321B, 315C, 315D, 315E, 315G and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Carya illinoinensis, Celtis laevigata,
        // Celtis laevigata var. reticulata, Platanus occidentalis,
        // Populus deltoides, Salix nigra, Sapindus saponaria var. drummondii,
        // Sideroxylon lanuginosum, Taxodium distichum, or Ulmus crassifolia,
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer negundo, Fraxinus albicans, Fraxinus pennsylvanica,
        // Juglans microcarpa, Prosopis glandulosa, Prunus serotina,
        // or Quercus fusiformis (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","321B, 315C, 315D, 315E, 315G");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya illinoinensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata var. reticulata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Platanus occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix nigra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sapindus saponaria var. drummondii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sideroxylon lanuginosum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Taxodium distichum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus albicans");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans microcarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus fusiformis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_013() {

        // Southeastern North American Ruderal Flooded & Swamp Forest (M310)
        // M310

        String level = "macrogroup";
        String code = "M310";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER] - needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_014() {

        // Western North American Temperate Flooded & Swamp Forests
        // F026

        String level = "formation";
        String code = "F026";

        // Forests found in ECOREGION 242, M242, 261, M261, 262, M262, 263, 313,
        // M313, 315, 321, 322, 331A, M331, M332, M333, M334, 341, M341, 342

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242, M242, 261, M261, 262, M262, 263, 313, M313, 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_015() {

        // Vancouverian Flooded & Swamp Forest Division (D193)
        // D193

        String level = "division";
        String code = "D193";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION 242, M242, 261A, M261, 263
        // AND
        // ii. EITHER
        // a. Tree composition dominated by one or more of STRONG diagnostic tree species
        // Abies grandis, Alnus rhombifolia, Alnus rubra, Fraxinus latifolia, Picea sitchensis,
        // Populus balsamifera ssp. trichocarpa, Salix lucida ssp. lasiandra,
        // Thuja plicata, or Tsuga heterophylla (=>50% RIV),
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species
        // any combination of Abies amabilis, Abies concolor, Abies magnifica,
        // Acer macrophyllum, Betula papyrifera, Callitropsis nootkatensis,
        // Pinus contorta, Populus tremuloides Tsuga mertensiana
        // Chamaecyparis lawsoniana, Notholithocarpus densiflorus, Picea engelmannii,
        // Pinus jeffreyi, Platanus racemosa, Populus fremontii, and Quercus lobata 
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
        // [Additional tree species not tracked by FIA include Pinus contorta var. murrayana]
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242, M242, 261A, M261, 263");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rhombifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera ssp. trichocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix lucida ssp. lasiandra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies amabilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Callitropsis nootkatensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Platanus racemosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus fremontii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus lobata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_016() {

        // Vancouverian Flooded & Swamp Forest (M035)
        // M035

        String level = "macrogroup";
        String code = "M035";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_017() {

        // North-Central Pacific Montane Riparian & Seepage Swamp Forest (G507)
        // G507

        String level = "group";
        String code = "G507";

        // i. Located in ECOREGION 261A, M261A, M261B, M261E, M261F, 242, M242,
        // M261D, M261G, 263
        // and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Abies amabilis, Abies concolor,
        // Abies magnifica, Picea engelmannii, Pinus contorta,
        // Pinus jeffreyi, Populus balsamifera, or Tsuga mertensiana (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Alnus rhombifolia, Alnus rubra, or Populus tremuloides
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261A, M261A, M261B, M261E, M261F, 242, M242, M261D, M261G, 263");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus rhombifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_018() {

        // North-Central Pacific Maritime Lowland Swamp Forest (G853)
        // G853

        String level = "group";
        String code = "G853";

        // i. Located in ECOREGION 242, M242
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Alnus rubra, Fraxinus latifolia, Picea sitchensis,
        // Populus balsamifera or Tsuga heterophylla (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies grandis, Abies magnifica, Pinus contorta, Thuja plicata, or
        // Tsuga mertensiana [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242, M242");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_019() {

        // North-Central Pacific Lowland Riparian Forest (G851)
        // G851

        String level = "group";
        String code = "G851";

        // i. Located in ECOREGION M242C, M261A, M261B, M261D, M261E, M262A, 242,
        // M242A, M242B, M242D, 261A, 263 and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Abies grandis, Alnus rhombifolia, Alnus rubra, Fraxinus latifolia,
        // Picea sitchensis, or Populus trichocarpa (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer macrophyllum, Chamaecyparis lawsoniana,
        // Notholithocarpus densiflorus, Platanus racemosa, Populus fremontii,
        // Pseudotsuga menziesii, Quercus lobata, Thuja plicata, or
        // Tsuga heterophylla [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M261A, M261B, M261D, M261E, M262A, 242, M242A, M242B, M242D, 261A, 263");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rhombifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus trichocarpa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Platanus racemosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus fremontii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus lobata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_020() {

        // Western North American Flooded Ruderal Forests - Vancouverian
        // D193

        String level = "division";
        String code = "D193";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_021() {

        // Rocky Mountain-Great Basin Montane Flooded & Swamp Forest Division (D195)
        // D195

        String level = "division";
        String code = "D195";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION M242C, M242D, 313, M313, 315, 322, 331A, M331, M332, M333, M334, 341, M341, 342
        // AND
        // ii. EITHER
        // a. Tree composition dominated by one or more of STRONG diagnostic tree species
        // Abies lasiocarpa, Abies grandis, Acer grandidentatum, Acer negundo, Betula occidentalis,
        // Juniperus scopulorum, Picea engelmannii, Picea pungens, Pinus contorta,
        // Pinus ponderosa, Populus angustifolia, Populus balsamifera, Populus tremuloides,
        // or Pseudotsuga menziesii (=>50% RIV),
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species
        // any combination of Alnus oblongifolia, Betula papyrifera, Juglans major,
        // Larix occidentalis, Pinus flexilis, Thuja plicata,
        // Tsuga heterophylla, Tsuga mertensiana
        // Abies concolor, Fraxinus latifolia, Juniperus osteosperma, Picea glauca, 
        // and Populus deltoides
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242D, 313, M313, 315, 322, 331A, M331, M332, M333, M334, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Betula occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus oblongifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_022() {

        // Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)
        // M034

        String level = "macrogroup";
        String code = "M034";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_023() {

        // Rocky Mountain-Great Basin Swamp Forest (G505)
        // G505

        String level = "group";
        String code = "G505";

        // i. Elevation less than 1500 meters and
        // located in ECOREGION 331A, 342A, 342D, 342F, 342G, 342H, M332,
        // M331A, M331B, M331D, M331J, M333C, M333A, M333B, M333D and
        // tree composition dominated by one or more of STRONG DIAGNOSTIC species
        // Abies grandis, Abies lasiocarpa, Picea engelmannii, Picea glauca,
        // Pinus contorta, Pseudotsuga menziesii, Thuja plicata, or
        // Tsuga heterophylla (RIV=>50%),
        // OR
        // ii. Elevation less than 1500 meters and
        // located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Betula papyrifera, Fraxinus latifolia,
        // Larix occidentalis, Populus balsamifera, or
        // Populus tremuloides (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","331A, 342A, 342D, 342F, 342G, 342H, M332, M331A, M331B, M331D, M331J, M333C, M333A, M333B, M333D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.get_elevation() < 1500 && plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_024() {

        // Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (G506)
        // G506

        String level = "group";
        String code = "G506";

        // i. Located in ECOREGION M242D, M261A, 313C, 313D, 315A, 315H, 322A,
        // 322B, M242C, M261D, M261E, M261G, 313A, 313B, M313, 331A, 331I, 331J,
        // 341, 342, M331, M332, M333, M334, M341
        // and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Abies lasiocarpa, Abies grandis,
        // Juniperus scopulorum, Picea engelmannii, Picea pungens, Pinus ponderosa,
        // Pinus contorta, or Populus angustifolia (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies concolor, Juniperus osteosperma,
        // Populus tremuloides, or Pseudotsuga menziesii (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242D, M261A, 313C, 313D, 315A, 315H, 322A, 322B, M242C, M261D, M261E, M261G, 313A, 313B, M313, 331A, 331I, 331J, 341, 342, M331, M332, M333, M334, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_025() {

        // Central Rocky Mountain Lowland & Foothill Riparian Forest (G796)
        // G796

        String level = "group";
        String code = "G796";

        // i. Located in ECOREGION M242C, M242D, M261E, M261G, 322A, 331G, 331L,
        // 341A, 341D, 341E, 341F, 341G, 342A, M331B, M331J, M341A, M341C, M341D,
        // 331A, 331D, 331K, 331N, 342B, 342C, 342D, 342H, 342I, 342J, M331A,
        // M331D, M332, M333  and tree composition dominated by one or more
        // of STRONG DIAGNOSTIC species Populus balsamifera (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Pinus ponderosa, Populus angustifolia, or
        // Populus deltoides (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242D, M261E, M261G, 322A, 331G, 331L, 341A, 341D, 341E, 341F, 341G, 342A, M331B, M331J, M341A, M341C, M341D, 331A, 331D, 331K, 331N, 342B, 342C, 342D, 342H, 342I, 342J, M331A, M331D, M332, M333");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_026() {

        // Western North American Flooded Ruderal Forests - Rocky Mountain
        // D195

        String level = "division";
        String code = "D195";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_027() {

        // Western North American Interior Flooded Forest Division (D013)
        // D013

        String level = "division";
        String code = "D013";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION 261, M261, 262, M262, 313, M313, 315, 321, 322, M331, 341, M341, 342
        // AND
        // ii. EITHER
        // a. Tree composition dominated by one or more of STRONG diagnostic tree species
        // Alnus oblongifolia, Alnus rhombifolia, Cordia boissieri, Diospyros texana, Ebenopsis ebano,
        // Ehretia anacua, Fraxinus berlandieriana, Leucaena pulverulenta, Parkinsonia aculeata, 
        // Phaulothamnus spinescens, Sabal mexicana, Sideroxylon celastrinum, Ulmus crassifolia, 
        // Washingtonia filifera,
        // Juglans californica, Juglans major, Juglans microcarpa, Platanus racemosa, Platanus wrightii, Populus fremontii,
        // Populus deltoides, Prosopis glandulosa, Elaeagnus angustifolia, and Tamarix spp. (=>50% RIV),
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species any combination of
        // Acacia farnesiana, Acer negundo, Celtis ehrenbergiana, Celtis laevigata, Fraxinus anomala, Fraxinus velutina,
        // Salix amygdaloides, Salix nigra, Salix gooddingii, Salix laevigata, Sapindus saponaria, Ailanthus altissima,
        // Eucalyptus spp., Ulmus pumila, Acer macrophyllum, Acer grandidentatum, Alnus rubra, Fraxinus latifolia,
        // Hesperocyparis arizonica, Populus angustifolia, Prosopis pubescens, Prosopis velutina, Quercus arizonica, 
        // Quercus emoryi, Quercus oblongifolia, Quercus agrifolia, Quercus gambelii, Quercus lobata, Quercus douglasii,
        // Quercus kelloggii, Robinia neomexicana, Salix lasiolepis, Salix lutea, Taxodium mucronatum, 
        // and Umbellularia californica
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261, M261, 262, M262, 313, M313, 315, 321, 322, M331, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus oblongifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rhombifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cordia boissieri");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Diospyros texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ebenopsis ebano");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ehretia anacua");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus berlandieriana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Leucaena pulverulenta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Parkinsonia aculeata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Phaulothamnus spinescens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sabal mexicana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sideroxylon celastrinum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Washingtonia filifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans microcarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Platanus racemosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Platanus wrightii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus fremontii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides ssp. wislizeni");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Elaeagnus angustifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tamarix");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acacia farnesiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis ehrenbergiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus anomala");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus velutina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix amygdaloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix gooddingii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Sapindus saponaria");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ailanthus altissima");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Eucalyptus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus pumila");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Hesperocyparis arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis pubescens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis velutina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus oblongifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus agrifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus lobata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus douglasii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Robinia neomexicana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix lasiolepis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix lutea");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Taxodium mucronatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_028() {

        // Interior Warm & Cool Desert Riparian Forest (M036)
        // M036

        String level = "macrogroup";
        String code = "M036";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_029() {

        // Tamaulipan Riparian Scrub Forest (G549)
        // G549

        String level = "group";
        String code = "G549";

        // i. Located in ECOREGION 321B, 315D, 315E
        // and tree composition dominated by one or more
        // of STRONG DIAGNOSTIC species Celtis laevigata,
        // Cordia boissieri, Diospyros texana,
        // Ebenopsis ebano, Ehretia anacua, Fraxinus berlandieriana,
        // Leucaena pulverulenta, Parkinsonia aculeata, Phaulothamnus spinescens,
        // Sabal mexicana, Sideroxylon celastrinum, or Ulmus crassifolia (RIV=>50%)
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acacia farnesiana, Celtis ehrenbergiana,
        // Prosopis glandulosa, Salix nigra, or Taxodium mucronatum (>=30% RIV;
        // i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","321B, 315D, 315E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cordia boissieri");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Diospyros texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ebenopsis ebano");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ehretia anacua");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus berlandieriana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Leucaena pulverulenta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Parkinsonia aculeata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Phaulothamnus spinescens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sabal mexicana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sideroxylon celastrinum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acacia farnesiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis ehrenbergiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Taxodium mucronatum");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_030() {

        // Californian Mediterranean Riparian Forest (G113)
        // G113

        String level = "group";
        String code = "G113";

        // i. Located in ECOREGION 261, 262, 263, 322A, 322C, M242A, M261A, M261B,
        // M261C, M262 and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Alnus rhombifolia, Juglans californica,
        // Platanus racemosa, Quercus agrifolia, Quercus lobata, Salix gooddingii,
        // Salix laevigata, or Umbellularia californica (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but with
        // =>20% RIV AND with other MODERATE DIAGNOSTIC species in any combination
        // of Acer macrophyllum, Acer negundo, Alnus rubra, Fraxinus latifolia,
        // Populus fremontii, Quercus douglasii, Quercus kelloggii,
        // Salix lasiolepis, or Salix lutea (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261, 262, 263, 322A, 322C, M242A, M261A, M261B, M261C, M262");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rhombifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Platanus racemosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus agrifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus lobata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix gooddingii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix laevigata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus fremontii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus douglasii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix lasiolepis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix lutea");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_031() {

        // Southwest Warm Desert Riparian Forest (G109)
        // G109

        String level = "group";
        String code = "G109";

        // i. Located in ECOREGION M313, 313C, 315A, 315B, 315H, 321, 322 and
        // tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Alnus oblongifolia, Fraxinus velutina, Juglans major,
        // Juglans microcarpa, Platanus wrightii, Populus fremontii,
        // Salix gooddingii, Salix lasiolepis, or Washingtonia filifera
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer grandidentatum, Acer negundo, Celtis laevigata,
        // Hesperocyparis arizonica, Populus angustifolia, Populus deltoides,
        // Prosopis glandulosa, Prosopis velutina, Quercus arizonica,
        // Quercus emoryi, Quercus oblongifolia, or Robinia neomexicana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M313, 313C, 315A, 315B, 315H, 321, 322");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus oblongifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans microcarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Platanus wrightii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus fremontii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix gooddingii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix lasiolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Washingtonia filifera");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cupressus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis velutina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus oblongifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Robinia neomexicana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_032() {

        // Great Basin-Colorado Plateau Semi-Desert Riparian Forest (G107)
        // G107

        String level = "group";
        String code = "G107";

        // i. Located in ECOREGION 313A, 313B, 313D, 322A, 341, 342B, 342C, 342E,
        // 342J, M261G, M331D, M331E, M331G, M331H, M341 and tree composition
        // dominated by one or more of STRONG DIAGNOSTIC species Acer negundo,
        // Celtis laevigata, Fraxinus anomala, Fraxinus velutina,
        // Populus deltoides, Populus fremontii, or Salix amygdaloides (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Fraxinus berlandieriana, Juniperus osteosperma,
        // Pinus edulis, Populus angustifolia, Prosopis pubescens,
        // Pseudotsuga menziesii, Quercus gambelii, Salix gooddingii or
        // Salix lasiolepis (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","313A, 313B, 313D, 322A, 341, 342B, 342C, 342E, 342J, M261G, M331D, M331E, M331G, M331H, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus anomala");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus fremontii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Salix amygdaloides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus berlandieriana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus angustifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis pubescens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix gooddingii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Salix lasiolepis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_033() {

        // Interior West Ruderal Flooded & Swamp Forest & Woodland (M298)
        // M298

        String level = "macrogroup";
        String code = "M298";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously). Tree
        // composition dominated by ruderal native or EXOTIC = yes
        // (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division

        Map<String,String> RUDERAL_OR_EXOTIC_values = new HashMap<>();
        RUDERAL_OR_EXOTIC_values.put("exotic","yes");
        RUDERAL_OR_EXOTIC_values.put("ruderal","yes");
        PatternList RUDERAL_OR_EXOTIC = new PatternList("RUDERAL_OR_EXOTIC", RUDERAL_OR_EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_034() {

        // Upland Forest & Woodlands
        // 

        String level = "class";
        String code = "";

        // Not as above

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_035() {

        // Temperate & Boreal Forest & Woodland Subclass
        // S15

        String level = "subclass";
        String code = "S15";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_036() {

        // Great Plains Temperate Forests
        // 

        String level = "subclass";
        String code = "";

        // Tree composition and ecology matching one of the following options
        // i. Located in ECOREGION 222, 251, 315 – exclude 315H, 332, 331 – exclude 331A and 331J, AND
        // EITHER
        // ii. Tree composition is dominated by one or more of Betula papyrifera
        // or Populus tremuloides =>20% RIV and Abies concolor,
        // Pseudotsuga menziesii, and Pinus ponderosa =<5% RIV
        // OR
        // iii. Aesculus pavia, Acer negundo, Acer saccharum, Aesculus glabra,
        // Amelanchier spp., Carya cordiformis, Carya texana, Celtis laevigata,
        // Celtis occidentalis, Cercis canadensis, Crataegus spp.,
        // Diospyros virginiana, Fraxinus americana, Fraxinus pennsylvanica,
        // Gleditsia triacanthos, Gymnocladus dioicus, Juglans nigra,
        // Juniperus ashei, Juniperus virginiana, Morus rubra, Ostrya virginiana
        // Persea borbonia, Platanus occidentalis, Populus balsamifera,
        // Populus deltoides, Prosopis glandulosa, Prosopis velutina,
        // Prunus pensylvanica, Prunus serotina, Prunus virginiana,
        // Quercus falcata, Quercus virginiana, Quercus macrocarpa, Quercus marilandica, Quercus muehlenbergii,
        // Quercus rubra, Quercus shumardii, Quercus sinuata var. sinuata,
        // Quercus stellata, Quercus velutina, Quercus virginiana, Sabal palmetto,
        // Tilia americana, Ulmus alata, Ulmus americana, Ulmus crassifolia,
        // or Ulmus rubra (>= 20% RIV)

        Map<String,String> ECOREGIONS_1_values = new HashMap<>();
        ECOREGIONS_1_values.put("ecoregion","222, 251, 315, 331, 332");
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_values);

        Map<String,String> ECOREGIONS_EXCL_values = new HashMap<>();
        ECOREGIONS_EXCL_values.put("ecoregion","315H, 331A, 331J");
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_values);

        Map<String,String> DIAGNOSTIC_SPECIES_1_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_1_values.put("species","Betula papyrifera");
        DIAGNOSTIC_SPECIES_1_values.put("species","Populus tremuloides");
        PatternList DIAGNOSTIC_SPECIES_1 = new PatternList("DIAGNOSTIC_SPECIES_1", DIAGNOSTIC_SPECIES_1_values);

        Map<String,String> DIAGNOSTIC_SPECIES_2_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_2_values.put("species","Abies concolor");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus ponderosa");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pseudotsuga menziesii");
        PatternList DIAGNOSTIC_SPECIES_2 = new PatternList("DIAGNOSTIC_SPECIES_2", DIAGNOSTIC_SPECIES_2_values);

        Map<String,String> DIAGNOSTIC_SPECIES_3_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_3_values.put("species","Aesculus pavia");
        DIAGNOSTIC_SPECIES_3_values.put("species","Acer negundo");
        DIAGNOSTIC_SPECIES_3_values.put("species","Acer saccharum");
        DIAGNOSTIC_SPECIES_3_values.put("species","Aesculus glabra");
        DIAGNOSTIC_SPECIES_3_values.put("species","Amelanchier");
        DIAGNOSTIC_SPECIES_3_values.put("species","Carya cordiformis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Carya texana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Celtis laevigata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Celtis occidentalis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Cercis canadensis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Crataegus");
        DIAGNOSTIC_SPECIES_3_values.put("species","Diospyros virginiana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Fraxinus americana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Fraxinus pennsylvanica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Gleditsia triacanthos");
        DIAGNOSTIC_SPECIES_3_values.put("species","Gymnocladus dioicus");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juglans nigra");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus ashei");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus virginiana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Morus rubra");
        DIAGNOSTIC_SPECIES_3_values.put("species","Ostrya virginiana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Persea borbonia");
        DIAGNOSTIC_SPECIES_3_values.put("species","Platanus occidentalis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Populus balsamifera");
        DIAGNOSTIC_SPECIES_3_values.put("species","Populus deltoides");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prosopis glandulosa");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prosopis velutina");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prunus pensylvanica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prunus serotina");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prunus virginiana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus falcata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus macrocarpa");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus marilandica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus muehlenbergii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus rubra");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus shumardii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus sinuata var. sinuata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus stellata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus velutina");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus virginiana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Sabal palmetto");
        DIAGNOSTIC_SPECIES_3_values.put("species","Tilia americana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Ulmus alata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Ulmus americana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Ulmus crassifolia");
        DIAGNOSTIC_SPECIES_3_values.put("species","Ulmus rubra");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus virginiana");
        PatternList DIAGNOSTIC_SPECIES_3 = new PatternList("DIAGNOSTIC_SPECIES_3", DIAGNOSTIC_SPECIES_3_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && !plot.match(ECOREGIONS_EXCL)) &&
           ( (plot.riv(DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(DIAGNOSTIC_SPECIES_2) <= 5) ||
           plot.riv(DIAGNOSTIC_SPECIES_3) >= 20 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_037() {

        // North American Great Plains Forest & Woodland Division (D326)
        // D326

        String level = "division";
        String code = "D326";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION 222, 231, 251, 255, 315, 321, 331, 332 – exclude 331A and 331J, 332
        // AND
        // ii. EITHER
        // a. Tree composition dominated by one or more of STRONG diagnostic
        // broadleaf trees Diospyros texana, Fraxinus pennsylvanica, Gleditsia triacanthos, Juglans nigra, Juniperus virginiana,
        // Populus deltoides, Populus tremuloides, Prosopis glandulosa, Prosopis velutina, Quercus macrocarpa,
        // Quercus marilandica, Quercus stellata, Quercus virginiana, Ulmus americana,
        // Ulmus crassifolia or Ulmus rubra (=>50% RIV),
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE
        // diagnostic species, any combination of Acer negundo,
        // Betula papyrifera, Celtis occidentalis, Crataegus spp.,
        // Juglans nigra, Juniperus ashei, Juniperus pinchotii, Juniperus scopulorum, Morus rubra, Pinus ponderosa,
        // Populus grandidentata, Populus balsamifera, Ostrya virginiana
        // Prunus virginiana, or Quercus muehlenbergii
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_1_values = new HashMap<>();
        ECOREGIONS_1_values.put("ecoregion","222, 231, 251, 255, 315, 321, 331, 332");
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_values);

        Map<String,String> ECOREGIONS_EXCL_values = new HashMap<>();
        ECOREGIONS_EXCL_values.put("ecoregion","331A, 331J");
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_values);

        Map<String,String> ECOREGIONS_2_values = new HashMap<>();
        ECOREGIONS_2_values.put("ecoregion","M334A");
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_1_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Fraxinus pennsylvanica");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Prosopis glandulosa");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Prosopis velutina");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Quercus macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Quercus marilandica");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Quercus stellata");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Ulmus americana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Ulmus crassifolia");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Ulmus rubra");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Gleditsia triacanthos");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Juglans nigra");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Quercus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus ashei");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus pinchotii");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Diospyros texana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Populus deltoides");
        PatternList STRONG_DIAGNOSTIC_SPECIES_1 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_1", STRONG_DIAGNOSTIC_SPECIES_1_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Crataegus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Morus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus grandidentata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS_1) && !plot.match(ECOREGIONS_EXCL) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_038() {

        // Southern Great Plains Forest & Woodland (M544)
        // M544

        String level = "macrogroup";
        String code = "M544";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B, AND tree composition dominated by one or more of STRONG MESIC DIAGNOSTIC species Juglans major, Acer grandidentatum, Diospyros texana, Juglans major, Juniperus ashei, Juniperus pinchotii Prosopis glandulosa, Prosopis velutina, Quercus buckleyi, Quercus laceyi, Quercus marilandica, Quercus muehlenbergii, Quercus stellata,   Quercus virginiana or Ulmus alata, or Ulmus crassifolia (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species in any combination of ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species in any combination of Arbutus xalapensis, Celtis laevigata, Juniperius virginai, Fraxinus texensis, Pinus remota, Prunus serotina, , Quercus macrocarpa, Quercus pungens, Quercus sinuata  (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus buckleyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus laceyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus alata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus pinchotii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Diospyros texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus remota");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus pungens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus texensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus sinuata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_039() {

        // Cross Timbers Forest & Woodland (G887)
        // G887

        String level = "group";
        String code = "G887";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 231E, 231G, 251E, 251F, 255A, 255E, 315C, 315G, 332F
        // and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Carya cordiformis, Carya texana, Quercus marilandica, Quercus stellata, Quercus virginiana, Quercus velutina, Sapindus saponaria, Sideroxylon lanuginosum ssp. lanuginosum, Ulmus crassifolia, Juniperus ashei, Juniperus virginiana    (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>20% RIV AND with other MODERATE DIAGNOSTIC species
        // in any combination of Ulmus alata (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","231E,  231G, 251E, 251F, 255A, 255E, 315C, 315G, 332F");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya cordiformis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sapindus saponaria");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sideroxylon lanuginosum ssp. lanuginosum");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus alata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_040() {

        // Edwards Plateau Dry-Mesic Hardwood Forest (G028)
        // G028

        String level = "group";
        String code = "G028";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 255B, 255E, 315C, 315D, 315E, 315G, 321B and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Acer grandidentatum, Juglans major, Juniperus ashei, Quercus buckleyi, Quercus laceyi,
        // Quercus muehlenbergii, Tilia americana, Ulmus rubra, or Ulmus crassifolia (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Arbutus xalapensis, Celtis laevigata,
        // Fraxinus texensis, Prunus serotina,
        // Quercus macrocarpa, Quercus stellata, or
        // Quercus sinuata (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","255B, 255E, 315C, 315D, 315E, 315G, 321B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus buckleyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus laceyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tilia americana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus rubra");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus sinuata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus texensis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_041() {

        // Edwards Plateau Dry Woodland (G126)
        // G126

        String level = "group";
        String code = "G126";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 255B, 255E, 315C, 315D, 315E, 315G, 321B and tree
        // composition dominated by one or more of STRONG
        // DIAGNOSTIC species Diospyros texana, Juniperus ashei, Juniperus pinchotii, Prosopis glandulosa, or Quercus virginiana [=Quercus fusiformis, Q. v. fusiformis] (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Fraxinus texensis, Pinus remota, Quercus buckleyi, Quercus marilandica,
        // Quercus sinuata, Quercus stellata, Quercus pungens, or
        // Ulmus crassifolia (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","255B, 255E, 315C, 315D, 315E, 315G, 321B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Diospyros texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus pinchotii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus remota");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus buckleyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus sinuata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus texensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus pungens");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_042() {

        // Northern Great Plains Forest & Woodland (M545)
        // M545

        String level = "macrogroup";
        String code = "M545";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_043() {

        // Great Plains Bur Oak Forest & Woodland(G329)
        // G329

        String level = "group";
        String code = "G329";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 222, 251, 331K?, 332B?, 331B?, 331F, 331C, 331M, 331E,
        // 332A, 332C, 332E, 332F, 332D and tree composition dominated by
        // one or more of STRONG DIAGNOSTIC species Quercus macrocarpa (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Fraxinus pennsylvanica, Juniperus virginiana, Morus rubra,
        // Ostrya virginiana, Prunus virginiana, or Populus tremuloides (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","222, 251, 331K, 332B, 331B, 331F, 331C, 331M, 331E, 332A, 332C, 332E, 332F, 332D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Morus rubra");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_044() {

        // Northeastern Great Plains Aspen Woodland (G146)
        // G146

        String level = "group";
        String code = "G146";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 251A, 251B, 222Na, 222Ma
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Populus tremuloides (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Betula papyrifera, Populus grandidentata,
        // Populus balsamifera, Prunus virginiana, Quercus macrocarpa, or Ulmus americana (>=30% RIV;
        // i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","251A, 251B, 222Na, 222Ma");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus grandidentata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus virginiana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_045() {

        // Northwestern Great Plains Aspen Woodland (G328)
        // G328

        String level = "group";
        String code = "G328";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 331E, 331M, 332A, 332B
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Populus tremuloides (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Betula papyrifera, Populus grandidentata,
        // Populus balsamifera, Prunus virginiana, Quercus macrocarpa, or Ulmus americana (>=30% RIV;
        // i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","331E, 331M, 332A, 332B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus grandidentata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_046() {

        // Great Plains Mesic Forest & Woodland (G145)
        // G145

        String level = "group";
        String code = "G145";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION ECOREGION 222, 251, 315F, 315B, 332, 331 – 
        // exclude 331A and 331J and tree composition dominated by one or more
        // of STRONG DIAGNOSTIC species Betula papyrifera, Fraxinus pennsylvanica,
        // Juniperus scopulorum, Populus tremuloides, Ulmus americana, Juniperus virginiana, or
        // Ulmus rubra, Morus rubra (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer negundo, Celtis occidentalis, Populus deltoides, or Quercus macrocarpa (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","222, 251, 315F, 315B, 332, 331");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> ECOREGIONS_EXCL_values = new HashMap<>();
        ECOREGIONS_EXCL_values.put("ecoregion","331A, 331J");
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Morus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL)) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_047() {

        // Great Plains Ruderal Woodland (M524)
        // M524

        String level = "macrogroup";
        String code = "M524";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by ruderal native or EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_048() {

        // Southeastern North American Forest & Woodland Division (D006)
        // D006

        String level = "division";
        String code = "D006";

        // Tree composition and ecology matching one of the following options:
        //   i. Located in ECOREGION 315E [Texas and Oklahoma]
        // AND
        //   ii. EITHER
        // a. Tree composition contains one or more of Aesculus pavia,
        // Quercus margarettiae, Quercus sinuata var. sinuata,
        // Quercus virginiana, or Sabal palmetto (>=20% RIV),
        // [Additional tree species not tracked by FIA include
        // Quercus fusiformis = Quercus virginiana var. fusiformis,
        // Quercus geminata, Serenoa repens]
        // OR
        // b. The above tree species, but with =>10% RIV AND other MODERATE
        // diagnostic species, any combination of Celtis laevigata,
        // Fraxinus americana, Juniperus virginiana, Ostrya virginiana,
        // Persea borbonia, Prunus serotina, Quercus marilandica, Quercus stellata,
        // or Ulmus alata (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STATES_values = new HashMap<>();
        STATES_values.put("state","TX, OK");
        PatternList STATES = new PatternList("STATES", STATES_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Aesculus pavia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus margarettiae");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus sinuata var. sinuata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus virginiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sabal palmetto");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus americana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Persea borbonia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus alata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && plot.match(STATES) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_049() {

        // Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)
        // M885

        String level = "macrogroup";
        String code = "M885";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> RUDERAL_EXOTIC_values = new HashMap<>();
        RUDERAL_EXOTIC_values.put("ruderal","yes");
        RUDERAL_EXOTIC_values.put("exotic","yes");
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_050() {

        // Coastal Live Oak - Hickory - Palmetto Forest (G798)
        // G798

        String level = "group";
        String code = "G798";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315E and tree composition dominated
        // by one or more of STRONG DIAGNOSTIC species
        // Quercus virginiana (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Sabal palmetto,
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus hemisphaerica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus virginiana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Sabal palmetto");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_051() {

        // Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)
        // G799

        String level = "group";
        String code = "G799";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315E
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Quercus fusiformis (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Prosopis glandulosa, Quercus marilandica,
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus fusiformis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Zanthoxylum hirsutum");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_052() {

        // Southeastern North American Ruderal Forest (M305)
        // M305

        String level = "macrogroup";
        String code = "M305";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy
        // native vegetation that invades natural stands or vegetation that
        // dominates on formerly cleared and/or planted sites but which has been
        // allowed to succeed more-or-less spontaneously). Tree composition
        // dominated by ruderal native or EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> RUDERAL_EXOTIC_values = new HashMap<>();
        RUDERAL_EXOTIC_values.put("ruderal","yes");
        RUDERAL_EXOTIC_values.put("exotic","yes");
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_053() {

        // Eastern North American Forest & Woodland Division (D008)
        // D008

        String level = "division";
        String code = "D008";

        // Tree composition and ecology matching one of the following options:
        // i. Located in ECOREGION 315, 332
        // AND
        // ii. EITHER
        // a. Tree composition dominated by one or more of STRONG diagnostic
        // species Acer saccharum, Aesculus glabra, Carya texana,
        // Celtis occidentalis, Fraxinus pennsylvanica, Gymnocladus dioicus,
        // Platanus occidentalis, Populus tremuloides, Quercus falcata,
        // Quercus macrocarpa, Quercus muehlenbergii,
        // Quercus rubra, Quercus velutina, Tilia americana,
        // Ulmus rubra, or Ulmus americana (=>50% RIV)
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE
        // diagnostic species Acer negundo, Amelanchier spp., Betula papyrifera,
        // Carya cordiformis, Cercis canadensis, Diospyros virginiana,
        // Gleditsia triacanthos, Juglans nigra, Juniperus ashei,
        // Juniperus virginiana, Morus rubra, Ostrya virginiana,
        // Populus balsamifera, Populus deltoides, Prunus pensylvanica,
        // Prunus serotina, Prunus virginiana, Quercus fusiformis,
        // Quercus marilandica, Quercus stellata,
        // Quercus shumardii, Ulmus alata, or Ulmus crassifolia
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315, 332");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer saccharum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Aesculus glabra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Celtis occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Gymnocladus dioicus");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Platanus occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus falcata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tilia americana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Amelanchier");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Carya cordiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cercis canadensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Diospyros virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Gleditsia triacanthos");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Morus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus balsamifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus deltoides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus pensylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus fusiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus shumardii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus alata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        EXOTIC_TREE_SPP_values.put("tallytree","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_054() {

        // Eastern North American Forest & Woodland Natural Forests
        // D008

        String level = "division";
        String code = "D008";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_055() {

        // Central Midwest Oak Forest, Woodland & Savanna (M012)
        // M012

        String level = "macrogroup";
        String code = "M012";

        // Tree composition dominated by one of the following:
        // i. Located in ECOREGION 332 AND
        // tree composition dominated by one or more of the following
        // STRONG DRY DIAGNOSTICS species of Populus tremuloides,
        // Quercus rubra, Quercus velutina, 
        // Quercus macrocarpa, Quercus muehlenbergii, or Quercus stellata (=>50% RIV);
        // OR
        // ii. tree composition as above, but with =>20% RIV, AND
        // other species are any combination of MODERATE DRY DIAGNOSTICS diagnostic species
        // of Betula papyrifera, Juniperus virginiana or weakly diagnostic species of Amelanchier spp.,
        // Carya cordiformis, Cercis canadensis, Diospyros virginiana, Morus rubra, Ostrya virginiana,
        // Prunus serotina (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","332A, 332D, 332C, 332E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Amelanchier");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Carya cordiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cercis canadensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Diospyros virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Morus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_056() {

        // North-Central Oak - Hickory Forest & Woodland (G649)
        // G649

        String level = "group";
        String code = "G649";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 332
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Carya cordiformis,
        // Quercus alba, Quercus rubra, or Quercus velutina (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer saccharum, Celtis occidentalis,
        // Ostrya virginiana, Quercus macrocarpa,
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","332");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya cordiformis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus alba");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus velutina");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer saccharum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_057() {

        // Southern & South-Central Oak - Pine Forest & Woodland (M016)
        // M016

        String level = "macrogroup";
        String code = "M016";

        // Tree composition dominated by one of the following:
        // i. Located in ECOREGION 315, 332, AND Tree composition dominated by
        // one or more of the STRONG DRY SOUTH-CENTRAL DIAGNOSTICS Carya texana,
        // Quercus falcata, Quercus rubra, or Quercus velutina (=>50% RIV);
        // OR
        // ii. States and Tree composition as above, but with =>20% RIV;
        // AND other species are any combination of MODERATE DRY SOUTH-CENTRAL
        // DIAGNOSTICS Carya cordiformis, Cercis canadensis,
        // Diospyros virginiana, Juglans nigra, Juniperus ashei,
        // Juniperus virginiana, Prunus serotina, Quercus fusiformis,
        // Quercus marilandica, Quercus stellata, Quercus shumardii,
        // Ulmus alata, or Ulmus crassifolia
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV).

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315, 332");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus falcata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus velutina");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Carya cordiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cercis canadensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Diospyros virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus fusiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus marilandica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus shumardii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus alata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus crassifolia");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_058() {

        // Western Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)
        // G013

        String level = "group";
        String code = "G013";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315D, 315E
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Carya texana, Quercus falcata, Quercus rubra, or Quercus velutina
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Carya tomentosa, Ostrya virginiana,
        // Pinus palustris, Quercus margarettae, Quercus stellata
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315D, 315E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Carya texana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus falcata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rubra");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus velutina");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Carya tomentosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ostrya virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus palustris");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus margarettae");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus stellata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_059() {

        // Eastern North American Ruderal Forests
        // D008

        String level = "division";
        String code = "D008";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy
        // native vegetation that invades natural stands or vegetation that
        // dominates on formerly cleared and/or planted sites but which has been
        // allowed to succeed more-or-less spontaneously). Tree composition
        // dominated by ruderal native or EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> RUDERAL_EXOTIC_values = new HashMap<>();
        RUDERAL_EXOTIC_values.put("ruderal","yes");
        RUDERAL_EXOTIC_values.put("exotic","yes");
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_060() {

        // Eastern North American Ruderal Forest (M013)
        // M013

        String level = "macrogroup";
        String code = "M013";

        // Only one Macrogroup

        Map<String,String> RUDERAL_EXOTIC_values = new HashMap<>();
        RUDERAL_EXOTIC_values.put("ruderal","yes");
        RUDERAL_EXOTIC_values.put("exotic","yes");
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_values);

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_061() {

        // Western North American Temperate Forests
        // 

        String level = "subclass";
        String code = "";

        // Forests found in ECOREGION 242, M242, 261, M261, 262, M262, 263, 313, M313,
        // 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242, M242, 261, M261, 262, M262, 263, 313, M313, 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_062() {

        // Warm Temperate Forest & Woodland Formation
        // F018

        String level = "formation";
        String code = "F018";

        // i. Located in ECOREGION M242B, 261, M261, 262, M262, 263, 313C, M313,
        // 315, 321, 322, 331B, 331J, M331F, M331G, 341F, 342B
        // AND
        // ii. Temperate deciduous and evergreen forests and woodlands, dominated
        // by broad-leaved deciduous, broad-leaved evergreen, and needle-leaved
        // tree growth forms. Tree composition contains one or more of diagnostic
        // conifer species Hesperocyparis bakeri, Hesperocyparis forbesii,
        // Hesperocyparis macnabiana, Hesperocyparis macrocarpa,
        // Hesperocyparis pigmaea, Hesperocyparis sargentii, Juniperus californica,
        // Juniperus pinchotii, Juniperus ashei, Juniperus coahuilensis,
        // Juniperus deppeana, Juniperus flaccida, Pinus arizonica,
        // Pinus cembroides, Pinus discolor, Pinus leiophylla,
        // Pinus strobiformis, Pinus attenuata, Pinus coulteri, Pinus muricata (exclude from 263),
        // Pinus radiata, Pinus remota, Pinus sabiniana, Pseudotsuga macrocarpa,
        // or broadleaf species Aesculus californica, Arbutus arizonica,
        // Arbutus xalapensis, Fraxinus albicans, Juglans californica,
        // Juglans major, Juglans nigra, Prosopis glandulosa, Prosopis velutina,
        // Quercus albocincta, Quercus arizonica, Quercus emoryi, Quercus grisea,
        // Quercus agrifolia, Quercus chrysolepis (exclude from M261A, M261B, M261C, M261D, M261G, and 263),
        // Quercus douglasii, Quercus engelmannii, Quercus hypoleucoides,
        // Quercus kelloggii (exclude from M261A, M261B, M261C, M261D, M261G, and 263), Quercus lobata,
        // Quercus oblongifolia, Quercus rugosa, Quercus muehlenbergii,
        // Quercus vaseyana, Quercus parvula var. shrevei, Quercus wislizeni,
        // or Umbellularia californica (exclude from M261A, M261B, M261C, M261D, M261G, and 263) (>= 20% RIV)
        // [Additional tree species not tracked by FIA include Ulmus crassifolia]

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242B, 261, M261, 262, M262, 331B, 331J, M331F, M331G, 341F, 342B, 322, 313C, M313, 321, 315");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> ECOREGIONS_EXCL_values = new HashMap<>();
        ECOREGIONS_EXCL_values.put("ecoregion","M261A, M261B, M261C, M261D, M261G");
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_values);

        Map<String,String> ECOREGIONS_263_values = new HashMap<>();
        ECOREGIONS_263_values.put("ecoregion","263");
        PatternList ECOREGIONS_263 = new PatternList("ECOREGIONS_263", ECOREGIONS_263_values);

        Map<String,String> DIAGNOSTIC_SPECIES_1_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_1_values.put("species","Cupressus bakeri");
        DIAGNOSTIC_SPECIES_1_values.put("species","Cupressus forbesii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Cupressus macnabiana");
        DIAGNOSTIC_SPECIES_1_values.put("species","Cupressus macrocarpa");
        DIAGNOSTIC_SPECIES_1_values.put("species","Cupressus goveniana ssp. pygmaea");
        DIAGNOSTIC_SPECIES_1_values.put("species","Cupressus sargentii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus californica");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus pinchotii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus ashei");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus coahuilensis");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus deppeana");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus flaccida");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus arizonica");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus cembroides");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus discolor");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus leiophylla");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus strobiformis");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus attenuata");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus coulteri");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus muricata");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus radiata");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus remota");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pinus sabiniana");
        DIAGNOSTIC_SPECIES_1_values.put("species","Pseudotsuga macrocarpa");
        DIAGNOSTIC_SPECIES_1_values.put("species","Aesculus californica");
        DIAGNOSTIC_SPECIES_1_values.put("species","Arbutus arizonica");
        DIAGNOSTIC_SPECIES_1_values.put("species","Arbutus xalapensis");
        DIAGNOSTIC_SPECIES_1_values.put("species","Fraxinus texensis");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juglans californica");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juglans major");
        DIAGNOSTIC_SPECIES_1_values.put("species","Juglans nigra");
        DIAGNOSTIC_SPECIES_1_values.put("species","Prosopis glandulosa");
        DIAGNOSTIC_SPECIES_1_values.put("species","Prosopis velutina");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus albocincta");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus arizonica");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus emoryi");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus grisea");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus agrifolia");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus chrysolepis");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus douglasii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus engelmannii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus hypoleucoides");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus kelloggii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus lobata");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus oblongifolia");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus rugosa");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus muehlenbergii");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus vaseyana");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus parvula");
        DIAGNOSTIC_SPECIES_1_values.put("species","Quercus wislizeni");
        DIAGNOSTIC_SPECIES_1_values.put("species","Umbellularia californica");
        PatternList DIAGNOSTIC_SPECIES_1 = new PatternList("DIAGNOSTIC_SPECIES_1", DIAGNOSTIC_SPECIES_1_values);

        Map<String,String> DIAGNOSTIC_SPECIES_2_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_2_values.put("species","Cupressus bakeri");
        DIAGNOSTIC_SPECIES_2_values.put("species","Cupressus forbesii");
        DIAGNOSTIC_SPECIES_2_values.put("species","Cupressus macnabiana");
        DIAGNOSTIC_SPECIES_2_values.put("species","Cupressus macrocarpa");
        DIAGNOSTIC_SPECIES_2_values.put("species","Cupressus goveniana ssp. pygmaea");
        DIAGNOSTIC_SPECIES_2_values.put("species","Cupressus sargentii");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus californica");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus pinchotii");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus ashei");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus coahuilensis");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus deppeana");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus flaccida");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus arizonica");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus cembroides");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus discolor");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus leiophylla");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus strobiformis");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus attenuata");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus coulteri");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus muricata");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus radiata");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus remota");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pinus sabiniana");
        DIAGNOSTIC_SPECIES_2_values.put("species","Pseudotsuga macrocarpa");
        DIAGNOSTIC_SPECIES_2_values.put("species","Aesculus californica");
        DIAGNOSTIC_SPECIES_2_values.put("species","Arbutus arizonica");
        DIAGNOSTIC_SPECIES_2_values.put("species","Arbutus xalapensis");
        DIAGNOSTIC_SPECIES_2_values.put("species","Fraxinus texensis");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juglans californica");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juglans major");
        DIAGNOSTIC_SPECIES_2_values.put("species","Juglans nigra");
        DIAGNOSTIC_SPECIES_2_values.put("species","Prosopis glandulosa");
        DIAGNOSTIC_SPECIES_2_values.put("species","Prosopis velutina");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus albocincta");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus arizonica");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus emoryi");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus grisea");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus agrifolia");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus douglasii");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus engelmannii");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus hypoleucoides");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus lobata");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus oblongifolia");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus rugosa");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus muehlenbergii");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus pungens");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus parvula");
        DIAGNOSTIC_SPECIES_2_values.put("species","Quercus wislizeni");
        PatternList DIAGNOSTIC_SPECIES_2 = new PatternList("DIAGNOSTIC_SPECIES_2", DIAGNOSTIC_SPECIES_2_values);

        Map<String,String> DIAGNOSTIC_SPECIES_3_values = new HashMap<>();
        DIAGNOSTIC_SPECIES_3_values.put("species","Cupressus bakeri");
        DIAGNOSTIC_SPECIES_3_values.put("species","Cupressus forbesii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Cupressus macnabiana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Cupressus macrocarpa");
        DIAGNOSTIC_SPECIES_3_values.put("species","Cupressus goveniana ssp. pygmaea");
        DIAGNOSTIC_SPECIES_3_values.put("species","Cupressus sargentii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus californica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus pinchotii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus ashei");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus coahuilensis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus deppeana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juniperus flaccida");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus arizonica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus cembroides");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus discolor");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus leiophylla");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus strobiformis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus attenuata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus coulteri");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus radiata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus remota");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pinus sabiniana");
        DIAGNOSTIC_SPECIES_3_values.put("species","Pseudotsuga macrocarpa");
        DIAGNOSTIC_SPECIES_3_values.put("species","Aesculus californica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Arbutus arizonica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Arbutus xalapensis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Fraxinus texensis");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juglans californica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juglans major");
        DIAGNOSTIC_SPECIES_3_values.put("species","Juglans nigra");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prosopis glandulosa");
        DIAGNOSTIC_SPECIES_3_values.put("species","Prosopis velutina");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus albocincta");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus arizonica");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus emoryi");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus grisea");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus agrifolia");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus douglasii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus engelmannii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus hypoleucoides");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus lobata");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus oblongifolia");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus rugosa");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus muehlenbergii");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus pungens");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus parvula");
        DIAGNOSTIC_SPECIES_3_values.put("species","Quercus wislizeni");
        PatternList DIAGNOSTIC_SPECIES_3 = new PatternList("DIAGNOSTIC_SPECIES_3", DIAGNOSTIC_SPECIES_3_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL) && plot.riv(DIAGNOSTIC_SPECIES_1) >= 20) ||
           (plot.match(ECOREGIONS_EXCL) && plot.riv(DIAGNOSTIC_SPECIES_2) >= 20) ||
           (plot.match(ECOREGIONS_263) && plot.riv(DIAGNOSTIC_SPECIES_3) >= 20)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_063() {

        // Californian Forest & Woodland Division (D007)
        // D007

        String level = "division";
        String code = "D007";

        // Tree composition and ecology matching one of the following options:
        // i. EITHER
        // a. Tree composition contains one or more of STRONG diagnostic tree species Abies concolor, Aesculus californica, Arbutus menziesii, Calocedrus decurrens, Chamaecyparis lawsoniana, Chrysolepis chrysophylla, Fraxinus latifolia, Cupressus bakeri, Cupressus forbesii, Cupressus macnabiana, Cupressus macrocarpa, Cupressus goveniana ssp. pigmaea, Cupressus sargentii, Juglans californica, Juniperus californica, Notholithocarpus densiflorus, Pinus attenuata, Pinus coulteri, Pinus jeffreyi, Pinus muricata, Pinus radiata, Pinus sabiniana, Quercus agrifolia, Quercus chrysolepis, Quercus douglasii, Quercus engelmannii, Quercus kelloggii, Quercus lobata, Quercus wislizeni, Quercus parvula var. shrevei,  or Umbellularia californica (=>50% RIV), [Additional tree species not tracked by FIA include Cupressus abramsiana, Cupressus goveniana, CupressusHesperocyparis nevadensis, Cupressus Hesperocyparis stephensonii, Pinus quadrifolia, Pinus torreyana, Quercus cedrosensis, Quercus tomentella] 
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE
        // diagnostic species any combination of Pinus lambertiana,
        // Pinus monophylla, Pinus ponderosa, Pseudotsuga macrocarpa, sequoia sempervirens
        // or Pseudotsuga menziesii
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV
        // AND
        // ii. Located in ECOREGION M242B, 342B, 263, M261, 341D, 341F, 262, 322, 261, M262

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242B, 342B, 263, M261, 341D, 341F, 262, 322, 261, M262");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Aesculus californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Calocedrus decurrens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Chrysolepis chrysophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus attenuata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus coulteri");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus muricata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus radiata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus sabiniana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus agrifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus douglasii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus lobata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus wislizeni");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus latifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus bakeri");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus forbesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus macnabiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus goveniana ssp. pygmaea");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus sargentii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus parvula");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus lambertiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Sequoia sempervirens");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) || 
           plot.riv(EXOTIC_TREE_SPP) >=80 )
           && plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_064() {

        // Californian Forest & Woodland (M009)
        // M009

        String level = "macrogroup";
        String code = "M009";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_065() {

        // Californian Conifer Forest & Woodland (G198)
        // G198

        String level = "group";
        String code = "G198";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M261D, M261A, 261B, 322A, M262A, 263,
        // M261B, M261C, M261F, M261E, M262B, 261A 
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Hesperocyparis abramsiana, Hesperocyparis bakeri,
        // Hesperocyparis forbesii, Hesperocyparis goveniana,
        // Hesperocyparis macnabiana, Hesperocyparis macrocarpa,
        // Hesperocyparis nevadensis, Hesperocyparis pigmaea,
        // Hesperocyparis sargentii, Hesperocyparis stephensonii,
        // Juniperus californica
        // Pinus sabiniana, Pinus attenuata, Pinus coulteri, Pinus muricata,
        // Pinus radiata, Pinus torreyana, or Pinus quadrifolia (RIV=>50%), 
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Arbutus menziesii, Calocedrus decurrens,
        // Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monophylla,
        // Pinus ponderosa, Pseudotsuga menziesii, Pseudotsuga macrocarpa,
        // Quercus agrifolia, Quercus chrysolepis, Quercus kelloggii,
        // Quercus wislizeni, or Quercus douglasii (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M261D, M261A, 261B, 322A, M262A, 263, M261B, M261C, M261F, M261E, M262B, 261A");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Hesperocyparis abramsiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus bakeri");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus forbesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus goveniana ssp. pygmaea");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus macnabiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus sargentii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus sabiniana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus attenuata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus coulteri");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus muricata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus radiata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus torreyana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus quadrifolia");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Calocedrus decurrens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus agrifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus wislizeni");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus douglasii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_066() {

        // Californian Broadleaf Forest & Woodland (G195)
        // G195

        String level = "group";
        String code = "G195";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 342B, 322A, 341D, M242B, M261, M262, 261,
        // 262, 263 and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Aesculus californica, Juglans californica,
        // Quercus agrifolia, Quercus chrysolepis, Quercus douglasii,
        // Quercus kelloggii, Quercus lobata, Quercus wislizeni,
        // or Umbellularia californica (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Quercus engelmannii or Quercus parvula var. shrevei,
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","342B, 322A, 341D, M242B, M261, M262, 261, 262, 263");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Aesculus californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juglans californica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus agrifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus douglasii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus lobata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus wislizeni");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus parvula");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_067() {

        // Californian Ruderal Forest (M513)
        // M513

        String level = "macrogroup";
        String code = "M513";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER] – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_068() {

        // Madrean Forest & Woodland Division (D331)
        // D331

        String level = "division";
        String code = "D331";

        // Tree composition and ecology matching one of the following options:
        // i. EITHER
        // a. Tree composition contains one or more of STRONG diagnostic tree
        // species Juniperus ashei, Juniperus coahuilensis, Juniperus deppeana,
        // Juniperus flaccida, Pinus arizonica, Pinus cembroides, Pinus discolor,
        // Pinus engelmannii, Pinus leiophylla, Pinus strobiformis,
        // Prosopis glandulosa, Prosopis velutina, Quercus albocincta,
        // Quercus arizonica, Quercus chrysolepis, Quercus emoryi,
        // Quercus grisea, Quercus hypoleucoides, Quercus oblongifolia,
        // or Quercus rugosa (=>50% RIV),
        // [Additional tree species not tracked by FIA include
        // Juniperus arizonica, Quercus buckleyi, Quercus fusiformis,
        // Quercus gravesii, Quercus vaseyana, or Ulmus crassifolia]
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE
        // diagnostic species any combination of Abies concolor,
        // Acer grandidentatum, Arbutus arizonica, Arbutus xalapensis,
        // Celtis laevigata, Fraxinus albicans, Juglans major, Juglans nigra,
        // Juniperus monosperma, Juniperus osteosperma, Juniperus pinchotii, Pinus edulis,
        // Pinus ponderosa, Pinus remota, Pseudotsuga menziesii,
        // Prunus serotina, Quercus macrocarpa, Quercus muehlenbergii, or Quercus vaseyana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
        // [Additional tree species not tracked by FIA include Quercus laceyi]
        // OR
        // c. Any EXOTIC = yes tree species =>80% RIV
        // AND
        // ii. Located in ECOREGION 322, 313, M313, 321, 315

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","322, 313, M313, 321, 315");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus ashei");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus coahuilensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus flaccida");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus cembroides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus discolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus leiophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus albocincta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus hypoleucoides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus oblongifolia");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rugosa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Celtis laevigata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus texensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans major");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juglans nigra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus pinchotii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus remota");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus serotina");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus vaseyana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) || 
           plot.riv(EXOTIC_TREE_SPP) >=80 )
           && plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_069() {

        // Madrean Natural Forests & Woodlands
        // D331

        String level = "division";
        String code = "D331";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = yes (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_070() {

        // Madrean Lowland Evergreen Woodland (M010)
        // M010

        String level = "macrogroup";
        String code = "M010";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322, 313C, M313, 321, AND
        // tree composition dominated by one or more of STRONG DIAGNOSTIC species
        // Juniperus coahuilensis, Juniperus deppeana, Juniperus flaccida,
        // Juniperus pinchotii, Pinus cembroides, Pinus discolor,
        // Prosopis glandulosa, Prosopis velutina [these Prosopis species may be ruderal
        // or wetland types, or not even woodlands in the NVC], Quercus arizonica,
        // Quercus emoryi, Quercus gravesii, Quercus grisea, or Quercus oblongifolia
        // (RIV=>20%), [Additional tree species not tracked by FIA include
        // Pinus remota, Quercus albocincta, Quercus chihuahuensis,
        // Quercus graciliformis]
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any combination
        // of Arbutus arizonica, Arbutus xalapensis, Juniperus monosperma,
        // Pinus arizonica, Pinus edulis, Pinus engelmannii, Pinus leiophylla
        // Pinus strobiformis, Quercus hypoleucoides, and Quercus rugosa
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%))

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","322, 313C, M313, 321");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus coahuilensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus flaccida");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus pinchotii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus cembroides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus discolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Prosopis velutina");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus gravesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus oblongifolia");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus leiophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus hypoleucoides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus rugosa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_071() {

        // Madrean Pinyon - Juniper Woodland (G200)
        // G200

        String level = "group";
        String code = "G200";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313D?, 315H?, 315A, 313B, M313A, M313B, 321,
        // 313A, 322A, 313C, 322B and tree composition dominated by one or more
        // of STRONG DIAGNOSTIC species Juniperus coahuilensis, Juniperus deppeana,
        // Juniperus flaccida, Juniperus pinchotii, Pinus cembroides,
        // Pinus discolor, Pinus edulis, or Pinus remota (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus deppeana, Prosopis glandulosa,
        // Prosopis velutina (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%),
        // OR
        // iii. Located in above ECOREGION, and tree composition as i. above,
        // but with =>20% RIV AND with other INDICATOR species
        // Juniperus ashei, Juniperus scopulorum, Pinus ponderosa, Quercus arizonica, Quercus emoryi, Quercus grisea,
        // Quercus hypoleucoides, or Quercus rugosa (RIV >=1%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","ECOREGION 313D, 315H, 315A, 313B, M313A, M313B, 321, 313A, 322A, 313C, 322B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus coahuilensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus flaccida");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus pinchotii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus cembroides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus discolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus remota");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis glandulosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prosopis velutina");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> OTHER_INDICATOR_SPECIES_values = new HashMap<>();
        OTHER_INDICATOR_SPECIES_values.put("species","Quercus arizonica");
        OTHER_INDICATOR_SPECIES_values.put("species","Quercus emoryi");
        OTHER_INDICATOR_SPECIES_values.put("species","Quercus grisea");
        OTHER_INDICATOR_SPECIES_values.put("species","Quercus hypoleucoides");
        OTHER_INDICATOR_SPECIES_values.put("species","Quercus rugosa");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus ponderosa");
        OTHER_INDICATOR_SPECIES_values.put("species","Juniperus scopulorum");
        OTHER_INDICATOR_SPECIES_values.put("species","Juniperus ashei");
        PatternList OTHER_INDICATOR_SPECIES = new PatternList("OTHER_INDICATOR_SPECIES", OTHER_INDICATOR_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(OTHER_INDICATOR_SPECIES) >= 1) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_072() {

        // Madrean Encinal (G201)
        // G201

        String level = "group";
        String code = "G201";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313D?, 315H?, M313A, M313B, 315A, 321, 322A,
        // 313C, 322B and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Quercus arizonica, Quercus emoryi, Quercus grisea,
        // or Quercus oblongifolia (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Arbutus arizonica, Arbutus xalapensis (>=30% RIV;
        // i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
        // OR
        // iii. Located in above ECOREGION, and tree composition as i. above,
        // but with =>20% RIV AND with other INDICATOR species
        // Juniperus coahuilensis, Juniperus deppeana, Pinus cembroides, and
        // Pinus discolor, Pinus arizonica, Pinus engelmannii, Pinus leiophylla,
        // or Pinus strobiformis (RIV >= 1%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","313D, 315H, M313A, M313B, 315A, 321, 322A, 313C, 322B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus oblongifolia");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> OTHER_INDICATOR_SPECIES_values = new HashMap<>();
        OTHER_INDICATOR_SPECIES_values.put("species","Juniperus coahuilensis");
        OTHER_INDICATOR_SPECIES_values.put("species","Juniperus deppeana");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus cembroides");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus discolor");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus arizonica");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus engelmannii");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus leiophylla");
        OTHER_INDICATOR_SPECIES_values.put("species","Pinus strobiformis");
        PatternList OTHER_INDICATOR_SPECIES = new PatternList("OTHER_INDICATOR_SPECIES", OTHER_INDICATOR_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(OTHER_INDICATOR_SPECIES) >= 1) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_073() {

        // Madrean Juniper Open Woodland (G487)
        // G487

        String level = "group";
        String code = "G487";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315B?, 315A, M313A, 322, M313B, 315C, 321,
        // 315D, 313A, 313D, M262B, 313C, 315H
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Juniperus coahuilensis or Juniperus deppeana
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus monosperma (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315B, 315A, M313A, 322, M313B, 315C, 321, 315D, 313A, 313D, M262B, 313C, 315H");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus coahuilensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_074() {

        // Madrean Montane Forest & Woodland (M011)
        // M011

        String level = "macrogroup";
        String code = "M011";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322, 313C, M313, 321, 315, AND tree composition
        // dominated by one or more of STRONG DIAGNOSTIC species
        // Juniperus deppeana, Pinus arizonica, Pinus engelmannii, Pinus leiophylla,
        // Pinus strobiformis,
        // Quercus albocincta, Quercus arizonica, Quercus chrysolepis, Quercus emoryi,
        // Quercus grisea, Quercus hypoleucoides, or Quercus rugosa (RIV=>20%),
        // [Additional tree species not tracked by FIA include Abies coahuilensis,
        // Hesperocyparis arizonica, Quercus fulva, Quercus viminea]
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies concolor, Acer grandidentatum, Arbutus arizonica,
        // Arbutus xalapensis, Juniperus flaccida, Pinus cembroides,
        // Pinus discolor, Pinus edulis, Pinus ponderosa, Pseudotsuga menziesii
        // Quercus gravesii and Quercus muehlenbergii
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","322, 313C, M313, 321, 315");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus leiophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus albocincta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus hypoleucoides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rugosa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus flaccida");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus cembroides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus discolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gravesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_075() {

        // Madrean Upper Montane Conifer - Oak Forest & Woodland (G202)
        // G202

        String level = "group";
        String code = "G202";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313B, 313D, 315H, 322B, 315A, M313A,
        // M313B, 321A, 322A, 313C  and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Abies coahuilensis, Abies concolor, Pinus strobiformis,
        // Pseudotsuga menziesii, Quercus hypoleucoides, or Quercus rugosa
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer grandidentatum, Juniperus deppeana,
        // Juniperus flaccida, Quercus arizonica, Quercus chrysolepis,
        // Quercus emoryi, Quercus gravesii, Quercus grisea,
        // Quercus muehlenbergii (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","341Fb, 341Fc, 341Fd, 322Ab, 322Aa, 322Az, 322Ac, 341Fk, 341Fe, 322Ad, 322Ay, 322Ae, 341Ff, 322As, 322Ar, 322Aq, 322Ag, 322Af, 322At, 313Ao, 322Ah, 322Ai, 322Aj, 322Av, 322Am, 313De, 322Aw, 322Al, 322Ax, 322Ao, 322An, 313Df, M313Ak, M313Al, 322Ba, 322Ap, 313Cd, 313Bo, 313Ca, M313Af, 315Ha, M313Ah, 313Cc, M313Am, M313Ad, M313Bf, 321Ag, 322Bh, M313Ag, 321Ai, M313Ae, 321Ak, 321Af, M313Bg, M313Ac, 315Aa, 321Aj, 321Am, M313Ba, 321Ac, 321Ah");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies coahuilensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus hypoleucoides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus rugosa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus flaccida");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gravesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus muehlenbergii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_076() {

        // Madrean Lower Montane Pine - Oak Forest & Woodland (G203)
        // G203

        String level = "group";
        String code = "G203";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315A, 315H, 313D, 322B, M313A, M313B, 321,
        // 322A, 313C and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Hesperocyparis arizonica, Juniperus deppeana, Pinus arizonica,
        // Pinus engelmannii,
        // Pinus leiophylla, or Pinus ponderosa var. scopulorum (RIV=>20%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Arbutus arizonica, Arbutus xalapensis,
        // Juniperus flaccida, Pinus cembroides,
        // Pinus discolor, Quercus arizonica, Quercus emoryi, Quercus fulva,
        // Quercus gravesii, Quercus grisea, Quercus hypoleucoides,
        // Quercus rugosa, or Quercus viminea (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315A, 315H, 313D, 322B, M313A, M313B, 321, 322A, 313C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cupressus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus arizonica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus leiophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus xalapensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus flaccida");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus cembroides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus discolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus emoryi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus fulva");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gravesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus hypoleucoides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus rugosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus viminea");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_077() {

        // Western North American Ruderal Forests - Madrean-Balconian
        // D060

        String level = "division";
        String code = "D060";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = yes (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        Map<String,String> EXOTIC_values = new HashMap<>();
        EXOTIC_values.put("exotic","yes");
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_078() {

        // Cool Temperate Forest & Woodland Formation
        // F008

        String level = "formation";
        String code = "F008";

        // Not as above, Temperate deciduous forests and woodlands, temperate
        // needle-leaved forests and woodlands, and temperate rainforests,
        // dominated by broad-leaved or needle-leaved tree growth forms found
        // in cool temperate regions of the western U.S. and southeast Alaska

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_079() {

        // Pacific Coast Temperate Rainforest Division (D338)
        // D338

        String level = "division";
        String code = "D338";

        // Tree composition and ecology matching one of the following options: 
        // i.  Located in ECOREGION 242A, M242, 261A, M261A, M261B, 263
        // AND
        // ii.  EITHER 
        //   a.  Tree composition dominated by one or more of STRONG DIAGNOSTIC 
        //   species Abies amabilis, Acer macrophyllum, Alnus rubra, 
        //   Chamaecyparis lawsoniana, Picea sitchensis, Pinus contorta 
        //   [exclude from M242C and M242D, and exclude plots >500m in 
        //   ELEVATION], Pseudotsuga menziesii [exclude from M242C and M242D],
        //   Sequoia sempervirens, Thuja plicata, or Tsuga heterophylla
        //   (RIV=>50%)
        //   OR
        //   b.  Tree composition as above, but with =>20% RIV AND with other 
        //   MODERATE DIAGNOSTIC species in any combination of Abies grandis,
        //   Abies lasiocarpa, Abies procera, Acer circinatum, 
        //   Arbutus menziesii, Callitropsis nootkatensis, Cornus nuttallii,
        //   Frangula purshiana, Notholithocarpus densiflorus,
        //   Pinus monticola, Pinus muricata, Quercus garryana, or 
        //   Umbellularia californica (>=30% RIV; i.e., together STRONG and
        //   MODERATE diagnostic species RIV =>50%) 
        //   OR 
        //   c.  Any EXOTIC = yes tree species =>80% RIV
        // 
        // ###TRANSLATES TO:
        // 
        // Plot location and tree composition are as follows:
        // STRONG DIAGNOSTICS RIV 50% or more
        // NO EXCLUSIONS
        //   i. Located in ECOREGION 242A, M242, 261A, M261A, M261B, 263, AND tree
        //   composition dominated by one or more of STRONG DIAGNOSTIC_1 species
        //   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
        //   Picea sitchensis, Sequoia sempervirens, Thuja plicata, or
        //   Tsuga heterophylla (RIV=>50%),
        // OR
        // ELEVATION <500m + ECOREGION EXCLUSIONS
        //   ii. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
        //   AND elevation <500m
        //   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_2 species
        //   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
        //   Picea sitchensis, Pinus contorta, Pseudotsuga menziesii, Sequoia sempervirens,
        //   Thuja plicata, or Tsuga heterophylla (RIV=>50%),
        // OR
        // ELEVATION =>500m + ECOREGION EXCLUSIONS
        //   iii. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
        //   AND elevation =>500m
        //   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_3 species
        //   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
        //   Picea sitchensis, Pseudotsuga menziesii, Sequoia sempervirens, Thuja plicata,
        //   or Tsuga heterophylla (RIV=>50%),
        // OR
        // STRONG DIAGNOSTICS RIV 20% or more + MODERATE DIAGNOSTICS RIV 30% or more
        // NO EXCLUSIONS
        //   iv. Located in ECOREGION 242A, M242, 261A, M261A, M261B, 263, AND tree composition
        //   dominated by one or more of STRONG DIAGNOSTIC_1 species Abies amabilis,
        //   Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana, Picea sitchensis,
        //   Sequoia sempervirens, Thuja plicata, or Tsuga heterophylla (RIV=>20%),
        //   AND with other MODERATE DIAGNOSTIC species in any combination of Abies grandis,
        //   Abies lasiocarpa, Abies procera, Acer circinatum, Arbutus menziesii,
        //   Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana,
        //   Notholithocarpus densiflorus, Pinus monticola, Pinus muricata, Quercus garryana,
        //   or Umbellularia californica (>=30% RIV; i.e., together STRONG and MODERATE
        //   diagnostic species RIV =>50%)
        // OR
        // ELEVATION <500m + ECOREGION EXCLUSIONS
        //   v. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
        //   AND elevation <500m
        //   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_2 species
        //   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
        //   Picea sitchensis, Pinus contorta, Pseudotsuga menziesii, Sequoia sempervirens,
        //   Thuja plicata, or Tsuga heterophylla (RIV=>20%),
        //   AND with other MODERATE DIAGNOSTIC species in any combination of Abies grandis,
        //   Abies lasiocarpa, Abies procera, Acer circinatum, Arbutus menziesii,
        //   Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana,
        //   Notholithocarpus densiflorus, Pinus monticola, Pinus muricata, Quercus garryana,
        //   or Umbellularia californica (>=30% RIV; i.e., together STRONG and MODERATE
        //   diagnostic species RIV =>50%)
        // OR
        // ELEVATION =>500m + ECOREGION EXCLUSIONS
        //   vi. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
        //   AND elevation =>500m
        //   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_3 species
        //   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
        //   Picea sitchensis, Pseudotsuga menziesii, Sequoia sempervirens, Thuja plicata,
        //   or Tsuga heterophylla (RIV=>20%),
        //   AND with other MODERATE DIAGNOSTIC species in any combination of Abies grandis,
        //   Abies lasiocarpa, Abies procera, Acer circinatum, Arbutus menziesii,
        //   Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana,
        //   Notholithocarpus densiflorus, Pinus monticola, Pinus muricata, Quercus garryana,
        //   or Umbellularia californica (>=30% RIV; i.e., together STRONG and MODERATE
        //   diagnostic species RIV =>50%)
        // OR
        //   vii. Any EXOTIC = yes tree species >= 80%

        Map<String,String> ECOREGIONS_1_values = new HashMap<>();
        ECOREGIONS_1_values.put("ecoregion","242A, M242, 261A, M261A, M261B, 263");
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_values);

        Map<String,String> ECOREGIONS_2_values = new HashMap<>();
        ECOREGIONS_2_values.put("ecoregion","242A, M242A, M242B, 261A, M261A, M261B, 263");
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_1_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Acer macrophyllum");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Alnus rubra");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Chamaecyparis lawsoniana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Sequoia sempervirens");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES_1 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_1", STRONG_DIAGNOSTIC_SPECIES_1_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_2_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Acer macrophyllum");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Alnus rubra");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Chamaecyparis lawsoniana");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Sequoia sempervirens");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES_2 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_2", STRONG_DIAGNOSTIC_SPECIES_2_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_3_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Acer macrophyllum");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Alnus rubra");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Chamaecyparis lawsoniana");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Sequoia sempervirens");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_3_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES_3 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_3", STRONG_DIAGNOSTIC_SPECIES_3_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies procera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer circinatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Callitropsis nootkatensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cornus nuttallii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Frangula purshiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus muricata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus garryana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50) ||
           (plot.match(ECOREGIONS_2) && plot.get_elevation() < 500 && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 50) ||
           (plot.match(ECOREGIONS_2) && plot.get_elevation() >= 500 && plot.riv(STRONG_DIAGNOSTIC_SPECIES_3) >= 50) ||
           (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.match(ECOREGIONS_2) && plot.get_elevation() < 500 && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.match(ECOREGIONS_2) && plot.get_elevation() >= 500 && plot.riv(STRONG_DIAGNOSTIC_SPECIES_3) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.match(ECOREGIONS_1) && plot.riv(EXOTIC_TREE_SPP) >= 80)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_080() {

        // Vancouverian Coastal Rainforest (M024)
        // M024

        String level = "macrogroup";
        String code = "M024";

        // Only macrogroup

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_081() {

        // Vancouverian Dry Coastal Beach Pine Forest & Woodland (G205)
        // G205

        String level = "group";
        String code = "G205";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 242, M242A, M261A, 263
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Pinus contorta(RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies grandis, Arbutus menziesii, Pinus muricata, Picea sitchensis, Pseudotsuga menziesii  or
        // Tsuga heterophylla [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242, M242A, M261A, 263");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus muricata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_082() {

        // Californian Coastal Redwood Forest (G235)
        // G235

        String level = "group";
        String code = "G235";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M262A, M242A, M261A, 263, M261B, 261A and
        // tree composition dominated by one or more of STRONG DIAGNOSTIC species
        // Chamaecyparis lawsoniana or Sequoia sempervirens (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Arbutus menziesii, Notholithocarpus densiflorus,
        // Picea sitchensis, Pseudotsuga menziesii, Tsuga heterophylla, or
        // Umbellularia californica (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M262A, M242A, M261A, 263, M261B, 261A");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sequoia sempervirens");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_083() {

        // North Pacific Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)
        // G237

        String level = "group";
        String code = "G237";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, M242D, M261A, M261D, M242A, M242B, 242
        // and tree composition dominated
        // by one or more of STRONG DIAGNOSTIC species Acer macrophyllum or
        // Alnus rubra (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies grandis, Cornus nuttallii, Frangula purshiana,
        // Picea sitchensis, Pseudotsuga menziesii, Quercus garryana,
        // Thuja plicata, Malus fusca, Prunus emarginata or Tsuga heterophylla (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242D, M261A, M261D, M242A, M242B, 242");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cornus nuttallii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Frangula purshiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus garryana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Malus fusca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus emarginata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_084() {

        // North Pacific Maritime Douglas-fir - Western Hemlock Rainforest (G240)
        // G240

        String level = "group";
        String code = "G240";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 261A, M242A, M261A, M261B, 263, 242
        // M242B, M242D and tree composition
        // dominated by one or more of STRONG DIAGNOSTIC species
        // Pseudotsuga menziesii, Tsuga heterophylla, or Thuja plicata
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer macrophyllum, Alnus rubra, Prunus emarginata, or Malus fusca (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261A, M242A, M261A, M261B, 263, 242, M242B, M242D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Malus fusca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus emarginata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_085() {

        // North-Central Pacific Maritime Silver Fir - Western Hemlock Rainforest (G241)
        // G241

        String level = "group";
        String code = "G241";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242, 242
        // and tree composition dominated
        // by one or more of STRONG DIAGNOSTIC species Abies amabilis or
        // Tsuga heterophylla (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies lasiocarpa, Abies procera, Malus fusca, Prunus emarginata  or
        // Callitropsis nootkatensis (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242, 242");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies procera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Callitropsis nootkatensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Malus fusca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus emarginata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_086() {

        // North-Central Pacific Western Hemlock - Sitka Spruce Rainforest (G751)
        // G751

        String level = "group";
        String code = "G751";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 261A, M261A, M261B, M242A, M242B,
        // M242D, 242, 263
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Picea sitchensis, Thuja plicata, or
        // Tsuga heterophylla (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies amabilis, Abies grandis, Acer circinatum,
        // Acer macrophyllum, Alnus rubra, Callitropsis nootkatensis,
        // Chamaecyparis lawsoniana, Frangula purshiana, Malus fusca, Prunus emarginata  or
        // Pseudotsuga menziesii (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261A, M261A, M261B, M242A, M242B, M242D, 242, 263");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies amabilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer circinatum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Alnus rubra");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Callitropsis nootkatensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Frangula purshiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Malus fusca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus emarginata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_087() {

        // Western North American Pinyon-Juniper Woodland & Scrub Division (D010)
        // D010

        String level = "division";
        String code = "D010";

        // Tree composition and ecology matching one of the following options:
        // i.  Located in ECOREGION M242C, M261D, M261E, M261G, M262B, 313, M313, 315,
        //   321, 322, 331I, 331J, M331, M332, 341, M341, 342
        // AND
        // ii.  EITHER
        //   a.  Tree composition dominated by one or more of STRONG diagnostic
        //   tree species Cercocarpus ledifolius, Juniperus monosperma,
        //   Juniperus occidentalis, Juniperus osteosperma, Pinus edulis, or
        //   Pinus monophylla (=>50% RIV),
        //   OR
        //   b.  The above tree species, but with =>20% RIV AND other MODERATE 
        //   diagnostic species of Juniperus californica, Juniperus deppeana,
        //   Juniperus grandis, Juniperus scopulorum, Pinus jeffreyi,
        //   Pinus ponderosa, or Quercus gambelii (>=30% RIV; i.e.,
        //   together STRONG and MODERATE diagnostic species =>50% RIV)
        //   OR
        //   c.  Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M261D, M261E, M261G, M262B, 313, M313, 315, 321, 322, 331I, 331J, M331, M332, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cercocarpus ledifolius");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus monophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus californica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
           && ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
           || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30)
           || plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_088() {

        // Intermountain Pinyon-Juniper Woodland (M896)
        // M896

        String level = "macrogroup";
        String code = "M896";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, 342, M332, M261D, M261E, M261G, 315, 313,
        // M313, 321, M331D, M331E, M331F, M331G, M331H, M331I, M331J, 341, M262B,
        // 322, 331I, 331J, M333, M341,
        // AND tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Juniperus occidentalis, Juniperus osteosperma, Pinus monophylla,
        // or Cercocarpus ledifolius (RIV=>20%), 
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus californica, Pinus edulis, Pinus jeffreyi
        // Juniperus grandis, Juniperus monosperma, Juniperus scopulorum, and Pinus ponderosa
        // or [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES]
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, 342, M332, M261D, M261E, M261G, 315, 313, M313, 321, M331D, M331E, M331F, M331G, M331H, M331I, M331J, 341, M262B, 322, 331I, 331J, M333, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus monophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cercocarpus ledifolius");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus californica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_089() {

        // Intermountain Western Juniper Open Woodland (G248)
        // G248

        String level = "group";
        String code = "G248";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 341E, 341G, 342D, M242B, M332A, M261A,
        // M261F, M242C, 342H, 342I, 342B, 342C, M332G, M261D, M261E, M261G
        // and tree composition dominated
        // by one or more of STRONG DIAGNOSTIC species Juniperus occidentalis
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Cercocarpus ledifolius, Pinus jeffreyi or
        // Pinus ponderosa (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","341E, 341G, 342D, M242B, M332A, M261A, M261F, M242C, 342H, 342I, 342B, 342C, M332G, M261D, M261E, M261G");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cercocarpus ledifolius");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_090() {

        // Intermountain Basins Curl-leaf Mountain-mahogany Woodland & Scrub (G249)
        // G249

        String level = "group";
        String code = "G249";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322B, 341B, 341C, 342F, 342A, 342G, 342I,
        // 342E, M242B, M261A, M261B, M261F, M262B, M332A, M331G, M331H,
        // M242C, M332E, M332F, M332G, M332B, M332D, M261D, M261E, M261G, 342H,
        // 342B, 342D, 342C, 342J, M331A, M331B, M331E, M331J, M331D, 313A,
        // 341A, 341F, 341E, 341D, 341G, 322A, M341 
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Cercocarpus ledifolius (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of [PLACEHOLDER - INSERT P2 VEG] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%) 

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","322B, 341B, 341C, 342F, 342A, 342G, 342I, 342E, M242B, M261A, M261B, M261F, M262B, M332A, M331G, M331H, M242C, M332E, M332F, M332G, M332B, M332D, M261D, M261E, M261G, 342H, 342B, 342D, 342C, 342J, M331A, M331B, M331E, M331J, M331D, 313A, 341A, 341F, 341E, 341D, 341G, 322A, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Cercocarpus ledifolius");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","placeholder - add moderate diagnostic");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_091() {

        // Great Basin Pinyon - Juniper Woodland (G899)
        // G899

        String level = "group";
        String code = "G899";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322B, 342D, 342H, M242C, 313, 322A, 341A,
        // 341D, 341E, 341F, 341G, 342B, 342C, 342J, M261F, M261E, M261G,
        // M262B, M331D, M341A, M341D, M341C
        // and tree composition dominated by the STRONG
        // DIAGNOSTIC species Pinus monophylla (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Cercocarpus ledifolius, Juniperus californica, Juniperus occidentalis,
        // Juniperus osteosperma or Pinus jeffreyi (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","322B, 342D, 342H, M242C, 313, 322A, 341A, 341D, 341E, 341F, 341G, 342B, 342C, 342J, M261F, M261E, M261G, M262B, M331D, M341A, M341D, M341C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus monophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cercocarpus ledifolius");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus californica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_092() {

        // Colorado Plateau Pinyon - Juniper Woodland (G900)
        // G900

        String level = "group";
        String code = "G900";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322B, 342E, 342D, 331I, 315A, 315H, 313,
        // 322A, M313A, M313B, M331D, M331E, M331F, M331G, M331H, M331I, 331J,
        // 342G, 341A, 341B, 341C, 341F, M341B, M341C
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Pinus edulis (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus monosperma, Juniperus osteosperma, Quercus gambelii, Quercus grisea  or
        // Juniperus scopulorum (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","322B, 342E, 342D, 331I, 315A, 315H, 313, 322A, M313A, M313B, M331D, M331E, M331F, M331G, M331H, M331I, 331J, 342G, 341A, 341B, 341C, 341F, M341B, M341C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus grisea");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_093() {

        // Intermountain Utah Juniper Open Woodland (G105)
        // G105

        String level = "group";
        String code = "G105";

        // i. Located in ECOREGION 313A, 313B, 313D, 322A, 341, 342B, 342J,
        // M331D, M331E, M341 and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Juniperus osteosperma (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Cercocarpus ledifolius, Juniperus californica,
        // Juniperus monosperma, Juniperus scopulorum or Quercus gambelii (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","313A, 313B, 313D, 322A, 341, 342B, 342J, M331D, M331E, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Cercocarpus ledifolius");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus californica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_094() {

        // Southern Rocky Mountain Two-needle Pinyon-Juniper Woodland (M897)
        // M897

        String level = "macrogroup";
        String code = "M897";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315, 313, M313, 321, 342, M331, 341, 322, 
        // 331B, 331I, 331J, M341B, M341C
        // AND tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Juniperus monosperma or Pinus edulis (RIV=>20%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus scopulorum or
        // [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES]
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315, 313, M313, 321, 342, M331, 341, 322, 331B, 331I, 331J, M341B, M341C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_095() {

        // Southern Rocky Mountain Pinyon - Juniper Woodland (G253)
        // G253

        String level = "group";
        String code = "G253";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 321A, 315A, 315H, 315B, 313B, 313D, M313,
        // M331G, M331F, M331I, 331B, 331I, 331J
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Pinus edulis
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus deppeana, Juniperus monosperma, Juniperus
        // scopulorum or Quercus gambelii (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","321A, 315A, 315H, 315B, 313B, 313D, M313, M331G, M331F, M331I, 331B, 331I, 331J");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_096() {

        // Southern Rocky Mountain Juniper Open Woodland (G252)
        // G252

        String level = "group";
        String code = "G252";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315A, 315B, 315H, 313B, 313D, M313, 321A,
        // M331G, M331F, 331B, 331J, 331I
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Juniperus monosperma (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus scopulorum (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315A, 315B, 315H, 313B, 313D, M313, 321A, M331G, M331F, 331B, 331J, 331I");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus monosperma");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_097() {

        // Pacific Mountains Forest & Woodland Division (D339)
        // D339

        String level = "division";
        String code = "D339";

        // Tree composition and ecology matching one of the following options:
        // i.  Elevation less than 2400 meters and Located in ECOREGION 242, M242, M261, 261A, 262, 263, 341D
        // ii.  EITHER 
        //     d.  Tree composition dominated by one or more of STRONG diagnostic tree
        //     species Abies concolor, Abies grandis, Abies lasiocarpa, Abies magnifica,
        //     Abies shastensis [Abies magnifica var. shastensis], Abies procera, 
        //     Calocedrus decurrens, , Chrysolepis chrysophylla, Juniperus grandis, 
        //     Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monticola, 
        //     Quercus chrysolepis, Quercus garryana, Quercus kelloggii, 
        //     Sequoiadendron giganteum, Taxus brevifolia, or Umbellularia californica 
        //     (=>20% RIV) 
        //     OR 
        //     e.  The above tree species, but with =>10% RIV AND other MODERATE 
        //     diagnostic species, any combination of Abies bracteata, Acer circinatum, Acer macrophyllum, 
        //     Arbutus menziesii, Cornus nuttallii, Frangula purshiana, Picea breweriana, 
        //     Pinus coulteri, Pinus flexilis, Pinus lambertiana, Pinus muricata, 
        //     Pinus washoensis, Populus balsamifera ssp. trichocarpa, 
        //     Pseudotsuga macrocarpa (>=40% RIV; i.e., together STRONG and MODERATE 
        //     diagnostic species =>50% RIV) 
        //     OR 
        //     f.  Any EXOTIC = yes tree species =>80% RIV 
        // OR 
        //   M242C and M242D Exclusion/Exception for Pinus contorta, Pinus ponderosa, and 
        //   Pseudotsuga menziesii: Tree composition and ecology matching one of the 
        //   following options: 
        //   iii.  Located in ECOREGION 242, M242A, M242B, M261, 261A, 262, 263, 341D 
        //   AND 
        //   iv.  EITHER 
        //       a.  Tree composition dominated by one or more of STRONG diagnostic tree 
        //           species Abies concolor, Abies grandis, Abies lasiocarpa, Abies magnifica, Abies shastensis [Abies magnifica var. shastensis], Abies procera, Calocedrus decurrens, , Chrysolepis chrysophylla, Juniperus occidentalis, Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monticola, Quercus chrysolepis, Quercus garryana, Quercus kelloggii, Sequoiadendron giganteum, Taxus brevifolia, or Umbellularia californica (=>20% RIV) 
        //       OR 
        //       b.  The above tree species, but with =>10% RIV AND other MODERATE 
        //           diagnostic species, any combination of Abies bracteata, Abies concolor var. lowiana, Acer circinatum, Acer macrophyllum, Arbutus menziesii, Cornus nuttallii, Frangula purshiana, Picea breweriana, Pinus coulteri, Pinus flexilis, Pinus lambertiana, Pinus muricata, Pinus washoensis, Populus balsamifera ssp. trichocarpa, Pseudotsuga macrocarpa (>=40% RIV; i.e., together STRONG and 
        //           MODERATE diagnostic species =>50% RIV) 
        //       OR 
        //       d.  Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_I_values = new HashMap<>();
        ECOREGIONS_I_values.put("ecoregion","242, M242, M261, 261A, 262, 263, 341D");
        PatternList ECOREGIONS_I = new PatternList("ECOREGIONS_I", ECOREGIONS_I_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_I_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Abies magnifica var. shastensis");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Abies procera");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Calocedrus decurrens");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Chrysolepis chrysophylla");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Lithocarpus densiflorus");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus jeffreyi");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus monticola");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Quercus garryana");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Quercus kelloggii");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Sequoiadendron giganteum");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Taxus brevifolia");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Umbellularia californica");
        STRONG_DIAGNOSTIC_SPECIES_I_values.put("species","Juniperus occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES_I = new PatternList("STRONG_DIAGNOSTIC_SPECIES_I", STRONG_DIAGNOSTIC_SPECIES_I_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_I_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Abies bracteata");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Acer circinatum");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Cornus nuttallii");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Frangula purshiana");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Picea breweriana");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus coulteri");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus lambertiana");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus muricata");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Pinus washoensis");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Populus balsamifera ssp. trichocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_I_values.put("species","Pseudotsuga macrocarpa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES_I = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_I", MODERATE_DIAGNOSTIC_SPECIES_I_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        Map<String,String> ECOREGIONS_II_values = new HashMap<>();
        ECOREGIONS_II_values.put("ecoregion","242, M242A, M242B, M261, 261A, 262, 263, 341D");
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_II_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies magnifica var. shastensis");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Abies procera");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Calocedrus decurrens");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Chrysolepis chrysophylla");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Notholithocarpus densiflorus");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Picea sitchensis");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus lambertiana");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus jeffreyi");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus monticola");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Quercus garryana");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Quercus kelloggii");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Sequoiadendron giganteum");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Taxus brevifolia");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Umbellularia californica");
        STRONG_DIAGNOSTIC_SPECIES_II_values.put("species","Juniperus occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES_II = new PatternList("STRONG_DIAGNOSTIC_SPECIES_II", STRONG_DIAGNOSTIC_SPECIES_II_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_II_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Abies bracteata");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Acer circinatum");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Cornus nuttallii");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Frangula purshiana");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Picea breweriana");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus coulteri");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus muricata");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Pinus washoensis");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Populus balsamifera ssp. trichocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_II_values.put("species","Pseudotsuga macrocarpa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES_II = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_II", MODERATE_DIAGNOSTIC_SPECIES_II_values);

        INodeMatch match = plot -> (
            plot.get_elevation() < 2400 && plot.match(ECOREGIONS_I) &&
           ((plot.riv(STRONG_DIAGNOSTIC_SPECIES_I) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES_I) >= 10 && 
           plot.riv(MODERATE_DIAGNOSTIC_SPECIES_I) >= 40) || 
           plot.riv(EXOTIC_TREE_SPP) >= 80)) ||
           (plot.match(ECOREGIONS_II) && 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 10 && 
           plot.riv(MODERATE_DIAGNOSTIC_SPECIES_II) >= 40) || 
           plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_098() {

        // Southern Vancouverian Dry Foothill Forest & Woodland (M886)
        // M886

        String level = "macrogroup";
        String code = "M886";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242, 242, M261, 263, 262,
        // AND tree composition dominated by one or more of STRONG DRY
        // DIAGNOSTIC species Arbutus menziesii, Notholithocarpus densiflorus,
        // Chrysolepis chrysophylla, Pseudotsuga macrocarpa 
        // Pseudotsuga menziesii, or Quercus garryana (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies grandis, Acer macrophyllum,
        // Abies bracteata, Calocedrus decurrens, Chamaecyparis lawsoniana, Pinus coulteri 
        // Juniperus occidentalis, Juniperus scopulorum, Pinus contorta, Pinus ponderosa,
        // Quercus chrysolepis, Quercus kelloggii, Taxus brevifolia, or
        // Umbellularia californica
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242, 242, M261, 263, 262");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Notholithocarpus densiflorus");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Chrysolepis chrysophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus garryana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies bracteata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Calocedrus decurrens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus coulteri");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Taxus brevifolia");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_099() {

        // Cascadian Oregon White Oak - Conifer Forest & Woodland (G206)
        // G206

        String level = "group";
        String code = "G206";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 242B, 262A, 261A, 261B, 342H, M242D, M262A,
        // M242C, M261D, M242A, M261A, 263, M261G, M261B, 342I, M242B, 242A
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Quercus garryana (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Arbutus menziesii, Juniperus occidentalis,
        // Pinus ponderosa, Pseudotsuga menziesii,
        // Quercus chrysolepis, or Quercus kelloggii (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242B, 262A, 261A, 261B, 342H, M242D, M262A, M242C, M261D, M242A, M261A, 263, M261G, M261B, 342I, M242B, 242A");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus garryana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_100() {

        // Californian Moist Coastal Mixed Evergreen Forest (G208)
        // G208

        String level = "group";
        String code = "G208";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 262A, M261C, M261E, 263, M242A, M261A, M261D,
        // M261F, M261B, M262, 261, M242B  and tree composition dominated by
        // one or more of STRONG DIAGNOSTIC species
        // Chrysolepis chrysophylla, Notholithocarpus densiflorus,
        // Pseudotsuga menziesii, Pseudotsuga macrocarpa, Quercus chrysolepis, or
        // Umbellularia californica (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies bracteata, Arbutus menziesii, Calocedrus decurrens,
        // Chamaecyparis lawsoniana, Pinus coulteri or Pinus ponderosa
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","262A, M261C, M261E, 263, M242A, M261A, M261D, M261F, M261B, M262, 261, M242B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Chrysolepis chrysophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Lithocarpus densiflorus");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Umbellularia californica");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies bracteata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Calocedrus decurrens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chamaecyparis lawsoniana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus coulteri");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_101() {

        // Southern Vancouverian Dry Douglas-fir - Madrone Woodland (G800)
        // G800

        String level = "group";
        String code = "G800";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 261A, 263A, M261D, M261B, M242B, M242A, M261A, 242
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Arbutus menziesii or Pseudotsuga menziesii
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies grandis, Acer macrophyllum, Juniperus scopulorum,
        // Pinus contorta, Quercus garryana, or Taxus brevifolia
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261A, 263A, M261D, M261B, M242B,  M242A, M261A, 242");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Arbutus menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer macrophyllum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus garryana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Taxus brevifolia");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_102() {

        // Southern Vancouverian Montane-Foothill Forest (M023)
        // M023

        String level = "macrogroup";
        String code = "M023";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M261, 262, 263, 341D, M242B
        // AND tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Abies concolor [=var. lowiana],
        // Calocedrus decurrens, Pinus jeffreyi, Pinus lambertiana,
        // Pinus ponderosa, Quercus chrysolepis, or Sequoiadendron giganteum
        // (RIV=>20%),
        // [Additional tree species not tracked by FIA include Abies lowiana]
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in
        // any combination Abies magnifica, Abies shastensis [Abies magnifica
        // var. shastensis], Chrysolepis chrysophylla,
        // Picea breweriana, Pinus monticola, Pseudotsuga macrocarpa,
        // Pseudotsuga menziesii, Quercus kelloggii
        // Pinus washoensis and Pseudotsuga macrocarpa 
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
        // [Additional tree species not tracked by FIA include Abies bracteata]

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M261, 262, 263, 341D, M242B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Calocedrus decurrens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus lambertiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sequoiadendron giganteum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga macrocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chrysolepis chrysophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea breweriana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus washoensis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_103() {

        // Californian Montane Conifer Forest & Woodland (G344)
        // G344

        String level = "group";
        String code = "G344";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 261B, 262A, 341E, 322A, M242A, 263, M261,
        // 341D, M242C, 342B, M262, M242B, 261A and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Abies concolor, Calocedrus decurrens, Pinus jeffreyi, Pinus lambertiana,
        // Pinus monticola, Pinus ponderosa, Pseudotsuga menziesii,
        // Quercus chrysolepis, Quercus kelloggii or Sequoiadendron giganteum
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies bracteata, Abies magnifica, Abies shastensis
        // [Abies magnifica var. shastensis], Chrysolepis chrysophylla,
        // Picea breweriana, Pinus washoensis, Pseudotsuga macrocarpa
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","261B, 262A, 341E, 322A, M242A, 263, M261, 341D, M242C, 342B, M262, M242B, 261A");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Calocedrus decurrens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus lambertiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus chrysolepis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus kelloggii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Sequoiadendron giganteum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies bracteata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Chrysolepis chrysophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea breweriana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus washoensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_104() {

        // Vancouverian Ruderal Forest (M405)
        // M405

        String level = "macrogroup";
        String code = "M405";

        // Only one Macrogroup

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC_TREE_SPP) >=80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_105() {

        // Vancouverian Ruderal Forest (G801)
        // G801

        String level = "group";
        String code = "G801";

        // 

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_106() {

        // Rocky Mountain Foothills & Montane Forest & Woodland (D337)
        // D337

        String level = "division";
        String code = "D337";

        // Tree composition and ecology matching one of the following options:
        // i.  Elevation below 2800 meters and located in ECOREGION M242C,
        //     M242D – only eastern ecosubsections M242Dd, M242De, M242Df, M242Dg, M242Dh,
        //     313A, 313B, 313C, 313D, 315A, 315B, 315F, 315H, 321, M313, 322A, 331, M331,
        //     M332, M333, M334, 341, M341, 342   
        // AND
        // ii.  EITHER
        //     a.  Tree composition dominated by one or more of STRONG diagnostic tree
        //     species Abies concolor, Abies grandis, Abies lasiocarpa,
        //     Acer grandidentatum, Juniperus scopulorum, Larix lyallii,
        //     Larix occidentalis, Picea glauca, Picea pungens, Pinus contorta,
        //     Pinus flexilis, Pinus ponderosa, Pinus longaeva, Populus tremuloides, Pseudotsuga menziesii,
        //     Quercus gambelii, Thuja plicata,  or Tsuga heterophylla (=>50% RIV),
        //     [Additional species not tracked by FIA Picea engelmannii x glauca hybrids]
        //     OR
        //     b.  The above tree species, but with =>20% RIV AND other MODERATE
        //     diagnostic species any combination of Abies lasiocarpa var. arizonica,
        //     Abies lasiocarpa var. lasiocarpa, Acer negundo, Betula papyrifera,
        //     Fraxinus pennsylvanica, Juniperus deppeana, Juniperus osteosperma, Picea engelmannii,
        //    , Pinus edulis, Pinus monticola, Pinus strobiformis,
        //     Quercus macrocarpa, or Ulmus americana (>=30% RIV; i.e., together STRONG
        //     and MODERATE diagnostic species =>50% RIV) 
        //     OR
        //     c.  Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 313A, 313B, 313C, 313D, 315A, 315B, 315F, 315H, 321, M313, 322A, 331, M331, M332, M333, M334, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Larix lyallii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus longaeva");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa var. arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa var. lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Prunus virginiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.get_elevation() < 2800 && plot.match(ECOREGIONS) && 
           ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && 
           plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_107() {

        // Southern Rocky Mountain Lower Montane Forest (M022)
        // M022

        String level = "macrogroup";
        String code = "M022";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315A, 315B, 315F, 315H, 313A, 313B, 313C, 313D,
        // M313, 342J, 342G, 342E, 342F, M331D, M331F, M331G, M331H, M331E,
        // M331I, 331H, 331C, 331B, 331I, 331J, 341, M341, 322A,
        // AND tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Abies concolor, Acer grandidentatum, Juniperus scopulorum,
        // Pinus aristata, Pinus contorta, Pinus longaeva
        // Pinus ponderosa, Pinus strobiformis, Pseudotsuga menziesii,
        // Picea pungens, Populus tremuloides, or Quercus gambelii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies lasiocarpa var. arizonica,
        // Abies lasiocarpa var. lasiocarpa, Juniperus deppeana,
        // Picea engelmannii, Pinus edulis, Pinus flexilis,
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315A, 315B, 315F, 315H, 313A, 313B, 313C, 313D, M313, 342J, 342G, 342E, 342F, M331D, M331F, M331G, M331H, M331E, M331I, 331H, 331C, 331B, 331I, 331J, 341, M341, 322A");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus aristata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus longaeva");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa var. arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa var. lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_108() {

        // Southern Rocky Mountain Bristlecone Pine Forest & Woodland (G102)
        // G102

        String level = "group";
        String code = "G102";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 342D, 342C, 313A, 313B, 313D, 322A, 331H,
        // 331I, 331J, 341, 342B, 342E, 342F, 342G, 342J, M261E, M331D, M331E,
        // M331F, M331G, M331H, M331I, M341
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Pinus longaeva (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
        // Abies concolor, Picea engelmannii,
        // Pinus contorta, Pinus flexilis,
        // Juniperus scopulorum, Pinus ponderosa
        // Pseudotsuga menziesii, or Populus tremuloides in any combination of
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","342D, 342C, 313A, 313B, 313D, 322A, 331H, 331I, 331J, 341, 342B, 342E, 342F, 342G, 342J, M261E, M331D, M331E, M331F, M331G, M331H, M331I, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus longaeva");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_109() {

        // Southern Rocky Mountain Mesic-Moist Mixed Conifer Forest (G225)
        // G225

        String level = "group";
        String code = "G225";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315A, 315H, 321A, 322A, 331B, 331G, 331J,
        // 331H, 331I, 341C, 341F, 341G, 342E, 342F, 342G, M341A, 313A, 313B,
        // 313C, M313, 342D, 342J, M331D, M331E, M331F, M331G, M331H, M331I,
        // M341B, M341C, 341A, 341B and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Acer grandidentatum,
        // Abies concolor, Picea pungens or Pseudotsuga menziesii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Picea engelmannii,
        // Pinus ponderosa, or Populus tremuloides (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%) 

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315A, 315H, 321A, 322A, 331B, 331G, 331J, 331H, 331I, 341C, 341F, 341G, 342E, 342F, 342G, M341A, 313A, 313B, 313C, M313, 342D, 342J, M331D, M331E, M331F, M331G, M331H, M331I, M341B, M341C, 341A, 341B");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Acer grandidentatum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_110() {

        // Southern Rocky Mountain Dry Mixed Conifer Forest & Woodland (G226)
        // G226

        String level = "group";
        String code = "G226";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313D, 315A, 315B, 315H, 322B, 331F, 331G,
        // 331H, 341C, 342F, 342G, 313A, 313B, 313C, M313, 321A, 322A, 341A,
        // 341B, 341F, 342D, 342E, 342J, 331B, 331I, 331J, M331D, M331E, M331F,
        // M331G, M331H, M331I, M341
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Abies concolor, Populus tremuloides, or Pseudotsuga menziesii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies lasiocarpa,
        // Abies lasiocarpa var. arizonica, Juniperus scopulorum,
        // Picea engelmannii, Picea pungens, Pinus flexilis, Pinus ponderosa,
        //  (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","313D, 315A, 315B, 315H, 322B, 331F, 331G, 331H, 341C, 342F, 342G, 313A, 313B, 313C, M313, 321A, 322A, 341A, 341B, 341F, 342D, 342E, 342J, 331B, 331I, 331J, M331D, M331E, M331F, M331G, M331H, M331I, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa var. arizonica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_111() {

        // Southern Rocky Mountain Ponderosa Pine Forest & Woodland (G103)
        // G103

        String level = "group";
        String code = "G103";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315F, 322B, 331C, 331N, 341A, 341C,
        // M331D, M331J, M341A, 313, 315A, 315B, 315H, 321A, 322A, M313,
        // 331B, 331F, 331G, 331H, 331I, 331J, 341B, 341F, 342A, 342E, 342F,
        // 342G, M331A, M331B, M331E, M331F, M331G, M331H, M331I, M341B, M341C
        // and tree composition dominated by the STRONG DIAGNOSTIC species
        // Pinus ponderosa or Quercus gambelii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Abies concolor, Juniperus deppeana, Juniperus scopulorum,
        // Pinus contorta, Pinus edulis, Pinus flexilis, Pinus longaeva,
        // Pinus strobiformis, Populus tremuloides, or Pseudotsuga menziesii
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
        // RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315F, 322B, 331C, 331N, 341A, 341C, M331D, M331J, M341A, 313, 315A, 315B, 315H, 321A, 322A, M313, 331B, 331F, 331G, 331H, 331I, 331J, 341B, 341F, 342A, 342E, 342F, 342G, M331A, M331B, M331E, M331F, M331G, M331H, M331I, M341B, M341C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Quercus gambelii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus deppeana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus edulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus longaeva");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus strobiformis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_112() {

        // Central Rocky Mountain Dry Lower Montane-Foothill Forest (M501)
        // M501

        String level = "macrogroup";
        String code = "M501";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, M242D, M332, M333, 331N, 342H, 331M,
        // 342B, 331E, 331A, 331K, 342D, M331A, 342A, 331G, M331B, 342C, M334A,
        // 342F, M331J, M331D, 331D, 342I, 331L, 342G, 331F, M331E,
        // AND ASPECT is between 157 and 203
        // AND tree composition dominated
        // by one or more of STRONG DRY DIAGNOSTIC species
        // Juniperus osteosperma, Juniperus scopulorum, Picea glauca, Pinus contorta, Pinus ponderosa, Populus tremuloides, Pseudotsuga menziesii
        // Pinus flexilis(RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer negundo, Betula papyrifera,
        // Fraxinus pennsylvanica, Picea engelmannii, Quercus macrocarpa,
        // or Ulmus americana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242D, M332, M333, 331N, 342H, 331M, 342B, 331E, 331A, 331K, 342D, M331A, 342A, 331G, M331B, 342C, M334A, 342F, M331J, M331D, 331D, 342I, 331L, 342G, 331F, M331E");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_113() {

        // Central Rocky Mountain Montane White Spruce Forest (G345)
        // G345

        String level = "group";
        String code = "G345";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M334A and tree composition dominated by one
        // or more of STRONG DIAGNOSTIC species Picea glauca or Populus tremuloides (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
        // Abies lasiocarpa, Picea engelmannii, Pinus contorta,
        // Pinus ponderosa or Pseudotsuga menziesii in any
        // combination of (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M334A");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_114() {

        // Black Hills-Northwestern Great Plains Ponderosa Pine Forest & Woodland (G216)
        // G216

        String level = "group";
        String code = "G216";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 331E, 331D, 331F, 331G, 331H, 331L, 331N,
        // 331M, 331K, M332Db, M332Dc, M331Ah, M331Ai, M331Ar, M331B, M334A,
        // 332D, 332C and tree
        // composition dominated by the STRONG DIAGNOSTIC species Pinus ponderosa
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Acer negundo, Betula papyrifera,
        // Fraxinus pennsylvanica, Juniperus scopulorum, Populus tremuloides,
        // Quercus macrocarpa, or Ulmus americana (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)
        // AND
        // iii. Located in above ECOREGION, and tree composition as above, but
        // with Pseudotsuga menziesii (<=1% RIV)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","331E, 331D, 331F, 331G, 331H, 331L, 331N, 331M, 331K, M332Db, M332Dc, M331Ah, M331Ai, M331Ar, M331B, M334A, 332D, 332C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Acer negundo");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Fraxinus pennsylvanica");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Quercus macrocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Ulmus americana");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> PSME_values = new HashMap<>();
        PSME_values.put("species","Pseudotsuga menziesii");
        PatternList PSME = new PatternList("PSME", PSME_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50) || 
           (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) && 
           (plot.match(ECOREGIONS) && plot.riv(PSME) <= 1)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_115() {

        // Rocky Mountain Foothill-Rock Outcrop Limber Pine - Juniper Woodland (G209)
        // G209

        String level = "group";
        String code = "G209";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M332A, M332B, M332E, M332F, M333C, M334A,
        // 341A, 341B, 342D, 331B, 331D, 331F, 331G, 331K, 331N, M332D, 342A,
        // 342E, 342F, 342G, M331A, M331B, M331D, M331E, M331H, M331I, M331J
        // and tree composition dominated by one
        // or more of STRONG DIAGNOSTIC species Juniperus osteosperma,
        // Juniperus scopulorum or Pinus flexilis (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of [PLACEHOLDER - INSERT P2 VEG] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M332A, M332B, M332E, M332F, M333C, M334A, 341A, 341B, 342D, 331B, 331D, 331F, 331G, 331K, 331N, M332D, 342A, 342E, 342F, 342G, M331A, M331B, M331D, M331E, M331H, M331I, M331J");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","PLACEHOLDER - INSERT P2 VEG");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_116() {

        // Central Rocky Mountain Ponderosa Pine Forest & Woodland (G213)
        // G213

        String level = "group";
        String code = "G213";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M261G, 331D, 342A, 342B, 342F, 342G, M331J,
        // M242C, M242D - only eastern ecosubsections M242Dd, M242De, M242Df,
        // M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332,
        // M333, M331A, M331B, M331D and tree
        // composition dominated by the STRONG DIAGNOSTIC species
        // Pinus ponderosa (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Pinus flexilis (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)
        // AND
        // iii. Located in above ECOREGION, and tree composition as above, but
        // with Pseudotsuga menziesii (<=10% RIV)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M261G, 331D, 342A, 342B, 342F, 342G, M331J, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332, M333, M331A, M331B, M331D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> PSME_values = new HashMap<>();
        PSME_values.put("species","Pseudotsuga menziesii");
        PatternList PSME = new PatternList("PSME", PSME_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50) || 
           (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) && 
           (plot.match(ECOREGIONS) && plot.riv(PSME) <= 10)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_117() {

        // Central Rocky Mountain Mesic-Moist Mixed Conifer Forest (G215)
        // G215

        String level = "group";
        String code = "G215";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 331A, 331E, 331F, 331M, M331E, M332G, M333C,
        // M333D, 331D, 331G, 331K, 331L, 331N, 342A, 342D, 342E, 342F, 342G,
        // M332A, M332B, M332D, M332E, M332F, M331A, M331B, M331D, M331J
        // and tree composition
        // dominated by the STRONG DIAGNOSTIC species Pinus contorta, Pseudotsuga menziesii or Populus tremuloides
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Juniperus osteosperma, Juniperus scopulorum, Picea engelmannii, or Pinus flexilis (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","331A, 331E, 331F, 331M, M331E, M332G, M333C, M333D, 331D, 331G, 331K, 331L, 331N, 342A, 342D, 342E, 342F, 342G, M332A, M332B, M332D, M332E, M332F, M331A, M331B, M331D, M331J");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus osteosperma");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_118() {

        // Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)
        // G210

        String level = "group";
        String code = "G210";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M261G, 331D, 342A, 342B, 342F, 342G, M331J,
        // M242C, M242D - only eastern ecosubsections M242Dd, M242De, M242Df,
        // M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332,
        // M333, M331A, M331B, M331D and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Pinus contorta, Pinus ponderosa, Picea engelmannii, or
        // Pseudotsuga menziesii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Larix occidentalis`, Pinus monticola,
        // or Picea glauca (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M261G, 331D, 342A, 342B, 342F, 342G, M331J, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332, M333, M331A, M331B, M331D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_119() {

        // Central Rocky Mountain Mesic Lower Montane Forest (M500)
        // M500

        String level = "macrogroup";
        String code = "M500";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, M242D, 331N, 342H, M332, M333, 331A,
        // 331K, 342D, M331A, M331B, 342A, 331G, 342F, M331J, M331D, 331D,
        // 342I, 342G, AND tree composition
        // dominated by one or more of STRONG MESIC DIAGNOSTIC species
        // Abies grandis, Larix occidentalis, Pseudotsuga menziesii,
        // Thuja plicata, or Tsuga heterophylla (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species
        // in any combination of Abies lasiocarpa, Betula papyrifera,
        // Picea engelmannii, Picea glauca, Pinus contorta, Pinus monticola,
        // Pinus ponderosa, or Populus tremuloides
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
        // [Additional tree species not tracked by FIA include
        // Picea engelmannii x glauca]

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242D, 331N, 342H, M332, M333, 331A, 331K, 342D, M331A, M331B, 342A, 331G, 342F, M331J, M331D, 331D, 342I, 342G");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea glauca");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_120() {

        // East Cascades Moist-Mesic Grand Fir - Douglas-fir Forest (G212)
        // G212

        String level = "group";
        String code = "G212";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M261D, M261E, M261G, 342H, 342I, M242C,
        // M242D - only eastern ecosubsections M242Dd, M242De, M242Df, M242Dg,
        // M242Dh and tree composition dominated
        // by one or more of STRONG MESIC DIAGNOSTIC species Abies grandis or
        // Pseudotsuga menziesii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE MESIC DIAGNOSTIC species in any
        // combination of Larix occidentalis, Pinus contorta, Pinus monticola,
        // Tsuga heterophylla or Thuja plicata (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M261D, M261E, M261G, 342H, 342I, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_121() {

        // Central Rocky Mountain-Interior Cedar - Hemlock Forest (G217)
        // G217

        String level = "group";
        String code = "G217";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, M332F, M332G, 331D, 342I, M333, 331A,
        // M332A, M332B, M242D - only eastern ecosubsections M242Dd, M242De,
        // M242Df, M242Dg, M242Dh and
        // tree composition dominated by the STRONG DIAGNOSTIC species
        // Tsuga heterophylla or Thuja plicata (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Abies grandis, Abies lasiocarpa, Larix occidentalis,
        // Picea engelmannii, Pinus contorta, Pinus monticola, Pinus ponderosa
        // or Pseudotsuga menziesii (>=30% RIV; i.e., together STRONG and
        // MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M332F, M332G, 331D, 342I, M333, 331A, M332A, M332B, M242Dd, M242De, M242Df, M242Dg, M242Dh");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_122() {

        // Central Rocky Mountain-Interior Mesic Grand Fir - Douglas-fir - Western Larch Forest (G211)
        // G211

        String level = "group";
        String code = "G211";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, 331D, 331G, 331N, 342A, 342D, 342E,
        // 342F, 342G, 342I, M331J, M242D - only eastern ecosubsections M242Dd,
        // M242De, M242Df, M242Dg, M242Dh, 331A, 331K, 342H, M332, M331A, M331B,
        // M331D, M333 and tree
        // composition dominated by one or more of STRONG MESIC DIAGNOSTIC
        // species Abies grandis, Pseudotsuga menziesii, or Larix occidentalis
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE MESIC DIAGNOSTIC species in any
        // combination of Abies lasiocarpa, Picea engelmannii, Pinus contorta,
        // Pinus monticola, Thuja plicata or Tsuga heterophylla (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, 331D, 331G, 331N, 342A, 342D, 342E, 342F, 342G, 342I, M331J, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331K, 342H, M332, M331A, M331B, M331D, M333");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies grandis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Larix occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Thuja plicata");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_123() {

        // Western Cordilleran Subalpine-High Montane Forest & Woodland (D336)
        // D336

        String level = "division";
        String code = "D336";

        // Tree composition and ecology matching one of the following options:
        // i.  Elevation above 2100 meters and located in 242A, 242B, 242C, M242A, M242B, M242C,
        //   M242D, M261; 313A, 313B, 313C, M313, 315A, 315H, 321A, 322A, 322B, 331, M331,
        //   M332, M333, M334, 341, M341, 342
        // AND
        // ii.  EITHER
        //     d.  Tree composition dominated by one or more of STRONG diagnostic tree 
        //     species Abies amabilis, Abies concolor, Abies lasiocarpa, Abies magnifica, Abies procera, 
        //     Abies shastensis [Abies magnifica var. shastensis], Betula papyrifera, 
        //     Juniperus grandis, Larix lyallii Picea engelmannii, Pinus albicaulis, 
        //     Pinus contorta, Pinus flexilis, Populus tremuloides, Pseudotsuga menziesii, or Tsuga mertensiana  
        //     (=>50% RIV)
        //     OR
        //     e.  The above tree species, but with =>20% RIV AND other MODERATE diagnostic
        //     species of Callitropsis nootkatensis , Pinus balfouriana, Pinus flexilis,
        //     Pinus jeffreyi, Pinus monticola, or Tsuga heterophylla
        //     (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        //     OR
        //     f.  Any EXOTIC = yes tree species =>80% RIV

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242A, 242B, 242C, M242A, M242B, M242C, M242D, M261; 313A, 313B, 313C, M313, 315A, 315H, 321A, 322A, 322B, 331, M331, M332, M333, M334, 341, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies procera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica var. shastensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus albicaulis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Callitropsis nootkatensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus balfouriana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        Map<String,String> EXOTIC_TREE_SPP_values = new HashMap<>();
        EXOTIC_TREE_SPP_values.put("exotic","yes");
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_values);

        INodeMatch match = plot -> (
            plot.get_elevation() > 2100 && plot.match(ECOREGIONS) && 
           ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && 
           plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) || 
           plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_124() {

        // Rocky Mountain Subalpine-High Montane Forest (M020)
        // M020

        String level = "macrogroup";
        String code = "M020";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh,
        // M333, M334, 331, M331, 342, M332, 313A,
        // 313B, M313, M341, 341, 322A, 315A, 315B, 315H, AND
        // tree composition dominated by one or more of STRONG DIAGNOSTIC species
        // Abies lasiocarpa, Larix lyallii, Picea engelmannii, Pinus albicaulis,
        // Pinus contorta, Pinus flexilis,
        // Betula papyrifera, Populus tremuloides, or Tsuga mertensiana (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above,
        // but with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies concolor, Juniperus scopulorum, Picea pungens,
        // Pinus ponderosa, or Pseudotsuga menziesii
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M333, M334, 331, M331, 342, M332, 313A, 313B, M313, M341, 341, 322A, 315A, 315B, 315H");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Larix lyallii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus albicaulis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea pungens");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_125() {

        // Rocky Mountain-Interior Subalpine-Montane Aspen Forest (G222)
        // G222

        String level = "group";
        String code = "G222";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313C, 315A, 315H, 321A, 322A, 322B, M242B,
        // M261A, M261D, M242C, M242D – only eastern ecosubsections M242Dd,
        // M242De, M242Df, M242Dg, M242Dh, M261E, M261G, 313A, 313B, 331, 341,
        // 342, M332, M313, M331, M341, M333, M334
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Populus tremuloides or Betula papyrifera (RIV=>75%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","313C, 315A, 315H, 321A, 322A, 322B, M242B, M261A, M261D, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M261E, M261G, 313A, 313B, 331, 341, 342, M332, M313, M331, M341, M333, M334");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Betula papyrifera");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 75
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_126() {

        // Rocky Mountain Subalpine Moist-Mesic Spruce - Fir Forest (G218)
        // G218

        String level = "group";
        String code = "G218";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313A, 313B, 322A, M313, 341A, 341B, 341F,
        // 341G, 331A, 331B, 331D, 331G, 331H, 331I, 331J, 331K, M242C, M242D –
        // only eastern ecosubsections M242Dd, M242De, M242Df, M242Dg, M242Dh,
        // M261D, M332, M331, 342, M333, M341B, M341C
        // and tree composition dominated by one
        // or more of STRONG MESIC TO WET DIAGNOSTIC species Abies lasiocarpa or
        // Picea engelmannii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE MESIC TO WET DIAGNOSTIC species
        // in any combination of Populus tremuloides, Pseudotsuga menziesii or Tsuga mertensiana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","313A, 313B, 322A, M313, 341A, 341B, 341F, 341G, 331A, 331B, 331D, 331G, 331H, 331I, 331J, 331K, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M261D, M332, M331, 342, M333, M341B, M341C");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_127() {

        // Rocky Mountain Subalpine Dry-Mesic Spruce - Fir Forest (G219)
        // G219

        String level = "group";
        String code = "G219";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242B, M261D, M313B, 313C, 315H, 322A,
        // M242C, M242D – only eastern ecosubsections M242Dd, M242De, M242Df,
        // M242Dg, M242Dh, 313A, 313B, M313A, 342, 341, M331, 331, M332, M333,
        // M341 and tree composition dominated by one or more of STRONG DRY
        // TO MESIC DIAGNOSTIC species Abies lasiocarpa or Picea engelmannii
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DRY TO MESIC DIAGNOSTIC species
        // in any combination of Pinus contorta, Pseudotsuga menziesii, or Populus tremuloides
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242B, M261D, M313B, 313C, 315H, 322A, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 313A, 313B, M313A, 342, 341, M331, 331, M332, M333, M341");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_128() {

        // Rocky Mountain Lodgepole Pine Forest & Woodland (G220)
        // G220

        String level = "group";
        String code = "G220";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242B, 313B, 341B, M242C, M242D – only
        // eastern ecosubsections M242Dd, M242De, M242Df, M242Dg, M242Dh,
        // M332, M333, 342, M331, 331
        // and tree composition dominated by the STRONG DIAGNOSTIC species
        // Pinus contorta (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Abies concolor, Abies lasiocarpa, Picea engelmannii, Pinus ponderosa,
        // Pseudotsuga menziesii, Populus tremuloides (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242B, 313B, 341B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh,  M332, M333, 342, M331, 331");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_129() {

        // Rocky Mountain Limber Pine Subalpine-Montane Woodland (G101)
        // G101

        String level = "group";
        String code = "G101";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315A, 313A, 313B, 313C, 322A, 341B, 341G,
        // M313B, M333C, M261E, M313A, 331, M332, M331, M341, 342 and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Pinus flexilis (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus scopulorum, Picea engelmannii,
        // Pinus contorta, Pinus ponderosa, Pseudotsuga menziesii,
        // Abies concolor, Pinus albicaulis, Pinus balfouriana,
        // Pinus monophylla, and Populus tremuloides (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","315A, 313A, 313B, 313C, 322A, 341B, 341G, M313B, M333C, M261E, M313A, 331, M332, M331, M341, 342");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Juniperus scopulorum");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus ponderosa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus albicaulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus balfouriana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monophylla");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Populus tremuloides");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_130() {

        // Central Rocky Mountain Whitebark Pine - Subalpine Larch Forest & Woodland (G223)
        // G223

        String level = "group";
        String code = "G223";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 331A, 331D, 331K, 331N, M261G, M242B,
        // M242C, M242D – only eastern ecosubsections M242Dd, M242De, M242Df,
        // M242Dg, M242Dh, 341G, 342, M331A, M331B, M331D, M331J, M332, M333
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Pinus albicaulis, Abies lasiocarpa, or
        // Larix lyallii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
        // Picea engelmannii or Pseudotsuga menziesii in any combination of (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","331A, 331D, 331K, 331N, M261G, M242B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 341G, 342, M331A, M331B, M331D, M331J, M332, M333");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus albicaulis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Larix lyallii");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pseudotsuga menziesii");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_131() {

        // Vancouverian Subalpine-High Montane Forest (M025)
        // M025

        String level = "macrogroup";
        String code = "M025";

        // Plot location and tree composition are as follows:
        // STRONG DIAGNOSTICS RIV 50% or more
        // NO EXCLUSIONS
        // i. Located in ECOREGION M242A, M242B, M242C, M242Dd, M242De, M242Df, M242Dg,
        // M242Dh, 242, M261, 263, 341D, AND tree composition dominated by one or more of
        // STRONG MESIC DIAGNOSTIC species Abies amabilis, Abies magnifica, Abies shastensis,
        // Abies magnifica var. shastensis], Abies procera, Callitropsis nootkatensis,
        // Juniperus occidentalis, Pinus albicaulis, Pinus balfouriana, Pinus contorta,
        // Pinus monticola, or Tsuga mertensiana (RIV=>50%),
        // OR
        // STRONG DIAGNOSTICS RIV 20% or more + MODERATE DIAGNOSTICS RIV 30% or more
        // NO EXCLUSIONS
        // ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV,
        // AND with other MODERATE MESIC DIAGNOSTIC  species in any combination of
        // Pinus flexilis, Pinus jeffreyi or Tsuga heterophylla [PLACEHOLDER - INSERT P2
        // DIAGNOSTIC SPECIES] (>=30% RIV; i.e., together STRONG and MODERATE diagnostic
        // species RIV =>50%)
        // OR
        // M242Db, M242Dd, M242De, M242Df, M242Dg, M242Dh subsections Exclusion/Exception for
        // Abies lasiocarpa and  Picea engelmannii
        // Tree composition and ecology matching one of the following options:
        // iii. Located in ECOREGION M242A, M242B, M242C, M242Da, M242Db, 242, M261, 263, 341D,
        // AND
        // iv. EITHER
        // a. Tree composition dominated by one or more of STRONG MESIC DIAGNOSTIC species
        // Abies amabilis,  Abies lasiocarpa, Abies magnifica, Abies shastensis,
        // Abies magnifica var. shastensis, Abies procera, Callitropsis nootkatensis,
        // Juniperus occidentalis, Pinus albicaulis, Pinus balfouriana, Pinus contorta,
        // Pinus monticola, or Tsuga mertensiana (RIV=>50%),
        // OR
        // b. The above tree species, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC
        // species in any combination of  Pinus flexilis, Pinus jeffreyi, Abies concolor or
        // Tsuga heterophylla [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_1_values = new HashMap<>();
        ECOREGIONS_1_values.put("ecoregion","M242A, M242B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 242, M261, 263, 341D");
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_values);

        Map<String,String> ECOREGIONS_2_values = new HashMap<>();
        ECOREGIONS_2_values.put("ecoregion","M242Db, M242A, M242B, M242C, M242Da, M242Db, 242, M261, 263, 341D");
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_1_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Abies magnifica var. shastensis");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Abies procera");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Callitropsis nootkatensis");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Pinus albicaulis");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Pinus balfouriana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Pinus monticola");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Tsuga mertensiana");
        STRONG_DIAGNOSTIC_SPECIES_1_values.put("species","Juniperus occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES_1 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_1", STRONG_DIAGNOSTIC_SPECIES_1_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_2_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Abies lasiocarpa");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Abies magnifica var. shastensis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Abies procera");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Callitropsis nootkatensis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus albicaulis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus balfouriana");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus monticola");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Tsuga mertensiana");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Juniperus occidentalis");
        STRONG_DIAGNOSTIC_SPECIES_2_values.put("species","Picea engelmannii");
        PatternList STRONG_DIAGNOSTIC_SPECIES_2 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_2", STRONG_DIAGNOSTIC_SPECIES_2_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_1_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_1_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_1_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_1_values.put("species","Tsuga heterophylla");
        PatternList MODERATE_DIAGNOSTIC_SPECIES_1 = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_1", MODERATE_DIAGNOSTIC_SPECIES_1_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_2_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_2_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_2_values.put("species","Tsuga heterophylla");
        MODERATE_DIAGNOSTIC_SPECIES_2_values.put("species","Abies concolor");
        PatternList MODERATE_DIAGNOSTIC_SPECIES_2 = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_2", MODERATE_DIAGNOSTIC_SPECIES_2_values);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50) ||
           (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES_1) >= 30) ||
           (plot.match(ECOREGIONS_2) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 50) ||
           (plot.match(ECOREGIONS_2) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES_2) >= 30)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_132() {

        // Sierra-Cascade Cold-Dry Subalpine Woodland (G243)
        // G243

        String level = "group";
        String code = "G243";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 342B, M242D, M242B, M242C, M261, 341D
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Juniperus occidentalis, Pinus albicaulis, or
        // Pinus contorta (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies lasiocarpa, Pinus balfouriana, Pinus flexilis,
        // or Pinus monticola (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","342B, M242D, M242B, M242C, M261, 341D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus albicaulis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Juniperus occidentalis");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus balfouriana");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus flexilis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_133() {

        // Sierra-Cascade Red Fir - Mountain Hemlock Forest (G749)
        // G749

        String level = "group";
        String code = "G749";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 242B, 342B, M242B, M242C, M261, 341D
        // and tree composition dominated by one or more of STRONG
        // DIAGNOSTIC species Abies magnifica, Abies shastensis [Abies
        // magnifica var. shastensis], Abies lasiocarpa, Abies procera, or Tsuga mertensiana
        // (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies concolor, Pinus albicaulis, Pinus contorta,
        // Pinus jeffreyi, or Pinus monticola (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","242B, 342B, M242B, M242C, M261, 341D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies magnifica var. shastensis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies procera");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus albicaulis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus contorta");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus jeffreyi");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Pinus monticola");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies concolor");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_134() {

        // North-Central Pacific Mountain Hemlock - Silver Fir Woodland (G849)
        // G849

        String level = "group";
        String code = "G849";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M242C, M261B, 242A, M242A, M242B, M242D
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Abies amabilis, Picea engelmannii, or
        // Tsuga mertensiana (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Abies lasiocarpa, Callitropsis nootkatensis,
        // or Tsuga heterophylla (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        Map<String,String> ECOREGIONS_values = new HashMap<>();
        ECOREGIONS_values.put("ecoregion","M242C, M261B, 242A, M242A, M242B, M242D");
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_values);

        Map<String,String> STRONG_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Abies amabilis");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Picea engelmannii");
        STRONG_DIAGNOSTIC_SPECIES_values.put("species","Tsuga mertensiana");
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_values);

        Map<String,String> MODERATE_DIAGNOSTIC_SPECIES_values = new HashMap<>();
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Abies lasiocarpa");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Callitropsis nootkatensis");
        MODERATE_DIAGNOSTIC_SPECIES_values.put("species","Tsuga heterophylla");
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_values);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

}
