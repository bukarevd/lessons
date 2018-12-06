package chat;


import lesson16.printAPP.PrintClient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
    private SocketAddress socketAddress;

    public Client(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }
    private void start() {
        System.out.println("Enter your name");
        String name = ConsoleHelper.readString();
        while (true) {
            System.out.println("Enter your message");
            String msg = ConsoleHelper.readString();

            buildAndSendMessage(name, msg);
        }
    }

    private void buildAndSendMessage(String name, String msg) {
        Message message = new Message(name, msg);
        sendMessage(message);
    }

    private void sendMessage(Message message) {

        try (Socket socket = new Socket())
        {

            socket.connect(socketAddress);
            IOConnection connection = new IOConnection(socket);
            connection.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SocketAddress parseAddress(String address) {
        String[] strings = address.split(":");
        return new InetSocketAddress(strings[0], Integer.parseInt(strings[1]));
    }

    public static void main(String[] args) {
        String address = null;
        if (args != null && args.length > 0) {
            address = args[0];
        }

        if (address == null) {
            System.out.println("Enter server address");
            address = ConsoleHelper.readString();
        }

        Client client = new Client(parseAddress(address));

        client.start();
    }
}
