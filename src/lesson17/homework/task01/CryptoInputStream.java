package lesson17.homework.task01;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {
    private long readBytes;
    byte[] pass;

    public CryptoInputStream(InputStream in) {
        super(in);
    }

    public CryptoInputStream(InputStream in, byte[] pass) {
        super(in);
        this.pass = pass;
    }

    @Override
    public int read() throws IOException {
        int res = super.read();
        if (res >= 0) readBytes++;
        return res;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int res = super.read(b, off, len);
        if (res >= 0) readBytes+=res;
        res = (byte) (res ^ pass[0 % pass.length]);
        return res;
    }
}
