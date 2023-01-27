package Controller;

import DAO.ArtistDAOImpl;
import Model.Artist;
import Views.ViewArtists;
import iDao_interfaces.IArtistDAO;

import java.util.ArrayList;
import java.util.List;

public class ArtistsController {
    private ViewArtists view = new ViewArtists();

    public ArtistsController(){}

    // --------- DAO to CREATE Artist
    public void create(Artist artist){
        IArtistDAO dao = new ArtistDAOImpl();
        dao.create(artist);
    }

    // --------- DAO to READ country
    public List<Artist> getAllArtistsList(){
        List<Artist> ArtistsList = new ArrayList<>();
        IArtistDAO dao = new ArtistDAOImpl();
        ArtistsList = dao.getAllArtists();
        view.ViewArtist(ArtistsList);
        return ArtistsList;
    }

    public List<Artist> getArtistsByCountry(String Country_name_fk){
        List<Artist> ArtistsList = new ArrayList<>();
        IArtistDAO dao = new ArtistDAOImpl();
        ArtistsList = dao.getArtistsByCountry(Country_name_fk);
        view.ViewArtist(ArtistsList);
        return ArtistsList;
    }

    public Artist getArtistById(int idArtist){
        Artist artistById = new Artist();
        IArtistDAO dao = new ArtistDAOImpl();
        artistById = dao.getArtistById(idArtist);
        view.ViewArtist(artistById);
        return artistById;
    }

    public List<Artist> getArtistsByName(String name){
        List<Artist> ArtistsList = new ArrayList<>();
        IArtistDAO dao = new ArtistDAOImpl();
        ArtistsList = dao.getArtistByName(name);
        view.ViewArtist(ArtistsList);
        return ArtistsList;
    }

    // --------- DAO to UPDATE employee
    public void update(Artist artist){
        IArtistDAO dao = new ArtistDAOImpl();
        dao.update(artist);
    }

    // --------- DAO to DELETE employee
    public void delete(Artist artist){
        IArtistDAO dao = new ArtistDAOImpl();
        dao.delete(artist);
    }
}
