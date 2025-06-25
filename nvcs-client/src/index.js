const { app, BrowserWindow, ipcMain, dialog } = require('electron');
const path = require('node:path');
const fs = require('fs');
const ini = require('ini');
const child_process = require("child_process");
const util = require("util");
const HTMLtoDOCX = require('html-to-docx');
const execFile = util.promisify(child_process.execFile);

let mainWindow;
let unsavedChanges = false;

// Handle creating/removing shortcuts on Windows when installing/uninstalling.
if (require('electron-squirrel-startup')) {
  app.quit();
}

const createWindow = () => {
  // Create the browser window.
  mainWindow = new BrowserWindow({
    width: 800,
    height: 600,
    show: false,
    webPreferences: {
      preload: path.join(__dirname, 'preload.js'),
    },
  });
  mainWindow.maximize();
  mainWindow.show();

  // and load the index.html of the app.
  mainWindow.loadFile(path.join(__dirname, 'index.html'));

  // Bind a close event
  mainWindow.on('close', (e) => {
    if (!unsavedChanges)
      return;
    const confirm = dialog.showMessageBoxSync(mainWindow, {
      type: 'warning',
      buttons: ['Yes', 'No'],
      defaultId: 0,
      title: 'Unsaved Changes Detected',
      message: 'You have unsaved changes detected. Are you sure you want to exit the application and risk losing these changes?'
    });
    if (confirm === 1)
      e.preventDefault();
  });

  // Open the DevTools.
  if (!app.isPackaged)
    mainWindow.webContents.openDevTools();
};

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.whenReady().then(() => {
  // Forge will automatically create a copy via forge.config.js
  if (!app.isPackaged)
    createDefaultConfigFile();

  ipcMain.handle('fetch-existing-json', fetchExistingJson);
  ipcMain.handle('update-json', updateJson);
  ipcMain.handle('fetch-species', fetchSpecies);
  ipcMain.handle('open-browse', openBrowseDialog);
  ipcMain.handle('open-save-directory', openSaveDirectoryDialog);
  ipcMain.handle('open-save-document', openSaveDocumentDialog);
  ipcMain.handle('execute-tester', executeTester);
  ipcMain.handle('open-directory', openDirectory);
  ipcMain.handle('fetch-settings', fetchSettings);
  ipcMain.handle('fetch-years', fetchAvailableYears);
  ipcMain.handle('mark-unsaved-changes', markUnsavedChanges);
  ipcMain.handle('get-application-version', getApplicationVersion);
  ipcMain.handle('save-document-word-format', saveDocumentWordFormat);
  createWindow();

  // On OS X it's common to re-create a window in the app when the
  // dock icon is clicked and there are no other windows open.
  app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow();
    }
  });
});

// Quit when all windows are closed, except on macOS. There, it's common
// for applications and their menu bar to stay active until the user quits
// explicitly with Cmd + Q.
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

// In this file you can include the rest of your app's specific main process
// code. You can also put them in separate files and import them here.

async function fetchExistingJson(event, targetPath) {
  console.log('INVOKED: fetxhExistingJson');

  // Retrieve Key Node JSON files
  const jsonDirectory = path.resolve((targetPath ?? getConfigurationPath()) + '/key-nodes/');
  console.log(`- Target JSON Directory: ${jsonDirectory}`);

  let cleanedJsonData = [];
  let jsonFiles = fs.readdirSync(jsonDirectory).filter(file => path.extname(file) === '.json');
  jsonFiles.forEach(file => {
    let jsonPath = path.resolve(path.join(jsonDirectory, file));
    let data = fs.readFileSync(jsonPath);
    let jsonData = JSON.parse(data);
    jsonData["node"]["fileName"] = path.basename(file);
    let stringData = JSON.stringify(jsonData);
    let cleanedData = stringData.trim();
    cleanedJsonData.push(cleanedData);
  })

  let allJsonData = `[${cleanedJsonData.join(',')}]`;

  // Retrieve Key Hierarchy TXT file
  const hierarchyPath = path.resolve((targetPath ?? getConfigurationPath()) + '/key-hierarchy.txt');
  console.log(`- Target Hierarchy Path: ${hierarchyPath}`);

  let hierarchyData = fs.readFileSync(hierarchyPath);
  let hierarchyString = hierarchyData.toString();

  // Retrieve document structure JSON
  let documentStructureString;
  const documentStructurePath = path.resolve((targetPath ?? getConfigurationPath()) + '/document.json');
  if (fs.existsSync(documentStructurePath)) {
    console.log(`- Target Document Structure Path: ${documentStructurePath}`);
    let documentStructureData = fs.readFileSync(documentStructurePath);
    documentStructureString = documentStructureData.toString();
  }

  // Combine and return data
  let returnData = {
    json: allJsonData,
    hierarchy: hierarchyString,
    documentStructure: documentStructureString
  }

  // Mark unaved as false
  unsavedChanges = false;

  console.log("- RETURNING RESULTS");
  return returnData;
}

