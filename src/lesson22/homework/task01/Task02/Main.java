package lesson22.homework.task01.Task02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {


    public static void main(String[] args) {
        Order order = new Order();
        BlockingQueue<Order> clientQueue = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Order> waiterQueue = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Order> cookQueue = new ArrayBlockingQueue<>(1, true);
        Client client = new Client(clientQueue, cookQueue, order);
        Waiter waiter = new Waiter(clientQueue, waiterQueue);
        Cook cook = new Cook(waiterQueue, cookQueue);
        client.start();
        waiter.start();
        cook.start();
    }
}

class Client extends Thread {
    private Order order;
    private BlockingQueue<Order> clientQueue;
    private BlockingQueue<Order> cookQueue;

    Client(BlockingQueue<Order> clientQueue, BlockingQueue<Order> cookQueue, Order order) {
        this.clientQueue = clientQueue;
        this.cookQueue = cookQueue;
        this.order = order;
    }

    @Override
    public void run() {
        order.setClient(true);
        try {
            clientQueue.put(new Order());
            System.out.println("Заказ создан");
            order = cookQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (order.isCook())
            System.out.println("Заказ готов");
    }
}

class Waiter extends Thread {
    private Order orderWaiter;


    private BlockingQueue<Order> clientQueue;
    private BlockingQueue<Order> waiterQueue;

    Waiter(BlockingQueue<Order> clientQueue, BlockingQueue<Order> waiterQueue) {
        this.clientQueue = clientQueue;
        this.waiterQueue = waiterQueue;
    }

    @Override
    public void run() {
        try {
            orderWaiter = clientQueue.take();
            if (orderWaiter.isClient())
                System.out.println("Заказ получен официантом от клиента");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderWaiter.setWaiter(true);
        try {
            waiterQueue.put(orderWaiter);
            System.out.println("Заказ передан повару");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Cook extends Thread{
    private Order cookOrder;

    private BlockingQueue<Order> waiterQueue;
    private BlockingQueue<Order> cookQueue;

    Cook(BlockingQueue<Order> waiterQueue, BlockingQueue<Order> cookQueue) {
        this.waiterQueue = waiterQueue;
        this.cookQueue = cookQueue;
    }

    @Override
    public void run() {
        try {
            cookOrder = waiterQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (cookOrder.isCook())
            System.out.println("Заказ получен поваром от официанта");
        cookOrder.setCook(true);
        try {
            cookQueue.put(cookOrder);
            System.out.println("Заказ передан клиенту");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
