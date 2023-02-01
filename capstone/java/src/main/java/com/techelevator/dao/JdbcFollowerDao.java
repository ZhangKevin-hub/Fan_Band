package com.techelevator.dao;

import com.techelevator.model.Follower;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFollowerDAO implements FollowerDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcFollowerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Follower> findFollowerWithBandId(int bandId) {
        String sql = "SELECT * FROM follower WHERE band_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, bandId);
        List<Follower> followers = new ArrayList<>();
        while (rowSet.next()) {
            followers.add(mapRowToFollower(rowSet));
        }
        return followers;
    }
    @Override
    public List<Follower> findFollowerWithUserId(int userId) {
        String sql = "SELECT * FROM follower WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        List<Follower> followers = new ArrayList<>();
        while (rowSet.next()) {
            followers.add(mapRowToFollower(rowSet));
        }
        return followers;
    }
    @Override
    public List<Follower> findAll() {
        String sql = "SELECT * FROM follower";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Follower> followers = new ArrayList<>();
        while (rowSet.next()) {
            followers.add(mapRowToFollower(rowSet));
        }
        return followers;
    }
    @Override
    public void addFollower(Follower follower) {
        String sql = "INSERT INTO follower (user_id, band_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, follower.getUserId(), follower.getBandId());
    }
    @Override
    public void removeFollower(Follower follower) {
        String sql = "DELETE FROM follower WHERE user_id = ? and band_id = ?";
        jdbcTemplate.update(sql, follower.getUserId(), follower.getBandId());
    }

    private Follower mapRowToFollower(SqlRowSet rowSet) {
        Follower follower = new Follower();
        follower.setUserId(rowSet.getInt("user_id"));
        follower.setBandId(rowSet.getInt("band_id"));
        return follower;
    }
}
