package lesson17.homework.task01;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {
    private long readBytes;
    byte[] pass;

    @Override
    public void write(int b) throws IOException {
        int res = b;
//        шифрование
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
