package lesson3.homework;

import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        string = string.replace(" ", "");
        char[] charString = new char[string.length()];
        string.getChars(0, string.length(), charString, 0);
        for (int i = 0; i < charString.length -1; i++){
            for (int j = i + 1; j < charString.length; j++)
            if (charString[i] == charString[j]) charString[j] = ' ';
        }
        string = string.copyValueOf(charString);
        string = string.replace(" ", "");
        System.out.println(string);
    }
}
