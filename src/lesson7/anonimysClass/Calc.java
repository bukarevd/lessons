package lesson7.anonimysClass;


public class Calc {
    int a, b;
    public Calc(int a, int b){
        this.a = a;
        this.b = b;
    }

    public double summ(Operations operation){
        return operation.apply(a, b);
    }
}
