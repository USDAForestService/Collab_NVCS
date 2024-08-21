let btnFetchExistingJson = document.getElementById("btn-fetch-existing-json");
let detectedJsonContainer = document.getElementById("detected-json-container");

btnFetchExistingJson.addEventListener('click', async (event) => {
    const returnedData = await window.electronAPI.fetchExistingJson();
    const nodeJson = JSON.parse(returnedData.json);
    const nodeHierarchy = returnedData.hierarchy;
    console.log(nodeJson, nodeHierarchy);

    detectedJsonContainer.innerHTML = nodeHierarchy;
});
