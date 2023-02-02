package com.techelevator.controller;

import java.util.List;

import com.techelevator.dao.InboxDao;
import com.techelevator.model.Inbox;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/inbox")
public class InboxController {
    private InboxDao inboxDao;

    public InboxController(InboxDao inboxDao) {
        this.inboxDao = inboxDao;
    }

    @RequestMapping(value = "/notifications" , method = RequestMethod.POST)
    public void addNotificationToInbox(@RequestBody Inbox inbox) {
        inboxDao.addNotificationToInbox(inbox);
    }

    @RequestMapping(value = "/notifications/{userId}", method = RequestMethod.GET)
    public List<Inbox> getNotificationsByUserId(int userId) {
        return inboxDao.getNotificationsByUserId(userId);
    }
}
