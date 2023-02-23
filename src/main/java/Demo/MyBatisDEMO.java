package Demo;

import Controller.*;

public class MyBatisDEMO {
    public static void main(String[] args) {
        // ----- CONTROLLERS
        GenreController genreController = new GenreController();

        // -----    READ ELEMENTS
        genreController.getAllGenresList();

    }
}
