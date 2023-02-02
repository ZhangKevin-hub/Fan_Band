package com.techelevator.controller;

import com.techelevator.dao.BandDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class BandController {
    @Autowired
    private BandDao bandDao;
    @Autowired
    private UserDao userDao;

    public BandController(BandDao bandDao, UserDao userDao) {
        this.bandDao = bandDao;
        this.userDao = userDao;
    }

    //create band
    @RequestMapping(value = "/band", method = RequestMethod.POST)
    public int createBand(@RequestBody Band band){

        return this.bandDao.create(band);
    }

    //update band
    @RequestMapping(value = "/band/{id}", method = RequestMethod.PUT)
    public void updateBand(@PathVariable int id, @RequestBody Band band){
        band.setBandId(id);
        this.bandDao.update(band);
    }

    //delete band
    @RequestMapping(value = "/band/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable int id){
        this.bandDao.delete(id);
    }

    //get specific band
    @RequestMapping(value = "/band/{id}", method = RequestMethod.GET)
    public Band getBand(@PathVariable int id){
        return this.bandDao.getBandById(id);
    }
    

    //get all bands
    @RequestMapping(value = "/band", method = RequestMethod.GET)
    public List<Band> getAllBands(){
        return this.bandDao.findAll();
    }

    //follow band
    @RequestMapping(value = "/band/{id}", method = RequestMethod.POST)
    public void addBandToUser(Principal principal, @PathVariable int id){
        int userId = this.userDao.findIdByUsername(principal.getName());
        this.bandDao.addBandToUser(userId, id);
    }
}
