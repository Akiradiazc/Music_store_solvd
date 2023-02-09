package XML_handlers;

import Model.Artist;
import Model.Employee;

import java.util.List;
import java.util.ArrayList;

import java.sql.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ArtistHandler extends DefaultHandler{
    private List<Artist> artistList = null;
    private Artist artist = null;
    private StringBuilder data = null;

    public List<Artist> getArtistList(){
        return artistList;
    }

    boolean bName = false;
    boolean bCountry_id_fk = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Artist")){
            // create a new Employee and put it in Map
            String id = attributes.getValue("id");
            // initialize Employee object and set id attribute
            artist = new Artist();
            artist.setIdArtists(Integer.parseInt(id));
            // initialize list
            if(artistList == null){
                artistList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("Name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("Country_id_fk")){
            bCountry_id_fk = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(bName){
            artist.setName(data.toString());
            bName = false;
        } else if (bCountry_id_fk) {
            artist.setCountry_id_fk(Integer.parseInt(data.toString()));
            bCountry_id_fk = false;
        }
        if(qName.equalsIgnoreCase("Artist")){
            artistList.add(artist);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String (ch, start, length));
    }
}
