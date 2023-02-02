package Model;

public class Buy_order {
    private int idBuy_order;
    private int Album_id_fk;
    private String Album_name_fk;
    private int Quantity;

    public Buy_order(){}
    public Buy_order(int Album_id_fk, int Quantity){
        this.idBuy_order = idBuy_order;
        this.Album_id_fk = Album_id_fk;
        this.Quantity = Quantity;
    }
    public Buy_order(String Album_name_fk, int Quantity){
        this.idBuy_order = idBuy_order;
        this.Album_name_fk = Album_name_fk;
        this.Quantity = Quantity;
    }

    public int getIdBuy_order() {
        return idBuy_order;
    }

    public void setIdBuy_order(int idBuy_order) {
        this.idBuy_order = idBuy_order;
    }

    public int getAlbum_id_fk() {
        return Album_id_fk;
    }

    public void setAlbum_id_fk(int album_id_fk) {
        Album_id_fk = album_id_fk;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getAlbum_name_fk() {
        return Album_name_fk;
    }

    public void setAlbum_name_fk(String album_name_fk) {
        Album_name_fk = album_name_fk;
    }

    @Override
    public String toString() {
        return "Buy_order{" +
                "idBuy_order=" + idBuy_order +
                ", Album_id_fk=" + Album_id_fk +
                ", Quantity=" + Quantity +
                '}';
    }
}
