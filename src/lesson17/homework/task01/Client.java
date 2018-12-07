package lesson17.homework.task01;


import lesson16.homework.Command;
import lesson16.homework.ListUsers;
import lesson16.homework.Ping;
import lesson16.homework.ServerTime;

import java.io.File;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client {
    private SocketAddress serverAddress;
    private Scanner scanner;
    private StringBuilder stringBuilder = new StringBuilder(System.getProperty("user.name") + "\n");
    private File file = new File("UserList.dat");

    private Client(SocketAddress serverAddress, Scanner scanner){
        this.serverAddress = serverAddress;
        this.scanner = scanner;
    }

    private static SocketAddress parseAddress(String address){
        String[] adr = address.split(":");
        return new InetSocketAddress(adr[0], Integer.parseInt(adr[1]));
    }

    private void writeUser(File file){
        // stringBuilder.append(System.getProperty("user.name") + "\n");
        if (!file.exists()){
            System.out.println("First enter");
        }
        try(FileOutputStream out = new FileOutputStream(file, true)) {
            out.write(stringBuilder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        writeUser(file);
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
            case "/list_users":
                sendCommand(new ListUsers());
                break;
            case "/ping":
                sendCommand(new Ping());
                break;
            default:

        }

    }

    private void sendCommand(Command object) {
        try (Socket socket = new Socket()) {
            socket.connect(serverAddress);
            try (OutputStream out = new CryptoOutputStream(socket.getOutputStream())) {
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
