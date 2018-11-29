package lesson16.homework;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client {
    private SocketAddress serverAddress;
    private Scanner scanner;

    private Client(SocketAddress serverAddress, Scanner scanner){
        this.serverAddress = serverAddress;
        this.scanner = scanner;
    }

    private static SocketAddress parseAddress(String address){
        String[] adr = address.split(":");
        return new InetSocketAddress(adr[0], Integer.parseInt(adr[1]));
    }

    private void start() {
        while (true) {
            System.out.println("Enter command");
            String command = scanner.nextLine();
            buildAndSendCommand(command);
        }
    }

    private void buildAndSendCommand(String command) {

        switch (command){
            case "/server_time":
                sendCommand(new ServerTime());
                break;
            case "/list_users":break;
            case "/ping":break;
            default: return;

        }

    }

    private void sendCommand(Object object) {
        try (Socket socket = new Socket()) {
            socket.connect(serverAddress);
            try (OutputStream out = socket.getOutputStream()) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        String address = null;
        if (args != null && args.length > 0)
            address = args[0];
        Scanner scanner = new Scanner(System.in);
        if (address == null){
            address = scanner.nextLine();
        }
        Client client = new Client(parseAddress(address), scanner);

        client.start();


    }
}
