package lesson1.homework;

public class fourth {
    public static void main(String[] args) {
        float n = 6.4F;
        float m = 11.9F;
        if (Math.abs(10 - n) == Math.abs(10 - m)) {
            System.out.println("Числа на одинаковом расстоянии");
        } else {
            String s = (Math.abs(10 - n) < Math.abs(10 - m)) ? "Число " + n + " ближе к 10 чем число " + m : "Число " + m + " ближе к 10 чем число " + n;
            System.out.println(s);

        }
    }
}
