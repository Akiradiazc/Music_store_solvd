package Demo;

import Controller.ClientsController;
import Model.Clients;

import java.sql.Date;

public class CRUD_demo {
    public static void main(String[] args){
        Clients client1 = new Clients("Fernanda", "Jacobo", "Street 145", Date.valueOf("1999-03-09"));

        //Controller
        ClientsController controller = new ClientsController();

        //CREATE a client
        controller.create(client1);
/*
        //READ clients
        controller.readClients();

        //UPDATE client
        client1.setAddress("Street 896");
        controller.update(client1);

        //DELETE client
  */
    }
}
