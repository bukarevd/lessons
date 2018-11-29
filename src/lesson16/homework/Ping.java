package lesson16.homework;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Ping extends Command implements Externalizable {
    private long startTime = System.currentTimeMillis();

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
         out.writeInt(VERSION);
         out.writeLong(startTime);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if(version > VERSION){
            System.out.println("unsupport version");
        }
        startTime -= System.currentTimeMillis();

    }

    @Override
    public void execute() {
        System.out.println(startTime);
    }
}
