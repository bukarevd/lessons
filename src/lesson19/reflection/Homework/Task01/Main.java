package lesson19.reflection.Homework.Task01;

import java.lang.reflect.Field;


public class Main {
    public static void main(String[] args) {
        TestClass test = new TestClass();
        testClass2 testClass2 = new testClass2();
        try {
            printMethod(test);
            printMethod(testClass2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void printMethod(Object testClass) throws IllegalAccessException {
        Class cla = testClass.getClass();
        System.out.println(cla.getName());
        Field[] fields = cla.getDeclaredFields();
        String name = cla.getSimpleName();
        boolean isPremitive = cla.isPrimitive();
        System.out.println("isPrimitibe= " + isPremitive);
        boolean isArray = cla.isArray();
        System.out.println("isArray= " + isArray);
        System.out.println("Class name = " + name + " { ");
        for (int i = 0; i < fields.length; i++) {
            System.out.println("name= " + fields[i].getName() + " type = " + fields[i].getType() + " value = " +
                    fields[i].get(testClass));
        }
        System.out.println(" }");

    }

}
