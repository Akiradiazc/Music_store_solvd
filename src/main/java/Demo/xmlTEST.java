package Demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import java.io.InputStream;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Views.*;
import XML_handlers.*;
import org.xml.sax.SAXException;

import Model.Employee;

public class xmlTEST {

    public static void main(String[] args) {
        //Viewers
        ViewEmployees viewEmployees = new ViewEmployees();
        ViewArtists viewArtists = new ViewArtists();
        ViewClients viewClients = new ViewClients();
        ViewStore viewStore = new ViewStore();
        ViewBuy_order viewBuyOrder = new ViewBuy_order();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try{
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParser saxParser2 = saxParserFactory.newSAXParser();

            // Object Handlers
            EmployeeHandler employeeHandler = new EmployeeHandler();
            ArtistHandler artistHandler = new ArtistHandler();
            ClientHandler clientHandler = new ClientHandler();
            StoreHandler storeHandler = new StoreHandler();
            BuyOrderHandler buyOrderHandler = new BuyOrderHandler();

            // Object SAX parsers
            saxParser.parse(new File("src//main//XML4SAX//Employees.xml"), employeeHandler);
            saxParser.parse(new File("src//main//XML4SAX//Artists.xml"), artistHandler);
            saxParser.parse(new File("src//main//XML4SAX//Clients.xml"), clientHandler);
            saxParser2.parse(new File("src//main//XML4SAX//Stores.xml"), storeHandler);
            saxParser2.parse(new File("src//main//XML4SAX//Buy_orders.xml"), buyOrderHandler);

            //Print employees
            viewEmployees.ViewEmployeeList(employeeHandler.getEmployeeList());
            //Print Artists
            viewArtists.ViewArtist(artistHandler.getArtistList());
            // Print Clients
            viewClients.viewClients(clientHandler.getClientList());
            // Print Stores
            viewStore.ViewStores(storeHandler.getStoreList());
            // Print Buy_order
            viewBuyOrder.ViewBuy_orders(buyOrderHandler.getBuyOrderList());

        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
    }
}
