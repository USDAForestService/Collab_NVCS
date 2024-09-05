let btnFetchExistingJson = document.getElementById("btn-fetch-existing-json");
let detectedJsonContainer = document.getElementById("detected-json-container");

var InputFilterTypes = [
    "state",
    "ecoregion",
    "plantation",
    "hydric",
    "riverine",
    "species",
    "wetland",
    "ruderal",
    "exotic",
    "softwoodhardwood",
    "planted",
    "tallytree"
];

var nodeJson;
var nodeHierarchy;
var hierarchy;

btnFetchExistingJson.addEventListener('click', async (event) => {
    // Query for JSON and TXT data
    const returnedData = await window.electronAPI.fetchExistingJson();
    nodeJson = JSON.parse(returnedData.json);
    nodeHierarchy = returnedData.hierarchy;

    // Generate objects from returned JSON and TXT data
    let hierarchySplit = nodeHierarchy.split('\r\n');
    hierarchy = [];
    for (let split of hierarchySplit) {
        let tabCount = (split.match(/\t/g) || []).length;
        let tablessSplit = split.replaceAll('\t', '');
        let associatedNode = nodeJson.filter(i => i.node.name === tablessSplit)[0];
        hierarchy.push({
            fileName: associatedNode.node.fileName,
            hierarchyName: associatedNode.node.name,
            hierarchyLevel: tabCount,
            hierarchyLineNumber: hierarchy.length + 1,
            node: associatedNode.node,
            parent: null,
            children: [],
        });

        let latestEntry = hierarchy[hierarchy.length - 1];
        for (let i = hierarchy.length - 2; i >= 0; i--) {
            let previousEntry = hierarchy[i];
            if (previousEntry.hierarchyLevel == latestEntry.hierarchyLevel - 1) {
                latestEntry.parent = previousEntry;
                previousEntry.children.push(latestEntry);
                break;
            }
        }
    }
    console.log(hierarchy);

    // Generate HTML tree
    nodeDisplay = "<ul>";
    let rootElements = hierarchy.filter(i => i.hierarchyLevel == 0);
    for (let rootElement of rootElements)
        nodeDisplay += generateListEntry(rootElement);
    nodeDisplay += "</ul>";

    // Display results
    detectedJsonContainer.innerHTML = nodeDisplay;
});

function generateListEntry(element) {
    returnString = "<li class='hierarchyNode'>";
    returnString += `<button class='hierarchyNodeButton' onclick='openJsonDialog(${element.hierarchyLineNumber})'>${element.hierarchyName}</button>`;
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateListEntry(child);
    returnString += "</ul>";
    returnString += "</li>";
    return returnString;
}

function openJsonDialog(hierarchyLineNumber) {
    const dialog = document.getElementById("json-dialog");
    dialog.classList.remove("hidden");

    const hierarchyElement = hierarchy.filter(i => i.hierarchyLineNumber == hierarchyLineNumber)[0];
    console.log(hierarchyElement);

    document.getElementById("node-hierarchyName").value = hierarchyElement.hierarchyName;
    document.getElementById("node-nodeDescription").value = hierarchyElement.node.description;
    document.getElementById("node-hierarchyLevel").value = hierarchyElement.hierarchyLevel;
    document.getElementById("node-hierarchyLineNumber").value = hierarchyElement.hierarchyLineNumber;
    document.getElementById("node-nodeID").value = hierarchyElement.node.id;
    document.getElementById("node-nodeLevel").value = hierarchyElement.node.level;
    document.getElementById("node-nodeTrigger").value = hierarchyElement.node.trigger;

    let nodeFilterContent = "";
    const filterKeys = Object.keys(hierarchyElement.node.filters);
    for (const filterKey of filterKeys) {
        
        let inputFilterContent = "";
        const filterValueArray = hierarchyElement.node.filters[filterKey];
        for (const filterValueArrayElement of filterValueArray) {

            const inputFilterKeys = Object.keys(filterValueArrayElement);
            for (const inputFilterKey of inputFilterKeys) {

                const inputFilterValue = filterValueArrayElement[inputFilterKey];
                inputFilterContent += createInputFilter(filterKey, inputFilterKey, inputFilterValue);
            }
        }

        nodeFilterContent += createFilter(filterKey, inputFilterContent);
    }

    nodeFilterContent += `
        <div class='add-filter-container'>
            <button onclick="addFilter()">
                Add Filter
            </button>
        </div>
    `;

    document.getElementById("node-nodeFilters").innerHTML = nodeFilterContent;
}

function closeJsonDialog() {
    const dialog = document.getElementById("json-dialog");
    dialog.classList.add("hidden");
}

function createElementFromString(htmlString) {
    const template = document.createElement("template");
    template.innerHTML = htmlString.trim();
    return template.content.firstChild;
}

function addFilter() {
    const addFilterButton = document.querySelector(".add-filter-container");
    const filterContainer = addFilterButton.parentElement;
    const newFilterHtml = createFilter(null, null);
    const newFilterElement = createElementFromString(newFilterHtml);
    filterContainer.insertBefore(newFilterElement, addFilterButton);
}

function addInputFilter(identifier) {
    const filterContainer = document.getElementById(identifier);
    const inputFiltersContainer = filterContainer.querySelector(".input-filters-container")
    const newInputFilterHtml = createInputFilter(null, null, null);
    inputFiltersContainer.insertAdjacentHTML('beforeEnd', newInputFilterHtml);
}

function createFilter(filterKey, inputFilters) {
    if (!filterKey)
        filterKey = "";

    if (!inputFilters)
        inputFilters = "";


    let identifier = newGuid();
    let html = `
    <div class='filter-container' id="${identifier}">
        <div class='sub-content-header-container'>
            <label for="filter-${filterKey}">Name:</label>
            <input type="text" id="filter-${filterKey}" value="${filterKey}" />
            <button onclick="deleteElement('${identifier}')">Delete Filter</button>
        </div>
        <div class='sub-content-container'>
            <div class='sub-key-holder'>
                Input Type
            </div>
            <div class='sub-value-holder'>
                Value
            </div>
        </div>
        <div class='input-filters-container'>
            ${inputFilters}
        </div>
        <div class='sub-content-button-container'>
            <button onclick="addInputFilter('${identifier}')">
                Add
            </button>
        </div>
    </div>
    `;

    return html;
}

function createInputFilter(filterKey, inputFilterKey, inputFilterValue) {
    if (!filterKey)
        filterKey = "";
    
    if (!inputFilterKey)
        inputFilterKey = "";

    if (!inputFilterValue)
        inputFilterValue = "";

    let filterSelectBoxOptions;
    for (const filterType of InputFilterTypes) {
        const selected = filterType == inputFilterKey ? "selected" : "";
        filterSelectBoxOptions += `
            <option value="${filterType}" ${selected}>
                ${filterType}
            </option>
        `;
    }

    const identifier = newGuid();
    let html = `
    <div class='sub-content-container' id="${identifier}" >
        <select class='sub-key-holder' value="${inputFilterKey}">
        ${filterSelectBoxOptions}
        </select>
        <input type="text" class='sub-value-holder' value="${inputFilterValue}"/>
        <button onclick="deleteElement('${identifier}')">Delete</button>
    </div>
    `

    return html;
}

function deleteElement(identifier) {
    const container = document.getElementById(identifier);
    container.remove();
}

function newGuid() {
    return "id" + Math.random().toString(16).slice(2);
}
