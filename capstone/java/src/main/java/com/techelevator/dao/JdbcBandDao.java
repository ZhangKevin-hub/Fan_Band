package com.techelevator.dao;

import com.techelevator.model.Band;

import java.util.List;

public class JdbcBandDao  implements BandDao{
    @Override
    public List<Band> findAll() {
        return null;
    }

    @Override
    public Band getBandById(int bandId) {
        return null;
    }

    @Override
    public Band findByBandName(String bandName) {
        return null;
    }

    @Override
    public int findIdByBandName(String bandName) {
        return 0;
    }

    @Override
    public String findGenreForBand(Band band) {
        return null;
    }

    @Override
    public boolean create(Band band) {
        return false;
    }
}
