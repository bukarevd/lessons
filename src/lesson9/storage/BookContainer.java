package lesson9.storage;

import lesson9.classes.Book;

public class BookContainer<T extends Book> {
    private T book;
    public BookContainer(T book){
        this.book = book;
    }

    public String getBook(){
        return this.book.getName();
    }

    public static void main(String[] args) {
        Book tails = new Book("Сказки", 500);
        BookContainer<Book> bookBookContainer= new BookContainer<>(tails);
        System.out.println(bookBookContainer.getBook());
    }

}
