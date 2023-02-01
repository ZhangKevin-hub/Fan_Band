package com.techelevator.dao;

import com.techelevator.model.Inbox;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public interface InboxDao {
    void addNotificationToInbox(Inbox inbox);


    List<Inbox> getNotificationsByUserId(int userId);

}
