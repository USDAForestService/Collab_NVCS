let btnFetchExistingJson = document.getElementById("btn-fetch-existing-json");

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
var lineNumberCounter = 0;

var nodeJson;
var nodeHierarchy;
var hierarchy;
var initialHierarchy;

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
        delete associatedNode.node.fileName;

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

    // Generate root element and push level 0 elements as children
    const levelZeroElements = hierarchy.filter(i => i.hierarchyLevel == 0);
    const rootElement = {
        hierarchyName: "ROOT",
        hierarchyLevel: -1,
        hierarchyLineNumber: -1,
        children: levelZeroElements
    };
    hierarchy.push(rootElement);
    for (const child of rootElement.children)
        child.parent = rootElement;

    // Sort hierarchy elements by line number
    hierarchy.sort((a, b) => a.hierarchyLevel - b.hierarchyLevel);

    console.log(hierarchy);
    initialHierarchy = structuredClone(hierarchy);

    generateHierarchyHTML(hierarchy);
});

function generateHierarchyHTML(hierarchy) {
    // Generate HTML tree
    nodeDisplay = "<ul>";
    let rootElement = hierarchy.filter(i => i.hierarchyName == "ROOT")[0];
    for (let rootChildElement of rootElement.children)
        nodeDisplay += generateListEntry(rootChildElement);
    nodeDisplay += "</ul>";

    // Display results
    let detectedJsonContainer = document.getElementById("detected-json-container");
    detectedJsonContainer.innerHTML = nodeDisplay;
}

function generateListEntry(element) {
    returnString = "<li class='hierarchyNode'>";
    returnString += `<button class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'>${element.hierarchyName}</button>`;
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateListEntry(child);
    returnString += "</ul>";
    returnString += "</li>";
    return returnString;
}

