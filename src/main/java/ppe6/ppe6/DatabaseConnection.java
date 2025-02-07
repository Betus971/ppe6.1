package ppe6.ppe6;

import java.sql.*;
import java.sql.DriverManager;

public class DatabaseConnection {
public Connection databaseLink;

    public Connection getconnection() {
        String databaseName = "ppe6";
        String databaseUser = "root";
        String databasePassword = "dodo";
        String databaseUrl = "jdbc:mysql://127.0.0.1:3306/" + databaseName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();


        }
        return databaseLink;
    }


}
