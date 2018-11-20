package lesson13.homework;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main.start();
    }

    protected static void start(){
        System.out.println("Select: \n 1. Registration \n 2. Login");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
                case 1:
                    User user1 = new User(in.next(), in.next(), in.next());
                    break;
                case 2:
                    System.out.println("logining");
                    break;
                default:
                    System.out.println("EXIT....");
                    break;
            }}catch (InputMismatchException e){
            //System.out.println("SELECT:");
            Main.start();
        }
        //  User user1 = new User(in.next(), in.next(), in.next());
        //User user2 = new User(in.next(), in.next(), in.next());
        //user1.SendMessage(user2);
    }


}
