import os
import sys
import inspect
import datetime

# Update sys path for correct run-time importing
currDir = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
parentDir = os.path.dirname(currDir)
sys.path.append(parentDir)
sys.path.append(parentDir + "/nvcs")

from nvcs_tester import plot_io, fixup_keyout_v2, tester
from nvcs_builder import configuration

# Script variables
ref_key_output_table_columns = ['TABLE_NAME', 'CREATED_DATE', 'DESCRIPTION']

def generateFullOutput(in_ClassificationKey, in_KeyTestData, in_AnlyTestData, in_RefForestType, in_RefAlgNode, in_RefKeyOutput, in_KeyOutput, out_Options):
    if out_Options["skip_shared_tables"]:
        print("-" * 50)
        print("Skipping shared table and view generation")
    else:
        # Announce generation of shared tables/views
        print("-" * 50)
        print("Generating shared tables and views\n")

        # Prepare & create table containing report metadata
        ref_key_output_table_definition = (
            f"CREATE TABLE '{in_RefKeyOutput['new_tbl_nm']}' ("
            "'TABLE_NAME' VARCHAR(256), 'CREATED_DATE' VARCHAR(256), "
            "'DESCRIPTION' VARCHAR(256));"
        )
        ref_key_output_table_metadata = [[in_RefKeyOutput['new_tbl_nm'], get_formatted_date(), in_RefKeyOutput['description']]]
        plot_io.write_table_sqlite(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], ref_key_output_table_metadata,
                                   ref_key_output_table_columns, ref_key_output_table_definition)

        # Prepare & create table containing unfiltered key input source
        nvcs_key_test_data_definition, nvcs_key_test_data_columns = plot_io.table_info_sqlite(
            in_KeyTestData['source'], in_KeyTestData['source_tbl_nm'], new_tbl=in_KeyTestData['new_tbl_nm'])
        nvcs_key_test_data_rows = plot_io.query_sqlite(
            in_KeyTestData['source'], f"SELECT * FROM {in_KeyTestData['source_tbl_nm']};")
        plot_io.write_table_sqlite(out_Options["output_db"], in_KeyTestData['new_tbl_nm'], nvcs_key_test_data_rows,
                             nvcs_key_test_data_columns, nvcs_key_test_data_definition)
        plot_io.execute_sqlite(out_Options["output_db"], f"DROP INDEX IF EXISTS idx_test_ident;")
        plot_io.execute_sqlite(out_Options["output_db"], f"CREATE INDEX idx_test_ident ON {in_KeyTestData['new_tbl_nm']} (IDENT);")
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], in_KeyTestData['new_tbl_nm'], in_KeyTestData['description'])

        # Prepare & create table containing unfiltered analytical input source
        nvcs_analytical_test_data_definition, nvcs_analytical_test_data_columns = plot_io.table_info_sqlite(
            in_AnlyTestData['source'], in_AnlyTestData['source_tbl_nm'], new_tbl=in_AnlyTestData['new_tbl_nm'])
        nvcs_analytical_test_data_rows = plot_io.query_sqlite(
            in_AnlyTestData['source'], f"SELECT * FROM {in_AnlyTestData['source_tbl_nm']};")
        plot_io.write_table_sqlite(out_Options["output_db"], in_AnlyTestData['new_tbl_nm'], nvcs_analytical_test_data_rows,
                             nvcs_analytical_test_data_columns, nvcs_analytical_test_data_definition)
        plot_io.execute_sqlite(out_Options["output_db"], f"DROP INDEX IF EXISTS idx_anly_ident;")
        plot_io.execute_sqlite(out_Options["output_db"],
                               f"CREATE INDEX idx_anly_ident ON {in_AnlyTestData['new_tbl_nm']} (IDENT);")
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], in_AnlyTestData['new_tbl_nm'], in_AnlyTestData['description'])

        # Prepare & create table containing REF_FOREST_TYPE values
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
        plot_io.write_table_sqlite(out_Options["output_db"], in_RefForestType['new_tbl_nm'], fs_fiadb_ref_forest_type_rows,
                             fs_fiadb_ref_forest_type_columns, fs_fiadb_ref_forest_type_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], in_RefForestType['new_tbl_nm'], in_RefForestType['description'])

        # Prepare & create table containing NVCS classifications, IDs, and codes
        ref_nvcs_algorithm_node_definition = (
            f"CREATE TABLE '{in_RefAlgNode['new_tbl_nm']}' ("
            "'IDENT' INTEGER, 'PARENT' INTEGER, 'DESCRIPTION' VARCHAR(256), "
            "'NVC_LEVEL' VARCHAR(256), 'NVC_CODE' VARCHAR(256));"
        )
        ref_nvcs_algorithm_node_columns = ['IDENT', 'PARENT', 'DESCRIPTION', 'NVC_LEVEL', 'NVC_CODE']
        ref_nvcs_algorithm_node_rows = export_node_table(in_ClassificationKey)
        plot_io.write_table_sqlite(out_Options["output_db"], in_RefAlgNode["new_tbl_nm"], ref_nvcs_algorithm_node_rows,
                             ref_nvcs_algorithm_node_columns, ref_nvcs_algorithm_node_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], in_RefAlgNode['new_tbl_nm'], in_RefAlgNode['description'])

    for inventory_year in out_Options["inventory_years"]:
        print("-" * 50)
        print(f"Generating tables and views for: {inventory_year}\n")

        # Create a filtered input view
        python_key_input_vw_name = f"Y{inventory_year}_PYTHON_KEY_INPUT_VW"
        python_key_input_vw_desc = f"View containing filtered input data fed through the classification key [{inventory_year} plots only]"
        python_key_input_vw_definition = (
            f"CREATE VIEW '{python_key_input_vw_name}' AS "
            "SELECT IDENT, RSCD, STATEAB, ECOREGION, PLANTATION, HYDRIC, RIVERINE, "
            "ELEVATION, COALESCE(SPECIES, '') AS 'SPECIES', RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, "
            f"TALLYTREE, SPCOV FROM {in_KeyTestData['new_tbl_nm']} "
            f"WHERE INVYR = {inventory_year} {out_Options['additional_where_clause']};"
        )
        plot_io.create_view(out_Options["output_db"], python_key_input_vw_name, python_key_input_vw_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], python_key_input_vw_name, python_key_input_vw_desc)
    
        # Run input data through the key
        tester.run(outfile=in_KeyTestData['source_out'], debugfile=in_KeyTestData['source_debug'],
                   dbfile=out_Options["output_db"], plottbl=python_key_input_vw_name)
    
        # Run the outfile through the fixup and save to the new database
        key_output_nm = f"Y{inventory_year}_{in_KeyOutput['new_tbl_nm']}"
        key_output_desc = f"{in_KeyOutput['description']} [{inventory_year} plots only]"
        fixup_keyout_v2.fixup(key_outfile=in_KeyTestData["source_out"], out_csv=in_KeyOutput["csv_output"],
                              out_db=out_Options["output_db"], out_db_tbl=key_output_nm)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], key_output_nm, key_output_desc)
    
        # Views created via code
        nvcs_analytical_test_data_vw_name = f"Y{inventory_year}_NVCS_ANALYTICAL_TEST_DATA_VW"
        nvcs_analytical_test_data_vw_desc = f"View containing filtered analytical data [{inventory_year} plots only]"
        nvcs_analytical_test_data_vw_definition = (
            f"CREATE VIEW '{nvcs_analytical_test_data_vw_name}' AS "
            f"SELECT * FROM {in_AnlyTestData['new_tbl_nm']} "
            f"WHERE INVYR = {inventory_year} {out_Options['additional_where_clause']}"
        )
        plot_io.create_view(out_Options["output_db"], nvcs_analytical_test_data_vw_name, nvcs_analytical_test_data_vw_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], nvcs_analytical_test_data_vw_name, nvcs_analytical_test_data_vw_desc)

        analytical_data_w_key_output_yw_nm = f"Y{inventory_year}_ANALYTICAL_DATA_W_KEY_OUTPUT_VW"
        analytical_data_w_key_output_yw_desc = f"View containing filtered analytical data joined with classification results and forest types [{inventory_year} plots only]"
        analytical_data_w_key_output_yw_definition = (
            f"CREATE VIEW '{analytical_data_w_key_output_yw_nm}' AS "
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
            f"FROM ({key_output_nm} AS 'KEY_OUTPUT' "
            f"INNER JOIN {nvcs_analytical_test_data_vw_name} AS 'ANLY' ON KEY_OUTPUT.IDENT = ANLY.IDENT) "
            f"INNER JOIN {in_RefForestType['new_tbl_nm']} AS 'FFRFT' ON ANLY.FOR_TYPE = FFRFT.VALUE;"
        )
        plot_io.create_view(out_Options["output_db"], analytical_data_w_key_output_yw_nm, analytical_data_w_key_output_yw_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], analytical_data_w_key_output_yw_nm, analytical_data_w_key_output_yw_desc)

        count_cond_by_solution_vw_nm = f"Y{inventory_year}_COUNT_COND_BY_SOLUTION_VW"
        count_cond_by_solution_vw_desc = f"View containing frequency of all terminal node classifications [{inventory_year} plots only]"
        count_cond_by_solution_vw_definition = (
            f"CREATE VIEW '{count_cond_by_solution_vw_nm}' AS "
            "SELECT KEY_OUTPUT.solution_desc, KEY_OUTPUT.solution_id, "
            f"Count(KEY_OUTPUT.ident) AS CountOfident FROM {key_output_nm} AS 'KEY_OUTPUT' "
            "GROUP BY KEY_OUTPUT.solution_desc, KEY_OUTPUT.solution_id "
            "ORDER BY Count(KEY_OUTPUT.ident) DESC;"
        )
        plot_io.create_view(out_Options["output_db"], count_cond_by_solution_vw_nm, count_cond_by_solution_vw_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], count_cond_by_solution_vw_nm, count_cond_by_solution_vw_desc)

        count_cond_by_solution_v2_vw_nm = f"Y{inventory_year}_COUNT_COND_BY_SOLUTION_V2_VW"
        count_cond_by_solution_v2_vw_desc = f"View containing frequency of group-level terminal node classifications [{inventory_year} plots only]"
        count_cond_by_solution_v2_vw_definition = (
            f"CREATE VIEW '{count_cond_by_solution_v2_vw_nm}' AS "
            "SELECT RNAN.ident AS node_id, RNAN.description, "
            f"CCBS.CountOfident FROM {in_RefAlgNode['new_tbl_nm']} AS 'RNAN' "
            f"LEFT JOIN {count_cond_by_solution_vw_nm} as 'CCBS' ON CCBS.solution_id = RNAN.ident "
            "WHERE (((RNAN.nvc_level)='group' OR (RNAN.nvc_level)='unclassified')) "
            "ORDER BY RNAN.ident;"
        )
        plot_io.create_view(out_Options["output_db"], count_cond_by_solution_v2_vw_nm, count_cond_by_solution_v2_vw_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], count_cond_by_solution_v2_vw_nm, count_cond_by_solution_v2_vw_desc)

        count_unclass_cond_by_last_node_vw_nm = f"Y{inventory_year}_COUNT_UNCLASS_COND_BY_LAST_NODE_VW"
        count_unclass_cond_by_last_node_vw_desc = f"View containing frequency of last internal nodes accessed before becoming unclassified [{inventory_year} plots only]"
        count_unclass_cond_by_last_node_vw_definition = (
            f"CREATE VIEW '{count_unclass_cond_by_last_node_vw_nm}' AS "
            "SELECT KEY_OUTPUT.last_node_desc, Count(KEY_OUTPUT.ident) AS CountOfident "
            f"FROM {key_output_nm} AS 'KEY_OUTPUT' WHERE (((KEY_OUTPUT.solution_id)=-1)) "
            "GROUP BY KEY_OUTPUT.last_node_desc ORDER BY Count(KEY_OUTPUT.ident) DESC;"
        )
        plot_io.create_view(out_Options["output_db"], count_unclass_cond_by_last_node_vw_nm, count_unclass_cond_by_last_node_vw_definition)
        write_metadata(out_Options["output_db"], in_RefKeyOutput["new_tbl_nm"], count_unclass_cond_by_last_node_vw_nm, count_unclass_cond_by_last_node_vw_desc)

    # Conclusion
    inv_yrs_comma = ', '.join(str(x) for x in out_Options['inventory_years'])

    print("-" * 50)
    print("Full output program has finished")
    print(f" - Result Path: {out_Options['output_db']}")
    print(f" - Inventory Years Added: {inv_yrs_comma}")


