package lesson13;

import lesson8.JDBCExample;

import java.sql.*;

public class MysqlConnect {
//    String connectUrl = "jdbc:mysql://localhost:3306/dbname";
//    String user = "root";
//    String password = "";

    public static void createTable() throws SQLException, ClassNotFoundException {

        String sql = "CREATE TABLE IF NOT EXISTS dbname (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "firstColumn TEXT NOT NULL, " +
                "secondColumn INTEGER NOT NULL);";

        //DriverManager.registerDriver(new JDBC());
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname?useSSL=false",
                "root","cde14af78")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }


//    public static void insertIntoTable() throws SQLException {
//        String sql = "INSERT INTO Example (firstColumn, secondColumn)" +
//                "VALUES ('Value 1', 123);";
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
//            Statement statement = connection.createStatement();
//            int row = statement.executeUpdate(sql);
//            System.out.println(row);
//        }
//    }
//
//    public static void selectData() throws SQLException {
//        String sql = "SELECT * FROM Example;";
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                String str = resultSet.getString("firstColumn");
//                int i = resultSet.getInt("secondColumn");
//                System.out.println("str = " + str);
//                System.out.println("int = " + i);
//            }
//        }
//    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
          createTable();
        //  JDBCExample.insertIntoTable();
        //JDBCExample.selectData();
    }


}
