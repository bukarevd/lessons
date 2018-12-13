package lesson1718.homework.task01.Task04;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Scanner;

public class ContextILogger {
    public static void main(String[] args) {
        Context context = new Context(new ConsoleLogger());
        Context context1 = new Context(new FileLogger());
        Context context2 = new Context(new TimeFileLogger());
        Scanner in = new Scanner(System.in);
        while (true) {
            String string = in.nextLine();
            context.writeText(string);
            context1.writeText(string);
            context2.writeText(string);

        }
    }
}

class ConsoleLogger implements ILogger {
    @Override
    public void writeText(String string) {
        System.out.println(string);
    }
}

class FileLogger implements ILogger {
    File file = new File("Logger.txt");

    @Override
    public void writeText(String string) {
        try (OutputStream out = new FileOutputStream(file, true)) {
            out.write(string.getBytes());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

class TimeFileLogger implements ILogger {
    File file = new File("TimeLogger.txt");
    Date date = new Date();

    @Override
    public void writeText(String string) {
        String newString = date.toString() + string;
        try (OutputStream out = new FileOutputStream(file, true)) {
            out.write(newString.getBytes());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

class Context {
    ILogger iLogger;

    public Context(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    public void writeText(String text) {
        iLogger.writeText(text);
    }
}