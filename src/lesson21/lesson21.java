package lesson21;

import java.util.ArrayList;
import java.util.List;

public class lesson21 {
    public static void main(String[] args) throws InterruptedException {
        Sync sync = new Sync();
        List<Sync.Adder> adderList = new ArrayList<>(100);
//        создаем потоки
        for (int i = 0; i < 100; i++) {
            adderList.add(sync.new Adder());
        }

//        запукаем потоки
        for (Sync.Adder adder : adderList)
            adder.run();

//        ждем завершения
        for (Sync.Adder adder : adderList)
            adder.join();

//        выводим результат
        System.out.println("Result: " + sync.counter);
    }
}

// общий участок памяти, который будем изменять из разных потоков
class Sync {
    int counter;


    private synchronized void increment(){
//    при синхронизации наметоде происходит синхронизация на текущем объекте (this)
        counter++;
    }

    public class Adder extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
//                counter++;
//               Sync.this - объект, на котором происходит синхронизация
//                synchronized (Sync.this){
//                    counter++;
//                }
                increment();
            }
        }
    }
}



class Storage{
    int booksCount = 0;

    public synchronized void getBook() throws InterruptedException {
        System.out.println("Start getBook");
        while (booksCount < 1){
            wait();
        }
        booksCount--;
        System.out.println("-1 book " + booksCount);
        notify(); // notifyAll - разбудит все потоки.
        System.out.println("End getBook");
    }

    public synchronized void setBook() throws InterruptedException {
        System.out.println("Start setBook");
        while (booksCount >= 5){
            wait();
        }
        booksCount++;
        System.out.println("Books added " + booksCount);
        notify();
        System.out.println("End setBook");
    }
}

class Put implements Runnable{
    Storage storage;

    public Put(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++){
            try {
                storage.setBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable{
    Storage storage;

    public Get(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++){
            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Library{
    public static void main(String[] args) {
//        Storage storage = new Storage();
//        Put put = new Put(storage);
//        Get get = new Get(storage);
//        new Thread(put).start();
//        new Thread(get).start();

        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                synchronized (object1){
//                    обработка данных
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 1 locked object1");
                    synchronized (object2){
                        System.out.println("Thread 1 both object1");

                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                synchronized (object2){
                    System.out.println("Thread 2 locked object2");
                    synchronized (object1){
                        System.out.println("Thread 2 both object2");

                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

//Выполнить подсчет ТОП 100 слов параллельно, количество потоков должно быть равно числу доступных процессоров
// системы  (Runtime.getRuntime().availableProcessor). Каждый поток работает со свои MAP. Потом сливает в общую MAP.