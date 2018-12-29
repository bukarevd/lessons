package lesson24.homework.task01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Ship> berth1 = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Ship> berth2 = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Ship> berth3 = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Ship> berth4 = new ArrayBlockingQueue<>(1, true);
        Ship ship = new Ship(true, false);
        Ship ship2 = new Ship(true, true);
        Ships ships = new Ships(ship, berth1);
        Ships ships2 = new Ships(ship2, berth1);
        ships.start();
        ships2.start();


    }
}

class Ships extends Thread{
    private Ship ship;
    private BlockingQueue blockingQueue;

    Ships(Ship ship, BlockingQueue blockingQueue){
        this.ship = ship;
        this.blockingQueue = blockingQueue;

    }

    @Override
    public void run() {
        try {
            blockingQueue.put(ship);
            System.out.println("Корабль вошел в порт ");
            if (ship.unloading) System.out.println("Разгрузка корабля");
            Thread.sleep(100);
            if (ship.loading) System.out.println("Загрузка корабля");
            Thread.sleep(100);
            blockingQueue.take();
            System.out.println("Корабль вышел из порта ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
