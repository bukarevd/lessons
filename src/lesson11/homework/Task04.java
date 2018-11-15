package lesson11.homework;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        double weight;
        double height;
        Scanner in = new Scanner(System.in);
        weight = in.nextDouble();
        height = in.nextDouble();
        in.close();
        Body(weight, height);


    }

    static void Body(double weight, double height) {
        double index = weight / (height * height);
        if (index < 18.5)
            System.out.println("Недовес: меньше чем 18.5");
        else if (index >= 18.5 || index < 24.9) System.out.println("Нормальный: между 18.5 и 24.9");
        else if (index >= 25 || index < 29.9) System.out.println("Избыточный вес: между 25 и 29.9");
        else System.out.println("Ожирение: 30 или больше");
    }
}
