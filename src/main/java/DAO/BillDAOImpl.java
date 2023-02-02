package DAO;

import Model.Bill;
import Model.Stock;
import Model.Store;
import iDao_interfaces.IBillDAO;
import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BillDAOImpl implements IBillDAO {
    @Override
    public boolean create(Bill bill) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;

        String columnNames = "(Date, Buy_order_id_fk, Clients_id_fk, Store_id_fk, Employees_id_fk, Paying_method_id_fk)";
        String PayingMethodSelect = "(SELECT idPaying_method FROM Paying_method WHERE Paying_method_name= )"+bill.getPaying_method_name_fk();

        String sql = "INSERT INTO Stock " + columnNames + " VALUES ("+ bill.getDate() +", "+bill.getBuy_order_id_fk() +
                ", "+bill.getClients_id_fk() +", "+bill.getStore_id_fk() +", "+
                bill.getEmployees_id_fk() +", "+
                PayingMethodSelect +")";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: BillDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Bill> getAllBill() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill ORDER BY idBill";
        List<Bill> BillList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
                BillList.add(bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return BillList;
    }

    @Override
    public List<Bill> getBillByDate(Date date) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill WHERE Date= "+date;
        List<Bill> BillList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
                BillList.add(bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, READ (getByDate) method");
            e.printStackTrace();
        }
        return BillList;
    }

    @Override
    public List<Bill> getBillByClient(int Client_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill WHERE Clients_id_fk= "+Client_id_fk;
        List<Bill> BillList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
                BillList.add(bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, READ (getByClient) method");
            e.printStackTrace();
        }
        return BillList;
    }

    @Override
    public List<Bill> getBillByStore(int Store_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill WHERE Store_id_fk= "+ Store_id_fk;
        List<Bill> BillList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
                BillList.add(bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, READ (getByStore) method");
            e.printStackTrace();
        }
        return BillList;
    }

    @Override
    public List<Bill> getBillByEmployee(int Employee_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill WHERE Employees_id_fk= "+ Employee_id_fk;
        List<Bill> BillList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
                BillList.add(bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, READ (getByEmployee) method");
            e.printStackTrace();
        }
        return BillList;
    }

    @Override
    public List<Bill> getBillByPayingMethod(String PayingMethod_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String Join = "INNER JOIN paying_method ON Bill.Paying_method_id_fk=Paying_method.idPaying_method";
        String columnNames = "idBill, Date, Buy_order_id_fk, Clients_id_fk, Store_id_fk, Employees_id_fk, Paying_method_id_fk";
        String sql = "SELECT "+columnNames+" FROM Bill "+Join+" WHERE Paying_method_name= "+ PayingMethod_name_fk;
        List<Bill> BillList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
                BillList.add(bill);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, READ (getByPayingMethod) method");
            e.printStackTrace();
        }
        return BillList;
    }

    @Override
    public Bill getBillById(int idBill) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill WHERE idBill= "+idBill;
        Bill bill = new Bill();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, READ (getByBillId) method");
            e.printStackTrace();
        }
        return bill;
    }

    @Override
    public Bill getBillByBuyOrder(int Buy_order_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Bill WHERE Buy_order_id_fk= "+Buy_order_id_fk;
        Bill bill = new Bill();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                bill.setIdBill(resultSet.getInt(1));
                bill.setDate(resultSet.getDate(2));
                bill.setBuy_order_id_fk(resultSet.getInt(3));
                bill.setClients_id_fk(resultSet.getInt(4));
                bill.setStore_id_fk(resultSet.getInt(5));
                bill.setEmployees_id_fk(resultSet.getInt(6));
                bill.setPaying_method_id_fk(resultSet.getInt(7));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error BuyOrderDaoImpl class, READ (getByBuyOrderId) method");
            e.printStackTrace();
        }
        return bill;
    }

    @Override
    public boolean update(Bill bill) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Bill SET Date= "+ bill.getDate()+", Buy_order_id_fk= "+bill.getBuy_order_id_fk()+
                ", Clients_id_fk= "+bill.getClients_id_fk()+
                ", Store_id_fk= "+bill.getStore_id_fk()+
                ", Employees_id_fk= "+bill.getEmployees_id_fk()+
                ", Paying_method_id_fk= "+bill.getPaying_method_id_fk();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Bill bill) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Bill WHERE idBill= "+bill.getIdBill();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error BillDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
