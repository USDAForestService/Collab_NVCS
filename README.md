# NVCS

This Python project is Stage 1 of an effort to populate a new condition
attribute, NVCS_CD, to NIMS and FIADB condition tables. NVCS_CD is a
classification variable describing the present vegetative community (very
similar to forest type). NVCS stands for National Vegetation Classification
Standard.

This initial version contains separate code bases for different FIA regional
groups.  For additional information see the relevant README in the regional
codebase folders:
    * NVCS-EAST


## Dependencies
- Python 3
- Cx_Oracle Python module

## Set-Up (Windows)
1. Download and install Python 3.*:

   - Go to [python.org](https://www.python.org/downloads)
   and download the "Windows x86 executable installer"

   - Run the installer.

2. Download and install cx_Oracle:

   - Go to [pypi.python.org](https://pypi.python.org/pypi/cx_Oracle "Cx_Oracle Downloads")

   - Open a command prompt and type:
   ```
   python -m pip install cx_Oracle
   ```

3. Extract the attached zip file.  I extracted it to %userprofile%\\NVCS.

4. Make sure your Windows ORACLE_HOME environment variable is set or appears on the PATH environment variable.  Otherwise cx_Oracle may fail to resolve
   the net service name, for example ORACLE_HOME=C:\\oracle64\\product\\12.2.0\\client\\bin

5. Test the database connection:

   - Open a python command prompt.
    ```python
    import cx_Oracle
    con = cx_Oracle.connect('/@FIADB01P')
    #If you get the >>> back then it worked and you can close the connection:
    con.close()
    ```

## Background

The U.S. National Vegetation Classification (USNVC) Standard was adopted by the
Federal Geographic Data Committee as a federal standard for reporting
vegetation information. NatureServe and the U.S. Forest Service (USFS) are
collaborating to implement the USNVC in the USFS Forest Inventory and Analysis
(FIA) Program. The USNVC uses an ecological vegetation approach that integrates
ecological and human factors with all vegetation layers into separate 8-level
hierarchy of types for both natural and cultural (plantation) forests. The goal
of our project is to classify conditions on FIA "Phase 2" (P2) plots across the
U.S. to the macrogroup level for natural forests and to type for plantation
forests. In this first phase, for eastern U.S. forests, NatureServe scientists
first completed a narrative-based key that used available FIA attributes,
including tree and environmental data, tree life-history data (nativity,
wetland indicator status, ruderality), and ecoregional information, to assign
P2 plot conditions to 27 macrogroup and 11 plantation types. The process of
computerizing the key was iterative. NRS-FIA staff (Kevin Nimerfro) developed a
computer algorithm based on this key, then produced summary outputs of
macrogroup and plantation types and distributions, which NatureServe staff
compared with published descriptions of the types. The final version of the key
was validated for natural forests using P2 FIA plots previously assigned to
USNVC groups and macrogroups by experts working with the LandFire program. By
assigning a macrogroup and plantation type to each forested condition, FIA can
report forest type data for eastern U.S. forests using the USNVC standard.　
This information will facilitate collaborations with other agencies using the
USNVC.　FIA data also improve the USNVC by providing valuable quantitative data
on macrogroup tree composition and distribution.

As the first phase of a national strategy, this project developed and
documented an approach for attributing FIA P2 forested conditions with the
USNVC macrogroups in the eastern half of the US (US Forest Service Regions 8
and 9), from Minnesota to Maine, south to Louisiana and eastern Texas to
Florida. The region extends as far west as the tallgrass prairie ecoregion
(Ecoregions 250, 255), including a small eastern portion of the Great Plains
states of Kansas, Nebraska, North Dakota, and South Dakota; the prairie
province extends further west in Oklahoma and Texas, so larger proportions of
these two states are included. FIA plots in ecoregions of western portions of
these six plains states do not yet have Macrogroup classification keys. A
future goal is to develop keys and code for attributing macrogroup to the
western half of the US, at which time those western portion of NRS-FIA and
SRS-FIA states will also be completed.

NatureServe scientists Don Faber Langendoen and Shannon Menard first completed
a narrative-based key that used available FIA attributes and tree species and
life-history data to assign P2 plot conditions to 27 macrogroup types and 11
plantation types in eastern US. The process of computerizing the key was
conducted primarily by Kevin Nimerfro. Once the first iteration of the key was
completed, it was translated into a Python program (by Kevin Nimerfro), which
is used to assign macrogroup codes to plot conditions. The Python program was
generated from a set of configuration files that describe the logic and flow of
the couplets in the key hierarchy. These configuration files allow for frequent
code changes including restructuring of the hierarchy. Likewise, it will be
easy to extend the key (e.g. include the Western U.S.) or develop a separate
key for another region of interest (e.g. a single state) – once NatureServe
develops new keys for the West.
