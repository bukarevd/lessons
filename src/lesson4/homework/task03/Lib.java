package lesson4.homework.task03;

import java.util.Arrays;

public class Lib {
    Book[] books = new Book[10];

    public int get(Book book, int quantity){
        for (int i = 0; i < books.length; i++){
            if (books[i] == book){
                books[i] = null;
                quantity--;
                break;
            }
        }
        return quantity;
    }

    public int put(Book book, int quantity){
        for (int i = 0; i < books.length; i++){
            if (books[i] == null ){
                books[i] = book;
                quantity++;
                break;
            }
        }
        return quantity;
    }

    public void showLib(int quantity){
        System.out.println(Arrays.toString(books)+ " " + quantity);
    }


}
