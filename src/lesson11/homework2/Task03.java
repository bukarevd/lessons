package lesson11.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Task03 task03 = new Task03();
        task03.printList(task03.CreateArray());
    }

    private ArrayList<String> CreateArray(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while (arrayList.size() < 10) {
            arrayList.add(in.nextLine());
        }

        ArrayList<String> doubleArrayList = new ArrayList<>();
        for (String x : arrayList){
            doubleArrayList.add(x);
            doubleArrayList.add(x);
        }
        return doubleArrayList;
    }

    private void printList(ArrayList<String> tArrayList){
        for (String x: tArrayList) {
            System.out.println(x);
        }
    }
}
