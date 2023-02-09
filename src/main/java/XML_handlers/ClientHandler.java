package XML_handlers;

import Model.Clients;

import java.util.List;
import java.util.ArrayList;

import java.sql.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ClientHandler extends DefaultHandler {

    // List to hold Clients object
    private List<Clients> clientList = null;
    private Clients client = null;
    private StringBuilder data = null;

    // getter method for clients list
    public List<Clients> getClientList() {
        return clientList;
    }

    boolean bFirst_name=false;
    boolean bLast_name=false;
    boolean bAddress=false;
    boolean bBirthdate=false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Client")){
            // create a new client and put it in Map
            String id = attributes.getValue("id");
            // initialize client object and set id attribute
            client = new Clients();
            client.setIdClients(Integer.parseInt(id));
            // initialize list
            if (clientList == null)
                clientList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("First_name")) {
            bFirst_name = true;
        } else if (qName.equalsIgnoreCase("Last_name")) {
            bLast_name = true;
        } else if (qName.equalsIgnoreCase("Address")) {
            bAddress = true;
        } else if (qName.equalsIgnoreCase("Birthdate")) {
            bBirthdate = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bFirst_name){
            client.setFirst_name(data.toString());
            bFirst_name = false;
        } else if (bLast_name) {
            client.setLast_name(data.toString());
            bLast_name = false;
        } else if (bAddress) {
            client.setAddress(data.toString());
            bAddress = false;
        } else if (bBirthdate) {
            client.setBirthdate(Date.valueOf(data.toString()));
            bBirthdate = false;
        }
        if (qName.equalsIgnoreCase("Client")) {
            // add client object to list
            clientList.add(client);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String (ch, start, length));
    }
}
