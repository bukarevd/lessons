package lesson15.homework;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file = new File(in.next());
        try (InputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            if (file.createNewFile()) {
                System.out.println("Создан файл " + file.getName());
            } else
                System.out.println("Файл уже существует");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            bytes = byteArrayOutputStream.toByteArray();
            for (int i = bytes.length - 1; i < 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (bytes[j] > bytes[j + 1]) {
                        byte tmp = bytes[j];
                        bytes[j] = bytes[j + 1];
                        bytes[j + 1] = tmp;
                    }
                }
            }
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
