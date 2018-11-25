package lesson15.homework;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file1 = new File(in.next());
        File file2 = new File(in.next());
        StringBuilder sb = new StringBuilder();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file1)) {
            if (file1.createNewFile()) {
                System.out.println("создан файл " + file1.getName());
            } else {
                System.out.println("Файл уже существует");
            }
            if (file2.createNewFile()) {
                System.out.println("создан файл " + file2.getName());
            } else {
                System.out.println("Файл уже существует");
            }
            sb.append(in.next());
            byte bytes[] = sb.toString().getBytes(Charset.forName("UTF-8"));
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] files = {file1, file2};
        in.close();
        new Task02().cuting(files);
    }

    protected void cuting(File[] files) {
        long bytesCount = 0;
        Scanner in = new Scanner(System.in);
        try (InputStream fileInputStream = new FileInputStream(files[0]);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                bytesCount += data;
            }
            System.out.println(byteArrayOutputStream.size());
            System.out.println("Доступно для переноса " + bytesCount + ", введите кол-во байт для переноса");
           // int trBytes = in.nextInt();
            int i = 0;
            try (FileOutputStream out = new FileOutputStream(files[i]);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out)) {
                StringBuilder sb = new StringBuilder();
                while (i < files.length - 1) {

                }
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }


    }
}
