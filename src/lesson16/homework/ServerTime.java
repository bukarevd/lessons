package lesson16.homework;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTime extends Command implements Externalizable{
    private Date time = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
    private String formatDate = simpleDateFormat.format(time);

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeUTF(formatDate);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        int version = in.readInt();
        if (version > VERSION) {
           throw new IOException("unsupported version " + version);
        }
        formatDate = in.readUTF();
    }

    @Override
    public void execute() {
        System.out.println(formatDate);
    }
}
