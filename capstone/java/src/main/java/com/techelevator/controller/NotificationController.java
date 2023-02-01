package com.techelevator.controller;

import java.util.List;

import com.techelevator.dao.NotificationDao;
import com.techelevator.model.Notification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private NotificationDao notificationDao;

    public NotificationController(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addNotification(@RequestBody Notification notification) {
        notificationDao.addNotification(notification);
    }

    @RequestMapping(value = "/{bandId}", method = RequestMethod.GET)
    public List<Notification> getNotificationsByBandId(@PathVariable int bandId) {
        return notificationDao.getNotificationsByBandId(bandId);
    }
}
