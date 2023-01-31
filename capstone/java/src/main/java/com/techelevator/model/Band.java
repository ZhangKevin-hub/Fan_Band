package com.techelevator.model;

public class Band {

    private int bandId;
    private String bandName;
    private String description;
    private String image;
    private int managerID;

    public Band(){}

    public Band(int bandId, String bandName, String description, String image, int managerID) {
        this.bandId = bandId;
        this.bandName = bandName;
        this.description = description;
        this.image = image;
        this.managerID = managerID;
    }

    public int getBandId() {
        return this.bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return this.bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getManagerID() {
        return this.managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}
