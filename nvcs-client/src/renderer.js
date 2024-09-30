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

async function fetchJson(event) {
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
            hierarchyLineNumber: hierarchy.length,
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
    let rootElement = createEmptyHierarchyElement();
    rootElement.hierarchyName = "ROOT";
    rootElement.hierarchyLevel = -1;
    rootElement.hierarchyLineNumber = -1;
    rootElement.node.name = "ROOT";
    rootElement.node.description.push("Root element to host hierarchy elements. Unused in the actual JSON or hierarchy.");
    rootElement.children = levelZeroElements;
    hierarchy.push(rootElement);
    for (const child of rootElement.children)
        child.parent = rootElement;

    // Sort hierarchy elements by line number
    hierarchy.sort((a, b) => a.hierarchyLevel - b.hierarchyLevel);

    // Clone hierarchy
    console.log(hierarchy);
    initialHierarchy = structuredClone(hierarchy);

    // Update HTML elements
    generateHierarchyHTML(hierarchy);
    document.getElementById("json-directory-name").disabled = false;
    document.getElementById("btn-update-json").disabled = false;
    document.getElementById("btn-add-element").disabled = false;
    document.getElementById("search-hierarchy").disabled = false;
    document.getElementById("btn-search-hierarchy").disabled = false;
}

function createEmptyHierarchyElement() {
    const element = {
        fileName: "",
        hierarchyName: "",
        hierarchyLevel: null,
        hierarchyLineNumber: null,
        node: {
            name: "",
            id: "",
            level: "",
            description: [],
            trigger: [],
            filters: []
        },
        parent: null,
        children: []
    };

    return element;
}

function generateHierarchyHTML(hierarchy) {
    // Generate HTML tree
    nodeDisplay = "<ul>";
    let rootElement = hierarchy.filter(i => i.hierarchyName == "ROOT")[0];
    nodeDisplay += generateListEntry(rootElement);
    nodeDisplay += "</ul>";

    // Generate full-hierarchy datalist
    generateFullHierarchyOptions();

    // Display results
    let detectedJsonContainer = document.getElementById("detected-json-container");
    detectedJsonContainer.innerHTML = nodeDisplay;
}

function generateListEntry(element) {
    returnString = "<li class='hierarchyNode'>";
    returnString += `<button id='${element.hierarchyName}' class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'>${element.hierarchyName}</button>`;
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateListEntry(child);
    returnString += "</ul>";
    returnString += "</li>";
    return returnString;
}

function openJsonDialog(hierarchyName) {
    showJsonDialog();

    const hierarchyElement = hierarchy.filter(i => i.hierarchyName == hierarchyName)[0];
    const isRoot = hierarchyElement.hierarchyName == "ROOT";
    console.log(hierarchyElement);

    document.getElementById("node-hierarchyName").value = hierarchyElement.hierarchyName;
    document.getElementById("node-hierarchyName").setAttribute("data-opened-name", hierarchyElement.hierarchyName);
    document.getElementById("node-fileName").value = hierarchyElement.fileName;
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
    if (!isRoot) {
        let nodeParentOptions = generateParentNodeOptions(hierarchyElement);
        document.getElementById("parent-hierarchy-list").innerHTML = nodeParentOptions;
        document.getElementById("node-parentNode").value = hierarchyElement.parent?.hierarchyName ?? "";
        document.getElementById("node-parentNode").disabled = false;
    }
    else  {
        const unavailableMessage = "Cannot be assigned to a parent";
        document.getElementById("parent-hierarchy-list").innerHTML = `
            <option selected disabled>${unavailableMessage}</option>
        `;
        document.getElementById("node-parentNode").value = unavailableMessage;
        document.getElementById("node-parentNode").disabled = true;
    }

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

    // Populate filters
    let nodeFilters = generateFilters(hierarchyElement);
    document.getElementById("node-nodeFilters").innerHTML = nodeFilters;
}

function showJsonDialog() {
    const dialog = document.getElementById("json-dialog");
    dialog.classList.remove("hidden");

    const dialogBody = dialog.querySelector(".body-container");
    dialogBody.scroll({ top: 0 });
}

