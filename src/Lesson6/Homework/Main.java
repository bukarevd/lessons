package Lesson6.Homework;

public class Main {
    public static void main(String[] args) {
        ListArr first = new ListArr();
        first.add(new TestObject(), 0);
        first.add(new TestObject(), 1);
        first.add(new TestObject(), 2);
        first.add(new TestObject(), 3);
        first.remove(3);
        first.size();
    }
}
