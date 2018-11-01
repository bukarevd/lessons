package Lesson7.memberinner2;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        Iterator iterator = myArray.evenIteranot();
        while (iterator.hasNext())
        System.out.println(iterator.next());
    }
}
