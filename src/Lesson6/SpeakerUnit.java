package Lesson6;

public interface SpeakerUnit {

    void say(String text);
    void sing(String song);

    default void greeting(){
        //default метод с реализацией
        System.out.println("Hello");
    }
}
