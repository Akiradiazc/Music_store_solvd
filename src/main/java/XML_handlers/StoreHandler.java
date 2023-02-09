package XML_handlers;

import Model.Store;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

public class StoreHandler extends DefaultHandler {
    // List to hold Store object
    private List<Store> storeList = null;
    private Store store = null;
    private StringBuilder data = null;

    // getter method for clients list
    public List<Store> getStoreList() {
        return storeList;
    }

    boolean bAddress=false;
    boolean bCity_id_fk=false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Store")){
            // create a new client and put it in Map
            String id = attributes.getValue("id");
            // initialize client object and set id attribute
            store = new Store();
            store.setIdStore(Integer.parseInt(id));
            // initialize list
            if (storeList == null)
                storeList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("Address")) {
            bAddress = true;
        } else if (qName.equalsIgnoreCase("City_id_fk")) {
            bCity_id_fk = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bAddress){
            store.setAddress(data.toString());
            bAddress = false;
        } else if (bCity_id_fk) {
            store.setCity_id_fk(Integer.parseInt(data.toString()));
            bCity_id_fk = false;
        }
        if (qName.equalsIgnoreCase("Store")) {
            // add client object to list
            storeList.add(store);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String (ch, start, length));
    }
}
