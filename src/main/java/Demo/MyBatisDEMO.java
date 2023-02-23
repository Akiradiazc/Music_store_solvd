package Demo;

import Controller.*;
import Model.Languages;

public class MyBatisDEMO {
    public static void main(String[] args) {
        // ----- CONTROLLERS
        GenreController genreController = new GenreController();
        LanguagesController languagesController = new LanguagesController();

        // -----    READ ELEMENTS
        //genreController.getAllGenresList();
        //genreController.getGenreById(1);
        languagesController.getAllLanguagesList();

    }
}
