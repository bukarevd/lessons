package lesson11.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (stringList.size() < 10)
            stringList.add(in.nextLine());
        for (int i = 0; i < stringList.size() - 1; i++){
            if (stringList.get(i).length() > stringList.get(i+1).length())
            {
                System.out.println(stringList.get(i));
                break;
            }
            else System.out.println("true");
        }
    }
}
