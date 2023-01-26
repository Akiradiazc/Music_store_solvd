package Controller;

import DAO.EmployeeDAOImpl;
import Model.Employee;

import java.util.ArrayList;
import java.util.List;
import Views.ViewEmployees;
import iDao_interfaces.IEmployeeDAO;

public class EmployeesController {
    private ViewEmployees view = new ViewEmployees();
    public EmployeesController(){}

    // --------- DAO to CREATE employee
    public void create(Employee employee){
        IEmployeeDAO dao = new EmployeeDAOImpl();
        dao.create(employee);
    }

    // --------- DAO to READ employee
    public List<Employee> getAllEmployeesList(){
        List<Employee> EmployeesList = new ArrayList<>();
        IEmployeeDAO dao = new EmployeeDAOImpl();
        EmployeesList = dao.getAllEmployees();
        view.ViewEmployeeList(EmployeesList);
        return EmployeesList;
    }
    public List<Employee> getEmployeesListByStoreId(int Store_id_fk){
        List<Employee> EmployeesList = new ArrayList<>();
        IEmployeeDAO dao = new EmployeeDAOImpl();
        EmployeesList = dao.getEmployeeByStoreId(Store_id_fk);
        view.ViewEmployeeList(EmployeesList);
        return EmployeesList;
    }
    public Employee getEmployeeById(int idEmployees){
        Employee employeeById = new Employee();
        IEmployeeDAO dao = new EmployeeDAOImpl();
        employeeById = dao.getEmployeeById(idEmployees);
        view.ViewEmployee(employeeById);
        return employeeById;

    }

    // --------- DAO to UPDATE employee
    public void update(Employee employee){
        IEmployeeDAO dao = new EmployeeDAOImpl();
        dao.update(employee);
    }

    // --------- DAO to DELETE employee
    public void delete(Employee employee){
        IEmployeeDAO dao = new EmployeeDAOImpl();
        dao.delete(employee);
    }
}
