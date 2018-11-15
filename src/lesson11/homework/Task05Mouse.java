package lesson11.homework;

public class Task05Mouse implements Task05Movable, Task05Eatable{
    public void Eatable(){
        System.out.println("Eatable");
    }
    public void Move(){
        System.out.println("Move");
    }

    public static void main(String[] args) {
        Task05Mouse mouse = new Task05Mouse();
        mouse.Move();
        mouse.Eatable();
    }
}
