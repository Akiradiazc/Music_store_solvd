package Demo;

import Controller.ClientsController;
import Model.Clients;

import java.sql.Date;

public class CRUD_demo {
    public static void main(String[] args){
        Clients client1 = new Clients("Fernanda", "Jacobo", "Street 145", Date.valueOf("1999-03-09"));

        //Controller
        ClientsController controller = new ClientsController();

        String sql = "INSERT INTO Clients VALUES ('"+client1.getFirst_name()+"','"+client1.getLast_name()+"','"+client1.getAddress()+"','"+client1.getBirthdate()+"')";
        System.out.println(sql);
        /*
        //CREATE a client
        controller.create(client1);

        //READ clients
        controller.readClients();

        //UPDATE client
        client1.setAddress("Street 896");
        controller.update(client1);

        //DELETE client
  */
    }
}
