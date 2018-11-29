package lesson16.homework;

import java.io.*;

public class ListUsers extends Command implements Externalizable {
    private String user = System.getProperty("user.name");

    private static final long serialVersionUID = 0L; //принято создавать 2 конст.
    private static final int VERSION = 0;

    private void update(){

    }

    @Override
    public void execute() {
        File file = new File("UserList.dat");

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeUTF(user);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if(version > VERSION){
            throw new IOException("unsupport version");
        }
        user = in.readUTF();
    }
}
