package lesson9.pair;

import lesson9.classes.Book;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(12, "значение");
        Integer key = pair.getKey();
        String string = pair.getValue();

        Book tails = new Book("Сказки", 500);
        Pair<String, Book> pair1 = new Pair<>("book1", tails);
        Book book = pair1.getValue();
    }
}
