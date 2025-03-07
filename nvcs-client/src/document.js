let unsavedDocumentDialogChanges = false;
let headerTags = new Map();
let nullCharacter = "∅";

document.getElementById("document-dialog").addEventListener("close", async (event) => {
    if (unsavedDocumentDialogChanges) {
        const message = "You may have unsaved changes made to this document. Are you sure you want to discard these changes by exiting the dialog without saving?";
        if (!await confirm(message)) {
            const dialog = document.getElementById("document-dialog");
            showDialog(dialog);
            return;
        }
        unsavedDocumentDialogChanges = false;
    }
});

document.getElementById("document-dialog").addEventListener("input", (event) => {
    unsavedDocumentDialogChanges = true;
    // Only perform validations on saveable input and textarea fields
    if (!(event.target instanceof HTMLInputElement || event.target instanceof HTMLTextAreaElement)) 
        return;
    if (event.target.classList.contains("skip-validation")) 
        return;
    performDocumentDialogValidations(false);
});

function toggleDocumentForm() {
    const documentToggleButton = document.getElementById("btn-show-document");
    const documentWordButton = document.getElementById("btn-document-word");
    if (isDocumentViewHidden()) {
        showDocumentForm();
        documentToggleButton.innerText = "Hide Document View";
        documentWordButton.disabled = false;
    }
    else {
        hideDocumentForm();
        documentToggleButton.innerText = "Show Document View";
        documentWordButton.disabled = true;
    }
}

function showDocumentForm() {
    // Hide JSON tree
    hideContentById("detected-json-container");

    // Show document container
    showContentById("document-form");
}

function hideDocumentForm() {
    // Hide document container
    hideContentById("document-form");

    // Show JSON tree
    showContentById("detected-json-container");
}

function openDocumentDialog(sectionName = null, index = null) {
    unsavedDocumentStructure = documentStructure;
    populateDocumentDialog();
    const dialog = document.getElementById("document-dialog");
    showDialog(dialog);

    // If provided, focus specific elements within the dialog
    if (sectionName && index) {
        const section = document.querySelector(`[data-section="${sectionName}"]`);
        const content = section.querySelector(`[data-index="${index}"]`);
        const contentInput = content.querySelector(`input, textarea, select`);
        contentInput.focus();
    }
    else if (sectionName) {
        const section = document.querySelector(`[data-section="${sectionName}"]`);
        const sectionInput = section.querySelector(`[id^="section-name-"]`);
        sectionInput.focus();
    }
}