async function updateJson(event, directory, json, changes, documentStructure, alerts) {
  console.log('INVOKED: updateJson');

  // Attempt to make new config directory
  const newJsonDirectoryPath = path.resolve(directory);
  if (!fs.existsSync(newJsonDirectoryPath))
    fs.mkdirSync(newJsonDirectoryPath);

  // Attempt to delete & recreate new key-nodes directory
  const newKeyNodesDirectoryPath = path.resolve(path.join(newJsonDirectoryPath, "key-nodes"));
  if (fs.existsSync(newKeyNodesDirectoryPath))
    fs.rmSync(newKeyNodesDirectoryPath, { recursive: true, force: true });
  fs.mkdirSync(newKeyNodesDirectoryPath);

  // Prepare hierarchy content
  const hierarchyPath = path.resolve(path.join(newJsonDirectoryPath, "key-hierarchy.txt"));
  let hierarchyContent = "";

  // Filter away the root
  json = json.filter(i => i.hierarchyName != "ROOT");

  // Sort JSON on hierarchy line number
  json.sort((a, b) => { return a.hierarchyLineNumber - b.hierarchyLineNumber });

  for (const entry of json) {
    // Store hierarchy element content
    const hierarchyName = entry.hierarchyName;
    const hierarchyLevel = entry.hierarchyLevel;
    const hierarchyTabs = "\t".repeat(hierarchyLevel);
    const hierarchyNewLine = hierarchyTabs + hierarchyName + "\r\n";
    hierarchyContent += hierarchyNewLine

    // Stringify & write JSON content
    const jsonNode = { node: entry.node };
    const jsonFilePath = path.resolve(path.join(newKeyNodesDirectoryPath, entry.fileName));
    let jsonAsText = JSON.stringify(jsonNode, null, 4);
    jsonAsText = jsonAsText.trim();
    fs.writeFileSync(jsonFilePath, jsonAsText);
  }

  // Write hierarchy file content
  hierarchyContent = hierarchyContent.trim();
  fs.writeFileSync(hierarchyPath, hierarchyContent);

  // Update changelog
  const changeLogPath = path.resolve(path.join(newJsonDirectoryPath, "changelog.txt"));
  let existingChangeLogEntry = "";
  if (fs.existsSync(changeLogPath))
    existingChangeLogEntry = fs.readFileSync(changeLogPath);
  const newChangeLogEntry = generateChangeLogEntry(changes);
  const updatedChangeLog = newChangeLogEntry + existingChangeLogEntry;
  fs.writeFileSync(changeLogPath, updatedChangeLog);

  // Update document structure
  const documentStructurePath = path.resolve(path.join(newJsonDirectoryPath, "document.json"));
  let documentStructureJson = JSON.stringify(documentStructure, null, 4);
  documentStructureJson = documentStructureJson.trim();
  fs.writeFileSync(documentStructurePath, documentStructureJson);

  // Update alerts file
  const alertsJson = JSON.stringify(alerts, null, 4);
  const alertsPath = path.resolve(path.join(newJsonDirectoryPath, "alerts.json"));
  fs.writeFileSync(alertsPath, alertsJson);

  // Mark unaved as false
  unsavedChanges = false;

  console.log("- RETURNING RESULTS");
  return true;
}

