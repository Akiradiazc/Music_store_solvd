package iDao_interfaces;

import Model.Album;
import Model.Artist;

import java.util.List;

public interface IAlbumDAO {
    // ------ CREATE
    boolean create(Album album);

    // ------ READ
    List<Album> getAllAlbums();
    List<Album> getAlbumsByArtist(String Artist_name_fk);
    List<Album> getAlbumsByGenre(String Genre_name_fk);
    List<Album> getAlbumsByLanguage(String Languages_name_fk);
    List<Album> getAlbumsByYearReleased(int Year_released);
    List<Album> getAlbumsByPrice(float price, String Comparator);
    Album getAlbumById(int idAlbum);
    Album getAlbumByName(String Album_name);

    // ------ UPDATE
    boolean update(Album album);

    // ------ DELETE
    boolean delete(Album album);
}
