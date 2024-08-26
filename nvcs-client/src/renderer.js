let btnFetchExistingJson = document.getElementById("btn-fetch-existing-json");
let detectedJsonContainer = document.getElementById("detected-json-container");

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
    nodeDisplay += "<ul>";

    // Display results
    detectedJsonContainer.innerHTML = nodeDisplay;
});

function generateListEntry(element) {
    returnString = "<li class='hierarchyNode'>";
    returnString += `<button class='hierarchyNodeLink' onclick='openJsonDialog(${element.hierarchyLineNumber})'>${element.hierarchyName}</button>`;
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
    document.getElementById("node-nodeFilters").value = hierarchyElement.node.filters;
}

function closeJsonDialog() {
    const dialog = document.getElementById("json-dialog");
    dialog.classList.add("hidden");
}
