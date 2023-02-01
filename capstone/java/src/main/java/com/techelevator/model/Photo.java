package com.techelevator.model;

public class Photo {
    private int photoId;
    private String imgUrl;
    private int bandId;

    public Photo(int photoId, String imgUrl, int bandId) {
        this.photoId = photoId;
        this.imgUrl = imgUrl;
        this.bandId = bandId;
    }

    public Photo() {
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }
}
