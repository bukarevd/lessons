package lesson1718.homework.task01;



import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class File {
    Scanner in = new Scanner(System.in);
    String pass;
    String text;

    protected void writeFile(){
        System.out.print("Enter password ");
        pass=in.nextLine();
        System.out.print("\nEnter text ");
        text = in.nextLine();
        try (OutputStream out = new CryptoOutputStream(new FileOutputStream("test.bin"), pass.getBytes())){
            out.write(text.getBytes());
        }catch (IOException e ){
            e.getMessage();
        }
    }

    protected void readFile(){
        try (InputStream in = new CryptoInputStream(new FileInputStream("test.bin"), pass.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            System.out.println("Считанный текст: " + new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8")));
        }catch (IOException e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        File first = new File();
        first.writeFile();
        first.readFile();
    }
}


