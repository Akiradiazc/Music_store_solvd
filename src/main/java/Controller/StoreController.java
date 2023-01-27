package Controller;

import DAO.StoreDAOImpl;
import Model.Store;
import Views.ViewStore;
import iDao_interfaces.IStoreDAO;

import java.util.ArrayList;
import java.util.List;

public class StoreController {
    ViewStore view = new ViewStore();

    public StoreController(){}

    // --------- DAO to CREATE Store
    public void create(Store store){
        IStoreDAO dao = new StoreDAOImpl();
        dao.create(store);
    }

    // --------- DAO to READ country
    public List<Store> getAllStoresList(){
        List<Store> StoresList = new ArrayList<>();
        IStoreDAO dao = new StoreDAOImpl();
        StoresList = dao.getAllStores();
        view.ViewStores(StoresList);
        return StoresList;
    }

    public List<Store> getStoresByCountry(String Country_name_fk){
        List<Store> StoresList = new ArrayList<>();
        IStoreDAO dao = new StoreDAOImpl();
        StoresList = dao.getStoresByCountry(Country_name_fk);
        view.ViewStores(StoresList);
        return StoresList;
    }
    public List<Store> getStoresByCity(String City_name_fk){
        List<Store> StoresList = new ArrayList<>();
        IStoreDAO dao = new StoreDAOImpl();
        StoresList = dao.getStoresByCity(City_name_fk);
        view.ViewStores(StoresList);
        return StoresList;
    }

    public Store getStoreById(int idStore){
        Store storeById = new Store();
        IStoreDAO dao = new StoreDAOImpl();
        storeById = dao.getStoreById(idStore);
        view.ViewStores(storeById);
        return storeById;
    }

    // --------- DAO to UPDATE employee
    public void update(Store store){
        IStoreDAO dao = new StoreDAOImpl();
        dao.update(store);
    }

    // --------- DAO to DELETE employee
    public void delete(Store store){
        IStoreDAO dao = new StoreDAOImpl();
        dao.delete(store);
    }
}
