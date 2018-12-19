package lesson24;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {

    private static int SomeValue = 12;

    public static void main(String[] args) {
//        синтаксис
//        (аргументы)->тело;
//        ()->тело;
//        ()->{
//        тело на несколько строк
//        [return значение]
//        };

//        (a, b)->a+b; вернет результат a+b
//        (a, b)->{
//
//        return a+b;
//        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });

        new Thread(() -> System.out.println("lambda"));
        Runnable runnable = () -> System.out.println("lambda");
        new Thread(runnable);

        Operation plus = (a, b) -> a + b;
        Operation minus = (a, b) -> a - b;

        double result = plus.execute(12, 12);

        int someLocalVar = 12;

        Operation operation = (a, b) -> {
            SomeValue -= a;
//            someLocalVar += b; //нельзя локальные переменные не final
            return SomeValue;
        };


//        ссылка на метод через нотацию (::)
        ButtonFactory<Button> factory = Button::new;
        Button button = factory.set("Cancel", "pink");
        System.out.println(button);


//        предикаты
        Predicate<Integer> pos = (num) -> num > 0;
        Predicate<Integer> neg = (num) -> num < 0;
        boolean pos1 = pos.test(4);
        boolean neg1 = neg.test(23);

        pos1 = pos.or(neg).test(2);
        System.out.println(pos1);
        pos1 = pos.and(neg).test(2);
        System.out.println(pos1);

        Button.testVoid(pos, 3);

//        Функции
        Function<Integer, Integer> PlusTen = (num) -> num + 10;
        Function<Integer, Integer> PlusSix = (num) -> num + 6;
        Integer res = PlusTen.apply(10);
        System.out.println(res);
        res = PlusSix.andThen(PlusTen).andThen(PlusSix).apply(10);
        System.out.println(res);

//        Consumer
        Consumer<Button> makeResetButton = (button1) -> button1.setValue("Reset");
        makeResetButton.accept(button);
        System.out.println(button);

//        Компараторы
        Button button1 = new Button("button1", "red");
        Button button2 = new Button("button2", "green");

        Comparator<Button> buttonComparator =
                Comparator.comparing(Button::getValue);
//                (b1, b2)->b1.getValue().compareTo(b2.getValue());
        int compareRes = buttonComparator.compare(button1, button2);
        System.out.println(compareRes);


//        forEach(лямбда выражение)
        List<Integer> integers = new ArrayList<>(Arrays.asList(23, 67, 12, -12, 0));
        List<Integer> integers1 = new ArrayList<>();
        integers.forEach((s) -> System.out.println(s + " "));
        integers.forEach((s) -> integers1.add(s + 10));
        System.out.println(integers1);

//        removeIf()

        integers.removeIf((s) -> s < 20);
        integers.removeIf(pos);
        System.out.println(integers);

//        Map.forEach()
        Map<String, String> books = new HashMap<>();
        books.put("book 1", "Author 1");
        books.put("book 2", "Author 2");
        books.forEach((a, b) -> System.out.println(a + " = " + b));

//        Map.compute()
        books.compute("book 1", (key, val) -> val + " еще один автор ");
        System.out.println(books);

//      Map.computeIfAbsent
        books.computeIfAbsent("book 1", (val) -> val + " еще один автор ");
        System.out.println(books);

        books.computeIfPresent("book 1", (key, val) -> val + " еще один автор ");
        System.out.println(books);

//        Map.getOrDefault()
        String def = books.getOrDefault("book 3", "default");
        System.out.println(def);



    }


}

// Функциональный интерфейс(1 абстрактный метод)
@FunctionalInterface
interface Operation {
    double execute(int a, int b);
}

interface ButtonFactory<T extends Button> {
    T set(String value, String color);
}

class Button {
    private String value;
    private String color;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Button(String value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Button{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void testVoid(Predicate<Integer> predicate, int i) {
        predicate.test(i);
    }
}
