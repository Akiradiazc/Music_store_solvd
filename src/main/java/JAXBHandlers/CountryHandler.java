package JAXBHandlers;

import Model.Country;
import Model.Languages;

import java.util.HashSet;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "Country")
public class CountryHandler {
    private Set<Country> CountryList = new HashSet<Country>();
    public Set<Country> getCountryList(){
        return CountryList;
    }

    @XmlElement(name="Country")
    public void setCountryList(Set<Country> CountryList){
        this.CountryList = CountryList;
    }
}
