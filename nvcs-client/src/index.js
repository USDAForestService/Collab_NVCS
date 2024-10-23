const { app, BrowserWindow, ipcMain, dialog } = require('electron');
const path = require('node:path');
const fs = require('fs');
const ini = require('ini');
const child_process = require("child_process");
const util = require("util");
const execFile = util.promisify(child_process.execFile);

let mainWindow;

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
  ipcMain.handle('execute-tester', executeTester);
  ipcMain.handle('open-directory', openDirectory);
  ipcMain.handle('fetch-settings', fetchSettings);
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

  allJsonData = `[${cleanedJsonData.join(',')}]`;

  // Retrieve Key Hierarchy TXT file
  const hierarchyPath = path.resolve((targetPath ?? getConfigurationPath()) + '/key-hierarchy.txt');
  console.log(`- Target Hierarchy Path: ${hierarchyPath}`);

  let hierarchyData = fs.readFileSync(hierarchyPath);
  let hierarchyString = hierarchyData.toString();

  // Combine and return data
  returnData = {
    json: allJsonData,
    hierarchy: hierarchyString
  }

  console.log("- RETURNING RESULTS");
  return returnData;
}

async function updateJson(event, directory, json) {
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
    properties: ['openDirectory'],
    promptToCreate: true
  });

  console.log("- RETURNING RESULTS");
  const path = !cancelled ? filePaths[0] : null;
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
  config.FullOutputConfig.InventoryYears = `[${testSettings.inventoryYears.join(',')}]`;
  config.FullOutputConfig.AdditionalWhereClause = testSettings.additionalWhere;
  setPythonConfigFile(config);

  console.log("- Executing Builder Script...");
  var builderResults = await execFile(pythonPath, [builderPath]);
  console.log("- Builder Results", builderResults);

  // Clone table
  console.log("- Creating base SQLite output file...")
  var sharedTablePath = getSharedTablePath();
  var copyTablePath =  parseIniPath(config.FullOutputConfig.Out_DbPath, config);
  fs.copyFileSync(sharedTablePath, copyTablePath);

  // Execute full output
  console.log("- Executing Full Output Script...");
  var fullOutputPath = getFullOutputPyPath();
  var fullOutputResults = await execFile(pythonPath, [fullOutputPath]);
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
  configFile = configFile.replaceAll(": ", "=");
  configFile = configFile.replaceAll(":\r\n", "=\r\n");

  const config = ini.parse(configFile);
  return config;
}

function setPythonConfigFile(config) {
  const configFilePath = getPythonConfigFilePath();

  let configFileString = ini.stringify(config, {
    whitespace: true
  });
  configFileString = configFileString.replaceAll(" = ", ": ");
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
    new Error("Unable to determine which command to open for the following platform", process.platform);

  let fullCommand = `${command} ${targetPath}`;
  console.log(`- Executing: ${fullCommand}`);
  await child_process.exec(fullCommand);

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
