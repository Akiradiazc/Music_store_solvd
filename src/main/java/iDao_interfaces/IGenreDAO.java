package iDao_interfaces;

import Model.Genre;

import java.util.List;

public interface IGenreDAO {
    // ------ CREATE
    boolean create(Genre genre);

    // ------ READ
    List<Genre> getAllGenres();
    Genre getGenreById(int idGenre);

    // ------ UPDATE
    boolean update(Genre genre);

    // ------ DELETE
    boolean delete(Genre genre);
}
