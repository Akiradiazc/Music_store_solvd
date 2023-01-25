package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Model.Clients;
import iDao_interfaces.IClientsDAO;

public class ClientsDAOImpl implements IClientsDAO{

    @Override
    public boolean create(Clients clients) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;

        String sql = "INSERT INTO Clients (First_name, Last_name, Address, Birthdate) VALUES ('"+clients.getFirst_name()+"','"+clients.getLast_name()+"','"+clients.getAddress()+"','"+clients.getBirthdate()+"')";

        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: ClientsDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Clients> read() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Clients ORDER BY idClients";

        List<Clients> ClientsList = new ArrayList<>();

        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Clients client = new Clients();
                client.setIdClients(resultSet.getInt(1));
                client.setFirst_name(resultSet.getString(2));
                client.setLast_name(resultSet.getString(3));
                client.setAddress(resultSet.getString(4));
                client.setBirthdate(resultSet.getDate(5));
                ClientsList.add(client);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error ClientDaoImpl class, READ method");
            e.printStackTrace();
        }
        return ClientsList;
    }

    @Override
    public boolean update(Clients clients) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Clients SET First_name='"+clients.getFirst_name()+"', Last_name='"+clients.getLast_name()+"', Address='"+clients.getAddress()+"', Birthdate='"+clients.getBirthdate()+"' WHERE IdClients = "+clients.getIdClients();

        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error ClientDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Clients clients) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Clients WHERE idClients = "+clients.getIdClients();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        }catch(SQLException e){
            System.out.println("Error ClientDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
