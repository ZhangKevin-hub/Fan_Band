package com.techelevator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.Notification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcNotificationDao implements NotificationDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcNotificationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void addNotification(Notification notification) {
        String sql = "INSERT INTO notification (band_id, message, message_date) values (?, ?, ?)";
        jdbcTemplate.update(sql, notification.getBandId(), notification.getMessage(), notification.getMessageDate());
    }
    // hi
    @Override
    public List<Notification> getNotificationsByUserId(int userId) {
        List<Notification> notifications = new ArrayList<Notification>();
        String sql = "SELECT * " +
                "FROM notification " +
                "JOIN follower ON follower.band_id = notification.band_id " +
                "WHERE user_id = ?" +
                "ORDER BY message_date DESC";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()){
            notifications.add(mapRowToNotification(rowSet));
        }
        return notifications;
    }

    private Notification mapRowToNotification(SqlRowSet rs) {
        Notification notification = new Notification();
        notification.setNotifId(rs.getInt("notif_id"));
        notification.setBandId(rs.getInt("band_id"));
        notification.setMessage(rs.getString("message"));
        notification.setMessageDate(rs.getDate("message_date"));
        return notification;
    }
}
