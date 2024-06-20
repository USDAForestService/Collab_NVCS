import os
import sys
import inspect
from datetime import date

# Update sys path for correct run-time importing
currDir = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
parentDir = os.path.dirname(currDir)
sys.path.append(parentDir)
sys.path.append(parentDir + "/nvcs")

from nvcs_tester import plot_io, fixup_keyout_v2
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
        - PYTHON_KEY_OUTPUT
            - nvcs_pnwrs_rmrs_2017 via Chris' output
            - Might wanna copy logic from fixup_keyout_v2 here
    
    Views:
        - PYTHON_KEY_INPUT_VW
        - NVCS_ANALYTICAL_TEST_DATA_<year>_VW
        - ANALYTICAL_DATA_W_KEY_OUTPUT_VW
        - COUNT_COND_BY_SOLUTION_VW
        - COUNT_COND_BY_SOLUTION_V2_VW
        - COUNT_UNCLASS_COND_BY_LAST_NODE_VW
        - QRY_KEY_OUTPUT_RIV_0_VW
            - Potentially refactoring or dropping

CREATE VIEW NVCS_KEY_TEST_DATA_WEST_2017_VW 
AS 
SELECT IDENT, RSCD, STATEAB, ECOREGION, PLANTATION, HYDRIC, RIVERINE, ELEVATION,
       SPECIES, RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, TALLYTREE, SPCOV
FROM NVCS_KEY_TEST_DATA WHERE RSCD IN (22, 23, 26, 33) AND INVYR = 2017;
 
CREATE VIEW NVCS_ANALYTICAL_DATA_WEST_2017_VW 
AS 
SELECT *
FROM NVCS_ANALYTICAL_TEST_DATA WHERE RSCD IN (22, 23, 26, 33) AND INVYR = 2017

TODO: Consider creating input views here, then running tester.py, and putting outputs into the SQLite
    all from within this script

