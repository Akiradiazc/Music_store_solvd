package Model;

import java.util.Date;

public class Clients {

    private int idClients;
    private String First_name;
    private String Last_name;
    private String Address;
    private Date Birthdate;

    public Clients(){}

    public Clients(String First_name, String Last_name, String Address, Date Birthdate){
        this.idClients = idClients;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Address = Address;
        this.Birthdate = Birthdate;
    }

    public int getIdClients() {
        return idClients;
    }

    public void setIdClients(int idClients) {
        this.idClients = idClients;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idClients=" + idClients +
                ", First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", Address='" + Address + '\'' +
                ", Birthdate=" + Birthdate +
                '}';
    }
}
