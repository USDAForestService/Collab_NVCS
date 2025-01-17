function toggleDocumentForm() {
    const documentForm = document.getElementById("document-form");
    if (documentForm.hidden)
        showDocumentForm();
    else
        hideDocumentForm();
}

function showDocumentForm() {
    // Hide JSON tree
    hideContentById("detected-json-container");

    // Generate document
    generateDocument();

    // Show document container
    showContentById("document-form");
}

function hideDocumentForm() {
    // Hide document container
    hideContentById("document-form");

    // Show JSON tree
    showContentById("detected-json-container");
}

function openDocumentDialog() {
    unsavedDocumentStructure = documentStructure;
    populateDocumentDialog();
    const dialog = document.getElementById("document-dialog");
    showDialog(dialog);
}

function populateDocumentDialog() {
    const dialog = document.getElementById("document-dialog");
    let html = "";

    for (const section of unsavedDocumentStructure.sections) {
        // New section prep
        const identifier = newGuid();
        html += `<div id='${identifier}' class='document-section'>`;

        // Section Name
        html += `
            <div class='input-container'>
                <label for='section-name-${identifier}'>Section Name:</label>
                <input id='section-name-${identifier}' type='text' value='${section.name}' />
                <button id='btn-delete-section-${identifier}'>Delete</button>
            </div>
        `;

        // Existing Content
        html += "<div class='document-section-content'>";
        for (const content of section.content)
            html += generateDocumentEditorContent(content)
        html += "</div>";

        // Add Content Settings
        html += `
            <div>
                <button id='btn-add-document-header-${identifier}' onclick="addDocumentHeader('${identifier}')">Add Header</button>
                <button id='btn-add-document-text-${identifier}' onclick="addDocumentText('${identifier}')">Add Text</button>
                <button id='btn-add-document-element-${identifier}' onclick="addDocumentElement('${identifier}')">Add Element Description</button>
            </div>
        `;

        html += "</div>";
    }

    // Add Section Settings
    html += `
        <div class='input-container'>
            <label for='add-section-name'>New Section Name:</label>
            <input id='add-section-name' type='text' />
            <button id='add-section' onclick="addDocumentSection()">Add Section</button>
        </div>
    `;

    // Apply HTML
    const body = dialog.querySelector(".body-container");
    body.innerHTML = html;
}

function generateDocumentEditorContent(item) {
    let html = "";

    switch (item.type) {
        case "element":
            html += generateDocumentEditorElementContent(item);
            break;
        case "header":
            html += generateDocumenEditortHeaderContent(item);
            break;
        case "text":
            html += generateDocumentEditorTextContent(item);
            break;
        default:
            throw new Error("Invalid type provided", item.type);
    }

    return html;
}

function generateDocumentEditorElementContent(item) {
    const element = hierarchy.filter(i => i.hierarchyName == item.hierarchyName)[0];
    const identifier = newGuid();

    let html = `
        <div class='input-container document-element'>
            <label for='element-source-${identifier}'>Element Description Source:</label>
            <input id='element-source-${identifier}' type='text' list='full-hierarchy-list' value='${element.hierarchyName}'/>
        </div>
    `;

    return html;
}

function generateDocumenEditortHeaderContent(item) {
    const identifier = newGuid();
    let levelOptions = "";
    for (let i = 1; i <= 6; i++) {
        const selected = item.level == i ? "selected" : "";
        levelOptions += `<option value="${i}" ${selected}>${i}</option>`;
    }

    let html = `
        <div class='input-container document-header'>
            <label for='header-content-${identifier}'>Header Content:</label>
            <input id='header-content-${identifier}' type="text" value='${item.content}'/>
            <label for='header-level-${identifier}'>Header Level:</label>
            <select id='header-level-${identifier}'>
                ${levelOptions}
            </select>
        </div>
    `;
    
    return html;
}

function generateDocumentEditorTextContent(item) {
    const identifier = newGuid();
    const joinedContent = item.content.join("\r\n");

    let html = `
        <div class='input-container document-text'>
            <label for='text-content-${identifier}'>Text Content:</label>
            <textarea id='text-content-${identifier}'>${joinedContent}</textarea>
        </div>
    `;
    
    return html;
}

