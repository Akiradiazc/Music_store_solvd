package Demo;

import JAXBHandlers.*;
import Model.*;

import java.io.File;
import java.sql.Date;
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
        JAXBContext jc_bill = JAXBContext.newInstance(BillHandler.class);
        JAXBContext jc_pm = JAXBContext.newInstance(Paying_methodHandler.class);

        // XML FILE CREATION
        String FileNameGenre = "src//main//XML4SAX//Genres.xml";
        String FileNameLanguage = "src//main//XML4SAX//Languages.xml";
        String FileNameCountry = "src//main//XML4SAX//Countries.xml";
        String FileNameBill = "src//main//XML4SAX//Bills.xml";
        String FileNamePM = "src//main//XML4SAX//PayingMethods.xml";

        File FileXmlGenre = new File(FileNameGenre);
        File FileXmlLanguage = new File(FileNameLanguage);
        File FileXmlCountry = new File(FileNameCountry);
        File FileXmlBill = new File(FileNameBill);
        File FileXmlPM = new File(FileNamePM);

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

            // -> BILL
        Set<Bill> BillList = new HashSet<>();
        Date date1 = Date.valueOf("2023-08-23");
        BillList.add(new Bill(3, date1, 3, 1,1,1));

            // -> PAYING_METHOD
        Set<Paying_method> PayingMethodList = new HashSet<>();
        PayingMethodList.add(new Paying_method(4, "RappiCard"));

        // HANDLER CREATION
        GenreHandler genreHandler = new GenreHandler();
        LanguagesHandler languagesHandler = new LanguagesHandler();
        CountryHandler countryHandler = new CountryHandler();
        BillHandler billHandler = new BillHandler();
        Paying_methodHandler paying_methodHandler = new Paying_methodHandler();

        // UPDATE ELEMENTS
        genreHandler.setGenreList(GenreList);
        languagesHandler.setLanguageList(LanguageList);
        countryHandler.setCountryList(CountryList);
        billHandler.setBillSet(BillList);
        paying_methodHandler.setPayingMethodList(PayingMethodList);

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

        Marshaller m_bill = jc_bill.createMarshaller();
        m_bill.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m_bill.marshal(billHandler, FileXmlBill);

        Marshaller m_pm = jc_pm.createMarshaller();
        m_pm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m_pm.marshal(paying_methodHandler, FileXmlPM);

        // UNMARSHALLERS
        Unmarshaller u_genre = jc_genre.createUnmarshaller();
        Object unmarshalled_genre = u_genre.unmarshal(FileXmlGenre);

        Unmarshaller u_language = jc_language.createUnmarshaller();
        Object unmarshalled_language = u_language.unmarshal(FileXmlLanguage);

        Unmarshaller u_country = jc_country.createUnmarshaller();
        Object unmarshalled_country = u_country.unmarshal(FileXmlCountry);

        Unmarshaller u_bill = jc_bill.createUnmarshaller();
        Object unmarshalled_bill = u_bill.unmarshal(FileXmlBill);

        Unmarshaller u_pm = jc_pm.createUnmarshaller();
        Object unmarshalled_pm = u_pm.unmarshal(FileXmlPM);
    }
}
