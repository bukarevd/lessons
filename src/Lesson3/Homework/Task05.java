package Lesson3.Homework;

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = in.nextLine();
        System.out.println("Введите подстроку которую нужно заменить");
        String strRegex = in.nextLine();
        System.out.println("Введите подстроку которой нужно заменить");
        String strRepl = in.nextLine();

        if (string.contains(strRegex)){
            String newString = string.replaceAll(strRegex, strRepl);
            System.out.println(newString);
        }else System.out.println("Данная подстрока в строке отсутствует");
        }

    }

