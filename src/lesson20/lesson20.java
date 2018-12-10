package lesson20;

public class lesson20 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        //метода thread
        //currentThread() - получить текущий поток
        //setName(str) - задать имя потока
        //getName() - получить имя потока


//        Thread thread = new Thread();  //создание потока
//        thread.start(); //запуск потока
//        // вариант 1//////////////////
//        MyThread myThread = new MyThread();
//        myThread.start();
//        //////////////////////////////
//
//        //Вариант 2//////////////////
//        Thread thread2 = new Thread(new MyThread2());
//        thread2.start();
//        ////////////////////////////
//        for (int i = 0; i < 5; i++)
//        {
//            Thread thread3 = new Thread(new MyThread2());
//            thread3.setName("T-" + i);
//            thread3.start();
//        }

        // еще один вариант работы
//        Thread thread4 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Running " + Thread.currentThread().isAlive());
//                System.out.println("Running " + Thread.currentThread().getState());
//            }
//        });
//
//        System.out.println("Before start " + thread4.isAlive());
//        System.out.println("Before start " + thread4.getState());
//        thread4.start();
//        //ожидаем, пока поток завершиться
//        thread4.join();
//        System.out.println("After join " + thread4.isAlive());
//        System.out.println("After join " + thread4.getState());
//
//        программа будет работать, пока есть незавершенные потоки
//
//        Thread thread5 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000); // выполнение потока будет приостановлено на указанное количество времени
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//            thread5.start();

//        программа будет работать, пока есть незавершенные потоки
//       Это касатеся основных потоков
//        Потоки отмеченные как daemon будут остановленны, сразу после завершения последнего основного потока


//        Thread thread6 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000); // выполнение потока будет приостановлено на указанное количество времени
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread6.setDaemon(true); // отмечает потока как не основной
//        thread6.start();

//            остановка потока
//    1. Поток выполнил все инструкции и вышел из метода run
//    2. В методе run было выброшено необрабатываемое исключение
//    3. Остановиласт JVM
//    4. это был daemon поток и последний основной поток завершил работу

//        механизм прерываний
        Thread thread7 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("Thread7");
                        Thread.sleep(1000); // выполнение потока будет приостановлено на указанное количество времени
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); //Устанавливает флаг прерван-не прерван в false (при вылетe Exception флаг не меняется)
                        System.out.println("InterruptedException");
                        //e.printStackTrace();
                    }
                }
            }
        });
        thread7.start();
        Thread.sleep(2000);
        System.out.println(thread7.isInterrupted());
        thread7.interrupt();
        System.out.println(thread7.isInterrupted());

    }
}

// вариант 1 для создания своего потока нужно унследоваться от класса Thread
//class MyThread extends Thread {
//    @Override
//    public void run() {
//        System.out.println("MyThread " + Thread.currentThread().getName());
//    }
//}
//
////Вариант 2  реализовать интерфейс Runnable (обычно используется этот вариант)
//
//class MyThread2 implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Mythread2 " + Thread.currentThread().getName());
//    }
//}