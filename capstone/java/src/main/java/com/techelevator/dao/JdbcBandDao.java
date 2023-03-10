package com.techelevator.dao;

import com.techelevator.model.Band;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBandDao implements BandDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBandDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Band> findAll() {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM band " +
                "ORDER BY band_name;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Band band = mapRowToBand(results);
            bands.add(band);
        }

        return bands;
    }

    @Override
    public Band getBandById(int bandId) {
        String sql = "SELECT * " +
                "FROM band " +
                "WHERE band_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bandId);
        if (results.next()){
            return mapRowToBand(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Band> findByBandName(String bandName) {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM band " +
                "WHERE band_name LIKE ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + bandName + "%");
        while (results.next()){
            Band band = mapRowToBand(results);
            bands.add(band);
        }
        return bands;
    }

    @Override
    public int update(Band band) {
        String sql = "UPDATE band " +
                "SET band_name = ?, description = ?, image = ? " +
                "WHERE band_id = ?;";
        return jdbcTemplate.update(sql, band.getBandName(), band.getDescription(), band.getImage(), band.getBandId());
    }

    @Override
    public void delete(int bandId) {
        String sql = "DELETE FROM band " +
                "WHERE band_id = ?;";
        jdbcTemplate.update(sql, bandId);
    }

    @Override
    public int findIdByBandName(String bandName) {
        if (bandName == null) throw new IllegalArgumentException("Band name cannot be null");
        String sql = "SELECT band_id " +
                "FROM band " +
                "WHERE band_name = ?;";
        int bandId;
        try {
            bandId = jdbcTemplate.queryForObject(sql, int.class, bandName);
        } catch (NullPointerException e){
            throw new UsernameNotFoundException("Band " + bandName + " was not found");
        }

        return bandId;
    }

    @Override
    public String findGenreForBand(Band band) {
//        List<String> genres = new ArrayList<>();
//        String sql = "SELECT genre_name " +
//                "FROM genre " +
//                "JOIN genre_band ON genre_band.genre_id = genre.genre_id " +
//                "WHERE band_id = ?;";
//        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, bandId);
//        while(rowSet.next()){
//            genres.add(rowSet);
//        }
        return null;
    }

    @Override
    public void addBandToUser(int userId, int bandID) {
        String sql = "INSERT INTO follower " +
                "(user_id, band_id) " +
                "VALUES (?, ?);";
         jdbcTemplate.update(sql, userId, bandID);
    }

    @Override
    public int create(Band band) {
        String sql = "INSERT INTO band " +
                "(band_name, description, image, user_id) " +
                "VALUES (?, ?, ?, ?)" +
                "RETURNING band_id;";
        return jdbcTemplate.queryForObject(sql, Integer.class, band.getBandName(), band.getDescription(), band.getImage(), band.getUser_id());
    }
    @Override
    public List<Band> getBandsByGenreIds(List<Integer> genreIds) {
        List<Band> bands = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM band " +
                "JOIN genre_band ON band.band_id = genre_band.band_id " +
                "WHERE genre_band.genre_id = ? " +
                "ORDER BY band.band_name";
        for(Integer genreId : genreIds){
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
            while (results.next()) {
                Band band = mapRowToBand(results);
                bands.add(band);
            }
        }
        return bands;
    }

    private Band mapRowToBand(SqlRowSet rowSet) {
        Band band = new Band();
        band.setBandId(rowSet.getInt("band_id"));
        band.setBandName(rowSet.getString("band_name"));
        band.setDescription(rowSet.getString("description"));
        band.setImage(rowSet.getString("image"));
        band.setUser_id(rowSet.getInt("user_id"));
        return band;
    }

}
