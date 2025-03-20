'''
Created on Oct 31, 2021
v.2 Oct 26,2022

@author: ctoney
'''

import os
import sys
import inspect
import ast
import csv

# Update sys path for correct run-time importing
currDir = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
parentDir = os.path.dirname(currDir)
sys.path.append(parentDir)
sys.path.append(parentDir + "/nvcs")

from nvcs_tester import plot_io
from nvcs_builder import configuration
config = configuration.DebugConfig()
if config.target == config.westSection:
    import key_western_us as classification_key
elif config.target == config.eastSection:
    import key_eastern_us as classification_key
elif config.target == config.alaskaSection:
    import key_alaska_us as classification_key

def usage():
    print()
    print("Usage: fixup_keyout.py <key output file> <out csv>")
    print("Or use no arguments and rely on config files")
    print()
    return

def fixup(key_outfile, out_csv, out_db, out_db_tbl):
    nvcskey = classification_key.ClassificationKey()
    print(f"Attempting to read from file at: {key_outfile}")
    writer = csv.writer(open(out_csv, 'w', newline=''))
    header = ['ident','solution_id','solution_desc','solution_path','last_node','last_node_desc']
    header = header + ['soln_div_id','soln_div_desc','soln_mg_id','soln_mg_desc','soln_grp_id','soln_grp_desc']
    outRows = []
    writer.writerow(header)
    with open(key_outfile, mode='r', encoding='utf-8') as f:
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

            solution_path_str = key_result[2]
            solution_path = ast.literal_eval(solution_path_str)
            if len(solution_path) > 0:
                last_node = solution_path[-1]
                last_node_desc = nvcskey.nodes[last_node].description
            else:
                last_node = -1
                last_node_desc = "unclassified"
            
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
            outrow = [ident, solution_id, solution_desc, solution_path_str, last_node, last_node_desc]
            outrow = outrow + [soln_div_id, soln_div_desc, soln_mg_id, soln_mg_desc, soln_grp_id, soln_grp_desc]
            outRows.append(outrow)
            writer.writerow(outrow)
            line = f.readline().strip()

    print(f"Successfully wrote {len(outRows)} rows to: {out_csv}")
    plot_io.write_table_sqlite(out_db, out_db_tbl, outRows, header)

if __name__ == '__main__':
    if len(sys.argv) == 1:
        key_outfile = config.get(config.target, "Out_TesterResultsPath")
        out_csv = config.get(config.target, "Out_FixupCsvPath")
        out_db = config.get(config.target, "Out_FixupDbPath")
        out_db_tbl = config.get(config.target, "Out_FixupDbTable")
        fixup(key_outfile, out_csv, out_db, out_db_tbl)
    elif len(sys.argv) != 5:
        usage()
        sys.exit()
    else:
        fixup(sys.argv[1], sys.argv[2], sys.argsv[3], sys.argv[4])

