let InputFilterTypes = [
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
let lineNumberCounter = 0;
let warnings = [];
let errors = [];
let unsavedDialogChanges = false;

let nodeJson;
let nodeHierarchy;
let hierarchy;
let initialHierarchy;
let availableSpecies;
let availableYears;
let testSettings;

displayApplicationVersion();

const stateChecker = {
    _modified: false,
    _modifiedListener: async (value) => {
        const btnTestSettings = document.getElementById("btn-test-settings");
        if (value) {
            btnTestSettings.disabled = true;
            btnTestSettings.setAttribute("title", "You must save your modifications before testing this directory");
            showContentById("unsaved-changes-banner");
            await markUnsavedChanges(true);
        }
        else {
            btnTestSettings.disabled = false;
            btnTestSettings.setAttribute("title", "Opens a dialog to modify test settings and execute the test program on your JSON configuration settings");
            hideContentById("unsaved-changes-banner");
        }
    },
    set modified(value) {
        this._modified = value;
        this._modifiedListener(value);
    },
    get modified() {
        return this._modified;
    }
};

document.getElementById("json-dialog").addEventListener("close", async (event) => {
    if (unsavedDialogChanges) {
        const message = "You may have unsaved changes made to this element. Are you sure you want to discard these changes by exiting the dialog without saving?";
        if (!await confirm(message)) {
            const dialog = document.getElementById("json-dialog");
            showDialog(dialog);
            return;
        }
        unsavedDialogChanges = false;
    }

    const openedHierarchyName = document.getElementById("node-hierarchyName").getAttribute("data-opened-name");
    const isNew = openedHierarchyName == "";

    // Delete newly-added but unsaved hierarchy elements
    if (isNew) {
        hierarchy = hierarchy.filter(i => i.hierarchyName != openedHierarchyName);
    }
});

const jsonDialogBody = document.querySelector("#json-dialog .body-container");
jsonDialogBody.addEventListener("input", (event) => {
    unsavedDialogChanges = true;
    // Only perform validations on saveable input and textarea fields
    if (!(event.target instanceof HTMLInputElement || event.target instanceof HTMLTextAreaElement)) 
        return;
    if (event.target.classList.contains("skip-validation")) 
        return;
    performDialogValidations(false);
});
jsonDialogBody.addEventListener("click", (event) => {
    if (!(event.target instanceof HTMLButtonElement)) 
        return;
    unsavedDialogChanges = true;
})

document.getElementById("settings-dialog").addEventListener("close", (event) => {
    // No implementation yet
});

const closeButtons = document.querySelectorAll(".close-btn");
closeButtons.forEach(closeButton => {
    closeButton.addEventListener("click", (event) => {
        const dialog = event.target.closest("dialog");
        dialog.close();
    })
})

async function displayApplicationVersion() {
    const version = await getApplicationVersion();
    document.getElementById("app-version").innerHTML = "v" + version;
}

async function getApplicationVersion() {
    try {
        return await window.electronAPI.getApplicationVersion();
    }
    catch (error) {
        console.error(error);
    }
}

async function fetchPackagedJson() {
    const loadMessage = "Are you sure you want to load the selected packaged content? " +
        "All currently loaded modifications will be lost unless they were saved to another directory.";
    if (hierarchy?.length > 0 && !await confirm(loadMessage))
        return;

    await fetchJson();

    document.getElementById("json-directory-path").value = "";
    document.getElementById("btn-test-settings").disabled = true;
    document.getElementById("btn-open-json").disabled = true;
}

async function fetchCustomJson() {
    const inputPath = document.getElementById("json-directory-path");
    const browsePath = await openBrowseDialog(inputPath.value);
    if (!browsePath) return;

    const loadMessage = "Are you sure you want to load from this directory? " +
        "All currently loaded modifications will be lost unless they were saved to another directory.";
    if (hierarchy?.length > 0 && !await confirm(loadMessage))
        return;

    inputPath.value = browsePath;
    const targetPath = document.getElementById("json-directory-path").value;
    if (!targetPath) {
        const message = "When loading custom JSON, please ensure a valid path is provided to the directory " +
            "containing the key nodes and hierarchy file that you wish to load";
        alert(message);
        return;
    }

    await fetchJson(targetPath);

    document.getElementById("btn-test-settings").disabled = false;
    document.getElementById("btn-open-json").disabled = false;
}

async function fetchJson(targetPath) {
    // Query for JSON and TXT data
    let returnedData;
    try {
        returnedData = await window.electronAPI.fetchExistingJson(targetPath);
    }
    catch (error) {
        alert(error);
        return;
    }
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
    console.log("Current Hierarchy", hierarchy);
    initialHierarchy = structuredClone(hierarchy);

    // Fetch latest species list
    await updateAvailableSpecies();

    // Fetch default test settings
    await getDefaultTestSettings();

    // Update HTML elements
    stateChecker.modified = false;
    generateHierarchyHTML(hierarchy);
    document.getElementById("btn-update-json").disabled = false;
    document.getElementById("btn-update-json").setAttribute("title", 
        "Browse for a direcory to save your key-nodes folder and key-hierarchy.txt file"
    );
    document.getElementById("btn-add-element").disabled = false;
    document.getElementById("search-hierarchy").disabled = false;
    document.getElementById("btn-search-hierarchy").disabled = false;
}

async function fetchSettings() {
    try {
        const response = await electronAPI.fetchSettings();
        console.log("Fetched Test Settings", response);
        return response;
    }
    catch (error) {
        console.error(error);
        alert(error);
        return;
    }
}

async function fetchAvailableYears() {
    try {
        const response = await electronAPI.fetchYears();
        availableYears = convertStringToNumbersList(response);
        console.log("Fetched and Converted Available Years", availableYears);
        return availableYears;
    }
    catch (error) {
        console.error(error);
        alert(error);
        return;
    }
}

async function updateAvailableYears() {
    let html = "";
    for (const year of availableYears) {
        let checked = testSettings.inventoryYears.includes(year) ? "checked" : "";
        html += `
        <div class='label-checkbox-container'>
            <label for='year_${year}'>${year}</label>
            <input id='year_${year}' type='checkbox' value='${year}' ${checked}/>
        </div>
        `;
    }

    document.getElementById("settings-inv-years").innerHTML = html;
}

async function updateAvailableSpecies() {
    let returnedData;
    try {
        returnedData = await window.electronAPI.fetchSpecies();
    }
    catch (error) {
        alert(error);
        return;
    }
    availableSpecies = returnedData;

    const speciesOptions = createOptions(availableSpecies);
    document.getElementById("species-list").innerHTML = speciesOptions;
    getDatalistDetails("species-list");

    console.log(`Updated available species with ${availableSpecies.length} elements`);
}

async function executeTester() {
    try {
        // Save settings without closing the dialog
        saveSettingsChanges(false);

        const testWarning = "Are you sure you want to test this directory? " +
            "Any previously saved 'nvcs-output.db' file will be overwritten if testing is successful.";
        if (!await confirm(testWarning))
            return;
        
        document.getElementById("testing-dialog").showModal();
        const newDirectoryName = document.getElementById("json-directory-path").value;
        const response = await window.electronAPI.executeTester(newDirectoryName, testSettings);

        if (!response.success)
            throw new Error("Unexpected error while testing");

        document.getElementById("testing-dialog").close();
        document.getElementById("settings-dialog").close();
        
        const message = `Successfully saved test results to the following location: ${response.outputDbPath}`;
        alert(message);
        return;
    }
    catch (error) {
        document.getElementById("testing-dialog").close();
        alert(error);
        return;
    }
}

async function openJsonDirectory() {
    try {
        const targetPath = document.getElementById("json-directory-path").value;
        await electronAPI.openDirectory(targetPath);
    }
    catch (error) {
        console.error(error);
        alert(error);
        return;
    }
}

async function markUnsavedChanges(value) {
    try {
        await electronAPI.markUnsavedChanges(value);
    }
    catch (error) {
        console.error(error);
        alert(error);
        return;
    }
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
    let nodeDisplay = "<ul>";
    let rootElement = hierarchy.filter(i => i.hierarchyName == "ROOT")[0];
    nodeDisplay += generateListEntry(rootElement);
    nodeDisplay += "</ul>";

    // Generate full-hierarchy datalist
    generateFullHierarchyOptions();

    // Display results
    let detectedJsonContainer = document.getElementById("detected-json-container");
    detectedJsonContainer.innerHTML = nodeDisplay;

    // Display alerts if any
    checkForProblems();
}

function generateAlerts() {
    // Wipe & hide existing alerts
    const errorContainer = document.getElementById("error-container");
    const errorList = document.querySelector(".error-list");
    const warningContainer = document.getElementById("warning-container");
    const warningList = document.querySelector(".warning-list");
    errorContainer.setAttribute("hidden", "");
    warningContainer.setAttribute("hidden", "");
    errorList.replaceChildren([]);
    warningList.replaceChildren([]);

    // Show Errors
    if (errors.length > 0)
        errorContainer.removeAttribute("hidden");
    for (const error of errors) {
        errorList.innerHTML += `
            <li id='${error.name}' class='error-list-item'>
                ${error.content}
            </li>
        `;
    }

    // Show Warnings
    if (warnings.length > 0)
        warningContainer.removeAttribute("hidden");
    for (const warning of warnings) {
        warningList.innerHTML += `
            <li id='${warning.name}' class='warning-list-item'>
                ${warning.content}
            </li>
        `;
    }
}

function generateListEntry(element) {
    let returnString = "<li class='hierarchyNode'>";
    returnString += `<button data-hierarchy-name='${element.hierarchyName}' class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'>${element.hierarchyName}</button>`;
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateListEntry(child);
    returnString += "</ul>";
    returnString += "</li>";
    return returnString;
}

function openJsonDialog(hierarchyName) {
    // Open the dialog
    unsavedDialogChanges = false;
    clearMarkedValidationFields();
    const dialog = document.getElementById("json-dialog");
    showDialog(dialog);

    // Gather opened dialog context
    const hierarchyElement = hierarchy.filter(i => i.hierarchyName == hierarchyName)[0];
    const isRoot = hierarchyElement.hierarchyName == "ROOT";
    console.log("Opened Hierarchy Element", hierarchyElement);

    // Prepare node name
    const inputNodeName = document.getElementById("node-hierarchyName");
    inputNodeName.value = hierarchyElement.hierarchyName;
    inputNodeName.setAttribute("data-opened-name", hierarchyElement.hierarchyName);
    inputNodeName.readOnly = isRoot;

    // Prepare file name
    const inputFileName = document.getElementById("node-fileName");
    inputFileName.value = hierarchyElement.fileName;
    inputFileName.readOnly = isRoot;

    // Prepare hierarchy level & line number (always readonly)
    document.getElementById("node-hierarchyLevel").value = hierarchyElement.hierarchyLevel;
    document.getElementById("node-hierarchyLineNumber").value = hierarchyElement.hierarchyLineNumber;

    // Prepare node ID
    const inputNodeId = document.getElementById("node-nodeID");
    inputNodeId.value = hierarchyElement.node.id;
    inputNodeId.readOnly = isRoot;

    // Prepare node level
    const inputNodeLevel = document.getElementById("node-nodeLevel");
    inputNodeLevel.value = hierarchyElement.node.level;
    inputNodeLevel.readOnly = isRoot;

    // Update node description data
    let lineBrokenDescription = hierarchyElement.node.description.join('\n');
    const inputNodeDescription = document.getElementById("node-nodeDescription");
    inputNodeDescription.value = lineBrokenDescription;
    inputNodeDescription.readOnly = isRoot;

    // Resize description height for its content
    inputNodeDescription.style.height = "1px";
    let descriptionScrollHeight = document.getElementById("node-nodeDescription").scrollHeight;
    inputNodeDescription.style.height = descriptionScrollHeight + "px";

    // Populate node parent options
    const inputParentNode = document.getElementById("node-parentNode");
    inputParentNode.readOnly = isRoot;
    if (!isRoot) {
        let nodeParentOptions = generateParentNodeOptions(hierarchyElement);
        document.getElementById("parent-hierarchy-list").innerHTML = nodeParentOptions;
        inputParentNode.value = hierarchyElement.parent?.hierarchyName ?? "";
    }
    else  {
        const unavailableMessage = "Cannot be assigned to a parent";
        document.getElementById("parent-hierarchy-list").innerHTML = `
            <option selected disabled>${unavailableMessage}</option>
        `;
        inputParentNode.value = unavailableMessage;
    }

    // Populate node children inputs
    let nodeChildrenInputs = generateChildNodeInputs(hierarchyElement);
    document.getElementById("node-childrenNodes").innerHTML = nodeChildrenInputs;

    // Update node trigger data
    let lineBrokenTrigger = hierarchyElement.node.trigger.join('\n');
    const inputNodeTrigger = document.getElementById("node-nodeTrigger");
    inputNodeTrigger.value = lineBrokenTrigger;
    inputNodeTrigger.readOnly = isRoot;

    // Resize trigger height for its content
    inputNodeTrigger.style.height = "1px";
    let triggerScrollHeight = document.getElementById("node-nodeTrigger").scrollHeight;
    inputNodeTrigger.style.height = triggerScrollHeight + "px";

    // Populate filters
    let nodeFilters = generateFilters(hierarchyElement);
    document.getElementById("node-nodeFilters").innerHTML = nodeFilters;

    // Prepare buttons
    document.getElementById("suggest-file-name").disabled = isRoot;
    document.getElementById("add-new-filter").disabled = isRoot;
    document.getElementById("delete-hierarchy-element").disabled = isRoot;

    // Perform other dialog validations
    performDialogValidations(false);
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

async function addInputFilter(identifier, bulkAdd = false) {
    if (bulkAdd) {
        const message = "Are you sure you want to bulk-add these filters? " +
        "Unique values will be extracted from the comma-separated 'Value' field and assigned the " +
        "selected 'Type' field. These can all be modified or removed afterwards if necessary.";
        if (!await confirm(message))
            return;
    }

    const filterContainer = document.getElementById(identifier);
    const inputFiltersContainer = filterContainer.querySelector(".input-filters-container")
    const singleInputType = document.getElementById("input_type_add_" + identifier).value;
    const singleInputValue = document.getElementById("input_value_add_" + identifier).value;
    let newInputFilterHtml = "";
    if (bulkAdd) {
        const separatedInputValues = singleInputValue.split(",");
        for (const separatedInputValue of separatedInputValues) {
            const cleanedInputValue = separatedInputValue.trim();
            const [html] = createInputFilter(singleInputType, cleanedInputValue)
            newInputFilterHtml += html;
        }

    }
    else {
        const [html] = createInputFilter(singleInputType, singleInputValue);
        newInputFilterHtml += html;
    }
    inputFiltersContainer.insertAdjacentHTML('beforeEnd', newInputFilterHtml);

    // Check newly-added filters
    performDialogValidations(false);
}

function createFilter(filterKey, inputFilters) {
    if (!filterKey)
        filterKey = "";

    if (!inputFilters)
        inputFilters = "";

    let inputFilterOptions = createInputFilterOptions();
    let identifier = newGuid();
    const inputValueList = getInputValueListForType(InputFilterTypes[0]);
    let html = `
    <div class='filter-container' id="${identifier}">
        <div class='sub-content-header-container'>
            <label for="filter-${identifier}">Name:</label>
            <input type="text" id="filter-${identifier}" class="filter-name-input" value="${filterKey}"/>
            <button onclick="deleteElement('${identifier}', true)">Delete Filter</button>
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
            <div class='add-single-container'>
                <label for="input_type_add_${identifier}">
                    Type:
                </label>
                <select id="input_type_add_${identifier}" class="input-type skip-validation" onchange="swapInputType(this)"  aria-label="Add Input Filter Type">
                    ${inputFilterOptions}
                </select>
                <label for="input_value_add_${identifier}">
                    Value:
                </label>
                <input id="input_value_add_${identifier}" type="text" class="input-value skip-validation" list="${inputValueList}" aria-label="Add Input Filter Value"/>
                <button onclick="addInputFilter('${identifier}', false)" title='The full input will be added as a single filter'>
                    Add Single
                </button>
                <button onclick="addInputFilter('${identifier}', true)" title='The full input will be separated based on commas and added as separate filters'>
                    Add Bulk
                </button>
            </div>
        </div>
    </div>
    `;

    return html;
}

function createInputFilter(inputFilterKey, inputFilterValue) {    
    if (!inputFilterKey)
        inputFilterKey = "";

    if (!inputFilterValue)
        inputFilterValue = "";

    let filterSelectBoxOptions = createInputFilterOptions(inputFilterKey);

    const identifier = newGuid();
    const inputValueList = getInputValueListForType(inputFilterKey);
    let html = `
    <div class='sub-content-container' id="${identifier}" >
        <select class='sub-key-holder input-type' value="${inputFilterKey}" onchange="swapInputType(this)" aria-label="Input Filter Type">
        ${filterSelectBoxOptions}
        </select>
        <input type="text" class='sub-value-holder input-value' value="${inputFilterValue}" list="${inputValueList}" aria-label="Input Filter Value"/>
        <button onclick="deleteElement('${identifier}')">Delete</button>
    </div>
    `

    return [html, identifier];
}

function createInputFilterOptions(inputFilterKey) {
    return createOptions(InputFilterTypes, inputFilterKey);
}

function createOptions(options, selectedOption = null) {
    let html = "";
    for (const option of options) {
        const selected = option == selectedOption ? "selected" : "";
        html += `
            <option value="${option}" ${selected}>
                ${option}
            </option>
        `;
    }
    return html;
}

async function deleteElement(identifier, confirmation = false) {
    const message = "Are you sure you want to delete this element?";
    if (confirmation && !await confirm(message))
        return;

    const container = document.getElementById(identifier);
    container.remove();

    // Check to see if recently deleted elements trigger any new errors
    performDialogValidations(false);
}

function newGuid() {
    return "id" + Math.random().toString(16).slice(2);
}

async function saveJsonChanges() {
    // Get input fields
    let inputHierarchyName = document.getElementById("node-hierarchyName")
    let inputFileName = document.getElementById("node-fileName")
    let inputNodeDescription = document.getElementById("node-nodeDescription")
    let inputNodeID = document.getElementById("node-nodeID")
    let inputNodeLevel = document.getElementById("node-nodeLevel")
    let inputNodeTrigger = document.getElementById("node-nodeTrigger")

    // Extract dialog values
    let openedHierarchyName = inputHierarchyName.getAttribute("data-opened-name");
    let isRoot = openedHierarchyName == "ROOT";
    let hierarchyName = inputHierarchyName.value.trim();
    let fileName = inputFileName.value.trim();
    let nodeDescription = inputNodeDescription.value.trim();
    let nodeID = inputNodeID.value.trim();
    let nodeLevel = inputNodeLevel.value.trim();
    let nodeTrigger = inputNodeTrigger.value.trim();

    // Exit function if validations don't pass
    if (!performDialogValidations(true))
        return;

    // Find hierarchy element to change
    let newHierarchyElement = hierarchy.filter(i => i.hierarchyName == openedHierarchyName)[0];

    // Update hierarchy name
    newHierarchyElement.hierarchyName = hierarchyName;
    newHierarchyElement.fileName = fileName;

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
    for (const childNodeInput of childNodeInputs) {
        const childName = childNodeInput.value;
        const associatedChildNode = hierarchy.filter(i => i.hierarchyName == childName)[0];
        newChildNodes.push(associatedChildNode);
    }
    newHierarchyElement.children = newChildNodes;

    // Re-calculate hierarchy line numbers & levels
    recalculateHierarchyPositionalData(hierarchy);

    // Close dialog & render new changes
    console.log(newHierarchyElement);
    stateChecker.modified = true;
    unsavedDialogChanges = false;
    document.getElementById("json-dialog").close();
    generateHierarchyHTML(hierarchy);
}

function performDialogValidations(displayAlert) {
    // Prepare for new validations
    clearMarkedValidationFields();
    let hasNoErrors = true;
    let newMarkedElements = [];

    // Do not perform validations on the ROOT element
    const inputHierarchyName = document.getElementById("node-hierarchyName")
    const openedHierarchyName = inputHierarchyName.getAttribute("data-opened-name");
    if (openedHierarchyName == "ROOT")
        return hasNoErrors;
    
    // Find invalid elements within the JSON dialog
    newMarkedElements = findInvalidsForNodeName(newMarkedElements);
    newMarkedElements = findInvalidsForFilePath(newMarkedElements);
    newMarkedElements = findInvalidsForNodeDescription(newMarkedElements);
    newMarkedElements = findInvalidsForParentNode(newMarkedElements);
    newMarkedElements = findInvalidsForNodeId(newMarkedElements);
    newMarkedElements = findInvalidsForNodeTrigger(newMarkedElements);
    newMarkedElements = findInvalidsForNodeFilters(newMarkedElements);
    newMarkedElements = findInvalidsForSubFilters(newMarkedElements);

    // Mark invalid fields
    markValidationFields(newMarkedElements, displayAlert);

    // Extract unique error messages if they exist
    let uniqueErrorMessages = [];
    const messageObjects = newMarkedElements.map(i => i.messages);
    for (const messageObject of messageObjects) {
        const errorTypes = messageObject.filter(i => i.type == "error");
        const newErrorMessages = errorTypes.map(i => i.message);
        uniqueErrorMessages.push(...newErrorMessages);
    }
    uniqueErrorMessages = [...new Set(uniqueErrorMessages)];

    // If requested and eligible, display an alert containing all unique errors
    hasNoErrors = uniqueErrorMessages.length == 0;
    if (displayAlert && !hasNoErrors) {
        const newLineError = "\r\n -";
        const joinedErrorMessages = uniqueErrorMessages.join(newLineError);
        const finalMessage = `The following errors were detected:${newLineError}${joinedErrorMessages}`;
        alert(finalMessage);
    }

    return hasNoErrors;
}

function findInvalidsForNodeName(newMarkedElements) {
    const inputHierarchyName = document.getElementById("node-hierarchyName")
    const openedHierarchyName = inputHierarchyName.getAttribute("data-opened-name");
    const inputNodeId = document.getElementById("node-nodeID");
    const nodeId = inputNodeId.value.trim();
    const hierarchyName = inputHierarchyName.value.trim();
    const otherElementsWithName = hierarchy.filter(i => i.hierarchyName == hierarchyName && i.hierarchyName != openedHierarchyName);

    if (hierarchyName == "") {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputHierarchyName, "Node name is required", "error");
    }

    if (otherElementsWithName.length != 0) {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputHierarchyName, "Node name must be unique", "error");
    }

    if (nodeId && !hierarchyName.includes(`(${nodeId})`))
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputHierarchyName, "Node name is unconventional because it lacks the node ID in parentheses at the end", "warning");

    return newMarkedElements
}

