package lesson13.homework;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class User {
    String name;
    String pwd;
    String email;

    public User() {
        this.name = "denis";
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public User(String name, String pwd, String email) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        String sql = "SELECT * FROM user WHERE name = ?";
        System.out.println(getName());
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb?useSSL=false",
                "chatuser", "cde14af78")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getName());
            preparedStatement.execute();
            System.out.println("Пользователь с таким именем уже зарегистрирован");
            Main.main(null);
        } catch (SQLException e) {
            System.out.println("Registration.....");
            RegisterUser.RegisterUser(getName(), getPwd(), getEmail());
            System.out.println("Success.....");
        }
    }

    protected void SendMessage(User reception) {
        System.out.println("Input message");
        Scanner in = new Scanner(System.in);
        String msg = in.next();
        Date date = new Date();
        String sql = "INSERT INTO message (text, date, sender, recepient, visible) VALUES (?, ?, ?, ?, ?);";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb?useSSL=false",
                "chatuser", "cde14af78")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, msg);
            preparedStatement.setString(2, date.toString());
            preparedStatement.setString(3, getName());
            preparedStatement.setString(4, reception.getName());
            preparedStatement.setString(5, "true");
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void AddToGroup(User user) {
        System.out.print("Enter Group name: ");
        ResultSet resultSet;
        Scanner in = new Scanner(System.in);
        String groupname = in.next();
        String sql = "SELECT id FROM User WHERE name = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb?useSSL=false",
                "chatuser", "cde14af78")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sql = "INSERT INTO usergroup (groupname, userid) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, groupname);
                preparedStatement.setString(2, resultSet.getString("id"));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


//
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb?useSSL=false",
//                "chatuser", "cde14af78")) {
//
//            System.out.println(row);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
    }
}
