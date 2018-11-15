package lesson11;

import java.util.ArrayList;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*Ввести с клавиатуры 5 слов в список строк.
        Удалить 3 - ий элемент списка, и вывести оставшиеся элементы в обратном порядке.*/

        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (i < 5) {
            arrayList.add(in.nextLine());
            i++;
        }
        System.out.println(arrayList.toString());
        arrayList.remove(2);
        for (int j = arrayList.size() - 1; j >= 0; j--){
            System.out.print(arrayList.get(j));
        }
    }
}