function generateDocument() {
    let html = "";
    
    html += generateDocumentSectionOne();
    html += generateDocumentSectionTwo();
    html += generateDocumentSectionThree();
    html += generateDocumentSectionFour();

    const documentContainer = document.getElementById("document-container");
    documentContainer.innerHTML = html;
}

function generateDocumentSectionOne() {
    let html = "<h1>SECTION I. KEY TO PLANTATION VS. NATURAL [WESTERN SECTION]</h1>";
    html += "<p><b>[HARDCODED]</b> A summary of the forest plantation types is provided in Table xx.</p>" +
        "<p>[work with FIA staff to determine what is needed for plantation types in west.]</p>" +
        "<p>Forest types are separated first into plantation versus natural types. FIA field crews make that call in the " +
        "field, and we rely entirely on that call to make the distinction. The plantation label is sometimes applied to " +
        "failed plantations that may now be dominated by non-plantation species (typically hardwoods), to stands in very " +
        "early stages of planting (and thus dominated by native conifers or hardwoods) or to transitional areas that are " +
        "on the edge of the plantation. Likewise, failed attempts to establish plantations may become obscured following " +
        "subsequent natural regeneration, in such cases, FIA field crews observe no plantation evidence and label stand " +
        "origin as natural regeneration, possibly conflicting with, or updating, historical stand records (which are not " +
        "utilized in this classification).</p>";
    const designatedElements = hierarchy.filter(i => i.hierarchyLevel == 0);
    html += "<ul>";
    for (const element of designatedElements) {
        html += "<li>";
        html += generateDocumentDescription(element);
        html += "</li>";
    }
    html += "</ul>";
    return html;
}

function generateDocumentSectionTwo() {
    let html = "<h1>SECTION II. KEY TO FORESTED VS. NON-FORESTED [WESTERN SECTION]</h1>";
    html += "<p><b>[HARDCODED]</b> IF RIV = 0 AND TTCOV <= 20%, then \"Possibly Regenerating\"</p>";
    return html;
}

function generateDocumentSectionThree() {
    let html = "<h1>SECTION III. KEY TO UPLAND VS. WETLAND [WESTERN SECTION]</h1>";
    const designatedElements = hierarchy.filter(i => i.hierarchyName == "Natural (including ruderal) Forests")[0].children;
    html += "<ul>";
    for (const element of designatedElements) {
        html += "<li>";
        html += generateDocumentDescription(element);
        html += "</li>";
    }
    html += "</ul>";
    return html;
}

function generateDocumentSectionFour() {
    let html = "<h1>SECTION IV. KEY TO NATURAL UPLAND FOREST & WOODLAND DIVISIONS</h1>";
    html += "<h2>IV.1. Skeletal Version (upland)</h2>";
    html += "<p>TODO</p>";
    html += "<h2>IV.2. Detailed Version (upland)</h2>";
    html += "<p><b>[HARDCODED]</b>Please read the introduction to understand the approach used in the key.</p>";
    const designatedRoot = hierarchy.filter(i => i.hierarchyName == "Upland Forest & Woodlands")[0];
    const designatedChildTypes = ["subclass", "formation", "division"];
    let designatedChildren = [];
    for (const child of designatedRoot.children)
        designatedChildren = getDescendantElementsByType(designatedChildren, child, designatedChildTypes);
    html += "<ul>";
    for (const element of designatedChildren) {
        html += "<li>";
        html += generateDocumentDescription(element);
        html += "</li>";
    }
    html += "</ul>";
    return html;
}

function generateDocumentDescription(element) {
    let returnString = "<p style='white-space: pre-wrap;'>";
    let descriptionList = [...element.node.description];
    const leadingSpaceReplace = "    ";
    for (let i = 0; i < descriptionList.length; i++) {
        descriptionList[i] = descriptionList[i].replace(/^(\s|\\t)+/, function(i) { return i.replace(/\s/g, leadingSpaceReplace); });
    }
    let fullDescription = descriptionList.join("</br>");
    returnString += fullDescription;
    returnString += ` ... <button data-hierarchy-name='${element.hierarchyName}' class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'><b>${element.hierarchyName}</b></button>`;
    returnString += "</p>";
    return returnString;
}

