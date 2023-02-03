package com.techelevator.model;

import java.util.Date;

public class NotificationName extends Notification{

    private String bandName;

    public NotificationName(int notifId, int bandId, String message, Date messageDate, String bandName) {
        super(notifId, bandId, message, messageDate);
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
