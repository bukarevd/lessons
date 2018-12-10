package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {
    private int port;
    private final Set<IOConnection> connections = new CopyOnWriteArraySet<>();
    private final BlockingDeque<Message> messageBlockingDeque = new LinkedBlockingDeque<>();

    public Server(int port){
        this.port = port;
    }

    private void start(){
        new Thread(new Writer()).start();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started on:" + serverSocket);
            IOConnection ioConnection ;
            while (true){
                Socket socket = serverSocket.accept();
                ioConnection = new IOConnection(socket);
                connections.add(ioConnection);

                new Thread(new Reader(ioConnection)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Reader implements Runnable{
        private IOConnection ioConnection;

        public Reader(IOConnection ioConnection){
            this.ioConnection = ioConnection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Message message = ioConnection.receave();
                    messageBlockingDeque.add(message);
                    System.out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Writer implements Runnable{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Message message = messageBlockingDeque.take();
                    for (IOConnection connection: connections){
                        connection.send(message);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8080);
        server.start();
    }

//    int port;
//
//    public Server(int port) {
//        this.port = port;
//    }
//
//    private void printMessage(Message message){
//       ConsoleHelper.writeString(message.getMessText() + " " + message.getSender());
//    }
//
//    private void getMessage(IOConnection connection){
//        try {
//            printMessage(connection.receave());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void start(){
//        try (ServerSocket serverSocket = new ServerSocket(port)){
//            System.out.println("Server start on: " + serverSocket);
//            Socket socket = serverSocket.accept();
//            IOConnection start = new IOConnection(socket);
//            getMessage(start);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        int port = Integer.parseInt(args[0]);
//        Server server = new Server(port);
//        server.start();
//
//    }
}
