package com.mcneil.technologies.triplexlinersystem.model.wrapper;


public class LinerPatternImageWrapper {
    private LinerPatternImage beforeImage;
    private LinerPatternImage locationImage;

    public LinerPatternImageWrapper() {

    }

    public LinerPatternImageWrapper(LinerPatternImage beforeImage, LinerPatternImage locationImage) {
        this.setBeforeImage(beforeImage);
        this.setLocationImage(locationImage);
    }

    public LinerPatternImage getBeforeImage() {
        return beforeImage;
    }

    public void setBeforeImage(LinerPatternImage beforeImage) {
        beforeImage.setImageType("before");
        this.beforeImage = beforeImage;
    }

    public LinerPatternImage getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(LinerPatternImage locationImage) {
        locationImage.setImageType("location");
        this.locationImage = locationImage;
    }
}
