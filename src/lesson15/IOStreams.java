package lesson15;

//io api

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Vector;


//        InputStream - входящие данные
//        OutputStream - исх данные (оба работают с байтами)

public class IOStreams {
    protected long readByte(File file) throws IOException {
        long byteSum = 0;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.available() > 0) { //available - возвр кол-во доступных байт
                int data = fileInputStream.read();
                byteSum += data;
                ///////Так делать нельзя, но оно работает///////////////
                System.out.println((char) data);
                //////////////////////////////////////
            }
            return byteSum;
        }
    }

    private void readByteArray(File file, Charset charset) throws IOException {// Charset - кодировка файла
        try (InputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0, len);
            }
            System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
        }
    }

    private void writeToFile(File file, boolean append, Charset charset) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append("Line ").append(i).append("\n");
            }
            byte[] bytes = sb.toString().getBytes(charset);
            fileOutputStream.write(bytes);
        }
    }

    public void writeWithBuffer(File file) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                sb.append("Line ").append(i).append("\n");
            }
            byte[] bytes = sb.toString().getBytes();
            bufferedOutputStream.write(bytes, 0, bytes.length);
        }

    }

    private void readFroTwoFiles(File[] files, Charset charset) throws IOException {
        try (InputStream inputStream = new FileInputStream(files[0]);
             InputStream inputStream2 = new FileInputStream(files[1]);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {


            //--------Для чтения из более 2 источников------------
            InputStream in1 = new FileInputStream("file1.exe");
            InputStream in2 = new FileInputStream("file2.exe");
            InputStream in3 = new FileInputStream("file3.exe");

            Vector<InputStream> vector = new Vector<>();
            vector.addElement(in1);
            vector.addElement(in2);
            vector.addElement(in3);
            SequenceInputStream vektorStream = new SequenceInputStream(vector.elements());
            //-----------------------------


            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream, inputStream2);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = sequenceInputStream.read(bytes)) > 0) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
        }
    }

    private static void dataOutput(OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeInt(1234);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.writeUTF("Hello");
    }

    private static void dataInput(InputStream in) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(in);
        String string = dataInputStream.readUTF();
        int i = dataInputStream.readInt();
        boolean bool = dataInputStream.readBoolean();


        System.out.printf("%s, %s, %s", i, bool, string);
        System.out.printf("%s, %s", string, i);
    }


    public String readUrl(String url, Charset charset) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        httpURLConnection.setRequestProperty("Accept-Charset", charset.name());
        try (InputStream in = httpURLConnection.getInputStream()){
            return readText(in, charset);
        }
    }

    private String readText(InputStream in, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[20];
        int len;
        while ((len = reader.read(chars)) > 0){
            sb.append(chars, 0, len);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
//        PipedInputStream pipedInputStream;
//        PipedOutputStream pipedOutputStream; только для многопоточной среды

//        FilterInputStream filterInputStream;
//        FileOutputStream fileOutputStream; для реализации своих вариантов. Переопределить метод read()


        IOStreams ioStreams = new IOStreams();
        //чтение из файла по байту
        File file = new File("file.txt");
        File file1 = new File("file2.txt");
        // System.out.println(ioStreams.readByte(file));
        //ioStreams.readByteArray(file, Charset.forName("UTF-8"));
        //ioStreams.writeToFile(file, false, Charset.forName("UTF-8"));// append (true - добавляет в файл/
        // false - перезаписывает файл)
//        ioStreams.writeWithBuffer(file);
        //   File[] files = {file, file1};
        // ioStreams.readFroTwoFiles(files, Charset.forName("UTF-8"));

//        try (OutputStream out = new FileOutputStream(file)) {
//            dataOutput(out);
//        }
//        try (InputStream in = new FileInputStream(file)){
//            dataInput(in);
//        }
        String str = ioStreams.readUrl("https://ya.ru/", Charset.forName("UTF-8"));
        System.out.println(str);


//        RandomAccessFile  - посмотреть
    }


}
