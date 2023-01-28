package Model;

public class Album {
    private int idAlbum;
    private String Album_name;
    private int Year_released;
    private float Price;
    private int Artists_id_fk;
    private String Artists_name_fk;
    private int Genre_id_fk;
    private String Genre_name_fk;
    private int Languages_id_fk;
    private String Languages_name_fk;

    public Album(){}
    public Album(String Album_name, int Year_released, float Price, int Artists_id_fk, int Genre_id_fk, int Languages_id_fk){
        this.idAlbum = idAlbum;
        this.Album_name = Album_name;
        this.Year_released = Year_released;
        this.Price = Price;
        this.Artists_id_fk = Artists_id_fk;
        this.Genre_id_fk = Genre_id_fk;
        this.Languages_id_fk = Languages_id_fk;
    }
    public Album(String Album_name, int Year_released, float Price, String Artists_name_fk, String Genre_name_fk, String Languages_name_fk){
        this.idAlbum = idAlbum;
        this.Album_name = Album_name;
        this.Year_released = Year_released;
        this.Price = Price;
        this.Artists_name_fk = Artists_name_fk;
        this.Genre_name_fk = Genre_name_fk;
        this.Languages_name_fk = Languages_name_fk;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getAlbum_name() {
        return Album_name;
    }

    public void setAlbum_name(String album_name) {
        Album_name = album_name;
    }

    public int getYear_released() {
        return Year_released;
    }

    public void setYear_released(int year_released) {
        Year_released = year_released;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getArtists_id_fk() {
        return Artists_id_fk;
    }

    public void setArtists_id_fk(int artists_id_fk) {
        Artists_id_fk = artists_id_fk;
    }

    public String getArtists_name_fk() {
        return Artists_name_fk;
    }

    public void setArtists_name_fk(String artists_name_fk) {
        Artists_name_fk = artists_name_fk;
    }

    public int getGenre_id_fk() {
        return Genre_id_fk;
    }

    public void setGenre_id_fk(int genre_id_fk) {
        Genre_id_fk = genre_id_fk;
    }

    public String getGenre_name_fk() {
        return Genre_name_fk;
    }

    public void setGenre_name_fk(String genre_name_fk) {
        Genre_name_fk = genre_name_fk;
    }

    public int getLanguages_id_fk() {
        return Languages_id_fk;
    }

    public void setLanguages_id_fk(int languages_id_fk) {
        Languages_id_fk = languages_id_fk;
    }

    public String getLanguages_name_fk() {
        return Languages_name_fk;
    }

    public void setLanguages_name_fk(String languages_name_fk) {
        Languages_name_fk = languages_name_fk;
    }

    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", Album_name='" + Album_name + '\'' +
                ", Year_released=" + Year_released +
                ", Price=" + Price +
                ", Artists_id_fk=" + Artists_id_fk +
                ", Genre_id_fk=" + Genre_id_fk +
                ", Languages_id_fk=" + Languages_id_fk +
                '}';
    }
}
