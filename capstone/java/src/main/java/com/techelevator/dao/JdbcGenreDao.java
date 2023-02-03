package com.techelevator.dao;

import com.techelevator.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Genre> findGenresByBandId(int bandId) {
        String sql = "SELECT * FROM genre WHERE band_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, bandId);
        List<Genre> genres = new ArrayList<>();
        while (rowSet.next()) {
            genres.add(mapRowToGenre(rowSet));
        }
        return genres;
    }

    public List<Genre> findAll() {
        String sql = "SELECT * FROM genre";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Genre> genres = new ArrayList<>();
        while (rowSet.next()) {
            genres.add(mapRowToGenre(rowSet));
        }
        return genres;
    }

    @Override
    public Genre findGenreById(int genreId) {
        return null;
    }

    // Below should ONLY be accessible to ADMIN ACCOUNTS
    @Override
    public void addGenre(Genre genre) {
        String sql = "INSERT INTO genre (genre_name) VALUES ( ?)";
        jdbcTemplate.update(sql, genre.getName());
    }


    @Override
    public void deleteGenre(Genre genre) {
        String sql = "DELETE FROM genre WHERE genre_id = ? and genre_name = ?";
        jdbcTemplate.update(sql, genre.getId(), genre.getName());
    }

    private Genre mapRowToGenre(SqlRowSet rowSet) {
        Genre genre = new Genre();
        genre.setId(rowSet.getInt("genre_id"));
        genre.setName(rowSet.getString("genre_name"));
        return genre;
    }
}