package lesson22.homework.task01;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class main {


    public static void main(String[] args) {
        Resource resource = new Resource();
        BlockingQueue<String> wordsQueue = new PriorityBlockingQueue<>();
        int processor = Runtime.getRuntime().availableProcessors();
        String text = null;
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        String[] words = null;
        try (InputStream in = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            text = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));

            text = text.replaceAll("\\pP", " ");
            words = text.split(" ");


        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < processor; i++) {
            new addQueueInThread(wordsQueue, words, resource).start();
        }
        new takeQueue(wordsQueue).start();

    }
}


class addQueueInThread extends Thread {
    Resource resource;
    BlockingQueue blockingQueue;
    String[] words;


    public addQueueInThread(BlockingQueue blockingQueue, String[] words, Resource resource) {
        this.blockingQueue = blockingQueue;
        this.words = words;
        this.resource = resource;
    }

    @Override
    public void run() {
        int start = resource.getStart();
        int end = resource.getEnd();
        int count = resource.getCount();
        int processor = Runtime.getRuntime().availableProcessors();
        if (words.length % processor == 0) {
            if (count == 0 && count < processor) {
                start = 0;
                end = words.length / processor - 1;
                count++;
            } else {
                start = start + (words.length / processor);
                if (count == processor - 1)
                    end = start + (words.length - start) - 1;
                else
                    end = start + (words.length / processor) - 1;
                count++;
            }
        } else {
            if (count == 0 && count < processor) {
                start = 0;
                end = words.length / processor;
                count++;
            } else {
                start = start + (words.length / processor) + 1;
                if (count == processor - 1)
                    end = start + (words.length - start) - 1;
                else
                    end = start + (words.length / processor);
                count++;
            }
            resource.setStart(start);
            resource.setEnd(end);
            resource.setCount(count);

            for (int i = resource.getStart(); i < resource.getEnd() + 1; i++) {
                blockingQueue.add(words[i]);
            }

        }
    }
}

class takeQueue extends Thread {
    BlockingQueue blockingQueue;

    public takeQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Resource {
    int start;
    int end;
    int count;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
