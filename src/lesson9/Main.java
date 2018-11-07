package lesson9;

import lesson9.classes.Book;
import lesson9.classes.Car;
import lesson9.classes.ChildBook;
import lesson9.storage.Storage;

public class Main {

    public static void main(String[] args) {
        Book tails = new Book("Сказки", 500);
        Book flowers = new Book("Цветы", 600);

        Car car = new Car("green", 1000);

        Storage<Book> bookStorage = new Storage<>();
        bookStorage.add(tails);
        bookStorage.add(flowers);
//        bookStorage.add(car);

        // ClassCastException возникает на моменте исполнения
        Book bookFromStorage = bookStorage.get(1);
        System.out.println(bookFromStorage);

        Storage<ChildBook> childBookStorage = new Storage<>();
        ChildBook bears = new ChildBook("Bears", 1000, "pic1");
        ChildBook coloring = new ChildBook("Coloring", 30, "pic2");

        childBookStorage.add(bears);
        Book firstBook = getFirstBook(childBookStorage);




        Storage<Car> carStorage = new Storage<>();
        carStorage.add(car);
        Car carFromStorage = carStorage.get(0);

        System.out.println(carFromStorage);

    }

//    public static Book getFirst(Storage<Book> storage){
//        return storage.get(0);
//    }

    public static Book getFirstBook(Storage<? extends Book> storage){ // принимает все типы объектов от родителя(только получить)
        return storage.get(0);
    }

    public static void addToStorage(Storage<? super Book> storage){ // только добавить
        storage.add(new Book("book", 100));
        Object b = storage.get(0);
        System.out.println(b);
    }

    public static void addGet(Storage<?> storage){
//        можно добавить только null, получить только Object
    }



}
