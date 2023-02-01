package com.techelevator.controller;

import com.techelevator.dao.GenreDao;
import com.techelevator.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/genres")
public class GenreController {
    private GenreDao genreDao;

    @Autowired
    public GenreController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @RequestMapping(value = "/bands/{bandId}", method = RequestMethod.GET)
    public List<Genre> findGenresByBandId(@PathVariable int bandId) {
        return genreDao.findGenresByBandId(bandId);
    }

    @GetMapping
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @RequestMapping(value = "/{genreId}", method = RequestMethod.GET)
    public Genre findGenreById(@PathVariable int genreId) {
        return genreDao.findGenreById(genreId);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addGenre(@RequestBody Genre genre) {
        genreDao.addGenre(genre);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteGenre(@RequestBody Genre genre) {
        genreDao.deleteGenre(genre);
    }

}
