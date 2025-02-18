function toggleDocumentForm() {
    const documentForm = document.getElementById("document-form");
    if (documentForm.classList.contains("hidden"))
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
            <div id='document-content-${identifier}' class='document-content'>
                <div class='input-container'>
                    <label for='section-name-${identifier}'>Section Name:</label>
                    <input id='section-name-${identifier}' type='text' value='${section.name}' />
                </div>
                <div class='button-container'>
                    <button onclick="deleteDocumentContent('${identifier}')">Delete</button>
                    <button onclick="moveUpInDocument('${identifier}')">Up</button>
                    <button onclick="moveDownInDocument('${identifier}')">Down</button>
                </div>
            </div>
        `;

        // Existing Content
        html += "<div class='document-section-content'>";
        for (const content of section.content)
            html += generateDocumentEditorContent(content)
        html += "</div>";

        // Add Content Settings
        html += `
            <div class='button-container bottom-buttons'>
                <button id='btn-add-document-header-${identifier}' onclick="addDocumentHeader('${identifier}')">Add Header</button>
                <button id='btn-add-document-text-${identifier}' onclick="addDocumentText('${identifier}')">Add Text</button>
                <button id='btn-add-document-element-${identifier}' onclick="addDocumentElement('${identifier}')">Add Element Description</button>
                <button id='btn-add-document-skeletal-${identifier}' onclick="addDocumentSkeletal('${identifier}')">Add Skeletal Element List</button>
            </div>
        `;

        html += "</div>";
    }

    // Add Section Settings
    html += `
        <div class='document-content'>
            <div class='input-container'>
                <label for='add-section-name'>New Section Name:</label>
                <input id='add-section-name' class='flex-grow' type='text' />
            </div>
            <div class='button-container'>
                <button id='add-section' onclick="addDocumentSection()">Add Section</button>
            </div>
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
        case "skeletal":
            html += generateDocumentEditorSkeletalContent(item);
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
    const element = hierarchy.filter(i => i.hierarchyName == item.content)[0];
    const inputValue = element ? element.hierarchyName : "";
    const identifier = newGuid();
    const descendantOptions = ["None", "Division", "Macrogroup", "Group"];
    const descendantOptionsHtml = createOptions(descendantOptions, item.descendantLimitType);
    const isHeaderChecked = item.isHeader ? "checked" : "";
    const headerTag = item.headerTag ?? "";

    let html = `
        <div id='document-content-${identifier}' class='document-content document-element'>
            <div class='input-container' style='flex-wrap: wrap;'>
                <label for='element-source-${identifier}'>Root Element:</label>
                <input id='element-source-${identifier}' type='text' list='full-hierarchy-list' value='${inputValue}'/>
                <label for='element-descendants-type-${identifier}'>Include Descendants of Type:</label>
                <select id='element-descendants-type-${identifier}'>
                    ${descendantOptionsHtml}
                </select>
                <label for='element-as-header-${identifier}'>Make Root Into Header:</label>
                <input id='element-as-header-${identifier}' type='checkbox'  ${isHeaderChecked} />
                <label for='element-header-tag-${identifier}'>Root Header Tag:</label>
                <input id='element-header-tag-${identifier} type='text' value='${headerTag}' />
            </div>
            <div class='button-container'>
                <button onclick="deleteDocumentContent('${identifier}')">Delete</button>
                <button onclick="moveUpInDocument('${identifier}')">Up</button>
                <button onclick="moveDownInDocument('${identifier}')">Down</button>
            </div>
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
        <div id='document-content-${identifier}'  class='document-content document-header'>
            <div class='input-container'>
                <label for='header-content-${identifier}'>Header Content:</label>
                <input id='header-content-${identifier}' type="text" value='${item.content}'/>
                <label for='header-level-${identifier}'>Header Level:</label>
                <select id='header-level-${identifier}'>
                    ${levelOptions}
                </select>
            </div>
            <div class='button-container'>
                <button onclick="deleteDocumentContent('${identifier}')">Delete</button>
                <button onclick="moveUpInDocument('${identifier}')">Up</button>
                <button onclick="moveDownInDocument('${identifier}')">Down</button>
            </div>
        </div>
    `;
    
    return html;
}

