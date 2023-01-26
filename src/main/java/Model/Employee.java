package Model;

import java.util.Date;

public class Employee {
    private int idEmployees;
    private String First_name;
    private String Last_name;
    private String Address;
    private Date Birthdate;
    private String City_Store_id_fk;
    private int Store_id_fk;

    public Employee(){}
    public Employee(String First_name, String Last_name, String Address, Date Birthdate, String City_Store_id_fk){
        this.idEmployees = idEmployees;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Address = Address;
        this.Birthdate = Birthdate;
        this.City_Store_id_fk = City_Store_id_fk;
    }
    public Employee(String First_name, String Last_name, String Address, Date Birthdate, int Store_id_fk){
        this.idEmployees = idEmployees;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Address = Address;
        this.Birthdate = Birthdate;
        this.Store_id_fk = Store_id_fk;
    }

    public int getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(int idEmployees) {
        this.idEmployees = idEmployees;
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

    public String getCity_Store_id_fk() {
        return City_Store_id_fk;
    }

    public void setCity_Store_id_fk(String city_Store_id_fk) {
        City_Store_id_fk = city_Store_id_fk;
    }

    public int getStore_id_fk() {
        return Store_id_fk;
    }

    public void setStore_id_fk(int store_id_fk) {
        Store_id_fk = store_id_fk;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployees=" + idEmployees +
                ", First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", Address='" + Address + '\'' +
                ", Birthdate=" + Birthdate +
                ", Store_id_fk=" + Store_id_fk +
                '}';
    }
}
