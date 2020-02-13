package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {


    public Connection getConnection(){
        Connection connection;
        String dbName = "online_shop";
        String user="root";
        String pass ="12345678";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName +"?useLegacyDatetimeCode=false&serverTimezone=America/New_York", user, pass); //tu specifikovat aj port!! v skole asi 3308
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