function findInvalidsForFilePath(newMarkedElements) {
    const inputHierarchyName = document.getElementById("node-hierarchyName")
    const openedHierarchyName = inputHierarchyName.getAttribute("data-opened-name");
    const inputFileName = document.getElementById("node-fileName")
    const fileName = inputFileName.value.trim();

    if (!fileName.endsWith(".json")){
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputFileName, "File name must end with the '.json' file type", "error");
    }

    const othersWithFileName = hierarchy.filter(i => i.hierarchyName != openedHierarchyName && i.fileName.toLowerCase() == fileName.toLowerCase());
    if (othersWithFileName.length > 0)
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputFileName, "File name must be unique", "error");
    
    const suggestedFileName = generateFileNameFromValue(inputHierarchyName.value);
    if (fileName != suggestedFileName)
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputFileName, "File name is unconventional, use of the 'Suggest' button is recommended", "warning");

    return newMarkedElements;
}

function findInvalidsForNodeDescription(newMarkedElements) {
    const inputNodeDescription = document.getElementById("node-nodeDescription")
    const nodeDescription = inputNodeDescription.value.trim();

    if (nodeDescription == "") {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputNodeDescription, "Node description is required", "error");
    }

    return newMarkedElements;
}

function findInvalidsForParentNode(newMarkedElements) {
    const inputHierarchyName = document.getElementById("node-hierarchyName")
    const openedHierarchyName = inputHierarchyName.getAttribute("data-opened-name");
    const inputParentNode = document.getElementById("node-parentNode")
    const parentNode = inputParentNode.value.trim();

    const otherElementAsParent = hierarchy.filter(i => i.hierarchyName == parentNode && i.hierarchyName != openedHierarchyName);
    if (otherElementAsParent.length == 0) {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputParentNode, "Parent node is required and must be assigned to a valid hierarchy element", "error");
    }

    return newMarkedElements;
}

