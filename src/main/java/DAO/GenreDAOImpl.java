package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Connection.MySessionFactory;
import Model.Genre;
import iDao_interfaces.IGenreDAO;
import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.annotations.Select;

public class GenreDAOImpl implements IGenreDAO{

    //------------ NEW ADDITIONS ----------
    // ADDING SINGLETON PATTERN TO BE USED WITH MYBATIS
    private final MySessionFactory instance = MySessionFactory.getInstance();

    @Override
    public boolean create(Genre genre) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String sql = "INSERT INTO Genre(Genre_name) VALUES ('"+ genre.getGenre_name()+"')";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: GenreDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    // TESTING MYBATIS IMPLEMENTATION
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
    /*
    @Override
    public List<Genre> getAllGenres() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Genre ORDER BY idGenre";
        List<Genre> GenreList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setIdGenre(resultSet.getInt(1));
                genre.setGenre_name(resultSet.getString(2));
                GenreList.add(genre);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error GenreDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return GenreList;
    }
*/
    @Override
    public Genre getGenreById(int idGenre) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Genre WHERE idGenre = "+ idGenre;
        Genre genreById = new Genre();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                genreById.setIdGenre(resultSet.getInt(1));
                genreById.setGenre_name(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error GenreDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return genreById;
    }

    @Override
    public boolean update(Genre genre) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Genre SET Genre_name='"+genre.getGenre_name()+"' WHERE idGenre= "+genre.getIdGenre();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error GenreDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Genre genre) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Genre WHERE idGenre= "+genre.getIdGenre();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error GenreDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
