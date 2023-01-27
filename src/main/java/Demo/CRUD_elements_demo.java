package Demo;

import Controller.*;
import Model.*;

public class CRUD_elements_demo {
    public static void main(String[] args) {
        // ----- CONTROLLERS
        CountryController countryController = new CountryController();
        GenreController genreController = new GenreController();
        LanguagesController languagesController = new LanguagesController();
        Paying_methodController payingMethodController = new Paying_methodController();
        CityController cityController = new CityController();
        ArtistsController artistsController = new ArtistsController();
        StoreController storeController = new StoreController();

        // -----   CREATE ELEMENTS
        // +++ Creating all elements to insert
        //Country Thailand = new Country("Thailand");
        //Genre kpop = new Genre("Kpop");
        //Languages korean = new Languages("Korean");
        //Paying_method paypal = new Paying_method("PayPal");
        //City Bangkok = new City("Bangkok", "Thailand");
        //Artist Lisa = new Artist("Lisa", "Thailand");
        //Store store1 = new Store("Short Street 33", "Tokyo");

        // +++ Inserting elements created
        //countryController.create(Thailand);
        //genreController.create(kpop);
        //languagesController.create(korean);
        //payingMethodController.create(paypal);
        //cityController.create(Bangkok);
        //artistsController.create(Lisa);
        //storeController.create(store1);

        // -----    READ ELEMENTS
        //countryController.getAllCountriesList();
        //genreController.getAllGenresList();
        //languagesController.getAllLanguagesList();
        //payingMethodController.getAllPayingMethodsList();
        //cityController.getAllCitiesList();
        //artistsController.getArtistsByName("Wee");
        //storeController.getStoreById(2);


        // -----    UPDATE ELEMENTS
        //Artist artistUpdate = artistsController.getArtistById(5);
        //artistUpdate.setName("Lisa");
        //artistsController.update(artistUpdate);
        //artistsController.getAllArtistsList();
    }
}
