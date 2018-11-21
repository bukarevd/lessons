package lesson14.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try {
            Calculator.enterData();
        } catch (CheckerEx | ArithmeticException e) {
            e.getMessage();
        }
    }


    protected static void enterData() throws CheckerEx, ArithmeticException {
        int x, y;
        Scanner in = new Scanner(System.in);
        String oper;
        try {
            System.out.print("> x = ");
            x = in.nextInt();
            System.out.print("> y = ");
            y = in.nextInt();
            System.out.print("> ");
            oper = in.next();
        } catch (InputMismatchException e) {
            throw new CheckerEx("InputMismatchException1111");
        }
        switch (oper) {
            case "+":
                System.out.println(x + y);
                break;
            case "-":
                System.out.println(x - y);
                break;
            case "*":
                System.out.println(x * y);
                break;
            case "/":
                System.out.println(x / y);
            default:
                return;
        }
    }

}
