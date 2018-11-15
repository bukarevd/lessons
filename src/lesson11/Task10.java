package lesson11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task10 {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            hashSet.add(i);
        }
        System.out.println(hashSet.toString());
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 10) {
                iterator.remove();
            }
        }

        System.out.println(hashSet.toString());
    }
}
