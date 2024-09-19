const { app, BrowserWindow, ipcMain } = require('electron');
const path = require('node:path');
const fs = require('fs');

// Handle creating/removing shortcuts on Windows when installing/uninstalling.
if (require('electron-squirrel-startup')) {
  app.quit();
}

const createWindow = () => {
  // Create the browser window.
  const mainWindow = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, 'preload.js'),
    },
  });

  // and load the index.html of the app.
  mainWindow.loadFile(path.join(__dirname, 'index.html'));

  // Open the DevTools.
  mainWindow.webContents.openDevTools();
};

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.whenReady().then(() => {
  ipcMain.handle('fetch-existing-json', fetchExistingJson);
  ipcMain.handle('update-json', updateJson);
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

async function fetchExistingJson(event) {
  console.log('INVOKED: fetxhExistingJson');

  // Retrieve Key Node JSON files
  const jsonDirectory = __dirname + '../../../nvcs-dev/nvcs_config/west/key-nodes/';
  console.log(`- Target JSON Directory: ${jsonDirectory}`);

  let cleanedJsonData = [];
  let jsonFiles = fs.readdirSync(jsonDirectory).filter(file => path.extname(file) === '.json');
  jsonFiles.forEach(file => {
    let jsonPath = path.join(jsonDirectory, file);
    let data = fs.readFileSync(jsonPath);
    let jsonData = JSON.parse(data);
    jsonData["node"]["fileName"] = path.basename(file);
    let stringData = JSON.stringify(jsonData);
    let cleanedData = stringData.trim();
    cleanedJsonData.push(cleanedData);
  })

  allJsonData = `[${cleanedJsonData.join(',')}]`;

  // Retrieve Key Hierarchy TXT file
  const hierarchyPath = __dirname + '../../../nvcs-dev/nvcs_config/west/key-hierarchy.txt';
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
  try {
    // Attempt to make new config directory
    const existingJsonConfigDirectory = __dirname + "../../../nvcs-dev/nvcs_config/";
    const newJsonDirectoryPath = path.join(existingJsonConfigDirectory, directory);
    if (!fs.existsSync(newJsonDirectoryPath))
      fs.mkdirSync(newJsonDirectoryPath);

    // Attempt to make new key-nodes directory
    const newKeyNodesDirectoryPath = path.join(newJsonDirectoryPath, "key-nodes");
    if (!fs.existsSync(newKeyNodesDirectoryPath))
      fs.mkdirSync(newKeyNodesDirectoryPath);

    // Prepare hierarchy content
    const hierarchyPath = path.join(newJsonDirectoryPath, "key-hierarchy.txt");
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
      const jsonFilePath = path.join(newKeyNodesDirectoryPath, entry.fileName);
      const jsonAsText = JSON.stringify(jsonNode, null, 4);
      fs.writeFileSync(jsonFilePath, jsonAsText);
    }

    // Write hierarchy file content
    fs.writeFileSync(hierarchyPath, hierarchyContent);
    return true;
  }
  catch (error) {
    console.error(error);
    return false;
  }
}
