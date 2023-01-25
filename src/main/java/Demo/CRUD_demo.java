package Demo;

import Controller.ClientsController;
import Model.Clients;

import java.sql.Date;
import java.util.List;

public class CRUD_demo {
    public static void main(String[] args){

        //-------- CONTROLLER
        ClientsController controller = new ClientsController();

        //-------- CREATE a client
        // Create a new client to put in DB || Through get/set or constructor
        //Clients clientCreate = new Clients();
        Clients clientCreate = new Clients("Abel", "Tesfaye", "West Street 23", Date.valueOf("1992-02-16"));
        // Puts Created Client into the DB
        controller.create(clientCreate);

        //-------- READ clients
        // Prints all clients in DB and assigns them to a ClientsList
        List<Clients> ClientsListDB = controller.readClients();


        //-------- UPDATE client
        // Selecting a client to update through index of array (idClients-1)
        Clients clientUpdate = ClientsListDB.get(3);
        // Modifications to perform
        clientUpdate.setAddress("East Street 896");
        // Updating client
        controller.update(clientUpdate);

        //-------- DELETE client
        // Selecting a client to update through index of array (idClients-1)
        Clients clientDelete = ClientsListDB.get(3);
        // Deleting client
        controller.delete(clientDelete);


    }
}
