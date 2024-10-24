const { app, BrowserWindow, ipcMain, dialog } = require('electron');
const path = require('node:path');
const fs = require('fs');
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
    webPreferences: {
      preload: path.join(__dirname, 'preload.js'),
    },
  });

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
  ipcMain.handle('fetch-existing-json', fetchExistingJson);
  ipcMain.handle('update-json', updateJson);
  ipcMain.handle('fetch-species', fetchSpecies);
  ipcMain.handle('open-browse', openBrowseDialog);
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
  return app.isPackaged ? process.resourcesPath + "/west" : __dirname + '../../../nvcs-dev/nvcs_config/west';
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
