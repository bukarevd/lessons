package lesson11.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int lenght = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        while (count < 5){
            String string = in.nextLine();
            arrayList.add(string);
            count++;
            if(string.length() > lenght) lenght = string.length();
        }
        ArrayList<String> arrayList1 = new ArrayList<>();
        for (String x: arrayList) {
               if (arrayList1.size() == 0 && x.length() < lenght){
                   arrayList1.add(x);
                   lenght = x.length();

               }
               else if(arrayList1.size() > 0 && x.length() < arrayList.get(0).length()){
                   arrayList1 = new ArrayList<>();
                   arrayList1.add(x);
                   lenght = x.length();
               }
               else if (x.length() == lenght ) arrayList1.add(x);
        }
        String string = in.nextLine();
        if(string.contains("/short string"))
            for (String x: arrayList1){
                System.out.println(x);
            }



    }
}
