package com.techelevator.model;

public class Follower {
    private int userId;
    private int bandId;


    public Follower(int userId, int bandId) {
        this.userId = userId;
        this.bandId = bandId;
    }

    public Follower() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }
}