function generateDocumentEditorSkeletalContent(item) {
    const identifier = newGuid();
    const checked = item.content ? "checked" : "";
    
    let html = `
        <div id='document-content-${identifier}' class='document-content document-skeletal'>
            <div class='input-container'>
                <label for='skeletal-content-${identifier}'>Enable Skeletal List for Section Elements:</label>
                <input id='skeletal-content-${identifier}' type="checkbox" ${checked} />
            </div>
            <div class='button-container'>
                <button onclick="deleteDocumentContent('${identifier}')">Delete</button>
                <button onclick="moveUpInDocument('${identifier}')">Up</button>
                <button onclick="moveDownInDocument('${identifier}')">Down</button>
            </div>
        </div>
    `;

    return html;
}

function generateDocumentEditorTextContent(item) {
    const identifier = newGuid();
    const joinedContent = item.content.join("\r\n");

    let html = `
        <div id='document-content-${identifier}' class='document-content document-text'>
            <div class='input-container'>
                <label for='text-content-${identifier}'>Text Content:</label>
                <textarea id='text-content-${identifier}'>${joinedContent}</textarea>
            </div>
            <div class='button-container'>
                <button onclick="deleteDocumentContent('${identifier}')">Delete</button>
                <button onclick="moveUpInDocument('${identifier}')">Up</button>
                <button onclick="moveDownInDocument('${identifier}')">Down</button>
            </div>
        </div>
    `;
    
    return html;
}

function generateDocument() {
    let html = generateDocumentTableOfContents();
    
    for (const section of documentStructure.sections)
        html += generateDocumentSection(section);

    const documentContainer = document.getElementById("document-container");
    documentContainer.innerHTML = html;
}

function generateDocumentTableOfContents() {
    let html = "";

    html += `
        <div class='document-toc'>
            <h1>TABLE OF CONTENTS</h1>
            <ul style='padding: 0'>
    `;

    let sectionHeaders = [];
    for (const section of documentStructure.sections) 
        sectionHeaders = [...sectionHeaders, ...section.content.filter(i => i.type == "header")];

    for (const sectionHeader of sectionHeaders) {
        const padding = `padding-left: ${sectionHeader.level * 10}px;`
        html += `
            <li class='skeletal-container' style="${padding}">
                <span>${sectionHeader.content}</span>
                <span class='separator'></span>
                <span>#</span>
            </li>
        `;
    }

    html += `
            </ul>    
        </div>
    `;

    return html;
}

function generateDocumentSection(section) {
    let html = "";

    for (const content of section.content) {
        switch (content.type) {
            case "element":
                html += generateDocumentElement(content);
                break;
            case "header":
                html += generateDocumentHeader(content);
                break;
            case "skeletal":
                html += generateDocumentSkeletal(content, section.content);
                break;
            case "text":
                html += generateDocumentText(content);
                break;
            default:
                throw new Error("Invalid type provided", content.type);
        }
    }

    return html;
}

function generateDocumentElement(content) {
    const element = hierarchy.filter(i => i.hierarchyName == content.content)[0];
    let html = generateDocumentDescriptionByElement(element, content.descendantLimitType, content.isHeader, content.headerTag);
    return html;
}

function generateDocumentDescriptionByElement(element, descendantLimitType, isHeader, headerTag) {

    let html = "";
    if (isHeader) {
        html += `
            <h3>
                ${headerTag}. ${element.hierarchyName}
            </h3>
            <div class='element-child-container'>
        `;
    }
    else {
        let descriptionList = [];
        for (const description of element.node.description) {
            if (description.startsWith("###"))
                break;
            const adjustedDescription = duplicateLeadingSpaces(description, 2);
            descriptionList.push(adjustedDescription);
        }
        const fullDescription = descriptionList.join("</br>");
        const elementButton = `<button data-hierarchy-name='${element.hierarchyName}' class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'><b>${element.hierarchyName}</b></button>`;
    
        const tagHtml = headerTag != "" ? `<b>${headerTag}</b>` : "";
        html += `
            <div class='element-container'>
                ${tagHtml}
                <p>${fullDescription} ... ${elementButton}</p>
            </div>
        `;
    }
    
    let childTagCounter = 1;
    const designatedTypes = getEligibleTypesByLimit(descendantLimitType);
    for (const child of element.children) {
        if (!designatedTypes.includes(child.node.level))
            continue;
        const childHeaderTag = headerTag != "" ? `${headerTag}.${childTagCounter}` : "";
        html += generateDocumentDescriptionByElement(child, descendantLimitType, false, childHeaderTag);
        childTagCounter++;
    }

    if (isHeader)
        html += "</div>";

    return html;
}

