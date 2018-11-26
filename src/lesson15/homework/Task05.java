package lesson15.homework;

import java.io.*;
import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file = new File(in.next());
        try(InputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0){
                byteArrayOutputStream.write(bytes, 0, len);
            }
            bytes = byteArrayOutputStream.toByteArray();
            int count = 0;
            for (byte b: bytes) {
                if(b == 44) count++;
            }
            System.out.println("Запятых в файле " + count + " шт.");
        }catch (FileNotFoundException e){

        }catch (IOException e){

        }

    }
}
