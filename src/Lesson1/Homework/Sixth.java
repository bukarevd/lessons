package Lesson1.Homework;

public class Sixth {
    public static void main(String[] args) {
        float a = 1.0F;
        float b = 12.0F;
        float c = 36.0F;

        float d = (b * b) - (4 * a * c);

        if (d < 0){
            System.out.println("Корнит отсутствуют");
        }
        else if (d == 0){
            float x = -b / (2 * a);
            System.out.println("Корень уравнения: " + x);
        }
        else{
            float x1 = (float) ((-b + Math.sqrt(d))/(2 * a));
            float x2 = (float) ((-b - Math.sqrt(d))/(2 * a));
            System.out.println("Корни уровнения: " + x1 + " и " + x2);
        }
    }
}
