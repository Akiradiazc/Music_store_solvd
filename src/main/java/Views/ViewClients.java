package Views;

import Model.Clients;

import java.util.List;

public class ViewClients {
    public void viewClients(Clients clients){
        System.out.println("Client Info: "+clients);
    }
    public void viewClients(List<Clients> clientsList){
        for (Clients clients : clientsList){
            System.out.println("Client Info: " + clients);
        }
    }
}
