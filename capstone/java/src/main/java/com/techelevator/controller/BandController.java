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
    @Autowired
    private JdbcGenreBandDao genreBandDao;

    public BandController(BandDao bandDao, UserDao userDao) {
        this.bandDao = bandDao;
        this.userDao = userDao;
    }

    //create band
    @RequestMapping(value = "/band", method = RequestMethod.POST)
    public int createBand(@RequestBody Band band, @RequestBody List<Integer> genreIds){
        int bandId = this.bandDao.create(band);
        for (int genreId : genreIds) {
            this.genreBandDao.addGenreBand(genreId, bandId);
        }
        return bandId;
    }

    //update band

    //delete

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
