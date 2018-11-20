
package lesson11.homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
//        Pattern pattern = Pattern.compile("^-?\\d+$");
        while (!string.equals("exit"))
            if (string.contains(".") && in.hasNextDouble())
                new Task01().print(Double.parseDouble(string));

    }

    public void print(Double d) {
        System.out.println(d);
    }
}


