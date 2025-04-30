package nvcs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

import nvcs_components.ClassificationKey;
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

        nodes = new LinkedHashMap<>();
        root_node = _setup();
        super.root_node = root_node;
    }

    public Node _setup() {
        nodes.put(0, new Node(0, null, element_000(), ""));
        nodes.put(  1,  new Node(  1,   0, element_001(), "Forest Plantations"));
        nodes.put(  2,  new Node(  2,   1, element_002(), "Tropical Forest Plantation Cultural Group"));
        nodes.put(  3,  new Node(  3,   2, element_003(), "Caribbean Forest Plantation Cultural Subgroup (CSG008)"));
        nodes.put(  4,  new Node(  4,   3, element_004(), "Caribbean Conifer Plantations"));
        nodes.put(  5,  new Node(  5,   4, element_005(), "Native Caribbean Conifer Plantation Cultural Type (CTY001)"));
        nodes.put(  6,  new Node(  6,   4, element_006(), "Exotic Caribbean Conifer Plantation Cultural Type (CTY002)"));
        nodes.put(  7,  new Node(  7,   3, element_007(), "Caribbean Hardwood Plantations"));
        nodes.put(  8,  new Node(  8,   7, element_008(), "Native Caribbean Hardwood Plantation Cultural Type (CTY003)"));
        nodes.put(  9,  new Node(  9,   7, element_009(), "Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)"));
        nodes.put( 10,  new Node( 10,   3, element_010(), "Miscellaneous Caribbean Plantation Cultural Type (CTYP19)"));
        nodes.put( 11,  new Node( 11,   1, element_011(), "Temperate & Boreal Forest Plantation Cultural Group (CGR007)"));
        nodes.put( 12,  new Node( 12,  11, element_012(), "Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)"));
        nodes.put( 13,  new Node( 13,  12, element_013(), "Eastern North American Conifer Plantations"));
        nodes.put( 14,  new Node( 14,  13, element_014(), "Native Eastern North American Conifer Plantations"));
        nodes.put( 15,  new Node( 15,  14, element_015(), "Native Southern Pine Plantation Cultural Type (CTY012)"));
        nodes.put( 16,  new Node( 16,  15, element_016(), "Shortleaf Pine Forest Plantation (CST007169)"));
        nodes.put( 17,  new Node( 17,  15, element_017(), "Longleaf Pine Forest Plantation (CST007176)"));
        nodes.put( 18,  new Node( 18,  15, element_018(), "Slash Pine Forest Plantation (CST007170)"));
        nodes.put( 19,  new Node( 19,  15, element_019(), "Loblolly Pine Forest Plantation (CST007179)"));
        nodes.put( 20,  new Node( 20,  15, element_020(), "Sand Pine Forest Plantation (CST007168)"));
        nodes.put( 21,  new Node( 21,  15, element_021(), "Native Miscellaneous Southern Pine Forest Plantation (CST007160)"));
        nodes.put( 22,  new Node( 22,  14, element_022(), "Native Northern Conifer Plantation"));
        nodes.put( 23,  new Node( 23,  22, element_023(), "Native Northern Pine Plantation Cultural Type (CTY009)"));
        nodes.put( 24,  new Node( 24,  23, element_024(), "Red Pine Forest Plantation (CST007117)"));
        nodes.put( 25,  new Node( 25,  23, element_025(), "White Pine Forest Plantation (CST007178)"));
        nodes.put( 26,  new Node( 26,  23, element_026(), "Jack Pine Forest Plantation (CST007161)"));
        nodes.put( 27,  new Node( 27,  23, element_027(), "Native Miscellaneous Northern Pine Forest Plantation"));
        nodes.put( 28,  new Node( 28,  22, element_028(), "Native Northern Spruce - Fir Plantation Cultural Type (CTY010)"));
        nodes.put( 29,  new Node( 29,  28, element_029(), "White Spruce Forest Plantation (CST007164)"));
        nodes.put( 30,  new Node( 30,  28, element_030(), "Balsam Fir Forest Plantation (CST007182)"));
        nodes.put( 31,  new Node( 31,  28, element_031(), "Red Spruce Forest Plantation (CST004758)"));
        nodes.put( 32,  new Node( 32,  28, element_032(), "Native Miscellaneous Northern Conifer Forest Plantation (CST007163)"));
        nodes.put( 33,  new Node( 33,  13, element_033(), "Exotic Eastern North American Conifer Plantations"));
        nodes.put( 34,  new Node( 34,  33, element_034(), "Exotic Northern Conifer Plantation Cultural Type (CTY014)"));
        nodes.put( 35,  new Node( 35,  34, element_035(), "Scotch Pine Exotic Forest Plantation (CST006313)"));
        nodes.put( 36,  new Node( 36,  34, element_036(), "Norway Spruce Forest Plantation (CST007167)"));
        nodes.put( 37,  new Node( 37,  34, element_037(), "Larch Forest Plantation (CST006408)"));
        nodes.put( 38,  new Node( 38,  34, element_038(), "Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)"));
        nodes.put( 39,  new Node( 39,  33, element_039(), "Exotic Southern Conifer Plantation Cultural Type (CTY015)"));
        nodes.put( 40,  new Node( 40,  39, element_040(), "Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)"));
        nodes.put( 41,  new Node( 41,  12, element_041(), "Eastern North American Hardwood Plantation"));
        nodes.put( 42,  new Node( 42,  41, element_042(), "Native Eastern North American Hardwood Plantations"));
        nodes.put( 43,  new Node( 43,  42, element_043(), "Native Northern Hardwood Forest Plantation Cultural Type (CTY016)"));
        nodes.put( 44,  new Node( 44,  43, element_044(), "Black Walnut Forest Plantation (CST007188)"));
        nodes.put( 45,  new Node( 45,  43, element_045(), "Aspen Forest Plantation (CST007189)"));
        nodes.put( 46,  new Node( 46,  43, element_046(), "Black Locust Forest Plantation (CST007190)"));
        nodes.put( 47,  new Node( 47,  43, element_047(), "Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)"));
        nodes.put( 48,  new Node( 48,  42, element_048(), "Native Southern Hardwood Forest Plantation Cultural Type (CTY017)"));
        nodes.put( 49,  new Node( 49,  48, element_049(), "Tuliptree Forest Plantation (CST007197)"));
        nodes.put( 50,  new Node( 50,  48, element_050(), "Sweetgum Forest Plantation Subtype (CST007450)"));
        nodes.put( 51,  new Node( 51,  48, element_051(), "Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)"));
        nodes.put( 52,  new Node( 52,  41, element_052(), "Exotic Eastern North American Hardwood Plantations"));
        nodes.put( 53,  new Node( 53,  52, element_053(), "Exotic Northern Hardwood Plantation Cultural Type (CTY018)"));
        nodes.put( 54,  new Node( 54,  52, element_054(), "Exotic Southern Hardwood Plantation Cultural Type (CTY019)"));
        nodes.put( 55,  new Node( 55,  11, element_055(), "North American Boreal Forest Plantation Cultural Subgroup"));
        nodes.put( 56,  new Node( 56,   0, element_056(), "Natural and Ruderal Forests"));
        nodes.put( 57,  new Node( 57,  56, element_057(), "Wetland Forest & Woodlands"));
        nodes.put( 58,  new Node( 58,  57, element_058(), "Caribbean Florida Wetland Forest"));
        nodes.put( 59,  new Node( 59,  58, element_059(), "Tropical Florida Natural Wetland Forest"));
        nodes.put( 60,  new Node( 60,  59, element_060(), "Caribbean Swamp Forest via tropical Florida (M617)"));
        nodes.put( 61,  new Node( 61,  59, element_061(), "Western Atlantic & Caribbean Mangrove (M005)"));
        nodes.put( 62,  new Node( 62,  58, element_062(), "Tropical Florida Ruderal Wetland Forest"));
        nodes.put( 63,  new Node( 63,  62, element_063(), "Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)"));
        nodes.put( 64,  new Node( 64,  57, element_064(), "Caribbean Wetland Forest"));
        nodes.put( 65,  new Node( 65,  64, element_065(), "Caribbean Natural Wetland Forest"));
        nodes.put( 66,  new Node( 66,  65, element_066(), "Caribbean Swamp Forest via wetland (M617)"));
        nodes.put( 67,  new Node( 67,  64, element_067(), "Caribbean Ruderal Wetland Forest"));
        nodes.put( 68,  new Node( 68,  57, element_068(), "Temperate & Boreal Wetland Forest"));
        nodes.put( 69,  new Node( 69,  68, element_069(), "Eastern North American Temperate & Boreal Wetland Forest"));
        nodes.put( 70,  new Node( 70,  69, element_070(), "Southeastern North American Flooded & Swamp Forest Division"));
        nodes.put( 71,  new Node( 71,  70, element_071(), "Eastern Warm Temperate Natural Wetland Forest"));
        nodes.put( 72,  new Node( 72,  71, element_072(), "Southern Great Plains Floodplain Forest & Woodland (M154)"));
        nodes.put( 73,  new Node( 73,  71, element_073(), "Pond-cypress Basin Swamp (M161)"));
        nodes.put( 74,  new Node( 74,  71, element_074(), "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)"));
        nodes.put( 75,  new Node( 75,  71, element_075(), "Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)"));
        nodes.put( 76,  new Node( 76,  71, element_076(), "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)"));
        nodes.put( 77,  new Node( 77,  71, element_077(), "Pond-cypress Basin Swamp LC (M161)"));
        nodes.put( 78,  new Node( 78,  71, element_078(), "Longleaf Pine Woodland LC2 (M007)"));
        nodes.put( 79,  new Node( 79,  71, element_079(), "Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)"));
        nodes.put( 80,  new Node( 80,  70, element_080(), "Eastern Warm Temperate Ruderal Wetland Forest"));
        nodes.put( 81,  new Node( 81,  80, element_081(), "Southeastern North American Ruderal Flooded & Swamp Forest (M310)"));
        nodes.put( 82,  new Node( 82,  69, element_082(), "Eastern Cool Temperate & North American Boreal Wetland Forest"));
        nodes.put( 83,  new Node( 83,  82, element_083(), "North American Boreal Flooded & Swamp Forest Division"));
        nodes.put( 84,  new Node( 84,  83, element_084(), "North American Boreal Natural Wetland Forest"));
        nodes.put( 85,  new Node( 85,  84, element_085(), "North American Boreal Conifer Poor Swamp (M299)"));
        nodes.put( 86,  new Node( 86,  84, element_086(), "North American Boreal Conifer Poor Swamp LC (M299)"));
        nodes.put( 87,  new Node( 87,  83, element_087(), "North American Boreal Ruderal Wetland Forest"));
        nodes.put( 88,  new Node( 88,  82, element_088(), "Eastern North American - Great Plains Flooded & Swamp Forest Division"));
        nodes.put( 89,  new Node( 89,  88, element_089(), "Eastern Cool Temperate Natural Wetland Forests"));
        nodes.put( 90,  new Node( 90,  89, element_090(), "Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)"));
        nodes.put( 91,  new Node( 91,  89, element_091(), "Central Hardwood Floodplain Forest (M029)"));
        nodes.put( 92,  new Node( 92,  89, element_092(), "Central Hardwood Swamp Forest (M503)"));
        nodes.put( 93,  new Node( 93,  89, element_093(), "Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)"));
        nodes.put( 94,  new Node( 94,  89, element_094(), "Central Hardwood Floodplain Forest LC (M029)"));
        nodes.put( 95,  new Node( 95,  89, element_095(), "Central Hardwood Swamp Forest LC (M503)"));
        nodes.put( 96,  new Node( 96,  88, element_096(), "Eastern Cool Temperate Ruderal Wetland Forests"));
        nodes.put( 97,  new Node( 97,  96, element_097(), "Eastern North American Ruderal Flooded & Swamp Forest (M302)"));
        nodes.put( 98,  new Node( 98,  56, element_098(), "Upland Forest & Woodlands"));
        nodes.put( 99,  new Node( 99,  98, element_099(), "Tropical Forest & Woodland Subclass"));
        nodes.put(100,  new Node(100,  99, element_100(), "Tropical Florida - Caribbean Forest"));
        nodes.put(101,  new Node(101, 100, element_101(), "Tropical Florida Forest"));
        nodes.put(102,  new Node(102, 101, element_102(), "Tropical Florida Natural Forest"));
        nodes.put(103,  new Node(103, 102, element_103(), "Caribbean Swamp Forest via upland (M617)"));
        nodes.put(104,  new Node(104, 102, element_104(), "Caribbean Coastal Lowland Dry Forest (M134)"));
        nodes.put(105,  new Node(105, 102, element_105(), "Caribbean Coastal Lowland Dry Forest LC (M134)"));
        nodes.put(106,  new Node(106, 101, element_106(), "Tropical Florida Ruderal Forest"));
        nodes.put(107,  new Node(107, 106, element_107(), "Caribbean Ruderal Dry Forest (M514)"));
        nodes.put(108,  new Node(108, 100, element_108(), "Caribbean Forest"));
        nodes.put(109,  new Node(109, 108, element_109(), "Caribbean Natural Forest"));
        nodes.put(110,  new Node(110, 109, element_110(), "Caribbean & Central American Dry Forests"));
        nodes.put(111,  new Node(111, 110, element_111(), "Caribbean-Mesoamerican Pine Forest (M296)"));
        nodes.put(112,  new Node(112, 110, element_112(), "Caribbean-Mesoamerican Pine Forest LC (M296)"));
        nodes.put(113,  new Node(113, 108, element_113(), "Caribbean Ruderal Forest"));
        nodes.put(114,  new Node(114, 113, element_107(), "Caribbean Ruderal Dry Forest (M514)"));
        nodes.put(115,  new Node(115,  98, element_114(), "Temperate & Boreal Forests"));
        nodes.put(116,  new Node(116, 115, element_115(), "Eastern North American Temperate & Boreal Forests"));
        nodes.put(117,  new Node(117, 116, element_116(), "Southeastern North American Forest & Woodland Division"));
        nodes.put(118,  new Node(118, 117, element_117(), "Southeastern Warm Temperate Natural Forests"));
        nodes.put(119,  new Node(119, 118, element_118(), "Southern & South-Central Oak - Pine Forest & Woodland (M016)"));
        nodes.put(120,  new Node(120, 118, element_119(), "Southern Mesic Mixed Broadleaf Forest (M008)"));
        nodes.put(121,  new Node(121, 118, element_120(), "Longleaf Pine Woodland (M007)"));
        nodes.put(122,  new Node(122, 118, element_121(), "Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)"));
        nodes.put(123,  new Node(123, 118, element_122(), "Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest LC (M885)"));
        nodes.put(124,  new Node(124, 118, element_123(), "Longleaf Pine Woodland LC1 (M007)"));
        nodes.put(125,  new Node(125, 118, element_124(), "Southern Mesic Mixed Broadleaf Forest LC (M008)"));
        nodes.put(126,  new Node(126, 117, element_125(), "Southeastern Warm Temperate Ruderal Forests"));
        nodes.put(127,  new Node(127, 126, element_126(), "Southeastern North American Ruderal Forest (M305)"));
        nodes.put(128,  new Node(128, 116, element_127(), "Eastern North American Forest & Woodland Division"));
        nodes.put(129,  new Node(129, 128, element_128(), "Eastern Cool Temperate Natural Forest & Woodlands"));
        nodes.put(130,  new Node(130, 129, element_129(), "Great Plains Forest & Woodland (M151)"));
        nodes.put(131,  new Node(131, 129, element_130(), "Northern Forest macrogroups"));
        nodes.put(132,  new Node(132, 131, element_131(), "Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)"));
        nodes.put(133,  new Node(133, 131, element_132(), "Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)"));
        nodes.put(134,  new Node(134, 131, element_133(), "Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)"));
        nodes.put(135,  new Node(135, 131, element_134(), "Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)"));
        nodes.put(136,  new Node(136, 129, element_135(), "Central Forest macrogroups"));
        nodes.put(137,  new Node(137, 136, element_136(), "Central Midwest Oak Forest, Woodland & Savanna (M012)"));
        nodes.put(138,  new Node(138, 136, element_137(), "Central Midwest Mesic Forest (M882)"));
        nodes.put(139,  new Node(139, 136, element_138(), "Central Midwest Oak Forest, Woodland & Savanna LC (M012)"));
        nodes.put(140,  new Node(140, 136, element_139(), "Central Midwest Mesic Forest LC (M882)"));
        nodes.put(141,  new Node(141, 136, element_140(), "Appalachian, Interior - Northeastern Mesic Forest (M883)"));
        nodes.put(142,  new Node(142, 136, element_141(), "Southern & South-Central Oak - Pine Forest & Woodland - Cool (M016)"));
        nodes.put(143,  new Node(143, 136, element_142(), "Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)"));
        nodes.put(144,  new Node(144, 136, element_143(), "Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)"));
        nodes.put(145,  new Node(145, 136, element_144(), "Southern & South-Central Oak - Pine Forest & Woodland LC (M016)"));
        nodes.put(146,  new Node(146, 136, element_145(), "Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)"));
        nodes.put(147,  new Node(147, 136, element_146(), "Appalachian, Interior - Northeastern Mesic Forest LC (M883)"));
        nodes.put(148,  new Node(148, 128, element_147(), "Eastern Cool Temperate Ruderal Forest & Woodlands"));
        nodes.put(149,  new Node(149, 148, element_148(), "Eastern North American Ruderal Forest (M013)"));

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

        // Forest Plantations
        // Forest Plantations

        String level = "division";
        String code = "Forest Plantations";

        // Vegetation shows evidence of intensive human management as planted vegetation,
        // such as trees being planted in rows, often dominated by single-species, and even
        // aged.  The stand is identified as planted in the FIA database (Stand Origin Code
        // = "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001)

        List<Pair<String,String>> PLANTATION_pattern0 = Arrays.asList(
            new Pair("plantation", "yes")
        );
        List<List<Pair<String,String>>> PLANTATION_patterns = Arrays.asList(
            PLANTATION_pattern0
        );
        PatternList PLANTATION = new PatternList("PLANTATION", PLANTATION_patterns);

        INodeMatch match = plot -> (
            plot.match(PLANTATION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_002() {

        // Tropical Forest Plantation Cultural Group
        // Tropical Forest Plantation Cultural Group

        String level = "group";
        String code = "Tropical Forest Plantation Cultural Group";

        // Conifer & Hardwood plantations found in the tropics, including Puerto Rico, U.S. Virgin Islands,
        // and tropical Florida (EcoSection 411A)

        List<Pair<String,String>> TROPICAL_LOCATION_pattern0 = Arrays.asList(
            new Pair("state", "PR")
        );
        List<Pair<String,String>> TROPICAL_LOCATION_pattern1 = Arrays.asList(
            new Pair("state", "VI")
        );
        List<Pair<String,String>> TROPICAL_LOCATION_pattern2 = Arrays.asList(
            new Pair("state", "FL"),
            new Pair("ecoregion", "411A")
        );
        List<List<Pair<String,String>>> TROPICAL_LOCATION_patterns = Arrays.asList(
            TROPICAL_LOCATION_pattern0,
            TROPICAL_LOCATION_pattern1,
            TROPICAL_LOCATION_pattern2
        );
        PatternList TROPICAL_LOCATION = new PatternList("TROPICAL_LOCATION", TROPICAL_LOCATION_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_LOCATION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_003() {

        // Caribbean Forest Plantation Cultural Subgroup (CSG008)
        // Caribbean Forest Plantation Cultural Subgroup (CSG008)

        String level = "subgroup";
        String code = "Caribbean Forest Plantation Cultural Subgroup (CSG008)";

        // Tropical forest plantations found in the Caribbean region,
        // including Puerto Rico, U.S. Virgin Islands, and tropical Florida (EcoSection 411A)

        List<Pair<String,String>> CARIBBEAN_pattern0 = Arrays.asList(
            new Pair("state", "PR")
        );
        List<Pair<String,String>> CARIBBEAN_pattern1 = Arrays.asList(
            new Pair("state", "VI")
        );
        List<Pair<String,String>> CARIBBEAN_pattern2 = Arrays.asList(
            new Pair("state", "FL"),
            new Pair("ecoregion", "411A")
        );
        List<List<Pair<String,String>>> CARIBBEAN_patterns = Arrays.asList(
            CARIBBEAN_pattern0,
            CARIBBEAN_pattern1,
            CARIBBEAN_pattern2
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

        String level = "type";
        String code = "Caribbean Conifer Plantations";

        // Caribbean species are conifers >=25% RIV

        List<Pair<String,String>> CONIFERS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "S")
        );
        List<List<Pair<String,String>>> CONIFERS_patterns = Arrays.asList(
            CONIFERS_pattern0
        );
        PatternList CONIFERS = new PatternList("CONIFERS", CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(CONIFERS) >= 25
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_005() {

        // Native Caribbean Conifer Plantation Cultural Type (CTY001)
        // Native Caribbean Conifer Plantation Cultural Type (CTY001)

        String level = "type";
        String code = "Native Caribbean Conifer Plantation Cultural Type (CTY001)";

        // Species of native conifers have > RIV than exotic species

        List<Pair<String,String>> NATIVE_CONIFERS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "S"),
            new Pair("exotic", "no")
        );
        List<List<Pair<String,String>>> NATIVE_CONIFERS_patterns = Arrays.asList(
            NATIVE_CONIFERS_pattern0
        );
        PatternList NATIVE_CONIFERS = new PatternList("NATIVE_CONIFERS", NATIVE_CONIFERS_patterns);

        List<Pair<String,String>> EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "S"),
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> EXOTIC_CONIFERS_patterns = Arrays.asList(
            EXOTIC_CONIFERS_pattern0
        );
        PatternList EXOTIC_CONIFERS = new PatternList("EXOTIC_CONIFERS", EXOTIC_CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_CONIFERS) > plot.riv(EXOTIC_CONIFERS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_006() {

        // Exotic Caribbean Conifer Plantation Cultural Type (CTY002)
        // Exotic Caribbean Conifer Plantation Cultural Type (CTY002)

        String level = "type";
        String code = "Exotic Caribbean Conifer Plantation Cultural Type (CTY002)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_007() {

        // Caribbean Hardwood Plantations
        // Caribbean Hardwood Plantations

        String level = "type";
        String code = "Caribbean Hardwood Plantations";

        // Caribbean species are hardwoods >=25% RIV

        List<Pair<String,String>> HARDWOODS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "H")
        );
        List<List<Pair<String,String>>> HARDWOODS_patterns = Arrays.asList(
            HARDWOODS_pattern0
        );
        PatternList HARDWOODS = new PatternList("HARDWOODS", HARDWOODS_patterns);

        INodeMatch match = plot -> (
            plot.riv(HARDWOODS) >= 25
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_008() {

        // Native Caribbean Hardwood Plantation Cultural Type (CTY003)
        // Native Caribbean Hardwood Plantation Cultural Type (CTY003)

        String level = "type";
        String code = "Native Caribbean Hardwood Plantation Cultural Type (CTY003)";

        // Species of native hardwoods have > RIV than exotic species

        List<Pair<String,String>> NATIVE_HARDWOODS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "H"),
            new Pair("exotic", "no")
        );
        List<List<Pair<String,String>>> NATIVE_HARDWOODS_patterns = Arrays.asList(
            NATIVE_HARDWOODS_pattern0
        );
        PatternList NATIVE_HARDWOODS = new PatternList("NATIVE_HARDWOODS", NATIVE_HARDWOODS_patterns);

        List<Pair<String,String>> EXOTIC_HARDWOODS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "H"),
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> EXOTIC_HARDWOODS_patterns = Arrays.asList(
            EXOTIC_HARDWOODS_pattern0
        );
        PatternList EXOTIC_HARDWOODS = new PatternList("EXOTIC_HARDWOODS", EXOTIC_HARDWOODS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_HARDWOODS) > plot.riv(EXOTIC_HARDWOODS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_009() {

        // Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)
        // Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)

        String level = "type";
        String code = "Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_010() {

        // Miscellaneous Caribbean Plantation Cultural Type (CTYP19)
        // Miscellaneous Caribbean Plantation Cultural Type (CTYP19)

        String level = "type";
        String code = "Miscellaneous Caribbean Plantation Cultural Type (CTYP19)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_011() {

        // Temperate & Boreal Forest Plantation Cultural Group (CGR007)
        // Temperate & Boreal Forest Plantation Cultural Group (CGR007)

        String level = "group";
        String code = "Temperate & Boreal Forest Plantation Cultural Group (CGR007)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_012() {

        // Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)
        // Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)

        String level = "subgroup";
        String code = "Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)";

        // Plantations found in eastern temperate region of North America (EcoProvince 210,
        // M210, 220, M220, 230, M230, 250, 310-Texas part only, and 330

        List<Pair<String,String>> EASTERN_TEMPERATE_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "210, M210, 220, M220, 230, M230, 250, 330")
        );
        List<Pair<String,String>> EASTERN_TEMPERATE_REGION_pattern1 = Arrays.asList(
            new Pair("ecoregion", "310"),
            new Pair("state", "TX")
        );
        List<List<Pair<String,String>>> EASTERN_TEMPERATE_REGION_patterns = Arrays.asList(
            EASTERN_TEMPERATE_REGION_pattern0,
            EASTERN_TEMPERATE_REGION_pattern1
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

        String level = "subgroup";
        String code = "Eastern North American Conifer Plantations";

        // Eastern North American species are conifers >=25% RIV

        List<Pair<String,String>> CONIFERS_pattern0 = Arrays.asList(
            new Pair("softwoodhardwood", "S")
        );
        List<List<Pair<String,String>>> CONIFERS_patterns = Arrays.asList(
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

        String level = "type";
        String code = "Native Eastern North American Conifer Plantations";

        // Tree species dominated by native conifers (See
        // Appendix A) with RIV > exotic conifers

        List<Pair<String,String>> NATIVE_CONIFERS_pattern0 = Arrays.asList(
            new Pair("exotic", "no"),
            new Pair("softwoodhardwood", "S")
        );
        List<List<Pair<String,String>>> NATIVE_CONIFERS_patterns = Arrays.asList(
            NATIVE_CONIFERS_pattern0
        );
        PatternList NATIVE_CONIFERS = new PatternList("NATIVE_CONIFERS", NATIVE_CONIFERS_patterns);

        List<Pair<String,String>> EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new Pair("exotic", "yes"),
            new Pair("softwoodhardwood", "S")
        );
        List<List<Pair<String,String>>> EXOTIC_CONIFERS_patterns = Arrays.asList(
            EXOTIC_CONIFERS_pattern0
        );
        PatternList EXOTIC_CONIFERS = new PatternList("EXOTIC_CONIFERS", EXOTIC_CONIFERS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_CONIFERS) > plot.riv(EXOTIC_CONIFERS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_015() {

        // Native Southern Pine Plantation Cultural Type (CTY012)
        // Native Southern Pine Plantation Cultural Type (CTY012)

        String level = "type";
        String code = "Native Southern Pine Plantation Cultural Type (CTY012)";

        //  i. Species are native conifers Pinus spp. with >=25% RIV:  Pinus echinata, Pinus elliottii,
        //     Pinus palustris, Pinus taeda, Pinus clausa. [note - this list represents the expected
        //     list of common southern native pine plantation species types.  If other common native
        //     pine plantationspecies are identified, they should be added to this list and
        //     additional couplets added below]
        // OR
        // ii. Species are native conifers found in ecoregion divisions 230, M230, 310 and
        //     ecoprovince 255

        List<Pair<String,String>> SOUTHERN_PINES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> SOUTHERN_PINES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> SOUTHERN_PINES_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<Pair<String,String>> SOUTHERN_PINES_pattern3 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> SOUTHERN_PINES_pattern4 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<List<Pair<String,String>>> SOUTHERN_PINES_patterns = Arrays.asList(
            SOUTHERN_PINES_pattern0,
            SOUTHERN_PINES_pattern1,
            SOUTHERN_PINES_pattern2,
            SOUTHERN_PINES_pattern3,
            SOUTHERN_PINES_pattern4
        );
        PatternList SOUTHERN_PINES = new PatternList("SOUTHERN_PINES", SOUTHERN_PINES_patterns);

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "230, M230, 310, 255")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
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

        List<Pair<String,String>> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<List<Pair<String,String>>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<Pair<String,String>> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<Pair<String,String>> SLASH_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<List<Pair<String,String>>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<Pair<String,String>> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<Pair<String,String>> SAND_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<List<Pair<String,String>>> SAND_PINE_patterns = Arrays.asList(
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

        List<Pair<String,String>> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<List<Pair<String,String>>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<Pair<String,String>> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<Pair<String,String>> SLASH_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<List<Pair<String,String>>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<Pair<String,String>> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<Pair<String,String>> SAND_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<List<Pair<String,String>>> SAND_PINE_patterns = Arrays.asList(
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

        List<Pair<String,String>> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<List<Pair<String,String>>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<Pair<String,String>> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<Pair<String,String>> SLASH_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<List<Pair<String,String>>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<Pair<String,String>> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<Pair<String,String>> SAND_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<List<Pair<String,String>>> SAND_PINE_patterns = Arrays.asList(
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
        // Loblolly Pine Forest Plantation (CST007179)

        String level = "subtype";
        String code = "Loblolly Pine Forest Plantation (CST007179)";

        // Tree composition dominated by Pinus taeda; i.e. Pinus taeda >= 25% RIV,
        // and exceeds each species of Pinus echinta, Pinus elliottii, Pinus clausa or Pinus palustris

        List<Pair<String,String>> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<List<Pair<String,String>>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<Pair<String,String>> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<Pair<String,String>> SLASH_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<List<Pair<String,String>>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<Pair<String,String>> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<Pair<String,String>> SAND_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<List<Pair<String,String>>> SAND_PINE_patterns = Arrays.asList(
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

        List<Pair<String,String>> SHORTLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<List<Pair<String,String>>> SHORTLEAF_PINE_patterns = Arrays.asList(
            SHORTLEAF_PINE_pattern0
        );
        PatternList SHORTLEAF_PINE = new PatternList("SHORTLEAF_PINE", SHORTLEAF_PINE_patterns);

        List<Pair<String,String>> LONGLEAF_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> LONGLEAF_PINE_patterns = Arrays.asList(
            LONGLEAF_PINE_pattern0
        );
        PatternList LONGLEAF_PINE = new PatternList("LONGLEAF_PINE", LONGLEAF_PINE_patterns);

        List<Pair<String,String>> SLASH_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<List<Pair<String,String>>> SLASH_PINE_patterns = Arrays.asList(
            SLASH_PINE_pattern0
        );
        PatternList SLASH_PINE = new PatternList("SLASH_PINE", SLASH_PINE_patterns);

        List<Pair<String,String>> LOBLOLLY_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> LOBLOLLY_PINE_patterns = Arrays.asList(
            LOBLOLLY_PINE_pattern0
        );
        PatternList LOBLOLLY_PINE = new PatternList("LOBLOLLY_PINE", LOBLOLLY_PINE_patterns);

        List<Pair<String,String>> SAND_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<List<Pair<String,String>>> SAND_PINE_patterns = Arrays.asList(
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

        String level = "type";
        String code = "Native Northern Conifer Plantation";

        //  i. Species are native conifers dominated by one or more of the following with >=25% RIV:
        //     Pinus banksiana, Pinus resinosa, Pinus strobus, Abies balsamea, Larix laricina, Picea glauca,
        //     or Picea mariana [note - this list represents the expected list of common northern native pine
        //     plantation species types. If other common native pine plantation species are identified, they
        //     should be added to this list and additional couplets added below]
        // OR
        // ii. Species not as above, but found in ecoregion divisions 211, M211, 212, 221, M221, 222,
        //     M222, 251, 223, M223, 231, M231

        List<Pair<String,String>> NORTHERN_PINES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> NORTHERN_PINES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> NORTHERN_PINES_pattern2 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> NORTHERN_PINES_pattern3 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> NORTHERN_PINES_pattern4 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> NORTHERN_PINES_pattern5 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<Pair<String,String>> NORTHERN_PINES_pattern6 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<List<Pair<String,String>>> NORTHERN_PINES_patterns = Arrays.asList(
            NORTHERN_PINES_pattern0,
            NORTHERN_PINES_pattern1,
            NORTHERN_PINES_pattern2,
            NORTHERN_PINES_pattern3,
            NORTHERN_PINES_pattern4,
            NORTHERN_PINES_pattern5,
            NORTHERN_PINES_pattern6
        );
        PatternList NORTHERN_PINES = new PatternList("NORTHERN_PINES", NORTHERN_PINES_patterns);

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "211, M211, 212, 221, M221, 222, M222, 251, 223, M223, 231, M231")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NORTHERN_PINES) >= 25 || plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_023() {

        // Native Northern Pine Plantation Cultural Type (CTY009)
        // Native Northern Pine Plantation Cultural Type (CTY009)

        String level = "type";
        String code = "Native Northern Pine Plantation Cultural Type (CTY009)";

        // Native pine species of Pinus spp. [Pinus spp not E = Exotic] exceed non-pine conifers (Native Pinus spp >=50% RIV)

        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus caribaea")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern2 = Arrays.asList(
            new Pair("species", "Pinus cembroides")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern3 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern4 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern5 = Arrays.asList(
            new Pair("species", "Pinus edulis")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern6 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern7 = Arrays.asList(
            new Pair("species", "Pinus elliottii var. elliottii")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern8 = Arrays.asList(
            new Pair("species", "Pinus flexilis")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern9 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern10 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern11 = Arrays.asList(
            new Pair("species", "Pinus pungens")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern12 = Arrays.asList(
            new Pair("species", "Pinus remota")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern13 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern14 = Arrays.asList(
            new Pair("species", "Pinus rigida")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern15 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern16 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern17 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> NATIVE_NORTHERN_PINES_pattern18 = Arrays.asList(
            new Pair("species", "Pinus virginiana")
        );
        List<List<Pair<String,String>>> NATIVE_NORTHERN_PINES_patterns = Arrays.asList(
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

        List<Pair<String,String>> RED_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<List<Pair<String,String>>> RED_PINE_patterns = Arrays.asList(
            RED_PINE_pattern0
        );
        PatternList RED_PINE = new PatternList("RED_PINE", RED_PINE_patterns);

        List<Pair<String,String>> JACK_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<List<Pair<String,String>>> JACK_PINE_patterns = Arrays.asList(
            JACK_PINE_pattern0
        );
        PatternList JACK_PINE = new PatternList("JACK_PINE", JACK_PINE_patterns);

        List<Pair<String,String>> WHITE_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<List<Pair<String,String>>> WHITE_PINE_patterns = Arrays.asList(
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

        List<Pair<String,String>> WHITE_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<List<Pair<String,String>>> WHITE_PINE_patterns = Arrays.asList(
            WHITE_PINE_pattern0
        );
        PatternList WHITE_PINE = new PatternList("WHITE_PINE", WHITE_PINE_patterns);

        List<Pair<String,String>> RED_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<List<Pair<String,String>>> RED_PINE_patterns = Arrays.asList(
            RED_PINE_pattern0
        );
        PatternList RED_PINE = new PatternList("RED_PINE", RED_PINE_patterns);

        List<Pair<String,String>> JACK_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<List<Pair<String,String>>> JACK_PINE_patterns = Arrays.asList(
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

        List<Pair<String,String>> JACK_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<List<Pair<String,String>>> JACK_PINE_patterns = Arrays.asList(
            JACK_PINE_pattern0
        );
        PatternList JACK_PINE = new PatternList("JACK_PINE", JACK_PINE_patterns);

        List<Pair<String,String>> RED_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<List<Pair<String,String>>> RED_PINE_patterns = Arrays.asList(
            RED_PINE_pattern0
        );
        PatternList RED_PINE = new PatternList("RED_PINE", RED_PINE_patterns);

        List<Pair<String,String>> WHITE_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<List<Pair<String,String>>> WHITE_PINE_patterns = Arrays.asList(
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

        // Native Northern Spruce - Fir Plantation Cultural Type (CTY010)
        // Native Northern Spruce - Fir Plantation Cultural Type (CTY010)

        String level = "type";
        String code = "Native Northern Spruce - Fir Plantation Cultural Type (CTY010)";

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

        List<Pair<String,String>> WHITE_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<List<Pair<String,String>>> WHITE_SPRUCE_patterns = Arrays.asList(
            WHITE_SPRUCE_pattern0
        );
        PatternList WHITE_SPRUCE = new PatternList("WHITE_SPRUCE", WHITE_SPRUCE_patterns);

        List<Pair<String,String>> BALSAM_FIR_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<List<Pair<String,String>>> BALSAM_FIR_patterns = Arrays.asList(
            BALSAM_FIR_pattern0
        );
        PatternList BALSAM_FIR = new PatternList("BALSAM_FIR", BALSAM_FIR_patterns);

        List<Pair<String,String>> NATIVE_TAMARACK_pattern0 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<List<Pair<String,String>>> NATIVE_TAMARACK_patterns = Arrays.asList(
            NATIVE_TAMARACK_pattern0
        );
        PatternList NATIVE_TAMARACK = new PatternList("NATIVE_TAMARACK", NATIVE_TAMARACK_patterns);

        List<Pair<String,String>> RED_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<List<Pair<String,String>>> RED_SPRUCE_patterns = Arrays.asList(
            RED_SPRUCE_pattern0
        );
        PatternList RED_SPRUCE = new PatternList("RED_SPRUCE", RED_SPRUCE_patterns);

        List<Pair<String,String>> BLACK_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<List<Pair<String,String>>> BLACK_SPRUCE_patterns = Arrays.asList(
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

        List<Pair<String,String>> BALSAM_FIR_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<List<Pair<String,String>>> BALSAM_FIR_patterns = Arrays.asList(
            BALSAM_FIR_pattern0
        );
        PatternList BALSAM_FIR = new PatternList("BALSAM_FIR", BALSAM_FIR_patterns);

        List<Pair<String,String>> NATIVE_TAMARACK_pattern0 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<List<Pair<String,String>>> NATIVE_TAMARACK_patterns = Arrays.asList(
            NATIVE_TAMARACK_pattern0
        );
        PatternList NATIVE_TAMARACK = new PatternList("NATIVE_TAMARACK", NATIVE_TAMARACK_patterns);

        List<Pair<String,String>> RED_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<List<Pair<String,String>>> RED_SPRUCE_patterns = Arrays.asList(
            RED_SPRUCE_pattern0
        );
        PatternList RED_SPRUCE = new PatternList("RED_SPRUCE", RED_SPRUCE_patterns);

        List<Pair<String,String>> WHITE_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<List<Pair<String,String>>> WHITE_SPRUCE_patterns = Arrays.asList(
            WHITE_SPRUCE_pattern0
        );
        PatternList WHITE_SPRUCE = new PatternList("WHITE_SPRUCE", WHITE_SPRUCE_patterns);

        List<Pair<String,String>> BLACK_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<List<Pair<String,String>>> BLACK_SPRUCE_patterns = Arrays.asList(
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

        List<Pair<String,String>> BALSAM_FIR_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<List<Pair<String,String>>> BALSAM_FIR_patterns = Arrays.asList(
            BALSAM_FIR_pattern0
        );
        PatternList BALSAM_FIR = new PatternList("BALSAM_FIR", BALSAM_FIR_patterns);

        List<Pair<String,String>> NATIVE_TAMARACK_pattern0 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<List<Pair<String,String>>> NATIVE_TAMARACK_patterns = Arrays.asList(
            NATIVE_TAMARACK_pattern0
        );
        PatternList NATIVE_TAMARACK = new PatternList("NATIVE_TAMARACK", NATIVE_TAMARACK_patterns);

        List<Pair<String,String>> RED_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<List<Pair<String,String>>> RED_SPRUCE_patterns = Arrays.asList(
            RED_SPRUCE_pattern0
        );
        PatternList RED_SPRUCE = new PatternList("RED_SPRUCE", RED_SPRUCE_patterns);

        List<Pair<String,String>> WHITE_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<List<Pair<String,String>>> WHITE_SPRUCE_patterns = Arrays.asList(
            WHITE_SPRUCE_pattern0
        );
        PatternList WHITE_SPRUCE = new PatternList("WHITE_SPRUCE", WHITE_SPRUCE_patterns);

        List<Pair<String,String>> BLACK_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<List<Pair<String,String>>> BLACK_SPRUCE_patterns = Arrays.asList(
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

        String level = "type";
        String code = "Exotic Eastern North American Conifer Plantations";

        // Tree species are dominated by exotic conifers (See
        // Appendix A) with RIV > native conifers.  Implemented as NOT native conifers.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_034() {

        // Exotic Northern Conifer Plantation Cultural Type (CTY014)
        // Exotic Northern Conifer Plantation Cultural Type (CTY014)

        String level = "type";
        String code = "Exotic Northern Conifer Plantation Cultural Type (CTY014)";

        // Exotic conifer tree species dominated by Pinus sylvestris,
        // Picea abies, Larix decidua (not used by FIA), or Larix spp. alone or in
        // combination >=25% RIV or stand found in ecodivisions 210, M210, 220, M220,
        // 330 and ecoprovince 251 [note - this list represents the expected list of
        // common exotic conifer plantation species types.  If other common exotic
        // conifer plantation species are identified, they should be added to this list
        // and additional couplets added below].

        List<Pair<String,String>> COMMON_EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus sylvestris")
        );
        List<Pair<String,String>> COMMON_EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new Pair("species", "Picea abies")
        );
        List<Pair<String,String>> COMMON_EXOTIC_CONIFERS_pattern2 = Arrays.asList(
            new Pair("species", "Larix spp.")
        );
        List<List<Pair<String,String>>> COMMON_EXOTIC_CONIFERS_patterns = Arrays.asList(
            COMMON_EXOTIC_CONIFERS_pattern0,
            COMMON_EXOTIC_CONIFERS_pattern1,
            COMMON_EXOTIC_CONIFERS_pattern2
        );
        PatternList COMMON_EXOTIC_CONIFERS = new PatternList("COMMON_EXOTIC_CONIFERS", COMMON_EXOTIC_CONIFERS_patterns);

        List<Pair<String,String>> NORTHERN_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "210, M210, 220, M220, 330, 251")
        );
        List<List<Pair<String,String>>> NORTHERN_REGION_patterns = Arrays.asList(
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

        List<Pair<String,String>> SCOTCH_PINE_pattern0 = Arrays.asList(
            new Pair("species", "Pinus sylvestris")
        );
        List<List<Pair<String,String>>> SCOTCH_PINE_patterns = Arrays.asList(
            SCOTCH_PINE_pattern0
        );
        PatternList SCOTCH_PINE = new PatternList("SCOTCH_PINE", SCOTCH_PINE_patterns);

        List<Pair<String,String>> NORWAY_SPRUCE_LARCH_pattern0 = Arrays.asList(
            new Pair("species", "Picea abies")
        );
        List<Pair<String,String>> NORWAY_SPRUCE_LARCH_pattern1 = Arrays.asList(
            new Pair("species", "Larix spp.")
        );
        List<List<Pair<String,String>>> NORWAY_SPRUCE_LARCH_patterns = Arrays.asList(
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

        List<Pair<String,String>> NORWAY_SPRUCE_pattern0 = Arrays.asList(
            new Pair("species", "Picea abies")
        );
        List<List<Pair<String,String>>> NORWAY_SPRUCE_patterns = Arrays.asList(
            NORWAY_SPRUCE_pattern0
        );
        PatternList NORWAY_SPRUCE = new PatternList("NORWAY_SPRUCE", NORWAY_SPRUCE_patterns);

        List<Pair<String,String>> OTHER_EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus sylvestris")
        );
        List<Pair<String,String>> OTHER_EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new Pair("species", "Larix spp.")
        );
        List<List<Pair<String,String>>> OTHER_EXOTIC_CONIFERS_patterns = Arrays.asList(
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

        List<Pair<String,String>> LARIX_SPP_pattern0 = Arrays.asList(
            new Pair("species", "Larix spp.")
        );
        List<List<Pair<String,String>>> LARIX_SPP_patterns = Arrays.asList(
            LARIX_SPP_pattern0
        );
        PatternList LARIX_SPP = new PatternList("LARIX_SPP", LARIX_SPP_patterns);

        List<Pair<String,String>> OTHER_EXOTIC_CONIFERS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus sylvestris")
        );
        List<Pair<String,String>> OTHER_EXOTIC_CONIFERS_pattern1 = Arrays.asList(
            new Pair("species", "Picea abies")
        );
        List<List<Pair<String,String>>> OTHER_EXOTIC_CONIFERS_patterns = Arrays.asList(
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

        // Exotic Southern Conifer Plantation Cultural Type (CTY015)
        // Exotic Southern Conifer Plantation Cultural Type (CTY015)

        String level = "type";
        String code = "Exotic Southern Conifer Plantation Cultural Type (CTY015)";

        // Tree species not as above.  Stands found in ecodivisions 230,
        // M230, 310 and ecoprovince 255. [note -if there are common exotic conifer
        // plantation species types in the south, they should be listed here, and
        // additional couplets added below].

        List<Pair<String,String>> SOUTHERN_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "230, M230, 310, 255")
        );
        List<List<Pair<String,String>>> SOUTHERN_REGION_patterns = Arrays.asList(
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

        String level = "type";
        String code = "Native Eastern North American Hardwood Plantations";

        // Tree species dominated by native hardwoods (See
        // Appendix A) with RIV > exotic hardwoods.

        List<Pair<String,String>> NATIVE_HARDWOODS_pattern0 = Arrays.asList(
            new Pair("exotic", "no"),
            new Pair("softwoodhardwood", "H")
        );
        List<List<Pair<String,String>>> NATIVE_HARDWOODS_patterns = Arrays.asList(
            NATIVE_HARDWOODS_pattern0
        );
        PatternList NATIVE_HARDWOODS = new PatternList("NATIVE_HARDWOODS", NATIVE_HARDWOODS_patterns);

        List<Pair<String,String>> EXOTIC_HARDWOODS_pattern0 = Arrays.asList(
            new Pair("exotic", "yes"),
            new Pair("softwoodhardwood", "H")
        );
        List<List<Pair<String,String>>> EXOTIC_HARDWOODS_patterns = Arrays.asList(
            EXOTIC_HARDWOODS_pattern0
        );
        PatternList EXOTIC_HARDWOODS = new PatternList("EXOTIC_HARDWOODS", EXOTIC_HARDWOODS_patterns);

        INodeMatch match = plot -> (
            plot.riv(NATIVE_HARDWOODS) > plot.riv(EXOTIC_HARDWOODS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_043() {

        // Native Northern Hardwood Forest Plantation Cultural Type (CTY016)
        // Native Northern Hardwood Forest Plantation Cultural Type (CTY016)

        String level = "type";
        String code = "Native Northern Hardwood Forest Plantation Cultural Type (CTY016)";

        // Stands found in ecodivisions 210, M210, 220, M220, 330 and ecoprovince 251.

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "210, M210, 220, M220, 330, 251")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
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

        List<Pair<String,String>> BLACK_WALNUT_pattern0 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<List<Pair<String,String>>> BLACK_WALNUT_patterns = Arrays.asList(
            BLACK_WALNUT_pattern0
        );
        PatternList BLACK_WALNUT = new PatternList("BLACK_WALNUT", BLACK_WALNUT_patterns);

        List<Pair<String,String>> QUAKING_ASPEN_pattern0 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<List<Pair<String,String>>> QUAKING_ASPEN_patterns = Arrays.asList(
            QUAKING_ASPEN_pattern0
        );
        PatternList QUAKING_ASPEN = new PatternList("QUAKING_ASPEN", QUAKING_ASPEN_patterns);

        List<Pair<String,String>> POPULUS_SPP_pattern0 = Arrays.asList(
            new Pair("species", "Populus spp.")
        );
        List<List<Pair<String,String>>> POPULUS_SPP_patterns = Arrays.asList(
            POPULUS_SPP_pattern0
        );
        PatternList POPULUS_SPP = new PatternList("POPULUS_SPP", POPULUS_SPP_patterns);

        List<Pair<String,String>> BLACK_LOCUST_pattern0 = Arrays.asList(
            new Pair("species", "Robinia pseudoacacia")
        );
        List<List<Pair<String,String>>> BLACK_LOCUST_patterns = Arrays.asList(
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

        List<Pair<String,String>> ASPEN_pattern0 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> ASPEN_pattern1 = Arrays.asList(
            new Pair("species", "Populus spp.")
        );
        List<List<Pair<String,String>>> ASPEN_patterns = Arrays.asList(
            ASPEN_pattern0,
            ASPEN_pattern1
        );
        PatternList ASPEN = new PatternList("ASPEN", ASPEN_patterns);

        List<Pair<String,String>> BLACK_WALNUT_pattern0 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<List<Pair<String,String>>> BLACK_WALNUT_patterns = Arrays.asList(
            BLACK_WALNUT_pattern0
        );
        PatternList BLACK_WALNUT = new PatternList("BLACK_WALNUT", BLACK_WALNUT_patterns);

        List<Pair<String,String>> BLACK_LOCUST_pattern0 = Arrays.asList(
            new Pair("species", "Robinia pseudoacacia")
        );
        List<List<Pair<String,String>>> BLACK_LOCUST_patterns = Arrays.asList(
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

        List<Pair<String,String>> BLACK_LOCUST_pattern0 = Arrays.asList(
            new Pair("species", "Robinia pseudoacacia")
        );
        List<List<Pair<String,String>>> BLACK_LOCUST_patterns = Arrays.asList(
            BLACK_LOCUST_pattern0
        );
        PatternList BLACK_LOCUST = new PatternList("BLACK_LOCUST", BLACK_LOCUST_patterns);

        List<Pair<String,String>> BLACK_WALNUT_pattern0 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<List<Pair<String,String>>> BLACK_WALNUT_patterns = Arrays.asList(
            BLACK_WALNUT_pattern0
        );
        PatternList BLACK_WALNUT = new PatternList("BLACK_WALNUT", BLACK_WALNUT_patterns);

        List<Pair<String,String>> QUAKING_ASPEN_pattern0 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<List<Pair<String,String>>> QUAKING_ASPEN_patterns = Arrays.asList(
            QUAKING_ASPEN_pattern0
        );
        PatternList QUAKING_ASPEN = new PatternList("QUAKING_ASPEN", QUAKING_ASPEN_patterns);

        List<Pair<String,String>> POPULUS_SPP_pattern0 = Arrays.asList(
            new Pair("species", "Populus spp.")
        );
        List<List<Pair<String,String>>> POPULUS_SPP_patterns = Arrays.asList(
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

        // Native Southern Hardwood Forest Plantation Cultural Type (CTY017)
        // Native Southern Hardwood Forest Plantation Cultural Type (CTY017)

        String level = "type";
        String code = "Native Southern Hardwood Forest Plantation Cultural Type (CTY017)";

        // Stands found in ecodivisions 230, M230, 310 and ecoprovince 255.

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "230, M230, 310, 255")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
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

        List<Pair<String,String>> TULIPTREE_pattern0 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<List<Pair<String,String>>> TULIPTREE_patterns = Arrays.asList(
            TULIPTREE_pattern0
        );
        PatternList TULIPTREE = new PatternList("TULIPTREE", TULIPTREE_patterns);

        List<Pair<String,String>> SWEETGUM_pattern0 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<List<Pair<String,String>>> SWEETGUM_patterns = Arrays.asList(
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

        List<Pair<String,String>> SWEETGUM_pattern0 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<List<Pair<String,String>>> SWEETGUM_patterns = Arrays.asList(
            SWEETGUM_pattern0
        );
        PatternList SWEETGUM = new PatternList("SWEETGUM", SWEETGUM_patterns);

        List<Pair<String,String>> TULIPTREE_pattern0 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<List<Pair<String,String>>> TULIPTREE_patterns = Arrays.asList(
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

        String level = "type";
        String code = "Exotic Eastern North American Hardwood Plantations";

        // Tree species dominated by exotic hardwoods (See Appendix A) with RIV > native hardwoods.
        // Implemented as NOT native RIV > exotic RIV.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_053() {

        // Exotic Northern Hardwood Plantation Cultural Type (CTY018)
        // Exotic Northern Hardwood Plantation Cultural Type (CTY018)

        String level = "type";
        String code = "Exotic Northern Hardwood Plantation Cultural Type (CTY018)";

        // Exotic hardwood tree species found in ecodivisions 210, M210, 220, M220, 330
        // and ecoprovince 251. [note - no exotic hardwoods are known to be commonly planted.
        // If common exotic hardwood plantation species are identified, they should be added to
        // this list and additional couplets added below].

        List<Pair<String,String>> NORTHERN_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "210, M210, 220, M220, 330, 251")
        );
        List<List<Pair<String,String>>> NORTHERN_REGION_patterns = Arrays.asList(
            NORTHERN_REGION_pattern0
        );
        PatternList NORTHERN_REGION = new PatternList("NORTHERN_REGION", NORTHERN_REGION_patterns);

        INodeMatch match = plot -> (
            plot.match(NORTHERN_REGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_054() {

        // Exotic Southern Hardwood Plantation Cultural Type (CTY019)
        // Exotic Southern Hardwood Plantation Cultural Type (CTY019)

        String level = "type";
        String code = "Exotic Southern Hardwood Plantation Cultural Type (CTY019)";

        // Tree species not as above.  Stands found in ecodivisions 230,
        // M230, 310 and ecoprovince 255. [note -if there are common exotic hardwood
        // plantation species types in the south, they should be listed here, and
        // additional couplets added below].

        List<Pair<String,String>> SOUTHERN_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "230, M230, 310, 255")
        );
        List<List<Pair<String,String>>> SOUTHERN_REGION_patterns = Arrays.asList(
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

        List<Pair<String,String>> BOREAL_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "100")
        );
        List<List<Pair<String,String>>> BOREAL_REGION_patterns = Arrays.asList(
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

        String level = "division";
        String code = "Natural and Ruderal Forests";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_057() {

        // Wetland Forest & Woodlands
        // Wetland Forest & Woodlands

        String level = "division";
        String code = "Wetland Forest & Woodlands";

        //   i. The "physiographic class code" in FIA database is NOT in the Hydric or Riverine series, AND EITHER
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

        List<Pair<String,String>> HYDRIC_OR_RIVERINE_pattern0 = Arrays.asList(
            new Pair("hydric", "yes")
        );
        List<Pair<String,String>> HYDRIC_OR_RIVERINE_pattern1 = Arrays.asList(
            new Pair("riverine", "yes")
        );
        List<List<Pair<String,String>>> HYDRIC_OR_RIVERINE_patterns = Arrays.asList(
            HYDRIC_OR_RIVERINE_pattern0,
            HYDRIC_OR_RIVERINE_pattern1
        );
        PatternList HYDRIC_OR_RIVERINE = new PatternList("HYDRIC_OR_RIVERINE", HYDRIC_OR_RIVERINE_patterns);

        List<Pair<String,String>> W1_pattern0 = Arrays.asList(
            new Pair("wetland", "obl")
        );
        List<List<Pair<String,String>>> W1_patterns = Arrays.asList(
            W1_pattern0
        );
        PatternList W1 = new PatternList("W1", W1_patterns);

        List<Pair<String,String>> W2_pattern0 = Arrays.asList(
            new Pair("wetland", "facw")
        );
        List<List<Pair<String,String>>> W2_patterns = Arrays.asList(
            W2_pattern0
        );
        PatternList W2 = new PatternList("W2", W2_patterns);

        List<Pair<String,String>> W3_pattern0 = Arrays.asList(
            new Pair("wetland", "fac")
        );
        List<List<Pair<String,String>>> W3_patterns = Arrays.asList(
            W3_pattern0
        );
        PatternList W3 = new PatternList("W3", W3_patterns);

        List<Pair<String,String>> WETLAND_pattern0 = Arrays.asList(
            new Pair("wetland", "obl, facw"),
            new Pair("exotic", "no")
        );
        List<List<Pair<String,String>>> WETLAND_patterns = Arrays.asList(
            WETLAND_pattern0
        );
        PatternList WETLAND = new PatternList("WETLAND", WETLAND_patterns);

        List<Pair<String,String>> UPLAND_pattern0 = Arrays.asList(
            new Pair("wetland", "upl"),
            new Pair("exotic", "no")
        );
        List<List<Pair<String,String>>> UPLAND_patterns = Arrays.asList(
            UPLAND_pattern0
        );
        PatternList UPLAND = new PatternList("UPLAND", UPLAND_patterns);

        List<Pair<String,String>> ECOREGIONS_III_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231E, 231G, 255")
        );
        List<List<Pair<String,String>>> ECOREGIONS_III_patterns = Arrays.asList(
            ECOREGIONS_III_pattern0
        );
        PatternList ECOREGIONS_III = new PatternList("ECOREGIONS_III", ECOREGIONS_III_patterns);

        List<Pair<String,String>> RIVERINE_pattern0 = Arrays.asList(
            new Pair("riverine", "yes")
        );
        List<List<Pair<String,String>>> RIVERINE_patterns = Arrays.asList(
            RIVERINE_pattern0
        );
        PatternList RIVERINE = new PatternList("RIVERINE", RIVERINE_patterns);

        List<Pair<String,String>> SPECIES_III_pattern0 = Arrays.asList(
            new Pair("species", "Gleditsia triacanthos")
        );
        List<Pair<String,String>> SPECIES_III_pattern1 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<List<Pair<String,String>>> SPECIES_III_patterns = Arrays.asList(
            SPECIES_III_pattern0,
            SPECIES_III_pattern1
        );
        PatternList SPECIES_III = new PatternList("SPECIES_III", SPECIES_III_patterns);

        List<Pair<String,String>> ECOREGIONS_IV_pattern0 = Arrays.asList(
            new Pair("ecoregion", "211, M211, 212")
        );
        List<List<Pair<String,String>>> ECOREGIONS_IV_patterns = Arrays.asList(
            ECOREGIONS_IV_pattern0
        );
        PatternList ECOREGIONS_IV = new PatternList("ECOREGIONS_IV", ECOREGIONS_IV_patterns);

        List<Pair<String,String>> SPECIES_IV_pattern0 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> SPECIES_IV_pattern1 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> SPECIES_IV_pattern2 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> SPECIES_IV_pattern3 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> SPECIES_IV_pattern4 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<List<Pair<String,String>>> SPECIES_IV_patterns = Arrays.asList(
            SPECIES_IV_pattern0,
            SPECIES_IV_pattern1,
            SPECIES_IV_pattern2,
            SPECIES_IV_pattern3,
            SPECIES_IV_pattern4
        );
        PatternList SPECIES_IV = new PatternList("SPECIES_IV", SPECIES_IV_patterns);

        INodeMatch match = plot -> (
               (!plot.match(HYDRIC_OR_RIVERINE) && (    plot.riv(W1) >= 20
                                                  || (plot.riv(W1) >= 5 && plot.riv(W1) + plot.riv(W2) >= 50)
                                                  ||  plot.riv(W2) >= 60
                                                  || (plot.riv(W2) >= 30 && plot.riv(W2) + plot.riv(W3) >= 70)
                                                  ||  plot.riv(WETLAND) > plot.riv(UPLAND)
                                                 ))
           || (    plot.match(HYDRIC_OR_RIVERINE) && (    plot.riv(W1) >= 10
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

        // Caribbean Florida Wetland Forest
        // Caribbean Florida Wetland Forest

        String level = "division";
        String code = "Caribbean Florida Wetland Forest";

        //  i. Plots found in Ecosection 411A (Tropical Florida) BUT excluding stands with Persea borbonia,
        //     Pinus elliottii, Quercus virginiana, Taxodium ascendens >=20% RIV.
        // OR
        // ii. Plots found in Ecosection 232 (Tropical Florida and Gulf or Atlantic coast)
        //     AND with tree composition dominated by one or more of Avicennia germinans, Conocarpus erectus,
        //     Laguncularia racemosa, Rhizophora mangle (>=20% RIV);

        List<Pair<String,String>> TROPICAL_FLORIDA_pattern0 = Arrays.asList(
            new Pair("state", "FL"),
            new Pair("ecoregion", "411A")
        );
        List<List<Pair<String,String>>> TROPICAL_FLORIDA_patterns = Arrays.asList(
            TROPICAL_FLORIDA_pattern0
        );
        PatternList TROPICAL_FLORIDA = new PatternList("TROPICAL_FLORIDA", TROPICAL_FLORIDA_patterns);

        List<Pair<String,String>> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<List<Pair<String,String>>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0,
            EXCLUDED_SPECIES_pattern1,
            EXCLUDED_SPECIES_pattern2,
            EXCLUDED_SPECIES_pattern3
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        List<Pair<String,String>> GULF_OR_ATLANTIC_COAST_pattern0 = Arrays.asList(
            new Pair("ecoregion", "232")
        );
        List<List<Pair<String,String>>> GULF_OR_ATLANTIC_COAST_patterns = Arrays.asList(
            GULF_OR_ATLANTIC_COAST_pattern0
        );
        PatternList GULF_OR_ATLANTIC_COAST = new PatternList("GULF_OR_ATLANTIC_COAST", GULF_OR_ATLANTIC_COAST_patterns);

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Avicennia germinans")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Conocarpus erectus")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Laguncularia racemosa")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Rhizophora mangle")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_pattern0,
            DIAGNOSTIC_SPECIES_pattern1,
            DIAGNOSTIC_SPECIES_pattern2,
            DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList DIAGNOSTIC_SPECIES = new PatternList("DIAGNOSTIC_SPECIES", DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
                (plot.match(TROPICAL_FLORIDA) && plot.riv(EXCLUDED_SPECIES) < 20)
            || (plot.match(GULF_OR_ATLANTIC_COAST) && plot.riv(DIAGNOSTIC_SPECIES) >= 20)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_059() {

        // Tropical Florida Natural Wetland Forest
        // Tropical Florida Natural Wetland Forest

        String level = "division";
        String code = "Tropical Florida Natural Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_060() {

        // Caribbean Swamp Forest via tropical Florida (M617)
        // Caribbean Swamp Forest via tropical Florida (M617)

        String level = "macrogroup";
        String code = "Caribbean Swamp Forest via tropical Florida (M617)";

        //  i. Tree composition dominated by Annona glabra, Fraxinus caroliniana,
        //     Salix caroliniana, Taxodium distichum, Sabal palmetto (>=50% RIV); stands only
        //     found in EcoSection 411A [note FIA database does not list these species];
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any
        //     combination of Conocarpus erectus, Magnolia virginiana, Persea borbonia,
        //     Salix caroliniana, other palms (together >=50% RIV);
        // 
        // [Note that because FIA does not list many of these species in their database,
        //  this type may overlap with MG 7, since Magnolia virginiana and Persea borbonia
        //  are diagnostic in that MG]

        List<Pair<String,String>> ECOREGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "411A")
        );
        List<List<Pair<String,String>>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Annona glabra")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Fraxinus caroliniana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Conocarpus erectus")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "other palms")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3,
            MODERATE_DIAGNOSTIC_SPECIES_pattern4
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
                 plot.match(ECOREGION)
           && (    plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
                || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_061() {

        // Western Atlantic & Caribbean Mangrove (M005)
        // Western Atlantic & Caribbean Mangrove (M005)

        String level = "macrogroup";
        String code = "Western Atlantic & Caribbean Mangrove (M005)";

        // Tree composition dominated by one or more of Avicennia germinans, Conocarpus erectus,
        // Laguncularia racemosa, Rhizophora mangle (>=20% RIV);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Avicennia germinans")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Conocarpus erectus")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Laguncularia racemosa")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Rhizophora mangle")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_062() {

        // Tropical Florida Ruderal Wetland Forest
        // Tropical Florida Ruderal Wetland Forest

        String level = "division";
        String code = "Tropical Florida Ruderal Wetland Forest";

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

    public Object[] element_063() {

        // Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)
        // Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)

        String level = "macrogroup";
        String code = "Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)";

        // Only one macrogroup.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_064() {

        // Caribbean Wetland Forest
        // Caribbean Wetland Forest

        String level = "division";
        String code = "Caribbean Wetland Forest";

        // Tropical wetland forests found in Puerto Rico, U.S. Virgin Islands and other Caribbean territories

        List<Pair<String,String>> CARIBBEAN_pattern0 = Arrays.asList(
            new Pair("state", "PR")
        );
        List<Pair<String,String>> CARIBBEAN_pattern1 = Arrays.asList(
            new Pair("state", "VI")
        );
        List<List<Pair<String,String>>> CARIBBEAN_patterns = Arrays.asList(
            CARIBBEAN_pattern0,
            CARIBBEAN_pattern1
        );
        PatternList CARIBBEAN = new PatternList("CARIBBEAN", CARIBBEAN_patterns);

        INodeMatch match = plot -> (
            plot.match(CARIBBEAN)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_065() {

        // Caribbean Natural Wetland Forest
        // Caribbean Natural Wetland Forest

        String level = "division";
        String code = "Caribbean Natural Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_066() {

        // Caribbean Swamp Forest via wetland (M617)
        // Caribbean Swamp Forest via wetland (M617)

        String level = "macrogroup";
        String code = "Caribbean Swamp Forest via wetland (M617)";

        // Only one Macrogroup reported for the Caribbean U.S., its territories and commonwealth.
        // See also M618 (Caribbean Floodplain Forest) reported elsewhere in the Caribbean, and
        // likely present in Puerto Rico

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_067() {

        // Caribbean Ruderal Wetland Forest
        // Caribbean Ruderal Wetland Forest

        String level = "division";
        String code = "Caribbean Ruderal Wetland Forest";

        // At this time, no ruderal types are know in the Caribbean region of the U.S., its
        // territories and commonwealth.

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_068() {

        // Temperate & Boreal Wetland Forest
        // Temperate & Boreal Wetland Forest

        String level = "division";
        String code = "Temperate & Boreal Wetland Forest";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_069() {

        // Eastern North American Temperate & Boreal Wetland Forest
        // Eastern North American Temperate & Boreal Wetland Forest

        String level = "division";
        String code = "Eastern North American Temperate & Boreal Wetland Forest";

        // Eastern North American wetland Temperate & Boreal Forest (all forests found
        // in EcoSection 411A, EcoDomain Humid Temperate (200 or M200) of the eastern
        // United States and Canada, and EcoDomain Polar (100 or M100) east of Alberta
        // and the Yukon [may not need worry about east-west boreal line since tree
        // species for Macrogroups are the same across the line.

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "411A, 200, M200, 100, M100")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_070() {

        // Southeastern North American Flooded & Swamp Forest Division
        // Southeastern North American Flooded & Swamp Forest Division

        String level = "division";
        String code = "Southeastern North American Flooded & Swamp Forest Division";

        //  i. Tree composition dominated by one or more of conifers of Chamaecyparis thyoides, Pinus elliottii,
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

        List<Pair<String,String>> EXCLUDED_REGIONS_pattern0 = Arrays.asList(
            new Pair("state", "MD, NY, NJ, PA, DE, VA")
        );
        List<Pair<String,String>> EXCLUDED_REGIONS_pattern1 = Arrays.asList(
            new Pair("ecoregion", "221")
        );
        List<List<Pair<String,String>>> EXCLUDED_REGIONS_patterns = Arrays.asList(
            EXCLUDED_REGIONS_pattern0,
            EXCLUDED_REGIONS_pattern1
        );
        PatternList EXCLUDED_REGIONS = new PatternList("EXCLUDED_REGIONS", EXCLUDED_REGIONS_patterns);

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Carya aquatica")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Fraxinus caroliniana")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Fraxinus profunda")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new Pair("species", "Gleditsia aquatica")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new Pair("species", "Gordonia lasianthus")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new Pair("species", "Halesia diptera")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new Pair("species", "Juglans major")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new Pair("species", "Juglans microcarpa")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new Pair("species", "Nyssa aquatica")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new Pair("species", "Nyssa biflora")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new Pair("species", "Planera aquatica")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new Pair("species", "Nyssa ogeche")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern22 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern23 = Arrays.asList(
            new Pair("species", "Quercus lyrata")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern24 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern25 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern26 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern27 = Arrays.asList(
            new Pair("species", "Quercus sinuata var. sinuata")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern28 = Arrays.asList(
            new Pair("species", "Quercus texana")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern29 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern30 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_pattern31 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONS_II_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231, 232, 234, 255"),
            new Pair("state", "!KS, MD, NY, NJ, PA, DE")
        );
        List<List<Pair<String,String>>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        INodeMatch match = plot -> (
            (!plot.match(EXCLUDED_REGIONS) && plot.riv(DIAGNOSTIC_SPECIES) >= 20) || plot.match(ECOREGIONS_II)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_071() {

        // Eastern Warm Temperate Natural Wetland Forest
        // Eastern Warm Temperate Natural Wetland Forest

        String level = "division";
        String code = "Eastern Warm Temperate Natural Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_072() {

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

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "255B, 255C, 255D, 315C, 315D, 315E, 315G, 321B")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Celtis laevigata var. reticulata")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Juglans microcarpa")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Juglans major")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Gleditsia triacanthos")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Maclura pomifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Prosopis glandulosa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Sapindus saponaria var. drummondii")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Sideroxylon lanuginosum ssp. lanuginosum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_073() {

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

        List<Pair<String,String>> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<List<Pair<String,String>>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Annona glabra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Nyssa biflora")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_074() {

        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)
        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)

        String level = "macrogroup";
        String code = "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)";

        // Plots found in ecosection 231A, B, D, E, 232A-D, F, G AND
        // tree composition, with STRONG SWAMP DIAGNOSTICS Pinus palustris < 5% RIV AND dominated by one or more
        // of Chamaecyparis thyoides, Cliftonia monophylla [not tracked by FIA], Fraxinus caroliniana, Gordonia lasianthus,
        // Magnolia virginiana, Persea borbonia, Pinus serotina or Quercus laurifolia, Sabal palmetto (>=20% RIV);

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231A, 231B, 231D, 231E, 232A, 232B, 232C, 232D, 232F, 232G")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Cliftonia monophylla")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fraxinus caroliniana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Gordonia lasianthus")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_075() {

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

        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Betula nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Fraxinus profunda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Gleditsia aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Nyssa aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Nyssa biflora")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Nyssa ogeche")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Planera aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus lyrata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Quercus texana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new Pair("species", "Sapindus saponaria var. drummondii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Gleditsia triacanthos")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Halesia diptera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Magnolia grandiflora")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new Pair("species", "Ulmus serotina")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_076() {

        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)
        // Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)

        String level = "macrogroup";
        String code = "Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)";

        // Plots found in ecosection 231A, B, D, E, 232A-D, F, G AND
        // % RIV of STRONG SWAMP DIAGNOSTICS > either STRONG POND CYPRESS DIAGNOSTICS
        // or STRONG LONGLEAF DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231A, 231B, 231D, 231E, 232A, 232B, 232C, 232D, 232F, 232G")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<List<Pair<String,String>>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Cliftonia monophylla")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fraxinus caroliniana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Gordonia lasianthus")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Betula nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Fraxinus profunda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Gleditsia aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Nyssa aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Nyssa biflora")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Nyssa ogeche")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Planera aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus lyrata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Quercus texana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new Pair("species", "Sapindus saponaria var. drummondii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_077() {

        // Pond-cypress Basin Swamp LC (M161)
        // Pond-cypress Basin Swamp LC (M161)

        String level = "macrogroup";
        String code = "Pond-cypress Basin Swamp LC (M161)";

        // % RIV OF STRONG POND CYPRESS DIAGNOSTICS > STRONG LONGLEAF DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

        List<Pair<String,String>> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<List<Pair<String,String>>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Cliftonia monophylla")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fraxinus caroliniana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Gordonia lasianthus")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Betula nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Fraxinus profunda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Gleditsia aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Nyssa aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Nyssa biflora")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Nyssa ogeche")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Planera aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus lyrata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Quercus texana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new Pair("species", "Sapindus saponaria var. drummondii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_078() {

        // Longleaf Pine Woodland LC2 (M007)
        // Longleaf Pine Woodland LC2 (M007)

        String level = "macrogroup";
        String code = "Longleaf Pine Woodland LC2 (M007)";

        // % RIV OF STRONG LONGLEAF DIAGNOSTICS > either STRONG POND CYPRESS DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

        List<Pair<String,String>> STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<List<Pair<String,String>>> STRONG_POND_CYPRESS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_POND_CYPRESS_DIAGNOSTICS_pattern0
        );
        PatternList STRONG_POND_CYPRESS_DIAGNOSTICS = new PatternList("STRONG_POND_CYPRESS_DIAGNOSTICS", STRONG_POND_CYPRESS_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Cliftonia monophylla")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fraxinus caroliniana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Gordonia lasianthus")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Pinus serotina")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Betula nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Fraxinus profunda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Gleditsia aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Nyssa aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Nyssa biflora")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Nyssa ogeche")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Planera aquatica")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus lyrata")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Quercus texana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern26 = Arrays.asList(
            new Pair("species", "Sapindus saponaria var. drummondii")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern27 = Arrays.asList(
            new Pair("species", "Taxodium distichum")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern28 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_FLOODPLAIN_DIAGNOSTICS_pattern29 = Arrays.asList(
            new Pair("species", "Ulmus crassifolia")
        );
        List<List<Pair<String,String>>> STRONG_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_079() {

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

    public Object[] element_080() {

        // Eastern Warm Temperate Ruderal Wetland Forest
        // Eastern Warm Temperate Ruderal Wetland Forest

        String level = "division";
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

    public Object[] element_081() {

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

    public Object[] element_082() {

        // Eastern Cool Temperate & North American Boreal Wetland Forest
        // Eastern Cool Temperate & North American Boreal Wetland Forest

        String level = "division";
        String code = "Eastern Cool Temperate & North American Boreal Wetland Forest";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_083() {

        // North American Boreal Flooded & Swamp Forest Division
        // North American Boreal Flooded & Swamp Forest Division

        String level = "division";
        String code = "North American Boreal Flooded & Swamp Forest Division";

        // Plots in Ecoprovince 212, 211, M211 AND
        //  i.  Tree composition dominated by one or more of boreal wetland conifer species
        //      (Larix laricina, Picea mariana) (if in EcoProvince 212) (>=80% RIV);
        // OR
        // ii.  The above tree composition but with >=20% RIV; AND other species are any
        //      combination of boreal hardwoods (Betula papyrifera) or other conifers
        //      (Abies balsamea, Picea glauca, Pinus banksiana) species (together >=95% RIV);
        //      [N.B. role of Thuja occidentalis in boreal swamps still under review]

        List<Pair<String,String>> BOREAL_REGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212, 211, M211")
        );
        List<List<Pair<String,String>>> BOREAL_REGION_patterns = Arrays.asList(
            BOREAL_REGION_pattern0
        );
        PatternList BOREAL_REGION = new PatternList("BOREAL_REGION", BOREAL_REGION_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
                plot.match(BOREAL_REGION)
           && (    plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 80 
                || (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 && plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 95))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_084() {

        // North American Boreal Natural Wetland Forest
        // North American Boreal Natural Wetland Forest

        String level = "division";
        String code = "North American Boreal Natural Wetland Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_085() {

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

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_086() {

        // North American Boreal Conifer Poor Swamp LC (M299)
        // North American Boreal Conifer Poor Swamp LC (M299)

        String level = "macrogroup";
        String code = "North American Boreal Conifer Poor Swamp LC (M299)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_087() {

        // North American Boreal Ruderal Wetland Forest
        // North American Boreal Ruderal Wetland Forest

        String level = "division";
        String code = "North American Boreal Ruderal Wetland Forest";

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

    public Object[] element_088() {

        // Eastern North American - Great Plains Flooded & Swamp Forest Division
        // Eastern North American - Great Plains Flooded & Swamp Forest Division

        String level = "division";
        String code = "Eastern North American - Great Plains Flooded & Swamp Forest Division";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_089() {

        // Eastern Cool Temperate Natural Wetland Forests
        // Eastern Cool Temperate Natural Wetland Forests

        String level = "division";
        String code = "Eastern Cool Temperate Natural Wetland Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_090() {

        // Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)
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
        // ii. Plots occur in EcoProvinces or EcoSections 212, M211, 211, 222I, 221A-221D
        //     AND
        //     iia. Tree composition dominated by one or more of ECOREGIONALLY STRONG LAURENTIAN-ACADIAN DIAGNOSTICS
        //          Acer rubrum, Acer saccharinum, Chamaecyparis thyoides, Fraxinus nigra, Fraxinus pennsylvanica,
        //          Larix laricina, Picea mariana, Picea rubens, Pinus rigida, Populus balsamifera, Salix amygdaloides,
        //          Tsuga canadensis, Thuja occidentalis, Ulmus americana, Ulmus rubra (>=50% RIV) AND in Province 212,
        //          M211, 211, 222I, 221A-221D.
        //      OR
        //     iib. Tree composition and ecoregions as above, but with >=20% RIV, AND other species are any combination
        //          of MODERATE DIAGNOSTICS Abies balsamea, Acer nigrum, Acer negundo, Acer saccharum, Betula alleghaniensis,
        //          Betula papyrifera, Carpinus caroliniana, Fraxinus americana, Nyssa sylvatica, Ostrya virginiana,
        //          Populus tremuloides, Prunus serotina, Quercus macrocarpa, Tilia americana (together >=50% RIV)

        List<Pair<String,String>> ECOREGIONS_I_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc, 222J, 222K, 222L, 222M, 222N, 222R, 222U")
        );
        List<List<Pair<String,String>>> ECOREGIONS_I_patterns = Arrays.asList(
            ECOREGIONS_I_pattern0
        );
        PatternList ECOREGIONS_I = new PatternList("ECOREGIONS_I", ECOREGIONS_I_patterns);

        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<List<Pair<String,String>>> STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5,
            STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6
        );
        PatternList STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS = new PatternList("STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS", STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns);

        List<Pair<String,String>> ECOREGIONS_II_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212, M211, 211, 222I, 221A, 221B, 221C, 221D")
        );
        List<List<Pair<String,String>>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Chamaecyparis thyoides")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus rigida")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Salix amygdaloides")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<List<Pair<String,String>>> ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns = Arrays.asList(
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
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern13,
            ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_pattern14
        );
        PatternList ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS = new PatternList("ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS", ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
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

    public Object[] element_091() {

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

        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya laciniosa")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula nigra")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Populus deltoides spp. monilifera")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Salix bebbiana")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Salix spp.")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<List<Pair<String,String>>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Gleditsia triacanthos")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new Pair("species", "Morus spp.")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new Pair("species", "Morus rubra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new Pair("species", "Quercus bicolor")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new Pair("species", "Quercus palustris")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_092() {

        // Central Hardwood Swamp Forest (M503)
        // Central Hardwood Swamp Forest (M503)

        String level = "macrogroup";
        String code = "Central Hardwood Swamp Forest (M503)";

        //  i. Tree composition dominated by one or more of of STRONG CENTRAL SWAMP DIAGNOSTICS
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

        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Quercus bicolor")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Quercus palustris")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Salix amygdaloides")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<List<Pair<String,String>>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Acer spicatum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new Pair("species", "Morus spp.")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern12 = Arrays.asList(
            new Pair("species", "Morus rubra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern13 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern14 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern15 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern16 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern17 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern18 = Arrays.asList(
            new Pair("species", "Salix bebbiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern19 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern20 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern21 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_093() {

        // Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)
        // Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)

        String level = "macrogroup";
        String code = "Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)";

        // ECOREGION is 212, M211, 211, 222I, 221A-221D

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212, M211, 211, 222I, 221A, 221B, 221C, 221D")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_094() {

        // Central Hardwood Floodplain Forest LC (M029)
        // Central Hardwood Floodplain Forest LC (M029)

        String level = "macrogroup";
        String code = "Central Hardwood Floodplain Forest LC (M029)";

        //  i. % RIV STRONG CENTRAL FLOODPLAIN DIAGNOSTICS > STRONG CENTRAL SWAMP DIAGNOSTICS
        // OR
        // ii. Physiographic code = R (Riverine)

        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharinum")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya laciniosa")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula nigra")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Populus deltoides spp. monilifera")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Salix bebbiana")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Salix nigra")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Salix caroliniana")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Salix spp.")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<List<Pair<String,String>>> STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Quercus bicolor")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Quercus palustris")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Salix amygdaloides")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<List<Pair<String,String>>> STRONG_CENTRAL_SWAMP_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> RIVERINE_pattern0 = Arrays.asList(
            new Pair("riverine", "yes")
        );
        List<List<Pair<String,String>>> RIVERINE_patterns = Arrays.asList(
            RIVERINE_pattern0
        );
        PatternList RIVERINE = new PatternList("RIVERINE", RIVERINE_patterns);

        INodeMatch match = plot -> (
               plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) > plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS)
           || plot.match(RIVERINE)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_095() {

        // Central Hardwood Swamp Forest LC (M503)
        // Central Hardwood Swamp Forest LC (M503)

        String level = "macrogroup";
        String code = "Central Hardwood Swamp Forest LC (M503)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_096() {

        // Eastern Cool Temperate Ruderal Wetland Forests
        // Eastern Cool Temperate Ruderal Wetland Forests

        String level = "division";
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

    public Object[] element_097() {

        // Eastern North American Ruderal Flooded & Swamp Forest (M302)
        // Eastern North American Ruderal Flooded & Swamp Forest (M302)

        String level = "macrogroup";
        String code = "Eastern North American Ruderal Flooded & Swamp Forest (M302)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_098() {

        // Upland Forest & Woodlands
        // Upland Forest & Woodlands

        String level = "division";
        String code = "Upland Forest & Woodlands";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_099() {

        // Tropical Forest & Woodland Subclass
        // Tropical Forest & Woodland Subclass

        String level = "division";
        String code = "Tropical Forest & Woodland Subclass";

        // Forests dominated by tropical hardwood, other palms and tropical conifer
        // tree species. Found in tropical regions of the United States - Puerto Rico,
        // U.S. Virgin Islands and Tropical Florida (EcoSection 411A) but excluding stands
        // containing alone or in combination Pinus elliottii, Pinus palustris, Quercus virginiana,
        // Quercus laurifolia, Taxodium ascendens > 20% RIV. [n.b. Some tropical forest types may
        // extend into EcoSubsections 232Da, 232Ga, 232Gb, but specific diagnostic species will 
        // need to be identified to key them out.]

        List<Pair<String,String>> TROPICAL_LOCATION_pattern0 = Arrays.asList(
            new Pair("state", "PR")
        );
        List<Pair<String,String>> TROPICAL_LOCATION_pattern1 = Arrays.asList(
            new Pair("state", "VI")
        );
        List<Pair<String,String>> TROPICAL_LOCATION_pattern2 = Arrays.asList(
            new Pair("state", "FL"),
            new Pair("ecoregion", "411A")
        );
        List<List<Pair<String,String>>> TROPICAL_LOCATION_patterns = Arrays.asList(
            TROPICAL_LOCATION_pattern0,
            TROPICAL_LOCATION_pattern1,
            TROPICAL_LOCATION_pattern2
        );
        PatternList TROPICAL_LOCATION = new PatternList("TROPICAL_LOCATION", TROPICAL_LOCATION_patterns);

        List<Pair<String,String>> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Taxodium ascendens")
        );
        List<List<Pair<String,String>>> EXCLUDED_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_100() {

        // Tropical Florida - Caribbean Forest
        // Tropical Florida - Caribbean Forest

        String level = "division";
        String code = "Tropical Florida - Caribbean Forest";

        // Tropical hardwood and tropical conifer forests found in Puerto Rico, U.S. Virgin Islands,
        // and in tropical Florida (EcoSection 411A)

        List<Pair<String,String>> TROPICAL_ATLANTIC_pattern0 = Arrays.asList(
            new Pair("state", "FL"),
            new Pair("ecoregion", "411A")
        );
        List<Pair<String,String>> TROPICAL_ATLANTIC_pattern1 = Arrays.asList(
            new Pair("state", "PR")
        );
        List<Pair<String,String>> TROPICAL_ATLANTIC_pattern2 = Arrays.asList(
            new Pair("state", "VI")
        );
        List<List<Pair<String,String>>> TROPICAL_ATLANTIC_patterns = Arrays.asList(
            TROPICAL_ATLANTIC_pattern0,
            TROPICAL_ATLANTIC_pattern1,
            TROPICAL_ATLANTIC_pattern2
        );
        PatternList TROPICAL_ATLANTIC = new PatternList("TROPICAL_ATLANTIC", TROPICAL_ATLANTIC_patterns);

        INodeMatch match = plot -> (
            plot.match(TROPICAL_ATLANTIC)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_101() {

        // Tropical Florida Forest
        // Tropical Florida Forest

        String level = "division";
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

        List<Pair<String,String>> TROPICAL_FLORIDA_pattern0 = Arrays.asList(
            new Pair("state", "FL"),
            new Pair("ecoregion", "411A")
        );
        List<List<Pair<String,String>>> TROPICAL_FLORIDA_patterns = Arrays.asList(
            TROPICAL_FLORIDA_pattern0
        );
        PatternList TROPICAL_FLORIDA = new PatternList("TROPICAL_FLORIDA", TROPICAL_FLORIDA_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Bursera simaruba")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Coccoloba diversifolia")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Guapira discolor")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Metopium toxiferum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "other palms")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Coccothrinax argentata")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Conocarpus erectus")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Sideroxylon salicifolium")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Thrinax morrisii")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_pattern3
        );
        PatternList MODERATE_DIAGNOSTIC_SPECIES = new PatternList("MODERATE_DIAGNOSTIC_SPECIES", MODERATE_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> RUDERAL_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_102() {

        // Tropical Florida Natural Forest
        // Tropical Florida Natural Forest

        String level = "division";
        String code = "Tropical Florida Natural Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_103() {

        // Caribbean Swamp Forest via upland (M617)
        // Caribbean Swamp Forest via upland (M617)

        String level = "macrogroup";
        String code = "Caribbean Swamp Forest via upland (M617)";

        // Tree composition >= 50% Sabal palmetto RIV

        List<Pair<String,String>> SABAL_PALMETTO_pattern0 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> SABAL_PALMETTO_patterns = Arrays.asList(
            SABAL_PALMETTO_pattern0
        );
        PatternList SABAL_PALMETTO = new PatternList("SABAL_PALMETTO", SABAL_PALMETTO_patterns);

        INodeMatch match = plot -> (
            plot.riv(SABAL_PALMETTO) >= 50
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_104() {

        // Caribbean Coastal Lowland Dry Forest (M134)
        // Caribbean Coastal Lowland Dry Forest (M134)

        String level = "macrogroup";
        String code = "Caribbean Coastal Lowland Dry Forest (M134)";

        // Tree composition dominated by one or more of Bursera simaruba, Coccoloba diversifolia,
        // Guapira discolor, Metopium toxiferum, Conocarpus erectus, "other palms",
        // Sabal palmetto (>=20% RIV)

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Bursera simaruba")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Coccoloba diversifolia")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Guapira discolor")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Metopium toxiferum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Conocarpus erectus")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "other palms")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_105() {

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

    public Object[] element_106() {

        // Tropical Florida Ruderal Forest
        // Tropical Florida Ruderal Forest

        String level = "division";
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

    public Object[] element_107() {

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

    public Object[] element_108() {

        // Caribbean Forest
        // Caribbean Forest

        String level = "division";
        String code = "Caribbean Forest";

        // Stands found in Caribbean islands.

        List<Pair<String,String>> CARIBBEAN_pattern0 = Arrays.asList(
            new Pair("state", "PR")
        );
        List<Pair<String,String>> CARIBBEAN_pattern1 = Arrays.asList(
            new Pair("state", "VI")
        );
        List<List<Pair<String,String>>> CARIBBEAN_patterns = Arrays.asList(
            CARIBBEAN_pattern0,
            CARIBBEAN_pattern1
        );
        PatternList CARIBBEAN = new PatternList("CARIBBEAN", CARIBBEAN_patterns);

        INodeMatch match = plot -> (
            plot.match(CARIBBEAN)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_109() {

        // Caribbean Natural Forest
        // Caribbean Natural Forest

        String level = "division";
        String code = "Caribbean Natural Forest";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_110() {

        // Caribbean & Central American Dry Forests
        // Caribbean & Central American Dry Forests

        String level = "division";
        String code = "Caribbean & Central American Dry Forests";

        //  i. Tree composition dominated by Pinus elliottii (= var. densa) or Pinus caribaea, alone or in
        //     combination (>=50% RIV)
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of (in
        //     dry stands) Bursera simaruba, Coccoloba diversifolia, Coccothrinax argentata, Conocarpus erectus,
        //     Guapira discolor, Metopium toxiferum, "other palms", Sabal palmetto, Thrinax morrisii,
        //     Sideroxylon salicifolium (together >=50% RIV)

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus caribaea")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Bursera simaruba")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Coccoloba diversifolia")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Coccothrinax argentata")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Conocarpus erectus")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Guapira discolor")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Metopium toxiferum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "other palms")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Thrinax morrisii")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Sideroxylon salicifolium")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_111() {

        // Caribbean-Mesoamerican Pine Forest (M296)
        // Caribbean-Mesoamerican Pine Forest (M296)

        String level = "macrogroup";
        String code = "Caribbean-Mesoamerican Pine Forest (M296)";

        //  i. Tree composition dominated by Pinus elliottii (var. densa) or Pinus caribaea,
        //     alone or in combination (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are
        //     any combination of (in dry stands) Coccothrinax argentata, Thrinax morrisii,
        //     Sideroxylon salicifolium (together >=50% RIV);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Pinus caribaea")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_pattern1
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES = new PatternList("STRONG_DIAGNOSTIC_SPECIES", STRONG_DIAGNOSTIC_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Coccothrinax argentata")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Thrinax morrisii")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Sideroxylon salicifolium")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_112() {

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

    public Object[] element_113() {

        // Caribbean Ruderal Forest
        // Caribbean Ruderal Forest

        String level = "division";
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

    public Object[] element_114() {

        // Temperate & Boreal Forests
        // Temperate & Boreal Forests

        String level = "division";
        String code = "Temperate & Boreal Forests";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_115() {

        // Eastern North American Temperate & Boreal Forests
        // Eastern North American Temperate & Boreal Forests

        String level = "division";
        String code = "Eastern North American Temperate & Boreal Forests";

        // Forests found in EcoDomain Humid Temperate (200 or M200) of the eastern United States
        // and Canada, and EcoDomain Polar (100 or M100) east of Alberta and the Yukon [need to
        // improve east-west boreal line using tree species., e.g., Pinus banksiana, Abies balsamea],
        // and 411A [most stands in 411 belong with tropical types, but a few exceptions are
        // allowed, see couplet A]

        List<Pair<String,String>> HUMID_TEMPERATE_OR_POLAR_pattern0 = Arrays.asList(
            new Pair("ecoregion", "200, M200, 100, M100, 411A")
        );
        List<List<Pair<String,String>>> HUMID_TEMPERATE_OR_POLAR_patterns = Arrays.asList(
            HUMID_TEMPERATE_OR_POLAR_pattern0
        );
        PatternList HUMID_TEMPERATE_OR_POLAR = new PatternList("HUMID_TEMPERATE_OR_POLAR", HUMID_TEMPERATE_OR_POLAR_patterns);

        INodeMatch match = plot -> (
            plot.match(HUMID_TEMPERATE_OR_POLAR)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_116() {

        // Southeastern North American Forest & Woodland Division
        // Southeastern North American Forest & Woodland Division

        String level = "division";
        String code = "Southeastern North American Forest & Woodland Division";

        //     i. Stands found in Ecoprovince 231, 232, 234A, 234C, but excluding NJ, PA
        //        AND
        //    ii. Tree composition contains one or more of Aesculus pavia, Halesia diptera,
        //        Juniperus virginiana var. silicicola Magnolia grandiflora, Pinus clausa, Pinus glabra,
        //        Pinus palustris, Pinus elliottii, Quercus incana, Quercus laevis, Quercus laurifolia,
        //        Quercus margarettiae, Quercus minima, Quercus sinuata, Quercus virginiana, Sabal palmetto (>=5% RIV);
        //        [Additional tree species not tracked by FIA include Quercus fusiformis = Quercus virginiana var. fusiformis),
        //        Quercus geminata, Serenoa repens]
        // OR
        //    Plot found in Ecosections 231B, 231E, 231H, 232B, 232C, 232D, 232E, 232F, 232G, 232H, 232I, 232J, 232K, 232L, 234,
        //    411A excluding NJ, PA, KY, TN, IL

        List<Pair<String,String>> ECOREGIONS_1_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231, 232, 234A, 234C"),
            new Pair("state", "!NJ, PA")
        );
        List<List<Pair<String,String>>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new Pair("species", "Aesculus pavia")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new Pair("species", "Halesia diptera")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new Pair("species", "Magnolia grandiflora")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern8 = Arrays.asList(
            new Pair("species", "Quercus incana")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern9 = Arrays.asList(
            new Pair("species", "Quercus laevis")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern10 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern11 = Arrays.asList(
            new Pair("species", "Quercus margarettiae")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern12 = Arrays.asList(
            new Pair("species", "Quercus minima")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern13 = Arrays.asList(
            new Pair("species", "Quercus sinuata var. sinuata")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern14 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_1_pattern15 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONS_2_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231B, 231E, 231H, 232B, 232C, 232D, 232E, 232F, 232G, 232H, 232I, 232J, 232K, 232L, 234, 411A"),
            new Pair("state", "!NJ, PA, KY, TN, IL")
        );
        List<List<Pair<String,String>>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        INodeMatch match = plot -> (
            (plot.match(ECOREGIONS_1) && plot.riv(DIAGNOSTIC_SPECIES_1) >= 5) || plot.match(ECOREGIONS_2)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_117() {

        // Southeastern Warm Temperate Natural Forests
        // Southeastern Warm Temperate Natural Forests

        String level = "division";
        String code = "Southeastern Warm Temperate Natural Forests";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
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

        // Southern & South-Central Oak - Pine Forest & Woodland (M016)
        // Southern & South-Central Oak - Pine Forest & Woodland (M016)

        String level = "macrogroup";
        String code = "Southern & South-Central Oak - Pine Forest & Woodland (M016)";

        //  i. Plot is in 232F, 231E and 234D, and tree composition dominated by Ilex opaca, Pinus taeda, Pinus echinata,
        //     Quercus arkansana, Quercus falcata, Quercus incana, Quercus margarettiae, or Quercus stellata >= 20%
        // OR
        // ii. a. Plot is in 231, 232 or 234D and tree composition dominated by Ilex opaca, Pinus echinata, Pinus taeda, Quercus stellata,
        //        Quercus marilandica or Quercus coccinea >= 50% RIV
        //     OR
        //     b. Plot is in 231, 232 or 234D and tree composition as above, but with >=20% RIV; AND in combination with other species of Oxydendrum arboreum,
        //        Quercus alba, Quercus falcata, Quercus nigra (together >= 50% RIV)

        List<Pair<String,String>> ECOREGIONS_1_pattern0 = Arrays.asList(
            new Pair("ecoregion", "232F, 231E, 234D")
        );
        List<List<Pair<String,String>>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern0 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern1 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern2 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern3 = Arrays.asList(
            new Pair("species", "Quercus arkansana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern4 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern5 = Arrays.asList(
            new Pair("species", "Quercus incana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern6 = Arrays.asList(
            new Pair("species", "Quercus margarettiae")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_1_pattern7 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_1_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONS_2_pattern0 = Arrays.asList(
            new Pair("ecoregion", "231, 232, 234D")
        );
        List<List<Pair<String,String>>> ECOREGIONS_2_patterns = Arrays.asList(
            ECOREGIONS_2_pattern0
        );
        PatternList ECOREGIONS_2 = new PatternList("ECOREGIONS_2", ECOREGIONS_2_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_2_pattern4 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_2_pattern5 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            STRONG_DIAGNOSTIC_SPECIES_2_pattern0,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern1,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern2,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern3,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern4,
            STRONG_DIAGNOSTIC_SPECIES_2_pattern5
        );
        PatternList STRONG_DIAGNOSTIC_SPECIES_2 = new PatternList("STRONG_DIAGNOSTIC_SPECIES_2", STRONG_DIAGNOSTIC_SPECIES_2_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_2_pattern0 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_2_pattern1 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_2_pattern2 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_2_pattern3 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_2_patterns = Arrays.asList(
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern0,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern1,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern2,
            MODERATE_DIAGNOSTIC_SPECIES_2_pattern3
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
        // Southern Mesic Mixed Broadleaf Forest (M008)

        String level = "macrogroup";
        String code = "Southern Mesic Mixed Broadleaf Forest (M008)";

        //  i. Tree composition dominated by one or more of Acer barbatum, Aesculus pavia, Fagus grandifolia,
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

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Aesculus pavia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Halesia diptera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Magnolia grandiflora")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Tilia spp.")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Tilia americana var. caroliniana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Aesculus pavia")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Celtis spp.")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Cornus florida")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Halesia spp.")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Halesia carolina")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Magnolia macrophylla")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Juniperus spp.")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> MODERATE_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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
        // Longleaf Pine Woodland (M007)

        String level = "macrogroup";
        String code = "Longleaf Pine Woodland (M007)";

        //   i. Tree composition dominated by Pinus palustris >=20% RIV,
        // OR
        //  ii. Tree composition dominated by Pinus clausa, Pinus elliottii, Pinus palustris >=5% AND Pinus clausa, Pinus echinata,
        //      Pinus elliottii, Pinus palustris, and Pinus taeda together >=50% RIV.
        // OR
        // iii. Tree composition dominated by one or more of Pinus clausa, Pinus elliottii or Pinus palustris (>=50% RIV);
        // OR
        //  iv. Tree composition as above, but with >=20% RIV, AND other species are any combination of coastal plain species of
        //      Acer rubrum, Carya illinoinensis, Diospyros virginiana, Liquidambar styraciflua, Pinus echinata, Pinus taeda,
        //      Persea borbonia, Quercus falcata, Quercus incana, Quercus laevis, Quercus laurifolia, Quercus margarettiae,
        //      Quercus marilandica, Quercus nigra, Quercus virginiana or Sabal palmetto (together >=50% RIV).

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_I_pattern0 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_I_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_I_pattern0
        );
        PatternList DIAGNOSTIC_SPECIES_I = new PatternList("DIAGNOSTIC_SPECIES_I", DIAGNOSTIC_SPECIES_I_patterns);

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_II_pattern0,
            DIAGNOSTIC_SPECIES_II_pattern1,
            DIAGNOSTIC_SPECIES_II_pattern2,
            DIAGNOSTIC_SPECIES_II_pattern3,
            DIAGNOSTIC_SPECIES_II_pattern4
        );
        PatternList DIAGNOSTIC_SPECIES_II = new PatternList("DIAGNOSTIC_SPECIES_II", DIAGNOSTIC_SPECIES_II_patterns);

        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya illinoinensis")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Quercus incana")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus laevis")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus margarettiae")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> MODERATE_LONGLEAF_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> MODERATE_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
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

        // Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)
        // Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)

        String level = "macrogroup";
        String code = "Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)";

        // Plot is in 232B, C, D, E, G [not in 232A, F, H, I, J], 255Da, Db, Dc [not 255Dd] or 411A, AND
        //  i. Tree composition is dominated by one or more of Juniperus virginiana var. silicicola,
        //     Pinus glabra, Quercus incana, Quercus laevis, Quercus laurifolia (presumably = Quercus hemisphaerica, if upland),
        //     Quercus margarettiae, Quercus minima, Quercus margarettiae, Quercus virginiana, Sabal palmetto (>=50% RIV);
        //     [Additional tree species not tracked by FIA include Quercus fusiformis = Quercus virginiana var. fusiformis),
        //     Quercus geminata, Serenoa repens,]
        // OR
        // ii. Tree composition as above, but with >=20% RIV; AND other species are any combination of Acer rubrum,
        //     Carpinus caroliniana, Carya alba, Celtis laevigata, Celtis spp., Fraxinus americana, Ilex opaca,
        //     Juniperus spp., Juniperus virginiana, Liquidambar styraciflua, Magnolia grandiflora, Nyssa sylvatica,
        //     Ostrya virginiana, Oxydendrum arboreum, other palms, Persea borbonia, Prunus serotina, Quercus alba,
        //     Quercus falcata, , Quercus nigra, Quercus pagoda, Quercus stellata, Pinus echinata, Pinus taeda,
        //     Ulmus alata (together >=50% RIV).

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "232B, 232C, 232D, 232E, 232G, 255Da, 255Db, 255Dc, 411A")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Quercus incana")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Quercus laevis")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Quercus margarettiae")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus minima")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Celtis laevigata")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Celtis spp.")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juniperus spp.")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Magnolia grandiflora")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "other palms")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Persea borbonia")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern26 = Arrays.asList(
            new Pair("species", "Ulmus alata")
        );
        List<List<Pair<String,String>>> MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns = Arrays.asList(
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
            MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern26
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

        // Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest LC (M885)
        // Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest LC (M885)

        String level = "macrogroup";
        String code = "Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest LC (M885)";

        // Plot is in 232B-E, 232G, 255Da-Dc or 411A, AND
        // % RIV of STRONG OAK-MIXED HARDWOOD DIAGNOSTICS > either STRONG LONGLEAF DIAGNOSTICS or STRONG MESIC DIAGNOSTICS

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "232B, 232C, 232D, 232E, 232G, 255Da, 255Db, 255Dc, 411A")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Juniperus virginiana var. silicicola")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Quercus incana")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Quercus laevis")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Quercus margarettiae")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus minima")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus virginiana")
        );
        List<Pair<String,String>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<List<Pair<String,String>>> STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Aesculus pavia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Halesia diptera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Magnolia grandiflora")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Tilia spp.")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Tilia americana var. caroliniana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Pinus clausa")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus elliottii")
        );
        List<Pair<String,String>> STRONG_LONGLEAF_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus palustris")
        );
        List<List<Pair<String,String>>> STRONG_LONGLEAF_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_LONGLEAF_DIAGNOSTICS_pattern0,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern1,
            STRONG_LONGLEAF_DIAGNOSTICS_pattern2
        );
        PatternList STRONG_LONGLEAF_DIAGNOSTICS = new PatternList("STRONG_LONGLEAF_DIAGNOSTICS", STRONG_LONGLEAF_DIAGNOSTICS_patterns);

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Aesculus pavia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Halesia diptera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Magnolia grandiflora")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Magnolia virginiana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus glabra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus michauxii")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Sabal palmetto")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Tilia spp.")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Tilia americana var. caroliniana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_125() {

        // Southeastern Warm Temperate Ruderal Forests
        // Southeastern Warm Temperate Ruderal Forests

        String level = "division";
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

    public Object[] element_126() {

        // Southeastern North American Ruderal Forest (M305)
        // Southeastern North American Ruderal Forest (M305)

        String level = "macrogroup";
        String code = "Southeastern North American Ruderal Forest (M305)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_127() {

        // Eastern North American Forest & Woodland Division
        // Eastern North American Forest & Woodland Division

        String level = "division";
        String code = "Eastern North American Forest & Woodland Division";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_128() {

        // Eastern Cool Temperate Natural Forest & Woodlands
        // Eastern Cool Temperate Natural Forest & Woodlands

        String level = "division";
        String code = "Eastern Cool Temperate Natural Forest & Woodlands";

        // Vegetation in a relatively natural state, dominated by native species; little or no
        // evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
        // may be early successional pole-sized trees following logging or blowdowns).  Tree
        // composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
        // needs to be refined for this Division)

        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("ruderal", "yes")
        );
        List<Pair<String,String>> RUDERAL_OR_EXOTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("exotic", "yes")
        );
        List<List<Pair<String,String>>> RUDERAL_OR_EXOTIC_SPECIES_patterns = Arrays.asList(
            RUDERAL_OR_EXOTIC_SPECIES_pattern0,
            RUDERAL_OR_EXOTIC_SPECIES_pattern1
        );
        PatternList RUDERAL_OR_EXOTIC_SPECIES = new PatternList("RUDERAL_OR_EXOTIC_SPECIES", RUDERAL_OR_EXOTIC_SPECIES_patterns);

        INodeMatch match = plot -> (
            plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_129() {

        // Great Plains Forest & Woodland (M151)
        // Great Plains Forest & Woodland (M151)

        String level = "macrogroup";
        String code = "Great Plains Forest & Woodland (M151)";

        //  i. Plot occurs in Ecoprovince 331, 332, 251A, or 222Na, and tree composition dominated by one or more of
        //     STRONG PLAINS DIAGNOSTICS Fraxinus pennsylvanica, Juniperus virginiana, Populus tremuloides,
        //     Quercus macrocarpa, Ulmus americana, Ulmus rubra (>=50% RIV) AND Tilia americana and
        //     Acer saccharum, singly or in combination < 5% RIV;
        // OR
        // ii. Plot occurs in Ecoprovince 331, 332, 251A, or 222Na, and tree composition as above, but with >=20% RIV, AND
        //     other species are any combination of MODERATE PLAINS DIAGNOSTICS Acer negundo, Betula papyrifera,
        //     Celtis occidentalis, Crataegus spp., Juglans nigra, Juniperus scopulorum, Morus rubra, Pinus ponderosa,
        //     Prunus virginiana, Quercus rubra, Quercus muehlenbergii, Ulmus rubra (together >=50% RIV)

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "331, 332, 251A, 222Na")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_PLAINS_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_PLAINS_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> STRONG_PLAINS_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> STRONG_PLAINS_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_PLAINS_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<Pair<String,String>> STRONG_PLAINS_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<List<Pair<String,String>>> STRONG_PLAINS_DIAGNOSTICS_patterns = Arrays.asList(
            STRONG_PLAINS_DIAGNOSTICS_pattern0,
            STRONG_PLAINS_DIAGNOSTICS_pattern1,
            STRONG_PLAINS_DIAGNOSTICS_pattern2,
            STRONG_PLAINS_DIAGNOSTICS_pattern3,
            STRONG_PLAINS_DIAGNOSTICS_pattern4,
            STRONG_PLAINS_DIAGNOSTICS_pattern5
        );
        PatternList STRONG_PLAINS_DIAGNOSTICS = new PatternList("STRONG_PLAINS_DIAGNOSTICS", STRONG_PLAINS_DIAGNOSTICS_patterns);

        List<Pair<String,String>> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<List<Pair<String,String>>> EXCLUDED_SPECIES_patterns = Arrays.asList(
            EXCLUDED_SPECIES_pattern0,
            EXCLUDED_SPECIES_pattern1
        );
        PatternList EXCLUDED_SPECIES = new PatternList("EXCLUDED_SPECIES", EXCLUDED_SPECIES_patterns);

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Crataegus spp.")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Juniperus scopulorum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Morus rubra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Pinus ponderosa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Prunus virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern10 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern11 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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
                || (plot.riv(STRONG_PLAINS_DIAGNOSTICS) >= 20 && plot.riv(STRONG_PLAINS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_130() {

        // Northern Forest macrogroups
        // Northern Forest macrogroups

        String level = "division";
        String code = "Northern Forest macrogroups";

        //   i. Tree composition dominated by one or more of Abies balsamea, Abies fraseri, Picea rubens (>=20% RIV)
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

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_I_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_I_pattern1 = Arrays.asList(
            new Pair("species", "Abies fraseri")
        );
        List<Pair<String,String>> DIAGNOSTIC_SPECIES_I_pattern2 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_I_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_I_pattern0,
            DIAGNOSTIC_SPECIES_I_pattern1,
            DIAGNOSTIC_SPECIES_I_pattern2
        );
        PatternList DIAGNOSTIC_SPECIES_I = new PatternList("DIAGNOSTIC_SPECIES_I", DIAGNOSTIC_SPECIES_I_patterns);

        List<Pair<String,String>> ECOREGIONS_II_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc, 222J, 222K, 222L, 222M, 222R, 222U")
        );
        List<List<Pair<String,String>>> ECOREGIONS_II_patterns = Arrays.asList(
            ECOREGIONS_II_pattern0
        );
        PatternList ECOREGIONS_II = new PatternList("ECOREGIONS_II", ECOREGIONS_II_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new Pair("species", "Acer spicatum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new Pair("species", "Amelanchier spp.")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new Pair("species", "Betula populifolia")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new Pair("species", "Prunus pensylvanica")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new Pair("species", "Sorbus americana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern14 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_II_pattern15 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern2 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern3 = Arrays.asList(
            new Pair("species", "Abies fraseri")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern4 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern5 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern6 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern9 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern10 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern11 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern12 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern13 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern14 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern15 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern16 = Arrays.asList(
            new Pair("species", "Prunus virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern17 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern18 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern19 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern20 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_II_pattern21 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_II_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONS_III_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc")
        );
        List<List<Pair<String,String>>> ECOREGIONS_III_patterns = Arrays.asList(
            ECOREGIONS_III_pattern0
        );
        PatternList ECOREGIONS_III = new PatternList("ECOREGIONS_III", ECOREGIONS_III_patterns);

        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern0 = Arrays.asList(
            new Pair("species", "Acer rubrum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern2 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern3 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern4 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern5 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern6 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern8 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern9 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern10 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern11 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern12 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern13 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern14 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern15 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern16 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern17 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_DIAGNOSTIC_SPECIES_III_pattern18 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> STRONG_DIAGNOSTIC_SPECIES_III_patterns = Arrays.asList(
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

    public Object[] element_131() {

        // Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)
        // Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)

        String level = "macrogroup";
        String code = "Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)";

        //  i. Tree composition dominated by one or more of STRONG DRY DIAGNOSTICS Picea mariana,
        //     Pinus banksiana, Pinus resinosa, Pinus strobus, Quercus alba, Quercus ellipsoidalis,
        //     Quercus macrocarpa, Quercus velutina (>=50% RIV);
        // OR
        // ii. Tree composition as above, but with >=20% RIV, AND other species are any combination
        //     of MODERATE DRY DIAGNOSTICS Amelanchier spp., Betula populifolia, Betula papyrifera, 
        //     Carpinus caroliniana, Ostrya virginiana, Populus grandidentata, Populus tremuloides, 
        //     Prunus pensylvanica, Prunus serotina, Quercus rubra (together >=50% RIV)

        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<List<Pair<String,String>>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Amelanchier spp.")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Betula populifolia")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Prunus pensylvanica")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern8 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_DIAGNOSTIC_SPECIES_pattern9 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<List<Pair<String,String>>> MODERATE_DIAGNOSTIC_SPECIES_patterns = Arrays.asList(
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
                plot.riv(STRONG_DRY_DIAGNOSTICS) >= 50
           || (    plot.riv(STRONG_DRY_DIAGNOSTICS) >= 20
               && plot.riv(STRONG_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_132() {

        // Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)
        // Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)

        String level = "macrogroup";
        String code = "Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)";

        // Tree composition dominated by any one or more of the hardwoods and/or conifers
        // STRONG MESIC DIAGNOSTICS Abies balsamea, Abies fraseri, Acer pensylvanicum,
        // Acer saccharum, Acer spicatum, Betula alleghaniensis, Betula lenta, Fagus grandifolia,
        // Fraxinus americana, Fraxinus nigra, Fraxinus pennsylvanica, Larix laricina, Picea glauca,
        // Picea mariana, Picea rubens, Populus balsamifera, Populus grandidentata, Quercus macrocarpa,
        // Quercus rubra, Thuja occidentalis, Tilia americana, Tsuga canadensis, Ulmus americana (>=20% RIV);

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Abies fraseri")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Acer spicatum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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
            STRONG_MESIC_DIAGNOSTICS_pattern20,
            STRONG_MESIC_DIAGNOSTICS_pattern21,
            STRONG_MESIC_DIAGNOSTICS_pattern22
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_133() {

        // Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)
        // Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)

        String level = "macrogroup";
        String code = "Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)";

        // % RIV of STRONG DRY DIAGNOSTICS > STRONG MESIC DIAGNOSTICS [if stands lacks both strong
        // dry and strong mesic diagnostics, plot will be assigned to the mesic]

        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<List<Pair<String,String>>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Abies balsamea")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Abies fraseri")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Acer spicatum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Larix laricina")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Picea glauca")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Picea mariana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Picea rubens")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Thuja occidentalis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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
            STRONG_MESIC_DIAGNOSTICS_pattern20,
            STRONG_MESIC_DIAGNOSTICS_pattern21,
            STRONG_MESIC_DIAGNOSTICS_pattern22
        );
        PatternList STRONG_MESIC_DIAGNOSTICS = new PatternList("STRONG_MESIC_DIAGNOSTICS", STRONG_MESIC_DIAGNOSTICS_patterns);

        INodeMatch match = plot -> (
            plot.riv(STRONG_DRY_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_134() {

        // Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)
        // Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)

        String level = "macrogroup";
        String code = "Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_135() {

        // Central Forest macrogroups
        // Central Forest macrogroups

        String level = "division";
        String code = "Central Forest macrogroups";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_136() {

        // Central Midwest Oak Forest, Woodland & Savanna (M012)
        // Central Midwest Oak Forest, Woodland & Savanna (M012)

        String level = "macrogroup";
        String code = "Central Midwest Oak Forest, Woodland & Savanna (M012)";

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

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "222, 223G, 251 ! 222I")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<List<Pair<String,String>>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya laciniosa")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Amelanchier spp.")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Cercis canadensis")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Cornus florida")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Morus rubra")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> MODERATE_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Sassafras albidum")
        );
        List<List<Pair<String,String>>> MODERATE_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_137() {

        // Central Midwest Mesic Forest (M882)
        // Central Midwest Mesic Forest (M882)

        String level = "macrogroup";
        String code = "Central Midwest Mesic Forest (M882)";

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

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "222, 223A, 223G, 251, 332 ! 222I")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Aesculus glabra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Asimina triloba")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Gymnocladus dioicus")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Juglans cinerea")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus bicolor")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus palustris")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer negundo")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Amelanchier spp.")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Betula populifolia")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Carya ovalis")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Cornus florida")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Gleditsia triacanthos")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Populus balsamifera")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Populus deltoides")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Prunus pensylvanica")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Prunus virginiana")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Sassafras albidum")
        );
        List<Pair<String,String>> MODERATE_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Ulmus thomasii")
        );
        List<List<Pair<String,String>>> MODERATE_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> DIAGNOSTIC_SPECIES_III_pattern0 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<List<Pair<String,String>>> DIAGNOSTIC_SPECIES_III_patterns = Arrays.asList(
            DIAGNOSTIC_SPECIES_III_pattern0
        );
        PatternList DIAGNOSTIC_SPECIES_III = new PatternList("DIAGNOSTIC_SPECIES_III", DIAGNOSTIC_SPECIES_III_patterns);

        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern0 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern1 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern2 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern3 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern4 = Arrays.asList(
            new Pair("species", "Quercus prinus")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern5 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern6 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern7 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_III_pattern8 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<List<Pair<String,String>>> EXCLUDED_SPECIES_III_patterns = Arrays.asList(
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

    public Object[] element_138() {

        // Central Midwest Oak Forest, Woodland & Savanna LC (M012)
        // Central Midwest Oak Forest, Woodland & Savanna LC (M012)

        String level = "macrogroup";
        String code = "Central Midwest Oak Forest, Woodland & Savanna LC (M012)";

        // Plot occurs in Ecoregions 222 (except not 222I), 251,
        // AND % RIV of STRONG DRY DIAGNOSTICS > STRONG MESIC DIAGNOSTICS

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "222, 251 ! 222I")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Pinus resinosa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus macrocarpa")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<List<Pair<String,String>>> STRONG_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Aesculus glabra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Asimina triloba")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Fraxinus nigra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Gymnocladus dioicus")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Juglans cinerea")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus bicolor")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus palustris")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_139() {

        // Central Midwest Mesic Forest LC (M882)
        // Central Midwest Mesic Forest LC (M882)

        String level = "macrogroup";
        String code = "Central Midwest Mesic Forest LC (M882)";

        // other

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "222, 251 ! 222I")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_140() {

        // Appalachian, Interior - Northeastern Mesic Forest (M883)
        // Appalachian, Interior - Northeastern Mesic Forest (M883)

        String level = "macrogroup";
        String code = "Appalachian, Interior - Northeastern Mesic Forest (M883)";

        //   i. Tree composition dominated by any one or more of the STRONG MESIC DIAGNOSTICS [Appalachian- Interior-Northeast Mesic
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

        List<Pair<String,String>> ECOREGIONS_1_pattern0 = Arrays.asList(
            new Pair("ecoregion", "211F, 211G, 211Jd, 221, M221, 223B, 223C, 223D, 223E, 223F, 223G, 231A, 231C, 231D, 231I, 232")
        );
        List<List<Pair<String,String>>> ECOREGIONS_1_patterns = Arrays.asList(
            ECOREGIONS_1_pattern0
        );
        PatternList ECOREGIONS_1 = new PatternList("ECOREGIONS_1", ECOREGIONS_1_patterns);

        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Aesculus flava")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Halesia carolina")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Halesia spp.")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Magnolia tripetala")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<List<Pair<String,String>>> STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Aesculus flava")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Aesculus glabra")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Asimina triloba")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Halesia carolina")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Halesia spp.")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Magnolia fraseri")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Magnolia macrophylla")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Magnolia tripetala")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Amelanchier spp.")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Betula populifolia")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Betula papyrifera")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Carya ovalis")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Cornus florida")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Gleditsia triacanthos")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Juglans cinerea")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Platanus occidentalis")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Populus grandidentata")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Populus tremuloides")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Prunus pensylvanica")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Prunus virginiana")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus bicolor")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Quercus phellos")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern25 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern26 = Arrays.asList(
            new Pair("species", "Ulmus rubra")
        );
        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_pattern27 = Arrays.asList(
            new Pair("species", "Ulmus thomasii")
        );
        List<List<Pair<String,String>>> ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<List<Pair<String,String>>> ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_patterns = Arrays.asList(
            ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_pattern0
        );
        PatternList ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS = new PatternList("ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS", ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS_patterns);

        List<Pair<String,String>> EXCLUDED_SPECIES_pattern0 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern1 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern2 = Arrays.asList(
            new Pair("species", "Quercus prinus")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern3 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern4 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern5 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern6 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> EXCLUDED_SPECIES_pattern7 = Arrays.asList(
            new Pair("species", "Carya pallida")
        );
        List<List<Pair<String,String>>> EXCLUDED_SPECIES_patterns = Arrays.asList(
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

    public Object[] element_141() {

        // Southern & South-Central Oak - Pine Forest & Woodland - Cool (M016)
        // Southern & South-Central Oak - Pine Forest & Woodland - Cool (M016)

        String level = "macrogroup";
        String code = "Southern & South-Central Oak - Pine Forest & Woodland - Cool (M016)";

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

        List<Pair<String,String>> EXCLUDED_STATES_pattern0 = Arrays.asList(
            new Pair("state", "!CT, DE, OH, MA, NJ, NY, PA, WV")
        );
        List<List<Pair<String,String>>> EXCLUDED_STATES_patterns = Arrays.asList(
            EXCLUDED_STATES_pattern0
        );
        PatternList EXCLUDED_STATES = new PatternList("EXCLUDED_STATES", EXCLUDED_STATES_patterns);

        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya pallida")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya texana")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Juniperus ashei")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Ulmus alata")
        );
        List<List<Pair<String,String>>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Cercis canadensis")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Cornus florida")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Juglans nigra")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus incana")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus laurifolia")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus pagoda")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus prinus")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<List<Pair<String,String>>> MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONS_pattern0 = Arrays.asList(
            new Pair("ecoregion", "221H, 223, M223, 231, M231, 234, 255")
        );
        List<List<Pair<String,String>>> ECOREGIONS_patterns = Arrays.asList(
            ECOREGIONS_pattern0
        );
        PatternList ECOREGIONS = new PatternList("ECOREGIONS", ECOREGIONS_patterns);

        INodeMatch match = plot -> (
                plot.match(EXCLUDED_STATES) && plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) >= 50
           || (plot.match(EXCLUDED_STATES) && plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) >= 20 && plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS) + plot.riv(MODERATE_DRY_SOUTH_CENTRAL_DIAGNOSTICS) >= 50)
           ||  plot.match(ECOREGIONS)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_142() {

        // Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)
        // Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)

        String level = "macrogroup";
        String code = "Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)";

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

        List<Pair<String,String>> ECOREGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "!212")
        );
        List<List<Pair<String,String>>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Castanea dentata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus pungens")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Pinus rigida")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Pinus virginiana")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus ilicifolia")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus prinus")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Tsuga caroliniana")
        );
        List<List<Pair<String,String>>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Amelanchier spp.")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carpinus caroliniana")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Cercis canadensis")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Cornus florida")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Ostrya virginiana")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Pinus banksiana")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Prunus serotina")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Prunus virginiana")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Quercus muehlenbergii")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus rubra")
        );
        List<Pair<String,String>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Sassafras albidum")
        );
        List<List<Pair<String,String>>> MODERATE_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_143() {

        // Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)
        // Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)

        String level = "macrogroup";
        String code = "Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)";

        // Plot is in Ecoregion 212

        List<Pair<String,String>> ECOREGION_pattern0 = Arrays.asList(
            new Pair("ecoregion", "212")
        );
        List<List<Pair<String,String>>> ECOREGION_patterns = Arrays.asList(
            ECOREGION_pattern0
        );
        PatternList ECOREGION = new PatternList("ECOREGION", ECOREGION_patterns);

        INodeMatch match = plot -> (
            plot.match(ECOREGION)
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_144() {

        // Southern & South-Central Oak - Pine Forest & Woodland LC (M016)
        // Southern & South-Central Oak - Pine Forest & Woodland LC (M016)

        String level = "macrogroup";
        String code = "Southern & South-Central Oak - Pine Forest & Woodland LC (M016)";

        // %RIV of STRONG DRY SOUTH-CENTRAL DIAGNOSTICS > either STRONG APPALACHIAN DRY DIAGONOSTICS OR ECOREGIONAL STRONG MESIC DIAGNOSTICS

        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya pallida")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya texana")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Juniperus ashei")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Ulmus alata")
        );
        List<List<Pair<String,String>>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Castanea dentata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus pungens")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Pinus rigida")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Pinus virginiana")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus ilicifolia")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus prinus")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Tsuga caroliniana")
        );
        List<List<Pair<String,String>>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Aesculus flava")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Aesculus glabra")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Asimina triloba")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Halesia carolina")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Magnolia fraseri")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Magnolia macrophylla")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Magnolia tripetala")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_145() {

        // Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)
        // Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)

        String level = "macrogroup";
        String code = "Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)";

        // i. %RIV STRONG APPALACHIAN DRY DIAGNOSTICS > either STRONG DRY SOUTH-CENTRAL DIAGNOSTICS OR ECOREGIONAL STRONG MESIC DIAGNOSTICS

        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer barbatum")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya pallida")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya texana")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Diospyros virginiana")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Ilex opaca")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Juniperus ashei")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Oxydendrum arboreum")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Pinus taeda")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus nigra")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Ulmus alata")
        );
        List<List<Pair<String,String>>> STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Carya glabra")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Carya ovata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Carya alba")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Castanea dentata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Fraxinus quadrangulata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Juniperus virginiana")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Nyssa sylvatica")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Pinus echinata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Pinus pungens")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Pinus rigida")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Pinus strobus")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Pinus virginiana")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Quercus alba")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Quercus coccinea")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Quercus ellipsoidalis")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Quercus falcata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Quercus imbricaria")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Quercus ilicifolia")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Quercus marilandica")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Quercus prinus")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus stellata")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Quercus velutina")
        );
        List<Pair<String,String>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Tsuga caroliniana")
        );
        List<List<Pair<String,String>>> STRONG_APPALACHIAN_DRY_DIAGNOSTICS_patterns = Arrays.asList(
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

        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern0 = Arrays.asList(
            new Pair("species", "Acer nigrum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern1 = Arrays.asList(
            new Pair("species", "Acer pensylvanicum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern2 = Arrays.asList(
            new Pair("species", "Acer saccharum")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern3 = Arrays.asList(
            new Pair("species", "Aesculus flava")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern4 = Arrays.asList(
            new Pair("species", "Aesculus glabra")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern5 = Arrays.asList(
            new Pair("species", "Asimina triloba")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern6 = Arrays.asList(
            new Pair("species", "Betula alleghaniensis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern7 = Arrays.asList(
            new Pair("species", "Betula lenta")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern8 = Arrays.asList(
            new Pair("species", "Carya cordiformis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern9 = Arrays.asList(
            new Pair("species", "Celtis occidentalis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern10 = Arrays.asList(
            new Pair("species", "Fagus grandifolia")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern11 = Arrays.asList(
            new Pair("species", "Fraxinus americana")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern12 = Arrays.asList(
            new Pair("species", "Fraxinus pennsylvanica")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern13 = Arrays.asList(
            new Pair("species", "Halesia carolina")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern14 = Arrays.asList(
            new Pair("species", "Liriodendron tulipifera")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern15 = Arrays.asList(
            new Pair("species", "Liquidambar styraciflua")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern16 = Arrays.asList(
            new Pair("species", "Magnolia acuminata")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern17 = Arrays.asList(
            new Pair("species", "Magnolia fraseri")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern18 = Arrays.asList(
            new Pair("species", "Magnolia macrophylla")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern19 = Arrays.asList(
            new Pair("species", "Magnolia tripetala")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern20 = Arrays.asList(
            new Pair("species", "Quercus shumardii")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern21 = Arrays.asList(
            new Pair("species", "Tilia americana")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern22 = Arrays.asList(
            new Pair("species", "Tilia americana var. heterophylla")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern23 = Arrays.asList(
            new Pair("species", "Tsuga canadensis")
        );
        List<Pair<String,String>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_pattern24 = Arrays.asList(
            new Pair("species", "Ulmus americana")
        );
        List<List<Pair<String,String>>> ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS_patterns = Arrays.asList(
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

    public Object[] element_146() {

        // Appalachian, Interior - Northeastern Mesic Forest LC (M883)
        // Appalachian, Interior - Northeastern Mesic Forest LC (M883)

        String level = "macrogroup";
        String code = "Appalachian, Interior - Northeastern Mesic Forest LC (M883)";

        // other

        INodeMatch match = plot -> (
            true
        );

        return new Object[] { level, code, match };
    }

    public Object[] element_147() {

        // Eastern Cool Temperate Ruderal Forest & Woodlands
        // Eastern Cool Temperate Ruderal Forest & Woodlands

        String level = "division";
        String code = "Eastern Cool Temperate Ruderal Forest & Woodlands";

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

    public Object[] element_148() {

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
