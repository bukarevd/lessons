package lesson16.homework2;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        File file = new File("Products.txt");
        Scanner in = new Scanner(System.in);
        String action = in.nextLine();

        String[] actions = action.split(" ");
        switch (actions[0]) {
            case "-c":
                addProduct(actions, file);
                break;
            case "-d":
                delete(actions, file);
                break;
            case "-u":
                update(actions, file);
                break;
            default:
                read(actions);
        }

    }

    private static void addProduct(String[] strings, File file) {
        int id = getId();
        char[] productName;
        productName = strings[1].toCharArray();
        float price = Float.parseFloat(strings[2]);
        int quantity = Integer.parseInt(strings[3]);
        try (FileOutputStream out = new FileOutputStream(file, true)) {
            byte[] bytes = (id + " " + new String(productName) + " " + price + " " + quantity + "\n").getBytes(Charset.forName("UTF-8"));
            out.write(bytes);
        } catch (IOException e) {
            e.getStackTrace();

        }

    }


    protected static int readIdFile(File file) {
        int id = 0;
        try (FileInputStream in = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            id = Integer.parseInt(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.getStackTrace();
        } catch (NumberFormatException e) {
            writeIdFile(file, 1);
            readIdFile(file);
        }
        return id;
    }

    protected static void writeIdFile(File file, int id) {
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(new String(id + "").getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static int getId() {
        System.out.println("GetId");
        File fileId = new File("id.txt");
        int id = 0;
        if (!fileId.exists()) {
            System.out.println("file not found");
            id = 1;
            try {
                fileId.createNewFile();
            } catch (IOException e) {
                e.getStackTrace();
            }
            writeIdFile(fileId, id);
        } else {
            id = readIdFile(fileId);

            writeIdFile(fileId, ++id);
        }

        return id;
    }


    private static void update(String[] strings, File file) {
        try (FileOutputStream out = new FileOutputStream(file, false)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                sb.append(strings[i] + "\n");
            }
            out.write(sb.toString().getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    private static void delete(String[] strings, File file) {
        int delId = Integer.parseInt(strings[1]);
        String[] products = null;
        int j=0;
        try (FileInputStream in = new FileInputStream(file);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            products = byteArrayOutputStream.toString().split("\n");
            String[] newProduct = new String[products.length - 1];
            for (int i = 0; i < products.length; i++) {
                String[] product = products[i].split(" ");
                if (Integer.parseInt(product[0]) != delId) {
                    newProduct[j] = products[i];
                    j++;
                } else {
                    continue;
                }
            }
            update(newProduct, file);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private static void read(String[] strings) {
        System.out.println("Read");
    }


}