function findInvalidsForNodeId(newMarkedElements) {
    const inputNodeId = document.getElementById("node-nodeID");
    const nodeId = inputNodeId.value.trim();
    const elementsWithNodeId = hierarchy.filter(i => i.node.id == nodeId);

    if (nodeId != "" && elementsWithNodeId.length > 1) {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputNodeId, "Node ID is non-unique", "warning");
    }

    return newMarkedElements;
}

function findInvalidsForNodeTrigger(newMarkedElements) {
    const inputNodeTrigger = document.getElementById("node-nodeTrigger")
    const nodeTrigger = inputNodeTrigger.value.trim();
    const inputFilterNames = [...document.querySelectorAll(".filter-name-input")];
    const missingFilters = findMissingFiltersInTrigger(nodeTrigger, inputFilterNames.map(i => i.value));

    if (nodeTrigger == "") {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputNodeTrigger, "Node trigger is required", "error");
    }

    if (!doParenthesesMatchInTrigger(nodeTrigger)) {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputNodeTrigger, "Node trigger has mismatched parentheses", "error");
    }

    if (missingFilters.length > 0) {
        newMarkedElements = addMarkedElementMessage(newMarkedElements, inputNodeTrigger, "Node trigger references filter names that don't exist", "error");
    }

    return newMarkedElements;
}

