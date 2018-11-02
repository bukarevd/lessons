package lesson4.homework.task01;


public class Main {
    public static void main(String[] args) {
        Figures triangle = new Figures(10, 2, 3, 4, 5, 6);
        System.out.println(triangle.getTrianglePerimetr());
        System.out.println(triangle.getTriangleArea());

        Figures rectangle = new Figures(1, 5, 6, 8, 4, 0);
        System.out.println(rectangle.getRectamglePerimetr());
        System.out.println(rectangle.getRectangleArea());

        Figures circle = new Figures(2, 5, 6, 7);
        System.out.println(circle.getCirclePerimetr());
        System.out.println(circle.getCircleArea());

    }
}
