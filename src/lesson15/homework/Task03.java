package lesson15.homework;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        File file = new File("task01.txt");
        File file2 = new File("task02.txt");
        Scanner in = new Scanner(System.in);
       // String key = in.next();
        // new Task03().encrypt(file, key);
        // new Task03().decrypt(file, key);
        File[] files = {file, file2};
        new Task03().encryptFile(files);
        new Task03().decryptFile(files);

    }

//    protected void encrypt(File file, String key) {
//        byte[] result = null;
//        try (InputStream inputStream = new FileInputStream(file);
//             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ) {
//            byte[] bytes = new byte[1024];
//            int len;
//            while ((len = inputStream.read(bytes)) > 0) {
//                byteArrayOutputStream.write(bytes, 0, len);
//            }
//            byte[] arr = byteArrayOutputStream.toByteArray();
//            byte[] str = key.getBytes();
//            result = new byte[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                result[i] = (byte) (arr[i] ^ str[i % str.length]);
//            }
//            System.out.println(Arrays.toString(result));
//        } catch (FileNotFoundException e) {
//            e.getStackTrace();
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
//        try (FileOutputStream fileOutputStream = new FileOutputStream(file, false)) {
//            fileOutputStream.write(result);
//        } catch (FileNotFoundException e) {
//            e.getStackTrace();
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
//    }
//
//
//    protected void decrypt(File file, String key) {
//        byte[] result = null;
//        try (InputStream inputStream = new FileInputStream(file);
//             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ) {
//            byte[] bytes = new byte[1024];
//            int len;
//            while ((len = inputStream.read(bytes)) > 0) {
//                byteArrayOutputStream.write(bytes, 0, len);
//            }
//            result = new byte[byteArrayOutputStream.toByteArray().length];
//            byte[] arr = byteArrayOutputStream.toByteArray();
//            byte[] keyarr = key.getBytes();
//            for (int i = 0; i < arr.length; i++) {
//                result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
//
//            }
//            System.out.println(Arrays.toString(result));
//        } catch (FileNotFoundException e) {
//            e.getStackTrace();
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
//        try (FileOutputStream fileOutputStream = new FileOutputStream(file, false)) {
//            fileOutputStream.write(result);
//        } catch (FileNotFoundException e) {
//            e.getStackTrace();
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
//    }

    protected void encryptFile(File[] files) {
        byte[] result = null;
        String keyString = "";
        //get key from file
        try (InputStream inputStream = new FileInputStream(files[1]);
             ByteArrayOutputStream byteArrayKeyFile = new ByteArrayOutputStream()) {
            byte[] keyBytes = new byte[1024];
            int keyLen;
            while ((keyLen = inputStream.read(keyBytes)) > 0) {
                byteArrayKeyFile.write(keyBytes, 0, keyLen);
            }
            keyString = byteArrayKeyFile.toString();
            // ----------
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        try (InputStream inputStream = new FileInputStream(files[0]);
        ByteArrayOutputStream byteArrayEncryptFiles = new ByteArrayOutputStream()){
            byte[] encryptBytes = new byte[1024];
            int len;
            while ((len = inputStream.read(encryptBytes)) > 0){
                byteArrayEncryptFiles.write(encryptBytes, 0, len);
            }
            result = new byte[byteArrayEncryptFiles.toByteArray().length];
            byte[] arr = byteArrayEncryptFiles.toByteArray();
            System.out.println(Arrays.toString(arr));
            byte[] keyarr = keyString.getBytes();
            for (int i = 0; i < arr.length; i++) {
                result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
            }
            System.out.println(Arrays.toString(result));
        }catch (FileNotFoundException e){

        }catch (IOException e){

        }

        try (FileOutputStream encryptFileOutputStream = new FileOutputStream(files[0], false)) {
            encryptFileOutputStream.write(result);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    protected void decryptFile(File[] files){
        byte[] result = null;
        String keyString = "";
        //get key from file
        try (InputStream inputStream = new FileInputStream(files[1]);
             ByteArrayOutputStream byteArrayKeyFile = new ByteArrayOutputStream()) {
            byte[] keyBytes = new byte[1024];
            int keyLen;
            while ((keyLen = inputStream.read(keyBytes)) > 0) {
                byteArrayKeyFile.write(keyBytes, 0, keyLen);
            }
            keyString = byteArrayKeyFile.toString();
            // ----------
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        try (InputStream inputStream = new FileInputStream(files[0]);
             ByteArrayOutputStream byteArrayEncryptFiles = new ByteArrayOutputStream()){
            byte[] encryptBytes = new byte[1024];
            int len;
            while ((len = inputStream.read(encryptBytes)) > 0){
                byteArrayEncryptFiles.write(encryptBytes, 0, len);
            }
            result = new byte[byteArrayEncryptFiles.toByteArray().length];
            byte[] arr = byteArrayEncryptFiles.toByteArray();
            System.out.println(Arrays.toString(arr));
            byte[] keyarr = keyString.getBytes();
            for (int i = 0; i < arr.length; i++) {
                result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
                System.out.println(result[i]);
            }
            System.out.println(Arrays.toString(result));
        }catch (FileNotFoundException e){

        }catch (IOException e){

        }

        try (FileOutputStream encryptFileOutputStream = new FileOutputStream(files[0], false)) {
            encryptFileOutputStream.write(result);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
