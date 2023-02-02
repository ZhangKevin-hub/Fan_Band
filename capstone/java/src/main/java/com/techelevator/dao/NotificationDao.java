package com.techelevator.dao;

import com.techelevator.model.Notification;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public interface NotificationDao {

    void addNotification(Notification notification);

    List<Notification> getNotificationsByUserIdDateSort(int userId);
    
    List<Notification> getNotificationsByUserIdBNameSort(int userId);
    

}
