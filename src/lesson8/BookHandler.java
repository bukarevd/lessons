package lesson8;

//import org.sqlite.JDBC;

import java.sql.*;

public class BookHandler {
  /*  public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Book (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "title TEXT NOT NULL, " +
                "pages INTEGER NOT NULL);";

        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        }
    }

    public static void insertIntoTable(Book book) throws SQLException {
        String sql = "INSERT INTO Book (title, pages)VALUES (?, ?);";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPages());
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        }
    }

    public static Book selectData(int id) throws SQLException {
        String sql = "SELECT * FROM Book WHERE id = ?;";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Book book = new Book();
            while (resultSet.next()) {
                String str = resultSet.getString("title");
                int i = resultSet.getInt("pages");
                book.setTitle(str);
                book.setPages(i);
               // System.out.println("str = " + str);
               // System.out.println("int = " + i);

            }
            return book;
        }
    }


    public static void main(String[] args) {

        Book book = new Book("Азбука", 500);
        Book book2 = new Book("Азбука 2", 500);

        try {
           // BookHandler.createTable();
//            BookHandler.insertIntoTable(book2);
            System.out.println(BookHandler.selectData(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }*/
}
