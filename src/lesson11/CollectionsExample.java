package lesson11;

import java.util.*;

public class CollectionsExample {
/*
JAVA Collection Framework
java.util.Collection
*/
//Интерфейс Collection
/*
boolean add(E e);
boolean remove(Object o);
int size();
boolean isEmpty();
boolean contains(Object o);
*/

/*  Object[] toArray[];
    <T> T[] toArray(T[] a);
    String[] arr = CollectionName.toArray(new String [0]);

    iterator()
*/

//Интерфейс List хранить любые значения
// java.util.List
//    Предоставляет методы для работы с коллекцией, которая является списком
    /*
    void add(int ind, E obj);
    boolean addAll(int ind, Collection <? extends E> col);
    E get(int ind);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    E remove(int ind);
    E set(int index, E obj);
    List<E> subList(int start, int end);
    */




    //ArrayList может хранить любые типы и Null. Автоматически раширяемый
    public static void main(String[] args) {


        ArrayList<String> strList = new ArrayList<>();
//        strList.ensureCapacity(20);
//        strList.trimToSize();

        strList.add("Element1");
        strList.add("Element2");
        strList.add("Element3");
        strList.add("Element4");
        strList.add(0, "Element4");
//        strList.remove(индекс);
//        strList.remove(значение);
        System.out.println(strList.toString());

        Integer[] integers = {23, 54, 65, 244};
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(integers));
        System.out.println(myList.toString());
        for (Integer i : myList) {
            System.out.println(i);
        }
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
//            System.out.println("iter = " + iterator.next());
            if(iterator.next() == 23) iterator.remove();
        }

        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Element1");
        stringLinkedList.add("Element2");
        stringLinkedList.add("Element3");
        stringLinkedList.add("Element4");
        stringLinkedList.add(1,"Element5");
        System.out.println(stringLinkedList);

        for (String str: stringLinkedList) {
            System.out.println(str);
        }
        String[] arr = stringLinkedList.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));

//        удаление элементов
//        /*stringLinkedList.poll(); // удаляет первый элемент или возвращает null
//        stringLinkedList.pollFirst(); // null
//        stringLinkedList.remove();//NoSuchElementException
//        stringLinkedList.removeFirst();//NoSuchElementException*/

//    Интерфейс Set хранит только уникальные значения
//        Set(интерфейс) -> Hashset(), - хранить элементы не в том порядке, в котором добавляли
//        SortedSet() -> TreeSet(), - хранить элементы в упорядоченном
//        LinkedHashSet() - хранить элементы в том порядке, в котором добавлялись

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        hashSet.add("Element 3");
        hashSet.add("Element 3");

        System.out.println(hashSet.toString());

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Element 1");
        treeSet.add("Element 2");
        treeSet.add("Element 3");
        treeSet.add("Element 3");
        System.out.println(treeSet.toString());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Element 1");
        linkedHashSet.add("Element 0");
        linkedHashSet.add("Element 3");
        linkedHashSet.add("Element 4");
        System.out.println(linkedHashSet.toString());

        /*Ввести с клавиатуры 5 слов в список строк.
        Удалить 3 - ий элемент списка, и вывести оставшиеся элементы в обратном порядке.*/



    }
}
