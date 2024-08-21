let btnFetchExistingJson = document.getElementById("btn-fetch-existing-json");
let detectedJsonContainer = document.getElementById("detected-json-container");

btnFetchExistingJson.addEventListener('click', async (event) => {
    const existingJson = await window.electronAPI.fetchExistingJson();
    const jsonObject = JSON.parse(existingJson);
    console.log(existingJson, jsonObject);

    detectedJsonContainer.innerHTML = existingJson;
});
