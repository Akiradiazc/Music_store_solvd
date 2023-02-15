package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {
    private int idCountry;
    private String Country_name;

    public Country(){}

    public Country(String Country_name){
        this.idCountry = idCountry;
        this.Country_name = Country_name;
    }
    public Country(int idCountry, String Country_name){
        this.idCountry = idCountry;
        this.Country_name = Country_name;
    }


    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountry_name() {
        return Country_name;
    }

    public void setCountry_name(String country_name) {
        Country_name = country_name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", Country_name='" + Country_name + '\'' +
                '}';
    }
}
