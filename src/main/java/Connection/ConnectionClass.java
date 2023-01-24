package Connection;

import java.sql.*;

public class ConnectionClass {
    public static Connection connect(){
        String url = "jdbc:mysql://localhost:3306/music_store_solvd?serverTimezone=UTC";
        String username = "root";
        String password = "akiretioN27#";
        Connection connection = null;

        //System.out.println("INSERT INTO Clients VALUES (NULL,"+"David"+"','"+"Diaz"+"','"+"Street 456"+"','"+"1999-02-27"+"')'");

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
