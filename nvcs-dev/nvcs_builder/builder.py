import json
import re
import os
import configuration

def _makevarcode(varname, alternatives):
    pattcode = [str(patts) for patts in alternatives]
    varcode = "    " + varname + " = PatternList('" + varname + "',\n        " + ",\n        ".join(pattcode) + "\n    )"
    return varcode

class ElementBuilder:
    def __init__(self, templatepath, elementpath):
        with open(templatepath, mode='r', encoding='utf-8') as handle:
            self.template = handle.read()
        with open(elementpath, mode='r', encoding='utf-8') as handle:    
            self.element = json.load(handle)['node']

    def build(self, ident):
        code = self.template
        code = code.replace('<%internalid%>', str(ident).rjust(3, '0'))
        code = code.replace('<%name%>', self.element['name'])
        code = code.replace('<%id%>', self.element['id']) 
        code = code.replace('<%level%>', self.element['level'])
        
        description = self.element['description']
        code = code.replace('<%description%>', '\n'.join(['    # ' + e for e in description]).lstrip())
       
        trigger = '\n'.join(self.element['trigger'])
        if trigger.lower() == 'true':
            trigger = 'True'
        elif trigger.lower() == 'false':
            trigger = 'False'
        else:
            trigger = re.sub(r'(elevation)\s*\(\s*\)', r'plot.get_\1()', trigger)
            trigger = re.sub(r'(match)\s*\(\s*([0-9a-zA-Z_]+)\s*\)', r'plot.\1(\2)', trigger)
            trigger = re.sub(r'(riv)\s*\(\s*([0-9a-zA-Z_]+)\s*\)', r'plot.\1(\2)', trigger)
            trigger = re.sub(r'(spcov)\s*\(\s*([0-9a-zA-Z_]+)\s*\)', r'plot.\1(\2)', trigger)
        spaces = re.findall(r' *return result', self.template)[0].count(' ') + 7
        trigger = trigger.replace('\n', '\n'.ljust(spaces))
        code = code.replace('<%trigger%>', trigger)
        
        filters = ('\n\n'.join([_makevarcode(varname, alternatives) for varname, alternatives in self.element['filters'].items()])).lstrip() if self.element.get('filters') else ''            
        code = code.replace('<%filters%>', filters)

        return code

class HierarchyBuilder:
    def __init__(self, hierarchy):
        self.count = 0
        self.internal_id_map = dict()
        self.nodes = [[seq+1, line.count('\t'), line.lstrip('\t').rstrip('\n')] for seq, line in enumerate(hierarchy)]
 
    def _get_internal_id(self, ident):
        internal_id = self.internal_id_map.get(ident)
        if internal_id:
            return internal_id
        else:
            self.count += 1
            self.internal_id_map[ident] = self.count
            return self.count
            
    def _get_parent(self, ident, level):
        if level == 0:
            parent = 0
        else:
            parent = max([i for i, l, d in self.nodes if i < ident and l == level - 1])
        return parent

    def build(self):
        nodeargs = [[i, self._get_parent(i, l), d] for i, l, d in self.nodes]
        code = "        " + "\n        ".join(["self.nodes[" + str(i).rjust(3) + "] = Node(" + str(i).rjust(3) + ", " + str(p).rjust(3) + ", element_" + str(self._get_internal_id(d)).rjust(3, '0') + "(), '" + d + "')" for i, p, d in nodeargs])
        return code
        
class KeyBuilder:
    def __init__(self, configdir, templatedir):
        self.configdir = configdir
        self.templatedir = templatedir
        self.template = open(self.templatedir + '/template-classification-key.py', 'r').read()
    
    def build(self):
        code = self.template
        #code = code.replace('<%version%>', self.configdir[-2:])
        
        hbuilder = HierarchyBuilder(open(self.configdir + '/key-hierarchy.txt', 'r'))
        hcode = hbuilder.build()
        code = code.replace('<%hierarchy%>', hcode)

        ncode_list = []
        for f in os.listdir(self.configdir + '/key-nodes'):
            if f.endswith('.json'):
                print(f);
                ebuilder = ElementBuilder(self.templatedir + '/template-element.py', self.configdir + '/key-nodes/' + f)
                internal_id = hbuilder.internal_id_map[ebuilder.element['name']]
                element = ebuilder.build(internal_id)
                ncode_list.append([internal_id, element])
        sorted_ncode_list = [code for internal_id, code in sorted(ncode_list, key=lambda e: e[0])]
        ncode = '\n\n'.join(sorted_ncode_list)
        code = code.replace('<%nodes%>', ncode)
        code = re.sub(r'\n\s+\n', r'\n\n', code)
        return code

if __name__ == '__main__':
    import builder

    config = configuration.DebugConfig()
    templatePath = config.get(config.base, "TemplatePath")
    configPath = config.get(config.target, "In_ConfigPath")
    keyPath = config.get(config.target, "Out_KeyPath")

    keybuilder = builder.KeyBuilder(configPath, templatePath)
    code = keybuilder.build()

    f = open(keyPath, 'w')
    f.write(code)
    f.close()
