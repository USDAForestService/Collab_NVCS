'''
Created on Mar 15, 2013

@author: knimerfro
'''

class Pattern:
    attrpatts = dict()
    
    @classmethod
    def register(cls, attr, pattcls):
        Pattern.attrpatts[attr] = pattcls
        
    def __init__(self, expr):
        if (not expr):
            raise RuntimeError("Pattern is empty")
        else:
            self.negated = expr.lstrip().startswith('!')
            self.pattern = [s.strip() for s in expr.lstrip(' !').split(',')]
        
    def match(self, value):
        #print("match:", self, value)
        if (self.negated):
            #print("   result=", not value in self.pattern)
            return not value in self.pattern
        else:
            #print("   result=", value in self.pattern)
            return value in self.pattern
            
    def __repr__(self):
        return "Pattern(%r, %r)" % ('!' if self.negated else ' ', self.pattern)

class PatternGroup:
    def __init__(self, pattgrp):
        self.pattgrp = dict()
        for attr in pattgrp.keys():
            self.pattgrp[attr] = Pattern.attrpatts[attr](pattgrp[attr])
    
    def match_all(self, valugrp):
        result = True
        for attr in self.pattgrp.keys():
            #print("match_all:", attr, self.pattgrp[attr], valugrp[attr])
            if (not self.pattgrp[attr].match(valugrp[attr])):
                result = False
                break
        return result

    def __repr__(self):
        return "PatternGroup(%r)" % (self.pattgrp)

class PatternList:
    def __init__(self, label, *pattgrps):
        if (not pattgrps):
            raise RuntimeError("PatternList is empty")
        self.label = label
        self.alternatives = [PatternGroup(pattgrp) for pattgrp in pattgrps]
        
    def match_any(self, valugrp):
        #print("match_any:", valugrp)
        if (not self.alternatives):
            result = True
        else:
            result = False
            for patterngroup in self.alternatives:
                if (patterngroup.match_all(valugrp)):
                    result = True
                    break
        return result
    
    def __repr__(self):
        return "PatternList(%r, %r)" % (self.label, self.alternatives)
