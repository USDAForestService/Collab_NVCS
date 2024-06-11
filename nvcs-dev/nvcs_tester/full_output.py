import os
import sys
import inspect

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

'''
What should this output contain?

Chris' AccessDB Content:
    Tables:
        - FS_FIADB_REF_FOREST_TYPE
        - NVCS_ANALYTICAL_DATA_WEST_2017_VW
            - Jason's SQLite data but filtered down to just 2017 data
        - nvcs_pnwrs_rmrs_2017
            - Fixup_keyou_v2 output
        - ref_key_output_table
            - Metadata on the current iteration of the key
        - ref_nvcs_algorithm_node
            - Generated from /nvcs/export_node_table.py
            - Needs a -1 Unclassified added manually as the first row
    Queries:
        - analytical_data_w_key_output
        - count_cond_by_solution
        - count_cond_by_solution_v2
        - count_unclass_cond_by_last_node
        - qry_key_output_riv_0
        - qry_nvcs_analytical_cond_level
        - qry_nvcs_python_input_cond_level
    Notes:
        - We want all queries as views
        - IDENT can now be used for joining tables in queries instead of PLT_CN, CONDID, and CND_CN
        
Jason's SQLite Content:
    Tables:
        - NVCS_ANALYTICAL_TEST_DATA
            - Plot condition list with all analytical columns for every year
        - NVCS_KEY_TEST_DATA
            - Plot condition list with only necessary analytical columns for every year
        - REF_SPECIES_NVCS_WEST
            - Western species list

Potential SQLite Content:
    Tables:
        - NVCS_TEST_DATA_ANALYTICAL
            - NVCS_ANALYTICAL_TEST_DATA (via Jason's SQLite Content)
        - NVCS_TEST_DATA_BASIC
            - NVCS_KEY_TEST_DATA (via Jason's SQLite Content)
    Views:
        - 

'''
def generateFullOutput():
    return None


if __name__ == '__main__':
    exit()