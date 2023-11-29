package com.mcneil.technologies.triplexlinersystem.model.wrapper;

import org.springframework.web.multipart.MultipartFile;

public class LinerPatternImage {
    private MultipartFile[] imageFiles;
    private String imageType;

    public LinerPatternImage() {

    }

    public LinerPatternImage(MultipartFile[] imageFiles, String imageType) {
        this.imageFiles = imageFiles;
        this.imageType = imageType;
    }

    public MultipartFile[] getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(MultipartFile[] imageFiles) {
        this.imageFiles = imageFiles;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
