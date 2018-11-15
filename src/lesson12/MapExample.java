package lesson12;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
       //  User user = new User(2, "User");

//        MAP
     /*   1. хранение данных в паре ключ - значение
        2. ключ должен быть уникальным
        3. хранение зависит от реализации
        4. могут хранить любые типы данных(null в качестве ключа зависит от реализации)

     boolean containsKey(Object key);
     boolean containsValue(Object val);
     void putAll(Map <? extends K, ? extends V> m);
     //method
        get(T key);
        put(T key, T val);

        Реализация
        HashMap
                TreeMap - создается на основе сортировки по ключам
        EnumMap
                LinkedHashMap - гарантирует что элементы будут храниться в порядке добавления
        WeakHashMap -
                IdentityHashMap - сравнение ключейпроисходи не с помощью equal, а спомощью ==
*/

        Map<Integer, String> haspMap = new HashMap<>();
        haspMap.put(1, "Elem 1");
        haspMap.put(2, "Elem 2");
        haspMap.put(null, "Elem null");
        System.out.println(haspMap);
        System.out.println(haspMap.get(1));
        System.out.println(haspMap.keySet());//set из ключей
        System.out.println(haspMap.values());//set из значений
        // перебор элементов Map

        for (Map.Entry entry : haspMap.entrySet()) {
            System.out.println("Key= " + entry.getKey() + " Value= " + entry.getValue());
        }


        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); //используется если важен порядок хранения
        linkedHashMap.put(1, "Elem 1");
        linkedHashMap.put(2, "Elem 2");
        linkedHashMap.put(null, "Elem null");
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get(1));

        Map<Integer, String> treeMap = new TreeMap<>();//  не может хранить null в качестве ключа, сортировка по ключам
        treeMap.put(1, "Elem 1");
        treeMap.put(2, "Elem 2");
        // treeMap.put(null, "Elem 2");
        System.out.println(treeMap);
        System.out.println(treeMap.get(1));

        // бинарное дерево
        /*1. корень - верхний узел
        2. листья - узлы без потомков
        3. значение левого потомка должно быть меньше родителя
        4. значение правого потомка должно быть больше родителя*/

        //красно-черное бинарное дерево
        /*1. корень и листья - всегда черные
        2. каждый красный узел имеет 2 черных потомка
        3. все пути от узла (корня) до листьев должны иметь одинаковое количество черных узлов
        */

        User user1 = new User(1, "Вася");
        User user2 = new User(2, "Саша");
        User user3 = new User(3, "Женя");

        Map<Integer, User> userTreeMap = new TreeMap<>();
        userTreeMap.put(1, user1);
        userTreeMap.put(2, user2);
        userTreeMap.put(3, user3);
        System.out.println(userTreeMap);

        TreeSet<User> treeSet = new TreeSet<>();
        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        System.out.println(treeSet);

        Map<Integer, String> haspMap2 = new HashMap<>();
        haspMap2.put(1, "Elem 1");
        haspMap2.put(2, "Elem 2");
        haspMap2.put(7, "Elem 7");
        haspMap2.put(5, "Elem 5");
        haspMap2.put(88, "Elem 88");
        haspMap2.put(66, "Elem 66");
        System.out.println(haspMap2);

        TreeMap<Integer, String> treeMap1 = new TreeMap<>(haspMap2);
        System.out.println(treeMap1);


    }
}
