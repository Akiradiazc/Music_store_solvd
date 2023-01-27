package Model;

public class Artist {
    private int idArtists;
    private String name;
    private int Country_id_fk;
    private String Country_name_fk;

    public Artist(){}

    public Artist(String name, int Country_id_fk){
        this.idArtists = idArtists;
        this.name = name;
        this.Country_id_fk = Country_id_fk;
    }
    public Artist(String name, String Country_name_fk){
        this.idArtists = idArtists;
        this.name = name;
        this.Country_name_fk = Country_name_fk;
    }

    public int getIdArtists() {
        return idArtists;
    }

    public void setIdArtists(int idArtists) {
        this.idArtists = idArtists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Artist{" +
                "idArtists=" + idArtists +
                ", name='" + name + '\'' +
                ", Country_id_fk=" + Country_id_fk +
                '}';
    }
}
