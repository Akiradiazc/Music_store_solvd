package iDao_interfaces;
import Model.Artist;

import java.util.List;

public interface IArtistDAO {
    // ------ CREATE
    boolean create(Artist artist);

    // ------ READ
    List<Artist> getAllArtists();
    List<Artist> getArtistsByCountry(String Country_name_fk);
    Artist getArtistById(int idArtist);
    List<Artist> getArtistByName(String name);

    // ------ UPDATE
    boolean update(Artist artist);

    // ------ DELETE
    boolean delete(Artist artist);
}
