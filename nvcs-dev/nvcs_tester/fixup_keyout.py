'''
Created on Oct 31, 2021

@author: ctoney
'''
import sys
import ast
import csv

def usage():
    print()
    print("Usage: fixup_keyout.py <key hierarchy file> <key output file> <out csv>")
    print()
    return

def load_key(key_file):
    nodes = {}
    with open(key_file, 'r') as f:
        this_node = f.readline().strip()
        line = 1
        while this_node:
            #print(line, this_node)
            nodes[line] = this_node
            this_node = f.readline().strip()
            line += 1
    return nodes

def fixup(key_hierarchy, key_outfile, out_csv):
    nodes = load_key(key_hierarchy)
    writer = csv.writer(open(out_csv, 'w', newline=''))
    header = ['ident','solution_id','solution_desc','solution_path','last_node','last_node_desc']
    writer.writerow(header)
    with open(key_outfile, 'r') as f:
        line = f.readline().strip()
        while line:
            key_result = line.split('\t')
            ident = key_result[0]
            solution_id = int(key_result[1])
            if solution_id == -1:
                solution_desc = 'unclassified'
            else:
                solution_desc = nodes[solution_id]
            solution_path = key_result[2]
            last_node = ast.literal_eval(solution_path)[-1]
            last_node_desc = nodes[int(last_node)]
            #print(ident, solution_id, solution_desc, solution_path, last_node, last_node_desc)
            writer.writerow([ident, solution_id, solution_desc, solution_path, last_node, last_node_desc])
            line = f.readline().strip()


if __name__ == '__main__':
    if (len(sys.argv) != 4):
        usage()
        sys.exit()
    fixup(sys.argv[1], sys.argv[2], sys.argv[3])

