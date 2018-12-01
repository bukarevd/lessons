package lesson16.homework2;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args)  {
        Scanner path = new Scanner(System.in);
        File folder = new File(path.nextLine());
        File[] listOfFiles = folder.listFiles();
        String dest = path.nextLine();


        for (File f : listOfFiles) {
            try {
                Files.copy(f.toPath(), new File(dest + File.separator + f.getName()).toPath());
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static void copy(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

}
