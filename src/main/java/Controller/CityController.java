package Controller;

import DAO.CityDAOImpl;
import iDao_interfaces.ICityDAO;
import Model.City;
import Views.ViewCity;

import java.util.ArrayList;
import java.util.List;
public class CityController {

    private ViewCity view = new ViewCity();

    public CityController(){}

    // --------- DAO to CREATE Country
    public void create(City city){
        ICityDAO dao = new CityDAOImpl();
        dao.create(city);
    }

    // --------- DAO to READ country
    public List<City> getAllCitiesList(){
        List<City> CitiesList = new ArrayList<>();
        ICityDAO dao = new CityDAOImpl();
        CitiesList = dao.getAllCites();
        view.ViewCities(CitiesList);
        return CitiesList;
    }

    public List<City> getCitiesByCountry(String Country_name_fk){
        List<City> CitiesList = new ArrayList<>();
        ICityDAO dao = new CityDAOImpl();
        CitiesList = dao.getCitesByCountry(Country_name_fk);
        view.ViewCities(CitiesList);
        return CitiesList;
    }

    public City getCityById(int idCity){
        City cityById = new City();
        ICityDAO dao = new CityDAOImpl();
        cityById = dao.getCityById(idCity);
        view.ViewCities(cityById);
        return cityById;
    }

    // --------- DAO to UPDATE employee
    public void update(City city){
        ICityDAO dao = new CityDAOImpl();
        dao.update(city);
    }

    // --------- DAO to DELETE employee
    public void delete(City city){
        ICityDAO dao = new CityDAOImpl();
        dao.delete(city);
    }
}