async function fetchSpecies(event) {
  console.log("INVOKED: fetchSpecies")

  // Find species file
  const speciesPath = path.resolve(getConfigurationPath() + '/species.csv');
  console.log(`- Target Species File: ${speciesPath}`);

  // Extract species from file
  const fileContent = fs.readFileSync(speciesPath, 'utf-8');
  const species = fileContent.split("\r\n");

  // Return species
  console.log("- RETURNING RESULTS");
  return species;
}

function getConfigurationPath() {
  let relative = path.join(getProjectResourcePath(), 'nvcs-dev/nvcs_config/west')
  return path.resolve(relative);
}

async function openBrowseDialog(event, targetPath) {
  console.log("INVOKED: openBrowseDialog");

  console.log(`- Target Browse Path: ${targetPath}`);
  const { cancelled, filePaths } = await dialog.showOpenDialog(mainWindow, {
    defaultPath: targetPath,
    title: "Open JSON Directory",
    properties: [
      'openDirectory'
    ],
  });

  console.log("- RETURNING RESULTS");
  const path = !cancelled ? filePaths[0] : null;
  return path;
}

async function openSaveDirectoryDialog(event, targetPath) {
  console.log("INVOKED: openSaveDirectoryDialog");

  console.log(`- Target Save Path: ${targetPath}`);
  const { cancelled, filePaths } = await dialog.showOpenDialog(mainWindow, {
    defaultPath: targetPath,
    buttonLabel: "Save",
    title: "Save JSON Directory",
    properties: [
      'openDirectory',
    ]
  });

  console.log("- RETURNING RESULTS");
  const path = !cancelled ? filePaths[0] : null;
  return path;
}


async function openSaveDocumentDialog(event, targetPath) {
  console.log("INVOKED: openSaveDocumentDialog");

  console.log(`- Target Save Path: ${targetPath}`);
  const { cancelled, filePath } = await dialog.showSaveDialog(mainWindow, {
    defaultPath: targetPath,
    buttonLabel: "Save",
    title: "Save Word Document",
    filters: [
      { 
        name: "Documents",
        extensions: ['docx']
      },
      {
        name: "All Files",
        extensions: ["*"]
      }
    ]
  });

  console.log("- RETURNING RESULTS");
  const path = !cancelled ? filePath : null;
  return path;
}

async function executeTester(event, targetPath, testSettings) {
  console.log("INVOKED: executeTester");

  const pythonPath = getPythonPath();
  console.log("- Target Python Path:", pythonPath);

  const builderPath = getBuilderPyPath();
  console.log("- Target Builder.py Path:", builderPath);
  
  let config = getPythonConfigFile();
  config.Config.ProjectRoot = getProjectResourcePath();
  config.WestConfig.In_ConfigPath = path.resolve(targetPath);
  config.FullOutputConfig.SkipSharedTables = "True";
  config.FullOutputConfig.Out_DbPath = path.resolve(path.join(targetPath, "nvcs-output.db"));
  config.FullOutputConfig.Out_TesterResultsPath = getOutPath();
  config.FullOutputConfig.Out_DebugLogPath = getDebugLogPath();
  config.FullOutputConfig.Out_FixupCsvPath = getFixupCsvPath();
  config.FullOutputConfig.InventoryYears = `[${testSettings.inventoryYears.join(',')}]`;
  config.FullOutputConfig.AdditionalWhereClause = testSettings.additionalWhere;
  setPythonConfigFile(config);

  console.log("- Executing Builder Script...");
  let builderResults = await execFile(pythonPath, [builderPath]);
  console.log("- Builder Results", builderResults);

  // Clone table
  let copyTablePath =  parseIniPath(config.FullOutputConfig.Out_DbPath, config);
  if (!testSettings.keepExisting || !fs.existsSync(copyTablePath)) {
    console.log("- Creating base SQLite output file...")
    let sharedTablePath = getSharedTablePath();
    fs.copyFileSync(sharedTablePath, copyTablePath);
  }

  // Execute full output
  console.log("- Executing Full Output Script...");
  let fullOutputPath = getFullOutputPyPath();
  let fullOutputResults = await execFile(pythonPath, [fullOutputPath]);
  console.log("- Full Output Results", fullOutputResults);

  console.log("- RETURNING RESULTS");
  return {
    success: true,
    builderMessage: builderResults,
    fullOutputMessage: fullOutputResults,
    outputDbPath: config.FullOutputConfig.Out_DbPath
  };
}

