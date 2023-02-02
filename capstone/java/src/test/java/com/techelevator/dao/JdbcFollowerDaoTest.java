package com.techelevator.dao;

import com.techelevator.model.Follower;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcFollowerDaoTest extends BaseDaoTests {

    private FollowerDao dao;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcFollowerDao(jdbcTemplate);
    }

    @Test
    public void find_follower_with_band_id_returns_expected_result() {
        // Given
        int bandId = 1;
        // When
        List<Follower> followers = dao.findFollowerWithBandId(bandId);
        // Then
        Assert.assertNotNull(followers);
    }

    @Test
    public void find_follower_with_user_id_returns_expected_result() {
        int userId = 1;
        List<Follower> followers = dao.findFollowerWithUserId(userId);
        Assert.assertNotNull(followers);
    }

    @Test
    public void find_all_followers_returns_expected_result() {
        List<Follower> followers = dao.findAll();
        Assert.assertNotNull(followers);
    }

    @Test
    public void add_follower_succeeds() {
        Follower follower = new Follower();
        follower.setUserId(1);
        follower.setBandId(1);
        dao.addFollower(follower);
        List<Follower> followers = dao.findAll();
        Assert.assertTrue(followers.contains(follower));
    }

    @Test
    public void remove_follower_succeeds() {
        Follower follower = new Follower();
        follower.setUserId(1);
        follower.setBandId(1);
        dao.addFollower(follower);
        dao.removeFollower(follower);
        List<Follower> followers = dao.findAll();
        Assert.assertFalse(followers.contains(follower));
    }

}
