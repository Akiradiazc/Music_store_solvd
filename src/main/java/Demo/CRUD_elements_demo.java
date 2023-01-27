package Demo;

import Controller.CountryController;
import Controller.GenreController;
import Controller.LanguagesController;
import Controller.Paying_methodController;
import Model.Country;
import Model.Genre;
import Model.Languages;
import Model.Paying_method;

public class CRUD_elements_demo {
    public static void main(String[] args) {
        // ----- CONTROLLERS
        CountryController countryController = new CountryController();
        GenreController genreController = new GenreController();
        LanguagesController languagesController = new LanguagesController();
        Paying_methodController payingMethodController = new Paying_methodController();

        // -----   CREATE ELEMENTS
        //  Creating all elements to insert
        Country Thailand = new Country("Thailand");
        Genre kpop = new Genre("Kpop");
        Languages korean = new Languages("Korean");
        Paying_method paypal = new Paying_method("PayPal");
        // Inserting elements created
        countryController.create(Thailand);
        genreController.create(kpop);
        languagesController.create(korean);
        payingMethodController.create(paypal);

        // -----    READ ELEMENTS
        countryController.getAllCountriesList();
        genreController.getAllGenresList();
        languagesController.getAllLanguagesList();
        payingMethodController.getAllPayingMethodsList();

        // -----    UPDATE ELEMENTS

    }
}
