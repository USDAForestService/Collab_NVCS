'''
Created on Mar 28, 2013

@author: knimerfro
@author: ctoney
- 2024-02-01 add read_sqlite()
'''
import sqlite3
import csv
import sys

def read_line(f):
    fields = f.readline().strip()
    if fields:
        return fields.split('\t')
    else:
        return None

def read_file(plotfile):
    from key_western_us import Plot
    from key_western_us import Tree
    with open(plotfile, mode='r', encoding='utf-8') as f:
        next(f)
        # str.strip each column value (CT 2023-02-13):
        curr = prev = list(map(str.strip, read_line(f)))
        while curr:
            plot = Plot(*curr[:8])
            plot.trees = [Tree(*curr[8:])]
            while True:
                curr = read_line(f)
                if curr and curr[0] == prev[0]:
                    plot.trees.append(Tree(*curr[8:]))
                else:
                    prev = curr
                    yield plot
                    break;

def read_csv(file_path):
    with open(file_path, newline='', encoding='utf-8') as f:
        reader = csv.reader(f)
        results = list(reader)
    return results

def read_sqlite(type, dbfile, tbl):
    if type == 'WestConfig':
        return read_sqlite_west(dbfile, tbl)
    else:
        return read_sqlite_east(dbfile, tbl)

def read_sqlite_west(dbfile, tbl):
    from key_western_us import Plot, Tree
    plot_fields = 'IDENT, RSCD, STATEAB, ECOREGION, PLANTATION, HYDRIC, RIVERINE, ELEVATION, BALIVE, FBCOV, GRCOV, SHCOV, TTCOV, NTCOV, LIVE_CANOPY_CVR_PCT, AFFORESTATION_CD, LAND_COVER_CLASS_CD, LAND_COVER_CLASS_CD_RET, TRTCD1, TRTCD2'
    tree_fields = 'SPECIES, RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, TALLYTREE, SPCOV'
    sql = 'SELECT DISTINCT ' + plot_fields + ' FROM ' + tbl
    sql = sql + ' WHERE RSCD IN (22, 23, 26, 33) ORDER BY IDENT'
    con = sqlite3.connect(dbfile)
    cur = con.cursor()
    tree_cur = con.cursor()
    for row in cur.execute(sql):
        plot = Plot(*row)
        sql = 'SELECT ' + tree_fields + ' FROM ' + tbl + ' WHERE IDENT == "' + row[0] + '"'
        for tree_row in tree_cur.execute(sql):
            tree_row = list(tree_row)
            if tree_row[0] is None:
                tree_row[0] = ""
            if tree_row[1] is None:
                tree_row[1] = 0
            if tree_row[8] is None:
                tree_row[8] = 0
            plot.trees.append(Tree(*tree_row))
        yield plot
    con.close()

def read_sqlite_east(dbfile, tbl):
    from key_eastern_us import Plot, Tree
    plot_fields = 'IDENT, null, null, ECOREGION, PLANTATION, HYDRIC, RIVERINE, null, null, null, null, null, null, null, null, null, null, null, null, null'
    tree_fields = 'SPECIES, RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, null, null'
    sql = 'SELECT DISTINCT ' + plot_fields + ' FROM ' + tbl
    sql = sql + ' WHERE (TRUE) ORDER BY IDENT'
    con = sqlite3.connect(dbfile)
    cur = con.cursor()
    tree_cur = con.cursor()
    for row in cur.execute(sql):
        plot = Plot(*row)
        sql = 'SELECT ' + tree_fields + ' FROM ' + tbl + ' WHERE IDENT == "' + row[0] + '"'
        for tree_row in tree_cur.execute(sql):
            tree_row = list(tree_row)
            if tree_row[0] is None:
                tree_row[0] = ""
            if tree_row[1] is None:
                tree_row[1] = 0
            if tree_row[8] is None:
                tree_row[8] = 0
            plot.trees.append(Tree(*tree_row))
        yield plot
    con.close()

def execute_sqlite(dbfile, query):
    con = sqlite3.connect(dbfile)
    cur = con.cursor()
    cur.execute(query)
    con.close()

