package lesson11.homework;

public class Task05Dog implements Task05Eat, Task05Movable {
    public void Eat(){
        System.out.println("Eat");
    }
    public void Move(){
        System.out.println("Move");
    }

    public static void main(String[] args) {
        Task05Dog dog = new Task05Dog();
        dog.Move();
        dog.Eat();
    }
}
