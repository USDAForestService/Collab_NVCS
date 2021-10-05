# NVCS East

This Python project is Stage 1 of an effort to populate a new condition
attribute, NVCS_CD, to NIMS and FIADB condition tables. NVCS_CD is a
classification variable describing the present vegetative community (very
similar to forest type). NVCS stands for National Vegetation Classification
Standard.

Data initially will be available only for eastern U.S. forested P2 plots.

## How to run

Below are some examples to illustrate how the NVCS-East python scripts may be
run.

### Run by State and Inventory Year

1. Launch Windows command prompt: cmd.exe
2. Change Directory to NVCS-East folder
    ```cmd
    cd %userprofile%\nvcs\nvcs-east\
    ```
3. Run NVCS-East Insert/Update
    ***Python command prompt***
    ```python
    from nvcs.nims_run import driver
    driver('/@fiadb01p','fs_nims_nrs','UPDATE',46,2020)
    ```

    ```
    NVCS version 1.0 on (Tue Sep  7 11:44:18 2021)
    Run parameters: (schema_name=fs_nims_nrs, statecd=46, invyr=2020, countycd=None, plot=None)
    Updating fs_nims_nrs.NIMS_COND_NVCS_TBL... done.
    Run summary:
         1 forested conditions were assigned an NVCS code
         0 forested conditions were assigned an NVCS code of -1 because the algorithm failed to produce a classification
        62 forested conditions were assigned an NVCS code of -2 because the eco-subsection is not supported by the algorithm
      1125 conditions were skipped because the status is not forested
     -----
      1188 conditions were processed in 25.953 sec.
    ```
4. Review updates/inserts were successful
    ```sql
    SELECT c.*
    FROM fs_nims_nrs.nims_cond_nvcs_vw c
    WHERE c.statecd = 46
    AND c.invyr = 2020;
    ```

### Clean out (delete) NVCS by State and Inventory Year

1. Launch Windows command prompt: cmd.exe
2. Change Directory to NVCS-East folder
    ```cmd
    cd %userprofile%\nvcs\nvcs-east\
    ```
3. Run NVCS-East Clean-up (delete)
    ***Python command prompt***
    ```python
    from nvcs.nims_run import driver
    driver('/@fiadb01p','fs_nims_nrs','DELETE',46,2020)
    ```

    ```
    NVCS version 1.0 on (Tue Sep  7 11:44:18 2021)
    Run parameters: (schema_name=fs_nims_nrs, statecd=46, invyr=2020, countycd=None, plot=None)
    Updating fs_nims_nrs.NIMS_COND_NVCS_TBL... done.
    Run summary:
         1 forested conditions were assigned an NVCS code
         0 forested conditions were assigned an NVCS code of -1 because the algorithm failed to produce a classification
        62 forested conditions were assigned an NVCS code of -2 because the eco-subsection is not supported by the algorithm
      1125 conditions were skipped because the status is not forested
     -----
      1188 conditions were processed in 25.953 sec.
    ```
4. Review updates/inserts were successful
    ```sql
    SELECT c.*
    FROM fs_nims_nrs.nims_cond_nvcs_vw c
    WHERE c.statecd = 46
    AND c.invyr = 2020;
    ```

## NVCS Algorithm Input Review

**Review condition-level inputs to NVCS algorithm**

```sql
SELECT cnd_cn,
       stateab,
       ecosubcd_actual,
       plantation,
       hydric,
       riverine
  FROM fs_nims_nrs.nims_cond_nvcs_input_vw;
```

**Review species-level inputs to NVCS algorithm**

```sql
SELECT species_name,
       riv,
       wetland,
       ruderal,
       exotic,
       softwoodhardwood,
       planted
  FROM fs_nims_nrs.nims_species_nvcs_input_vw;
```
