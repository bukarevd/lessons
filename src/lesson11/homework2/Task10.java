package lesson11.homework2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Task10 {
    public static void main(String[] args) {
        Set<Integer> set= new HashSet<>();
        Scanner in = new Scanner(System.in);
        while (set.size() < 5) set.add(in.nextInt());
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            if(iterator.next() > 10) iterator.remove();
        }
        System.out.println(set);
    }
}
