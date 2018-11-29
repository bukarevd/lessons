package lesson16.homework;

import java.io.*;
import java.nio.charset.Charset;

public class ListUsers extends Command implements Externalizable {
    private StringBuilder stringBuilder = new StringBuilder(System.getProperty("user.name") + "\n");
   // private String user = System.getProperty("user.name");
    private File file = new File("UserList.dat");

    private static final long serialVersionUID = 0L; //принято создавать 2 конст.
    private static final int VERSION = 0;



    @Override
    public void execute() {
      //  System.out.println(user);
        readUsers(file);
        writeUser(file);



    }
    private void writeUser(File file){
       // stringBuilder.append(System.getProperty("user.name") + "\n");
        if (!file.exists()){
            System.out.println("First enter");
        }
        try(FileOutputStream out = new FileOutputStream(file, true)) {
            out.write(stringBuilder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readUsers(File file){
        try (FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0){
                byteArrayOutputStream.write(bytes, 0, len);
            }
            System.out.println(new String(byteArrayOutputStream.toByteArray(),Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeUTF(stringBuilder.toString());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if(version > VERSION){
            throw new IOException("unsupport version");
        }
        stringBuilder.append( in.readUTF());
    }
}
