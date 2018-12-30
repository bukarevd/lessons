package lesson24.bank;

public class Main {
    public static void main(String[] args) {
        Account user1 = new Account(1, 100);
        Account user2 = new Account(2, 200);
        new Transfer(user1, user2, 50).start();


    }

}
