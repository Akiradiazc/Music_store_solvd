package Model;

import java.util.Date;

public class Employee {
    private int idEmployees;
    private String First_name;
    private String Last_name;
    private String Address;
    private Date Birthdate;
    private String Store_id_fk;

    Employee(){}
    Employee(String First_name, String Last_name, String Address, Date Birthdate){
        this.idEmployees = idEmployees;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Address = Address;
        this.Birthdate = Birthdate;
        this.Store_id_fk = Store_id_fk;
    }
}
