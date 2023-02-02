package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.dao.BandDao;
import com.techelevator.dao.NotificationDao;
import com.techelevator.model.Notification;
import com.techelevator.model.NotificationName;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/notifications")
public class NotificationController {
    private NotificationDao notificationDao;
    private BandDao bandDao;

    public NotificationController(NotificationDao notificationDao, BandDao bandDao) {
        this.notificationDao = notificationDao;
        this.bandDao = bandDao;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addNotification(@RequestBody Notification notification) {
        notificationDao.addNotification(notification);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<NotificationName> getNotificationsByUserIdDateSort(@PathVariable int userId) {
        List<Notification> notifications = notificationDao.getNotificationsByUserIdDateSort(userId);
        List<NotificationName> listOfNotificationsWithName = new ArrayList<>();
        for (Notification notification : notifications){
            NotificationName notificationName = new NotificationName();
            notificationName.setBandId(notification.getBandId());
            notificationName.setMessage(notification.getMessage());
            notificationName.setMessageDate(notification.getMessageDate());
            notificationName.setNotifId(notification.getNotifId());
            String bandName = this.bandDao.getBandById(notification.getBandId()).getBandName();
            notificationName.setBandName(bandName);
            listOfNotificationsWithName.add(notificationName);
        }
        return listOfNotificationsWithName;
    }

    @RequestMapping(value = "/{userId}/band-name-sort", method = RequestMethod.GET)
    public List<NotificationName> getNotificationsByUserIdBNameSort(@PathVariable int userId) {
        List<Notification> notifications = notificationDao.getNotificationsByUserIdBNameSort(userId);
        List<NotificationName> listOfNotificationsWithName = new ArrayList<>();
        for (Notification notification : notifications){
            NotificationName notificationName = new NotificationName();
            notificationName.setBandId(notification.getBandId());
            notificationName.setMessage(notification.getMessage());
            notificationName.setMessageDate(notification.getMessageDate());
            notificationName.setNotifId(notification.getNotifId());
            String bandName = this.bandDao.getBandById(notification.getBandId()).getBandName();
            notificationName.setBandName(bandName);
            listOfNotificationsWithName.add(notificationName);
        }
        return listOfNotificationsWithName;
    }
}