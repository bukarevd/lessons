package lesson2.homework;

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pointX1 = in.nextInt();
        int pointY1 = in.nextInt();
        int pointX2 = in.nextInt();
        int pointY2 = in.nextInt();
        int pointX3 = in.nextInt();
        int pointY3 = in.nextInt();

        double p1 = Math.pow ((pointX1 - pointX2), 2) + Math.pow((pointY1 - pointY2), 2);
        double p2 = Math.pow ((pointX2 - pointX3), 2) + Math.pow((pointY2 - pointY3), 2);
        double p3 = Math.pow ((pointX1 - pointX3), 2) + Math.pow((pointY1 - pointY3), 2);

        if ((p1 == p2 + p3) | (p2 == p1 + p3) | (p3 == p1 + p2))
            System.out.println("Треугольник прямой");
        else System.out.println("Треугольник не прямой");
    }
}
