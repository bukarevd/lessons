package lesson15.homework;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file1 = new File(in.next());
        File file2 = new File(in.next());
        StringBuilder sb = new StringBuilder();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file1, false)) {
            if (file1.createNewFile()) {
                System.out.println("Файл " + file1.getName() + " создан");
            } else {
                System.out.println("уже существует");
            }
            if (file2.createNewFile()) {
                System.out.println("Файл " + file2.getName() + " создан");
            } else {
                System.out.println("уже существует");
            }
            sb.append(in.next());
            byte[] bytes = sb.toString().getBytes(Charset.forName("UTF-8"));
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
             FileInputStream fileInputStream = new FileInputStream(file1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = fileInputStream.read(buf)) > 0) {
                    byteArrayOutputStream.write(buf, 0, len);
                    bufferedOutputStream.write(buf, 0, buf.length);
                    System.out.println(len);
                }
        }catch (IOException e){
            e.getStackTrace();
        }

    }
}
