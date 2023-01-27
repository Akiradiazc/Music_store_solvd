package DAO;

import Model.City;
import Model.Country;
import Model.Store;
import iDao_interfaces.ICityDAO;
import iDao_interfaces.ICountryDAO;

import java.sql.Connection;
import Connection.ConnectionClass;
import iDao_interfaces.IStoreDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreDAOImpl implements IStoreDAO {

    @Override
    public boolean create(Store store) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String citySelect = "(SELECT idCity FROM City WHERE City_name = '"+store.getCity_name_fk()+"')";
        String sql = "INSERT INTO Store(Address, City_id_fk) VALUES ('"+ store.getAddress()+"',"+ citySelect +")";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: StoreDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Store> getAllStores() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Store ORDER BY idStore";
        List<Store> StoresList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Store store = new Store();
                store.setIdStore(resultSet.getInt(1));
                store.setAddress(resultSet.getString(2));
                store.setCity_id_fk(resultSet.getInt(3));
                StoresList.add(store);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StoreDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return StoresList;
    }

    @Override
    public List<Store> getStoresByCity(String City_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idStore, Address, City_id_fk";
        String sql = "SELECT "+searcher+ " FROM Store INNER JOIN City ON Store.City_id_fk = City.idCity WHERE City.City_name= '"+City_name_fk+"'";
        List<Store> StoresList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Store store = new Store();
                store.setIdStore(resultSet.getInt(1));
                store.setAddress(resultSet.getString(2));
                store.setCity_id_fk(resultSet.getInt(3));
                StoresList.add(store);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StoreDaoImpl class, READ (getByCity) method");
            e.printStackTrace();
        }
        return StoresList;
    }

    @Override
    public List<Store> getStoresByCountry(String Country_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idStore, Address, City_id_fk";
        String joins = "INNER JOIN City ON Store.City_id_fk = City.idCity INNER JOIN Country ON Country_id_fk = Country.idCountry ";
        String sql = "SELECT "+searcher+ " FROM Store "+ joins +" WHERE  Country.Country_name= '"+Country_name_fk+"'";
        List<Store> StoresList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Store store = new Store();
                store.setIdStore(resultSet.getInt(1));
                store.setAddress(resultSet.getString(2));
                store.setCity_id_fk(resultSet.getInt(3));
                StoresList.add(store);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StoreDaoImpl class, READ (getByCountry) method");
            e.printStackTrace();
        }
        return StoresList;
    }

    @Override
    public Store getStoreById(int idStore) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Store WHERE idStore = "+ idStore;
        Store storeById = new Store();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                storeById.setIdStore(resultSet.getInt(1));
                storeById.setAddress(resultSet.getString(2));
                storeById.setCity_id_fk(resultSet.getInt(3));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error StoreDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return storeById;
    }

    @Override
    public boolean update(Store store) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Store SET Address='"+store.getAddress()+"' WHERE idStore= "+store.getIdStore();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error StoreDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Store store) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Store WHERE idStore= "+store.getIdStore();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error StoreDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