function findInvalidsForNodeFilters(newMarkedElements) {
    const inputFilterNames = [...document.querySelectorAll(".filter-name-input")];

    for (const inputFilterName of inputFilterNames) {
        if (inputFilterName.value == "") {
            newMarkedElements = addMarkedElementMessage(newMarkedElements, inputFilterName, "Filter names are required", "error");
        }

        const filtersWithSameName = inputFilterNames.filter(i => i.value == inputFilterName.value);
        if (filtersWithSameName.length > 1) {
            newMarkedElements = addMarkedElementMessage(newMarkedElements, inputFilterName, "Filter names must be unique", "error");
        }
    }

    return newMarkedElements;
}

function addMarkedElementMessage(newMarkedElements, html, message, type) {
    const existingHtml = newMarkedElements.filter(i => i.html == html)[0];
    if (existingHtml) {
        existingHtml.messages.push({
            message: message,
            type: type
        });
    }
    else {
        newMarkedElements.push({
            html: html,
            messages: [{
                message: message,
                type: type
            }]
        });
    }
    return newMarkedElements;
}

function clearMarkedValidationFields() {
    // Find all marked-fields and remove error for new scan
    const markedSelector = "data-validation-marked";
    const existingMarkedElements = document.querySelectorAll(`[${markedSelector}]`);
    for (const markedElement of existingMarkedElements) {
        markElementAsType(markedElement, null);
        markedElement.removeAttribute(markedSelector);
    }
}

function markValidationFields(newMarkedElements, focusFirst) {
    // Loop through marked-fields, focusing the first, and applying errors
    const markedSelector = "data-validation-marked";
    for (let i = 0; i < newMarkedElements.length; i++) {
        const newMarkedElement = newMarkedElements[i];
        const html = newMarkedElement.html;
        const message = newMarkedElement.messages.map(i => i.message).join(", ");
        const type = newMarkedElement.messages.map(i => i.type)[0];
        markElementAsType(html, type, message);
        html.setAttribute(markedSelector, type);
        if (i == 0 && focusFirst && type == "error") html.focus();
    }
}