function duplicateLeadingSpaces(text, times = 2) {
    const regex = /^(\s+)/g;
    let replaceRegex = "";
    for (let i = 0; i < times; i++)
        replaceRegex += "$1";
    const replace = text.replace(regex, replaceRegex)
    return replace;
}


function getEligibleTypesByLimit(type) {
    let designatedChildTypes = ["class", "subclass", "formation"];
    if (type == "Division")
        designatedChildTypes.push(...["division"]);
    else if (type == "Macrogroup")
        designatedChildTypes.push(...["division", "macrogroup"]);
    else if (type == "Group")
        designatedChildTypes.push(...["division", "macrogroup", "group"]);
    else
        return [];

    return designatedChildTypes;
}

function getElementsByContent(content) {
    const element = hierarchy.filter(i => i.hierarchyName == content.content)[0];
    let elements = [ element ];
    if (content.descendantLimitType == "None")
        return elements;

    let designatedChildTypes = getEligibleTypesByLimit(content.type);

    for (const child of element.children)
        elements = getDescendantElementsByType(elements, child, designatedChildTypes);

    return elements;
}

function generateDocumentHeader(content) {
    const headerText = content.content;
    const headerLevel = content.level;

    let html = `
        <h${headerLevel}>
            ${headerText}
        </h${headerLevel}>
    `;

    return html
}

function generateDocumentSkeletal(content, sectionContent) {
    if (!content.content)
        return "";

    let html = "<ul class='skeletal-list-root'>";

    for (const item of sectionContent.filter(i => i.type == "element")) {
        const element = hierarchy.filter(i => i.hierarchyName == item.content)[0];
        html += generateDocumentNamesForElement(element, item.descendantLimitType, item.headerTag);
    }

    html += "</ul>";

    return html;
}

function generateDocumentNamesForElement(element, descendantLimitType, headerTag) {
    const padding = `padding-left: ${element.hierarchyLevel * 10}px;`
    const mainHeaderTag = headerTag != "" ? `${headerTag}.` : "";
    let html = `
        <li class='skeletal-container' style='${padding}'>
            <span>${mainHeaderTag} ${element.hierarchyName}</span>
            <span class='separator'></span>
            <span>#</span>
        </li>
    `;

    if (element.children.length > 0) {
        let childTagCounter = 1;
        const designatedTypes = getEligibleTypesByLimit(descendantLimitType);
        for (const child of element.children) {
            if (!designatedTypes.includes(child.node.level))
                continue;
            const childHeaderTag = headerTag != "" ? `${headerTag}.${childTagCounter}` : "";
            html += generateDocumentNamesForElement(child, descendantLimitType, childHeaderTag);
            childTagCounter++;
        }
    }

    return html;
}

function generateDocumentText(content) {
    const text = content.content;

    let html = `
        <p>
            ${text}
        </p>
    `;

    return html
}

