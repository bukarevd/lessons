package Lesson4.homework.task01.task02;

public class List {
    Node[] arrList = new Node[10];

    public void add(Node node){
        for (int i = 0; i < arrList.length; i++){
            if (arrList[i] == null){
                if (i != 0) ;
                arrList[i] = node;
            }
        }
    }

    public void remove(List node){

    }
}
