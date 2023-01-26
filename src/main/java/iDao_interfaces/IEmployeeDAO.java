package iDao_interfaces;
import Model.Clients;
import Model.Employee;
import java.util.List;

public interface IEmployeeDAO {
    // ------ CREATE -------------
    boolean create (Employee employee);

    // ------ READ -------------
    List<Employee> getAllEmployees();
    List<Employee> getEmployeeByStoreId(int Store_id_fk);
    Employee getEmployeeById(int idEmployee);

    // ------ UPDATE -------------
    boolean update(Employee employee);

    // ------ DELETE -------------
    boolean delete(Employee employee);
}
