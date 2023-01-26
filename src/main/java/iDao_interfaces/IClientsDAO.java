package iDao_interfaces;

import Model.Clients;

import java.util.List;

public interface IClientsDAO {
    // ------ CREATE
    boolean create (Clients clients);
    // ------ READ
    List<Clients> read();
    Clients getClientById(int idClient);
    // ------ UPDATE
    boolean update(Clients clients);
    // ------ DELETE
    boolean delete(Clients clients);

}