async function updateJson() {
    const inputPath = document.getElementById("json-directory-path");
    const browsePath = await openBrowseDialog(inputPath.value);
    if (!browsePath) return;

    const updateWarning = "Are you sure you want to save changes to this directory? " +
        "Any previously saved changes within this directory will be overwritten.";
    if (!await confirm(updateWarning))
        return;

    inputPath.value = browsePath;
    const newDirectoryName = document.getElementById("json-directory-path").value;
    if (!newDirectoryName) {
        const message = "Please provide an exact directory path to store your updated JSON files";
        alert(message);
        return;
    }

    cleanUpWhitespace();

    try {
        const changes = detectHierarchyChanges();
        console.log(changes)
        await window.electronAPI.updateJson(newDirectoryName, hierarchy, changes);
        initialHierarchy = structuredClone(hierarchy);
        const message = `Successfully saved changes to: ${newDirectoryName}`;
        alert(message);

        stateChecker.modified = false;
        document.getElementById("btn-open-json").disabled = false;
        return;
    }
    catch (error) {
        alert(error);
        return;
    }
    
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
                    const [html] = createInputFilter(inputFilterKey, inputFilterValue);
                    inputFilterContent += html;
                }
            }
    
            nodeFilterContent += createFilter(filterKey, inputFilterContent);
        }
    }

    nodeFilterContent += `
        <div class='add-filter-container'>
            <button id='add-new-filter' onclick="addFilter()">
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
    if (!pivotContainer?.classList.contains("child-node-container"))
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

async function deleteHierarchyElement() {
    // Confirm before deleting
    const message = "Are you sure you want to delete this hierarchy element?";
    if (!await confirm(message))
        return;

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

    // Re-calculate hierarchy line numbers & levels
    recalculateHierarchyPositionalData(hierarchy);

    // Close dialog & render new changes
    stateChecker.modified = true;
    unsavedDialogChanges = false;
    document.getElementById("json-dialog").close();
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

    let suggestedName = generateFileNameFromValue(nodeName);
    document.getElementById("node-fileName").value = suggestedName;

    // See if the new file name somehow caused issues
    performDialogValidations(false);
}

function generateFileNameFromValue(nodeName) {
    let suggestedName = nodeName.toLowerCase().trim();

    const nodeId = /(?<=\()[^()]+(?=\)$)/g;
    suggestedName = suggestedName.replace(nodeId, i => i.toUpperCase());

    const commas = ",";
    suggestedName = suggestedName.replaceAll(commas, "-");

    const whiteSpace = /\s+/g;
    suggestedName = suggestedName.replace(whiteSpace, "-");

    const parantheses = /[()]/g;
    suggestedName = suggestedName.replace(parantheses, "");

    const consecutiveDashes = /(-+){2}/g;
    suggestedName = suggestedName.replace(consecutiveDashes, "-"); 

    suggestedName = suggestedName + ".json";
    return suggestedName;
}

function searchHierarchy() {
    const searchId = document.getElementById("search-hierarchy").value;
    if (!searchId) {
        const message = "Please use the available options to select an existing hierarchy element"
        alert(message);
        return;
    }

    let element = findHierarchyButton(searchId);
    if (!element) {
        const message = "Provided hierarchy element does not exist";
        alert(message);
        return
    }

    element.focus();
}

function swapInputType(element) {
    const inputValue = element.parentElement.querySelector(".input-value");
    const inputValueListName = getInputValueListForType(element.value);
    inputValue.setAttribute("list", inputValueListName);
    
    // Check adjacent input field to see if any violations appear
    performDialogValidations(false);
}

function getInputValueListForType(type) {
    switch (type) {
        case "species": 
            return "species-list";
        case "plantation":
        case "hydric":
        case "riverine":
        case "ruderal":
        case "exotic":
        case "planted":
        case "tallytree":
            return "binary-list";
        default: 
            return "";
    }
}

function checkForProblems() {
    // Wipe existing lists
    errors = [];
    warnings = [];

    // Check errors
    checkMissingRequiredFields();
    checkMissingTriggerParenthesesError();
    checkMissingFiltersInTrigger();
    checkInvalidBinaryValueError();

    // Check warnings
    checkMissingNodeIdInNames();
    checkUnconventionalFileNames();
    checkDuplicateNodeIds();
    checkInvalidSpeciesWarning();

    // Update alerts
    generateAlerts();
}

function createError(name, content, source) {
    errors = errors.filter(i => i.name != name);

    errors.push({
        name: name,
        content: content,
        source: source
    });

    errors.sort((a,b) => a.name - b.name);
}

function createWarning(name, content, source) {
    warnings = warnings.filter(i => i.name != name);
    
    warnings.push({
        name: name,
        content: content,
        source: source
    });

    warnings.sort((a,b) => a.name - b.name);
}

function cloneElement(element, ariaLabel = null) {
    const clone = element.cloneNode(true);
    if (ariaLabel)
        clone.setAttribute("aria-label", ariaLabel);
    return clone;
}

function toggleNestedContent(button, type) {
    const ariaControls = button.getAttribute("aria-controls");
    const content = document.getElementById(ariaControls);

    let typeMessage;
    if (type == "error")
        typeMessage = "Errors";
    else if (type == "warning")
        typeMessage = "Warnings";
    else
        throw new Error("Invalid nested button type provided", type);

    if (content.getAttribute("aria-expanded") === "true") {
        content.setAttribute("hidden", "");
        content.setAttribute("aria-expanded", false);
        button.innerText = `Show Nested ${typeMessage}`;
    }
    else {
        content.removeAttribute("hidden");
        content.setAttribute("aria-expanded", true);
        button.innerText = `Hide Nested ${typeMessage}`;
    }
} 

function checkMissingRequiredFields() {
    const invalidMissingRequired = findMissingRequiredFields();
    if (invalidMissingRequired.length == 0)
        return;
    console.error("Invalid missing required fields", invalidMissingRequired);

    let html = `
        <p>
            Missing required fields within ${invalidMissingRequired.length} hierarchy elements!
            All required fields must be provided or the classification key may fail to build.
            <button id='btn-toggle-nested-missing-required-errors' aria-describedby="nested-missing-required-errors" aria-controls='nested-missing-required-errors' onclick="toggleNestedContent(this, 'error')">
                Show Nested Errors
            </button>
        </p>
        <ul id='nested-missing-required-errors' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Missing Required Fields" hidden>
    `;

    for (const info of invalidMissingRequired) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (missing required fields)");
        const elementButton = cloneButton.outerHTML;

        html += `
            <li class='border-box-list-item'>
                ${elementButton}
                <ul>
        `;

        for (const elementFilter of info.invalids) {
            html += `
                <li>
                    ${elementFilter}
                </li>
            `;
        }

        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createError("missing-required-fields", html, invalidMissingRequired);
}

function checkMissingTriggerParenthesesError() {
    const invalidParentheses = findMissingTriggerParentheses();
    if (invalidParentheses.length == 0)
        return;
    console.error("Invalid parentheses counts", invalidParentheses);

    let html = `
        <p>
            Mismatched left and right parentheses counts detected within ${invalidParentheses.length} hierarchy element triggers!
            These triggers should be revisited or the classification key may fail to build.
            <button id='btn-toggle-nested-parentheses-errors' aria-describedby="nested-parentheses-errors" aria-controls='nested-parentheses-errors' onclick="toggleNestedContent(this, 'error')">
                Show Nested Errors
            </button>
        </p>
        <ul id='nested-parentheses-errors' aria-expanded='false' aria-label="Nested Invalid Triggers" hidden>
    `;

    for (const info of invalidParentheses) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (mismatched parentheses)");
        const elementButton = cloneButton.outerHTML;
        html += `
            <li>
                ${elementButton}
            </li>
        `
    }

    html += `
        </ul>
    `

    createError("invalid-trigger-parentheses", html, invalidParentheses);
}

function checkMissingFiltersInTrigger() {
    const invalidTriggerFilters = findMissingTriggerFilters();
    if (invalidTriggerFilters.length == 0)
        return;
    console.error("Invalid missing trigger filters", invalidTriggerFilters);

    let html = `
        <p>
            Unknown filters mentioned within ${invalidTriggerFilters.length} hierarchy element triggers!
            These triggers should only reference valid filter names or the classification key may fail to build.
            <button id='btn-toggle-nested-trigger-filter-errors' aria-describedby="nested-trigger-filter-errors" aria-controls='nested-trigger-filter-errors' onclick="toggleNestedContent(this, 'error')">
                Show Nested Errors
            </button>
        </p>
        <ul id='nested-trigger-filter-errors' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Trigger Filters" hidden>
    `;

    for (const info of invalidTriggerFilters) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (missing filters)");
        const elementButton = cloneButton.outerHTML;

        html += `
            <li class='border-box-list-item'>
                ${elementButton}
                <ul>
        `;

        for (const elementFilter of info.invalids) {
            html += `
                <li>
                    ${elementFilter}
                </li>
            `;
        }

        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createError("invalid-trigger-filters", html, invalidTriggerFilters);
}

function checkInvalidBinaryValueError() {
    const invalidBinaryValues = findInvalidBinaryValues();
    if (invalidBinaryValues.length == 0)
        return;
    console.error("Invalid binary values", invalidBinaryValues);

    let html = `
        <p>
            Invalid binary values have been detected within ${invalidBinaryValues.length} hierarchy elements!
            These binary filters should only have their inputs set to "yes" or "no".
            <button id='btn-toggle-invalid-binary-errors' aria-describedby="nested-binary-errors" aria-controls='nested-binary-errors' onclick="toggleNestedContent(this, 'error')">
                Show Nested Errors
            </button>
        </p>
        <ul id='nested-binary-errors' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Binary Filters" hidden>
    `;

    for (const info of invalidBinaryValues) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (invalid binary fields)");
        const elementButton = cloneButton.outerHTML;

        let elementFilters = [];
        for (const entry of info.invalids)
            elementFilters.push(entry.filter);
        elementFilters = [...new Set(elementFilters)];

        html += `
            <li class='border-box-list-item'>
                ${elementButton}
                <ul>
        `;

        for (const elementFilter of elementFilters) {
            html += `
                <li class='invalid-binary-filter-container'>
                    <p class='invalid-filter-name'>
                        ${elementFilter}
                    </p>
                    <ul class='invalid-binary-container'>
            `;

            for (const entry of info.invalids) {
                if (entry.filter != elementFilter) 
                    continue;

                html += `
                    <li>
                        ${entry.value}
                    </li>
                `;
            }

            html += `
                    </ul>
                </li>
            `;
        }


        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createError("invalid-binary", html, invalidBinaryValues);
}

function checkMissingNodeIdInNames() {
    const missingNodeIdsInNames = findMissingNodeIdInNames();
    if (missingNodeIdsInNames.length == 0)
        return;
    console.warn("Invalid missing node ID in names", missingNodeIdsInNames);

    let html = `
        <p>
            Node ID missing from the node name of ${missingNodeIdsInNames.length} hierarchy elements!
            The standard convention for node names is to include the node ID in parentheses at the end if one exists.
            <button id='btn-toggle-nested-missing-node-id-in-name-warnings' aria-describedby="nested-missing-node-id-in-name-warnings" aria-controls='nested-missing-node-id-in-name-warnings' onclick="toggleNestedContent(this, 'warning')">
                Show Nested Warnings
            </button>
        </p>
        <ul id='nested-missing-node-id-in-name-warnings' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Missing Node ID in Names" hidden>
    `;

    for (const info of missingNodeIdsInNames) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (missing node ID in name)");
        const elementButton = cloneButton.outerHTML;

        html += `
            <li class='border-box-list-item'>
                ${elementButton}
                <ul>
        `;

        html += `
                <li>
                    <b>Missing Node ID:</b> ${info.id}
                </li>
        `;

        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createWarning("missing-node-id-in-name", html, missingNodeIdsInNames);
}

function checkUnconventionalFileNames() {
    const unconventionalFileNames = findUnconventionalFileNames();
    if (unconventionalFileNames.length == 0)
        return;
    console.warn("Invalid unconventional file names", unconventionalFileNames);

    let html = `
        <p>
            Unconventional file names detected within ${unconventionalFileNames.length} hierarchy elements!
            The following elements have file names that don't follow standard conventions. Use of the "Suggest" button is recommended for these file names.
            <button id='btn-toggle-nested-unconventional-file-name-warnings' aria-describedby="nested-unconventional-file-name-warnings" aria-controls='nested-unconventional-file-name-warnings' onclick="toggleNestedContent(this, 'warning')">
                Show Nested Warnings
            </button>
        </p>
        <ul id='nested-unconventional-file-name-warnings' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Unconventional File Names" hidden>
    `;

    for (const info of unconventionalFileNames) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (unconventional file name)");
        const elementButton = cloneButton.outerHTML;

        html += `
            <li class='border-box-list-item'>
                ${elementButton}
                <ul>
        `;

        html += `
                <li>
                    <b>File Name:</b> ${info.fileName}
                </li>
                <li>
                    <b>Suggested Name:</b> ${info.suggestedName}
                </li>
        `;

        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createWarning("unconventional-file-name", html, unconventionalFileNames);
}

function checkDuplicateNodeIds() {
    const duplicateNodeIds = findDuplicateNodeIds();
    if (duplicateNodeIds.length == 0)
        return;
    console.warn("Invalid duplicate node IDs", duplicateNodeIds);

    let html = `
        <p>
            Duplicate node IDs detected within ${duplicateNodeIds.length} hierarchy elements!
            The following elements are unconventional because they have non-unique node IDs. Most hierarchy elements either have a unique node ID or none at all.
            <button id='btn-toggle-nested-duplicate-node-ids-warnings' aria-describedby="nested-duplicate-node-ids-warnings" aria-controls='nested-duplicate-node-ids-warnings' onclick="toggleNestedContent(this, 'warning')">
                Show Nested Warnings
            </button>
        </p>
        <ul id='nested-duplicate-node-ids-warnings' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Duplicate Node IDs" hidden>
    `;

    for (const info of duplicateNodeIds) {
        

        html += `
            <li class='border-box-list-item'>
                <b>Node ID:</b> ${info.id}
                <ul>
        `;

        for (const button of info.buttons) {
            const cloneButton = cloneElement(button, button.innerText + " (duplicate node ID)");
            const elementButton = cloneButton.outerHTML;

            html += `
            <li>
                ${elementButton}
            </li>
            `;
        }

        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createWarning("duplicate-node-ids", html, duplicateNodeIds);
}

function checkInvalidSpeciesWarning() {
    const invalidSpeciesInfo = findInvalidSpecies();
    if (invalidSpeciesInfo.length == 0)
        return;
    console.warn("Invalid species info", invalidSpeciesInfo);

    let html = `
        <p>
            Non-tracked FIA species filters have been detected within ${invalidSpeciesInfo.length} hierarchy elements!
            These species filters will simply catch no conditions while running the classification key.
            <button id='btn-toggle-nested-species-warnings' aria-describedby="nested-species-warnings" aria-controls='nested-species-warnings' onclick="toggleNestedContent(this, 'warning')">
                Show Nested Warnings
            </button>
        </p>
        <ul id='nested-species-warnings' class='border-box-list' aria-expanded='false' aria-label="Nested Invalid Species Filters" hidden>
    `;

    for (const info of invalidSpeciesInfo) {
        const cloneButton = cloneElement(info.button, info.button.innerText + " (invalid species)");
        const elementButton = cloneButton.outerHTML;

        let elementFilters = [];
        for (const entry of info.invalids)
            elementFilters.push(entry.filter);
        elementFilters = [...new Set(elementFilters)];

        html += `
            <li class='border-box-list-item'>
                ${elementButton}
                <ul>
        `;

        for (const elementFilter of elementFilters) {
            html += `
                <li class='invalid-species-filter-container'>
                    <p class='invalid-filter-name'>
                        ${elementFilter}
                    </p>
                    <ul class='invalid-species-container'>
            `;

            for (const entry of info.invalids) {
                if (entry.filter != elementFilter) 
                    continue;

                const invalidSpeciesName = entry.value;
                html += `
                    <li>
                        ${invalidSpeciesName}
                    </li>
                `;
            }

            html += `
                    </ul>
                </li>
            `;
        }


        html += `
                </ul>
            </li>        
        `;
    }

    html += `
        </ul>
    `;

    createWarning("invalid-species", html, invalidSpeciesInfo);
}

function findMissingRequiredFields() {
    let invalid = [];
    for (const element of hierarchy.filter(i => i.hierarchyName != "ROOT")) {
        let invalids = [];
        if (element.hierarchyName == "")
            invalids.push("Node Name");

        if (element.fileName == "")
            invalids.push("Node Description");

        if (element.node.description == "")
            invalids.push("Node Description");

        if (!element.parent)
            invalids.push("Parent Node");

        if (element.node.trigger == "")
            invalids.push("Node Trigger");

        const filterNames = Object.keys(element.node.filters);
        if (filterNames.includes(""))
            invalids.push("Node Filter Names");
        
        if (invalids.length == 0) 
            continue;
        
        invalid.push({
            hierarchyName: element.hierarchyName,
            element: element,
            button: findHierarchyButton(element.hierarchyName),
            invalids: invalids
        });
    }

    return invalid;
}

function findMissingTriggerParentheses() {
    let invalid = [];
    for (const element of hierarchy) {
        const trigger = element.node.trigger;
        const joinedTrigger = trigger.join("\n");
        const matchingParentheses = doParenthesesMatchInTrigger(joinedTrigger);
        if (matchingParentheses) continue;

        invalid.push({
            hierarchyName: element.hierarchyName,
            element: element,
            button: findHierarchyButton(element.hierarchyName)
        });
    }

    return invalid;
}

function doParenthesesMatchInTrigger(trigger) {
    const leftCount = (trigger.match(/\(/g) || []).length
    const rightCount = (trigger.match(/\)/g) || []).length
    return leftCount == rightCount;
}

function findMissingTriggerFilters() {
    let invalid = [];
    for (const element of hierarchy) {
        if (element.hierarchyName == "ROOT") continue;
        const trigger = element.node.trigger;
        const joinedTrigger = trigger.join("\n");
        const filters = Object.keys(element.node.filters);
        const invalids = findMissingFiltersInTrigger(joinedTrigger, filters);
        if (invalids.length == 0) continue;
        
        invalid.push({
            hierarchyName: element.hierarchyName,
            element: element,
            button: findHierarchyButton(element.hierarchyName),
            invalids: invalids
        });
    }

    return invalid;
}

function findInvalidBinaryValues() {
    let availableKeys = ["plantation", "hydric", "riverine", "ruderal", "exotic", "planted", "tallytree"];
    let datalistDetails = getDatalistDetails("binary-list");
    let availableValues = datalistDetails.options;
    return findInvalidFilters(availableKeys, availableValues);
}

function findInvalidSpecies() {
    let availableKeys = ["species"];
    let availableValues = availableSpecies;
    return findInvalidFilters(availableKeys, availableValues);
}

function findMissingNodeIdInNames() {
    let invalid = [];
    for (const element of hierarchy.filter(i => i.hierarchyName != "ROOT")) {
        const missingId = `(${element.node.id})`;
        if (!element.node.id || element.hierarchyName.includes(missingId))
            continue;
        
        invalid.push({
            hierarchyName: element.hierarchyName,
            element: element,
            button: findHierarchyButton(element.hierarchyName),
            id: missingId
        });
    }

    return invalid;
}

function findUnconventionalFileNames() {
    let invalid = [];
    for (const element of hierarchy.filter(i => i.hierarchyName != "ROOT")) {
        const fileName = element.fileName;
        const suggestedName = generateFileNameFromValue(element.hierarchyName);
        
        if (fileName == suggestedName) 
            continue;
        
        invalid.push({
            hierarchyName: element.hierarchyName,
            element: element,
            button: findHierarchyButton(element.hierarchyName),
            fileName: fileName,
            suggestedName: suggestedName
        });
    }

    return invalid;
}

function findDuplicateNodeIds() {
    let invalid = [];
    const context = hierarchy.filter(i => i.hierarchyName != "ROOT" && i.node.id != "");
    for (const element of context) {
        // Skip already accounted for node IDs
        if (invalid.filter(i => i.id == element.node.id).length > 0)
            continue;

        const elementsWithNodeId = context.filter(i => i.node.id == element.node.id);
        if (elementsWithNodeId.length == 1) 
            continue;

        invalid.push({
            id: element.node.id,
            elements: elementsWithNodeId,
            buttons: elementsWithNodeId.map(i => findHierarchyButton(i.hierarchyName))
        });
    }

    return invalid;
}

function findInvalidFilters(availableKeys, availableValues) {
    let invalidInfo = [];
    for (const element of hierarchy) {
        const filters = element.node.filters;
        for (const [filterKey, filterValues] of Object.entries(filters)) {
            for (const filterValue of filterValues) {
                invalidInfo = extractInvalidInfo(invalidInfo, availableKeys, availableValues, element, filterKey, filterValue);
            }
        }
    }
    return invalidInfo;
}

function extractInvalidInfo(invalidInfo, availableKeys, availableValues, element, filterKey, filterValue) {
    for (const [subFilterKey, subFilterValue] of Object.entries(filterValue)) {
        // Skip if sub-filter key isn't available
        if (!availableKeys.includes(subFilterKey)) continue;
        // Skip if sub-filter key and value are available
        if (availableValues.includes(subFilterValue)) continue;
        // Either add new unique invalid info node entries or add to their existing invalids list
        const subFilterCombo = `${subFilterKey}: ${subFilterValue}`;
        let existingInvalid = invalidInfo.filter(i => i.element == element)[0];
        if (!existingInvalid) {
            invalidInfo.push({
                hierarchyName: element.hierarchyName,
                invalids: [{
                    filter: filterKey,
                    value: subFilterCombo
                }],
                element: element,
                button: findHierarchyButton(element.hierarchyName)
            });
        }
        else {
            existingInvalid.invalids.push({
                filter: filterKey,
                value: subFilterCombo
            });
        }
    }
    return invalidInfo;
}

function findHierarchyButton(hierarchyName) {
    let selector = `#detected-json-container button[data-hierarchy-name='${hierarchyName}']`;
    let element = document.querySelector(selector);
    return element;   
}

