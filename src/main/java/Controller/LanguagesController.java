package Controller;

import DAO.LanguagesDAOImpl;
import Model.Languages;
import Views.ViewLanguages;
import iDao_interfaces.ILanguagesDAO;

import java.util.ArrayList;
import java.util.List;

public class LanguagesController {

    private ViewLanguages view = new ViewLanguages();

    public LanguagesController(){}

    // --------- DAO to CREATE Country
    public void create(Languages language){
        ILanguagesDAO dao = new LanguagesDAOImpl();
        dao.create(language);
    }

    // --------- DAO to READ country
    public List<Languages> getAllLanguagesList(){
        List<Languages> LanguagesList = new ArrayList<>();
        ILanguagesDAO dao = new LanguagesDAOImpl();
        LanguagesList = dao.getAllLanguages();
        view.ViewLanguage(LanguagesList);
        return LanguagesList;
    }

    public Languages getLanguagyById(int idLanguage){
        Languages languageById = new Languages();
        ILanguagesDAO dao = new LanguagesDAOImpl();
        languageById = dao.getLanguageById(idLanguage);
        view.ViewLanguage(languageById);
        return languageById;
    }

    // --------- DAO to UPDATE employee
    public void update(Languages language){
        ILanguagesDAO dao = new LanguagesDAOImpl();
        dao.update(language);
    }

    // --------- DAO to DELETE employee
    public void delete(Languages language){
        ILanguagesDAO dao = new LanguagesDAOImpl();
        dao.delete(language);
    }
}