function getDocumentHeaderTagForElement(element) {
    const hierarchyLevel = element.hierarchyLevel;
    const headerLevel = Math.min(hierarchyLevel + 1, 6);
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

function addDocumentSkeletal(identifier) {
    recordUnsavedChanges();

    const targetSection = findDocumentSectionFromIdentifier(unsavedDocumentStructure, identifier);
    targetSection.content.push({
        type: "skeletal",
        content: true
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
        content: null,
        descendantLimitType: null,
        isHeader: false,
        headerTag: null
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
        const sectionContentContainers = sectionContainer.querySelectorAll(".document-section-content .document-content");
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
            else if (contentContainer.classList.contains("document-skeletal")) {
                const checkedContent = contentContainer.querySelector("input[type='checkbox']").checked;
                sectionContent.push({
                    type: "skeletal",
                    content: checkedContent
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
                const elementName = contentContainer.querySelector("[id^='element-source']").value;
                const descendantLimit = contentContainer.querySelector("[id^='element-descendants-type']").value;
                const isHeader = contentContainer.querySelector("[id^='element-as-header']").checked;
                const headerTag = contentContainer.querySelector("[id^='element-header-tag']").value;

                sectionContent.push({
                    type: "element",
                    content: elementName,
                    descendantLimitType: descendantLimit,
                    isHeader: isHeader,
                    headerTag: headerTag
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

function moveUpInDocument(identifier) {
    moveInDocument(identifier, true);
}

function moveDownInDocument(identifier) {
    moveInDocument(identifier, false);
}

function moveInDocument(identifier, moveUp) {
    recordUnsavedChanges();

    const documentContent = document.getElementById(`document-content-${identifier}`);
    const documentInput = documentContent.querySelector("input,select,textarea");
    const replacementIndexIncrement = moveUp ? -1 : 1;

    if (documentInput.id.startsWith("section-name")) {
        const sectionName = documentInput.value;
        const section = unsavedDocumentStructure.sections.filter(i => i.name == sectionName)[0];
        const sectionIndex = unsavedDocumentStructure.sections.indexOf(section);
        const cutOff = moveUp ? 0 : unsavedDocumentStructure.sections.length - 1;
        if (sectionIndex == cutOff)
            return;

        unsavedDocumentStructure.sections[sectionIndex] = unsavedDocumentStructure.sections[sectionIndex + replacementIndexIncrement];
        unsavedDocumentStructure.sections[sectionIndex + replacementIndexIncrement] = section;
    }
    else {
        const contentValue = documentInput.type == "checkbox" ? documentInput.checked : documentInput.value;
        const contentType = documentInput.id.split("-")[0];
        const sectionContainer = documentContent.closest(".document-section");
        const sectionName = sectionContainer.querySelector("[id^='section-name']").value;
        const section = unsavedDocumentStructure.sections.filter(i => i.name == sectionName)[0];
        const content = section.content.filter(
            i => i.type == contentType && 
            contentType == "text" ? 
            i.content.join("\n") == contentValue : 
            i.content == contentValue
        )[0];
        const contentIndex = section.content.indexOf(content);
        const cutOff = moveUp ? 0 : section.content.length - 1;
        if (contentIndex == cutOff)
            return;

        section.content[contentIndex] = section.content[contentIndex + replacementIndexIncrement];
        section.content[contentIndex + replacementIndexIncrement] = content;
    }

    populateDocumentDialog();
}

function deleteDocumentContent(identifier) {
    recordUnsavedChanges();

    const documentContent = document.getElementById(`document-content-${identifier}`);
    const documentInput = documentContent.querySelector("input,select,textarea");

    if (documentInput.id.startsWith("section-name")) {
        const sectionName = documentInput.value;
        const section = unsavedDocumentStructure.sections.filter(i => i.name == sectionName)[0];
        unsavedDocumentStructure.sections = unsavedDocumentStructure.sections.filter(i => i != section);
    }
    else {
        const contentValue = documentInput.type == "checkbox" ? documentInput.checked : documentInput.value;
        const contentType = documentInput.id.split("-")[0];
        const sectionContainer = documentContent.closest(".document-section");
        const sectionName = sectionContainer.querySelector("[id^='section-name']").value;
        const section = unsavedDocumentStructure.sections.filter(i => i.name == sectionName)[0];
        const content = section.content.filter(
            i => i.type == contentType && 
            contentType == "text" ? 
            i.content.join("\n") == contentValue : 
            i.content == contentValue
        )[0];
        section.content = section.content.filter(i => i != content);
    }

    populateDocumentDialog();
}

async function saveDocumentChanges() {
    const confirmSaveMessage = "Are you sure you wanted to save these changes?";
    if (!await confirm(confirmSaveMessage))
        return;

    recordUnsavedChanges();
    documentStructure = unsavedDocumentStructure;
    stateChecker.modified = true;
    
    generateDocument();
    document.getElementById("document-dialog").close();
}