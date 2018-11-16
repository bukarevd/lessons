package lesson8;

//import org.sqlite.JDBC;

import java.sql.*;

public class JDBCExample {

/*
    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Example (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "firstColumn TEXT NOT NULL, " +
                "secondColumn INTEGER NOT NULL);";

        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }


    public static void insertIntoTable() throws SQLException {
        String sql = "INSERT INTO Example (firstColumn, secondColumn)" +
                "VALUES ('Value 1', 123);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }

    public static void selectData() throws SQLException {
        String sql = "SELECT * FROM Example;";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String str = resultSet.getString("firstColumn");
                int i = resultSet.getInt("secondColumn");
                System.out.println("str = " + str);
                System.out.println("int = " + i);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        //  JDBCExample.createTable();
      //  JDBCExample.insertIntoTable();
        JDBCExample.selectData();
    }

*/
}
