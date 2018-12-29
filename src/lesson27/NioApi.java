package lesson27;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.*;

public class NioApi {
//    Channel

//    FileChannel
//    DatagramChannel  - UDP протокол
//    SocketChannel - TCP клиент
//    ServerSocketChannel - TCP сервер

    //    Buffer
//    Selector
    public static void write(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
//            Получаем канал из RandomAccessFile
            FileChannel channel = raf.getChannel();
            String text = "Text\n" + "Text\n" + "Text\n";
            byte[] bytes = text.getBytes(Charset.forName("UTF-8"));

//            Создаем буфер для записи данных
            ByteBuffer buffer = ByteBuffer.allocate(512);
//            заполняем буфер данными
            buffer.put(bytes);
//            ставим limit на позицию курсора, курсор перемещаем в начало
            buffer.flip();
//            записываем данные из буфера в канал
//            курсор перемещается на позицию, равную количеству записанных байт
            int written = channel.write(buffer);
            System.out.println("written: " + written + " bytes to file " + file.getAbsoluteFile());

        }

    }

    public static void read(File file) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            FileChannel channel = raf.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            StringBuilder builder = new StringBuilder();
//            чтение данных
            while (channel.read(buffer) != -1){
                builder.append(new String(buffer.array(), 0, buffer.remaining()));
//                очищение буфера для следующего чтения
                buffer.clear();
            }
            System.out.println("Read from file: " + file + ":");
            System.out.println(builder);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            write(new File("fileNIO.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Buffer
//        capacity - емкость буфера
//        position - текущее полощение курсора в буфере
//        limit - предел для position

        ByteBuffer buffer = ByteBuffer.allocate(512);

//       putXXX/getXXX запись/чтение данных в буфер
//        flip() - перемещает
//        rewind() - сбрасывает позицию на 0
//        clear() -
//        remaining() - показывает разницу между позицией и лимитом

//        buffer.position();
//        buffer.capacity();
//        buffer.limit(400); // устанавливает новый лимит
//        buffer.limit();
//        buffer.remaining();

//        Path path = Paths.get();

        Path dir = Paths.get("src");
        WatchService watcher = FileSystems.getDefault().newWatchService();
        while (true){
            WatchKey key = null;
            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (WatchEvent event: key.pollEvents()) {
                switch (event.kind().name()){
                    
                }
            }
        }
    }
}