def export_node_table(classification_key):
    rows = [
        ['ident', 'parent', 'description', 'nvc_level', 'nvc_code'],
        ['-1', '', 'unclassified', 'unclassified', '']
    ]

    key = classification_key.ClassificationKey()
    for node in key.nodes.values():
        if (node.ident > 0):
            rows.append([node.ident, node.parent, node.description, node.level, node.code])

    return rows


def write_metadata(db, metadata_tbl, name, description):
    metadata = [[name, get_formatted_date(), description]]
    plot_io.write_rows_sqlite(db, metadata_tbl, metadata, ref_key_output_table_columns)


def get_formatted_date():
    current_time = datetime.datetime.now()
    return current_time.strftime("%Y-%m-%d %H:%M:%S %z")


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

    in_KeyTestData = {
        "source": config.get(config.fullOutputSection, "In_DbPath"),
        "source_tbl_nm": config.get(config.fullOutputSection, "In_TestDbTable"),
        "source_out": config.get(config.fullOutputSection, "Out_TesterResultsPath"),
        "source_debug": config.get(config.fullOutputSection, "Out_DebugLogPath"),
        "new_tbl_nm": config.get(config.fullOutputSection, "KeyTestDataName"),
        "description": config.get(config.fullOutputSection, "KeyTestDataDesc")
    }

    in_AnlyTestData = {
        "source": config.get(config.fullOutputSection, "In_DbPath"),
        "source_tbl_nm": config.get(config.fullOutputSection, "In_AnlyDbTable"),
        "new_tbl_nm": config.get(config.fullOutputSection, "AnlyTestDataName"),
        "description": config.get(config.fullOutputSection, "AnlyTestDataDesc")
    }

    in_RefForestType = {
        "source": config.get(config.fullOutputSection, "In_RefForestTypeDataPath"),
        "new_tbl_nm": config.get(config.fullOutputSection, "RefForestTypeName"),
        "description": config.get(config.fullOutputSection, "RefForestTypeDesc")
    }

    in_RefAlgNode = {
        "new_tbl_nm": config.get(config.fullOutputSection, "RefAlgNodeName"),
        "description": config.get(config.fullOutputSection, "RefAlgNodeDesc")
    }

    in_RefKeyOutput = {
        "new_tbl_nm": config.get(config.fullOutputSection, "RefKeyOutputName"),
        "description": config.get(config.fullOutputSection, "RefKeyOutputDesc")
    }
    
    in_KeyOutput = {
        "source": config.get(config.fullOutputSection, "Out_TesterResultsPath"),
        "new_tbl_nm": config.get(config.fullOutputSection, "KeyOutputName"),
        "description": config.get(config.fullOutputSection, "KeyOutputDesc"),
        "csv_output": config.get(config.fullOutputSection, "Out_FixupCsvPath")
    }

    out_Options = {
        "inventory_years": config.get_literal(config.fullOutputSection, "InventoryYears"),
        "additional_where_clause": config.get(config.fullOutputSection, "AdditionalWhereClause"),
        "output_db": config.get(config.fullOutputSection, "Out_DbPath"),
        "skip_shared_tables": config.get_literal(config.fullOutputSection, "SkipSharedTables")
    }

    generateFullOutput(classification_key, in_KeyTestData, in_AnlyTestData, in_RefForestType, in_RefAlgNode,
                       in_RefKeyOutput, in_KeyOutput, out_Options)