function getPythonPath() {
  let redistPath = app.isPackaged ? "redist" : "nvcs-client/redist";
  let relative = path.join(getProjectResourcePath(), redistPath, 'python/python.exe')
  return path.resolve(relative);
}

function createDefaultConfigFile() {
  const source = getPythonConfigFilePath();
  const target = getDefaultPythontConfigFilePath();
  fs.copyFileSync(source, target);
}

function getPythonConfigFile(targetPath = null) {
  const configFilePath = targetPath ?? getPythonConfigFilePath();
  
  let configFile = fs.readFileSync(configFilePath, 'utf-8');
  configFile = configFile.replaceAll(/(^|\r\n)([^: ]*): /gi, "$1$2 = ");;
  configFile = configFile.replaceAll(":\r\n", "=\r\n");

  const config = ini.parse(configFile);
  return config;
}

function setPythonConfigFile(config) {
  const configFilePath = getPythonConfigFilePath();

  let configFileString = ini.stringify(config, {
    whitespace: true
  });
  configFileString = configFileString.replaceAll(/(^|\r\n)([^ =]*) = /gi, "$1$2: ");
  configFileString = configFileString.replaceAll("\"", "");
  configFileString = configFileString.replaceAll(": \r\n", ":\r\n");
  configFileString = configFileString.replaceAll("${Config=", "${Config:");
  fs.writeFileSync(configFilePath, configFileString);
}

function getPythonConfigFilePath() {
  let relative = path.join(getProjectResourcePath(), 'nvcs-dev/nvcs_builder/debug_config.ini')
  return path.resolve(relative);
}

function getDefaultPythontConfigFilePath() {
  let relativeConfig = 'debug_config.ini';
  if (!app.isPackaged)
    relativeConfig = 'nvcs-data/debug_config.ini';

  let relative = path.join(getProjectResourcePath(), relativeConfig)
  return path.resolve(relative);
}

function getBuilderPyPath() {
  let relative = path.join(getProjectResourcePath(), 'nvcs-dev/nvcs_builder/builder.py')
  return path.resolve(relative);
}

function getFullOutputPyPath() {
  let relative = path.join(getProjectResourcePath(), 'nvcs-dev/nvcs_tester/full_output.py')
  return path.resolve(relative);
}

function getPlotIoPyPath() {
  let relative = path.join(getProjectResourcePath(), 'nvcs-dev/nvcs_tester/plot_io.py')
  return path.resolve(relative);
}

function getProjectResourcePath() {
  let relative = process.resourcesPath;
  if (!app.isPackaged)
    relative = path.join(__dirname, '../../');
  return path.resolve(relative);
}

function getSharedTablePath() {
  let relativeTable = "west_shared_tables.db";
  if (!app.isPackaged)
    relativeTable = "nvcs-data/run_output/west/west_shared_tables.db";

  let relative = path.join(getProjectResourcePath(), relativeTable);
  return path.resolve(relative);
}

function getOutPath() {
  let relativeTable = "TEMP_nvcs_full_output.out";
  if (!app.isPackaged)
    relativeTable = "nvcs-data/run_output/west/TEMP_nvcs_full_output.out";

  let relative = path.join(getProjectResourcePath(), relativeTable);
  return path.resolve(relative);
}

