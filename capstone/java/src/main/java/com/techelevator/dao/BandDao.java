package com.techelevator.dao;

import com.techelevator.model.Band;

import java.util.List;

public interface BandDao {

    List<Band> findAll();

    Band getBandById(int bandId);

    Band findByBandName(String bandName);

    int findIdByBandName(String bandName);

    String findGenreForBand(Band band);

    int create(Band band);
}
