package Controller;

import DAO.AlbumDAOImpl;
import Model.Album;
import Views.ViewAlbum;
import iDao_interfaces.IAlbumDAO;

import java.util.ArrayList;
import java.util.List;


public class AlbumController {
    ViewAlbum view = new ViewAlbum();

    public AlbumController(){}

    // --------- DAO to CREATE Album
    public void create(Album album){
        IAlbumDAO dao = new AlbumDAOImpl();
        dao.create(album);
    }

    // --------- DAO to READ Album
    public List<Album> getAllAlbums() {
        List<Album> albumsList = new ArrayList<>();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumsList = dao.getAllAlbums();
        view.ViewAlbums(albumsList);
        return albumsList;
    }

    public List<Album> getAlbumsByArtist(String Artist_name_fk){
        List<Album> albumsList = new ArrayList<>();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumsList = dao.getAlbumsByArtist(Artist_name_fk);
        view.ViewAlbums(albumsList);
        return albumsList;
    }
    public List<Album> getAlbumsByGenre(String Genre_name_fk){
        List<Album> albumsList = new ArrayList<>();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumsList = dao.getAlbumsByGenre(Genre_name_fk);
        view.ViewAlbums(albumsList);
        return albumsList;
    }
    public List<Album> getAlbumsByLanguage(String Languages_name_fk){
        List<Album> albumsList = new ArrayList<>();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumsList = dao.getAlbumsByLanguage(Languages_name_fk);
        view.ViewAlbums(albumsList);
        return albumsList;
    }
    public List<Album> getAlbumsByYearReleased(int Year_released){
        List<Album> albumsList = new ArrayList<>();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumsList = dao.getAlbumsByYearReleased(Year_released);
        view.ViewAlbums(albumsList);
        return albumsList;
    }
    public List<Album> getAlbumsByPrice(float price, String Comparator){
        List<Album> albumsList = new ArrayList<>();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumsList = dao.getAlbumsByPrice(price, Comparator);
        view.ViewAlbums(albumsList);
        return albumsList;
    }
    public Album getAlbumById(int idAlbum){
        Album albumById = new Album();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumById = dao.getAlbumById(idAlbum);
        view.ViewAlbums(albumById);
        return albumById;
    }
    public Album getAlbumByName(String Album_name){
        Album albumByName= new Album();
        IAlbumDAO dao = new AlbumDAOImpl();
        albumByName = dao.getAlbumByName(Album_name);
        view.ViewAlbums(albumByName);
        return albumByName;
    }

    // --------- DAO to UPDATE Album
    public void update(Album album){
        IAlbumDAO dao = new AlbumDAOImpl();
        dao.update(album);
    }

    // --------- DAO to DELETE Album
    public void delete(Album album){
        IAlbumDAO dao = new AlbumDAOImpl();
        dao.delete(album);
    }
}
