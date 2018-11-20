package lesson11.homework2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Task11 LL = new Task11();
        long start = System.currentTimeMillis();
        LL.insert10000(linkedList);
        LL.get10000(linkedList);
        LL.set10000(linkedList);
       // LL.remove10000(linkedList);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        Task11 AL = new Task11();
        start = System.currentTimeMillis();
        AL.insert10000(arrayList);
        LL.get10000(linkedList);
        LL.set10000(linkedList);
        LL.remove10000(linkedList);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }

    private void insert10000(List list){
        for (Integer i = 0; i < 10000; i++) {
            list.add(i);
        }
    }

    private void get10000(List list){
        for (int i = 0; i < 10000; i++){
            list.get(i);
        }
    }

    private void set10000(List list){
        for (int i = 0; i < 10000; i++) {
            list.set(i, i);
        }
    }

    private void  remove10000(List list){
        for (int i = 0; i < 4000; i++)
            list.remove(i);
    }





}
