package com.techelevator.model;

import java.util.Date;

public class Notification {
    private int notifId;
    private int bandId;
    private String message;
    private Date messageDate;
    //
    public Notification(int notifId, int bandId, String message, Date messageDate) {
        this.notifId = notifId;
        this.bandId = bandId;
        this.message = message;
        this.messageDate = messageDate;
    }

    public Notification() {
    }

    public int getNotifId() {
        return notifId;
    }
    public void setNotifId(int notifId) {
        this.notifId = notifId;
    }
    public int getBandId() {
        return bandId;
    }
    public void setBandId(int bandId) {
        this.bandId = bandId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getMessageDate() {
        return messageDate;
    }
    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}
