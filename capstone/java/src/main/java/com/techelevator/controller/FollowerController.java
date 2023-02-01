package com.techelevator.controller;


import com.techelevator.dao.FollowerDao;
import com.techelevator.model.Follower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/followers")
public class FollowerController {
    private FollowerDao followerDao;

    @Autowired
    public FollowerController(FollowerDao followerDao) {
        this.followerDao = followerDao;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/bands/{bandId}", method = RequestMethod.GET)
    public List<Follower> findFollowersWithBandId(@PathVariable int bandId) {
        return followerDao.findFollowerWithBandId(bandId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public List<Follower> findFollowersWithUserId(@PathVariable int userId) {
        return followerDao.findFollowerWithUserId(userId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET)
    public List<Follower> findAllFollowers() {
        return followerDao.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.POST)
    public void addFollower(@RequestBody Follower follower) {
        followerDao.addFollower(follower);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.DELETE)
    public void removeFollower(@RequestBody Follower follower) {
        followerDao.removeFollower(follower);
    }
}


