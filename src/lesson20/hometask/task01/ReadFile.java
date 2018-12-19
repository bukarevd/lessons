package lesson20.hometask.task01;


import java.io.*;
import java.nio.charset.Charset;
import java.util.*;


public class ReadFile {
    private int processor = Runtime.getRuntime().availableProcessors();
    List<String> list = new ArrayList<>();
    private int leight;
    int count;
    int start;
    int end;

    public int getLeight() {
        return leight;
    }

    public int getCount() {
        return count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLeight(int leight, int count) {
        this.leight = leight;
        this.count = count;
    }

    public void start() {
        File file = new File(new Scanner(System.in).nextLine());
        String text = null;
        try (InputStream in = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            text = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));

            text = text.replaceAll("[:\"!,.\\t]", "");
            text = text.replaceAll("[\n]", " ");
            CreateList(text);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List CreateList(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }
        return list;
    }





}
class Threads extends Thread {
    ReadFile readFile;
    int processor = Runtime.getRuntime().availableProcessors();

    public void setResource(ReadFile readFile) {
        this.readFile = readFile;
    }

    int leight;
    int count;
    int start;
    int end;

    @Override
    public synchronized void run() {
        leight = readFile.getLeight();
        count = readFile.getCount();
        start = readFile.getStart();
        end = readFile.getEnd();
        if (leight % processor == 0) {
            if (count == 0 && count < processor) {
                start = 0;
                end = leight / processor - 1;
                count++;
            } else {
                start = start + (leight / processor);
                if (count == processor - 1)
                    end = start + (leight - start) - 1;
                else
                    end = start + (leight / processor) - 1;
                count++;
            }
        } else {
            if (count == 0 && count < processor) {
                start = 0;
                end = leight / processor;
                count++;
            } else {
                start = start + (leight / processor) + 1;
                if (count == processor - 1)
                    end = start + (leight - start) - 1;
                else
                    end = start + (leight / processor);
                count++;
            }
        }
        readFile.setLeight(leight, count);
        readFile.setStart(start);
        readFile.setEnd(end);
        readFile.setCount(count);
        System.out.println(readFile.getLeight() + " " + readFile.getStart() + " " + readFile.getEnd());
    }
}
