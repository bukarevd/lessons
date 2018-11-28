package lesson16.printAPP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PrintServer {
    private int port;

    public PrintServer(int port) {
        this.port = port;
    }

    private void printMessage(Message message) {
        System.out.println("message: " + message.getMessText() + " from " + message.getSender());
    }

    private void getMessage(Socket socket) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
            Object object = objectInputStream.readObject();
            printMessage((Message) object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on:" + serverSocket);
            while (true) {
                Socket socket = serverSocket.accept();

                getMessage(socket);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        PrintServer printServer = new PrintServer(port);
        printServer.start();
    }
}
