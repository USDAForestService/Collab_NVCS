import collections
from classifier import Node
from pattern import Pattern
from pattern import PatternList
import logging

class Plot:
    def __init__(self, ident, rscd, state, ecoregion, plantation, hydric, riverine, elevation):
        self.attrs = dict()
        self.attrs['ident'] = ident
        self.attrs['rscd'] = rscd
        self.attrs['state'] = state
        self.attrs['ecoregion'] = ecoregion
        self.attrs['plantation'] = plantation
        self.attrs['hydric'] = hydric
        self.attrs['riverine'] = riverine
        self.attrs['elevation'] = float(elevation)
        self.trees = list()

    def __getattr__(self, name):
        return self.attrs[name]

    def match(self, pattlist):
        result = pattlist.match_any(self.attrs)
        logging.debug('%s|match()::%s|%s', self.ident, pattlist.label, result)
        return result

    def riv(self, pattlist):
        match_riv = 0.0
        total_riv = 0.0
        for tree in self.trees:
            total_riv += tree.riv;
            if pattlist.match_any({k:d.get(k) for d in (self.attrs, tree.attrs) for k in d}):
                match_riv += tree.riv;
        if total_riv == 0.0:
            pct_riv = 0.0
        else:
            pct_riv = (match_riv / total_riv) * 100
        logging.debug('%s|riv()::%s|%.1f', self.ident, pattlist.label, pct_riv)
        return pct_riv

    def spcov(self, pattlist):
        match_spcov = 0.0
        for tree in self.trees:
            if pattlist.match_any({k:d.get(k) for d in (self.attrs, tree.attrs) for k in d}):
                match_spcov += tree.spcov;
        logging.debug('%s|spcov()::%s|%.1f', self.ident, pattlist.label, match_spcov)
        return match_spcov

    def get_elevation(self):
        logging.debug('%s|elevation()|%s', self.ident, self.elevation)
        return int(self.elevation)

    def __repr__(self):
        return "Plot(%r)" % (self.attrs)

class Tree:
    def __init__(self, species, riv, wetland, ruderal, exotic, softwoodhardwood, planted, tallytree, spcov):
        self.attrs = dict()
        self.attrs['species'] = species
        self.attrs['riv'] = float(riv)
        self.attrs['wetland'] = wetland
        self.attrs['ruderal'] = ruderal
        self.attrs['exotic'] = exotic
        self.attrs['softwoodhardwood'] = softwoodhardwood
        self.attrs['planted'] = planted
        self.attrs['tallytree'] = tallytree
        self.attrs['spcov'] = float(spcov)

    def __getattr__(self, name):
        return self.attrs[name]

    def __repr__(self):
        return "Tree(%r)" % (self.attrs)

class _EcoregionPattern(Pattern):
    def __init__(self, expr):
        if (not expr):
            raise RuntimeError("Pattern is empty")
        else:
            p = expr.lstrip().find('!')
            if (p == -1):
                self.includepattern = [s.strip() for s in expr.split(',')]
                self.excludepattern = None
            elif (p == 0):
                self.includepattern = None
                self.excludepattern = [s.strip() for s in expr.lstrip(' !').split(',')]
            else:
                expr1, expr2 = expr.split('!')
                self.includepattern = [s.strip() for s in expr1.split(',')]
                self.excludepattern = [s.strip() for s in expr2.split(',')]

    def match(self, value):
        #print("ecoregion_match:", self, value)
        # make sure whitespace is trimmed from the input value (CT 2023-02-18):
        value = value.strip()
        if (self.includepattern is None):
            foundinclude = True
        else:
            foundinclude = False
            for p in self.includepattern:
                if (value.startswith(p.rstrip('0'))):
                    foundinclude = True
                    break
        if (self.excludepattern is None):
            foundexclude = False
        else:
            foundexclude = False
            for p in self.excludepattern:
                if (value.startswith(p.rstrip('0'))):
                    foundexclude = True
                    break
        return foundinclude and not foundexclude

    def __repr__(self):
        return "EcoregionPattern(%r, %r)" % (self.includepattern, self.excludepattern)

#print("register pattern classes")

Pattern.register('rscd', Pattern)
Pattern.register('state', Pattern)
Pattern.register('ecoregion', _EcoregionPattern)
Pattern.register('plantation', Pattern)
Pattern.register('hydric', Pattern)
Pattern.register('riverine', Pattern)
#Pattern.register('species', Pattern)
#use "starts with" pattern matching for species also:
Pattern.register('species', _EcoregionPattern)
Pattern.register('wetland', Pattern)
Pattern.register('ruderal', Pattern)
Pattern.register('exotic', Pattern)
Pattern.register('softwoodhardwood', Pattern)
Pattern.register('planted', Pattern)
Pattern.register('tallytree', Pattern)

class ClassificationKey:
    def __init__(self):
        self.nodes = collections.OrderedDict()
        self.root_node = self._setup()

    def _setup(self):
        self.nodes[  0] = Node(  0, None, ((lambda plot:True), "", ""), "")
        self.nodes[  1] = Node(  1,   0, element_001(), 'Forest Plantations')
        self.nodes[  2] = Node(  2,   1, element_002(), 'Tropical Forest Plantation Cultural Group')
        self.nodes[  3] = Node(  3,   2, element_003(), 'Caribbean Forest Plantation Cultural Subgroup (CSG008)')
        self.nodes[  4] = Node(  4,   3, element_004(), 'Caribbean Conifer Plantations')
        self.nodes[  5] = Node(  5,   4, element_005(), 'Native Caribbean Conifer Plantation Cultural Type (CTY001)')
        self.nodes[  6] = Node(  6,   4, element_006(), 'Exotic Caribbean Conifer Plantation Cultural Type (CTY002)')
        self.nodes[  7] = Node(  7,   3, element_007(), 'Caribbean Hardwood Plantations')
        self.nodes[  8] = Node(  8,   7, element_008(), 'Native Caribbean Hardwood Plantation Cultural Type (CTY003)')
        self.nodes[  9] = Node(  9,   7, element_009(), 'Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)')
        self.nodes[ 10] = Node( 10,   3, element_010(), 'Miscellaneous Caribbean Plantation Cultural Type (CTYP19)')
        self.nodes[ 11] = Node( 11,   1, element_011(), 'Temperate & Boreal Forest Plantation Cultural Group (CGR007)')
        self.nodes[ 12] = Node( 12,  11, element_012(), 'Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)')
        self.nodes[ 13] = Node( 13,  12, element_013(), 'Eastern North American Conifer Plantations')
        self.nodes[ 14] = Node( 14,  13, element_014(), 'Native Eastern North American Conifer Plantations')
        self.nodes[ 15] = Node( 15,  14, element_015(), 'Native Southern Pine Plantation Cultural Type (CTY012)')
        self.nodes[ 16] = Node( 16,  15, element_016(), 'Shortleaf Pine Forest Plantation (CST007169)')
        self.nodes[ 17] = Node( 17,  15, element_017(), 'Longleaf Pine Forest Plantation (CST007176)')
        self.nodes[ 18] = Node( 18,  15, element_018(), 'Slash Pine Forest Plantation (CST007170)')
        self.nodes[ 19] = Node( 19,  15, element_019(), 'Loblolly Pine Forest Plantation (CST007179)')
        self.nodes[ 20] = Node( 20,  15, element_020(), 'Sand Pine Forest Plantation (CST007168)')
        self.nodes[ 21] = Node( 21,  15, element_021(), 'Native Miscellaneous Southern Pine Forest Plantation (CST007160)')
        self.nodes[ 22] = Node( 22,  14, element_022(), 'Native Northern Conifer Plantation')
        self.nodes[ 23] = Node( 23,  22, element_023(), 'Native Northern Pine Plantation Cultural Type (CTY009)')
        self.nodes[ 24] = Node( 24,  23, element_024(), 'Red Pine Forest Plantation (CST007117)')
        self.nodes[ 25] = Node( 25,  23, element_025(), 'White Pine Forest Plantation (CST007178)')
        self.nodes[ 26] = Node( 26,  23, element_026(), 'Jack Pine Forest Plantation (CST007161)')
        self.nodes[ 27] = Node( 27,  23, element_027(), 'Native Miscellaneous Northern Pine Forest Plantation')
        self.nodes[ 28] = Node( 28,  22, element_028(), 'Native Northern Spruce - Fir Plantation Cultural Type (CTY010)')
        self.nodes[ 29] = Node( 29,  28, element_029(), 'White Spruce Forest Plantation (CST007164)')
        self.nodes[ 30] = Node( 30,  28, element_030(), 'Balsam Fir Forest Plantation (CST007182)')
        self.nodes[ 31] = Node( 31,  28, element_031(), 'Red Spruce Forest Plantation (CST004758)')
        self.nodes[ 32] = Node( 32,  28, element_032(), 'Native Miscellaneous Northern Conifer Forest Plantation (CST007163)')
        self.nodes[ 33] = Node( 33,  13, element_033(), 'Exotic Eastern North American Conifer Plantations')
        self.nodes[ 34] = Node( 34,  33, element_034(), 'Exotic Northern Conifer Plantation Cultural Type (CTY014)')
        self.nodes[ 35] = Node( 35,  34, element_035(), 'Scotch Pine Exotic Forest Plantation (CST006313)')
        self.nodes[ 36] = Node( 36,  34, element_036(), 'Norway Spruce Forest Plantation (CST007167)')
        self.nodes[ 37] = Node( 37,  34, element_037(), 'Larch Forest Plantation (CST006408)')
        self.nodes[ 38] = Node( 38,  34, element_038(), 'Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)')
        self.nodes[ 39] = Node( 39,  33, element_039(), 'Exotic Southern Conifer Plantation Cultural Type (CTY015)')
        self.nodes[ 40] = Node( 40,  39, element_040(), 'Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)')
        self.nodes[ 41] = Node( 41,  12, element_041(), 'Eastern North American Hardwood Plantation')
        self.nodes[ 42] = Node( 42,  41, element_042(), 'Native Eastern North American Hardwood Plantations')
        self.nodes[ 43] = Node( 43,  42, element_043(), 'Native Northern Hardwood Forest Plantation Cultural Type (CTY016)')
        self.nodes[ 44] = Node( 44,  43, element_044(), 'Black Walnut Forest Plantation (CST007188)')
        self.nodes[ 45] = Node( 45,  43, element_045(), 'Aspen Forest Plantation (CST007189)')
        self.nodes[ 46] = Node( 46,  43, element_046(), 'Black Locust Forest Plantation (CST007190)')
        self.nodes[ 47] = Node( 47,  43, element_047(), 'Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)')
        self.nodes[ 48] = Node( 48,  42, element_048(), 'Native Southern Hardwood Forest Plantation Cultural Type (CTY017)')
        self.nodes[ 49] = Node( 49,  48, element_049(), 'Tuliptree Forest Plantation (CST007197)')
        self.nodes[ 50] = Node( 50,  48, element_050(), 'Sweetgum Forest Plantation Subtype (CST007450)')
        self.nodes[ 51] = Node( 51,  48, element_051(), 'Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)')
        self.nodes[ 52] = Node( 52,  41, element_052(), 'Exotic Eastern North American Hardwood Plantations')
        self.nodes[ 53] = Node( 53,  52, element_053(), 'Exotic Northern Hardwood Plantation Cultural Type (CTY018)')
        self.nodes[ 54] = Node( 54,  52, element_054(), 'Exotic Southern Hardwood Plantation Cultural Type (CTY019)')
        self.nodes[ 55] = Node( 55,  11, element_055(), 'North American Boreal Forest Plantation Cultural Subgroup')
        self.nodes[ 56] = Node( 56,   0, element_056(), 'Natural and Ruderal Forests')
        self.nodes[ 57] = Node( 57,  56, element_057(), 'Wetland Forest & Woodlands')
        self.nodes[ 58] = Node( 58,  57, element_058(), 'Caribbean Florida Wetland Forest')
        self.nodes[ 59] = Node( 59,  58, element_059(), 'Tropical Florida Natural Wetland Forest')
        self.nodes[ 60] = Node( 60,  59, element_060(), 'Caribbean Swamp Forest via tropical Florida (M617)')
        self.nodes[ 61] = Node( 61,  59, element_061(), 'Western Atlantic & Caribbean Mangrove (M005)')
        self.nodes[ 62] = Node( 62,  58, element_062(), 'Tropical Florida Ruderal Wetland Forest')
        self.nodes[ 63] = Node( 63,  62, element_063(), 'Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)')
        self.nodes[ 64] = Node( 64,  57, element_064(), 'Caribbean Wetland Forest')
        self.nodes[ 65] = Node( 65,  64, element_065(), 'Caribbean Natural Wetland Forest')
        self.nodes[ 66] = Node( 66,  65, element_066(), 'Caribbean Swamp Forest via wetland (M617)')
        self.nodes[ 67] = Node( 67,  64, element_067(), 'Caribbean Ruderal Wetland Forest')
        self.nodes[ 68] = Node( 68,  57, element_068(), 'Temperate & Boreal Wetland Forest')
        self.nodes[ 69] = Node( 69,  68, element_069(), 'Eastern North American Temperate & Boreal Wetland Forest')
        self.nodes[ 70] = Node( 70,  69, element_070(), 'Southeastern North American Flooded & Swamp Forest Division')
        self.nodes[ 71] = Node( 71,  70, element_071(), 'Eastern Warm Temperate Natural Wetland Forest')
        self.nodes[ 72] = Node( 72,  71, element_072(), 'Southern Great Plains Floodplain Forest & Woodland (M154)')
        self.nodes[ 73] = Node( 73,  71, element_073(), 'Pond-cypress Basin Swamp (M161)')
        self.nodes[ 74] = Node( 74,  71, element_074(), 'Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)')
        self.nodes[ 75] = Node( 75,  71, element_075(), 'Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)')
        self.nodes[ 76] = Node( 76,  71, element_076(), 'Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)')
        self.nodes[ 77] = Node( 77,  71, element_077(), 'Pond-cypress Basin Swamp LC (M161)')
        self.nodes[ 78] = Node( 78,  71, element_078(), 'Longleaf Pine Woodland LC2 (M007)')
        self.nodes[ 79] = Node( 79,  71, element_079(), 'Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)')
        self.nodes[ 80] = Node( 80,  70, element_080(), 'Eastern Warm Temperate Ruderal Wetland Forest')
        self.nodes[ 81] = Node( 81,  80, element_081(), 'Southeastern North American Ruderal Flooded & Swamp Forest (M310)')
        self.nodes[ 82] = Node( 82,  69, element_082(), 'Eastern Cool Temperate & North American Boreal Wetland Forest')
        self.nodes[ 83] = Node( 83,  82, element_083(), 'North American Boreal Flooded & Swamp Forest Division')
        self.nodes[ 84] = Node( 84,  83, element_084(), 'North American Boreal Natural Wetland Forest')
        self.nodes[ 85] = Node( 85,  84, element_085(), 'North American Boreal Conifer Poor Swamp (M299)')
        self.nodes[ 86] = Node( 86,  84, element_086(), 'North American Boreal Conifer Poor Swamp LC (M299)')
        self.nodes[ 87] = Node( 87,  83, element_087(), 'North American Boreal Ruderal Wetland Forest')
        self.nodes[ 88] = Node( 88,  82, element_088(), 'Eastern North American - Great Plains Flooded & Swamp Forest Division')
        self.nodes[ 89] = Node( 89,  88, element_089(), 'Eastern Cool Temperate Natural Wetland Forests')
        self.nodes[ 90] = Node( 90,  89, element_090(), 'Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)')
        self.nodes[ 91] = Node( 91,  89, element_091(), 'Central Hardwood Floodplain Forest (M029)')
        self.nodes[ 92] = Node( 92,  89, element_092(), 'Central Hardwood Swamp Forest (M503)')
        self.nodes[ 93] = Node( 93,  89, element_093(), 'Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)')
        self.nodes[ 94] = Node( 94,  89, element_094(), 'Central Hardwood Floodplain Forest LC (M029)')
        self.nodes[ 95] = Node( 95,  89, element_095(), 'Central Hardwood Swamp Forest LC (M503)')
        self.nodes[ 96] = Node( 96,  88, element_096(), 'Eastern Cool Temperate Ruderal Wetland Forests')
        self.nodes[ 97] = Node( 97,  96, element_097(), 'Eastern North American Ruderal Flooded & Swamp Forest (M302)')
        self.nodes[ 98] = Node( 98,  56, element_098(), 'Upland Forest & Woodlands')
        self.nodes[ 99] = Node( 99,  98, element_099(), 'Tropical Forest & Woodland Subclass')
        self.nodes[100] = Node(100,  99, element_100(), 'Tropical Florida - Caribbean Forest')
        self.nodes[101] = Node(101, 100, element_101(), 'Tropical Florida Forest')
        self.nodes[102] = Node(102, 101, element_102(), 'Tropical Florida Natural Forest')
        self.nodes[103] = Node(103, 102, element_103(), 'Caribbean Swamp Forest via upland (M617)')
        self.nodes[104] = Node(104, 102, element_104(), 'Caribbean Coastal Lowland Dry Forest (M134)')
        self.nodes[105] = Node(105, 102, element_105(), 'Caribbean Coastal Lowland Dry Forest LC (M134)')
        self.nodes[106] = Node(106, 101, element_106(), 'Tropical Florida Ruderal Forest')
        self.nodes[107] = Node(107, 106, element_107(), 'Caribbean Ruderal Dry Forest (M514)')
        self.nodes[108] = Node(108, 100, element_108(), 'Caribbean Forest')
        self.nodes[109] = Node(109, 108, element_109(), 'Caribbean Natural Forest')
        self.nodes[110] = Node(110, 109, element_110(), 'Caribbean & Central American Dry Forests')
        self.nodes[111] = Node(111, 110, element_111(), 'Caribbean-Mesoamerican Pine Forest (M296)')
        self.nodes[112] = Node(112, 110, element_112(), 'Caribbean-Mesoamerican Pine Forest LC (M296)')
        self.nodes[113] = Node(113, 108, element_113(), 'Caribbean Ruderal Forest')
        self.nodes[114] = Node(114, 113, element_107(), 'Caribbean Ruderal Dry Forest (M514)')
        self.nodes[115] = Node(115,  98, element_114(), 'Temperate & Boreal Forests')
        self.nodes[116] = Node(116, 115, element_115(), 'Eastern North American Temperate & Boreal Forests')
        self.nodes[117] = Node(117, 116, element_116(), 'Southeastern North American Forest & Woodland Division')
        self.nodes[118] = Node(118, 117, element_117(), 'Southeastern Warm Temperate Natural Forests')
        self.nodes[119] = Node(119, 118, element_118(), 'Southern Mesic Mixed Broadleaf Forest (M008)')
        self.nodes[120] = Node(120, 118, element_119(), 'Longleaf Pine Woodland (M007)')
        self.nodes[121] = Node(121, 118, element_120(), 'Southeastern Coastal Plain Evergreen Oak Forest (M885)')
        self.nodes[122] = Node(122, 118, element_121(), 'Southeastern Coastal Plain Evergreen Oak Forest LC (M885)')
        self.nodes[123] = Node(123, 118, element_122(), 'Longleaf Pine Woodland LC1 (M007)')
        self.nodes[124] = Node(124, 118, element_123(), 'Southern Mesic Mixed Broadleaf Forest LC (M008)')
        self.nodes[125] = Node(125, 117, element_124(), 'Southeastern Warm Temperate Ruderal Forests')
        self.nodes[126] = Node(126, 125, element_125(), 'Southeastern North American Ruderal Forest (M305)')
        self.nodes[127] = Node(127, 116, element_126(), 'Eastern North American Forest & Woodland Division')
        self.nodes[128] = Node(128, 127, element_127(), 'Eastern Cool Temperate Natural Forest & Woodlands')
        self.nodes[129] = Node(129, 128, element_128(), 'Great Plains Forest & Woodland (M151)')
        self.nodes[130] = Node(130, 128, element_129(), 'Northern Forest macrogroups')
        self.nodes[131] = Node(131, 130, element_130(), 'Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)')
        self.nodes[132] = Node(132, 130, element_131(), 'Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)')
        self.nodes[133] = Node(133, 130, element_132(), 'Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)')
        self.nodes[134] = Node(134, 130, element_133(), 'Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)')
        self.nodes[135] = Node(135, 128, element_134(), 'Central Forest macrogroups')
        self.nodes[136] = Node(136, 135, element_135(), 'Central Midwest Oak Forest, Woodland & Savanna (M012)')
        self.nodes[137] = Node(137, 135, element_136(), 'Central Midwest Mesic Forest (M882)')
        self.nodes[138] = Node(138, 135, element_137(), 'Central Midwest Oak Forest, Woodland & Savanna LC (M012)')
        self.nodes[139] = Node(139, 135, element_138(), 'Central Midwest Mesic Forest LC (M882)')
        self.nodes[140] = Node(140, 135, element_139(), 'Appalachian, Interior - Northeastern Mesic Forest (M883)')
        self.nodes[141] = Node(141, 135, element_140(), 'Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)')
        self.nodes[142] = Node(142, 135, element_141(), 'Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)')
        self.nodes[143] = Node(143, 135, element_142(), 'Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)')
        self.nodes[144] = Node(144, 135, element_143(), 'Appalachian, Interior - Northeastern Mesic Forest LC (M883)')
        self.nodes[145] = Node(145, 127, element_144(), 'Eastern Cool Temperate Ruderal Forest & Woodlands')
        self.nodes[146] = Node(146, 145, element_145(), 'Eastern North American Ruderal Forest (M013)')

        for ident, element in self.nodes.items():
            if (element.parent is not None):
                self.nodes[element.parent].children.append(self.nodes[ident])

        return self.nodes[0]

