package lesson2.homework;

import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner plates = new Scanner(System.in);
        int platesNum = plates.nextInt();
        Scanner cleanser = new Scanner(System.in);
        float cleanserNum = cleanser.nextFloat();
        int countPlates = 0;
        for (int i = 0; i < platesNum; i++){
            if (cleanserNum == 0) break;
            else {
                 countPlates++;
                 cleanserNum -= 0.5;
            }
        }
        if (platesNum - countPlates > 0){
            System.out.println("Осталось не помытых тарелок " + (platesNum - countPlates));
        }
        else{
            System.out.println("Все тарелки помыты, осталось " + cleanserNum + " средства");
        }
    }
}
