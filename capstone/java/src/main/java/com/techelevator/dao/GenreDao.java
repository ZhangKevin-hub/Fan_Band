
package com.techelevator.dao;

import com.techelevator.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> findAll();
    List<Genre> findGenresByBandId(int bandId);
    Genre findGenreById(int genreId);

    void addGenre(Genre genre);

    void deleteGenre(Genre genreId);
}