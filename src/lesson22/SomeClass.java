package lesson22;

import java.util.*;
import java.util.concurrent.*;

public class SomeClass {
    //    чтение и запись всегда будут атомарными
//    чтение всегда всернет актуальное значение из памяти
    private static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new SomeThread().start();
        }
        Thread.sleep(3000);
        run = false;
    }

    private static class SomeThread extends Thread {
        @Override
        public void run() {
            while (run) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    run = true;
                    e.printStackTrace();
                }

            }
        }
    }


//    многопоточные коллекции(потокобезопасные)

//    Vector
//    HashTable
//    Stack
//    StringBuffer

    //    однопоточные коллекции плюс декораторы
    List<String> list = Collections.synchronizedList(new ArrayList<>());
    Set<String> set = Collections.synchronizedSet(new HashSet<>());
    Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

//java.util.concurrent.  - java 1.5
//    многопоточные коллекции
//    интерфейс ConcurrentMap
// чтение и запись будут атомарными
//    операции чтения не требуют блокировок
//    операции записи могут происходить без блокировок

//    putIfAbsent(key, val) - добавляет в map если ключ отсутствует
//    remove(key, val) - return true if delete
//    replace(key, oldValue, newValue)  - заменит, если старому ключу соответствует новое значение

//ConcurrentHashMap - блокировка на уровне сегментов
//ConcurrentSkipListMap - (Skip list алгоритм)
//    ConcurrentSkipListSet
//CopyOnWriteArrayList - используется когда много потоков на чтение и мало на запись
//CopyOnWriteArraySet- используется когда много потоков на чтение и мало на запись

//  интерфейс  blockingQueue - блокирующие очереди (однонаправленная)
//  интерфейс  blockingDeque - блокирующие очереди (двунаправленная)
//    вставка
//      add(e) - выбросит исключение если некуда вставлять данные
//      offer(e) -
//      put(e) - если некуда вставить, поток будет заблокирован и разбужен когда будет куда добавить
//    удаление
//    remove() - exception если нечего удалить
//    poll() -
//    take() - блокирует поток до тех пор пока не будет что удалить
//    new ArrayBlockingQueue (int capacity)  (размер фиксирован)
//    new ArrayBlockingQueue (int capacity, boolean fair)  (размер фиксирован)
//    new ArrayBlockingQueue (int capacity, boolean fair, Collection collection)  (размер фиксирован)
//
//    LinkedBlockingQueue() - не указывается размер(по умолчанию Integer.MAX_VALUE)
//    LinkedBlockingQueue(int capacity)
//    LinkedBlockingQueue(Collection collection)
//
//    SynchronousQueue - каждая операция добавления будет ждать операцию удаления и наоборот(хранит один элемент. для передачи между потоками)



//    ДЗ используя блокирующие очереди сосчитать ТОП 100 слов

}


