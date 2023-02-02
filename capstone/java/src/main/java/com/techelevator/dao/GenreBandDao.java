
import java.util.List;

import javax.sql.DataSource;


public interface GenreBandDao {


    public void addGenreBand(int genreId, int bandId);

    public void removeGenreBand(int genreId, int bandId);

    public List<GenreBand> getGenreBandsByGenreId(int genreId);

    public List<GenreBand> getGenreBandsByBandId(int bandId);
}


