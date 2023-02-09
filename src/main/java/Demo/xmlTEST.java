package Demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import XML_handlers.EmployeeHandler;
import org.xml.sax.SAXException;

import Model.Employee;

public class xmlTEST {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            EmployeeHandler employeeHandler = new EmployeeHandler();
            saxParser.parse(new File(""), employeeHandler);
            //Get Employees list
            List<Employee> employeeList = employeeHandler.getEmployeeList();
            //print employee information
            for(Employee emp : employeeList){
                System.out.println(emp);
            }
        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}
