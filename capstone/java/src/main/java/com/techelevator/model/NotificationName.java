package com.techelevator.model;

public class NotificationName extends Notification{

    private String bandName;


    public NotificationName(String bandName) {
        this.bandName = bandName;
    }

    public NotificationName(){}

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
