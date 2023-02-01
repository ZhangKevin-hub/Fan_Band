package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Band {

    private int bandId;
    private String bandName;
    private String description;
    private String image;
    @JsonProperty("userId")
    private int userId;

    public Band() {
    }

    public Band(int bandId, String bandName, String description, String image, int userId) {
        this.bandId = bandId;
        this.bandName = bandName;
        this.description = description;
        this.image = image;
        this.userId = userId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }
}

