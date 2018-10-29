package Lesson6.Calculator;

public class Plus extends Operation {
    private int a, b;

    public Plus(int a ,int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void exucute() {
        System.out.println("Plus = " + (a + b));
    }
}
