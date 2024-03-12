'''
Created on May 1, 2013

@author: knimerfro
@author: ctoney
- 2024-02-02 switch to read_sqlite()
'''

import sys

sys.path.append(r"C:\Users\kelvynmeyers\Documents\GitHub\FS-Enterprise\NVCS\nvcs-dev")
from nvcs_builder import configuration
config = configuration.DebugConfig()

sys.path.append(r"C:\Users\kelvynmeyers\Documents\GitHub\FS-Enterprise\NVCS\nvcs-dev\nvcs")
if config.target == config.westSection:
    import key_western_us as classification_key
elif config.target == config.eastSection:
    import key_eastern_us as classification_key
elif config.target == config.alaskaSection:
    import key_alaska_us as classification_key

from classifier import Classifier
from plot_reader import read_sqlite, read_file
import logging
from time import process_time

def run(outfile, debugfile, dbfile = None, plottbl = None, txtfile = None):

    print('Input file = %s' % (dbfile if dbfile is not None else txtfile))
    print('Output file = %s' % outfile)

    #Create NVC plot classification key
    classifier = Classifier(classification_key.ClassificationKey())
    
    #Classify plots read from a sqlite db or text file
    logging.basicConfig(filename=debugfile, filemode='w', level=logging.DEBUG) # or ERROR
    with Timer() as t:
        with open(outfile, 'w') as f:
            plots = read_sqlite(dbfile, plottbl) if txtfile is None else read_file(txtfile)
            for plot in plots:
                solution = classifier.classify(plot)
                if solution.path[-1]:
                    f.write('{0}\t{1}\t{2}\n'.format(solution.obj.ident, solution.path[-1].ident, str([node.ident for node in solution.path])))
                else:
                    f.write('{0}\t{1}\t{2}\n'.format(solution.obj.ident, -1, str([node.ident for node in solution.path[:-1]])))
    print('Run took %.03f sec.' % t.interval)

class Timer:    
    def __enter__(self):
        self.start = process_time()
        return self

    def __exit__(self, *args):
        self.end = process_time()
        self.interval = self.end - self.start
               

if __name__ == '__main__':

    run(outfile=config.get(config.target, "Out_TesterResultsPath"),
        debugfile=config.get(config.target, "Out_DebugLogPath"),
        dbfile=config.get(config.target, "In_DbPath"),
        plottbl=config.get(config.target, "In_DbTable"),
        txtfile=config.get(config.target, "In_TxtPath"))

    pass
