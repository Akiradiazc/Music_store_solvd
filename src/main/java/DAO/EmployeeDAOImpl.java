package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Model.Employee;
import iDao_interfaces.IEmployeeDAO;

public class EmployeeDAOImpl implements IEmployeeDAO {

    @Override
    public boolean create(Employee employee) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;

        String sql = "INSERT INTO Employees (First_name, Last_name, Address, Birthdate, Store_id_fk) VALUES ('"+employee.getFirst_name()+"','"+employee.getLast_name()+"','"+employee.getAddress()+"','"+employee.getBirthdate()+"','"+employee.getStore_id_fk()+"')";

        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: EmployeesDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Employee> getAllEmployees() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Employees ORDER BY idEmployees";

        List<Employee> EmployeesList = new ArrayList<>();

        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setIdEmployees(resultSet.getInt(1));
                employee.setFirst_name(resultSet.getString(2));
                employee.setLast_name(resultSet.getString(3));
                employee.setAddress(resultSet.getString(4));
                employee.setBirthdate(resultSet.getDate(5));
                employee.setStore_id_fk(resultSet.getInt(6));
                EmployeesList.add(employee);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error EmployeeDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return EmployeesList;
    }

    @Override
    public List<Employee> getEmployeeByStoreId(int Store_id_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Employees WHERE Store_id_fk= "+Store_id_fk;

        List<Employee> EmployeesListStore = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setIdEmployees(resultSet.getInt(1));
                employee.setFirst_name(resultSet.getString(2));
                employee.setLast_name(resultSet.getString(3));
                employee.setAddress(resultSet.getString(4));
                employee.setBirthdate(resultSet.getDate(5));
                employee.setStore_id_fk(resultSet.getInt(6));
                EmployeesListStore.add(employee);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error EmployeeDaoImpl class, READ (getByStoreID) method");
            e.printStackTrace();
        }
        return EmployeesListStore;
    }

    @Override
    public Employee getEmployeeById(int idEmployee) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Employees WHERE idEmployees = " + idEmployee;

        Employee employeeById = new Employee();

        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                employeeById.setIdEmployees(resultSet.getInt(1));
                employeeById.setFirst_name(resultSet.getString(2));
                employeeById.setLast_name(resultSet.getString(3));
                employeeById.setAddress(resultSet.getString(4));
                employeeById.setBirthdate(resultSet.getDate(5));
                employeeById.setStore_id_fk(resultSet.getInt(6));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error EmployeeDaoImpl class, READ (getByEmployeeId) method");
            e.printStackTrace();
        }
        return employeeById;
    }

    @Override
    public boolean update(Employee employee) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Employees SET First_name='"+employee.getFirst_name()+"', Last_name='"+employee.getLast_name()+"', Address='"+employee.getAddress()+"', Birthdate='"+employee.getBirthdate()+"', Store_id_fk='"+employee.getStore_id_fk()+"' WHERE IdEmployees = "+employee.getIdEmployees();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error EmployeeDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Employee employee) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Employees WHERE idEmployees = "+employee.getIdEmployees();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        }catch(SQLException e){
            System.out.println("Error EmployeeDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
