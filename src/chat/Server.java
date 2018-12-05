package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port;

    public Server(int port) {
        this.port = port;
    }

    private void printMessage(Message message){
       ConsoleHelper.writeString(message.getMessText() + " " + message.getSender());
    }

    private void getMessage(IOConnection connection){
        try {
            printMessage(connection.receave());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server start on: " + serverSocket);
            Socket socket = serverSocket.accept();
            IOConnection start = new IOConnection(socket);
            getMessage(start);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        Server server = new Server(port);
        server.start();

    }
}
