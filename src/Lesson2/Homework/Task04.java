package Lesson2.Homework;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numb = in.nextInt();
        int count = 0;

        for (int i = 2; i < numb; i++){
             for (int j = i; j < numb; j++) {
                 if (numb % i == 0) {
                     count++;
                     break;
                 }
             }
        }
        if (count == 0) System.out.print("Число " + numb + " простое");
    }
}
