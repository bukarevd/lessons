package lesson16.homework2;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordLenght = scanner.nextLine().split("-");
        int min = Integer.parseInt(wordLenght[0]);
        int max = Integer.parseInt(wordLenght[1]);
        Task01 task01 = new Task01();
        File file = new File("task01.txt");
        try (FileInputStream in = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            String string = new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
            String[] newString = string.split(" ");
            for (String word : newString) {
                if (wordLenght.length > min && word.length() < max)
                    task01.writeFile(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String string) {
        File outFile = new File("/task/out.txt");

                try (FileOutputStream fileOutputStream = new FileOutputStream(outFile, true)) {
                byte[] bytes = (string + "\n").getBytes(Charset.forName("UTF-8"));
                fileOutputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
