package com.techelevator.dao;

import com.techelevator.model.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotoDao implements PhotoDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPhotoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;



    }
    @Override
    public List<Photo> findPhotoByBandId(int bandId){
        List<Photo> photo = new ArrayList<>();
       String sql = "SELECT * FROM photo WHERE band_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, bandId);
        while (rowSet.next()){
            photo.add(mapRowToPhoto(rowSet));
        }
        return photo;
    }
    // photo_id could be changed if it's messing things up
    @Override
    public void addPhoto(Photo photo) {
        String sql = "INSERT INTO photo (band_id, img_url) VALUES (?, ?)";
        jdbcTemplate.update(sql, photo.getPhotoId(), photo.getBandId(), photo.getImgUrl());
    }
    @Override
    public void deletePhoto(Photo photo) {
        String sql = "DELETE FROM photo WHERE photo_id = ?";
        jdbcTemplate.update(sql, photo.getPhotoId());
    }

    private Photo mapRowToPhoto(SqlRowSet rowSet) {
        Photo photo = new Photo();
        photo.setPhotoId(rowSet.getInt("photo_id"));
        photo.setImgUrl(rowSet.getString("img_url"));
        photo.setBandId(rowSet.getInt("band_id"));
        return photo;
    }
}
