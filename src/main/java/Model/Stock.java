package Model;

public class Stock {
    private int idStock;
    private int Quantity;
    private int Album_id_fk;
    private int Store_id_fk;
    private String Album_name_fk;

    public Stock(){}
    public Stock(int Quantity, int Album_id_fk, int Store_id_fk){
        this.idStock = idStock;
        this.Quantity = Quantity;
        this.Album_id_fk = Album_id_fk;
        this.Store_id_fk = Store_id_fk;
    }
    public Stock(int Quantity, String Album_name_fk, int Store_id_fk){
        this.idStock = idStock;
        this.Quantity = Quantity;
        this.Album_name_fk = Album_name_fk;
        this.Store_id_fk = Store_id_fk;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getAlbum_id_fk() {
        return Album_id_fk;
    }

    public void setAlbum_id_fk(int album_id_fk) {
        Album_id_fk = album_id_fk;
    }

    public int getStore_id_fk() {
        return Store_id_fk;
    }

    public void setStore_id_fk(int store_id_fk) {
        Store_id_fk = store_id_fk;
    }

    public String getAlbum_name_fk() {
        return Album_name_fk;
    }

    public void setAlbum_name_fk(String album_name_fk) {
        Album_name_fk = album_name_fk;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "idStock=" + idStock +
                ", Quantity=" + Quantity +
                ", Album_id_fk=" + Album_id_fk +
                ", Store_id_fk=" + Store_id_fk +
                '}';
    }
}
