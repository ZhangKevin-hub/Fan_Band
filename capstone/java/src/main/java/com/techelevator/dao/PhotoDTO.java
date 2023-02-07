package com.techelevator.dao;

import com.techelevator.model.Photo;

import java.util.List;

public class PhotoDTO {
    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