'''
def generateFullOutput(in_ClassificationKey, in_KeyTestData, in_AnlyTestData, in_RefForestType, in_KeyOutput, out_FullOutput_db):
    # Prepare table containing unfiltered key input source
    nvcs_key_test_data_definition, nvcs_key_test_data_columns = plot_io.table_info_sqlite(
        in_KeyTestData['source'], in_KeyTestData['source_tbl_nm'], new_tbl=in_KeyTestData['new_tbl_nm'])
    nvcs_key_test_data_rows = plot_io.query_sqlite(
        in_KeyTestData['source'], f"SELECT * FROM {in_KeyTestData['source_tbl_nm']};")

    # Prepare table containing unfiltered analytical input source
    nvcs_analytical_test_data_definition, nvcs_analytical_test_data_columns = plot_io.table_info_sqlite(
        in_AnlyTestData['source'], in_AnlyTestData['source_tbl_nm'], new_tbl=in_AnlyTestData['new_tbl_nm'])
    nvcs_analytical_test_data_rows = plot_io.query_sqlite(
        in_AnlyTestData['source'], f"SELECT * FROM {in_AnlyTestData['source_tbl_nm']};")

    # Prepare table containing REF_FOREST_TYPE values
    fs_fiadb_ref_forest_type_definition = (
        f"CREATE TABLE '{in_RefForestType['new_tbl_nm']}' ("
        "'VALUE', 'MEANING', 'TYPGRPCD', 'MANUAL_START', 'MANUAL_END',"
        "'ALLOWED_IN_FIELD', 'CREATED_BY', 'CREATED_DATE', 'CREATED_IN_INSTANCE',"
        "'MODIFIED_BY', 'MODIFIED_DATE', 'MODIFIED_IN_INSTANCE')"
    )
    fs_fiadb_ref_forest_type_columns = ['VALUE', 'MEANING', 'TYPGRPCD', 'MANUAL_START', 'MANUAL_END',
                                        'ALLOWED_IN_FIELD', 'CREATED_BY', 'CREATED_DATE', 'CREATED_IN_INSTANCE',
                                        'MODIFIED_BY', 'MODIFIED_DATE', 'MODIFIED_IN_INSTANCE']
    fs_fiadb_ref_forest_type_rows = plot_io.read_csv(in_RefForestType["source"])

    # Prepare table containing NVCS classifications, IDs, and codes
    ref_nvcs_algorithm_node_definition = (
        "CREATE TABLE 'REF_NVCS_ALGORITHM_NODE' ("
        "'IDENT' INTEGER, 'PARENT' INTEGER, 'DESCRIPTION' VARCHAR(256), "
        "'NVC_LEVEL' VARCHAR(256), 'NVC_CODE' VARCHAR(256));"
    )
    ref_nvcs_algorithm_node_columns = ['IDENT', 'PARENT', 'DESCRIPTION', 'NVC_LEVEL', 'NVC_CODE']
    ref_nvcs_algorithm_node_rows = export_node_table(in_ClassificationKey)

    # Prepare table containing report metadata
    ref_key_output_table_definition = (
        "CREATE TABLE 'REF_KEY_OUTPUT_TABLE' ("
        "'TABLE_NAME' VARCHAR(256), 'CREATED_DATE' VARCHAR(256), "
        "'DESCRIPTION' VARCHAR(256));"
    )
    ref_key_output_table_columns = ['TABLE_NAME', 'CREATED_DATE', 'DESCRIPTION']
    ref_key_output_table_rows = [['python_input_vw', str(date.today()), 'Inventory year filtered, used as Python input']]

    # Prepare and create table containing classification output
    fixup_keyout_v2.fixup(in_KeyOutput["source"], in_KeyOutput["csv_output"], out_FullOutput_db, in_KeyOutput["new_tbl_nm"])

    # Create tables in output file
    plot_io.write_sqlite(out_FullOutput_db, in_KeyTestData['new_tbl_nm'], nvcs_key_test_data_rows,
                         nvcs_key_test_data_columns, nvcs_key_test_data_definition)
    plot_io.write_sqlite(out_FullOutput_db, in_AnlyTestData['new_tbl_nm'], nvcs_analytical_test_data_rows,
                         nvcs_analytical_test_data_columns, nvcs_analytical_test_data_definition)
    plot_io.write_sqlite(out_FullOutput_db, in_RefForestType['new_tbl_nm'], fs_fiadb_ref_forest_type_rows,
                         fs_fiadb_ref_forest_type_columns, fs_fiadb_ref_forest_type_definition)
    plot_io.write_sqlite(out_FullOutput_db, 'REF_NVCS_ALGORITHM_NODE', ref_nvcs_algorithm_node_rows,
                         ref_nvcs_algorithm_node_columns, ref_nvcs_algorithm_node_definition)
    plot_io.write_sqlite(out_FullOutput_db, "REF_KEY_OUTPUT_TABLE", ref_key_output_table_rows,
                         ref_key_output_table_columns, ref_key_output_table_definition)

    # Views created via code
    python_key_input_vw_definition = (
        "CREATE VIEW 'PYTHON_KEY_INPUT_VW' AS "
        "SELECT IDENT, RSCD, STATEAB, ECOREGION, PLANTATION, HYDRIC, RIVERINE, "
        "ELEVATION,SPECIES, RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, "
        f"TALLYTREE, SPCOV FROM {in_KeyTestData['new_tbl_nm']} "
        "WHERE RSCD IN (22, 23, 26, 33)  AND INVYR = 2017;"
    )

    nvcs_analytical_test_data_vw_definition = (
        "CREATE VIEW 'NVCS_ANALYTICAL_TEST_DATA_2017_VW' AS "
        "SELECT * FROM NVCS_ANALYTICAL_TEST_DATA_ALL "
        "WHERE RSCD IN (22, 23, 26, 33) AND INVYR = 2017"
    )

    analytical_data_w_key_output_yw_definition = (
        "CREATE VIEW 'ANALYTICAL_DATA_W_KEY_OUTPUT_VW' AS "
        "SELECT KEY_OUTPUT.ident, ANLY.PLT_CN, ANLY.INVYR, ANLY.RSCD, ANLY.STATECD, ANLY.STATEAB, KEY_OUTPUT.solution_desc, "
        "KEY_OUTPUT.last_node_desc, ANLY.ECOREGION, ANLY.EPA_ECO_REGION, ANLY.USACE_SWC, ANLY.PLANTATION, ANLY.HYDRIC, "
        "ANLY.RIVERINE, ANLY.ELEVATION, ANLY.PHYSCLCD, ANLY.TOPO_POSITION, ANLY.BALIVE, ANLY.ASPECT, ANLY.SLOPE, "
        "ANLY.FOR_TYPE, FFRFT.MEANING AS FOR_TYPE_NAME, ANLY.HAB_TYPE, ANLY.SYMBOL, ANLY.SPECIES, "
        "ANLY.RIV, ANLY.WETLAND, ANLY.RUDERAL, ANLY.EXOTIC, ANLY.SOFTWOODHARDWOOD, ANLY.PLANTED, ANLY.TALLYTREE, "
        "ANLY.SPCOV, ANLY.RIV_UNDERSTORY, ANLY.RIV_OVERSTORY, ANLY.LAYER_NUMBER, ANLY.FBCOV, ANLY.SHCOV, ANLY.GRCOV, "
        "ANLY.TTCOV, ANLY.NTCOV, ANLY.COVER_FB_LAYER1, ANLY.COVER_SH_LAYER1, ANLY.COVER_GR_LAYER1, ANLY.COVER_TT_LAYER1, "
        "ANLY.COVER_NT_LAYER1, ANLY.COVER_FB_LAYER2, ANLY.COVER_SH_LAYER2, ANLY.COVER_GR_LAYER2, ANLY.COVER_TT_LAYER2, "
        "ANLY.COVER_NT_LAYER2, ANLY.COVER_FB_LAYER3, ANLY.COVER_SH_LAYER3, ANLY.COVER_GR_LAYER3, ANLY.COVER_TT_LAYER3, "
        "ANLY.COVER_NT_LAYER3, ANLY.COVER_FB_LAYER4, ANLY.COVER_SH_LAYER4, ANLY.COVER_GR_LAYER4, ANLY.COVER_TT_LAYER4, "
        "ANLY.COVER_NT_LAYER4, ANLY.REL_DENSITY_SEEDLING, ANLY.UNADJ_FOR_COND, ANLY.NUM_FORCOND_PLOT "
        "FROM (PYTHON_KEY_OUTPUT AS 'KEY_OUTPUT' "
        "INNER JOIN NVCS_ANALYTICAL_TEST_DATA_2017_VW AS 'ANLY' ON KEY_OUTPUT.IDENT = ANLY.IDENT) "
        "INNER JOIN FS_FIADB_REF_FOREST_TYPE AS 'FFRFT' ON ANLY.FOR_TYPE = FFRFT.VALUE;"
    )

    count_cond_by_solution_vw_definition = (
        "CREATE VIEW 'COUNT_COND_BY_SOLUTION_VW' AS "
        "SELECT KEY_OUTPUT.solution_desc, KEY_OUTPUT.solution_id, "
        "Count(KEY_OUTPUT.ident) AS CountOfident FROM PYTHON_KEY_OUTPUT AS 'KEY_OUTPUT' "
        "GROUP BY KEY_OUTPUT.solution_desc, KEY_OUTPUT.solution_id "
        "ORDER BY Count(KEY_OUTPUT.ident) DESC;"
    )

    count_cond_by_solution_v2_vw_definition = (
        "CREATE VIEW 'COUNT_COND_BY_SOLUTION_VW_V2_VW' AS "
        "SELECT RNAN.ident AS node_id, RNAN.description, "
        "CCBS.CountOfident FROM REF_NVCS_ALGORITHM_NODE AS 'RNAN' "
        "LEFT JOIN COUNT_COND_BY_SOLUTION_VW as 'CCBS' ON CCBS.solution_id = RNAN.ident "
        "WHERE (((RNAN.nvc_level)='group' OR (RNAN.nvc_level)='unclassified')) "
        "ORDER BY RNAN.ident;"
    )

    count_unclass_cond_by_last_node_vw_definition = (
        "CREATE VIEW 'COUNT_UNCLASS_COND_BY_LAST_NODE_VW' AS "
        "SELECT KEY_OUTPUT.last_node_desc, Count(KEY_OUTPUT.ident) AS CountOfident "
        "FROM PYTHON_KEY_OUTPUT AS 'KEY_OUTPUT' WHERE (((KEY_OUTPUT.solution_id)=-1)) "
        "GROUP BY KEY_OUTPUT.last_node_desc ORDER BY Count(KEY_OUTPUT.ident) DESC;"
    )

    # Drop views (if exist) in output file
    drop_view_sql = "DROP VIEW IF EXISTS {0}"
    plot_io.execute_sqlite(out_FullOutput_db, drop_view_sql.format("PYTHON_KEY_INPUT_VW"))
    plot_io.execute_sqlite(out_FullOutput_db, drop_view_sql.format("NVCS_ANALYTICAL_TEST_DATA_2017_VW"))
    plot_io.execute_sqlite(out_FullOutput_db, drop_view_sql.format("ANALYTICAL_DATA_W_KEY_OUTPUT_VW"))
    plot_io.execute_sqlite(out_FullOutput_db, drop_view_sql.format("COUNT_COND_BY_SOLUTION_VW"))
    plot_io.execute_sqlite(out_FullOutput_db, drop_view_sql.format("COUNT_COND_BY_SOLUTION_V2_VW"))
    plot_io.execute_sqlite(out_FullOutput_db, drop_view_sql.format("COUNT_UNCLASS_COND_BY_LAST_NODE_VW"))

    # Create views in output file
    plot_io.execute_sqlite(out_FullOutput_db, python_key_input_vw_definition)
    plot_io.execute_sqlite(out_FullOutput_db, nvcs_analytical_test_data_vw_definition)
    plot_io.execute_sqlite(out_FullOutput_db, analytical_data_w_key_output_yw_definition)
    plot_io.execute_sqlite(out_FullOutput_db, count_cond_by_solution_vw_definition)
    plot_io.execute_sqlite(out_FullOutput_db, count_cond_by_solution_v2_vw_definition)
    plot_io.execute_sqlite(out_FullOutput_db, count_unclass_cond_by_last_node_vw_definition)


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
    print("Usage: Fill out ~/nvcs_config/debug_config.ini")
    print()
    return


if __name__ == '__main__':
    if len(sys.argv) != 1:
        usage()
        exit()

    config = configuration.DebugConfig()

    if config.target == config.westSection:
        import key_western_us as classification_key
    elif config.target == config.eastSection:
        import key_eastern_us as classification_key
    elif config.target == config.alaskaSection:
        import key_alaska_us as classification_key

    in_KeyTestDataInfo = {
        "source": config.get(config.target, "In_DbPath"),
        "source_tbl_nm": config.get(config.target, "In_DbTable"),
        "new_tbl_nm": "NVCS_KEY_TEST_DATA_ALL"
    }

    in_AnlyTestData = {
        "source": config.get(config.target, "In_AnlyDbPath"),
        "source_tbl_nm": config.get(config.target, "In_AnlyDbTable"),
        "new_tbl_nm": "NVCS_ANALYTICAL_TEST_DATA_ALL"
    }

    in_RefAlgNodes = {
        "source": config.get(config.target, "In_RefForestTypeDbPath"),
        "source_tbl_nm": None,
        "new_tbl_nm": "FS_FIADB_REF_FOREST_TYPE"
    }
    
    in_KeyOutput = {
        "source": config.get(config.target, "Out_TesterResultsPath"),
        "source_tbl_nm": None,
        "new_tbl_nm": "PYTHON_KEY_OUTPUT",
        "csv_output": config.get(config.target, "Out_FixupCsvPath")
    }

    out_FullOutput_db = config.get(config.target, "Out_FullOutputPath")

    generateFullOutput(classification_key, in_KeyTestDataInfo, in_AnlyTestData, in_RefAlgNodes, in_KeyOutput,
                       out_FullOutput_db)
