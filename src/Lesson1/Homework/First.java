package Lesson1.Homework;

public class First {
    public static void main(String[] args) {
        int height = 50;
        int width = 40;
        int length = 50;

        int S = 2*(height * length + length * width + height * width);
        System.out.println("Площадь = " + S);

       String answer = (width > height) ? "Больше ширина" : "Больше высота";
       System.out.println(answer);
    }
}
