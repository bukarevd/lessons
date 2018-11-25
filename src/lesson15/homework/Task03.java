package lesson15.homework;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        File file = new File("task01.txt");
        Scanner in = new Scanner(System.in);
        String key = in.next();
        try (InputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            byte[] arr = byteArrayOutputStream.toByteArray();
            byte[] str = key.getBytes();
            byte[] result = new byte[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = (byte) (arr[i] ^ str[i % str.length]);
            }

        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
