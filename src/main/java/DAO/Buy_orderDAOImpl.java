package DAO;

import Model.Album;
import Model.Buy_order;
import iDao_interfaces.IBuy_orderDAO;

import java.sql.Connection;
import Connection.ConnectionClass;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Buy_orderDAOImpl implements IBuy_orderDAO {
    @Override
    public boolean create(Buy_order buy_order) {
        boolean create = false;
        //Sql
        Statement statement = null;
        Connection connection = null;

        String columnNames = "(Albums_id_fk, Quantity, Store_id_fk)";
        String AlbumSelect = "(SELECT idAlbum FROM Albums WHERE Album_name= '" + buy_order.getAlbum_name_fk() + "')";
        String sql = "INSERT INTO Buy_order " + columnNames + " VALUES (" + AlbumSelect + "," + buy_order.getQuantity() + "," + buy_order.getStore_id_fk() + ")";
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create = true;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Buy_orderDaoImpl class, CREATE method");
            e.printStackTrace();
        }

        return create;
    }

    @Override
    public List<Buy_order> getAllBuyOrders() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Buy_order ORDER BY idBuy_order";
        List<Buy_order> BuyOrderList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Buy_order buy_order = new Buy_order();
                buy_order.setIdBuy_order(resultSet.getInt(1));
                buy_order.setAlbum_id_fk(resultSet.getInt(2));
                buy_order.setQuantity(resultSet.getInt(3));
                buy_order.setStore_id_fk(resultSet.getInt(4));
                BuyOrderList.add(buy_order);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return BuyOrderList;
    }

    @Override
    public List<Buy_order> getBuyOrderByAlbumId(String album_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String join = "Buy_order INNER JOIN albums ON Buy_order.Albums_id_fk = albums.idAlbum";
        String Columns ="idBuy_order, Albums_id_fk, Quantity, Store_id_fk";
        String sql = "SELECT "+ Columns+ " FROM "+join+" WHERE Album_name= '"+album_name_fk+"'";
        List<Buy_order> BuyOrderList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Buy_order buy_order = new Buy_order();
                buy_order.setIdBuy_order(resultSet.getInt(1));
                buy_order.setAlbum_id_fk(resultSet.getInt(2));
                buy_order.setQuantity(resultSet.getInt(3));
                buy_order.setStore_id_fk(resultSet.getInt(4));
                BuyOrderList.add(buy_order);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, READ (getByAlbumId) method");
            e.printStackTrace();
        }
        return BuyOrderList;
    }

    @Override
    public List<Buy_order> getBuyOrdersByStoreId(int Store_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String Columns ="idBuy_order, Albums_id_fk, Quantity, Store_id_fk";
        String sql = "SELECT "+ Columns+ " FROM Buy_order WHERE Store_id_fk= '"+Store_id_fk;
        List<Buy_order> BuyOrderList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Buy_order buy_order = new Buy_order();
                buy_order.setIdBuy_order(resultSet.getInt(1));
                buy_order.setAlbum_id_fk(resultSet.getInt(2));
                buy_order.setQuantity(resultSet.getInt(3));
                buy_order.setStore_id_fk(resultSet.getInt(4));
                BuyOrderList.add(buy_order);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, READ (getByStoreId) method");
            e.printStackTrace();
        }
        return BuyOrderList;
    }

    @Override
    public Buy_order getBuyOrderById(int idBuy_order) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Buy_order WHERE idBuy_order= "+idBuy_order;
        Buy_order buy_order = new Buy_order();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                buy_order.setIdBuy_order(resultSet.getInt(1));
                buy_order.setAlbum_id_fk(resultSet.getInt(2));
                buy_order.setQuantity(resultSet.getInt(3));
                buy_order.setStore_id_fk(resultSet.getInt(4));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, READ (getByAlbumId) method");
            e.printStackTrace();
        }
        return buy_order;
    }

    @Override
    public boolean update(Buy_order buy_order) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Buy_order SET Albums_id_fk= '"+ buy_order.getAlbum_id_fk()+"', Quantity= "+buy_order.getQuantity()+", Store_id_fk= "+buy_order.getStore_id_fk();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Buy_order buy_order) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Buy_order WHERE idBuy_order= '"+ buy_order.getIdBuy_order()+";";
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
