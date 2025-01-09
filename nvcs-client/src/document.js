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

function generateDocument() {
    let html = "<ul>";
    let rootElementChildren = hierarchy.filter(i => i.hierarchyName == "ROOT")[0].children;
    for (const child of rootElementChildren)
        html += generateDocumentListEntry(child);
    html += "</ul>"

    const documentContainer = document.getElementById("document-container");
    documentContainer.innerHTML = html;
}

function generateDocumentListEntry(element) {
    let returnString = "<li>";
    returnString += "<p style='white-space: pre-wrap;'>";
    let descriptionList = [...element.node.description];
    const leadingSpaceReplace = "    ";
    for (let i = 0; i < descriptionList.length; i++) {
        descriptionList[i] = descriptionList[i].replace(/^(\s|\\t)+/, function(i) { return i.replace(/\s/g, leadingSpaceReplace); });
    }
    let fullDescription = descriptionList.join("</br>");
    returnString += fullDescription;
    returnString += ` ... <button data-hierarchy-name='${element.hierarchyName}' class='hierarchyNodeButton' onclick='openJsonDialog("${element.hierarchyName}")'><b>${element.hierarchyName}</b></button>`;
    returnString += "</p>";
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