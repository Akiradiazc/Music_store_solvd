package Demo;

import Model.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

public class JSONTest {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        // JSON FILE CREATION
        String FileNameGenre = "src//main//JSONFiles//Genres.json";
        String FileNameLanguage = "src//main//JSONFiles//Languages.json";
        String FileNameCountry = "src//main//JSONFiles//Countries.json";
        String FileNameBill = "src//main//JSONFiles//Bills.json";
        String FileNamePM = "src//main//JSONFiles//PayingMethods.json";

        File FileGenre = new File(FileNameGenre);
        File FileLanguage = new File(FileNameLanguage);
        File FileCountry = new File(FileNameCountry);
        File FileBill = new File(FileNameBill);
        File FilePM = new File(FileNamePM);

        // JAVA OBJECT TO JSON
        try{
            Set<Genre> GenreSet = new HashSet<>();
            GenreSet.add(new Genre(2,"Bachata"));
            GenreSet.add(new Genre(3,"Disco"));
            GenreSet.add(new Genre(4, "Salsa"));
            GenreSet.add(new Genre(5, "Urban"));

            // -> LANGUAGES
            Set<Languages> LanguageList = new HashSet<>();
            LanguageList.add(new Languages(1, "Portuguese"));

            // -> COUNTRIES
            Set<Country> CountryList = new HashSet<Country>();
            CountryList.add(new Country(1, "Colombia"));

            // -> BILL
            Set<Bill> BillList = new HashSet<>();
            java.sql.Date date1 = Date.valueOf("2023-08-23");
            BillList.add(new Bill(3, date1, 3, 1,1,1));

            // -> PAYING_METHOD
            Set<Paying_method> PayingMethodList = new HashSet<>();
            PayingMethodList.add(new Paying_method(4, "RappiCard"));

            // JSON FILES UPDATE
            mapper.writerWithDefaultPrettyPrinter().writeValue(FileGenre, GenreSet);
            mapper.writerWithDefaultPrettyPrinter().writeValue(FileLanguage, LanguageList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(FileCountry, CountryList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(FileBill, BillList);
            mapper.writerWithDefaultPrettyPrinter().writeValue(FilePM, PayingMethodList);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
