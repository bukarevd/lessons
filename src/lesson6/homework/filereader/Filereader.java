package lesson6.homework.filereader;

public class Filereader {
    public void getType(String fileName) {
        String separator = "\\.";
        String[] file = fileName.split(separator);
        switch (file[file.length - 1].toLowerCase()) {
            case "xml":
                readXML(fileName);
                break;
            case "txt":
                readTXT(fileName);
                break;
            default:
                System.out.println("Неизвестный файл");
                break;


        }
    }

    public String readXML(String fileName) {
        System.out.println("Читаем XML");
        return "Читаем XML";
    }

    public String readTXT(String fileName) {
        System.out.println("Читаем TXT");
        return "Читаем TXT";
    }
}
