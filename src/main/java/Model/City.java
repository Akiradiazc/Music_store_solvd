package Model;

public class City {
    private int idCity;
    private String City_name;
    private int Country_id_fk;
    private String Country_name_fk;

    public City(){}

    public City(String City_name, int Country_id_fk){
        this.idCity = idCity;
        this.City_name = City_name;
        this.Country_id_fk = Country_id_fk;
    }
    public City(String City_name, String Country_name_fk){
        this.idCity = idCity;
        this.City_name = City_name;
        this.Country_name_fk = Country_name_fk;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCity_name() {
        return City_name;
    }

    public void setCity_name(String city_name) {
        City_name = city_name;
    }

    public int getCountry_id_fk() {
        return Country_id_fk;
    }

    public void setCountry_id_fk(int country_id_fk) {
        Country_id_fk = country_id_fk;
    }

    public String getCountry_name_fk() {
        return Country_name_fk;
    }

    public void setCountry_name_fk(String country_name_fk) {
        Country_name_fk = country_name_fk;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", City_name='" + City_name + '\'' +
                ", Country_id_fk=" + Country_id_fk +
                '}';
    }
}
