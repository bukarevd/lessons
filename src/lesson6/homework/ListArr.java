package lesson6.homework;

import java.util.Arrays;
import java.util.Scanner;

public class ListArr implements List, Stack, Queue {
    private Scanner in = new Scanner(System.in);
    private int arrSize = in.nextInt();
    private TestObject[] obj = new TestObject[arrSize];


    @Override
    public void add(Object obj, int index) {
        TestObject object = (TestObject) obj;
        if (index == this.obj.length - 1) {
            this.obj[index] = object;
            if (this.obj[index - 1] != null)
                this.obj[index - 1].setNextObj(object);
            for (int i = index; i > 0; i--) {
                if (index > 0 && this.obj[i - 1] != null) {
                    this.obj[i - 1].setNextObj(object);
                    break;
                } else continue;
            }
        } else {
            this.obj[index] = object;
            object.setNextObj(this.obj[index + 1]);
            for (int i = index; i > 0; i--) {
                if (index > 0 && this.obj[i - 1] != null) {
                    this.obj[i - 1].setNextObj(object);
                    break;
                } else continue;
            }
        }


    }

    @Override
    public void remove(int index) {
        this.obj[index] = null;
        for (int i = index; i < this.obj.length - 1; i++) {
            if (obj[i + 1] == null) {
                continue;
            } else {
                obj[index - 1].setNextObj(obj[i + 1]);
            }
        }
    }

    @Override
    public void get(int index) {

        System.out.println(this.obj[index].toString());
    }

    @Override
    public void size() {
        int count = 0;
        for (TestObject anObj : this.obj) {
            if (anObj != null) count++;
        }
        System.out.println(count);
    }

    @Override
    public void shift(Object obj) {
        TestObject tempObjArr[] = new TestObject[this.obj.length + 1];
        int[] index = new int[this.obj.length];
        tempObjArr[0] = (TestObject) obj;
        int i = 1;
        for (TestObject anObj : this.obj) {
            tempObjArr[i++] = anObj;
        }
        tempObjArr[0].setNextObj(tempObjArr[1]);
        this.obj = tempObjArr;


    }

    @Override
    public void unshift() {
        TestObject tempObjArr[] = new TestObject[this.obj.length - 1];
        for (int i = 1; i < this.obj.length; i ++){
            tempObjArr[i -1] = this.obj[i];
        }
        this.obj = tempObjArr;

    }

    @Override
    public void push(Object obj) {
        TestObject tempObjArr[] = new TestObject[this.obj.length + 1];
        TestObject object = (TestObject) obj;
        for (int i = 0; i < this.obj.length - 1; i++) {
            tempObjArr[i] = this.obj[i];
        }
        this.obj = tempObjArr;
        add(object, this.obj.length - 1);
    }

    @Override
    public void pop() {
        this.obj[this.obj.length - 1] = null;
        for (int i = this.obj.length - 1; i > 0; i--) {
            if (this.obj[i - 1] != null) {
                this.obj[i - 1].setNextObj(null);
                break;
            } else continue;
        }

    }

    @Override
    public String toString() {
        return "ListArr{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}
