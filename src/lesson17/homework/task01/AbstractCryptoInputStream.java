package lesson17.homework.task01;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

abstract class AbstractCryptoInputStream extends FilterInputStream {

    byte[] pass;
    InputStream in;

    public AbstractCryptoInputStream(InputStream in) {
        super(in);
    }

    public AbstractCryptoInputStream(InputStream in, byte[] pass){
        super(in);
        this.pass = pass;
    }

    @Override
    public int read() throws IOException {
        int res = super.read();
        System.out.println(res);
        return res;
    }
}
