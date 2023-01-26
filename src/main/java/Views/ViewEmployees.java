package Views;
import Model.Employee;
import java.util.List;
public class ViewEmployees {
    public void ViewEmployee(Employee employee){
        System.out.println("Employee info: "+employee);
    }
    public void ViewEmployeeList(List<Employee> EmployeeList){
        for(Employee employee: EmployeeList){
            System.out.println("Employee info: "+employee);
        }
    }
}
