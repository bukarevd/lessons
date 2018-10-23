package Lesson3.Homework;

import java.util.Arrays;
import java.util.Random;

public class Task03 {
    public static void main(String[] args) {
        int[] intArr = new int[15];
        Random rnd = new Random();
        int count = 0;

        for (int i = 0; i < intArr.length; i++)
            intArr[i] = rnd.nextInt(10);
        System.out.println(Arrays.toString(intArr));

        for (int num: intArr)
            if (num % 2 == 0)
                count++;

        System.out.println(" Количество четных чисел в массиве: " + count);
    }
}
