package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection() throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/library_db";
        String USERNAME = "root";
        String PASSWORD = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}