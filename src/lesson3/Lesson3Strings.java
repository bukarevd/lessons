package lesson3;

public class Lesson3Strings {
    public static void main(String[] args) {
       /* String str = "String";
        String str2 = new String("String");

        String str3 = String.format("String %02d", 8);
        System.out.println(str3);

        String str4  = "String String";
        String str5  = "String";
        String str6  = "sTRING";

        System.out.println(str == str2); //falser
        System.out.println(str == str5); //true

        System.out.println(str.equals(str2)); // строки можно сравнивать только так
        System.out.println(str.equals(str5));

        System.out.println(str.equalsIgnoreCase(str6));
        System.out.println(str.equals(str6));

        System.out.println(str.startsWith("Q"));
        System.out.println(str.endsWith("Q")); //с учетом регистра

        String str10 = "string";
        String str11 = new String("string");
        String str12 = "str";
        String str13 = "String String";

        System.out.println(str10.compareTo(str11)); // возвращает 0 если строки одинаковы
        System.out.println(str11.compareTo(str12)); // положиетльное - вызывающя строка больше чем передаваемая
        System.out.println(str11.compareTo(str13)); // отрицательное - вызывающя строка меньше чем передаваемая (считается меньше из-за заглавной буквы)

        System.out.println(str11.compareToIgnoreCase(str13));

        String a = "Astring";
        String b = "Bstring";
        String c = "Cstring \"string\"";

        System.out.println(c);
        String[] strArr = {"c", "b", "a"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        System.out.println(a.substring(1, 4));
        System.out.println(a.contains("str"));

        String[] arr = {"qwe", "rty", "yui"};*/

        String string = "First ";
        String string2 = " string";
        System.out.println(string + string2);

        System.out.println("🚌");

        for (int i = 1; i < 10; i++){
            string += string2;
        }

        // при создании сложных строк лучше использовать классы StringBuffer или StringBuilder

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(string);
        for (int i = 0; i < 10; i++){
            strBuilder.append("string ").append("str ");
        }
        System.out.println(strBuilder.toString());
    }
}
