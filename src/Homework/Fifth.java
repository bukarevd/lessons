package Homework;

public class Fifth {
    public static void main(String[] args) {
        float credit = 10000.9F;
        float proc = 10.9F;
        int years = 5;
        float procsum = 0.0F;


        // Если проценты по кредиту прибавляются у сумме кредита
        while (years != 0){
            procsum = procsum + credit * proc / 100;
            credit = credit + procsum;
            years--;
        }
        System.out.println("Итого процентов по кредиту: " + procsum);

    }
}
