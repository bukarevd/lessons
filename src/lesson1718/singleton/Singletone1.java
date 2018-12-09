package lesson1718.singleton;

public class Singletone1 {
    private static Singletone1 instance;
//    запрет создания объектов вне классов
    private Singletone1(){}
//    создание объекта по требованию
    public static Singletone1 getInstance() {
        if (instance == null) {
            instance = new Singletone1();
        }
        return instance;
    }

}
