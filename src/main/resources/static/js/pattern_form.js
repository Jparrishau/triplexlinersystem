/*
---------------------
     Paging Logic
---------------------
*/
//A function that show's a specific form-page and takes in the page number as a parameter.
function showPage(pageNumber) {
    var pages = document.getElementsByClassName('form-page');
    var currentPage = document.querySelector('.form-page.active-page');
    var currentPageNumber = currentPage.getAttribute('data-page-number');
    if (pageNumber <= pages.length && pageNumber > 0) {
        //Remove the "active-page" class from the current page and add it to the page with the page number passed in.
        currentPage.classList.remove('active-page');
        pages[pageNumber - 1].classList.add('active-page');
        //Save the current page number to the session storage.
        sessionStorage.setItem('currentPageNumber', pageNumber);
        //If we are on the last page then change the "Next" button to "Submit".
        var nextButton = document.getElementById('submit-button');
        if (pageNumber == pages.length) {
            nextButton.innerText = 'Submit';
        }
        else {
            nextButton.innerText = 'Next';
        }
    }
}

//A function that runs when the "Next" button is clicked. It will move the user to the next page.
function nextPage() {
    var pages = document.getElementsByClassName('form-page');
    var currentPage = document.querySelector('.form-page.active-page');
    var currentPageNumber = currentPage.getAttribute('data-page-number');
    var nextPageNumber = parseInt(currentPageNumber) + 1;
    if (nextPageNumber <= pages.length) {
        showPage(nextPageNumber);
    }
    else {
        submitForm();
    }
}

//A function that runs when the "Back" button is clicked. It will move the user to the previous page.
function backPage() {
    var pages = document.getElementsByClassName('form-page');
    var currentPage = document.querySelector('.form-page.active-page');
    var currentPageNumber = currentPage.getAttribute('data-page-number');
    var backPageNumber = parseInt(currentPageNumber) - 1;
    if (backPageNumber > 0) {
        showPage(backPageNumber);
    }
    else {
      window.location.href = '/';
    }
}

//A function that runs when the "See error's" button is clicked.
//It will move the user to the first page that has an error.
function goToFirstError() {
    var invalidInputs = document.querySelectorAll('#pattern-form-main input:invalid');
    if (invalidInputs.length > 0) {
        var firstInvalidInput = invalidInputs[0];
        var firstInvalidInputPage = firstInvalidInput.closest('.form-page');
        var firstInvalidInputPageNumber = firstInvalidInputPage.getAttribute('data-page-number');
        var pages = document.getElementsByClassName('form-page');
        var currentPage = document.querySelector('.form-page.active-page');
        var currentPageNumber = currentPage.getAttribute('data-page-number');
        showPage(firstInvalidInputPageNumber);
    }
}

/*
---------------------
Form Submission Logic
---------------------
*/
function submitForm() {
    //Check if any of the input's are :invalid and if they are then show an error message.
    var invalidInputs = document.querySelectorAll('#pattern-form-main input:invalid');
    if (invalidInputs.length > 0) {
        //Get the form element that was submitted and add the "was-validated" class to it.
        var form = document.getElementById('pattern-form-main');
        form.classList.add('form-validated');
        checkFileUpload();
        //Show an error message.
        showErrorNavigation();
        return;
    }

    //Submit the form.
    var form = document.getElementById('pattern-form-main');
    var formData = new FormData(form);
    var request = new XMLHttpRequest();
    request.open('POST', '/patternform');
    request.send(formData);
    request.onload = function () {
        if (request.status == 200) {
            window.location.href = '/?success=true';
        } else {
            alert('Error: ' + request.status);
        }
    }
    sessionStorage.clear();
}

function showErrorNavigation() {
    let errorNavigation = document.getElementById("error-navigation");
    let navigationContainer = errorNavigation.querySelector(".navigation-container");
    let navigationButton = errorNavigation.querySelector(".navigation-button");

    errorNavigation.style.display = "block";
    setTimeout(function() {
        errorNavigation.style.display = "none"}, 5000);
    navigationButton.addEventListener("click", () => {
        errorNavigation.style.display = "none";
    });
}

/*
---------------------
  Session Data Logic
---------------------
*/
// For each of the input's in the "pattern-form-main" form above.
// Add an event listener that checks for "change event" and then stores the value of the input in the session storage.
document.querySelectorAll('#pattern-form-main input').forEach(function (input) {
    if(input.type != "file") {
        if (input.type == "checkbox") {
            input.addEventListener('change', function () {
                sessionStorage.setItem(input.id, input.checked);
            });
        } else {
            input.addEventListener('change', function () {
                if (input.value != "" && input.value != null) {
                    sessionStorage.setItem(input.id, input.value);
                }
            });
        }
    }
});

// If session data is not empty. Then for each of the input's in the "pattern-form-main" form above.
// Retrieve the value from the session storage and set the value of the input to the value retrieved from the session storage.
document.querySelectorAll('#pattern-form-main input').forEach(function (input) {
    if (input.type != "file" && sessionStorage.getItem(input.id) != null && sessionStorage.getItem(input.id) != "") {
        if (input.type == "checkbox") {
            input.checked = sessionStorage.getItem(input.id) == "true" ? true : false;
        }
        else {
            input.value = sessionStorage.getItem(input.id);
        }
    }
});

// If session data is not empty and contains a "currentPageNumber". Then show the page that is stored in the session storage.
if (sessionStorage.getItem('currentPageNumber') != null && sessionStorage.getItem('currentPageNumber') != "") {
    showPage(sessionStorage.getItem('currentPageNumber'));
}


//

/*
---------------------
   Validation Logic
---------------------
*/
function checkFileUpload() {
    let fileInputs = document.querySelectorAll('input[type="file"]');
    if (fileInputs.length > 0) {
        //For each of the invalid file inputs.
        fileInputs.forEach(function (fileInput) {
            if(fileInput.matches(':invalid')) {
                //Get the file upload container.
                var fileUploadZone = fileInput.closest('.file-upload-zone');
                //If the file upload container is not null. Add the "is-invalid" class to the file upload container.
                if (fileUploadZone != null) {
                    fileUploadZone.classList.add('is-invalid');
                    fileInput.addEventListener('change', function () {
                        checkFileUpload();
                    });
                }
            }
            else {
                //Get the file upload container.
                var fileUploadZone = fileInput.closest('.file-upload-zone');
                //If the file upload container is not null. Remove the "is-invalid" class from the file upload container.
                if (fileUploadZone != null) {
                    fileUploadZone.classList.remove('is-invalid');
                }
            }
        });
    }
}