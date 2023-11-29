class FileUpload {

    constructor(element) {
        this.element = element;
        this.fileUploadLimit = 4;
        this.files = [];
        this.galleryItems = new Map();

        this.fileUploadZone = this.element.querySelector('.file-upload-zone');
        this.fileUploadBrowse = this.element.querySelector('.file-upload-browse');
        this.fileUploadGallery = this.element.querySelector('.file-upload-gallery');
        this.fileUploadInput = this.element.querySelector('.file-upload-input');

        //If any of the above elements are null. Then throw an error.
        if (this.fileUploadZone == null || this.fileUploadBrowse == null ||
         this.fileUploadGallery == null || this.fileUploadInput == null) {
            throw new Error('Error: One or more of the required elements are not present.');
        }
        this.fileUploadInput.addEventListener('change', this.onFileUploadInputChanged.bind(this));
        this.fileUploadZone.addEventListener('click', this.onFileUploadZoneClicked.bind(this));
    }

    //Note: This is called when a file is added or removed.
    onFilesChanged() {
        let files = Array.from(this.files);
        if (files.length > 0) {
            this.showFileUploadGallery();
        } else {
            this.showFileUploadBrowse();
        }
        this.updateFileInput();
    }

    //Note: This is only called when the user adds a file.
    onFileUploadInputChanged() {
        let files = Array.from(this.fileUploadInput.files);
        if (files.length > 0) {
          for(let file of files) {
            if(!this.files.includes(file)) {
              this.addFile(file);
            }
          }
        }
    }

    onFileUploadZoneClicked() {
        this.fileUploadInput.click();
    }

    updateFileInput() {
        let fileList = new DataTransfer();
        for(let file of this.files) {
            fileList.items.add(file);
        }
        this.fileUploadInput.files = fileList.files;
    }

    addGalleryItem(file) {
        let fileUploadGalleryItem = document.createElement('div');
        fileUploadGalleryItem.classList.add('file-upload-gallery-item');

        let fileUploadOriginalImgElement = document.createElement('img');
        fileUploadOriginalImgElement.src = URL.createObjectURL(file);

        //Wait for the image to load before resizing it.
        fileUploadOriginalImgElement.addEventListener("load", function () {
            let fileUploadImage = document.createElement('img');
            fileUploadImage.classList.add('file-upload-img');
            fileUploadImage.src = this.getResizedImgCopy(fileUploadOriginalImgElement, 120, 120);
            fileUploadImage.alt = file.name;

            let fileUploadImgContainer = document.createElement('div');
            fileUploadImgContainer.classList.add('file-upload-img-container');
            fileUploadImgContainer.classList.add('file-upload-clickable');

            fileUploadImgContainer.appendChild(fileUploadImage);
            fileUploadGalleryItem.appendChild(fileUploadImgContainer);
            this.fileUploadGallery.appendChild(fileUploadGalleryItem);
            this.galleryItems.set(file.uuid, fileUploadGalleryItem);

            fileUploadImgContainer.addEventListener('click', this.onFileUploadImgContainerClicked.bind(this, file));
        }.bind(this));
    }

     removeGalleryItem(file) {
            let fileUploadGalleryItem = this.galleryItems.get(file.uuid);
            this.fileUploadGallery.removeChild(fileUploadGalleryItem);
            this.galleryItems.delete(file.uuid);
    }

    onFileUploadImgContainerClicked(file) {
        event.stopPropagation();
        //Show an alert that asks the user if they want to remove the image.
        if (confirm("Are you sure you want to remove this image?")) {
            //Remove the image from the file input element.
            if(this.files.includes(file)) {
                this.removeFile(file);
            }
        }
    }

    getResizedImgCopy(imgElement, newWidth, newHeight) {
        let canvas = document.createElement('canvas');
        let context = canvas.getContext('2d');
        canvas.width = newWidth;
        canvas.height = newHeight;
        context.drawImage(imgElement, 0, 0, newWidth, newHeight);
        return canvas.toDataURL();
    }

    addFile(file) {
        if (this.files.length >= this.fileUploadLimit) {
            alert("You can only upload a maximum of " + this.fileUploadLimit + " images.");
            return;
        }
        file.uuid = this.uuidv4();
        this.files.push(file);
        this.addGalleryItem(file);
        this.onFilesChanged();
    }

    removeFile(file) {
        this.files = this.files.filter(f => f != file);
        this.removeGalleryItem(file);
        this.onFilesChanged();
    }

    getResizedImgCopy(img, newWidth, newHeight) {
        let canvas = document.createElement('canvas');
        canvas.width = newWidth;
        canvas.height = newHeight;
        let ctx = canvas.getContext('2d');
        ctx.drawImage(img, 0, 0, newWidth, newHeight);
        return canvas.toDataURL();
    }

    //A function that show's the fileUploadBrowse div.
    showFileUploadBrowse() {
        let fileUploadBrowse = this.fileUploadZone.querySelector('.file-upload-browse');
        let fileUploadSnackBar = this.fileUploadZone.querySelector('.file-upload-gallery');
        fileUploadBrowse.style.display = "flex";
        fileUploadSnackBar.style.display = "none";
    }

    //A function that show's the fileUploadSnackBar div.
    showFileUploadGallery() {
        let fileUploadBrowse = this.fileUploadZone.querySelector('.file-upload-browse');
        let fileUploadSnackBar = this.fileUploadZone.querySelector('.file-upload-gallery');
        fileUploadBrowse.style.display = "none";
        fileUploadSnackBar.style.display = "flex";
    }

    uuidv4() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            let r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
            return v.toString(16);
        });
    }
}