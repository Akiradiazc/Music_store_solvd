package XML_handlers;

import Model.Buy_order;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class BuyOrderHandler extends DefaultHandler {
    // List to hold BuyOrder object
    private List<Buy_order> buyOrderList = null;
    private Buy_order buy_order = null;
    private StringBuilder data = null;

    // getter method for clients list
    public List<Buy_order> getBuyOrderList() {
        return buyOrderList;
    }

    boolean bAlbum_id_fk=false;
    boolean bQuantity=false;
    boolean bStore_id_fk=false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Buy_order")){
            // create a new client and put it in Map
            String id = attributes.getValue("id");
            // initialize client object and set id attribute
            buy_order = new Buy_order();
            buy_order.setIdBuy_order(Integer.parseInt(id));
            // initialize list
            if (buyOrderList == null)
                buyOrderList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("Album_id_fk")) {
            bAlbum_id_fk= true;
        } else if (qName.equalsIgnoreCase("Quantity")) {
            bQuantity = true;
        } else if (qName.equalsIgnoreCase("Store_id_fk")) {
            bStore_id_fk = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bAlbum_id_fk){
            buy_order.setAlbum_id_fk(Integer.parseInt(data.toString()));
            bAlbum_id_fk = false;
        } else if (bQuantity) {
            buy_order.setQuantity(Integer.parseInt(data.toString()));
            bQuantity = false;
        } else if (bStore_id_fk) {
            buy_order.setStore_id_fk(Integer.parseInt(data.toString()));
            bStore_id_fk = false;
        }
        if (qName.equalsIgnoreCase("Buy_order")) {
            // add client object to list
            buyOrderList.add(buy_order);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String (ch, start, length));
    }
}
