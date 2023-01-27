package DAO;

import Model.Artist;
import Model.City;
import iDao_interfaces.IArtistDAO;

import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImpl implements IArtistDAO {
    @Override
    public boolean create(Artist artist) {
        boolean create = false;

        //Sql
        Statement statement = null;
        Connection connection = null;
        String countrySelect = "(SELECT idCountry FROM Country WHERE Country_name = '"+artist.getCountry_name_fk()+"')";
        String sql = "INSERT INTO Artists(Name, Country_id_fk) VALUES ('"+ artist.getName()+"',"+countrySelect+")";
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            create=true;
            statement.close();
            connection.close();
        } catch(SQLException e){
            System.out.println("Error: ArtistDaoImpl class, CREATE method");
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public List<Artist> getAllArtists() {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Artists ORDER BY idArtists";
        List<Artist> ArtistsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setIdArtists(resultSet.getInt(1));
                artist.setName(resultSet.getString(2));
                artist.setCountry_id_fk(resultSet.getInt(3));
                ArtistsList.add(artist);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error ArtistDaoImpl class, READ (getAll) method");
            e.printStackTrace();
        }
        return ArtistsList;
    }

    @Override
    public List<Artist> getArtistsByCountry(String Country_name_fk) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String elementsToShow = "Artists.idArtists, Artists.Name, Artists.Country_id_fk";
        String sql = "SELECT "+ elementsToShow +" FROM Artists INNER JOIN Country ON Artists.Country_id_fk = Country.idCountry WHERE Country_name = '"+Country_name_fk+"';";
        List<Artist> ArtistsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setIdArtists(resultSet.getInt(1));
                artist.setName(resultSet.getString(2));
                artist.setCountry_id_fk(resultSet.getInt(3));
                ArtistsList.add(artist);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error ArtistDaoImpl class, READ (getArtistsByCountry) method");
            e.printStackTrace();
        }
        return ArtistsList;
    }

    @Override
    public Artist getArtistById(int idArtist) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Artists WHERE idArtists = "+ idArtist;
        Artist artistById = new Artist();
        try{
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                artistById.setIdArtists(resultSet.getInt(1));
                artistById.setName(resultSet.getString(2));
                artistById.setCountry_id_fk(resultSet.getInt(3));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error ArtistsDaoImpl class, READ (byId) method");
            e.printStackTrace();
        }
        return artistById;
    }

    @Override
    public List<Artist> getArtistByName(String name) {
        //sql
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM Artists WHERE Artists.Name LIKE '%"+ name +"%'";
        List<Artist> ArtistsList = new ArrayList<>();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setIdArtists(resultSet.getInt(1));
                artist.setName(resultSet.getString(2));
                artist.setCountry_id_fk(resultSet.getInt(3));
                ArtistsList.add(artist);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error ArtistDaoImpl class, READ (getArtistsByName) method");
            e.printStackTrace();
        }
        return ArtistsList;
    }

    @Override
    public boolean update(Artist artist) {
        Connection connection = null;
        Statement statement = null;
        boolean update = false;
        String sql = "UPDATE Artists SET Artists.Name ='"+artist.getName()+"' WHERE idArtists= "+artist.getIdArtists();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            update = true;
        } catch (SQLException e){
            System.out.println("Error ArtistsDaoImpl class, UPDATE method");
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public boolean delete(Artist artist) {
        Connection connection = null;
        Statement statement = null;
        boolean delete = false;
        String sql = "DELETE FROM Artists WHERE idArtists= "+artist.getIdArtists();
        try {
            connection = ConnectionClass.connect();
            statement = connection.createStatement();
            statement.execute(sql);
            delete = true;
        } catch (SQLException e){
            System.out.println("Error ArtistsDaoImpl class, DELETE method");
            e.printStackTrace();
        }
        return delete;
    }
}