async function openBrowseDialog(targetPath = "") {
    try {
        const returnedData = await window.electronAPI.openBrowse(targetPath);
        return returnedData;
    }
    catch (error) {
        alert(error);
        return null;
    }
}

let datalistDetails = [];
function getDatalistDetails(listId) {
    let datalistDetail = datalistDetails.filter(i => i.id == listId)[0];
    if (!datalistDetail) {
        const list = document.getElementById(listId);
        datalistDetail = {
            id: listId,
            type: list.getAttribute("data-type"),
            message: list.getAttribute("data-missing-message"),
            options: getOptionValuesFromDataList(list)
        };
        datalistDetails.push(datalistDetail);
    }
    return datalistDetail;
}

function findInvalidsForSubFilters(newMarkedElements) {
    const inputTypes = document.querySelectorAll("input[list].input-value:not(.skip-validation)");
    for (const element of inputTypes) {
        const input = element.value;
        const listId = element.getAttribute("list");
        if (!listId) continue;
        const listDetails = getDatalistDetails(listId);
        if (!listDetails.options.includes(input))
            newMarkedElements = addMarkedElementMessage(newMarkedElements, element, listDetails.message, listDetails.type);
    }
    return newMarkedElements;
}

function markElementAsType(element, type, title = null) {
    if (type == null) {
        element.classList.remove(mapTypeToClass("error"))
        element.classList.remove(mapTypeToClass("warning"))
        element.removeAttribute("title");
        return;
    }
    const listTypeClass = mapTypeToClass(type);
    element.classList.add(listTypeClass);
    element.setAttribute("title", title);
}

