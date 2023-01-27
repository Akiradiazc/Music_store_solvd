package Controller;

import DAO.CountryDAOImpl;
import iDao_interfaces.ICountryDAO;
import Model.Country;
import Views.ViewCountry;

import java.util.ArrayList;
import java.util.List;

public class CountryController {

    private ViewCountry view = new ViewCountry();

    public CountryController(){}

    // --------- DAO to CREATE Country
    public void create(Country country){
        ICountryDAO dao = new CountryDAOImpl();
        dao.create(country);
    }

    // --------- DAO to READ country
    public List<Country> getAllCountriesList(){
        List<Country> CountriesList = new ArrayList<>();
        ICountryDAO dao = new CountryDAOImpl();
        CountriesList = dao.getAllCountries();
        view.ViewCountries(CountriesList);
        return CountriesList;
    }

    public Country getCountryById(int idCountry){
        Country countryById = new Country();
        ICountryDAO dao = new CountryDAOImpl();
        countryById = dao.getCountryById(idCountry);
        view.ViewCountries(countryById);
        return countryById;
    }

    // --------- DAO to UPDATE employee
    public void update(Country country){
        ICountryDAO dao = new CountryDAOImpl();
        dao.update(country);
    }

    // --------- DAO to DELETE employee
    public void delete(Country country){
        ICountryDAO dao = new CountryDAOImpl();
        dao.delete(country);
    }
}
