package lesson2;

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
//        конструкция if
 /*       Scanner in = new Scanner(System.in);
        System.out.println("Введите код");
        int code = in.nextInt();
        if (code == 123){
            System.out.println("Вы вошли как адм.");
        } else if (code == 345) {
            System.out.println("Вы вошли как гость.");
        }
        else {
            System.out.println("Код не верный");
        }
*/
//        Switch (оператор выбора) значение case cons(case 333333)
 /*       Scanner in2 = new Scanner(System.in);
        int userTicketNum = in2.nextInt();
        String prize;
        switch (userTicketNum){
            case 333333:
                prize = "Большой приз";
                break;
            case 333334:
            case 333335:
                prize = "Средний приз";
                break;
            case 333336:
            case 333337:
            case 333338:
                prize ="Средний приз";
                break;
            default:
                prize = "0";

        }
        System.out.println("Вы получили: " + prize);

*/
//              While
        int messageCount = 5;
        while (messageCount > 0) {
            System.out.println("Сообщение №" + messageCount);
            messageCount--;
        }

        Scanner in3 = new Scanner(System.in);
//        while (in3.nextInt() != 123){
//            System.out.println("Enter code!!");
//        }
//
          /*  while (true){

                int code3 =in3.nextInt();
                if (code3 == 123){
                    System.out.println("Вы вошли как адм.");
                    in3.close();
                    break;
                } else if (code3 == 345) {
                    System.out.println("Вы вошли как гость.");
                    in3.close();
                    break;
                }
                else {
                    System.out.println("Код не верный");
                }
            }

            // do - while
            do {
                System.out.println("False");
            }while (false);
*/
            //цикл for (инициализация; проверка условия; шаг;)
/*
            for (int x = 1; x < 11; x += 2){
                System.out.println(x);
            }

            for(int i = 0; i < 3; i++){
                System.out.println("i=" + i);
                for (int j = 0; j < 3; j++){
                    System.out.println("j=" + j);
                    if (j == 2) break;
                }
            }*/



        outer: for(int i = 0; i < 3; i++){
            System.out.println("i=" + i);
            for (int j = 0; j < 3; j++){
                System.out.println("j=" + j);
                if (j == 2) break outer;
            }
        }
    }
}
