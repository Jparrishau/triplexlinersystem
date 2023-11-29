
window.addEventListener("load", function() {
    if (window.location.href.indexOf("success=true") > -1) {
        createSuccessNavigation();
    }
});

function createSuccessNavigation() {
    let successNavigation = document.createElement("div");
    successNavigation.id = "success-navigation";
    successNavigation.classList.add("navigation-container");

    let navigationContainer = document.createElement("div");
    navigationContainer.classList.add("container")
    let navigationRow = document.createElement("div");
    navigationRow.classList.add("row");

    let navigationSpan = document.createElement("span");
    navigationSpan.classList.add("navigation-message");
    navigationSpan.innerText = "Your pattern has been successfully submitted!";

    let navigationButton = document.createElement("button");
    navigationButton.classList.add("navigation-button");
    navigationButton.type = "button";
    navigationButton.innerText = "Close";

    navigationRow.appendChild(navigationSpan);
    navigationRow.appendChild(navigationButton);
    navigationContainer.appendChild(navigationRow);
    successNavigation.appendChild(navigationContainer);
    document.body.appendChild(successNavigation);

   /* setTimeout(function() {
        successNavigation.remove();
    }, 5000);*/
    navigationButton.addEventListener("click", () => {
        successNavigation.remove();
    });
}