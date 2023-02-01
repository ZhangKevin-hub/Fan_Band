package com.techelevator.model;

public class GenreBand {

    private int genreId;
    private int bandId;

    public GenreBand() {}

    public GenreBand(int genreId, int bandId) {
        this.genreId = genreId;
        this.bandId = bandId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }
}
