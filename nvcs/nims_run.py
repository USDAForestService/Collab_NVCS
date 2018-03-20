#!python3
import cx_Oracle
import nvcs.key_eastern_us
from nvcs.key_eastern_us import Plot
from nvcs.key_eastern_us import Tree
from nvcs.classifier import Classifier
import logging
import time

__version__ = "1.0"

logfile = "nvcs-debug.log"

NID_ALGORITHM_FAILED = -1
NID_ECOREGION_NOT_SUPPORTED = -2

def fetch_nims_nvcs_input(schema_name, con, cnd_cn):
    cond = None
    trees = None
    condcur = con.cursor()
    condcur.execute("select cnd_cn, stateab, ecosubcd_actual, plantation, hydric, riverine from " + schema_name + ".nims_cond_nvcs_input_vw where cnd_cn=:p_cnd_cn", p_cnd_cn=cnd_cn)
    for c in condcur:
        cond = (c[0], c[1], c[2], c[3], c[4], c[5])
        treecur = con.cursor()
        treecur.execute("select species_name, riv, wetland, ruderal, exotic, softwoodhardwood, planted from " + schema_name + ".nims_species_nvcs_input_vw where cnd_cn = :p_cnd_cn", p_cnd_cn=cnd_cn)
        trees = []
        for t in treecur:
            trees.append((t[0], t[1], t[2], t[3], t[4], t[5], t[6]))
        treecur.close()
    condcur.close()
    return (cond, trees)

def lookup_nvcs_hierarchy_struct_cn(schema_name, con, node_id, stdorgcd):
        cur = con.cursor()
        if (node_id == NID_ALGORITHM_FAILED or node_id == NID_ECOREGION_NOT_SUPPORTED):
            if (stdorgcd == 1):
                primary_class = 'CULTURAL'
            else:
                primary_class = 'NATURAL'
            cur.execute("select cn, 'HIGH' confidence from " + schema_name + ".ref_nvcs_hierarchy_strct where primary_class=:p_primary_class and hierarchy_level_label in ('MACROGROUP', 'SUBTYPE') and nvcs_code=:p_node_id", p_primary_class=primary_class, p_node_id=str(node_id))
            for rec in cur:
                (rnvcshs_cn, confidence) = (rec[0], rec[1])
        else:
            cur.execute("select rnvcshs_cn, NVL(confidence, 'HIGH') confidence from " + schema_name + ".ref_nvcs_algorithm_node where node_id=:p_node_id", p_node_id=node_id)
            for rec in cur:
                (rnvcshs_cn, confidence) = (rec[0], rec[1])
        cur.close()
        return (rnvcshs_cn, confidence)

def expand_hierarchy(cur, cnd_cn):
    pass

def update_nims_cond_nvcs_tbl(schema_name, con, cnd_cn, node_id, stdorgcd):
    cur = con.cursor()
    (rnvcshs_cn, confidence) = lookup_nvcs_hierarchy_struct_cn(schema_name, con, node_id, stdorgcd)
    if rnvcshs_cn is None:
        (rnvcshs_cn, confidence) = lookup_nvcs_hierarchy_struct_cn(schema_name, con, NID_ALGORITHM_FAILED, stdorgcd)
    #print("cnd_cn=%s, rnvcshs_cn=%s, confidence=%s" % (cnd_cn, rnvcshs_cn, confidence))
    cur.execute("delete from " + schema_name + ".nims_cond_nvcs_tbl where cnd_cn=:p_cnd_cn", p_cnd_cn = cnd_cn)
    cur.execute("insert into " + schema_name + ".nims_cond_nvcs_tbl (cnd_cn, rnvcshs_cn, confidence, publish) select :p_cnd_cn, cn, :p_confidence, 'Y' from " + schema_name + ".ref_nvcs_hierarchy_strct start with cn = :p_rnvcshs_cn connect by prior parent_cn = cn", p_cnd_cn=cnd_cn, p_rnvcshs_cn=rnvcshs_cn, p_confidence=confidence)
    expand_hierarchy(cur, cnd_cn)
    cur.close()

class Timer:
    def __enter__(self):
        self.start = time.clock()
        return self

    def __exit__(self, *args):
        self.end = time.clock()
        self.interval = self.end - self.start

