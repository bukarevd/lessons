package lesson7;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", "Толстой", "1");
        book1.setPages(1000);
        Book book2 = new Book("Война и мир", "Толстой", "1");
        book2.setPages(1000);

        System.out.println(book1 == book2); //false сравнение по ссылке
        System.out.println(book1.equals(book2));

        System.out.println(Book.getStatistic());
        book1.selBook();
        book1.selBook();
        System.out.println(Book.getStatistic());
        book2.selBook();
        System.out.println(Book.getStatistic());
    }
}
