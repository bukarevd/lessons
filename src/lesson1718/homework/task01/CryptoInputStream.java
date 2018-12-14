package lesson1718.homework.task01;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class CryptoInputStream extends FilterInputStream {
    byte[] pass;
    int count = 0;

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
        res = res ^ pass[count % pass.length];
        count++;
        return res;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int res = super.read(b, 0, len);
        for(int i = 0; i < b.length; i++){
            b[i] = (byte) (b[i] ^ pass[count % pass.length]);
            count++;
        }
        return res;
    }



}
