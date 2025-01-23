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
        self.nodes[  2] = Node(  2,   0, element_002(), 'Natural (including ruderal) Forests')
        self.nodes[  3] = Node(  3,   2, element_003(), 'Wetland Forest & Woodlands')
        self.nodes[  4] = Node(  4,   3, element_004(), 'Temperate Flooded & Swamp Forest Formation')
        self.nodes[  5] = Node(  5,   4, element_005(), 'Great Plains Temperate Flooded & Swamp Forests')
        self.nodes[  6] = Node(  6,   5, element_006(), 'Eastern North American-Great Plains Flooded & Swamp Forest Division (D011)')
        self.nodes[  7] = Node(  7,   6, element_007(), 'Great Plains Flooded & Swamp Forest (M028)')
        self.nodes[  8] = Node(  8,   7, element_008(), 'Great Plains Cottonwood - Green Ash Floodplain Forest (G147)')
        self.nodes[  9] = Node(  9,   6, element_009(), 'Eastern North American Ruderal Flooded & Swamp Forest (M302)')
        self.nodes[ 10] = Node( 10,   5, element_010(), 'Southeastern North American Flooded & Swamp Forest Division (D062)')
        self.nodes[ 11] = Node( 11,  10, element_011(), 'Southern Great Plains Floodplain Forest & Woodland (M154)')
        self.nodes[ 12] = Node( 12,  11, element_012(), 'Southeastern Great Plains Floodplain Forest (G784)')
        self.nodes[ 13] = Node( 13,  10, element_013(), 'Southeastern North American Ruderal Flooded & Swamp Forest (M310)')
        self.nodes[ 14] = Node( 14,   4, element_014(), 'Western North American Temperate Flooded & Swamp Forests')
        self.nodes[ 15] = Node( 15,  14, element_015(), 'Vancouverian Flooded & Swamp Forest Division (D193)')
        self.nodes[ 16] = Node( 16,  15, element_016(), 'Vancouverian Flooded & Swamp Forest (M035)')
        self.nodes[ 17] = Node( 17,  16, element_017(), 'North-Central Pacific Montane Riparian & Seepage Swamp Forest (G507)')
        self.nodes[ 18] = Node( 18,  16, element_018(), 'North-Central Pacific Maritime Lowland Swamp Forest (G853)')
        self.nodes[ 19] = Node( 19,  16, element_019(), 'North-Central Pacific Lowland Riparian Forest (G851)')
        self.nodes[ 20] = Node( 20,  15, element_020(), 'Western North American Flooded Ruderal Forests - Vancouverian')
        self.nodes[ 21] = Node( 21,  14, element_021(), 'Rocky Mountain-Great Basin Montane Flooded & Swamp Forest Division (D195)')
        self.nodes[ 22] = Node( 22,  21, element_022(), 'Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)')
        self.nodes[ 23] = Node( 23,  22, element_023(), 'Rocky Mountain-Great Basin Swamp Forest (G505)')
        self.nodes[ 24] = Node( 24,  22, element_024(), 'Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (G506)')
        self.nodes[ 25] = Node( 25,  22, element_025(), 'Central Rocky Mountain Lowland & Foothill Riparian Forest (G796)')
        self.nodes[ 26] = Node( 26,  21, element_026(), 'Western North American Flooded Ruderal Forests - Rocky Mountain')
        self.nodes[ 27] = Node( 27,  14, element_027(), 'Western North American Interior Flooded Forest Division (D013)')
        self.nodes[ 28] = Node( 28,  27, element_028(), 'Interior Warm & Cool Desert Riparian Forest (M036)')
        self.nodes[ 29] = Node( 29,  28, element_029(), 'Tamaulipan Riparian Scrub Forest (G549)')
        self.nodes[ 30] = Node( 30,  28, element_030(), 'Californian Mediterranean Riparian Forest (G113)')
        self.nodes[ 31] = Node( 31,  28, element_031(), 'Southwest Warm Desert Riparian Forest (G109)')
        self.nodes[ 32] = Node( 32,  28, element_032(), 'Great Basin-Colorado Plateau Semi-Desert Riparian Forest (G107)')
        self.nodes[ 33] = Node( 33,  27, element_033(), 'Interior West Ruderal Flooded & Swamp Forest & Woodland (M298)')
        self.nodes[ 34] = Node( 34,   2, element_034(), 'Upland Forest & Woodlands')
        self.nodes[ 35] = Node( 35,  34, element_035(), 'Temperate & Boreal Forest & Woodland Subclass')
        self.nodes[ 36] = Node( 36,  35, element_036(), 'Great Plains Temperate Forests')
        self.nodes[ 37] = Node( 37,  36, element_037(), 'North American Great Plains Forest & Woodland Division (D326)')
        self.nodes[ 38] = Node( 38,  37, element_038(), 'Southern Great Plains Forest & Woodland (M544)')
        self.nodes[ 39] = Node( 39,  38, element_039(), 'Cross Timbers Forest & Woodland (G887)')
        self.nodes[ 40] = Node( 40,  38, element_040(), 'Edwards Plateau Dry-Mesic Hardwood Forest (G028)')
        self.nodes[ 41] = Node( 41,  38, element_041(), 'Edwards Plateau Dry Woodland (G126)')
        self.nodes[ 42] = Node( 42,  37, element_042(), 'Northern Great Plains Forest & Woodland (M545)')
        self.nodes[ 43] = Node( 43,  42, element_043(), 'Great Plains Bur Oak Forest & Woodland(G329)')
        self.nodes[ 44] = Node( 44,  42, element_044(), 'Northeastern Great Plains Aspen Woodland (G146)')
        self.nodes[ 45] = Node( 45,  42, element_045(), 'Northwestern Great Plains Aspen Woodland (G328)')
        self.nodes[ 46] = Node( 46,  42, element_046(), 'Great Plains Mesic Forest & Woodland (G145)')
        self.nodes[ 47] = Node( 47,  37, element_047(), 'Great Plains Ruderal Woodland (M524)')
        self.nodes[ 48] = Node( 48,  36, element_048(), 'Southeastern North American Forest & Woodland Division (D006)')
        self.nodes[ 49] = Node( 49,  48, element_049(), 'Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)')
        self.nodes[ 50] = Node( 50,  49, element_050(), 'Coastal Live Oak - Hickory - Palmetto Forest (G798)')
        self.nodes[ 51] = Node( 51,  49, element_051(), 'Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)')
        self.nodes[ 52] = Node( 52,  48, element_052(), 'Southeastern North American Ruderal Forest (M305)')
        self.nodes[ 53] = Node( 53,  36, element_053(), 'Eastern North American Forest & Woodland Division (D008)')
        self.nodes[ 54] = Node( 54,  53, element_054(), 'Eastern North American Forest & Woodland Natural Forests')
        self.nodes[ 55] = Node( 55,  54, element_055(), 'Central Midwest Oak Forest, Woodland & Savanna (M012)')
        self.nodes[ 56] = Node( 56,  55, element_056(), 'North-Central Oak - Hickory Forest & Woodland (G649)')
        self.nodes[ 57] = Node( 57,  54, element_057(), 'Southern & South-Central Oak - Pine Forest & Woodland (M016)')
        self.nodes[ 58] = Node( 58,  57, element_058(), 'Western Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)')
        self.nodes[ 59] = Node( 59,  53, element_059(), 'Eastern North American Ruderal Forests')
        self.nodes[ 60] = Node( 60,  59, element_060(), 'Eastern North American Ruderal Forest (M013)')
        self.nodes[ 61] = Node( 61,  35, element_061(), 'Western North American Temperate Forests')
        self.nodes[ 62] = Node( 62,  61, element_062(), 'Warm Temperate Forest & Woodland Formation')
        self.nodes[ 63] = Node( 63,  62, element_063(), 'Californian Forest & Woodland Division (D007)')
        self.nodes[ 64] = Node( 64,  63, element_064(), 'Californian Forest & Woodland (M009)')
        self.nodes[ 65] = Node( 65,  64, element_065(), 'Californian Conifer Forest & Woodland (G198)')
        self.nodes[ 66] = Node( 66,  64, element_066(), 'Californian Broadleaf Forest & Woodland (G195)')
        self.nodes[ 67] = Node( 67,  63, element_067(), 'Californian Ruderal Forest (M513)')
        self.nodes[ 68] = Node( 68,  62, element_068(), 'Madrean Forest & Woodland Division (D331)')
        self.nodes[ 69] = Node( 69,  68, element_069(), 'Madrean Natural Forests & Woodlands')
        self.nodes[ 70] = Node( 70,  69, element_070(), 'Madrean Lowland Evergreen Woodland (M010)')
        self.nodes[ 71] = Node( 71,  70, element_071(), 'Madrean Pinyon - Juniper Woodland (G200)')
        self.nodes[ 72] = Node( 72,  70, element_072(), 'Madrean Encinal (G201)')
        self.nodes[ 73] = Node( 73,  70, element_073(), 'Madrean Juniper Open Woodland (G487)')
        self.nodes[ 74] = Node( 74,  69, element_074(), 'Madrean Montane Forest & Woodland (M011)')
        self.nodes[ 75] = Node( 75,  74, element_075(), 'Madrean Upper Montane Conifer - Oak Forest & Woodland (G202)')
        self.nodes[ 76] = Node( 76,  74, element_076(), 'Madrean Lower Montane Pine - Oak Forest & Woodland (G203)')
        self.nodes[ 77] = Node( 77,  68, element_077(), 'Western North American Ruderal Forests - Madrean-Balconian')
        self.nodes[ 78] = Node( 78,  61, element_078(), 'Cool Temperate Forest & Woodland Formation')
        self.nodes[ 79] = Node( 79,  78, element_079(), 'Pacific Coast Temperate Rainforest Division (D338)')
        self.nodes[ 80] = Node( 80,  79, element_080(), 'Vancouverian Coastal Rainforest (M024)')
        self.nodes[ 81] = Node( 81,  80, element_081(), 'Vancouverian Dry Coastal Beach Pine Forest & Woodland (G205)')
        self.nodes[ 82] = Node( 82,  80, element_082(), 'Californian Coastal Redwood Forest (G235)')
        self.nodes[ 83] = Node( 83,  80, element_083(), 'North Pacific Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)')
        self.nodes[ 84] = Node( 84,  80, element_084(), 'North Pacific Maritime Douglas-fir - Western Hemlock Rainforest (G240)')
        self.nodes[ 85] = Node( 85,  80, element_085(), 'North-Central Pacific Maritime Silver Fir - Western Hemlock Rainforest (G241)')
        self.nodes[ 86] = Node( 86,  80, element_086(), 'North-Central Pacific Western Hemlock - Sitka Spruce Rainforest (G751)')
        self.nodes[ 87] = Node( 87,  78, element_087(), 'Western North American Pinyon-Juniper Woodland & Scrub Division (D010)')
        self.nodes[ 88] = Node( 88,  87, element_088(), 'Intermountain Pinyon-Juniper Woodland (M896)')
        self.nodes[ 89] = Node( 89,  88, element_089(), 'Intermountain Western Juniper Open Woodland (G248)')
        self.nodes[ 90] = Node( 90,  88, element_090(), 'Intermountain Basins Curl-leaf Mountain-mahogany Woodland & Scrub (G249)')
        self.nodes[ 91] = Node( 91,  88, element_091(), 'Great Basin Pinyon - Juniper Woodland (G899)')
        self.nodes[ 92] = Node( 92,  88, element_092(), 'Colorado Plateau Pinyon - Juniper Woodland (G900)')
        self.nodes[ 93] = Node( 93,  88, element_093(), 'Intermountain Utah Juniper Open Woodland (G105)')
        self.nodes[ 94] = Node( 94,  87, element_094(), 'Southern Rocky Mountain Two-needle Pinyon-Juniper Woodland (M897)')
        self.nodes[ 95] = Node( 95,  94, element_095(), 'Southern Rocky Mountain Pinyon - Juniper Woodland (G253)')
        self.nodes[ 96] = Node( 96,  94, element_096(), 'Southern Rocky Mountain Juniper Open Woodland (G252)')
        self.nodes[ 97] = Node( 97,  78, element_097(), 'Pacific Mountains Forest & Woodland Division (D339)')
        self.nodes[ 98] = Node( 98,  97, element_098(), 'Southern Vancouverian Dry Foothill Forest & Woodland (M886)')
        self.nodes[ 99] = Node( 99,  98, element_099(), 'Cascadian Oregon White Oak - Conifer Forest & Woodland (G206)')
        self.nodes[100] = Node(100,  98, element_100(), 'Californian Moist Coastal Mixed Evergreen Forest (G208)')
        self.nodes[101] = Node(101,  98, element_101(), 'Southern Vancouverian Dry Douglas-fir - Madrone Woodland (G800)')
        self.nodes[102] = Node(102,  97, element_102(), 'Southern Vancouverian Montane-Foothill Forest (M023)')
        self.nodes[103] = Node(103, 102, element_103(), 'Californian Montane Conifer Forest & Woodland (G344)')
        self.nodes[104] = Node(104,  97, element_104(), 'Vancouverian Ruderal Forest (M405)')
        self.nodes[105] = Node(105, 104, element_105(), 'Vancouverian Ruderal Forest (G801)')
        self.nodes[106] = Node(106,  78, element_106(), 'Rocky Mountain Foothills & Montane Forest & Woodland (D337)')
        self.nodes[107] = Node(107, 106, element_107(), 'Southern Rocky Mountain Lower Montane Forest (M022)')
        self.nodes[108] = Node(108, 107, element_108(), 'Southern Rocky Mountain Bristlecone Pine Forest & Woodland (G102)')
        self.nodes[109] = Node(109, 107, element_109(), 'Southern Rocky Mountain Mesic-Moist Mixed Conifer Forest (G225)')
        self.nodes[110] = Node(110, 107, element_110(), 'Southern Rocky Mountain Dry Mixed Conifer Forest & Woodland (G226)')
        self.nodes[111] = Node(111, 107, element_111(), 'Southern Rocky Mountain Ponderosa Pine Forest & Woodland (G103)')
        self.nodes[112] = Node(112, 106, element_112(), 'Central Rocky Mountain Dry Lower Montane-Foothill Forest (M501)')
        self.nodes[113] = Node(113, 112, element_113(), 'Central Rocky Mountain Montane White Spruce Forest (G345)')
        self.nodes[114] = Node(114, 112, element_114(), 'Black Hills-Northwestern Great Plains Ponderosa Pine Forest & Woodland (G216)')
        self.nodes[115] = Node(115, 112, element_115(), 'Rocky Mountain Foothill-Rock Outcrop Limber Pine - Juniper Woodland (G209)')
        self.nodes[116] = Node(116, 112, element_116(), 'Central Rocky Mountain Ponderosa Pine Forest & Woodland (G213)')
        self.nodes[117] = Node(117, 112, element_117(), 'Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)')
        self.nodes[118] = Node(118, 112, element_118(), 'Central Rocky Mountain Mesic-Moist Mixed Conifer Forest (G215)')
        self.nodes[119] = Node(119, 106, element_119(), 'Central Rocky Mountain Mesic Lower Montane Forest (M500)')
        self.nodes[120] = Node(120, 119, element_120(), 'East Cascades Moist-Mesic Grand Fir - Douglas-fir Forest (G212)')
        self.nodes[121] = Node(121, 119, element_121(), 'Central Rocky Mountain-Interior Cedar - Hemlock Forest (G217)')
        self.nodes[122] = Node(122, 119, element_122(), 'Central Rocky Mountain-Interior Mesic Grand Fir - Douglas-fir - Western Larch Forest (G211)')
        self.nodes[123] = Node(123,  78, element_123(), 'Western Cordilleran Subalpine-High Montane Forest & Woodland (D336)')
        self.nodes[124] = Node(124, 123, element_124(), 'Rocky Mountain Subalpine-High Montane Forest (M020)')
        self.nodes[125] = Node(125, 124, element_125(), 'Rocky Mountain-Interior Subalpine-Montane Aspen Forest (G222)')
        self.nodes[126] = Node(126, 124, element_126(), 'Rocky Mountain Subalpine Moist-Mesic Spruce - Fir Forest (G218)')
        self.nodes[127] = Node(127, 124, element_127(), 'Rocky Mountain Subalpine Dry-Mesic Spruce - Fir Forest (G219)')
        self.nodes[128] = Node(128, 124, element_128(), 'Rocky Mountain Lodgepole Pine Forest & Woodland (G220)')
        self.nodes[129] = Node(129, 124, element_129(), 'Rocky Mountain Limber Pine Subalpine-Montane Woodland (G101)')
        self.nodes[130] = Node(130, 124, element_130(), 'Central Rocky Mountain Whitebark Pine - Subalpine Larch Forest & Woodland (G223)')
        self.nodes[131] = Node(131, 123, element_131(), 'Vancouverian Subalpine-High Montane Forest (M025)')
        self.nodes[132] = Node(132, 131, element_132(), 'Sierra-Cascade Cold-Dry Subalpine Woodland (G243)')
        self.nodes[133] = Node(133, 131, element_133(), 'Sierra-Cascade Red Fir - Mountain Hemlock Forest (G749)')
        self.nodes[134] = Node(134, 131, element_134(), 'North-Central Pacific Mountain Hemlock - Silver Fir Woodland (G849)')

        for ident, element in self.nodes.items():
            if (element.parent is not None):
                self.nodes[element.parent].children.append(self.nodes[ident])

        return self.nodes[0]

