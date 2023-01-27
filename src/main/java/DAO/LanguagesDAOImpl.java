package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionClass;
import Model.Languages;
import iDao_interfaces.ILanguagesDAO;

public class LanguagesDAOImpl implements ILanguagesDAO{
    @Override
    public boolean create(Languages language) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String sql = "INSERT INTO Languages(Language_name) VALUES ('"+ language.getLanguage_name()+"')";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: LanguageDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Languages> getAllLanguages() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Languages ORDER BY idLanguages";
        List<Languages> languagesList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Languages language = new Languages();
                language.setIdLanguages(resultSet.getInt(1));
                language.setLanguage_name(resultSet.getString(2));
                languagesList.add(language);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error LanguagesDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return languagesList;
    }

    @Override
    public Languages getLanguageById(int idLanguage) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Languages WHERE idLanguage = "+ idLanguage;
        Languages languagesById = new Languages();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                languagesById.setIdLanguages(resultSet.getInt(1));
                languagesById.setLanguage_name(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error LanguagesDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return languagesById;
    }

    @Override
    public boolean update(Languages language) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Languages SET Language_name='"+language.getLanguage_name()+"' WHERE idLanguages= "+language.getIdLanguages();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error LanguagesDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Languages language) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Languages WHERE idLanguages= "+language.getIdLanguages();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error LanguagesDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
