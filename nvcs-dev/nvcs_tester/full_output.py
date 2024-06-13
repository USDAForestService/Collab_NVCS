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



'''
What should this output contain?

Chris' AccessDB Content:
    Tables:
        - FS_FIADB_REF_FOREST_TYPE
            - queried from FIADB?
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
        - NVCS_KEY_TEST_DATA_ALL
            - NVCS_KEY_TEST_DATA (via Jason's SQLite Content)
        - NVCS_ANALYTICAL_TEST_DATA_ALL
            - NVCS_ANALYTICAL_TEST_DATA (via Jason's SQLite Content)
        - REF_KEY_OUTPUT_TABLE
            - ref_key_output_table (manually-added like Chris' AccessDB content)
        - REF_NVCS_ALGORITHM_NODE
            - Via /nvcs/export_node_Table.py and a -1 Unclassified entry at the beginning
        - FS_FIADB_REF_FOREST_TYPE
            - Queried via FIADB?
            - Maybe we take output as CSV and manually write to SQLite until future updates to avoid querying FIADB
    Views:
        - NVCS_KEY_TEST_DATA_<year>_VW
        - NVCS_ANALYTICAL_TEST_DATA_<year>_VW
        - ANALYTICAL_DATA_W_KEY_OUTPUT_VW
        - COUNT_COND_BY_SOLUTION_VW
        - COUNT_COND_BY_SOLUTION_V2_VW
        - COUNT_UNCLASS_COND_BY_LAST_NODE_VW
        - QRY_KEY_OUTPUT_RIV_0_VW
        - QRY_NVCS_ANALYTICAL_COND_LEVEL_VW
        - QRY_NVCS_PYTHON_INPUT_COND_LEVEL_VW

CREATE VIEW NVCS_KEY_TEST_DATA_WEST_2017_VW 
AS 
SELECT IDENT, RSCD, STATEAB, ECOREGION, PLANTATION, HYDRIC, RIVERINE, ELEVATION,
       SPECIES, RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, TALLYTREE, SPCOV
FROM NVCS_KEY_TEST_DATA WHERE RSCD IN (22, 23, 26, 33) AND INVYR = 2017;
 
CREATE VIEW NVCS_ANALYTICAL_DATA_WEST_2017_VW 
AS 
SELECT *
FROM NVCS_ANALYTICAL_TEST_DATA WHERE RSCD IN (22, 23, 26, 33) AND INVYR = 2017

'''
def generateFullOutput(in_ClassificationKey, in_KeyTestData_db, in_KeyTestData_tbl, in_AnlyTestData_db, in_AnlyTestData_tbl, in_RefForestType_path, out_FullOutput_db):
    # Tables retrieved from SQLite Database inputs
    nvcs_key_test_data_rows = plot_io.query_sqlite(in_KeyTestData_db, f"SELECT * FROM {in_KeyTestData_tbl};")
    nvcs_analytical_test_data_rows = plot_io.query_sqlite(in_AnlyTestData_db, f"SELECT * FROM {in_AnlyTestData_tbl};")

    # Tables retrieved from local project directory

    # Tables created via code
    ref_nvcs_algorithm_node_rows = export_node_table(in_ClassificationKey)

def export_node_table(classification_key):
    rows = [
        ['ident', 'parent', 'description', 'nvc_level', 'nvc_code'],
        ['-1', '', 'unclassified', '', '']
    ]

    key = classification_key.ClassificationKey()
    for node in key.nodes.values():
        if (node.ident > 0):
            rows.append([node.ident, node.parent, node.description, node.level, node.code])

    return rows

def usage():
    print()
    print("Usage: full_output.py <stuff>")
    print("Or use no arguments and rely on config files")
    print()
    return

if __name__ == '__main__':
    if len(sys.argv) == 1:
        config = configuration.DebugConfig()
        
        if config.target == config.westSection:
            import key_western_us as classification_key
        elif config.target == config.eastSection:
            import key_eastern_us as classification_key
        elif config.target == config.alaskaSection:
            import key_alaska_us as classification_key

        in_KeyTest_db = config.get(config.target, "In_DbPath")
        in_KeyTest_tbl = config.get(config.target, "In_DbTable")

        # TODO: REMOVE
        plot_io.table_info_sqlite(in_KeyTest_db, in_KeyTest_tbl)
        exit()

        generateFullOutput(classification_key, in_KeyTest_db, in_KeyTest_tbl)
    elif len(sys.argv) == 4:
        classification_key = ""
        generateFullOutput()
    else:
        usage()