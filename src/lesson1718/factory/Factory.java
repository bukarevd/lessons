package lesson1718.factory;

abstract class Handler {
    abstract void read();

    abstract void write();
}

class TxtHandler extends Handler {
    @Override
    void read() {
        System.out.println("Read txt");
    }

    @Override
    void write() {
        System.out.println("Write txt");
    }
}

class XmlHandler extends Handler {
    @Override
    void read() {
        System.out.println("Read xml");
    }

    @Override
    void write() {
        System.out.println("Write xml");
    }
}

public class Factory {

    public Handler getHandler(String string){
        Handler handler = null;
        if(string.endsWith("txt")){
            handler = new TxtHandler();
        }else if(string.endsWith("xml")){
            handler = new XmlHandler();
        }
        return  handler;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        String file = "qwe.txt";
        Handler str = factory.getHandler(file);
        str.read();
    }

}
