'''
Created on Oct 31, 2021

@author: ctoney
'''

import key_western_us
from classifier import Node
import csv

out_csv = "./key_western_us_nodes.csv"

writer = csv.writer(open(out_csv, 'w', newline=''))
header = ['ident','parent','description','nvc_level','nvc_code']
writer.writerow(header)

nvcskey = key_western_us.ClassificationKey()
for node in nvcskey.nodes.values():
    if (node.ident > 0):
        #print(node.ident, node.parent, node.description)
        writer.writerow([node.ident, node.parent, node.description, node.level, node.code])
