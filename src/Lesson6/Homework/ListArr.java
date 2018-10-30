package Lesson6.Homework;

import java.util.Arrays;
import java.util.Scanner;

public class ListArr implements List, Stack, Queue{
    Scanner in = new Scanner(System.in);
    int arrSize = in.nextInt();
    Object[] obj = new Object[arrSize];


    @Override
    public void add(Object obj, int index) {
        this.obj[index] = obj;
    }

    @Override
    public void remove(int index) {
        this.obj[index] = null;
    }

    @Override
    public Object get(int index) {
        return this.obj[index];
    }

    @Override
    public void size() {
        System.out.println(Arrays.toString(obj));
    }

    @Override
    public void shift(Object obj) {

    }

    @Override
    public void unshift() {

    }

    @Override
    public void push(Object obj) {

    }

    @Override
    public void pop() {

    }
}
