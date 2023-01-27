package iDao_interfaces;

import Model.Paying_method;

import java.util.List;

public interface IPaying_methodDAO {
    // ------ CREATE
    boolean create(Paying_method paying_method);

    // ------ READ
    List<Paying_method> getAllPayingMethods();
    Paying_method getPayingMethodById(int idPaying_method);

    // ------ UPDATE
    boolean update(Paying_method paying_method);

    // ------ DELETE
    boolean delete(Paying_method paying_method);
}
