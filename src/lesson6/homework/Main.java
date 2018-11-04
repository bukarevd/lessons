package lesson6.homework;

public class Main {
    public static void main(String[] args) {
        ListArr first = new ListArr();
        first.add(new TestObject(), 0);
        first.add(new TestObject(), 1);
        first.add(new TestObject(), 2);
        first.add(new TestObject(), 8);
        System.out.println(first.toString());
        first.remove(2);
        first.size();
        first.get(8);
        System.out.println(first.toString());
        first.push(new TestObject());
        System.out.println(first.toString());
        first.pop();
        System.out.println(first.toString());
        first.shift(new TestObject());
        System.out.println(first.toString());
        first.unshift();
        System.out.println(first.toString());
    }
}
