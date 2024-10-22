// See the Electron documentation for details on how to use preload scripts:
// https://www.electronjs.org/docs/latest/tutorial/process-model#preload-scripts
const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('electronAPI', {
    fetchExistingJson: (targetPath) => ipcRenderer.invoke('fetch-existing-json', targetPath),
    updateJson: (directory, json) => ipcRenderer.invoke('update-json', directory, json),
    fetchSpecies: () => ipcRenderer.invoke('fetch-species'),
    openBrowse: (targetPath) => ipcRenderer.invoke('open-browse', targetPath),
    executeTester: (targetPath) => ipcRenderer.invoke('execute-tester', targetPath),
});
