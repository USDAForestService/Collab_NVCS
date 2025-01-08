function toggleDocumentForm() {
    const documentForm = document.getElementById("document-form");
    if (documentForm.hidden)
        showDocumentForm();
    else
        hideDocumentForm();
}

function showDocumentForm() {
    // Hide JSON tree & alerts
    hideContentById("alerts");
    hideContentById("detected-json-container");

    // Generate document
    generateDocument();
    generateDocumentComputed();

    // Show document container
    showContentById("document-form");
}

function hideDocumentForm() {
    // Hide document container
    hideContentById("document-form");

    // Show JSON tree & alerts
    showContentById("alerts");
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

function generateDocumentComputed() {
    let html = "<ul>";
    let rootElementChildren = hierarchy.filter(i => i.hierarchyName == "ROOT")[0].children;
    for (const child of rootElementChildren)
        html += generateDocumentListEntryComputed(child);
    html += "</ul>"

    const documentContainer = document.getElementById("document-container-computed");
    documentContainer.innerHTML = html;
}

function generateDocumentListEntry(element) {
    let returnString = "<li>";
    returnString += "<p style='white-space: pre-wrap;'>";
    let descriptionList = [...element.node.description];
    const leadingSpaceReplace = "    ";
    for (let i = 0; i < descriptionList.length; i++) {
        descriptionList[i] = descriptionList[i].replace(/^(\s||\\t)+/, function(i) { return i.replace(/\s/g, leadingSpaceReplace); });
    }
    let fullDescription = descriptionList.join("</br>");
    returnString += fullDescription;
    returnString += ` ... <b>${element.hierarchyName}</b>`;
    returnString += "</p>";
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateDocumentListEntry(child);
    returnString += "</ul>";
    returnString += "</li>";
    return returnString;
}

function generateDocumentListEntryComputed(element) {
    let returnString = "<li>";
    returnString += "<p style='white-space: pre-wrap;'>";
    returnString += generateDescriptionForElement(element);
    returnString += ` ... <b>${element.hierarchyName}</b>`;
    returnString += "</p>";
    returnString += "<ul>";
    for (let child of element.children)
        returnString += generateDocumentListEntryComputed(child);
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

function generateDescriptionForElement(element) {
    let partDescriptions = [];
    let joinedTrigger = element.node.trigger.join(" ");
    let parts = joinedTrigger.split(/( and | or )/g);
    console.log(parts)
    for (const part of parts) {
        const rivPattern = part.match(/riv\(([^)]*)\)/g) ?? [];
        for (const riv of rivPattern) {
            const filterName = riv.replace("riv(", "").replace(")", "");
            const filter = element.node.filters[filterName];
            const filterValues = filter.map(i => i.species);
            filterValues[filterValues.length - 1] = "or " + filterValues[filterValues.length - 1];
            
            let rivComparison = part.replace(riv, "").trim();
            rivComparison = ` (${rivComparison}% RIV)`;

            let partDescription = "Tree composition is dominated by one or more of " + filterValues.join(", ") + rivComparison;
            console.log(partDescription);
            partDescriptions.push(partDescription);
        }

        const matchPattern = part.match(/match\(([^)]*)\)/g) ?? [];
        for (const match of matchPattern) {
            const filterName = match.replace("match(", "").replace(")", "");
            const filter = element.node.filters[filterName];
            const filterValues = filter.map(i => i.ecoregion);

            let partDescription = "Forests found in ECOREGION " + filterValues.join(", ");
            console.log(partDescription);
            partDescriptions.push(partDescription);
        }

        const joinStatementPattern = part.match(/and|or/g) ?? [];
        for (const joinStatement of joinStatementPattern) {
            const partDescription = joinStatement.trim().toUpperCase();
            console.log(partDescription);
            partDescriptions.push(partDescription);
        }
    }
    let description = partDescriptions.join(" ");
    return description;
}