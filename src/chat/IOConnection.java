package chat;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class IOConnection {
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public IOConnection(Socket socket) {
        this.socket = socket;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Message message) {
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public Message receave() throws IOException, ClassNotFoundException{
        return (Message) in.readObject();
    }

    public SocketAddress getRemoveSocketAddress(){
        return socket.getRemoteSocketAddress();
    }
}
