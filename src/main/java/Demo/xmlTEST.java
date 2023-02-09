package Demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Views.ViewArtists;
import Views.ViewEmployees;
import XML_handlers.ArtistHandler;
import XML_handlers.EmployeeHandler;
import org.xml.sax.SAXException;

import Model.Employee;

public class xmlTEST {

    public static void main(String[] args) {
        //Viewers
        ViewEmployees viewEmployees = new ViewEmployees();
        ViewArtists viewArtists = new ViewArtists();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Object Handlers
            EmployeeHandler employeeHandler = new EmployeeHandler();
            ArtistHandler artistHandler = new ArtistHandler();

            // Object SAX parsers
            saxParser.parse(new File("src//main//XML4SAX//Employees.xml"), employeeHandler);
            saxParser.parse(new File("src//main//XML4SAX//Artists.xml"), artistHandler);

            //Print employees
            viewEmployees.ViewEmployeeList(employeeHandler.getEmployeeList());
            //Print Artists
            viewArtists.ViewArtist(artistHandler.getArtistList());

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}
