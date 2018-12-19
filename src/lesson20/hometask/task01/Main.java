package lesson20.hometask.task01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        int count = 0;
        ReadFile readFile = new ReadFile();
        readFile.start();
        readFile.setLeight(readFile.list.size(), count);
        List<Threads> threadList = new ArrayList<>();
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threadList.add(new Threads());
        }
        for (Threads thread : threadList) {
            thread.setResource(readFile);
            thread.start();
            thread.join();
        }

    }
}
