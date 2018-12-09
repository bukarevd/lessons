package lesson1718.homework.task01;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CryptoInputStream extends FilterInputStream {
    byte[] pass;
    int count = 0;
    byte[] b2;

    public CryptoInputStream(InputStream in) {
        super(in);
    }

    public CryptoInputStream(InputStream in, byte[] pass) {
        super(in);
        this.pass = pass;

    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {


        return super.read(decoded(b), off, len);
    }

    public byte[] decoded(byte[] b){
        System.out.println(Arrays.toString(b));
        for(int i = 0; i < b.length; i++){
            b[i] = (byte) (b[i] ^ pass[count % pass.length]);
            count++;
        }
        System.out.println(Arrays.toString(b));
        return b;
    }


}
