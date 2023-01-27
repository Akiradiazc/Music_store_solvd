package Controller;

import DAO.GenreDAOImpl;
import Model.Genre;
import Views.ViewGenre;
import iDao_interfaces.IGenreDAO;

import java.util.ArrayList;
import java.util.List;

public class GenreController {
    private ViewGenre view = new ViewGenre();

    public GenreController(){}

    // --------- DAO to CREATE Country
    public void create(Genre genre){
        IGenreDAO dao = new GenreDAOImpl();
        dao.create(genre);
    }

    // --------- DAO to READ country
    public List<Genre> getAllGenresList(){
        List<Genre> GenresList = new ArrayList<>();
        IGenreDAO dao = new GenreDAOImpl();
        GenresList = dao.getAllGenres();
        view.ViewGenres(GenresList);
        return GenresList;
    }

    public Genre getGenreById(int idGenre){
        Genre genreById = new Genre();
        IGenreDAO dao = new GenreDAOImpl();
        genreById = dao.getGenreById(idGenre);
        view.ViewGenres(genreById);
        return genreById;
    }

    // --------- DAO to UPDATE employee
    public void update(Genre genre){
        IGenreDAO dao = new GenreDAOImpl();
        dao.update(genre);
    }

    // --------- DAO to DELETE employee
    public void delete(Genre genre){
        IGenreDAO dao = new GenreDAOImpl();
        dao.delete(genre);
    }
}