function mapTypeToClass(type) {
    switch (type) {
        case "warning":
            return "warning-bg-color";
        case "error":
            return "error-bg-color";
        default:
            console.error("Invalid type provided for class mapping", type);
            return;
    }
}

function getOptionValuesFromDataList(list) {
    const listOptions = list.querySelectorAll("option");
    const listValues = [...listOptions].map(i => i.value);
    return listValues;
}

function convertStringToNumbersList(stringList) {
    // stringList is '[2015, 2016, 2017]' or ['2015', '2016', '2017']
    let numberSplit = stringList;
    if (typeof(stringList) == 'string')
        numberSplit = stringList.substring(1, stringList.length - 1).split(",");
    
    let numberList = [];
    for (let number of numberSplit)
        numberList.push(Number(number));

    return numberList;
}

async function getDefaultTestSettings() {
    let defaultSettings = await fetchSettings();
    testSettings = {};
    testSettings.inventoryYears = convertStringToNumbersList(defaultSettings.inventoryYears);
    testSettings.additionalWhere = defaultSettings.additionalWhere;
    testSettings.keepExisting = false;
}

async function openSettingsDialog() {

    if (!availableYears) {
        await fetchAvailableYears();
    }

    if (!testSettings) {
        await getDefaultTestSettings();
    }

    updateSettingsDialogValues();

    const dialog = document.getElementById("settings-dialog");
    showDialog(dialog);
}

function updateSettingsDialogValues() {
    updateAvailableYears();
    document.getElementById("settings-additional-where").value = testSettings.additionalWhere;
    document.getElementById("settings-keep-existing").checked = testSettings.keepExisting;
}

function showDialog(dialog) {
    dialog.showModal();

    const dialogBody = dialog.querySelector(".body-container");
    dialogBody.scroll({ top: 0 });
}

function showPopup(dialog) {
    dialog.showModal();

    const dialogBody = dialog.querySelector(".popup-content");
    dialogBody.scroll({ top: 0, left: 0 });
}

function showContentById(id) {
    const element = document.getElementById(id);
    element.removeAttribute("hidden");
}

function hideContentById(id) {
    const element = document.getElementById(id);
    element.setAttribute("hidden", "");
}

function saveSettingsChanges(closeAfter = true) {
    const checkedInventoryYears = [...document.querySelectorAll("#settings-inv-years input[type='checkbox']:checked")];
    let inventoryYears = checkedInventoryYears.map(i => i.value);
    for (let i = 0; i < inventoryYears.length; i++) {
        let stringValue = inventoryYears[i];
        stringValue = stringValue.trim();
        let numberValue = Number(stringValue);
        if (isNaN(numberValue)) {
            console.error(message);
            alert(message);
            continue;
        }

        inventoryYears[i] = numberValue;
    }
    inventoryYears.sort((a, b) => a - b);

    const additionalWhere = document.getElementById("settings-additional-where").value;
    const keepExisting = document.getElementById("settings-keep-existing").checked;

    testSettings.inventoryYears = inventoryYears;
    testSettings.additionalWhere = additionalWhere.trim();
    testSettings.keepExisting = keepExisting;
    
    if (closeAfter)
        document.getElementById("settings-dialog").close();
}

async function resetSettings() {
    const message = `Are you sure you want to reset your settings back to the default?`;
    if (!await confirm(message))
        return;

    await getDefaultTestSettings();
    updateSettingsDialogValues();
}

