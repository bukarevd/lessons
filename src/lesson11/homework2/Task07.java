package lesson11.homework2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);
        Map<String, String> stringMap = new HashMap<>();
        while (stringMap.size() < 10) stringMap.put(in.next(), in.next());
        System.out.println(stringMap.toString());
        final String name = in.next();
        final String surname = in.next();
        for (Map.Entry<String, String> entry : stringMap.entrySet()){
            if(entry.getKey().equals(name) || entry.getValue().equals(surname)){
                count++;
            }
        }
        System.out.println(count);


    }
}
