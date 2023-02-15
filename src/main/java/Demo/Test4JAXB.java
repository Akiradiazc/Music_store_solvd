package Demo;

import JAXBHandlers.CountryHandler;
import JAXBHandlers.GenreHandler;
import JAXBHandlers.LanguagesHandler;
import Model.Country;
import Model.Genre;
import Model.Languages;

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

        // JAXB CONTEXT CREATOR
        JAXBContext jc_genre = JAXBContext.newInstance(GenreHandler.class);
        JAXBContext jc_language = JAXBContext.newInstance(LanguagesHandler.class);
        JAXBContext jc_country = JAXBContext.newInstance(CountryHandler.class);

        // XML FILE CREATION
        String FileNameGenre = "src//main//XML4SAX//Genres.xml";
        String FileNameLanguage = "src//main//XML4SAX//Languages.xml";
        String FileNameCountry = "src//main//XML4SAX//Countries.xml";

        File FileXmlGenre = new File(FileNameGenre);
        File FileXmlLanguage = new File(FileNameLanguage);
        File FileXmlCountry = new File(FileNameCountry);

        // ELEMENTS TO UPDATE
            // -> GENRES
        Set<Genre> GenreList = new HashSet<>();
        GenreList.add(new Genre(2,"Bachata"));
        GenreList.add(new Genre(3,"Disco"));
        GenreList.add(new Genre(4, "Salsa"));
        GenreList.add(new Genre(5, "Urban"));

            // -> LANGUAGES
        Set<Languages> LanguageList = new HashSet<>();
        LanguageList.add(new Languages(1, "Portuguese"));

            // -> COUNTRIES
        Set<Country> CountryList = new HashSet<Country>();
        CountryList.add(new Country(1, "Colombia"));

        // HANDLER CREATION
        GenreHandler genreHandler = new GenreHandler();
        LanguagesHandler languagesHandler = new LanguagesHandler();
        CountryHandler countryHandler = new CountryHandler();

        // UPDATE ELEMENTS
        genreHandler.setGenreList(GenreList);
        languagesHandler.setLanguageList(LanguageList);
        countryHandler.setCountryList(CountryList);

        // MARSHALLERS
        Marshaller m_genre = jc_genre.createMarshaller();
        m_genre.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m_genre.marshal(genreHandler,(FileXmlGenre));

        Marshaller m_language = jc_language.createMarshaller();
        m_language.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m_language.marshal(languagesHandler, FileXmlLanguage);

        Marshaller m_country = jc_country.createMarshaller();
        m_country.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m_country.marshal(countryHandler, FileXmlCountry);

        // UNMARSHALLERS
        Unmarshaller u_genre = jc_genre.createUnmarshaller();
        Object unmarshalled_genre = u_genre.unmarshal(FileXmlGenre);

        Unmarshaller u_language = jc_language.createUnmarshaller();
        Object unmarshalled_language = u_language.unmarshal(FileXmlLanguage);

        Unmarshaller u_country = jc_country.createUnmarshaller();
        Object unmarshalled_country = u_country.unmarshal(FileXmlCountry);

    }
}