def query_sqlite(dbfile, query):
    con = sqlite3.connect(dbfile)
    cur = con.cursor()
    cur.execute(query)
    results = cur.fetchall()
    con.close()
    return results

def table_info_sqlite(dbfile, tbl, new_tbl):
    sql = f"PRAGMA table_info('{tbl}')"
    table_info = query_sqlite(dbfile, sql)
    table_definition = ""
    table_columns = []

    for i in range(len(table_info)):
        column = table_info[i]
        name = column[1]
        type = column[2]
        not_null = " NOT NULL" if column[3] != 0 else ""
        primary_key = " PRIMARY KEY" if column[5] != 0 else ""
        default_value = ""
        if isinstance(column[4], str):
            f" DEFAULT VALUE '{column[4]}'"
        elif column[4] is not None:
            f" DEFAULT VALUE {column[4]}"

        table_definition += f"'{name}' {type}{not_null}{default_value}{primary_key}"
        if i < len(table_info) - 1:
            table_definition += ","

        table_columns.append(name)

    table_name = new_tbl if new_tbl is not None else tbl
    table_creation_sql = f"CREATE TABLE '{table_name}' ({table_definition});"
    return table_creation_sql, table_columns

def create_view(dbfile, view, view_definition):
    drop_view_sql = f"DROP VIEW IF EXISTS {view}"
    execute_sqlite(dbfile, drop_view_sql)
    execute_sqlite(dbfile, view_definition)
    print(f"Successfully created view {view} at: {dbfile}")

def write_rows_sqlite(dbfile, tbl, dataRows, columns, cur=None):
    con = None
    if cur is None:
        con = sqlite3.connect(dbfile)
        cur = con.cursor()

    insertedColumns = ','.join(columns)
    insertedPlaceholders = ','.join(['?'] * len(columns))
    insertStatement = f"INSERT INTO {tbl} ({insertedColumns}) VALUES ({insertedPlaceholders});"
    insertedRows = [tuple(i) for i in dataRows]

    cur.executemany(insertStatement, insertedRows)

    if con is not None:
        con.commit()
        con.close()

    return insertedRows

def delete_row_sqlite(dbfile, tbl, where, cur=None):
    con = None
    if cur is None:
        con = sqlite3.connect(dbfile)
        cur = con.cursor()

    deleteStatement = f"DELETE FROM {tbl} WHERE {where};"
    cur.execute(deleteStatement)

    if con is not None:
        con.commit()
        con.close()

def write_table_sqlite(dbfile, tbl, dataRows, columns, table_definition=None):
    con = sqlite3.connect(dbfile)
    cur = con.cursor()

    insertedColumns = ','.join(columns)
    createStatement = table_definition if table_definition is not None else f"CREATE TABLE {tbl} ({insertedColumns});"
    cur.execute(f"DROP TABLE IF EXISTS [{tbl}];")
    cur.execute(createStatement)

    insertedRows = write_rows_sqlite(dbfile, tbl, dataRows, columns, cur)
    con.commit()
    con.close()

    print(f"Successfully inserted {len(insertedRows)} rows into '{tbl}' at: {dbfile}")

def get_unique_values_sqlite(dbfile, tbl, column, cur=None):
    selectStatement = f"SELECT DISTINCT {column} FROM {tbl} ORDER BY {column}"
    results = query_sqlite(dbfile, selectStatement)
    return_list = [i[0] for i in results]
    return return_list


if __name__ == '__main__':
    if len(sys.argv) == 1:
        print("Usage: py plot_io.py function_name param_1 param_2 param_n")
        sys.exit()
    
    target_function = sys.argv[1]
    if target_function == "get_unique_values_sqlite":
        required_param_count = 3
        if len(sys.argv) < 2 + required_param_count:
            raise Exception(f"{target_function} has {required_param_count} required parameters")
        results = get_unique_values_sqlite(sys.argv[2], sys.argv[3], sys.argv[4])
        print(results)
        sys.exit()
    else:
        print(f"Unimplemented target function: {target_function}")

    