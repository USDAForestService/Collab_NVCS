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

public class ClassificationKeyEast extends ClassificationKey {

    public Map<Integer,Node> nodes;
    public Node root_node;

    public ClassificationKeyEast() {

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
        nodes.put(  1,  new Node(  1,   0, element_001(), "Forest Plantation Anthro-Division (CSF05)"));
        nodes.put(  2,  new Node(  2,   1, element_002(), "Tropical Forest Plantation Anthro-macrogroup (CGR008)"));
        nodes.put(  3,  new Node(  3,   2, element_003(), "Caribbean Forest Plantation Anthro-group (CSG008)"));
        nodes.put(  4,  new Node(  4,   3, element_004(), "Caribbean Conifer Plantations"));
        nodes.put(  5,  new Node(  5,   4, element_005(), "Native Caribbean Conifer Plantation Anthro-type (CTY001)"));
        nodes.put(  6,  new Node(  6,   4, element_006(), "Exotic Caribbean Forest Plantation Anthro-type (CTY002)"));
        nodes.put(  7,  new Node(  7,   3, element_007(), "Caribbean Hardwood Plantations"));
        nodes.put(  8,  new Node(  8,   7, element_008(), "Native Caribbean Hardwood Plantation Anthro-type (CTY003)"));
        nodes.put(  9,  new Node(  9,   7, element_009(), "Exotic Caribbean Hardwood Plantation Anthro-type (CTY004)"));
        nodes.put( 10,  new Node( 10,   3, element_010(), "Miscellaneous Caribbean Plantation Anthro-type (CTY019)"));
        nodes.put( 11,  new Node( 11,   1, element_011(), "Temperate & Boreal Forest Plantation Anthro-macrogroup (CGR007)"));
        nodes.put( 12,  new Node( 12,  11, element_012(), "Eastern North American Temperate Forest Plantation Anthro-group (CSG005)"));
        nodes.put( 13,  new Node( 13,  12, element_013(), "Eastern North American Conifer Plantations"));
        nodes.put( 14,  new Node( 14,  13, element_014(), "Native Eastern North American Conifer Plantations"));
        nodes.put( 15,  new Node( 15,  14, element_015(), "Native Southern Pine Plantation Anthro-type (CTY012)"));
        nodes.put( 16,  new Node( 16,  15, element_016(), "Shortleaf Pine Forest Plantation (CST007169)"));
        nodes.put( 17,  new Node( 17,  15, element_017(), "Longleaf Pine Forest Plantation (CST007176)"));
        nodes.put( 18,  new Node( 18,  15, element_018(), "Slash Pine Forest Plantation (CST007170)"));
        nodes.put( 19,  new Node( 19,  15, element_019(), "Loblolly Pine Forest Plantation (CST007179)"));
        nodes.put( 20,  new Node( 20,  15, element_020(), "Sand Pine Forest Plantation (CST007168)"));
        nodes.put( 21,  new Node( 21,  15, element_021(), "Native Miscellaneous Southern Pine Forest Plantation (CST007160)"));
        nodes.put( 22,  new Node( 22,  14, element_022(), "Native Northern Conifer Plantation"));
        nodes.put( 23,  new Node( 23,  22, element_023(), "Native Northern Pine Plantation Anthro-type (CTY009)"));
        nodes.put( 24,  new Node( 24,  23, element_024(), "Red Pine Forest Plantation (CST007117)"));
        nodes.put( 25,  new Node( 25,  23, element_025(), "White Pine Forest Plantation (CST007178)"));
        nodes.put( 26,  new Node( 26,  23, element_026(), "Jack Pine Forest Plantation (CST007161)"));
        nodes.put( 27,  new Node( 27,  23, element_027(), "Native Miscellaneous Northern Pine Forest Plantation"));
        nodes.put( 28,  new Node( 28,  22, element_028(), "Native Northern Spruce - Fir Plantation Anthro-type (CTY010)"));
        nodes.put( 29,  new Node( 29,  28, element_029(), "White Spruce Forest Plantation (CST007164)"));
        nodes.put( 30,  new Node( 30,  28, element_030(), "Balsam Fir Forest Plantation (CST007182)"));
        nodes.put( 31,  new Node( 31,  28, element_031(), "Red Spruce Forest Plantation (CST004758)"));
        nodes.put( 32,  new Node( 32,  28, element_032(), "Native Miscellaneous Northern Conifer Forest Plantation (CST007163)"));
        nodes.put( 33,  new Node( 33,  13, element_033(), "Exotic Eastern North American Conifer Plantations"));
        nodes.put( 34,  new Node( 34,  33, element_034(), "Exotic Northern Conifer Plantation Anthro-type (CTY014)"));
        nodes.put( 35,  new Node( 35,  34, element_035(), "Scotch Pine Exotic Forest Plantation (CST006313)"));
        nodes.put( 36,  new Node( 36,  34, element_036(), "Norway Spruce Forest Plantation (CST007167)"));
        nodes.put( 37,  new Node( 37,  34, element_037(), "Larch Forest Plantation (CST006408)"));
        nodes.put( 38,  new Node( 38,  34, element_038(), "Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)"));
        nodes.put( 39,  new Node( 39,  33, element_039(), "Exotic Southern Conifer Plantation Anthro-type (CTY015)"));
        nodes.put( 40,  new Node( 40,  39, element_040(), "Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)"));
        nodes.put( 41,  new Node( 41,  12, element_041(), "Eastern North American Hardwood Plantation"));
        nodes.put( 42,  new Node( 42,  41, element_042(), "Native Eastern North American Hardwood Plantations"));
        nodes.put( 43,  new Node( 43,  42, element_043(), "Native Northern Hardwood Forest Plantation Anthro-type (CTY016)"));
        nodes.put( 44,  new Node( 44,  43, element_044(), "Black Walnut Forest Plantation (CST007188)"));
        nodes.put( 45,  new Node( 45,  43, element_045(), "Aspen Forest Plantation (CST007189)"));
        nodes.put( 46,  new Node( 46,  43, element_046(), "Black Locust Forest Plantation (CST007190)"));
        nodes.put( 47,  new Node( 47,  43, element_047(), "Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)"));
        nodes.put( 48,  new Node( 48,  42, element_048(), "Native Southern Hardwood Forest Plantation Anthro-type (CTY017)"));
        nodes.put( 49,  new Node( 49,  48, element_049(), "Tuliptree Forest Plantation (CST007197)"));
        nodes.put( 50,  new Node( 50,  48, element_050(), "Sweetgum Forest Plantation Subtype (CST007450)"));
        nodes.put( 51,  new Node( 51,  48, element_051(), "Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)"));
        nodes.put( 52,  new Node( 52,  41, element_052(), "Exotic Eastern North American Hardwood Plantations"));
        nodes.put( 53,  new Node( 53,  52, element_053(), "Exotic Northern Hardwood Plantation Anthro-type (CTY018)"));
        nodes.put( 54,  new Node( 54,  52, element_054(), "Exotic Southern Hardwood Plantation Anthro-type (CTY019a)"));
        nodes.put( 55,  new Node( 55,  11, element_055(), "North American Boreal Forest Plantation Cultural Subgroup"));
        nodes.put( 56,  new Node( 56,   0, element_056(), "Natural and Ruderal Forests"));
        nodes.put( 57,  new Node( 57,  56, element_057(), "Wetland Forest & Woodlands Key"));
        nodes.put( 58,  new Node( 58,  57, element_058(), "Brackish Tidal Wetland Biome (MB1), Coastal Brackish Tidal Wetland Subbiome (MB1.a), Mangrove Ecobiome, (MB1.a2) and Atlantic-Caribbean & East Pacific Mangrove (D004)."));
        nodes.put( 59,  new Node( 59,  58, element_059(), "Tropical Florida Natural Mangrove Forests"));
        nodes.put( 60,  new Node( 60,  59, element_060(), "Western Atlantic & Caribbean Mangrove (M005)"));
        nodes.put( 61,  new Node( 61,  58, element_061(), "Tropical Florida Ruderal Mangrove Forests"));
        nodes.put( 62,  new Node( 62,  57, element_062(), "Palustrine Wetland Biome (TP1), Forested Wetland Subbiome (TP1.a)"));
        nodes.put( 63,  new Node( 63,  62, element_063(), "Caribbean Natural Wetland Forest"));
        nodes.put( 64,  new Node( 64,  63, element_064(), "Caribbean Swamp (M617)"));
        nodes.put( 65,  new Node( 65,  62, element_065(), "Caribbean Ruderal Wetland Forest"));
        nodes.put( 66,  new Node( 66,  57, element_066(), "Temperate & Boreal Forested Wetland (F136)"));
        nodes.put( 67,  new Node( 67,  66, element_067(), "Southeastern North American Flooded & Swamp Forest Division (D062)"));
        nodes.put( 68,  new Node( 68,  67, element_068(), "Eastern Warm Temperate Natural Wetland Forest"));
        nodes.put( 69,  new Node( 69,  68, element_069(), "Southern Great Plains Floodplain Forest & Woodland (M154)"));
        nodes.put( 70,  new Node( 70,  68, element_070(), "Pond-cypress Basin Swamp (M161)"));
        nodes.put( 71,  new Node( 71,  68, element_071(), "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)"));
        nodes.put( 72,  new Node( 72,  68, element_072(), "Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)"));
        nodes.put( 73,  new Node( 73,  68, element_073(), "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)"));
        nodes.put( 74,  new Node( 74,  68, element_074(), "Pond-cypress Basin Swamp LC (M161)"));
        nodes.put( 75,  new Node( 75,  68, element_075(), "Longleaf Pine Woodland LC2 (M007)"));
        nodes.put( 76,  new Node( 76,  68, element_076(), "Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)"));
        nodes.put( 77,  new Node( 77,  67, element_077(), "Eastern Warm Temperate Ruderal Wetland Forest"));
        nodes.put( 78,  new Node( 78,  77, element_078(), "Southeastern North American Ruderal Flooded & Swamp Forest (M310)"));
        nodes.put( 79,  new Node( 79,  66, element_079(), "North American Boreal Flooded Forest & Swamp Division (D016)"));
        nodes.put( 80,  new Node( 80,  79, element_080(), "Eastern Boreal Natural Wetland Forests"));
        nodes.put( 81,  new Node( 81,  80, element_081(), "North American Boreal Conifer Poor Swamp (M299)"));
        nodes.put( 82,  new Node( 82,  80, element_082(), "North American Boreal Flooded Forest & Rich Swamp (M300)"));
        nodes.put( 83,  new Node( 83,  79, element_083(), "Eastern Boreal Ruderal Wetland Forests"));
        nodes.put( 84,  new Node( 84,  66, element_084(), "Eastern North American Flooded Forest & Swamp Division (D011)"));
        nodes.put( 85,  new Node( 85,  84, element_085(), "Eastern Cool Temperate & North American Boreal Wetland Forest"));
        nodes.put( 86,  new Node( 86,  85, element_086(), "Eastern North American - Great Plains Flooded & Swamp Forest"));
        nodes.put( 87,  new Node( 87,  86, element_087(), "Eastern Cool Temperate Natural Wetland Forests"));
        nodes.put( 88,  new Node( 88,  87, element_088(), "Laurentian-Acadian Flooded Forest & Swamp (M504)"));
        nodes.put( 89,  new Node( 89,  87, element_089(), "Central Hardwood Floodplain Forest (M029)"));
        nodes.put( 90,  new Node( 90,  87, element_090(), "Central Hardwood Swamp (M503)"));
        nodes.put( 91,  new Node( 91,  87, element_091(), "Laurentian-Acadian Flooded Forest & Swamp LC (M504)"));
        nodes.put( 92,  new Node( 92,  87, element_092(), "Central Hardwood Floodplain Forest LC (M029)"));
        nodes.put( 93,  new Node( 93,  87, element_093(), "Central Hardwood Swamp LC (M503)"));
        nodes.put( 94,  new Node( 94,  86, element_094(), "Eastern Cool Temperate Ruderal Wetland Forests"));
        nodes.put( 95,  new Node( 95,  94, element_095(), "Eastern North American Ruderal Flooded Forest & Swamp (M302)"));
        nodes.put( 96,  new Node( 96,  56, element_096(), "Upland Forest & Woodlands"));
        nodes.put( 97,  new Node( 97,  96, element_097(), "Tropical Forest & Woodland Subclass"));
        nodes.put( 98,  new Node( 98,  97, element_098(), "Tropical Dry Forest"));
        nodes.put( 99,  new Node( 99,  98, element_099(), "Tropical Florida Forest"));
        nodes.put(100,  new Node(100,  99, element_100(), "Tropical Florida Natural Forest"));
        nodes.put(101,  new Node(101, 100, element_101(), "Caribbean-Mesoamerican Dry Pine Forest (M296)"));
        nodes.put(102,  new Node(102, 100, element_102(), "Caribbean Swamp Forest via upland (M617)"));
        nodes.put(103,  new Node(103, 100, element_103(), "Caribbean Coastal Lowland Dry Forest (M134)"));
        nodes.put(104,  new Node(104, 100, element_104(), "Caribbean Coastal Lowland Dry Forest LC (M134)"));
        nodes.put(105,  new Node(105,  99, element_105(), "Tropical Florida Ruderal Forest"));
        nodes.put(106,  new Node(106, 105, element_106(), "Caribbean Ruderal Dry Forest (M514)"));
        nodes.put(107,  new Node(107,  98, element_107(), "Caribbean Forest"));
        nodes.put(108,  new Node(108, 107, element_108(), "Caribbean Natural Forest"));
        nodes.put(109,  new Node(109, 108, element_109(), "Caribbean & Central American Dry Forests"));
        nodes.put(110,  new Node(110, 109, element_110(), "Caribbean-Mesoamerican Pine Forest via Caribbean (M296)"));
        nodes.put(111,  new Node(111, 109, element_111(), "Caribbean-Mesoamerican Pine Forest LC (M296)"));
        nodes.put(112,  new Node(112, 107, element_112(), "Caribbean Ruderal Forest"));
        nodes.put(113,  new Node(113, 112, element_113(), "Caribbean Ruderal Dry ForestA (M514A)"));
        nodes.put(114,  new Node(114,  96, element_114(), "Temperate & Boreal Forests"));
        nodes.put(115,  new Node(115, 114, element_115(), "Temperate-Boreal Forest & Woodland (TT2)"));
        nodes.put(116,  new Node(116, 115, element_116(), "Southeastern North American Forest & Woodland Division (D006)"));
        nodes.put(117,  new Node(117, 116, element_117(), "Southeastern Warm Temperate Natural Forests"));
        nodes.put(118,  new Node(118, 117, element_118(), "South-Central Oak - Pine Forest & Woodland (M540)"));
        nodes.put(119,  new Node(119, 117, element_119(), "Southern Mesic Mixed Broadleaf Forest (M008)"));
        nodes.put(120,  new Node(120, 117, element_120(), "Longleaf Pine Woodland (M007)"));
        nodes.put(121,  new Node(121, 117, element_121(), "Southeastern Coastal Plain Evergreen Oak Forest (M885)"));
        nodes.put(122,  new Node(122, 117, element_122(), "Southeastern Coastal Plain Evergreen Oak Forest LC (M885)"));
        nodes.put(123,  new Node(123, 117, element_123(), "Longleaf Pine Woodland LC1 (M007)"));
        nodes.put(124,  new Node(124, 117, element_124(), "Florida Xeric Scrub & Prairie (M162)"));
        nodes.put(125,  new Node(125, 117, element_125(), "Southern Mesic Mixed Broadleaf Forest LC (M008)"));
        nodes.put(126,  new Node(126, 116, element_126(), "Southeastern Warm Temperate Ruderal Forests"));
        nodes.put(127,  new Node(127, 126, element_127(), "Southeastern North American Ruderal Forest (M305)"));
        nodes.put(128,  new Node(128, 115, element_128(), "Temperate Deciduous-Mixed Forest & Woodland Ecobiome (TT2.b1)"));
        nodes.put(129,  new Node(129, 128, element_129(), "North American Great Plains Forest & Woodland (D332)"));
        nodes.put(130,  new Node(130, 129, element_130(), "Great Plains Natural Woodlands"));
        nodes.put(131,  new Node(131, 130, element_131(), "Northern Great Plains Forest & Woodland (M545)"));
        nodes.put(132,  new Node(132, 130, element_132(), "Southern Great Plains Forest & Woodland (M544)"));
        nodes.put(133,  new Node(133, 129, element_133(), "Great Plains Ruderal Woodland"));
        nodes.put(134,  new Node(134, 133, element_134(), "Great Plains Ruderal Woodland (M524)"));
        nodes.put(135,  new Node(135, 128, element_135(), "Eastern North American Forest & Woodland (D008)"));
        nodes.put(136,  new Node(136, 135, element_136(), "Eastern North American Natural Forest & Woodlands"));
        nodes.put(137,  new Node(137, 136, element_137(), "Northern Forest Macrogroups (Laurentian and Acadian-Appalachian)"));
        nodes.put(138,  new Node(138, 137, element_138(), "Laurentian Forests"));
        nodes.put(139,  new Node(139, 138, element_139(), "Acadian-Appalachian Forest (M103)"));
        nodes.put(140,  new Node(140, 138, element_140(), "Laurentian Dry Forest & Woodland (M159)"));
        nodes.put(141,  new Node(141, 138, element_141(), "Laurentian Mesic Mixed Forest (M102)"));
        nodes.put(142,  new Node(142, 138, element_142(), "Laurentian Dry Forest & Woodland LC (M159)"));
        nodes.put(143,  new Node(143, 136, element_143(), "Coastal and Midwest Forest Macrogroups, Appalachian and Central Interior Forest Macrogroups"));
        nodes.put(144,  new Node(144, 143, element_144(), "North Atlantic Coastal Forest & Woodland (M525)"));
        nodes.put(145,  new Node(145, 143, element_145(), "Central Midwest Oak Forest, Woodland & Savanna (M012)"));
        nodes.put(146,  new Node(146, 143, element_146(), "Central Midwest Mesic Forest (M882)"));
        nodes.put(147,  new Node(147, 143, element_147(), "Central Midwest Oak Forest, Woodland & Savanna LC (M012)"));
        nodes.put(148,  new Node(148, 143, element_148(), "Central Midwest Mesic Forest LC (M882)"));
        nodes.put(149,  new Node(149, 143, element_149(), "Southern-Central Appalachian Mesic Forest (M883)"));
        nodes.put(150,  new Node(150, 143, element_150(), "Central Interior Oak - Pine Forest & Woodland (M543)"));
        nodes.put(151,  new Node(151, 143, element_151(), "Southern-Central Appalachian Dry Forest & Woodland (M502)"));
        nodes.put(152,  new Node(152, 143, element_152(), "Laurentian Mesic Forest LC (M102)"));
        nodes.put(153,  new Node(153, 143, element_153(), "Central Interior Oak - Pine Forest & Woodland LC  (M543)"));
        nodes.put(154,  new Node(154, 143, element_154(), "Southern-Central Appalachian Dry Forest & Woodland LC (M502)"));
        nodes.put(155,  new Node(155, 143, element_155(), "Southern-Central Appalachian Mesic Forest LC (M883)"));
        nodes.put(156,  new Node(156, 135, element_156(), "Eastern North American Ruderal Forest & Woodlands"));
        nodes.put(157,  new Node(157, 156, element_157(), "Eastern North American Ruderal Forest (M013)"));

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

        // Forest Plantation Anthro-Division (CSF05)
        // CSF05

        String level = "division";
        String code = "CSF05";

        // Vegetation shows evidence of intensive human management as planted vegetation,
        // such as trees being planted in rows, often dominated by single-species, and even
        // aged.  The stand is identified as planted in the FIA database (Stand Origin Code
        // = "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001)

        List<KeyValue> PLANTATION_pattern0 = Arrays.asList(
            new KeyValue("plantation", "Y")
        );
        List<List<KeyValue>> PLANTATION_patterns = Arrays.asList(
            PLANTATION_pattern0
        );
        PatternList PLANTATION = new PatternList("PLANTATION", PLANTATION_patterns);

        INodeMatch match = plot -> (
            plot.match(PLANTATION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_002() {

        // Tropical Forest Plantation Anthro-macrogroup (CGR008)
        // CGR008

        String level = "macrogroup";
        String code = "CGR008";

        // Conifer & Hardwood plantations found in the tropics, including Puerto Rico, U.S. Virgin Islands, and tropical Florida (EcoSection 411A)

        List<KeyValue> TROPICAL_LOCATION_pattern0 = Arrays.asList(
            new KeyValue("state", "PR")
        );
        List<KeyValue> TROPICAL_LOCATION_pattern1 = Arrays.asList(
            new KeyValue("state", "VI")
        );
        List<KeyValue> TROPICAL_LOCATION_pattern2 = Arrays.asList(
            new KeyValue("state", "FL")
        );
        List<KeyValue> TROPICAL_LOCATION_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "411A")
        );
        List<List<KeyValue>> TROPICAL_LOCATION_patterns = Arrays.asList(
            TROPICAL_LOCATION_pattern0,
            TROPICAL_LOCATION_pattern1,
            TROPICAL_LOCATION_pattern2,
            TROPICAL_LOCATION_pattern3
        );
        PatternList TROPICAL_LOCATION = new PatternList("TROPICAL_LOCATION", TROPICAL_LOCATION_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_LOCATION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_003() {

        // Caribbean Forest Plantation Anthro-group (CSG008)
        // CSG008

        String level = "group";
        String code = "CSG008";

        // Tropical forest plantations found in the Caribbean region,
        // including Puerto Rico, U.S. Virgin Islands, and tropical Florida (EcoSection 411A)

        List<KeyValue> CARIBBEAN_pattern0 = Arrays.asList(
            new KeyValue("state", "PR")
        );
        List<KeyValue> CARIBBEAN_pattern1 = Arrays.asList(
            new KeyValue("state", "VI")
        );
        List<KeyValue> CARIBBEAN_pattern2 = Arrays.asList(
            new KeyValue("state", "FL")
        );
        List<KeyValue> CARIBBEAN_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "411A")
        );
        List<List<KeyValue>> CARIBBEAN_patterns = Arrays.asList(
            CARIBBEAN_pattern0,
            CARIBBEAN_pattern1,
            CARIBBEAN_pattern2,
            CARIBBEAN_pattern3
        );
        PatternList CARIBBEAN = new PatternList("CARIBBEAN", CARIBBEAN_patterns);

        INodeMatch match = plot -> (
            plot.match(CARIBBEAN)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_004() {

        // Caribbean Conifer Plantations
        // Caribbean Conifer Plantations

        String level = "informal";
        String code = "Caribbean Conifer Plantations";

        // Caribbean species are conifers >=25% RIV

        List<KeyValue> CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "S")
        );
        List<List<KeyValue>> CONIFERS_patterns = Arrays.asList(
            CONIFERS_pattern0
        );
        PatternList CONIFERS = new PatternList("CONIFERS", CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(CONIFERS) >= 25
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_005() {

        // Native Caribbean Conifer Plantation Anthro-type (CTY001)
        // CTY001

        String level = "type";
        String code = "CTY001";

        // Species of native conifers have > RIV than exotic species

        List<KeyValue> NATIVE_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "S")
        );
        List<KeyValue> NATIVE_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<List<KeyValue>> NATIVE_CONIFERS_patterns = Arrays.asList(
            NATIVE_CONIFERS_pattern0,
            NATIVE_CONIFERS_pattern1
        );
        PatternList NATIVE_CONIFERS = new PatternList("NATIVE_CONIFERS", NATIVE_CONIFERS_patterns);

        List<KeyValue> EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "S")
        );
        List<KeyValue> EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_CONIFERS_patterns = Arrays.asList(
            EXOTIC_CONIFERS_pattern0,
            EXOTIC_CONIFERS_pattern1
        );
        PatternList EXOTIC_CONIFERS = new PatternList("EXOTIC_CONIFERS", EXOTIC_CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_CONIFERS) > plot.riv(EXOTIC_CONIFERS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_006() {

        // Exotic Caribbean Forest Plantation Anthro-type (CTY002)
        // CTY002

        String level = "type";
        String code = "CTY002";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_007() {

        // Caribbean Hardwood Plantations
        // Caribbean Hardwood Plantations

        String level = "informal";
        String code = "Caribbean Hardwood Plantations";

        // Caribbean species are hardwoods >=25% RIV

        List<KeyValue> HARDWOODS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "H")
        );
        List<List<KeyValue>> HARDWOODS_patterns = Arrays.asList(
            HARDWOODS_pattern0
        );
        PatternList HARDWOODS = new PatternList("HARDWOODS", HARDWOODS_patterns);

        INodeMatch match = plot -> (
            plot.riv(HARDWOODS) >= 25
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_008() {

        // Native Caribbean Hardwood Plantation Anthro-type (CTY003)
        // CTY003

        String level = "type";
        String code = "CTY003";

        // Species of native hardwoods have > RIV than exotic species

        List<KeyValue> NATIVE_HARDWOODS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "H")
        );
        List<KeyValue> NATIVE_HARDWOODS_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<List<KeyValue>> NATIVE_HARDWOODS_patterns = Arrays.asList(
            NATIVE_HARDWOODS_pattern0,
            NATIVE_HARDWOODS_pattern1
        );
        PatternList NATIVE_HARDWOODS = new PatternList("NATIVE_HARDWOODS", NATIVE_HARDWOODS_patterns);

        List<KeyValue> EXOTIC_HARDWOODS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "H")
        );
        List<KeyValue> EXOTIC_HARDWOODS_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> EXOTIC_HARDWOODS_patterns = Arrays.asList(
            EXOTIC_HARDWOODS_pattern0,
            EXOTIC_HARDWOODS_pattern1
        );
        PatternList EXOTIC_HARDWOODS = new PatternList("EXOTIC_HARDWOODS", EXOTIC_HARDWOODS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_HARDWOODS) > plot.riv(EXOTIC_HARDWOODS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_009() {

        // Exotic Caribbean Hardwood Plantation Anthro-type (CTY004)
        // CTY004

        String level = "type";
        String code = "CTY004";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_010() {

        // Miscellaneous Caribbean Plantation Anthro-type (CTY019)
        // CTY019

        String level = "type";
        String code = "CTY019";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_011() {

        // Temperate & Boreal Forest Plantation Anthro-macrogroup (CGR007)
        // CGR007

        String level = "group";
        String code = "CGR007";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_012() {

        // Eastern North American Temperate Forest Plantation Anthro-group (CSG005)
        // CSG005

        String level = "subgroup";
        String code = "CSG005";

        // Plantations found in eastern temperate region of North America (EcoProvince 210,
        // M210, 220, M220, 230, M230, 250, 310-Texas part only, and 330

        List<KeyValue> EASTERN_TEMPERATE_REGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "210, M210, 220, M220, 230, M230, 250, 330")
        );
        List<KeyValue> EASTERN_TEMPERATE_REGION_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "310")
        );
        List<KeyValue> EASTERN_TEMPERATE_REGION_pattern2 = Arrays.asList(
            new KeyValue("state", "TX")
        );
        List<List<KeyValue>> EASTERN_TEMPERATE_REGION_patterns = Arrays.asList(
            EASTERN_TEMPERATE_REGION_pattern0,
            EASTERN_TEMPERATE_REGION_pattern1,
            EASTERN_TEMPERATE_REGION_pattern2
        );
        PatternList EASTERN_TEMPERATE_REGION = new PatternList("EASTERN_TEMPERATE_REGION", EASTERN_TEMPERATE_REGION_patterns);

        INodeMatch match = plot -> (
            plot.match(EASTERN_TEMPERATE_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_013() {

        // Eastern North American Conifer Plantations
        // Eastern North American Conifer Plantations

        String level = "informal";
        String code = "Eastern North American Conifer Plantations";

        // Eastern North American species are conifers >=25% RIV

        List<KeyValue> CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("softwoodhardwood", "S")
        );
        List<List<KeyValue>> CONIFERS_patterns = Arrays.asList(
            CONIFERS_pattern0
        );
        PatternList CONIFERS = new PatternList("CONIFERS", CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(CONIFERS) >= 25
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_014() {

        // Native Eastern North American Conifer Plantations
        // Native Eastern North American Conifer Plantations

        String level = "informal";
        String code = "Native Eastern North American Conifer Plantations";

        // Tree species dominated by native conifers (See
        // Appendix A) with RIV > exotic conifers

        List<KeyValue> NATIVE_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<KeyValue> NATIVE_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("softwoodhardwood", "S")
        );
        List<List<KeyValue>> NATIVE_CONIFERS_patterns = Arrays.asList(
            NATIVE_CONIFERS_pattern0,
            NATIVE_CONIFERS_pattern1
        );
        PatternList NATIVE_CONIFERS = new PatternList("NATIVE_CONIFERS", NATIVE_CONIFERS_patterns);

        List<KeyValue> EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("softwoodhardwood", "S")
        );
        List<List<KeyValue>> EXOTIC_CONIFERS_patterns = Arrays.asList(
            EXOTIC_CONIFERS_pattern0,
            EXOTIC_CONIFERS_pattern1
        );
        PatternList EXOTIC_CONIFERS = new PatternList("EXOTIC_CONIFERS", EXOTIC_CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_CONIFERS) > plot.riv(EXOTIC_CONIFERS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_015() {

        // Native Southern Pine Plantation Anthro-type (CTY012)
        // CTY012

        String level = "type";
        String code = "CTY012";

        // i. Species are native conifers Pinus spp. with >=25% RIV:  Pinus echinata, Pinus elliottii,
        //     Pinus palustris, Pinus taeda, Pinus clausa. [note - this list represents the expected
        //     list of common southern native pine plantation species types.  If other common native
        //     pine plantationspecies are identified, they should be added to this list and
        //     additional couplets added below]
        // OR
        // ii. Species are native conifers found in ecoregion divisions 230, M230, 310 and
        //     ecoprovince 255

        List<KeyValue> SOUTHERN_PINES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> SOUTHERN_PINES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> SOUTHERN_PINES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> SOUTHERN_PINES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> SOUTHERN_PINES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> SOUTHERN_PINES_patterns = Arrays.asList(
            SOUTHERN_PINES_pattern0,
            SOUTHERN_PINES_pattern1,
            SOUTHERN_PINES_pattern2,
            SOUTHERN_PINES_pattern3,
            SOUTHERN_PINES_pattern4
        );
        PatternList SOUTHERN_PINES = new PatternList("SOUTHERN_PINES", SOUTHERN_PINES_patterns);

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "230, M230, 310, 255")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.riv(SOUTHERN_PINES) >= 25 || plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_016() {

        // Shortleaf Pine Forest Plantation (CST007169)
        // Shortleaf Pine Forest Plantation (CST007169)

        String level = "subtype";
        String code = "Shortleaf Pine Forest Plantation (CST007169)";

        // Tree composition dominated by Pinus echinata; i.e. Pinus echinata >= 25% RIV,
        // and exceeds each species of Pinus elliottii, Pinus palustris, Pinus clausa and Pinus taeda.

        List<KeyValue> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<List<KeyValue>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<KeyValue> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<KeyValue> SLASH_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<List<KeyValue>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<KeyValue> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<KeyValue> SAND_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> SAND_PINE_patterns = Arrays.asList(
            SAND_PINE_pattern0
        );
        PatternList SAND_PINE = new PatternList("SAND_PINE", SAND_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(SHORTLEAF_PINE) >= 25
           && plot.riv(SHORTLEAF_PINE) > plot.riv(LONGLEAF_PINE)
           && plot.riv(SHORTLEAF_PINE) > plot.riv(SLASH_PINE)
           && plot.riv(SHORTLEAF_PINE) > plot.riv(LOBLOLLY_PINE)
           && plot.riv(SHORTLEAF_PINE) > plot.riv(SAND_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_017() {

        // Longleaf Pine Forest Plantation (CST007176)
        // Longleaf Pine Forest Plantation (CST007176)

        String level = "subtype";
        String code = "Longleaf Pine Forest Plantation (CST007176)";

        // Tree composition dominated by Pinus palustris; i.e. Pinus palustris >= 25% RIV,
        // and exceeds each species of Pinus echinata, Pinus elliottii, Pinus clausa and Pinus taeda.

        List<KeyValue> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<List<KeyValue>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<KeyValue> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<KeyValue> SLASH_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<List<KeyValue>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<KeyValue> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<KeyValue> SAND_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> SAND_PINE_patterns = Arrays.asList(
            SAND_PINE_pattern0
        );
        PatternList SAND_PINE = new PatternList("SAND_PINE", SAND_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(LONGLEAF_PINE) >= 25
           && plot.riv(LONGLEAF_PINE) > plot.riv(SHORTLEAF_PINE)
           && plot.riv(LONGLEAF_PINE) > plot.riv(SLASH_PINE)
           && plot.riv(LONGLEAF_PINE) > plot.riv(LOBLOLLY_PINE)
           && plot.riv(LONGLEAF_PINE) > plot.riv(SAND_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_018() {

        // Slash Pine Forest Plantation (CST007170)
        // Slash Pine Forest Plantation (CST007170)

        String level = "subtype";
        String code = "Slash Pine Forest Plantation (CST007170)";

        // Tree composition dominated by Pinus elliottii; i.e. Pinus elliotti >= 25% RIV,
        // and exceeds each species of Pinus echinta, Pinus palustris, Pinus clausa or Pinus taeda.

        List<KeyValue> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<List<KeyValue>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<KeyValue> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<KeyValue> SLASH_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<List<KeyValue>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<KeyValue> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<KeyValue> SAND_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> SAND_PINE_patterns = Arrays.asList(
            SAND_PINE_pattern0
        );
        PatternList SAND_PINE = new PatternList("SAND_PINE", SAND_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(SLASH_PINE) >= 25
           && plot.riv(SLASH_PINE) > plot.riv(SHORTLEAF_PINE)
           && plot.riv(SLASH_PINE) > plot.riv(LONGLEAF_PINE)
           && plot.riv(SLASH_PINE) > plot.riv(LOBLOLLY_PINE)
           && plot.riv(SLASH_PINE) > plot.riv(SAND_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_019() {

        // Loblolly Pine Forest Plantation (CST007179)
        // CST007179

        String level = "subtype";
        String code = "CST007179";

        // Tree composition dominated by Pinus taeda; i.e. Pinus taeda >= 25% RIV,
        // and exceeds each species of Pinus echinta, Pinus elliottii, Pinus clausa or Pinus palustris

        List<KeyValue> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<List<KeyValue>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<KeyValue> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<KeyValue> SLASH_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<List<KeyValue>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<KeyValue> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<KeyValue> SAND_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> SAND_PINE_patterns = Arrays.asList(
            SAND_PINE_pattern0
        );
        PatternList SAND_PINE = new PatternList("SAND_PINE", SAND_PINE_patterns);

        INodeMatch match = plot -> (
            plot.riv(LOBLOLLY_PINE) >= 25
           && plot.riv(LOBLOLLY_PINE) > plot.riv(SHORTLEAF_PINE)
           && plot.riv(LOBLOLLY_PINE) > plot.riv(LONGLEAF_PINE)
           && plot.riv(LOBLOLLY_PINE) > plot.riv(SLASH_PINE)
           && plot.riv(LOBLOLLY_PINE) > plot.riv(SAND_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_020() {

        // Sand Pine Forest Plantation (CST007168)
        // Sand Pine Forest Plantation (CST007168)

        String level = "subtype";
        String code = "Sand Pine Forest Plantation (CST007168)";

        // Tree composition dominated by Pinus clausa >= 25% RIV, and exceeds each
        // species of Pinus echinata, Pinus palustris, Pinus elliottii and Pinus taeda

        List<KeyValue> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<List<KeyValue>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<KeyValue> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<KeyValue> SLASH_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<List<KeyValue>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<KeyValue> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<KeyValue> SAND_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> SAND_PINE_patterns = Arrays.asList(
            SAND_PINE_pattern0
        );
        PatternList SAND_PINE = new PatternList("SAND_PINE", SAND_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(SAND_PINE) >= 25
           && plot.riv(SAND_PINE) > plot.riv(SHORTLEAF_PINE)
           && plot.riv(SAND_PINE) > plot.riv(LONGLEAF_PINE)
           && plot.riv(SAND_PINE) > plot.riv(SLASH_PINE)
           && plot.riv(SAND_PINE) > plot.riv(LOBLOLLY_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_021() {

        // Native Miscellaneous Southern Pine Forest Plantation (CST007160)
        // Native Miscellaneous Southern Pine Forest Plantation (CST007160)

        String level = "subtype";
        String code = "Native Miscellaneous Southern Pine Forest Plantation (CST007160)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_022() {

        // Native Northern Conifer Plantation
        // Native Northern Conifer Plantation

        String level = "informal";
        String code = "Native Northern Conifer Plantation";

        // i. Species are native conifers dominated by one or more of the following with >=25% RIV:
        //     Pinus banksiana, Pinus resinosa, Pinus strobus, Abies balsamea, Larix laricina, Picea glauca,
        //     or Picea mariana [note - this list represents the expected list of common northern native pine
        //     plantation species types. If other common native pine plantation species are identified, they
        //     should be added to this list and additional couplets added below]
        // OR
        // ii. Species not as above, but found in ecoregion divisions 211, M211, 212, 221, M221, 222,
        //     M222, 251, 223, M223, 231, M231

        List<KeyValue> NORTHERN_PINES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> NORTHERN_PINES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> NORTHERN_PINES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> NORTHERN_PINES_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> NORTHERN_PINES_pattern4 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> NORTHERN_PINES_pattern5 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> NORTHERN_PINES_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<List<KeyValue>> NORTHERN_PINES_patterns = Arrays.asList(
            NORTHERN_PINES_pattern0,
            NORTHERN_PINES_pattern1,
            NORTHERN_PINES_pattern2,
            NORTHERN_PINES_pattern3,
            NORTHERN_PINES_pattern4,
            NORTHERN_PINES_pattern5,
            NORTHERN_PINES_pattern6
        );
        PatternList NORTHERN_PINES = new PatternList("NORTHERN_PINES", NORTHERN_PINES_patterns);

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "211, M211, 212, 221, M221, 222, M222, 251, 223, M223, 231, M231")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NORTHERN_PINES) >= 25 || plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_023() {

        // Native Northern Pine Plantation Anthro-type (CTY009)
        // CTY009

        String level = "type";
        String code = "CTY009";

        // Native pine species of Pinus spp. [Pinus spp not E = Exotic] exceed non-pine conifers (Native Pinus spp >=50% RIV)

        List<KeyValue> NATIVE_NORTHERN_PINES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus caribaea")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus cembroides")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus edulis")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus flexilis")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus pungens")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus remota")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus rigida")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern16 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern17 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> NATIVE_NORTHERN_PINES_pattern18 = Arrays.asList(
            new KeyValue("species", "Pinus virginiana")
        );
        List<List<KeyValue>> NATIVE_NORTHERN_PINES_patterns = Arrays.asList(
            NATIVE_NORTHERN_PINES_pattern0,
            NATIVE_NORTHERN_PINES_pattern1,
            NATIVE_NORTHERN_PINES_pattern2,
            NATIVE_NORTHERN_PINES_pattern3,
            NATIVE_NORTHERN_PINES_pattern4,
            NATIVE_NORTHERN_PINES_pattern5,
            NATIVE_NORTHERN_PINES_pattern6,
            NATIVE_NORTHERN_PINES_pattern7,
            NATIVE_NORTHERN_PINES_pattern8,
            NATIVE_NORTHERN_PINES_pattern9,
            NATIVE_NORTHERN_PINES_pattern10,
            NATIVE_NORTHERN_PINES_pattern11,
            NATIVE_NORTHERN_PINES_pattern12,
            NATIVE_NORTHERN_PINES_pattern13,
            NATIVE_NORTHERN_PINES_pattern14,
            NATIVE_NORTHERN_PINES_pattern15,
            NATIVE_NORTHERN_PINES_pattern16,
            NATIVE_NORTHERN_PINES_pattern17,
            NATIVE_NORTHERN_PINES_pattern18
        );
        PatternList NATIVE_NORTHERN_PINES = new PatternList("NATIVE_NORTHERN_PINES", NATIVE_NORTHERN_PINES_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_NORTHERN_PINES) >= 50
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_024() {

        // Red Pine Forest Plantation (CST007117)
        // Red Pine Forest Plantation (CST007117)

        String level = "subtype";
        String code = "Red Pine Forest Plantation (CST007117)";

        // Tree composition dominated by Pinus resinosa >= 25% RIV,
        // and exceeds each species of Pinus banksiana and Pinus strobus.

        List<KeyValue> RED_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<List<KeyValue>> RED_PINE_patterns = Arrays.asList(
            RED_PINE_pattern0
        );
        PatternList RED_PINE = new PatternList("RED_PINE", RED_PINE_patterns);

        List<KeyValue> JACK_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<List<KeyValue>> JACK_PINE_patterns = Arrays.asList(
            JACK_PINE_pattern0
        );
        PatternList JACK_PINE = new PatternList("JACK_PINE", JACK_PINE_patterns);

        List<KeyValue> WHITE_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<List<KeyValue>> WHITE_PINE_patterns = Arrays.asList(
            WHITE_PINE_pattern0
        );
        PatternList WHITE_PINE = new PatternList("WHITE_PINE", WHITE_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(RED_PINE) >= 25
           && plot.riv(RED_PINE) > plot.riv(JACK_PINE)
           && plot.riv(RED_PINE) > plot.riv(WHITE_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_025() {

        // White Pine Forest Plantation (CST007178)
        // White Pine Forest Plantation (CST007178)

        String level = "subtype";
        String code = "White Pine Forest Plantation (CST007178)";

        // Tree composition dominated by Pinus strobus >= 25% RIV,
        // and exceeds each species of Pinus resinosa and Pinus banksiana.

        List<KeyValue> WHITE_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<List<KeyValue>> WHITE_PINE_patterns = Arrays.asList(
            WHITE_PINE_pattern0
        );
        PatternList WHITE_PINE = new PatternList("WHITE_PINE", WHITE_PINE_patterns);

        List<KeyValue> RED_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<List<KeyValue>> RED_PINE_patterns = Arrays.asList(
            RED_PINE_pattern0
        );
        PatternList RED_PINE = new PatternList("RED_PINE", RED_PINE_patterns);

        List<KeyValue> JACK_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<List<KeyValue>> JACK_PINE_patterns = Arrays.asList(
            JACK_PINE_pattern0
        );
        PatternList JACK_PINE = new PatternList("JACK_PINE", JACK_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(WHITE_PINE) >= 25
           && plot.riv(WHITE_PINE) > plot.riv(RED_PINE)
           && plot.riv(WHITE_PINE) > plot.riv(JACK_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_026() {

        // Jack Pine Forest Plantation (CST007161)
        // Jack Pine Forest Plantation (CST007161)

        String level = "subtype";
        String code = "Jack Pine Forest Plantation (CST007161)";

        // Tree composition dominated by Pinus banksiana >= 25% RIV,
        // and exceeds each species of Pinus resinosa and Pinus strobus.

        List<KeyValue> JACK_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<List<KeyValue>> JACK_PINE_patterns = Arrays.asList(
            JACK_PINE_pattern0
        );
        PatternList JACK_PINE = new PatternList("JACK_PINE", JACK_PINE_patterns);

        List<KeyValue> RED_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<List<KeyValue>> RED_PINE_patterns = Arrays.asList(
            RED_PINE_pattern0
        );
        PatternList RED_PINE = new PatternList("RED_PINE", RED_PINE_patterns);

        List<KeyValue> WHITE_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<List<KeyValue>> WHITE_PINE_patterns = Arrays.asList(
            WHITE_PINE_pattern0
        );
        PatternList WHITE_PINE = new PatternList("WHITE_PINE", WHITE_PINE_patterns);

        INodeMatch match = plot -> (
                plot.riv(JACK_PINE) >= 25
           && plot.riv(JACK_PINE) > plot.riv(RED_PINE)
           && plot.riv(JACK_PINE) > plot.riv(WHITE_PINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_027() {

        // Native Miscellaneous Northern Pine Forest Plantation
        // Native Miscellaneous Northern Pine Forest Plantation

        String level = "subtype";
        String code = "Native Miscellaneous Northern Pine Forest Plantation";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_028() {

        // Native Northern Spruce - Fir Plantation Anthro-type (CTY010)
        // CTY010

        String level = "type";
        String code = "CTY010";

        // Native Pinus species <50% RIV

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_029() {

        // White Spruce Forest Plantation (CST007164)
        // White Spruce Forest Plantation (CST007164)

        String level = "subtype";
        String code = "White Spruce Forest Plantation (CST007164)";

        // Tree composition dominated by Picea glauca >=25% RIV,
        // and exceeds each species of Abies balsamea, Larix laricina,
        // Picea rubens and Picea mariana.

        List<KeyValue> WHITE_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<List<KeyValue>> WHITE_SPRUCE_patterns = Arrays.asList(
            WHITE_SPRUCE_pattern0
        );
        PatternList WHITE_SPRUCE = new PatternList("WHITE_SPRUCE", WHITE_SPRUCE_patterns);

        List<KeyValue> BALSAM_FIR_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<List<KeyValue>> BALSAM_FIR_patterns = Arrays.asList(
            BALSAM_FIR_pattern0
        );
        PatternList BALSAM_FIR = new PatternList("BALSAM_FIR", BALSAM_FIR_patterns);

        List<KeyValue> NATIVE_TAMARACK_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<List<KeyValue>> NATIVE_TAMARACK_patterns = Arrays.asList(
            NATIVE_TAMARACK_pattern0
        );
        PatternList NATIVE_TAMARACK = new PatternList("NATIVE_TAMARACK", NATIVE_TAMARACK_patterns);

        List<KeyValue> RED_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> RED_SPRUCE_patterns = Arrays.asList(
            RED_SPRUCE_pattern0
        );
        PatternList RED_SPRUCE = new PatternList("RED_SPRUCE", RED_SPRUCE_patterns);

        List<KeyValue> BLACK_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<List<KeyValue>> BLACK_SPRUCE_patterns = Arrays.asList(
            BLACK_SPRUCE_pattern0
        );
        PatternList BLACK_SPRUCE = new PatternList("BLACK_SPRUCE", BLACK_SPRUCE_patterns);

        INodeMatch match = plot -> (
                plot.riv(WHITE_SPRUCE) >= 25
           && plot.riv(WHITE_SPRUCE) > plot.riv(BALSAM_FIR)
           && plot.riv(WHITE_SPRUCE) > plot.riv(NATIVE_TAMARACK)
           && plot.riv(WHITE_SPRUCE) > plot.riv(RED_SPRUCE)
           && plot.riv(WHITE_SPRUCE) > plot.riv(BLACK_SPRUCE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_030() {

        // Balsam Fir Forest Plantation (CST007182)
        // Balsam Fir Forest Plantation (CST007182)

        String level = "subtype";
        String code = "Balsam Fir Forest Plantation (CST007182)";

        // Tree composition dominated by Abies balsamea >=25% RIV,
        // and exceeds each species of Larix laricina, Picea glauca,
        // Picea rubens and Picea mariana.

        List<KeyValue> BALSAM_FIR_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<List<KeyValue>> BALSAM_FIR_patterns = Arrays.asList(
            BALSAM_FIR_pattern0
        );
        PatternList BALSAM_FIR = new PatternList("BALSAM_FIR", BALSAM_FIR_patterns);

        List<KeyValue> NATIVE_TAMARACK_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<List<KeyValue>> NATIVE_TAMARACK_patterns = Arrays.asList(
            NATIVE_TAMARACK_pattern0
        );
        PatternList NATIVE_TAMARACK = new PatternList("NATIVE_TAMARACK", NATIVE_TAMARACK_patterns);

        List<KeyValue> RED_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> RED_SPRUCE_patterns = Arrays.asList(
            RED_SPRUCE_pattern0
        );
        PatternList RED_SPRUCE = new PatternList("RED_SPRUCE", RED_SPRUCE_patterns);

        List<KeyValue> WHITE_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<List<KeyValue>> WHITE_SPRUCE_patterns = Arrays.asList(
            WHITE_SPRUCE_pattern0
        );
        PatternList WHITE_SPRUCE = new PatternList("WHITE_SPRUCE", WHITE_SPRUCE_patterns);

        List<KeyValue> BLACK_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<List<KeyValue>> BLACK_SPRUCE_patterns = Arrays.asList(
            BLACK_SPRUCE_pattern0
        );
        PatternList BLACK_SPRUCE = new PatternList("BLACK_SPRUCE", BLACK_SPRUCE_patterns);

        INodeMatch match = plot -> (
                plot.riv(BALSAM_FIR) >= 25
           && plot.riv(BALSAM_FIR) > plot.riv(NATIVE_TAMARACK)
           && plot.riv(BALSAM_FIR) > plot.riv(WHITE_SPRUCE)
           && plot.riv(BALSAM_FIR) > plot.riv(RED_SPRUCE)
           && plot.riv(BALSAM_FIR) > plot.riv(BLACK_SPRUCE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_031() {

        // Red Spruce Forest Plantation (CST004758)
        // Red Spruce Forest Plantation (CST004758)

        String level = "subtype";
        String code = "Red Spruce Forest Plantation (CST004758)";

        // Tree composition dominated by Picea rubens, i.e., Picea rubens >=25% RIV,
        // and exceeds each species of Abies balsamea, Larix laricina, Picea glauca, and Picea mariana.

        List<KeyValue> BALSAM_FIR_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<List<KeyValue>> BALSAM_FIR_patterns = Arrays.asList(
            BALSAM_FIR_pattern0
        );
        PatternList BALSAM_FIR = new PatternList("BALSAM_FIR", BALSAM_FIR_patterns);

        List<KeyValue> NATIVE_TAMARACK_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<List<KeyValue>> NATIVE_TAMARACK_patterns = Arrays.asList(
            NATIVE_TAMARACK_pattern0
        );
        PatternList NATIVE_TAMARACK = new PatternList("NATIVE_TAMARACK", NATIVE_TAMARACK_patterns);

        List<KeyValue> RED_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> RED_SPRUCE_patterns = Arrays.asList(
            RED_SPRUCE_pattern0
        );
        PatternList RED_SPRUCE = new PatternList("RED_SPRUCE", RED_SPRUCE_patterns);

        List<KeyValue> WHITE_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<List<KeyValue>> WHITE_SPRUCE_patterns = Arrays.asList(
            WHITE_SPRUCE_pattern0
        );
        PatternList WHITE_SPRUCE = new PatternList("WHITE_SPRUCE", WHITE_SPRUCE_patterns);

        List<KeyValue> BLACK_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<List<KeyValue>> BLACK_SPRUCE_patterns = Arrays.asList(
            BLACK_SPRUCE_pattern0
        );
        PatternList BLACK_SPRUCE = new PatternList("BLACK_SPRUCE", BLACK_SPRUCE_patterns);

        INodeMatch match = plot -> (
                plot.riv(RED_SPRUCE) >= 25
           && plot.riv(RED_SPRUCE) > plot.riv(BALSAM_FIR)
           && plot.riv(RED_SPRUCE) > plot.riv(NATIVE_TAMARACK)
           && plot.riv(RED_SPRUCE) > plot.riv(WHITE_SPRUCE)
           && plot.riv(RED_SPRUCE) > plot.riv(BLACK_SPRUCE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_032() {

        // Native Miscellaneous Northern Conifer Forest Plantation (CST007163)
        // Native Miscellaneous Northern Conifer Forest Plantation (CST007163)

        String level = "subtype";
        String code = "Native Miscellaneous Northern Conifer Forest Plantation (CST007163)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_033() {

        // Exotic Eastern North American Conifer Plantations
        // Exotic Eastern North American Conifer Plantations

        String level = "informal";
        String code = "Exotic Eastern North American Conifer Plantations";

        // Tree species are dominated by exotic conifers (See
        // Appendix A) with RIV > native conifers.  Implemented as NOT native conifers.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_034() {

        // Exotic Northern Conifer Plantation Anthro-type (CTY014)
        // CTY014

        String level = "type";
        String code = "CTY014";

        // Exotic conifer tree species dominated by Pinus sylvestris,
        // Picea abies, Larix decidua (not used by FIA), or Larix spp. alone or in
        // combination >=25% RIV or stand found in ecodivisions 210, M210, 220, M220,
        // 330 and ecoprovince 251 [note - this list represents the expected list of
        // common exotic conifer plantation species types.  If other common exotic
        // conifer plantation species are identified, they should be added to this list
        // and additional couplets added below].

        List<KeyValue> COMMON_EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus sylvestris")
        );
        List<KeyValue> COMMON_EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea abies")
        );
        List<KeyValue> COMMON_EXOTIC_CONIFERS_pattern2 = Arrays.asList(
            new KeyValue("species", "Larix")
        );
        List<List<KeyValue>> COMMON_EXOTIC_CONIFERS_patterns = Arrays.asList(
            COMMON_EXOTIC_CONIFERS_pattern0,
            COMMON_EXOTIC_CONIFERS_pattern1,
            COMMON_EXOTIC_CONIFERS_pattern2
        );
        PatternList COMMON_EXOTIC_CONIFERS = new PatternList("COMMON_EXOTIC_CONIFERS", COMMON_EXOTIC_CONIFERS_patterns);

        List<KeyValue> NORTHERN_REGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "210, M210, 220, M220, 330, 251")
        );
        List<List<KeyValue>> NORTHERN_REGION_patterns = Arrays.asList(
            NORTHERN_REGION_pattern0
        );
        PatternList NORTHERN_REGION = new PatternList("NORTHERN_REGION", NORTHERN_REGION_patterns);

        INodeMatch match = plot -> (
            plot.riv(COMMON_EXOTIC_CONIFERS) >= 25 || plot.match(NORTHERN_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_035() {

        // Scotch Pine Exotic Forest Plantation (CST006313)
        // Scotch Pine Exotic Forest Plantation (CST006313)

        String level = "subtype";
        String code = "Scotch Pine Exotic Forest Plantation (CST006313)";

        //  i. Tree composition dominated by Pinus sylvestris with >=50% RIV
        // OR
        // ii. The above tree species, but with >=25% RIV, AND planted Picea abies or
        //     Larix spp. alone or in combination <25%

        List<KeyValue> SCOTCH_PINE_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus sylvestris")
        );
        List<List<KeyValue>> SCOTCH_PINE_patterns = Arrays.asList(
            SCOTCH_PINE_pattern0
        );
        PatternList SCOTCH_PINE = new PatternList("SCOTCH_PINE", SCOTCH_PINE_patterns);

        List<KeyValue> NORWAY_SPRUCE_LARCH_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea abies")
        );
        List<KeyValue> NORWAY_SPRUCE_LARCH_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix")
        );
        List<List<KeyValue>> NORWAY_SPRUCE_LARCH_patterns = Arrays.asList(
            NORWAY_SPRUCE_LARCH_pattern0,
            NORWAY_SPRUCE_LARCH_pattern1
        );
        PatternList NORWAY_SPRUCE_LARCH = new PatternList("NORWAY_SPRUCE_LARCH", NORWAY_SPRUCE_LARCH_patterns);

        INodeMatch match = plot -> (
                plot.riv(SCOTCH_PINE) >= 50
           || (plot.riv(SCOTCH_PINE) >= 25 && plot.riv(NORWAY_SPRUCE_LARCH) < 25)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_036() {

        // Norway Spruce Forest Plantation (CST007167)
        // Norway Spruce Forest Plantation (CST007167)

        String level = "subtype";
        String code = "Norway Spruce Forest Plantation (CST007167)";

        //  i. Tree composition dominated by Picea abies with >=50% RIV
        // OR
        // ii. Tree composition dominated by Pinus abies, but with >=25% RIV, AND species
        //     of Pinus sylvestris or Larix spp. alone or in combination <25% RIV

        List<KeyValue> NORWAY_SPRUCE_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea abies")
        );
        List<List<KeyValue>> NORWAY_SPRUCE_patterns = Arrays.asList(
            NORWAY_SPRUCE_pattern0
        );
        PatternList NORWAY_SPRUCE = new PatternList("NORWAY_SPRUCE", NORWAY_SPRUCE_patterns);

        List<KeyValue> OTHER_EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus sylvestris")
        );
        List<KeyValue> OTHER_EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix")
        );
        List<List<KeyValue>> OTHER_EXOTIC_CONIFERS_patterns = Arrays.asList(
            OTHER_EXOTIC_CONIFERS_pattern0,
            OTHER_EXOTIC_CONIFERS_pattern1
        );
        PatternList OTHER_EXOTIC_CONIFERS = new PatternList("OTHER_EXOTIC_CONIFERS", OTHER_EXOTIC_CONIFERS_patterns);

        INodeMatch match = plot -> (
                plot.riv(NORWAY_SPRUCE) >= 50
           || (plot.riv(NORWAY_SPRUCE) >= 25 && plot.riv(OTHER_EXOTIC_CONIFERS) < 25)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_037() {

        // Larch Forest Plantation (CST006408)
        // Larch Forest Plantation (CST006408)

        String level = "subtype";
        String code = "Larch Forest Plantation (CST006408)";

        //  i. Tree composition dominated by Larix spp. with >=50% RIV
        // OR
        // ii. Tree composition dominated by Larix spp., but with >=25% RIV, AND species
        //     of Pinus sylvestris or Picea abies alone or in combination <25% RIV

        List<KeyValue> LARIX_SPP_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix")
        );
        List<List<KeyValue>> LARIX_SPP_patterns = Arrays.asList(
            LARIX_SPP_pattern0
        );
        PatternList LARIX_SPP = new PatternList("LARIX_SPP", LARIX_SPP_patterns);

        List<KeyValue> OTHER_EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus sylvestris")
        );
        List<KeyValue> OTHER_EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea abies")
        );
        List<List<KeyValue>> OTHER_EXOTIC_CONIFERS_patterns = Arrays.asList(
            OTHER_EXOTIC_CONIFERS_pattern0,
            OTHER_EXOTIC_CONIFERS_pattern1
        );
        PatternList OTHER_EXOTIC_CONIFERS = new PatternList("OTHER_EXOTIC_CONIFERS", OTHER_EXOTIC_CONIFERS_patterns);

        INodeMatch match = plot -> (
                plot.riv(LARIX_SPP) >= 50
           || (plot.riv(LARIX_SPP) >= 25 && plot.riv(OTHER_EXOTIC_CONIFERS) < 25)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_038() {

        // Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)
        // Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)

        String level = "subtype";
        String code = "Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_039() {

        // Exotic Southern Conifer Plantation Anthro-type (CTY015)
        // CTY015

        String level = "type";
        String code = "CTY015";

        // Tree species not as above.  Stands found in ecodivisions 230,
        // M230, 310 and ecoprovince 255. [note -if there are common exotic conifer
        // plantation species types in the south, they should be listed here, and
        // additional couplets added below].

        List<KeyValue> SOUTHERN_REGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "230, M230, 310, 255")
        );
        List<List<KeyValue>> SOUTHERN_REGION_patterns = Arrays.asList(
            SOUTHERN_REGION_pattern0
        );
        PatternList SOUTHERN_REGION = new PatternList("SOUTHERN_REGION", SOUTHERN_REGION_patterns);

        INodeMatch match = plot -> (
            plot.match(SOUTHERN_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_040() {

        // Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)
        // Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)

        String level = "subtype";
        String code = "Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_041() {

        // Eastern North American Hardwood Plantation
        // Eastern North American Hardwood Plantation

        String level = "subgroup";
        String code = "Eastern North American Hardwood Plantation";

        // Tree species are hardwoods >=75% RIV.  Implemented as NOT (conifers >= 25% RIV)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_042() {

        // Native Eastern North American Hardwood Plantations
        // Native Eastern North American Hardwood Plantations

        String level = "informal";
        String code = "Native Eastern North American Hardwood Plantations";

        // Tree species dominated by native hardwoods (See
        // Appendix A) with RIV > exotic hardwoods.

        List<KeyValue> NATIVE_HARDWOODS_pattern0 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<KeyValue> NATIVE_HARDWOODS_pattern1 = Arrays.asList(
            new KeyValue("softwoodhardwood", "H")
        );
        List<List<KeyValue>> NATIVE_HARDWOODS_patterns = Arrays.asList(
            NATIVE_HARDWOODS_pattern0,
            NATIVE_HARDWOODS_pattern1
        );
        PatternList NATIVE_HARDWOODS = new PatternList("NATIVE_HARDWOODS", NATIVE_HARDWOODS_patterns);

        List<KeyValue> EXOTIC_HARDWOODS_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> EXOTIC_HARDWOODS_pattern1 = Arrays.asList(
            new KeyValue("softwoodhardwood", "H")
        );
        List<List<KeyValue>> EXOTIC_HARDWOODS_patterns = Arrays.asList(
            EXOTIC_HARDWOODS_pattern0,
            EXOTIC_HARDWOODS_pattern1
        );
        PatternList EXOTIC_HARDWOODS = new PatternList("EXOTIC_HARDWOODS", EXOTIC_HARDWOODS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_HARDWOODS) > plot.riv(EXOTIC_HARDWOODS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_043() {

        // Native Northern Hardwood Forest Plantation Anthro-type (CTY016)
        // CTY016

        String level = "type";
        String code = "CTY016";

        // Stands found in ecodivisions 210, M210, 220, M220, 330 and ecoprovince 251.

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "210, M210, 220, M220, 330, 251")
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

    public Object[] element_044() {

        // Black Walnut Forest Plantation (CST007188)
        // Black Walnut Forest Plantation (CST007188)

        String level = "subtype";
        String code = "Black Walnut Forest Plantation (CST007188)";

        // Tree composition dominated by Juglans nigra >=25% RIV,
        // and exceeds each species of Populus tremuloides,
        // Populus spp., and Robinia pseudoacacia.

        List<KeyValue> BLACK_WALNUT_pattern0 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<List<KeyValue>> BLACK_WALNUT_patterns = Arrays.asList(
            BLACK_WALNUT_pattern0
        );
        PatternList BLACK_WALNUT = new PatternList("BLACK_WALNUT", BLACK_WALNUT_patterns);

        List<KeyValue> QUAKING_ASPEN_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> QUAKING_ASPEN_patterns = Arrays.asList(
            QUAKING_ASPEN_pattern0
        );
        PatternList QUAKING_ASPEN = new PatternList("QUAKING_ASPEN", QUAKING_ASPEN_patterns);

        List<KeyValue> POPULUS_SPP_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus")
        );
        List<List<KeyValue>> POPULUS_SPP_patterns = Arrays.asList(
            POPULUS_SPP_pattern0
        );
        PatternList POPULUS_SPP = new PatternList("POPULUS_SPP", POPULUS_SPP_patterns);

        List<KeyValue> BLACK_LOCUST_pattern0 = Arrays.asList(
            new KeyValue("species", "Robinia pseudoacacia")
        );
        List<List<KeyValue>> BLACK_LOCUST_patterns = Arrays.asList(
            BLACK_LOCUST_pattern0
        );
        PatternList BLACK_LOCUST = new PatternList("BLACK_LOCUST", BLACK_LOCUST_patterns);

        INodeMatch match = plot -> (
                plot.riv(BLACK_WALNUT) >= 25
           && plot.riv(BLACK_WALNUT) > plot.riv(QUAKING_ASPEN)
           && plot.riv(BLACK_WALNUT) > plot.riv(POPULUS_SPP)
           && plot.riv(BLACK_WALNUT) > plot.riv(BLACK_LOCUST)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_045() {

        // Aspen Forest Plantation (CST007189)
        // Aspen Forest Plantation (CST007189)

        String level = "subtype";
        String code = "Aspen Forest Plantation (CST007189)";

        // i. Tree composition dominated by Populus tremuloides, Populus spp. >=25% RIV,
        //    and exceeds each species of Juglans nigra and Robinia pseudoacacia.

        List<KeyValue> ASPEN_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> ASPEN_pattern1 = Arrays.asList(
            new KeyValue("species", "Populus")
        );
        List<List<KeyValue>> ASPEN_patterns = Arrays.asList(
            ASPEN_pattern0,
            ASPEN_pattern1
        );
        PatternList ASPEN = new PatternList("ASPEN", ASPEN_patterns);

        List<KeyValue> BLACK_WALNUT_pattern0 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<List<KeyValue>> BLACK_WALNUT_patterns = Arrays.asList(
            BLACK_WALNUT_pattern0
        );
        PatternList BLACK_WALNUT = new PatternList("BLACK_WALNUT", BLACK_WALNUT_patterns);

        List<KeyValue> BLACK_LOCUST_pattern0 = Arrays.asList(
            new KeyValue("species", "Robinia pseudoacacia")
        );
        List<List<KeyValue>> BLACK_LOCUST_patterns = Arrays.asList(
            BLACK_LOCUST_pattern0
        );
        PatternList BLACK_LOCUST = new PatternList("BLACK_LOCUST", BLACK_LOCUST_patterns);

        INodeMatch match = plot -> (
                plot.riv(ASPEN) >= 25
           && plot.riv(ASPEN) > plot.riv(BLACK_WALNUT)
           && plot.riv(ASPEN) > plot.riv(BLACK_LOCUST)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_046() {

        // Black Locust Forest Plantation (CST007190)
        // Black Locust Forest Plantation (CST007190)

        String level = "subtype";
        String code = "Black Locust Forest Plantation (CST007190)";

        // Tree composition dominated by Robinia pseudoacacia, >=25% RIV,
        // and exceeds each species of Juglans nigra, Populus tremuloides
        // and Populus spp.

        List<KeyValue> BLACK_LOCUST_pattern0 = Arrays.asList(
            new KeyValue("species", "Robinia pseudoacacia")
        );
        List<List<KeyValue>> BLACK_LOCUST_patterns = Arrays.asList(
            BLACK_LOCUST_pattern0
        );
        PatternList BLACK_LOCUST = new PatternList("BLACK_LOCUST", BLACK_LOCUST_patterns);

        List<KeyValue> BLACK_WALNUT_pattern0 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<List<KeyValue>> BLACK_WALNUT_patterns = Arrays.asList(
            BLACK_WALNUT_pattern0
        );
        PatternList BLACK_WALNUT = new PatternList("BLACK_WALNUT", BLACK_WALNUT_patterns);

        List<KeyValue> QUAKING_ASPEN_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<List<KeyValue>> QUAKING_ASPEN_patterns = Arrays.asList(
            QUAKING_ASPEN_pattern0
        );
        PatternList QUAKING_ASPEN = new PatternList("QUAKING_ASPEN", QUAKING_ASPEN_patterns);

        List<KeyValue> POPULUS_SPP_pattern0 = Arrays.asList(
            new KeyValue("species", "Populus")
        );
        List<List<KeyValue>> POPULUS_SPP_patterns = Arrays.asList(
            POPULUS_SPP_pattern0
        );
        PatternList POPULUS_SPP = new PatternList("POPULUS_SPP", POPULUS_SPP_patterns);

        INodeMatch match = plot -> (
                plot.riv(BLACK_LOCUST) >= 25
           && plot.riv(BLACK_LOCUST) > plot.riv(BLACK_WALNUT)
           && plot.riv(BLACK_LOCUST) > plot.riv(QUAKING_ASPEN)
           && plot.riv(BLACK_LOCUST) > plot.riv(POPULUS_SPP)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_047() {

        // Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)
        // Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)

        String level = "subtype";
        String code = "Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_048() {

        // Native Southern Hardwood Forest Plantation Anthro-type (CTY017)
        // CTY017

        String level = "type";
        String code = "CTY017";

        // Stands found in ecodivisions 230, M230, 310 and ecoprovince 255.

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "230, M230, 310, 255")
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

    public Object[] element_049() {

        // Tuliptree Forest Plantation (CST007197)
        // Tuliptree Forest Plantation (CST007197)

        String level = "subtype";
        String code = "Tuliptree Forest Plantation (CST007197)";

        // Tree composition dominated by Liriodendron tulipifera >=25% RIV,
        // and exceeds species of Liquidambar styraciflua.

        List<KeyValue> TULIPTREE_pattern0 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<List<KeyValue>> TULIPTREE_patterns = Arrays.asList(
            TULIPTREE_pattern0
        );
        PatternList TULIPTREE = new PatternList("TULIPTREE", TULIPTREE_patterns);

        List<KeyValue> SWEETGUM_pattern0 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<List<KeyValue>> SWEETGUM_patterns = Arrays.asList(
            SWEETGUM_pattern0
        );
        PatternList SWEETGUM = new PatternList("SWEETGUM", SWEETGUM_patterns);

        INodeMatch match = plot -> (
                plot.riv(TULIPTREE) >= 25
           && plot.riv(TULIPTREE) > plot.riv(SWEETGUM)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_050() {

        // Sweetgum Forest Plantation Subtype (CST007450)
        // Sweetgum Forest Plantation Subtype (CST007450)

        String level = "subtype";
        String code = "Sweetgum Forest Plantation Subtype (CST007450)";

        // Tree composition dominated by Liquidambar styraciflua >=25% RIV,
        // and exceeds species of Liriodendron tulipifera.

        List<KeyValue> SWEETGUM_pattern0 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<List<KeyValue>> SWEETGUM_patterns = Arrays.asList(
            SWEETGUM_pattern0
        );
        PatternList SWEETGUM = new PatternList("SWEETGUM", SWEETGUM_patterns);

        List<KeyValue> TULIPTREE_pattern0 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<List<KeyValue>> TULIPTREE_patterns = Arrays.asList(
            TULIPTREE_pattern0
        );
        PatternList TULIPTREE = new PatternList("TULIPTREE", TULIPTREE_patterns);

        INodeMatch match = plot -> (
                plot.riv(SWEETGUM) >= 25
           && plot.riv(SWEETGUM) > plot.riv(TULIPTREE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_051() {

        // Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)
        // Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)

        String level = "type";
        String code = "Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_052() {

        // Exotic Eastern North American Hardwood Plantations
        // Exotic Eastern North American Hardwood Plantations

        String level = "informal";
        String code = "Exotic Eastern North American Hardwood Plantations";

        // Tree species dominated by exotic hardwoods (See Appendix A) with RIV > native hardwoods.
        // Implemented as NOT native RIV > exotic RIV.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_053() {

        // Exotic Northern Hardwood Plantation Anthro-type (CTY018)
        // CTY018

        String level = "type";
        String code = "CTY018";

        // Exotic hardwood tree species found in ecodivisions 210, M210, 220, M220, 330
        // and ecoprovince 251. [note - no exotic hardwoods are known to be commonly planted.
        // If common exotic hardwood plantation species are identified, they should be added to
        // this list and additional couplets added below].

        List<KeyValue> NORTHERN_REGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "210, M210, 220, M220, 330, 251")
        );
        List<List<KeyValue>> NORTHERN_REGION_patterns = Arrays.asList(
            NORTHERN_REGION_pattern0
        );
        PatternList NORTHERN_REGION = new PatternList("NORTHERN_REGION", NORTHERN_REGION_patterns);

        INodeMatch match = plot -> (
            plot.match(NORTHERN_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_054() {

        // Exotic Southern Hardwood Plantation Anthro-type (CTY019a)
        // CTY019a

        String level = "type";
        String code = "CTY019a";

        // Tree species not as above.  Stands found in ecodivisions 230,
        // M230, 310 and ecoprovince 255. [note -if there are common exotic hardwood
        // plantation species types in the south, they should be listed here, and
        // additional couplets added below].

        List<KeyValue> SOUTHERN_REGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "230, M230, 310, 255")
        );
        List<List<KeyValue>> SOUTHERN_REGION_patterns = Arrays.asList(
            SOUTHERN_REGION_pattern0
        );
        PatternList SOUTHERN_REGION = new PatternList("SOUTHERN_REGION", SOUTHERN_REGION_patterns);

        INodeMatch match = plot -> (
            plot.match(SOUTHERN_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_055() {

        // North American Boreal Forest Plantation Cultural Subgroup
        // North American Boreal Forest Plantation Cultural Subgroup

        String level = "subgroup";
        String code = "North American Boreal Forest Plantation Cultural Subgroup";

        // Plantations found in the boreal region of North America (EcoDomain 100)

        List<KeyValue> BOREAL_REGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "100")
        );
        List<List<KeyValue>> BOREAL_REGION_patterns = Arrays.asList(
            BOREAL_REGION_pattern0
        );
        PatternList BOREAL_REGION = new PatternList("BOREAL_REGION", BOREAL_REGION_patterns);

        INodeMatch match = plot -> (
            plot.match(BOREAL_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_056() {

        // Natural and Ruderal Forests
        // Natural and Ruderal Forests

        String level = "informal";
        String code = "Natural and Ruderal Forests";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_057() {

        // Wetland Forest & Woodlands Key
        // Wetland Forest & Woodlands

        String level = "informal";
        String code = "Wetland Forest & Woodlands";

        // i. The "physiographic class code" in FIA database is NOT in the Hydric or Riverine series, AND EITHER
        //      ia. the "obligate wet" (W1) species (see Appendix A) have a combined RIV >=20%; OR
        //      ib. the "obligate wet" (W1) species have at least a combined RIV of >=5%, and the combination
        //          of "obligate wet" (W1) and "facultative wet" (W2) has a combined RIV of >=50%, OR
        //      ic. "facultative wet" (W2) tree species have a combined RIV of >=60%,
        //      id. "facultative wet" (W2) tree species have at least a combined RIV > 30%, and the combination
        //          of "facultative wet" (W2) and "facultative" (W3) > 70%, OR
        //      ie. Wetland indicators W1, W2 (WI) > Upland indicators (UI).  Do not include exotic or
        //          FAC(W3) species.
        //  ii. if "physiographic class code" in FIA database is in the Hydric or Riverine series, AND EITHER
        //      iia. the "obligate wet" (W1) wetland diagnostic species have a combined RIV of (>=10%), OR
        //      iib. the "obligate wet" (W1) species have at least a combined RIV of >=5%, and the combination
        //           of "obligate wet" (W1) and "facultative wet" (W2) have a combined RIV of >=40%, OR
        //      iic. the "facultative wet" (W2) tree species have a combined RIV of >= 50%
        //      iid. "facultative wet" (W2) tree species have at least a combined RIV > 20%, and the combination
        //           of "facultative wet" (W2) and "facultative" (W3) > 60%, OR
        //      iie. Wetland indicators W1, W2 (WI) > Upland indicators (UI).  Do not include exotic or
        //           FAC(W3) species.
        //      iif. "facultative" (W3) have combine RIV >= 80%
        // iii. the ecoregion is 231E, 231G, OR 255 AND
        //      iiia. The "physiographic class code" in FIA Database is in the Riverine series
        //      OR
        //      iiib. The "obligate wet" (W1) species have at least a combined RIV >=5%, and the combination of
        //            "obligate wet" (W1), "facultative wet" (W2), "facultative" (W3), and Gleditsia triacanthos
        //            and Quercus virginiana have a combined RIV >=50%
        //  iv. the ecoregion is 211, M211, 212, AND
        //      the combination of "obligate wet" (W1) and "facultative wet" (W2) >= 50%,
        //      OR
        //      Fraxinus nigra, Larix laricina, Picea mariana, Populus balsamifera, and Thuja occidentalis have a combined RIV >= 25%

        List<KeyValue> HYDRIC_pattern0 = Arrays.asList(
            new KeyValue("hydric", "Y")
        );
        List<List<KeyValue>> HYDRIC_patterns = Arrays.asList(
            HYDRIC_pattern0
        );
        PatternList HYDRIC = new PatternList("HYDRIC", HYDRIC_patterns);

        List<KeyValue> W1_pattern0 = Arrays.asList(
            new KeyValue("wetland", "OBL")
        );
        List<List<KeyValue>> W1_patterns = Arrays.asList(
            W1_pattern0
        );
        PatternList W1 = new PatternList("W1", W1_patterns);

        List<KeyValue> W2_pattern0 = Arrays.asList(
            new KeyValue("wetland", "FACW")
        );
        List<List<KeyValue>> W2_patterns = Arrays.asList(
            W2_pattern0
        );
        PatternList W2 = new PatternList("W2", W2_patterns);

        List<KeyValue> W3_pattern0 = Arrays.asList(
            new KeyValue("wetland", "FAC")
        );
        List<List<KeyValue>> W3_patterns = Arrays.asList(
            W3_pattern0
        );
        PatternList W3 = new PatternList("W3", W3_patterns);

        List<KeyValue> WETLAND_pattern0 = Arrays.asList(
            new KeyValue("wetland", "OBL, FACW")
        );
        List<KeyValue> WETLAND_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<List<KeyValue>> WETLAND_patterns = Arrays.asList(
            WETLAND_pattern0,
            WETLAND_pattern1
        );
        PatternList WETLAND = new PatternList("WETLAND", WETLAND_patterns);

        List<KeyValue> UPLAND_pattern0 = Arrays.asList(
            new KeyValue("wetland", "UPL")
        );
        List<KeyValue> UPLAND_pattern1 = Arrays.asList(
            new KeyValue("exotic", "N")
        );
        List<List<KeyValue>> UPLAND_patterns = Arrays.asList(
            UPLAND_pattern0,
            UPLAND_pattern1
        );
        PatternList UPLAND = new PatternList("UPLAND", UPLAND_patterns);

        List<KeyValue> ECOREGIONS_III_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231E, 231G, 255")
        );
        List<List<KeyValue>> ECOREGIONS_III_patterns = Arrays.asList(
            ECOREGIONS_III_pattern0
        );
        PatternList ECOREGIONS_III = new PatternList("ECOREGIONS_III", ECOREGIONS_III_patterns);

        List<KeyValue> RIVERINE_pattern0 = Arrays.asList(
            new KeyValue("riverine", "Y")
        );
        List<List<KeyValue>> RIVERINE_patterns = Arrays.asList(
            RIVERINE_pattern0
        );
        PatternList RIVERINE = new PatternList("RIVERINE", RIVERINE_patterns);

        List<KeyValue> SPECIES_III_pattern0 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> SPECIES_III_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<List<KeyValue>> SPECIES_III_patterns = Arrays.asList(
            SPECIES_III_pattern0,
            SPECIES_III_pattern1
        );
        PatternList SPECIES_III = new PatternList("SPECIES_III", SPECIES_III_patterns);

        List<KeyValue> ECOREGIONS_IV_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "211, M211, 212")
        );
        List<List<KeyValue>> ECOREGIONS_IV_patterns = Arrays.asList(
            ECOREGIONS_IV_pattern0
        );
        PatternList ECOREGIONS_IV = new PatternList("ECOREGIONS_IV", ECOREGIONS_IV_patterns);

        List<KeyValue> SPECIES_IV_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> SPECIES_IV_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> SPECIES_IV_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> SPECIES_IV_pattern3 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> SPECIES_IV_pattern4 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<List<KeyValue>> SPECIES_IV_patterns = Arrays.asList(
            SPECIES_IV_pattern0,
            SPECIES_IV_pattern1,
            SPECIES_IV_pattern2,
            SPECIES_IV_pattern3,
            SPECIES_IV_pattern4
        );
        PatternList SPECIES_IV = new PatternList("SPECIES_IV", SPECIES_IV_patterns);

        INodeMatch match = plot -> (
            (!plot.match(HYDRIC) && !plot.match(RIVERINE) && (    plot.riv(W1) >= 20
                                                  || (plot.riv(W1) >= 5 && plot.riv(W1) + plot.riv(W2) >= 50)
                                                  ||  plot.riv(W2) >= 60
                                                  || (plot.riv(W2) >= 30 && plot.riv(W2) + plot.riv(W3) >= 70)
                                                  ||  plot.riv(WETLAND) > plot.riv(UPLAND)
                                                 ))
           || (plot.match(HYDRIC) || plot.match(RIVERINE)  && (    plot.riv(W1) >= 10
                                                  || (plot.riv(W1) >= 5 && plot.riv(W1) + plot.riv(W2) >= 40)
                                                  || plot.riv(W2) >= 50
                                                  || (plot.riv(W2) >= 20 && plot.riv(W2) + plot.riv(W3) >= 60)
                                                  || plot.riv(WETLAND) > plot.riv(UPLAND)
                                                  || plot.riv(W3) >= 80
                                                 ))
           || (plot.match(ECOREGIONS_III) && (plot.match(RIVERINE) || (plot.riv(W1) >= 5 && plot.riv(W1) + plot.riv(W2) + plot.riv(W3) + plot.riv(SPECIES_III) >= 50)))
           || (plot.match(ECOREGIONS_IV) && (plot.riv(W1) + plot.riv(W2) >= 50 || plot.riv(SPECIES_IV) >= 25))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_058() {

        // Brackish Tidal Wetland Biome (MB1), Coastal Brackish Tidal Wetland Subbiome (MB1.a), Mangrove Ecobiome, (MB1.a2) and Atlantic-Caribbean & East Pacific Mangrove (D004).
        // Brackish Tidal Wetland Biome

        String level = "informal";
        String code = "Brackish Tidal Wetland Biome";

        // A.  Plots found in coastal brackish tidal conditions, where 
        // i.  Plots found in Ecosection 232 or 411 (Tropical Florida and Gulf or Atlantic coast) AND 
        // ii.  tree composition dominated by one or more of Avicennia germinans, Conocarpus erectus, Laguncularia racemosa, Rhizophora mangle (=>20% RIV); …………………………Key TW1. Brackish Tidal Wetland Biome (MB1), Coastal Brackish Tidal Wetland Subbiome (MB1.a), Mangrove Ecobiome, (MB1.a2) and Atlantic-Caribbean & East Pacific Mangrove (D004).

        List<KeyValue> TROPICAL_ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "232")
        );
        List<KeyValue> TROPICAL_ECOREGIONS_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "411")
        );
        List<List<KeyValue>> TROPICAL_ECOREGIONS_patterns = Arrays.asList(
            TROPICAL_ECOREGIONS_pattern0,
            TROPICAL_ECOREGIONS_pattern1
        );
        PatternList TROPICAL_ECOREGIONS = new PatternList("TROPICAL_ECOREGIONS", TROPICAL_ECOREGIONS_patterns);

        List<KeyValue> MANGROVE_INDICATORS_pattern0 = Arrays.asList(
            new KeyValue("species", "Avicennia germinans")
        );
        List<KeyValue> MANGROVE_INDICATORS_pattern1 = Arrays.asList(
            new KeyValue("species", "Conocarpus erectus")
        );
        List<KeyValue> MANGROVE_INDICATORS_pattern2 = Arrays.asList(
            new KeyValue("species", "Laguncularia racemosa")
        );
        List<KeyValue> MANGROVE_INDICATORS_pattern3 = Arrays.asList(
            new KeyValue("species", "Rhizophora mangle")
        );
        List<List<KeyValue>> MANGROVE_INDICATORS_patterns = Arrays.asList(
            MANGROVE_INDICATORS_pattern0,
            MANGROVE_INDICATORS_pattern1,
            MANGROVE_INDICATORS_pattern2,
            MANGROVE_INDICATORS_pattern3
        );
        PatternList MANGROVE_INDICATORS = new PatternList("MANGROVE_INDICATORS", MANGROVE_INDICATORS_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_ECOREGIONS) &&
           plot.riv(MANGROVE_INDICATORS)>=20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_059() {

        // Tropical Florida Natural Mangrove Forests
        // Tropical Florida Natural Mangrove Forests

        String level = "informal";
        String code = "Tropical Florida Natural Mangrove Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no evidence of trees in a row, no very recent logging, understory mowing, etc. (trees may be early successional pole-sized trees following logging or blowdowns). Tree composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix B - needs to be refined for this Division).

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
            plot.riv(RUDERAL_EXOTIC) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_060() {

        // Western Atlantic & Caribbean Mangrove (M005)
        // M005

        String level = "macrogroup";
        String code = "M005";

        // Tree composition dominated by one or more of Avicennia germinans, Conocarpus erectus,
        // Laguncularia racemosa, Rhizophora mangle (>=20% RIV);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Avicennia germinans")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Conocarpus erectus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Laguncularia racemosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Rhizophora mangle")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_061() {

        // Tropical Florida Ruderal Mangrove Forests
        // Tropical Florida Ruderal Mangrove Forests

        String level = "informal";
        String code = "Tropical Florida Ruderal Mangrove Forests";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy native vegetation that invades natural stands or vegetation that dominates on formerly cleared and/or planted sites but which has been allowed to succeed more-or-less spontaneously). Tree composition dominated by ruderal native or exotic species (>= 80% RIV) (see Appendix B – needs to be refined for this Division).

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC)>= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_062() {

        // Palustrine Wetland Biome (TP1), Forested Wetland Subbiome (TP1.a)
        // Palustrine Wetland Biome (TP1), Forested Wetland Subbiome (TP1.a)

        String level = "informal";
        String code = "Palustrine Wetland Biome (TP1), Forested Wetland Subbiome (TP1.a)";

        // Tree composition not as above (that is, freshwater forested wetlands)…………….B (Palustrine Wetland Biome (TP1), Forested Wetland Subbiome (TP1.a) [note that we do not have good information on Puerto Rico freshwater forested wetlands, and so the key may fail there]

        List<KeyValue> TROPICAL_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "411")
        );
        List<List<KeyValue>> TROPICAL_patterns = Arrays.asList(
            TROPICAL_pattern0
        );
        PatternList TROPICAL = new PatternList("TROPICAL", TROPICAL_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_063() {

        // Caribbean Natural Wetland Forest
        // Caribbean Natural Wetland Forest

        String level = "informal";
        String code = "Caribbean Natural Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_064() {

        // Caribbean Swamp (M617)
        // M617

        String level = "macrogroup";
        String code = "M617";

        // Only one Macrogroup reported for the Caribbean U.S., its territories and commonwealth.
        // See also M618 (Caribbean Floodplain Forest) reported elsewhere in the Caribbean, and
        // likely present in Puerto Rico

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_065() {

        // Caribbean Ruderal Wetland Forest
        // Caribbean Ruderal Wetland Forest

        String level = "informal";
        String code = "Caribbean Ruderal Wetland Forest";

        // At this time, no ruderal types are know in the Caribbean region of the U.S., its
        // territories and commonwealth.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_066() {

        // Temperate & Boreal Forested Wetland (F136)
        // F136

        String level = "ecobiome";
        String code = "F136";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_067() {

        // Southeastern North American Flooded & Swamp Forest Division (D062)
        // D062

        String level = "division";
        String code = "D062";

        // i. Tree composition dominated by one or more of conifers of Chamaecyparis thyoides, Pinus elliottii,
        //     Pinus glabra, Pinus palustris, Pinus serotina, Pinus taeda, Taxodium distichum, Taxodium ascendens,
        //     or hardwoods Carya aquatica, Fraxinus caroliniana, Fraxinus profunda, Gleditsia aquatica,
        //     Gordonia lasianthus, Halesia diptera, Juglans major, Juglans microcarpa, Magnolia virginiana,
        //     Nyssa aquatica, Nyssa biflora, Planera aquatica, Persea borbonia, Nyssa ogeche, Quercus laurifolia,
        //     Quercus lyrata, Quercus michauxii, Quercus nigra, Quercus pagoda, Quercus sinuata var. sinuata,
        //     Quercus texana, Quercus virginiana, Sabal palmetto, Ulmus crassifolia (>=20% RIV); EXCLUDING coastal
        //     plain forests of MD, NY, NJ, PA, DE, VA or Ecoregion 221.
        // OR
        // ii. STANDS FOUND in EcoProvince 231, 232, 234 and 255 (but EXCLUDING KS and coastal plain forests
        //     of MD, NY, NJ, PA, DE)
        // 
        // [Note: Tree composition that fits c.ii. (i.e lack strong diagnostics but are found in coastal plain forest
        // wetlands could include stands dominated by one or more of conifers of Pinus taeda or hardwoods  Acer saccharinum,
        // Acer rubrum, Celtis laevigata, Fraxinus pennsylvanica, Liquidambar styraciflua, Platanus occidentalis Salix nigra,
        // Quercus macrocarpa, Quercus shumardii, Ulmus americana, Ulmus crassifolia (>=50% RIV); OR Tree composition as above,
        // but with >=20% RIV; AND other species are any combination of Acer negundo, Carpinus caroliniana, Ilex opaca,
        // Magnolia grandiflora (together >=50% RIV), OR All Ruderal stands where ruderals >= 80% RIV]

        List<KeyValue> EXCLUDED_STATE_REGION_pattern0 = Arrays.asList(
            new KeyValue("state", "KS")
        );
        List<List<KeyValue>> EXCLUDED_STATE_REGION_patterns = Arrays.asList(
            EXCLUDED_STATE_REGION_pattern0
        );
        PatternList EXCLUDED_STATE_REGION = new PatternList("EXCLUDED_STATE_REGION", EXCLUDED_STATE_REGION_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis thyoides")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Taxodium ascendens")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya aquatica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Fraxinus caroliniana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Fraxinus profunda")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Gleditsia aquatica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Gordonia lasianthus")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Halesia diptera")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Nyssa aquatica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Nyssa biflora")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Planera aquatica")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Nyssa ogeche")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus lyrata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern24 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern25 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern26 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern27 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata var. sinuata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern28 = Arrays.asList(
            new KeyValue("species", "Quercus texana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern29 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern30 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_pattern31 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
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
            DIAGNOSTIC_SPECIES_pattern21,
            DIAGNOSTIC_SPECIES_pattern22,
            DIAGNOSTIC_SPECIES_pattern23,
            DIAGNOSTIC_SPECIES_pattern24,
            DIAGNOSTIC_SPECIES_pattern25,
            DIAGNOSTIC_SPECIES_pattern26,
            DIAGNOSTIC_SPECIES_pattern27,
            DIAGNOSTIC_SPECIES_pattern28,
            DIAGNOSTIC_SPECIES_pattern29,
            DIAGNOSTIC_SPECIES_pattern30,
            DIAGNOSTIC_SPECIES_pattern31
        );
        PatternList DIAGNOSTIC_SPECIES = new PatternList("DIAGNOSTIC_SPECIES", DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> ECOREGIONS_II_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231, 232, 234, 255")
        );
        List<List<KeyValue>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        INodeMatch match = plot -> (
            plot.riv(DIAGNOSTIC_SPECIES) >= 20 || 
           (plot.match(ECOREGIONS_II) && !plot.match(EXCLUDED_STATE_REGION))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_068() {

        // Eastern Warm Temperate Natural Wetland Forest
        // Eastern Warm Temperate Natural Wetland Forest

        String level = "informal";
        String code = "Eastern Warm Temperate Natural Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_069() {

        // Southern Great Plains Floodplain Forest & Woodland (M154)
        // Southern Great Plains Floodplain Forest & Woodland (M154)

        String level = "macrogroup";
        String code = "Southern Great Plains Floodplain Forest & Woodland (M154)";

        // Stands found in Ecoregion 255B-D, 315C-E, 315G, 321B AND Tree composition dominated by:
        //  i. Tree composition dominated by one or more of STRONG SOUTHERN GREAT PLAINS DIAGNOSTICS,
        //     Carya illinoinensis, Celtis laevigata var. reticulata, Fraxinus pennsylvanica, Juglans microcarpa,
        //     Juglans nigra, Juglans major, Platanus occidentalis, Populus deltoides, Quercus shumardii,
        //     Quercus virginiana, Salix nigra Taxodium distichum, Ulmus americana, Ulmus crassifolia (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV; AND other species are any combination of
        //     MODERATE DIAGNOSTICS, Acer negundo, Celtis occidentalis, iospyros virginiana, Gleditsia triacanthos,
        //     Juglans nigra, Maclura pomifera, Prosopis glandulosa, Quercus macrocarpa, Quercus nigra,
        //     Sapindus saponaria var. drummondii, Sideroxylon lanuginosum ssp. lanuginosum,
        //     Ulmus crassifolia (together >=50% RIV)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "255B, 255C, 255D, 315C, 315D, 315E, 315G, 321B")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Juglans microcarpa")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Juglans major")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<List<KeyValue>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern0,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern1,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern2,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern3,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern4,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern5,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern6,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern7,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern8,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern9,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern10,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern11,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern12,
            STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern13
        );
        PatternList STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS = new PatternList("STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS", STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Maclura pomifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Prosopis glandulosa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
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
                 plot.match(ECOREGIONS)
           && (    plot.riv(STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS) >= 50
                || (    plot.riv(STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS) >= 20
                    && plot.riv(STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_070() {

        // Pond-cypress Basin Swamp (M161)
        // Pond-cypress Basin Swamp (M161)

        String level = "macrogroup";
        String code = "Pond-cypress Basin Swamp (M161)";

        //  i. Tree composition dominated by STRONG POND CYPRESS DIAGNOSTICS
        //     Taxodium distichum var. nutans (= Taxodium ascendens) (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are
        //     any combination of MODERATE DIAGNOSTICS coastal plain species of Acer rubrum,
        //     Annona glabra, Liriodendron tulipifera, Liquidambar styraciflua,
        //     Nyssa sylvatica var. biflora (= Nyssa biflora), Persea borbonia (= Persea palustris),
        //     Pinus serotina, Pinus elliottii, Pinus taeda, Taxodium distichum, Sabal palmetto
        //     (together >=50% RIV).

        List<KeyValue> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Taxodium ascendens")
        );
        List<List<KeyValue>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Annona glabra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Nyssa biflora")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
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
                plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) >= 50
           || (    plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) >= 20
               && plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_071() {

        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)
        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)

        String level = "macrogroup";
        String code = "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)";

        // Plots found in ecosection 231A, B, D, E, 232A-D, F, G AND
        // tree composition, with STRONG SWAMP DIAGNOSTICS Pinus palustris < 5% RIV AND dominated by one or more
        // of Chamaecyparis thyoides, Cliftonia monophylla [not tracked by FIA], Fraxinus caroliniana, Gordonia lasianthus,
        // Magnolia virginiana, Persea borbonia, Pinus serotina or Quercus laurifolia, Sabal palmetto (>=20% RIV);

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231A, 231B, 231D, 231E, 232A, 232B, 232C, 232D, 232F, 232G")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis thyoides")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Cliftonia monophylla")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus caroliniana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Gordonia lasianthus")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_SWAMP_DIAGNOSTICS_pattern0,
            STRONG_SWAMP_DIAGNOSTICS_pattern1,
            STRONG_SWAMP_DIAGNOSTICS_pattern2,
            STRONG_SWAMP_DIAGNOSTICS_pattern3,
            STRONG_SWAMP_DIAGNOSTICS_pattern4,
            STRONG_SWAMP_DIAGNOSTICS_pattern5,
            STRONG_SWAMP_DIAGNOSTICS_pattern6,
            STRONG_SWAMP_DIAGNOSTICS_pattern7,
            STRONG_SWAMP_DIAGNOSTICS_pattern8
        );
        PatternList STRONG_SWAMP_DIAGNOSTICS = new PatternList("STRONG_SWAMP_DIAGNOSTICS", STRONG_SWAMP_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && (plot.riv(EXCLUDED_SPECIES) < 5 && plot.riv(STRONG_SWAMP_DIAGNOSTICS) >= 20)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_072() {

        // Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)
        // Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)

        String level = "macrogroup";
        String code = "Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)";

        //  i. Tree composition dominated by STRONG FLOODPLAIN DIAGNOSTICS Acer saccharinum, Carya aquatica, Betula nigra,
        //     Carya illinoinensis, Celtis laevigata, Fraxinus pennsylvanica, Fraxinus profunda, Liquidambar styraciflua,
        //     Gleditsia aquatica, Juniperus virginiana var. silicicola, Nyssa aquatica, Nyssa biflora, Nyssa ogeche,
        //     Planera aquatica, Platanus occidentalis, Populus deltoides, Quercus falcata var. pagodifolia (= Q. pagoda),
        //     Quercus laurifolia, Quercus lyrata, Quercus michauxii, Quercus nigra, Quercus phellos, Quercus shumardii,
        //     Quercus texana, Salix caroliniana, Salix nigra, Sapindus saponaria var. drummondii, Taxodium distichum,
        //     Ulmus americana, Ulmus crassifolia (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with at least 20% RIV; AND in combination with other species of MODERATE DIAGNOSTICS
        //     Acer negundo, Acer rubrum, Carpinus caroliniana, Chamaecyparis thyoides, Gleditsia triacanthos, Halesia diptera,
        //     Ilex opaca, Juglans nigra, Liriodendron tulipifera, Magnolia grandiflora, Magnolia virginiana, Nyssa sylvatica,
        //     Pinus elliottii, Pinus glabra, Pinus taeda, Quercus macrocarpa, Sabal palmetto, Ulmus rubra, Ulmus serotina (together >=50% RIV)

        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus profunda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Gleditsia aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Nyssa aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Nyssa biflora")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Nyssa ogeche")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Planera aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus lyrata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus texana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Salix caroliniana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<List<KeyValue>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29
        );
        PatternList STRONG_FLOODPLAIN_DIAGNOSTICS = new PatternList("STRONG_FLOODPLAIN_DIAGNOSTICS", STRONG_FLOODPLAIN_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis thyoides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Halesia diptera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Magnolia grandiflora")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Ulmus serotina")
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

        INodeMatch match = plot -> (
                plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS) >= 50
           || (    plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS) >= 20
               && plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_073() {

        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)
        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)

        String level = "macrogroup";
        String code = "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)";

        // Plots found in ecosection 231A, B, D, E, 232A-D, F, G AND
        // % RIV of STRONG SWAMP DIAGNOSTICS > either STRONG POND CYPRESS DIAGNOSTICS
        // or STRONG LONGLEAF DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231A, 231B, 231D, 231E, 232A, 232B, 232C, 232D, 232F, 232G")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Taxodium ascendens")
        );
        List<List<KeyValue>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis thyoides")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Cliftonia monophylla")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus caroliniana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Gordonia lasianthus")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_SWAMP_DIAGNOSTICS_pattern0,
            STRONG_SWAMP_DIAGNOSTICS_pattern1,
            STRONG_SWAMP_DIAGNOSTICS_pattern2,
            STRONG_SWAMP_DIAGNOSTICS_pattern3,
            STRONG_SWAMP_DIAGNOSTICS_pattern4,
            STRONG_SWAMP_DIAGNOSTICS_pattern5,
            STRONG_SWAMP_DIAGNOSTICS_pattern6,
            STRONG_SWAMP_DIAGNOSTICS_pattern7,
            STRONG_SWAMP_DIAGNOSTICS_pattern8
        );
        PatternList STRONG_SWAMP_DIAGNOSTICS = new PatternList("STRONG_SWAMP_DIAGNOSTICS", STRONG_SWAMP_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus profunda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Gleditsia aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Nyssa aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Nyssa biflora")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Nyssa ogeche")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Planera aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus lyrata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus texana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Salix caroliniana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<List<KeyValue>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29
        );
        PatternList STRONG_FLOODPLAIN_DIAGNOSTICS = new PatternList("STRONG_FLOODPLAIN_DIAGNOSTICS", STRONG_FLOODPLAIN_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) &&
                (plot.riv(STRONG_SWAMP_DIAGNOSTICS) > plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS)
              || plot.riv(STRONG_SWAMP_DIAGNOSTICS) > plot.riv(STRONG_LONGLEAF_DIAGNOSTICS)
              || plot.riv(STRONG_SWAMP_DIAGNOSTICS) > plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_074() {

        // Pond-cypress Basin Swamp LC (M161)
        // Pond-cypress Basin Swamp LC (M161)

        String level = "macrogroup";
        String code = "Pond-cypress Basin Swamp LC (M161)";

        // % RIV OF STRONG POND CYPRESS DIAGNOSTICS > STRONG LONGLEAF DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

        List<KeyValue> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Taxodium ascendens")
        );
        List<List<KeyValue>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis thyoides")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Cliftonia monophylla")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus caroliniana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Gordonia lasianthus")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_SWAMP_DIAGNOSTICS_pattern0,
            STRONG_SWAMP_DIAGNOSTICS_pattern1,
            STRONG_SWAMP_DIAGNOSTICS_pattern2,
            STRONG_SWAMP_DIAGNOSTICS_pattern3,
            STRONG_SWAMP_DIAGNOSTICS_pattern4,
            STRONG_SWAMP_DIAGNOSTICS_pattern5,
            STRONG_SWAMP_DIAGNOSTICS_pattern6,
            STRONG_SWAMP_DIAGNOSTICS_pattern7,
            STRONG_SWAMP_DIAGNOSTICS_pattern8
        );
        PatternList STRONG_SWAMP_DIAGNOSTICS = new PatternList("STRONG_SWAMP_DIAGNOSTICS", STRONG_SWAMP_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus profunda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Gleditsia aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Nyssa aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Nyssa biflora")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Nyssa ogeche")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Planera aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus lyrata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus texana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Salix caroliniana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<List<KeyValue>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29
        );
        PatternList STRONG_FLOODPLAIN_DIAGNOSTICS = new PatternList("STRONG_FLOODPLAIN_DIAGNOSTICS", STRONG_FLOODPLAIN_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
               plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) > plot.riv(STRONG_LONGLEAF_DIAGNOSTICS)
           || plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) > plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_075() {

        // Longleaf Pine Woodland LC2 (M007)
        // Longleaf Pine Woodland LC2 (M007)

        String level = "macrogroup";
        String code = "Longleaf Pine Woodland LC2 (M007)";

        // % RIV OF STRONG LONGLEAF DIAGNOSTICS > either STRONG POND CYPRESS DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

        List<KeyValue> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Taxodium ascendens")
        );
        List<List<KeyValue>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Chamaecyparis thyoides")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Cliftonia monophylla")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus caroliniana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Gordonia lasianthus")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus serotina")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_SWAMP_DIAGNOSTICS_pattern0,
            STRONG_SWAMP_DIAGNOSTICS_pattern1,
            STRONG_SWAMP_DIAGNOSTICS_pattern2,
            STRONG_SWAMP_DIAGNOSTICS_pattern3,
            STRONG_SWAMP_DIAGNOSTICS_pattern4,
            STRONG_SWAMP_DIAGNOSTICS_pattern5,
            STRONG_SWAMP_DIAGNOSTICS_pattern6,
            STRONG_SWAMP_DIAGNOSTICS_pattern7,
            STRONG_SWAMP_DIAGNOSTICS_pattern8
        );
        PatternList STRONG_SWAMP_DIAGNOSTICS = new PatternList("STRONG_SWAMP_DIAGNOSTICS", STRONG_SWAMP_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus profunda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Gleditsia aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Nyssa aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Nyssa biflora")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Nyssa ogeche")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Planera aquatica")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus lyrata")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus texana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Salix caroliniana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new KeyValue("species", "Sapindus saponaria var. drummondii")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new KeyValue("species", "Taxodium distichum")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new KeyValue("species", "Ulmus crassifolia")
        );
        List<List<KeyValue>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28,
            STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29
        );
        PatternList STRONG_FLOODPLAIN_DIAGNOSTICS = new PatternList("STRONG_FLOODPLAIN_DIAGNOSTICS", STRONG_FLOODPLAIN_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
               plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) > plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS)
           || plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) > plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_076() {

        // Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)
        // Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)

        String level = "macrogroup";
        String code = "Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_077() {

        // Eastern Warm Temperate Ruderal Wetland Forest
        // Eastern Warm Temperate Ruderal Wetland Forest

        String level = "informal";
        String code = "Eastern Warm Temperate Ruderal Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_078() {

        // Southeastern North American Ruderal Flooded & Swamp Forest (M310)
        // Southeastern North American Ruderal Flooded & Swamp Forest (M310)

        String level = "macrogroup";
        String code = "Southeastern North American Ruderal Flooded & Swamp Forest (M310)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_079() {

        // North American Boreal Flooded Forest & Swamp Division (D016)
        // D016

        String level = "division";
        String code = "D016";

        // D. Tree composition dominated by one of the following:
        // i. Located in Ecoprovince 212, 211, or M211, AND
        //     ia. Tree composition dominated by one or more of boreal wetland conifer species (Larix laricina, Picea mariana) (>=80% RIV);
        //   ib. The above tree composition but with =>20% RIV; AND other species are any combination of boreal hardwoods (Betula papyrifera) or other conifers (Abies balsamea, Fraxinus nigra, Picea glauca, Pinus banksiana, Populus balsamifera) species (together >=95% RIV); [N.B. role of Thuja occidentalis in boreal swamps still under review]

        List<KeyValue> ECOREGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212, 211, M211")
        );
        List<List<KeyValue>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        List<KeyValue> STRONG_INDICATORS_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_INDICATORS_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<List<KeyValue>> STRONG_INDICATORS_patterns = Arrays.asList(
            STRONG_INDICATORS_pattern0,
            STRONG_INDICATORS_pattern1
        );
        PatternList STRONG_INDICATORS = new PatternList("STRONG_INDICATORS", STRONG_INDICATORS_patterns);

        List<KeyValue> BOREAL_INDICATORS_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> BOREAL_INDICATORS_pattern1 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> BOREAL_INDICATORS_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> BOREAL_INDICATORS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> BOREAL_INDICATORS_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> BOREAL_INDICATORS_pattern5 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<List<KeyValue>> BOREAL_INDICATORS_patterns = Arrays.asList(
            BOREAL_INDICATORS_pattern0,
            BOREAL_INDICATORS_pattern1,
            BOREAL_INDICATORS_pattern2,
            BOREAL_INDICATORS_pattern3,
            BOREAL_INDICATORS_pattern4,
            BOREAL_INDICATORS_pattern5
        );
        PatternList BOREAL_INDICATORS = new PatternList("BOREAL_INDICATORS", BOREAL_INDICATORS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGION) &&
           (plot.riv(STRONG_INDICATORS) >=80 ||
           (plot.riv(STRONG_INDICATORS) +
           plot.riv(BOREAL_INDICATORS) >=95))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_080() {

        // Eastern Boreal Natural Wetland Forests
        // Eastern Boreal Natural Wetland Forests

        String level = "informal";
        String code = "Eastern Boreal Natural Wetland Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no evidence of trees in a row, no very recent logging, understory mowing, etc. (trees may be early successional pole-sized trees following logging or blowdowns). Tree composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix B - needs to be refined for this Division).

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_081() {

        // North American Boreal Conifer Poor Swamp (M299)
        // North American Boreal Conifer Poor Swamp (M299)

        String level = "macrogroup";
        String code = "North American Boreal Conifer Poor Swamp (M299)";

        // Tree composition dominated by one of the following:
        //  i.   Any combination of one or more of the boreal wetland conifer species (Larix laricina,
        //       Picea mariana (>=50% RIV);
        // OR
        // ii.  The above tree composition with >=20% RIV; AND other species are any combination of
        //      boreal hardwoods Betula papyrifera, or other conifers Abies balsamea, Picea glauca,
        //      Pinus banksiana (together >=95% RIV);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
           || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 95)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_082() {

        // North American Boreal Flooded Forest & Rich Swamp (M300)
        // North American Boreal Flooded Forest & Rich Swamp (M300)

        String level = "macrogroup";
        String code = "North American Boreal Flooded Forest & Rich Swamp (M300)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_083() {

        // Eastern Boreal Ruderal Wetland Forests
        // Eastern Boreal Ruderal Wetland Forests

        String level = "informal";
        String code = "Eastern Boreal Ruderal Wetland Forests";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy native vegetation that invades natural stands or vegetation that dominates on formerly cleared and/or planted sites but which has been allowed to succeed more-or-less spontaneously). Tree composition dominated by ruderal native or exotic species (>= 80% RIV) (see Appendix B – needs to be refined for this Division).

        List<KeyValue> RUDERAL_EXOTIC_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<KeyValue> RUDERAL_EXOTIC_pattern1 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<List<KeyValue>> RUDERAL_EXOTIC_patterns = Arrays.asList(
            RUDERAL_EXOTIC_pattern0,
            RUDERAL_EXOTIC_pattern1
        );
        PatternList RUDERAL_EXOTIC = new PatternList("RUDERAL_EXOTIC", RUDERAL_EXOTIC_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_EXOTIC)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_084() {

        // Eastern North American Flooded Forest & Swamp Division (D011)
        // D011

        String level = "division";
        String code = "D011";

        // Eastern North American wetland Temperate & Boreal Forest (all forests found
        // in EcoSection 411A, EcoDomain Humid Temperate (200 or M200) of the eastern
        // United States and Canada, and EcoDomain Polar (100 or M100) east of Alberta
        // and the Yukon [may not need worry about east-west boreal line since tree
        // species for Macrogroups are the same across the line.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_085() {

        // Eastern Cool Temperate & North American Boreal Wetland Forest
        // Eastern Cool Temperate & North American Boreal Wetland Forest

        String level = "informal";
        String code = "Eastern Cool Temperate & North American Boreal Wetland Forest";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_086() {

        // Eastern North American - Great Plains Flooded & Swamp Forest
        // Eastern North American - Great Plains Flooded & Swamp Forest Division

        String level = "informal";
        String code = "Eastern North American - Great Plains Flooded & Swamp Forest Division";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_087() {

        // Eastern Cool Temperate Natural Wetland Forests
        // Eastern Cool Temperate Natural Wetland Forests

        String level = "informal";
        String code = "Eastern Cool Temperate Natural Wetland Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_088() {

        // Laurentian-Acadian Flooded Forest & Swamp (M504)
        // Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)

        String level = "macrogroup";
        String code = "Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)";

        // Tree composition dominated by one of the following:
        //  i. Plots occurs in EcoProvinces or EcoSections 212, M211, 211A - 211E, 211Ja, 211Jb, 211Jc [intentionally
        //     exclude 211F, 211G, 211Jd], 222J, 222K, 222L, 222M, 222N, 222R, 222U
        //     AND
        //     Tree composition dominated by one or more STRONG LAURENTIAN-ACADIAN DIAGNOSTICS of Fraxinus nigra,
        //     Larix laricina, Picea mariana, Picea rubens, Populus balsamifera, Tsuga canadensis,
        //     Thuja occidentalis (>=50% RIV)
        // OR
        // ii. Plots occur in EcoProvinces or EcoSections 212, M211, 211, 222I, 221A, or 221D
        //     AND
        //     iia. Tree composition dominated by one or more of ECOREGIONALLY STRONG LAURENTIAN-ACADIAN DIAGNOSTICS
        //          Acer rubrum, Acer saccharinum, Fraxinus nigra, Fraxinus pennsylvanica,
        //          Larix laricina, Picea mariana, Picea rubens, Pinus rigida, Populus balsamifera, Salix amygdaloides,
        //          Tsuga canadensis, Thuja occidentalis, Ulmus americana, Ulmus rubra (>=50% RIV) AND in Province 212,
        //          M211, 211, 222I, 221A-221D.
        //      OR
        //     iib. Tree composition and ecoregions as above, but with >=20% RIV, AND other species are any combination
        //          of MODERATE DIAGNOSTICS Abies balsamea, Acer nigrum, Acer negundo, Acer saccharum, Betula alleghaniensis,
        //          Betula papyrifera, Carpinus caroliniana, Fraxinus americana, Nyssa sylvatica, Ostrya virginiana,
        //          Populus tremuloides, Prunus serotina, Quercus macrocarpa, Tilia americana (together >=50% RIV)

        List<KeyValue> ECOREGIONS_I_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc, 222J, 222K, 222L, 222M, 222N, 222R, 222U")
        );
        List<List<KeyValue>> ECOREGIONS_I_patterns = Arrays.asList(
            ECOREGIONS_I_pattern0
        );
        PatternList ECOREGIONS_I = new PatternList("ECOREGIONS_I", ECOREGIONS_I_patterns);

        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<List<KeyValue>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6
        );
        PatternList STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS = new PatternList("STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS", STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONS_II_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212, M211, 211, 222I, 221A, 221B")
        );
        List<List<KeyValue>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus rigida")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<List<KeyValue>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern7,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern8,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern9,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern10,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern11,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern12,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern13
        );
        PatternList ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS = new PatternList("ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS", ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
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
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern13
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_II = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_II", MODERATE_DIAGNOSTIC_SPECIES_II_patterns);

        INodeMatch match = plot -> (
            (    plot.match(ECOREGIONS_I)
               && plot.riv(STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) >= 50)
           || (     plot.match(ECOREGIONS_II)
               && (    plot.riv(ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) >= 50
                    || (plot.riv(ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) >= 20 && plot.riv(ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES_II) >= 50)))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_089() {

        // Central Hardwood Floodplain Forest (M029)
        // Central Hardwood Floodplain Forest (M029)

        String level = "macrogroup";
        String code = "Central Hardwood Floodplain Forest (M029)";

        //  i. Tree composition dominated by one or more of STRONG CENTRAL FLOODPLAIN DIAGNOSTICS
        //     Acer negundo, Acer saccharinum, Carya cordiformis, Carya laciniosa, Celtis laevigata,
        //     Celtis occidentalis, Betula nigra, Fraxinus pennsylvanica, Platanus occidentalis,
        //     Populus deltoides, Populus deltoides spp. monilifera, Salix bebbiana, Salix nigra,
        //     Salix caroliniana, Salix spp., Ulmus americana, Ulmus rubra (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any combination
        //     of MODERATE DIAGNOSTICS Acer rubrum, Acer negundo, Acer saccharum, Carpinus caroliniana,
        //     Carya cordiformis, Carya illinoinensis, Diospyros virginiana, Fraxinus nigra,
        //     Gleditsia triacanthos, Liriodendron tulipifera, Liquidambar styraciflua, Morus spp.,
        //     Morus rubra, Populus tremuloides,  Quercus bicolor, Quercus imbricaria, Quercus palustris,
        //     Quercus macrocarpa, Tilia americana (together >=50% RIV).

        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya laciniosa")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Betula nigra")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Populus deltoides spp. monilifera")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Salix bebbiana")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Salix caroliniana")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Salix")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<List<KeyValue>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern0,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern1,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern2,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern3,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern4,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern5,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern6,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern7,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern8,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern9,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern10,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern11,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern12,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern13,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern14,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern15,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern16
        );
        PatternList STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS = new PatternList("STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS", STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Morus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus bicolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus palustris")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
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

        INodeMatch match = plot -> (
                plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) >= 50
           || (    plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) >= 20
               && plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_090() {

        // Central Hardwood Swamp (M503)
        // Central Hardwood Swamp (M503)

        String level = "macrogroup";
        String code = "Central Hardwood Swamp (M503)";

        // i. Tree composition dominated by one or more of of STRONG CENTRAL SWAMP DIAGNOSTICS
        //     Fraxinus nigra, Larix laricina, Nyssa sylvatica, Quercus bicolor, Quercus palustris,
        //     Quercus phellos, Quercus shumardii, Salix amygdaloides, Thuja occidentalis,
        //     Tsuga canadensis or Picea rubens (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of
        //     MODERATE DIAGNOSTICS Acer rubrum, Acer saccharum, Acer saccharinum, Acer spicatum,
        //     Betula alleghaniensis, Carpinus caroliniana, Carya cordiformis, Fagus grandifolia,
        //     Fraxinus pennsylvanica, Liriodendron tulipifera, Liquidambar styraciflua, Morus spp.,
        //     Morus rubra, Ostrya virginiana, Quercus alba, Quercus macrocarpa, Populus balsamifera,
        //     Populus tremuloides, Salix bebbiana, Salix nigra, Tilia americana, Ulmus americana
        //     (together >=50% RIV).

        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus bicolor")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus palustris")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern0,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern1,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern2,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern3,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern4,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern5,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern6,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern7,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern8,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern9,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern10
        );
        PatternList STRONG_CENTRAL_SWAMP_DIAGNOSTICS = new PatternList("STRONG_CENTRAL_SWAMP_DIAGNOSTICS", STRONG_CENTRAL_SWAMP_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer spicatum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Morus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new KeyValue("species", "Salix bebbiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
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
            MODERATE_DIAGNOSTIC_SPECIES_pattern21
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS) >= 50
           || (    plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS) >= 20
               && plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_091() {

        // Laurentian-Acadian Flooded Forest & Swamp LC (M504)
        // Laurentian-Acadian Flooded Forest & Swamp LC (M504)

        String level = "macrogroup";
        String code = "Laurentian-Acadian Flooded Forest & Swamp LC (M504)";

        // ECOREGION is 212, M211, 211, 222I, 221A-221D

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212, M211, 211, 222I, 221A, 221B, 221C, 221D")
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

    public Object[] element_092() {

        // Central Hardwood Floodplain Forest LC (M029)
        // Central Hardwood Floodplain Forest LC (M029)

        String level = "macrogroup";
        String code = "Central Hardwood Floodplain Forest LC (M029)";

        //  i. % RIV STRONG CENTRAL FLOODPLAIN DIAGNOSTICS > STRONG CENTRAL SWAMP DIAGNOSTICS
        // OR
        // ii. Physiographic code = R (Riverine)

        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharinum")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya laciniosa")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Betula nigra")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Populus deltoides spp. monilifera")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Salix bebbiana")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Salix nigra")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Salix caroliniana")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Salix")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<List<KeyValue>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern0,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern1,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern2,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern3,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern4,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern5,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern6,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern7,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern8,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern9,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern10,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern11,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern12,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern13,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern14,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern15,
            STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern16
        );
        PatternList STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS = new PatternList("STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS", STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus bicolor")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus palustris")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Salix amygdaloides")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern0,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern1,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern2,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern3,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern4,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern5,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern6,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern7,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern8,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern9,
            STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern10
        );
        PatternList STRONG_CENTRAL_SWAMP_DIAGNOSTICS = new PatternList("STRONG_CENTRAL_SWAMP_DIAGNOSTICS", STRONG_CENTRAL_SWAMP_DIAGNOSTICS_patterns);

        List<KeyValue> RIVERINE_pattern0 = Arrays.asList(
            new KeyValue("riverine", "Y")
        );
        List<List<KeyValue>> RIVERINE_patterns = Arrays.asList(
            RIVERINE_pattern0
        );
        PatternList RIVERINE = new PatternList("RIVERINE", RIVERINE_patterns);

        INodeMatch match = plot -> (
               plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) > plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS)
           || plot.match(RIVERINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_093() {

        // Central Hardwood Swamp LC (M503)
        // Central Hardwood Swamp LC (M503)

        String level = "macrogroup";
        String code = "Central Hardwood Swamp LC (M503)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_094() {

        // Eastern Cool Temperate Ruderal Wetland Forests
        // Eastern Cool Temperate Ruderal Wetland Forests

        String level = "informal";
        String code = "Eastern Cool Temperate Ruderal Wetland Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_095() {

        // Eastern North American Ruderal Flooded Forest & Swamp (M302)
        // Eastern North American Ruderal Flooded Forest & Swamp (M302)

        String level = "macrogroup";
        String code = "Eastern North American Ruderal Flooded Forest & Swamp (M302)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_096() {

        // Upland Forest & Woodlands
        // Upland Forest & Woodlands

        String level = "informal";
        String code = "Upland Forest & Woodlands";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_097() {

        // Tropical Forest & Woodland Subclass
        // Tropical Forest

        String level = "biome";
        String code = "Tropical Forest";

        // Forests dominated by tropical hardwood, other palms and tropical conifer
        // tree species. Found in tropical regions of the United States - Puerto Rico,
        // U.S. Virgin Islands and Tropical Florida (EcoSection 411A) but excluding stands
        // containing alone or in combination Pinus elliottii, Pinus palustris, Quercus virginiana,
        // Quercus laurifolia, Taxodium ascendens > 20% RIV. [n.b. Some tropical forest types may
        // extend into EcoSubsections 232Da, 232Ga, 232Gb, but specific diagnostic species will 
        // need to be identified to key them out.]

        List<KeyValue> TROPICAL_LOCATION_pattern0 = Arrays.asList(
            new KeyValue("state", "PR")
        );
        List<KeyValue> TROPICAL_LOCATION_pattern1 = Arrays.asList(
            new KeyValue("state", "VI")
        );
        List<KeyValue> TROPICAL_LOCATION_pattern2 = Arrays.asList(
            new KeyValue("state", "FL")
        );
        List<KeyValue> TROPICAL_LOCATION_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "411A")
        );
        List<List<KeyValue>> TROPICAL_LOCATION_patterns = Arrays.asList(
            TROPICAL_LOCATION_pattern0,
            TROPICAL_LOCATION_pattern1,
            TROPICAL_LOCATION_pattern2,
            TROPICAL_LOCATION_pattern3
        );
        PatternList TROPICAL_LOCATION = new PatternList("TROPICAL_LOCATION", TROPICAL_LOCATION_patterns);

        List<KeyValue> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Taxodium ascendens")
        );
        List<List<KeyValue>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0,
            EXCLUDED_SPECIES_pattern1,
            EXCLUDED_SPECIES_pattern2,
            EXCLUDED_SPECIES_pattern3,
            EXCLUDED_SPECIES_pattern4
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_LOCATION) && plot.riv(EXCLUDED_SPECIES) < 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_098() {

        // Tropical Dry Forest
        // Tt1.b

        String level = "subbiome";
        String code = "Tt1.b";

        // Tropical hardwood and tropical conifer forests found in Puerto Rico, U.S. Virgin Islands,
        // and in tropical Florida (EcoSection 411A)

        List<KeyValue> TROPICAL_ATLANTIC_pattern0 = Arrays.asList(
            new KeyValue("state", "FL")
        );
        List<KeyValue> TROPICAL_ATLANTIC_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "411A")
        );
        List<KeyValue> TROPICAL_ATLANTIC_pattern2 = Arrays.asList(
            new KeyValue("state", "PR")
        );
        List<KeyValue> TROPICAL_ATLANTIC_pattern3 = Arrays.asList(
            new KeyValue("state", "VI")
        );
        List<List<KeyValue>> TROPICAL_ATLANTIC_patterns = Arrays.asList(
            TROPICAL_ATLANTIC_pattern0,
            TROPICAL_ATLANTIC_pattern1,
            TROPICAL_ATLANTIC_pattern2,
            TROPICAL_ATLANTIC_pattern3
        );
        PatternList TROPICAL_ATLANTIC = new PatternList("TROPICAL_ATLANTIC", TROPICAL_ATLANTIC_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_ATLANTIC)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_099() {

        // Tropical Florida Forest
        // Tropical Florida Forest

        String level = "informal";
        String code = "Tropical Florida Forest";

        // Stands found in Tropical Florida (Ecosection 411A) AND
        //   i. Tropical Tree composition dominated by one or more of Bursera simaruba, Coccoloba diversifolia,
        //      Guapira discolor, Metopium toxiferum, Sabal palmetto, or "other palms" (>=50% RIV); stands only found
        //      in EcoSection 411A;
        //  OR
        //  ii. The above tree species, but with >=20% RIV, AND other species are any combination of Coccothrinax
        //      argentata, Conocarpus erectus, Sideroxylon salicifolium, Thrinax morrisii (together >=50% RIV); stands
        //      only found in EcoSection 411A.
        //  OR
        // iii. Ruderal (weedy natives and exotic) tree species with >=80% RIV

        List<KeyValue> TROPICAL_FLORIDA_pattern0 = Arrays.asList(
            new KeyValue("state", "FL")
        );
        List<KeyValue> TROPICAL_FLORIDA_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "411A")
        );
        List<List<KeyValue>> TROPICAL_FLORIDA_patterns = Arrays.asList(
            TROPICAL_FLORIDA_pattern0,
            TROPICAL_FLORIDA_pattern1
        );
        PatternList TROPICAL_FLORIDA = new PatternList("TROPICAL_FLORIDA", TROPICAL_FLORIDA_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Bursera simaruba")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Coccoloba diversifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Guapira discolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Metopium toxiferum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "other palms")
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
            new KeyValue("species", "Coccothrinax argentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Conocarpus erectus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Sideroxylon salicifolium")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Thrinax morrisii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> RUDERAL_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<List<KeyValue>> RUDERAL_SPECIES_patterns = Arrays.asList(
            RUDERAL_SPECIES_pattern0
        );
        PatternList RUDERAL_SPECIES = new PatternList("RUDERAL_SPECIES", RUDERAL_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_FLORIDA)
           && (    plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
                || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
                ||  plot.riv(RUDERAL_SPECIES) >= 80)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_100() {

        // Tropical Florida Natural Forest
        // Tropical Florida Natural Forest

        String level = "informal";
        String code = "Tropical Florida Natural Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_101() {

        // Caribbean-Mesoamerican Dry Pine Forest (M296)
        // M296

        String level = "macrogroup";
        String code = "M296";

        // Caribbean-Mesoamerican Dry Pine Forest (M296)
        // 
        // 1. Tree composition dominated by one of the following:
        // 
        // i. Tree composition dominated by Pinus elliottii [= var. densa] (=>50% RIV);
        // 
        // OR
        // 
        // ii. Tree composition as above, but with =>20% RIV, AND other species are any combination of (in dry stands) Coccothrinax argentata, Leucothrinax morrisii, Sideroxylon salicifolium (together =>50% RIV);
        // 
        // ........................................................ Caribbean-Mesoamerican Dry Pine Forest (M296)

        List<KeyValue> Strong_Indicator_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii")
        );
        List<List<KeyValue>> Strong_Indicator_patterns = Arrays.asList(
            Strong_Indicator_pattern0
        );
        PatternList Strong_Indicator = new PatternList("Strong_Indicator", Strong_Indicator_patterns);

        List<KeyValue> Moderate_Indicator_pattern0 = Arrays.asList(
            new KeyValue("species", "Coccothrinax argentata")
        );
        List<KeyValue> Moderate_Indicator_pattern1 = Arrays.asList(
            new KeyValue("species", "Leucothrinax morrisii")
        );
        List<KeyValue> Moderate_Indicator_pattern2 = Arrays.asList(
            new KeyValue("species", "Sideroxylon salicifolium")
        );
        List<List<KeyValue>> Moderate_Indicator_patterns = Arrays.asList(
            Moderate_Indicator_pattern0,
            Moderate_Indicator_pattern1,
            Moderate_Indicator_pattern2
        );
        PatternList Moderate_Indicator = new PatternList("Moderate_Indicator", Moderate_Indicator_patterns);

        INodeMatch match = plot -> (
            riv (Strong_Indicat||)>=50
           || (riv(Strong_Indicat||) >= 20

               && riv(Strong_Indicat||) + riv(Moderate_Indicat||) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_102() {

        // Caribbean Swamp Forest via upland (M617)
        // Caribbean Swamp Forest via upland (M617)

        String level = "macrogroup";
        String code = "Caribbean Swamp Forest via upland (M617)";

        // Tree composition >= 50% Sabal palmetto RIV

        List<KeyValue> SABAL_PALMETTO_pattern0 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> SABAL_PALMETTO_patterns = Arrays.asList(
            SABAL_PALMETTO_pattern0
        );
        PatternList SABAL_PALMETTO = new PatternList("SABAL_PALMETTO", SABAL_PALMETTO_patterns);

        INodeMatch match = plot -> (
            plot.riv(SABAL_PALMETTO) >= 50
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_103() {

        // Caribbean Coastal Lowland Dry Forest (M134)
        // Caribbean Coastal Lowland Dry Forest (M134)

        String level = "macrogroup";
        String code = "Caribbean Coastal Lowland Dry Forest (M134)";

        // Tree composition dominated by one or more of Bursera simaruba, Coccoloba diversifolia,
        // Guapira discolor, Metopium toxiferum, Conocarpus erectus, "other palms",
        // Sabal palmetto (>=20% RIV)

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Bursera simaruba")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Coccoloba diversifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Guapira discolor")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Metopium toxiferum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Conocarpus erectus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "other palms")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
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

        INodeMatch match = plot -> (
            plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_104() {

        // Caribbean Coastal Lowland Dry Forest LC (M134)
        // Caribbean Coastal Lowland Dry Forest LC (M134)

        String level = "macrogroup";
        String code = "Caribbean Coastal Lowland Dry Forest LC (M134)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_105() {

        // Tropical Florida Ruderal Forest
        // Tropical Florida Ruderal Forest

        String level = "informal";
        String code = "Tropical Florida Ruderal Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_106() {

        // Caribbean Ruderal Dry Forest (M514)
        // Caribbean Ruderal Dry Forest (M514)

        String level = "macrogroup";
        String code = "Caribbean Ruderal Dry Forest (M514)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_107() {

        // Caribbean Forest
        // Caribbean Forest

        String level = "informal";
        String code = "Caribbean Forest";

        // Stands found in Caribbean islands.

        List<KeyValue> CARIBBEAN_pattern0 = Arrays.asList(
            new KeyValue("state", "PR")
        );
        List<KeyValue> CARIBBEAN_pattern1 = Arrays.asList(
            new KeyValue("state", "VI")
        );
        List<List<KeyValue>> CARIBBEAN_patterns = Arrays.asList(
            CARIBBEAN_pattern0,
            CARIBBEAN_pattern1
        );
        PatternList CARIBBEAN = new PatternList("CARIBBEAN", CARIBBEAN_patterns);

        INodeMatch match = plot -> (
            plot.match(CARIBBEAN)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_108() {

        // Caribbean Natural Forest
        // Caribbean Natural Forest

        String level = "informal";
        String code = "Caribbean Natural Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_109() {

        // Caribbean & Central American Dry Forests
        // Caribbean & Central American Dry Forests

        String level = "informal";
        String code = "Caribbean & Central American Dry Forests";

        // i. Tree composition dominated by Pinus elliottii (= var. densa) or Pinus caribaea, alone or in
        //     combination (>=50% RIV)
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of (in
        //     dry stands) Bursera simaruba, Coccoloba diversifolia, Coccothrinax argentata, Conocarpus erectus,
        //     Guapira discolor, Metopium toxiferum, "other palms", Sabal palmetto, Thrinax morrisii,
        //     Sideroxylon salicifolium (together >=50% RIV)

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus caribaea")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Bursera simaruba")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Coccoloba diversifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Coccothrinax argentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Conocarpus erectus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Guapira discolor")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Metopium toxiferum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "other palms")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Thrinax morrisii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Sideroxylon salicifolium")
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
            plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_110() {

        // Caribbean-Mesoamerican Pine Forest via Caribbean (M296)
        // Caribbean-Mesoamerican Pine Forest via Caribbean (M296)

        String level = "macrogroup";
        String code = "Caribbean-Mesoamerican Pine Forest via Caribbean (M296)";

        // i. Tree composition dominated by Pinus elliottii (var. densa) or Pinus caribaea,
        //     alone or in combination (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are
        //     any combination of (in dry stands) Coccothrinax argentata, Thrinax morrisii,
        //     Sideroxylon salicifolium (together >=50% RIV);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus caribaea")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Coccothrinax argentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Leucothrinax morrisii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Sideroxylon salicifolium")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_111() {

        // Caribbean-Mesoamerican Pine Forest LC (M296)
        // Caribbean-Mesoamerican Pine Forest LC (M296)

        String level = "macrogroup";
        String code = "Caribbean-Mesoamerican Pine Forest LC (M296)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_112() {

        // Caribbean Ruderal Forest
        // Caribbean Ruderal Forest

        String level = "informal";
        String code = "Caribbean Ruderal Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_113() {

        // Caribbean Ruderal Dry ForestA (M514A)
        // Caribbean Ruderal Dry ForestA (M514A)

        String level = "macrogroup";
        String code = "Caribbean Ruderal Dry ForestA (M514A)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_114() {

        // Temperate & Boreal Forests
        // Temperate & Boreal Forests

        String level = "informal";
        String code = "Temperate & Boreal Forests";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_115() {

        // Temperate-Boreal Forest & Woodland (TT2)
        // TT2

        String level = "biome";
        String code = "TT2";

        // Woodland Subbiome (TT2.a), Cool Temperate Forest & Woodland Subbiome (TT2.b)) [note, Boreal Forest & Woodland Subbiome (TT2.c)  may occur in northern Minnesota or Michigan, but they are not reliably separated from subboreal counterparts, so this subbiome is not currently applied. Upland Subboreal equivalents, such as those dominated by Picea glauca or Picea mariana, are tracked in the Temperate Forest & Woodland subbiome under M159 (G999) and M102 (G048)]  D

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_116() {

        // Southeastern North American Forest & Woodland Division (D006)
        // D006

        String level = "division";
        String code = "D006";

        // Tree composition matching one of the following options: 
        // 
        // i. Located in Ecoprovince 231A, 231B, 231E, 231F, 231H, 231I, 232, 234, 411A 
        // 
        // AND 
        // 
        // ii. Tree composition contains one or more of Aesculus pavia, Halesia diptera, Juniperus virginiana var. silicicola, Magnolia grandiflora, Pinus clausa, Pinus glabra, Pinus palustris, Pinus elliottii, Quercus incana, Quercus laevis, Quercus laurifolia, Quercus margarettiae, Quercus minima, Quercus sinuata var sinuata, Quercus virginiana, Sabal palmetto (>=5% RIV); [Additional tree species not tracked by FIA include Quercus fusiformis = Quercus virginiana var. fusiformis), Quercus geminata, Serenoa repens] 
        // 
        // OR 
        // 
        // Located in Ecosections 231A, 231B, 231E, 231F, 231H, 231I, 232B, 232C, 232E, 232F, 232J, 232K, 232L, 234, (but exclude DC, DE, MD, NJ, PA, VA  
        // 
        // .... Warm Temperate Evergreen Forest & Woodland Ecobiome (TT2.a1)… [eastern Warm Temperate Upland Forests] ......................................................................................................E 
        // 
        // E. Southeastern North American Forest & Woodland Division (D006) one  E1

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231A, 231B, 231E, 231F, 231H, 231I, 232, 234, 411A")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Halesia diptera")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new KeyValue("species", "Magnolia grandiflora")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus incana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus laevis")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus margaretta")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus minima")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus sinuata var. sinuata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_1_pattern15 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
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
            DIAGNOSTIC_SPECIES_1_pattern15
        );
        PatternList DIAGNOSTIC_SPECIES_1 = new PatternList("DIAGNOSTIC_SPECIES_1", DIAGNOSTIC_SPECIES_1_patterns);

        List<KeyValue> ECOREGIONS_2_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231A, 231B, 231E, 231F, 231H, 231I, 232B, 232C, 232E, 232F, 232J, 232K, 232L, 234")
        );
        List<List<KeyValue>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<KeyValue> STATES_pattern0 = Arrays.asList(
            new KeyValue("state", "!DC")
        );
        List<KeyValue> STATES_pattern1 = Arrays.asList(
            new KeyValue("state", "DE")
        );
        List<KeyValue> STATES_pattern2 = Arrays.asList(
            new KeyValue("state", "MD")
        );
        List<KeyValue> STATES_pattern3 = Arrays.asList(
            new KeyValue("state", "NJ")
        );
        List<KeyValue> STATES_pattern4 = Arrays.asList(
            new KeyValue("state", "PA")
        );
        List<KeyValue> STATES_pattern5 = Arrays.asList(
            new KeyValue("state", "VA")
        );
        List<List<KeyValue>> STATES_patterns = Arrays.asList(
            STATES_pattern0,
            STATES_pattern1,
            STATES_pattern2,
            STATES_pattern3,
            STATES_pattern4,
            STATES_pattern5
        );
        PatternList STATES = new PatternList("STATES", STATES_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && plot.riv(DIAGNOSTIC_SPECIES_1) >= 5) || (plot.match(ECOREGIONS_2) && plot.match(STATES))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_117() {

        // Southeastern Warm Temperate Natural Forests
        // Southeastern Warm Temperate Natural Forests

        String level = "informal";
        String code = "Southeastern Warm Temperate Natural Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_118() {

        // South-Central Oak - Pine Forest & Woodland (M540)
        // M540

        String level = "macrogroup";
        String code = "M540";

        // i. Plot is in 232F, 231E, 234D or 255D and tree composition dominated by Carya glabra, Carya ovalis, Carya pallida, Ilex opaca, Pinus taeda, Pinus echinata,
        //     Quercus arkansana, Quercus falcata, Quercus incana, Quercus margarettiae, or Quercus stellata >= 20%
        // OR
        // ii. a. Plot is in 231, 232, 234D, 255D and tree composition dominated by Carya glabra, Carya ovalis, Carya pallida, Ilex opaca, Pinus echinata, Pinus taeda, Quercus stellata,
        //        Quercus marilandica or Quercus coccinea >= 50% RIV
        //     OR
        //     b. Plot is in 231, 232, 234D, 255D and tree composition as above, but with >=20% RIV; AND in combination with other species of Oxydendrum arboreum,
        //        Quercus alba, Quercus falcata, Quercus nigra, Quercus montana, Quercus muehlenbergii (together >= 50% RIV)

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "232F, 231E, 234D, 255D")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus arkansana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus incana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus margaretta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern9 = Arrays.asList(
            new KeyValue("species", "Carya ovalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_1_pattern10 = Arrays.asList(
            new KeyValue("species", "Carya pallida")
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

        List<KeyValue> ECOREGIONS_2_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "231, 232, 234D, 255D")
        );
        List<List<KeyValue>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern7 = Arrays.asList(
            new KeyValue("species", "Carya ovalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_2_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya pallida")
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
            STRONG_DIAGNOSTIC_SPECIES_2_pattern8
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_2 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_2", STRONG_DIAGNOSTIC_SPECIES_2_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_2_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern4,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern5
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_2 = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_2", MODERATE_DIAGNOSTIC_SPECIES_2_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20)
            ||
           (plot.match(ECOREGIONS_2)
              && (    plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 50
                   || (plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES_2) >= 50)))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_119() {

        // Southern Mesic Mixed Broadleaf Forest (M008)
        // M008

        String level = "macrogroup";
        String code = "M008";

        // i. Tree composition dominated by one or more of Acer barbatum, Aesculus pavia, Fagus grandifolia,
        //     Halesia diptera, Ilex opaca, Magnolia acuminata, Magnolia grandiflora, Magnolia virginiana,
        //     Pinus glabra, Quercus michauxii, Quercus pagoda, Quercus phellos, Quercus shumardii,
        //     Sabal palmetto, Tilia spp., Tilia americana, Tilia americana var. heterophylla,
        //     Tilia americana var. caroliniana (>=50% RIV)
        // OR
        // ii. Tree composition as above, but with >=20% RIV; AND other species [in the context of
        //     EcoProvince 232] are any combination of Acer rubrum, Aesculus pavia, Carpinus caroliniana,
        //     Carya alba, Celtis spp., Celtis laevigata, Cornus florida, Diospyros virginiana,
        //     Fraxinus americana, Halesia spp., Halesia carolina (=H. tetraptera), Liquidambar styraciflua,
        //     Liriodendron tulipifera, Magnolia macrophylla, Nyssa sylvatica, Ostrya virginiana,
        //     Oxydendrum arboreum, Quercus alba, Quercus falcata, Quercus muehlenbergii, Quercus rubra,
        //     Quercus virginiana, Quercus nigra, Juniperus spp., Pinus taeda (together >=50% RIV)

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Halesia diptera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Magnolia grandiflora")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Tilia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11,
            STRONG_MESIC_DIAGNOSTICS_pattern12,
            STRONG_MESIC_DIAGNOSTICS_pattern13,
            STRONG_MESIC_DIAGNOSTICS_pattern14,
            STRONG_MESIC_DIAGNOSTICS_pattern15,
            STRONG_MESIC_DIAGNOSTICS_pattern16,
            STRONG_MESIC_DIAGNOSTICS_pattern17
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Celtis")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Cornus florida")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Halesia")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Halesia carolina")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Magnolia macrophylla")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Juniperus")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> MODERATE_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_MESIC_DIAGNOSTICS_pattern0,
            MODERATE_MESIC_DIAGNOSTICS_pattern1,
            MODERATE_MESIC_DIAGNOSTICS_pattern2,
            MODERATE_MESIC_DIAGNOSTICS_pattern3,
            MODERATE_MESIC_DIAGNOSTICS_pattern4,
            MODERATE_MESIC_DIAGNOSTICS_pattern5,
            MODERATE_MESIC_DIAGNOSTICS_pattern6,
            MODERATE_MESIC_DIAGNOSTICS_pattern7,
            MODERATE_MESIC_DIAGNOSTICS_pattern8,
            MODERATE_MESIC_DIAGNOSTICS_pattern9,
            MODERATE_MESIC_DIAGNOSTICS_pattern10,
            MODERATE_MESIC_DIAGNOSTICS_pattern11,
            MODERATE_MESIC_DIAGNOSTICS_pattern12,
            MODERATE_MESIC_DIAGNOSTICS_pattern13,
            MODERATE_MESIC_DIAGNOSTICS_pattern14,
            MODERATE_MESIC_DIAGNOSTICS_pattern15,
            MODERATE_MESIC_DIAGNOSTICS_pattern16,
            MODERATE_MESIC_DIAGNOSTICS_pattern17,
            MODERATE_MESIC_DIAGNOSTICS_pattern18,
            MODERATE_MESIC_DIAGNOSTICS_pattern19,
            MODERATE_MESIC_DIAGNOSTICS_pattern20,
            MODERATE_MESIC_DIAGNOSTICS_pattern21,
            MODERATE_MESIC_DIAGNOSTICS_pattern22,
            MODERATE_MESIC_DIAGNOSTICS_pattern23,
            MODERATE_MESIC_DIAGNOSTICS_pattern24
        );
        PatternList MODERATE_MESIC_DIAGNOSTICS = new PatternList("MODERATE_MESIC_DIAGNOSTICS", MODERATE_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 50
           || (plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20 && plot.riv(STRONG_MESIC_DIAGNOSTICS) + plot.riv(MODERATE_MESIC_DIAGNOSTICS) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_120() {

        // Longleaf Pine Woodland (M007)
        // M007

        String level = "macrogroup";
        String code = "M007";

        // i. Tree composition dominated by Pinus palustris >=20% RIV,
        // OR
        //  ii. Tree composition dominated by Pinus elliottii, Pinus palustris >=5% AND Pinus echinata,
        //      Pinus elliottii, Pinus palustris, and Pinus taeda together >=50% RIV.
        // OR
        // iii. Tree composition dominated by one or more of Pinus clausa, Pinus elliottii or Pinus palustris (>=50% RIV);
        // OR
        //  iv. Tree composition as above, but with >=20% RIV, AND other species are any combination of coastal plain species of
        //      Acer rubrum, Diospyros virginiana, Liquidambar styraciflua, Pinus clausa, Pinus echinata, Pinus taeda,
        //      Persea borbonia, Quercus falcata, Quercus incana, Quercus laevis, Quercus laurifolia, Quercus margarettiae,
        //      Quercus marilandica, Quercus nigra, Quercus virginiana or Sabal palmetto (together >=50% RIV).

        List<KeyValue> DIAGNOSTIC_SPECIES_I_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_I_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_I_pattern0
        );
        PatternList DIAGNOSTIC_SPECIES_I = new PatternList("DIAGNOSTIC_SPECIES_I", DIAGNOSTIC_SPECIES_I_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_II_pattern0,
            DIAGNOSTIC_SPECIES_II_pattern1,
            DIAGNOSTIC_SPECIES_II_pattern2,
            DIAGNOSTIC_SPECIES_II_pattern3
        );
        PatternList DIAGNOSTIC_SPECIES_II = new PatternList("DIAGNOSTIC_SPECIES_II", DIAGNOSTIC_SPECIES_II_patterns);

        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus incana")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus laevis")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus margaretta")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> MODERATE_LONGLEAF_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> MODERATE_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern0,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern1,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern2,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern3,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern4,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern5,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern6,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern7,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern8,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern9,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern10,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern11,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern12,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern13,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern14,
            MODERATE_LONGLEAF_DIAGNOSTICS_pattern15
        );
        PatternList MODERATE_LONGLEAF_DIAGNOSTICS = new PatternList("MODERATE_LONGLEAF_DIAGNOSTICS", MODERATE_LONGLEAF_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(DIAGNOSTIC_SPECIES_I) >= 20
           || (plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) >= 5 && plot.riv(DIAGNOSTIC_SPECIES_II) >= 50)
           ||  plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) >= 50
           || (plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) >= 20 && plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) + plot.riv(MODERATE_LONGLEAF_DIAGNOSTICS) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_121() {

        // Southeastern Coastal Plain Evergreen Oak Forest (M885)
        // M885

        String level = "macrogroup";
        String code = "M885";

        // Plot is in 232B, C, D, E, G [not in 232A, F, H, I, J], 255Da, Db, Dc [not 255Dd] or 411A, AND
        //  i. Tree composition is dominated by one or more of Juniperus virginiana var. silicicola,
        //     Pinus glabra, Quercus incana, Quercus laevis, Quercus laurifolia (presumably = Quercus hemisphaerica, if upland),
        //     Quercus margarettiae, Quercus minima, Quercus margarettiae, Quercus virginiana, Sabal palmetto (>=50% RIV);
        //     [Additional tree species not tracked by FIA include Quercus fusiformis = Quercus virginiana var. fusiformis),
        //     Quercus geminata, Serenoa repens,]
        // OR
        // ii. Tree composition as above, but with >=20% RIV; AND other species are any combination of Acer rubrum,
        //     Carpinus caroliniana, Carya alba, Carya illinoinensis, Celtis laevigata, Celtis spp., Fraxinus americana, Ilex opaca,
        //     Juniperus spp., Juniperus virginiana, Liquidambar styraciflua, Magnolia grandiflora, Nyssa sylvatica,
        //     Ostrya virginiana, Oxydendrum arboreum, other palms, Persea borbonia, Prunus serotina, Quercus alba,
        //     Quercus falcata, , Quercus nigra, Quercus pagoda, Quercus stellata, Pinus echinata, Pinus taeda,
        //     Ulmus alata (together >=50% RIV).

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "232B, 232C, 232D, 232E, 232G, 255Da, 255Db, 255Dc, 411A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus incana")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus laevis")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus margaretta")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus minima")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8
        );
        PatternList STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS = new PatternList("STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS", STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Celtis laevigata var. reticulata")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Celtis")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Magnolia grandiflora")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "other palms")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Persea borbonia")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern26 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<KeyValue> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern27 = Arrays.asList(
            new KeyValue("species", "Carya illinoinensis")
        );
        List<List<KeyValue>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern9,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern10,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern11,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern12,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern13,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern14,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern15,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern16,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern17,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern18,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern19,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern20,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern21,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern22,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern23,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern24,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern25,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern26,
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern27
        );
        PatternList MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS = new PatternList("MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS", MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) &&
             (    plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) >= 50
              || (    plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) >= 20
                  && plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) + plot.riv(MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS) >= 50))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_122() {

        // Southeastern Coastal Plain Evergreen Oak Forest LC (M885)
        // Southeastern Coastal Plain Evergreen Oak Forest LC (M885)

        String level = "macrogroup";
        String code = "Southeastern Coastal Plain Evergreen Oak Forest LC (M885)";

        // Plot is in 232B-E, 232G, 255Da-Dc or 411A, AND
        // % RIV of STRONG OAK-MIXED HARDWOOD DIAGNOSTICS > either STRONG LONGLEAF DIAGNOSTICS or STRONG MESIC DIAGNOSTICS

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "232B, 232C, 232D, 232E, 232G, 255Da, 255Db, 255Dc, 411A")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus incana")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus laevis")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus margaretta")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus minima")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus virginiana")
        );
        List<KeyValue> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<List<KeyValue>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7,
            STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8
        );
        PatternList STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS = new PatternList("STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS", STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Halesia diptera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Magnolia grandiflora")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Tilia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11,
            STRONG_MESIC_DIAGNOSTICS_pattern12,
            STRONG_MESIC_DIAGNOSTICS_pattern13,
            STRONG_MESIC_DIAGNOSTICS_pattern14,
            STRONG_MESIC_DIAGNOSTICS_pattern15,
            STRONG_MESIC_DIAGNOSTICS_pattern16,
            STRONG_MESIC_DIAGNOSTICS_pattern17
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) &&
             (   plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) > plot.riv(STRONG_LONGLEAF_DIAGNOSTICS)
              || plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_123() {

        // Longleaf Pine Woodland LC1 (M007)
        // Longleaf Pine Woodland LC1 (M007)

        String level = "macrogroup";
        String code = "Longleaf Pine Woodland LC1 (M007)";

        // STRONG LONGLEAF DIAGNOSTICS %RIV > STRONG MESIC DIAGNOSTICS %RIV

        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus elliottii var. elliottii")
        );
        List<KeyValue> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus palustris")
        );
        List<List<KeyValue>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Aesculus pavia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Halesia diptera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Magnolia grandiflora")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Magnolia virginiana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus glabra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus michauxii")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Sabal palmetto")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Tilia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11,
            STRONG_MESIC_DIAGNOSTICS_pattern12,
            STRONG_MESIC_DIAGNOSTICS_pattern13,
            STRONG_MESIC_DIAGNOSTICS_pattern14,
            STRONG_MESIC_DIAGNOSTICS_pattern15,
            STRONG_MESIC_DIAGNOSTICS_pattern16,
            STRONG_MESIC_DIAGNOSTICS_pattern17
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_124() {

        // Florida Xeric Scrub & Prairie (M162)
        // M162

        String level = "macrogroup";
        String code = "M162";

        // Tree composition dominated by Pinus clausa =>20% RIV   Florida Xeric Scrub & Prairie (M162) [The USNVC now treats Pinus clausa stands as part of a non-forested ecosystem, as they are closely linked to Florida Scrub as a successional stage in a fire-dominated successional sequence; and they are not part of the Longleaf Pine Woodland macrogroup]

        List<KeyValue> DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus clausa")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_pattern0
        );
        PatternList DIAGNOSTIC_SPECIES = new PatternList("DIAGNOSTIC_SPECIES", DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(DIAGNOSTIC_SPECIES) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_125() {

        // Southern Mesic Mixed Broadleaf Forest LC (M008)
        // Southern Mesic Mixed Broadleaf Forest LC (M008)

        String level = "macrogroup";
        String code = "Southern Mesic Mixed Broadleaf Forest LC (M008)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_126() {

        // Southeastern Warm Temperate Ruderal Forests
        // Southeastern Warm Temperate Ruderal Forests

        String level = "informal";
        String code = "Southeastern Warm Temperate Ruderal Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_127() {

        // Southeastern North American Ruderal Forest (M305)
        // M305

        String level = "macrogroup";
        String code = "M305";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_128() {

        // Temperate Deciduous-Mixed Forest & Woodland Ecobiome (TT2.b1)
        // TT2.b1

        String level = "ecobiome";
        String code = "TT2.b1";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_129() {

        // North American Great Plains Forest & Woodland (D332)
        // D332

        String level = "division";
        String code = "D332";

        // Located in Ecoprovince 331, 332, 315B, 315C, 315D, 315E, 315F, 315G, 255….North American Great Plains Forest & Woodland Division D332)……………………………….……F1

        List<KeyValue> Great_Plains_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331")
        );
        List<KeyValue> Great_Plains_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "332")
        );
        List<KeyValue> Great_Plains_pattern2 = Arrays.asList(
            new KeyValue("ecoregion", "315B")
        );
        List<KeyValue> Great_Plains_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "315C")
        );
        List<KeyValue> Great_Plains_pattern4 = Arrays.asList(
            new KeyValue("ecoregion", "315D")
        );
        List<KeyValue> Great_Plains_pattern5 = Arrays.asList(
            new KeyValue("ecoregion", "315E")
        );
        List<KeyValue> Great_Plains_pattern6 = Arrays.asList(
            new KeyValue("ecoregion", "315F")
        );
        List<KeyValue> Great_Plains_pattern7 = Arrays.asList(
            new KeyValue("ecoregion", "315G")
        );
        List<KeyValue> Great_Plains_pattern8 = Arrays.asList(
            new KeyValue("ecoregion", "255")
        );
        List<List<KeyValue>> Great_Plains_patterns = Arrays.asList(
            Great_Plains_pattern0,
            Great_Plains_pattern1,
            Great_Plains_pattern2,
            Great_Plains_pattern3,
            Great_Plains_pattern4,
            Great_Plains_pattern5,
            Great_Plains_pattern6,
            Great_Plains_pattern7,
            Great_Plains_pattern8
        );
        PatternList Great_Plains = new PatternList("Great_Plains", Great_Plains_patterns);

        INodeMatch match = plot -> (
            plot.match(Great_Plains)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_130() {

        // Great Plains Natural Woodlands
        // Great Plains Natural Woodlands

        String level = "informal";
        String code = "Great Plains Natural Woodlands";

        // 0. Vegetation in a relatively natural state, dominated by native species; little or no evidence of trees in a row, no very recent logging, understory mowing, etc. (trees may be early successional pole-sized trees following logging or blowdowns). Tree composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix B - needs to be refined for this Division).................Great Plains Natural Woodlands

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        List<KeyValue> NATIVE_RUDERAL_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<List<KeyValue>> NATIVE_RUDERAL_patterns = Arrays.asList(
            NATIVE_RUDERAL_pattern0
        );
        PatternList NATIVE_RUDERAL = new PatternList("NATIVE_RUDERAL", NATIVE_RUDERAL_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80 ||
           plot.riv(NATIVE_RUDERAL) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_131() {

        // Northern Great Plains Forest & Woodland (M545)
        // M545

        String level = "macrogroup";
        String code = "M545";

        // Tree composition dominated by one of the following:
        // Located in Ecoprovince 331, 332, AND Tilia americana and Acer saccharum, singly or in combination < 5% RIV,  [i.e. RIV(Tilia americana) < 5 or RIV(Acer saccharum) < 5, or RIV(Tilia americana) + RIV(Acer saccharum) < 5] AND
        // i. Tree composition dominated by one or more of STRONG PLAINS DIAGNOSTICS Fraxinus pennsylvanica, Juniperus virginiana, Populus tremuloides, Quercus macrocarpa, Ulmus americana, Ulmus rubra (=>50% RIV);
        // OR
        // ii. Tree composition as above, but with=>20% RIV AND other species are any combination of MODERATE PLAINS DIAGNOSTICS Acer negundo, Betula papyrifera, Celtis occidentalis, Crataegus spp., Juglans nigra, Juniperus scopulorum, Morus rubra, Pinus ponderosa, Prunus virginiana, Quercus rubra, Quercus muehlenbergii, Ulmus rubra (together =>50% RIV) ...................................................................................................... .................................................................... Northern Great Plains Forest & Woodland (M545)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "331")
        );
        List<KeyValue> ECOREGIONS_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "332")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0,
            ECOREGIONS_pattern1
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<List<KeyValue>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        List<KeyValue> STRONG_PLAINS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_PLAINS_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> STRONG_PLAINS_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_PLAINS_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_PLAINS_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<KeyValue> STRONG_PLAINS_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<List<KeyValue>> STRONG_PLAINS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_PLAINS_DIAGNOSTICS_pattern0,
            STRONG_PLAINS_DIAGNOSTICS_pattern1,
            STRONG_PLAINS_DIAGNOSTICS_pattern2,
            STRONG_PLAINS_DIAGNOSTICS_pattern3,
            STRONG_PLAINS_DIAGNOSTICS_pattern4,
            STRONG_PLAINS_DIAGNOSTICS_pattern5
        );
        PatternList STRONG_PLAINS_DIAGNOSTICS = new PatternList("STRONG_PLAINS_DIAGNOSTICS", STRONG_PLAINS_DIAGNOSTICS_patterns);

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
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
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
            plot.match(ECOREGIONS)
           && plot.riv(EXCLUDED_SPECIES) < 5
           && (    plot.riv(STRONG_PLAINS_DIAGNOSTICS) >= 50
                || (plot.riv(STRONG_PLAINS_DIAGNOSTICS) >= 20 && (plot.riv(STRONG_PLAINS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_132() {

        // Southern Great Plains Forest & Woodland (M544)
        // M544

        String level = "macrogroup";
        String code = "M544";

        // Located in Ecoprovince 315, [315B – G] and 255.  [Typical species include Acer grandidentatum, Fraxinus albicans, Juniperus ashei, Pinus cembroides, Juglans major, Juniperus virginiana, Quercus buckleyi, Quercus fusiformis, Quercus laceyi, Quercus marilandica, Quercus muehlenbergii, Quercus sinuata var. breviloba, Quercus stellata, Sapindus Saponaria, Ulmus alata, Ulmus crassifolia, Ulmus rubra]

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "255")
        );
        List<KeyValue> ECOREGIONS_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "315B")
        );
        List<KeyValue> ECOREGIONS_pattern2 = Arrays.asList(
            new KeyValue("ecoregion", "315C")
        );
        List<KeyValue> ECOREGIONS_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "315D")
        );
        List<KeyValue> ECOREGIONS_pattern4 = Arrays.asList(
            new KeyValue("ecoregion", "315E")
        );
        List<KeyValue> ECOREGIONS_pattern5 = Arrays.asList(
            new KeyValue("ecoregion", "315F")
        );
        List<KeyValue> ECOREGIONS_pattern6 = Arrays.asList(
            new KeyValue("ecoregion", "315G")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0,
            ECOREGIONS_pattern1,
            ECOREGIONS_pattern2,
            ECOREGIONS_pattern3,
            ECOREGIONS_pattern4,
            ECOREGIONS_pattern5,
            ECOREGIONS_pattern6
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_133() {

        // Great Plains Ruderal Woodland
        // Great Plains Ruderal Woodland

        String level = "informal";
        String code = "Great Plains Ruderal Woodland";

        // Vegetation dominated by ruderal vegetation (nonnative invasive or weedy native vegetation that invades natural stands or vegetation that dominates on formerly cleared and/or planted sites but which has been allowed to succeed more-or-less spontaneously). Tree composition dominated by ruderal native or exotic species (>= 80% RIV) (see Appendix B – needs to be refined for this Division.………………………………………………………………………………………. Great Plains Ruderal Woodlands

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        List<KeyValue> NATIVE_RUDERAL_pattern0 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<List<KeyValue>> NATIVE_RUDERAL_patterns = Arrays.asList(
            NATIVE_RUDERAL_pattern0
        );
        PatternList NATIVE_RUDERAL = new PatternList("NATIVE_RUDERAL", NATIVE_RUDERAL_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) >80 ||
           plot.riv(NATIVE_RUDERAL) > 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_134() {

        // Great Plains Ruderal Woodland (M524)
        // M524

        String level = "macrogroup";
        String code = "M524";

        // Only 1 macrogroup, Great Plains Ruderal Woodland (M524)

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_135() {

        // Eastern North American Forest & Woodland (D008)
        // D008a

        String level = "division";
        String code = "D008a";

        // Tree composition not as above.  Eastern North American Forest & Woodland Division (D008)……………………………………………………………………………………………………………………..F2

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_136() {

        // Eastern North American Natural Forest & Woodlands
        // Eastern Cool Temperate Natural Forest & Woodlands

        String level = "informal";
        String code = "Eastern Cool Temperate Natural Forest & Woodlands";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_137() {

        // Northern Forest Macrogroups (Laurentian and Acadian-Appalachian)
        // Northern Forest Macrogroups (Laurentian and Acadian-Appalachian)

        String level = "informal";
        String code = "Northern Forest Macrogroups (Laurentian and Acadian-Appalachian)";

        // i. Tree composition dominated by one or more of Abies balsamea, Abies fraseri, Picea rubens (>=20% RIV)
        // OR
        //  ii. Plots occurs in EcoProvinces 212, M211, 211A - 211E, 211Ja, 211Jb, 211Jc [intentionally exclude 211F,
        //      211G, 211Jd], 222J, 222K, 222L, 222M, 222R, 222U AND
        //         a. Tree composition dominated by one or more of Acer pensylvanicum, Acer spicatum, Amelanchier spp.,
        //            Betula alleghaniensis, Betula papyrifera, Betula populifolia, Fraxinus nigra, Picea glauca, Picea mariana,
        //            Pinus banksiana, Pinus resinosa, Populus balsamifera, Prunus pensylvanica, Sorbus americana, Thuja occidentalis,
        //            Tsuga canadensis (>=50% RIV)
        //        OR
        //         b. Tree composition as above, but with >=20% RIV, AND other species, are any combination of Acer rubrum,
        //            Acer saccharum, Abies balsamea, Abies fraseri, Betula lenta, Carpinus caroliniana, Fagus grandifolia,
        //            Fraxinus americana, Fraxinus pennsylvanica, Larix laricina, Ostrya virginiana, Picea rubens,
        //            Pinus strobus, Populus grandidentata, Populus tremuloides, Prunus serotina, Prunus virginiana,
        //            Quercus ellipsoidalis, Quercus macrocarpa, Quercus rubra, Tilia americana, or Ulmus americana (together >=50% RIV)
        // OR
        // iii. Plots occur in EcoProvinces 212, M211, 211A - 211E, 211Ja, 211Jb, 211Jc [intentionally exclude 211F, 211G, 211Jd] AND
        //      Tree composition dominated by one or more of Acer rubrum, Acer saccharum, Betula alleghaniensis, Betula lenta,
        //      Carpinus caroliniana, Fagus grandifolia, Fraxinus americana, Fraxinus pennsylvanica, Larix laricina,
        //      Ostrya virginiana, Pinus strobus, Populus grandidentata, Populus tremuloides, Prunus serotina,
        //      Quercus ellipsoidalis, Quercus macrocarpa, Quercus rubra, Tilia americana, or Ulmus americana (>= 50% RIV)

        List<KeyValue> DIAGNOSTIC_SPECIES_I_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_I_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies fraseri")
        );
        List<KeyValue> DIAGNOSTIC_SPECIES_I_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_I_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_I_pattern0,
            DIAGNOSTIC_SPECIES_I_pattern1,
            DIAGNOSTIC_SPECIES_I_pattern2
        );
        PatternList DIAGNOSTIC_SPECIES_I = new PatternList("DIAGNOSTIC_SPECIES_I", DIAGNOSTIC_SPECIES_I_patterns);

        List<KeyValue> ECOREGIONS_II_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc, 222J, 222K, 222L, 222M, 222R, 222U")
        );
        List<List<KeyValue>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer spicatum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new KeyValue("species", "Betula populifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new KeyValue("species", "Sorbus americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern14 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_II_pattern15 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
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
            STRONG_DIAGNOSTIC_SPECIES_II_pattern15
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_II = new PatternList("STRONG_DIAGNOSTIC_SPECIES_II", STRONG_DIAGNOSTIC_SPECIES_II_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new KeyValue("species", "Abies fraseri")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern14 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern15 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern16 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern20 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_II_pattern21 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
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
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern12,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern13,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern14,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern15,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern16,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern17,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern18,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern19,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern20,
            MODERATE_DIAGNOSTIC_SPECIES_II_pattern21
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES_II = new PatternList("MODERATE_DIAGNOSTIC_SPECIES_II", MODERATE_DIAGNOSTIC_SPECIES_II_patterns);

        List<KeyValue> ECOREGIONS_III_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc")
        );
        List<List<KeyValue>> ECOREGIONS_III_patterns = Arrays.asList(
            ECOREGIONS_III_pattern0
        );
        PatternList ECOREGIONS_III = new PatternList("ECOREGIONS_III", ECOREGIONS_III_patterns);

        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer rubrum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern4 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern5 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern6 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern8 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern9 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern11 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern12 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern13 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern17 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_DIAGNOSTIC_SPECIES_III_pattern18 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTIC_SPECIES_III_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_III_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern5,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern6,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern7,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern8,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern9,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern10,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern11,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern12,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern13,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern14,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern15,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern16,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern17,
            STRONG_DIAGNOSTIC_SPECIES_III_pattern18
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_III = new PatternList("STRONG_DIAGNOSTIC_SPECIES_III", STRONG_DIAGNOSTIC_SPECIES_III_patterns);

        INodeMatch match = plot -> (
            plot.riv(DIAGNOSTIC_SPECIES_I) >= 20
           || (     plot.match(ECOREGIONS_II)
               && (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 50 || (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES_II) >= 50)))
           || (     plot.match(ECOREGIONS_III)
               &&  plot.riv(STRONG_DIAGNOSTIC_SPECIES_III) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_138() {

        // Laurentian Forests
        // Laurentian Forests

        String level = "informal";
        String code = "Laurentian Forests";

        // 2. Tree composition dominated by one of the following:
        // i Located in Ecoprovince 212 [i.e. all stands in Laurentian 212 ecoregion go here, regardless of tree composition]
        // OR
        // ii. Located in 222J, 222K, 222L, 222M, 222R, or 222U, AND 
        //      iia Tree composition dominated by one or more of STRONG DRY DIAGNOSTI2. Tree composition dominated by one of the following:
        // i Located in Ecoprovince 212 [i.e. all stands in Laurentian 212 ecoregion go here, regardless of tree composition]
        // OR
        // ii. Located in 222J, 222K, 222L, 222M, 222R, or 222U, AND 
        //      iia Tree composition dominated by one or more of STRONG DRY DIAGNOSTICS Picea mariana, Pinus banksiana, Pinus resinosa, Pinus strobus (=>50% RIV);
        // OR
        //     iib. Tree composition as above, but with =>20% RIV, AND other species are any combination of MODERATE DRY DIAGNOSTICS of Amelanchier spp.,, Betula papyrifera, Carpinus caroliniana, Ostrya virginiana, Populus grandidentata, Populus tremuloides, Prunus pensylvanica, Prunus serotina, Quercus alba, Quercus ellipsoidalis, Quercus rubra (together =>50% RIV)
        // OR
        // Ii . Tree composition dominated by any one or more of the hardwoods and/or conifer STRONG MESIC DIAGNOSTICS of Abies balsamea, Acer pensylvanicum, Acer spicatum, Betula alleghaniensis, Fraxinus nigra, Larix laricina, Picea glauca, Picea mariana, Populus balsamifera, Populus grandidentata,Thuja occidentalis, Tsuga canadensis (=>20% RIV) [DFL1]
        // .... Laurentian Forests……..................................................................................................... …3
        // [DFL1]Its possible that the details of composition could be omitted and the couplet just relies on ecoprovince Location.CS Picea mariana, Pinus banksiana, Pinus resinosa, Pinus strobus (=>50% RIV);
        // OR
        //     iib. Tree composition as above, but with =>20% RIV, AND other species are any combination of MODERATE DRY DIAGNOSTICS of Amelanchier spp.,, Betula papyrifera, Carpinus caroliniana, Ostrya virginiana, Populus grandidentata, Populus tremuloides, Prunus pensylvanica, Prunus serotina, Quercus alba, Quercus ellipsoidalis, Quercus rubra (together =>50% RIV)
        // OR
        // Ii . Tree composition dominated by any one or more of the hardwoods and/or conifer STRONG MESIC DIAGNOSTICS of Abies balsamea, Acer pensylvanicum, Acer spicatum, Betula alleghaniensis, Fraxinus nigra, Larix laricina, Picea glauca, Picea mariana, Populus balsamifera, Populus grandidentata,Thuja occidentalis, Tsuga canadensis (=>20% RIV) [DFL1]
        // .... Laurentian Forests……..................................................................................................... …3

        List<KeyValue> ECOPROVINCE_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212")
        );
        List<List<KeyValue>> ECOPROVINCE_patterns = Arrays.asList(
            ECOPROVINCE_pattern0
        );
        PatternList ECOPROVINCE = new PatternList("ECOPROVINCE", ECOPROVINCE_patterns);

        List<KeyValue> ECOREGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222J")
        );
        List<KeyValue> ECOREGION_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "222K")
        );
        List<KeyValue> ECOREGION_pattern2 = Arrays.asList(
            new KeyValue("ecoregion", "222L")
        );
        List<KeyValue> ECOREGION_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "222M")
        );
        List<KeyValue> ECOREGION_pattern4 = Arrays.asList(
            new KeyValue("ecoregion", "222R")
        );
        List<KeyValue> ECOREGION_pattern5 = Arrays.asList(
            new KeyValue("ecoregion", "222U")
        );
        List<List<KeyValue>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0,
            ECOREGION_pattern1,
            ECOREGION_pattern2,
            ECOREGION_pattern3,
            ECOREGION_pattern4,
            ECOREGION_pattern5
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<List<KeyValue>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_DIAGNOSTICS_pattern0,
            STRONG_DRY_DIAGNOSTICS_pattern1,
            STRONG_DRY_DIAGNOSTICS_pattern2,
            STRONG_DRY_DIAGNOSTICS_pattern3
        );
        PatternList STRONG_DRY_DIAGNOSTICS = new PatternList("STRONG_DRY_DIAGNOSTICS", STRONG_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<List<KeyValue>> MODERATE_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_DRY_DIAGNOSTICS_pattern0,
            MODERATE_DRY_DIAGNOSTICS_pattern1,
            MODERATE_DRY_DIAGNOSTICS_pattern2,
            MODERATE_DRY_DIAGNOSTICS_pattern3,
            MODERATE_DRY_DIAGNOSTICS_pattern4,
            MODERATE_DRY_DIAGNOSTICS_pattern5,
            MODERATE_DRY_DIAGNOSTICS_pattern6,
            MODERATE_DRY_DIAGNOSTICS_pattern7,
            MODERATE_DRY_DIAGNOSTICS_pattern8,
            MODERATE_DRY_DIAGNOSTICS_pattern9,
            MODERATE_DRY_DIAGNOSTICS_pattern10
        );
        PatternList MODERATE_DRY_DIAGNOSTICS = new PatternList("MODERATE_DRY_DIAGNOSTICS", MODERATE_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer spicatum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOPROVINCE) || 
           (plot.match(ECOREGION) && plot.riv(STRONG_DRY_DIAGNOSTICS) >= 50 || 
           plot.riv(STRONG_DRY_DIAGNOSTICS) >= 20 &&
           plot.riv(MODERATE_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DRY_DIAGNOSTICS) >= 50
           || plot.riv(STRONG_MESIC_DIAGNOSTICS) >=20)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_139() {

        // Acadian-Appalachian Forest (M103)
        // M103

        String level = "macrogroup";
        String code = "M103";

        // i.  Located in Ecoprovince 211A to 211E, M211, and 211Ia [i.e all stands in these Acadian- northern Appalachian ecoregions go here, regardless of tree composition].
        // OR 
        // ii.  tree composition dominated by one or more of Abies balsamea, Abies fraseri, Picea rubens (=>20% RIV)  
        // OR 
        // iii.  Located in 211Ja, 211Jb, 211Jc, 211Jd, AND
        // i. Tree composition dominated by one or more of STRONG DRY DIAGNOSTICS Picea rubens, Picea mariana, Pinus banksiana, Pinus resinosa, Pinus strobus, Quercus alba, Quercus macrocarpa, Quercus velutina (=>50% RIV);
        // OR
        // ii. Tree composition as above, but with =>20% RIV, AND other species are any combination of MODERATE DRY DIAGNOSTICS of Amelanchier spp., Betula populifolia, Betula papyrifera, Carpinus caroliniana, Ostrya virginiana, Populus grandidentata, Populus tremuloides, Prunus pensylvanica, Prunus serotina, Quercus rubra (together =>50% RIV);
        // OR  
        // iii. Tree composition dominated by any one or more of the hardwoods and/or conifer STRONG MESIC DIAGNOSTICS of Abies balsamea, Abies fraseri, Acer spicatum, , Larix laricina, Picea glauca, Picea rubens, Picea mariana, Populus balsamifera, Populus grandidentata, Thuja occidentalis (=>20% RIV) [DFL1.1]   Acadian-Appalachian Forest (M103)
        // [note; dry forests in Acadian-Northern Appalachian region are relatively uncommon, so dry versus mesic combined at macrogroup level and distinction is made at group level].

        List<KeyValue> ECOREGION_A_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "211A, 211B, 211C, 211D, 211E, M211, 211Ia")
        );
        List<List<KeyValue>> ECOREGION_A_patterns = Arrays.asList(
            ECOREGION_A_pattern0
        );
        PatternList ECOREGION_A = new PatternList("ECOREGION_A", ECOREGION_A_patterns);

        List<KeyValue> ECOREGION_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> ECOREGION_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies fraseri")
        );
        List<KeyValue> ECOREGION_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<List<KeyValue>> ECOREGION_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGION_DIAGNOSTICS_pattern0,
            ECOREGION_DIAGNOSTICS_pattern1,
            ECOREGION_DIAGNOSTICS_pattern2
        );
        PatternList ECOREGION_DIAGNOSTICS = new PatternList("ECOREGION_DIAGNOSTICS", ECOREGION_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGION_B_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "211Ja, 211Jb, 211Jc, 211JD")
        );
        List<List<KeyValue>> ECOREGION_B_patterns = Arrays.asList(
            ECOREGION_B_pattern0
        );
        PatternList ECOREGION_B = new PatternList("ECOREGION_B", ECOREGION_B_patterns);

        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_DIAGNOSTICS_pattern0,
            STRONG_DRY_DIAGNOSTICS_pattern1,
            STRONG_DRY_DIAGNOSTICS_pattern2,
            STRONG_DRY_DIAGNOSTICS_pattern3,
            STRONG_DRY_DIAGNOSTICS_pattern4,
            STRONG_DRY_DIAGNOSTICS_pattern5,
            STRONG_DRY_DIAGNOSTICS_pattern6,
            STRONG_DRY_DIAGNOSTICS_pattern7
        );
        PatternList STRONG_DRY_DIAGNOSTICS = new PatternList("STRONG_DRY_DIAGNOSTICS", STRONG_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula populifolia")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<List<KeyValue>> MODERATE_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_DRY_DIAGNOSTICS_pattern0,
            MODERATE_DRY_DIAGNOSTICS_pattern1,
            MODERATE_DRY_DIAGNOSTICS_pattern2,
            MODERATE_DRY_DIAGNOSTICS_pattern3,
            MODERATE_DRY_DIAGNOSTICS_pattern4,
            MODERATE_DRY_DIAGNOSTICS_pattern5,
            MODERATE_DRY_DIAGNOSTICS_pattern6,
            MODERATE_DRY_DIAGNOSTICS_pattern7,
            MODERATE_DRY_DIAGNOSTICS_pattern8,
            MODERATE_DRY_DIAGNOSTICS_pattern9
        );
        PatternList MODERATE_DRY_DIAGNOSTICS = new PatternList("MODERATE_DRY_DIAGNOSTICS", MODERATE_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Abies fraseri")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer spicatum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Picea rubens")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGION_A) ||
           plot.riv(ECOREGION_DIAGNOSTICS) >=1 ||
           plot.match(ECOREGION_B) && 
           (plot.riv(STRONG_DRY_DIAGNOSTICS)>=50 ||
           plot.riv(STRONG_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DRY_DIAGNOSTICS) >=50 || plot.riv(STRONG_MESIC_DIAGNOSTICS)>=20)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_140() {

        // Laurentian Dry Forest & Woodland (M159)
        // M159

        String level = "macrogroup";
        String code = "M159";

        // Tree composition dominated by one or more of the following:
        //   i Tree composition dominated by one or more of STRONG DRY DIAGNOSTICS Picea mariana, Pinus banksiana, Pinus resinosa, Pinus strobus (=>50% RIV);
        // OR
        //      ii. Tree composition as above, but with =>20% RIV, AND other species are any combination of MODERATE DRY DIAGNOSTICS of Amelanchier spp.,, Betula papyrifera, Carpinus caroliniana, Ostrya virginiana, Populus grandidentata, Populus tremuloides, Prunus pensylvanica, Prunus serotina, Quercus alba, Quercus ellipsoidalis, Quercus rubra (together =>50% RIV)…..Laurentian Dry Forest & Woodland (M159)

        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<List<KeyValue>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_DIAGNOSTICS_pattern0,
            STRONG_DRY_DIAGNOSTICS_pattern1,
            STRONG_DRY_DIAGNOSTICS_pattern2,
            STRONG_DRY_DIAGNOSTICS_pattern3
        );
        PatternList STRONG_DRY_DIAGNOSTICS = new PatternList("STRONG_DRY_DIAGNOSTICS", STRONG_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
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
            plot.riv(STRONG_DRY_DIAGNOSTICS) >= 50
           || (    plot.riv(STRONG_DRY_DIAGNOSTICS) >= 20
               && plot.riv(STRONG_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_141() {

        // Laurentian Mesic Mixed Forest (M102)
        // M102

        String level = "macrogroup";
        String code = "M102";

        // Tree composition dominated by any one or more of the hardwoods and/or conifers
        // STRONG MESIC DIAGNOSTICS Abies balsamea, Abies fraseri, Acer pensylvanicum,
        // Acer saccharum, Acer spicatum, Betula alleghaniensis, Betula lenta, Fagus grandifolia,
        // Fraxinus americana, Fraxinus nigra, Fraxinus pennsylvanica, Larix laricina, Picea glauca,
        // Picea mariana, Picea rubens, Populus balsamifera, Populus grandidentata, Quercus macrocarpa,
        // Quercus rubra, Thuja occidentalis, Tilia americana, Tsuga canadensis, Ulmus americana (>=20% RIV);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Abies balsamea")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Acer spicatum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Larix laricina")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Picea glauca")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Picea mariana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Thuja occidentalis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11,
            STRONG_MESIC_DIAGNOSTICS_pattern12,
            STRONG_MESIC_DIAGNOSTICS_pattern13,
            STRONG_MESIC_DIAGNOSTICS_pattern14,
            STRONG_MESIC_DIAGNOSTICS_pattern15,
            STRONG_MESIC_DIAGNOSTICS_pattern16,
            STRONG_MESIC_DIAGNOSTICS_pattern17,
            STRONG_MESIC_DIAGNOSTICS_pattern18,
            STRONG_MESIC_DIAGNOSTICS_pattern19,
            STRONG_MESIC_DIAGNOSTICS_pattern20
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_142() {

        // Laurentian Dry Forest & Woodland LC (M159)
        // Laurentian Dry Forest & Woodland LC (M159)

        String level = "macrogroup";
        String code = "Laurentian Dry Forest & Woodland LC (M159)";

        // Not as Above

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_143() {

        // Coastal and Midwest Forest Macrogroups, Appalachian and Central Interior Forest Macrogroups
        // Coastal and Midwest Forest Macrogroups, Appalachian and Central Interior Forest Macrogroups

        String level = "informal";
        String code = "Coastal and Midwest Forest Macrogroups, Appalachian and Central Interior Forest Macrogroups";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_144() {

        // North Atlantic Coastal Forest & Woodland (M525)
        // M525

        String level = "macrogroup";
        String code = "M525";

        // Tree composition dominated by one of the following:
        // [PM21.1]LOCATED in 221An, 221Ab[DFL22.1], 232A, 232H (but not North Carolina[PM23.1]) or 232I AND tree composition dominated by one or more of the following:
        // i. Tree composition dominated by one or more of the STRONG DIAGNOSTICS species of Fagus grandifolia, Ilex opaca, Juniperus virginiana, Pinus rigida, Pinus echinata, Pinus taeda, Pinus virginiana, Quercus alba, Quercus falcata (= var. falcata), Quercus stellata, Quercus velutina  (=>50% RIV);
        // OR
        // ii. tree composition as above, but with =>20% RIV, AND other species are any combination of MODERATE DIAGNOSTICS diagnostic species of Pinus strobus, Prunus serotina, Quercus coccinea, Quercus montana, Quercus muehlenbergii (together =>50% RIV) .............................. North Atlantic Coastal Forest & Woodland (M525)

        List<KeyValue> ECOREGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "221An")
        );
        List<KeyValue> ECOREGION_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "221Ab")
        );
        List<KeyValue> ECOREGION_pattern2 = Arrays.asList(
            new KeyValue("ecoregion", "232A")
        );
        List<KeyValue> ECOREGION_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "232I")
        );
        List<List<KeyValue>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0,
            ECOREGION_pattern1,
            ECOREGION_pattern2,
            ECOREGION_pattern3
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        List<KeyValue> ECOREGION_STATE_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "232H")
        );
        List<List<KeyValue>> ECOREGION_STATE_patterns = Arrays.asList(
            ECOREGION_STATE_pattern0
        );
        PatternList ECOREGION_STATE = new PatternList("ECOREGION_STATE", ECOREGION_STATE_patterns);

        List<KeyValue> STATE_pattern0 = Arrays.asList(
            new KeyValue("state", "NC")
        );
        List<List<KeyValue>> STATE_patterns = Arrays.asList(
            STATE_pattern0
        );
        PatternList STATE = new PatternList("STATE", STATE_patterns);

        List<KeyValue> STRONG_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus rigida")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus virginiana")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DIAGNOSTICS_pattern0,
            STRONG_DIAGNOSTICS_pattern1,
            STRONG_DIAGNOSTICS_pattern2,
            STRONG_DIAGNOSTICS_pattern3,
            STRONG_DIAGNOSTICS_pattern4,
            STRONG_DIAGNOSTICS_pattern5,
            STRONG_DIAGNOSTICS_pattern6,
            STRONG_DIAGNOSTICS_pattern7,
            STRONG_DIAGNOSTICS_pattern8,
            STRONG_DIAGNOSTICS_pattern9,
            STRONG_DIAGNOSTICS_pattern10
        );
        PatternList STRONG_DIAGNOSTICS = new PatternList("STRONG_DIAGNOSTICS", STRONG_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> MODERATE_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> MODERATE_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> MODERATE_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<List<KeyValue>> MODERATE_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_DIAGNOSTICS_pattern0,
            MODERATE_DIAGNOSTICS_pattern1,
            MODERATE_DIAGNOSTICS_pattern2,
            MODERATE_DIAGNOSTICS_pattern3,
            MODERATE_DIAGNOSTICS_pattern4
        );
        PatternList MODERATE_DIAGNOSTICS = new PatternList("MODERATE_DIAGNOSTICS", MODERATE_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGION) ||
           plot.match(ECOREGION_STATE) && !plot.match(STATE)) &&
           plot.riv(STRONG_DIAGNOSTICS)>=20 ||
           (plot.riv(STRONG_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTICS)>=50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_145() {

        // Central Midwest Oak Forest, Woodland & Savanna (M012)
        // M012

        String level = "macrogroup";
        String code = "M012";

        // Plot occurs in Ecoregion 222, 223G, 251 [excludes 222I, exclude Ozarks ecoregion] AND
        //  i. tree composition dominated by one or more of the STRONG DRY DIAGNOSTICS of Carya ovata, Juniperus virginiana,
        //     Pinus banksiana, Pinus resinosa, Pinus strobus, Populus tremuloides, Quercus alba, Quercus ellipsoidalis,
        //     Quercus imbricaria, Quercus macrocarpa, Quercus rubra, Quercus muehlenbergii, Quercus stellata,
        //     Quercus velutina (>=50% RIV);
        // OR
        // ii. tree composition as above, but with >=20% RIV, AND other species are any combination of MODERATE DRY DIAGNOSTICS
        //     diagnostic species of Betula papyrifera, Carya alba, Carya glabra, Carya laciniosa, or weakly diagnostic species
        //     of Amelanchier spp., Carpinus caroliniana, Cercis canadensis, Cornus florida, Diospyros virginiana,
        //     Fraxinus quadrangulata, Morus rubra, Ostrya virginiana, Populus gradidentata, Prunus serotina,
        //     Quercus falcata (= var. falcata), Sassafras albidum (together >=50% RIV)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222A, 222B, 222C, 222D, 222E, 222F, 222G, 222H, 222J, 222K, 222L, 222M, 223G, 251 ! 222I")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_DIAGNOSTICS_pattern0,
            STRONG_DRY_DIAGNOSTICS_pattern1,
            STRONG_DRY_DIAGNOSTICS_pattern2,
            STRONG_DRY_DIAGNOSTICS_pattern3,
            STRONG_DRY_DIAGNOSTICS_pattern4,
            STRONG_DRY_DIAGNOSTICS_pattern5,
            STRONG_DRY_DIAGNOSTICS_pattern6,
            STRONG_DRY_DIAGNOSTICS_pattern7,
            STRONG_DRY_DIAGNOSTICS_pattern8,
            STRONG_DRY_DIAGNOSTICS_pattern9,
            STRONG_DRY_DIAGNOSTICS_pattern10,
            STRONG_DRY_DIAGNOSTICS_pattern11,
            STRONG_DRY_DIAGNOSTICS_pattern12,
            STRONG_DRY_DIAGNOSTICS_pattern13
        );
        PatternList STRONG_DRY_DIAGNOSTICS = new PatternList("STRONG_DRY_DIAGNOSTICS", STRONG_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya laciniosa")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Cornus florida")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Morus rubra")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> MODERATE_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Sassafras albidum")
        );
        List<List<KeyValue>> MODERATE_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_DRY_DIAGNOSTICS_pattern0,
            MODERATE_DRY_DIAGNOSTICS_pattern1,
            MODERATE_DRY_DIAGNOSTICS_pattern2,
            MODERATE_DRY_DIAGNOSTICS_pattern3,
            MODERATE_DRY_DIAGNOSTICS_pattern4,
            MODERATE_DRY_DIAGNOSTICS_pattern5,
            MODERATE_DRY_DIAGNOSTICS_pattern6,
            MODERATE_DRY_DIAGNOSTICS_pattern7,
            MODERATE_DRY_DIAGNOSTICS_pattern8,
            MODERATE_DRY_DIAGNOSTICS_pattern9,
            MODERATE_DRY_DIAGNOSTICS_pattern10,
            MODERATE_DRY_DIAGNOSTICS_pattern11,
            MODERATE_DRY_DIAGNOSTICS_pattern12,
            MODERATE_DRY_DIAGNOSTICS_pattern13,
            MODERATE_DRY_DIAGNOSTICS_pattern14,
            MODERATE_DRY_DIAGNOSTICS_pattern15
        );
        PatternList MODERATE_DRY_DIAGNOSTICS = new PatternList("MODERATE_DRY_DIAGNOSTICS", MODERATE_DRY_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
           && (    plot.riv(STRONG_DRY_DIAGNOSTICS) >= 50
                || (plot.riv(STRONG_DRY_DIAGNOSTICS) >= 20 && plot.riv(STRONG_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DRY_DIAGNOSTICS) >= 50))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_146() {

        // Central Midwest Mesic Forest (M882)
        // M882

        String level = "macrogroup";
        String code = "M882";

        // Stands found in Ecoregion 222, 223A, 223G, 251, 332) [excludes 222I, includes Ozarks ecoregion]
        // AND tree composition dominated by one or more of the following:
        //   i. Tree composition dominated by one or more of the STRONG MESIC DIAGNOSTICS: Acer nigrum, Acer saccharum,
        //      Aesculus glabra, Asimina triloba, Carya cordiformis, Celtis occidentalis, Fagus grandifolia, Fraxinus americana,
        //      Fraxinus nigra, Fraxinus pennsylvanica, Gymnocladus dioicus, Juglans cinerea, Liriodendron tulipifera,
        //      Liquidambar styraciflua, Nyssa sylvatica, Platanus occidentalis, Quercus bicolor, Quercus palustris,
        //      Tilia americana, Ulmus rubra, Ulmus americana (>=50% RIV).
        //  OR
        //  ii. Tree composition as above, but with >=20% RIV and other species are any combination of MODERATE MESIC DIAGNOSTICS
        //      Acer barbatum, Acer negundo, Amelanchier spp., Betula populifolia,  Betula papyrifera, Carpinus caroliniana,
        //      Carya ovalis, Cornus florida, Gleditsia triacanthos, Juglans nigra, Ostrya virginiana, Pinus strobus,
        //      Populus balsamifera, Populus deltoides, Populus grandidentata, Populus tremuloides, Prunus pensylvanica,
        //      Prunus virginiana, Quercus imbricaria, Quercus muehlenbergii, Quercus pagoda, Quercus rubra, Quercus shumardii,
        //      Sassafras albidum, Ulmus thomasii (together >=50% RIV)
        //  OR
        // iii. Tree composition dominated by Quercus rubra with >=20% RIV, AND <20% RIV of other species are any combination of
        //      Quercus spp or Carya spp. (Quercus alba, Quercus coccinea, Quercus ellipsoidalis, Quercus macrocarpa,
        //      Quercus prinus, Quercus velutina, Carya glabra, Carya ovata, Carya alba)

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222A, 222B, 222C, 222D, 222D, 222E, 222F, 222G, 222H, 222J, 222K, 222L, 222M,  223G, 251, 332 ! 222I")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra var. arguta")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Asimina triloba")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Gymnocladus dioicus")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Juglans cinerea")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus bicolor")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus palustris")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11,
            STRONG_MESIC_DIAGNOSTICS_pattern12,
            STRONG_MESIC_DIAGNOSTICS_pattern13,
            STRONG_MESIC_DIAGNOSTICS_pattern14,
            STRONG_MESIC_DIAGNOSTICS_pattern15,
            STRONG_MESIC_DIAGNOSTICS_pattern16,
            STRONG_MESIC_DIAGNOSTICS_pattern17,
            STRONG_MESIC_DIAGNOSTICS_pattern18,
            STRONG_MESIC_DIAGNOSTICS_pattern19,
            STRONG_MESIC_DIAGNOSTICS_pattern20
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer negundo")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula populifolia")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya ovalis")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Cornus florida")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Populus balsamifera")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Populus deltoides ssp. monilifera")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Sassafras albidum")
        );
        List<KeyValue> MODERATE_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Ulmus thomasii")
        );
        List<List<KeyValue>> MODERATE_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_MESIC_DIAGNOSTICS_pattern0,
            MODERATE_MESIC_DIAGNOSTICS_pattern1,
            MODERATE_MESIC_DIAGNOSTICS_pattern2,
            MODERATE_MESIC_DIAGNOSTICS_pattern3,
            MODERATE_MESIC_DIAGNOSTICS_pattern4,
            MODERATE_MESIC_DIAGNOSTICS_pattern5,
            MODERATE_MESIC_DIAGNOSTICS_pattern6,
            MODERATE_MESIC_DIAGNOSTICS_pattern7,
            MODERATE_MESIC_DIAGNOSTICS_pattern8,
            MODERATE_MESIC_DIAGNOSTICS_pattern9,
            MODERATE_MESIC_DIAGNOSTICS_pattern10,
            MODERATE_MESIC_DIAGNOSTICS_pattern11,
            MODERATE_MESIC_DIAGNOSTICS_pattern12,
            MODERATE_MESIC_DIAGNOSTICS_pattern13,
            MODERATE_MESIC_DIAGNOSTICS_pattern14,
            MODERATE_MESIC_DIAGNOSTICS_pattern15,
            MODERATE_MESIC_DIAGNOSTICS_pattern16,
            MODERATE_MESIC_DIAGNOSTICS_pattern17,
            MODERATE_MESIC_DIAGNOSTICS_pattern18,
            MODERATE_MESIC_DIAGNOSTICS_pattern19,
            MODERATE_MESIC_DIAGNOSTICS_pattern20,
            MODERATE_MESIC_DIAGNOSTICS_pattern21,
            MODERATE_MESIC_DIAGNOSTICS_pattern22,
            MODERATE_MESIC_DIAGNOSTICS_pattern23,
            MODERATE_MESIC_DIAGNOSTICS_pattern24
        );
        PatternList MODERATE_MESIC_DIAGNOSTICS = new PatternList("MODERATE_MESIC_DIAGNOSTICS", MODERATE_MESIC_DIAGNOSTICS_patterns);

        List<KeyValue> DIAGNOSTIC_SPECIES_III_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<List<KeyValue>> DIAGNOSTIC_SPECIES_III_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_III_pattern0
        );
        PatternList DIAGNOSTIC_SPECIES_III = new PatternList("DIAGNOSTIC_SPECIES_III", DIAGNOSTIC_SPECIES_III_patterns);

        List<KeyValue> EXCLUDED_SPECIES_III_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern5 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern7 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> EXCLUDED_SPECIES_III_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<List<KeyValue>> EXCLUDED_SPECIES_III_patterns = Arrays.asList(
            EXCLUDED_SPECIES_III_pattern0,
            EXCLUDED_SPECIES_III_pattern1,
            EXCLUDED_SPECIES_III_pattern2,
            EXCLUDED_SPECIES_III_pattern3,
            EXCLUDED_SPECIES_III_pattern4,
            EXCLUDED_SPECIES_III_pattern5,
            EXCLUDED_SPECIES_III_pattern6,
            EXCLUDED_SPECIES_III_pattern7,
            EXCLUDED_SPECIES_III_pattern8
        );
        PatternList EXCLUDED_SPECIES_III = new PatternList("EXCLUDED_SPECIES_III", EXCLUDED_SPECIES_III_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
           && (    plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 50
                || (plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20 && plot.riv(STRONG_MESIC_DIAGNOSTICS) + plot.riv(MODERATE_MESIC_DIAGNOSTICS) >= 50)
                || (plot.riv(DIAGNOSTIC_SPECIES_III) >= 20 && plot.riv(EXCLUDED_SPECIES_III) < 20))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_147() {

        // Central Midwest Oak Forest, Woodland & Savanna LC (M012)
        // Central Midwest Oak Forest, Woodland & Savanna LC (M012)

        String level = "macrogroup";
        String code = "Central Midwest Oak Forest, Woodland & Savanna LC (M012)";

        // Plot occurs in Ecoregions 222 (except not 222I), 251,
        // AND % RIV of STRONG DRY DIAGNOSTICS > STRONG MESIC DIAGNOSTICS

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222, 251 ! 222I")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Pinus resinosa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus macrocarpa")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_DIAGNOSTICS_pattern0,
            STRONG_DRY_DIAGNOSTICS_pattern1,
            STRONG_DRY_DIAGNOSTICS_pattern2,
            STRONG_DRY_DIAGNOSTICS_pattern3,
            STRONG_DRY_DIAGNOSTICS_pattern4,
            STRONG_DRY_DIAGNOSTICS_pattern5,
            STRONG_DRY_DIAGNOSTICS_pattern6,
            STRONG_DRY_DIAGNOSTICS_pattern7,
            STRONG_DRY_DIAGNOSTICS_pattern8,
            STRONG_DRY_DIAGNOSTICS_pattern9,
            STRONG_DRY_DIAGNOSTICS_pattern10,
            STRONG_DRY_DIAGNOSTICS_pattern11,
            STRONG_DRY_DIAGNOSTICS_pattern12,
            STRONG_DRY_DIAGNOSTICS_pattern13
        );
        PatternList STRONG_DRY_DIAGNOSTICS = new PatternList("STRONG_DRY_DIAGNOSTICS", STRONG_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra var. arguta")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Asimina triloba")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Fraxinus nigra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Gymnocladus dioicus")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Juglans cinerea")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus bicolor")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus palustris")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10,
            STRONG_MESIC_DIAGNOSTICS_pattern11,
            STRONG_MESIC_DIAGNOSTICS_pattern12,
            STRONG_MESIC_DIAGNOSTICS_pattern13,
            STRONG_MESIC_DIAGNOSTICS_pattern14,
            STRONG_MESIC_DIAGNOSTICS_pattern15,
            STRONG_MESIC_DIAGNOSTICS_pattern16,
            STRONG_MESIC_DIAGNOSTICS_pattern17,
            STRONG_MESIC_DIAGNOSTICS_pattern18,
            STRONG_MESIC_DIAGNOSTICS_pattern19,
            STRONG_MESIC_DIAGNOSTICS_pattern20
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS) && plot.riv(STRONG_DRY_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_148() {

        // Central Midwest Mesic Forest LC (M882)
        // Central Midwest Mesic Forest LC (M882)

        String level = "macrogroup";
        String code = "Central Midwest Mesic Forest LC (M882)";

        // other

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "222, 251 ! 222I")
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

    public Object[] element_149() {

        // Southern-Central Appalachian Mesic Forest (M883)
        // M883

        String level = "macrogroup";
        String code = "M883";

        // i. Tree composition dominated by any one or more of the STRONG MESIC DIAGNOSTICS [Appalachian- Interior-Northeast Mesic
        //      Forest Diagnostics] Acer nigrum [questionable], Acer pensylvanicum, Aesculus flava, Betula alleghaniensis, Betula lenta,
        //      Halesia carolina (=H. tetraptera), Halesia spp., Magnolia acuminata, Magnolia tripetala, Tilia americana var. heterophylla,
        //      Tsuga canadensis, (>=50% RIV);
        //  OR
        //  ii. Plot occurs in EcoProvinces 211F, 211G, 211Jd, 221, M221, 223B-223G, 231A, 231C, 231D, 231I, 232 [only plots in VA, PA,
        //      DE, MD, NJ, southern IN, southern IL] AND tree composition dominated by any one or more of the ECOREGIONAL STRONG MESIC
        //      DIAGNOSTICS [Strong Appalachian- Northeast Mesic Forest Diagnostics] Acer nigrum, Acer pensylvanicum, Acer saccharum,
        //      Aesculus flava, Aesculus glabra, Asimina triloba, Betula alleghaniensis, Betula lenta, Carya cordiformis, Celtis occidentalis,
        //      Fagus grandifolia, Fraxinus americana, Fraxinus pennsylvanica, Halesia carolina (= H. tetraptera), Halesia spp., Liriodendron tulipifera,
        //      Liquidambar styraciflua, Magnolia acuminata, Magnolia fraseri, Magnolia macrophylla, Magnolia tripetela,Quercus shumardii,
        //      Tilia americana, Tilia americana var. heterophylla, Tsuga canadensis, Ulmus americana (>=20% RIV);
        //   AND
        //      any of the following ECOREGIONAL MODERATE MESIC DIAGNOSTICS [Moderate Appalachian-Interior-Northeast Mesic Forest Diagnostics]
        //      Acer barbatum,Amelanchier spp., Betula populifolia, Betula papyrifera, Carpinus caroliniana, Carya ovalis, Cornus florida,
        //      Gleditsia triacanthos, Juglans cinerea, Juglans nigra, Ostrya virginiana, Oxydendrum arboreum, Pinus strobus,
        //      Platanus occidentalis, Populus grandidentata, Populus tremuloides, Prunus pensylvanica, Prunus serotina, Prunus virginiana,
        //      Quercus bicolor, Quercus imbricaria, Quercus muehlenbergii, Quercus pagoda, Quercus phellos, Quercus rubra, Quercus shumardii,
        //      Ulmus rubra, Ulmus thomasii (together >=50% RIV) [note, some mesic Nyssa sylvatica - Quercus alba) plots from Arkansas could
        //      key out here]
        //  OR
        // iii. Plot occurs in EcoSections 211F, 211G, 211Jd, 221, M221, 223B-223G, 231A, 231C, 231D, 231I, 232 AND tree composition dominated
        //      by ECOREGIONAL MODERATE MESIC OAK DIAGNOSTICS Quercus rubra with >=20% RIV, and the following dry Quercus spp. or Carya spp.
        //      (Quercus alba, Quercus coccinea, Quercus prinus, Quercus stellata, Quercus velutina, Carya glabra, Carya alba, Carya pallida)
        //      <20% RIV

        List<KeyValue> ECOREGIONS_1_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "211F")
        );
        List<KeyValue> ECOREGIONS_1_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "211G")
        );
        List<KeyValue> ECOREGIONS_1_pattern2 = Arrays.asList(
            new KeyValue("ecoregion", "211Jd")
        );
        List<KeyValue> ECOREGIONS_1_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "221")
        );
        List<KeyValue> ECOREGIONS_1_pattern4 = Arrays.asList(
            new KeyValue("ecoregion", "M221")
        );
        List<KeyValue> ECOREGIONS_1_pattern5 = Arrays.asList(
            new KeyValue("ecoregion", "223")
        );
        List<KeyValue> ECOREGIONS_1_pattern6 = Arrays.asList(
            new KeyValue("ecoregion", "M223")
        );
        List<KeyValue> ECOREGIONS_1_pattern7 = Arrays.asList(
            new KeyValue("ecoregion", "231A")
        );
        List<KeyValue> ECOREGIONS_1_pattern8 = Arrays.asList(
            new KeyValue("ecoregion", "231C")
        );
        List<KeyValue> ECOREGIONS_1_pattern9 = Arrays.asList(
            new KeyValue("ecoregion", "231D")
        );
        List<KeyValue> ECOREGIONS_1_pattern10 = Arrays.asList(
            new KeyValue("ecoregion", "231I")
        );
        List<KeyValue> ECOREGIONS_1_pattern11 = Arrays.asList(
            new KeyValue("ecoregion", "231G")
        );
        List<KeyValue> ECOREGIONS_1_pattern12 = Arrays.asList(
            new KeyValue("ecoregion", "M231A")
        );
        List<List<KeyValue>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0,
            ECOREGIONS_1_pattern1,
            ECOREGIONS_1_pattern2,
            ECOREGIONS_1_pattern3,
            ECOREGIONS_1_pattern4,
            ECOREGIONS_1_pattern5,
            ECOREGIONS_1_pattern6,
            ECOREGIONS_1_pattern7,
            ECOREGIONS_1_pattern8,
            ECOREGIONS_1_pattern9,
            ECOREGIONS_1_pattern10,
            ECOREGIONS_1_pattern11,
            ECOREGIONS_1_pattern12
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Aesculus flava")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Halesia carolina")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Halesia")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Magnolia tripetala")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<List<KeyValue>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_MESIC_DIAGNOSTICS_pattern0,
            STRONG_MESIC_DIAGNOSTICS_pattern1,
            STRONG_MESIC_DIAGNOSTICS_pattern2,
            STRONG_MESIC_DIAGNOSTICS_pattern3,
            STRONG_MESIC_DIAGNOSTICS_pattern4,
            STRONG_MESIC_DIAGNOSTICS_pattern5,
            STRONG_MESIC_DIAGNOSTICS_pattern6,
            STRONG_MESIC_DIAGNOSTICS_pattern7,
            STRONG_MESIC_DIAGNOSTICS_pattern8,
            STRONG_MESIC_DIAGNOSTICS_pattern9,
            STRONG_MESIC_DIAGNOSTICS_pattern10
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Aesculus flava")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra var. arguta")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Asimina triloba")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Halesia carolina")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Halesia")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Magnolia fraseri")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Magnolia macrophylla")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Magnolia tripetala")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern25
        );
        PatternList ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS = new PatternList("ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS", ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Betula populifolia")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Betula papyrifera")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Carya ovalis")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Cornus florida")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Gleditsia triacanthos")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Juglans cinerea")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Platanus occidentalis")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Populus grandidentata")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Populus tremuloides")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Prunus pensylvanica")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus bicolor")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Quercus phellos")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern25 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern26 = Arrays.asList(
            new KeyValue("species", "Ulmus rubra")
        );
        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern27 = Arrays.asList(
            new KeyValue("species", "Ulmus thomasii")
        );
        List<List<KeyValue>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern0,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern1,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern2,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern3,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern4,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern5,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern6,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern7,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern8,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern9,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern10,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern11,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern12,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern13,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern14,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern15,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern16,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern17,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern18,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern19,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern20,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern21,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern22,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern23,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern24,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern25,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern26,
            ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern27
        );
        PatternList ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS = new PatternList("ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS", ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<List<KeyValue>> ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_pattern0
        );
        PatternList ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS = new PatternList("ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS", ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_patterns);

        List<KeyValue> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern2 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern3 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern4 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern5 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern6 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> EXCLUDED_SPECIES_pattern7 = Arrays.asList(
            new KeyValue("species", "Carya pallida")
        );
        List<List<KeyValue>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0,
            EXCLUDED_SPECIES_pattern1,
            EXCLUDED_SPECIES_pattern2,
            EXCLUDED_SPECIES_pattern3,
            EXCLUDED_SPECIES_pattern4,
            EXCLUDED_SPECIES_pattern5,
            EXCLUDED_SPECIES_pattern6,
            EXCLUDED_SPECIES_pattern7
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 50
           || (    plot.match(ECOREGIONS_1)
               && (   (    plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS) >= 20
                        && plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS) + plot.riv(ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS) >= 50)
                    || (    plot.riv(ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS) >= 20
                        && plot.riv(EXCLUDED_SPECIES) < 20)))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_150() {

        // Central Interior Oak - Pine Forest & Woodland (M543)
        // M543

        String level = "macrogroup";
        String code = "M543";

        // Plots not in CT, DE, OH, MA, NJ, NY, PA, WV AND
        //   i. Tree composition dominated by one or more of the STRONG DRY SOUTH-CENTRAL DIAGNOSTICS of Acer barbatum,
        //      Carya pallida, Carya texana, Diospyros virginiana, Fraxinus quadrangulata, Ilex opaca,
        //      Juniperus ashei, Oxydendrum arboreum, Pinus echinata, Pinus taeda, Quercus falcata (= var. falcata),
        //      Quercus marilandica, Quercus nigra, Quercus stellata (= var. stellata), Ulmus alata (>=50% RIV);
        // OR
        //  ii. States and tree composition as above, but with >=20% RIV; AND other species are any combination of
        //      MODERATE DRY SOUTH-CENTRAL DIAGNOSTICS Betula lenta, Carpinus caroliniana, Carya glabra, Carya alba,
        //      Carya ovata, Cercis canadensis, Cornus florida, Diospyros virginiana, Juglans nigra, Juniperus virginiana,
        //      Liriodendron tulipifera, Liquidambar styraciflua, Prunus serotina, Quercus alba, Quercus coccinea,
        //      Quercus prinus, Quercus rubra, Quercus velutina (together >=50% RIV).
        // OR
        // iii. Plot occurs in in 221H, 223, M223, 231, M231, 234, 255 [composition to be added; this could pull in
        //      mesic and dry stands that have low diagnostic trees and lots of ruderals, but ruderals <80%].

        List<KeyValue> EXCLUDED_STATES_pattern0 = Arrays.asList(
            new KeyValue("state", "CT")
        );
        List<KeyValue> EXCLUDED_STATES_pattern1 = Arrays.asList(
            new KeyValue("state", "DE")
        );
        List<KeyValue> EXCLUDED_STATES_pattern2 = Arrays.asList(
            new KeyValue("state", "OH")
        );
        List<KeyValue> EXCLUDED_STATES_pattern3 = Arrays.asList(
            new KeyValue("state", "MA")
        );
        List<KeyValue> EXCLUDED_STATES_pattern4 = Arrays.asList(
            new KeyValue("state", "NJ")
        );
        List<KeyValue> EXCLUDED_STATES_pattern5 = Arrays.asList(
            new KeyValue("state", "NY")
        );
        List<KeyValue> EXCLUDED_STATES_pattern6 = Arrays.asList(
            new KeyValue("state", "PA")
        );
        List<KeyValue> EXCLUDED_STATES_pattern7 = Arrays.asList(
            new KeyValue("state", "WV")
        );
        List<List<KeyValue>> EXCLUDED_STATES_patterns = Arrays.asList(
            EXCLUDED_STATES_pattern0,
            EXCLUDED_STATES_pattern1,
            EXCLUDED_STATES_pattern2,
            EXCLUDED_STATES_pattern3,
            EXCLUDED_STATES_pattern4,
            EXCLUDED_STATES_pattern5,
            EXCLUDED_STATES_pattern6,
            EXCLUDED_STATES_pattern7
        );
        PatternList EXCLUDED_STATES = new PatternList("EXCLUDED_STATES", EXCLUDED_STATES_patterns);

        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya pallida")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<List<KeyValue>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14
        );
        PatternList STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS = new PatternList("STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS", STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Cornus florida")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Juglans nigra")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus incana")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus laurifolia")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus pagoda")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<List<KeyValue>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern15,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern16,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern17,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern18,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern19,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern20,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern21,
            MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern22
        );
        PatternList MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS = new PatternList("MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS", MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONS_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "221H")
        );
        List<KeyValue> ECOREGIONS_pattern1 = Arrays.asList(
            new KeyValue("ecoregion", "223")
        );
        List<KeyValue> ECOREGIONS_pattern2 = Arrays.asList(
            new KeyValue("ecoregion", "M223")
        );
        List<KeyValue> ECOREGIONS_pattern3 = Arrays.asList(
            new KeyValue("ecoregion", "231")
        );
        List<KeyValue> ECOREGIONS_pattern4 = Arrays.asList(
            new KeyValue("ecoregion", "M231")
        );
        List<KeyValue> ECOREGIONS_pattern5 = Arrays.asList(
            new KeyValue("ecoregion", "234")
        );
        List<List<KeyValue>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0,
            ECOREGIONS_pattern1,
            ECOREGIONS_pattern2,
            ECOREGIONS_pattern3,
            ECOREGIONS_pattern4,
            ECOREGIONS_pattern5
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            !plot.match(EXCLUDED_STATES) && plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) >= 50
           || (plot.match(EXCLUDED_STATES) && plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) >= 20 && plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) + plot.riv(MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS) >= 50)
           ||  plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_151() {

        // Southern-Central Appalachian Dry Forest & Woodland (M502)
        // M502

        String level = "macrogroup";
        String code = "M502";

        // Plot not in Ecoregion 212 AND
        //  i. Tree composition dominated by one or more of the STRONG APPALACHIAN DRY DIAGNOSTICS of Carya glabra,
        //     Carya ovata, Carya alba, Castanea dentata, Fraxinus quadrangulata, Juniperus virginiana, Nyssa sylvatica,
        //     Pinus echinata, Pinus pungens, Pinus rigida, Pinus strobus, Pinus virginiana, Quercus alba, Quercus coccinea,
        //     Quercus ellipsoidalis, Quercus falcata (= var. falcata), Quercus imbricaria, Quercus ilicifolia,
        //     Quercus marilandica, Quercus prinus, Quercus stellata, Quercus velutina, Tsuga caroliniana
        //     (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of weakly diagnostic
        //     species of Amelanchier spp., Carpinus caroliniana, Cercis canadensis, Cornus florida,
        //     Ostrya virginiana, Oxydendrum arboreum, Pinus banksiana, Prunus serotina, Prunus virginiana,
        //     Quercus muehlenbergii, Quercus rubra, Sassafras albidum (>=50% RIV)

        List<KeyValue> ECOREGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "!212")
        );
        List<List<KeyValue>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Castanea dentata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus pungens")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus rigida")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus virginiana")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus ilicifolia")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Tsuga caroliniana")
        );
        List<List<KeyValue>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22
        );
        PatternList STRONG_APPALACHIAN_DRY_DIAGNOSTICS = new PatternList("STRONG_APPALACHIAN_DRY_DIAGNOSTICS", STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Amelanchier")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carpinus caroliniana")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Cercis canadensis")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Cornus florida")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Ostrya virginiana")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Pinus banksiana")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Prunus serotina")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Prunus virginiana")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Quercus muehlenbergii")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus rubra")
        );
        List<KeyValue> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Sassafras albidum")
        );
        List<List<KeyValue>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern0,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern1,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern2,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern3,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern4,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern5,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern6,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern7,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern8,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern9,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern10,
            MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern11
        );
        PatternList MODERATE_APPALACHIAN_DRY_DIAGNOSTICS = new PatternList("MODERATE_APPALACHIAN_DRY_DIAGNOSTICS", MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGION) && (plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) >= 50 || (plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) >= 20 && plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) + plot.riv(MODERATE_APPALACHIAN_DRY_DIAGNOSTICS) >= 50))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_152() {

        // Laurentian Mesic Forest LC (M102)
        // M102LC

        String level = "macrogroup";
        String code = "M102LC";

        // Plot is in Ecoregion 212

        List<KeyValue> ECOREGION_pattern0 = Arrays.asList(
            new KeyValue("ecoregion", "212")
        );
        List<List<KeyValue>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_153() {

        // Central Interior Oak - Pine Forest & Woodland LC  (M543)
        // M543LC

        String level = "macrogroup";
        String code = "M543LC";

        // %RIV of STRONG DRY SOUTH-CENTRAL DIAGNOSTICS > either STRONG APPALACHIAN DRY DIAGONOSTICS OR ECOREGIONAL STRONG MESIC DIAGNOSTICS

        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya pallida")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<List<KeyValue>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14
        );
        PatternList STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS = new PatternList("STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS", STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Castanea dentata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus pungens")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus rigida")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus virginiana")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus ilicifolia")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Tsuga caroliniana")
        );
        List<List<KeyValue>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22
        );
        PatternList STRONG_APPALACHIAN_DRY_DIAGNOSTICS = new PatternList("STRONG_APPALACHIAN_DRY_DIAGNOSTICS", STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Aesculus flava")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra var. arguta")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Asimina triloba")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Halesia carolina")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Magnolia fraseri")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Magnolia macrophylla")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Magnolia tripetala")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24
        );
        PatternList ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS = new PatternList("ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS", ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) > plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS)
           || plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) > plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_154() {

        // Southern-Central Appalachian Dry Forest & Woodland LC (M502)
        // Southern-Central Appalachian Dry Forest & Woodland LC (M502)

        String level = "macrogroup";
        String code = "Southern-Central Appalachian Dry Forest & Woodland LC (M502)";

        // i. %RIV STRONG APPALACHIAN DRY DIAGNOSTICS > either STRONG DRY SOUTH-CENTRAL DIAGNOSTICS OR ECOREGIONAL STRONG MESIC DIAGNOSTICS

        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer floridanum")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya pallida")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya texana")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Diospyros virginiana")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Ilex opaca")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Juniperus ashei")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Oxydendrum arboreum")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus taeda")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus nigra")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Ulmus alata")
        );
        List<List<KeyValue>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13,
            STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14
        );
        PatternList STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS = new PatternList("STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS", STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns);

        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Carya glabra")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Carya ovata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Carya tomentosa")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Castanea dentata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Fraxinus quadrangulata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Juniperus virginiana var. silicicola")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Nyssa sylvatica")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Pinus echinata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Pinus pungens")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Pinus rigida")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Pinus strobus")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Pinus virginiana")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Quercus alba")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Quercus coccinea")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Quercus ellipsoidalis")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Quercus falcata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Quercus imbricaria")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Quercus ilicifolia")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Quercus marilandica")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Quercus montana")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus stellata")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Quercus velutina")
        );
        List<KeyValue> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Tsuga caroliniana")
        );
        List<List<KeyValue>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21,
            STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22
        );
        PatternList STRONG_APPALACHIAN_DRY_DIAGNOSTICS = new PatternList("STRONG_APPALACHIAN_DRY_DIAGNOSTICS", STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns);

        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new KeyValue("species", "Acer nigrum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new KeyValue("species", "Acer pensylvanicum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new KeyValue("species", "Acer saccharum")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new KeyValue("species", "Aesculus flava")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new KeyValue("species", "Aesculus glabra var. arguta")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new KeyValue("species", "Asimina triloba")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new KeyValue("species", "Betula alleghaniensis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new KeyValue("species", "Betula lenta")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new KeyValue("species", "Carya cordiformis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new KeyValue("species", "Celtis occidentalis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new KeyValue("species", "Fagus grandifolia")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new KeyValue("species", "Fraxinus americana")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new KeyValue("species", "Fraxinus pennsylvanica")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new KeyValue("species", "Halesia carolina")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new KeyValue("species", "Liriodendron tulipifera")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new KeyValue("species", "Liquidambar styraciflua")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new KeyValue("species", "Magnolia acuminata")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new KeyValue("species", "Magnolia fraseri")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new KeyValue("species", "Magnolia macrophylla")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new KeyValue("species", "Magnolia tripetala")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new KeyValue("species", "Quercus shumardii")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new KeyValue("species", "Tilia americana")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new KeyValue("species", "Tilia americana var. heterophylla")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new KeyValue("species", "Tsuga canadensis")
        );
        List<KeyValue> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new KeyValue("species", "Ulmus americana")
        );
        List<List<KeyValue>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23,
            ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24
        );
        PatternList ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS = new PatternList("ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS", ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) > plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS)
           || plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) > plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_155() {

        // Southern-Central Appalachian Mesic Forest LC (M883)
        // Southern-Central Appalachian Mesic Forest LC (M883)

        String level = "macrogroup";
        String code = "Southern-Central Appalachian Mesic Forest LC (M883)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_156() {

        // Eastern North American Ruderal Forest & Woodlands
        // Eastern Cool Temperate Ruderal Forest & Woodlands

        String level = "informal";
        String code = "Eastern Cool Temperate Ruderal Forest & Woodlands";

        // Tree composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new KeyValue("ruderal", "Y")
        );
        List<KeyValue> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new KeyValue("exotic", "Y")
        );
        List<List<KeyValue>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) >= 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_157() {

        // Eastern North American Ruderal Forest (M013)
        // Eastern North American Ruderal Forest (M013)

        String level = "macrogroup";
        String code = "Eastern North American Ruderal Forest (M013)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

}
