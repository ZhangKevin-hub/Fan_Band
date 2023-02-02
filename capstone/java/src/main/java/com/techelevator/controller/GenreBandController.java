import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre-band")
public class GenreBandController {
    @Autowired
    private JdbcGenreBandDao genreBandDao;

    @RequestMapping(value = "/genrebands", method = RequestMethod.POST)
    public void addGenreBand(@RequestBody GenreBand genreBand) {
        jdbcGenreBandDao.addGenreBand(genreBand.getGenreId(), genreBand.getBandId());
    }

    @RequestMapping(value = "/genrebands/{genreId}/{bandId}", method = RequestMethod.DELETE)
    public void removeGenreBand(@PathVariable int genreId, @PathVariable int bandId) {
        jdbcGenreBandDao.removeGenreBand(genreId, bandId);
    }

    @RequestMapping(value = "/genrebands/genre/{genreId}", method = RequestMethod.GET)
    public List<GenreBand> getGenreBandsByGenreId(@PathVariable int genreId) {
        return jdbcGenreBandDao.getGenreBandsByGenreId(genreId);
    }

    @RequestMapping(value = "/genrebands/band/{bandId}", method = RequestMethod.GET)
    public List<GenreBand> getGenreBandsByBandId(@PathVariable int bandId) {
        return jdbcGenreBandDao.getGenreBandsByBandId(bandId);
    }
}