function generateDocumentListEntry(element) {
    let returnString = "<li>";
    returnString += generateDocumentDescription(element);
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateDocumentListEntry(child);
    returnString += "</ul>";
    returnString += "</li>";
    return returnString;
}

function getDocumentHeaderTagForElement(element) {
    const hierarchyLevel = element.hierarchyLevel;
    const headerLevel = Math.min(hierarchyLevel + 1, 6);
    console.log(hierarchyLevel, headerLevel);
    const headerTag = "h" + headerLevel;
    return headerTag;
}

function getDescendantElementsByType(descendants, rootElement, types) {
    if (!types.includes(rootElement.node.level))
        return descendants;

    descendants.push(rootElement);

    for (const child of rootElement.children)
        descendants = getDescendantElementsByType(descendants, child, types);

    return descendants;
}

function findDocumentSectionFromIdentifier(structure, identifier) {
    const sectionInput = document.getElementById(`section-name-${identifier}`);
    const sectionName = sectionInput.value;
    const targetSection = structure.sections.filter(i => i.name == sectionName)[0];
    if (!targetSection)
        throw new Error("Failed to find target section:", targetSection);
    return targetSection;
}

function addDocumentSection() {
    recordUnsavedChanges();

    const sectionName = document.getElementById("add-section-name").value;
    const existingSections = unsavedDocumentStructure.sections.filter(i => i.name == sectionName);
    if (existingSections.length > 0) {
        const message = "The provided section name already exists, please provide a unique section name";
        alert(message);
        return;
    }

    unsavedDocumentStructure.sections.push({
        name: sectionName,
        content: []
    });

    populateDocumentDialog();
}

function addDocumentHeader(identifier) {
    recordUnsavedChanges();

    const targetSection = findDocumentSectionFromIdentifier(unsavedDocumentStructure, identifier);
    targetSection.content.push({
        type: "header",
        level: "1",
        content: ""
    });

    populateDocumentDialog();
}

function addDocumentText(identifier) {
    recordUnsavedChanges();

    const targetSection = findDocumentSectionFromIdentifier(unsavedDocumentStructure, identifier);
    targetSection.content.push({
        type: "text",
        content: []
    });

    populateDocumentDialog();
}

function addDocumentElement(identifier) {
    recordUnsavedChanges();

    const targetSection = findDocumentSectionFromIdentifier(unsavedDocumentStructure, identifier);
    targetSection.content.push({
        type: "element",
        hierarchyName: null
    });

    populateDocumentDialog();
}

function recordUnsavedChanges() {
    unsavedDocumentStructure = {
        sections: []
    };

    const dialog = document.getElementById("document-dialog");
    const sectionContainers = dialog.querySelectorAll(".body-container > .document-section");
    for (const sectionContainer of [...sectionContainers]) {
        const sectionId = sectionContainer.id;
        const sectionName = sectionContainer.querySelector(`#section-name-${sectionId}`).value;
        
        let sectionContent = [];
        const sectionContentContainers = sectionContainer.querySelectorAll(".document-section-content .input-container");
        for (const contentContainer of [...sectionContentContainers]) {
            if (contentContainer.classList.contains("document-header")) {
                const headerContent = contentContainer.querySelector("input").value;
                const headerLevel = contentContainer.querySelector("select").value;
                sectionContent.push({
                    type: "header",
                    content: headerContent,
                    level: headerLevel
                });
            }
            else if (contentContainer.classList.contains("document-text")) {
                const textContent = contentContainer.querySelector("textarea").value;
                const splitTextContent = textContent.split("\n");
                sectionContent.push({
                    type: "text",
                    content: splitTextContent
                });
            }
            else if (contentContainer.classList.contains("document-element")) {
                const elementName = contentContainer.querySelector("input").value;
                sectionContent.push({
                    type: "element",
                    hierarchyName: elementName
                });
            }
            else {
                throw new Error("Invalid class list detected for element", contentContainer);
            }
        }

        unsavedDocumentStructure.sections.push({
            name: sectionName,
            content: sectionContent
        });
    }
}

async function saveDocumentChanges() {
    const confirmSaveMessage = "Are you sure you wanted to save these changes?";
    if (!await confirm(confirmSaveMessage))
        return;

    recordUnsavedChanges();
    documentStructure = unsavedDocumentStructure;
    
    document.getElementById("document-dialog").close();
}