def driver_update_mode(con, schema_name, statecd, invyr, countycd, plot):
    sql = "SELECT cnd.cn," +\
            "       cnd.cond_status_cd," +\
            "       cnd.stdorgcd," +\
            "       CASE" +\
            "          WHEN plt.ecosubcd_actual IS NULL THEN" +\
            "           'missing'" +\
            "          WHEN NOT (rtrim(ltrim(plt.ecosubcd_actual)) LIKE 'M3%' OR rtrim(ltrim(plt.ecosubcd_actual)) LIKE '3%') THEN" +\
            "           'supported'" +\
            "          ELSE" +\
            "           'not supported'" +\
            "       END ecoregion_status" +\
            "  FROM " + schema_name + ".nims_plot_vw plt, " + schema_name + ".nims_cond_vw cnd" +\
            " WHERE cnd.plt_cn = plt.cn" +\
            "   AND plt.statecd=" + str(statecd) +\
            "   AND plt.invyr=" + str(invyr)
    if countycd is not None:
        sql = sql + "   AND plt.countycd=" + str(countycd)
    if plot is not None:
        sql = sql + "   AND plt.plot=" + str(plot)

    classifier = Classifier(nvcs.key_eastern_us.ClassificationKey())

    condition_count = 0
    success_count = 0
    failure_count = 0
    ecoregion_not_supported_count = 0
    skipped_count = 0

    print("Run parameters: (schema_name=%s, statecd=%d, invyr=%d, countycd=%s, plot=%s)" % (
        schema_name, statecd, invyr, "" if countycd is None else str(countycd), "" if plot is None else str(plot)))
    #print("SELECT statement: " + ' '.join(sql.split()))
    print("Updating " + schema_name + "." + "NIMS_COND_NVCS_TBL... ", end='', flush=True)

    cur = con.cursor()
    try:
        cur.execute(sql)
        for rec in cur:
            cnd_cn = rec[0]
            cond_status_cd = rec[1]
            stdorgcd = rec[2]
            ecoregion_status = rec[3]
            if cond_status_cd == 1: # forested
                if ecoregion_status == 'supported': # compute an NVCS code
                    (cond, trees) = fetch_nims_nvcs_input(schema_name, con, cnd_cn)
                    if cond is not None and trees is not None:
                        plot = Plot(*cond)
                        plot.trees = []
                        for t in trees:
                            plot.trees.append(Tree(*t))
                        solution = classifier.classify(plot)
                        if solution.path[-1] is not None:
                            node_id = solution.path[-1].ident
                            success_count += 1
                        else: # algorithm failed
                            node_id = NID_ALGORITHM_FAILED
                            failure_count += 1
                    else: # condition or tree data is missing
                        node_id = NID_ALGORITHM_FAILED
                        failure_count += 1
                elif ecoregion_status == 'not supported': # ecoregion is not supported
                    node_id = NID_ECOREGION_NOT_SUPPORTED
                    ecoregion_not_supported_count += 1
                else: # ecoregion is missing
                    node_id = NID_ALGORITHM_FAILED
                    failure_count += 1
                update_nims_cond_nvcs_tbl(schema_name, con, cnd_cn, node_id, stdorgcd)
            else: # not forested
                skipped_count += 1
            condition_count += 1
    finally:
        cur.close()

    print("done.")
    print("Run summary:")
    print("%6d forested conditions were assigned an NVCS code" % success_count)
    print("%6d forested conditions were assigned an NVCS code of %d because the algorithm failed to produce a classification" % (failure_count, NID_ALGORITHM_FAILED))
    print("%6d forested conditions were assigned an NVCS code of %d because the eco-subsection is not supported by the algorithm" % (ecoregion_not_supported_count, NID_ECOREGION_NOT_SUPPORTED))
    print("%6d conditions were skipped because the status is not forested" % skipped_count)
    print(" -----")
    print("%6d conditions were processed in " % condition_count, end='')

def driver_delete_mode(con, schema_name, statecd, invyr, countycd, plot):
    innersql = "SELECT cn FROM " + schema_name + ".nims_cond_vw WHERE statecd=" + str(statecd) + " AND invyr=" + str(invyr)
    if countycd is not None:
        innersql = innersql + " AND countycd=" + str(countycd)
    if plot is not None:
        innersql= innersql + " AND plot=" + str(plot)
    sql = "DELETE FROM " + schema_name + ".nims_cond_nvcs_tbl WHERE cnd_cn IN (" + innersql + ")"

    print("Run parameters: (schema_name=%s, statecd=%d, invyr=%d, countycd=%s, plot=%s)" % (
        schema_name, statecd, invyr, "" if countycd is None else str(countycd), "" if plot is None else str(plot)))
    print("DELETE statement: " + ' '.join(sql.split()))
    print("Deleting from " + schema_name + ".NIMS_COND_NVCS_TBL... ", end='', flush=True)

    cur = con.cursor()
    try:
        cur.execute(sql)
        rowcount = cur.rowcount
    finally:
        cur.close()

    print("done.")
    print("%d rows were deleted in " % rowcount, end='')

def driver(connect_string, schema_name, mode, statecd, invyr, countycd = None, plot = None):
    global logfile

    print("NVCS version " + __version__ + " on (" + time.asctime(time.localtime()) + ")")
    with Timer() as t:
        #logging.basicConfig(filename=logfile, filemode='w', level=logging.DEBUG) # or ERROR
        logging.basicConfig()
        logging.disable(logging.CRITICAL)
        with cx_Oracle.connect(connect_string) as con:
            if mode.upper() == 'UPDATE':
                driver_update_mode(con, schema_name, statecd, invyr, countycd, plot)
            elif mode.upper() == 'DELETE':
                driver_delete_mode(con, schema_name, statecd, invyr, countycd, plot)
            else:
                print(mode.upper() + " is not a valid mode.  The parameter value must be 'UPDATE' or 'DELETE'.")
            #con.commit()
    print("%.03f sec.\n" % t.interval)

if __name__ == '__main__':
    #from nvcs.nims_run import driver
    print("Examples:")
    print()
    print("1. Load 2009 Kansas at LUPE:")
    print("driver('my_username/my_password@LUPE01P', 'fs_nims_nrs', 'UPDATE', 20, 2009)")
    print()
    print("2. Load 2009 Kansas, countycd=1 at LUPE:")
    print("driver('my_username/my_password@LUPE01P', 'fs_nims_nrs', 'UPDATE', 20, 2009, 1)")
    print()
    print("3. Load 2009 Kansas, countycd=1, plot=251 at LUPE:")
    print("driver('my_username/my_password@LUPE01P', 'fs_nims_nrs', 'UPDATE', 20, 2009, 1, 251)")
    print()
    print("4. Delete 2009 Kansas at LUPE:")
    print("driver('my_username/my_password@LUPE01P', 'fs_nims_nrs', 'DELETE', 20, 2009)")
    print()
    print("5. Load 2009 Kansas at PROD using OS authentication:")
    print("driver('/@fia01p', 'fs_nims_nrs', 'UPDATE', 20, 2009)")

