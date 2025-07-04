import collections
from classifier import Node
from pattern import Pattern
from pattern import PatternList
import logging

class Plot:
    def __init__(self, ident, rscd, state, ecoregion, plantation, hydric, riverine, elevation, balive, fbcov, grcov, shcov, ttcov, ntcov, live_canopy_cvr_pct, afforestation_cd, land_cover_class_cd, trtcd1, trtcd2, trtcd3, trtyr1, trtyr2, trtyr3):
        self.attrs = dict()
        self.attrs['ident'] = str(ident if ident is not None else "")
        self.attrs['rscd'] = str(rscd if rscd is not None else "")
        self.attrs['state'] = str(state if state is not None else "")
        self.attrs['ecoregion'] = str(ecoregion if ecoregion is not None else "")
        self.attrs['plantation'] = str(plantation if plantation is not None else "")
        self.attrs['hydric'] = str(hydric if hydric is not None else "")
        self.attrs['riverine'] = str(riverine if riverine is not None else "")
        self.attrs['elevation'] = float(elevation if elevation is not None else 0)
        self.attrs['balive'] = float(balive if balive is not None else 0)
        self.attrs['fbcov'] = float(fbcov if fbcov is not None else 0)
        self.attrs['grcov'] = float(grcov if grcov is not None else 0)
        self.attrs['shcov'] = float(shcov if shcov is not None else 0)
        self.attrs['ttcov'] = float(ttcov if ttcov is not None else 0)
        self.attrs['ntcov'] = float(ntcov if ntcov is not None else 0)
        self.attrs['live_canopy_cvr_pct'] = float(live_canopy_cvr_pct if live_canopy_cvr_pct is not None else 0)
        self.attrs['afforestation_cd'] = str(afforestation_cd if afforestation_cd is not None else "")
        self.attrs['land_cover_class_cd'] = str(land_cover_class_cd if land_cover_class_cd is not None else "")
        self.attrs['trtcd1'] = str(trtcd1 if trtcd1 is not None else "")
        self.attrs['trtcd2'] = str(trtcd2 if trtcd2 is not None else "")
        self.attrs['trtcd3'] = str(trtcd3 if trtcd3 is not None else "")
        self.attrs['trtyr1'] = float(trtyr1 if trtyr1 is not None else 0)
        self.attrs['trtyr2'] = float(trtyr2 if trtyr2 is not None else 0)
        self.attrs['trtyr3'] = float(trtyr3 if trtyr3 is not None else 0)
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
            if tree.species == "": continue
            total_riv += tree.riv;
            if pattlist.match_any({k:d.get(k) for d in (self.attrs, tree.attrs) for k in d}):
                match_riv += tree.riv;
        if total_riv == 0.0:
            pct_riv = 0.0
        else:
            pct_riv = (match_riv / total_riv) * 100
        logging.debug('%s|riv()::%s|%.1f', self.ident, pattlist.label, pct_riv)
        return round(pct_riv, 3)
        
    def spcov(self, pattlist):
        match_spcov = 0.0
        for tree in self.trees:
            if tree.species == "": continue
            if pattlist.match_any({k:d.get(k) for d in (self.attrs, tree.attrs) for k in d}):
                match_spcov += tree.spcov;
        logging.debug('%s|spcov()::%s|%.1f', self.ident, pattlist.label, match_spcov)
        return round(match_spcov, 3)

    def get_elevation(self):
        logging.debug('%s|elevation()|%s', self.ident, self.elevation)
        return int(self.elevation)

    def get_balive(self):
        logging.debug('%s|balive()|%s', self.ident, self.balive)
        return float(self.balive)

    def get_fbcov(self):
        logging.debug('%s|fbcov()|%s', self.ident, self.fbcov)
        return float(self.fbcov)

    def get_grcov(self):
        logging.debug('%s|grcov()|%s', self.ident, self.grcov)
        return float(self.grcov)

    def get_shcov(self):
        logging.debug('%s|shcov()|%s', self.ident, self.shcov)
        return float(self.shcov)

    def get_ttcov(self):
        logging.debug('%s|ttcov()|%s', self.ident, self.ttcov)
        return float(self.ttcov)

    def get_ntcov(self):
        logging.debug('%s|ntcov()|%s', self.ident, self.ntcov)
        return float(self.ntcov)
    
    def get_live_canopy_cvr_pct(self):
        logging.debug('%s|live_canopy_cvr_pct()|%s', self.ident, self.live_canopy_cvr_pct)
        return float(self.live_canopy_cvr_pct)
    
    def get_trtyr1(self):
        logging.debug('%s|trtyr1()|%s', self.ident, self.trtyr1)
        return float(self.trtyr1)
    
    def get_trtyr2(self):
        logging.debug('%s|trtyr2()|%s', self.ident, self.trtyr2)
        return float(self.trtyr2)
    
    def get_trtyr3(self):
        logging.debug('%s|trtyr3()|%s', self.ident, self.trtyr3)
        return float(self.trtyr3)

    def __repr__(self):
        return "Plot(%r)" % (self.attrs)
    
class Tree:
    def __init__(self, species, riv, wetland, ruderal, exotic, softwoodhardwood, planted, tallytree, spcov):
        self.attrs = dict()
        self.attrs['species'] = str(species if species is not None else "")
        self.attrs['riv'] = float(riv if riv is not None else 0)
        self.attrs['wetland'] = str(wetland if wetland is not None else "")
        self.attrs['ruderal'] = str(ruderal if ruderal is not None else "")
        self.attrs['exotic'] = str(exotic if exotic is not None else "")
        self.attrs['softwoodhardwood'] = str(softwoodhardwood if softwoodhardwood is not None else "")
        self.attrs['planted'] = str(planted if planted is not None else "")
        self.attrs['tallytree'] = str(tallytree if tallytree is not None else "")
        self.attrs['spcov'] = float(spcov if spcov is not None else 0)

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
Pattern.register('afforestation_cd', Pattern)
Pattern.register('land_cover_class_cd', Pattern)
Pattern.register('trtcd1', Pattern)
Pattern.register('trtcd2', Pattern)
Pattern.register('trtcd3', Pattern)

class ClassificationKey:
    def __init__(self):
        self.nodes = collections.OrderedDict()
        self.root_node = self._setup()

    def _setup(self):
        self.nodes[  0] = Node(  0, None, ((lambda plot:True), "", ""), "")
<%hierarchy%>

        for ident, element in self.nodes.items():
            if (element.parent is not None):
                self.nodes[element.parent].children.append(self.nodes[ident])

        return self.nodes[0]

<%nodes%>
