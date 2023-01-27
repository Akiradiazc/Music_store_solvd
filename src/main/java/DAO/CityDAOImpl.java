package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Model.City;
import iDao_interfaces.ICityDAO;

public class CityDAOImpl implements ICityDAO {
    @Override
    public boolean create(City city) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String countrySelect = "(SELECT idCountry FROM Country WHERE Country_name = '"+city.getCountry_name_fk()+"')";
        String sql = "INSERT INTO City(City_name, Country_id_fk) VALUES ('"+ city.getCity_name()+"',"+countrySelect+")";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: CityDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<City> getAllCites() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM City ORDER BY idCity";
        List<City> CityList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                City city = new City();
                city.setIdCity(resultSet.getInt(1));
                city.setCity_name(resultSet.getString(2));
                city.setCountry_id_fk(resultSet.getInt(3));
                CityList.add(city);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error CityDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return CityList;
    }

    @Override
    public List<City> getCitesByCountry(String Country_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String elementsToShow = "City.idCity, City.City_name, City.Country_id_fk";
        String sql = "SELECT "+ elementsToShow +" FROM City INNER JOIN Country ON City.Country_id_fk = Country.idCountry WHERE Country_name = '"+Country_name_fk+"';";
        List<City> CityList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                City city = new City();
                city.setIdCity(resultSet.getInt(1));
                city.setCity_name(resultSet.getString(2));
                CityList.add(city);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error CityDaoImpl class, READ (getByCountryName) method");
            e.printStackTrace();
        }
        return CityList;
    }

    @Override
    public City getCityById(int idCity) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM City WHERE idCity = "+ idCity;
        City cityById = new City();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                cityById.setIdCity(resultSet.getInt(1));
                cityById.setCity_name(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error CityDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return cityById;
    }

    @Override
    public boolean update(City city) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE City SET City_name='"+city.getCity_name()+"' WHERE idCity= "+city.getIdCity();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error CityDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(City city) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM City WHERE idCity= "+city.getIdCity();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error CityDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
