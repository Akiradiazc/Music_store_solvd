package iDao_interfaces;

import Model.Store;

import java.util.List;

public interface IStoreDAO {
    // ------ CREATE
    boolean create(Store store);

    // ------ READ
    List<Store> getAllStores();
    List<Store> getStoresByCity(String City_name_fk);
    List<Store> getStoresByCountry(String Country_name_fk);
    Store getStoreById(int idStore);

    // ------ UPDATE
    boolean update(Store store);

    // ------ DELETE
    boolean delete(Store store);
}
