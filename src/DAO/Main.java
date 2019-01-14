package DAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1);
        user1.setLogin("User1");
        User user2 = new User();
        user2.setId(2);
        user2.setLogin("User2");
        UserDao user = new UserDao();
        try {
            ConnectionDB.createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.add(user1);
        user.add(user2);
       // user.getAll();
        user.delete(user1);
       // user.update(user2);
        user.getById(user2);
    }
}
