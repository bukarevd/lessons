package lesson13.homework;

import java.sql.*;
import java.util.Scanner;

public class RegisterUser {
    protected static void RegisterUser(String name, String pwd, String email) {

        String sql = "INSERT INTO User (name, password, email) VALUES (?, ? , ?);";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb?useSSL=false",
                "chatuser", "cde14af78")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
           preparedStatement.setString(2, pwd);
           preparedStatement.setString(3, email);
           int row = preparedStatement.executeUpdate();
           System.out.println(row);
        } catch (SQLException e) {
            System.out.println("Doublicate data");
        }

    }
}
