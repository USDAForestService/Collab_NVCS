import collections
from classifier import Node
from pattern import Pattern
from pattern import PatternList
import logging

class Plot:
    def __init__(self, ident, rscd, state, ecoregion, plantation, hydric, riverine, elevation, balive, fbcov, grcov, shcov, ttcov, ntcov):
        self.attrs = dict()
        self.attrs['ident'] = ident
        self.attrs['rscd'] = rscd
        self.attrs['state'] = state
        self.attrs['ecoregion'] = ecoregion
        self.attrs['plantation'] = plantation
        self.attrs['hydric'] = hydric
        self.attrs['riverine'] = riverine
        self.attrs['elevation'] = float(elevation)
        self.attrs['balive'] = float(balive)
        self.attrs['fbcov'] = float(fbcov or 0)
        self.attrs['grcov'] = float(grcov or 0)
        self.attrs['shcov'] = float(shcov or 0)
        self.attrs['ttcov'] = float(ttcov or 0)
        self.attrs['ntcov'] = float(ntcov or 0)
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
<%hierarchy%>

        for ident, element in self.nodes.items():
            if (element.parent is not None):
                self.nodes[element.parent].children.append(self.nodes[ident])

        return self.nodes[0]

<%nodes%>
