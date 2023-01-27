package Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionClass {
    public static Connection connect(){

        String url = new String();
        String username = new String();
        String password = new String();

        try(InputStream input = ConnectionClass.class.getClassLoader().getResourceAsStream("db.properties")){
            Properties properties = new Properties();
            if(input == null){
                System.out.println("Unable to access DB properties file");
            }
            properties.load(input);
            username = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
            url = properties.getProperty("db.url");

        } catch(IOException e){
            e.printStackTrace();
        }

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, username, password);
            if (connection!=null){
                System.out.println("Connected to database");
            }
        } catch (SQLException e){
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
        return connection;
    }
}
