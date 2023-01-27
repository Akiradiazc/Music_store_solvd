package Controller;

import DAO.Paying_methodDAOImpl;
import Model.Paying_method;
import Views.ViewPaying_Method;
import iDao_interfaces.IPaying_methodDAO;

import java.util.ArrayList;
import java.util.List;

public class Paying_methodController {

    private ViewPaying_Method view = new ViewPaying_Method();

    public Paying_methodController(){}

    // --------- DAO to CREATE Country
    public void create(Paying_method payingMethod){
        IPaying_methodDAO dao = new Paying_methodDAOImpl();
        dao.create(payingMethod);
    }

    // --------- DAO to READ country
    public List<Paying_method> getAllPayingMethodsList(){
        List<Paying_method> PayingMethodsList = new ArrayList<>();
        IPaying_methodDAO dao = new Paying_methodDAOImpl();
        PayingMethodsList = dao.getAllPayingMethods();
        view.ViewPaying_methods(PayingMethodsList);
        return PayingMethodsList;
    }

    public Paying_method getPayingMethodById(int idPayingMethod){
        Paying_method payingMethodById = new Paying_method();
        IPaying_methodDAO dao = new Paying_methodDAOImpl();
        payingMethodById = dao.getPayingMethodById(idPayingMethod);
        view.ViewPaying_methods(payingMethodById);
        return payingMethodById;
    }

    // --------- DAO to UPDATE employee
    public void update(Paying_method payingMethod){
        IPaying_methodDAO dao = new Paying_methodDAOImpl();
        dao.update(payingMethod);
    }

    // --------- DAO to DELETE employee
    public void delete(Paying_method payingMethod){
        IPaying_methodDAO dao = new Paying_methodDAOImpl();
        dao.delete(payingMethod);
    }
}
