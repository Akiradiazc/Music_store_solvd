package iDao_interfaces;
import Model.City;

import java.util.List;

public interface ICityDAO {
    // ------ CREATE
    boolean create(City city);

    // ------ READ
    List<City> getAllCites();
    List<City> getCitesByCountry(String Country_name_fk);
    City getCityById(int idCity);

    // ------ UPDATE
    boolean update(City city);

    // ------ DELETE
    boolean delete(City city);
}
