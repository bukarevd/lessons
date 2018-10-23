package Lesson3.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] intArr = new int[num];
        int min = -5, max = 5;



        for (int i = 0; i < intArr.length; i++){
            intArr[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        System.out.println(Arrays.toString(intArr));
//
    }
}
