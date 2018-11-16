package lesson11.homework2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (map.size() < 3) map.put(in.next(), in.nextInt());
        int money = in.nextInt();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry)it.next();
            if(pair.getValue() < money)
                it.remove();
        }
        System.out.println(map.toString());
    }
}
