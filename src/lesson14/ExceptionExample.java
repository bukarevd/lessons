package lesson14;

import java.util.Arrays;

public class ExceptionExample {
    public static void main(String[] args) {
        int[] arr = new int[5];
        //  arr[10] = 23; //java.lang.ArrayIndexOutOfBoundsException
        System.out.println(Arrays.toString(arr));

//        доступ к объекту по null ссылке
        String string = null; //java.lang.NullPointerException
        // string.equals("some string");

        int a = 9;
        int b = 0;
        // System.out.println(a/b); //java.lang.ArithmeticException: / by zero

//        Integer.parseInt("abc"); //java.lang.NumberFormatException
//        Свое исключение
//        throw new NumberFormatException("NFE");

        //обработка исключений
//        try-catch
        Object data = "42";

//        try {
//            Integer intData = (Integer) data; //ClassCastException
//            System.out.println("code after");
//        }

//        } catch (ClassCastException e){
//            System.out.println("exception " + e.getMessage());
//        }catch (NullPointerException e){
//            System.out.println("exception " + e.getMessage());
//        }
//        catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
//            System.out.println("exception " + e.getMessage());
//            System.out.println(Arrays.toString(e.getStackTrace()));
//            System.out.println(e.fillInStackTrace());
//            System.out.println(e.getCause());
//        }

//        catch (RuntimeException e){
//            System.out.println("exception " + e.getMessage());
//        }
//        finally {
//            //в блоке закрывают подключения к ресурсам
//            System.out.println("finally");
//        }
//        System.out.println("code after try-catch");

        //cheked exception
//        try {
//            throw new Exception("checked exception");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            voidWithException();
        } catch (Exception e) {
          //  e.printStackTrace();
        }

//        if (a < 9)
//        throw new UnchekedException("UncheckedException");

        //throw new CheckedException("CheckedException");

        try {
            voidWithCheckException();
        } catch (CheckedException e) {
            e.printStackTrace();
            throw new UnchekedException("In catch");
        }

    }
    public static void voidWithException() throws Exception {
        throw new Exception("checked exception");
    }
    public static void voidWithCheckException() throws CheckedException {
        throw new CheckedException("checked exception");
    }
}