package lesson7.anonimysClass;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc(2 ,4);
        calc.summ(new Operations() {
            @Override
            public double apply(double val1, double val2) {
                return val1 + val2;
            }
        });
    }
}
