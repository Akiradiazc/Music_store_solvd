package iDao_interfaces;

import Model.Clients;

import java.util.List;

public interface IClientsDAO {

    public boolean create (Clients clients);
    public List<Clients> read();
    public boolean update(Clients clients);
    public boolean delete(Clients clients);

}
