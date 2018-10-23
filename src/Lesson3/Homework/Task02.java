package Lesson3.Homework;



import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        int[] intArr = new int[50];

        for (int i =1, j = 0; i < 100; i += 2, j++){
            intArr[j] = i;
        }
        for (int i = 0; i < intArr.length; i++)
            System.out.print(intArr[i] + " ");

        System.out.println();

        for (int i = intArr.length - 1;  i >= 0; i--)
            System.out.print(intArr[i] + " ");
    }
}
