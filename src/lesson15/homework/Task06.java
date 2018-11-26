package lesson15.homework;

import java.io.*;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file1 = new File(in.next());
        File file2 = new File(in.next());
        File file3 = new File(in.next());
        try (InputStream inputStream = new FileInputStream(file1);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            bytes = byteArrayOutputStream.toByteArray();
            byte[] buf;
            if (byteArrayOutputStream.toByteArray().length % 2 == 0) {
                for (int i = 0; i < (bytes.length / 2); i++) {
                    buf = new byte[bytes.length / 2];
                    buf[i] = bytes[i];
                    new Task06().writeToFile(file2, buf);
                }
                for (int i = (bytes.length / 2); i < bytes.length; i++) {
                    buf = new byte[(bytes.length / 2) + 1];
                    buf[i] = bytes[i];
                    new Task06().writeToFile(file3, buf);
                }
            } else {
                for (int i = 0; i < (bytes.length / 2); i++) {
                    buf = new byte[bytes.length / 2];
                    buf[i] = bytes[i];
                    new Task06().writeToFile(file2, buf);
                }
                for (int i = (bytes.length / 2); i < bytes.length; i++) {
                    buf = new byte[bytes.length / 2];
                    buf[i] = bytes[i];
                    new Task06().writeToFile(file3, buf);
                }
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    protected void writeToFile(File file, byte[] bytes) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }
}
