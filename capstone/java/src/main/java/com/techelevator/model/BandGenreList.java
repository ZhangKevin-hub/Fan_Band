package com.techelevator.model;

import java.util.List;

public class BandGenreList extends Band{

    private List<Integer> genreIds;

    public BandGenreList(int bandId, String bandName, String description, String image, int userId, List<Integer> genreIds) {
        super(bandId, bandName, description, image, userId);
        this.genreIds = genreIds;
    }

    public BandGenreList(){}

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
}
