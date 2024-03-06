'''
Created on Mar 29, 2023

@author: ctoney
'''

import os
import json
from collections import Counter
import csv

configdir = "C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_config/western-us/v1.0/config"
outfile = "C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs/spp_from_json.csv"

def extract_spp(filters):
    spp = list()
    for k,v in filters.items():
        if isinstance(v, list):
            for i in v:
                try:
                    spp.append(i["species"])
                except KeyError:
                    continue
    return spp

spp_all = list()
nodedir = configdir + "/key-nodes/"
n = 0

for f in os.listdir(nodedir):
    if f.endswith(".json"):
        #print(f);
        node = json.load(open(nodedir + f,"r"))["node"]
        filters = node["filters"]
        spp_all += extract_spp(filters)
        n += 1

spp_count = dict(Counter(spp_all))
#print(spp_count)

with open(outfile, 'w', newline='') as csv_file:  
    writer = csv.writer(csv_file)
    writer.writerow(["species", "count"])
    for k,v in spp_count.items():
        writer.writerow([k, v])

print(str(n) + " JSON files processed.")
print("Output written to:")
print(outfile)
