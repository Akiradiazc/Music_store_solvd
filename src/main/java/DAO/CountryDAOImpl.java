package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Model.Country;
import iDao_interfaces.ICountryDAO;

public class CountryDAOImpl implements ICountryDAO {
// ------------- CREATE ----------------
    @Override
    public boolean create(Country country) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String sql = "INSERT INTO Country(Country_name) VALUES ('"+ country.getCountry_name()+"')";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: CountryDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    // ------------- READ ----------------
    @Override
    public List<Country> getAllCountries() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Country ORDER BY idCountry";
        List<Country> CountryList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Country country = new Country();
                country.setIdCountry(resultSet.getInt(1));
                country.setCountry_name(resultSet.getString(2));
                CountryList.add(country);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error CountryDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return CountryList;
    }

    @Override
    public Country getCountryById(int idCountry) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Country WHERE idCountry = "+ idCountry;
        Country countryById = new Country();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                countryById.setIdCountry(resultSet.getInt(1));
                countryById.setCountry_name(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error CountryDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return countryById;
    }
    // ------------- UPDATE ----------------
    @Override
    public boolean update(Country country) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Country SET Country_name='"+country.getCountry_name()+"' WHERE idCountry= "+country.getIdCountry();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error CountryDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }
    // ------------- DELETE ----------------
    @Override
    public boolean delete(Country country) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Country WHERE idCountry= "+country.getIdCountry();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error CountryDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
