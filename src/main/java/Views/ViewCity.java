package Views;
import Model.City;

import java.util.List;

public class ViewCity {
    public void ViewCities(City city){
        System.out.println("City info: "+ city);
    }
    public void ViewCities(List<City> CitiesList){
        for(City city : CitiesList){
            System.out.println(city);
        }
    }
}
