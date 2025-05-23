'''
Created on May 1, 2013

@author: knimerfro
@author: ctoney
- 2024-02-02 switch to read_sqlite()
'''

import os
import sys
import inspect

# Update sys path for correct run-time importing
currDir = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
parentDir = os.path.dirname(currDir)
sys.path.append(parentDir)
sys.path.append(parentDir + "/nvcs")

from classifier import Classifier
from plot_io import read_sqlite, read_file
import logging
from time import perf_counter

from nvcs_builder import configuration
config = configuration.DebugConfig()

if config.target == config.westSection:
    import key_western_us as classification_key
elif config.target == config.eastSection:
    import key_eastern_us as classification_key
elif config.target == config.alaskaSection:
    import key_alaska_us as classification_key

def run(type, outfile, debugfile, dbfile = None, plottbl = None, txtfile = None):

    print('Input file = %s' % (dbfile if dbfile is not None else txtfile))
    print('Output file = %s' % outfile)

    #Create NVC plot classification key
    classifier = Classifier(classification_key.ClassificationKey())
    
    #Classify plots read from a sqlite db or text file
    logging.basicConfig(filename=debugfile, filemode='w', level=logging.DEBUG) # or ERROR
    with Timer() as t:
        with open(outfile, mode='w', encoding='utf-8') as f:
            plots = read_sqlite(type, dbfile, plottbl) if txtfile is None else read_file(txtfile)
            for plot in plots:
                solution = classifier.classify(plot)
                if solution.path[-1]:
                    f.write('{0}\t{1}\t{2}\n'.format(solution.obj.ident, solution.path[-1].ident, str([node.ident for node in solution.path])))
                else:
                    f.write('{0}\t{1}\t{2}\n'.format(solution.obj.ident, -1, str([node.ident for node in solution.path[:-1]])))
    print('Run took %.03f sec.' % t.interval)

class Timer:    
    def __enter__(self):
        self.start = perf_counter()
        return self

    def __exit__(self, *args):
        self.end = perf_counter()
        self.interval = self.end - self.start
               

if __name__ == '__main__':

    run(type=config.target,
        outfile=config.get(config.target, "Out_TesterResultsPath"),
        debugfile=config.get(config.target, "Out_DebugLogPath"),
        dbfile=config.get(config.target, "In_DbPath"),
        plottbl=config.get(config.target, "In_DbTable"))

    pass