function hideJsonDialog() {
    const dialog = document.getElementById("json-dialog");
    dialog.classList.add("hidden");
}

function closeJsonDialog() {
    hideJsonDialog();

    const openedHierarchyName = document.getElementById("node-hierarchyName").getAttribute("data-opened-name");
    const isNew = openedHierarchyName == "";

    // Delete newly-added but unsaved hierarchy elements
    if (isNew) {
        hierarchy = hierarchy.filter(i => i.hierarchyName != openedHierarchyName);
    }

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
    let isRoot = openedHierarchyName == "ROOT";
    let hierarchyName = document.getElementById("node-hierarchyName").value.trim();
    let fileName = document.getElementById("node-fileName").value.trim();
    let nodeDescription = document.getElementById("node-nodeDescription").value.trim();
    let nodeID = document.getElementById("node-nodeID").value.trim();
    let nodeLevel = document.getElementById("node-nodeLevel").value.trim();
    let nodeTrigger = document.getElementById("node-nodeTrigger").value.trim();

    // TODO: Implement validations
    if (!isRoot && !fileName.endsWith(".json")){
        const message = "File name must end with the '.json' file type";
        alert(message);
        return;
    }

    // Find hierarchy element to change
    let newHierarchyElement = hierarchy.filter(i => i.hierarchyName == openedHierarchyName)[0];

    // Update hierarchy name
    newHierarchyElement.hierarchyName = hierarchyName;
    newHierarchyElement.fileName = fileName;
    
    // Update connection data
    newHierarchyElement.children = newHierarchyElement.children;
    newHierarchyElement.parent = newHierarchyElement.parent;

    // Update node data
    newHierarchyElement.node.id = nodeID;
    newHierarchyElement.node.level = nodeLevel;
    newHierarchyElement.node.name = hierarchyName;

    // Update node description data
    newHierarchyElement.node.description = [];
    let splitNodeDescriptions = nodeDescription.split('\n');
    for (const splitNodeDescription of splitNodeDescriptions)
        newHierarchyElement.node.description.push(splitNodeDescription);

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

    // Update node parent relationship
    if (!isRoot) {
        let newParentName = document.getElementById("node-parentNode").value;
        let newParentElement = hierarchy.filter(i => i.hierarchyName == newParentName)[0];
        let previousParent = newHierarchyElement.parent;
        if (previousParent != newParentElement) {
            if (previousParent)
                previousParent.children = previousParent.children.filter(i => i.hierarchyName != newHierarchyElement.hierarchyName);
            newParentElement.children.push(newHierarchyElement);
            newHierarchyElement.parent = newParentElement;
        }
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

    // Re-calculate hierarchy line numbers & levels
    recalculateHierarchyPositionalData(hierarchy);

    // Close dialog & render new changes
    console.log(newHierarchyElement);
    closeJsonDialog();
    generateHierarchyHTML(hierarchy);
}

async function updateJson() {
    const newDirectoryName = document.getElementById("json-directory-name").value;
    if (!newDirectoryName) {
        const message = "Please provide a directory name for your updated JSON files";
        alert(message);
        return;
    }

    cleanUpWhitespace();

    const updateDataResponse = await window.electronAPI.updateJson(newDirectoryName, hierarchy);
    console.log(updateDataResponse);
}

function cleanUpWhitespace() {
    const tabReplace = "  ";
    for (const element of hierarchy) {
        const description = element.node.description;
        for (let i = 0; i < description.length; i++) {
            description[i] = description[i].replaceAll('\t', tabReplace);
        }
    }
}

function generateParentNodeOptions(excludedElement) {
    const otherNodes = hierarchy.filter(i => i.hierarchyName != excludedElement.hierarchyName);
    const selectedElement = excludedElement.parent;
    const disabledElements = otherNodes.filter(i => isElementDescendant(excludedElement, i));

    let html = generateElementOptions(otherNodes, selectedElement, disabledElements)
    return html;
}

function generateFullHierarchyOptions() {
    let html = generateElementOptions(hierarchy);
    document.getElementById("full-hierarchy-list").innerHTML = html;
}

function generateElementOptions(elements, selectedElement = null, disabledElements = null) {
    elements.sort((a, b) => a.hierarchyLineNumber - b.hierarchyLineNumber);

    let html = "";
    for (const element of elements) {
        const blankSpace = "&nbsp;";
        const name = element.hierarchyName;
        const levelIndicator = `[L${element.hierarchyLevel}]`;
        const tabSpaces = element.hierarchyLevel >= 0 ? blankSpace.repeat(element.hierarchyLevel) : "";
        const selected = element == selectedElement ? "selected" : "";
        const disabled = disabledElements?.includes(element) ? "disabled" : "";
        html += `<option value="${name}" ${selected} ${disabled}>${tabSpaces}${name} ${levelIndicator}</option>`;
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

function generateFilters(element) {
    let nodeFilterContent = "";

    if (element) {
        const filterKeys = Object.keys(element.node.filters);
        for (const filterKey of filterKeys) {
            
            let inputFilterContent = "";
            const filterValueArray = element.node.filters[filterKey];
            for (const filterValueArrayElement of filterValueArray) {
    
                const inputFilterKeys = Object.keys(filterValueArrayElement);
                for (const inputFilterKey of inputFilterKeys) {
    
                    const inputFilterValue = filterValueArrayElement[inputFilterKey];
                    inputFilterContent += createInputFilter(filterKey, inputFilterKey, inputFilterValue);
                }
            }
    
            nodeFilterContent += createFilter(filterKey, inputFilterContent);
        }
    }

    nodeFilterContent += `
        <div class='add-filter-container'>
            <button onclick="addFilter()">
                Add Filter
            </button>
        </div>
    `;

    return nodeFilterContent;
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
    lineNumberCounter = -1;
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

function deleteHierarchyElement() {
    // Get associated element
    const openedHierarchyName = document.getElementById("node-hierarchyName").getAttribute("data-opened-name");
    const element = hierarchy.filter(i => i.hierarchyName == openedHierarchyName)[0];

    // Only allow deleting if children elements are empty
    if (element.children.length > 0) {
        const message = "Unable to delete nodes with children. Please delete or reassign all children before attempting to delete this element again.";
        alert(message);
        return;
    }

    // Delete the element from parent's children list
    const indexAsChild = element.parent.children.indexOf(element);
    element.parent.children.splice(indexAsChild, 1);

    // Delete the element from hierarchy element list
    const indexAsHierarchy = hierarchy.indexOf(element);
    hierarchy.splice(indexAsHierarchy, 1);
    
    // Delete the element
    delete element;

    // Re-calculate hierarchy line numbers & levels
    recalculateHierarchyPositionalData(hierarchy);

    // Close dialog & render new changes
    closeJsonDialog();
    generateHierarchyHTML(hierarchy);
}

function addHierarchyElement() {
    const element = createEmptyHierarchyElement();
    hierarchy.push(element);
    openJsonDialog(element.hierarchyName);
}

function suggestFileName() {
    const nodeName = document.getElementById("node-hierarchyName").value;
    if (!nodeName) {
        const message = "Please provide a node name to allow for file name suggestions to generate";
        alert(message);
        return;
    }

    let suggestedName = nodeName.toLowerCase().trim();

    const whiteSpace = /\s+/g;
    suggestedName = suggestedName.replace(whiteSpace, "-");

    const parantheses = /\(|\)/g;
    suggestedName = suggestedName.replace(parantheses, "");
    suggestedName = suggestedName + ".json";

    document.getElementById("node-fileName").value = suggestedName;
}

function searchHierarchy() {
    const searchId = document.getElementById("search-hierarchy").value;
    if (!searchId) {
        const message = "Please use the available options to select an existing hierarchy element"
        alert(message);
        return;
    }

    let element = document.getElementById(searchId);
    if (!element) {
        const message = "Provided hierarchy element does not exist";
        alert(message);
        return
    }

    element.focus();
}