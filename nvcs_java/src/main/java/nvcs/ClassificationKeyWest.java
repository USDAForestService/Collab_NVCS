package nvcs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nvcs_components.ClassificationKey;
import nvcs_components.KeyValue;
import nvcs_components.Node;
import nvcs_interfaces.INodeMatch;
import nvcs_patterns.Pattern;
import nvcs_patterns.PatternList;

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
        Pattern.register("afforestation_cd", "Pattern");
        Pattern.register("land_cover_class_cd", "Pattern");
        Pattern.register("land_cover_class_cd_ret", "Pattern");
        Pattern.register("trtcd1", "Pattern");
        Pattern.register("trtcd2", "Pattern");
        Pattern.register("trtcd3", "Pattern");

        nodes = new LinkedHashMap<>();
        root_node = _setup();
        super.root_node = root_node;
    }

    public Node _setup() {
        nodes.put(0, new Node(0, null, element_000(), ""));
        nodes.put(  1,  new Node(  1,   0, element_001(), "Test No to Low Trees"));
        nodes.put(  2,  new Node(  2,   1, element_002(), "live canopy cover over 10"));
        nodes.put(  3,  new Node(  3,   1, element_003(), "Western North American Grassland & Shrubland (D022)"));
        nodes.put(  4,  new Node(  4,   1, element_004(), "low vegetative cover"));
        nodes.put(  5,  new Node(  5,   0, element_005(), "Forest Plantations"));
        nodes.put(  6,  new Node(  6,   0, element_006(), "Natural (including ruderal) Forests (C01)"));
        nodes.put(  7,  new Node(  7,   6, element_007(), "Wetland Forest & Woodlands"));
        nodes.put(  8,  new Node(  8,   7, element_008(), "Temperate Flooded & Swamp Forest Formation (F026)"));
        nodes.put(  9,  new Node(  9,   8, element_009(), "Great Plains Temperate Flooded & Swamp Forests (F026)"));
        nodes.put( 10,  new Node( 10,   9, element_010(), "Eastern North American-Great Plains Flooded & Swamp Forest Division (D011)"));
        nodes.put( 11,  new Node( 11,  10, element_011(), "Great Plains Flooded & Swamp Forest (M028)"));
        nodes.put( 12,  new Node( 12,  11, element_012(), "Great Plains Cottonwood - Willow Floodplain Forest (G147)"));
        nodes.put( 13,  new Node( 13,  10, element_013(), "Eastern North American Ruderal Flooded & Swamp Forest (M302)"));
        nodes.put( 14,  new Node( 14,   9, element_014(), "Southeastern North American Flooded & Swamp Forest Division (D062)"));
        nodes.put( 15,  new Node( 15,  14, element_015(), "Southern Great Plains Floodplain Forest & Woodland (M154)"));
        nodes.put( 16,  new Node( 16,  15, element_016(), "Southeastern Great Plains Floodplain Forest (G784)"));
        nodes.put( 17,  new Node( 17,  14, element_017(), "Southeastern North American Ruderal Flooded & Swamp Forest (M310)"));
        nodes.put( 18,  new Node( 18,   8, element_018(), "Western North American Temperate Flooded & Swamp Forests (F026)"));
        nodes.put( 19,  new Node( 19,  18, element_019(), "North Pacific Forested Wetland (D193)"));
        nodes.put( 20,  new Node( 20,  19, element_020(), "North Pacific Forested Wetland(M035)"));
        nodes.put( 21,  new Node( 21,  20, element_021(), "North-Central Pacific Montane Riparian & Seepage Swamp Forest (G507)"));
        nodes.put( 22,  new Node( 22,  20, element_022(), "North-Central Pacific Maritime Lowland Swamp (G853)"));
        nodes.put( 23,  new Node( 23,  20, element_023(), "North-Central Pacific Lowland Riparian Forest (G851)"));
        nodes.put( 24,  new Node( 24,  19, element_024(), "North Pacific Forested Wetland Ruderal Forests (D193)"));
        nodes.put( 25,  new Node( 25,  18, element_025(), "Rocky Mountain-Great Basin Montane Flooded & Swamp Forest Division (D195)"));
        nodes.put( 26,  new Node( 26,  25, element_026(), "Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)"));
        nodes.put( 27,  new Node( 27,  26, element_027(), "Rocky Mountain-Great Basin Swamp Forest (G505)"));
        nodes.put( 28,  new Node( 28,  26, element_028(), "Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (G506)"));
        nodes.put( 29,  new Node( 29,  26, element_029(), "Central Rocky Mountain Lowland & Foothill Riparian Forest (G796)"));
        nodes.put( 30,  new Node( 30,  25, element_030(), "Rocky Mountain-Great Basin Montane Ruderal Flooded & Swamp Forest (D195)"));
        nodes.put( 31,  new Node( 31,  18, element_031(), "Western North American Arid Flooded Forest (D013)"));
        nodes.put( 32,  new Node( 32,  31, element_032(), "Western Arid Lowland Flooded Forest (M036)"));
        nodes.put( 33,  new Node( 33,  32, element_033(), "Tamaulipan Flooded Forest (G549)"));
        nodes.put( 34,  new Node( 34,  32, element_034(), "Californian Mediterranean Riparian Forest (G113)"));
        nodes.put( 35,  new Node( 35,  32, element_035(), "Southwest Warm Desert Riparian Forest (G109)"));
        nodes.put( 36,  new Node( 36,  32, element_036(), "Great Basin-Colorado Plateau Semi-Desert Riparian Forest (G107)"));
        nodes.put( 37,  new Node( 37,  31, element_037(), "Western Arid Ruderal Riparian Forest & Scrub (M298)"));
        nodes.put( 38,  new Node( 38,   6, element_038(), "Upland Forest & Woodlands"));
        nodes.put( 39,  new Node( 39,  38, element_039(), "Temperate & Boreal Forest & Woodland Subclass (B02)"));
        nodes.put( 40,  new Node( 40,  39, element_040(), "Great Plains Temperate Forests"));
        nodes.put( 41,  new Node( 41,  40, element_041(), "North American Great Plains Forest & Woodland Division (D322)"));
        nodes.put( 42,  new Node( 42,  41, element_042(), "Southern Great Plains Forest & Woodland (M544)"));
        nodes.put( 43,  new Node( 43,  42, element_043(), "Cross Timbers Woodland (G887)"));
        nodes.put( 44,  new Node( 44,  42, element_044(), "Edwards Plateau Dry-Mesic Hardwood Forest (G028)"));
        nodes.put( 45,  new Node( 45,  42, element_045(), "Edwards Plateau Dry Woodland (G126)"));
        nodes.put( 46,  new Node( 46,  41, element_046(), "Northern Great Plains Forest & Woodland (M545)"));
        nodes.put( 47,  new Node( 47,  46, element_047(), "Great Plains Bur Oak Forest & Woodland(G329)"));
        nodes.put( 48,  new Node( 48,  46, element_048(), "Northern Tallgrass Oak Aspen Woodland (G146)"));
        nodes.put( 49,  new Node( 49,  46, element_049(), "Northwestern Great Plains Aspen Woodland (G328)"));
        nodes.put( 50,  new Node( 50,  46, element_050(), "Northern Great Plains Mesic Forest & Woodland (G145)"));
        nodes.put( 51,  new Node( 51,  41, element_051(), "Great Plains Ruderal Woodland (M524)"));
        nodes.put( 52,  new Node( 52,  41, element_052(), "LC Southern Great Plains Forest & Woodland (M544LC)"));
        nodes.put( 53,  new Node( 53,  41, element_053(), "LC Northern Great Plains Forest & Woodland (M545LC)"));
        nodes.put( 54,  new Node( 54,  40, element_054(), "Southeastern North American Forest & Woodland Division (D006)"));
        nodes.put( 55,  new Node( 55,  54, element_055(), "Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)"));
        nodes.put( 56,  new Node( 56,  55, element_056(), "Southeast Maritime Live Oak - Palmetto Forest (G798)"));
        nodes.put( 57,  new Node( 57,  55, element_057(), "Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)"));
        nodes.put( 58,  new Node( 58,  54, element_058(), "Southeastern North American Ruderal Forest (M305)"));
        nodes.put( 59,  new Node( 59,  40, element_059(), "Eastern North American Forest & Woodland Division (D008)"));
        nodes.put( 60,  new Node( 60,  59, element_060(), "Eastern North American Forest & Woodland Natural Forests (D008)"));
        nodes.put( 61,  new Node( 61,  60, element_061(), "Central Midwest Oak Forest, Woodland & Savanna (M012)"));
        nodes.put( 62,  new Node( 62,  61, element_062(), "Midwest Oak Hickory Forest (G990)"));
        nodes.put( 63,  new Node( 63,  60, element_063(), "South - Central Oak - Pine Forest & Woodland (M540)"));
        nodes.put( 64,  new Node( 64,  63, element_064(), "West Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)"));
        nodes.put( 65,  new Node( 65,  59, element_065(), "Eastern North American Ruderal Forests (D008)"));
        nodes.put( 66,  new Node( 66,  65, element_066(), "Eastern North American Ruderal Forest (M013)"));
        nodes.put( 67,  new Node( 67,  39, element_067(), "Western North American Temperate Forests"));
        nodes.put( 68,  new Node( 68,  67, element_068(), "Warm Temperate Forest & Woodland (S54)"));
        nodes.put( 69,  new Node( 69,  68, element_069(), "Californian Forest & Woodland Division (D007)"));
        nodes.put( 70,  new Node( 70,  69, element_070(), "Californian Forest & Woodland (M009)"));
        nodes.put( 71,  new Node( 71,  70, element_071(), "Californian Conifer Forest & Woodland (G198)"));
        nodes.put( 72,  new Node( 72,  70, element_072(), "Californian Broadleaf Forest & Woodland (G195)"));
        nodes.put( 73,  new Node( 73,  69, element_073(), "Californian Ruderal Forest (M513)"));
        nodes.put( 74,  new Node( 74,  68, element_074(), "Madrean Forest & Woodland Division (D331)"));
        nodes.put( 75,  new Node( 75,  74, element_075(), "Madrean Natural Forests & Woodlands (D331)"));
        nodes.put( 76,  new Node( 76,  75, element_076(), "Madrean Lowland Evergreen Woodland (M010)"));
        nodes.put( 77,  new Node( 77,  76, element_077(), "Madrean Pinyon - Juniper Woodland (G200)"));
        nodes.put( 78,  new Node( 78,  76, element_078(), "Madrean Encinal (G201)"));
        nodes.put( 79,  new Node( 79,  76, element_079(), "Madrean Juniper Open Woodland (G487)"));
        nodes.put( 80,  new Node( 80,  75, element_080(), "Madrean Montane Forest & Woodland (M011)"));
        nodes.put( 81,  new Node( 81,  80, element_081(), "Madrean Upper Montane Conifer - Oak Forest & Woodland (G202)"));
        nodes.put( 82,  new Node( 82,  80, element_082(), "Madrean Lower Montane Pine - Oak Forest & Woodland (G203)"));
        nodes.put( 83,  new Node( 83,  74, element_083(), "Western North American Ruderal Forests - Madrean-Balconian (D060)"));
        nodes.put( 84,  new Node( 84,  74, element_084(), "LC Madrean Montane Forest & Woodland (M011LC)"));
        nodes.put( 85,  new Node( 85,  67, element_085(), "Cool Temperate Forest & Woodland Subbiome(S92)"));
        nodes.put( 86,  new Node( 86,  85, element_086(), "North American Pacific Coast Temperate Rainforest (D338)"));
        nodes.put( 87,  new Node( 87,  86, element_087(), "North Pacific Coastal Rainforest (M024)"));
        nodes.put( 88,  new Node( 88,  87, element_088(), "Coastal Redwood Forest (G235)"));
        nodes.put( 89,  new Node( 89,  87, element_089(), "Coastal Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)"));
        nodes.put( 90,  new Node( 90,  87, element_090(), "Coastal Douglas-fir - Western Hemlock Rainforest (G240)"));
        nodes.put( 91,  new Node( 91,  87, element_091(), "Coastal Silver Fir - Western Hemlock Rainforest(G241)"));
        nodes.put( 92,  new Node( 92,  87, element_092(), "Coastal Western Hemlock - Sitka Spruce Rainforest (G751)"));
        nodes.put( 93,  new Node( 93,  85, element_093(), "Western North American Pinyon-Juniper Woodland & Scrub Division (D010)"));
        nodes.put( 94,  new Node( 94,  93, element_094(), "Intermountain Pinyon-Juniper Woodland (M896)"));
        nodes.put( 95,  new Node( 95,  94, element_095(), "Intermountain Western Juniper Open Woodland (G248)"));
        nodes.put( 96,  new Node( 96,  94, element_096(), "Intermountain Basins Curl-leaf Mountain-mahogany Woodland & Scrub (G249)"));
        nodes.put( 97,  new Node( 97,  94, element_097(), "Great Basin Pinyon - Juniper Woodland (G899)"));
        nodes.put( 98,  new Node( 98,  94, element_098(), "Colorado Plateau Pinyon - Juniper Woodland (G900)"));
        nodes.put( 99,  new Node( 99,  94, element_099(), "Intermountain Utah Juniper Open Woodland (G105)"));
        nodes.put(100,  new Node(100,  93, element_100(), "Southern Rocky Mountain Two-needle Pinyon-Juniper Woodland (M897)"));
        nodes.put(101,  new Node(101, 100, element_101(), "Southern Rocky Mountain Pinyon - Juniper Woodland (G253)"));
        nodes.put(102,  new Node(102, 100, element_102(), "Southern Rocky Mountain Juniper Open Woodland (G252)"));
        nodes.put(103,  new Node(103,  93, element_103(), "LC Intermountain Pinyon-Juniper Woodland (M896LC)"));
        nodes.put(104,  new Node(104,  85, element_104(), "Californian-North Pacific Foothills Forest & Woodland (D339)"));
        nodes.put(105,  new Node(105, 104, element_105(), "Californian-North Pacific Vancouverian Dry Foothill Forest & Woodland (M886)"));
        nodes.put(106,  new Node(106, 105, element_106(), "Cascadian Oregon White Oak - Conifer Forest & Woodland (G206)"));
        nodes.put(107,  new Node(107, 105, element_107(), "Californian Moist Coastal Mixed Evergreen Forest (G208)"));
        nodes.put(108,  new Node(108, 105, element_108(), "North Pacific Douglas-fir - Madrone Dry Woodland (G800)"));
        nodes.put(109,  new Node(109, 105, element_109(), "Coastal Shore Pine Forest & Woodland (G205)"));
        nodes.put(110,  new Node(110, 104, element_110(), "Sierran-Californian Montane-Foothill Forest & Woodland (M023)"));
        nodes.put(111,  new Node(111, 110, element_111(), "Californian Montane Conifer Forest & Woodland (G344)"));
        nodes.put(112,  new Node(112, 104, element_112(), "Vancouverian Ruderal Forest (M405)"));
        nodes.put(113,  new Node(113, 112, element_113(), "North Pacific Ruderal Forest (G801)"));
        nodes.put(114,  new Node(114, 104, element_114(), "LC Californian-North Pacific Vancouverian Dry Foothill Forest & Woodland (M886LC)"));
        nodes.put(115,  new Node(115,  85, element_115(), "Rocky Mountain Foothills & Montane Forest & Woodland (D337)"));
        nodes.put(116,  new Node(116, 115, element_116(), "Southern Rocky Mountain Montane Forest & Woodland (M022)"));
        nodes.put(117,  new Node(117, 116, element_117(), "Southern Rocky Mountain Bristlecone Pine Forest & Woodland (G102)"));
        nodes.put(118,  new Node(118, 116, element_118(), "Southern Rocky Mountain Mesic-Moist Mixed Conifer Forest (G225)"));
        nodes.put(119,  new Node(119, 116, element_119(), "Southern Rocky Mountain Dry Mixed Conifer Forest & Woodland (G226)"));
        nodes.put(120,  new Node(120, 116, element_120(), "Southern Rocky Mountain Ponderosa Pine Forest & Woodland (G103)"));
        nodes.put(121,  new Node(121, 115, element_121(), "Central Rocky Mountain Montane Forest & Woodland (M501)"));
        nodes.put(122,  new Node(122, 121, element_122(), "Central Rocky Mountain Montane White Spruce Forest (G345)"));
        nodes.put(123,  new Node(123, 121, element_123(), "Black Hills-Northwestern Great Plains Ponderosa Pine Forest & Woodland (G216)"));
        nodes.put(124,  new Node(124, 121, element_124(), "Rocky Mountain Foothill-Rock Outcrop Limber Pine - Juniper Woodland (G209)"));
        nodes.put(125,  new Node(125, 121, element_125(), "Central Rocky Mountain Ponderosa Pine Forest & Woodland (G213)"));
        nodes.put(126,  new Node(126, 121, element_126(), "Central Rocky Mountain Douglas-fir Mesic Forest (G215)"));
        nodes.put(127,  new Node(127, 121, element_127(), "Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)"));
        nodes.put(128,  new Node(128, 115, element_128(), "Central Rocky Mountain-Interior Moist Montane Forest (M500)"));
        nodes.put(129,  new Node(129, 128, element_129(), "East Cascades Moist-Mesic Grand Fir - Douglas-fir Forest (G212)"));
        nodes.put(130,  new Node(130, 128, element_130(), "Central Rocky Mountain-Interior Cedar - Hemlock Forest (G217)"));
        nodes.put(131,  new Node(131, 128, element_131(), "Central Rocky Mountain-Interior Mesic Grand Fir - Douglas-fir - Western Larch Forest (G211)"));
        nodes.put(132,  new Node(132, 115, element_132(), "LC Central Rocky Mountain Montane Forest & Woodland (M501LC)"));
        nodes.put(133,  new Node(133,  85, element_133(), "Western Cordilleran Subalpine-High Montane Forest & Woodland (D336)"));
        nodes.put(134,  new Node(134, 133, element_134(), "Rocky Mountain Subalpine-Upper Montane Forest & Woodland (M020)"));
        nodes.put(135,  new Node(135, 134, element_135(), "Rocky Mountain-Interior Subalpine-Montane Aspen Forest (G222)"));
        nodes.put(136,  new Node(136, 134, element_136(), "Rocky Mountain Subalpine Moist-Mesic Spruce - Fir Forest (G218)"));
        nodes.put(137,  new Node(137, 134, element_137(), "Rocky Mountain Subalpine Dry-Mesic Spruce - Fir Forest (G219)"));
        nodes.put(138,  new Node(138, 134, element_138(), "Rocky Mountain Lodgepole Pine Forest & Woodland (G220)"));
        nodes.put(139,  new Node(139, 134, element_139(), "Rocky Mountain Montane-Subalpine Limber Pine Woodland (G101)"));
        nodes.put(140,  new Node(140, 134, element_140(), "Central Rocky Mountain Whitebark Pine - Subalpine Larch Woodland (G223)"));
        nodes.put(141,  new Node(141, 133, element_141(), "Vancouverian Subalpine-High Montane Forest (M025)"));
        nodes.put(142,  new Node(142, 141, element_142(), "Sierra-Cascade Cold-Dry Subalpine Woodland (G243)"));
        nodes.put(143,  new Node(143, 141, element_143(), "Sierra-Cascade Red Fir - Mountain Hemlock Forest (G749)"));
        nodes.put(144,  new Node(144, 141, element_144(), "North-Central Pacific Mountain Hemlock - Silver Fir Woodland (G849)"));
        nodes.put(145,  new Node(145, 133, element_145(), "LC Rocky Mountain Subalpine-High Montane Forest (M020LC)"));

        for (Map.Entry<Integer,Node> entry : nodes.entrySet()) {
            Integer ident = entry.getKey();
            Node element = entry.getValue();
            if (element.parent != null) {
                nodes.get(element.parent).children.add(nodes.get(ident));
            }
        }

        return nodes.get(0);
    }

    public Object[] element_000() {

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { "", "", match };
    }

    public Object[] element_001() {

        // Test No to Low Trees
        // 

        String level = "";
        String code = "";

        // No to low trees.

        INodeMatch match = plot -> (
            plot.get_balive() < 1
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_002() {

        // live canopy cover over 10
        // B02

        String level = "Biome";
        String code = "B02";

        // No to low basal area but with live canopy > 10

        INodeMatch match = plot -> (
            plot.get_live_canopy_cvr_pct() > 10
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_003() {

        // Western North American Grassland & Shrubland (D022)
        // 

        String level = "";
        String code = "";

        // Testing shrubland versus grassland.

        INodeMatch match = plot -> (
            plot.get_shcov()> 3 || plot.get_grcov()> 3 || plot.get_fbcov()>3
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_004() {

        // low vegetative cover
        // 

        String level = "";
        String code = "";

        // grassland

        INodeMatch match = plot -> (
            plot.get_grcov()<3 && plot.get_shcov()<3 && plot.get_fbcov()<3
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_005() {

        // Forest Plantations
        // 

        String level = "";
        String code = "";

        // Vegetation shows evidence of intensive human management as planted vegetation,
        // such as trees being planted in rows, often dominated by single-species, and even
        // aged.  The stand is identified as planted in the FIA database (Stand Origin Code
        // = 1 "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001).
        // AND the Stand Origin Species (STDORGSP) is EITHER a Populus spp. or Exotic.

        List<KeyValue> PLANTATION_pattern0 = Arrays.asList(
            new KeyValue("plantation", "Y")
        );
        List<List<KeyValue>> PLANTATION_patterns = Arrays.asList(
            PLANTATION_pattern0
        );
        PatternList PLANTATION = new PatternList("PLANTATION", PLANTATION_patterns);

        List<KeyValue> PLANTED_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("planted", "Y")
        );
        List<KeyValue> PLANTED_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> PLANTED_EXOTIC_patterns = Arrays.asList(
            PLANTED_EXOTIC_pattern0,
            PLANTED_EXOTIC_pattern1
        );
        PatternList PLANTED_EXOTIC = new PatternList("PLANTED_EXOTIC", PLANTED_EXOTIC_patterns);

        List<KeyValue> PLANTED_POPULUS_pattern0 = Arrays.asList(
            new KeyValue("planted", "Y")
        );
        List<KeyValue> PLANTED_POPULUS_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus")
        );
        List<List<KeyValue>> PLANTED_POPULUS_patterns = Arrays.asList(
            PLANTED_POPULUS_pattern0,
            PLANTED_POPULUS_pattern1
        );
        PatternList PLANTED_POPULUS = new PatternList("PLANTED_POPULUS", PLANTED_POPULUS_patterns);

        INodeMatch match = plot -> (
            false
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_006() {

        // Natural (including ruderal) Forests (C01)
        // C01

        String level = "class";
        String code = "C01";

        // Natural (including ruderal) forests

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_007() {

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

        List<KeyValue> ECOREGIONS_SGP_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315Ce, 315G, 321B")
        );
        List<List<KeyValue>> ECOREGIONS_SGP_patterns = Arrays.asList(
            ECOREGIONS_SGP_pattern0
        );
        PatternList ECOREGIONS_SGP = new PatternList("ECOREGIONS_SGP", ECOREGIONS_SGP_patterns);

        List<KeyValue> ECOREGIONS_IV_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242")
        );
        List<List<KeyValue>> ECOREGIONS_IV_patterns = Arrays.asList(
            ECOREGIONS_IV_pattern0
        );
        PatternList ECOREGIONS_IV = new PatternList("ECOREGIONS_IV", ECOREGIONS_IV_patterns);

        List<KeyValue> RIVERINE_pattern0 = Arrays.asList(
            new KeyValue("riverine", "Y")
        );
        List<List<KeyValue>> RIVERINE_patterns = Arrays.asList(
            RIVERINE_pattern0
        );
        PatternList RIVERINE = new PatternList("RIVERINE", RIVERINE_patterns);

        List<KeyValue> HYDRIC_OR_RIVERINE_pattern0 = Arrays.asList(
            new KeyValue("hydric", "Y")
        );
        List<KeyValue> HYDRIC_OR_RIVERINE_pattern1 = Arrays.asList(
            new KeyValue("riverine", "Y")
        );
        List<List<KeyValue>> HYDRIC_OR_RIVERINE_patterns = Arrays.asList(
            HYDRIC_OR_RIVERINE_pattern0,
            HYDRIC_OR_RIVERINE_pattern1
        );
        PatternList HYDRIC_OR_RIVERINE = new PatternList("HYDRIC_OR_RIVERINE", HYDRIC_OR_RIVERINE_patterns);

        List<KeyValue> W1_pattern0 = Arrays.asList(
            new KeyValue("wetland", "OBL")
        );
        List<List<KeyValue>> W1_patterns = Arrays.asList(
            W1_pattern0
        );
        PatternList W1 = new PatternList("W1", W1_patterns);

        List<KeyValue> W1_UNDERSTORY_pattern0 = Arrays.asList(
            new KeyValue("wetland", "OBL")
        );
        List<KeyValue> W1_UNDERSTORY_pattern1 = Arrays.asList(
            new KeyValue("tallytree", "N")
        );
        List<List<KeyValue>> W1_UNDERSTORY_patterns = Arrays.asList(
            W1_UNDERSTORY_pattern0,
            W1_UNDERSTORY_pattern1
        );
        PatternList W1_UNDERSTORY = new PatternList("W1_UNDERSTORY", W1_UNDERSTORY_patterns);

        List<KeyValue> W2_pattern0 = Arrays.asList(
            new KeyValue("wetland", "FACW")
        );
        List<List<KeyValue>> W2_patterns = Arrays.asList(
            W2_pattern0
        );
        PatternList W2 = new PatternList("W2", W2_patterns);

        List<KeyValue> W2_UNDERSTORY_pattern0 = Arrays.asList(
            new KeyValue("wetland", "FACW")
        );
        List<KeyValue> W2_UNDERSTORY_pattern1 = Arrays.asList(
            new KeyValue("tallytree", "N")
        );
        List<List<KeyValue>> W2_UNDERSTORY_patterns = Arrays.asList(
            W2_UNDERSTORY_pattern0,
            W2_UNDERSTORY_pattern1
        );
        PatternList W2_UNDERSTORY = new PatternList("W2_UNDERSTORY", W2_UNDERSTORY_patterns);

        List<KeyValue> W3_pattern0 = Arrays.asList(
            new KeyValue("wetland", "FAC")
        );
        List<List<KeyValue>> W3_patterns = Arrays.asList(
            W3_pattern0
        );
        PatternList W3 = new PatternList("W3", W3_patterns);

        List<KeyValue> WI_pattern0 = Arrays.asList(
            new KeyValue("wetland", "OBL, FACW")
        );
        List<KeyValue> WI_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<List<KeyValue>> WI_patterns = Arrays.asList(
            WI_pattern0,
            WI_pattern1
        );
        PatternList WI = new PatternList("WI", WI_patterns);

        List<KeyValue> WI_UNDERSTORY_pattern0 = Arrays.asList(
            new KeyValue("wetland", "OBL, FACW")
        );
        List<KeyValue> WI_UNDERSTORY_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<KeyValue> WI_UNDERSTORY_pattern2 = Arrays.asList(
            new KeyValue("tallytree", "N")
        );
        List<List<KeyValue>> WI_UNDERSTORY_patterns = Arrays.asList(
            WI_UNDERSTORY_pattern0,
            WI_UNDERSTORY_pattern1,
            WI_UNDERSTORY_pattern2
        );
        PatternList WI_UNDERSTORY = new PatternList("WI_UNDERSTORY", WI_UNDERSTORY_patterns);

        List<KeyValue> UI_pattern0 = Arrays.asList(
            new KeyValue("wetland", "UPL")
        );
        List<KeyValue> UI_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<List<KeyValue>> UI_patterns = Arrays.asList(
            UI_pattern0,
            UI_pattern1
        );
        PatternList UI = new PatternList("UI", UI_patterns);

        List<KeyValue> UI_UNDERSTORY_pattern0 = Arrays.asList(
            new KeyValue("wetland", "UPL")
        );
        List<KeyValue> UI_UNDERSTORY_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<KeyValue> UI_UNDERSTORY_pattern2 = Arrays.asList(
            new KeyValue("tallytree", "N")
        );
        List<List<KeyValue>> UI_UNDERSTORY_patterns = Arrays.asList(
            UI_UNDERSTORY_pattern0,
            UI_UNDERSTORY_pattern1,
            UI_UNDERSTORY_pattern2
        );
        PatternList UI_UNDERSTORY = new PatternList("UI_UNDERSTORY", UI_UNDERSTORY_patterns);

        List<KeyValue> Populus_fremontii_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<List<KeyValue>> Populus_fremontii_patterns = Arrays.asList(
            Populus_fremontii_pattern0
        );
        PatternList Populus_fremontii = new PatternList("Populus_fremontii", Populus_fremontii_patterns);

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

    public Object[] element_008() {

        // Temperate Flooded & Swamp Forest Formation (F026)
        // F026

        String level = "formation";
        String code = "F026";

        // Tree-dominated wetlands in a temperate climate that is influenced by minerotrophic
        //   groundwater, either on mineral or organic soils. The vegetation is dominated by broad-leaved
        //   or needle-leaved trees, generally over 10% tree cover, and the substrate is either a
        //   wood-rich peat or a mineral soil on floodplains.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_009() {

        // Great Plains Temperate Flooded & Swamp Forests (F026)
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

        List<KeyValue> ECOREGIONS_GP_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315, 331, 332, M334")
        );
        List<List<KeyValue>> ECOREGIONS_GP_patterns = Arrays.asList(
            ECOREGIONS_GP_pattern0
        );
        PatternList ECOREGIONS_GP = new PatternList("ECOREGIONS_GP", ECOREGIONS_GP_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Betula occidentalis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_pattern0,
            DIAGNOSTIC_SPECIES_pattern1,
            DIAGNOSTIC_SPECIES_pattern2,
            DIAGNOSTIC_SPECIES_pattern3,
            DIAGNOSTIC_SPECIES_pattern4,
            DIAGNOSTIC_SPECIES_pattern5,
            DIAGNOSTIC_SPECIES_pattern6,
            DIAGNOSTIC_SPECIES_pattern7,
            DIAGNOSTIC_SPECIES_pattern8,
            DIAGNOSTIC_SPECIES_pattern9,
            DIAGNOSTIC_SPECIES_pattern10,
            DIAGNOSTIC_SPECIES_pattern11,
            DIAGNOSTIC_SPECIES_pattern12,
            DIAGNOSTIC_SPECIES_pattern13,
            DIAGNOSTIC_SPECIES_pattern14,
            DIAGNOSTIC_SPECIES_pattern15,
            DIAGNOSTIC_SPECIES_pattern16,
            DIAGNOSTIC_SPECIES_pattern17,
            DIAGNOSTIC_SPECIES_pattern18,
            DIAGNOSTIC_SPECIES_pattern19,
            DIAGNOSTIC_SPECIES_pattern20,
            DIAGNOSTIC_SPECIES_pattern21
        );
        PatternList DIAGNOSTIC_SPECIES = new PatternList("DIAGNOSTIC_SPECIES", DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS_GP) && plot.riv(DIAGNOSTIC_SPECIES) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_010() {

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
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "332, M334, 331")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> ECOREGIONS_EXCL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A")
        );
        List<List<KeyValue>> ECOREGIONS_EXCL_patterns = Arrays.asList(
            ECOREGIONS_EXCL_pattern0
        );
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_011() {

        // Great Plains Flooded & Swamp Forest (M028)
        // M028

        String level = "macrogroup";
        String code = "M028";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_012() {

        // Great Plains Cottonwood - Willow Floodplain Forest (G147)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315D, 332A, 332B, 315A, 315B, 315C, 315F, 315G, M313B, 331, M332D, M334A, 332C, 332D, 332F, 332E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> ECOREGIONS_EXCL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A, 331J")
        );
        List<List<KeyValue>> ECOREGIONS_EXCL_patterns = Arrays.asList(
            ECOREGIONS_EXCL_pattern0
        );
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL)) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_013() {

        // Eastern North American Ruderal Flooded & Swamp Forest (M302)
        // M302

        String level = "macrogroup";
        String code = "M302";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER] - needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_014() {

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
        // Fraxinus texensis, Prunus serotina, and Quercus virginiana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
        // [Additional tree species not tracked by FIA include Ulmus crassifolia]
        // OR
        // iii. Located in above ECOREGION and any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> ECOREGIONS_2_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315")
        );
        List<KeyValue> ECOREGIONS_2_pattern1 = Arrays.asList(
            new KeyValue("state", "OK, TX")
        );
        List<List<KeyValue>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0,
            ECOREGIONS_2_pattern1
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<KeyValue> SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> SPECIES_1_patterns = Arrays.asList(
            SPECIES_1_pattern0,
            SPECIES_1_pattern1,
            SPECIES_1_pattern2
        );
        PatternList SPECIES_1 = new PatternList("SPECIES_1", SPECIES_1_patterns);

        List<KeyValue> SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> SPECIES_2_pattern4 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> SPECIES_2_pattern5 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> SPECIES_2_pattern6 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> SPECIES_2_pattern7 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> SPECIES_2_pattern8 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> SPECIES_2_pattern9 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> SPECIES_2_pattern10 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> SPECIES_2_pattern11 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> SPECIES_2_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> SPECIES_2_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> SPECIES_2_pattern14 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> SPECIES_2_pattern15 = Arrays.asList(
            new KeyValue("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<List<KeyValue>> SPECIES_2_patterns = Arrays.asList(
            SPECIES_2_pattern0,
            SPECIES_2_pattern1,
            SPECIES_2_pattern2,
            SPECIES_2_pattern3,
            SPECIES_2_pattern4,
            SPECIES_2_pattern5,
            SPECIES_2_pattern6,
            SPECIES_2_pattern7,
            SPECIES_2_pattern8,
            SPECIES_2_pattern9,
            SPECIES_2_pattern10,
            SPECIES_2_pattern11,
            SPECIES_2_pattern12,
            SPECIES_2_pattern13,
            SPECIES_2_pattern14,
            SPECIES_2_pattern15
        );
        PatternList SPECIES_2 = new PatternList("SPECIES_2", SPECIES_2_patterns);

        List<KeyValue> SPECIES_3_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> SPECIES_3_pattern1 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> SPECIES_3_pattern2 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> SPECIES_3_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> SPECIES_3_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> SPECIES_3_patterns = Arrays.asList(
            SPECIES_3_pattern0,
            SPECIES_3_pattern1,
            SPECIES_3_pattern2,
            SPECIES_3_pattern3,
            SPECIES_3_pattern4
        );
        PatternList SPECIES_3 = new PatternList("SPECIES_3", SPECIES_3_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            ( plot.match(ECOREGIONS_1) && plot.riv(SPECIES_1) >= 20 )
           || ( plot.match(ECOREGIONS_2) && ( plot.riv(SPECIES_2) >= 50 || (plot.riv(SPECIES_2) >= 20 && plot.riv(SPECIES_3) >= 30) ))
           || ( plot.match(ECOREGIONS_1) && plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_015() {

        // Southern Great Plains Floodplain Forest & Woodland (M154)
        // M154

        String level = "macrogroup";
        String code = "M154";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_016() {

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
        // combination of Acer negundo, Fraxinus texensis, Fraxinus pennsylvanica,
        // Juglans microcarpa, Prosopis glandulosa, Prunus serotina,
        // or Quercus virginiana (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "321B, 315C, 315D, 315E, 315G")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_017() {

        // Southeastern North American Ruderal Flooded & Swamp Forest (M310)
        // M310

        String level = "macrogroup";
        String code = "M310";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER] - needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_018() {

        // Western North American Temperate Flooded & Swamp Forests (F026)
        // F026

        String level = "formation";
        String code = "F026";

        // Forests found in ECOREGION 242, M242, 261, M261, 262, M262, 263, 313,
        // M313, 315, 321, 322, 331A, M331, M332, M333, M334, 341, M341, 342

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242, 261, M261, 262, M262, 263, 313, M313, 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_019() {

        // North Pacific Forested Wetland (D193)
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
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242, 261A, M261, 263")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Alnus rhombifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera ssp. trichocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Salix lucida ssp. lasiandra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Platanus racemosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_pattern13,
            MODERATE_DIAGNOSTIC_SPECIES_pattern14,
            MODERATE_DIAGNOSTIC_SPECIES_pattern15
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_020() {

        // North Pacific Forested Wetland(M035)
        // M035

        String level = "macrogroup";
        String code = "M035";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_021() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261A, M261A, M261B, M261E, M261F, 242, M242, M261D, M261G, 263")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Alnus rhombifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_022() {

        // North-Central Pacific Maritime Lowland Swamp (G853)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_023() {

        // North-Central Pacific Lowland Riparian Forest (G851)
        // G851

        String level = "group";
        String code = "G851";

        // i. Located in ECOREGION M242C, M261A, M261B, M261D, M261E, M262A, 242,
        // M242A, M242B, M242D, 261A, 263 and tree
        // composition dominated by one or more of STRONG DIAGNOSTIC species
        // Abies grandis, Alnus rhombifolia, Alnus rubra, Fraxinus latifolia,
        // Picea sitchensis, or Populus balsamifera ssp. trichocarpa (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer macrophyllum, Chamaecyparis lawsoniana,
        // Notholithocarpus densiflorus, Platanus racemosa, Populus fremontii,
        // Pseudotsuga menziesii, Quercus lobata, Thuja plicata, or
        // Tsuga heterophylla [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
        // together STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M261A, M261B, M261D, M261E, M262A, 242, M242A, M242B, M242D, 261A, 263")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Alnus rhombifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera ssp. trichocarpa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Platanus racemosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_024() {

        // North Pacific Forested Wetland Ruderal Forests (D193)
        // D193

        String level = "division";
        String code = "D193";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_025() {

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
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242D, 313, M313, 315, 322, 331A, M331, M332, M333, M334, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Betula occidentalis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Alnus oblongifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_026() {

        // Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)
        // M034

        String level = "macrogroup";
        String code = "M034";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_027() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A, 342A, 342D, 342F, 342G, 342H, M332, M331A, M331B, M331D, M331J, M333C, M333A, M333B, M333D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.get_elevation() < 1500 && plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_028() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242D, M261A, 313C, 313D, 315A, 315H, 322A, 322B, M242C, M261D, M261E, M261G, 313A, 313B, M313, 331A, 331I, 331J, 341, 342, M331, M332, M333, M334, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_029() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242D, M261E, M261G, 322A, 331G, 331L, 341A, 341D, 341E, 341F, 341G, 342A, M331B, M331J, M341A, M341C, M341D, 331A, 331D, 331K, 331N, 342B, 342C, 342D, 342H, 342I, 342J, M331A, M331D, M332, M333")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_030() {

        // Rocky Mountain-Great Basin Montane Ruderal Flooded & Swamp Forest (D195)
        // D195

        String level = "division";
        String code = "D195";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_031() {

        // Western North American Arid Flooded Forest (D013)
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
        // Cupressus arizonica, Populus angustifolia, Prosopis pubescens, Prosopis velutina, Quercus arizonica, 
        // Quercus emoryi, Quercus oblongifolia, Quercus agrifolia, Quercus gambelii, Quercus lobata, Quercus douglasii,
        // Quercus kelloggii, Robinia neomexicana, Salix lasiolepis, Salix lutea, Taxodium distichum, 
        // and Umbellularia californica
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261, M261, 262, M262, 313, M313, 315, 321, 322, M331, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Alnus oblongifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Alnus rhombifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Cordia boissieri")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Diospyros texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ebenopsis ebano")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Ehretia anacua")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus berlandieriana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Leucaena pulverulenta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Parkinsonia aculeata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Phaulothamnus spinescens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Sabal mexicana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Sideroxylon celastrinum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Washingtonia filifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Platanus racemosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Platanus wrightii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. wislizeni")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern22 = Arrays.asList(
            new KeyValue("species", "Elaeagnus angustifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern23 = Arrays.asList(
            new KeyValue("species", "Tamarix")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_pattern18,
            STRONG_DIAGNOSTIC_SPECIES_pattern19,
            STRONG_DIAGNOSTIC_SPECIES_pattern20,
            STRONG_DIAGNOSTIC_SPECIES_pattern21,
            STRONG_DIAGNOSTIC_SPECIES_pattern22,
            STRONG_DIAGNOSTIC_SPECIES_pattern23
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acacia farnesiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis ehrenbergiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus anomala")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus velutina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Salix gooddingii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Salix laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ailanthus altissima")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Eucalyptus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Ulmus pumila")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Prosopis pubescens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern24 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern25 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern26 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern27 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern28 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern29 = Arrays.asList(
            new KeyValue("species", "Robinia neomexicana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern30 = Arrays.asList(
            new KeyValue("species", "Salix lasiolepis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern31 = Arrays.asList(
            new KeyValue("species", "Salix lutea")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern32 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern33 = Arrays.asList(
            new KeyValue("species", "Cupressus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern34 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_pattern13,
            MODERATE_DIAGNOSTIC_SPECIES_pattern14,
            MODERATE_DIAGNOSTIC_SPECIES_pattern15,
            MODERATE_DIAGNOSTIC_SPECIES_pattern16,
            MODERATE_DIAGNOSTIC_SPECIES_pattern17,
            MODERATE_DIAGNOSTIC_SPECIES_pattern18,
            MODERATE_DIAGNOSTIC_SPECIES_pattern19,
            MODERATE_DIAGNOSTIC_SPECIES_pattern20,
            MODERATE_DIAGNOSTIC_SPECIES_pattern21,
            MODERATE_DIAGNOSTIC_SPECIES_pattern22,
            MODERATE_DIAGNOSTIC_SPECIES_pattern23,
            MODERATE_DIAGNOSTIC_SPECIES_pattern24,
            MODERATE_DIAGNOSTIC_SPECIES_pattern25,
            MODERATE_DIAGNOSTIC_SPECIES_pattern26,
            MODERATE_DIAGNOSTIC_SPECIES_pattern27,
            MODERATE_DIAGNOSTIC_SPECIES_pattern28,
            MODERATE_DIAGNOSTIC_SPECIES_pattern29,
            MODERATE_DIAGNOSTIC_SPECIES_pattern30,
            MODERATE_DIAGNOSTIC_SPECIES_pattern31,
            MODERATE_DIAGNOSTIC_SPECIES_pattern32,
            MODERATE_DIAGNOSTIC_SPECIES_pattern33,
            MODERATE_DIAGNOSTIC_SPECIES_pattern34
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_032() {

        // Western Arid Lowland Flooded Forest (M036)
        // M036

        String level = "macrogroup";
        String code = "M036";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_033() {

        // Tamaulipan Flooded Forest (G549)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "321B, 315D, 315E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Cordia boissieri")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Diospyros texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Ebenopsis ebano")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ehretia anacua")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus berlandieriana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Leucaena pulverulenta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Parkinsonia aculeata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Phaulothamnus spinescens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Sabal mexicana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Sideroxylon celastrinum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acacia farnesiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis ehrenbergiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Taxodium mucronatum")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_034() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261, 262, 263, 322A, 322C, M242A, M261A, M261B, M261C, M262")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Alnus rhombifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Platanus racemosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Salix gooddingii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Salix laevigata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Salix lasiolepis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Salix lutea")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_035() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M313, 313C, 315A, 315B, 315H, 321, 322")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Alnus oblongifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Platanus wrightii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Salix gooddingii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Salix lasiolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Washingtonia filifera")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Cupressus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Robinia neomexicana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_036() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313A, 313B, 313D, 322A, 341, 342B, 342C, 342E, 342J, M261G, M331D, M331E, M331G, M331H, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus anomala")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus fremontii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus berlandieriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus angustifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Prosopis pubescens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Salix gooddingii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Salix lasiolepis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_037() {

        // Western Arid Ruderal Riparian Forest & Scrub (M298)
        // M298

        String level = "macrogroup";
        String code = "M298";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously). Tree
        // composition dominated by ruderal native or EXOTIC = Y
        // (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division

        List<KeyValue> RUDERAL_OR_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_pattern0,
            RUDERAL_OR_EXOTIC_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC = new PatternList("RUDERAL_OR_EXOTIC", RUDERAL_OR_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_038() {

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

    public Object[] element_039() {

        // Temperate & Boreal Forest & Woodland Subclass (B02)
        // B02

        String level = "Biome";
        String code = "B02";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_040() {

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

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222, 251, 315, 331, 332")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> ECOREGIONS_EXCL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315H, 331A, 331J")
        );
        List<List<KeyValue>> ECOREGIONS_EXCL_patterns = Arrays.asList(
            ECOREGIONS_EXCL_pattern0
        );
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_1_pattern0,
            DIAGNOSTIC_SPECIES_1_pattern1
        );
        PatternList DIAGNOSTIC_SPECIES_1 = new PatternList("DIAGNOSTIC_SPECIES_1", DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_2_pattern0,
            DIAGNOSTIC_SPECIES_2_pattern1,
            DIAGNOSTIC_SPECIES_2_pattern2
        );
        PatternList DIAGNOSTIC_SPECIES_2 = new PatternList("DIAGNOSTIC_SPECIES_2", DIAGNOSTIC_SPECIES_2_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern0 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern3 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern4 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern5 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern7 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern8 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern9 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern10 = Arrays.asList(
            new KeyValue("species", "Crataegus")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern11 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern12 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern13 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern14 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern15 = Arrays.asList(
            new KeyValue("species", "Gymnocladus dioicus")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern16 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern17 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern18 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern19 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern20 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern21 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern22 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern23 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern24 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern25 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern26 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern27 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern28 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern29 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern30 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern31 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern32 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern33 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern34 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern35 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern36 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata var. sinuata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern37 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern38 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern39 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern40 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern41 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern42 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern43 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern44 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern45 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern46 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_3_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_3_pattern0,
            DIAGNOSTIC_SPECIES_3_pattern1,
            DIAGNOSTIC_SPECIES_3_pattern2,
            DIAGNOSTIC_SPECIES_3_pattern3,
            DIAGNOSTIC_SPECIES_3_pattern4,
            DIAGNOSTIC_SPECIES_3_pattern5,
            DIAGNOSTIC_SPECIES_3_pattern6,
            DIAGNOSTIC_SPECIES_3_pattern7,
            DIAGNOSTIC_SPECIES_3_pattern8,
            DIAGNOSTIC_SPECIES_3_pattern9,
            DIAGNOSTIC_SPECIES_3_pattern10,
            DIAGNOSTIC_SPECIES_3_pattern11,
            DIAGNOSTIC_SPECIES_3_pattern12,
            DIAGNOSTIC_SPECIES_3_pattern13,
            DIAGNOSTIC_SPECIES_3_pattern14,
            DIAGNOSTIC_SPECIES_3_pattern15,
            DIAGNOSTIC_SPECIES_3_pattern16,
            DIAGNOSTIC_SPECIES_3_pattern17,
            DIAGNOSTIC_SPECIES_3_pattern18,
            DIAGNOSTIC_SPECIES_3_pattern19,
            DIAGNOSTIC_SPECIES_3_pattern20,
            DIAGNOSTIC_SPECIES_3_pattern21,
            DIAGNOSTIC_SPECIES_3_pattern22,
            DIAGNOSTIC_SPECIES_3_pattern23,
            DIAGNOSTIC_SPECIES_3_pattern24,
            DIAGNOSTIC_SPECIES_3_pattern25,
            DIAGNOSTIC_SPECIES_3_pattern26,
            DIAGNOSTIC_SPECIES_3_pattern27,
            DIAGNOSTIC_SPECIES_3_pattern28,
            DIAGNOSTIC_SPECIES_3_pattern29,
            DIAGNOSTIC_SPECIES_3_pattern30,
            DIAGNOSTIC_SPECIES_3_pattern31,
            DIAGNOSTIC_SPECIES_3_pattern32,
            DIAGNOSTIC_SPECIES_3_pattern33,
            DIAGNOSTIC_SPECIES_3_pattern34,
            DIAGNOSTIC_SPECIES_3_pattern35,
            DIAGNOSTIC_SPECIES_3_pattern36,
            DIAGNOSTIC_SPECIES_3_pattern37,
            DIAGNOSTIC_SPECIES_3_pattern38,
            DIAGNOSTIC_SPECIES_3_pattern39,
            DIAGNOSTIC_SPECIES_3_pattern40,
            DIAGNOSTIC_SPECIES_3_pattern41,
            DIAGNOSTIC_SPECIES_3_pattern42,
            DIAGNOSTIC_SPECIES_3_pattern43,
            DIAGNOSTIC_SPECIES_3_pattern44,
            DIAGNOSTIC_SPECIES_3_pattern45,
            DIAGNOSTIC_SPECIES_3_pattern46
        );
        PatternList DIAGNOSTIC_SPECIES_3 = new PatternList("DIAGNOSTIC_SPECIES_3", DIAGNOSTIC_SPECIES_3_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && !plot.match(ECOREGIONS_EXCL)) &&
           ( (plot.riv(DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(DIAGNOSTIC_SPECIES_2) <= 5) ||
           plot.riv(DIAGNOSTIC_SPECIES_3) >= 20 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_041() {

        // North American Great Plains Forest & Woodland Division (D322)
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
        // Quercus marilandica, Quercus stellata, Quercus virginiana, Sideroxylon lanuginosum ssp. lanuginosum, Ulmus americana,
        // Ulmus crassifolia or Ulmus rubra (=>50% RIV),
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE
        // diagnostic species, any combination of Acer negundo,
        // Betula papyrifera, Celtis laevigata, Celtis occidentalis, Crataegus spp.,
        // Juglans nigra, Juniperus ashei, Juniperus pinchotii, Juniperus scopulorum, Morus rubra, Pinus ponderosa,
        // Populus grandidentata, Populus balsamifera, Ostrya virginiana
        // Prunus virginiana, or Quercus muehlenbergii
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222, 231, 251, 255, 315, 321, 331, 332")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> ECOREGIONS_EXCL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A, 331J")
        );
        List<List<KeyValue>> ECOREGIONS_EXCL_patterns = Arrays.asList(
            ECOREGIONS_EXCL_pattern0
        );
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_patterns);

        List<KeyValue> ECOREGIONS_2_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M334A")
        );
        List<List<KeyValue>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern8 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern9 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern10 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern11 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern12 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern14 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern15 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern16 = Arrays.asList(
            new KeyValue("species", "Diospyros texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern17 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern18 = Arrays.asList(
            new KeyValue("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_1_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern18
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_1 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_1", STRONG_DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Crataegus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_pattern13
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS_1) && !plot.match(ECOREGIONS_EXCL) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_042() {

        // Southern Great Plains Forest & Woodland (M544)
        // M544

        String level = "macrogroup";
        String code = "M544";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B, AND tree composition dominated by one or more of STRONG MESIC DIAGNOSTIC species Juglans major, Acer grandidentatum, Diospyros texana, Juglans major, Juniperus ashei, Juniperus pinchotii Prosopis glandulosa, Prosopis velutina, Quercus buckleyi, Quercus laceyi, Quercus marilandica, Quercus muehlenbergii, Quercus stellata,   Quercus virginiana or Ulmus alata, or Ulmus crassifolia (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species in any combination of ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species in any combination of Arbutus xalapensis, Celtis laevigata, Juniperius virginai, Fraxinus texensis, Pinus remota, Prunus serotina, , Quercus macrocarpa, Quercus pungens, Quercus sinuata  (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus buckleyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus laceyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Diospyros texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus pungens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_043() {

        // Cross Timbers Woodland (G887)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231E,  231G, 251E, 251F, 255A, 255E, 315C, 315G, 332F")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_044() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "255B, 255E, 315C, 315D, 315E, 315G, 321B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus buckleyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus laceyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_045() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "255B, 255E, 315C, 315D, 315E, 315G, 321B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Diospyros texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus buckleyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus pungens")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_046() {

        // Northern Great Plains Forest & Woodland (M545)
        // M545

        String level = "macrogroup";
        String code = "M545";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_047() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222, 251, 331K, 332B, 331B, 331F, 331C, 331M, 331E, 332A, 332C, 332E, 332F, 332D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_048() {

        // Northern Tallgrass Oak Aspen Woodland (G146)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "251A, 251B, 222Na, 222Ma")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_049() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331E, 331M, 332A, 332B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_050() {

        // Northern Great Plains Mesic Forest & Woodland (G145)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222, 251, 315F, 315B, 332, 331")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> ECOREGIONS_EXCL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A, 331J")
        );
        List<List<KeyValue>> ECOREGIONS_EXCL_patterns = Arrays.asList(
            ECOREGIONS_EXCL_pattern0
        );
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL)) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_051() {

        // Great Plains Ruderal Woodland (M524)
        // M524

        String level = "macrogroup";
        String code = "M524";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by ruderal native or EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_052() {

        // LC Southern Great Plains Forest & Woodland (M544LC)
        // M544LC

        String level = "macrogroup";
        String code = "M544LC";

        // Not as above.

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_053() {

        // LC Northern Great Plains Forest & Woodland (M545LC)
        // M545LC

        String level = "macrogroup";
        String code = "M545LC";

        // Not as above.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_054() {

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
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STATES_pattern0 = Arrays.asList(
            new KeyValue("state", "TX, OK")
        );
        List<List<KeyValue>> STATES_patterns = Arrays.asList(
            STATES_pattern0
        );
        PatternList STATES = new PatternList("STATES", STATES_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus margarettiae")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata var. sinuata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && plot.match(STATES) &&
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_055() {

        // Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)
        // M885

        String level = "macrogroup";
        String code = "M885";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_056() {

        // Southeast Maritime Live Oak - Palmetto Forest (G798)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus hemisphaerica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_057() {

        // Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)
        // G799

        String level = "group";
        String code = "G799";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 315E
        // and tree composition dominated by one or more of
        // STRONG DIAGNOSTIC species Quercus virginiana (=Quercus virgiana ssp. fusiformis) (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Prosopis glandulosa, Quercus marilandica,
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Zanthoxylum hirsutum")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_058() {

        // Southeastern North American Ruderal Forest (M305)
        // M305

        String level = "macrogroup";
        String code = "M305";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy
        // native vegetation that invades natural stands or vegetation that
        // dominates on formerly cleared and/or planted sites but which has been
        // allowed to succeed more-or-less spontaneously). Tree composition
        // dominated by ruderal native or EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_059() {

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
        // Juniperus virginiana , Morus rubra, Ostrya virginiana,
        // Populus balsamifera, Populus deltoides, Prunus pensylvanica,
        // Prunus serotina, Prunus virginiana, Quercus virginiana (=Quercus virgiana ssp. fusiformis),
        // Quercus marilandica, Quercus stellata,
        // Quercus shumardii, Ulmus alata, or Ulmus crassifolia
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
        // OR
        // c. Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315, 332")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Gymnocladus dioicus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Populus deltoides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_pattern13,
            MODERATE_DIAGNOSTIC_SPECIES_pattern14,
            MODERATE_DIAGNOSTIC_SPECIES_pattern15,
            MODERATE_DIAGNOSTIC_SPECIES_pattern16,
            MODERATE_DIAGNOSTIC_SPECIES_pattern17,
            MODERATE_DIAGNOSTIC_SPECIES_pattern18,
            MODERATE_DIAGNOSTIC_SPECIES_pattern19,
            MODERATE_DIAGNOSTIC_SPECIES_pattern20,
            MODERATE_DIAGNOSTIC_SPECIES_pattern21,
            MODERATE_DIAGNOSTIC_SPECIES_pattern22
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> EXOTIC_TREE_SPP_pattern1 = Arrays.asList(
            new KeyValue("tallytree", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0,
            EXOTIC_TREE_SPP_pattern1
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ||
           plot.riv(EXOTIC_TREE_SPP) >=80 )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_060() {

        // Eastern North American Forest & Woodland Natural Forests (D008)
        // D008

        String level = "division";
        String code = "D008";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_061() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "332A, 332D, 332C, 332E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_062() {

        // Midwest Oak Hickory Forest (G990)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "332")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_063() {

        // South - Central Oak - Pine Forest & Woodland (M540)
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
        // Juniperus virginiana, Prunus serotina, Quercus virginiana,
        // Quercus marilandica, Quercus stellata, Quercus shumardii,
        // Ulmus alata, or Ulmus crassifolia
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV).

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315, 332")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_064() {

        // West Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315D, 315E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus margarettae")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_065() {

        // Eastern North American Ruderal Forests (D008)
        // D008

        String level = "division";
        String code = "D008";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy
        // native vegetation that invades natural stands or vegetation that
        // dominates on formerly cleared and/or planted sites but which has been
        // allowed to succeed more-or-less spontaneously). Tree composition
        // dominated by ruderal native or EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_066() {

        // Eastern North American Ruderal Forest (M013)
        // M013

        String level = "macrogroup";
        String code = "M013";

        // Only one Macrogroup

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_067() {

        // Western North American Temperate Forests
        // 

        String level = "subclass";
        String code = "";

        // Forests found in ECOREGION 242, M242, 261, M261, 262, M262, 263, 313, M313,
        // 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242, 261, M261, 262, M262, 263, 313, M313, 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_068() {

        // Warm Temperate Forest & Woodland (S54)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242B, 261, M261, 262, M262, 331B, 331J, M331F, M331G, 341F, 342B, 322, 313C, M313, 321, 315")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> ECOREGIONS_EXCL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M261A, M261B, M261C, M261D, M261G")
        );
        List<List<KeyValue>> ECOREGIONS_EXCL_patterns = Arrays.asList(
            ECOREGIONS_EXCL_pattern0
        );
        PatternList ECOREGIONS_EXCL = new PatternList("ECOREGIONS_EXCL", ECOREGIONS_EXCL_patterns);

        List<KeyValue> ECOREGIONS_263_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "263")
        );
        List<List<KeyValue>> ECOREGIONS_263_patterns = Arrays.asList(
            ECOREGIONS_263_pattern0
        );
        PatternList ECOREGIONS_263 = new PatternList("ECOREGIONS_263", ECOREGIONS_263_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Cupressus bakeri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Cupressus forbesii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Cupressus macnabiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new KeyValue("species", "Cupressus macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new KeyValue("species", "Cupressus goveniana ssp. pygmaea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new KeyValue("species", "Cupressus sargentii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern8 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern10 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern11 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern16 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern17 = Arrays.asList(
            new KeyValue("species", "Pinus attenuata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern18 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern19 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern20 = Arrays.asList(
            new KeyValue("species", "Pinus radiata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern21 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern22 = Arrays.asList(
            new KeyValue("species", "Pinus sabiniana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern23 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern24 = Arrays.asList(
            new KeyValue("species", "Aesculus californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern25 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern26 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern27 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern28 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern29 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern30 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern31 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern32 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern33 = Arrays.asList(
            new KeyValue("species", "Quercus albocincta")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern34 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern35 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern36 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern37 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern38 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern39 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern40 = Arrays.asList(
            new KeyValue("species", "Quercus engelmannii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern41 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern42 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern43 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern44 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern45 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern46 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern47 = Arrays.asList(
            new KeyValue("species", "Quercus vaseyana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern48 = Arrays.asList(
            new KeyValue("species", "Quercus parvula")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern49 = Arrays.asList(
            new KeyValue("species", "Quercus wislizeni")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern50 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_1_pattern0,
            DIAGNOSTIC_SPECIES_1_pattern1,
            DIAGNOSTIC_SPECIES_1_pattern2,
            DIAGNOSTIC_SPECIES_1_pattern3,
            DIAGNOSTIC_SPECIES_1_pattern4,
            DIAGNOSTIC_SPECIES_1_pattern5,
            DIAGNOSTIC_SPECIES_1_pattern6,
            DIAGNOSTIC_SPECIES_1_pattern7,
            DIAGNOSTIC_SPECIES_1_pattern8,
            DIAGNOSTIC_SPECIES_1_pattern9,
            DIAGNOSTIC_SPECIES_1_pattern10,
            DIAGNOSTIC_SPECIES_1_pattern11,
            DIAGNOSTIC_SPECIES_1_pattern12,
            DIAGNOSTIC_SPECIES_1_pattern13,
            DIAGNOSTIC_SPECIES_1_pattern14,
            DIAGNOSTIC_SPECIES_1_pattern15,
            DIAGNOSTIC_SPECIES_1_pattern16,
            DIAGNOSTIC_SPECIES_1_pattern17,
            DIAGNOSTIC_SPECIES_1_pattern18,
            DIAGNOSTIC_SPECIES_1_pattern19,
            DIAGNOSTIC_SPECIES_1_pattern20,
            DIAGNOSTIC_SPECIES_1_pattern21,
            DIAGNOSTIC_SPECIES_1_pattern22,
            DIAGNOSTIC_SPECIES_1_pattern23,
            DIAGNOSTIC_SPECIES_1_pattern24,
            DIAGNOSTIC_SPECIES_1_pattern25,
            DIAGNOSTIC_SPECIES_1_pattern26,
            DIAGNOSTIC_SPECIES_1_pattern27,
            DIAGNOSTIC_SPECIES_1_pattern28,
            DIAGNOSTIC_SPECIES_1_pattern29,
            DIAGNOSTIC_SPECIES_1_pattern30,
            DIAGNOSTIC_SPECIES_1_pattern31,
            DIAGNOSTIC_SPECIES_1_pattern32,
            DIAGNOSTIC_SPECIES_1_pattern33,
            DIAGNOSTIC_SPECIES_1_pattern34,
            DIAGNOSTIC_SPECIES_1_pattern35,
            DIAGNOSTIC_SPECIES_1_pattern36,
            DIAGNOSTIC_SPECIES_1_pattern37,
            DIAGNOSTIC_SPECIES_1_pattern38,
            DIAGNOSTIC_SPECIES_1_pattern39,
            DIAGNOSTIC_SPECIES_1_pattern40,
            DIAGNOSTIC_SPECIES_1_pattern41,
            DIAGNOSTIC_SPECIES_1_pattern42,
            DIAGNOSTIC_SPECIES_1_pattern43,
            DIAGNOSTIC_SPECIES_1_pattern44,
            DIAGNOSTIC_SPECIES_1_pattern45,
            DIAGNOSTIC_SPECIES_1_pattern46,
            DIAGNOSTIC_SPECIES_1_pattern47,
            DIAGNOSTIC_SPECIES_1_pattern48,
            DIAGNOSTIC_SPECIES_1_pattern49,
            DIAGNOSTIC_SPECIES_1_pattern50
        );
        PatternList DIAGNOSTIC_SPECIES_1 = new PatternList("DIAGNOSTIC_SPECIES_1", DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Cupressus bakeri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Cupressus forbesii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Cupressus macnabiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Cupressus macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern4 = Arrays.asList(
            new KeyValue("species", "Cupressus goveniana ssp. pygmaea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern5 = Arrays.asList(
            new KeyValue("species", "Cupressus sargentii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern7 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern8 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern10 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern11 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern16 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern17 = Arrays.asList(
            new KeyValue("species", "Pinus attenuata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern18 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern19 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern20 = Arrays.asList(
            new KeyValue("species", "Pinus radiata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern21 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern22 = Arrays.asList(
            new KeyValue("species", "Pinus sabiniana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern23 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern24 = Arrays.asList(
            new KeyValue("species", "Aesculus californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern25 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern26 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern27 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern28 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern29 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern30 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern31 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern32 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern33 = Arrays.asList(
            new KeyValue("species", "Quercus albocincta")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern34 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern35 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern36 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern37 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern38 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern39 = Arrays.asList(
            new KeyValue("species", "Quercus engelmannii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern40 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern41 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern42 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern43 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern44 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern45 = Arrays.asList(
            new KeyValue("species", "Quercus pungens")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern46 = Arrays.asList(
            new KeyValue("species", "Quercus parvula")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_2_pattern47 = Arrays.asList(
            new KeyValue("species", "Quercus wislizeni")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_2_pattern0,
            DIAGNOSTIC_SPECIES_2_pattern1,
            DIAGNOSTIC_SPECIES_2_pattern2,
            DIAGNOSTIC_SPECIES_2_pattern3,
            DIAGNOSTIC_SPECIES_2_pattern4,
            DIAGNOSTIC_SPECIES_2_pattern5,
            DIAGNOSTIC_SPECIES_2_pattern6,
            DIAGNOSTIC_SPECIES_2_pattern7,
            DIAGNOSTIC_SPECIES_2_pattern8,
            DIAGNOSTIC_SPECIES_2_pattern9,
            DIAGNOSTIC_SPECIES_2_pattern10,
            DIAGNOSTIC_SPECIES_2_pattern11,
            DIAGNOSTIC_SPECIES_2_pattern12,
            DIAGNOSTIC_SPECIES_2_pattern13,
            DIAGNOSTIC_SPECIES_2_pattern14,
            DIAGNOSTIC_SPECIES_2_pattern15,
            DIAGNOSTIC_SPECIES_2_pattern16,
            DIAGNOSTIC_SPECIES_2_pattern17,
            DIAGNOSTIC_SPECIES_2_pattern18,
            DIAGNOSTIC_SPECIES_2_pattern19,
            DIAGNOSTIC_SPECIES_2_pattern20,
            DIAGNOSTIC_SPECIES_2_pattern21,
            DIAGNOSTIC_SPECIES_2_pattern22,
            DIAGNOSTIC_SPECIES_2_pattern23,
            DIAGNOSTIC_SPECIES_2_pattern24,
            DIAGNOSTIC_SPECIES_2_pattern25,
            DIAGNOSTIC_SPECIES_2_pattern26,
            DIAGNOSTIC_SPECIES_2_pattern27,
            DIAGNOSTIC_SPECIES_2_pattern28,
            DIAGNOSTIC_SPECIES_2_pattern29,
            DIAGNOSTIC_SPECIES_2_pattern30,
            DIAGNOSTIC_SPECIES_2_pattern31,
            DIAGNOSTIC_SPECIES_2_pattern32,
            DIAGNOSTIC_SPECIES_2_pattern33,
            DIAGNOSTIC_SPECIES_2_pattern34,
            DIAGNOSTIC_SPECIES_2_pattern35,
            DIAGNOSTIC_SPECIES_2_pattern36,
            DIAGNOSTIC_SPECIES_2_pattern37,
            DIAGNOSTIC_SPECIES_2_pattern38,
            DIAGNOSTIC_SPECIES_2_pattern39,
            DIAGNOSTIC_SPECIES_2_pattern40,
            DIAGNOSTIC_SPECIES_2_pattern41,
            DIAGNOSTIC_SPECIES_2_pattern42,
            DIAGNOSTIC_SPECIES_2_pattern43,
            DIAGNOSTIC_SPECIES_2_pattern44,
            DIAGNOSTIC_SPECIES_2_pattern45,
            DIAGNOSTIC_SPECIES_2_pattern46,
            DIAGNOSTIC_SPECIES_2_pattern47
        );
        PatternList DIAGNOSTIC_SPECIES_2 = new PatternList("DIAGNOSTIC_SPECIES_2", DIAGNOSTIC_SPECIES_2_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern0 = Arrays.asList(
            new KeyValue("species", "Cupressus bakeri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern1 = Arrays.asList(
            new KeyValue("species", "Cupressus forbesii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern2 = Arrays.asList(
            new KeyValue("species", "Cupressus macnabiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern3 = Arrays.asList(
            new KeyValue("species", "Cupressus macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern4 = Arrays.asList(
            new KeyValue("species", "Cupressus goveniana ssp. pygmaea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern5 = Arrays.asList(
            new KeyValue("species", "Cupressus sargentii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern7 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern8 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern10 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern11 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern16 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern17 = Arrays.asList(
            new KeyValue("species", "Pinus attenuata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern18 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern19 = Arrays.asList(
            new KeyValue("species", "Pinus radiata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern20 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern21 = Arrays.asList(
            new KeyValue("species", "Pinus sabiniana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern22 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern23 = Arrays.asList(
            new KeyValue("species", "Aesculus californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern24 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern25 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern26 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern27 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern28 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern29 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern30 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern31 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern32 = Arrays.asList(
            new KeyValue("species", "Quercus albocincta")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern33 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern34 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern35 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern36 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern37 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern38 = Arrays.asList(
            new KeyValue("species", "Quercus engelmannii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern39 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern40 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern41 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern42 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern43 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern44 = Arrays.asList(
            new KeyValue("species", "Quercus pungens")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern45 = Arrays.asList(
            new KeyValue("species", "Quercus parvula")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_3_pattern46 = Arrays.asList(
            new KeyValue("species", "Quercus wislizeni")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_3_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_3_pattern0,
            DIAGNOSTIC_SPECIES_3_pattern1,
            DIAGNOSTIC_SPECIES_3_pattern2,
            DIAGNOSTIC_SPECIES_3_pattern3,
            DIAGNOSTIC_SPECIES_3_pattern4,
            DIAGNOSTIC_SPECIES_3_pattern5,
            DIAGNOSTIC_SPECIES_3_pattern6,
            DIAGNOSTIC_SPECIES_3_pattern7,
            DIAGNOSTIC_SPECIES_3_pattern8,
            DIAGNOSTIC_SPECIES_3_pattern9,
            DIAGNOSTIC_SPECIES_3_pattern10,
            DIAGNOSTIC_SPECIES_3_pattern11,
            DIAGNOSTIC_SPECIES_3_pattern12,
            DIAGNOSTIC_SPECIES_3_pattern13,
            DIAGNOSTIC_SPECIES_3_pattern14,
            DIAGNOSTIC_SPECIES_3_pattern15,
            DIAGNOSTIC_SPECIES_3_pattern16,
            DIAGNOSTIC_SPECIES_3_pattern17,
            DIAGNOSTIC_SPECIES_3_pattern18,
            DIAGNOSTIC_SPECIES_3_pattern19,
            DIAGNOSTIC_SPECIES_3_pattern20,
            DIAGNOSTIC_SPECIES_3_pattern21,
            DIAGNOSTIC_SPECIES_3_pattern22,
            DIAGNOSTIC_SPECIES_3_pattern23,
            DIAGNOSTIC_SPECIES_3_pattern24,
            DIAGNOSTIC_SPECIES_3_pattern25,
            DIAGNOSTIC_SPECIES_3_pattern26,
            DIAGNOSTIC_SPECIES_3_pattern27,
            DIAGNOSTIC_SPECIES_3_pattern28,
            DIAGNOSTIC_SPECIES_3_pattern29,
            DIAGNOSTIC_SPECIES_3_pattern30,
            DIAGNOSTIC_SPECIES_3_pattern31,
            DIAGNOSTIC_SPECIES_3_pattern32,
            DIAGNOSTIC_SPECIES_3_pattern33,
            DIAGNOSTIC_SPECIES_3_pattern34,
            DIAGNOSTIC_SPECIES_3_pattern35,
            DIAGNOSTIC_SPECIES_3_pattern36,
            DIAGNOSTIC_SPECIES_3_pattern37,
            DIAGNOSTIC_SPECIES_3_pattern38,
            DIAGNOSTIC_SPECIES_3_pattern39,
            DIAGNOSTIC_SPECIES_3_pattern40,
            DIAGNOSTIC_SPECIES_3_pattern41,
            DIAGNOSTIC_SPECIES_3_pattern42,
            DIAGNOSTIC_SPECIES_3_pattern43,
            DIAGNOSTIC_SPECIES_3_pattern44,
            DIAGNOSTIC_SPECIES_3_pattern45,
            DIAGNOSTIC_SPECIES_3_pattern46
        );
        PatternList DIAGNOSTIC_SPECIES_3 = new PatternList("DIAGNOSTIC_SPECIES_3", DIAGNOSTIC_SPECIES_3_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && !plot.match(ECOREGIONS_EXCL) && plot.riv(DIAGNOSTIC_SPECIES_1) >= 20) ||
           (plot.match(ECOREGIONS_EXCL) && plot.riv(DIAGNOSTIC_SPECIES_2) >= 20) ||
           (plot.match(ECOREGIONS_263) && plot.riv(DIAGNOSTIC_SPECIES_3) >= 20)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_069() {

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
        // c. Any EXOTIC = Y tree species =>80% RIV
        // AND
        // ii. Located in ECOREGION M242B, 342B, 263, M261, 341D, 341F, 262, 322, 261, M262

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242B, 342B, 263, M261, 341D, 341F, 262, 322, 261, M262")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Aesculus californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus attenuata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus radiata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus sabiniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus wislizeni")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern22 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern23 = Arrays.asList(
            new KeyValue("species", "Fraxinus latifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern24 = Arrays.asList(
            new KeyValue("species", "Cupressus bakeri")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern25 = Arrays.asList(
            new KeyValue("species", "Cupressus forbesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern26 = Arrays.asList(
            new KeyValue("species", "Cupressus macnabiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern27 = Arrays.asList(
            new KeyValue("species", "Cupressus macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern28 = Arrays.asList(
            new KeyValue("species", "Cupressus goveniana ssp. pygmaea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern29 = Arrays.asList(
            new KeyValue("species", "Cupressus sargentii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern30 = Arrays.asList(
            new KeyValue("species", "Quercus parvula")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_pattern18,
            STRONG_DIAGNOSTIC_SPECIES_pattern19,
            STRONG_DIAGNOSTIC_SPECIES_pattern20,
            STRONG_DIAGNOSTIC_SPECIES_pattern21,
            STRONG_DIAGNOSTIC_SPECIES_pattern22,
            STRONG_DIAGNOSTIC_SPECIES_pattern23,
            STRONG_DIAGNOSTIC_SPECIES_pattern24,
            STRONG_DIAGNOSTIC_SPECIES_pattern25,
            STRONG_DIAGNOSTIC_SPECIES_pattern26,
            STRONG_DIAGNOSTIC_SPECIES_pattern27,
            STRONG_DIAGNOSTIC_SPECIES_pattern28,
            STRONG_DIAGNOSTIC_SPECIES_pattern29,
            STRONG_DIAGNOSTIC_SPECIES_pattern30
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus lambertiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Sequoia sempervirens")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) || 
           plot.riv(EXOTIC_TREE_SPP) >=80 )
           && plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_070() {

        // Californian Forest & Woodland (M009)
        // M009

        String level = "macrogroup";
        String code = "M009";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_071() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M261D, M261A, 261B, 322A, M262A, 263, M261B, M261C, M261F, M261E, M262B, 261A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Hesperocyparis abramsiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Cupressus bakeri")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Cupressus forbesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Cupressus goveniana ssp. pygmaea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Cupressus macnabiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Cupressus macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Cupressus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Cupressus sargentii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus sabiniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus attenuata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus radiata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus torreyana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus quadrifolia")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus wislizeni")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_072() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "342B, 322A, 341D, M242B, M261, M262, 261, 262, 263")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Aesculus californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juglans californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus agrifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus douglasii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus lobata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus wislizeni")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus parvula")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_073() {

        // Californian Ruderal Forest (M513)
        // M513

        String level = "macrogroup";
        String code = "M513";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER] – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_074() {

        // Madrean Forest & Woodland Division (D331)
        // D331

        String level = "division";
        String code = "D331";

        // Tree composition and ecology matching one of the following options:
        // i. EITHER
        // a. Tree composition contains one or more of STRONG diagnostic tree
        // species Juniperus ashei, Juniperus coahuilensis, Juniperus deppeana,
        // Juniperus flaccida, Juniperus pinchotii, Pinus arizonica, Pinus cembroides, Pinus discolor,
        // Pinus engelmannii, Pinus leiophylla, Pinus strobiformis,
        // Prosopis glandulosa, Prosopis velutina, Quercus albocincta,
        // Quercus arizonica, Quercus chrysolepis, Quercus emoryi,
        // Quercus grisea, Quercus hypoleucoides, Quercus oblongifolia,
        // or Quercus rugosa (=>50% RIV),
        // [Additional tree species not tracked by FIA include
        // Juniperus arizonica, Pinus monophylla, Quercus buckleyi, Quercus fusiformis,
        // Quercus gravesii, Quercus vaseyana, or Ulmus crassifolia]
        // OR
        // b. The above tree species, but with =>20% RIV AND other MODERATE
        // diagnostic species any combination of Abies concolor,
        // Acer grandidentatum, Arbutus arizonica, Arbutus xalapensis,
        // Celtis laevigata, Fraxinus albicans, Juglans major, Juglans nigra,
        // Juniperus monosperma, Juniperus osteosperma, Pinus edulis,
        // Pinus ponderosa, Pinus remota, Pseudotsuga menziesii,
        // Prunus serotina, Quercus gambelii, Quercus macrocarpa, Quercus muehlenbergii, or Quercus vaseyana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
        // [Additional tree species not tracked by FIA include Quercus laceyi]
        // OR
        // c. Any EXOTIC = Y tree species =>80% RIV
        // AND
        // ii. Located in ECOREGION 322, 313, M313, 321, 315

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "322, 313, M313, 321, 315")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus albocincta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_pattern18,
            STRONG_DIAGNOSTIC_SPECIES_pattern19,
            STRONG_DIAGNOSTIC_SPECIES_pattern20,
            STRONG_DIAGNOSTIC_SPECIES_pattern21
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus texensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus vaseyana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_pattern13,
            MODERATE_DIAGNOSTIC_SPECIES_pattern14,
            MODERATE_DIAGNOSTIC_SPECIES_pattern15,
            MODERATE_DIAGNOSTIC_SPECIES_pattern16,
            MODERATE_DIAGNOSTIC_SPECIES_pattern17,
            MODERATE_DIAGNOSTIC_SPECIES_pattern18
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) || 
           plot.riv(EXOTIC_TREE_SPP) >=80 )
           && plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_075() {

        // Madrean Natural Forests & Woodlands (D331)
        // D331

        String level = "division";
        String code = "D331";

        // Vegetation in a relatively natural state, dominated by native species,
        // little or no evidence of trees in a row, no very recent logging,
        // understory mowing, etc. (trees may be early successional pole-sized
        // trees following logging or blowdowns). Tree composition is dominated by
        // ruderal native or EXOTIC = Y (< 20% RIV)
        // (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_076() {

        // Madrean Lowland Evergreen Woodland (M010)
        // M010

        String level = "macrogroup";
        String code = "M010";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322, 313C, M313, 321, 315 AND
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
        // Pinus strobiformis, Quercus hypoleucoides, Quercus gambelii and Quercus rugosa
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%))

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "322, 313C, M313, 321, 315")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus gravesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_077() {

        // Madrean Pinyon - Juniper Woodland (G200)
        // G200

        String level = "group";
        String code = "G200";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 313D?, 315, 313B, M313A, M313B, 321,
        // 313A, 322A, 313C, 322B and tree composition dominated by one or more
        // of STRONG DIAGNOSTIC species Juniperus coahuilensis, Juniperus deppeana,
        // Juniperus flaccida, Juniperus pinchotii, Pinus cembroides,
        // Pinus discolor, Pinus edulis, or Pinus monophylla, Pinus remota (RIV=>50%),
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313D, 315, 313B, M313A, M313B, 321, 313A, 322A, 313C, 322B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus pinchotii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<List<KeyValue>> OTHER_INDICATOR_SPECIES_patterns = Arrays.asList(
            OTHER_INDICATOR_SPECIES_pattern0,
            OTHER_INDICATOR_SPECIES_pattern1,
            OTHER_INDICATOR_SPECIES_pattern2,
            OTHER_INDICATOR_SPECIES_pattern3,
            OTHER_INDICATOR_SPECIES_pattern4,
            OTHER_INDICATOR_SPECIES_pattern5,
            OTHER_INDICATOR_SPECIES_pattern6,
            OTHER_INDICATOR_SPECIES_pattern7
        );
        PatternList OTHER_INDICATOR_SPECIES = new PatternList("OTHER_INDICATOR_SPECIES", OTHER_INDICATOR_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(OTHER_INDICATOR_SPECIES) >= 1) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_078() {

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
        // combination of Arbutus arizonica, Arbutus xalapensis, Quercus gambelii, or Pinus ponderosa (>=30% RIV;
        // i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
        // OR
        // iii. Located in above ECOREGION, and tree composition as i. above,
        // but with =>20% RIV AND with other INDICATOR species
        // Juniperus coahuilensis, Juniperus deppeana, Pinus cembroides, and
        // Pinus discolor, Pinus arizonica, Pinus engelmannii, Pinus leiophylla,
        // or Pinus strobiformis (RIV >= 1%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313D, 315H, M313A, M313B, 315A, 321, 322A, 313C, 322B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus oblongifolia")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus engelmannii")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> OTHER_INDICATOR_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<List<KeyValue>> OTHER_INDICATOR_SPECIES_patterns = Arrays.asList(
            OTHER_INDICATOR_SPECIES_pattern0,
            OTHER_INDICATOR_SPECIES_pattern1,
            OTHER_INDICATOR_SPECIES_pattern2,
            OTHER_INDICATOR_SPECIES_pattern3,
            OTHER_INDICATOR_SPECIES_pattern4,
            OTHER_INDICATOR_SPECIES_pattern5,
            OTHER_INDICATOR_SPECIES_pattern6,
            OTHER_INDICATOR_SPECIES_pattern7
        );
        PatternList OTHER_INDICATOR_SPECIES = new PatternList("OTHER_INDICATOR_SPECIES", OTHER_INDICATOR_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(OTHER_INDICATOR_SPECIES) >= 1) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_079() {

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
        // combination of Juniperus monosperma, Prosopis glandulosa, or Prosopis velutina (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315B, 315A, M313A, 322, M313B, 315C, 321, 315D, 313A, 313D, M262B, 313C, 315H")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus coahuilensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Prosopis velutina")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_080() {

        // Madrean Montane Forest & Woodland (M011)
        // M011

        String level = "macrogroup";
        String code = "M011";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322, 313C, M313, 321, 315, AND tree composition
        // dominated by one or more of STRONG DIAGNOSTIC species
        // Juniperus deppeana, Pinus arizonica, Pinus engelmannii, Pinus leiophylla, Pinus ponderosa,
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
        // Pinus discolor, Pinus edulis, Pseudotsuga menziesii
        // Quercus gravesii and Quercus muehlenbergii
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "322, 313C, M313, 321, 315")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus albocincta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus gravesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_081() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "341Fb, 341Fc, 341Fd, 322Ab, 322Aa, 322Az, 322Ac, 341Fk, 341Fe, 322Ad, 322Ay, 322Ae, 341Ff, 322As, 322Ar, 322Aq, 322Ag, 322Af, 322At, 313Ao, 322Ah, 322Ai, 322Aj, 322Av, 322Am, 313De, 322Aw, 322Al, 322Ax, 322Ao, 322An, 313Df, M313Ak, M313Al, 322Ba, 322Ap, 313Cd, 313Bo, 313Ca, M313Af, 315Ha, M313Ah, 313Cc, M313Am, M313Ad, M313Bf, 321Ag, 322Bh, M313Ag, 321Ai, M313Ae, 321Ak, 321Af, M313Bg, M313Ac, 315Aa, 321Aj, 321Am, M313Ba, 321Ac, 321Ah")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies coahuilensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus gravesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_082() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315A, 315H, 313D, 322B, M313A, M313B, 321, 322A, 313C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Cupressus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus arizonica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus leiophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Arbutus xalapensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus flaccida")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus discolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus emoryi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus fulva")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus gravesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus hypoleucoides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus rugosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus viminea")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_083() {

        // Western North American Ruderal Forests - Madrean-Balconian (D060)
        // D060

        String level = "division";
        String code = "D060";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or
        // weedy native vegetation that invades natural stands or vegetation
        // that dominates on formerly cleared and/or planted sites but which
        // has been allowed to succeed more-or-less spontaneously).
        // Tree composition dominated by EXOTIC = Y (>= 80% RIV)
        // (See Appendix xx [PLACEHOLDER])

        List<KeyValue> EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_patterns = Arrays.asList(
            EXOTIC_pattern0
        );
        PatternList EXOTIC = new PatternList("EXOTIC", EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_084() {

        // LC Madrean Montane Forest & Woodland (M011LC)
        // M011LC

        String level = "macrogroup";
        String code = "M011LC";

        // Not as above.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_085() {

        // Cool Temperate Forest & Woodland Subbiome(S92)
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

    public Object[] element_086() {

        // North American Pacific Coast Temperate Rainforest (D338)
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
        //   c.  Any EXOTIC = Y tree species =>80% RIV
        // 
        // TRANSLATES TO:
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
        //   vii. Any EXOTIC = Y tree species >= 80%

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242A, M242, 261A, M261A, M261B, 263")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> ECOREGIONS_2_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242A, M242A, M242B, 261A, M261A, M261B, 263")
        );
        List<List<KeyValue>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new KeyValue("species", "Sequoia sempervirens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_1_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern7
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_1 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_1", STRONG_DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern6 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern7 = Arrays.asList(
            new KeyValue("species", "Sequoia sempervirens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern8 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern9 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_2_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern9
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_2 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_2", STRONG_DIAGNOSTIC_SPECIES_2_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern2 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern5 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern6 = Arrays.asList(
            new KeyValue("species", "Sequoia sempervirens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern7 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_3_pattern8 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_3_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_3_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_3_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_3 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_3", STRONG_DIAGNOSTIC_SPECIES_3_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer circinatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Cornus nuttallii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Frangula purshiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

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

    public Object[] element_087() {

        // North Pacific Coastal Rainforest (M024)
        // M024

        String level = "macrogroup";
        String code = "M024";

        // Only macrogroup

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_088() {

        // Coastal Redwood Forest (G235)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M262A, M242A, M261A, 263, M261B, 261A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Sequoia sempervirens")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_089() {

        // Coastal Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242D, M261A, M261D, M242A, M242B, 242")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Cornus nuttallii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Frangula purshiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Malus fusca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Prunus emarginata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_090() {

        // Coastal Douglas-fir - Western Hemlock Rainforest (G240)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261A, M242A, M261A, M261B, 263, 242, M242B, M242D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Malus fusca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Prunus emarginata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_091() {

        // Coastal Silver Fir - Western Hemlock Rainforest(G241)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242, 242")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Malus fusca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Prunus emarginata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_092() {

        // Coastal Western Hemlock - Sitka Spruce Rainforest (G751)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261A, M261A, M261B, M242A, M242B, M242D, 242, 263")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer circinatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Alnus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Frangula purshiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Malus fusca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Prunus emarginata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_093() {

        // Western North American Pinyon-Juniper Woodland & Scrub Division (D010)
        // D010

        String level = "division";
        String code = "D010";

        // Tree composition and ecology matching one of the following options:
        // i.  Located in ECOREGION M242C, M261D, M261E, M261G, M262B, 313, M313, 315,
        //   321, 322, 331B, 331I, 331J, M331, M332, 341, M341, 342
        // AND
        // ii.  EITHER
        //   a.  Tree composition dominated by one or more of STRONG diagnostic
        //   tree species Cercocarpus ledifolius, Juniperus monosperma,
        //   Juniperus occidentalis, Juniperus osteosperma, Juniperus scopulorum, Pinus edulis, or
        //   Pinus monophylla (=>50% RIV),
        //   OR
        //   b.  The above tree species, but with =>20% RIV AND other MODERATE 
        //   diagnostic species of Juniperus californica, Juniperus deppeana,
        //   Juniperus grandis, Pinus jeffreyi,
        //   Pinus ponderosa, or Quercus gambelii (>=30% RIV; i.e.,
        //   together STRONG and MODERATE diagnostic species =>50% RIV)
        //   OR
        //   c.  Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M261D, M261E, M261G, M262B, 313, M313, 315, 321, 322, 331B, 331I, 331J, M331, M332, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Cercocarpus ledifolius")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
           && ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
           || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30)
           || plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_094() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, 342, M332, M261D, M261E, M261G, 315, 313, M313, 321, M331D, M331E, M331F, M331G, M331H, M331I, M331J, 341, M262B, 322, 331I, 331J, M333, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Cercocarpus ledifolius")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_095() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "341E, 341G, 342D, M242B, M332A, M261A, M261F, M242C, 342H, 342I, 342B, 342C, M332G, M261D, M261E, M261G")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Cercocarpus ledifolius")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_096() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "322B, 341B, 341C, 342F, 342A, 342G, 342I, 342E, M242B, M261A, M261B, M261F, M262B, M332A, M331G, M331H, M242C, M332E, M332F, M332G, M332B, M332D, M261D, M261E, M261G, 342H, 342B, 342D, 342C, 342J, M331A, M331B, M331E, M331J, M331D, 313A, 341A, 341F, 341E, 341D, 341G, 322A, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Cercocarpus ledifolius")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "placeholder - add moderate diagnostic")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_097() {

        // Great Basin Pinyon - Juniper Woodland (G899)
        // G899

        String level = "group";
        String code = "G899";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322B, 342D, 342H, M242C, 313, 322A, 341A,
        // 341D, 341E, 341F, 341G, 342B, 342C, 342J, M261F, M261E, M261G,
        // M262B, M331D, M341A, M341D, M341C
        // and tree composition dominated by the STRONG
        // DIAGNOSTIC species Juniperus osteosperma or Pinus monophylla (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
        // Cercocarpus ledifolius, Juniperus californica, Juniperus occidentalis,
        // or Pinus jeffreyi (>=30% RIV; i.e., together
        // STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "322B, 342D, 342H, M242C, 313, 322A, 341A, 341D, 341E, 341F, 341G, 342B, 342C, 342J, M261F, M261E, M261G, M262B, M331D, M341A, M341D, M341C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Cercocarpus ledifolius")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_098() {

        // Colorado Plateau Pinyon - Juniper Woodland (G900)
        // G900

        String level = "group";
        String code = "G900";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION 322B, 342E, 342D, 331I, 315A, 315H, 313,
        // 322A, M313A, M313B, M331, 331J,
        // 342G, 341A, 341B, 341C, 341F, M341B, M341C
        // and tree composition dominated by one or more of STRONG DIAGNOSTIC
        // species Juniperus osteosperma or Pinus edulis (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Juniperus monosperma, Quercus gambelii, Quercus grisea  or
        // Juniperus scopulorum (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "322B, 342E, 342D, 331I, 315A, 315H, 313, 322A, M313A, M313B, M331, 331J, 342G, 341A, 341B, 341C, 341F, M341B, M341C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus grisea")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_099() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313A, 313B, 313D, 322A, 341, 342B, 342J, M331D, M331E, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Cercocarpus ledifolius")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus californica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_100() {

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
        // combination of Juniperus scopulorum or Juniperus deppeana
        // [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES]
        // (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315, 313, M313, 321, 342, M331, 341, 322, 331B, 331I, 331J, M341B, M341C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_101() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "321A, 315A, 315H, 315B, 313B, 313D, M313, M331G, M331F, M331I, 331B, 331I, 331J")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_102() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315A, 315B, 315H, 313B, 313D, M313, 321A, M331G, M331F, 331B, 331J, 331I")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus monosperma")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_103() {

        // LC Intermountain Pinyon-Juniper Woodland (M896LC)
        // M896LC

        String level = "macrogroup";
        String code = "M896LC";

        // Not as above.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_104() {

        // Californian-North Pacific Foothills Forest & Woodland (D339)
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
        //     Arbutus menziesii, Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana, Picea breweriana, 
        //     Pinus coulteri, Pinus flexilis, Pinus lambertiana, Pinus muricata, 
        //     Pinus washoensis, Populus balsamifera ssp. trichocarpa, 
        //     Pseudotsuga macrocarpa (>=40% RIV; i.e., together STRONG and MODERATE 
        //     diagnostic species =>50% RIV) 
        //     OR 
        //     f.  Any EXOTIC = Y tree species =>80% RIV 
        // OR 
        //   M242C and M242D Exclusion/Exception for Pinus contorta, Pinus ponderosa, and 
        //   Pseudotsuga menziesii: Tree composition and ecology matching one of the 
        //   following options: 
        //   iii.  Located in ECOREGION 242, M242A, M242B, M261, 261A, 262, 263, 341D 
        //   AND 
        //   iv.  EITHER 
        //       a.  Tree composition dominated by one or more of STRONG diagnostic tree 
        //           species Abies amabilis, Abies concolor, Abies grandis, Abies lasiocarpa, Abies magnifica, Abies shastensis [Abies magnifica var. shastensis], Abies procera, Calocedrus decurrens, , Chrysolepis chrysophylla, Juniperus occidentalis, Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monticola, Quercus chrysolepis, Quercus garryana, Quercus kelloggii, Sequoiadendron giganteum, Taxus brevifolia, Tsuga mertensiana, or Umbellularia californica (=>20% RIV) 
        //       OR 
        //       b.  The above tree species, but with =>10% RIV AND other MODERATE 
        //           diagnostic species, any combination of Abies bracteata, Abies concolor var. lowiana, Acer circinatum, Acer macrophyllum, Arbutus menziesii, Cornus nuttallii, Frangula purshiana, Picea breweriana, Pinus coulteri, Pinus flexilis, Pinus lambertiana, Pinus contorta, Pinus muricata, Pinus washoensis, Populus balsamifera ssp. trichocarpa, Pseudotsuga macrocarpa (>=40% RIV; i.e., together STRONG and 
        //           MODERATE diagnostic species =>50% RIV) 
        //       OR 
        //       d.  Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_I_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242, M261, 261A, 262, 263, 341D")
        );
        List<List<KeyValue>> ECOREGIONS_I_patterns = Arrays.asList(
            ECOREGIONS_I_pattern0
        );
        PatternList ECOREGIONS_I = new PatternList("ECOREGIONS_I", ECOREGIONS_I_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies magnifica var. shastensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern5 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern6 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern7 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern8 = Arrays.asList(
            new KeyValue("species", "Lithocarpus densiflorus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern14 = Arrays.asList(
            new KeyValue("species", "Sequoiadendron giganteum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern15 = Arrays.asList(
            new KeyValue("species", "Taxus brevifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern16 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern17 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern18 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern19 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_I_pattern20 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_I_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_I_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern18,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern19,
            STRONG_DIAGNOSTIC_SPECIES_I_pattern20
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_I = new PatternList("STRONG_DIAGNOSTIC_SPECIES_I", STRONG_DIAGNOSTIC_SPECIES_I_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies bracteata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer circinatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern3 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern4 = Arrays.asList(
            new KeyValue("species", "Cornus nuttallii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern5 = Arrays.asList(
            new KeyValue("species", "Frangula purshiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea breweriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus lambertiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus washoensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern12 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera ssp. trichocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern13 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_I_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_I_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern13,
            MODERATE_DIAGNOSTIC_SPECIES_I_pattern14
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_I = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_I", MODERATE_DIAGNOSTIC_SPECIES_I_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        List<KeyValue> ECOREGIONS_II_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242A, M242B, M261, 261A, 262, 263, 341D")
        );
        List<List<KeyValue>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new KeyValue("species", "Abies magnifica var. shastensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus lambertiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern16 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern20 = Arrays.asList(
            new KeyValue("species", "Sequoiadendron giganteum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern21 = Arrays.asList(
            new KeyValue("species", "Taxus brevifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern22 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern23 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_II_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern18,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern19,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern20,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern21,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern22,
            STRONG_DIAGNOSTIC_SPECIES_II_pattern23
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_II = new PatternList("STRONG_DIAGNOSTIC_SPECIES_II", STRONG_DIAGNOSTIC_SPECIES_II_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies bracteata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer circinatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new KeyValue("species", "Cornus nuttallii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new KeyValue("species", "Frangula purshiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea breweriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus washoensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera ssp. trichocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_II = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_II", MODERATE_DIAGNOSTIC_SPECIES_II_patterns);

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

    public Object[] element_105() {

        // Californian-North Pacific Vancouverian Dry Foothill Forest & Woodland (M886)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242, 242, M261, 263, 262")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Notholithocarpus densiflorus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies bracteata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Taxus brevifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_106() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242B, 262A, 261A, 261B, 342H, M242D, M262A, M242C, M261D, M242A, M261A, 263, M261G, M261B, 342I, M242B, 242A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_107() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "262A, M261C, M261E, 263, M242A, M261A, M261D, M261F, M261B, M262, 261, M242B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Lithocarpus densiflorus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Umbellularia californica")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies bracteata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis lawsoniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus coulteri")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_108() {

        // North Pacific Douglas-fir - Madrone Dry Woodland (G800)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261A, 263A, M261D, M261B, M242B,  M242A, M261A, 242")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer macrophyllum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus garryana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Taxus brevifolia")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_109() {

        // Coastal Shore Pine Forest & Woodland (G205)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242, M242A, M261A, 263")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Arbutus menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus muricata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea sitchensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_110() {

        // Sierran-Californian Montane-Foothill Forest & Woodland (M023)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M261, 262, 263, 341D, M242B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus lambertiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Sequoiadendron giganteum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea breweriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus washoensis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_111() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "261B, 262A, 341E, 322A, M242A, 263, M261, 341D, M242C, 342B, M262, M242B, 261A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Calocedrus decurrens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus lambertiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus chrysolepis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus kelloggii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Sequoiadendron giganteum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies bracteata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Chrysolepis chrysophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea breweriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus washoensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_112() {

        // Vancouverian Ruderal Forest (M405)
        // M405

        String level = "macrogroup";
        String code = "M405";

        // Only one Macrogroup

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.riv(EXOTIC_TREE_SPP) >=80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_113() {

        // North Pacific Ruderal Forest (G801)
        // G801

        String level = "group";
        String code = "G801";

        // Plots with greater than 80% non-native RIV.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_114() {

        // LC Californian-North Pacific Vancouverian Dry Foothill Forest & Woodland (M886LC)
        // M886LC

        String level = "macrogroup";
        String code = "M886LC";

        // Not as above.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_115() {

        // Rocky Mountain Foothills & Montane Forest & Woodland (D337)
        // D337

        String level = "division";
        String code = "D337";

        // Tree composition and ecology matching one of the following options:
        // i.  Elevation below 2800 meters and located in ECOREGION M242C,
        //     M242D – only eastern ecosubsections M242D,
        //     313A, 313B, 313C, 313D, 315A, 315B, 315F, 315H, 321, M313, 322A, 331, M331,
        //     M332, M333, M334, 341, M341, 342   
        // AND
        // ii.  EITHER
        //     a.  Tree composition dominated by one or more of STRONG diagnostic tree
        //     species Abies concolor, Abies grandis, Abies lasiocarpa,
        //     Acer grandidentatum, Juniperus scopulorum, Larix lyallii,
        //     Larix occidentalis, Picea glauca, Picea pungens, Pinus contorta,
        //     Pinus flexilis, Pinus ponderosa, Pinus longaeva, Populus tremuloides, Pseudotsuga menziesii,
        //     Quercus gambelii, Thuja plicata, Tsuga heterophylla, or Tsuga mertensiana (=>50% RIV),
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
        //     c.  Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242D, 313A, 313B, 313C, 313D, 315A, 315B, 315F, 315H, 321, M313, 322A, 331, M331, M332, M333, M334, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Larix lyallii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Pinus longaeva")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_pattern18
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa var. arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa var. lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9,
            MODERATE_DIAGNOSTIC_SPECIES_pattern10,
            MODERATE_DIAGNOSTIC_SPECIES_pattern11,
            MODERATE_DIAGNOSTIC_SPECIES_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_pattern13
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.get_elevation() < 2800 && plot.match(ECOREGIONS) && 
           ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && 
           plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) ||
           plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_116() {

        // Southern Rocky Mountain Montane Forest & Woodland (M022)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315A, 315B, 315F, 315H, 313A, 313B, 313C, 313D, M313, 342J, 342G, 342E, 342F, M331D, M331F, M331G, M331H, M331E, M331I, 331H, 331C, 331B, 331I, 331J, 341, M341, 322A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus aristata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus longaeva")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa var. arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa var. lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_117() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "342D, 342C, 313A, 313B, 313D, 322A, 331H, 331I, 331J, 341, 342B, 342E, 342F, 342G, 342J, M261E, M331D, M331E, M331F, M331G, M331H, M331I, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus longaeva")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_118() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315A, 315H, 321A, 322A, 331B, 331G, 331J, 331H, 331I, 341C, 341F, 341G, 342E, 342F, 342G, M341A, 313A, 313B, 313C, M313, 342D, 342J, M331D, M331E, M331F, M331G, M331H, M331I, M341B, M341C, 341A, 341B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer grandidentatum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_119() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313D, 315A, 315B, 315H, 322B, 331F, 331G, 331H, 341C, 342F, 342G, 313A, 313B, 313C, M313, 321A, 322A, 341A, 341B, 341F, 342D, 342E, 342J, 331B, 331I, 331J, M331D, M331E, M331F, M331G, M331H, M331I, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa var. arizonica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_120() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315F, 322B, 331C, 331N, 341A, 341C, M331D, M331J, M341A, 313, 315A, 315B, 315H, 321A, 322A, M313, 331B, 331F, 331G, 331H, 331I, 331J, 341B, 341F, 342A, 342E, 342F, 342G, M331A, M331B, M331E, M331F, M331G, M331H, M331I, M341B, M341C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus gambelii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus deppeana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus longaeva")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus strobiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_121() {

        // Central Rocky Mountain Montane Forest & Woodland (M501)
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
        // Abies lasiocarpa, Juniperus osteosperma, Juniperus scopulorum, Picea engelmannii, Picea glauca, Pinus contorta, Pinus ponderosa, Populus tremuloides, Pseudotsuga menziesii
        // Pinus flexilis(RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
        // combination of Acer negundo, Betula papyrifera,
        // Fraxinus pennsylvanica, Quercus macrocarpa,
        // or Ulmus americana
        // (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242D, M332, M333, 331N, 342H, 331M, 342B, 331E, 331A, 331K, 342D, M331A, 342A, 331G, M331B, 342C, M334A, 342F, M331J, M331D, 331D, 342I, 331L, 342G, 331F, M331E")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_122() {

        // Central Rocky Mountain Montane White Spruce Forest (G345)
        // G345

        String level = "group";
        String code = "G345";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M334A, 331Dh, 331Ea, 331Fb, 331Fd, 331Fj, 331Ge, 331Gf, 331Kb, 331Kf, 331La, 331Ma, 331Mc, 331Me, 331Mi and tree composition dominated by one
        // or more of STRONG DIAGNOSTIC species Picea glauca or Populus tremuloides (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
        // Abies lasiocarpa, Picea engelmannii, Pinus contorta,
        // Pinus ponderosa or Pseudotsuga menziesii in any
        // combination of (>=30% RIV; i.e., together STRONG and MODERATE
        // diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M334A, 331Dh, 331Ea, 331Fb, 331Fd, 331Fj, 331Ge, 331Gf, 331Kb, 331Kf, 331La, 331Ma, 331Mc, 331Me, 331Mi")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_123() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331E, 331D, 331F, 331G, 331H, 331L, 331N, 331M, 331K, M332Db, M332Dc, M331Ah, M331Ai, M331Ar, M331B, M334A, 332D, 332C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> PSME_pattern0 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> PSME_patterns = Arrays.asList(
            PSME_pattern0
        );
        PatternList PSME = new PatternList("PSME", PSME_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50) || 
           (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) && 
           (plot.match(ECOREGIONS) && plot.riv(PSME) <= 1)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_124() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M332A, M332B, M332E, M332F, M333C, M334A, 341A, 341B, 342D, 331B, 331D, 331F, 331G, 331K, 331N, M332D, 342A, 342E, 342F, 342G, M331A, M331B, M331D, M331E, M331H, M331I, M331J")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "PLACEHOLDER - INSERT P2 VEG")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_125() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M261G, 331D, 342A, 342B, 342F, 342G, M331J, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332, M333, M331A, M331B, M331D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> PSME_pattern0 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> PSME_patterns = Arrays.asList(
            PSME_pattern0
        );
        PatternList PSME = new PatternList("PSME", PSME_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50) || 
           (plot.match(ECOREGIONS) && plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) && 
           (plot.match(ECOREGIONS) && plot.riv(PSME) <= 10)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_126() {

        // Central Rocky Mountain Douglas-fir Mesic Forest (G215)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A, 331E, 331F, 331M, M331E, M332G, M333C, M333D, 331D, 331G, 331K, 331L, 331N, 342A, 342D, 342E, 342F, 342G, M332A, M332B, M332D, M332E, M332F, M331A, M331B, M331D, M331J")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus osteosperma")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_127() {

        // Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)
        // G210

        String level = "group";
        String code = "G210";

        // Plot location and tree composition are as follows:
        // i. Located in ECOREGION M261G, 331D, 342A, 342B, 342F, 342G,
        // M242C, M242D - only eastern ecosubsections M242Dd, M242De, M242Df,
        // M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332,
        // M333, M331 and tree composition dominated by one or
        // more of STRONG DIAGNOSTIC species Abies lasiocarpa, Pinus contorta, Pinus ponderosa, Picea engelmannii, or
        // Pseudotsuga menziesii (RIV=>50%),
        // OR
        // ii. Located in above ECOREGION, and tree composition as above, but
        // with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
        // combination of Larix occidentalis`, Pinus monticola,
        // or Picea glauca (>=30% RIV; i.e., together STRONG
        // and MODERATE diagnostic species RIV =>50%)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M261G, 331D, 342A, 342B, 342F, 342G, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332, M333, M331")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_128() {

        // Central Rocky Mountain-Interior Moist Montane Forest (M500)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242D, 331N, 342H, M332, M333, 331A, 331K, 342D, M331A, M331B, 342A, 331G, 342F, M331J, M331D, 331D, 342I, 342G")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_129() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M261D, M261E, M261G, 342H, 342I, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_130() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M332F, M332G, 331D, 342I, M333, 331A, M332A, M332B, M242Dd, M242De, M242Df, M242Dg, M242Dh")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_131() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, 331D, 331G, 331N, 342A, 342D, 342E, 342F, 342G, 342I, M331J, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331K, 342H, M332, M331A, M331B, M331D, M333")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies grandis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Larix occidentalis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Thuja plicata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_132() {

        // LC Central Rocky Mountain Montane Forest & Woodland (M501LC)
        // M501LC

        String level = "macrogroup";
        String code = "M501LC";

        // Not as above.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_133() {

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
        //     f.  Any EXOTIC = Y tree species =>80% RIV

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242A, 242B, 242C, M242A, M242B, M242C, M242D, M261, 313A, 313B, 313C, M313, 315A, 315H, 321A, 322A, 322B, 331, M331, M332, M333, M334, 341, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies magnifica var. shastensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_pattern16
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus balfouriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> EXOTIC_TREE_SPP_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_TREE_SPP_patterns = Arrays.asList(
            EXOTIC_TREE_SPP_pattern0
        );
        PatternList EXOTIC_TREE_SPP = new PatternList("EXOTIC_TREE_SPP", EXOTIC_TREE_SPP_patterns);

        INodeMatch match = plot -> (
            plot.get_elevation() > 2100 && plot.match(ECOREGIONS) && 
           ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || 
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && 
           plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) || 
           plot.riv(EXOTIC_TREE_SPP) >= 80))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_134() {

        // Rocky Mountain Subalpine-Upper Montane Forest & Woodland (M020)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M333, M334, 331, M331, 342, M332, 313A, 313B, M313, M341, 341, 322A, 315A, 315B, 315H")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix lyallii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea pungens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_135() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313C, 315A, 315H, 321A, 322A, 322B, M242B, M261A, M261D, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M261E, M261G, 313A, 313B, 331, 341, 342, M332, M313, M331, M341, M333, M334")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 75
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_136() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "313A, 313B, 322A, M313, 341A, 341B, 341F, 341G, 331A, 331B, 331D, 331G, 331H, 331I, 331J, 331K, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M261D, M332, M331, 342, M333, M341B, M341C")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_137() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242B, M261D, M313B, 313C, 315H, 322A, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 313A, 313B, M313A, 342, 341, M331, 331, M332, M333, M341")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_138() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242B, 313B, 341B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh,  M332, M333, 342, M331, 331")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_139() {

        // Rocky Mountain Montane-Subalpine Limber Pine Woodland (G101)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "315A, 313A, 313B, 313C, 322A, 341B, 341G, M313B, M333C, M261E, M313A, 331, M332, M331, M341, 342")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus scopulorum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus ponderosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus balfouriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus monophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_pattern5,
            MODERATE_DIAGNOSTIC_SPECIES_pattern6,
            MODERATE_DIAGNOSTIC_SPECIES_pattern7,
            MODERATE_DIAGNOSTIC_SPECIES_pattern8,
            MODERATE_DIAGNOSTIC_SPECIES_pattern9
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_140() {

        // Central Rocky Mountain Whitebark Pine - Subalpine Larch Woodland (G223)
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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331A, 331D, 331K, 331N, M261G, M242B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 341G, 342, M331A, M331B, M331D, M331J, M332, M333")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Larix lyallii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pseudotsuga menziesii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_141() {

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

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242A, M242B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 242, M261, 263, 341D")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> ECOREGIONS_2_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242Db, M242A, M242B, M242C, M242Da, M242Db, 242, M261, 263, 341D")
        );
        List<List<KeyValue>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies magnifica var. shastensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus balfouriana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern9 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern10 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_1_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_1_pattern10
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_1 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_1", STRONG_DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies magnifica var. shastensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern5 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus balfouriana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern10 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern11 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern12 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_2_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern12
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_2 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_2", STRONG_DIAGNOSTIC_SPECIES_2_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_1_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_1_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_1_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_1 = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_1", MODERATE_DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_2 = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_2", MODERATE_DIAGNOSTIC_SPECIES_2_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50) ||
           (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES_1) >= 30) ||
           (plot.match(ECOREGIONS_2) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 50) ||
           (plot.match(ECOREGIONS_2) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES_2) >= 30)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_142() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "342B, M242D, M242B, M242C, M261, 341D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus occidentalis")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus balfouriana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_143() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "242B, 342B, M242B, M242C, M261, 341D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies magnifica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies magnifica var. shastensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies procera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus albicaulis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus contorta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus jeffreyi")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus monticola")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Abies concolor")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_144() {

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

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "M242C, M261B, 242A, M242A, M242B, M242D")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies amabilis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea engelmannii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Tsuga mertensiana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies lasiocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Callitropsis nootkatensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Tsuga heterophylla")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && 
           ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 ||
           (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) )
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_145() {

        // LC Rocky Mountain Subalpine-High Montane Forest (M020LC)
        // M020LC

        String level = "macrogroup";
        String code = "M020LC";

        // Not as above.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

}