function findMissingFiltersInTrigger(trigger, filters) {
    const regex = /(match|riv|spcov)\(([^)]*)\)/g;
    const references = trigger.match(regex) ?? [];
    
    let missing = [];
    for (const reference of references) {
        const filter = reference.replace("match(", "").replace("riv(", "").replace("spcov(", "").replace(")", "");
        if (filters.includes(filter)) continue;
        missing.push(reference);
    }

    return missing;
}

function detectHierarchyChanges() {
    let changes = [];

    // Record element changes
    const newNames = hierarchy.map(i => i.hierarchyName);
    const oldNames = initialHierarchy.map(i => i.hierarchyName);
    const addedNames = newNames.filter(i => !oldNames.includes(i));
    const removedNames = oldNames.filter(i => !newNames.includes(i));
    const sameNames = oldNames.filter(i => newNames.includes(i));
    for (const addedName of addedNames)
        changes.push(generateLogMessage(`+ Added element "${addedName}"`, 0));
    for (const removedName of removedNames)
        changes.push(generateLogMessage(`- Removed element "${removedName}"`, 0));
    for (const sameName of sameNames)
        changes = detectExistingElementHierarchyChanges(changes, sameName);

    return changes.join("\r\n");
}

function detectExistingElementHierarchyChanges(changes, sameName) {
    const newElement = hierarchy.filter(i => i.hierarchyName == sameName)[0];
    const initElement = initialHierarchy.filter(i => i.hierarchyName == sameName)[0];

    // Record general changes
    let elementChanges = [];
    if (initElement.fileName != newElement.fileName)
        elementChanges.push(generateLogMessage("~ Updated File Name", 1));

    if (initElement.node.description.join("\r\n") != newElement.node.description.join("\r\n"))
        elementChanges.push(generateLogMessage("~ Updated Description", 1));

    if (initElement.node.id != newElement.node.id)
        elementChanges.push(generateLogMessage("~ Updated ID", 1, initElement.node.id, newElement.node.id));

    if (initElement.node.level != newElement.node.level)
        elementChanges.push(generateLogMessage("~ Updated Level", 1, initElement.node.level, newElement.node.level));

    if (initElement.node.trigger.join("\r\n") != newElement.node.trigger.join("\r\n"))
        elementChanges.push(generateLogMessage("~ Updated Trigger", 1));

    if (initElement.parent?.hierarchyName != newElement.parent?.hierarchyName)
        elementChanges.push(generateLogMessage("~ Updated Parent Element", 1, initElement.parent.hierarchyName, newElement.parent.hierarchyName));

    // Record child position changes
    const initChildren = initElement.children?.map((i, index) => { return { hierarchyName: i.hierarchyName, index: index }});
    const newChildren = newElement.children?.map((i, index) => { return { hierarchyName: i.hierarchyName, index: index }});
    const addedChildren = newChildren.filter(i => !initChildren.map(i => i.hierarchyName).includes(i.hierarchyName));
    const removedChildren = initChildren.filter(i => !newChildren.map(i => i.hierarchyName).includes(i.hierarchyName));
    const sharedChildren = initChildren.filter(i => newChildren.map(i => i.hierarchyName).includes(i.hierarchyName));
    for (const addedChild of addedChildren)
        elementChanges.push(generateLogMessage(`+ Added Child Element "${addedChild.hierarchyName}" at position "${addedChild.index}"`, 1));
    for (const removedChild of removedChildren)
        elementChanges.push(generateLogMessage(`+ Removed Child Element "${removedChild.hierarchyName}" at position "${removedChild.index}"`, 1));
    for (const sharedChild of sharedChildren) {
        const initChildIndex = initChildren.filter(i => i.hierarchyName == sharedChild.hierarchyName).map(i => i.index)[0];
        const newChildIndex = newChildren.filter(i => i.hierarchyName == sharedChild.hierarchyName).map(i => i.index)[0];
        if (initChildIndex != newChildIndex)
            elementChanges.push(generateLogMessage(`~ Updated Child Element "${sharedChild.hierarchyName}" position`, 1, initChildIndex, newChildIndex))
    }

    // Record Filter changes
    const initFilterKeys = Object.keys(initElement.node.filters);
    const newFilterKeys = Object.keys(newElement.node.filters);
    const addedKeys = newFilterKeys.filter(i => !initFilterKeys.includes(i));
    const removedKeys = initFilterKeys.filter(i => !newFilterKeys.includes(i));
    const sharedKeys = initFilterKeys.filter(i => newFilterKeys.includes(i));
    for (const addedKey of addedKeys)
        elementChanges.push(generateLogMessage(`+ Added Filter Key "${addedKey}"`, 1));
    for (const removedKey of removedKeys)
        elementChanges.push(generateLogMessage(`- Removed Filter Key "${removedKey}"`, 1));

    // Check sub-filters
    elementChanges = detectSubFilterHierarchyChanges(elementChanges, initElement, newElement, sharedKeys);

    // Compile all changes
    if (elementChanges.length == 0) 
        return changes;

    changes.push(generateLogMessage(`~ Updated element "${sameName}"`, 0));
    changes.push(...elementChanges);
    return changes;
}

function detectSubFilterHierarchyChanges(elementChanges, initElement, newElement, sharedKeys) {
    for (const sharedKey of sharedKeys) {
        const initSubFilters = initElement.node.filters[sharedKey];
        const newSubFilters = newElement.node.filters[sharedKey];

        let initSubFilterKeyValues = createSubFilterKeyValueList(initSubFilters);
        let newSubFilterKeyValues = createSubFilterKeyValueList(newSubFilters);

        // Record sub-filter changes
        let subFilterChanges = [];
        const addedSubKeys = newSubFilterKeyValues.filter(i => !initSubFilterKeyValues.includes(i));
        const removeSubdKeys = initSubFilterKeyValues.filter(i => !newSubFilterKeyValues.includes(i));
        for (const addedSubKey of addedSubKeys)
            subFilterChanges.push(`+ Added Filter Value "${addedSubKey}"`);
        for (const removedSubKey of removeSubdKeys)
            subFilterChanges.push(`- Removed Filter Value "${removedSubKey}"`);

        if (subFilterChanges.length > 0) {
            elementChanges.push(generateLogMessage(`~ Updated Filter Key "${sharedKey}"`, 1));
            for (const subFilterChange of subFilterChanges)
                elementChanges.push(generateLogMessage(subFilterChange, 2));
        }
    }
    return elementChanges;
}

function createSubFilterKeyValueList(subFilters) {
    let filterKeyValues = [];
    for (const subFilter of subFilters) {
        const subFilterKeys = Object.keys(subFilter);
        const subFilterValues = Object.values(subFilter);
        for (let i = 0; i < subFilterKeys.length; i++)
            filterKeyValues.push(`${subFilterKeys[i]}: ${subFilterValues[i]}`)
    }
    return filterKeyValues;
}

function generateLogMessage(action, tabCount, before = null, after = null) {
    const tabs = "\t".repeat(tabCount);
    if (!before && !after)
        return `${tabs}${action}`;
    return `${tabs}${action} from "${before}" to "${after}"`;
}

async function confirm(message) {
    return await new Promise((success, failure) => {
        document.getElementById("confirm-dialog").returnValue = "";
        document.getElementById("confirm-dialog-text").innerText = message;
        let confirmClose = (event) => {
            document.getElementById("confirm-dialog").removeEventListener("close", confirmClose);
            const dialogValue = document.getElementById("confirm-dialog").returnValue;
            const confirmation = dialogValue === "confirm";
            success(confirmation)
        }
        document.getElementById("confirm-dialog").addEventListener("close", confirmClose);
        showPopup(document.getElementById("confirm-dialog"));
    });
}

document.getElementById("confirm-dialog-ok").addEventListener("click", (event) => {
    event.preventDefault();
    document.getElementById("confirm-dialog").close("confirm");
});

function alert(message) {
    document.getElementById("alert-dialog-text").innerText = message;
    showPopup(document.getElementById("alert-dialog"));
}

document.getElementById("alert-dialog-ok").addEventListener("click", (event) => {
    event.preventDefault();
    document.getElementById("alert-dialog").close();
});

