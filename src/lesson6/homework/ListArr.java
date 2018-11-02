package lesson6.homework;

import java.util.Arrays;
import java.util.Scanner;

public class ListArr implements List, Stack, Queue{
    Scanner in = new Scanner(System.in);
    int arrSize = in.nextInt();
    TestObject[] obj = new TestObject[arrSize];


    @Override
    public void add(Object obj, int index) {
        TestObject object = (TestObject)obj;
        if(index == this.obj.length) {
           this.obj[index] = object;
           this.obj[index -1].setNextObj(object);
       }else {
           this.obj[index] = object;
           object.setNextObj(this.obj[index + 1]);
           if(index > 0)
           this.obj[index -1].setNextObj(object);
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
        int count = 0;
        for (int i = 0; i < obj.length; i++){
            if (obj[i] != null) count++;
        }
        System.out.println(count);
    }

    @Override
    public void shift(Object obj) {

    }

    @Override
    public void unshift() {

    }

    @Override
    public void push(Object obj) {
        TestObject tempObjArr[] = new TestObject[this.obj.length + 1];
        TestObject object = (TestObject) obj;
        for (int i = 0; i < this.obj.length; i++){
            tempObjArr[i] = this.obj[i];
        }
        this.obj = tempObjArr;
       // add(obj, this.obj.length);
    }

    @Override
    public void pop() {

    }

    @Override
    public String toString() {
        return "ListArr{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}
