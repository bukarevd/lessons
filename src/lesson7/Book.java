package lesson7;

import java.util.Objects;
import java.util.Random;

public class Book {

    final String CONST = "CONST";
    final String CONST2;
    final String CONST3;

    private String title;
    private String author;
    private int pages;

    public static int soldBook;

    static {
        soldBook = -(new Random().nextInt(100));
    }

    final public void selBook(){
        soldBook++;
    }

    public static String getStatistic(){
        return "Book sold: " + soldBook;
    }

//    public Book(String title, String author){
//
//    }
//

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(final String author) { //аргумент будет доступен только для чтения
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    Book(String title, String author, String val) {
        CONST2 = "CONST2";
        CONST3 = val;
        this.title = title;
        this.author = author;
    }

//    Все классы наследуются от класса Object
//    toString()

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    // clone() - возвращает копию объекта
//    getClass() - возвращает ссылку на класс объекта
//    finalize() - выполняется при уничтожении сборщиком мусора
//    wait() | notify() | notifyall() - многопоточность
//    equals() - возвращает true|false, по умолчанию сравнивает объекты с помощью ==
//    hashCode() - возвращает hashcode объекта


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }
}
