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
        AlbumController albumController = new AlbumController();
        StockController stockController = new StockController();
        Buy_orderController buyOrderController = new Buy_orderController();

        // -----   CREATE ELEMENTS
        // +++ Creating all elements to insert
        //Country Thailand = new Country("Thailand");
        //Genre kpop = new Genre("Kpop");
        //Languages korean = new Languages("Korean");
        //Paying_method paypal = new Paying_method("PayPal");
        //City Bangkok = new City("Bangkok", "Thailand");
        //Artist Lisa = new Artist("Lisa", "Thailand");
        //Store store1 = new Store("Short Street 33", "Tokyo");
        //Album weeknd3 = new Album("Kiss Land", 2013, (float) 110.99, "The Weeknd", "R&B", "English");
        Buy_order buyOrder1 = new Buy_order("Romance", 1, 1);


        // +++ Inserting elements created
        //countryController.create(Thailand);
        //genreController.create(kpop);
        //languagesController.create(korean);
        //payingMethodController.create(paypal);
        //cityController.create(Bangkok);
        //artistsController.create(Lisa);
        //storeController.create(store1);
        //albumController.create(weeknd3);
        buyOrderController.create(buyOrder1);


        // -----    READ ELEMENTS
        //countryController.getAllCountriesList();
        //genreController.getAllGenresList();
        //languagesController.getAllLanguagesList();
        //payingMethodController.getAllPayingMethodsList();
        //cityController.getAllCitiesList();
        //artistsController.getArtistsByName("Wee");
        //storeController.getStoreById(2);
        //albumController.getAlbumsByGenre("Jpop");
        stockController.getAllStock();


        // -----    UPDATE ELEMENTS
        //Artist artistUpdate = artistsController.getArtistById(5);
        //artistUpdate.setName("Lisa");
        //artistsController.update(artistUpdate);
        //artistsController.getAllArtistsList();
    }
}
