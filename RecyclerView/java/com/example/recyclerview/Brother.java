package com.example.recyclerview;

public class Brother {
    private String name;
    private int imageId;

    public Brother(String name,int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
