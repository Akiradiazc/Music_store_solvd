package Model;

import java.util.Date;

public class Bill {
    private int idBill;
    private Date date;
    private int buy_order_id_fk;
    private int Clients_id_fk;
    private int Store_id_fk;
    private int Employees_id_fk;
    private int Paying_method_id_fk;
    private String Paying_method_name_fk;

    public Bill(){}

    public Bill(Date date, int buy_order_id_fk, int clients_id_fk, int store_id_fk, int employees_id_fk, int paying_method_id_fk) {
        this.idBill = idBill;
        this.date = date;
        this.buy_order_id_fk = buy_order_id_fk;
        Clients_id_fk = clients_id_fk;
        Store_id_fk = store_id_fk;
        Employees_id_fk = employees_id_fk;
        Paying_method_id_fk = paying_method_id_fk;
    }
    public Bill(Date date, int buy_order_id_fk, int clients_id_fk, int store_id_fk, int employees_id_fk, String paying_method_name_fk) {
        this.idBill = idBill;
        this.date = date;
        this.buy_order_id_fk = buy_order_id_fk;
        Clients_id_fk = clients_id_fk;
        Store_id_fk = store_id_fk;
        Employees_id_fk = employees_id_fk;
        Paying_method_name_fk = paying_method_name_fk;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBuy_order_id_fk() {
        return buy_order_id_fk;
    }

    public void setBuy_order_id_fk(int buy_order_id_fk) {
        this.buy_order_id_fk = buy_order_id_fk;
    }

    public int getClients_id_fk() {
        return Clients_id_fk;
    }

    public void setClients_id_fk(int clients_id_fk) {
        Clients_id_fk = clients_id_fk;
    }

    public int getStore_id_fk() {
        return Store_id_fk;
    }

    public void setStore_id_fk(int store_id_fk) {
        Store_id_fk = store_id_fk;
    }

    public int getEmployees_id_fk() {
        return Employees_id_fk;
    }

    public void setEmployees_id_fk(int employees_id_fk) {
        Employees_id_fk = employees_id_fk;
    }

    public int getPaying_method_id_fk() {
        return Paying_method_id_fk;
    }

    public void setPaying_method_id_fk(int paying_method_id_fk) {
        Paying_method_id_fk = paying_method_id_fk;
    }

    public String getPaying_method_name_fk() {
        return Paying_method_name_fk;
    }

    public void setPaying_method_name_fk(String paying_method_name_fk) {
        Paying_method_name_fk = paying_method_name_fk;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", date=" + date +
                ", buy_order_id_fk=" + buy_order_id_fk +
                ", Clients_id_fk=" + Clients_id_fk +
                ", Store_id_fk=" + Store_id_fk +
                ", Employees_id_fk=" + Employees_id_fk +
                ", Paying_method_id_fk=" + Paying_method_id_fk +
                '}';
    }
}
