'''
Created on Mar 28, 2013

@author: knimerfro
@author: ctoney
- 2024-02-01 add read_sqlite()
'''
import sqlite3

from key_western_us import Plot
from key_western_us import Tree

def read_line(f):
    fields = f.readline().strip()
    if fields:
        return fields.split('\t')
    else:
        return None

def read_file(plotfile):
    with open(plotfile, 'r') as f:
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

def read_sqlite(dbfile, tbl):
    plot_fields = 'IDENT, RSCD, STATEAB, ECOREGION, PLANTATION, HYDRIC, RIVERINE, ELEVATION'
    tree_fields = 'SPECIES, RIV, WETLAND, RUDERAL, EXOTIC, SOFTWOODHARDWOOD, PLANTED, TALLYTREE, SPCOV'
    sql = 'SELECT DISTINCT ' + plot_fields + ' FROM ' + tbl
    sql = sql + ' WHERE STATEAB != "AK"'
    con = sqlite3.connect(dbfile)
    cur = con.cursor()
    tree_cur = con.cursor()
    for row in cur.execute(sql):
        plot = Plot(*row)
        sql = 'SELECT ' + tree_fields + ' FROM ' + tbl + ' WHERE IDENT == "' + row[0] + '"'
        for tree_row in tree_cur.execute(sql):
            tree_row = list(tree_row)
            if tree_row[1] is None:
                tree_row[1] = 0
            if tree_row[8] is None:
                tree_row[8] = 0
            plot.trees.append(Tree(*tree_row))
        yield plot
    con.close()

def write_sqlite(dbfile, tbl, columns, dataRows):
    con = sqlite3.connect(dbfile)
    cur = con.cursor()

    insertedColumns = ','.join(columns)
    cur.execute(f"DROP TABLE IF EXISTS [{tbl}];")
    cur.execute(f"CREATE TABLE {tbl} ({insertedColumns});")

    insertedPlaceholders = ','.join(['?'] * len(columns))
    insertStatement = f"INSERT INTO {tbl} ({insertedColumns}) VALUES ({insertedPlaceholders});"
    insertedRows = [tuple(i) for i in dataRows]

    cur.executemany(insertStatement, insertedRows)
    con.commit()
    con.close()

    print(f"Successfully inserted {len(insertedRows)} rows into '{tbl}' at: {dbfile}")

if __name__ == '__main__':
    #for plot in read_file('C:/nvcs-workspace/nvcs_west/nvcs_tester/run_input/nvcs-case-dataset-1.csv'):
        print(plot)
    