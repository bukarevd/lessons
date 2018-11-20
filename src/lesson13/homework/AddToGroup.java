package lesson13.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddToGroup {
    static void AddToGroup(){
        Scanner in = new Scanner(System.in);
        String groupname = in.next();
        int userid = in.nextInt();
        String sql = "INSERT INTO usergroup (groupname, userid) VALUES (?, ?);";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb?" +
                        "useSSL=false", "chatuser", "cde14af78")) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, groupname);
            preparedStatement.setString(2, Integer.toString(userid));
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
