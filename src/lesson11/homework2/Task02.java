package lesson11.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task02 {
    private static ArrayList<Integer> integerArrayList2 = new ArrayList<>();
    private static ArrayList<Integer> integerArrayList3 = new ArrayList<>();
    public static void main(String[] args) {
        createArray();
        printList();
        printList("integerArrayList2");
        printList("integerArrayList3");
    }

    private static void createArray(){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (integerArrayList.size() < 10) {
            integerArrayList.add(in.nextInt());
        }

        for (Integer x: integerArrayList) {
            if (x % 2 == 0) integerArrayList2.add(x);
            if (x % 3 == 0) integerArrayList3.add(x);
        }
    }

    private static void printList(){
        System.out.println(integerArrayList2);
        System.out.println(integerArrayList3);
    }
    private static void printList(String listName){
        if (listName.equals("integerArrayList2")) System.out.println(integerArrayList2);
        if (listName.equals("integerArrayList3")) System.out.println(integerArrayList3);
    }


}
