'''
Created on May 1, 2013

@author: knimerfro
@author: ctoney
- 2024-02-02 switch to read_sqlite()
'''

import sys
#sys.path.append("C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs")
sys.path.append("C:/ctoney/FIA/nvcs/git/nvcs-west/nvcs")

import key_western_us as classification_key
#import key_eastern_us as classification_key
#import key_alaska_us as classification_key
from classifier import Classifier
from plot_reader import read_sqlite, read_file
import logging
from time import process_time

def run(outfile, dbfile = None, plottbl = None, txtfile = None):

    print('Input file = %s' % (dbfile if dbfile is not None else txtfile))
    print('Output file = %s' % outfile)

    #Create NVC plot classification key
    classifier = Classifier(classification_key.ClassificationKey())
    
    logging.basicConfig(filename='C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/debug.log', filemode='w', level=logging.DEBUG) # or ERROR
    #Classify plots read from a sqlite db or text file
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
    import tester

    # sqlite-db input
    tester.run(outfile=r'C:\Users\kelvynmeyers\Documents\GitHub\FS-Enterprise\NVCS\nvcs-dev\nvcs_tester\run_output\west\nvcs_pnwrs_rmrs_2017.out',
               dbfile=r'C:\Users\kelvynmeyers\Documents\GitHub\FS-Enterprise\NVCS\nvcs-dev\nvcs_tester\run_input\west\sqllite_db\nvcs_west_test_data_2017.db',
               plottbl='NVCS_KEY_TEST_DATA')

    # # txt input
    # tester.run(outfile=r'C:\Users\kelvynmeyers\Documents\GitHub\FS-Enterprise\NVCS\nvcs-dev\nvcs_tester\run_output\east\nvcs_dataset_2009.out',
    #            txtfile=r'C:\Users\kelvynmeyers\Documents\GitHub\FS-Enterprise\NVCS\nvcs-dev\nvcs_tester\run_input\east\text_files\nvc-dataset-2009-MODIFIED.txt')
    pass
