package com.techelevator.controller;

import com.techelevator.dao.BandDao;
import com.techelevator.dao.JdbcGenreBandDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Band;
import com.techelevator.model.BandGenreList;
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
    public int createBand(@RequestBody BandGenreList bandGenreList){
        Band band = new Band();
        band.setUser_id(bandGenreList.getUser_id());
        band.setBandName(bandGenreList.getBandName());
        band.setDescription(bandGenreList.getDescription());
        band.setImage(bandGenreList.getImage());
        List<Integer> genreIds = bandGenreList.getGenreIds();
        int bandId =  this.bandDao.create(band);
        for (int genreId : genreIds) {
            this.genreBandDao.addGenreBand(genreId, bandId);
        }
        return bandId;
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
    // get specific band by name

    @RequestMapping(value = "/band/specific/{bandName}", method = RequestMethod.GET)
    public int findIdByBandName(@PathVariable String bandName){
        return this.bandDao.findIdByBandName(bandName);
    }
    // get similar band by name

    @RequestMapping(value = "/band/similar/{bandName}", method = RequestMethod.GET)
    public List<Band> getBandByName(@PathVariable String bandName){

        return this.bandDao.findByBandName(bandName);
    }
    //get all bands
    @RequestMapping(value = "/band", method = RequestMethod.GET)
    public List<Band> getAllBands(){
        return this.bandDao.findAll();
    }

    //GetBands via genreId
    @RequestMapping(value = "/band/genre/{genreIds}", method = RequestMethod.GET)
    public List<Band> getBandsByGenreIds(@PathVariable List<Integer> genreIds) {
        return this.bandDao.getBandsByGenreIds(genreIds);
    }

    //follow band
    @RequestMapping(value = "/band/{id}", method = RequestMethod.POST)
    public void addBandToUser(Principal principal, @PathVariable int id){
        int userId = this.userDao.findIdByUsername(principal.getName());
        this.bandDao.addBandToUser(userId, id);
    }
}
