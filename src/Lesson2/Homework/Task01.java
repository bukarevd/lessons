package Lesson2.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        int[] number = new int[3];
        Scanner inputNum = new Scanner(System.in);
        for(int i = 0; i < number.length; i++){
            number[i] = inputNum.nextInt();

        }
//        Arrays.sort(number);
       for(int i = number.length -1; i > 0; i--) {
           for (int j = 0; j < i; j++) {
               if (number[j] > number[j + 1]) {
                   int temp = number[j];
                   number[j] = number[j + 1];
                   number[j + 1] = temp;
               }
           }
       }
        System.out.print("Отсортированный массив: ");
        for(int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }
    }
}
