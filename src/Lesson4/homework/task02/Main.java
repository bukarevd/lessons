package Lesson4.homework.task02;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.setInd(4);

        Node node2 = new Node();
        node2.setInd(6);

        Node node3 = new Node();
        node3.setInd(7);

        List listNodes = new List();
        listNodes.add(node1);
        listNodes.add(node2);
        listNodes.add(node3);

        listNodes.remove(0);

        listNodes.showArrList();
    }
}
