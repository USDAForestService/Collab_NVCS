// See the Electron documentation for details on how to use preload scripts:
// https://www.electronjs.org/docs/latest/tutorial/process-model#preload-scripts
const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('electronAPI', {
    fetchExistingJson: (targetPath) => ipcRenderer.invoke('fetch-existing-json', targetPath),
    updateJson: (directory, json, changes) => ipcRenderer.invoke('update-json', directory, json, changes),
    fetchSpecies: () => ipcRenderer.invoke('fetch-species'),
    openBrowse: (targetPath) => ipcRenderer.invoke('open-browse', targetPath),
    executeTester: (targetPath, testSettings) => ipcRenderer.invoke('execute-tester', targetPath, testSettings),
    openDirectory: (targetPath) => ipcRenderer.invoke('open-directory', targetPath),
    fetchSettings: () => ipcRenderer.invoke('fetch-settings'),
    fetchYears: () => ipcRenderer.invoke('fetch-years'),
    markUnsavedChanges: (value) => ipcRenderer.invoke('mark-unsaved-changes', value),
    getApplicationVersion: () => ipcRenderer.invoke('get-application-version')
});
