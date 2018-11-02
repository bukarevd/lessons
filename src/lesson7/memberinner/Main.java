package lesson7.memberinner;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("Outerclass");
        outerClass.getInnerClass().someVoid();
        System.out.println(outerClass.intVal);
    }
}
