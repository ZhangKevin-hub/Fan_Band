import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcGenreBandDao implements GenreBandDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcGenreBandDao(JdbcTemplate jdbcTemplate {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addGenreBand(int genreId, int bandId) {
        String sql = "INSERT INTO genre_band (genre_id, band_id) VALUES (?,?)";
        jdbcTemplate.update(sql, genreId, bandId);
    }

    @Override
    public void removeGenreBand(int genreId, int bandId) {
        String sql = "DELETE FROM genre_band WHERE genre_id=? AND band_id=?";
        jdbcTemplate.update(sql, genreId, bandId);
    }

    @Override
    public List<GenreBand> getGenreBandsByGenreId(int genreId) {
        List<GenreBand> genreBands = new ArrayList<GenreBand>();
        String sql = "SELECT * FROM genre_band WHERE genre_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
        while (results.next()) {
            GenreBand genreBand = mapRowToGenreBand(results);
            genreBands.add(genreBand);
        }
        return genreBands;
    }

    @Override
    public List<GenreBand> getGenreBandsByBandId(int bandId) {
        List<GenreBand> genreBands = new ArrayList<GenreBand>();
        String sql = "SELECT genre_band.*, band.band_name " +
        "FROM genre_band " +
        "JOIN band ON genre_band.band_id = band.band_id " +
        "WHERE genre_band.band_id=? " +
        "ORDER BY band.band_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bandId);
        while (results.next()) {
            GenreBand genreBand = mapRowToGenreBand(results);
            genreBands.add(genreBand);
        }
        return genreBands;
    }
    private GenreBand mapRowToGenreBand(SqlRowSet results) {
        GenreBand genreBand = new GenreBand();
        genreBand.setGenreId(results.getInt("genre_id"));
        genreBand.setBandId(results.getInt("band_id"));
        return genreBand;
    }
}


