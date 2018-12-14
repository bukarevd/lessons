package lesson1718.homework.task01;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {
    byte[] pass;
    int count = 0;

    @Override
    public void write(int b) throws IOException {
        int res = b ^ pass[count % pass.length];
        count++;
        super.write(res);
    }

    public CryptoOutputStream(OutputStream out) {
        super(out);
    }

    public CryptoOutputStream(OutputStream out, byte[] pass) {
        super(out);
        this.pass = pass;
    }

}
