package Lesson6.Calculator;

public class Minus extends Operation{

    private int a, b;
    public Minus(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void exucute() {
        System.out.println("Minus = " + (a - b));
    }
}