function getDebugLogPath() {
  let relativeTable = "TEMP_nvcs_full_output.log";
  if (!app.isPackaged)
    relativeTable = "nvcs-data/run_output/west/TEMP_nvcs_full_output.log";

  let relative = path.join(getProjectResourcePath(), relativeTable);
  return path.resolve(relative);
}

function getFixupCsvPath() {
  let relativeTable = "TEMP_nvcs_full_output.csv";
  if (!app.isPackaged)
    relativeTable = "nvcs-data/run_output/west/TEMP_nvcs_full_output.csv";

  let relative = path.join(getProjectResourcePath(), relativeTable);
  return path.resolve(relative);
}

function parseIniPath(path, config) {
  const projectRoot = config.Config.ProjectRoot;
  const parsedPath = path.replaceAll("${Config:ProjectRoot}", projectRoot);
  return parsedPath;
}

async function openDirectory(event, targetPath) {
  console.log("INVOKED: openDirectory");

  let command = "";
  if (process.platform.startsWith("win"))
    command = "explorer";
  else if (process.platform == "darwin")
    command = "open";
  else if (process.platform == "linux")
    command = "xdg-open";
  else
    throw new Error("Unable to determine which command to open for the following platform", process.platform);

  if (!fs.existsSync(targetPath))
    throw new Error("Provided path does not exist");

  let fullCommand = `${command} ${targetPath}`;
  console.log(`- Executing: ${fullCommand}`);
  child_process.exec(fullCommand);

  console.log("- RETURNING RESULTS");
  return true;
}

async function fetchSettings(event) {
  console.log("INVOKED: fetchSettings");

  const defaultPath = getDefaultPythontConfigFilePath();
  const config = getPythonConfigFile(defaultPath);
  
  const response = {
    inventoryYears: config.FullOutputConfig.InventoryYears,
    additionalWhere: config.FullOutputConfig.AdditionalWhereClause
  };

  console.log("- RETURNING RESULTS");
  return response;
}

async function fetchAvailableYears(event) {
  console.log("INVOKED: fetchAvailableYears");

  const pythonPath = getPythonPath();
  console.log("- Target Python Path:", pythonPath);

  // Get source table & column
  const defaultConfigPath = getDefaultPythontConfigFilePath();
  const config = getPythonConfigFile(defaultConfigPath);
  const table = config.FullOutputConfig.AnlyTestDataName;
  const column = "INVYR";

  // Execute Plot IO
  console.log("- Executing Plot IO Script...");
  const scriptPath = getPlotIoPyPath();
  const dbPath = getSharedTablePath();
  const results = await execFile(pythonPath, [scriptPath, "get_unique_values_sqlite", dbPath, table, column]);
  console.log("- Plot IO  Results", results);

  // Parse results
  let response = results.stdout.replace('[', '').replace(']\r\n', '').split(',');

  console.log("- RETURNING RESULTS");
  return response;
}

function generateChangeLogEntry(message) {
  const timestamp = new Date().toISOString();
  if (!message || message == "")
    message = "~ No changes detected";
  const entry = `### Saved at ${timestamp} (UTC):\r\n${message}\r\n\r\n`;
  return entry;
}

async function markUnsavedChanges(value) {
  unsavedChanges = value;
}

async function getApplicationVersion() {
  return app.getVersion();
}

async function saveDocumentWordFormat(event, targetPath, html) {
  console.log("INVOKED: saveDocumentWordFormat");

  const fullTargetPath = path.resolve(targetPath);
  console.log("- Full Target Path:", fullTargetPath);

  const headerString = null;
  const footerString = null;
  const documentOptions = {
    table: { row: { cantSplit: false } },
    footer: true,
    pageNumber: true,
  };
  const fileBuffer = await HTMLtoDOCX(html, headerString, documentOptions, footerString);

  console.log("- Executing file write");
  fs.writeFileSync(fullTargetPath, fileBuffer);

  console.log("- RETURNING RESULTS");
  return fullTargetPath;
}