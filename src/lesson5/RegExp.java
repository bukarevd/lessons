package lesson5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        String string = "Строка 1 для поиска и замены СИМВОЛОВ";
        String pattern = "иск";
        System.out.println(string.replaceAll(pattern, "*!*"));
        pattern = "^Стр"; // ^ - начало строки, $ - конец строки
        System.out.println(string.replaceAll(pattern, "*!*"));
        pattern = "[иск]"; //Перечень символов
        System.out.println(string.replaceAll(pattern, "*"));
        pattern = "[^иск]"; // поиск всех символов, кроме указанных
        System.out.println(string.replaceAll(pattern, "*"));
        pattern = "\\d"; //ищем цифровой символ
        System.out.println(string.replaceAll(pattern, "*"));
        pattern = "\\D"; //ищем не цифровой символ
        System.out.println(string.replaceAll(pattern, "*"));
        // w - буквинно-цифровой символ или "_"
        // W - не w
        // s - заменяет любой пробельный символ
        // S - не s
        pattern = "\\s";
        System.out.println(string.replaceAll(pattern, "*"));
        pattern = "[а-яё]"; // Буквы от а до я
        System.out.println(string.replaceAll(pattern, "*"));
        pattern = "[А-Я0-9]";// [А-Я][0-9] -Сначала большая букава, потом цифра
        System.out.println(string.replaceAll(pattern, "*"));


//        Pattern | Matcher
        string = "String B1 to search and replace CHARS";

        Pattern pattern1 = Pattern.compile(".{6,}"); // . - любой символ в строке, {} - повторение символ (от и до), | - или
        pattern1 = Pattern.compile("(?=.*\\d)(?=.*\\[a-z])(?=.*\\[A-Z])"); //?= - означает соответствует, * - означает, что символ повторяется  0 и более раз
        Matcher matcher = pattern1.matcher(string);
        System.out.println(matcher.find()); // true | false ищет совпадение по заданному шаблону в заданной строке
        System.out.println(matcher.matches());// true | false


    }
}