def element_001():

    """Forest Plantations"""
    """Forest Plantations"""
    level = 'division'
    code = 'Forest Plantations'

    # Vegetation shows evidence of intensive human management as planted vegetation,
    # such as trees being planted in rows, often dominated by single-species, and even
    # aged.  The stand is identified as planted in the FIA database (Stand Origin Code
    # = "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001)

    PLANTATION = PatternList('PLANTATION',
        {'plantation': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=001|Forest Plantations', plot.ident)
        result = (plot.match(PLANTATION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_002():

    """Tropical Forest Plantation Cultural Group"""
    """Tropical Forest Plantation Cultural Group"""
    level = 'group'
    code = 'Tropical Forest Plantation Cultural Group'

    # Conifer & Hardwood plantations found in the tropics, including Puerto Rico, U.S. Virgin Islands,
    # and tropical Florida (EcoSection 411A)

    TROPICAL_LOCATION = PatternList('TROPICAL_LOCATION',
        {'state': 'PR'},
        {'state': 'VI'},
        {'state': 'FL', 'ecoregion': '411A'}
    )

    def match(plot):
        logging.debug('%s|NODE=002|Tropical Forest Plantation Cultural Group', plot.ident)
        result = (plot.match(TROPICAL_LOCATION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_003():

    """Caribbean Forest Plantation Cultural Subgroup (CSG008)"""
    """Caribbean Forest Plantation Cultural Subgroup (CSG008)"""
    level = 'subgroup'
    code = 'Caribbean Forest Plantation Cultural Subgroup (CSG008)'

    # Tropical forest plantations found in the Caribbean region,
    # including Puerto Rico, U.S. Virgin Islands, and tropical Florida (EcoSection 411A)

    CARIBBEAN = PatternList('CARIBBEAN',
        {'state': 'PR'},
        {'state': 'VI'},
        {'state': 'FL', 'ecoregion': '411A'}
    )

    def match(plot):
        logging.debug('%s|NODE=003|Caribbean Forest Plantation Cultural Subgroup (CSG008)', plot.ident)
        result = (plot.match(CARIBBEAN))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_004():

    """Caribbean Conifer Plantations"""
    """Caribbean Conifer Plantations"""
    level = 'type'
    code = 'Caribbean Conifer Plantations'

    # Caribbean species are conifers >=25% RIV

    CONIFERS = PatternList('CONIFERS',
        {'softwoodhardwood': 'S'}
    )

    def match(plot):
        logging.debug('%s|NODE=004|Caribbean Conifer Plantations', plot.ident)
        result = (plot.riv(CONIFERS) >= 25)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_005():

    """Native Caribbean Conifer Plantation Cultural Type (CTY001)"""
    """Native Caribbean Conifer Plantation Cultural Type (CTY001)"""
    level = 'type'
    code = 'Native Caribbean Conifer Plantation Cultural Type (CTY001)'

    # Species of native conifers have > RIV than exotic species

    NATIVE_CONIFERS = PatternList('NATIVE_CONIFERS',
        {'softwoodhardwood': 'S', 'exotic': 'no'}
    )

    EXOTIC_CONIFERS = PatternList('EXOTIC_CONIFERS',
        {'softwoodhardwood': 'S', 'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=005|Native Caribbean Conifer Plantation Cultural Type (CTY001)', plot.ident)
        result = (plot.riv(NATIVE_CONIFERS) > plot.riv(EXOTIC_CONIFERS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_006():

    """Exotic Caribbean Conifer Plantation Cultural Type (CTY002)"""
    """Exotic Caribbean Conifer Plantation Cultural Type (CTY002)"""
    level = 'type'
    code = 'Exotic Caribbean Conifer Plantation Cultural Type (CTY002)'

    # other

    def match(plot):
        logging.debug('%s|NODE=006|Exotic Caribbean Conifer Plantation Cultural Type (CTY002)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_007():

    """Caribbean Hardwood Plantations"""
    """Caribbean Hardwood Plantations"""
    level = 'type'
    code = 'Caribbean Hardwood Plantations'

    # Caribbean species are hardwoods >=25% RIV

    HARDWOODS = PatternList('HARDWOODS',
        {'softwoodhardwood': 'H'}
    )

    def match(plot):
        logging.debug('%s|NODE=007|Caribbean Hardwood Plantations', plot.ident)
        result = (plot.riv(HARDWOODS) >= 25)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_008():

    """Native Caribbean Hardwood Plantation Cultural Type (CTY003)"""
    """Native Caribbean Hardwood Plantation Cultural Type (CTY003)"""
    level = 'type'
    code = 'Native Caribbean Hardwood Plantation Cultural Type (CTY003)'

    # Species of native hardwoods have > RIV than exotic species

    NATIVE_HARDWOODS = PatternList('NATIVE_HARDWOODS',
        {'softwoodhardwood': 'H', 'exotic': 'no'}
    )

    EXOTIC_HARDWOODS = PatternList('EXOTIC_HARDWOODS',
        {'softwoodhardwood': 'H', 'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=008|Native Caribbean Hardwood Plantation Cultural Type (CTY003)', plot.ident)
        result = (plot.riv(NATIVE_HARDWOODS) > plot.riv(EXOTIC_HARDWOODS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_009():

    """Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)"""
    """Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)"""
    level = 'type'
    code = 'Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)'

    # other

    def match(plot):
        logging.debug('%s|NODE=009|Exotic Caribbean Hardwood Plantation Cultural Type (CTY004)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_010():

    """Miscellaneous Caribbean Plantation Cultural Type (CTYP19)"""
    """Miscellaneous Caribbean Plantation Cultural Type (CTYP19)"""
    level = 'type'
    code = 'Miscellaneous Caribbean Plantation Cultural Type (CTYP19)'

    # other

    def match(plot):
        logging.debug('%s|NODE=010|Miscellaneous Caribbean Plantation Cultural Type (CTYP19)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_011():

    """Temperate & Boreal Forest Plantation Cultural Group (CGR007)"""
    """Temperate & Boreal Forest Plantation Cultural Group (CGR007)"""
    level = 'group'
    code = 'Temperate & Boreal Forest Plantation Cultural Group (CGR007)'

    # other

    def match(plot):
        logging.debug('%s|NODE=011|Temperate & Boreal Forest Plantation Cultural Group (CGR007)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_012():

    """Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)"""
    """Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)"""
    level = 'subgroup'
    code = 'Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)'

    # Plantations found in eastern temperate region of North America (EcoProvince 210,
    # M210, 220, M220, 230, M230, 250, 310-Texas part only, and 330

    EASTERN_TEMPERATE_REGION = PatternList('EASTERN_TEMPERATE_REGION',
        {'ecoregion': '210, M210, 220, M220, 230, M230, 250, 330'},
        {'ecoregion': '310', 'state': 'TX'}
    )

    def match(plot):
        logging.debug('%s|NODE=012|Eastern North American Temperate Forest Plantation Cultural Subgroup (CSG005)', plot.ident)
        result = (plot.match(EASTERN_TEMPERATE_REGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_013():

    """Eastern North American Conifer Plantations"""
    """Eastern North American Conifer Plantations"""
    level = 'subgroup'
    code = 'Eastern North American Conifer Plantations'

    # Eastern North American species are conifers >=25% RIV

    CONIFERS = PatternList('CONIFERS',
        {'softwoodhardwood': 'S'}
    )

    def match(plot):
        logging.debug('%s|NODE=013|Eastern North American Conifer Plantations', plot.ident)
        result = (plot.riv(CONIFERS) >= 25)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_014():

    """Native Eastern North American Conifer Plantations"""
    """Native Eastern North American Conifer Plantations"""
    level = 'type'
    code = 'Native Eastern North American Conifer Plantations'

    # Tree species dominated by native conifers (See
    # Appendix A) with RIV > exotic conifers

    NATIVE_CONIFERS = PatternList('NATIVE_CONIFERS',
        {'exotic': 'no', 'softwoodhardwood': 'S'}
    )

    EXOTIC_CONIFERS = PatternList('EXOTIC_CONIFERS',
        {'exotic': 'yes', 'softwoodhardwood': 'S'}
    )

    def match(plot):
        logging.debug('%s|NODE=014|Native Eastern North American Conifer Plantations', plot.ident)
        result = (plot.riv(NATIVE_CONIFERS) > plot.riv(EXOTIC_CONIFERS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_015():

    """Native Southern Pine Plantation Cultural Type (CTY012)"""
    """Native Southern Pine Plantation Cultural Type (CTY012)"""
    level = 'type'
    code = 'Native Southern Pine Plantation Cultural Type (CTY012)'

    #  i. Species are native conifers Pinus spp. with >=25% RIV:  Pinus echinata, Pinus elliottii,
    #     Pinus palustris, Pinus taeda, Pinus clausa. [note - this list represents the expected
    #     list of common southern native pine plantation species types.  If other common native
    #     pine plantationspecies are identified, they should be added to this list and
    #     additional couplets added below]
    # OR
    # ii. Species are native conifers found in ecoregion divisions 230, M230, 310 and
    #     ecoprovince 255

    SOUTHERN_PINES = PatternList('SOUTHERN_PINES',
        {'species': 'Pinus echinata'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'},
        {'species': 'Pinus taeda'},
        {'species': 'Pinus clausa'}
    )

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '230, M230, 310, 255'}
    )

    def match(plot):
        logging.debug('%s|NODE=015|Native Southern Pine Plantation Cultural Type (CTY012)', plot.ident)
        result = (plot.riv(SOUTHERN_PINES) >= 25 or plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_016():

    """Shortleaf Pine Forest Plantation (CST007169)"""
    """Shortleaf Pine Forest Plantation (CST007169)"""
    level = 'subtype'
    code = 'Shortleaf Pine Forest Plantation (CST007169)'

    # Tree composition dominated by Pinus echinata; i.e. Pinus echinata >= 25% RIV,
    # and exceeds each species of Pinus elliottii, Pinus palustris, Pinus clausa and Pinus taeda.

    SHORTLEAF_PINE = PatternList('SHORTLEAF_PINE',
        {'species': 'Pinus echinata'}
    )

    LONGLEAF_PINE = PatternList('LONGLEAF_PINE',
        {'species': 'Pinus palustris'}
    )

    SLASH_PINE = PatternList('SLASH_PINE',
        {'species': 'Pinus elliottii'}
    )

    LOBLOLLY_PINE = PatternList('LOBLOLLY_PINE',
        {'species': 'Pinus taeda'}
    )

    SAND_PINE = PatternList('SAND_PINE',
        {'species': 'Pinus clausa'}
    )

    def match(plot):
        logging.debug('%s|NODE=016|Shortleaf Pine Forest Plantation (CST007169)', plot.ident)
        result = (    plot.riv(SHORTLEAF_PINE) >= 25
               and plot.riv(SHORTLEAF_PINE) > plot.riv(LONGLEAF_PINE)
               and plot.riv(SHORTLEAF_PINE) > plot.riv(SLASH_PINE)
               and plot.riv(SHORTLEAF_PINE) > plot.riv(LOBLOLLY_PINE)
               and plot.riv(SHORTLEAF_PINE) > plot.riv(SAND_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_017():

    """Longleaf Pine Forest Plantation (CST007176)"""
    """Longleaf Pine Forest Plantation (CST007176)"""
    level = 'subtype'
    code = 'Longleaf Pine Forest Plantation (CST007176)'

    # Tree composition dominated by Pinus palustris; i.e. Pinus palustris >= 25% RIV,
    # and exceeds each species of Pinus echinata, Pinus elliottii, Pinus clausa and Pinus taeda.

    SHORTLEAF_PINE = PatternList('SHORTLEAF_PINE',
        {'species': 'Pinus echinata'}
    )

    LONGLEAF_PINE = PatternList('LONGLEAF_PINE',
        {'species': 'Pinus palustris'}
    )

    SLASH_PINE = PatternList('SLASH_PINE',
        {'species': 'Pinus elliottii'}
    )

    LOBLOLLY_PINE = PatternList('LOBLOLLY_PINE',
        {'species': 'Pinus taeda'}
    )

    SAND_PINE = PatternList('SAND_PINE',
        {'species': 'Pinus clausa'}
    )

    def match(plot):
        logging.debug('%s|NODE=017|Longleaf Pine Forest Plantation (CST007176)', plot.ident)
        result = (    plot.riv(LONGLEAF_PINE) >= 25
               and plot.riv(LONGLEAF_PINE) > plot.riv(SHORTLEAF_PINE)
               and plot.riv(LONGLEAF_PINE) > plot.riv(SLASH_PINE)
               and plot.riv(LONGLEAF_PINE) > plot.riv(LOBLOLLY_PINE)
               and plot.riv(LONGLEAF_PINE) > plot.riv(SAND_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_018():

    """Slash Pine Forest Plantation (CST007170)"""
    """Slash Pine Forest Plantation (CST007170)"""
    level = 'subtype'
    code = 'Slash Pine Forest Plantation (CST007170)'

    # Tree composition dominated by Pinus elliottii; i.e. Pinus elliotti >= 25% RIV,
    # and exceeds each species of Pinus echinta, Pinus palustris, Pinus clausa or Pinus taeda.

    SHORTLEAF_PINE = PatternList('SHORTLEAF_PINE',
        {'species': 'Pinus echinata'}
    )

    LONGLEAF_PINE = PatternList('LONGLEAF_PINE',
        {'species': 'Pinus palustris'}
    )

    SLASH_PINE = PatternList('SLASH_PINE',
        {'species': 'Pinus elliottii'}
    )

    LOBLOLLY_PINE = PatternList('LOBLOLLY_PINE',
        {'species': 'Pinus taeda'}
    )

    SAND_PINE = PatternList('SAND_PINE',
        {'species': 'Pinus clausa'}
    )

    def match(plot):
        logging.debug('%s|NODE=018|Slash Pine Forest Plantation (CST007170)', plot.ident)
        result = (    plot.riv(SLASH_PINE) >= 25
               and plot.riv(SLASH_PINE) > plot.riv(SHORTLEAF_PINE)
               and plot.riv(SLASH_PINE) > plot.riv(LONGLEAF_PINE)
               and plot.riv(SLASH_PINE) > plot.riv(LOBLOLLY_PINE)
               and plot.riv(SLASH_PINE) > plot.riv(SAND_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_019():

    """Loblolly Pine Forest Plantation (CST007179)"""
    """Loblolly Pine Forest Plantation (CST007179)"""
    level = 'subtype'
    code = 'Loblolly Pine Forest Plantation (CST007179)'

    # Tree composition dominated by Pinus taeda; i.e. Pinus taeda >= 25% RIV,
    # and exceeds each species of Pinus echinta, Pinus elliottii, Pinus clausa or Pinus palustris

    SHORTLEAF_PINE = PatternList('SHORTLEAF_PINE',
        {'species': 'Pinus echinata'}
    )

    LONGLEAF_PINE = PatternList('LONGLEAF_PINE',
        {'species': 'Pinus palustris'}
    )

    SLASH_PINE = PatternList('SLASH_PINE',
        {'species': 'Pinus elliottii'}
    )

    LOBLOLLY_PINE = PatternList('LOBLOLLY_PINE',
        {'species': 'Pinus taeda'}
    )

    SAND_PINE = PatternList('SAND_PINE',
        {'species': 'Pinus clausa'}
    )

    def match(plot):
        logging.debug('%s|NODE=019|Loblolly Pine Forest Plantation (CST007179)', plot.ident)
        result = (    plot.riv(LOBLOLLY_PINE) >= 25
               and plot.riv(LOBLOLLY_PINE) > plot.riv(SHORTLEAF_PINE)
               and plot.riv(LOBLOLLY_PINE) > plot.riv(LONGLEAF_PINE)
               and plot.riv(LOBLOLLY_PINE) > plot.riv(SLASH_PINE)
               and plot.riv(LOBLOLLY_PINE) > plot.riv(SAND_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_020():

    """Sand Pine Forest Plantation (CST007168)"""
    """Sand Pine Forest Plantation (CST007168)"""
    level = 'subtype'
    code = 'Sand Pine Forest Plantation (CST007168)'

    # Tree composition dominated by Pinus clausa >= 25% RIV, and exceeds each
    # species of Pinus echinata, Pinus palustris, Pinus elliottii and Pinus taeda

    SHORTLEAF_PINE = PatternList('SHORTLEAF_PINE',
        {'species': 'Pinus echinata'}
    )

    LONGLEAF_PINE = PatternList('LONGLEAF_PINE',
        {'species': 'Pinus palustris'}
    )

    SLASH_PINE = PatternList('SLASH_PINE',
        {'species': 'Pinus elliottii'}
    )

    LOBLOLLY_PINE = PatternList('LOBLOLLY_PINE',
        {'species': 'Pinus taeda'}
    )

    SAND_PINE = PatternList('SAND_PINE',
        {'species': 'Pinus clausa'}
    )

    def match(plot):
        logging.debug('%s|NODE=020|Sand Pine Forest Plantation (CST007168)', plot.ident)
        result = (    plot.riv(SAND_PINE) >= 25
               and plot.riv(SAND_PINE) > plot.riv(SHORTLEAF_PINE)
               and plot.riv(SAND_PINE) > plot.riv(LONGLEAF_PINE)
               and plot.riv(SAND_PINE) > plot.riv(SLASH_PINE)
               and plot.riv(SAND_PINE) > plot.riv(LOBLOLLY_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_021():

    """Native Miscellaneous Southern Pine Forest Plantation (CST007160)"""
    """Native Miscellaneous Southern Pine Forest Plantation (CST007160)"""
    level = 'subtype'
    code = 'Native Miscellaneous Southern Pine Forest Plantation (CST007160)'

    # other

    def match(plot):
        logging.debug('%s|NODE=021|Native Miscellaneous Southern Pine Forest Plantation (CST007160)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_022():

    """Native Northern Conifer Plantation"""
    """Native Northern Conifer Plantation"""
    level = 'type'
    code = 'Native Northern Conifer Plantation'

    #  i. Species are native conifers dominated by one or more of the following with >=25% RIV:
    #     Pinus banksiana, Pinus resinosa, Pinus strobus, Abies balsamea, Larix laricina, Picea glauca,
    #     or Picea mariana [note - this list represents the expected list of common northern native pine
    #     plantation species types. If other common native pine plantation species are identified, they
    #     should be added to this list and additional couplets added below]
    # OR
    # ii. Species not as above, but found in ecoregion divisions 211, M211, 212, 221, M221, 222,
    #     M222, 251, 223, M223, 231, M231

    NORTHERN_PINES = PatternList('NORTHERN_PINES',
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus resinosa'},
        {'species': 'Pinus strobus'},
        {'species': 'Abies balsamea'},
        {'species': 'Larix laricina'},
        {'species': 'Picea glauca'},
        {'species': 'Picea mariana'}
    )

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '211, M211, 212, 221, M221, 222, M222, 251, 223, M223, 231, M231'}
    )

    def match(plot):
        logging.debug('%s|NODE=022|Native Northern Conifer Plantation', plot.ident)
        result = (plot.riv(NORTHERN_PINES) >= 25 or plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_023():

    """Native Northern Pine Plantation Cultural Type (CTY009)"""
    """Native Northern Pine Plantation Cultural Type (CTY009)"""
    level = 'type'
    code = 'Native Northern Pine Plantation Cultural Type (CTY009)'

    # Native pine species of Pinus spp. [Pinus spp not E = Exotic] exceed non-pine conifers (Native Pinus spp >=50% RIV)

    NATIVE_NORTHERN_PINES = PatternList('NATIVE_NORTHERN_PINES',
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus caribaea'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus clausa'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus elliottii var. elliottii'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus glabra'},
        {'species': 'Pinus palustris'},
        {'species': 'Pinus pungens'},
        {'species': 'Pinus remota'},
        {'species': 'Pinus resinosa'},
        {'species': 'Pinus rigida'},
        {'species': 'Pinus serotina'},
        {'species': 'Pinus strobus'},
        {'species': 'Pinus taeda'},
        {'species': 'Pinus virginiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=023|Native Northern Pine Plantation Cultural Type (CTY009)', plot.ident)
        result = (plot.riv(NATIVE_NORTHERN_PINES) >= 50)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_024():

    """Red Pine Forest Plantation (CST007117)"""
    """Red Pine Forest Plantation (CST007117)"""
    level = 'subtype'
    code = 'Red Pine Forest Plantation (CST007117)'

    # Tree composition dominated by Pinus resinosa >= 25% RIV,
    # and exceeds each species of Pinus banksiana and Pinus strobus.

    RED_PINE = PatternList('RED_PINE',
        {'species': 'Pinus resinosa'}
    )

    JACK_PINE = PatternList('JACK_PINE',
        {'species': 'Pinus banksiana'}
    )

    WHITE_PINE = PatternList('WHITE_PINE',
        {'species': 'Pinus strobus'}
    )

    def match(plot):
        logging.debug('%s|NODE=024|Red Pine Forest Plantation (CST007117)', plot.ident)
        result = (    plot.riv(RED_PINE) >= 25
               and plot.riv(RED_PINE) > plot.riv(JACK_PINE)
               and plot.riv(RED_PINE) > plot.riv(WHITE_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_025():

    """White Pine Forest Plantation (CST007178)"""
    """White Pine Forest Plantation (CST007178)"""
    level = 'subtype'
    code = 'White Pine Forest Plantation (CST007178)'

    # Tree composition dominated by Pinus strobus >= 25% RIV,
    # and exceeds each species of Pinus resinosa and Pinus banksiana.

    WHITE_PINE = PatternList('WHITE_PINE',
        {'species': 'Pinus strobus'}
    )

    RED_PINE = PatternList('RED_PINE',
        {'species': 'Pinus resinosa'}
    )

    JACK_PINE = PatternList('JACK_PINE',
        {'species': 'Pinus banksiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=025|White Pine Forest Plantation (CST007178)', plot.ident)
        result = (    plot.riv(WHITE_PINE) >= 25
               and plot.riv(WHITE_PINE) > plot.riv(RED_PINE)
               and plot.riv(WHITE_PINE) > plot.riv(JACK_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_026():

    """Jack Pine Forest Plantation (CST007161)"""
    """Jack Pine Forest Plantation (CST007161)"""
    level = 'subtype'
    code = 'Jack Pine Forest Plantation (CST007161)'

    # Tree composition dominated by Pinus banksiana >= 25% RIV,
    # and exceeds each species of Pinus resinosa and Pinus strobus.

    JACK_PINE = PatternList('JACK_PINE',
        {'species': 'Pinus banksiana'}
    )

    RED_PINE = PatternList('RED_PINE',
        {'species': 'Pinus resinosa'}
    )

    WHITE_PINE = PatternList('WHITE_PINE',
        {'species': 'Pinus strobus'}
    )

    def match(plot):
        logging.debug('%s|NODE=026|Jack Pine Forest Plantation (CST007161)', plot.ident)
        result = (    plot.riv(JACK_PINE) >= 25
               and plot.riv(JACK_PINE) > plot.riv(RED_PINE)
               and plot.riv(JACK_PINE) > plot.riv(WHITE_PINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_027():

    """Native Miscellaneous Northern Pine Forest Plantation"""
    """Native Miscellaneous Northern Pine Forest Plantation"""
    level = 'subtype'
    code = 'Native Miscellaneous Northern Pine Forest Plantation'

    # other

    def match(plot):
        logging.debug('%s|NODE=027|Native Miscellaneous Northern Pine Forest Plantation', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_028():

    """Native Northern Spruce - Fir Plantation Cultural Type (CTY010)"""
    """Native Northern Spruce - Fir Plantation Cultural Type (CTY010)"""
    level = 'type'
    code = 'Native Northern Spruce - Fir Plantation Cultural Type (CTY010)'

    # Native Pinus species <50% RIV

    def match(plot):
        logging.debug('%s|NODE=028|Native Northern Spruce - Fir Plantation Cultural Type (CTY010)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_029():

    """White Spruce Forest Plantation (CST007164)"""
    """White Spruce Forest Plantation (CST007164)"""
    level = 'subtype'
    code = 'White Spruce Forest Plantation (CST007164)'

    # Tree composition dominated by Picea glauca >=25% RIV,
    # and exceeds each species of Abies balsamea, Larix laricina,
    # Picea rubens and Picea mariana.

    WHITE_SPRUCE = PatternList('WHITE_SPRUCE',
        {'species': 'Picea glauca'}
    )

    BALSAM_FIR = PatternList('BALSAM_FIR',
        {'species': 'Abies balsamea'}
    )

    NATIVE_TAMARACK = PatternList('NATIVE_TAMARACK',
        {'species': 'Larix laricina'}
    )

    RED_SPRUCE = PatternList('RED_SPRUCE',
        {'species': 'Picea rubens'}
    )

    BLACK_SPRUCE = PatternList('BLACK_SPRUCE',
        {'species': 'Picea mariana'}
    )

    def match(plot):
        logging.debug('%s|NODE=029|White Spruce Forest Plantation (CST007164)', plot.ident)
        result = (    plot.riv(WHITE_SPRUCE) >= 25
               and plot.riv(WHITE_SPRUCE) > plot.riv(BALSAM_FIR)
               and plot.riv(WHITE_SPRUCE) > plot.riv(NATIVE_TAMARACK)
               and plot.riv(WHITE_SPRUCE) > plot.riv(RED_SPRUCE)
               and plot.riv(WHITE_SPRUCE) > plot.riv(BLACK_SPRUCE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_030():

    """Balsam Fir Forest Plantation (CST007182)"""
    """Balsam Fir Forest Plantation (CST007182)"""
    level = 'subtype'
    code = 'Balsam Fir Forest Plantation (CST007182)'

    # Tree composition dominated by Abies balsamea >=25% RIV,
    # and exceeds each species of Larix laricina, Picea glauca,
    # Picea rubens and Picea mariana.

    BALSAM_FIR = PatternList('BALSAM_FIR',
        {'species': 'Abies balsamea'}
    )

    NATIVE_TAMARACK = PatternList('NATIVE_TAMARACK',
        {'species': 'Larix laricina'}
    )

    RED_SPRUCE = PatternList('RED_SPRUCE',
        {'species': 'Picea rubens'}
    )

    WHITE_SPRUCE = PatternList('WHITE_SPRUCE',
        {'species': 'Picea glauca'}
    )

    BLACK_SPRUCE = PatternList('BLACK_SPRUCE',
        {'species': 'Picea mariana'}
    )

    def match(plot):
        logging.debug('%s|NODE=030|Balsam Fir Forest Plantation (CST007182)', plot.ident)
        result = (    plot.riv(BALSAM_FIR) >= 25
               and plot.riv(BALSAM_FIR) > plot.riv(NATIVE_TAMARACK)
               and plot.riv(BALSAM_FIR) > plot.riv(WHITE_SPRUCE)
               and plot.riv(BALSAM_FIR) > plot.riv(RED_SPRUCE)
               and plot.riv(BALSAM_FIR) > plot.riv(BLACK_SPRUCE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_031():

    """Red Spruce Forest Plantation (CST004758)"""
    """Red Spruce Forest Plantation (CST004758)"""
    level = 'subtype'
    code = 'Red Spruce Forest Plantation (CST004758)'

    # Tree composition dominated by Picea rubens, i.e., Picea rubens >=25% RIV,
    # and exceeds each species of Abies balsamea, Larix laricina, Picea glauca, and Picea mariana.

    BALSAM_FIR = PatternList('BALSAM_FIR',
        {'species': 'Abies balsamea'}
    )

    NATIVE_TAMARACK = PatternList('NATIVE_TAMARACK',
        {'species': 'Larix laricina'}
    )

    RED_SPRUCE = PatternList('RED_SPRUCE',
        {'species': 'Picea rubens'}
    )

    WHITE_SPRUCE = PatternList('WHITE_SPRUCE',
        {'species': 'Picea glauca'}
    )

    BLACK_SPRUCE = PatternList('BLACK_SPRUCE',
        {'species': 'Picea mariana'}
    )

    def match(plot):
        logging.debug('%s|NODE=031|Red Spruce Forest Plantation (CST004758)', plot.ident)
        result = (    plot.riv(RED_SPRUCE) >= 25
               and plot.riv(RED_SPRUCE) > plot.riv(BALSAM_FIR)
               and plot.riv(RED_SPRUCE) > plot.riv(NATIVE_TAMARACK)
               and plot.riv(RED_SPRUCE) > plot.riv(WHITE_SPRUCE)
               and plot.riv(RED_SPRUCE) > plot.riv(BLACK_SPRUCE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_032():

    """Native Miscellaneous Northern Conifer Forest Plantation (CST007163)"""
    """Native Miscellaneous Northern Conifer Forest Plantation (CST007163)"""
    level = 'subtype'
    code = 'Native Miscellaneous Northern Conifer Forest Plantation (CST007163)'

    # other

    def match(plot):
        logging.debug('%s|NODE=032|Native Miscellaneous Northern Conifer Forest Plantation (CST007163)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_033():

    """Exotic Eastern North American Conifer Plantations"""
    """Exotic Eastern North American Conifer Plantations"""
    level = 'type'
    code = 'Exotic Eastern North American Conifer Plantations'

    # Tree species are dominated by exotic conifers (See
    # Appendix A) with RIV > native conifers.  Implemented as NOT native conifers.

    def match(plot):
        logging.debug('%s|NODE=033|Exotic Eastern North American Conifer Plantations', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_034():

    """Exotic Northern Conifer Plantation Cultural Type (CTY014)"""
    """Exotic Northern Conifer Plantation Cultural Type (CTY014)"""
    level = 'type'
    code = 'Exotic Northern Conifer Plantation Cultural Type (CTY014)'

    # Exotic conifer tree species dominated by Pinus sylvestris,
    # Picea abies, Larix decidua (not used by FIA), or Larix spp. alone or in
    # combination >=25% RIV or stand found in ecodivisions 210, M210, 220, M220,
    # 330 and ecoprovince 251 [note - this list represents the expected list of
    # common exotic conifer plantation species types.  If other common exotic
    # conifer plantation species are identified, they should be added to this list
    # and additional couplets added below].

    COMMON_EXOTIC_CONIFERS = PatternList('COMMON_EXOTIC_CONIFERS',
        {'species': 'Pinus sylvestris'},
        {'species': 'Picea abies'},
        {'species': 'Larix spp.'}
    )

    NORTHERN_REGION = PatternList('NORTHERN_REGION',
        {'ecoregion': '210, M210, 220, M220, 330, 251'}
    )

    def match(plot):
        logging.debug('%s|NODE=034|Exotic Northern Conifer Plantation Cultural Type (CTY014)', plot.ident)
        result = (plot.riv(COMMON_EXOTIC_CONIFERS) >= 25 or plot.match(NORTHERN_REGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_035():

    """Scotch Pine Exotic Forest Plantation (CST006313)"""
    """Scotch Pine Exotic Forest Plantation (CST006313)"""
    level = 'subtype'
    code = 'Scotch Pine Exotic Forest Plantation (CST006313)'

    #  i. Tree composition dominated by Pinus sylvestris with >=50% RIV
    # OR
    # ii. The above tree species, but with >=25% RIV, AND planted Picea abies or
    #     Larix spp. alone or in combination <25%

    SCOTCH_PINE = PatternList('SCOTCH_PINE',
        {'species': 'Pinus sylvestris'}
    )

    NORWAY_SPRUCE_LARCH = PatternList('NORWAY_SPRUCE_LARCH',
        {'species': 'Picea abies'},
        {'species': 'Larix spp.'}
    )

    def match(plot):
        logging.debug('%s|NODE=035|Scotch Pine Exotic Forest Plantation (CST006313)', plot.ident)
        result = (    plot.riv(SCOTCH_PINE) >= 50
               or (plot.riv(SCOTCH_PINE) >= 25 and plot.riv(NORWAY_SPRUCE_LARCH) < 25))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_036():

    """Norway Spruce Forest Plantation (CST007167)"""
    """Norway Spruce Forest Plantation (CST007167)"""
    level = 'subtype'
    code = 'Norway Spruce Forest Plantation (CST007167)'

    #  i. Tree composition dominated by Picea abies with >=50% RIV
    # OR
    # ii. Tree composition dominated by Pinus abies, but with >=25% RIV, AND species
    #     of Pinus sylvestris or Larix spp. alone or in combination <25% RIV

    NORWAY_SPRUCE = PatternList('NORWAY_SPRUCE',
        {'species': 'Picea abies'}
    )

    OTHER_EXOTIC_CONIFERS = PatternList('OTHER_EXOTIC_CONIFERS',
        {'species': 'Pinus sylvestris'},
        {'species': 'Larix spp.'}
    )

    def match(plot):
        logging.debug('%s|NODE=036|Norway Spruce Forest Plantation (CST007167)', plot.ident)
        result = (    plot.riv(NORWAY_SPRUCE) >= 50
               or (plot.riv(NORWAY_SPRUCE) >= 25 and plot.riv(OTHER_EXOTIC_CONIFERS) < 25))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_037():

    """Larch Forest Plantation (CST006408)"""
    """Larch Forest Plantation (CST006408)"""
    level = 'subtype'
    code = 'Larch Forest Plantation (CST006408)'

    #  i. Tree composition dominated by Larix spp. with >=50% RIV
    # OR
    # ii. Tree composition dominated by Larix spp., but with >=25% RIV, AND species
    #     of Pinus sylvestris or Picea abies alone or in combination <25% RIV

    LARIX_SPP = PatternList('LARIX_SPP',
        {'species': 'Larix spp.'}
    )

    OTHER_EXOTIC_CONIFERS = PatternList('OTHER_EXOTIC_CONIFERS',
        {'species': 'Pinus sylvestris'},
        {'species': 'Picea abies'}
    )

    def match(plot):
        logging.debug('%s|NODE=037|Larch Forest Plantation (CST006408)', plot.ident)
        result = (    plot.riv(LARIX_SPP) >= 50
               or (plot.riv(LARIX_SPP) >= 25 and plot.riv(OTHER_EXOTIC_CONIFERS) < 25))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_038():

    """Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)"""
    """Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)"""
    level = 'subtype'
    code = 'Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)'

    # other

    def match(plot):
        logging.debug('%s|NODE=038|Exotic Miscellaneous Northern Conifer Forest Plantation (CST007183)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_039():

    """Exotic Southern Conifer Plantation Cultural Type (CTY015)"""
    """Exotic Southern Conifer Plantation Cultural Type (CTY015)"""
    level = 'type'
    code = 'Exotic Southern Conifer Plantation Cultural Type (CTY015)'

    # Tree species not as above.  Stands found in ecodivisions 230,
    # M230, 310 and ecoprovince 255. [note -if there are common exotic conifer
    # plantation species types in the south, they should be listed here, and
    # additional couplets added below].

    SOUTHERN_REGION = PatternList('SOUTHERN_REGION',
        {'ecoregion': '230, M230, 310, 255'}
    )

    def match(plot):
        logging.debug('%s|NODE=039|Exotic Southern Conifer Plantation Cultural Type (CTY015)', plot.ident)
        result = (plot.match(SOUTHERN_REGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_040():

    """Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)"""
    """Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)"""
    level = 'subtype'
    code = 'Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)'

    # other

    def match(plot):
        logging.debug('%s|NODE=040|Exotic Miscellaneous Southern Conifer Forest Plantation (CST007187)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_041():

    """Eastern North American Hardwood Plantation"""
    """Eastern North American Hardwood Plantation"""
    level = 'subgroup'
    code = 'Eastern North American Hardwood Plantation'

    # Tree species are hardwoods >=75% RIV.  Implemented as NOT (conifers >= 25% RIV)

    def match(plot):
        logging.debug('%s|NODE=041|Eastern North American Hardwood Plantation', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_042():

    """Native Eastern North American Hardwood Plantations"""
    """Native Eastern North American Hardwood Plantations"""
    level = 'type'
    code = 'Native Eastern North American Hardwood Plantations'

    # Tree species dominated by native hardwoods (See
    # Appendix A) with RIV > exotic hardwoods.

    NATIVE_HARDWOODS = PatternList('NATIVE_HARDWOODS',
        {'exotic': 'no', 'softwoodhardwood': 'H'}
    )

    EXOTIC_HARDWOODS = PatternList('EXOTIC_HARDWOODS',
        {'exotic': 'yes', 'softwoodhardwood': 'H'}
    )

    def match(plot):
        logging.debug('%s|NODE=042|Native Eastern North American Hardwood Plantations', plot.ident)
        result = (plot.riv(NATIVE_HARDWOODS) > plot.riv(EXOTIC_HARDWOODS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_043():

    """Native Northern Hardwood Forest Plantation Cultural Type (CTY016)"""
    """Native Northern Hardwood Forest Plantation Cultural Type (CTY016)"""
    level = 'type'
    code = 'Native Northern Hardwood Forest Plantation Cultural Type (CTY016)'

    # Stands found in ecodivisions 210, M210, 220, M220, 330 and ecoprovince 251.

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '210, M210, 220, M220, 330, 251'}
    )

    def match(plot):
        logging.debug('%s|NODE=043|Native Northern Hardwood Forest Plantation Cultural Type (CTY016)', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_044():

    """Black Walnut Forest Plantation (CST007188)"""
    """Black Walnut Forest Plantation (CST007188)"""
    level = 'subtype'
    code = 'Black Walnut Forest Plantation (CST007188)'

    # Tree composition dominated by Juglans nigra >=25% RIV,
    # and exceeds each species of Populus tremuloides,
    # Populus spp., and Robinia pseudoacacia.

    BLACK_WALNUT = PatternList('BLACK_WALNUT',
        {'species': 'Juglans nigra'}
    )

    QUAKING_ASPEN = PatternList('QUAKING_ASPEN',
        {'species': 'Populus tremuloides'}
    )

    POPULUS_SPP = PatternList('POPULUS_SPP',
        {'species': 'Populus spp.'}
    )

    BLACK_LOCUST = PatternList('BLACK_LOCUST',
        {'species': 'Robinia pseudoacacia'}
    )

    def match(plot):
        logging.debug('%s|NODE=044|Black Walnut Forest Plantation (CST007188)', plot.ident)
        result = (    plot.riv(BLACK_WALNUT) >= 25
               and plot.riv(BLACK_WALNUT) > plot.riv(QUAKING_ASPEN)
               and plot.riv(BLACK_WALNUT) > plot.riv(POPULUS_SPP)
               and plot.riv(BLACK_WALNUT) > plot.riv(BLACK_LOCUST))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_045():

    """Aspen Forest Plantation (CST007189)"""
    """Aspen Forest Plantation (CST007189)"""
    level = 'subtype'
    code = 'Aspen Forest Plantation (CST007189)'

    # i. Tree composition dominated by Populus tremuloides, Populus spp. >=25% RIV,
    #    and exceeds each species of Juglans nigra and Robinia pseudoacacia.

    ASPEN = PatternList('ASPEN',
        {'species': 'Populus tremuloides'},
        {'species': 'Populus spp.'}
    )

    BLACK_WALNUT = PatternList('BLACK_WALNUT',
        {'species': 'Juglans nigra'}
    )

    BLACK_LOCUST = PatternList('BLACK_LOCUST',
        {'species': 'Robinia pseudoacacia'}
    )

    def match(plot):
        logging.debug('%s|NODE=045|Aspen Forest Plantation (CST007189)', plot.ident)
        result = (    plot.riv(ASPEN) >= 25
               and plot.riv(ASPEN) > plot.riv(BLACK_WALNUT)
               and plot.riv(ASPEN) > plot.riv(BLACK_LOCUST))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_046():

    """Black Locust Forest Plantation (CST007190)"""
    """Black Locust Forest Plantation (CST007190)"""
    level = 'subtype'
    code = 'Black Locust Forest Plantation (CST007190)'

    # Tree composition dominated by Robinia pseudoacacia, >=25% RIV,
    # and exceeds each species of Juglans nigra, Populus tremuloides
    # and Populus spp.

    BLACK_LOCUST = PatternList('BLACK_LOCUST',
        {'species': 'Robinia pseudoacacia'}
    )

    BLACK_WALNUT = PatternList('BLACK_WALNUT',
        {'species': 'Juglans nigra'}
    )

    QUAKING_ASPEN = PatternList('QUAKING_ASPEN',
        {'species': 'Populus tremuloides'}
    )

    POPULUS_SPP = PatternList('POPULUS_SPP',
        {'species': 'Populus spp.'}
    )

    def match(plot):
        logging.debug('%s|NODE=046|Black Locust Forest Plantation (CST007190)', plot.ident)
        result = (    plot.riv(BLACK_LOCUST) >= 25
               and plot.riv(BLACK_LOCUST) > plot.riv(BLACK_WALNUT)
               and plot.riv(BLACK_LOCUST) > plot.riv(QUAKING_ASPEN)
               and plot.riv(BLACK_LOCUST) > plot.riv(POPULUS_SPP))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_047():

    """Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)"""
    """Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)"""
    level = 'subtype'
    code = 'Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)'

    # other

    def match(plot):
        logging.debug('%s|NODE=047|Native Miscellaneous Northern Hardwood Forest Plantation (CST007193)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_048():

    """Native Southern Hardwood Forest Plantation Cultural Type (CTY017)"""
    """Native Southern Hardwood Forest Plantation Cultural Type (CTY017)"""
    level = 'type'
    code = 'Native Southern Hardwood Forest Plantation Cultural Type (CTY017)'

    # Stands found in ecodivisions 230, M230, 310 and ecoprovince 255.

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '230, M230, 310, 255'}
    )

    def match(plot):
        logging.debug('%s|NODE=048|Native Southern Hardwood Forest Plantation Cultural Type (CTY017)', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_049():

    """Tuliptree Forest Plantation (CST007197)"""
    """Tuliptree Forest Plantation (CST007197)"""
    level = 'subtype'
    code = 'Tuliptree Forest Plantation (CST007197)'

    # Tree composition dominated by Liriodendron tulipifera >=25% RIV,
    # and exceeds species of Liquidambar styraciflua.

    TULIPTREE = PatternList('TULIPTREE',
        {'species': 'Liriodendron tulipifera'}
    )

    SWEETGUM = PatternList('SWEETGUM',
        {'species': 'Liquidambar styraciflua'}
    )

    def match(plot):
        logging.debug('%s|NODE=049|Tuliptree Forest Plantation (CST007197)', plot.ident)
        result = (    plot.riv(TULIPTREE) >= 25
               and plot.riv(TULIPTREE) > plot.riv(SWEETGUM))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_050():

    """Sweetgum Forest Plantation Subtype (CST007450)"""
    """Sweetgum Forest Plantation Subtype (CST007450)"""
    level = 'subtype'
    code = 'Sweetgum Forest Plantation Subtype (CST007450)'

    # Tree composition dominated by Liquidambar styraciflua >=25% RIV,
    # and exceeds species of Liriodendron tulipifera.

    SWEETGUM = PatternList('SWEETGUM',
        {'species': 'Liquidambar styraciflua'}
    )

    TULIPTREE = PatternList('TULIPTREE',
        {'species': 'Liriodendron tulipifera'}
    )

    def match(plot):
        logging.debug('%s|NODE=050|Sweetgum Forest Plantation Subtype (CST007450)', plot.ident)
        result = (    plot.riv(SWEETGUM) >= 25
               and plot.riv(SWEETGUM) > plot.riv(TULIPTREE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_051():

    """Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)"""
    """Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)"""
    level = 'type'
    code = 'Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)'

    # other

    def match(plot):
        logging.debug('%s|NODE=051|Native Miscellaneous Southern Hardwood Forest Plantation (CST007155)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_052():

    """Exotic Eastern North American Hardwood Plantations"""
    """Exotic Eastern North American Hardwood Plantations"""
    level = 'type'
    code = 'Exotic Eastern North American Hardwood Plantations'

    # Tree species dominated by exotic hardwoods (See Appendix A) with RIV > native hardwoods.
    # Implemented as NOT native RIV > exotic RIV.

    def match(plot):
        logging.debug('%s|NODE=052|Exotic Eastern North American Hardwood Plantations', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_053():

    """Exotic Northern Hardwood Plantation Cultural Type (CTY018)"""
    """Exotic Northern Hardwood Plantation Cultural Type (CTY018)"""
    level = 'type'
    code = 'Exotic Northern Hardwood Plantation Cultural Type (CTY018)'

    # Exotic hardwood tree species found in ecodivisions 210, M210, 220, M220, 330
    # and ecoprovince 251. [note - no exotic hardwoods are known to be commonly planted.
    # If common exotic hardwood plantation species are identified, they should be added to
    # this list and additional couplets added below].

    NORTHERN_REGION = PatternList('NORTHERN_REGION',
        {'ecoregion': '210, M210, 220, M220, 330, 251'}
    )

    def match(plot):
        logging.debug('%s|NODE=053|Exotic Northern Hardwood Plantation Cultural Type (CTY018)', plot.ident)
        result = (plot.match(NORTHERN_REGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_054():

    """Exotic Southern Hardwood Plantation Cultural Type (CTY019)"""
    """Exotic Southern Hardwood Plantation Cultural Type (CTY019)"""
    level = 'type'
    code = 'Exotic Southern Hardwood Plantation Cultural Type (CTY019)'

    # Tree species not as above.  Stands found in ecodivisions 230,
    # M230, 310 and ecoprovince 255. [note -if there are common exotic hardwood
    # plantation species types in the south, they should be listed here, and
    # additional couplets added below].

    SOUTHERN_REGION = PatternList('SOUTHERN_REGION',
        {'ecoregion': '230, M230, 310, 255'}
    )

    def match(plot):
        logging.debug('%s|NODE=054|Exotic Southern Hardwood Plantation Cultural Type (CTY019)', plot.ident)
        result = (plot.match(SOUTHERN_REGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_055():

    """North American Boreal Forest Plantation Cultural Subgroup"""
    """North American Boreal Forest Plantation Cultural Subgroup"""
    level = 'subgroup'
    code = 'North American Boreal Forest Plantation Cultural Subgroup'

    # Plantations found in the boreal region of North America (EcoDomain 100)

    BOREAL_REGION = PatternList('BOREAL_REGION',
        {'ecoregion': '100'}
    )

    def match(plot):
        logging.debug('%s|NODE=055|North American Boreal Forest Plantation Cultural Subgroup', plot.ident)
        result = (plot.match(BOREAL_REGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_056():

    """Natural and Ruderal Forests"""
    """Natural and Ruderal Forests"""
    level = 'division'
    code = 'Natural and Ruderal Forests'

    # other

    def match(plot):
        logging.debug('%s|NODE=056|Natural and Ruderal Forests', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_057():

    """Wetland Forest & Woodlands"""
    """Wetland Forest & Woodlands"""
    level = 'division'
    code = 'Wetland Forest & Woodlands'

    #   i. The "physiographic class code" in FIA database is NOT in the Hydric or Riverine series, AND EITHER
    #      ia. the "obligate wet" (W1) species (see Appendix A) have a combined RIV >=20%; OR
    #      ib. the "obligate wet" (W1) species have at least a combined RIV of >=5%, and the combination
    #          of "obligate wet" (W1) and "facultative wet" (W2) has a combined RIV of >=50%, OR
    #      ic. "facultative wet" (W2) tree species have a combined RIV of >=60%,
    #      id. "facultative wet" (W2) tree species have at least a combined RIV > 30%, and the combination
    #          of "facultative wet" (W2) and "facultative" (W3) > 70%, OR
    #      ie. Wetland indicators W1, W2 (WI) > Upland indicators (UI).  Do not include exotic or
    #          FAC(W3) species.
    #  ii. if "physiographic class code" in FIA database is in the Hydric or Riverine series, AND EITHER
    #      iia. the "obligate wet" (W1) wetland diagnostic species have a combined RIV of (>=10%), OR
    #      iib. the "obligate wet" (W1) species have at least a combined RIV of >=5%, and the combination
    #           of "obligate wet" (W1) and "facultative wet" (W2) have a combined RIV of >=40%, OR
    #      iic. the "facultative wet" (W2) tree species have a combined RIV of >= 50%
    #      iid. "facultative wet" (W2) tree species have at least a combined RIV > 20%, and the combination
    #           of "facultative wet" (W2) and "facultative" (W3) > 60%, OR
    #      iie. Wetland indicators W1, W2 (WI) > Upland indicators (UI).  Do not include exotic or
    #           FAC(W3) species.
    #      iif. "facultative" (W3) have combine RIV >= 80%
    # iii. the ecoregion is 231E, 231G, OR 255 AND
    #      iiia. The "physiographic class code" in FIA Database is in the Riverine series
    #      OR
    #      iiib. The "obligate wet" (W1) species have at least a combined RIV >=5%, and the combination of
    #            "obligate wet" (W1), "facultative wet" (W2), "facultative" (W3), and Gleditsia triacanthos
    #            and Quercus virginiana have a combined RIV >=50%
    #  iv. the ecoregion is 211, M211, 212, AND
    #      the combination of "obligate wet" (W1) and "facultative wet" (W2) >= 50%,
    #      OR
    #      Fraxinus nigra, Larix laricina, Picea mariana, Populus balsamifera, and Thuja occidentalis have a combined RIV >= 25%

    HYDRIC_OR_RIVERINE = PatternList('HYDRIC_OR_RIVERINE',
        {'hydric': 'yes'},
        {'riverine': 'yes'}
    )

    W1 = PatternList('W1',
        {'wetland': 'obl'}
    )

    W2 = PatternList('W2',
        {'wetland': 'facw'}
    )

    W3 = PatternList('W3',
        {'wetland': 'fac'}
    )

    WETLAND = PatternList('WETLAND',
        {'wetland': 'obl, facw', 'exotic': 'no'}
    )

    UPLAND = PatternList('UPLAND',
        {'wetland': 'upl', 'exotic': 'no'}
    )

    ECOREGIONS_III = PatternList('ECOREGIONS_III',
        {'ecoregion': '231E, 231G, 255'}
    )

    RIVERINE = PatternList('RIVERINE',
        {'riverine': 'yes'}
    )

    SPECIES_III = PatternList('SPECIES_III',
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Quercus virginiana'}
    )

    ECOREGIONS_IV = PatternList('ECOREGIONS_IV',
        {'ecoregion': '211, M211, 212'}
    )

    SPECIES_IV = PatternList('SPECIES_IV',
        {'species': 'Fraxinus nigra'},
        {'species': 'Larix laricina'},
        {'species': 'Picea mariana'},
        {'species': 'Populus balsamifera'},
        {'species': 'Thuja occidentalis'}
    )

    def match(plot):
        logging.debug('%s|NODE=057|Wetland Forest & Woodlands', plot.ident)
        result = (   (not plot.match(HYDRIC_OR_RIVERINE) and (    plot.riv(W1) >= 20
                                                      or (plot.riv(W1) >= 5 and plot.riv(W1) + plot.riv(W2) >= 50)
                                                      or  plot.riv(W2) >= 60
                                                      or (plot.riv(W2) >= 30 and plot.riv(W2) + plot.riv(W3) >= 70)
                                                      or  plot.riv(WETLAND) > plot.riv(UPLAND)
                                                     ))
               or (    plot.match(HYDRIC_OR_RIVERINE) and (    plot.riv(W1) >= 10
                                                      or (plot.riv(W1) >= 5 and plot.riv(W1) + plot.riv(W2) >= 40)
                                                      or plot.riv(W2) >= 50
                                                      or (plot.riv(W2) >= 20 and plot.riv(W2) + plot.riv(W3) >= 60)
                                                      or plot.riv(WETLAND) > plot.riv(UPLAND)
                                                      or plot.riv(W3) >= 80
                                                     ))
               or (plot.match(ECOREGIONS_III) and (plot.match(RIVERINE) or (plot.riv(W1) >= 5 and plot.riv(W1) + plot.riv(W2) + plot.riv(W3) + plot.riv(SPECIES_III) >= 50)))
               or (plot.match(ECOREGIONS_IV) and (plot.riv(W1) + plot.riv(W2) >= 50 or plot.riv(SPECIES_IV) >= 25)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_058():

    """Caribbean Florida Wetland Forest"""
    """Caribbean Florida Wetland Forest"""
    level = 'division'
    code = 'Caribbean Florida Wetland Forest'

    #  i. Plots found in Ecosection 411A (Tropical Florida) BUT excluding stands with Persea borbonia,
    #     Pinus elliottii, Quercus virginiana, Taxodium ascendens >=20% RIV.
    # OR
    # ii. Plots found in Ecosection 232 (Tropical Florida and Gulf or Atlantic coast)
    #     AND with tree composition dominated by one or more of Avicennia germinans, Conocarpus erectus,
    #     Laguncularia racemosa, Rhizophora mangle (>=20% RIV);

    TROPICAL_FLORIDA = PatternList('TROPICAL_FLORIDA',
        {'state': 'FL', 'ecoregion': '411A'}
    )

    EXCLUDED_SPECIES = PatternList('EXCLUDED_SPECIES',
        {'species': 'Persea borbonia'},
        {'species': 'Pinus elliottii'},
        {'species': 'Quercus virginiana'},
        {'species': 'Taxodium ascendens'}
    )

    GULF_OR_ATLANTIC_COAST = PatternList('GULF_OR_ATLANTIC_COAST',
        {'ecoregion': '232'}
    )

    DIAGNOSTIC_SPECIES = PatternList('DIAGNOSTIC_SPECIES',
        {'species': 'Avicennia germinans'},
        {'species': 'Conocarpus erectus'},
        {'species': 'Laguncularia racemosa'},
        {'species': 'Rhizophora mangle'}
    )

    def match(plot):
        logging.debug('%s|NODE=058|Caribbean Florida Wetland Forest', plot.ident)
        result = (    (plot.match(TROPICAL_FLORIDA) and plot.riv(EXCLUDED_SPECIES) < 20)
                or (plot.match(GULF_OR_ATLANTIC_COAST) and plot.riv(DIAGNOSTIC_SPECIES) >= 20))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_059():

    """Tropical Florida Natural Wetland Forest"""
    """Tropical Florida Natural Wetland Forest"""
    level = 'division'
    code = 'Tropical Florida Natural Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=059|Tropical Florida Natural Wetland Forest', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_060():

    """Caribbean Swamp Forest via tropical Florida (M617)"""
    """Caribbean Swamp Forest via tropical Florida (M617)"""
    level = 'macrogroup'
    code = 'Caribbean Swamp Forest via tropical Florida (M617)'

    #  i. Tree composition dominated by Annona glabra, Fraxinus caroliniana,
    #     Salix caroliniana, Taxodium distichum, Sabal palmetto (>=50% RIV); stands only
    #     found in EcoSection 411A [note FIA database does not list these species];
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are any
    #     combination of Conocarpus erectus, Magnolia virginiana, Persea borbonia,
    #     Salix caroliniana, other palms (together >=50% RIV);
    # 
    # [Note that because FIA does not list many of these species in their database,
    #  this type may overlap with MG 7, since Magnolia virginiana and Persea borbonia
    #  are diagnostic in that MG]

    ECOREGION = PatternList('ECOREGION',
        {'ecoregion': '411A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Annona glabra'},
        {'species': 'Fraxinus caroliniana'},
        {'species': 'Salix caroliniana'},
        {'species': 'Taxodium distichum'},
        {'species': 'Sabal palmetto'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Conocarpus erectus'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Salix caroliniana'},
        {'species': 'other palms'}
    )

    def match(plot):
        logging.debug('%s|NODE=060|Caribbean Swamp Forest via tropical Florida (M617)', plot.ident)
        result = (     plot.match(ECOREGION)
               and (    plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
                    or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_061():

    """Western Atlantic & Caribbean Mangrove (M005)"""
    """Western Atlantic & Caribbean Mangrove (M005)"""
    level = 'macrogroup'
    code = 'Western Atlantic & Caribbean Mangrove (M005)'

    # Tree composition dominated by one or more of Avicennia germinans, Conocarpus erectus,
    # Laguncularia racemosa, Rhizophora mangle (>=20% RIV);

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Avicennia germinans'},
        {'species': 'Conocarpus erectus'},
        {'species': 'Laguncularia racemosa'},
        {'species': 'Rhizophora mangle'}
    )

    def match(plot):
        logging.debug('%s|NODE=061|Western Atlantic & Caribbean Mangrove (M005)', plot.ident)
        result = (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_062():

    """Tropical Florida Ruderal Wetland Forest"""
    """Tropical Florida Ruderal Wetland Forest"""
    level = 'division'
    code = 'Tropical Florida Ruderal Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=062|Tropical Florida Ruderal Wetland Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_063():

    """Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)"""
    """Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)"""
    level = 'macrogroup'
    code = 'Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)'

    # Only one macrogroup.

    def match(plot):
        logging.debug('%s|NODE=063|Tropical Florida Ruderal Flooded & Swamp Forest (Mnew1)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_064():

    """Caribbean Wetland Forest"""
    """Caribbean Wetland Forest"""
    level = 'division'
    code = 'Caribbean Wetland Forest'

    # Tropical wetland forests found in Puerto Rico, U.S. Virgin Islands and other Caribbean territories

    CARIBBEAN = PatternList('CARIBBEAN',
        {'state': 'PR'},
        {'state': 'VI'}
    )

    def match(plot):
        logging.debug('%s|NODE=064|Caribbean Wetland Forest', plot.ident)
        result = (plot.match(CARIBBEAN))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_065():

    """Caribbean Natural Wetland Forest"""
    """Caribbean Natural Wetland Forest"""
    level = 'division'
    code = 'Caribbean Natural Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=065|Caribbean Natural Wetland Forest', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_066():

    """Caribbean Swamp Forest via wetland (M617)"""
    """Caribbean Swamp Forest via wetland (M617)"""
    level = 'macrogroup'
    code = 'Caribbean Swamp Forest via wetland (M617)'

    # Only one Macrogroup reported for the Caribbean U.S., its territories and commonwealth.
    # See also M618 (Caribbean Floodplain Forest) reported elsewhere in the Caribbean, and
    # likely present in Puerto Rico

    def match(plot):
        logging.debug('%s|NODE=066|Caribbean Swamp Forest via wetland (M617)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_067():

    """Caribbean Ruderal Wetland Forest"""
    """Caribbean Ruderal Wetland Forest"""
    level = 'division'
    code = 'Caribbean Ruderal Wetland Forest'

    # At this time, no ruderal types are know in the Caribbean region of the U.S., its
    # territories and commonwealth.

    def match(plot):
        logging.debug('%s|NODE=067|Caribbean Ruderal Wetland Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_068():

    """Temperate & Boreal Wetland Forest"""
    """Temperate & Boreal Wetland Forest"""
    level = 'division'
    code = 'Temperate & Boreal Wetland Forest'

    # other

    def match(plot):
        logging.debug('%s|NODE=068|Temperate & Boreal Wetland Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_069():

    """Eastern North American Temperate & Boreal Wetland Forest"""
    """Eastern North American Temperate & Boreal Wetland Forest"""
    level = 'division'
    code = 'Eastern North American Temperate & Boreal Wetland Forest'

    # Eastern North American wetland Temperate & Boreal Forest (all forests found
    # in EcoSection 411A, EcoDomain Humid Temperate (200 or M200) of the eastern
    # United States and Canada, and EcoDomain Polar (100 or M100) east of Alberta
    # and the Yukon [may not need worry about east-west boreal line since tree
    # species for Macrogroups are the same across the line.

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '411A, 200, M200, 100, M100'}
    )

    def match(plot):
        logging.debug('%s|NODE=069|Eastern North American Temperate & Boreal Wetland Forest', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_070():

    """Southeastern North American Flooded & Swamp Forest Division"""
    """Southeastern North American Flooded & Swamp Forest Division"""
    level = 'division'
    code = 'Southeastern North American Flooded & Swamp Forest Division'

    #  i. Tree composition dominated by one or more of conifers of Chamaecyparis thyoides, Pinus elliottii,
    #     Pinus glabra, Pinus palustris, Pinus serotina, Pinus taeda, Taxodium distichum, Taxodium ascendens,
    #     or hardwoods Carya aquatica, Fraxinus caroliniana, Fraxinus profunda, Gleditsia aquatica,
    #     Gordonia lasianthus, Halesia diptera, Juglans major, Juglans microcarpa, Magnolia virginiana,
    #     Nyssa aquatica, Nyssa biflora, Planera aquatica, Persea borbonia, Nyssa ogeche, Quercus laurifolia,
    #     Quercus lyrata, Quercus michauxii, Quercus nigra, Quercus pagoda, Quercus sinuata var. sinuata,
    #     Quercus texana, Quercus virginiana, Sabal palmetto, Ulmus crassifolia (>=20% RIV); EXCLUDING coastal
    #     plain forests of MD, NY, NJ, PA, DE, VA or Ecoregion 221.
    # OR
    # ii. STANDS FOUND in EcoProvince 231, 232, 234 and 255 (but EXCLUDING KS and coastal plain forests
    #     of MD, NY, NJ, PA, DE)
    # 
    # [Note: Tree composition that fits c.ii. (i.e lack strong diagnostics but are found in coastal plain forest
    # wetlands could include stands dominated by one or more of conifers of Pinus taeda or hardwoods  Acer saccharinum,
    # Acer rubrum, Celtis laevigata, Fraxinus pennsylvanica, Liquidambar styraciflua, Platanus occidentalis Salix nigra,
    # Quercus macrocarpa, Quercus shumardii, Ulmus americana, Ulmus crassifolia (>=50% RIV); OR Tree composition as above,
    # but with >=20% RIV; AND other species are any combination of Acer negundo, Carpinus caroliniana, Ilex opaca,
    # Magnolia grandiflora (together >=50% RIV), OR All Ruderal stands where ruderals >= 80% RIV]

    EXCLUDED_REGIONS = PatternList('EXCLUDED_REGIONS',
        {'state': 'MD, NY, NJ, PA, DE, VA'},
        {'ecoregion': '221'}
    )

    DIAGNOSTIC_SPECIES = PatternList('DIAGNOSTIC_SPECIES',
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus glabra'},
        {'species': 'Pinus palustris'},
        {'species': 'Pinus serotina'},
        {'species': 'Pinus taeda'},
        {'species': 'Taxodium distichum'},
        {'species': 'Taxodium ascendens'},
        {'species': 'Carya aquatica'},
        {'species': 'Fraxinus caroliniana'},
        {'species': 'Fraxinus profunda'},
        {'species': 'Gleditsia aquatica'},
        {'species': 'Gordonia lasianthus'},
        {'species': 'Halesia diptera'},
        {'species': 'Juglans major'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Nyssa aquatica'},
        {'species': 'Nyssa biflora'},
        {'species': 'Planera aquatica'},
        {'species': 'Persea borbonia'},
        {'species': 'Nyssa ogeche'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus lyrata'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus sinuata var. sinuata'},
        {'species': 'Quercus texana'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'},
        {'species': 'Ulmus crassifolia'}
    )

    ECOREGIONS_II = PatternList('ECOREGIONS_II',
        {'ecoregion': '231, 232, 234, 255', 'state': '!KS, MD, NY, NJ, PA, DE'}
    )

    def match(plot):
        logging.debug('%s|NODE=070|Southeastern North American Flooded & Swamp Forest Division', plot.ident)
        result = ((not plot.match(EXCLUDED_REGIONS) and plot.riv(DIAGNOSTIC_SPECIES) >= 20) or plot.match(ECOREGIONS_II))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_071():

    """Eastern Warm Temperate Natural Wetland Forest"""
    """Eastern Warm Temperate Natural Wetland Forest"""
    level = 'division'
    code = 'Eastern Warm Temperate Natural Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=071|Eastern Warm Temperate Natural Wetland Forest', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_072():

    """Southern Great Plains Floodplain Forest & Woodland (M154)"""
    """Southern Great Plains Floodplain Forest & Woodland (M154)"""
    level = 'macrogroup'
    code = 'Southern Great Plains Floodplain Forest & Woodland (M154)'

    # Stands found in Ecoregion 255B-D, 315C-E, 315G, 321B AND Tree composition dominated by:
    #  i. Tree composition dominated by one or more of STRONG SOUTHERN GREAT PLAINS DIAGNOSTICS,
    #     Carya illinoinensis, Celtis laevigata var. reticulata, Fraxinus pennsylvanica, Juglans microcarpa,
    #     Juglans nigra, Juglans major, Platanus occidentalis, Populus deltoides, Quercus shumardii,
    #     Quercus virginiana, Salix nigra Taxodium distichum, Ulmus americana, Ulmus crassifolia (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV; AND other species are any combination of
    #     MODERATE DIAGNOSTICS, Acer negundo, Celtis occidentalis, iospyros virginiana, Gleditsia triacanthos,
    #     Juglans nigra, Maclura pomifera, Prosopis glandulosa, Quercus macrocarpa, Quercus nigra,
    #     Sapindus saponaria var. drummondii, Sideroxylon lanuginosum ssp. lanuginosum,
    #     Ulmus crassifolia (together >=50% RIV)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '255B, 255C, 255D, 315C, 315D, 315E, 315G, 321B'}
    )

    STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS = PatternList('STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS',
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata var. reticulata'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Juglans nigra'},
        {'species': 'Juglans major'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus virginiana'},
        {'species': 'Salix nigra'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Juglans nigra'},
        {'species': 'Maclura pomifera'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Sideroxylon lanuginosum ssp. lanuginosum'},
        {'species': 'Ulmus crassifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=072|Southern Great Plains Floodplain Forest & Woodland (M154)', plot.ident)
        result = (     plot.match(ECOREGIONS)
               and (    plot.riv(STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS) >= 50
                    or (    plot.riv(STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS) >= 20
                        and plot.riv(STRONG_SOUTHERN_GREAT_PLAINS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_073():

    """Pond-cypress Basin Swamp (M161)"""
    """Pond-cypress Basin Swamp (M161)"""
    level = 'macrogroup'
    code = 'Pond-cypress Basin Swamp (M161)'

    #  i. Tree composition dominated by STRONG POND CYPRESS DIAGNOSTICS
    #     Taxodium distichum var. nutans (= Taxodium ascendens) (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are
    #     any combination of MODERATE DIAGNOSTICS coastal plain species of Acer rubrum,
    #     Annona glabra, Liriodendron tulipifera, Liquidambar styraciflua,
    #     Nyssa sylvatica var. biflora (= Nyssa biflora), Persea borbonia (= Persea palustris),
    #     Pinus serotina, Pinus elliottii, Pinus taeda, Taxodium distichum, Sabal palmetto
    #     (together >=50% RIV).

    STRONG_POND_CYPRESS_DIAGNOSTICS = PatternList('STRONG_POND_CYPRESS_DIAGNOSTICS',
        {'species': 'Taxodium ascendens'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer rubrum'},
        {'species': 'Annona glabra'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Nyssa biflora'},
        {'species': 'Persea borbonia'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus serotina'},
        {'species': 'Pinus taeda'},
        {'species': 'Taxodium distichum'},
        {'species': 'Sabal palmetto'}
    )

    def match(plot):
        logging.debug('%s|NODE=073|Pond-cypress Basin Swamp (M161)', plot.ident)
        result = (    plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) >= 50
               or (    plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) >= 20
                   and plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_074():

    """Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)"""
    """Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)"""
    level = 'macrogroup'
    code = 'Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)'

    # Plots found in ecosection 231A, B, D, E, 232A-D, F, G AND
    # tree composition, with STRONG SWAMP DIAGNOSTICS Pinus palustris < 5% RIV AND dominated by one or more
    # of Chamaecyparis thyoides, Cliftonia monophylla [not tracked by FIA], Fraxinus caroliniana, Gordonia lasianthus,
    # Magnolia virginiana, Persea borbonia, Pinus serotina or Quercus laurifolia, Sabal palmetto (>=20% RIV);

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '231A, 231B, 231D, 231E, 232A, 232B, 232C, 232D, 232F, 232G'}
    )

    EXCLUDED_SPECIES = PatternList('EXCLUDED_SPECIES',
        {'species': 'Pinus palustris'}
    )

    STRONG_SWAMP_DIAGNOSTICS = PatternList('STRONG_SWAMP_DIAGNOSTICS',
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Cliftonia monophylla'},
        {'species': 'Fraxinus caroliniana'},
        {'species': 'Gordonia lasianthus'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Pinus serotina'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Sabal palmetto'}
    )

    def match(plot):
        logging.debug('%s|NODE=074|Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest (M032)', plot.ident)
        result = (plot.match(ECOREGIONS) and (plot.riv(EXCLUDED_SPECIES) < 5 and plot.riv(STRONG_SWAMP_DIAGNOSTICS) >= 20))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_075():

    """Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)"""
    """Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)"""
    level = 'macrogroup'
    code = 'Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)'

    #  i. Tree composition dominated by STRONG FLOODPLAIN DIAGNOSTICS Acer saccharinum, Carya aquatica, Betula nigra,
    #     Carya illinoinensis, Celtis laevigata, Fraxinus pennsylvanica, Fraxinus profunda, Liquidambar styraciflua,
    #     Gleditsia aquatica, Juniperus virginiana var. silicicola, Nyssa aquatica, Nyssa biflora, Nyssa ogeche,
    #     Planera aquatica, Platanus occidentalis, Populus deltoides, Quercus falcata var. pagodifolia (= Q. pagoda),
    #     Quercus laurifolia, Quercus lyrata, Quercus michauxii, Quercus nigra, Quercus phellos, Quercus shumardii,
    #     Quercus texana, Salix caroliniana, Salix nigra, Sapindus saponaria var. drummondii, Taxodium distichum,
    #     Ulmus americana, Ulmus crassifolia (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with at least 20% RIV; AND in combination with other species of MODERATE DIAGNOSTICS
    #     Acer negundo, Acer rubrum, Carpinus caroliniana, Chamaecyparis thyoides, Gleditsia triacanthos, Halesia diptera,
    #     Ilex opaca, Juglans nigra, Liriodendron tulipifera, Magnolia grandiflora, Magnolia virginiana, Nyssa sylvatica,
    #     Pinus elliottii, Pinus glabra, Pinus taeda, Quercus macrocarpa, Sabal palmetto, Ulmus rubra, Ulmus serotina (together >=50% RIV)

    STRONG_FLOODPLAIN_DIAGNOSTICS = PatternList('STRONG_FLOODPLAIN_DIAGNOSTICS',
        {'species': 'Acer saccharinum'},
        {'species': 'Carya aquatica'},
        {'species': 'Betula nigra'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Fraxinus profunda'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Gleditsia aquatica'},
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Nyssa aquatica'},
        {'species': 'Nyssa biflora'},
        {'species': 'Nyssa ogeche'},
        {'species': 'Planera aquatica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus lyrata'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus texana'},
        {'species': 'Salix caroliniana'},
        {'species': 'Salix nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Acer rubrum'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Halesia diptera'},
        {'species': 'Ilex opaca'},
        {'species': 'Juglans nigra'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Magnolia grandiflora'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus glabra'},
        {'species': 'Pinus taeda'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Sabal palmetto'},
        {'species': 'Ulmus rubra'},
        {'species': 'Ulmus serotina'}
    )

    def match(plot):
        logging.debug('%s|NODE=075|Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods (M033)', plot.ident)
        result = (    plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS) >= 50
               or (    plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS) >= 20
                   and plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_076():

    """Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)"""
    """Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)"""
    level = 'macrogroup'
    code = 'Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)'

    # Plots found in ecosection 231A, B, D, E, 232A-D, F, G AND
    # % RIV of STRONG SWAMP DIAGNOSTICS > either STRONG POND CYPRESS DIAGNOSTICS
    # or STRONG LONGLEAF DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '231A, 231B, 231D, 231E, 232A, 232B, 232C, 232D, 232F, 232G'}
    )

    STRONG_POND_CYPRESS_DIAGNOSTICS = PatternList('STRONG_POND_CYPRESS_DIAGNOSTICS',
        {'species': 'Taxodium ascendens'}
    )

    STRONG_LONGLEAF_DIAGNOSTICS = PatternList('STRONG_LONGLEAF_DIAGNOSTICS',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'}
    )

    STRONG_SWAMP_DIAGNOSTICS = PatternList('STRONG_SWAMP_DIAGNOSTICS',
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Cliftonia monophylla'},
        {'species': 'Fraxinus caroliniana'},
        {'species': 'Gordonia lasianthus'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Pinus serotina'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Sabal palmetto'}
    )

    STRONG_FLOODPLAIN_DIAGNOSTICS = PatternList('STRONG_FLOODPLAIN_DIAGNOSTICS',
        {'species': 'Acer saccharinum'},
        {'species': 'Carya aquatica'},
        {'species': 'Betula nigra'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Fraxinus profunda'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Gleditsia aquatica'},
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Nyssa aquatica'},
        {'species': 'Nyssa biflora'},
        {'species': 'Nyssa ogeche'},
        {'species': 'Planera aquatica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus lyrata'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus texana'},
        {'species': 'Salix caroliniana'},
        {'species': 'Salix nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=076|Southern Coastal Plain Evergreen Hardwood - Conifer Swamp Forest LC (M032)', plot.ident)
        result = (plot.match(ECOREGIONS) and
                    (plot.riv(STRONG_SWAMP_DIAGNOSTICS) > plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS)
                  or plot.riv(STRONG_SWAMP_DIAGNOSTICS) > plot.riv(STRONG_LONGLEAF_DIAGNOSTICS)
                  or plot.riv(STRONG_SWAMP_DIAGNOSTICS) > plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_077():

    """Pond-cypress Basin Swamp LC (M161)"""
    """Pond-cypress Basin Swamp LC (M161)"""
    level = 'macrogroup'
    code = 'Pond-cypress Basin Swamp LC (M161)'

    # % RIV OF STRONG POND CYPRESS DIAGNOSTICS > STRONG LONGLEAF DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

    STRONG_POND_CYPRESS_DIAGNOSTICS = PatternList('STRONG_POND_CYPRESS_DIAGNOSTICS',
        {'species': 'Taxodium ascendens'}
    )

    STRONG_LONGLEAF_DIAGNOSTICS = PatternList('STRONG_LONGLEAF_DIAGNOSTICS',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'}
    )

    STRONG_SWAMP_DIAGNOSTICS = PatternList('STRONG_SWAMP_DIAGNOSTICS',
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Cliftonia monophylla'},
        {'species': 'Fraxinus caroliniana'},
        {'species': 'Gordonia lasianthus'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Pinus serotina'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Sabal palmetto'}
    )

    STRONG_FLOODPLAIN_DIAGNOSTICS = PatternList('STRONG_FLOODPLAIN_DIAGNOSTICS',
        {'species': 'Acer saccharinum'},
        {'species': 'Carya aquatica'},
        {'species': 'Betula nigra'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Fraxinus profunda'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Gleditsia aquatica'},
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Nyssa aquatica'},
        {'species': 'Nyssa biflora'},
        {'species': 'Nyssa ogeche'},
        {'species': 'Planera aquatica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus lyrata'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus texana'},
        {'species': 'Salix caroliniana'},
        {'species': 'Salix nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=077|Pond-cypress Basin Swamp LC (M161)', plot.ident)
        result = (   plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) > plot.riv(STRONG_LONGLEAF_DIAGNOSTICS)
               or plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS) > plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_078():

    """Longleaf Pine Woodland LC2 (M007)"""
    """Longleaf Pine Woodland LC2 (M007)"""
    level = 'macrogroup'
    code = 'Longleaf Pine Woodland LC2 (M007)'

    # % RIV OF STRONG LONGLEAF DIAGNOSTICS > either STRONG POND CYPRESS DIAGNOSTICS or STRONG FLOODPLAIN DIAGNOSTICS

    STRONG_POND_CYPRESS_DIAGNOSTICS = PatternList('STRONG_POND_CYPRESS_DIAGNOSTICS',
        {'species': 'Taxodium ascendens'}
    )

    STRONG_LONGLEAF_DIAGNOSTICS = PatternList('STRONG_LONGLEAF_DIAGNOSTICS',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'}
    )

    STRONG_SWAMP_DIAGNOSTICS = PatternList('STRONG_SWAMP_DIAGNOSTICS',
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Cliftonia monophylla'},
        {'species': 'Fraxinus caroliniana'},
        {'species': 'Gordonia lasianthus'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Pinus serotina'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Sabal palmetto'}
    )

    STRONG_FLOODPLAIN_DIAGNOSTICS = PatternList('STRONG_FLOODPLAIN_DIAGNOSTICS',
        {'species': 'Acer saccharinum'},
        {'species': 'Carya aquatica'},
        {'species': 'Betula nigra'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Fraxinus profunda'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Gleditsia aquatica'},
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Nyssa aquatica'},
        {'species': 'Nyssa biflora'},
        {'species': 'Nyssa ogeche'},
        {'species': 'Planera aquatica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus lyrata'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus texana'},
        {'species': 'Salix caroliniana'},
        {'species': 'Salix nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=078|Longleaf Pine Woodland LC2 (M007)', plot.ident)
        result = (   plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) > plot.riv(STRONG_POND_CYPRESS_DIAGNOSTICS)
               or plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) > plot.riv(STRONG_FLOODPLAIN_DIAGNOSTICS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_079():

    """Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)"""
    """Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)"""
    level = 'macrogroup'
    code = 'Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)'

    # other

    def match(plot):
        logging.debug('%s|NODE=079|Southern Coastal Plain Floodplain Forest (M031) / Southern Coastal Plain Basin Swamp & Flatwoods LC (M033)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_080():

    """Eastern Warm Temperate Ruderal Wetland Forest"""
    """Eastern Warm Temperate Ruderal Wetland Forest"""
    level = 'division'
    code = 'Eastern Warm Temperate Ruderal Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=080|Eastern Warm Temperate Ruderal Wetland Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_081():

    """Southeastern North American Ruderal Flooded & Swamp Forest (M310)"""
    """Southeastern North American Ruderal Flooded & Swamp Forest (M310)"""
    level = 'macrogroup'
    code = 'Southeastern North American Ruderal Flooded & Swamp Forest (M310)'

    # other

    def match(plot):
        logging.debug('%s|NODE=081|Southeastern North American Ruderal Flooded & Swamp Forest (M310)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_082():

    """Eastern Cool Temperate & North American Boreal Wetland Forest"""
    """Eastern Cool Temperate & North American Boreal Wetland Forest"""
    level = 'division'
    code = 'Eastern Cool Temperate & North American Boreal Wetland Forest'

    # other

    def match(plot):
        logging.debug('%s|NODE=082|Eastern Cool Temperate & North American Boreal Wetland Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_083():

    """North American Boreal Flooded & Swamp Forest Division"""
    """North American Boreal Flooded & Swamp Forest Division"""
    level = 'division'
    code = 'North American Boreal Flooded & Swamp Forest Division'

    # Plots in Ecoprovince 212, 211, M211 AND
    #  i.  Tree composition dominated by one or more of boreal wetland conifer species
    #      (Larix laricina, Picea mariana) (if in EcoProvince 212) (>=80% RIV);
    # OR
    # ii.  The above tree composition but with >=20% RIV; AND other species are any
    #      combination of boreal hardwoods (Betula papyrifera) or other conifers
    #      (Abies balsamea, Picea glauca, Pinus banksiana) species (together >=95% RIV);
    #      [N.B. role of Thuja occidentalis in boreal swamps still under review]

    BOREAL_REGION = PatternList('BOREAL_REGION',
        {'ecoregion': '212, 211, M211'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Larix laricina'},
        {'species': 'Picea mariana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Abies balsamea'},
        {'species': 'Picea glauca'},
        {'species': 'Pinus banksiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=083|North American Boreal Flooded & Swamp Forest Division', plot.ident)
        result = (    plot.match(BOREAL_REGION)
               and (    plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 80 
                    or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 95)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_084():

    """North American Boreal Natural Wetland Forest"""
    """North American Boreal Natural Wetland Forest"""
    level = 'division'
    code = 'North American Boreal Natural Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=084|North American Boreal Natural Wetland Forest', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_085():

    """North American Boreal Conifer Poor Swamp (M299)"""
    """North American Boreal Conifer Poor Swamp (M299)"""
    level = 'macrogroup'
    code = 'North American Boreal Conifer Poor Swamp (M299)'

    # Tree composition dominated by one of the following:
    #  i.   Any combination of one or more of the boreal wetland conifer species (Larix laricina,
    #       Picea mariana (>=50% RIV);
    # OR
    # ii.  The above tree composition with >=20% RIV; AND other species are any combination of
    #      boreal hardwoods Betula papyrifera, or other conifers Abies balsamea, Picea glauca,
    #      Pinus banksiana (together >=95% RIV);

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Larix laricina'},
        {'species': 'Picea mariana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Abies balsamea'},
        {'species': 'Picea glauca'},
        {'species': 'Pinus banksiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=085|North American Boreal Conifer Poor Swamp (M299)', plot.ident)
        result = (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
               or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 95))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_086():

    """North American Boreal Conifer Poor Swamp LC (M299)"""
    """North American Boreal Conifer Poor Swamp LC (M299)"""
    level = 'macrogroup'
    code = 'North American Boreal Conifer Poor Swamp LC (M299)'

    # other

    def match(plot):
        logging.debug('%s|NODE=086|North American Boreal Conifer Poor Swamp LC (M299)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_087():

    """North American Boreal Ruderal Wetland Forest"""
    """North American Boreal Ruderal Wetland Forest"""
    level = 'division'
    code = 'North American Boreal Ruderal Wetland Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=087|North American Boreal Ruderal Wetland Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_088():

    """Eastern North American - Great Plains Flooded & Swamp Forest Division"""
    """Eastern North American - Great Plains Flooded & Swamp Forest Division"""
    level = 'division'
    code = 'Eastern North American - Great Plains Flooded & Swamp Forest Division'

    # other

    def match(plot):
        logging.debug('%s|NODE=088|Eastern North American - Great Plains Flooded & Swamp Forest Division', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_089():

    """Eastern Cool Temperate Natural Wetland Forests"""
    """Eastern Cool Temperate Natural Wetland Forests"""
    level = 'division'
    code = 'Eastern Cool Temperate Natural Wetland Forests'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=089|Eastern Cool Temperate Natural Wetland Forests', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_090():

    """Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)"""
    """Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)'

    # Tree composition dominated by one of the following:
    #  i. Plots occurs in EcoProvinces or EcoSections 212, M211, 211A - 211E, 211Ja, 211Jb, 211Jc [intentionally
    #     exclude 211F, 211G, 211Jd], 222J, 222K, 222L, 222M, 222N, 222R, 222U
    #     AND
    #     Tree composition dominated by one or more STRONG LAURENTIAN-ACADIAN DIAGNOSTICS of Fraxinus nigra,
    #     Larix laricina, Picea mariana, Picea rubens, Populus balsamifera, Tsuga canadensis,
    #     Thuja occidentalis (>=50% RIV)
    # OR
    # ii. Plots occur in EcoProvinces or EcoSections 212, M211, 211, 222I, 221A-221D
    #     AND
    #     iia. Tree composition dominated by one or more of ECOREGIONALLY STRONG LAURENTIAN-ACADIAN DIAGNOSTICS
    #          Acer rubrum, Acer saccharinum, Chamaecyparis thyoides, Fraxinus nigra, Fraxinus pennsylvanica,
    #          Larix laricina, Picea mariana, Picea rubens, Pinus rigida, Populus balsamifera, Salix amygdaloides,
    #          Tsuga canadensis, Thuja occidentalis, Ulmus americana, Ulmus rubra (>=50% RIV) AND in Province 212,
    #          M211, 211, 222I, 221A-221D.
    #      OR
    #     iib. Tree composition and ecoregions as above, but with >=20% RIV, AND other species are any combination
    #          of MODERATE DIAGNOSTICS Abies balsamea, Acer nigrum, Acer negundo, Acer saccharum, Betula alleghaniensis,
    #          Betula papyrifera, Carpinus caroliniana, Fraxinus americana, Nyssa sylvatica, Ostrya virginiana,
    #          Populus tremuloides, Prunus serotina, Quercus macrocarpa, Tilia americana (together >=50% RIV)

    ECOREGIONS_I = PatternList('ECOREGIONS_I',
        {'ecoregion': '212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc, 222J, 222K, 222L, 222M, 222N, 222R, 222U'}
    )

    STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS = PatternList('STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS',
        {'species': 'Fraxinus nigra'},
        {'species': 'Larix laricina'},
        {'species': 'Picea mariana'},
        {'species': 'Picea rubens'},
        {'species': 'Populus balsamifera'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Thuja occidentalis'}
    )

    ECOREGIONS_II = PatternList('ECOREGIONS_II',
        {'ecoregion': '212, M211, 211, 222I, 221A, 221B, 221C, 221D'}
    )

    ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS = PatternList('ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS',
        {'species': 'Acer rubrum'},
        {'species': 'Acer saccharinum'},
        {'species': 'Chamaecyparis thyoides'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Larix laricina'},
        {'species': 'Picea mariana'},
        {'species': 'Picea rubens'},
        {'species': 'Pinus rigida'},
        {'species': 'Populus balsamifera'},
        {'species': 'Salix amygdaloides'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Thuja occidentalis'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus rubra'}
    )

    MODERATE_DIAGNOSTIC_SPECIES_II = PatternList('MODERATE_DIAGNOSTIC_SPECIES_II',
        {'species': 'Abies balsamea'},
        {'species': 'Acer nigrum'},
        {'species': 'Acer negundo'},
        {'species': 'Acer saccharum'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula papyrifera'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Fraxinus americana'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Tilia americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=090|Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest (M504)', plot.ident)
        result = (   (    plot.match(ECOREGIONS_I)
                   and plot.riv(STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) >= 50)
               or (     plot.match(ECOREGIONS_II)
                   and (    plot.riv(ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) >= 50
                        or (plot.riv(ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) >= 20 and plot.riv(ECOREGIONALLY_STRONG_LAURENTIAN_ACADIAN_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES_II) >= 50))))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_091():

    """Central Hardwood Floodplain Forest (M029)"""
    """Central Hardwood Floodplain Forest (M029)"""
    level = 'macrogroup'
    code = 'Central Hardwood Floodplain Forest (M029)'

    #  i. Tree composition dominated by one or more of STRONG CENTRAL FLOODPLAIN DIAGNOSTICS
    #     Acer negundo, Acer saccharinum, Carya cordiformis, Carya laciniosa, Celtis laevigata,
    #     Celtis occidentalis, Betula nigra, Fraxinus pennsylvanica, Platanus occidentalis,
    #     Populus deltoides, Populus deltoides spp. monilifera, Salix bebbiana, Salix nigra,
    #     Salix caroliniana, Salix spp., Ulmus americana, Ulmus rubra (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are any combination
    #     of MODERATE DIAGNOSTICS Acer rubrum, Acer negundo, Acer saccharum, Carpinus caroliniana,
    #     Carya cordiformis, Carya illinoinensis, Diospyros virginiana, Fraxinus nigra,
    #     Gleditsia triacanthos, Liriodendron tulipifera, Liquidambar styraciflua, Morus spp.,
    #     Morus rubra, Populus tremuloides,  Quercus bicolor, Quercus imbricaria, Quercus palustris,
    #     Quercus macrocarpa, Tilia americana (together >=50% RIV).

    STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS = PatternList('STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS',
        {'species': 'Acer negundo'},
        {'species': 'Acer saccharinum'},
        {'species': 'Carya cordiformis'},
        {'species': 'Carya laciniosa'},
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Betula nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Populus deltoides spp. monilifera'},
        {'species': 'Salix bebbiana'},
        {'species': 'Salix nigra'},
        {'species': 'Salix caroliniana'},
        {'species': 'Salix spp.'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus rubra'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer rubrum'},
        {'species': 'Acer negundo'},
        {'species': 'Acer saccharum'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Carya cordiformis'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Morus spp.'},
        {'species': 'Morus rubra'},
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus bicolor'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus palustris'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Tilia americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=091|Central Hardwood Floodplain Forest (M029)', plot.ident)
        result = (    plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) >= 50
               or (    plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) >= 20
                   and plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_092():

    """Central Hardwood Swamp Forest (M503)"""
    """Central Hardwood Swamp Forest (M503)"""
    level = 'macrogroup'
    code = 'Central Hardwood Swamp Forest (M503)'

    #  i. Tree composition dominated by one or more of of STRONG CENTRAL SWAMP DIAGNOSTICS
    #     Fraxinus nigra, Larix laricina, Nyssa sylvatica, Quercus bicolor, Quercus palustris,
    #     Quercus phellos, Quercus shumardii, Salix amygdaloides, Thuja occidentalis,
    #     Tsuga canadensis or Picea rubens (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of
    #     MODERATE DIAGNOSTICS Acer rubrum, Acer saccharum, Acer saccharinum, Acer spicatum,
    #     Betula alleghaniensis, Carpinus caroliniana, Carya cordiformis, Fagus grandifolia,
    #     Fraxinus pennsylvanica, Liriodendron tulipifera, Liquidambar styraciflua, Morus spp.,
    #     Morus rubra, Ostrya virginiana, Quercus alba, Quercus macrocarpa, Populus balsamifera,
    #     Populus tremuloides, Salix bebbiana, Salix nigra, Tilia americana, Ulmus americana
    #     (together >=50% RIV).

    STRONG_CENTRAL_SWAMP_DIAGNOSTICS = PatternList('STRONG_CENTRAL_SWAMP_DIAGNOSTICS',
        {'species': 'Fraxinus nigra'},
        {'species': 'Larix laricina'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Quercus bicolor'},
        {'species': 'Quercus palustris'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Salix amygdaloides'},
        {'species': 'Thuja occidentalis'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Picea rubens'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer rubrum'},
        {'species': 'Acer saccharum'},
        {'species': 'Acer saccharinum'},
        {'species': 'Acer spicatum'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Carya cordiformis'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Morus spp.'},
        {'species': 'Morus rubra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus tremuloides'},
        {'species': 'Salix bebbiana'},
        {'species': 'Salix nigra'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=092|Central Hardwood Swamp Forest (M503)', plot.ident)
        result = (    plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS) >= 50
               or (    plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS) >= 20
                   and plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_093():

    """Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)"""
    """Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)'

    # ECOREGION is 212, M211, 211, 222I, 221A-221D

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '212, M211, 211, 222I, 221A, 221B, 221C, 221D'}
    )

    def match(plot):
        logging.debug('%s|NODE=093|Laurentian-Acadian-North Atlantic Coastal Flooded & Swamp Forest LC (M504)', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_094():

    """Central Hardwood Floodplain Forest LC (M029)"""
    """Central Hardwood Floodplain Forest LC (M029)"""
    level = 'macrogroup'
    code = 'Central Hardwood Floodplain Forest LC (M029)'

    #  i. % RIV STRONG CENTRAL FLOODPLAIN DIAGNOSTICS > STRONG CENTRAL SWAMP DIAGNOSTICS
    # OR
    # ii. Physiographic code = R (Riverine)

    STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS = PatternList('STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS',
        {'species': 'Acer negundo'},
        {'species': 'Acer saccharinum'},
        {'species': 'Carya cordiformis'},
        {'species': 'Carya laciniosa'},
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Betula nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Populus deltoides spp. monilifera'},
        {'species': 'Salix bebbiana'},
        {'species': 'Salix nigra'},
        {'species': 'Salix caroliniana'},
        {'species': 'Salix spp.'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus rubra'}
    )

    STRONG_CENTRAL_SWAMP_DIAGNOSTICS = PatternList('STRONG_CENTRAL_SWAMP_DIAGNOSTICS',
        {'species': 'Fraxinus nigra'},
        {'species': 'Larix laricina'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Quercus bicolor'},
        {'species': 'Quercus palustris'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Salix amygdaloides'},
        {'species': 'Thuja occidentalis'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Picea rubens'}
    )

    RIVERINE = PatternList('RIVERINE',
        {'riverine': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=094|Central Hardwood Floodplain Forest LC (M029)', plot.ident)
        result = (   plot.riv(STRONG_CENTRAL_FLOODPLAIN_DIAGNOSTICS) > plot.riv(STRONG_CENTRAL_SWAMP_DIAGNOSTICS)
               or plot.match(RIVERINE))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_095():

    """Central Hardwood Swamp Forest LC (M503)"""
    """Central Hardwood Swamp Forest LC (M503)"""
    level = 'macrogroup'
    code = 'Central Hardwood Swamp Forest LC (M503)'

    # other

    def match(plot):
        logging.debug('%s|NODE=095|Central Hardwood Swamp Forest LC (M503)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_096():

    """Eastern Cool Temperate Ruderal Wetland Forests"""
    """Eastern Cool Temperate Ruderal Wetland Forests"""
    level = 'division'
    code = 'Eastern Cool Temperate Ruderal Wetland Forests'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=096|Eastern Cool Temperate Ruderal Wetland Forests', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_097():

    """Eastern North American Ruderal Flooded & Swamp Forest (M302)"""
    """Eastern North American Ruderal Flooded & Swamp Forest (M302)"""
    level = 'macrogroup'
    code = 'Eastern North American Ruderal Flooded & Swamp Forest (M302)'

    # other

    def match(plot):
        logging.debug('%s|NODE=097|Eastern North American Ruderal Flooded & Swamp Forest (M302)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_098():

    """Upland Forest & Woodlands"""
    """Upland Forest & Woodlands"""
    level = 'division'
    code = 'Upland Forest & Woodlands'

    # other

    def match(plot):
        logging.debug('%s|NODE=098|Upland Forest & Woodlands', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_099():

    """Tropical Forest & Woodland Subclass"""
    """Tropical Forest & Woodland Subclass"""
    level = 'division'
    code = 'Tropical Forest & Woodland Subclass'

    # Forests dominated by tropical hardwood, other palms and tropical conifer
    # tree species. Found in tropical regions of the United States - Puerto Rico,
    # U.S. Virgin Islands and Tropical Florida (EcoSection 411A) but excluding stands
    # containing alone or in combination Pinus elliottii, Pinus palustris, Quercus virginiana,
    # Quercus laurifolia, Taxodium ascendens > 20% RIV. [n.b. Some tropical forest types may
    # extend into EcoSubsections 232Da, 232Ga, 232Gb, but specific diagnostic species will 
    # need to be identified to key them out.]

    TROPICAL_LOCATION = PatternList('TROPICAL_LOCATION',
        {'state': 'PR'},
        {'state': 'VI'},
        {'state': 'FL', 'ecoregion': '411A'}
    )

    EXCLUDED_SPECIES = PatternList('EXCLUDED_SPECIES',
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'},
        {'species': 'Quercus virginiana'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Taxodium ascendens'}
    )

    def match(plot):
        logging.debug('%s|NODE=099|Tropical Forest & Woodland Subclass', plot.ident)
        result = (plot.match(TROPICAL_LOCATION) and plot.riv(EXCLUDED_SPECIES) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_100():

    """Tropical Florida - Caribbean Forest"""
    """Tropical Florida - Caribbean Forest"""
    level = 'division'
    code = 'Tropical Florida - Caribbean Forest'

    # Tropical hardwood and tropical conifer forests found in Puerto Rico, U.S. Virgin Islands,
    # and in tropical Florida (EcoSection 411A)

    TROPICAL_ATLANTIC = PatternList('TROPICAL_ATLANTIC',
        {'state': 'FL', 'ecoregion': '411A'},
        {'state': 'PR'},
        {'state': 'VI'}
    )

    def match(plot):
        logging.debug('%s|NODE=100|Tropical Florida - Caribbean Forest', plot.ident)
        result = (plot.match(TROPICAL_ATLANTIC))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_101():

    """Tropical Florida Forest"""
    """Tropical Florida Forest"""
    level = 'division'
    code = 'Tropical Florida Forest'

    # Stands found in Tropical Florida (Ecosection 411A) AND
    #   i. Tropical Tree composition dominated by one or more of Bursera simaruba, Coccoloba diversifolia,
    #      Guapira discolor, Metopium toxiferum, Sabal palmetto, or "other palms" (>=50% RIV); stands only found
    #      in EcoSection 411A;
    #  OR
    #  ii. The above tree species, but with >=20% RIV, AND other species are any combination of Coccothrinax
    #      argentata, Conocarpus erectus, Sideroxylon salicifolium, Thrinax morrisii (together >=50% RIV); stands
    #      only found in EcoSection 411A.
    #  OR
    # iii. Ruderal (weedy natives and exotic) tree species with >=80% RIV

    TROPICAL_FLORIDA = PatternList('TROPICAL_FLORIDA',
        {'state': 'FL', 'ecoregion': '411A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Bursera simaruba'},
        {'species': 'Coccoloba diversifolia'},
        {'species': 'Guapira discolor'},
        {'species': 'Metopium toxiferum'},
        {'species': 'Sabal palmetto'},
        {'species': 'other palms'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Coccothrinax argentata'},
        {'species': 'Conocarpus erectus'},
        {'species': 'Sideroxylon salicifolium'},
        {'species': 'Thrinax morrisii'}
    )

    RUDERAL_SPECIES = PatternList('RUDERAL_SPECIES',
        {'ruderal': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=101|Tropical Florida Forest', plot.ident)
        result = (    plot.match(TROPICAL_FLORIDA)
               and (    plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
                    or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)
                    or  plot.riv(RUDERAL_SPECIES) >= 80))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_102():

    """Tropical Florida Natural Forest"""
    """Tropical Florida Natural Forest"""
    level = 'division'
    code = 'Tropical Florida Natural Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=102|Tropical Florida Natural Forest', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_103():

    """Caribbean Swamp Forest via upland (M617)"""
    """Caribbean Swamp Forest via upland (M617)"""
    level = 'macrogroup'
    code = 'Caribbean Swamp Forest via upland (M617)'

    # Tree composition >= 50% Sabal palmetto RIV

    SABAL_PALMETTO = PatternList('SABAL_PALMETTO',
        {'species': 'Sabal palmetto'}
    )

    def match(plot):
        logging.debug('%s|NODE=103|Caribbean Swamp Forest via upland (M617)', plot.ident)
        result = (plot.riv(SABAL_PALMETTO) >= 50)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_104():

    """Caribbean Coastal Lowland Dry Forest (M134)"""
    """Caribbean Coastal Lowland Dry Forest (M134)"""
    level = 'macrogroup'
    code = 'Caribbean Coastal Lowland Dry Forest (M134)'

    # Tree composition dominated by one or more of Bursera simaruba, Coccoloba diversifolia,
    # Guapira discolor, Metopium toxiferum, Conocarpus erectus, "other palms",
    # Sabal palmetto (>=20% RIV)

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Bursera simaruba'},
        {'species': 'Coccoloba diversifolia'},
        {'species': 'Guapira discolor'},
        {'species': 'Metopium toxiferum'},
        {'species': 'Conocarpus erectus'},
        {'species': 'other palms'},
        {'species': 'Sabal palmetto'}
    )

    def match(plot):
        logging.debug('%s|NODE=104|Caribbean Coastal Lowland Dry Forest (M134)', plot.ident)
        result = (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_105():

    """Caribbean Coastal Lowland Dry Forest LC (M134)"""
    """Caribbean Coastal Lowland Dry Forest LC (M134)"""
    level = 'macrogroup'
    code = 'Caribbean Coastal Lowland Dry Forest LC (M134)'

    # other

    def match(plot):
        logging.debug('%s|NODE=105|Caribbean Coastal Lowland Dry Forest LC (M134)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_106():

    """Tropical Florida Ruderal Forest"""
    """Tropical Florida Ruderal Forest"""
    level = 'division'
    code = 'Tropical Florida Ruderal Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=106|Tropical Florida Ruderal Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_107():

    """Caribbean Ruderal Dry Forest (M514)"""
    """Caribbean Ruderal Dry Forest (M514)"""
    level = 'macrogroup'
    code = 'Caribbean Ruderal Dry Forest (M514)'

    # other

    def match(plot):
        logging.debug('%s|NODE=107|Caribbean Ruderal Dry Forest (M514)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_108():

    """Caribbean Forest"""
    """Caribbean Forest"""
    level = 'division'
    code = 'Caribbean Forest'

    # Stands found in Caribbean islands.

    CARIBBEAN = PatternList('CARIBBEAN',
        {'state': 'PR'},
        {'state': 'VI'}
    )

    def match(plot):
        logging.debug('%s|NODE=108|Caribbean Forest', plot.ident)
        result = (plot.match(CARIBBEAN))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_109():

    """Caribbean Natural Forest"""
    """Caribbean Natural Forest"""
    level = 'division'
    code = 'Caribbean Natural Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=109|Caribbean Natural Forest', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_110():

    """Caribbean & Central American Dry Forests"""
    """Caribbean & Central American Dry Forests"""
    level = 'division'
    code = 'Caribbean & Central American Dry Forests'

    #  i. Tree composition dominated by Pinus elliottii (= var. densa) or Pinus caribaea, alone or in
    #     combination (>=50% RIV)
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of (in
    #     dry stands) Bursera simaruba, Coccoloba diversifolia, Coccothrinax argentata, Conocarpus erectus,
    #     Guapira discolor, Metopium toxiferum, "other palms", Sabal palmetto, Thrinax morrisii,
    #     Sideroxylon salicifolium (together >=50% RIV)

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus caribaea'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Bursera simaruba'},
        {'species': 'Coccoloba diversifolia'},
        {'species': 'Coccothrinax argentata'},
        {'species': 'Conocarpus erectus'},
        {'species': 'Guapira discolor'},
        {'species': 'Metopium toxiferum'},
        {'species': 'other palms'},
        {'species': 'Sabal palmetto'},
        {'species': 'Thrinax morrisii'},
        {'species': 'Sideroxylon salicifolium'}
    )

    def match(plot):
        logging.debug('%s|NODE=110|Caribbean & Central American Dry Forests', plot.ident)
        result = (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_111():

    """Caribbean-Mesoamerican Pine Forest (M296)"""
    """Caribbean-Mesoamerican Pine Forest (M296)"""
    level = 'macrogroup'
    code = 'Caribbean-Mesoamerican Pine Forest (M296)'

    #  i. Tree composition dominated by Pinus elliottii (var. densa) or Pinus caribaea,
    #     alone or in combination (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are
    #     any combination of (in dry stands) Coccothrinax argentata, Thrinax morrisii,
    #     Sideroxylon salicifolium (together >=50% RIV);

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus caribaea'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Coccothrinax argentata'},
        {'species': 'Thrinax morrisii'},
        {'species': 'Sideroxylon salicifolium'}
    )

    def match(plot):
        logging.debug('%s|NODE=111|Caribbean-Mesoamerican Pine Forest (M296)', plot.ident)
        result = (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_112():

    """Caribbean-Mesoamerican Pine Forest LC (M296)"""
    """Caribbean-Mesoamerican Pine Forest LC (M296)"""
    level = 'macrogroup'
    code = 'Caribbean-Mesoamerican Pine Forest LC (M296)'

    # other

    def match(plot):
        logging.debug('%s|NODE=112|Caribbean-Mesoamerican Pine Forest LC (M296)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_113():

    """Caribbean Ruderal Forest"""
    """Caribbean Ruderal Forest"""
    level = 'division'
    code = 'Caribbean Ruderal Forest'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=113|Caribbean Ruderal Forest', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_114():

    """Temperate & Boreal Forests"""
    """Temperate & Boreal Forests"""
    level = 'division'
    code = 'Temperate & Boreal Forests'

    # other

    def match(plot):
        logging.debug('%s|NODE=114|Temperate & Boreal Forests', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_115():

    """Eastern North American Temperate & Boreal Forests"""
    """Eastern North American Temperate & Boreal Forests"""
    level = 'division'
    code = 'Eastern North American Temperate & Boreal Forests'

    # Forests found in EcoDomain Humid Temperate (200 or M200) of the eastern United States
    # and Canada, and EcoDomain Polar (100 or M100) east of Alberta and the Yukon [need to
    # improve east-west boreal line using tree species., e.g., Pinus banksiana, Abies balsamea],
    # and 411A [most stands in 411 belong with tropical types, but a few exceptions are
    # allowed, see couplet A]

    HUMID_TEMPERATE_OR_POLAR = PatternList('HUMID_TEMPERATE_OR_POLAR',
        {'ecoregion': '200, M200, 100, M100, 411A'}
    )

    def match(plot):
        logging.debug('%s|NODE=115|Eastern North American Temperate & Boreal Forests', plot.ident)
        result = (plot.match(HUMID_TEMPERATE_OR_POLAR))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_116():

    """Southeastern North American Forest & Woodland Division"""
    """Southeastern North American Forest & Woodland Division"""
    level = 'division'
    code = 'Southeastern North American Forest & Woodland Division'

    #     i. Stands found in Ecoprovince 231, 232, 234A, 234C, but excluding NJ, PA
    #        AND
    #    ii. Tree composition contains one or more of Aesculus pavia, Halesia diptera,
    #        Juniperus virginiana var. silicicola Magnolia grandiflora, Pinus clausa, Pinus glabra,
    #        Pinus palustris, Pinus elliottii, Quercus incana, Quercus laevis, Quercus laurifolia,
    #        Quercus margarettiae, Quercus minima, Quercus sinuata, Quercus virginiana, Sabal palmetto (>=5% RIV);
    #        [Additional tree species not tracked by FIA include Quercus fusiformis = Quercus virginiana var. fusiformis),
    #        Quercus geminata, Serenoa repens]
    # OR
    #    Plot found in Ecosections 231B, 231E, 231H, 232B, 232C, 232D, 232E, 232F, 232G, 232H, 232I, 232J, 232K, 232L, 234,
    #    411A excluding NJ, PA, KY, TN, IL

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': '231, 232, 234A, 234C', 'state': '!NJ, PA'}
    )

    DIAGNOSTIC_SPECIES_1 = PatternList('DIAGNOSTIC_SPECIES_1',
        {'species': 'Aesculus pavia'},
        {'species': 'Halesia diptera'},
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Magnolia grandiflora'},
        {'species': 'Pinus clausa'},
        {'species': 'Pinus glabra'},
        {'species': 'Pinus palustris'},
        {'species': 'Pinus elliottii'},
        {'species': 'Quercus incana'},
        {'species': 'Quercus laevis'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus margarettiae'},
        {'species': 'Quercus minima'},
        {'species': 'Quercus sinuata var. sinuata'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'}
    )

    ECOREGIONS_2 = PatternList('ECOREGIONS_2',
        {'ecoregion': '231B, 231E, 231H, 232B, 232C, 232D, 232E, 232F, 232G, 232H, 232I, 232J, 232K, 232L, 234, 411A', 'state': '!NJ, PA, KY, TN, IL'}
    )

    def match(plot):
        logging.debug('%s|NODE=116|Southeastern North American Forest & Woodland Division', plot.ident)
        result = ((plot.match(ECOREGIONS_1) and plot.riv(DIAGNOSTIC_SPECIES_1) >= 5) or plot.match(ECOREGIONS_2))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_117():

    """Southeastern Warm Temperate Natural Forests"""
    """Southeastern Warm Temperate Natural Forests"""
    level = 'division'
    code = 'Southeastern Warm Temperate Natural Forests'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=117|Southeastern Warm Temperate Natural Forests', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_118():

    """Southern Mesic Mixed Broadleaf Forest (M008)"""
    """Southern Mesic Mixed Broadleaf Forest (M008)"""
    level = 'macrogroup'
    code = 'Southern Mesic Mixed Broadleaf Forest (M008)'

    #  i. Tree composition dominated by one or more of Acer barbatum, Aesculus pavia, Fagus grandifolia,
    #     Halesia diptera, Ilex opaca, Magnolia acuminata, Magnolia grandiflora, Magnolia virginiana,
    #     Pinus glabra, Quercus michauxii, Quercus pagoda, Quercus phellos, Quercus shumardii,
    #     Sabal palmetto, Tilia spp., Tilia americana, Tilia americana var. heterophylla,
    #     Tilia americana var. caroliniana (>=50% RIV)
    # OR
    # ii. Tree composition as above, but with >=20% RIV; AND other species [in the context of
    #     EcoProvince 232] are any combination of Acer rubrum, Aesculus pavia, Carpinus caroliniana,
    #     Carya alba, Celtis spp., Celtis laevigata, Cornus florida, Diospyros virginiana,
    #     Fraxinus americana, Halesia spp., Halesia carolina (=H. tetraptera), Liquidambar styraciflua,
    #     Liriodendron tulipifera, Magnolia macrophylla, Nyssa sylvatica, Ostrya virginiana,
    #     Oxydendrum arboreum, Quercus alba, Quercus falcata, Quercus muehlenbergii, Quercus rubra,
    #     Quercus virginiana, Quercus nigra, Juniperus spp., Pinus taeda (together >=50% RIV)

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Aesculus pavia'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Halesia diptera'},
        {'species': 'Ilex opaca'},
        {'species': 'Magnolia acuminata'},
        {'species': 'Magnolia grandiflora'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Pinus glabra'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Sabal palmetto'},
        {'species': 'Tilia spp.'},
        {'species': 'Tilia americana'},
        {'species': 'Tilia americana var. heterophylla'},
        {'species': 'Tilia americana var. caroliniana'}
    )

    MODERATE_MESIC_DIAGNOSTICS = PatternList('MODERATE_MESIC_DIAGNOSTICS',
        {'species': 'Acer rubrum'},
        {'species': 'Aesculus pavia'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Carya alba'},
        {'species': 'Celtis spp.'},
        {'species': 'Celtis laevigata'},
        {'species': 'Cornus florida'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Fraxinus americana'},
        {'species': 'Halesia spp.'},
        {'species': 'Halesia carolina'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Magnolia macrophylla'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Oxydendrum arboreum'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus virginiana'},
        {'species': 'Quercus nigra'},
        {'species': 'Juniperus spp.'},
        {'species': 'Pinus taeda'}
    )

    def match(plot):
        logging.debug('%s|NODE=118|Southern Mesic Mixed Broadleaf Forest (M008)', plot.ident)
        result = (    plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 50
               or (plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20 and plot.riv(STRONG_MESIC_DIAGNOSTICS) + plot.riv(MODERATE_MESIC_DIAGNOSTICS) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_119():

    """Longleaf Pine Woodland (M007)"""
    """Longleaf Pine Woodland (M007)"""
    level = 'macrogroup'
    code = 'Longleaf Pine Woodland (M007)'

    #   i. Tree composition dominated by Pinus palustris >=20% RIV,
    # OR
    #  ii. Tree composition dominated by Pinus clausa, Pinus elliottii, Pinus palustris >=5% AND Pinus clausa, Pinus echinata,
    #      Pinus elliottii, Pinus palustris, and Pinus taeda together >=50% RIV.
    # OR
    # iii. Tree composition dominated by one or more of Pinus clausa, Pinus elliottii or Pinus palustris (>=50% RIV);
    # OR
    #  iv. Tree composition as above, but with >=20% RIV, AND other species are any combination of coastal plain species of
    #      Acer rubrum, Carya illinoinensis, Diospyros virginiana, Liquidambar styraciflua, Pinus echinata, Pinus taeda,
    #      Persea borbonia, Quercus falcata, Quercus incana, Quercus laevis, Quercus laurifolia, Quercus margarettiae,
    #      Quercus marilandica, Quercus nigra, Quercus virginiana or Sabal palmetto (together >=50% RIV).

    DIAGNOSTIC_SPECIES_I = PatternList('DIAGNOSTIC_SPECIES_I',
        {'species': 'Pinus palustris'}
    )

    DIAGNOSTIC_SPECIES_II = PatternList('DIAGNOSTIC_SPECIES_II',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'},
        {'species': 'Pinus taeda'}
    )

    STRONG_LONGLEAF_DIAGNOSTICS = PatternList('STRONG_LONGLEAF_DIAGNOSTICS',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'}
    )

    MODERATE_LONGLEAF_DIAGNOSTICS = PatternList('MODERATE_LONGLEAF_DIAGNOSTICS',
        {'species': 'Acer rubrum'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus taeda'},
        {'species': 'Persea borbonia'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus incana'},
        {'species': 'Quercus laevis'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus margarettiae'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'}
    )

    def match(plot):
        logging.debug('%s|NODE=119|Longleaf Pine Woodland (M007)', plot.ident)
        result = (    plot.riv(DIAGNOSTIC_SPECIES_I) >= 20
               or (plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) >= 5 and plot.riv(DIAGNOSTIC_SPECIES_II) >= 50)
               or  plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) >= 50
               or (plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) >= 20 and plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) + plot.riv(MODERATE_LONGLEAF_DIAGNOSTICS) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_120():

    """Southeastern Coastal Plain Evergreen Oak Forest (M885)"""
    """Southeastern Coastal Plain Evergreen Oak Forest (M885)"""
    level = 'macrogroup'
    code = 'Southeastern Coastal Plain Evergreen Oak Forest (M885)'

    # Plot is in 232B, C, D, E, G [not in 232A, F, H, I, J], 255Da, Db, Dc [not 255Dd] or 411A, AND
    #  i. Tree composition is dominated by one or more of Juniperus virginiana var. silicicola,
    #     Pinus glabra, Quercus incana, Quercus laevis, Quercus laurifolia (presumably = Quercus hemisphaerica, if upland),
    #     Quercus margarettiae, Quercus minima, Quercus margarettiae, Quercus virginiana, Sabal palmetto (>=50% RIV);
    #     [Additional tree species not tracked by FIA include Quercus fusiformis = Quercus virginiana var. fusiformis),
    #     Quercus geminata, Serenoa repens,]
    # OR
    # ii. Tree composition as above, but with >=20% RIV; AND other species are any combination of Acer rubrum,
    #     Carpinus caroliniana, Carya alba, Celtis laevigata, Celtis spp., Fraxinus americana, Ilex opaca,
    #     Juniperus spp., Juniperus virginiana, Liquidambar styraciflua, Magnolia grandiflora, Nyssa sylvatica,
    #     Ostrya virginiana, Oxydendrum arboreum, other palms, Persea borbonia, Prunus serotina, Quercus alba,
    #     Quercus falcata, , Quercus nigra, Quercus pagoda, Quercus stellata, Pinus echinata, Pinus taeda,
    #     Ulmus alata (together >=50% RIV).

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '232B, 232C, 232D, 232E, 232G, 255Da, 255Db, 255Dc, 411A'}
    )

    STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS = PatternList('STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS',
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Pinus glabra'},
        {'species': 'Quercus incana'},
        {'species': 'Quercus laevis'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus margarettiae'},
        {'species': 'Quercus minima'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'}
    )

    MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS = PatternList('MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Acer rubrum'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Carya alba'},
        {'species': 'Carya glabra'},
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis spp.'},
        {'species': 'Fraxinus americana'},
        {'species': 'Ilex opaca'},
        {'species': 'Juniperus spp.'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Magnolia grandiflora'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Oxydendrum arboreum'},
        {'species': 'other palms'},
        {'species': 'Persea borbonia'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus stellata'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus taeda'},
        {'species': 'Ulmus alata'}
    )

    def match(plot):
        logging.debug('%s|NODE=120|Southeastern Coastal Plain Evergreen Oak Forest (M885)', plot.ident)
        result = (plot.match(ECOREGIONS) and
                 (    plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) >= 50
                  or (    plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) >= 20
                      and plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) + plot.riv(MODERATE_OAK_MIXED_HARDWOOD_DIAGNOSTICS) >= 50)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_121():

    """Southeastern Coastal Plain Evergreen Oak Forest LC (M885)"""
    """Southeastern Coastal Plain Evergreen Oak Forest LC (M885)"""
    level = 'macrogroup'
    code = 'Southeastern Coastal Plain Evergreen Oak Forest LC (M885)'

    # Plot is in 232B-E, 232G, 255Da-Dc or 411A, AND
    # % RIV of STRONG OAK-MIXED HARDWOOD DIAGNOSTICS > either STRONG LONGLEAF DIAGNOSTICS or STRONG MESIC DIAGNOSTICS

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '232B, 232C, 232D, 232E, 232G, 255Da, 255Db, 255Dc, 411A'}
    )

    STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS = PatternList('STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS',
        {'species': 'Juniperus virginiana var. silicicola'},
        {'species': 'Pinus glabra'},
        {'species': 'Quercus incana'},
        {'species': 'Quercus laevis'},
        {'species': 'Quercus laurifolia'},
        {'species': 'Quercus margarettiae'},
        {'species': 'Quercus minima'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'}
    )

    STRONG_LONGLEAF_DIAGNOSTICS = PatternList('STRONG_LONGLEAF_DIAGNOSTICS',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'}
    )

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Aesculus pavia'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Halesia diptera'},
        {'species': 'Ilex opaca'},
        {'species': 'Magnolia acuminata'},
        {'species': 'Magnolia grandiflora'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Pinus glabra'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Sabal palmetto'},
        {'species': 'Tilia spp.'},
        {'species': 'Tilia americana'},
        {'species': 'Tilia americana var. heterophylla'},
        {'species': 'Tilia americana var. caroliniana'}
    )

    def match(plot):
        logging.debug('%s|NODE=121|Southeastern Coastal Plain Evergreen Oak Forest LC (M885)', plot.ident)
        result = (plot.match(ECOREGIONS) and
                 (   plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) > plot.riv(STRONG_LONGLEAF_DIAGNOSTICS)
                  or plot.riv(STRONG_OAK_MIXED_HARDWOOD_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_122():

    """Longleaf Pine Woodland LC1 (M007)"""
    """Longleaf Pine Woodland LC1 (M007)"""
    level = 'macrogroup'
    code = 'Longleaf Pine Woodland LC1 (M007)'

    # STRONG LONGLEAF DIAGNOSTICS %RIV > STRONG MESIC DIAGNOSTICS %RIV

    STRONG_LONGLEAF_DIAGNOSTICS = PatternList('STRONG_LONGLEAF_DIAGNOSTICS',
        {'species': 'Pinus clausa'},
        {'species': 'Pinus elliottii'},
        {'species': 'Pinus palustris'}
    )

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Aesculus pavia'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Halesia diptera'},
        {'species': 'Ilex opaca'},
        {'species': 'Magnolia acuminata'},
        {'species': 'Magnolia grandiflora'},
        {'species': 'Magnolia virginiana'},
        {'species': 'Pinus glabra'},
        {'species': 'Quercus michauxii'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus shumardii'},
        {'species': 'Sabal palmetto'},
        {'species': 'Tilia spp.'},
        {'species': 'Tilia americana'},
        {'species': 'Tilia americana var. heterophylla'},
        {'species': 'Tilia americana var. caroliniana'}
    )

    def match(plot):
        logging.debug('%s|NODE=122|Longleaf Pine Woodland LC1 (M007)', plot.ident)
        result = (plot.riv(STRONG_LONGLEAF_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_123():

    """Southern Mesic Mixed Broadleaf Forest LC (M008)"""
    """Southern Mesic Mixed Broadleaf Forest LC (M008)"""
    level = 'macrogroup'
    code = 'Southern Mesic Mixed Broadleaf Forest LC (M008)'

    # other

    def match(plot):
        logging.debug('%s|NODE=123|Southern Mesic Mixed Broadleaf Forest LC (M008)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_124():

    """Southeastern Warm Temperate Ruderal Forests"""
    """Southeastern Warm Temperate Ruderal Forests"""
    level = 'division'
    code = 'Southeastern Warm Temperate Ruderal Forests'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=124|Southeastern Warm Temperate Ruderal Forests', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_125():

    """Southeastern North American Ruderal Forest (M305)"""
    """Southeastern North American Ruderal Forest (M305)"""
    level = 'macrogroup'
    code = 'Southeastern North American Ruderal Forest (M305)'

    # other

    def match(plot):
        logging.debug('%s|NODE=125|Southeastern North American Ruderal Forest (M305)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_126():

    """Eastern North American Forest & Woodland Division"""
    """Eastern North American Forest & Woodland Division"""
    level = 'division'
    code = 'Eastern North American Forest & Woodland Division'

    # other

    def match(plot):
        logging.debug('%s|NODE=126|Eastern North American Forest & Woodland Division', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_127():

    """Eastern Cool Temperate Natural Forest & Woodlands"""
    """Eastern Cool Temperate Natural Forest & Woodlands"""
    level = 'division'
    code = 'Eastern Cool Temperate Natural Forest & Woodlands'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition not dominated by ruderal native or exotic species (< 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    RUDERAL_OR_EXOTIC_SPECIES = PatternList('RUDERAL_OR_EXOTIC_SPECIES',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=127|Eastern Cool Temperate Natural Forest & Woodlands', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC_SPECIES) < 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_128():

    """Great Plains Forest & Woodland (M151)"""
    """Great Plains Forest & Woodland (M151)"""
    level = 'macrogroup'
    code = 'Great Plains Forest & Woodland (M151)'

    #  i. Plot occurs in Ecoprovince 331, 332, 251A, or 222Na, and tree composition dominated by one or more of
    #     STRONG PLAINS DIAGNOSTICS Fraxinus pennsylvanica, Juniperus virginiana, Populus tremuloides,
    #     Quercus macrocarpa, Ulmus americana, Ulmus rubra (>=50% RIV) AND Tilia americana and
    #     Acer saccharum, singly or in combination < 5% RIV;
    # OR
    # ii. Plot occurs in Ecoprovince 331, 332, 251A, or 222Na, and tree composition as above, but with >=20% RIV, AND
    #     other species are any combination of MODERATE PLAINS DIAGNOSTICS Acer negundo, Betula papyrifera,
    #     Celtis occidentalis, Crataegus spp., Juglans nigra, Juniperus scopulorum, Morus rubra, Pinus ponderosa,
    #     Prunus virginiana, Quercus rubra, Quercus muehlenbergii, Ulmus rubra (together >=50% RIV)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '331, 332, 251A, 222Na'}
    )

    STRONG_PLAINS_DIAGNOSTICS = PatternList('STRONG_PLAINS_DIAGNOSTICS',
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus rubra'}
    )

    EXCLUDED_SPECIES = PatternList('EXCLUDED_SPECIES',
        {'species': 'Tilia americana'},
        {'species': 'Acer saccharum'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Betula papyrifera'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Crataegus spp.'},
        {'species': 'Juglans nigra'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Morus rubra'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Ulmus rubra'}
    )

    def match(plot):
        logging.debug('%s|NODE=128|Great Plains Forest & Woodland (M151)', plot.ident)
        result = (    plot.match(ECOREGIONS)
               and plot.riv(EXCLUDED_SPECIES) < 5
               and (    plot.riv(STRONG_PLAINS_DIAGNOSTICS) >= 50
                    or (plot.riv(STRONG_PLAINS_DIAGNOSTICS) >= 20 and plot.riv(STRONG_PLAINS_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_129():

    """Northern Forest macrogroups"""
    """Northern Forest macrogroups"""
    level = 'division'
    code = 'Northern Forest macrogroups'

    #   i. Tree composition dominated by one or more of Abies balsamea, Abies fraseri, Picea rubens (>=20% RIV)
    # OR
    #  ii. Plots occurs in EcoProvinces 212, M211, 211A - 211E, 211Ja, 211Jb, 211Jc [intentionally exclude 211F,
    #      211G, 211Jd], 222J, 222K, 222L, 222M, 222R, 222U AND
    #         a. Tree composition dominated by one or more of Acer pensylvanicum, Acer spicatum, Amelanchier spp.,
    #            Betula alleghaniensis, Betula papyrifera, Betula populifolia, Fraxinus nigra, Picea glauca, Picea mariana,
    #            Pinus banksiana, Pinus resinosa, Populus balsamifera, Prunus pensylvanica, Sorbus americana, Thuja occidentalis,
    #            Tsuga canadensis (>=50% RIV)
    #        OR
    #         b. Tree composition as above, but with >=20% RIV, AND other species, are any combination of Acer rubrum,
    #            Acer saccharum, Abies balsamea, Abies fraseri, Betula lenta, Carpinus caroliniana, Fagus grandifolia,
    #            Fraxinus americana, Fraxinus pennsylvanica, Larix laricina, Ostrya virginiana, Picea rubens,
    #            Pinus strobus, Populus grandidentata, Populus tremuloides, Prunus serotina, Prunus virginiana,
    #            Quercus ellipsoidalis, Quercus macrocarpa, Quercus rubra, Tilia americana, or Ulmus americana (together >=50% RIV)
    # OR
    # iii. Plots occur in EcoProvinces 212, M211, 211A - 211E, 211Ja, 211Jb, 211Jc [intentionally exclude 211F, 211G, 211Jd] AND
    #      Tree composition dominated by one or more of Acer rubrum, Acer saccharum, Betula alleghaniensis, Betula lenta,
    #      Carpinus caroliniana, Fagus grandifolia, Fraxinus americana, Fraxinus pennsylvanica, Larix laricina,
    #      Ostrya virginiana, Pinus strobus, Populus grandidentata, Populus tremuloides, Prunus serotina,
    #      Quercus ellipsoidalis, Quercus macrocarpa, Quercus rubra, Tilia americana, or Ulmus americana (>= 50% RIV)

    DIAGNOSTIC_SPECIES_I = PatternList('DIAGNOSTIC_SPECIES_I',
        {'species': 'Abies balsamea'},
        {'species': 'Abies fraseri'},
        {'species': 'Picea rubens'}
    )

    ECOREGIONS_II = PatternList('ECOREGIONS_II',
        {'ecoregion': '212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc, 222J, 222K, 222L, 222M, 222R, 222U'}
    )

    STRONG_DIAGNOSTIC_SPECIES_II = PatternList('STRONG_DIAGNOSTIC_SPECIES_II',
        {'species': 'Acer pensylvanicum'},
        {'species': 'Acer spicatum'},
        {'species': 'Amelanchier spp.'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula papyrifera'},
        {'species': 'Betula populifolia'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Picea glauca'},
        {'species': 'Picea mariana'},
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus resinosa'},
        {'species': 'Populus balsamifera'},
        {'species': 'Prunus pensylvanica'},
        {'species': 'Sorbus americana'},
        {'species': 'Thuja occidentalis'},
        {'species': 'Tsuga canadensis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES_II = PatternList('MODERATE_DIAGNOSTIC_SPECIES_II',
        {'species': 'Acer rubrum'},
        {'species': 'Acer saccharum'},
        {'species': 'Abies balsamea'},
        {'species': 'Abies fraseri'},
        {'species': 'Betula lenta'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Larix laricina'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Picea rubens'},
        {'species': 'Pinus strobus'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus serotina'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus rubra'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus americana'}
    )

    ECOREGIONS_III = PatternList('ECOREGIONS_III',
        {'ecoregion': '212, M211, 211A, 211B, 211C, 211D, 211E, 211Ja, 211Jb, 211Jc'}
    )

    STRONG_DIAGNOSTIC_SPECIES_III = PatternList('STRONG_DIAGNOSTIC_SPECIES_III',
        {'species': 'Acer rubrum'},
        {'species': 'Acer saccharum'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula lenta'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Larix laricina'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Pinus strobus'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus rubra'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=129|Northern Forest macrogroups', plot.ident)
        result = (    plot.riv(DIAGNOSTIC_SPECIES_I) >= 20
               or (     plot.match(ECOREGIONS_II)
                   and (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 50 or (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 20 and plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES_II) >= 50)))
               or (     plot.match(ECOREGIONS_III)
                   and  plot.riv(STRONG_DIAGNOSTIC_SPECIES_III) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_130():

    """Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)"""
    """Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)'

    #  i. Tree composition dominated by one or more of STRONG DRY DIAGNOSTICS Picea mariana,
    #     Pinus banksiana, Pinus resinosa, Pinus strobus, Quercus alba, Quercus ellipsoidalis,
    #     Quercus macrocarpa, Quercus velutina (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are any combination
    #     of MODERATE DRY DIAGNOSTICS Amelanchier spp., Betula populifolia, Betula papyrifera, 
    #     Carpinus caroliniana, Ostrya virginiana, Populus grandidentata, Populus tremuloides, 
    #     Prunus pensylvanica, Prunus serotina, Quercus rubra (together >=50% RIV)

    STRONG_DRY_DIAGNOSTICS = PatternList('STRONG_DRY_DIAGNOSTICS',
        {'species': 'Picea mariana'},
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus resinosa'},
        {'species': 'Pinus strobus'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus velutina'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Amelanchier spp.'},
        {'species': 'Betula populifolia'},
        {'species': 'Betula papyrifera'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus pensylvanica'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus rubra'}
    )

    def match(plot):
        logging.debug('%s|NODE=130|Laurentian-Acadian Pine Hardwood Forest & Woodland (M159)', plot.ident)
        result = (    plot.riv(STRONG_DRY_DIAGNOSTICS) >= 50
               or (    plot.riv(STRONG_DRY_DIAGNOSTICS) >= 20
                   and plot.riv(STRONG_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_131():

    """Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)"""
    """Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)'

    # Tree composition dominated by any one or more of the hardwoods and/or conifers
    # STRONG MESIC DIAGNOSTICS Abies balsamea, Abies fraseri, Acer pensylvanicum,
    # Acer saccharum, Acer spicatum, Betula alleghaniensis, Betula lenta, Fagus grandifolia,
    # Fraxinus americana, Fraxinus nigra, Fraxinus pennsylvanica, Larix laricina, Picea glauca,
    # Picea mariana, Picea rubens, Populus balsamifera, Populus grandidentata, Quercus macrocarpa,
    # Quercus rubra, Thuja occidentalis, Tilia americana, Tsuga canadensis, Ulmus americana (>=20% RIV);

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Abies balsamea'},
        {'species': 'Abies fraseri'},
        {'species': 'Acer pensylvanicum'},
        {'species': 'Acer saccharum'},
        {'species': 'Acer spicatum'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula lenta'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Larix laricina'},
        {'species': 'Picea glauca'},
        {'species': 'Picea mariana'},
        {'species': 'Picea rubens'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus grandidentata'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus rubra'},
        {'species': 'Thuja occidentalis'},
        {'species': 'Tilia americana'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=131|Laurentian-Acadian Mesic Hardwood - Conifer Forest (M014)', plot.ident)
        result = (plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_132():

    """Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)"""
    """Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)'

    # % RIV of STRONG DRY DIAGNOSTICS > STRONG MESIC DIAGNOSTICS [if stands lacks both strong
    # dry and strong mesic diagnostics, plot will be assigned to the mesic]

    STRONG_DRY_DIAGNOSTICS = PatternList('STRONG_DRY_DIAGNOSTICS',
        {'species': 'Picea mariana'},
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus resinosa'},
        {'species': 'Pinus strobus'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus velutina'}
    )

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Abies balsamea'},
        {'species': 'Abies fraseri'},
        {'species': 'Acer pensylvanicum'},
        {'species': 'Acer saccharum'},
        {'species': 'Acer spicatum'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula lenta'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Larix laricina'},
        {'species': 'Picea glauca'},
        {'species': 'Picea mariana'},
        {'species': 'Picea rubens'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus grandidentata'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus rubra'},
        {'species': 'Thuja occidentalis'},
        {'species': 'Tilia americana'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=132|Laurentian-Acadian Pine - Hardwood Forest & Woodland LC (M159)', plot.ident)
        result = (plot.riv(STRONG_DRY_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_133():

    """Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)"""
    """Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)'

    # other

    def match(plot):
        logging.debug('%s|NODE=133|Laurentian-Acadian Mesic Hardwood - Conifer Forest LC1 (M014)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_134():

    """Central Forest macrogroups"""
    """Central Forest macrogroups"""
    level = 'division'
    code = 'Central Forest macrogroups'

    # other

    def match(plot):
        logging.debug('%s|NODE=134|Central Forest macrogroups', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_135():

    """Central Midwest Oak Forest, Woodland & Savanna (M012)"""
    """Central Midwest Oak Forest, Woodland & Savanna (M012)"""
    level = 'macrogroup'
    code = 'Central Midwest Oak Forest, Woodland & Savanna (M012)'

    # Plot occurs in Ecoregion 222, 223G, 251 [excludes 222I, exclude Ozarks ecoregion] AND
    #  i. tree composition dominated by one or more of the STRONG DRY DIAGNOSTICS of Carya ovata, Juniperus virginiana,
    #     Pinus banksiana, Pinus resinosa, Pinus strobus, Populus tremuloides, Quercus alba, Quercus ellipsoidalis,
    #     Quercus imbricaria, Quercus macrocarpa, Quercus rubra, Quercus muehlenbergii, Quercus stellata,
    #     Quercus velutina (>=50% RIV);
    # OR
    # ii. tree composition as above, but with >=20% RIV, AND other species are any combination of MODERATE DRY DIAGNOSTICS
    #     diagnostic species of Betula papyrifera, Carya alba, Carya glabra, Carya laciniosa, or weakly diagnostic species
    #     of Amelanchier spp., Carpinus caroliniana, Cercis canadensis, Cornus florida, Diospyros virginiana,
    #     Fraxinus quadrangulata, Morus rubra, Ostrya virginiana, Populus gradidentata, Prunus serotina,
    #     Quercus falcata (= var. falcata), Sassafras albidum (together >=50% RIV)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '222, 223G, 251 ! 222I'}
    )

    STRONG_DRY_DIAGNOSTICS = PatternList('STRONG_DRY_DIAGNOSTICS',
        {'species': 'Carya ovata'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus resinosa'},
        {'species': 'Pinus strobus'},
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus velutina'}
    )

    MODERATE_DRY_DIAGNOSTICS = PatternList('MODERATE_DRY_DIAGNOSTICS',
        {'species': 'Betula papyrifera'},
        {'species': 'Carya alba'},
        {'species': 'Carya glabra'},
        {'species': 'Carya laciniosa'},
        {'species': 'Amelanchier spp.'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Cercis canadensis'},
        {'species': 'Cornus florida'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Fraxinus quadrangulata'},
        {'species': 'Morus rubra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Populus grandidentata'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus falcata'},
        {'species': 'Sassafras albidum'}
    )

    def match(plot):
        logging.debug('%s|NODE=135|Central Midwest Oak Forest, Woodland & Savanna (M012)', plot.ident)
        result = (    plot.match(ECOREGIONS)
               and (    plot.riv(STRONG_DRY_DIAGNOSTICS) >= 50
                    or (plot.riv(STRONG_DRY_DIAGNOSTICS) >= 20 and plot.riv(STRONG_DRY_DIAGNOSTICS) + plot.riv(MODERATE_DRY_DIAGNOSTICS) >= 50)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_136():

    """Central Midwest Mesic Forest (M882)"""
    """Central Midwest Mesic Forest (M882)"""
    level = 'macrogroup'
    code = 'Central Midwest Mesic Forest (M882)'

    # Stands found in Ecoregion 222, 223A, 223G, 251, 332) [excludes 222I, includes Ozarks ecoregion]
    # AND tree composition dominated by one or more of the following:
    #   i. Tree composition dominated by one or more of the STRONG MESIC DIAGNOSTICS: Acer nigrum, Acer saccharum,
    #      Aesculus glabra, Asimina triloba, Carya cordiformis, Celtis occidentalis, Fagus grandifolia, Fraxinus americana,
    #      Fraxinus nigra, Fraxinus pennsylvanica, Gymnocladus dioicus, Juglans cinerea, Liriodendron tulipifera,
    #      Liquidambar styraciflua, Nyssa sylvatica, Platanus occidentalis, Quercus bicolor, Quercus palustris,
    #      Tilia americana, Ulmus rubra, Ulmus americana (>=50% RIV).
    #  OR
    #  ii. Tree composition as above, but with >=20% RIV and other species are any combination of MODERATE MESIC DIAGNOSTICS
    #      Acer barbatum, Acer negundo, Amelanchier spp., Betula populifolia,  Betula papyrifera, Carpinus caroliniana,
    #      Carya ovalis, Cornus florida, Gleditsia triacanthos, Juglans nigra, Ostrya virginiana, Pinus strobus,
    #      Populus balsamifera, Populus deltoides, Populus grandidentata, Populus tremuloides, Prunus pensylvanica,
    #      Prunus virginiana, Quercus imbricaria, Quercus muehlenbergii, Quercus pagoda, Quercus rubra, Quercus shumardii,
    #      Sassafras albidum, Ulmus thomasii (together >=50% RIV)
    #  OR
    # iii. Tree composition dominated by Quercus rubra with >=20% RIV, AND <20% RIV of other species are any combination of
    #      Quercus spp or Carya spp. (Quercus alba, Quercus coccinea, Quercus ellipsoidalis, Quercus macrocarpa,
    #      Quercus prinus, Quercus velutina, Carya glabra, Carya ovata, Carya alba)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '222, 223A, 223G, 251, 332 ! 222I'}
    )

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer nigrum'},
        {'species': 'Acer saccharum'},
        {'species': 'Aesculus glabra'},
        {'species': 'Asimina triloba'},
        {'species': 'Carya cordiformis'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Gymnocladus dioicus'},
        {'species': 'Juglans cinerea'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Quercus bicolor'},
        {'species': 'Quercus palustris'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus rubra'},
        {'species': 'Ulmus americana'}
    )

    MODERATE_MESIC_DIAGNOSTICS = PatternList('MODERATE_MESIC_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Acer negundo'},
        {'species': 'Amelanchier spp.'},
        {'species': 'Betula populifolia'},
        {'species': 'Betula papyrifera'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Carya ovalis'},
        {'species': 'Cornus florida'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Juglans nigra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Pinus strobus'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus deltoides'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus pensylvanica'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus shumardii'},
        {'species': 'Sassafras albidum'},
        {'species': 'Ulmus thomasii'}
    )

    DIAGNOSTIC_SPECIES_III = PatternList('DIAGNOSTIC_SPECIES_III',
        {'species': 'Quercus rubra'}
    )

    EXCLUDED_SPECIES_III = PatternList('EXCLUDED_SPECIES_III',
        {'species': 'Quercus alba'},
        {'species': 'Quercus coccinea'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus prinus'},
        {'species': 'Quercus velutina'},
        {'species': 'Carya alba'},
        {'species': 'Carya glabra'},
        {'species': 'Carya ovata'}
    )

    def match(plot):
        logging.debug('%s|NODE=136|Central Midwest Mesic Forest (M882)', plot.ident)
        result = (    plot.match(ECOREGIONS)
               and (    plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 50
                    or (plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 20 and plot.riv(STRONG_MESIC_DIAGNOSTICS) + plot.riv(MODERATE_MESIC_DIAGNOSTICS) >= 50)
                    or (plot.riv(DIAGNOSTIC_SPECIES_III) >= 20 and plot.riv(EXCLUDED_SPECIES_III) < 20)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_137():

    """Central Midwest Oak Forest, Woodland & Savanna LC (M012)"""
    """Central Midwest Oak Forest, Woodland & Savanna LC (M012)"""
    level = 'macrogroup'
    code = 'Central Midwest Oak Forest, Woodland & Savanna LC (M012)'

    # Plot occurs in Ecoregions 222 (except not 222I), 251,
    # AND % RIV of STRONG DRY DIAGNOSTICS > STRONG MESIC DIAGNOSTICS

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '222, 251 ! 222I'}
    )

    STRONG_DRY_DIAGNOSTICS = PatternList('STRONG_DRY_DIAGNOSTICS',
        {'species': 'Carya ovata'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Pinus banksiana'},
        {'species': 'Pinus resinosa'},
        {'species': 'Pinus strobus'},
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus velutina'}
    )

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer nigrum'},
        {'species': 'Acer saccharum'},
        {'species': 'Aesculus glabra'},
        {'species': 'Asimina triloba'},
        {'species': 'Carya cordiformis'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus nigra'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Gymnocladus dioicus'},
        {'species': 'Juglans cinerea'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Quercus bicolor'},
        {'species': 'Quercus palustris'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus rubra'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=137|Central Midwest Oak Forest, Woodland & Savanna LC (M012)', plot.ident)
        result = (plot.match(ECOREGIONS) and plot.riv(STRONG_DRY_DIAGNOSTICS) > plot.riv(STRONG_MESIC_DIAGNOSTICS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_138():

    """Central Midwest Mesic Forest LC (M882)"""
    """Central Midwest Mesic Forest LC (M882)"""
    level = 'macrogroup'
    code = 'Central Midwest Mesic Forest LC (M882)'

    # other

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '222, 251 ! 222I'}
    )

    def match(plot):
        logging.debug('%s|NODE=138|Central Midwest Mesic Forest LC (M882)', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_139():

    """Appalachian, Interior - Northeastern Mesic Forest (M883)"""
    """Appalachian, Interior - Northeastern Mesic Forest (M883)"""
    level = 'macrogroup'
    code = 'Appalachian, Interior - Northeastern Mesic Forest (M883)'

    #   i. Tree composition dominated by any one or more of the STRONG MESIC DIAGNOSTICS [Appalachian- Interior-Northeast Mesic
    #      Forest Diagnostics] Acer nigrum [questionable], Acer pensylvanicum, Aesculus flava, Betula alleghaniensis, Betula lenta,
    #      Halesia carolina (=H. tetraptera), Halesia spp., Magnolia acuminata, Magnolia tripetala, Tilia americana var. heterophylla,
    #      Tsuga canadensis, (>=50% RIV);
    #  OR
    #  ii. Plot occurs in EcoProvinces 211F, 211G, 211Jd, 221, M221, 223B-223G, 231A, 231C, 231D, 231I, 232 [only plots in VA, PA,
    #      DE, MD, NJ, southern IN, southern IL] AND tree composition dominated by any one or more of the ECOREGIONAL STRONG MESIC
    #      DIAGNOSTICS [Strong Appalachian- Northeast Mesic Forest Diagnostics] Acer nigrum, Acer pensylvanicum, Acer saccharum,
    #      Aesculus flava, Aesculus glabra, Asimina triloba, Betula alleghaniensis, Betula lenta, Carya cordiformis, Celtis occidentalis,
    #      Fagus grandifolia, Fraxinus americana, Fraxinus pennsylvanica, Halesia carolina (= H. tetraptera), Halesia spp., Liriodendron tulipifera,
    #      Liquidambar styraciflua, Magnolia acuminata, Magnolia fraseri, Magnolia macrophylla, Magnolia tripetela,Quercus shumardii,
    #      Tilia americana, Tilia americana var. heterophylla, Tsuga canadensis, Ulmus americana (>=20% RIV);
    #   AND
    #      any of the following ECOREGIONAL MODERATE MESIC DIAGNOSTICS [Moderate Appalachian-Interior-Northeast Mesic Forest Diagnostics]
    #      Acer barbatum,Amelanchier spp., Betula populifolia, Betula papyrifera, Carpinus caroliniana, Carya ovalis, Cornus florida,
    #      Gleditsia triacanthos, Juglans cinerea, Juglans nigra, Ostrya virginiana, Oxydendrum arboreum, Pinus strobus,
    #      Platanus occidentalis, Populus grandidentata, Populus tremuloides, Prunus pensylvanica, Prunus serotina, Prunus virginiana,
    #      Quercus bicolor, Quercus imbricaria, Quercus muehlenbergii, Quercus pagoda, Quercus phellos, Quercus rubra, Quercus shumardii,
    #      Ulmus rubra, Ulmus thomasii (together >=50% RIV) [note, some mesic Nyssa sylvatica - Quercus alba) plots from Arkansas could
    #      key out here]
    #  OR
    # iii. Plot occurs in EcoSections 211F, 211G, 211Jd, 221, M221, 223B-223G, 231A, 231C, 231D, 231I, 232 AND tree composition dominated
    #      by ECOREGIONAL MODERATE MESIC OAK DIAGNOSTICS Quercus rubra with >=20% RIV, and the following dry Quercus spp. or Carya spp.
    #      (Quercus alba, Quercus coccinea, Quercus prinus, Quercus stellata, Quercus velutina, Carya glabra, Carya alba, Carya pallida)
    #      <20% RIV

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': '211F, 211G, 211Jd, 221, M221, 223B, 223C, 223D, 223E, 223F, 223G, 231A, 231C, 231D, 231I, 232'}
    )

    STRONG_MESIC_DIAGNOSTICS = PatternList('STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer nigrum'},
        {'species': 'Acer pensylvanicum'},
        {'species': 'Aesculus flava'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula lenta'},
        {'species': 'Halesia carolina'},
        {'species': 'Halesia spp.'},
        {'species': 'Magnolia acuminata'},
        {'species': 'Magnolia tripetala'},
        {'species': 'Tilia americana var. heterophylla'},
        {'species': 'Tsuga canadensis'}
    )

    ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS = PatternList('ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer nigrum'},
        {'species': 'Acer pensylvanicum'},
        {'species': 'Acer saccharum'},
        {'species': 'Aesculus flava'},
        {'species': 'Aesculus glabra'},
        {'species': 'Asimina triloba'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula lenta'},
        {'species': 'Carya cordiformis'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Halesia carolina'},
        {'species': 'Halesia spp.'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Magnolia acuminata'},
        {'species': 'Magnolia fraseri'},
        {'species': 'Magnolia macrophylla'},
        {'species': 'Magnolia tripetala'},
        {'species': 'Quercus shumardii'},
        {'species': 'Tilia americana'},
        {'species': 'Tilia americana var. heterophylla'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Ulmus americana'}
    )

    ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS = PatternList('ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Amelanchier spp.'},
        {'species': 'Betula populifolia'},
        {'species': 'Betula papyrifera'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Carya ovalis'},
        {'species': 'Cornus florida'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Juglans cinerea'},
        {'species': 'Juglans nigra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Oxydendrum arboreum'},
        {'species': 'Pinus strobus'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus pensylvanica'},
        {'species': 'Prunus serotina'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus bicolor'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus pagoda'},
        {'species': 'Quercus phellos'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus shumardii'},
        {'species': 'Ulmus rubra'},
        {'species': 'Ulmus thomasii'}
    )

    ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS = PatternList('ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS',
        {'species': 'Quercus rubra'}
    )

    EXCLUDED_SPECIES = PatternList('EXCLUDED_SPECIES',
        {'species': 'Quercus alba'},
        {'species': 'Quercus coccinea'},
        {'species': 'Quercus prinus'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus velutina'},
        {'species': 'Carya glabra'},
        {'species': 'Carya alba'},
        {'species': 'Carya pallida'}
    )

    def match(plot):
        logging.debug('%s|NODE=139|Appalachian, Interior - Northeastern Mesic Forest (M883)', plot.ident)
        result = (    plot.riv(STRONG_MESIC_DIAGNOSTICS) >= 50
               or (    plot.match(ECOREGIONS_1)
                   and (   (    plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS) >= 20
                            and plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS) + plot.riv(ECOREGIONAL_MODERATE_MESIC_DIAGNOSTICS) >= 50)
                        or (    plot.riv(ECOREGIONAL_MODERATE_MESIC_OAK_DIAGNOSTICS) >= 20
                            and plot.riv(EXCLUDED_SPECIES) < 20))))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_140():

    """Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)"""
    """Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)"""
    level = 'macrogroup'
    code = 'Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)'

    # Plot not in Ecoregion 212 AND
    #  i. Tree composition dominated by one or more of the STRONG APPALACHIAN DRY DIAGNOSTICS of Carya glabra,
    #     Carya ovata, Carya alba, Castanea dentata, Fraxinus quadrangulata, Juniperus virginiana, Nyssa sylvatica,
    #     Pinus echinata, Pinus pungens, Pinus rigida, Pinus strobus, Pinus virginiana, Quercus alba, Quercus coccinea,
    #     Quercus ellipsoidalis, Quercus falcata (= var. falcata), Quercus imbricaria, Quercus ilicifolia,
    #     Quercus marilandica, Quercus prinus, Quercus stellata, Quercus velutina, Tsuga caroliniana
    #     (>=50% RIV);
    # OR
    # ii. Tree composition as above, but with >=20% RIV, AND other species are any combination of weakly diagnostic
    #     species of Amelanchier spp., Carpinus caroliniana, Cercis canadensis, Cornus florida,
    #     Ostrya virginiana, Oxydendrum arboreum, Pinus banksiana, Prunus serotina, Prunus virginiana,
    #     Quercus muehlenbergii, Quercus rubra, Sassafras albidum (>=50% RIV)

    ECOREGION = PatternList('ECOREGION',
        {'ecoregion': '!212'}
    )

    STRONG_APPALACHIAN_DRY_DIAGNOSTICS = PatternList('STRONG_APPALACHIAN_DRY_DIAGNOSTICS',
        {'species': 'Carya glabra'},
        {'species': 'Carya ovata'},
        {'species': 'Carya alba'},
        {'species': 'Castanea dentata'},
        {'species': 'Fraxinus quadrangulata'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus pungens'},
        {'species': 'Pinus rigida'},
        {'species': 'Pinus strobus'},
        {'species': 'Pinus virginiana'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus coccinea'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus ilicifolia'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus prinus'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus velutina'},
        {'species': 'Tsuga caroliniana'}
    )

    MODERATE_APPALACHIAN_DRY_DIAGNOSTICS = PatternList('MODERATE_APPALACHIAN_DRY_DIAGNOSTICS',
        {'species': 'Amelanchier spp.'},
        {'species': 'Carpinus caroliniana'},
        {'species': 'Cercis canadensis'},
        {'species': 'Cornus florida'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Oxydendrum arboreum'},
        {'species': 'Pinus banksiana'},
        {'species': 'Prunus serotina'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus rubra'},
        {'species': 'Sassafras albidum'}
    )

    def match(plot):
        logging.debug('%s|NODE=140|Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland (M502)', plot.ident)
        result = (plot.match(ECOREGION) and (plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) >= 50 or (plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) >= 20 and plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) + plot.riv(MODERATE_APPALACHIAN_DRY_DIAGNOSTICS) >= 50)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_141():

    """Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)"""
    """Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)"""
    level = 'macrogroup'
    code = 'Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)'

    # Plot is in Ecoregion 212

    ECOREGION = PatternList('ECOREGION',
        {'ecoregion': '212'}
    )

    def match(plot):
        logging.debug('%s|NODE=141|Laurentian-Acadian Mesic Hardwood - Conifer Forest LC2 (M014)', plot.ident)
        result = (plot.match(ECOREGION))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_142():

    """Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)"""
    """Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)"""
    level = 'macrogroup'
    code = 'Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)'

    # i. %RIV STRONG APPALACHIAN DRY DIAGNOSTICS > either STRONG DRY SOUTH-CENTRAL DIAGNOSTICS OR ECOREGIONAL STRONG MESIC DIAGNOSTICS

    STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS = PatternList('STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS',
        {'species': 'Acer barbatum'},
        {'species': 'Carya pallida'},
        {'species': 'Carya texana'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Fraxinus quadrangulata'},
        {'species': 'Ilex opaca'},
        {'species': 'Juniperus ashei'},
        {'species': 'Oxydendrum arboreum'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus taeda'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus nigra'},
        {'species': 'Quercus stellata'},
        {'species': 'Ulmus alata'}
    )

    STRONG_APPALACHIAN_DRY_DIAGNOSTICS = PatternList('STRONG_APPALACHIAN_DRY_DIAGNOSTICS',
        {'species': 'Carya glabra'},
        {'species': 'Carya ovata'},
        {'species': 'Carya alba'},
        {'species': 'Castanea dentata'},
        {'species': 'Fraxinus quadrangulata'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Nyssa sylvatica'},
        {'species': 'Pinus echinata'},
        {'species': 'Pinus pungens'},
        {'species': 'Pinus rigida'},
        {'species': 'Pinus strobus'},
        {'species': 'Pinus virginiana'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus coccinea'},
        {'species': 'Quercus ellipsoidalis'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus imbricaria'},
        {'species': 'Quercus ilicifolia'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus prinus'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus velutina'},
        {'species': 'Tsuga caroliniana'}
    )

    ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS = PatternList('ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS',
        {'species': 'Acer nigrum'},
        {'species': 'Acer pensylvanicum'},
        {'species': 'Acer saccharum'},
        {'species': 'Aesculus flava'},
        {'species': 'Aesculus glabra'},
        {'species': 'Asimina triloba'},
        {'species': 'Betula alleghaniensis'},
        {'species': 'Betula lenta'},
        {'species': 'Carya cordiformis'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fagus grandifolia'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Halesia carolina'},
        {'species': 'Liriodendron tulipifera'},
        {'species': 'Liquidambar styraciflua'},
        {'species': 'Magnolia acuminata'},
        {'species': 'Magnolia fraseri'},
        {'species': 'Magnolia macrophylla'},
        {'species': 'Magnolia tripetala'},
        {'species': 'Quercus shumardii'},
        {'species': 'Tilia americana'},
        {'species': 'Tilia americana var. heterophylla'},
        {'species': 'Tsuga canadensis'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=142|Appalachian-Northeastern Oak - Hardwood - Pine Forest & Woodland LC (M502)', plot.ident)
        result = (   plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) > plot.riv(STRONG_DRY_SOUTH_CENTRAL_DIAGNOSTICS)
               or plot.riv(STRONG_APPALACHIAN_DRY_DIAGNOSTICS) > plot.riv(ECOREGIONAL_STRONG_MESIC_DIAGNOSTICS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_143():

    """Appalachian, Interior - Northeastern Mesic Forest LC (M883)"""
    """Appalachian, Interior - Northeastern Mesic Forest LC (M883)"""
    level = 'macrogroup'
    code = 'Appalachian, Interior - Northeastern Mesic Forest LC (M883)'

    # other

    def match(plot):
        logging.debug('%s|NODE=143|Appalachian, Interior - Northeastern Mesic Forest LC (M883)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_144():

    """Eastern Cool Temperate Ruderal Forest & Woodlands"""
    """Eastern Cool Temperate Ruderal Forest & Woodlands"""
    level = 'division'
    code = 'Eastern Cool Temperate Ruderal Forest & Woodlands'

    # Vegetation in a relatively natural state, dominated by native species; little or no
    # evidence of trees in a row, no very recent logging, understory mowing, etc. (trees
    # may be early successional pole-sized trees following logging or blowdowns).  Tree
    # composition dominated by ruderal native or exotic species (>= 80% RIV) (See Appendix A -
    # needs to be refined for this Division)

    def match(plot):
        logging.debug('%s|NODE=144|Eastern Cool Temperate Ruderal Forest & Woodlands', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_145():

    """Eastern North American Ruderal Forest (M013)"""
    """Eastern North American Ruderal Forest (M013)"""
    level = 'macrogroup'
    code = 'Eastern North American Ruderal Forest (M013)'

    # other

    def match(plot):
        logging.debug('%s|NODE=145|Eastern North American Ruderal Forest (M013)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