function openJsonDialog(hierarchyName) {
    const dialog = document.getElementById("json-dialog");
    dialog.classList.remove("hidden");

    const dialogBody = dialog.querySelector(".body-container");
    dialogBody.scroll({ top: 0 });

    const hierarchyElement = hierarchy.filter(i => i.hierarchyName == hierarchyName)[0];
    console.log(hierarchyElement);

    document.getElementById("node-hierarchyName").value = hierarchyElement.hierarchyName;
    document.getElementById("node-hierarchyName").setAttribute("data-opened-name", hierarchyElement.hierarchyName);
    document.getElementById("node-hierarchyLevel").value = hierarchyElement.hierarchyLevel;
    document.getElementById("node-hierarchyLineNumber").value = hierarchyElement.hierarchyLineNumber;
    document.getElementById("node-nodeID").value = hierarchyElement.node.id;
    document.getElementById("node-nodeLevel").value = hierarchyElement.node.level;

    // Update node description data
    let lineBrokenDescription = hierarchyElement.node.description.join('\n');
    document.getElementById("node-nodeDescription").value = lineBrokenDescription;

    // Resize description height for its content
    document.getElementById("node-nodeDescription").style.height = "1px";
    let descriptionScrollHeight = document.getElementById("node-nodeDescription").scrollHeight;
    document.getElementById("node-nodeDescription").style.height = descriptionScrollHeight + "px";

    // Populate node parent options
    let nodeParentOptions = generateParentNodeOptions(hierarchyElement);
    document.getElementById("node-parentNode").innerHTML = nodeParentOptions;

    // Populate node children inputs
    let nodeChildrenInputs = generateChildNodeInputs(hierarchyElement);
    document.getElementById("node-childrenNodes").innerHTML = nodeChildrenInputs;

    // Update node trigger data
    let lineBrokenTrigger = hierarchyElement.node.trigger.join('\n');
    document.getElementById("node-nodeTrigger").value = lineBrokenTrigger;

    // Resize trigger height for its content
    document.getElementById("node-nodeTrigger").style.height = "1px";
    let triggerScrollHeight = document.getElementById("node-nodeTrigger").scrollHeight;
    document.getElementById("node-nodeTrigger").style.height = triggerScrollHeight + "px";

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

async function saveJsonChanges() {
    // Extract dialog values
    let openedHierarchyName = document.getElementById("node-hierarchyName").getAttribute("data-opened-name");
    let hierarchyName = document.getElementById("node-hierarchyName").value.trim();
    let nodeDescription = document.getElementById("node-nodeDescription").value.trim();
    let nodeID = document.getElementById("node-nodeID").value.trim();
    let nodeLevel = document.getElementById("node-nodeLevel").value.trim();
    let nodeTrigger = document.getElementById("node-nodeTrigger").value.trim();

    // Find hierarchy element to change
    let newHierarchyElement = hierarchy.filter(i => i.hierarchyName == openedHierarchyName)[0];

    // Update hierarchy data
    newHierarchyElement.hierarchyName = hierarchyName;
    
    // Update connection data
    newHierarchyElement.children = newHierarchyElement.children;
    newHierarchyElement.parent = newHierarchyElement.parent;

    // Update node data
    newHierarchyElement.node.fileName = newHierarchyElement.node.fileName;
    newHierarchyElement.node.id = nodeID;
    newHierarchyElement.node.level = nodeLevel;
    newHierarchyElement.node.name = hierarchyName;

    // Update node description data
    newHierarchyElement.node.description = [];
    let splitNodeDescriptions = nodeDescription.split('\n');
    for (const splitNodeDescription of splitNodeDescriptions)
        newHierarchyElement.node.description.push(splitNodeDescription);

    // Update node parent relationship
    let newParentName = document.getElementById("node-parentNode").value;
    let newParentElement = hierarchy.filter(i => i.hierarchyName == newParentName)[0];
    let previousParent = newHierarchyElement.parent;
    if (previousParent != newParentElement) {
        previousParent.children = previousParent.children.filter(i => i.hierarchyName != newHierarchyElement.hierarchyName);
        newParentElement.children.push(newHierarchyElement);
        newHierarchyElement.parent = newParentElement;
    }
    
    // Re-assign children nodes based on dialog positioning
    let newChildNodes = [];
    let childNodeInputs = document.querySelectorAll(".child-node-container input");
    for (let i = 0; i < childNodeInputs.length; i++) {
        const childNodeInput = childNodeInputs[i];
        const childName = childNodeInput.value;
        const associatedChildNode = hierarchy.filter(i => i.hierarchyName == childName)[0];
        newChildNodes.push(associatedChildNode);
    }
    newHierarchyElement.children = newChildNodes;

    // Update node trigger data
    newHierarchyElement.node.trigger = [];
    let splitNodeTriggers = nodeTrigger.split('\n');
    for (const splitNodeTrigger of splitNodeTriggers)
        newHierarchyElement.node.trigger.push(splitNodeTrigger);

    // Update node filter data
    let filterObject = {};
    let filterContainers = document.querySelectorAll(".filter-container");
    for (const filterContainer of filterContainers) {
        let filterName = filterContainer.querySelector(".sub-content-header-container input").value.trim();
        filterObject[filterName] = [];

        let subFilterContainers = filterContainer.querySelectorAll(".input-filters-container .sub-content-container");
        for (const subFilterContainer of subFilterContainers) {
            let subFilterKey = subFilterContainer.querySelector(".sub-key-holder").value.trim();
            let subFilterValue = subFilterContainer.querySelector(".sub-value-holder").value.trim();
            
            let subFilterObject = {};
            subFilterObject[subFilterKey] = subFilterValue;
            filterObject[filterName].push(subFilterObject);
        }
    }
    newHierarchyElement.node.filters = filterObject;

    // Re-calculate hierarchy line numbers & levels
    recalculateHierarchyPositionalData(hierarchy);

    // Close dialog & render new changes
    console.log(newHierarchyElement);
    closeJsonDialog();
    generateHierarchyHTML(hierarchy);
}

async function updateJson() {
    const newDirectoryName = document.getElementById("json-directory-name").value;
    const updateDataResponse = await window.electronAPI.updateJson(newDirectoryName, hierarchy);
    console.log(updateDataResponse);
}


function generateParentNodeOptions(excludedElement) {
    const otherNodes = hierarchy.filter(i => i.hierarchyName != excludedElement.hierarchyName);
    otherNodes.sort((a, b) => a.hierarchyLineNumber - b.hierarchyLineNumber);

    let html = ""
    for (const otherNode of otherNodes) {
        const blankSpace = "&nbsp;";
        const otherNodeName = otherNode.hierarchyName;
        const levelIndicator = `[L${otherNode.hierarchyLevel}]`;
        const tabSpaces = otherNode.hierarchyLevel >= 0 ? blankSpace.repeat(otherNode.hierarchyLevel) : "";
        const selected = otherNodeName == excludedElement.parent.hierarchyName ? "selected" : "";
        const disabled = isElementDescendant(excludedElement, otherNode) ? "disabled" : "";
        html += `<option value="${otherNodeName}" ${selected} ${disabled}>${levelIndicator}${blankSpace}${tabSpaces}${otherNodeName}</option>`;
    }

    return html;
}

function generateChildNodeInputs(element) {
    let html = "";

    if (element.children == null || element.children.length == 0) {
        html += `
        <div>
            No children assigned
        </div>
        `
    }
    else {
        html += `
            <div class="sub-content-container">
                <div class="sub-key-holder-sm">
                </div>
                <div class="sub-value-holder">
                    Element Name
                </div>
            </div>
        `

        for (let i = 0; i < element.children.length; i++) {
            const child = element.children[i];
            const childName = child.hierarchyName;
            const identifier = newGuid();
            html += `
                <div id="${identifier}" class="sub-content-container child-node-container">
                    <label for="${identifier}_input" class="sub-key-holder-sm">${i}</label>
                    <input id="${identifier}_input" type="text" value="${childName}" readonly class='sub-value-holder' />
                    <div>
                        <button class='btn-up' onclick="moveChildUp('${identifier}')" >Up</button>
                        <button class='btn-down' onclick="moveChildDown('${identifier}')" >Down</button>
                    </div>
                </div>
            `
        }
    }

    return html;
}

function isElementDescendant(ancestorElement, descendantElement) {
    // Base case - is a descendant
    if (ancestorElement.hierarchyName == descendantElement.hierarchyName)
        return true;

    // Recursively check children
    for (const child of ancestorElement.children)
        if (isElementDescendant(child, descendantElement))
            return true;
    
    // Not a descendant
    return false;
}

function moveChildUp(identifier) {
    // Identify containers
    const container = document.getElementById(identifier);
    const parentContainer = container.parentElement;
    const pivotContainer = container.previousElementSibling;
    if (!pivotContainer.classList.contains("child-node-container"))
        return;

    // Perform move
    container.remove();
    parentContainer.insertBefore(container, pivotContainer);

    // Swap postiional label text
    const containerLabel = container.querySelector("label");
    const containerLabelText = containerLabel.innerText;
    const pivotContainerLabel = pivotContainer.querySelector("label");
    const pivotContainerLabelText = pivotContainerLabel.innerText;
    containerLabel.innerText = pivotContainerLabelText;
    pivotContainerLabel.innerText = containerLabelText;
}

function moveChildDown(identifier) {
    // Identify containers
    const container = document.getElementById(identifier);
    const parentContainer = container.parentElement;
    const pivotContainer = container.nextElementSibling;
    if (!pivotContainer.classList.contains("child-node-container"))
        return;

    // Perform move
    container.remove();
    if (pivotContainer == parentContainer.children[parentContainer.children.length - 1]) {
        parentContainer.appendChild(container);
    }
    else {
        parentContainer.insertBefore(container, pivotContainer.nextElementSibling);
    }

    // Swap postiional label text
    const containerLabel = container.querySelector("label");
    const containerLabelText = containerLabel.innerText;
    const pivotContainerLabel = pivotContainer.querySelector("label");
    const pivotContainerLabelText = pivotContainerLabel.innerText;
    containerLabel.innerText = pivotContainerLabelText;
    pivotContainerLabel.innerText = containerLabelText;
}

function recalculateHierarchyPositionalData(hierarchy) {
    lineNumberCounter = 0;
    const root = hierarchy.filter(i => i.hierarchyName == "ROOT")[0];
    recursivelyUpdatePositionalData(root);
}

function recursivelyUpdatePositionalData(element) {
    element.hierarchyLineNumber = lineNumberCounter;
    lineNumberCounter++;

    if (element.parent)
        element.hierarchyLevel = element.parent.hierarchyLevel + 1;

    for (const child of element.children)
        recursivelyUpdatePositionalData(child);
}
