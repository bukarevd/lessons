package Lesson3.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        String string = in.nextLine();
        string = string.replace(" ", "");
        char[] charString = new char[string.length()];
        string.getChars(0, string.length(), charString, 0);
        for (int i = 0; i < charString.length; i++)
            for (int num = 0; num < 10; num++)
                if (charString[i] == (char) (num + 48)) count++;

                char[] charArr = new char[count];
                count = 0;

                for (int i = 0; i < charString.length; i++)
                    for (int num = 0; num < 10; num++)
                        if (charString[i] == (char) (num + 48)){
                            charArr[count] = charString[i];
                            count++;
                        }

        System.out.println(Arrays.toString(charArr));


    }
}
