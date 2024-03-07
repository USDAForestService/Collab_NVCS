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
from plot_reader import read_sqlite
import logging
from time import process_time

def run(dbfile, plottbl, outfile):

    print('Input file = %s' % dbfile)
    print('Output file = %s' % outfile)

    #Create NVC plot classification key
    classifier = Classifier(classification_key.ClassificationKey())
    
    #Classify plots read from a text file
    logging.basicConfig(filename='C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/debug.log', filemode='w', level=logging.DEBUG) # or ERROR
    with Timer() as t:
        with open(outfile, 'w') as f:
            for plot in read_sqlite(dbfile, plottbl):
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
    #tester.run('C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_input/western-us-test-dataset-1.txt', 'C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/western-us-test-dataset-1.out')
    #tester.run('C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_input/nvcs_python_input_pnwrs_rmrs_2017_utf-8.txt', 'C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/nvcs_pnwrs_rmrs_2017.out')
    # new test dataset:
    #tester.run('C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_input/nvcs_key_test_data_2017_20240129.txt', 'C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/nvcs_pnwrs_rmrs_2017.out')
    # sqlite db
    tester.run('C:/ctoney/FIA/nvcs/rmrs-data/nvcs_west_test_data_2017.db', 'NVCS_KEY_TEST_DATA', 'C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/nvcs_pnwrs_rmrs_2017.out')
    #tester.run('C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_input/nvcs_key_test_data_2017_20230404.tsv', 'C:/ctoney/FIA/nvcs/nvcs-workspace/nvcs_west/nvcs_tester/run_output/nvcs_pnwrs_rmrs_2017_newdata.out')
    pass
