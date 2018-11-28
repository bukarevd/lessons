package lesson16.homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    private void startserver() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server start on:" + serverSocket);
            while (true) {
                Socket socket = serverSocket.accept();
                getMessage(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printObject(Object command) {
        System.out.println();
    }

    private void getMessage(Socket socket) {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            Object object = in.readObject();
            printObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(8080);
        server.startserver();
    }
}
