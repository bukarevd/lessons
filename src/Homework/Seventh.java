package Homework;

public class Seventh {
    public static void main(String[] args) {
        int num = 581;
        int x = 0;
        while (num >= 1) {
            if (x < num % 10) x = num % 10;
            num = num / 10;


        }
      System.out.println("Наибольшая цифра в числе: " + x);
    }
}