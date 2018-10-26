package Lesson4.homework.task03;

public class Main {
    public static void main(String[] args) {
        int quantity = 0;
        Book book1 = new Book();
        book1.setAuthor("Denis");
        book1.setName("java");

        Lib libr = new Lib();
        quantity = libr.put(book1, quantity);
        quantity = libr.put(book1, quantity);
        quantity = libr.put(book1, quantity);
        quantity = libr.put(book1, quantity);
        quantity= libr.get(book1, quantity);

        Book book2 = new Book();
        book2.setAuthor("tanya");
        book2.setName("python");
        quantity = libr.put(book2, quantity);
        quantity= libr.get(book1, quantity);
        libr.showLib(quantity);
    }
}
