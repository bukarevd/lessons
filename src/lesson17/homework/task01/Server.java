package lesson17.homework.task01;

import java.io.IOException;
import java.io.InputStream;
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

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        server.startserver();
    }
}

