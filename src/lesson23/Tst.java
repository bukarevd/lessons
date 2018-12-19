package lesson23;

import java.util.concurrent.*;

public class Tst {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> res = executorService.submit(new SomeClass());
        try {
            Integer integer = res.get(10, TimeUnit.MILLISECONDS);
            System.out.println("integer:" + integer);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            res.cancel(true);
            e.printStackTrace();
        }
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
    }

    public static class SomeClass implements Callable<Integer>{
        @Override
        public Integer call() {
            return 123;
        }
    }
}
