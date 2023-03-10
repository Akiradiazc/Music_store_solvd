package XML_handlers;

import Model.Employee;

import java.util.List;
import java.util.ArrayList;

import java.sql.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {

    // List to hold Employees object
    private List<Employee> employeeList = null;
    private Employee employee = null;
    private StringBuilder data = null;

    // getter method for employee list
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    boolean bFirst_name=false;
    boolean bLast_name=false;
    boolean bAddress=false;
    boolean bBirthdate=false;
    boolean bStore_id_fk=false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Employee")){
            // create a new Employee and put it in Map
            String id = attributes.getValue("id");
            // initialize Employee object and set id attribute
            employee = new Employee();
            employee.setIdEmployees(Integer.parseInt(id));
            // initialize list
            if (employeeList == null)
                employeeList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("First_name")) {
            bFirst_name = true;
        } else if (qName.equalsIgnoreCase("Last_name")) {
            bLast_name = true;
        } else if (qName.equalsIgnoreCase("Address")) {
            bAddress = true;
        } else if (qName.equalsIgnoreCase("Birthdate")) {
            bBirthdate = true;
        } else if (qName.equalsIgnoreCase("Store_id_fk")) {
            bStore_id_fk = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bFirst_name){
            employee.setFirst_name(data.toString());
            bFirst_name = false;
        } else if (bLast_name) {
            employee.setLast_name(data.toString());
            bLast_name = false;
        } else if (bAddress) {
            employee.setAddress(data.toString());
            bAddress = false;
        } else if (bBirthdate) {
            employee.setBirthdate(Date.valueOf(data.toString()));
            bBirthdate = false;
        } else if (bStore_id_fk){
            employee.setStore_id_fk(Integer.parseInt(data.toString()));
            bStore_id_fk = false;
        }
        if (qName.equalsIgnoreCase("Employee")) {
            // add Employee object to list
            employeeList.add(employee);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String (ch, start, length));
    }
}
