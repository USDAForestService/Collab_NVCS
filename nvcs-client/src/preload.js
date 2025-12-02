// See the Electron documentation for details on how to use preload scripts:
// https://www.electronjs.org/docs/latest/tutorial/process-model#preload-scripts
const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('electronAPI', {
    fetchExistingJson: (targetPath) => ipcRenderer.invoke('fetch-existing-json', targetPath),
    fetchPackagedJson: (packagedJsonType) => ipcRenderer.invoke('fetch-packaged-json', packagedJsonType),
    updateJson: (config) => ipcRenderer.invoke('update-json', config),
    fetchSpecies: (type) => ipcRenderer.invoke('fetch-species', type),
    openBrowse: (targetPath) => ipcRenderer.invoke('open-browse', targetPath),
    openSaveDirectory: (targetPath) => ipcRenderer.invoke('open-save-directory', targetPath),
    openSaveDocument: (targetPath) => ipcRenderer.invoke('open-save-document', targetPath),
    executeTester: (targetPath, testSettings) => ipcRenderer.invoke('execute-tester', targetPath, testSettings),
    openDirectory: (targetPath) => ipcRenderer.invoke('open-directory', targetPath),
    fetchSettings: (type) => ipcRenderer.invoke('fetch-settings', type),
    fetchYears: (type) => ipcRenderer.invoke('fetch-years', type),
    markUnsavedChanges: (value) => ipcRenderer.invoke('mark-unsaved-changes', value),
    getApplicationVersion: () => ipcRenderer.invoke('get-application-version'),
    saveDocumentWordFormat: (targetPath, html) => ipcRenderer.invoke('save-document-word-format', targetPath, html)
});
