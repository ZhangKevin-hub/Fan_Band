package com.techelevator.dao;

import com.techelevator.model.Band;

import java.util.List;

public interface BandDao {

    List<Band> findAll();

    Band getBandById(int bandId);


    int findIdByBandName(String bandName);

    String findGenreForBand(Band band);

    void addBandToUser(int userId, int bandId);

    int create(Band band);

    List<Band> findByBandName(String bandName);

    int update(Band band);

    List<Band> getBandsByGenreIds(List<Integer> genreIds);

    void delete(int bandId);


}
