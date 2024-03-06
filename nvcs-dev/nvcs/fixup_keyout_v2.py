'''
Created on Oct 31, 2021
v.2 Oct 26,2022

@author: ctoney
'''
import key_western_us
from classifier import Node
import sys
import ast
import csv

def usage():
    print()
    print("Usage: fixup_keyout.py <key output file> <out csv>")
    print()
    return

def fixup(key_outfile, out_csv):
    nvcskey = key_western_us.ClassificationKey()
    writer = csv.writer(open(out_csv, 'w', newline=''))
    header = ['ident','solution_id','solution_desc','solution_path','last_node','last_node_desc']
    header = header + ['soln_div_id','soln_div_desc','soln_mg_id','soln_mg_desc','soln_grp_id','soln_grp_desc']
    writer.writerow(header)
    with open(key_outfile, 'r') as f:
        line = f.readline().strip()
        while line:
            outrow = []
            key_result = line.split('\t')
            
            ident = key_result[0]
            solution_id = int(key_result[1])
            if solution_id == -1:
                solution_desc = 'unclassified'
            else:
                solution_desc = nvcskey.nodes[solution_id].description
            
            solution_path = ast.literal_eval(key_result[2])
            last_node = solution_path[-1]
            last_node_desc = nvcskey.nodes[last_node].description
            
            soln_div_id = -1
            soln_div_desc = 'unclassified'
            soln_mg_id = -1
            soln_mg_desc = 'unclassified'
            soln_grp_id = -1
            soln_grp_desc = 'unclassified'
            for id in solution_path:
                if soln_div_id == -1 and nvcskey.nodes[id].level == 'division':
                    soln_div_id = nvcskey.nodes[id].ident
                    soln_div_desc = nvcskey.nodes[id].description
                if soln_mg_id == -1 and nvcskey.nodes[id].level == 'macrogroup':
                    soln_mg_id = nvcskey.nodes[id].ident
                    soln_mg_desc = nvcskey.nodes[id].description
                if soln_grp_id == -1 and nvcskey.nodes[id].level == 'group':
                    soln_grp_id = nvcskey.nodes[id].ident
                    soln_grp_desc = nvcskey.nodes[id].description
            
            #print(ident, solution_id, solution_desc, solution_path, last_node, last_node_desc)
            outrow = [ident, solution_id, solution_desc, solution_path, last_node, last_node_desc]
            outrow = outrow + [soln_div_id, soln_div_desc, soln_mg_id, soln_mg_desc, soln_grp_id, soln_grp_desc]
            writer.writerow(outrow)
            line = f.readline().strip()


if __name__ == '__main__':
    if (len(sys.argv) != 3):
        usage()
        sys.exit()
    fixup(sys.argv[1], sys.argv[2])

