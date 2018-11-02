package lesson4.homework.task02;

public class Node {
    int ind = 0;
    Node nextNode = null;

    public void setInd(int ind) {
        this.ind = ind;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ind=" + ind +
                ", nextNode=" + nextNode +
                '}';
    }
}
