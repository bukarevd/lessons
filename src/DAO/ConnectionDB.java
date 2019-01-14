package DAO;

import org.sqlite.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionDB {
    public static void createTables() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        String UserDB = "CREATE TABLE IF NOT EXISTS User (id INTEGER PRIMARY KEY NOT NULL, login TEXT NOT NULL);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:DAO.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(UserDB);
            System.out.println(row);
        }
    }
}
