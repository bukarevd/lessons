package Lesson3.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        int min = -5, max = 5;
        int sumleft = 0, sumright = 0;
        System.out.println("Введите четное положительное число");
        while (true){
            num = in.nextInt();
            if ((num % 2) == 0 && num > 0) {
                int[] intArr = new int[num];
                for (int i = 0; i < intArr.length; i++){
                    intArr[i] = min + (int)(Math.random() * ((max - min) + 1));
                }
                System.out.println(Arrays.toString(intArr));
                for (int j = 0; j < (intArr.length / 2); j++){
                    sumleft += Math.abs(intArr[j]);
                }
                for (int j = (intArr.length / 2); j < intArr.length; j++){
                    sumright += Math.abs(intArr[j]);
                }
                if (sumleft > sumright) System.out.println("Больше левая часть массива");
                else if (sumleft < sumright) System.out.println("Больше правая часть массива");
                else System.out.println("Обе части массива равны");
                break;
            } else {
                System.out.println("Введите число заново");
            }
        }





    }
}
