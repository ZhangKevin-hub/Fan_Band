package com.techelevator.model;

public class Inbox {
    private int notifId;
    private int userId;
    public Inbox(int notifId, int userId) {
        this.notifId = notifId;
        this.userId = userId;
    }
    public Inbox(){

    }
    public int getNotifId() {
        return notifId;
    }
    public void setNotifId(int notifId) {
        this.notifId = notifId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}

