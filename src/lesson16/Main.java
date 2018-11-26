package lesson16;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        File file = new File("stat.bin");
//        LaunchStat stat = null;
//        if(!file.exists())
//            stat = new LaunchStat();
//        else{
//            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
//               stat = (LaunchStat)objectInputStream.readObject();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if(stat.isFirstLaunch()){
//            System.out.println("First launch");
//        }else{
//            System.out.println(stat);
//        }
//        stat.update();
//
//        //сохранение
//        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
//            objectOutputStream.writeObject(stat);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File file = new File("stat2.bin");
        LaunchStatExternalizable stat = null;
        if(!file.exists()){
            stat = new LaunchStatExternalizable();
        }else{
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
                stat = (LaunchStatExternalizable)objectInputStream.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(stat.isFirstLaunch()){
            System.out.println("First launch");
        }else{
            System.out.println(stat);
        }
        stat.update();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(stat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
