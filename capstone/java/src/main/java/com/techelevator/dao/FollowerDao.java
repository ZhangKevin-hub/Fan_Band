package com.techelevator.dao;

import com.techelevator.model.Follower;

import java.util.List;

public interface FollowerDao {

    List<Follower> findFollowerWithBandId(int bandId);

    List<Follower> findFollowerWithUserId(int userId);

    List<Follower> findAll();

    void addFollower(Follower follower);

    void removeFollower(Follower follower);

}