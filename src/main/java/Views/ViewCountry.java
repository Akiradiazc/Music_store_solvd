package Views;

import Model.Country;

import java.util.List;

public class ViewCountry {
    public void ViewCountries(Country country){
        System.out.println("Country Info: "+country);
    }
    public void ViewCountries(List<Country> countryList){
        for (Country country : countryList){
            System.out.println("Country Info: "+country);
        }
    }
}
