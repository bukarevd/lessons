package lesson6;

import lesson6.calculator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Knight knight = new Knight(100, 20);
        Spearman spearman = new Spearman(60, 60);

        knight.attack(spearman);

        Doctor doctor = new Doctor(50, 50);
        doctor.attack(spearman);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String UserChoose = scanner.nextLine();
        BattleUnitFactory unitFactory = new BattleUnitFactory();
        BattleUnit unit = unitFactory.create(UserChoose);

        Fight fight = new Fight(unit, spearman);
        fight.fight();
        System.out.println(fight.fightresult());

        int a = 9;
        int b = 3;

        Operation plus = new Plus(a, b);
        plus.exucute();

        Operation minus = new Minus(a, b);
        minus.exucute();

        Operation del = new Del(a, b);
        del.exucute();

    }
}
