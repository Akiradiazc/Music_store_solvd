package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Model.Genre;
import Model.Paying_method;
import iDao_interfaces.IPaying_methodDAO;

public class Paying_methodDAOImpl implements IPaying_methodDAO {
    @Override
    public boolean create(Paying_method paying_method) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String sql = "INSERT INTO Paying_method(Paying_method_name) VALUES ('"+ paying_method.getPaying_method_name()+"')";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: Paying_methodDAOImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Paying_method> getAllPayingMethods() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Paying_method ORDER BY idPaying_method";
        List<Paying_method> Paying_methodList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Paying_method payingMethod = new Paying_method();
                payingMethod.setIdPaying_method(resultSet.getInt(1));
                payingMethod.setPaying_method_name(resultSet.getString(2));
                Paying_methodList.add(payingMethod);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error Paying_methodDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return Paying_methodList;
    }

    @Override
    public Paying_method getPayingMethodById(int idPaying_method) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Paying_method WHERE idPaying_method = "+ idPaying_method;
        Paying_method payingMethodById = new Paying_method();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                payingMethodById.setIdPaying_method(resultSet.getInt(1));
                payingMethodById.setPaying_method_name(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error Paying_methodDAOImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return payingMethodById;
    }

    @Override
    public boolean update(Paying_method paying_method) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Paying_method SET Paying_method_name='"+paying_method.getPaying_method_name()+"' WHERE idPaying_method= "+paying_method.getIdPaying_method();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error Paying_methodDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Paying_method paying_method) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Paying_method WHERE idPaying_method= "+paying_method.getIdPaying_method();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error Paying_methodDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
