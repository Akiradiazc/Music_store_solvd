package DAO;

import Model.Buy_order;
import Model.Stock;
import iDao_interfaces.IStockDAO;

import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StockDAOImpl implements IStockDAO {
    @Override
    public boolean create(Stock stock) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;

        String columnNames = "(Quantity, Albums_id_fk, Store_id_fk)";
        String AlbumSelect = "(SELECT idAlbum FROM Albums WHERE Album_name= "+stock.getAlbum_name_fk()+"')";
        String StoreSelect = "(SELECT idStore FROM Store WHERE idStore= "+ stock.getStore_id_fk();

        String sql = "INSERT INTO Stock " + columnNames + " VALUES ("+ stock.getQuantity() +", " + AlbumSelect +", "+ StoreSelect+")";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: StockDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Stock> getAllStock() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Stock ORDER BY idStock";
        List<Stock> StockList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setIdStock(resultSet.getInt(1));
                stock.setQuantity(resultSet.getInt(2));
                stock.setAlbum_id_fk(resultSet.getInt(3));
                stock.setStore_id_fk(resultSet.getInt(4));
                StockList.add(stock);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return StockList;
    }

    @Override
    public List<Stock> getStockByStore(int Store_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String Columns = "idStock, Quantity, Albums_id_fk, Store_id_fk";
        String sql = "SELECT * FROM Stock WHERE Store_id_fk= "+Store_id_fk;
        List<Stock> StockList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setIdStock(resultSet.getInt(1));
                stock.setQuantity(resultSet.getInt(2));
                stock.setAlbum_id_fk(resultSet.getInt(3));
                stock.setStore_id_fk(resultSet.getInt(4));
                StockList.add(stock);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, READ (getByStoreId) method");
            e.printStackTrace();
        }
        return StockList;
    }

    @Override
    public List<Stock> getStockByAlbum(String Album_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String Columns = "idStock, Quantity, Albums_id_fk, Store_id_fk";
        String Joins = "INNER JOIN albums ON Stock.Albums_id_fk=albums.idAlbum";
        String sql = "SELECT "+Columns+" FROM Stock "+Joins+" WHERE Album_name= "+Album_name_fk;
        List<Stock> StockList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setIdStock(resultSet.getInt(1));
                stock.setQuantity(resultSet.getInt(2));
                stock.setAlbum_id_fk(resultSet.getInt(3));
                stock.setStore_id_fk(resultSet.getInt(4));
                StockList.add(stock);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, READ (getByAlbumName) method");
            e.printStackTrace();
        }
        return StockList;
    }

    @Override
    public List<Stock> getStockByArtist(String Artist_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String Columns = "idStock, Quantity, Albums_id_fk, Store_id_fk";
        String Join1 = " INNER JOIN albums ON Stock.Albums_id_fk=albums.idAlbum ";
        String Join2 = " INNER JOIN artists ON Artists_id_fk=artists.idArtists ";
        String sql = "SELECT "+Columns+" FROM Stock"+Join1+Join2+"WHERE Name= "+Artist_name_fk;
        List<Stock> StockList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setIdStock(resultSet.getInt(1));
                stock.setQuantity(resultSet.getInt(2));
                stock.setAlbum_id_fk(resultSet.getInt(3));
                stock.setStore_id_fk(resultSet.getInt(4));
                StockList.add(stock);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, READ (getByArtistName) method");
            e.printStackTrace();
        }
        return StockList;
    }

    @Override
    public Stock getStockById(int idStock) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Stock WHERE idStock= "+idStock;
        Stock stock = new Stock();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                stock.setIdStock(resultSet.getInt(1));
                stock.setQuantity(resultSet.getInt(2));
                stock.setAlbum_id_fk(resultSet.getInt(3));
                stock.setStore_id_fk(resultSet.getInt(4));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, READ (getByStockId) method");
            e.printStackTrace();
        }
        return stock;
    }

    @Override
    public boolean update(Stock stock) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Stock SET Quantity= "+ stock.getQuantity()+", Albums_id_fk= "+stock.getAlbum_id_fk()+", Store_id_fk= "+stock.getStore_id_fk();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Stock stock) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Stock WHERE idStock= "+stock.getIdStock();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error StockDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
