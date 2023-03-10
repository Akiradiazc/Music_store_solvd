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
    public List<Clients> readClients(){
        List<Clients> clientsList = new ArrayList<>();
        IClientsDAO dao = new ClientsDAOImpl();
        clientsList = dao.read();
        view.viewClients(clientsList);
        return clientsList;
    }

    public Clients getClientById(int idClients){
        Clients clientById = new Clients();
        IClientsDAO dao = new ClientsDAOImpl();
        clientById = dao.getClientById(idClients);
        view.viewClients(clientById);
        return clientById;
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
