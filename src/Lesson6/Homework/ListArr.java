package Lesson6.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class ListArr implements List, Stack, Queue{
    Scanner in = new Scanner(System.in);
    int arrSize = in.nextInt();
    TestObject[] obj = new TestObject[arrSize];


    @Override
    public void add(TestObject obj, int index) {
       if(index == this.obj.length) {
           this.obj[index] = obj;
           this.obj[index -1].setNextObj(obj);
       }else {
           this.obj[index] = obj;
           obj.setNextObj(this.obj[index + 1]);
           if(index > 0)
           this.obj[index -1].setNextObj(obj);
       }

    }

    @Override
    public void remove(int index) {
        this.obj[index] = null;
        for (int i = index; i < this.obj.length - 1; i++){
            obj[i] = obj[i + 1];
        }
        if (index > 0)
        obj[index-1].setNextObj(obj[index]);
    }

    @Override
    public TestObject get(int index) {
        return this.obj[index];
    }

    @Override
    public void size() {
        System.out.println(Arrays.toString(obj));
    }

    @Override
    public void shift(TestObject obj) {

    }

    @Override
    public void unshift() {

    }

    @Override
    public void push(TestObject obj) {

    }

    @Override
    public void pop() {

    }
}
