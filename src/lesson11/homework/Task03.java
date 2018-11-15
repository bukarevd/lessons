package lesson11.homework;

public class Task03 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Dog1");
        Dog dog2 = new Dog(10, "Black");
        Dog dog3 = new Dog(10, "Black");
        Dog dog4 = new Dog(10, "Black");
        Dog dog5 = new Dog(10, "Black");
        System.out.println(Dog.getDogCount());
    }
}
