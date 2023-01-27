package iDao_interfaces;

import Model.Country;

import java.util.List;

public interface ICountryDAO {
    // ------ CREATE
    boolean create(Country country);

    // ------ READ
    List<Country> getAllCountries();
    Country getCountryById(int idCountry);

    // ------ UPDATE
    boolean update(Country country);

    // ------ DELETE
    boolean delete(Country country);

}
