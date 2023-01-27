package Model;

public class Store {
    private int idStore;
    private String Address;
    private int City_id_fk;
    private String City_name_fk;
    public Store(){}
    public Store(String Address, int City_id_fk){
        this.idStore = idStore;
        this.Address = Address;
        this.City_id_fk = City_id_fk;
    }
    public Store(String Address, String City_name_fk){
        this.idStore = idStore;
        this.Address = Address;
        this.City_name_fk = City_name_fk;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCity_id_fk() {
        return City_id_fk;
    }

    public void setCity_id_fk(int city_id_fk) {
        City_id_fk = city_id_fk;
    }

    public String getCity_name_fk() {
        return City_name_fk;
    }

    public void setCity_name_fk(String city_name_fk) {
        City_name_fk = city_name_fk;
    }

    @Override
    public String toString() {
        return "Store{" +
                "idStore=" + idStore +
                ", Address='" + Address + '\'' +
                ", City_id_fk=" + City_id_fk +
                '}';
    }
}
