package com.techelevator.dao;

import com.techelevator.model.Notification;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public interface NotificationDao {

    void addNotification(Notification notification);

    // Sort via Date Recent
    List<Notification> getNotificationsByUserIdDateSortRecent(int userId);

    //Sort via Date Oldest
    List<Notification> getNotificationsByUserIdDateSortOld(int userId);

    // Sort Via A-Z BandName(default)
    List<Notification> getNotificationsByUserIdBNameSortAZ(int userId);


    // Sort Z-A BandName
    List<Notification> getNotificationsByUserIdBNameSortZA(int userId);
}
