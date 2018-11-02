package lesson4.homework.task02;

import java.util.Arrays;

public class List {
    Node[] arrList = new Node[10];
    Node temp;


    public void add(Node node) {
        for (int i = 0; i < arrList.length; i++) {
            if (arrList[i] == null) {
                if (i != 0 && i < arrList.length) {
                    node.setNextNode(arrList[i+1]);
                    arrList[i] = node;
                     temp = arrList[i-1];
                     temp.setNextNode(arrList[i]);
                    break;
                } else {
                    arrList[i] = node;
                    break;
                }
            }
        }

    }

    public void remove(int index){
        if (index == 0){
            arrList[index] = null;
        } else {
            temp = arrList[index - 1];
            arrList[index] = null;

            for (int i = index; i < arrList.length; i++){
                if (arrList[i] == null) {
                    continue;
                }
                else {
                    temp.setNextNode(arrList[i]);
                    break;
                }
            }
        }
    }


    public void showArrList() {
        System.out.println(Arrays.toString(arrList));
    }


}

