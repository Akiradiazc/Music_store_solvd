package XML_handlers;

import Model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {

    // List to hold Employees object
    private List<Employee> employeeList = null;
    private Employee employee = null;
    private StringBuilder data = null;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

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
            Employee employee = new Employee();
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
        } else if (bLast_name) {
            employee.setLast_name(data.toString());
        } else if (bAddress) {
            employee.setAddress(data.toString());
        } else if (bBirthdate) {
            try {
                employee.setBirthdate(formatter.parse(data.toString()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (bStore_id_fk){
            employee.setStore_id_fk(Integer.parseInt(data.toString()));
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