def element_001():

    """Forest Plantations"""
    """"""
    level = ''
    code = ''

    # Vegetation shows evidence of intensive human management as planted vegetation,
    # such as trees being planted in rows, often dominated by single-species, and even
    # aged.  The stand is identified as planted in the FIA database (Stand Origin Code
    # = 1 "Clear evidence of artificial regeneration," Condition Table, Miles et al. 2001).
    # AND the Stand Origin Species (STDORGSP) is EITHER a Populus spp. or Exotic.

    PLANTATION = PatternList('PLANTATION',
        {'plantation': 'yes'}
    )

    PLANTED_EXOTIC = PatternList('PLANTED_EXOTIC',
        {'planted': 'yes'},
        {'exotic': 'yes'}
    )

    PLANTED_POPULUS = PatternList('PLANTED_POPULUS',
        {'planted': 'yes'},
        {'species': 'Populus'}
    )

    def match(plot):
        logging.debug('%s|NODE=001|Forest Plantations', plot.ident)
        result = (plot.match(PLANTATION)
               and (plot.riv(PLANTED_EXOTIC) > 0 or plot.riv(PLANTED_POPULUS) > 0))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_002():

    """Natural (including ruderal) Forests"""
    """C01"""
    level = 'class'
    code = 'C01'

    # Natural (including ruderal) forests

    def match(plot):
        logging.debug('%s|NODE=002|Natural (including ruderal) Forests', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_003():

    """Wetland Forest & Woodlands"""
    """"""
    level = 'class'
    code = ''

    # Vegetation is a Western section wetland forest, where:
    # i.  The ecoregion (ECOREGION) is 315C-E, 315G, OR 321B [Southern Great Plains Floodplain Forest & Woodland] AND
    #  ia. If the physiographic class code is RIVERINE = Y
    #   OR
    #  ib. the combination of facultative wet (W2) and facultative (W3) tree (RIV =>50%) species
    #  Celtis laevigata var. reticulata, Fraxinus pennsylvanica, Populus deltoides, or Ulmus americana
    # OR
    # ii. If the physiographic class code is RIVERINE = Y, AND EITHER
    #  iia.  Facultative wet (W2) tree species have at least a combined RIV =>20%,
    #  and OBLigate wet (W1) understory species (See Appendix xx) have a combined SPCOV =>10%,
    #  OR
    #  iib.  Facultative wet (W2) tree species have at least a combined RIV => 20%,
    #  and the combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 40%,
    #  OR
    #  iic.  Facultative (W3) tree species have at least a combined RIV => 20%,
    #  The combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 50%,
    #  OR
    #  iid. Wetland indicators for trees (% RIV) or understory (% SPCOV) species W1, W2 (WI) > Upland indicators (UI).
    #  Do not include exotic species.
    #  OR
    #  iie. RIV Populus fremontii > 20% # test
    # OR
    # iii. If physiographic class code is HYDRIC = Y, OR if the physiographic class code is RIVERINE = Y, AND EITHER
    #  iiia. Facultative wet (W2) tree species have at least a combined RIV =>10%,
    #  and OBLigate wet (W1) understory species (See Appendix xx) have a combined SPCOV =>10%,
    #  OR
    #  iiib. Facultative wet (W2) tree species have at least a combined RIV => 10%,
    #  and the combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 50%,
    #  OR
    #  iiic. Facultative (W3) tree species have at least a combined RIV => 10%, and
    #  the combination of OBLigate wet (W1) or facultative wet (W2) understory species SPCOV => 40%,
    #  OR
    #  iiid. Wetland indicators for trees (% RIV) or understory (% SPCOV) species W1, W2 (WI) > Upland indicators (UI).
    #  Do not include exotic species.
    #  OR
    #  iiie. RIV Populus fremontii > 20% # test
    #  OR
    # iv. If the ecoregion (ECOREGION ) is 242 AND
    #  iva. The facultative wet (W2) tree species have at least a combined RIV =>20%, and the combination of
    # obligate wet (W1) and facultative wet (W2) understory species and have a combined SPCOV =>50%
    #  OR
    #  va. The “facultative wet” (W2) tree species have at least a combined RIV =>520%, and the combination of “obligate wet” (W1) and “facultative wet” (W2) understory species and have a combined SPCOV =>50%

    ECOREGIONS_SGP = PatternList('ECOREGIONS_SGP',
        {'ecoregion': '315Ce, 315G, 321B'}
    )

    ECOREGIONS_IV = PatternList('ECOREGIONS_IV',
        {'ecoregion': '242'}
    )

    RIVERINE = PatternList('RIVERINE',
        {'riverine': 'yes'}
    )

    HYDRIC_OR_RIVERINE = PatternList('HYDRIC_OR_RIVERINE',
        {'hydric': 'yes'},
        {'riverine': 'yes'}
    )

    W1 = PatternList('W1',
        {'wetland': 'OBL'}
    )

    W1_UNDERSTORY = PatternList('W1_UNDERSTORY',
        {'wetland': 'OBL'},
        {'tallytree': 'no'}
    )

    W2 = PatternList('W2',
        {'wetland': 'FACW'}
    )

    W2_UNDERSTORY = PatternList('W2_UNDERSTORY',
        {'wetland': 'FACW'},
        {'tallytree': 'no'}
    )

    W3 = PatternList('W3',
        {'wetland': 'FAC'}
    )

    WI = PatternList('WI',
        {'wetland': 'OBL, FACW'},
        {'exotic': 'no'}
    )

    WI_UNDERSTORY = PatternList('WI_UNDERSTORY',
        {'wetland': 'OBL, FACW'},
        {'exotic': 'no'},
        {'tallytree': 'no'}
    )

    UI = PatternList('UI',
        {'wetland': 'UPL'},
        {'exotic': 'no'}
    )

    UI_UNDERSTORY = PatternList('UI_UNDERSTORY',
        {'wetland': 'UPL'},
        {'exotic': 'no'},
        {'tallytree': 'no'}
    )

    Populus_fremontii = PatternList('Populus_fremontii',
        {'species': 'Populus fremontii'}
    )

    def match(plot):
        logging.debug('%s|NODE=003|Wetland Forest & Woodlands', plot.ident)
        result = ((plot.match(ECOREGIONS_SGP) and ( plot.match(RIVERINE) or (plot.riv(W2) + plot.riv(W3) >= 50) ))
               or (plot.match(RIVERINE) and ( (plot.riv(W2) >= 20 and plot.spcov(W1_UNDERSTORY) >= 10)
                                         or (plot.riv(W2) >= 20 and plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 40)
                                         or (plot.riv(W3) >= 20 and plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 50)
                                         or (plot.riv(WI) > plot.riv(UI) or plot.spcov(WI_UNDERSTORY) > plot.spcov(UI_UNDERSTORY)) ))
                                         or (plot.riv(Populus_fremontii) >= 20)
               or (plot.match(HYDRIC_OR_RIVERINE) and ( (plot.riv(W2) >= 10 and plot.spcov(W1_UNDERSTORY) >= 10)
                                                    or (plot.riv(W2) >= 10 and plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 50)
                                                    or (plot.riv(W3) >= 10 and plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 40)
                                                    or (plot.riv(WI) > plot.riv(UI) or plot.spcov(WI_UNDERSTORY) > plot.spcov(UI_UNDERSTORY)) ))
                                                    or (plot.riv(Populus_fremontii) >= 20)
               or (plot.match(ECOREGIONS_IV) and (plot.riv(W2) >= 20 and plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >= 50))
               or (plot.riv(W2) >= 20 and plot.spcov(W1_UNDERSTORY) + plot.spcov(W2_UNDERSTORY) >=50))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_004():

    """Temperate Flooded & Swamp Forest Formation"""
    """F026"""
    level = 'formation'
    code = 'F026'

    #   Tree-dominated wetlands in a temperate climate that is influenced by minerotrophic
    #   groundwater, either on mineral or organic soils. The vegetation is dominated by broad-leaved
    #   or needle-leaved trees, generally over 10% tree cover, and the substrate is either a
    #   wood-rich peat or a mineral soil on floodplains.

    def match(plot):
        logging.debug('%s|NODE=004|Temperate Flooded & Swamp Forest Formation', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_005():

    """Great Plains Temperate Flooded & Swamp Forests"""
    """F026"""
    level = 'formation'
    code = 'F026'

    # Forests found in ECOREGION 315, 331, 332, M334, AND
    # tree composition is dominated by one or more of Acer negundo, Betula occidentalis
    # Carya illinoinensis, Celtis laevigata, Celtis laevigata var. reticulata,
    # Celtis occidentalis, Fraxinus pennsylvanica, Juglans microcarpa,
    # Juglans nigra, Juglans major, Platanus occidentalis, Populus angustifolia Populus deltoides,
    # Quercus macrocarpa, Quercus shumardii, Quercus virginiana, Salix nigra,
    # Salix amygdaloides, Sapindus saponaria var. drummondii,
    # Sideroxylon lanuginosum ssp. lanuginosum, Taxodium distichum, or Ulmus americana
    # (=>20% RIV)

    ECOREGIONS_GP = PatternList('ECOREGIONS_GP',
        {'ecoregion': '315, 331, 332, M334'}
    )

    DIAGNOSTIC_SPECIES = PatternList('DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis laevigata var. reticulata'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Juglans nigra'},
        {'species': 'Juglans major'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus virginiana'},
        {'species': 'Salix nigra'},
        {'species': 'Salix amygdaloides'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Sideroxylon lanuginosum ssp. lanuginosum'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus americana'},
        {'species': 'Betula occidentalis'},
        {'species': 'Populus angustifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=005|Great Plains Temperate Flooded & Swamp Forests', plot.ident)
        result = (plot.match(ECOREGIONS_GP) and plot.riv(DIAGNOSTIC_SPECIES) >= 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_006():

    """Eastern North American-Great Plains Flooded & Swamp Forest Division (D011)"""
    """D011"""
    level = 'division'
    code = 'D011'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION ECOREGION 332, M334, 331 – exclude 331A, 
    # AND
    # ii. EITHER
    # a. Tree composition dominated by one or more of STRONG diagnostic tree species
    # Celtis occidentalis, Fraxinus pennsylvanica, Populus deltoides,
    # Salix nigra or Salix amygdaloides (=>50% RIV),
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species any combination of
    # Acer negundo, Acer saccharinum, Celtis laevigata, Platanus occidentalis, or Ulmus americana
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '332, M334, 331'}
    )

    ECOREGIONS_EXCL = PatternList('ECOREGIONS_EXCL',
        {'ecoregion': '331A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Celtis occidentalis'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Populus deltoides'},
        {'species': 'Salix nigra'},
        {'species': 'Salix amygdaloides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Acer saccharinum'},
        {'species': 'Celtis laevigata'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Ulmus americana'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=006|Eastern North American-Great Plains Flooded & Swamp Forest Division (D011)', plot.ident)
        result = (plot.match(ECOREGIONS) and not plot.match(ECOREGIONS_EXCL) and
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_007():

    """Great Plains Flooded & Swamp Forest (M028)"""
    """M028"""
    level = 'macrogroup'
    code = 'M028'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=007|Great Plains Flooded & Swamp Forest (M028)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_008():

    """Great Plains Cottonwood - Green Ash Floodplain Forest (G147)"""
    """G147"""
    level = 'group'
    code = 'G147'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315D, 332A, 332B, 315A, 315B, 315C, 315F,
    # 315G, M313B, 331 – exclude 331A and 331J, M332D, M334A, 332C, 332D,
    # 332F, 332E and tree composition dominated by one or
    # more of STRONG DIAGNOSTIC species Populus deltoides (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer negundo, Fraxinus pennsylvanica, Salix nigra,
    # or Salix amygdaloides (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315D, 332A, 332B, 315A, 315B, 315C, 315F, 315G, M313B, 331, M332D, M334A, 332C, 332D, 332F, 332E'}
    )

    ECOREGIONS_EXCL = PatternList('ECOREGIONS_EXCL',
        {'ecoregion': '331A, 331J'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Populus deltoides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Salix nigra'},
        {'species': 'Salix amygdaloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=008|Great Plains Cottonwood - Green Ash Floodplain Forest (G147)', plot.ident)
        result = ((plot.match(ECOREGIONS) and not plot.match(ECOREGIONS_EXCL)) and
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_009():

    """Eastern North American Ruderal Flooded & Swamp Forest (M302)"""
    """M302"""
    level = 'macrogroup'
    code = 'M302'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER] - needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=009|Eastern North American Ruderal Flooded & Swamp Forest (M302)', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_010():

    """Southeastern North American Flooded & Swamp Forest Division (D062)"""
    """D062"""
    level = 'division'
    code = 'D062'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION 315 AND
    # tree composition dominated by one or more of Carya illinoinensis,
    # Quercus virginiana, or Sabal palmetto (=>20% RIV);
    # OR
    # ii. Located in ECOREGION 315 (in OK or TX), AND
    # tree composition dominated by one or more of Celtis laevigata,
    # Celtis laevigata var. reticulata, Celtis occidentalis, Fraxinus pennsylvanica,
    # Juglans microcarpa, Juglans nigra, Juglans major, Platanus occidentalis,
    # Populus deltoides, Salix nigra, Sapindus saponaria var. drummondii,
    # Sideroxylon lanuginosum, Taxodium distichum, Quercus macrocarpa, Quercus shumardii,
    # or Ulmus americana (=>50% RIV);
    # OR Tree composition as above, but with =>20% RIV; AND other species are
    # any combination of Acer negundo, Prosopis glandulosa
    # Fraxinus albicans, Prunus serotina, and Quercus fusiformis
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
    # [Additional tree species not tracked by FIA include Ulmus crassifolia]
    # OR
    # iii. Located in above ECOREGION and any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': '315'}
    )

    ECOREGIONS_2 = PatternList('ECOREGIONS_2',
        {'ecoregion': '315', 'state': 'OK, TX'}
    )

    SPECIES_1 = PatternList('SPECIES_1',
        {'species': 'Carya illinoinensis'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'}
    )

    SPECIES_2 = PatternList('SPECIES_2',
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis laevigata var. reticulata'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Juglans nigra'},
        {'species': 'Juglans major'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Salix nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Sideroxylon lanuginosum'},
        {'species': 'Taxodium distichum'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus shumardii'},
        {'species': 'Ulmus americana'}
    )

    SPECIES_3 = PatternList('SPECIES_3',
        {'species': 'Acer negundo'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Fraxinus albicans'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus fusiformis'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=010|Southeastern North American Flooded & Swamp Forest Division (D062)', plot.ident)
        result = (( plot.match(ECOREGIONS_1) and plot.riv(SPECIES_1) >= 20 )
               or ( plot.match(ECOREGIONS_2) and ( plot.riv(SPECIES_2) >= 50 or (plot.riv(SPECIES_2) >= 20 and plot.riv(SPECIES_3) >= 30) ))
               or ( plot.match(ECOREGIONS_1) and plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_011():

    """Southern Great Plains Floodplain Forest & Woodland (M154)"""
    """M154"""
    level = 'macrogroup'
    code = 'M154'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=011|Southern Great Plains Floodplain Forest & Woodland (M154)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_012():

    """Southeastern Great Plains Floodplain Forest (G784)"""
    """G784"""
    level = 'group'
    code = 'G784'

    # i. Located in ECOREGION 321B, 315C, 315D, 315E, 315G and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Carya illinoinensis, Celtis laevigata,
    # Celtis laevigata var. reticulata, Platanus occidentalis,
    # Populus deltoides, Salix nigra, Sapindus saponaria var. drummondii,
    # Sideroxylon lanuginosum, Taxodium distichum, or Ulmus crassifolia,
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer negundo, Fraxinus albicans, Fraxinus pennsylvanica,
    # Juglans microcarpa, Prosopis glandulosa, Prunus serotina,
    # or Quercus fusiformis (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '321B, 315C, 315D, 315E, 315G'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Carya illinoinensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis laevigata var. reticulata'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus deltoides'},
        {'species': 'Salix nigra'},
        {'species': 'Sapindus saponaria var. drummondii'},
        {'species': 'Sideroxylon lanuginosum'},
        {'species': 'Taxodium distichum'},
        {'species': 'Ulmus crassifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Fraxinus albicans'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus fusiformis'}
    )

    def match(plot):
        logging.debug('%s|NODE=012|Southeastern Great Plains Floodplain Forest (G784)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_013():

    """Southeastern North American Ruderal Flooded & Swamp Forest (M310)"""
    """M310"""
    level = 'macrogroup'
    code = 'M310'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER] - needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=013|Southeastern North American Ruderal Flooded & Swamp Forest (M310)', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_014():

    """Western North American Temperate Flooded & Swamp Forests"""
    """F026"""
    level = 'formation'
    code = 'F026'

    # Forests found in ECOREGION 242, M242, 261, M261, 262, M262, 263, 313,
    # M313, 315, 321, 322, 331A, M331, M332, M333, M334, 341, M341, 342

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242, M242, 261, M261, 262, M262, 263, 313, M313, 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342'}
    )

    def match(plot):
        logging.debug('%s|NODE=014|Western North American Temperate Flooded & Swamp Forests', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_015():

    """Vancouverian Flooded & Swamp Forest Division (D193)"""
    """D193"""
    level = 'division'
    code = 'D193'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION 242, M242, 261A, M261, 263
    # AND
    # ii. EITHER
    # a. Tree composition dominated by one or more of STRONG diagnostic tree species
    # Abies grandis, Alnus rhombifolia, Alnus rubra, Fraxinus latifolia, Picea sitchensis,
    # Populus balsamifera ssp. trichocarpa, Salix lucida ssp. lasiandra,
    # Thuja plicata, or Tsuga heterophylla (=>50% RIV),
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species
    # any combination of Abies amabilis, Abies concolor, Abies magnifica,
    # Acer macrophyllum, Betula papyrifera, Callitropsis nootkatensis,
    # Pinus contorta, Populus tremuloides Tsuga mertensiana
    # Chamaecyparis lawsoniana, Notholithocarpus densiflorus, Picea engelmannii,
    # Pinus jeffreyi, Platanus racemosa, Populus fremontii, and Quercus lobata 
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
    # [Additional tree species not tracked by FIA include Pinus contorta var. murrayana]
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242, M242, 261A, M261, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Alnus rhombifolia'},
        {'species': 'Alnus rubra'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Picea sitchensis'},
        {'species': 'Populus balsamifera ssp. trichocarpa'},
        {'species': 'Salix lucida ssp. lasiandra'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies amabilis'},
        {'species': 'Abies concolor'},
        {'species': 'Abies magnifica'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Betula papyrifera'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Pinus contorta'},
        {'species': 'Populus tremuloides'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Platanus racemosa'},
        {'species': 'Populus fremontii'},
        {'species': 'Quercus lobata'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=015|Vancouverian Flooded & Swamp Forest Division (D193)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_016():

    """Vancouverian Flooded & Swamp Forest (M035)"""
    """M035"""
    level = 'macrogroup'
    code = 'M035'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=016|Vancouverian Flooded & Swamp Forest (M035)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_017():

    """North-Central Pacific Montane Riparian & Seepage Swamp Forest (G507)"""
    """G507"""
    level = 'group'
    code = 'G507'

    # i. Located in ECOREGION 261A, M261A, M261B, M261E, M261F, 242, M242,
    # M261D, M261G, 263
    # and tree composition dominated by one or
    # more of STRONG DIAGNOSTIC species Abies amabilis, Abies concolor,
    # Abies magnifica, Picea engelmannii, Pinus contorta,
    # Pinus jeffreyi, Populus balsamifera, or Tsuga mertensiana (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Alnus rhombifolia, Alnus rubra, or Populus tremuloides
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261A, M261A, M261B, M261E, M261F, 242, M242, M261D, M261G, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies amabilis'},
        {'species': 'Abies concolor'},
        {'species': 'Abies magnifica'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Populus balsamifera'},
        {'species': 'Tsuga mertensiana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Alnus rhombifolia'},
        {'species': 'Alnus rubra'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=017|North-Central Pacific Montane Riparian & Seepage Swamp Forest (G507)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_018():

    """North-Central Pacific Maritime Lowland Swamp Forest (G853)"""
    """G853"""
    level = 'group'
    code = 'G853'

    # i. Located in ECOREGION 242, M242
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Alnus rubra, Fraxinus latifolia, Picea sitchensis,
    # Populus balsamifera or Tsuga heterophylla (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies grandis, Abies magnifica, Pinus contorta, Thuja plicata, or
    # Tsuga mertensiana [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242, M242'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Alnus rubra'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Picea sitchensis'},
        {'species': 'Populus balsamifera'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Abies magnifica'},
        {'species': 'Pinus contorta'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga mertensiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=018|North-Central Pacific Maritime Lowland Swamp Forest (G853)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_019():

    """North-Central Pacific Lowland Riparian Forest (G851)"""
    """G851"""
    level = 'group'
    code = 'G851'

    # i. Located in ECOREGION M242C, M261A, M261B, M261D, M261E, M262A, 242,
    # M242A, M242B, M242D, 261A, 263 and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Abies grandis, Alnus rhombifolia, Alnus rubra, Fraxinus latifolia,
    # Picea sitchensis, or Populus trichocarpa (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer macrophyllum, Chamaecyparis lawsoniana,
    # Notholithocarpus densiflorus, Platanus racemosa, Populus fremontii,
    # Pseudotsuga menziesii, Quercus lobata, Thuja plicata, or
    # Tsuga heterophylla [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M261A, M261B, M261D, M261E, M262A, 242, M242A, M242B, M242D, 261A, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Alnus rhombifolia'},
        {'species': 'Alnus rubra'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Picea sitchensis'},
        {'species': 'Populus trichocarpa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer macrophyllum'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Platanus racemosa'},
        {'species': 'Populus fremontii'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus lobata'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    def match(plot):
        logging.debug('%s|NODE=019|North-Central Pacific Lowland Riparian Forest (G851)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_020():

    """Western North American Flooded Ruderal Forests - Vancouverian"""
    """D193"""
    level = 'division'
    code = 'D193'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER])

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=020|Western North American Flooded Ruderal Forests - Vancouverian', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_021():

    """Rocky Mountain-Great Basin Montane Flooded & Swamp Forest Division (D195)"""
    """D195"""
    level = 'division'
    code = 'D195'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION M242C, M242D, 313, M313, 315, 322, 331A, M331, M332, M333, M334, 341, M341, 342
    # AND
    # ii. EITHER
    # a. Tree composition dominated by one or more of STRONG diagnostic tree species
    # Abies lasiocarpa, Abies grandis, Acer grandidentatum, Acer negundo, Betula occidentalis,
    # Juniperus scopulorum, Picea engelmannii, Picea pungens, Pinus contorta,
    # Pinus ponderosa, Populus angustifolia, Populus balsamifera, Populus tremuloides,
    # or Pseudotsuga menziesii (=>50% RIV),
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species
    # any combination of Alnus oblongifolia, Betula papyrifera, Juglans major,
    # Larix occidentalis, Pinus flexilis, Thuja plicata,
    # Tsuga heterophylla, Tsuga mertensiana
    # Abies concolor, Fraxinus latifolia, Juniperus osteosperma, Picea glauca, 
    # and Populus deltoides
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242D, 313, M313, 315, 322, 331A, M331, M332, M333, M334, 341, M341, 342'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies grandis'},
        {'species': 'Acer grandidentatum'},
        {'species': 'Acer negundo'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Picea engelmannii'},
        {'species': 'Picea pungens'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Populus angustifolia'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Betula occidentalis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Alnus oblongifolia'},
        {'species': 'Betula papyrifera'},
        {'species': 'Juglans major'},
        {'species': 'Larix occidentalis'},
        {'species': 'Pinus flexilis'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Abies concolor'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Picea glauca'},
        {'species': 'Populus deltoides'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=021|Rocky Mountain-Great Basin Montane Flooded & Swamp Forest Division (D195)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_022():

    """Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)"""
    """M034"""
    level = 'macrogroup'
    code = 'M034'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=022|Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (M034)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_023():

    """Rocky Mountain-Great Basin Swamp Forest (G505)"""
    """G505"""
    level = 'group'
    code = 'G505'

    # i. Elevation less than 1500 meters and
    # located in ECOREGION 331A, 342A, 342D, 342F, 342G, 342H, M332,
    # M331A, M331B, M331D, M331J, M333C, M333A, M333B, M333D and
    # tree composition dominated by one or more of STRONG DIAGNOSTIC species
    # Abies grandis, Abies lasiocarpa, Picea engelmannii, Picea glauca,
    # Pinus contorta, Pseudotsuga menziesii, Thuja plicata, or
    # Tsuga heterophylla (RIV=>50%),
    # OR
    # ii. Elevation less than 1500 meters and
    # located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Betula papyrifera, Fraxinus latifolia,
    # Larix occidentalis, Populus balsamifera, or
    # Populus tremuloides (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '331A, 342A, 342D, 342F, 342G, 342H, M332, M331A, M331B, M331D, M331J, M333C, M333A, M333B, M333D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Picea engelmannii'},
        {'species': 'Picea glauca'},
        {'species': 'Pinus contorta'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Larix occidentalis'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=023|Rocky Mountain-Great Basin Swamp Forest (G505)', plot.ident)
        result = (plot.get_elevation() < 1500 and plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_024():

    """Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (G506)"""
    """G506"""
    level = 'group'
    code = 'G506'

    # i. Located in ECOREGION M242D, M261A, 313C, 313D, 315A, 315H, 322A,
    # 322B, M242C, M261D, M261E, M261G, 313A, 313B, M313, 331A, 331I, 331J,
    # 341, 342, M331, M332, M333, M334, M341
    # and tree composition dominated by one or
    # more of STRONG DIAGNOSTIC species Abies lasiocarpa, Abies grandis,
    # Juniperus scopulorum, Picea engelmannii, Picea pungens, Pinus ponderosa,
    # Pinus contorta, or Populus angustifolia (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies concolor, Juniperus osteosperma,
    # Populus tremuloides, or Pseudotsuga menziesii (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242D, M261A, 313C, 313D, 315A, 315H, 322A, 322B, M242C, M261D, M261E, M261G, 313A, 313B, M313, 331A, 331I, 331J, 341, 342, M331, M332, M333, M334, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies grandis'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Picea engelmannii'},
        {'species': 'Picea pungens'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pinus contorta'},
        {'species': 'Populus angustifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=024|Rocky Mountain-Great Basin Montane Riparian & Swamp Forest (G506)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_025():

    """Central Rocky Mountain Lowland & Foothill Riparian Forest (G796)"""
    """G796"""
    level = 'group'
    code = 'G796'

    # i. Located in ECOREGION M242C, M242D, M261E, M261G, 322A, 331G, 331L,
    # 341A, 341D, 341E, 341F, 341G, 342A, M331B, M331J, M341A, M341C, M341D,
    # 331A, 331D, 331K, 331N, 342B, 342C, 342D, 342H, 342I, 342J, M331A,
    # M331D, M332, M333  and tree composition dominated by one or more
    # of STRONG DIAGNOSTIC species Populus balsamifera (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Pinus ponderosa, Populus angustifolia, or
    # Populus deltoides (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242D, M261E, M261G, 322A, 331G, 331L, 341A, 341D, 341E, 341F, 341G, 342A, M331B, M331J, M341A, M341C, M341D, 331A, 331D, 331K, 331N, 342B, 342C, 342D, 342H, 342I, 342J, M331A, M331D, M332, M333'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Populus balsamifera'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus ponderosa'},
        {'species': 'Populus angustifolia'},
        {'species': 'Populus deltoides'}
    )

    def match(plot):
        logging.debug('%s|NODE=025|Central Rocky Mountain Lowland & Foothill Riparian Forest (G796)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_026():

    """Western North American Flooded Ruderal Forests - Rocky Mountain"""
    """D195"""
    level = 'division'
    code = 'D195'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER])

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=026|Western North American Flooded Ruderal Forests - Rocky Mountain', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_027():

    """Western North American Interior Flooded Forest Division (D013)"""
    """D013"""
    level = 'division'
    code = 'D013'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION 261, M261, 262, M262, 313, M313, 315, 321, 322, M331, 341, M341, 342
    # AND
    # ii. EITHER
    # a. Tree composition dominated by one or more of STRONG diagnostic tree species
    # Alnus oblongifolia, Alnus rhombifolia, Cordia boissieri, Diospyros texana, Ebenopsis ebano,
    # Ehretia anacua, Fraxinus berlandieriana, Leucaena pulverulenta, Parkinsonia aculeata, 
    # Phaulothamnus spinescens, Sabal mexicana, Sideroxylon celastrinum, Ulmus crassifolia, 
    # Washingtonia filifera,
    # Juglans californica, Juglans major, Juglans microcarpa, Platanus racemosa, Platanus wrightii, Populus fremontii,
    # Populus deltoides, Prosopis glandulosa, Elaeagnus angustifolia, and Tamarix spp. (=>50% RIV),
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE diagnostic species any combination of
    # Acacia farnesiana, Acer negundo, Celtis ehrenbergiana, Celtis laevigata, Fraxinus anomala, Fraxinus velutina,
    # Salix amygdaloides, Salix nigra, Salix gooddingii, Salix laevigata, Sapindus saponaria, Ailanthus altissima,
    # Eucalyptus spp., Ulmus pumila, Acer macrophyllum, Acer grandidentatum, Alnus rubra, Fraxinus latifolia,
    # Hesperocyparis arizonica, Populus angustifolia, Prosopis pubescens, Prosopis velutina, Quercus arizonica, 
    # Quercus emoryi, Quercus oblongifolia, Quercus agrifolia, Quercus gambelii, Quercus lobata, Quercus douglasii,
    # Quercus kelloggii, Robinia neomexicana, Salix lasiolepis, Salix lutea, Taxodium mucronatum, 
    # and Umbellularia californica
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261, M261, 262, M262, 313, M313, 315, 321, 322, M331, 341, M341, 342'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Alnus oblongifolia'},
        {'species': 'Alnus rhombifolia'},
        {'species': 'Cordia boissieri'},
        {'species': 'Diospyros texana'},
        {'species': 'Ebenopsis ebano'},
        {'species': 'Ehretia anacua'},
        {'species': 'Fraxinus berlandieriana'},
        {'species': 'Leucaena pulverulenta'},
        {'species': 'Parkinsonia aculeata'},
        {'species': 'Phaulothamnus spinescens'},
        {'species': 'Sabal mexicana'},
        {'species': 'Sideroxylon celastrinum'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Washingtonia filifera'},
        {'species': 'Juglans californica'},
        {'species': 'Juglans major'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Platanus racemosa'},
        {'species': 'Platanus wrightii'},
        {'species': 'Populus fremontii'},
        {'species': 'Populus deltoides ssp. wislizeni'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Elaeagnus angustifolia'},
        {'species': 'Tamarix'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acacia farnesiana'},
        {'species': 'Acer negundo'},
        {'species': 'Celtis ehrenbergiana'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus anomala'},
        {'species': 'Fraxinus velutina'},
        {'species': 'Salix amygdaloides'},
        {'species': 'Salix nigra'},
        {'species': 'Salix gooddingii'},
        {'species': 'Salix laevigata'},
        {'species': 'Sapindus saponaria'},
        {'species': 'Ailanthus altissima'},
        {'species': 'Eucalyptus'},
        {'species': 'Ulmus pumila'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Acer grandidentatum'},
        {'species': 'Alnus rubra'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Hesperocyparis arizonica'},
        {'species': 'Populus angustifolia'},
        {'species': 'Prosopis pubescens'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus oblongifolia'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus gambelii'},
        {'species': 'Quercus lobata'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Robinia neomexicana'},
        {'species': 'Salix lasiolepis'},
        {'species': 'Salix lutea'},
        {'species': 'Taxodium mucronatum'},
        {'species': 'Umbellularia californica'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=027|Western North American Interior Flooded Forest Division (D013)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_028():

    """Interior Warm & Cool Desert Riparian Forest (M036)"""
    """M036"""
    level = 'macrogroup'
    code = 'M036'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=028|Interior Warm & Cool Desert Riparian Forest (M036)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_029():

    """Tamaulipan Riparian Scrub Forest (G549)"""
    """G549"""
    level = 'group'
    code = 'G549'

    # i. Located in ECOREGION 321B, 315D, 315E
    # and tree composition dominated by one or more
    # of STRONG DIAGNOSTIC species Celtis laevigata,
    # Cordia boissieri, Diospyros texana,
    # Ebenopsis ebano, Ehretia anacua, Fraxinus berlandieriana,
    # Leucaena pulverulenta, Parkinsonia aculeata, Phaulothamnus spinescens,
    # Sabal mexicana, Sideroxylon celastrinum, or Ulmus crassifolia (RIV=>50%)
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acacia farnesiana, Celtis ehrenbergiana,
    # Prosopis glandulosa, Salix nigra, or Taxodium mucronatum (>=30% RIV;
    # i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '321B, 315D, 315E'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Celtis laevigata'},
        {'species': 'Cordia boissieri'},
        {'species': 'Diospyros texana'},
        {'species': 'Ebenopsis ebano'},
        {'species': 'Ehretia anacua'},
        {'species': 'Fraxinus berlandieriana'},
        {'species': 'Leucaena pulverulenta'},
        {'species': 'Parkinsonia aculeata'},
        {'species': 'Phaulothamnus spinescens'},
        {'species': 'Sabal mexicana'},
        {'species': 'Sideroxylon celastrinum'},
        {'species': 'Ulmus crassifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acacia farnesiana'},
        {'species': 'Celtis ehrenbergiana'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Salix nigra'},
        {'species': 'Taxodium mucronatum'}
    )

    def match(plot):
        logging.debug('%s|NODE=029|Tamaulipan Riparian Scrub Forest (G549)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_030():

    """Californian Mediterranean Riparian Forest (G113)"""
    """G113"""
    level = 'group'
    code = 'G113'

    # i. Located in ECOREGION 261, 262, 263, 322A, 322C, M242A, M261A, M261B,
    # M261C, M262 and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Alnus rhombifolia, Juglans californica,
    # Platanus racemosa, Quercus agrifolia, Quercus lobata, Salix gooddingii,
    # Salix laevigata, or Umbellularia californica (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but with
    # =>20% RIV AND with other MODERATE DIAGNOSTIC species in any combination
    # of Acer macrophyllum, Acer negundo, Alnus rubra, Fraxinus latifolia,
    # Populus fremontii, Quercus douglasii, Quercus kelloggii,
    # Salix lasiolepis, or Salix lutea (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261, 262, 263, 322A, 322C, M242A, M261A, M261B, M261C, M262'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Alnus rhombifolia'},
        {'species': 'Juglans californica'},
        {'species': 'Platanus racemosa'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus lobata'},
        {'species': 'Salix gooddingii'},
        {'species': 'Salix laevigata'},
        {'species': 'Umbellularia californica'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer macrophyllum'},
        {'species': 'Acer negundo'},
        {'species': 'Alnus rubra'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Populus fremontii'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Salix lasiolepis'},
        {'species': 'Salix lutea'}
    )

    def match(plot):
        logging.debug('%s|NODE=030|Californian Mediterranean Riparian Forest (G113)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_031():

    """Southwest Warm Desert Riparian Forest (G109)"""
    """G109"""
    level = 'group'
    code = 'G109'

    # i. Located in ECOREGION M313, 313C, 315A, 315B, 315H, 321, 322 and
    # tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Alnus oblongifolia, Fraxinus velutina, Juglans major,
    # Juglans microcarpa, Platanus wrightii, Populus fremontii,
    # Salix gooddingii, Salix lasiolepis, or Washingtonia filifera
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer grandidentatum, Acer negundo, Celtis laevigata,
    # Hesperocyparis arizonica, Populus angustifolia, Populus deltoides,
    # Prosopis glandulosa, Prosopis velutina, Quercus arizonica,
    # Quercus emoryi, Quercus oblongifolia, or Robinia neomexicana
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M313, 313C, 315A, 315B, 315H, 321, 322'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Alnus oblongifolia'},
        {'species': 'Fraxinus velutina'},
        {'species': 'Juglans major'},
        {'species': 'Juglans microcarpa'},
        {'species': 'Platanus wrightii'},
        {'species': 'Populus fremontii'},
        {'species': 'Salix gooddingii'},
        {'species': 'Salix lasiolepis'},
        {'species': 'Washingtonia filifera'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer grandidentatum'},
        {'species': 'Acer negundo'},
        {'species': 'Celtis laevigata'},
        {'species': 'Hesperocyparis arizonica'},
        {'species': 'Populus angustifolia'},
        {'species': 'Populus deltoides'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus oblongifolia'},
        {'species': 'Robinia neomexicana'}
    )

    def match(plot):
        logging.debug('%s|NODE=031|Southwest Warm Desert Riparian Forest (G109)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_032():

    """Great Basin-Colorado Plateau Semi-Desert Riparian Forest (G107)"""
    """G107"""
    level = 'group'
    code = 'G107'

    # i. Located in ECOREGION 313A, 313B, 313D, 322A, 341, 342B, 342C, 342E,
    # 342J, M261G, M331D, M331E, M331G, M331H, M341 and tree composition
    # dominated by one or more of STRONG DIAGNOSTIC species Acer negundo,
    # Celtis laevigata, Fraxinus anomala, Fraxinus velutina,
    # Populus deltoides, Populus fremontii, or Salix amygdaloides (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Fraxinus berlandieriana, Juniperus osteosperma,
    # Pinus edulis, Populus angustifolia, Prosopis pubescens,
    # Pseudotsuga menziesii, Quercus gambelii, Salix gooddingii or
    # Salix lasiolepis (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '313A, 313B, 313D, 322A, 341, 342B, 342C, 342E, 342J, M261G, M331D, M331E, M331G, M331H, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus anomala'},
        {'species': 'Fraxinus velutina'},
        {'species': 'Populus deltoides'},
        {'species': 'Populus fremontii'},
        {'species': 'Salix amygdaloides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Fraxinus berlandieriana'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Pinus edulis'},
        {'species': 'Populus angustifolia'},
        {'species': 'Prosopis pubescens'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus gambelii'},
        {'species': 'Salix gooddingii'},
        {'species': 'Salix lasiolepis'}
    )

    def match(plot):
        logging.debug('%s|NODE=032|Great Basin-Colorado Plateau Semi-Desert Riparian Forest (G107)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_033():

    """Interior West Ruderal Flooded & Swamp Forest & Woodland (M298)"""
    """M298"""
    level = 'macrogroup'
    code = 'M298'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously). Tree
    # composition dominated by ruderal native or EXOTIC = yes
    # (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division

    RUDERAL_OR_EXOTIC = PatternList('RUDERAL_OR_EXOTIC',
        {'exotic': 'yes'},
        {'ruderal': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=033|Interior West Ruderal Flooded & Swamp Forest & Woodland (M298)', plot.ident)
        result = (plot.riv(RUDERAL_OR_EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_034():

    """Upland Forest & Woodlands"""
    """"""
    level = 'class'
    code = ''

    # Not as above

    def match(plot):
        logging.debug('%s|NODE=034|Upland Forest & Woodlands', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_035():

    """Temperate & Boreal Forest & Woodland Subclass"""
    """S15"""
    level = 'subclass'
    code = 'S15'

    # other

    def match(plot):
        logging.debug('%s|NODE=035|Temperate & Boreal Forest & Woodland Subclass', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_036():

    """Great Plains Temperate Forests"""
    """"""
    level = 'subclass'
    code = ''

    # Tree composition and ecology matching one of the following options
    # i. Located in ECOREGION 222, 251, 315 – exclude 315H, 332, 331 – exclude 331A and 331J, AND
    # EITHER
    # ii. Tree composition is dominated by one or more of Betula papyrifera
    # or Populus tremuloides =>20% RIV and Abies concolor,
    # Pseudotsuga menziesii, and Pinus ponderosa =<5% RIV
    # OR
    # iii. Aesculus pavia, Acer negundo, Acer saccharum, Aesculus glabra,
    # Amelanchier spp., Carya cordiformis, Carya texana, Celtis laevigata,
    # Celtis occidentalis, Cercis canadensis, Crataegus spp.,
    # Diospyros virginiana, Fraxinus americana, Fraxinus pennsylvanica,
    # Gleditsia triacanthos, Gymnocladus dioicus, Juglans nigra,
    # Juniperus ashei, Juniperus virginiana, Morus rubra, Ostrya virginiana
    # Persea borbonia, Platanus occidentalis, Populus balsamifera,
    # Populus deltoides, Prosopis glandulosa, Prosopis velutina,
    # Prunus pensylvanica, Prunus serotina, Prunus virginiana,
    # Quercus falcata, Quercus virginiana, Quercus macrocarpa, Quercus marilandica, Quercus muehlenbergii,
    # Quercus rubra, Quercus shumardii, Quercus sinuata var. sinuata,
    # Quercus stellata, Quercus velutina, Quercus virginiana, Sabal palmetto,
    # Tilia americana, Ulmus alata, Ulmus americana, Ulmus crassifolia,
    # or Ulmus rubra (>= 20% RIV)

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': '222, 251, 315, 331, 332'}
    )

    ECOREGIONS_EXCL = PatternList('ECOREGIONS_EXCL',
        {'ecoregion': '315H, 331A, 331J'}
    )

    DIAGNOSTIC_SPECIES_1 = PatternList('DIAGNOSTIC_SPECIES_1',
        {'species': 'Betula papyrifera'},
        {'species': 'Populus tremuloides'}
    )

    DIAGNOSTIC_SPECIES_2 = PatternList('DIAGNOSTIC_SPECIES_2',
        {'species': 'Abies concolor'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'}
    )

    DIAGNOSTIC_SPECIES_3 = PatternList('DIAGNOSTIC_SPECIES_3',
        {'species': 'Aesculus pavia'},
        {'species': 'Acer negundo'},
        {'species': 'Acer saccharum'},
        {'species': 'Aesculus glabra'},
        {'species': 'Amelanchier'},
        {'species': 'Carya cordiformis'},
        {'species': 'Carya texana'},
        {'species': 'Celtis laevigata'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Cercis canadensis'},
        {'species': 'Crataegus'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Fraxinus americana'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Gymnocladus dioicus'},
        {'species': 'Juglans nigra'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Morus rubra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus deltoides'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Prunus pensylvanica'},
        {'species': 'Prunus serotina'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus shumardii'},
        {'species': 'Quercus sinuata var. sinuata'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus velutina'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus alata'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Ulmus rubra'},
        {'species': 'Quercus virginiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=036|Great Plains Temperate Forests', plot.ident)
        result = ((plot.match(ECOREGIONS_1) and not plot.match(ECOREGIONS_EXCL)) and
               ( (plot.riv(DIAGNOSTIC_SPECIES_1) >= 20 and plot.riv(DIAGNOSTIC_SPECIES_2) <= 5) or
               plot.riv(DIAGNOSTIC_SPECIES_3) >= 20 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_037():

    """North American Great Plains Forest & Woodland Division (D326)"""
    """D326"""
    level = 'division'
    code = 'D326'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION 222, 231, 251, 255, 315, 321, 331, 332 – exclude 331A and 331J, 332
    # AND
    # ii. EITHER
    # a. Tree composition dominated by one or more of STRONG diagnostic
    # broadleaf trees Diospyros texana, Fraxinus pennsylvanica, Gleditsia triacanthos, Juglans nigra, Juniperus virginiana,
    # Populus deltoides, Populus tremuloides, Prosopis glandulosa, Prosopis velutina, Quercus macrocarpa,
    # Quercus marilandica, Quercus stellata, Quercus virginiana, Ulmus americana,
    # Ulmus crassifolia or Ulmus rubra (=>50% RIV),
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE
    # diagnostic species, any combination of Acer negundo,
    # Betula papyrifera, Celtis occidentalis, Crataegus spp.,
    # Juglans nigra, Juniperus ashei, Juniperus pinchotii, Juniperus scopulorum, Morus rubra, Pinus ponderosa,
    # Populus grandidentata, Populus balsamifera, Ostrya virginiana
    # Prunus virginiana, or Quercus muehlenbergii
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': '222, 231, 251, 255, 315, 321, 331, 332'}
    )

    ECOREGIONS_EXCL = PatternList('ECOREGIONS_EXCL',
        {'ecoregion': '331A, 331J'}
    )

    ECOREGIONS_2 = PatternList('ECOREGIONS_2',
        {'ecoregion': 'M334A'}
    )

    STRONG_DIAGNOSTIC_SPECIES_1 = PatternList('STRONG_DIAGNOSTIC_SPECIES_1',
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus stellata'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Ulmus rubra'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Juglans nigra'},
        {'species': 'Quercus virginiana'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Diospyros texana'},
        {'species': 'Populus deltoides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Betula papyrifera'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Crataegus'},
        {'species': 'Juglans nigra'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Morus rubra'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus balsamifera'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus muehlenbergii'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=037|North American Great Plains Forest & Woodland Division (D326)', plot.ident)
        result = (plot.match(ECOREGIONS_1) and not plot.match(ECOREGIONS_EXCL) and
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_038():

    """Southern Great Plains Forest & Woodland (M544)"""
    """M544"""
    level = 'macrogroup'
    code = 'M544'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B, AND tree composition dominated by one or more of STRONG MESIC DIAGNOSTIC species Juglans major, Acer grandidentatum, Diospyros texana, Juglans major, Juniperus ashei, Juniperus pinchotii Prosopis glandulosa, Prosopis velutina, Quercus buckleyi, Quercus laceyi, Quercus marilandica, Quercus muehlenbergii, Quercus stellata,   Quercus virginiana or Ulmus alata, or Ulmus crassifolia (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species in any combination of ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species in any combination of Arbutus xalapensis, Celtis laevigata, Juniperius virginai, Fraxinus texensis, Pinus remota, Prunus serotina, , Quercus macrocarpa, Quercus pungens, Quercus sinuata  (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '251E, 251F, 255A, 255E, 315, 321B, 332F, 231E, 255B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juglans major'},
        {'species': 'Juniperus ashei'},
        {'species': 'Quercus buckleyi'},
        {'species': 'Quercus laceyi'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus stellata'},
        {'species': 'Ulmus alata'},
        {'species': 'Quercus virginiana'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Diospyros texana'},
        {'species': 'Acer grandidentatum'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus xalapensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Prunus serotina'},
        {'species': 'Pinus remota'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus pungens'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Fraxinus texensis'},
        {'species': 'Quercus sinuata'}
    )

    def match(plot):
        logging.debug('%s|NODE=038|Southern Great Plains Forest & Woodland (M544)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_039():

    """Cross Timbers Forest & Woodland (G887)"""
    """G887"""
    level = 'group'
    code = 'G887'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 231E, 231G, 251E, 251F, 255A, 255E, 315C, 315G, 332F
    # and tree composition dominated by one or
    # more of STRONG DIAGNOSTIC species Carya cordiformis, Carya texana, Quercus marilandica, Quercus stellata, Quercus virginiana, Quercus velutina, Sapindus saponaria, Sideroxylon lanuginosum ssp. lanuginosum, Ulmus crassifolia, Juniperus ashei, Juniperus virginiana    (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>20% RIV AND with other MODERATE DIAGNOSTIC species
    # in any combination of Ulmus alata (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '231E,  231G, 251E, 251F, 255A, 255E, 315C, 315G, 332F'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus stellata'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Juniperus ashei'},
        {'species': 'Carya texana'},
        {'species': 'Carya cordiformis'},
        {'species': 'Quercus velutina'},
        {'species': 'Sapindus saponaria'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sideroxylon lanuginosum ssp. lanuginosum'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Ulmus alata'}
    )

    def match(plot):
        logging.debug('%s|NODE=039|Cross Timbers Forest & Woodland (G887)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_040():

    """Edwards Plateau Dry-Mesic Hardwood Forest (G028)"""
    """G028"""
    level = 'group'
    code = 'G028'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 255B, 255E, 315C, 315D, 315E, 315G, 321B and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Acer grandidentatum, Juglans major, Juniperus ashei, Quercus buckleyi, Quercus laceyi,
    # Quercus muehlenbergii, Tilia americana, Ulmus rubra, or Ulmus crassifolia (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Arbutus xalapensis, Celtis laevigata,
    # Fraxinus texensis, Prunus serotina,
    # Quercus macrocarpa, Quercus stellata, or
    # Quercus sinuata (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '255B, 255E, 315C, 315D, 315E, 315G, 321B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Acer grandidentatum'},
        {'species': 'Quercus buckleyi'},
        {'species': 'Quercus laceyi'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Juglans major'},
        {'species': 'Juniperus ashei'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus rubra'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus xalapensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus sinuata'},
        {'species': 'Fraxinus texensis'}
    )

    def match(plot):
        logging.debug('%s|NODE=040|Edwards Plateau Dry-Mesic Hardwood Forest (G028)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_041():

    """Edwards Plateau Dry Woodland (G126)"""
    """G126"""
    level = 'group'
    code = 'G126'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 255B, 255E, 315C, 315D, 315E, 315G, 321B and tree
    # composition dominated by one or more of STRONG
    # DIAGNOSTIC species Diospyros texana, Juniperus ashei, Juniperus pinchotii, Prosopis glandulosa, or Quercus virginiana [=Quercus fusiformis, Q. v. fusiformis] (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Fraxinus texensis, Pinus remota, Quercus buckleyi, Quercus marilandica,
    # Quercus sinuata, Quercus stellata, Quercus pungens, or
    # Ulmus crassifolia (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '255B, 255E, 315C, 315D, 315E, 315G, 321B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Prosopis glandulosa'},
        {'species': 'Quercus virginiana'},
        {'species': 'Diospyros texana'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus pinchotii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus remota'},
        {'species': 'Quercus buckleyi'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus sinuata'},
        {'species': 'Quercus stellata'},
        {'species': 'Ulmus crassifolia'},
        {'species': 'Fraxinus texensis'},
        {'species': 'Quercus pungens'}
    )

    def match(plot):
        logging.debug('%s|NODE=041|Edwards Plateau Dry Woodland (G126)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_042():

    """Northern Great Plains Forest & Woodland (M545)"""
    """M545"""
    level = 'macrogroup'
    code = 'M545'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER])

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=042|Northern Great Plains Forest & Woodland (M545)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_043():

    """Great Plains Bur Oak Forest & Woodland(G329)"""
    """G329"""
    level = 'group'
    code = 'G329'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 222, 251, 331K?, 332B?, 331B?, 331F, 331C, 331M, 331E,
    # 332A, 332C, 332E, 332F, 332D and tree composition dominated by
    # one or more of STRONG DIAGNOSTIC species Quercus macrocarpa (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Fraxinus pennsylvanica, Juniperus virginiana, Morus rubra,
    # Ostrya virginiana, Prunus virginiana, or Populus tremuloides (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '222, 251, 331K, 332B, 331B, 331F, 331C, 331M, 331E, 332A, 332C, 332E, 332F, 332D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus macrocarpa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Populus tremuloides'},
        {'species': 'Prunus virginiana'},
        {'species': 'Morus rubra'}
    )

    def match(plot):
        logging.debug('%s|NODE=043|Great Plains Bur Oak Forest & Woodland(G329)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_044():

    """Northeastern Great Plains Aspen Woodland (G146)"""
    """G146"""
    level = 'group'
    code = 'G146'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 251A, 251B, 222Na, 222Ma
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Populus tremuloides (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Betula papyrifera, Populus grandidentata,
    # Populus balsamifera, Prunus virginiana, Quercus macrocarpa, or Ulmus americana (>=30% RIV;
    # i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '251A, 251B, 222Na, 222Ma'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Populus tremuloides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus balsamifera'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Ulmus americana'},
        {'species': 'Prunus virginiana'}
    )

    def match(plot):
        logging.debug('%s|NODE=044|Northeastern Great Plains Aspen Woodland (G146)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_045():

    """Northwestern Great Plains Aspen Woodland (G328)"""
    """G328"""
    level = 'group'
    code = 'G328'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 331E, 331M, 332A, 332B
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Populus tremuloides (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Betula papyrifera, Populus grandidentata,
    # Populus balsamifera, Prunus virginiana, Quercus macrocarpa, or Ulmus americana (>=30% RIV;
    # i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '331E, 331M, 332A, 332B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Populus tremuloides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Picea glauca'},
        {'species': 'Populus grandidentata'},
        {'species': 'Populus balsamifera'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=045|Northwestern Great Plains Aspen Woodland (G328)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_046():

    """Great Plains Mesic Forest & Woodland (G145)"""
    """G145"""
    level = 'group'
    code = 'G145'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION ECOREGION 222, 251, 315F, 315B, 332, 331 – 
    # exclude 331A and 331J and tree composition dominated by one or more
    # of STRONG DIAGNOSTIC species Betula papyrifera, Fraxinus pennsylvanica,
    # Juniperus scopulorum, Populus tremuloides, Ulmus americana, Juniperus virginiana, or
    # Ulmus rubra, Morus rubra (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer negundo, Celtis occidentalis, Populus deltoides, or Quercus macrocarpa (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '222, 251, 315F, 315B, 332, 331'}
    )

    ECOREGIONS_EXCL = PatternList('ECOREGIONS_EXCL',
        {'ecoregion': '331A, 331J'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Populus tremuloides'},
        {'species': 'Ulmus americana'},
        {'species': 'Ulmus rubra'},
        {'species': 'Morus rubra'},
        {'species': 'Juniperus virginiana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Populus deltoides'}
    )

    def match(plot):
        logging.debug('%s|NODE=046|Great Plains Mesic Forest & Woodland (G145)', plot.ident)
        result = ((plot.match(ECOREGIONS) and not plot.match(ECOREGIONS_EXCL)) and
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_047():

    """Great Plains Ruderal Woodland (M524)"""
    """M524"""
    level = 'macrogroup'
    code = 'M524'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by ruderal native or EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER])

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=047|Great Plains Ruderal Woodland (M524)', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_048():

    """Southeastern North American Forest & Woodland Division (D006)"""
    """D006"""
    level = 'division'
    code = 'D006'

    # Tree composition and ecology matching one of the following options:
    #   i. Located in ECOREGION 315E [Texas and Oklahoma]
    # AND
    #   ii. EITHER
    # a. Tree composition contains one or more of Aesculus pavia,
    # Quercus margarettiae, Quercus sinuata var. sinuata,
    # Quercus virginiana, or Sabal palmetto (>=20% RIV),
    # [Additional tree species not tracked by FIA include
    # Quercus fusiformis = Quercus virginiana var. fusiformis,
    # Quercus geminata, Serenoa repens]
    # OR
    # b. The above tree species, but with =>10% RIV AND other MODERATE
    # diagnostic species, any combination of Celtis laevigata,
    # Fraxinus americana, Juniperus virginiana, Ostrya virginiana,
    # Persea borbonia, Prunus serotina, Quercus marilandica, Quercus stellata,
    # or Ulmus alata (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315E'}
    )

    STATES = PatternList('STATES',
        {'state': 'TX, OK'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Aesculus pavia'},
        {'species': 'Quercus margarettiae'},
        {'species': 'Quercus sinuata var. sinuata'},
        {'species': 'Quercus virginiana'},
        {'species': 'Sabal palmetto'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus americana'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Persea borbonia'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus stellata'},
        {'species': 'Ulmus alata'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=048|Southeastern North American Forest & Woodland Division (D006)', plot.ident)
        result = (plot.match(ECOREGIONS) and plot.match(STATES) and
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_049():

    """Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)"""
    """M885"""
    level = 'macrogroup'
    code = 'M885'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER])

    RUDERAL_EXOTIC = PatternList('RUDERAL_EXOTIC',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=049|Southeastern Coastal Plain Evergreen Oak - Mixed Hardwood Forest (M885)', plot.ident)
        result = (plot.riv(RUDERAL_EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_050():

    """Coastal Live Oak - Hickory - Palmetto Forest (G798)"""
    """G798"""
    level = 'group'
    code = 'G798'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315E and tree composition dominated
    # by one or more of STRONG DIAGNOSTIC species
    # Quercus virginiana (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Sabal palmetto,
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315E'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus hemisphaerica'},
        {'species': 'Quercus virginiana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Sabal palmetto'}
    )

    def match(plot):
        logging.debug('%s|NODE=050|Coastal Live Oak - Hickory - Palmetto Forest (G798)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_051():

    """Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)"""
    """G799"""
    level = 'group'
    code = 'G799'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315E
    # and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Quercus fusiformis (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Prosopis glandulosa, Quercus marilandica,
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315E'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus fusiformis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Prosopis glandulosa'},
        {'species': 'Quercus marilandica'},
        {'species': 'Zanthoxylum hirsutum'}
    )

    def match(plot):
        logging.debug('%s|NODE=051|Texas Live Oak - Wax Mallow Motte & Coastal Forest (G799)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_052():

    """Southeastern North American Ruderal Forest (M305)"""
    """M305"""
    level = 'macrogroup'
    code = 'M305'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or weedy
    # native vegetation that invades natural stands or vegetation that
    # dominates on formerly cleared and/or planted sites but which has been
    # allowed to succeed more-or-less spontaneously). Tree composition
    # dominated by ruderal native or EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER])

    RUDERAL_EXOTIC = PatternList('RUDERAL_EXOTIC',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=052|Southeastern North American Ruderal Forest (M305)', plot.ident)
        result = (plot.riv(RUDERAL_EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_053():

    """Eastern North American Forest & Woodland Division (D008)"""
    """D008"""
    level = 'division'
    code = 'D008'

    # Tree composition and ecology matching one of the following options:
    # i. Located in ECOREGION 315, 332
    # AND
    # ii. EITHER
    # a. Tree composition dominated by one or more of STRONG diagnostic
    # species Acer saccharum, Aesculus glabra, Carya texana,
    # Celtis occidentalis, Fraxinus pennsylvanica, Gymnocladus dioicus,
    # Platanus occidentalis, Populus tremuloides, Quercus falcata,
    # Quercus macrocarpa, Quercus muehlenbergii,
    # Quercus rubra, Quercus velutina, Tilia americana,
    # Ulmus rubra, or Ulmus americana (=>50% RIV)
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE
    # diagnostic species Acer negundo, Amelanchier spp., Betula papyrifera,
    # Carya cordiformis, Cercis canadensis, Diospyros virginiana,
    # Gleditsia triacanthos, Juglans nigra, Juniperus ashei,
    # Juniperus virginiana, Morus rubra, Ostrya virginiana,
    # Populus balsamifera, Populus deltoides, Prunus pensylvanica,
    # Prunus serotina, Prunus virginiana, Quercus fusiformis,
    # Quercus marilandica, Quercus stellata,
    # Quercus shumardii, Ulmus alata, or Ulmus crassifolia
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315, 332'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Acer saccharum'},
        {'species': 'Aesculus glabra'},
        {'species': 'Carya texana'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Gymnocladus dioicus'},
        {'species': 'Platanus occidentalis'},
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus velutina'},
        {'species': 'Tilia americana'},
        {'species': 'Ulmus rubra'},
        {'species': 'Ulmus americana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Amelanchier'},
        {'species': 'Betula papyrifera'},
        {'species': 'Carya cordiformis'},
        {'species': 'Cercis canadensis'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Gleditsia triacanthos'},
        {'species': 'Juglans nigra'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Morus rubra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Populus balsamifera'},
        {'species': 'Populus deltoides'},
        {'species': 'Prunus pensylvanica'},
        {'species': 'Prunus serotina'},
        {'species': 'Prunus virginiana'},
        {'species': 'Quercus fusiformis'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus shumardii'},
        {'species': 'Ulmus alata'},
        {'species': 'Ulmus crassifolia'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes', 'tallytree': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=053|Eastern North American Forest & Woodland Division (D008)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) or
               plot.riv(EXOTIC_TREE_SPP) >=80 ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_054():

    """Eastern North American Forest & Woodland Natural Forests"""
    """D008"""
    level = 'division'
    code = 'D008'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=054|Eastern North American Forest & Woodland Natural Forests', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_055():

    """Central Midwest Oak Forest, Woodland & Savanna (M012)"""
    """M012"""
    level = 'macrogroup'
    code = 'M012'

    # Tree composition dominated by one of the following:
    # i. Located in ECOREGION 332 AND
    # tree composition dominated by one or more of the following
    # STRONG DRY DIAGNOSTICS species of Populus tremuloides,
    # Quercus rubra, Quercus velutina, 
    # Quercus macrocarpa, Quercus muehlenbergii, or Quercus stellata (=>50% RIV);
    # OR
    # ii. tree composition as above, but with =>20% RIV, AND
    # other species are any combination of MODERATE DRY DIAGNOSTICS diagnostic species
    # of Betula papyrifera, Juniperus virginiana or weakly diagnostic species of Amelanchier spp.,
    # Carya cordiformis, Cercis canadensis, Diospyros virginiana, Morus rubra, Ostrya virginiana,
    # Prunus serotina (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '332A, 332D, 332C, 332E'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus velutina'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus stellata'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Betula papyrifera'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Amelanchier'},
        {'species': 'Carya cordiformis'},
        {'species': 'Cercis canadensis'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Morus rubra'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Prunus serotina'}
    )

    def match(plot):
        logging.debug('%s|NODE=055|Central Midwest Oak Forest, Woodland & Savanna (M012)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_056():

    """North-Central Oak - Hickory Forest & Woodland (G649)"""
    """G649"""
    level = 'group'
    code = 'G649'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 332
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Carya cordiformis,
    # Quercus alba, Quercus rubra, or Quercus velutina (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer saccharum, Celtis occidentalis,
    # Ostrya virginiana, Quercus macrocarpa,
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '332'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Carya cordiformis'},
        {'species': 'Quercus alba'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus velutina'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer saccharum'},
        {'species': 'Celtis occidentalis'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Quercus macrocarpa'}
    )

    def match(plot):
        logging.debug('%s|NODE=056|North-Central Oak - Hickory Forest & Woodland (G649)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_057():

    """Southern & South-Central Oak - Pine Forest & Woodland (M016)"""
    """M016"""
    level = 'macrogroup'
    code = 'M016'

    # Tree composition dominated by one of the following:
    # i. Located in ECOREGION 315, 332, AND Tree composition dominated by
    # one or more of the STRONG DRY SOUTH-CENTRAL DIAGNOSTICS Carya texana,
    # Quercus falcata, Quercus rubra, or Quercus velutina (=>50% RIV);
    # OR
    # ii. States and Tree composition as above, but with =>20% RIV;
    # AND other species are any combination of MODERATE DRY SOUTH-CENTRAL
    # DIAGNOSTICS Carya cordiformis, Cercis canadensis,
    # Diospyros virginiana, Juglans nigra, Juniperus ashei,
    # Juniperus virginiana, Prunus serotina, Quercus fusiformis,
    # Quercus marilandica, Quercus stellata, Quercus shumardii,
    # Ulmus alata, or Ulmus crassifolia
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV).

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315, 332'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Carya texana'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus velutina'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Carya cordiformis'},
        {'species': 'Cercis canadensis'},
        {'species': 'Diospyros virginiana'},
        {'species': 'Juglans nigra'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus virginiana'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus fusiformis'},
        {'species': 'Quercus marilandica'},
        {'species': 'Quercus stellata'},
        {'species': 'Quercus shumardii'},
        {'species': 'Ulmus alata'},
        {'species': 'Ulmus crassifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=057|Southern & South-Central Oak - Pine Forest & Woodland (M016)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_058():

    """Western Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)"""
    """G013"""
    level = 'group'
    code = 'G013'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315D, 315E
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Carya texana, Quercus falcata, Quercus rubra, or Quercus velutina
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Carya tomentosa, Ostrya virginiana,
    # Pinus palustris, Quercus margarettae, Quercus stellata
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315D, 315E'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Carya texana'},
        {'species': 'Quercus falcata'},
        {'species': 'Quercus rubra'},
        {'species': 'Quercus velutina'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Carya tomentosa'},
        {'species': 'Ostrya virginiana'},
        {'species': 'Pinus palustris'},
        {'species': 'Quercus margarettae'},
        {'species': 'Quercus stellata'}
    )

    def match(plot):
        logging.debug('%s|NODE=058|Western Gulf Coastal Plain Pine - Oak Forest & Woodland (G013)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_059():

    """Eastern North American Ruderal Forests"""
    """D008"""
    level = 'division'
    code = 'D008'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or weedy
    # native vegetation that invades natural stands or vegetation that
    # dominates on formerly cleared and/or planted sites but which has been
    # allowed to succeed more-or-less spontaneously). Tree composition
    # dominated by ruderal native or EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER])

    RUDERAL_EXOTIC = PatternList('RUDERAL_EXOTIC',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=059|Eastern North American Ruderal Forests', plot.ident)
        result = (plot.riv(RUDERAL_EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_060():

    """Eastern North American Ruderal Forest (M013)"""
    """M013"""
    level = 'macrogroup'
    code = 'M013'

    # Only one Macrogroup

    RUDERAL_EXOTIC = PatternList('RUDERAL_EXOTIC',
        {'ruderal': 'yes'},
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=060|Eastern North American Ruderal Forest (M013)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_061():

    """Western North American Temperate Forests"""
    """"""
    level = 'subclass'
    code = ''

    # Forests found in ECOREGION 242, M242, 261, M261, 262, M262, 263, 313, M313,
    # 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242, M242, 261, M261, 262, M262, 263, 313, M313, 315, 321, 322, 331, M331, M332, M333, M334, 341, M341, 342'}
    )

    def match(plot):
        logging.debug('%s|NODE=061|Western North American Temperate Forests', plot.ident)
        result = (plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_062():

    """Warm Temperate Forest & Woodland Formation"""
    """F018"""
    level = 'formation'
    code = 'F018'

    # i. Located in ECOREGION M242B, 261, M261, 262, M262, 263, 313C, M313,
    # 315, 321, 322, 331B, 331J, M331F, M331G, 341F, 342B
    # AND
    # ii. Temperate deciduous and evergreen forests and woodlands, dominated
    # by broad-leaved deciduous, broad-leaved evergreen, and needle-leaved
    # tree growth forms. Tree composition contains one or more of diagnostic
    # conifer species Hesperocyparis bakeri, Hesperocyparis forbesii,
    # Hesperocyparis macnabiana, Hesperocyparis macrocarpa,
    # Hesperocyparis pigmaea, Hesperocyparis sargentii, Juniperus californica,
    # Juniperus pinchotii, Juniperus ashei, Juniperus coahuilensis,
    # Juniperus deppeana, Juniperus flaccida, Pinus arizonica,
    # Pinus cembroides, Pinus discolor, Pinus leiophylla,
    # Pinus strobiformis, Pinus attenuata, Pinus coulteri, Pinus muricata (exclude from 263),
    # Pinus radiata, Pinus remota, Pinus sabiniana, Pseudotsuga macrocarpa,
    # or broadleaf species Aesculus californica, Arbutus arizonica,
    # Arbutus xalapensis, Fraxinus albicans, Juglans californica,
    # Juglans major, Juglans nigra, Prosopis glandulosa, Prosopis velutina,
    # Quercus albocincta, Quercus arizonica, Quercus emoryi, Quercus grisea,
    # Quercus agrifolia, Quercus chrysolepis (exclude from M261A, M261B, M261C, M261D, M261G, and 263),
    # Quercus douglasii, Quercus engelmannii, Quercus hypoleucoides,
    # Quercus kelloggii (exclude from M261A, M261B, M261C, M261D, M261G, and 263), Quercus lobata,
    # Quercus oblongifolia, Quercus rugosa, Quercus muehlenbergii,
    # Quercus vaseyana, Quercus parvula var. shrevei, Quercus wislizeni,
    # or Umbellularia californica (exclude from M261A, M261B, M261C, M261D, M261G, and 263) (>= 20% RIV)
    # [Additional tree species not tracked by FIA include Ulmus crassifolia]

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242B, 261, M261, 262, M262, 331B, 331J, M331F, M331G, 341F, 342B, 322, 313C, M313, 321, 315'}
    )

    ECOREGIONS_EXCL = PatternList('ECOREGIONS_EXCL',
        {'ecoregion': 'M261A, M261B, M261C, M261D, M261G'}
    )

    ECOREGIONS_263 = PatternList('ECOREGIONS_263',
        {'ecoregion': '263'}
    )

    DIAGNOSTIC_SPECIES_1 = PatternList('DIAGNOSTIC_SPECIES_1',
        {'species': 'Hesperocyparis bakeri'},
        {'species': 'Hesperocyparis forbesii'},
        {'species': 'Hesperocyparis macnabiana'},
        {'species': 'Hesperocyparis macrocarpa'},
        {'species': 'Hesperocyparis pigmaea'},
        {'species': 'Hesperocyparis sargentii'},
        {'species': 'Juniperus californica'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Pinus attenuata'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus muricata'},
        {'species': 'Pinus radiata'},
        {'species': 'Pinus remota'},
        {'species': 'Pinus sabiniana'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Aesculus californica'},
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Fraxinus albicans'},
        {'species': 'Juglans californica'},
        {'species': 'Juglans major'},
        {'species': 'Juglans nigra'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus albocincta'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus engelmannii'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Quercus lobata'},
        {'species': 'Quercus oblongifolia'},
        {'species': 'Quercus rugosa'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus vaseyana'},
        {'species': 'Quercus parvula var. shrevei'},
        {'species': 'Quercus wislizeni'},
        {'species': 'Umbellularia californica'}
    )

    DIAGNOSTIC_SPECIES_2 = PatternList('DIAGNOSTIC_SPECIES_2',
        {'species': 'Hesperocyparis bakeri'},
        {'species': 'Hesperocyparis forbesii'},
        {'species': 'Hesperocyparis macnabiana'},
        {'species': 'Hesperocyparis macrocarpa'},
        {'species': 'Hesperocyparis pigmaea'},
        {'species': 'Hesperocyparis sargentii'},
        {'species': 'Juniperus californica'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Pinus attenuata'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus muricata'},
        {'species': 'Pinus radiata'},
        {'species': 'Pinus remota'},
        {'species': 'Pinus sabiniana'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Aesculus californica'},
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Fraxinus albicans'},
        {'species': 'Juglans californica'},
        {'species': 'Juglans major'},
        {'species': 'Juglans nigra'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus albocincta'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus engelmannii'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus lobata'},
        {'species': 'Quercus oblongifolia'},
        {'species': 'Quercus rugosa'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus vaseyana'},
        {'species': 'Quercus parvula var. shrevei'},
        {'species': 'Quercus wislizeni'}
    )

    DIAGNOSTIC_SPECIES_3 = PatternList('DIAGNOSTIC_SPECIES_3',
        {'species': 'Hesperocyparis bakeri'},
        {'species': 'Hesperocyparis forbesii'},
        {'species': 'Hesperocyparis macnabiana'},
        {'species': 'Hesperocyparis macrocarpa'},
        {'species': 'Hesperocyparis pigmaea'},
        {'species': 'Hesperocyparis sargentii'},
        {'species': 'Juniperus californica'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Pinus attenuata'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus radiata'},
        {'species': 'Pinus remota'},
        {'species': 'Pinus sabiniana'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Aesculus californica'},
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Fraxinus albicans'},
        {'species': 'Juglans californica'},
        {'species': 'Juglans major'},
        {'species': 'Juglans nigra'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus albocincta'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus engelmannii'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus lobata'},
        {'species': 'Quercus oblongifolia'},
        {'species': 'Quercus rugosa'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus vaseyana'},
        {'species': 'Quercus parvula var. shrevei'},
        {'species': 'Quercus wislizeni'}
    )

    def match(plot):
        logging.debug('%s|NODE=062|Warm Temperate Forest & Woodland Formation', plot.ident)
        result = ((plot.match(ECOREGIONS) and not plot.match(ECOREGIONS_EXCL) and plot.riv(DIAGNOSTIC_SPECIES_1) >= 20) or
               (plot.match(ECOREGIONS_EXCL) and plot.riv(DIAGNOSTIC_SPECIES_2) >= 20) or
               (plot.match(ECOREGIONS_263) and plot.riv(DIAGNOSTIC_SPECIES_3) >= 20))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_063():

    """Californian Forest & Woodland Division (D007)"""
    """D007"""
    level = 'division'
    code = 'D007'

    # Tree composition and ecology matching one of the following options:
    # i. EITHER
    # a. Tree composition contains one or more of STRONG diagnostic tree species Abies concolor, Aesculus californica, Arbutus menziesii, Calocedrus decurrens, Chamaecyparis lawsoniana, Chrysolepis chrysophylla, Fraxinus latifolia, Cupressus bakeri, Cupressus forbesii, Cupressus macnabiana, Cupressus macrocarpa, Cupressus goveniana ssp. pigmaea, Cupressus sargentii, Juglans californica, Juniperus californica, Notholithocarpus densiflorus, Pinus attenuata, Pinus coulteri, Pinus jeffreyi, Pinus muricata, Pinus radiata, Pinus sabiniana, Quercus agrifolia, Quercus chrysolepis, Quercus douglasii, Quercus engelmannii, Quercus kelloggii, Quercus lobata, Quercus wislizeni, Quercus parvula var. shrevei,  or Umbellularia californica (=>50% RIV), [Additional tree species not tracked by FIA include Cupressus abramsiana, Cupressus goveniana, CupressusHesperocyparis nevadensis, Cupressus Hesperocyparis stephensonii, Pinus quadrifolia, Pinus torreyana, Quercus cedrosensis, Quercus tomentella] 
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE
    # diagnostic species any combination of Pinus lambertiana,
    # Pinus monophylla, Pinus ponderosa, Pseudotsuga macrocarpa, sequoia sempervirens
    # or Pseudotsuga menziesii
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV
    # AND
    # ii. Located in ECOREGION M242B, 342B, 263, M261, 341D, 341F, 262, 322, 261, M262

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242B, 342B, 263, M261, 341D, 341F, 262, 322, 261, M262'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Aesculus californica'},
        {'species': 'Arbutus menziesii'},
        {'species': 'Calocedrus decurrens'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Juglans californica'},
        {'species': 'Juniperus californica'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Pinus attenuata'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus muricata'},
        {'species': 'Pinus radiata'},
        {'species': 'Pinus sabiniana'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus engelmannii'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Quercus lobata'},
        {'species': 'Quercus wislizeni'},
        {'species': 'Umbellularia californica'},
        {'species': 'Abies concolor'},
        {'species': 'Fraxinus latifolia'},
        {'species': 'Cupressus bakeri'},
        {'species': 'Cupressus forbesii'},
        {'species': 'Cupressus macnabiana'},
        {'species': 'Cupressus macrocarpa'},
        {'species': 'Cupressus goveniana ssp. pygmaea'},
        {'species': 'Cupressus sargentii'},
        {'species': 'Quercus parvula'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus lambertiana'},
        {'species': 'Pinus monophylla'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Sequoia sempervirens'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=063|Californian Forest & Woodland Division (D007)', plot.ident)
        result = (( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or 
               plot.riv(EXOTIC_TREE_SPP) >=80 )
               and plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_064():

    """Californian Forest & Woodland (M009)"""
    """M009"""
    level = 'macrogroup'
    code = 'M009'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER])

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=064|Californian Forest & Woodland (M009)', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_065():

    """Californian Conifer Forest & Woodland (G198)"""
    """G198"""
    level = 'group'
    code = 'G198'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M261D, M261A, 261B, 322A, M262A, 263,
    # M261B, M261C, M261F, M261E, M262B, 261A 
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Hesperocyparis abramsiana, Hesperocyparis bakeri,
    # Hesperocyparis forbesii, Hesperocyparis goveniana,
    # Hesperocyparis macnabiana, Hesperocyparis macrocarpa,
    # Hesperocyparis nevadensis, Hesperocyparis pigmaea,
    # Hesperocyparis sargentii, Hesperocyparis stephensonii,
    # Juniperus californica
    # Pinus sabiniana, Pinus attenuata, Pinus coulteri, Pinus muricata,
    # Pinus radiata, Pinus torreyana, or Pinus quadrifolia (RIV=>50%), 
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Arbutus menziesii, Calocedrus decurrens,
    # Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monophylla,
    # Pinus ponderosa, Pseudotsuga menziesii, Pseudotsuga macrocarpa,
    # Quercus agrifolia, Quercus chrysolepis, Quercus kelloggii,
    # Quercus wislizeni, or Quercus douglasii (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M261D, M261A, 261B, 322A, M262A, 263, M261B, M261C, M261F, M261E, M262B, 261A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Hesperocyparis abramsiana'},
        {'species': 'Hesperocyparis bakeri'},
        {'species': 'Hesperocyparis forbesii'},
        {'species': 'Hesperocyparis goveniana'},
        {'species': 'Hesperocyparis macnabiana'},
        {'species': 'Hesperocyparis macrocarpa'},
        {'species': 'Hesperocyparis nevadensis'},
        {'species': 'Hesperocyparis pigmaea'},
        {'species': 'Hesperocyparis sargentii'},
        {'species': 'Hesperocyparis stephensonii'},
        {'species': 'Juniperus californica'},
        {'species': 'Pinus sabiniana'},
        {'species': 'Pinus attenuata'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus muricata'},
        {'species': 'Pinus radiata'},
        {'species': 'Pinus torreyana'},
        {'species': 'Pinus quadrifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus menziesii'},
        {'species': 'Calocedrus decurrens'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus monophylla'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Quercus wislizeni'},
        {'species': 'Quercus douglasii'}
    )

    def match(plot):
        logging.debug('%s|NODE=065|Californian Conifer Forest & Woodland (G198)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_066():

    """Californian Broadleaf Forest & Woodland (G195)"""
    """G195"""
    level = 'group'
    code = 'G195'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 342B, 322A, 341D, M242B, M261, M262, 261,
    # 262, 263 and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Aesculus californica, Juglans californica,
    # Quercus agrifolia, Quercus chrysolepis, Quercus douglasii,
    # Quercus kelloggii, Quercus lobata, Quercus wislizeni,
    # or Umbellularia californica (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Quercus engelmannii or Quercus parvula var. shrevei,
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '342B, 322A, 341D, M242B, M261, M262, 261, 262, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Aesculus californica'},
        {'species': 'Juglans californica'},
        {'species': 'Quercus agrifolia'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus douglasii'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Quercus lobata'},
        {'species': 'Quercus wislizeni'},
        {'species': 'Umbellularia californica'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus engelmannii'},
        {'species': 'Quercus parvula var. shrevei'}
    )

    def match(plot):
        logging.debug('%s|NODE=066|Californian Broadleaf Forest & Woodland (G195)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_067():

    """Californian Ruderal Forest (M513)"""
    """M513"""
    level = 'macrogroup'
    code = 'M513'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER] – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=067|Californian Ruderal Forest (M513)', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_068():

    """Madrean Forest & Woodland Division (D331)"""
    """D331"""
    level = 'division'
    code = 'D331'

    # Tree composition and ecology matching one of the following options:
    # i. EITHER
    # a. Tree composition contains one or more of STRONG diagnostic tree
    # species Juniperus ashei, Juniperus coahuilensis, Juniperus deppeana,
    # Juniperus flaccida, Pinus arizonica, Pinus cembroides, Pinus discolor,
    # Pinus engelmannii, Pinus leiophylla, Pinus strobiformis,
    # Prosopis glandulosa, Prosopis velutina, Quercus albocincta,
    # Quercus arizonica, Quercus chrysolepis, Quercus emoryi,
    # Quercus grisea, Quercus hypoleucoides, Quercus oblongifolia,
    # or Quercus rugosa (=>50% RIV),
    # [Additional tree species not tracked by FIA include
    # Juniperus arizonica, Quercus buckleyi, Quercus fusiformis,
    # Quercus gravesii, Quercus vaseyana, or Ulmus crassifolia]
    # OR
    # b. The above tree species, but with =>20% RIV AND other MODERATE
    # diagnostic species any combination of Abies concolor,
    # Acer grandidentatum, Arbutus arizonica, Arbutus xalapensis,
    # Celtis laevigata, Fraxinus albicans, Juglans major, Juglans nigra,
    # Juniperus monosperma, Juniperus osteosperma, Juniperus pinchotii, Pinus edulis,
    # Pinus ponderosa, Pinus remota, Pseudotsuga menziesii,
    # Prunus serotina, Quercus macrocarpa, Quercus muehlenbergii, or Quercus vaseyana
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV),
    # [Additional tree species not tracked by FIA include Quercus laceyi]
    # OR
    # c. Any EXOTIC = yes tree species =>80% RIV
    # AND
    # ii. Located in ECOREGION 322, 313, M313, 321, 315

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '322, 313, M313, 321, 315'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus ashei'},
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus engelmannii'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus albocincta'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus oblongifolia'},
        {'species': 'Quercus rugosa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Acer grandidentatum'},
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Celtis laevigata'},
        {'species': 'Fraxinus albicans'},
        {'species': 'Juglans major'},
        {'species': 'Juglans nigra'},
        {'species': 'Juniperus monosperma'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pinus remota'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Prunus serotina'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Quercus muehlenbergii'},
        {'species': 'Quercus vaseyana'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=068|Madrean Forest & Woodland Division (D331)', plot.ident)
        result = (( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or 
               plot.riv(EXOTIC_TREE_SPP) >=80 )
               and plot.match(ECOREGIONS))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_069():

    """Madrean Natural Forests & Woodlands"""
    """D331"""
    level = 'division'
    code = 'D331'

    # Vegetation in a relatively natural state, dominated by native species,
    # little or no evidence of trees in a row, no very recent logging,
    # understory mowing, etc. (trees may be early successional pole-sized
    # trees following logging or blowdowns). Tree composition is dominated by
    # ruderal native or EXOTIC = yes (< 20% RIV)
    # (See Appendix xx [PLACEHOLDER]) – needs to be refined for this Division)

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=069|Madrean Natural Forests & Woodlands', plot.ident)
        result = (plot.riv(EXOTIC) < 20)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_070():

    """Madrean Lowland Evergreen Woodland (M010)"""
    """M010"""
    level = 'macrogroup'
    code = 'M010'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 322, 313C, M313, 321, AND
    # tree composition dominated by one or more of STRONG DIAGNOSTIC species
    # Juniperus coahuilensis, Juniperus deppeana, Juniperus flaccida,
    # Juniperus pinchotii, Pinus cembroides, Pinus discolor,
    # Prosopis glandulosa, Prosopis velutina [these Prosopis species may be ruderal
    # or wetland types, or not even woodlands in the NVC], Quercus arizonica,
    # Quercus emoryi, Quercus gravesii, Quercus grisea, or Quercus oblongifolia
    # (RIV=>20%), [Additional tree species not tracked by FIA include
    # Pinus remota, Quercus albocincta, Quercus chihuahuensis,
    # Quercus graciliformis]
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any combination
    # of Arbutus arizonica, Arbutus xalapensis, Juniperus monosperma,
    # Pinus arizonica, Pinus edulis, Pinus engelmannii, Pinus leiophylla
    # Pinus strobiformis, Quercus hypoleucoides, and Quercus rugosa
    # (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%))

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '322, 313C, M313, 321'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus gravesii'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus oblongifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Juniperus monosperma'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus engelmannii'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus rugosa'}
    )

    def match(plot):
        logging.debug('%s|NODE=070|Madrean Lowland Evergreen Woodland (M010)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_071():

    """Madrean Pinyon - Juniper Woodland (G200)"""
    """G200"""
    level = 'group'
    code = 'G200'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 313D?, 315H?, 315A, 313B, M313A, M313B, 321,
    # 313A, 322A, 313C, 322B and tree composition dominated by one or more
    # of STRONG DIAGNOSTIC species Juniperus coahuilensis, Juniperus deppeana,
    # Juniperus flaccida, Juniperus pinchotii, Pinus cembroides,
    # Pinus discolor, Pinus edulis, or Pinus remota (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus deppeana, Prosopis glandulosa,
    # Prosopis velutina (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%),
    # OR
    # iii. Located in above ECOREGION, and tree composition as i. above,
    # but with =>20% RIV AND with other INDICATOR species
    # Juniperus ashei, Juniperus scopulorum, Pinus ponderosa, Quercus arizonica, Quercus emoryi, Quercus grisea,
    # Quercus hypoleucoides, or Quercus rugosa (RIV >=1%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'ECOREGION 313D, 315H, 315A, 313B, M313A, M313B, 321, 313A, 322A, 313C, 322B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Juniperus pinchotii'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus remota'},
        {'species': 'Juniperus deppeana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Prosopis glandulosa'},
        {'species': 'Prosopis velutina'}
    )

    OTHER_INDICATOR_SPECIES = PatternList('OTHER_INDICATOR_SPECIES',
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus rugosa'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Juniperus ashei'}
    )

    def match(plot):
        logging.debug('%s|NODE=071|Madrean Pinyon - Juniper Woodland (G200)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(OTHER_INDICATOR_SPECIES) >= 1) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_072():

    """Madrean Encinal (G201)"""
    """G201"""
    level = 'group'
    code = 'G201'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 313D?, 315H?, M313A, M313B, 315A, 321, 322A,
    # 313C, 322B and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Quercus arizonica, Quercus emoryi, Quercus grisea,
    # or Quercus oblongifolia (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Arbutus arizonica, Arbutus xalapensis (>=30% RIV;
    # i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
    # OR
    # iii. Located in above ECOREGION, and tree composition as i. above,
    # but with =>20% RIV AND with other INDICATOR species
    # Juniperus coahuilensis, Juniperus deppeana, Pinus cembroides, and
    # Pinus discolor, Pinus arizonica, Pinus engelmannii, Pinus leiophylla,
    # or Pinus strobiformis (RIV >= 1%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '313D, 315H, M313A, M313B, 315A, 321, 322A, 313C, 322B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus oblongifolia'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'}
    )

    OTHER_INDICATOR_SPECIES = PatternList('OTHER_INDICATOR_SPECIES',
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus engelmannii'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'}
    )

    def match(plot):
        logging.debug('%s|NODE=072|Madrean Encinal (G201)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(OTHER_INDICATOR_SPECIES) >= 1) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_073():

    """Madrean Juniper Open Woodland (G487)"""
    """G487"""
    level = 'group'
    code = 'G487'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315B?, 315A, M313A, 322, M313B, 315C, 321,
    # 315D, 313A, 313D, M262B, 313C, 315H
    # and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Juniperus coahuilensis or Juniperus deppeana
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus monosperma (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315B, 315A, M313A, 322, M313B, 315C, 321, 315D, 313A, 313D, M262B, 313C, 315H'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus coahuilensis'},
        {'species': 'Juniperus deppeana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus monosperma'}
    )

    def match(plot):
        logging.debug('%s|NODE=073|Madrean Juniper Open Woodland (G487)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_074():

    """Madrean Montane Forest & Woodland (M011)"""
    """M011"""
    level = 'macrogroup'
    code = 'M011'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 322, 313C, M313, 321, 315, AND tree composition
    # dominated by one or more of STRONG DIAGNOSTIC species
    # Juniperus deppeana, Pinus arizonica, Pinus engelmannii, Pinus leiophylla,
    # Pinus strobiformis,
    # Quercus albocincta, Quercus arizonica, Quercus chrysolepis, Quercus emoryi,
    # Quercus grisea, Quercus hypoleucoides, or Quercus rugosa (RIV=>20%),
    # [Additional tree species not tracked by FIA include Abies coahuilensis,
    # Hesperocyparis arizonica, Quercus fulva, Quercus viminea]
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies concolor, Acer grandidentatum, Arbutus arizonica,
    # Arbutus xalapensis, Juniperus flaccida, Pinus cembroides,
    # Pinus discolor, Pinus edulis, Pinus ponderosa, Pseudotsuga menziesii
    # Quercus gravesii and Quercus muehlenbergii
    # (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '322, 313C, M313, 321, 315'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus deppeana'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus engelmannii'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Quercus albocincta'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus rugosa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Acer grandidentatum'},
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus gravesii'},
        {'species': 'Quercus muehlenbergii'}
    )

    def match(plot):
        logging.debug('%s|NODE=074|Madrean Montane Forest & Woodland (M011)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_075():

    """Madrean Upper Montane Conifer - Oak Forest & Woodland (G202)"""
    """G202"""
    level = 'group'
    code = 'G202'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 313B, 313D, 315H, 322B, 315A, M313A,
    # M313B, 321A, 322A, 313C  and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Abies coahuilensis, Abies concolor, Pinus strobiformis,
    # Pseudotsuga menziesii, Quercus hypoleucoides, or Quercus rugosa
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer grandidentatum, Juniperus deppeana,
    # Juniperus flaccida, Quercus arizonica, Quercus chrysolepis,
    # Quercus emoryi, Quercus gravesii, Quercus grisea,
    # Quercus muehlenbergii (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '341Fb, 341Fc, 341Fd, 322Ab, 322Aa, 322Az, 322Ac, 341Fk, 341Fe, 322Ad, 322Ay, 322Ae, 341Ff, 322As, 322Ar, 322Aq, 322Ag, 322Af, 322At, 313Ao, 322Ah, 322Ai, 322Aj, 322Av, 322Am, 313De, 322Aw, 322Al, 322Ax, 322Ao, 322An, 313Df, M313Ak, M313Al, 322Ba, 322Ap, 313Cd, 313Bo, 313Ca, M313Af, 315Ha, M313Ah, 313Cc, M313Am, M313Ad, M313Bf, 321Ag, 322Bh, M313Ag, 321Ai, M313Ae, 321Ak, 321Af, M313Bg, M313Ac, 315Aa, 321Aj, 321Am, M313Ba, 321Ac, 321Ah'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies coahuilensis'},
        {'species': 'Abies concolor'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus rugosa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer grandidentatum'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus gravesii'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus muehlenbergii'}
    )

    def match(plot):
        logging.debug('%s|NODE=075|Madrean Upper Montane Conifer - Oak Forest & Woodland (G202)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_076():

    """Madrean Lower Montane Pine - Oak Forest & Woodland (G203)"""
    """G203"""
    level = 'group'
    code = 'G203'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315A, 315H, 313D, 322B, M313A, M313B, 321,
    # 322A, 313C and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Hesperocyparis arizonica, Juniperus deppeana, Pinus arizonica,
    # Pinus engelmannii,
    # Pinus leiophylla, or Pinus ponderosa var. scopulorum (RIV=>20%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Arbutus arizonica, Arbutus xalapensis,
    # Juniperus flaccida, Pinus cembroides,
    # Pinus discolor, Quercus arizonica, Quercus emoryi, Quercus fulva,
    # Quercus gravesii, Quercus grisea, Quercus hypoleucoides,
    # Quercus rugosa, or Quercus viminea (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315A, 315H, 313D, 322B, M313A, M313B, 321, 322A, 313C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Hesperocyparis arizonica'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Pinus arizonica'},
        {'species': 'Pinus engelmannii'},
        {'species': 'Pinus leiophylla'},
        {'species': 'Pinus ponderosa var. scopulorum'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus arizonica'},
        {'species': 'Arbutus xalapensis'},
        {'species': 'Juniperus flaccida'},
        {'species': 'Pinus cembroides'},
        {'species': 'Pinus discolor'},
        {'species': 'Quercus arizonica'},
        {'species': 'Quercus emoryi'},
        {'species': 'Quercus fulva'},
        {'species': 'Quercus gravesii'},
        {'species': 'Quercus grisea'},
        {'species': 'Quercus hypoleucoides'},
        {'species': 'Quercus rugosa'},
        {'species': 'Quercus viminea'}
    )

    def match(plot):
        logging.debug('%s|NODE=076|Madrean Lower Montane Pine - Oak Forest & Woodland (G203)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_077():

    """Western North American Ruderal Forests - Madrean-Balconian"""
    """D060"""
    level = 'division'
    code = 'D060'

    # Vegetation dominated by ruderal vegetation (nonnative invasive or
    # weedy native vegetation that invades natural stands or vegetation
    # that dominates on formerly cleared and/or planted sites but which
    # has been allowed to succeed more-or-less spontaneously).
    # Tree composition dominated by EXOTIC = yes (>= 80% RIV)
    # (See Appendix xx [PLACEHOLDER])

    EXOTIC = PatternList('EXOTIC',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=077|Western North American Ruderal Forests - Madrean-Balconian', plot.ident)
        result = (plot.riv(EXOTIC) >= 80)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_078():

    """Cool Temperate Forest & Woodland Formation"""
    """F008"""
    level = 'formation'
    code = 'F008'

    # Not as above, Temperate deciduous forests and woodlands, temperate
    # needle-leaved forests and woodlands, and temperate rainforests,
    # dominated by broad-leaved or needle-leaved tree growth forms found
    # in cool temperate regions of the western U.S. and southeast Alaska

    def match(plot):
        logging.debug('%s|NODE=078|Cool Temperate Forest & Woodland Formation', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_079():

    """Pacific Coast Temperate Rainforest Division (D338)"""
    """D338"""
    level = 'division'
    code = 'D338'

    # Tree composition and ecology matching one of the following options: 
    # i.  Located in ECOREGION 242A, M242, 261A, M261A, M261B, 263
    # AND
    # ii.  EITHER 
    #   a.  Tree composition dominated by one or more of STRONG DIAGNOSTIC 
    #   species Abies amabilis, Acer macrophyllum, Alnus rubra, 
    #   Chamaecyparis lawsoniana, Picea sitchensis, Pinus contorta 
    #   [exclude from M242C and M242D, and exclude plots >500m in 
    #   ELEVATION], Pseudotsuga menziesii [exclude from M242C and M242D],
    #   Sequoia sempervirens, Thuja plicata, or Tsuga heterophylla
    #   (RIV=>50%)
    #   OR
    #   b.  Tree composition as above, but with =>20% RIV AND with other 
    #   MODERATE DIAGNOSTIC species in any combination of Abies grandis,
    #   Abies lasiocarpa, Abies procera, Acer circinatum, 
    #   Arbutus menziesii, Callitropsis nootkatensis, Cornus nuttallii,
    #   Frangula purshiana, Notholithocarpus densiflorus,
    #   Pinus monticola, Pinus muricata, Quercus garryana, or 
    #   Umbellularia californica (>=30% RIV; i.e., together STRONG and
    #   MODERATE diagnostic species RIV =>50%) 
    #   OR 
    #   c.  Any EXOTIC = yes tree species =>80% RIV
    # 
    # TRANSLATES TO:
    # 
    # Plot location and tree composition are as follows:
    # STRONG DIAGNOSTICS RIV 50% or more
    # NO EXCLUSIONS
    #   i. Located in ECOREGION 242A, M242, 261A, M261A, M261B, 263, AND tree
    #   composition dominated by one or more of STRONG DIAGNOSTIC_1 species
    #   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
    #   Picea sitchensis, Sequoia sempervirens, Thuja plicata, or
    #   Tsuga heterophylla (RIV=>50%),
    # OR
    # ELEVATION <500m + ECOREGION EXCLUSIONS
    #   ii. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
    #   AND elevation <500m
    #   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_2 species
    #   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
    #   Picea sitchensis, Pinus contorta, Pseudotsuga menziesii, Sequoia sempervirens,
    #   Thuja plicata, or Tsuga heterophylla (RIV=>50%),
    # OR
    # ELEVATION =>500m + ECOREGION EXCLUSIONS
    #   iii. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
    #   AND elevation =>500m
    #   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_3 species
    #   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
    #   Picea sitchensis, Pseudotsuga menziesii, Sequoia sempervirens, Thuja plicata,
    #   or Tsuga heterophylla (RIV=>50%),
    # OR
    # STRONG DIAGNOSTICS RIV 20% or more + MODERATE DIAGNOSTICS RIV 30% or more
    # NO EXCLUSIONS
    #   iv. Located in ECOREGION 242A, M242, 261A, M261A, M261B, 263, AND tree composition
    #   dominated by one or more of STRONG DIAGNOSTIC_1 species Abies amabilis,
    #   Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana, Picea sitchensis,
    #   Sequoia sempervirens, Thuja plicata, or Tsuga heterophylla (RIV=>20%),
    #   AND with other MODERATE DIAGNOSTIC species in any combination of Abies grandis,
    #   Abies lasiocarpa, Abies procera, Acer circinatum, Arbutus menziesii,
    #   Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana,
    #   Notholithocarpus densiflorus, Pinus monticola, Pinus muricata, Quercus garryana,
    #   or Umbellularia californica (>=30% RIV; i.e., together STRONG and MODERATE
    #   diagnostic species RIV =>50%)
    # OR
    # ELEVATION <500m + ECOREGION EXCLUSIONS
    #   v. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
    #   AND elevation <500m
    #   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_2 species
    #   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
    #   Picea sitchensis, Pinus contorta, Pseudotsuga menziesii, Sequoia sempervirens,
    #   Thuja plicata, or Tsuga heterophylla (RIV=>20%),
    #   AND with other MODERATE DIAGNOSTIC species in any combination of Abies grandis,
    #   Abies lasiocarpa, Abies procera, Acer circinatum, Arbutus menziesii,
    #   Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana,
    #   Notholithocarpus densiflorus, Pinus monticola, Pinus muricata, Quercus garryana,
    #   or Umbellularia californica (>=30% RIV; i.e., together STRONG and MODERATE
    #   diagnostic species RIV =>50%)
    # OR
    # ELEVATION =>500m + ECOREGION EXCLUSIONS
    #   vi. Located in ECOREGION 242A, M242A, M242B, 261A, M261A, M261B, 263,
    #   AND elevation =>500m
    #   AND tree composition dominated by one or more of STRONG DIAGNOSTIC_3 species
    #   Abies amabilis, Acer macrophyllum, Alnus rubra, Chamaecyparis lawsoniana,
    #   Picea sitchensis, Pseudotsuga menziesii, Sequoia sempervirens, Thuja plicata,
    #   or Tsuga heterophylla (RIV=>20%),
    #   AND with other MODERATE DIAGNOSTIC species in any combination of Abies grandis,
    #   Abies lasiocarpa, Abies procera, Acer circinatum, Arbutus menziesii,
    #   Callitropsis nootkatensis, Cornus nuttallii, Frangula purshiana,
    #   Notholithocarpus densiflorus, Pinus monticola, Pinus muricata, Quercus garryana,
    #   or Umbellularia californica (>=30% RIV; i.e., together STRONG and MODERATE
    #   diagnostic species RIV =>50%)
    # OR
    #   vii. Any EXOTIC = yes tree species >= 80%

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': '242A, M242, 261A, M261A, M261B, 263'}
    )

    ECOREGIONS_2 = PatternList('ECOREGIONS_2',
        {'ecoregion': '242A, M242A, M242B, 261A, M261A, M261B, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES_1 = PatternList('STRONG_DIAGNOSTIC_SPECIES_1',
        {'species': 'Abies amabilis'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Alnus rubra'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Picea sitchensis'},
        {'species': 'Sequoia sempervirens'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    STRONG_DIAGNOSTIC_SPECIES_2 = PatternList('STRONG_DIAGNOSTIC_SPECIES_2',
        {'species': 'Abies amabilis'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Alnus rubra'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Picea sitchensis'},
        {'species': 'Pinus contorta'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Sequoia sempervirens'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    STRONG_DIAGNOSTIC_SPECIES_3 = PatternList('STRONG_DIAGNOSTIC_SPECIES_3',
        {'species': 'Abies amabilis'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Alnus rubra'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Picea sitchensis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Sequoia sempervirens'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies procera'},
        {'species': 'Acer circinatum'},
        {'species': 'Arbutus menziesii'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Cornus nuttallii'},
        {'species': 'Frangula purshiana'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Pinus monticola'},
        {'species': 'Pinus muricata'},
        {'species': 'Quercus garryana'},
        {'species': 'Umbellularia californica'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=079|Pacific Coast Temperate Rainforest Division (D338)', plot.ident)
        result = ((plot.match(ECOREGIONS_1) and plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50) or
               (plot.match(ECOREGIONS_2) and plot.get_elevation() < 500 and plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 50) or
               (plot.match(ECOREGIONS_2) and plot.get_elevation() >= 500 and plot.riv(STRONG_DIAGNOSTIC_SPECIES_3) >= 50) or
               (plot.match(ECOREGIONS_1) and plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or
               (plot.match(ECOREGIONS_2) and plot.get_elevation() < 500 and plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or
               (plot.match(ECOREGIONS_2) and plot.get_elevation() >= 500 and plot.riv(STRONG_DIAGNOSTIC_SPECIES_3) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or
               (plot.match(ECOREGIONS_1) and plot.riv(EXOTIC_TREE_SPP) >= 80))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_080():

    """Vancouverian Coastal Rainforest (M024)"""
    """M024"""
    level = 'macrogroup'
    code = 'M024'

    # Only macrogroup

    def match(plot):
        logging.debug('%s|NODE=080|Vancouverian Coastal Rainforest (M024)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_081():

    """Vancouverian Dry Coastal Beach Pine Forest & Woodland (G205)"""
    """G205"""
    level = 'group'
    code = 'G205'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 242, M242A, M261A, 263
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Pinus contorta(RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies grandis, Arbutus menziesii, Pinus muricata, Picea sitchensis, Pseudotsuga menziesii  or
    # Tsuga heterophylla [PLACEHOLDER – INSERT P2 VEG] (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242, M242A, M261A, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus contorta'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Arbutus menziesii'},
        {'species': 'Pinus muricata'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Picea sitchensis'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=081|Vancouverian Dry Coastal Beach Pine Forest & Woodland (G205)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_082():

    """Californian Coastal Redwood Forest (G235)"""
    """G235"""
    level = 'group'
    code = 'G235'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M262A, M242A, M261A, 263, M261B, 261A and
    # tree composition dominated by one or more of STRONG DIAGNOSTIC species
    # Chamaecyparis lawsoniana or Sequoia sempervirens (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Arbutus menziesii, Notholithocarpus densiflorus,
    # Picea sitchensis, Pseudotsuga menziesii, Tsuga heterophylla, or
    # Umbellularia californica (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M262A, M242A, M261A, 263, M261B, 261A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Sequoia sempervirens'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus menziesii'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Picea sitchensis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Umbellularia californica'}
    )

    def match(plot):
        logging.debug('%s|NODE=082|Californian Coastal Redwood Forest (G235)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_083():

    """North Pacific Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)"""
    """G237"""
    level = 'group'
    code = 'G237'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, M242D, M261A, M261D, M242A, M242B, 242
    # and tree composition dominated
    # by one or more of STRONG DIAGNOSTIC species Acer macrophyllum or
    # Alnus rubra (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies grandis, Cornus nuttallii, Frangula purshiana,
    # Picea sitchensis, Pseudotsuga menziesii, Quercus garryana,
    # Thuja plicata, Malus fusca, Prunus emarginata or Tsuga heterophylla (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242D, M261A, M261D, M242A, M242B, 242'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Acer macrophyllum'},
        {'species': 'Alnus rubra'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Cornus nuttallii'},
        {'species': 'Frangula purshiana'},
        {'species': 'Picea sitchensis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus garryana'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Malus fusca'},
        {'species': 'Prunus emarginata'}
    )

    def match(plot):
        logging.debug('%s|NODE=083|North Pacific Red Alder - Bigleaf Maple - Douglas-fir Rainforest (G237)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_084():

    """North Pacific Maritime Douglas-fir - Western Hemlock Rainforest (G240)"""
    """G240"""
    level = 'group'
    code = 'G240'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 261A, M242A, M261A, M261B, 263, 242
    # M242B, M242D and tree composition
    # dominated by one or more of STRONG DIAGNOSTIC species
    # Pseudotsuga menziesii, Tsuga heterophylla, or Thuja plicata
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer macrophyllum, Alnus rubra, Prunus emarginata, or Malus fusca (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261A, M242A, M261A, M261B, 263, 242, M242B, M242D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Thuja plicata'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer macrophyllum'},
        {'species': 'Alnus rubra'},
        {'species': 'Malus fusca'},
        {'species': 'Prunus emarginata'}
    )

    def match(plot):
        logging.debug('%s|NODE=084|North Pacific Maritime Douglas-fir - Western Hemlock Rainforest (G240)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_085():

    """North-Central Pacific Maritime Silver Fir - Western Hemlock Rainforest (G241)"""
    """G241"""
    level = 'group'
    code = 'G241'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242, 242
    # and tree composition dominated
    # by one or more of STRONG DIAGNOSTIC species Abies amabilis or
    # Tsuga heterophylla (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies lasiocarpa, Abies procera, Malus fusca, Prunus emarginata  or
    # Callitropsis nootkatensis (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242, 242'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies amabilis'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies procera'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Malus fusca'},
        {'species': 'Prunus emarginata'}
    )

    def match(plot):
        logging.debug('%s|NODE=085|North-Central Pacific Maritime Silver Fir - Western Hemlock Rainforest (G241)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_086():

    """North-Central Pacific Western Hemlock - Sitka Spruce Rainforest (G751)"""
    """G751"""
    level = 'group'
    code = 'G751'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 261A, M261A, M261B, M242A, M242B,
    # M242D, 242, 263
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Picea sitchensis, Thuja plicata, or
    # Tsuga heterophylla (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies amabilis, Abies grandis, Acer circinatum,
    # Acer macrophyllum, Alnus rubra, Callitropsis nootkatensis,
    # Chamaecyparis lawsoniana, Frangula purshiana, Malus fusca, Prunus emarginata  or
    # Pseudotsuga menziesii (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261A, M261A, M261B, M242A, M242B, M242D, 242, 263'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Picea sitchensis'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies amabilis'},
        {'species': 'Abies grandis'},
        {'species': 'Acer circinatum'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Alnus rubra'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Frangula purshiana'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Malus fusca'},
        {'species': 'Prunus emarginata'}
    )

    def match(plot):
        logging.debug('%s|NODE=086|North-Central Pacific Western Hemlock - Sitka Spruce Rainforest (G751)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_087():

    """Western North American Pinyon-Juniper Woodland & Scrub Division (D010)"""
    """D010"""
    level = 'division'
    code = 'D010'

    # Tree composition and ecology matching one of the following options:
    # i.  Located in ECOREGION M242C, M261D, M261E, M261G, M262B, 313, M313, 315,
    #   321, 322, 331I, 331J, M331, M332, 341, M341, 342
    # AND
    # ii.  EITHER
    #   a.  Tree composition dominated by one or more of STRONG diagnostic
    #   tree species Cercocarpus ledifolius, Juniperus monosperma,
    #   Juniperus occidentalis, Juniperus osteosperma, Pinus edulis, or
    #   Pinus monophylla (=>50% RIV),
    #   OR
    #   b.  The above tree species, but with =>20% RIV AND other MODERATE 
    #   diagnostic species of Juniperus californica, Juniperus deppeana,
    #   Juniperus grandis, Juniperus scopulorum, Pinus jeffreyi,
    #   Pinus ponderosa, or Quercus gambelii (>=30% RIV; i.e.,
    #   together STRONG and MODERATE diagnostic species =>50% RIV)
    #   OR
    #   c.  Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M261D, M261E, M261G, M262B, 313, M313, 315, 321, 322, 331I, 331J, M331, M332, 341, M341, 342'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Cercocarpus ledifolius'},
        {'species': 'Juniperus monosperma'},
        {'species': 'Juniperus occidentalis'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus monophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus californica'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus grandis'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Quercus gambelii'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=087|Western North American Pinyon-Juniper Woodland & Scrub Division (D010)', plot.ident)
        result = (plot.match(ECOREGIONS)
               and ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50
               or (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30)
               or plot.riv(EXOTIC_TREE_SPP) >= 80)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_088():

    """Intermountain Pinyon-Juniper Woodland (M896)"""
    """M896"""
    level = 'macrogroup'
    code = 'M896'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, 342, M332, M261D, M261E, M261G, 315, 313,
    # M313, 321, M331D, M331E, M331F, M331G, M331H, M331I, M331J, 341, M262B,
    # 322, 331I, 331J, M333, M341,
    # AND tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Juniperus occidentalis, Juniperus osteosperma, Pinus monophylla,
    # or Cercocarpus ledifolius (RIV=>20%), 
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus californica, Pinus edulis, Pinus jeffreyi
    # Juniperus grandis, Juniperus monosperma, Juniperus scopulorum, and Pinus ponderosa
    # or [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES]
    # (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, 342, M332, M261D, M261E, M261G, 315, 313, M313, 321, M331D, M331E, M331F, M331G, M331H, M331I, M331J, 341, M262B, 322, 331I, 331J, M333, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus occidentalis'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Pinus monophylla'},
        {'species': 'Cercocarpus ledifolius'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus californica'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Juniperus grandis'},
        {'species': 'Juniperus monosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus ponderosa'}
    )

    def match(plot):
        logging.debug('%s|NODE=088|Intermountain Pinyon-Juniper Woodland (M896)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_089():

    """Intermountain Western Juniper Open Woodland (G248)"""
    """G248"""
    level = 'group'
    code = 'G248'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 341E, 341G, 342D, M242B, M332A, M261A,
    # M261F, M242C, 342H, 342I, 342B, 342C, M332G, M261D, M261E, M261G
    # and tree composition dominated
    # by one or more of STRONG DIAGNOSTIC species Juniperus occidentalis
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Cercocarpus ledifolius, Pinus jeffreyi or
    # Pinus ponderosa (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '341E, 341G, 342D, M242B, M332A, M261A, M261F, M242C, 342H, 342I, 342B, 342C, M332G, M261D, M261E, M261G'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus occidentalis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Cercocarpus ledifolius'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus ponderosa'}
    )

    def match(plot):
        logging.debug('%s|NODE=089|Intermountain Western Juniper Open Woodland (G248)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_090():

    """Intermountain Basins Curl-leaf Mountain-mahogany Woodland & Scrub (G249)"""
    """G249"""
    level = 'group'
    code = 'G249'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 322B, 341B, 341C, 342F, 342A, 342G, 342I,
    # 342E, M242B, M261A, M261B, M261F, M262B, M332A, M331G, M331H,
    # M242C, M332E, M332F, M332G, M332B, M332D, M261D, M261E, M261G, 342H,
    # 342B, 342D, 342C, 342J, M331A, M331B, M331E, M331J, M331D, 313A,
    # 341A, 341F, 341E, 341D, 341G, 322A, M341 
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Cercocarpus ledifolius (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of [PLACEHOLDER - INSERT P2 VEG] (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%) 

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '322B, 341B, 341C, 342F, 342A, 342G, 342I, 342E, M242B, M261A, M261B, M261F, M262B, M332A, M331G, M331H, M242C, M332E, M332F, M332G, M332B, M332D, M261D, M261E, M261G, 342H, 342B, 342D, 342C, 342J, M331A, M331B, M331E, M331J, M331D, 313A, 341A, 341F, 341E, 341D, 341G, 322A, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Cercocarpus ledifolius'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'placeholder - add moderate diagnostic'}
    )

    def match(plot):
        logging.debug('%s|NODE=090|Intermountain Basins Curl-leaf Mountain-mahogany Woodland & Scrub (G249)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_091():

    """Great Basin Pinyon - Juniper Woodland (G899)"""
    """G899"""
    level = 'group'
    code = 'G899'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 322B, 342D, 342H, M242C, 313, 322A, 341A,
    # 341D, 341E, 341F, 341G, 342B, 342C, 342J, M261F, M261E, M261G,
    # M262B, M331D, M341A, M341D, M341C
    # and tree composition dominated by the STRONG
    # DIAGNOSTIC species Pinus monophylla (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Cercocarpus ledifolius, Juniperus californica, Juniperus occidentalis,
    # Juniperus osteosperma or Pinus jeffreyi (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '322B, 342D, 342H, M242C, 313, 322A, 341A, 341D, 341E, 341F, 341G, 342B, 342C, 342J, M261F, M261E, M261G, M262B, M331D, M341A, M341D, M341C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus monophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Cercocarpus ledifolius'},
        {'species': 'Juniperus californica'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Juniperus occidentalis'}
    )

    def match(plot):
        logging.debug('%s|NODE=091|Great Basin Pinyon - Juniper Woodland (G899)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_092():

    """Colorado Plateau Pinyon - Juniper Woodland (G900)"""
    """G900"""
    level = 'group'
    code = 'G900'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 322B, 342E, 342D, 331I, 315A, 315H, 313,
    # 322A, M313A, M313B, M331D, M331E, M331F, M331G, M331H, M331I, 331J,
    # 342G, 341A, 341B, 341C, 341F, M341B, M341C
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Pinus edulis (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus monosperma, Juniperus osteosperma, Quercus gambelii, Quercus grisea  or
    # Juniperus scopulorum (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '322B, 342E, 342D, 331I, 315A, 315H, 313, 322A, M313A, M313B, M331D, M331E, M331F, M331G, M331H, M331I, 331J, 342G, 341A, 341B, 341C, 341F, M341B, M341C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus edulis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus monosperma'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Quercus gambelii'},
        {'species': 'Quercus grisea'}
    )

    def match(plot):
        logging.debug('%s|NODE=092|Colorado Plateau Pinyon - Juniper Woodland (G900)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_093():

    """Intermountain Utah Juniper Open Woodland (G105)"""
    """G105"""
    level = 'group'
    code = 'G105'

    # i. Located in ECOREGION 313A, 313B, 313D, 322A, 341, 342B, 342J,
    # M331D, M331E, M341 and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Juniperus osteosperma (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
    # combination of Cercocarpus ledifolius, Juniperus californica,
    # Juniperus monosperma, Juniperus scopulorum or Quercus gambelii (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '313A, 313B, 313D, 322A, 341, 342B, 342J, M331D, M331E, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus osteosperma'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Cercocarpus ledifolius'},
        {'species': 'Juniperus californica'},
        {'species': 'Juniperus monosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Quercus gambelii'}
    )

    def match(plot):
        logging.debug('%s|NODE=093|Intermountain Utah Juniper Open Woodland (G105)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_094():

    """Southern Rocky Mountain Two-needle Pinyon-Juniper Woodland (M897)"""
    """M897"""
    level = 'macrogroup'
    code = 'M897'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315, 313, M313, 321, 342, M331, 341, 322, 
    # 331B, 331I, 331J, M341B, M341C
    # AND tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Juniperus monosperma or Pinus edulis (RIV=>20%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>10% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus scopulorum or
    # [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES]
    # (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315, 313, M313, 321, 342, M331, 341, 322, 331B, 331I, 331J, M341B, M341C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus monosperma'},
        {'species': 'Pinus edulis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus scopulorum'}
    )

    def match(plot):
        logging.debug('%s|NODE=094|Southern Rocky Mountain Two-needle Pinyon-Juniper Woodland (M897)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_095():

    """Southern Rocky Mountain Pinyon - Juniper Woodland (G253)"""
    """G253"""
    level = 'group'
    code = 'G253'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 321A, 315A, 315H, 315B, 313B, 313D, M313,
    # M331G, M331F, M331I, 331B, 331I, 331J
    # and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Pinus edulis
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus deppeana, Juniperus monosperma, Juniperus
    # scopulorum or Quercus gambelii (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '321A, 315A, 315H, 315B, 313B, 313D, M313, M331G, M331F, M331I, 331B, 331I, 331J'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus edulis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus monosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Quercus gambelii'}
    )

    def match(plot):
        logging.debug('%s|NODE=095|Southern Rocky Mountain Pinyon - Juniper Woodland (G253)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_096():

    """Southern Rocky Mountain Juniper Open Woodland (G252)"""
    """G252"""
    level = 'group'
    code = 'G252'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315A, 315B, 315H, 313B, 313D, M313, 321A,
    # M331G, M331F, 331B, 331J, 331I
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Juniperus monosperma (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus scopulorum (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315A, 315B, 315H, 313B, 313D, M313, 321A, M331G, M331F, 331B, 331J, 331I'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus monosperma'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus scopulorum'}
    )

    def match(plot):
        logging.debug('%s|NODE=096|Southern Rocky Mountain Juniper Open Woodland (G252)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_097():

    """Pacific Mountains Forest & Woodland Division (D339)"""
    """D339"""
    level = 'division'
    code = 'D339'

    # Tree composition and ecology matching one of the following options:
    # i.  Elevation less than 2400 meters and Located in ECOREGION 242, M242, M261, 261A, 262, 263, 341D
    # ii.  EITHER 
    #     d.  Tree composition dominated by one or more of STRONG diagnostic tree
    #     species Abies concolor, Abies grandis, Abies lasiocarpa, Abies magnifica,
    #     Abies shastensis [Abies magnifica var. shastensis], Abies procera, 
    #     Calocedrus decurrens, , Chrysolepis chrysophylla, Juniperus grandis, 
    #     Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monticola, 
    #     Quercus chrysolepis, Quercus garryana, Quercus kelloggii, 
    #     Sequoiadendron giganteum, Taxus brevifolia, or Umbellularia californica 
    #     (=>20% RIV) 
    #     OR 
    #     e.  The above tree species, but with =>10% RIV AND other MODERATE 
    #     diagnostic species, any combination of Abies bracteata, Acer circinatum, Acer macrophyllum, 
    #     Arbutus menziesii, Cornus nuttallii, Frangula purshiana, Picea breweriana, 
    #     Pinus coulteri, Pinus flexilis, Pinus lambertiana, Pinus muricata, 
    #     Pinus washoensis, Populus balsamifera ssp. trichocarpa, 
    #     Pseudotsuga macrocarpa (>=40% RIV; i.e., together STRONG and MODERATE 
    #     diagnostic species =>50% RIV) 
    #     OR 
    #     f.  Any EXOTIC = yes tree species =>80% RIV 
    # OR 
    #   M242C and M242D Exclusion/Exception for Pinus contorta, Pinus ponderosa, and 
    #   Pseudotsuga menziesii: Tree composition and ecology matching one of the 
    #   following options: 
    #   iii.  Located in ECOREGION 242, M242A, M242B, M261, 261A, 262, 263, 341D 
    #   AND 
    #   iv.  EITHER 
    #       a.  Tree composition dominated by one or more of STRONG diagnostic tree 
    #           species Abies concolor, Abies grandis, Abies lasiocarpa, Abies magnifica, Abies shastensis [Abies magnifica var. shastensis], Abies procera, Calocedrus decurrens, , Chrysolepis chrysophylla, Juniperus occidentalis, Notholithocarpus densiflorus, Pinus jeffreyi, Pinus monticola, Quercus chrysolepis, Quercus garryana, Quercus kelloggii, Sequoiadendron giganteum, Taxus brevifolia, or Umbellularia californica (=>20% RIV) 
    #       OR 
    #       b.  The above tree species, but with =>10% RIV AND other MODERATE 
    #           diagnostic species, any combination of Abies bracteata, Abies concolor var. lowiana, Acer circinatum, Acer macrophyllum, Arbutus menziesii, Cornus nuttallii, Frangula purshiana, Picea breweriana, Pinus coulteri, Pinus flexilis, Pinus lambertiana, Pinus muricata, Pinus washoensis, Populus balsamifera ssp. trichocarpa, Pseudotsuga macrocarpa (>=40% RIV; i.e., together STRONG and 
    #           MODERATE diagnostic species =>50% RIV) 
    #       OR 
    #       d.  Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS_I = PatternList('ECOREGIONS_I',
        {'ecoregion': '242, M242, M261, 261A, 262, 263, 341D'}
    )

    STRONG_DIAGNOSTIC_SPECIES_I = PatternList('STRONG_DIAGNOSTIC_SPECIES_I',
        {'species': 'Abies concolor'},
        {'species': 'Abies grandis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies magnifica'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Abies procera'},
        {'species': 'Calocedrus decurrens'},
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus monticola'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus garryana'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Sequoiadendron giganteum'},
        {'species': 'Taxus brevifolia'},
        {'species': 'Umbellularia californica'},
        {'species': 'Juniperus occidentalis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES_I = PatternList('MODERATE_DIAGNOSTIC_SPECIES_I',
        {'species': 'Abies bracteata'},
        {'species': 'Acer circinatum'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Arbutus menziesii'},
        {'species': 'Cornus nuttallii'},
        {'species': 'Frangula purshiana'},
        {'species': 'Picea breweriana'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus lambertiana'},
        {'species': 'Pinus muricata'},
        {'species': 'Pinus washoensis'},
        {'species': 'Populus balsamifera ssp. trichocarpa'},
        {'species': 'Pseudotsuga macrocarpa'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    ECOREGIONS_II = PatternList('ECOREGIONS_II',
        {'ecoregion': '242, M242A, M242B, M261, 261A, 262, 263, 341D'}
    )

    STRONG_DIAGNOSTIC_SPECIES_II = PatternList('STRONG_DIAGNOSTIC_SPECIES_II',
        {'species': 'Abies amabilis'},
        {'species': 'Abies concolor'},
        {'species': 'Abies grandis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies magnifica'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Abies procera'},
        {'species': 'Calocedrus decurrens'},
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Pinus contorta'},
        {'species': 'Picea sitchensis'},
        {'species': 'Pinus lambertiana'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus monticola'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus garryana'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Sequoiadendron giganteum'},
        {'species': 'Taxus brevifolia'},
        {'species': 'Umbellularia californica'},
        {'species': 'Juniperus occidentalis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES_II = PatternList('MODERATE_DIAGNOSTIC_SPECIES_II',
        {'species': 'Abies bracteata'},
        {'species': 'Acer circinatum'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Arbutus menziesii'},
        {'species': 'Cornus nuttallii'},
        {'species': 'Frangula purshiana'},
        {'species': 'Picea breweriana'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus muricata'},
        {'species': 'Pinus washoensis'},
        {'species': 'Populus balsamifera ssp. trichocarpa'},
        {'species': 'Pseudotsuga macrocarpa'}
    )

    def match(plot):
        logging.debug('%s|NODE=097|Pacific Mountains Forest & Woodland Division (D339)', plot.ident)
        result = (plot.get_elevation() < 2400 and plot.match(ECOREGIONS_I) and
               ((plot.riv(STRONG_DIAGNOSTIC_SPECIES_I) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES_I) >= 10 and 
               plot.riv(MODERATE_DIAGNOSTIC_SPECIES_I) >= 40) or 
               plot.riv(EXOTIC_TREE_SPP) >= 80)) or
               (plot.match(ECOREGIONS_II) and 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES_II) >= 10 and 
               plot.riv(MODERATE_DIAGNOSTIC_SPECIES_II) >= 40) or 
               plot.riv(EXOTIC_TREE_SPP) >= 80)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_098():

    """Southern Vancouverian Dry Foothill Forest & Woodland (M886)"""
    """M886"""
    level = 'macrogroup'
    code = 'M886'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242, 242, M261, 263, 262,
    # AND tree composition dominated by one or more of STRONG DRY
    # DIAGNOSTIC species Arbutus menziesii, Notholithocarpus densiflorus,
    # Chrysolepis chrysophylla, Pseudotsuga macrocarpa 
    # Pseudotsuga menziesii, or Quercus garryana (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies grandis, Acer macrophyllum,
    # Abies bracteata, Calocedrus decurrens, Chamaecyparis lawsoniana, Pinus coulteri 
    # Juniperus occidentalis, Juniperus scopulorum, Pinus contorta, Pinus ponderosa,
    # Quercus chrysolepis, Quercus kelloggii, Taxus brevifolia, or
    # Umbellularia californica
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242, 242, M261, 263, 262'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus menziesii'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus garryana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Abies bracteata'},
        {'species': 'Calocedrus decurrens'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Pinus coulteri'},
        {'species': 'Juniperus occidentalis'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus contorta'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Taxus brevifolia'},
        {'species': 'Umbellularia californica'},
        {'species': 'Pinus ponderosa'}
    )

    def match(plot):
        logging.debug('%s|NODE=098|Southern Vancouverian Dry Foothill Forest & Woodland (M886)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_099():

    """Cascadian Oregon White Oak - Conifer Forest & Woodland (G206)"""
    """G206"""
    level = 'group'
    code = 'G206'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 242B, 262A, 261A, 261B, 342H, M242D, M262A,
    # M242C, M261D, M242A, M261A, 263, M261G, M261B, 342I, M242B, 242A
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Quercus garryana (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Arbutus menziesii, Juniperus occidentalis,
    # Pinus ponderosa, Pseudotsuga menziesii,
    # Quercus chrysolepis, or Quercus kelloggii (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242B, 262A, 261A, 261B, 342H, M242D, M262A, M242C, M261D, M242A, M261A, 263, M261G, M261B, 342I, M242B, 242A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Quercus garryana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus menziesii'},
        {'species': 'Juniperus occidentalis'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus kelloggii'}
    )

    def match(plot):
        logging.debug('%s|NODE=099|Cascadian Oregon White Oak - Conifer Forest & Woodland (G206)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_100():

    """Californian Moist Coastal Mixed Evergreen Forest (G208)"""
    """G208"""
    level = 'group'
    code = 'G208'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 262A, M261C, M261E, 263, M242A, M261A, M261D,
    # M261F, M261B, M262, 261, M242B  and tree composition dominated by
    # one or more of STRONG DIAGNOSTIC species
    # Chrysolepis chrysophylla, Notholithocarpus densiflorus,
    # Pseudotsuga menziesii, Pseudotsuga macrocarpa, Quercus chrysolepis, or
    # Umbellularia californica (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies bracteata, Arbutus menziesii, Calocedrus decurrens,
    # Chamaecyparis lawsoniana, Pinus coulteri or Pinus ponderosa
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '262A, M261C, M261E, 263, M242A, M261A, M261D, M261F, M261B, M262, 261, M242B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Notholithocarpus densiflorus'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Umbellularia californica'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies bracteata'},
        {'species': 'Arbutus menziesii'},
        {'species': 'Calocedrus decurrens'},
        {'species': 'Chamaecyparis lawsoniana'},
        {'species': 'Pinus coulteri'},
        {'species': 'Pinus ponderosa'}
    )

    def match(plot):
        logging.debug('%s|NODE=100|Californian Moist Coastal Mixed Evergreen Forest (G208)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_101():

    """Southern Vancouverian Dry Douglas-fir - Madrone Woodland (G800)"""
    """G800"""
    level = 'group'
    code = 'G800'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 261A, 263A, M261D, M261B, M242B, M242A, M261A, 242
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Arbutus menziesii or Pseudotsuga menziesii
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies grandis, Acer macrophyllum, Juniperus scopulorum,
    # Pinus contorta, Quercus garryana, or Taxus brevifolia
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261A, 263A, M261D, M261B, M242B,  M242A, M261A, 242'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Arbutus menziesii'},
        {'species': 'Pseudotsuga menziesii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Acer macrophyllum'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus contorta'},
        {'species': 'Quercus garryana'},
        {'species': 'Taxus brevifolia'}
    )

    def match(plot):
        logging.debug('%s|NODE=101|Southern Vancouverian Dry Douglas-fir - Madrone Woodland (G800)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_102():

    """Southern Vancouverian Montane-Foothill Forest (M023)"""
    """M023"""
    level = 'macrogroup'
    code = 'M023'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M261, 262, 263, 341D,
    # AND tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Abies concolor [=var. lowiana],
    # Calocedrus decurrens, Pinus jeffreyi, Pinus lambertiana,
    # Pinus ponderosa, Quercus chrysolepis, or Sequoiadendron giganteum
    # (RIV=>20%),
    # [Additional tree species not tracked by FIA include Abies lowiana]
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>10% RIV AND with other MODERATE DIAGNOSTIC species in
    # any combination Abies magnifica, Abies shastensis [Abies magnifica
    # var. shastensis], Chrysolepis chrysophylla,
    # Picea breweriana, Pinus monticola, Pseudotsuga macrocarpa,
    # Pseudotsuga menziesii, Quercus kelloggii
    # Pinus washoensis and Pseudotsuga macrocarpa 
    # (>=40% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
    # [Additional tree species not tracked by FIA include Abies bracteata]

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M261, 262, 263, 341D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Calocedrus decurrens'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus lambertiana'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Sequoiadendron giganteum'},
        {'species': 'Abies concolor'},
        {'species': 'Quercus chrysolepis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies magnifica'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Picea breweriana'},
        {'species': 'Pinus monticola'},
        {'species': 'Pseudotsuga macrocarpa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Pinus washoensis'}
    )

    def match(plot):
        logging.debug('%s|NODE=102|Southern Vancouverian Montane-Foothill Forest (M023)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 10 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=40) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_103():

    """Californian Montane Conifer Forest & Woodland (G344)"""
    """G344"""
    level = 'group'
    code = 'G344'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 261B, 262A, 341E, 322A, M242A, 263, M261,
    # 341D, M242C, 342B, M262, M242B, 261A and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Abies concolor, Calocedrus decurrens, Pinus jeffreyi, Pinus lambertiana,
    # Pinus monticola, Pinus ponderosa, Pseudotsuga menziesii,
    # Quercus chrysolepis, Quercus kelloggii or Sequoiadendron giganteum
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies bracteata, Abies magnifica, Abies shastensis
    # [Abies magnifica var. shastensis], Chrysolepis chrysophylla,
    # Picea breweriana, Pinus washoensis, Pseudotsuga macrocarpa
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '261B, 262A, 341E, 322A, M242A, 263, M261, 341D, M242C, 342B, M262, M242B, 261A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Calocedrus decurrens'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus lambertiana'},
        {'species': 'Pinus monticola'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus chrysolepis'},
        {'species': 'Quercus kelloggii'},
        {'species': 'Sequoiadendron giganteum'},
        {'species': 'Abies concolor'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies bracteata'},
        {'species': 'Abies magnifica'},
        {'species': 'Abies shastensis'},
        {'species': 'Chrysolepis chrysophylla'},
        {'species': 'Picea breweriana'},
        {'species': 'Pinus washoensis'},
        {'species': 'Pseudotsuga macrocarpa'}
    )

    def match(plot):
        logging.debug('%s|NODE=103|Californian Montane Conifer Forest & Woodland (G344)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_104():

    """Vancouverian Ruderal Forest (M405)"""
    """M405"""
    level = 'macrogroup'
    code = 'M405'

    # Only one Macrogroup

    def match(plot):
        logging.debug('%s|NODE=104|Vancouverian Ruderal Forest (M405)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_105():

    """Vancouverian Ruderal Forest (G801)"""
    """G801"""
    level = 'group'
    code = 'G801'

    # 

    def match(plot):
        logging.debug('%s|NODE=105|Vancouverian Ruderal Forest (G801)', plot.ident)
        result = (True)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_106():

    """Rocky Mountain Foothills & Montane Forest & Woodland (D337)"""
    """D337"""
    level = 'division'
    code = 'D337'

    # Tree composition and ecology matching one of the following options:
    # i.  Elevation below 2800 meters and located in ECOREGION M242C,
    #     M242D – only eastern ecosubsections M242Dd, M242De, M242Df, M242Dg, M242Dh,
    #     313A, 313B, 313C, 313D, 315A, 315B, 315F, 315H, 321, M313, 322A, 331, M331,
    #     M332, M333, M334, 341, M341, 342   
    # AND
    # ii.  EITHER
    #     a.  Tree composition dominated by one or more of STRONG diagnostic tree
    #     species Abies concolor, Abies grandis, Abies lasiocarpa,
    #     Acer grandidentatum, Juniperus scopulorum, Larix lyallii,
    #     Larix occidentalis, Picea glauca, Picea pungens, Pinus contorta,
    #     Pinus flexilis, Pinus ponderosa, Pinus longaeva, Populus tremuloides, Pseudotsuga menziesii,
    #     Quercus gambelii, Thuja plicata,  or Tsuga heterophylla (=>50% RIV),
    #     [Additional species not tracked by FIA Picea engelmannii x glauca hybrids]
    #     OR
    #     b.  The above tree species, but with =>20% RIV AND other MODERATE
    #     diagnostic species any combination of Abies lasiocarpa var. arizonica,
    #     Abies lasiocarpa var. lasiocarpa, Acer negundo, Betula papyrifera,
    #     Fraxinus pennsylvanica, Juniperus deppeana, Juniperus osteosperma, Picea engelmannii,
    #    , Pinus edulis, Pinus monticola, Pinus strobiformis,
    #     Quercus macrocarpa, or Ulmus americana (>=30% RIV; i.e., together STRONG
    #     and MODERATE diagnostic species =>50% RIV) 
    #     OR
    #     c.  Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 313A, 313B, 313C, 313D, 315A, 315B, 315F, 315H, 321, M313, 322A, 331, M331, M332, M333, M334, 341, M341, 342'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Abies grandis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Acer grandidentatum'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Larix lyallii'},
        {'species': 'Larix occidentalis'},
        {'species': 'Picea pungens'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Quercus gambelii'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Picea glauca'},
        {'species': 'Pinus longaeva'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa var. arizonica'},
        {'species': 'Abies lasiocarpa var. lasiocarpa'},
        {'species': 'Acer negundo'},
        {'species': 'Betula papyrifera'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus osteosperma'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus monticola'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Ulmus americana'},
        {'species': 'Prunus virginiana'},
        {'species': 'Picea engelmannii'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=106|Rocky Mountain Foothills & Montane Forest & Woodland (D337)', plot.ident)
        result = (plot.get_elevation() < 2800 and plot.match(ECOREGIONS) and 
               ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and 
               plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or
               plot.riv(EXOTIC_TREE_SPP) >= 80)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_107():

    """Southern Rocky Mountain Lower Montane Forest (M022)"""
    """M022"""
    level = 'macrogroup'
    code = 'M022'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315A, 315B, 315F, 315H, 313A, 313B, 313C, 313D,
    # M313, 342J, 342G, 342E, 342F, M331D, M331F, M331G, M331H, M331E,
    # M331I, 331H, 331C, 331B, 331I, 331J, 341, M341, 322A,
    # AND tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Abies concolor, Acer grandidentatum, Juniperus scopulorum,
    # Pinus aristata, Pinus contorta, Pinus longaeva
    # Pinus ponderosa, Pinus strobiformis, Pseudotsuga menziesii,
    # Picea pungens, Populus tremuloides, or Quercus gambelii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies lasiocarpa var. arizonica,
    # Abies lasiocarpa var. lasiocarpa, Juniperus deppeana,
    # Picea engelmannii, Pinus edulis, Pinus flexilis,
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315A, 315B, 315F, 315H, 313A, 313B, 313C, 313D, M313, 342J, 342G, 342E, 342F, M331D, M331F, M331G, M331H, M331E, M331I, 331H, 331C, 331B, 331I, 331J, 341, M341, 322A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Acer grandidentatum'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus aristata'},
        {'species': 'Pinus longaeva'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Picea pungens'},
        {'species': 'Quercus gambelii'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pinus contorta'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa var. arizonica'},
        {'species': 'Abies lasiocarpa var. lasiocarpa'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus flexilis'}
    )

    def match(plot):
        logging.debug('%s|NODE=107|Southern Rocky Mountain Lower Montane Forest (M022)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_108():

    """Southern Rocky Mountain Bristlecone Pine Forest & Woodland (G102)"""
    """G102"""
    level = 'group'
    code = 'G102'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 342D, 342C, 313A, 313B, 313D, 322A, 331H,
    # 331I, 331J, 341, 342B, 342E, 342F, 342G, 342J, M261E, M331D, M331E,
    # M331F, M331G, M331H, M331I, M341
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Pinus longaeva (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
    # Abies concolor, Picea engelmannii,
    # Pinus contorta, Pinus flexilis,
    # Juniperus scopulorum, Pinus ponderosa
    # Pseudotsuga menziesii, or Populus tremuloides in any combination of
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '342D, 342C, 313A, 313B, 313D, 322A, 331H, 331I, 331J, 341, 342B, 342E, 342F, 342G, 342J, M261E, M331D, M331E, M331F, M331G, M331H, M331I, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus longaeva'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus flexilis'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=108|Southern Rocky Mountain Bristlecone Pine Forest & Woodland (G102)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_109():

    """Southern Rocky Mountain Mesic-Moist Mixed Conifer Forest (G225)"""
    """G225"""
    level = 'group'
    code = 'G225'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315A, 315H, 321A, 322A, 331B, 331G, 331J,
    # 331H, 331I, 341C, 341F, 341G, 342E, 342F, 342G, M341A, 313A, 313B,
    # 313C, M313, 342D, 342J, M331D, M331E, M331F, M331G, M331H, M331I,
    # M341B, M341C, 341A, 341B and tree composition dominated by one or
    # more of STRONG DIAGNOSTIC species Acer grandidentatum,
    # Abies concolor, Picea pungens or Pseudotsuga menziesii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Picea engelmannii,
    # Pinus ponderosa, or Populus tremuloides (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%) 

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315A, 315H, 321A, 322A, 331B, 331G, 331J, 331H, 331I, 341C, 341F, 341G, 342E, 342F, 342G, M341A, 313A, 313B, 313C, M313, 342D, 342J, M331D, M331E, M331F, M331G, M331H, M331I, M341B, M341C, 341A, 341B'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Acer grandidentatum'},
        {'species': 'Abies concolor'},
        {'species': 'Picea pungens'},
        {'species': 'Pseudotsuga menziesii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=109|Southern Rocky Mountain Mesic-Moist Mixed Conifer Forest (G225)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_110():

    """Southern Rocky Mountain Dry Mixed Conifer Forest & Woodland (G226)"""
    """G226"""
    level = 'group'
    code = 'G226'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 313D, 315A, 315B, 315H, 322B, 331F, 331G,
    # 331H, 341C, 342F, 342G, 313A, 313B, 313C, M313, 321A, 322A, 341A,
    # 341B, 341F, 342D, 342E, 342J, 331B, 331I, 331J, M331D, M331E, M331F,
    # M331G, M331H, M331I, M341
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Abies concolor, Populus tremuloides, or Pseudotsuga menziesii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies lasiocarpa,
    # Abies lasiocarpa var. arizonica, Juniperus scopulorum,
    # Picea engelmannii, Picea pungens, Pinus flexilis, Pinus ponderosa,
    #  (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '313D, 315A, 315B, 315H, 322B, 331F, 331G, 331H, 341C, 342F, 342G, 313A, 313B, 313C, M313, 321A, 322A, 341A, 341B, 341F, 342D, 342E, 342J, 331B, 331I, 331J, M331D, M331E, M331F, M331G, M331H, M331I, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Populus tremuloides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies lasiocarpa var. arizonica'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Picea engelmannii'},
        {'species': 'Picea pungens'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus ponderosa'}
    )

    def match(plot):
        logging.debug('%s|NODE=110|Southern Rocky Mountain Dry Mixed Conifer Forest & Woodland (G226)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_111():

    """Southern Rocky Mountain Ponderosa Pine Forest & Woodland (G103)"""
    """G103"""
    level = 'group'
    code = 'G103'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315F, 322B, 331C, 331N, 341A, 341C,
    # M331D, M331J, M341A, 313, 315A, 315B, 315H, 321A, 322A, M313,
    # 331B, 331F, 331G, 331H, 331I, 331J, 341B, 341F, 342A, 342E, 342F,
    # 342G, M331A, M331B, M331E, M331F, M331G, M331H, M331I, M341B, M341C
    # and tree composition dominated by the STRONG DIAGNOSTIC species
    # Pinus ponderosa or Quercus gambelii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Abies concolor, Juniperus deppeana, Juniperus scopulorum,
    # Pinus contorta, Pinus edulis, Pinus flexilis, Pinus longaeva,
    # Pinus strobiformis, Populus tremuloides, or Pseudotsuga menziesii
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species
    # RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315F, 322B, 331C, 331N, 341A, 341C, M331D, M331J, M341A, 313, 315A, 315B, 315H, 321A, 322A, M313, 331B, 331F, 331G, 331H, 331I, 331J, 341B, 341F, 342A, 342E, 342F, 342G, M331A, M331B, M331E, M331F, M331G, M331H, M331I, M341B, M341C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus ponderosa'},
        {'species': 'Quercus gambelii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Juniperus deppeana'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus edulis'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus longaeva'},
        {'species': 'Pinus strobiformis'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=111|Southern Rocky Mountain Ponderosa Pine Forest & Woodland (G103)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_112():

    """Central Rocky Mountain Dry Lower Montane-Foothill Forest (M501)"""
    """M501"""
    level = 'macrogroup'
    code = 'M501'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, M242D, M332, M333, 331N, 342H, 331M,
    # 342B, 331E, 331A, 331K, 342D, M331A, 342A, 331G, M331B, 342C, M334A,
    # 342F, M331J, M331D, 331D, 342I, 331L, 342G, 331F, M331E,
    # AND ASPECT is between 157 and 203
    # AND tree composition dominated
    # by one or more of STRONG DRY DIAGNOSTIC species
    # Juniperus osteosperma, Juniperus scopulorum, Picea glauca, Pinus contorta, Pinus ponderosa, Populus tremuloides, Pseudotsuga menziesii
    # Pinus flexilis(RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
    # combination of Acer negundo, Betula papyrifera,
    # Fraxinus pennsylvanica, Picea engelmannii, Quercus macrocarpa,
    # or Ulmus americana
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242D, M332, M333, 331N, 342H, 331M, 342B, 331E, 331A, 331K, 342D, M331A, 342A, 331G, M331B, 342C, M334A, 342F, M331J, M331D, 331D, 342I, 331L, 342G, 331F, M331E'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus osteosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Picea glauca'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pinus contorta'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Betula papyrifera'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Picea engelmannii'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Ulmus americana'}
    )

    def match(plot):
        logging.debug('%s|NODE=112|Central Rocky Mountain Dry Lower Montane-Foothill Forest (M501)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_113():

    """Central Rocky Mountain Montane White Spruce Forest (G345)"""
    """G345"""
    level = 'group'
    code = 'G345'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M334A and tree composition dominated by one
    # or more of STRONG DIAGNOSTIC species Picea glauca or Populus tremuloides (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
    # Abies lasiocarpa, Picea engelmannii, Pinus contorta,
    # Pinus ponderosa or Pseudotsuga menziesii in any
    # combination of (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M334A'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Picea glauca'},
        {'species': 'Populus tremuloides'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Picea engelmannii'}
    )

    def match(plot):
        logging.debug('%s|NODE=113|Central Rocky Mountain Montane White Spruce Forest (G345)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_114():

    """Black Hills-Northwestern Great Plains Ponderosa Pine Forest & Woodland (G216)"""
    """G216"""
    level = 'group'
    code = 'G216'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 331E, 331D, 331F, 331G, 331H, 331L, 331N,
    # 331M, 331K, M332Db, M332Dc, M331Ah, M331Ai, M331Ar, M331B, M334A,
    # 332D, 332C and tree
    # composition dominated by the STRONG DIAGNOSTIC species Pinus ponderosa
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Acer negundo, Betula papyrifera,
    # Fraxinus pennsylvanica, Juniperus scopulorum, Populus tremuloides,
    # Quercus macrocarpa, or Ulmus americana (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)
    # AND
    # iii. Located in above ECOREGION, and tree composition as above, but
    # with Pseudotsuga menziesii (<=1% RIV)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '331E, 331D, 331F, 331G, 331H, 331L, 331N, 331M, 331K, M332Db, M332Dc, M331Ah, M331Ai, M331Ar, M331B, M334A, 332D, 332C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus ponderosa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Acer negundo'},
        {'species': 'Betula papyrifera'},
        {'species': 'Fraxinus pennsylvanica'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Populus tremuloides'},
        {'species': 'Quercus macrocarpa'},
        {'species': 'Ulmus americana'}
    )

    PSME = PatternList('PSME',
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=114|Black Hills-Northwestern Great Plains Ponderosa Pine Forest & Woodland (G216)', plot.ident)
        result = ((plot.match(ECOREGIONS) and plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50) or 
               (plot.match(ECOREGIONS) and plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) and 
               (plot.match(ECOREGIONS) and plot.riv(PSME) <= 1))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_115():

    """Rocky Mountain Foothill-Rock Outcrop Limber Pine - Juniper Woodland (G209)"""
    """G209"""
    level = 'group'
    code = 'G209'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M332A, M332B, M332E, M332F, M333C, M334A,
    # 341A, 341B, 342D, 331B, 331D, 331F, 331G, 331K, 331N, M332D, 342A,
    # 342E, 342F, 342G, M331A, M331B, M331D, M331E, M331H, M331I, M331J
    # and tree composition dominated by one
    # or more of STRONG DIAGNOSTIC species Juniperus osteosperma,
    # Juniperus scopulorum or Pinus flexilis (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of [PLACEHOLDER - INSERT P2 VEG] (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M332A, M332B, M332E, M332F, M333C, M334A, 341A, 341B, 342D, 331B, 331D, 331F, 331G, 331K, 331N, M332D, 342A, 342E, 342F, 342G, M331A, M331B, M331D, M331E, M331H, M331I, M331J'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus osteosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Pinus flexilis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'PLACEHOLDER - INSERT P2 VEG'}
    )

    def match(plot):
        logging.debug('%s|NODE=115|Rocky Mountain Foothill-Rock Outcrop Limber Pine - Juniper Woodland (G209)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_116():

    """Central Rocky Mountain Ponderosa Pine Forest & Woodland (G213)"""
    """G213"""
    level = 'group'
    code = 'G213'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M261G, 331D, 342A, 342B, 342F, 342G, M331J,
    # M242C, M242D - only eastern ecosubsections M242Dd, M242De, M242Df,
    # M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332,
    # M333, M331A, M331B, M331D and tree
    # composition dominated by the STRONG DIAGNOSTIC species
    # Pinus ponderosa (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Pinus flexilis (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)
    # AND
    # iii. Located in above ECOREGION, and tree composition as above, but
    # with Pseudotsuga menziesii (<=10% RIV)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M261G, 331D, 342A, 342B, 342F, 342G, M331J, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332, M333, M331A, M331B, M331D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus ponderosa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus flexilis'}
    )

    PSME = PatternList('PSME',
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=116|Central Rocky Mountain Ponderosa Pine Forest & Woodland (G213)', plot.ident)
        result = ((plot.match(ECOREGIONS) and plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50) or 
               (plot.match(ECOREGIONS) and plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) and 
               (plot.match(ECOREGIONS) and plot.riv(PSME) <= 10))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_117():

    """Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)"""
    """G210"""
    level = 'group'
    code = 'G210'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M261G, 331D, 342A, 342B, 342F, 342G, M331J,
    # M242C, M242D - only eastern ecosubsections M242Dd, M242De, M242Df,
    # M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332,
    # M333, M331A, M331B, M331D and tree composition dominated by one or
    # more of STRONG DIAGNOSTIC species Pinus contorta, Pinus ponderosa, Picea engelmannii, or
    # Pseudotsuga menziesii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Larix occidentalis`, Pinus monticola,
    # or Picea glauca (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M261G, 331D, 342A, 342B, 342F, 342G, M331J, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331G, 331K, 331N, 342C, 342D, 342H, 342I, M332, M333, M331A, M331B, M331D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus contorta'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Larix occidentalis'},
        {'species': 'Pinus monticola'},
        {'species': 'Picea glauca'}
    )

    def match(plot):
        logging.debug('%s|NODE=117|Central Rocky Mountain Dry Mixed Conifer Forest & Woodland (G210)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_118():

    """Central Rocky Mountain Mesic-Moist Mixed Conifer Forest (G215)"""
    """G215"""
    level = 'group'
    code = 'G215'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 331A, 331E, 331F, 331M, M331E, M332G, M333C,
    # M333D, 331D, 331G, 331K, 331L, 331N, 342A, 342D, 342E, 342F, 342G,
    # M332A, M332B, M332D, M332E, M332F, M331A, M331B, M331D, M331J
    # and tree composition
    # dominated by the STRONG DIAGNOSTIC species Pinus contorta, Pseudotsuga menziesii or Populus tremuloides
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Juniperus osteosperma, Juniperus scopulorum, Picea engelmannii, or Pinus flexilis (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '331A, 331E, 331F, 331M, M331E, M332G, M333C, M333D, 331D, 331G, 331K, 331L, 331N, 342A, 342D, 342E, 342F, 342G, M332A, M332B, M332D, M332E, M332F, M331A, M331B, M331D, M331J'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pinus contorta'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus osteosperma'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus flexilis'}
    )

    def match(plot):
        logging.debug('%s|NODE=118|Central Rocky Mountain Mesic-Moist Mixed Conifer Forest (G215)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_119():

    """Central Rocky Mountain Mesic Lower Montane Forest (M500)"""
    """M500"""
    level = 'macrogroup'
    code = 'M500'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, M242D, 331N, 342H, M332, M333, 331A,
    # 331K, 342D, M331A, M331B, 342A, 331G, 342F, M331J, M331D, 331D,
    # 342I, 342G, AND tree composition
    # dominated by one or more of STRONG MESIC DIAGNOSTIC species
    # Abies grandis, Larix occidentalis, Pseudotsuga menziesii,
    # Thuja plicata, or Tsuga heterophylla (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC species
    # in any combination of Abies lasiocarpa, Betula papyrifera,
    # Picea engelmannii, Picea glauca, Pinus contorta, Pinus monticola,
    # Pinus ponderosa, or Populus tremuloides
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%),
    # [Additional tree species not tracked by FIA include
    # Picea engelmannii x glauca]

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242D, 331N, 342H, M332, M333, 331A, 331K, 342D, M331A, M331B, 342A, 331G, 342F, M331J, M331D, 331D, 342I, 342G'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Larix occidentalis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Betula papyrifera'},
        {'species': 'Picea engelmannii'},
        {'species': 'Picea glauca'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus monticola'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=119|Central Rocky Mountain Mesic Lower Montane Forest (M500)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_120():

    """East Cascades Moist-Mesic Grand Fir - Douglas-fir Forest (G212)"""
    """G212"""
    level = 'group'
    code = 'G212'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M261D, M261E, M261G, 342H, 342I, M242C,
    # M242D - only eastern ecosubsections M242Dd, M242De, M242Df, M242Dg,
    # M242Dh and tree composition dominated
    # by one or more of STRONG MESIC DIAGNOSTIC species Abies grandis or
    # Pseudotsuga menziesii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE MESIC DIAGNOSTIC species in any
    # combination of Larix occidentalis, Pinus contorta, Pinus monticola,
    # Tsuga heterophylla or Thuja plicata (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M261D, M261E, M261G, 342H, 342I, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Pseudotsuga menziesii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Larix occidentalis'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus monticola'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Thuja plicata'}
    )

    def match(plot):
        logging.debug('%s|NODE=120|East Cascades Moist-Mesic Grand Fir - Douglas-fir Forest (G212)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_121():

    """Central Rocky Mountain-Interior Cedar - Hemlock Forest (G217)"""
    """G217"""
    level = 'group'
    code = 'G217'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, M332F, M332G, 331D, 342I, M333, 331A,
    # M332A, M332B, M242D - only eastern ecosubsections M242Dd, M242De,
    # M242Df, M242Dg, M242Dh and
    # tree composition dominated by the STRONG DIAGNOSTIC species
    # Tsuga heterophylla or Thuja plicata (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Abies grandis, Abies lasiocarpa, Larix occidentalis,
    # Picea engelmannii, Pinus contorta, Pinus monticola, Pinus ponderosa
    # or Pseudotsuga menziesii (>=30% RIV; i.e., together STRONG and
    # MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M332F, M332G, 331D, 342I, M333, 331A, M332A, M332B, M242Dd, M242De, M242Df, M242Dg, M242Dh'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Tsuga heterophylla'},
        {'species': 'Thuja plicata'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Larix occidentalis'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus monticola'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=121|Central Rocky Mountain-Interior Cedar - Hemlock Forest (G217)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_122():

    """Central Rocky Mountain-Interior Mesic Grand Fir - Douglas-fir - Western Larch Forest (G211)"""
    """G211"""
    level = 'group'
    code = 'G211'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, 331D, 331G, 331N, 342A, 342D, 342E,
    # 342F, 342G, 342I, M331J, M242D - only eastern ecosubsections M242Dd,
    # M242De, M242Df, M242Dg, M242Dh, 331A, 331K, 342H, M332, M331A, M331B,
    # M331D, M333 and tree
    # composition dominated by one or more of STRONG MESIC DIAGNOSTIC
    # species Abies grandis, Pseudotsuga menziesii, or Larix occidentalis
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE MESIC DIAGNOSTIC species in any
    # combination of Abies lasiocarpa, Picea engelmannii, Pinus contorta,
    # Pinus monticola, Thuja plicata or Tsuga heterophylla (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, 331D, 331G, 331N, 342A, 342D, 342E, 342F, 342G, 342I, M331J, M242Dd, M242De, M242Df, M242Dg, M242Dh, 331A, 331K, 342H, M332, M331A, M331B, M331D, M333'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies grandis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Larix occidentalis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus monticola'},
        {'species': 'Thuja plicata'},
        {'species': 'Tsuga heterophylla'}
    )

    def match(plot):
        logging.debug('%s|NODE=122|Central Rocky Mountain-Interior Mesic Grand Fir - Douglas-fir - Western Larch Forest (G211)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_123():

    """Western Cordilleran Subalpine-High Montane Forest & Woodland (D336)"""
    """D336"""
    level = 'division'
    code = 'D336'

    # Tree composition and ecology matching one of the following options:
    # i.  Elevation above 2100 meters and located in 242A, 242B, 242C, M242A, M242B, M242C,
    #   M242D, M261; 313A, 313B, 313C, M313, 315A, 315H, 321A, 322A, 322B, 331, M331,
    #   M332, M333, M334, 341, M341, 342
    # AND
    # ii.  EITHER
    #     d.  Tree composition dominated by one or more of STRONG diagnostic tree 
    #     species Abies amabilis, Abies concolor, Abies lasiocarpa, Abies magnifica, Abies procera, 
    #     Abies shastensis [Abies magnifica var. shastensis], Betula papyrifera, 
    #     Juniperus grandis, Larix lyallii Picea engelmannii, Pinus albicaulis, 
    #     Pinus contorta, Pinus flexilis, Populus tremuloides, Pseudotsuga menziesii, or Tsuga mertensiana  
    #     (=>50% RIV)
    #     OR
    #     e.  The above tree species, but with =>20% RIV AND other MODERATE diagnostic
    #     species of Callitropsis nootkatensis , Pinus balfouriana, Pinus flexilis,
    #     Pinus jeffreyi, Pinus monticola, or Tsuga heterophylla
    #     (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species =>50% RIV)
    #     OR
    #     f.  Any EXOTIC = yes tree species =>80% RIV

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242A, 242B, 242C, M242A, M242B, M242C, M242D, M261; 313A, 313B, 313C, M313, 315A, 315H, 321A, 322A, 322B, 331, M331, M332, M333, M334, 341, M341, 342'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies amabilis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies magnifica'},
        {'species': 'Abies procera'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Betula papyrifera'},
        {'species': 'Pinus flexilis'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus flexilis'},
        {'species': 'Populus tremuloides'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Picea engelmannii'},
        {'species': 'Juniperus occidentalis'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Abies concolor'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Pinus balfouriana'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus monticola'},
        {'species': 'Tsuga heterophylla'}
    )

    EXOTIC_TREE_SPP = PatternList('EXOTIC_TREE_SPP',
        {'exotic': 'yes'}
    )

    def match(plot):
        logging.debug('%s|NODE=123|Western Cordilleran Subalpine-High Montane Forest & Woodland (D336)', plot.ident)
        result = (plot.get_elevation() > 2100 and plot.match(ECOREGIONS) and 
               ((plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or 
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and 
               plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >= 30) or 
               plot.riv(EXOTIC_TREE_SPP) >= 80)))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_124():

    """Rocky Mountain Subalpine-High Montane Forest (M020)"""
    """M020"""
    level = 'macrogroup'
    code = 'M020'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh,
    # M333, M334, 331, M331, 342, M332, 313A,
    # 313B, M313, M341, 341, 322A, 315A, 315B, 315H, AND
    # tree composition dominated by one or more of STRONG DIAGNOSTIC species
    # Abies lasiocarpa, Larix lyallii, Picea engelmannii, Pinus albicaulis,
    # Pinus contorta, Pinus flexilis,
    # Betula papyrifera, Populus tremuloides, or Tsuga mertensiana (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above,
    # but with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies concolor, Juniperus scopulorum, Picea pungens,
    # Pinus ponderosa, or Pseudotsuga menziesii
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M333, M334, 331, M331, 342, M332, 313A, 313B, M313, M341, 341, 322A, 315A, 315B, 315H'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Larix lyallii'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus flexilis'},
        {'species': 'Betula papyrifera'},
        {'species': 'Populus tremuloides'},
        {'species': 'Tsuga mertensiana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Juniperus scopulorum'},
        {'species': 'Picea pungens'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=124|Rocky Mountain Subalpine-High Montane Forest (M020)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_125():

    """Rocky Mountain-Interior Subalpine-Montane Aspen Forest (G222)"""
    """G222"""
    level = 'group'
    code = 'G222'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 313C, 315A, 315H, 321A, 322A, 322B, M242B,
    # M261A, M261D, M242C, M242D – only eastern ecosubsections M242Dd,
    # M242De, M242Df, M242Dg, M242Dh, M261E, M261G, 313A, 313B, 331, 341,
    # 342, M332, M313, M331, M341, M333, M334
    # and tree composition dominated by one or more of STRONG DIAGNOSTIC
    # species Populus tremuloides or Betula papyrifera (RIV=>75%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '313C, 315A, 315H, 321A, 322A, 322B, M242B, M261A, M261D, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M261E, M261G, 313A, 313B, 331, 341, 342, M332, M313, M331, M341, M333, M334'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Populus tremuloides'},
        {'species': 'Betula papyrifera'}
    )

    def match(plot):
        logging.debug('%s|NODE=125|Rocky Mountain-Interior Subalpine-Montane Aspen Forest (G222)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 75)
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_126():

    """Rocky Mountain Subalpine Moist-Mesic Spruce - Fir Forest (G218)"""
    """G218"""
    level = 'group'
    code = 'G218'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 313A, 313B, 322A, M313, 341A, 341B, 341F,
    # 341G, 331A, 331B, 331D, 331G, 331H, 331I, 331J, 331K, M242C, M242D –
    # only eastern ecosubsections M242Dd, M242De, M242Df, M242Dg, M242Dh,
    # M261D, M332, M331, 342, M333, M341B, M341C
    # and tree composition dominated by one
    # or more of STRONG MESIC TO WET DIAGNOSTIC species Abies lasiocarpa or
    # Picea engelmannii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE MESIC TO WET DIAGNOSTIC species
    # in any combination of Populus tremuloides, Pseudotsuga menziesii or Tsuga mertensiana
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '313A, 313B, 322A, M313, 341A, 341B, 341F, 341G, 331A, 331B, 331D, 331G, 331H, 331I, 331J, 331K, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, M261D, M332, M331, 342, M333, M341B, M341C'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Picea engelmannii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Populus tremuloides'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=126|Rocky Mountain Subalpine Moist-Mesic Spruce - Fir Forest (G218)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_127():

    """Rocky Mountain Subalpine Dry-Mesic Spruce - Fir Forest (G219)"""
    """G219"""
    level = 'group'
    code = 'G219'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242B, M261D, M313B, 313C, 315H, 322A,
    # M242C, M242D – only eastern ecosubsections M242Dd, M242De, M242Df,
    # M242Dg, M242Dh, 313A, 313B, M313A, 342, 341, M331, 331, M332, M333,
    # M341 and tree composition dominated by one or more of STRONG DRY
    # TO MESIC DIAGNOSTIC species Abies lasiocarpa or Picea engelmannii
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DRY TO MESIC DIAGNOSTIC species
    # in any combination of Pinus contorta, Pseudotsuga menziesii, or Populus tremuloides
    # (>=30% RIV; i.e., together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242B, M261D, M313B, 313C, 315H, 322A, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 313A, 313B, M313A, 342, 341, M331, 331, M332, M333, M341'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Picea engelmannii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus contorta'},
        {'species': 'Populus tremuloides'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=127|Rocky Mountain Subalpine Dry-Mesic Spruce - Fir Forest (G219)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_128():

    """Rocky Mountain Lodgepole Pine Forest & Woodland (G220)"""
    """G220"""
    level = 'group'
    code = 'G220'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242B, 313B, 341B, M242C, M242D – only
    # eastern ecosubsections M242Dd, M242De, M242Df, M242Dg, M242Dh,
    # M332, M333, 342, M331, 331
    # and tree composition dominated by the STRONG DIAGNOSTIC species
    # Pinus contorta (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species of
    # Abies concolor, Abies lasiocarpa, Picea engelmannii, Pinus ponderosa,
    # Pseudotsuga menziesii, Populus tremuloides (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242B, 313B, 341B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh,  M332, M333, 342, M331, 331'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus contorta'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies concolor'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=128|Rocky Mountain Lodgepole Pine Forest & Woodland (G220)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_129():

    """Rocky Mountain Limber Pine Subalpine-Montane Woodland (G101)"""
    """G101"""
    level = 'group'
    code = 'G101'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 315A, 313A, 313B, 313C, 322A, 341B, 341G,
    # M313B, M333C, M261E, M313A, 331, M332, M331, M341, 342 and tree
    # composition dominated by one or more of STRONG DIAGNOSTIC species
    # Pinus flexilis (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species in any
    # combination of Juniperus scopulorum, Picea engelmannii,
    # Pinus contorta, Pinus ponderosa, Pseudotsuga menziesii,
    # Abies concolor, Pinus albicaulis, Pinus balfouriana,
    # Pinus monophylla, and Populus tremuloides (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '315A, 313A, 313B, 313C, 322A, 341B, 341G, M313B, M333C, M261E, M313A, 331, M332, M331, M341, 342'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus flexilis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Juniperus scopulorum'},
        {'species': 'Picea engelmannii'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus ponderosa'},
        {'species': 'Pseudotsuga menziesii'},
        {'species': 'Abies concolor'},
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus balfouriana'},
        {'species': 'Pinus monophylla'},
        {'species': 'Populus tremuloides'}
    )

    def match(plot):
        logging.debug('%s|NODE=129|Rocky Mountain Limber Pine Subalpine-Montane Woodland (G101)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_130():

    """Central Rocky Mountain Whitebark Pine - Subalpine Larch Forest & Woodland (G223)"""
    """G223"""
    level = 'group'
    code = 'G223'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 331A, 331D, 331K, 331N, M261G, M242B,
    # M242C, M242D – only eastern ecosubsections M242Dd, M242De, M242Df,
    # M242Dg, M242Dh, 341G, 342, M331A, M331B, M331D, M331J, M332, M333
    # and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Pinus albicaulis, Abies lasiocarpa, or
    # Larix lyallii (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV, AND with other MODERATE DIAGNOSTIC species
    # Picea engelmannii or Pseudotsuga menziesii in any combination of (>=30% RIV; i.e., together
    # STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '331A, 331D, 331K, 331N, M261G, M242B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 341G, 342, M331A, M331B, M331D, M331J, M332, M333'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus albicaulis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Larix lyallii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Picea engelmannii'},
        {'species': 'Pseudotsuga menziesii'}
    )

    def match(plot):
        logging.debug('%s|NODE=130|Central Rocky Mountain Whitebark Pine - Subalpine Larch Forest & Woodland (G223)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_131():

    """Vancouverian Subalpine-High Montane Forest (M025)"""
    """M025"""
    level = 'macrogroup'
    code = 'M025'

    # Plot location and tree composition are as follows:
    # STRONG DIAGNOSTICS RIV 50% or more
    # NO EXCLUSIONS
    # i. Located in ECOREGION M242A, M242B, M242C, M242Dd, M242De, M242Df, M242Dg,
    # M242Dh, 242, M261, 263, 341D, AND tree composition dominated by one or more of
    # STRONG MESIC DIAGNOSTIC species Abies amabilis, Abies magnifica, Abies shastensis,
    # Abies magnifica var. shastensis], Abies procera, Callitropsis nootkatensis,
    # Juniperus occidentalis, Pinus albicaulis, Pinus balfouriana, Pinus contorta,
    # Pinus monticola, or Tsuga mertensiana (RIV=>50%),
    # OR
    # STRONG DIAGNOSTICS RIV 20% or more + MODERATE DIAGNOSTICS RIV 30% or more
    # NO EXCLUSIONS
    # ii. Located in above ECOREGION, and tree composition as above, but with =>20% RIV,
    # AND with other MODERATE MESIC DIAGNOSTIC  species in any combination of
    # Pinus flexilis, Pinus jeffreyi or Tsuga heterophylla [PLACEHOLDER - INSERT P2
    # DIAGNOSTIC SPECIES] (>=30% RIV; i.e., together STRONG and MODERATE diagnostic
    # species RIV =>50%)
    # OR
    # M242Db, M242Dd, M242De, M242Df, M242Dg, M242Dh subsections Exclusion/Exception for
    # Abies lasiocarpa and  Picea engelmannii
    # Tree composition and ecology matching one of the following options:
    # iii. Located in ECOREGION M242A, M242B, M242C, M242Da, M242Db, 242, M261, 263, 341D,
    # AND
    # iv. EITHER
    # a. Tree composition dominated by one or more of STRONG MESIC DIAGNOSTIC species
    # Abies amabilis,  Abies lasiocarpa, Abies magnifica, Abies shastensis,
    # Abies magnifica var. shastensis, Abies procera, Callitropsis nootkatensis,
    # Juniperus occidentalis, Pinus albicaulis, Pinus balfouriana, Pinus contorta,
    # Pinus monticola, or Tsuga mertensiana (RIV=>50%),
    # OR
    # b. The above tree species, but with =>20% RIV, AND with other MODERATE MESIC DIAGNOSTIC
    # species in any combination of  Pinus flexilis, Pinus jeffreyi, Abies concolor or
    # Tsuga heterophylla [PLACEHOLDER - INSERT P2 DIAGNOSTIC SPECIES] (>=30% RIV; i.e.,
    # together STRONG and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS_1 = PatternList('ECOREGIONS_1',
        {'ecoregion': 'M242A, M242B, M242C, M242Dd, M242De, M242Df, M242Dg, M242Dh, 242, M261, 263, 341D'}
    )

    ECOREGIONS_2 = PatternList('ECOREGIONS_2',
        {'ecoregion': 'M242Db, M242A, M242B, M242C, M242Da, M242Db, 242, M261, 263, 341D'}
    )

    STRONG_DIAGNOSTIC_SPECIES_1 = PatternList('STRONG_DIAGNOSTIC_SPECIES_1',
        {'species': 'Abies amabilis'},
        {'species': 'Abies magnifica'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Abies procera'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus balfouriana'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus monticola'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Juniperus occidentalis'}
    )

    STRONG_DIAGNOSTIC_SPECIES_2 = PatternList('STRONG_DIAGNOSTIC_SPECIES_2',
        {'species': 'Abies amabilis'},
        {'species': 'Abies lasiocarpa'},
        {'species': 'Abies magnifica'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Abies procera'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus balfouriana'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus monticola'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Juniperus occidentalis'},
        {'species': 'Picea engelmannii'}
    )

    MODERATE_DIAGNOSTIC_SPECIES_1 = PatternList('MODERATE_DIAGNOSTIC_SPECIES_1',
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Tsuga heterophylla'}
    )

    MODERATE_DIAGNOSTIC_SPECIES_2 = PatternList('MODERATE_DIAGNOSTIC_SPECIES_2',
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Tsuga heterophylla'},
        {'species': 'Abies concolor'}
    )

    def match(plot):
        logging.debug('%s|NODE=131|Vancouverian Subalpine-High Montane Forest (M025)', plot.ident)
        result = ((plot.match(ECOREGIONS_1) and plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 50) or
               (plot.match(ECOREGIONS_1) and plot.riv(STRONG_DIAGNOSTIC_SPECIES_1) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES_1) >= 30) or
               (plot.match(ECOREGIONS_2) and plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 50) or
               (plot.match(ECOREGIONS_2) and plot.riv(STRONG_DIAGNOSTIC_SPECIES_2) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES_2) >= 30))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_132():

    """Sierra-Cascade Cold-Dry Subalpine Woodland (G243)"""
    """G243"""
    level = 'group'
    code = 'G243'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 342B, M242D, M242B, M242C, M261, 341D
    # and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Juniperus occidentalis, Pinus albicaulis, or
    # Pinus contorta (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies lasiocarpa, Pinus balfouriana, Pinus flexilis,
    # or Pinus monticola (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '342B, M242D, M242B, M242C, M261, 341D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus contorta'},
        {'species': 'Juniperus occidentalis'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Pinus balfouriana'},
        {'species': 'Pinus flexilis'},
        {'species': 'Pinus monticola'}
    )

    def match(plot):
        logging.debug('%s|NODE=132|Sierra-Cascade Cold-Dry Subalpine Woodland (G243)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_133():

    """Sierra-Cascade Red Fir - Mountain Hemlock Forest (G749)"""
    """G749"""
    level = 'group'
    code = 'G749'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION 242B, 342B, M242B, M242C, M261, 341D
    # and tree composition dominated by one or more of STRONG
    # DIAGNOSTIC species Abies magnifica, Abies shastensis [Abies
    # magnifica var. shastensis], Abies lasiocarpa, Abies procera, or Tsuga mertensiana
    # (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies concolor, Pinus albicaulis, Pinus contorta,
    # Pinus jeffreyi, or Pinus monticola (>=30% RIV; i.e., together STRONG
    # and MODERATE diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': '242B, 342B, M242B, M242C, M261, 341D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies magnifica'},
        {'species': 'Abies magnifica var. shastensis'},
        {'species': 'Abies procera'},
        {'species': 'Tsuga mertensiana'},
        {'species': 'Abies lasiocarpa'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Pinus albicaulis'},
        {'species': 'Pinus contorta'},
        {'species': 'Pinus jeffreyi'},
        {'species': 'Pinus monticola'},
        {'species': 'Abies concolor'}
    )

    def match(plot):
        logging.debug('%s|NODE=133|Sierra-Cascade Red Fir - Mountain Hemlock Forest (G749)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

def element_134():

    """North-Central Pacific Mountain Hemlock - Silver Fir Woodland (G849)"""
    """G849"""
    level = 'group'
    code = 'G849'

    # Plot location and tree composition are as follows:
    # i. Located in ECOREGION M242C, M261B, 242A, M242A, M242B, M242D
    # and tree composition dominated by one or more of
    # STRONG DIAGNOSTIC species Abies amabilis, Picea engelmannii, or
    # Tsuga mertensiana (RIV=>50%),
    # OR
    # ii. Located in above ECOREGION, and tree composition as above, but
    # with =>20% RIV AND with other MODERATE DIAGNOSTIC species in any
    # combination of Abies lasiocarpa, Callitropsis nootkatensis,
    # or Tsuga heterophylla (>=30% RIV; i.e., together STRONG and MODERATE
    # diagnostic species RIV =>50%)

    ECOREGIONS = PatternList('ECOREGIONS',
        {'ecoregion': 'M242C, M261B, 242A, M242A, M242B, M242D'}
    )

    STRONG_DIAGNOSTIC_SPECIES = PatternList('STRONG_DIAGNOSTIC_SPECIES',
        {'species': 'Abies amabilis'},
        {'species': 'Picea engelmannii'},
        {'species': 'Tsuga mertensiana'}
    )

    MODERATE_DIAGNOSTIC_SPECIES = PatternList('MODERATE_DIAGNOSTIC_SPECIES',
        {'species': 'Abies lasiocarpa'},
        {'species': 'Callitropsis nootkatensis'},
        {'species': 'Tsuga heterophylla'}
    )

    def match(plot):
        logging.debug('%s|NODE=134|North-Central Pacific Mountain Hemlock - Silver Fir Woodland (G849)', plot.ident)
        result = (plot.match(ECOREGIONS) and 
               ( plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 50 or
               (plot.riv(STRONG_DIAGNOSTIC_SPECIES) >= 20 and plot.riv(MODERATE_DIAGNOSTIC_SPECIES) >=30) ))
        logging.debug('%s|RESULT|%s', plot.ident, result)
        return result
    return level, code, match

