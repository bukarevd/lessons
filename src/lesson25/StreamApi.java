package lesson25;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class StreamApi {
    public static void main(String[] args) throws IOException {

//        создание stream
//        сначала устанавливаеются конвеерные методы, потом выполняется терминальный метод.
//        стрим из массива
        Integer[] arr = {15, 45, 44, 45, -12, 0};
        Stream<Integer> arrStream = Arrays.stream(arr);
//      стрим из коллекции
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Stream<Integer> lisrStream = list.stream();
//        метод of
        Stream<String> stringStream = Stream.of("wq", "ef", "fsdfs");

        File file = new File("wp.txt");
        Stream<String> fileStream = Files.lines(file.toPath());

//        примитивы
        IntStream intStream = IntStream.range(12, 23);
        LongStream longStream = LongStream.builder().add(3).add(22).add(33).build();

//        удалить из списка элементов меньше 20
//        каждый элемент увеличить на 10, вывести в отсортированном порядке
        list = new ArrayList<>(Arrays.asList(arr));

        list.stream()
//                удалить элементы меньше 20
                .filter(s -> s > 20)
//                 каждый элемент увеличить на 10
                .map(s -> s + 10)
                .sorted()
                .forEach(System.out::println);

        Optional<Integer> optional = Stream.of(1, 2, 3).filter(s -> s < 5).findFirst();
        Integer i = optional.orElse(0);

        String res = Stream.of("wq", "ef", "fsdfs").reduce("", (k, j) -> k + j);
        System.out.println(res);

//        top10
        Map<String, Long> words = Files.lines(file.toPath())
//                указываем, что стрим должен быть параллельным
                .parallel()
//                убрать знаки препинания
                .map(line -> line.toLowerCase().replaceAll("\\pP", " "))
//                каждую строку разбиваем на слова
                .flatMap(line -> Arrays.stream(line.split(" ")))
//                обрезаем пробелы
                .map(String::trim)
//                убираем невалидные слова
                .filter(word -> !"".equals(word))

                //        groupingBy() -  разделить коллекцию по условию и вернуть
//        Map<N, List<T>> Т - тип последнего стрима, N - Значение разделителя

                .collect(groupingBy(identity(), counting()))
                .entrySet().parallelStream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(words);

        Stream<String> stringStream1 = Files.lines(file.toPath())
//                указываем, что стрим должен быть параллельным
                .parallel()
//                убрать знаки препинания
                .map(line -> line.toLowerCase().replaceAll("\\pP", " "))
//                каждую строку разбиваем на слова
                .flatMap(line -> Arrays.stream(line.split(" ")))
//                обрезаем пробелы
                .map(String::trim)
//                убираем невалидные слова
                .filter(word -> !"".equals(word));
//        число вхождений слова the

        //  Long count = stringStream1.filter("the"::equals).count();
        // System.out.println(count);

//        выбрать все элементы содержащие the
        List<String> res1 = stringStream1.filter((s) -> s.contains("the")).collect(Collectors.toList());
        System.out.println(res1);

        IntSummaryStatistics statistics = arrStream.collect(Collectors.summarizingInt(p -> p - 1));
        System.out.println(statistics);

//        выбрать пользователей в возрасте от 18 до 40
//        Найти максимальный возраст, найти средний возраст

        User user1 = new User("F", 23);
        User user2 = new User("G", 12);
        User user3 = new User("Hw", 54);
        User user4 = new User("J", 32);
        User user5 = new User("Kw", 1);
        User user6 = new User("L", 99);
        User user7 = new User("M", 25);
        User user8 = new User("Nw", 40);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);

        userList.stream().filter((s1 -> s1.getAge() > 18 && s1.getAge() < 40)).forEach(System.out::println);
        IntSummaryStatistics sm = userList.stream().collect(Collectors.summarizingInt(s -> s.getAge()));
        System.out.println(sm.getMax() + " " + sm.getAverage());


        Integer int1 = list.stream().filter(s -> s % 2 != 0).reduce((j, k) -> j + k).get();
        System.out.println(int1);


//        проверить, есть ли символ "w" во всех именах
       boolean boo = userList.stream().allMatch((s->s.getName().contains("w")));
        System.out.println(boo);
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}