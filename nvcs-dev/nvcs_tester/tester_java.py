import os
import sys
import inspect
import subprocess

# Update sys path for correct run-time importing
currDir = os.path.dirname(os.path.abspath(inspect.getfile(inspect.currentframe())))
parentDir = os.path.dirname(currDir)
sys.path.append(parentDir)
sys.path.append(parentDir + "/nvcs")

from plot_io import query_sqlite
import logging
from time import process_time

from nvcs_builder import configuration
config = configuration.DebugConfig()

def run(outfile, debugfile, dbfile, plottbl, temp_path, invyrs, where):

    print('Input file = %s' % (dbfile))
    print('Output file = %s' % outfile)

    #Classify plots read from a sqlite db or text file
    logging.basicConfig(filename=debugfile, filemode='w', level=logging.DEBUG) # or ERROR
    with Timer() as t:
        with open(outfile, mode='w', encoding='utf-8') as f:
            plots = json_query(dbfile, plottbl, invyrs, where)
            with open(temp_path, mode='w', encoding='utf-8') as temp:
                for plot in plots:
                    ident = plot[0]
                    row_json = plot[1]
                    temp.write(f"{ident}\t{row_json}\n")
            java_classify(temp_path, outfile)
    print('Run took %.03f sec.' % t.interval)

def json_query(dbfile, tbl, invyrs, where):
    where = f"{where}" if where != "" else "TRUE"
    invyr = f"INVYR IN ({invyrs.replace("[", "(").replace("]",")")})" if invyrs != "" else "TRUE"
    query = f"""
        SELECT
            IDENT,
            '{{\"rows\":[' || group_concat(ROW_JSON) || ']}}' ROWS_JSON
        FROM
        (
            SELECT 
            IDENT,
            JSON_OBJECT(
                'IDENT', IDENT,
                'RSCD', RSCD,
                'STATEAB', STATEAB,
                'ECOREGION', ECOREGION,
                'PLANTATION', PLANTATION,
                'HYDRIC', HYDRIC,
                'RIVERINE', RIVERINE,
                'ELEVATION', ELEVATION,
                'BALIVE', BALIVE,
                'FBCOV', FBCOV,
                'GRCOV', GRCOV,
                'SHCOV', SHCOV,
                'TTCOV', TTCOV,
                'NTCOV', NTCOV,
                'SPECIES', SPECIES,
                'RIV', RIV,
                'WETLAND', WETLAND,
                'RUDERAL', RUDERAL,
                'EXOTIC', EXOTIC,
                'SOFTWOODHARDWOOD', SOFTWOODHARDWOOD,
                'PLANTED', PLANTED,
                'TALLYTREE', TALLYTREE,
                'SPCOV', SPCOV
            )
            ROW_JSON
            FROM {tbl}
            WHERE ({where}) AND ({invyr})
        ) json
        GROUP BY IDENT
        ORDER BY IDENT;
    """

    results = query_sqlite(dbfile, query)
    return results

def java_classify(json_path, outfile):
    java_classes = "C:/GitHub/FS-Enterprise/NVCS/nvcs_java/target/classes"
    args = ['java', '-cp', java_classes, 'nvcs.App', json_path, outfile]
    try:
        process = subprocess.run(args, capture_output=True, text=True, check=True)
        if process.stderr != "":
            raise Exception(process.stderr)
        return process.stdout
    except subprocess.CalledProcessError as exception:
        raise Exception(exception.stderr)

class Timer:    
    def __enter__(self):
        self.start = process_time()
        return self

    def __exit__(self, *args):
        self.end = process_time()
        self.interval = self.end - self.start
               

if __name__ == '__main__':

    run(outfile=config.get(config.base, "Out_TestPath"),
        debugfile=config.get(config.target, "Out_DebugLogPath"),
        dbfile=config.get(config.target, "In_DbPath"),
        plottbl=config.get(config.target, "In_DbTable"),
        temp_path=config.get(config.base, "In_TempPath"),
        invyrs=config.get(config.fullOutputSection, "InventoryYears"),
        where=config.get(config.fullOutputSection, "AdditionalWhereClause"))

    pass
