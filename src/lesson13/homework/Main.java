package lesson13.homework;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //User user1 = new User(in.next(), in.next(), in.next());
//        User user2 = new User(in.next(), in.next(), in.next());
//        user1.SendMessage(user2);
        User.AddToGroup(new User());
    }


}
