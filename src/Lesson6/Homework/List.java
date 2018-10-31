package Lesson6.Homework;

public interface List {
    void add(TestObject obj, int index);
    void remove(int index);
    TestObject get(int index);
    void size();
}
