package DAO;

import Model.Album;
import Model.Artist;
import Model.Store;
import iDao_interfaces.IAlbumDAO;

import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAOImpl implements IAlbumDAO {

    @Override
    public boolean create(Album album) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;

        String columnNames = "(Album_name, Year_released, Price, Artists_id_fk, Genre_id_fk, Languages_id_fk)";
        String ArtistSelect = "(SELECT idArtists FROM Artists WHERE Name= '"+album.getArtists_name_fk()+"')";
        String GenreSelect = "(SELECT idGenre FROM Genre WHERE Genre_name= '"+album.getGenre_name_fk()+"')";
        String LanguageSelect = "(SELECT idLanguages FROM Languages WHERE Language_name= '"+album.getLanguages_name_fk()+"')";
        String sql = "INSERT INTO Albums " + columnNames + " VALUES ('"+ album.getAlbum_name()+"', "+album.getYear_released()+", "+album.getPrice()+", "+ArtistSelect+", "+GenreSelect+", "+LanguageSelect+")";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: AlbumDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Album> getAllAlbums() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Albums ORDER BY idAlbum";
        List<Album> AlbumsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Album album = new Album();
                album.setIdAlbum(resultSet.getInt(1));
                album.setAlbum_name(resultSet.getString(2));
                album.setYear_released(resultSet.getInt(3));
                album.setPrice(resultSet.getFloat(4));
                album.setArtists_id_fk(resultSet.getInt(5));
                album.setGenre_id_fk(resultSet.getInt(6));
                album.setLanguages_id_fk(resultSet.getInt(7));
                AlbumsList.add(album);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error AlbumsDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return AlbumsList;
    }

    @Override
    public List<Album> getAlbumsByArtist(String Artist_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idAlbum, Album_name, Year_released, Price, Artists_id_fk, Genre_id_fk, Languages_id_fk";
        String joins = "INNER JOIN Artists ON Albums.Artists_id_fk = Artists.idArtists";
        String sql = "SELECT " + searcher + " FROM Albums "+joins+ " WHERE Artists.Name = '"+Artist_name_fk+"';";
        List<Album> AlbumsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Album album = new Album();
                album.setIdAlbum(resultSet.getInt(1));
                album.setAlbum_name(resultSet.getString(2));
                album.setYear_released(resultSet.getInt(3));
                album.setPrice(resultSet.getFloat(4));
                album.setArtists_id_fk(resultSet.getInt(5));
                album.setGenre_id_fk(resultSet.getInt(6));
                album.setLanguages_id_fk(resultSet.getInt(7));
                AlbumsList.add(album);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error AlbumsDaoImpl class, READ (getByArtist) method");
            e.printStackTrace();
        }
        return AlbumsList;
    }

    @Override
    public List<Album> getAlbumsByGenre(String Genre_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idAlbum, Album_name, Year_released, Price, Artists_id_fk, Genre_id_fk, Languages_id_fk";
        String joins = "INNER JOIN Genre ON Albums.Genre_id_fk = Genre.idGenre";
        String sql = "SELECT " + searcher + " FROM Albums "+joins+ " WHERE Genre.Genre_name = '"+Genre_name_fk+"';";
        List<Album> AlbumsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Album album = new Album();
                album.setIdAlbum(resultSet.getInt(1));
                album.setAlbum_name(resultSet.getString(2));
                album.setYear_released(resultSet.getInt(3));
                album.setPrice(resultSet.getFloat(4));
                album.setArtists_id_fk(resultSet.getInt(5));
                album.setGenre_id_fk(resultSet.getInt(6));
                album.setLanguages_id_fk(resultSet.getInt(7));
                AlbumsList.add(album);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error AlbumsDaoImpl class, READ (getByGenre) method");
            e.printStackTrace();
        }
        return AlbumsList;
    }

    @Override
    public List<Album> getAlbumsByLanguage(String Languages_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idAlbum, Album_name, Year_released, Price, Artists_id_fk, Genre_id_fk, Languages_id_fk";
        String joins = "INNER JOIN Languages ON Albums.Languages_id_fk = Languages.idLanguages";
        String sql = "SELECT " + searcher + " FROM Albums "+joins+ "  WHERE Languages.Language_name = '"+Languages_name_fk+"';";
        List<Album> AlbumsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Album album = new Album();
                album.setIdAlbum(resultSet.getInt(1));
                album.setAlbum_name(resultSet.getString(2));
                album.setYear_released(resultSet.getInt(3));
                album.setPrice(resultSet.getFloat(4));
                album.setArtists_id_fk(resultSet.getInt(5));
                album.setGenre_id_fk(resultSet.getInt(6));
                album.setLanguages_id_fk(resultSet.getInt(7));
                AlbumsList.add(album);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error AlbumsDaoImpl class, READ (getByLanguage) method");
            e.printStackTrace();
        }
        return AlbumsList;
    }

    @Override
    public List<Album> getAlbumsByYearReleased(int Year_released) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idAlbum, Album_name, Year_released, Price, Artists_id_fk, Genre_id_fk, Languages_id_fk";
        String sql = "SELECT " + searcher + " FROM Albums WHERE Year_released = "+Year_released+";";
        List<Album> AlbumsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Album album = new Album();
                album.setIdAlbum(resultSet.getInt(1));
                album.setAlbum_name(resultSet.getString(2));
                album.setYear_released(resultSet.getInt(3));
                album.setPrice(resultSet.getFloat(4));
                album.setArtists_id_fk(resultSet.getInt(5));
                album.setGenre_id_fk(resultSet.getInt(6));
                album.setLanguages_id_fk(resultSet.getInt(7));
                AlbumsList.add(album);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error AlbumsDaoImpl class, READ (getByYear) method");
            e.printStackTrace();
        }
        return AlbumsList;
    }

    @Override
    public List<Album> getAlbumsByPrice(float price, String comparator) {
        String comp = switch (comparator) {
            case "less" -> "<";
            case "greater" -> ">";
            case "exact" -> "=";
            default -> new String();
        };
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String searcher = "idAlbum, Album_name, Year_released, Price, Artists_id_fk, Genre_id_fk, Languages_id_fk";
        String sql = "SELECT " + searcher + " FROM Albums WHERE Price"+comp+ price+";";
        List<Album> AlbumsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Album album = new Album();
                album.setIdAlbum(resultSet.getInt(1));
                album.setAlbum_name(resultSet.getString(2));
                album.setYear_released(resultSet.getInt(3));
                album.setPrice(resultSet.getFloat(4));
                album.setArtists_id_fk(resultSet.getInt(5));
                album.setGenre_id_fk(resultSet.getInt(6));
                album.setLanguages_id_fk(resultSet.getInt(7));
                AlbumsList.add(album);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error AlbumsDaoImpl class, READ (getByArtist) method");
            e.printStackTrace();
        }
        return AlbumsList;
    }

    @Override
    public Album getAlbumById(int idAlbum) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Albums WHERE idAlbum = "+ idAlbum;
        Album albumById = new Album();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                albumById.setIdAlbum(resultSet.getInt(1));
                albumById.setAlbum_name(resultSet.getString(2));
                albumById.setYear_released(resultSet.getInt(3));
                albumById.setPrice(resultSet.getFloat(4));
                albumById.setArtists_id_fk(resultSet.getInt(5));
                albumById.setGenre_id_fk(resultSet.getInt(6));
                albumById.setLanguages_id_fk(resultSet.getInt(7));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error AlbumDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return albumById;
    }

    @Override
    public Album getAlbumByName(String Album_name) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Albums WHERE Album_name = "+ Album_name;
        Album albumByName = new Album();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                albumByName.setIdAlbum(resultSet.getInt(1));
                albumByName.setAlbum_name(resultSet.getString(2));
                albumByName.setYear_released(resultSet.getInt(3));
                albumByName.setPrice(resultSet.getFloat(4));
                albumByName.setArtists_id_fk(resultSet.getInt(5));
                albumByName.setGenre_id_fk(resultSet.getInt(6));
                albumByName.setLanguages_id_fk(resultSet.getInt(7));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error AlbumDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return albumByName;
    }

    @Override
    public boolean update(Album album) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Album SET Album_name= '"+ album.getAlbum_name()+"', Year_released= "+album.getYear_released()+", Price= "+album.getPrice()+", Artists_id_fk= "+album.getArtists_id_fk()+", Genre_id_fk= "+album.getGenre_id_fk()+", Languages_id_fk= "+album.getLanguages_id_fk()+";";
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error AlbumDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Album album) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Album WHERE idAlbum= "+album.getIdAlbum();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error AlbumDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
