package lesson16.homework2;


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) throws IOException {
        Scanner path = new Scanner(System.in);
        File file = new File(path.nextLine());
        Path p = file.toPath();


        try(DirectoryStream<Path> stream = Files.newDirectoryStream(p)) {
            BasicFileAttributes attr =Files.readAttributes(p, BasicFileAttributes.class);
            for (Path file1 : stream) {
                if (!file1.toFile().isDirectory()) {


                        System.out.println(file.getPath() + " " + file1.getFileName() + attr.creationTime());

                }
            }
        } finally {
            path.close();
        }
    }
}
