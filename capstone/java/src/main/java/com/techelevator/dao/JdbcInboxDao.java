package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.Inbox;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcInboxDao implements InboxDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcInboxDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addNotificationToInbox(Inbox inbox) {
        String sql = "INSERT INTO inbox (notif_id, user_id) values (?, ?)";
        jdbcTemplate.update(sql, inbox.getNotifId(), inbox.getUserId());
    }

    @Override
    public List<Inbox> getNotificationsByUserId(int userId) {
        List<Inbox> notifications = new ArrayList<>();
        String sql = "SELECT * FROM inbox WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            notifications.add(mapRowToInbox(rowSet));
        }
        return notifications;
    }

    private Inbox mapRowToInbox(SqlRowSet rs) {
        Inbox inbox = new Inbox();
        inbox.setNotifId(rs.getInt("notif_id"));
        inbox.setUserId(rs.getInt("user_id"));
        return inbox;
    }

}

