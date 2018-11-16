package lesson11.homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int M = in.nextInt();
        if (N < M) return;
        else {
            ArrayList<String> arrayList = new ArrayList<>();
            while (arrayList.size() < N) arrayList.add(in.next());
            System.out.println(arrayList.toString());
            for (int i = 0; i < M; i++){
            arrayList.add(arrayList.get(i));
        }
            if (M > 0) {
                arrayList.subList(0, M).clear();
            }
            System.out.println(arrayList.toString());
        }
    }
}
