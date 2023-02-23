package MyBatisDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Connection.MySessionFactory;
import Model.Genre;
import Model.Languages;
import iDao_interfaces.ILanguagesDAO;
import org.apache.ibatis.session.SqlSession;

public class LangDAOMyBatisImp implements ILanguagesDAO{
    //------------ NEW ADDITIONS ----------
    // ADDING SINGLETON PATTERN TO BE USED WITH MYBATIS
    private final MySessionFactory instance = MySessionFactory.getInstance();

    @Override
    public boolean create(Languages language) {
        return false;
    }

    @Override
    public List<Languages> getAllLanguages() {
        List<Languages> LanguageList = new ArrayList<>();
        SqlSession session = null;
        try{
            session = instance.getFactory().openSession();
            LanguageList = session.selectList("getAllLanguages");
        } catch(Exception error){
            error.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        return LanguageList;
    }

    @Override
    public Languages getLanguageById(int idLanguage) {
        return null;
    }

    @Override
    public boolean update(Languages language) {
        return false;
    }

    @Override
    public boolean delete(Languages language) {
        return false;
    }
}
