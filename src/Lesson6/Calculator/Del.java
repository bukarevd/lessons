package Lesson6.Calculator;

public class Del extends Operation {

    private int a, b;

    public Del(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void exucute() {
        if (b == 0){
            System.out.println("Error /0");
            return;
        }
        else System.out.println("Del = " + (a / b));
    }
}
