package MyBatisDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Connection.MySessionFactory;
import Model.Genre;
import Model.Languages;
import iDao_interfaces.IGenreDAO;
import iDao_interfaces.ILanguagesDAO;
import org.apache.ibatis.session.SqlSession;

public class GenrDAOMyBatisImp implements IGenreDAO {
    //------------ NEW ADDITIONS ----------
    // ADDING SINGLETON PATTERN TO BE USED WITH MYBATIS
    private final MySessionFactory instance = MySessionFactory.getInstance();

    @Override
    public boolean create(Genre genre) {
        return false;
    }

    @Override
    public  List<Genre> getAllGenres(){
        List<Genre> genreList = new ArrayList<>();
        SqlSession session = null;
        try{
            session = instance.getFactory().openSession();
            genreList = session.selectList("getAllGenres");
        } catch(Exception error){
            error.printStackTrace();
        } finally{
            if(session != null){
                session.close();
            }
        }
        return genreList;
    }

    @Override
    public Genre getGenreById(int idGenre) {
        return null;
    }

    @Override
    public boolean update(Genre genre) {
        return false;
    }

    @Override
    public boolean delete(Genre genre) {
        return false;
    }
}
