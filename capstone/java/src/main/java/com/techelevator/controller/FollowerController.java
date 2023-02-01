package com.techelevator.controller;


import com.techelevator.dao.FollowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FollowerController {
    @Autowired
    private FollowerDao followerDao;


}
