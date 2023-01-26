package Demo;

import Controller.EmployeesController;
import Model.Employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CRUD_employee_demo {
    public static void main(String[] args) {

        // ----- CONTROLLER
        EmployeesController employeesController = new EmployeesController();

        //-------- CREATE an employee
        //      Create a new employee to put in DB || Through get/set or constructor
        //Employee employeeCreate = new Employee();
        Employee employeeCreate = new Employee("Drake", "Bell", "Long Street 23", Date.valueOf("1990-10-20"), 1);
        //      Puts Created Employee into the DB
        employeesController.create(employeeCreate);

        //-------- READ employees
        //      Prints all employees in DB and assigns them to a EmployeesList
        // List<Employee> EmployeesListDB = employeesController.getAllEmployeesList();
        //      Prints all employees in a Store and assigns them to a EmployeesListStore
        // List<Employee> EmployeesListStoreDB = employeesController.getEmployeesListByStoreId(1);
        //      Prints an employee in DB by their EmployeeId
        // employeesController.getEmployeeById(2);

        //-------- UPDATE employees
        //      Update an employee from database
        //      Assign the employee to modify after selecting it
        //Employee employeeUpdate = employeesController.getEmployeeById(2);
        //      Modifications to perform
        //employeeUpdate.setLast_name("Bell");
        //      Updating employee
        //employeesController.update(employeeUpdate);

        //-------- DELETE employees
        //      Delete an employee from database
        //      Assign the employee to delete after selecting it
        //Employee employeeDelete = employeesController.getEmployeeById(2);
        //      Deleting employee
        //employeesController.delete(employeeDelete);

    }
}