function populateDocumentDialog() {
    const dialog = document.getElementById("document-dialog");
    let html = "";

    if (unsavedDocumentStructure.sections.length == 0) {
        html += `
            <p>
                Your document is currently empty. Please begin by adding new sections from scratch or
                by clicking the "Reset All" button below to load in a prepackaged document template.
            </p>
        `;
    }

    for (const section of unsavedDocumentStructure.sections) {
        // New section prep
        const identifier = newGuid();
        html += `<div id='${identifier}' class='document-section' data-section="${section.name}">`;

        // Section Name
        html += `
            <div id='document-content-${identifier}' class='document-content'>
                <div class='input-container'>
                    <label for='section-name-${identifier}'>Section Name:</label>
                    <input id='section-name-${identifier}' type='text' value='${section.name}' />
                </div>
                <div class='button-container'>
                    <button onclick="deleteDocumentContent('${identifier}', true)">Delete</button>
                    <button onclick="moveUpInDocument('${identifier}')">Up</button>
                    <button onclick="moveDownInDocument('${identifier}')">Down</button>
                </div>
            </div>
        `;

        // Existing Content
        html += "<div class='document-section-content'>";
        for (let i = 0; i < section.content.length; i++) {
            const content = section.content[i];
            html += generateDocumentEditorContent(content, i)
        }
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

    // Perform dialog validations
    performDocumentDialogValidations();
}

function generateDocumentEditorContent(item, index) {
    let html = "";

    switch (item.type) {
        case "element":
            html += generateDocumentEditorElementContent(item, index);
            break;
        case "header":
            html += generateDocumenEditortHeaderContent(item, index);
            break;
        case "skeletal":
            html += generateDocumentEditorSkeletalContent(item, index);
            break;
        case "text":
            html += generateDocumentEditorTextContent(item, index);
            break;
        default:
            throw new Error("Invalid type provided", item.type);
    }

    return html;
}

function generateDocumentEditorElementContent(item, index) {
    const inputValue = item.content;
    const identifier = newGuid();
    const descendantOptions = ["None", "Division", "Macrogroup", "Group"];
    const descendantOptionsHtml = createOptions(descendantOptions, item.descendantLimitType);
    const isHeaderChecked = item.isHeader ? "checked" : "";
    const headerTag = item.headerTag ?? "";

    let html = `
        <div id='document-content-${identifier}' class='document-content document-element' data-index="${index}">
            <div class="document-element-input-container">
                <div class='input-container'>
                    <label for='element-source-${identifier}'>Root Element:</label>
                    <input id='element-source-${identifier}' type='text' list='full-hierarchy-list' value='${inputValue}'/>
                    <label for='element-header-tag-${identifier}'>Root Header Tag:</label>
                    <input id='element-header-tag-${identifier} type='text' value='${headerTag}' />
                </div>
                <div class='input-container'>
                    <label for='element-descendants-type-${identifier}'>Include Descendant Elements of Type:</label>
                    <select id='element-descendants-type-${identifier}'>
                        ${descendantOptionsHtml}
                    </select>
                    <label for='element-as-header-${identifier}'>Display Root Element Name As Header:</label>
                    <input id='element-as-header-${identifier}' type='checkbox'  ${isHeaderChecked} />
                </div>
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

function generateDocumenEditortHeaderContent(item, index) {
    const identifier = newGuid();
    let levelOptions = "";
    for (let i = 1; i <= 6; i++) {
        const selected = item.level == i ? "selected" : "";
        levelOptions += `<option value="${i}" ${selected}>${i}</option>`;
    }

    let html = `
        <div id='document-content-${identifier}' class='document-content document-header' data-index="${index}">
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

function generateDocumentEditorSkeletalContent(item, index) {
    const identifier = newGuid();
    const checked = item.content ? "checked" : "";
    
    let html = `
        <div id='document-content-${identifier}' class='document-content document-skeletal' data-index="${index}">
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

function generateDocumentEditorTextContent(item, index) {
    const identifier = newGuid();
    const joinedContent = item.content.join("\r\n");

    let html = `
        <div id='document-content-${identifier}' class='document-content document-text' data-index="${index}">
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

    headerTags = new Map();
    for (const section of documentStructure.sections)
        headerTags = getHeaderTagsForElements(section.content);
    console.log(headerTags);
    
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
                <span>${nullCharacter}</span>
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
    let html = `
        <div id="${section.name}" class="document-section-container">
    `;

    for (let i = 0; i < section.content.length; i++) {
        const content = section.content[i];
        switch (content.type) {
            case "element":
                html += generateDocumentElement(content, i, section.name);
                break;
            case "header":
                html += generateDocumentHeader(content, i, section.name);
                break;
            case "skeletal":
                html += generateDocumentSkeletal(content, section.content, i, section.name);
                break;
            case "text":
                html += generateDocumentText(content, i, section.name);
                break;
            default:
                throw new Error("Invalid type provided", content.type);
        }
    }

    html += `
        </div>
    `;

    return html;
}

function generateDocumentEditButton(sectionName, contentIndex) {
    let html = `
        <button class='document-content-edit-btn' onclick="openDocumentDialog('${sectionName}', ${contentIndex})">Edit</button>
    `;
    return html;
} 

function generateDocumentElement(content, index, sectionName) {
    let html = "";
    const element = hierarchy.filter(i => i.hierarchyName == content.content)[0];
    if (!element) {
        console.error("Unable to find a hierarchy element for the given content name:", content.content);
        return html;
    }

    html += `
        <div class="document-element-container document-content-edit-container" data-index="${index}">
    `;

    html += generateDocumentEditButton(sectionName, index);
    html += generateDocumentDescriptionByElement(element, content.descendantLimitType, content.isHeader, content.isHeader, content.headerTag);

    html += `
        </div>
    `;

    return html;
}

function generateDocumentDescriptionByElement(element, descendantLimitType, isHeader, needsTitle, headerTag) {

    let html = "";
    if (needsTitle) {
        const titleTag = getHeaderTagsByName(element.hierarchyName) ?? nullCharacter;
        html += `
            <h3>${titleTag}. ${element.hierarchyName}</h3>
            <table class='element-child-container outlined'>
            <tbody>
        `;
    }
    else {
        if (!isHeader) {
            html += `
            <table class='element-child-container outlined'>
            <tbody>
        `;
        }
        html += addDocumentElementMainContent(element);
    }

    html += addDocumentElementChildrenContent(element, descendantLimitType, isHeader, headerTag);

    if (!isHeader || needsTitle)
        html += "</tbody></table>";

    return html;
}

function addDocumentElementMainContent(element) {
    let html = "";

    let descriptionList = [];
    for (const description of element.node.description) {
        if (description.startsWith("###"))
            break;
        const adjustedDescription = duplicateLeadingSpaces(description, 2);
        descriptionList.push(adjustedDescription);
    }
    const fullDescription = descriptionList.join("</br>");
    const elementButton = `<b><button data-hierarchy-name='${element.hierarchyName}' class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'>${element.hierarchyName}</button></b>`;
    const displayHeaderTag = getHeaderTagsByName(element.hierarchyName) ?? nullCharacter;

    html += `
        <tr>
            <td class='element-tag-cell'><b>${displayHeaderTag}</b></td>
            <td class='element-content-cell'><p>${fullDescription} ... ${elementButton}</p></td>
            <td class='element-tag-cell'></td>
        </tr>
    `;

    return html;
}

function addDocumentElementChildrenContent(element, descendantLimitType, isHeader, headerTag) {
    let html = "";
    let childTagCounter = 1;
    const designatedTypes = getEligibleTypesByLimit(descendantLimitType);
    for (const child of element.children) {
        if (!designatedTypes.includes(child.node.level))
            continue;

        let childHeaderTag = "";
        if (headerTag)
            childHeaderTag = isHeader ? `${headerTag}.${childTagCounter}` : getNextAlphabetLetter(headerTag);

        html += generateDocumentDescriptionByElement(child, descendantLimitType, isHeader, false, childHeaderTag);
        if (isHeader && childTagCounter <= element.children.length - 1) {
            let nextChildHeaderTag = headerTag ? `${headerTag}.${childTagCounter + 1}` : nullCharacter;

            html += `
                <tr>
                    <td class='element-tag-cell'><b>${childHeaderTag}</b></td>
                    <td class='element-content-cell'><p>Tree composition not as above...</p></td>
                    <td class='element-tag-cell'><b>${nextChildHeaderTag}</b></td>
                </tr>
            `;
        }
        childTagCounter++;
    }
    return html;
}

function getNextAlphabetLetter(letter, capitalize = true) {
    const lowered = letter.toLowerCase();
    if (lowered == "z")
        return "a";

    const nextCharCode = lowered.charCodeAt(0) + 1;
    let nextLetter = String.fromCharCode(nextCharCode);
    if (capitalize)
        nextLetter = nextLetter.toUpperCase();
    return nextLetter;

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
    let elements = [];
    const element = hierarchy.filter(i => i.hierarchyName == content.content)[0];
    if (!element) {
        console.error("Unable to find a hierarchy element for the given content name:", content.content);
        return elements;
    }

    elements.push(element);
    if (content.descendantLimitType == "None")
        return elements;

    let designatedChildTypes = getEligibleTypesByLimit(content.descendantLimitType);

    for (const child of element.children)
        elements = getDescendantElementsByType(elements, child, designatedChildTypes);

    return elements;
}

function generateDocumentHeader(content, index, sectionName) {
    const headerText = content.content;
    const headerLevel = content.level;
    const editButton = generateDocumentEditButton(sectionName, index);

    let html = `
        <div class="document-header-container document-content-edit-container" data-index="${index}">
            ${editButton}
            <h${headerLevel}>${headerText}</h${headerLevel}>
        </div>
    `;

    return html
}

function getHeaderTagsByName(name) {
    const entry = headerTags.get(name);
    const response = entry != "" ? entry : null;
    return response; 
}


function getHeaderTagsForElements(sectionContent) {
    const allSectionElements = sectionContent.filter(i => i.type == "element");
    for (const sectionElement of allSectionElements) {
        const hierarchyElement = hierarchy.filter(i => i.hierarchyName == sectionElement.content)[0];
        if (!hierarchyElement) {
            console.error("Unable to find a hierarchy element for the given content name:", sectionContent.content);
            continue;
        }
        getHeaderTagsForElement(hierarchyElement, sectionElement.headerTag);
    }
    return headerTags;
}

function getHeaderTagsForElement(hierarchyElement, headerTag) {
    if (!getHeaderTagsByName(hierarchyElement.hierarchyName))
        headerTags.set(hierarchyElement.hierarchyName, headerTag);

    for (let i = 0; i < hierarchyElement.children.length; i++) {
        const childHierarchyElement = hierarchyElement.children[i];
        const childHeaderTag = headerTag ? `${headerTag}.${i + 1}` : null;
        getHeaderTagsForElement(childHierarchyElement, childHeaderTag);
    }
}

function generateDocumentSkeletal(content, sectionContent, index, sectionName) {
    if (!content.content)
        return "";

    const editButton = generateDocumentEditButton(sectionName, index);
    let html = `
        <div class="document-skeletal-container document-content-edit-container" data-index="${index}">
            ${editButton}
            <ul class='skeletal-list-root'>
    `;

    for (const item of sectionContent.filter(i => i.type == "element")) {
        const element = hierarchy.filter(i => i.hierarchyName == item.content)[0];
        if (!element) {
            console.error("Unable to find a hierarchy element for the given content name:", item.content);
            continue;
        }

        html += generateDocumentNamesForElement(element, item.descendantLimitType, item.headerTag);
    }

    html += `
            </ul>
        </div>
    `;

    return html;
}

function generateDocumentNamesForElement(element, descendantLimitType, headerTag) {
    const padding = `padding-left: ${element.hierarchyLevel * 10}px;`
    const mainHeaderTag = getHeaderTagsByName(element.hierarchyName) ?? nullCharacter;
    let html = `
        <li class='skeletal-container' style='${padding}'>
            <span>${mainHeaderTag}. ${element.hierarchyName}</span>
            <span class='separator'></span>
            <span>${nullCharacter}</span>
        </li>
    `;

    if (element.children.length > 0) {
        let childTagCounter = 1;
        const designatedTypes = getEligibleTypesByLimit(descendantLimitType);
        for (const child of element.children) {
            if (!designatedTypes.includes(child.node.level))
                continue;
            const childHeaderTag = headerTag ? `${headerTag}.${childTagCounter}` : null;
            html += generateDocumentNamesForElement(child, descendantLimitType, childHeaderTag);
            childTagCounter++;
        }
    }

    return html;
}

function generateDocumentText(content, index, sectionName) {
    const text = content.content.map(i => i.trim()).join("\n");
    const editButton = generateDocumentEditButton(sectionName, index);

    let html = `
        <div class="document-text-container document-content-edit-container" data-index="${index}">
            ${editButton}
            <p>${text}</p>
        </div>
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
    unsavedDocumentDialogChanges = true;
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
    unsavedDocumentDialogChanges = true;
}

function addDocumentSkeletal(identifier) {
    recordUnsavedChanges();

    const targetSection = findDocumentSectionFromIdentifier(unsavedDocumentStructure, identifier);
    targetSection.content.push({
        type: "skeletal",
        content: true
    });

    populateDocumentDialog();
    unsavedDocumentDialogChanges = true;
}

function addDocumentText(identifier) {
    recordUnsavedChanges();

    const targetSection = findDocumentSectionFromIdentifier(unsavedDocumentStructure, identifier);
    targetSection.content.push({
        type: "text",
        content: []
    });

    populateDocumentDialog();
    unsavedDocumentDialogChanges = true;
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
    unsavedDocumentDialogChanges = true;
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
    unsavedDocumentDialogChanges = true;
}

async function deleteDocumentContent(identifier, confirmation = false) {
    const message = "Are you sure you want to delete this element?";
    if (confirmation && !await confirm(message))
        return;
    
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
    unsavedDocumentDialogChanges = true;
}

async function saveDocumentChanges() {
    const confirmSaveMessage = "Are you sure you wanted to save these changes?";
    if (!await confirm(confirmSaveMessage))
        return;

    recordUnsavedChanges();
    documentStructure = unsavedDocumentStructure;
    stateChecker.modified = true;
    unsavedDocumentDialogChanges = false;
    
    generatePages(hierarchy);
    document.getElementById("document-dialog").close();
}

async function resetDocumentChanges() {
    const confirmSaveMessage = "Are you sure you wanted to reset all document changes to the prepackaged template?";
    if (!await confirm(confirmSaveMessage))
        return;

    documentStructure = await fetchDocumentStructure();
    stateChecker.modified = true;
    unsavedDocumentDialogChanges = false;

    openDocumentDialog();
    generatePages(hierarchy);
}

function isDocumentViewHidden() {
    const documentForm = document.getElementById("document-form");
    return documentForm.hidden || documentForm.classList.contains("hidden"); 
}

async function saveDocumentWordFormat() {
    try {
        const inputPath = document.getElementById("json-directory-path");
        const browsePath = await openSaveDocumentDialog(inputPath.value);
        if (!browsePath) return;

        const updateWarning = "Are you sure you want to save the Word document to this path? " +
            "Any previously saved word documents at this path will be overwritten.";
        if (!await confirm(updateWarning))
            return;

        let documentHtml = document.getElementById("document-container").innerHTML;
        documentHtml = prepareDocumentHtmlForString(documentHtml);
        const response = await electronAPI.saveDocumentWordFormat(browsePath, documentHtml);
        const message = `Successfully saved word document to: ${response}`;
        alert(message);
        return response;
    }
    catch (error) {
        console.error(error);
        alert(error);
        return;
    }
}

function prepareDocumentHtmlForString(htmlString) {
    let cleaned = htmlString;

    // Remove any Edit buttons
    const regex = /<button class="document-content-edit-btn"(.*)<\/button>/g;
    cleaned = cleaned.replaceAll(regex, "");

    // Replace CSS separators with text
    const separator = `<span class="separator"></span>`;
    const separateReplace = `<span> .......... </span>`;
    cleaned = cleaned.replaceAll(separator, separateReplace);

    return cleaned;
}