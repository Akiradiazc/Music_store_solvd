package Controller;

import DAO.ClientsDAOImpl;
import iDao_interfaces.IClientsDAO;
import Model.Clients;
import Views.ViewClients;

import java.util.ArrayList;
import java.util.List;

public class ClientsController {
    private ViewClients view = new ViewClients();

    //Default constructor
    public ClientsController(){}

    // DAO to create client
    public void create(Clients clients){
        IClientsDAO dao = new ClientsDAOImpl();
        dao.create(clients);
    }

    // DAO to read clients
    public void readClients(){
        List<Clients> clientsList = new ArrayList<>();
        IClientsDAO dao = new ClientsDAOImpl();
        clientsList = dao.read();
        view.viewClients(clientsList);
    }

    // DAO to update client
    public void update(Clients clients){
        IClientsDAO dao = new ClientsDAOImpl();
        dao.update(clients);
    }

    // DAO to delete client
    public void delete(Clients clients){
        IClientsDAO dao = new ClientsDAOImpl();
        dao.delete(clients);
    }
}
