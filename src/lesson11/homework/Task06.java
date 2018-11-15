package lesson11.homework;

public class Task06 {
    static Task06 task06;
    private Task06() {
        System.out.println(this);

    }

    static Task06 getInstance() {
        task06 = new Task06();
        return task06;
    }


    public static void main(String[] args) {
        getInstance();
        getInstance();
        getInstance();
    }
}
