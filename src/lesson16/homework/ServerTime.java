package lesson16.homework;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTime implements Externalizable {
    Date time = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
    String formatDate = simpleDateFormat.format(time);

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 1;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(VERSION);
        out.writeUTF(formatDate);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION) {
            throw new IOException("unsupported version");
        }
        formatDate = in.readUTF();
    }
}
