package lesson23;




import chat.Message;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        java.util.concurrent.Callable - возвращает данные из потока
//        java.util.concurrent.Future
//        get(), get(long l, TimeUnit tu)
//          cancel() - отменяет текущую задачу
//        isCanceled(), isDone()

//        FutureTask
//        new FutureTask(Callable < T > c)
//        new FutureTask(Runnable r, T rezult)

        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
//                тело потока
                return "String";
            }
        });

        new Thread(task).start();
//        ждем завершения операции

        String result = task.get();
        System.out.println(result);

        FutureTask<String> task1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                int counter = 0;
                while (!Thread.currentThread().isInterrupted() && counter < 3) {
                    counter++;
                    Thread.sleep(1000);
                }
                return "Finished";
            }
        });
//      запускаем поток с задачей
        new Thread(task1).start();
        Thread.sleep(2000);
//      прерываем выполнение
        task1.cancel(true);

        System.out.println(task1.isCancelled());
        System.out.println(task.isDone());

//        interface Executor позволяют управлять группой потоков(создание, повторное использование)
//        execute(Runnable runnable)

//        new Thread(task).start();
//        ExecutorService executorService; // создание объекта
//        executorService.execute(new Thread(task));
//        executorService.submit(new Thread(task1)) //добавляет задачу на выполнение и возвращает Future Object

//        Executors class

//        Executors.newFixedThreadPool( int i); создает пул потоков с фиксированным кол-ом
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool() - сам решает сколько потоков создавать, в зависимости от нагрузки
//        Executors.newScheduledThreadPool(int i) - настроить выполнение задач по рассписанию

       ExecutorService pool = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 5; i++){
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("pool: " + Thread.currentThread().getName());
//                }
//            });
//        }
//        метод submit возвращает объект Future
//        соответственно ему доступны все его методы
//        pool.submit(new Thread(task)).get();
//        pool.shutdown();
//
//        ExecutorService service = new ThreadPoolExecutor(
//                1, //основное количество потоков
//                2, //максимальное кол-во потоков
//                2, //Сколько избыточные потоки будут простаивать
//                TimeUnit.MINUTES,
//                new LinkedBlockingDeque<>()//очередь для задач
//        );
////
//        for (int i = 0; i < 3; i++){
//            service.submit(new Runnable() {
//                @Override
//                public void run() {
//                    //код
//                }
//            });
//        }
//

//        Объекты синхронизации
//        CountDownLatch(int num) - блокирует выполнение потока пока не наступит событие (num - количество событий)
//        await(); // блокировка потоков
//        countDown(); // уменьшение счетчика

//        Exchanger // позволяет обмениваться данными между потоками
//        exchange(T buffer);
//
//        Exchanger<Message> exchanger;
//        messages[4] = exchanger.exchange(messages[4]);


        //ДЗ
        /* 1. Создать класс "Пользователь" (id, email)
              класс "Акаунт" (id, id_user, количество денег)
              id, id_user уникальные
              класс "Банк" хранит список всех аккаунтов,
              метод перевода денег transferMoney(Account_src, Account_dst, int amount) src != dst
              если средств недостаточно, перевод средств не будет выполнен (проверка счета потокобезопасная)
              класс "Транзакции" (Account src, Account dst, Bank bank, int amount, Date date)
         */

    }
}
