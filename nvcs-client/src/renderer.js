let btnFetchExistingJson = document.getElementById("btn-fetch-existing-json");
let detectedJsonContainer = document.getElementById("detected-json-container");

var nodeJson;
var nodeHierarchy;

btnFetchExistingJson.addEventListener('click', async (event) => {
    const returnedData = await window.electronAPI.fetchExistingJson();
    nodeJson = JSON.parse(returnedData.json);
    nodeHierarchy = returnedData.hierarchy;

    let hierarchySplit = nodeHierarchy.split('\r\n');
    let hierarchy = [] 
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

    nodeDisplay = "";
    const tabSpace = "&nbsp;&nbsp;";
    for (let element of hierarchy) {
        for (let i = 0; i < element.hierarchyLevel; i++)
            nodeDisplay += tabSpace;

        nodeDisplay += element.hierarchyName;
        nodeDisplay += "<br>";
    }

    detectedJsonContainer.innerHTML = nodeDisplay;
});
