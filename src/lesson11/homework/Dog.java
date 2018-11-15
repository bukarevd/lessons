package lesson11.homework;

public class Dog {

    private String name;
    private int weight;
    private int age;
    private String color;
    private String address;
    private static int count = 0;

    Dog(String name) {
        this.name = name;
        this.weight = 10;
        this.age = 10;
        this.color = "Black";
        this.address = "Street";
        count++;
    }

    Dog(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Black";
        this.address = "Street";
        count++;

    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 10;
        this.color = "Black";
        this.address = "Street";
        count++;

    }

    Dog(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = 10;
        this.name = null;
        this.address = null;
        count++;

    }

    public Dog(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.name = "Dog";
        this.age = 10;
        count++;

    }
    static int getDogCount(){
        return count;
    }
}
