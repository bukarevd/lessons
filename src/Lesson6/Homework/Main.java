package Lesson6.Homework;

public class Main {
    public static void main(String[] args) {
        ListArr first = new ListArr();
        first.add(new TestObj(), 1);
        System.out.println(first.get(1));
        first.remove(1);
        first.size();
    }
}
