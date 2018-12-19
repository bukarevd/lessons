package lesson1718.homework.task01;




import java.io.*;
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

    private void sendText(String text) {
        try (Socket socket = new Socket()) {
            socket.connect(serverAddress);
            try (OutputStream out = new CryptoOutputStream(socket.getOutputStream())) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
                objectOutputStream.writeObject(text);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void start() {
        while (true) {
            System.out.println("Enter text");
            String text = scanner.nextLine();
            sendText(text);
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
