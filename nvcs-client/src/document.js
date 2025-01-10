let documentStructure = {
    sections: [
        {
            name: "sectionOne",
            content: [
                {
                    type: "header",
                    level: "1",
                    content: "SECTION I. KEY TO PLANTATION VS. NATURAL [WESTERN SECTION]"
                },
                {
                    type: "text",
                    content: "A summary of the forest plantation types is provided in Table xx."
                },
                {
                    type: "text",
                    content: "[work with FIA staff to determine what is needed for plantation types in west.]"
                },
                {
                    type: "text",
                    content: "Forest types are separated first into plantation versus natural types. FIA field crews " +
                    "make that call in the field, and we rely entirely on that call to make the distinction. The " +
                    "plantation label is sometimes applied to failed plantations that may now be dominated by " +
                    "non-plantation species (typically hardwoods), to stands in very early stages of planting (and thus " +
                    "dominated by native conifers or hardwoods) or to transitional areas that are on the edge of the " +
                    "plantation. Likewise, failed attempts to establish plantations may become obscured following " +
                    "subsequent natural regeneration, in such cases, FIA field crews observe no plantation evidence and " +
                    "label stand origin as natural regeneration, possibly conflicting with, or updating, historical stand " +
                    "records (which are not utilized in this classification)."
                },
                {
                    type: "element",
                    hierarchyName: "Forest Plantations"
                },
                {
                    type: "element",
                    hierarchyName: "Natural (including ruderal) Forests"
                }
            ]
        }
    ]
};

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
    const dialog = document.getElementById("document-dialog");
    populateDocumentDialog(dialog);
    showDialog(dialog);
}

function populateDocumentDialog(dialog) {
    let html = "";

    for (const section of documentStructure.sections) {
        // New section prep
        const identifier = newGuid();
        html += "<div class='document-section'>";

        // Section Name
        html += `
            <div class='input-container'>
                <label for='section-name'>Section Name:</label>
                <input id='section-name' type='text' value='${section.name}' />
                <button id='btn-delete-seciton'>Delete</button>
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
                <button id='btn-add-document-header-${identifier}'>Add Header</button>
                <button id='btn-add-document-text-${identifier}'>Add Text</button>
                <button id='btn-add-document-element-${identifier}'>Add Element Description</button>
            </div>
        `;

        html += "</div>";
    }

    // Add Section Settings
    html += `
        <div class='input-container'>
            <label for='add-section-name'>New Section Name:</label>
            <input id='add-section-name' type='text' />
            <button id='add-section'>Add Section</button>
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
    const element = hierarchy.filter(i => i.hierarchyName = item.hierarchyName)[0];
    const hierarchyOptions = generateElementOptions(hierarchy, element);
    const identifier = newGuid();

    let html = `
        <div class='input-container'>
            <label for='element-source-${identifier}'>Element Description Source:</label>
            <select id='element-source-${identifier}'>
                ${hierarchyOptions}
            </select>
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
        <div class='input-container'>
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

    let html = `
        <div class='input-container'>
            <label for='text-content-${identifier}'>Text Content:</label>
            <textarea id='text-content-${identifier}'>${item.content}</textarea>
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