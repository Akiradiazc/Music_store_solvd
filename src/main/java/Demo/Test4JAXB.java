package Demo;

import JAXBHandlers.GenreHandler;
import Model.Genre;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test4JAXB {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(GenreHandler.class);

        String FileName = "src//main//XML4SAX//Genres.xml";
        File FileXml = new File(FileName);

        Set<Genre> GenreList = new HashSet<>();
        GenreList.add(new Genre(2,"Bachata"));
        GenreList.add(new Genre(3,"Disco"));
        GenreList.add(new Genre(4, "Salsa"));
        GenreList.add(new Genre(5, "Urban"));

        GenreHandler genreHandler = new GenreHandler();
        genreHandler.setGenreList(GenreList);

        // Marshaller
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(genreHandler,(FileXml));

        // Unmarshaller
        Unmarshaller u = jc.createUnmarshaller();
        Object unmarshalled = u.unmarshal(FileXml);

    }
}
