// See the Electron documentation for details on how to use preload scripts:
// https://www.electronjs.org/docs/latest/tutorial/process-model#preload-scripts
const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('electronAPI', {
    fetchExistingJson: () => ipcRenderer.invoke('fetch-existing-json'),
    updateJson: (directory, json) => ipcRenderer.invoke('update-json', directory, json)
});
