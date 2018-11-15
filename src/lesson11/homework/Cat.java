package lesson11.homework;

public class Cat {
    private String name;
    private int age;
    private int weight;
    private int strenght;

    Cat(String name, int age, int weight, int strenght) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strenght = strenght;
    }



    private int getAge() {
        return age;
    }


    private int getWeight() {
        return weight;
    }


    private int getStrenght() {
        return strenght;
    }



    boolean fight(Cat anotherCat) {
        boolean result;
        int liveCat1 = getAge() * getStrenght() + getWeight();
        int liveCat2 = anotherCat.getAge() * anotherCat.getStrenght() + anotherCat.getWeight();
        while (liveCat1 > 0 && liveCat2 > 0) {
            liveCat1 -= anotherCat.getStrenght();
            liveCat2 -= getStrenght();
        }
        result = liveCat1 > 0;
        return result;
    }
}
