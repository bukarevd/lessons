package lesson16.homework;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Client {
    private String serverAddress;

    private SocketAddress parseAddres(String address){
        String[] adr = address.split(":");
        return InetSocketAddress(adr[0], );
    }

    public static void main(String[] args) {


    }
}
