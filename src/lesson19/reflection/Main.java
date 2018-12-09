package lesson19.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //каждый загруженный класс имеет соответствующий java.lang.Class объект,
//        который дает доступ к структуре класса
//        У каждого типа есть чвой строковой литерал
        System.out.println(String.class);
        System.out.println(int.class);

//        Child child = new Child();
        Child child = new Child("str", 2);
        System.out.println(child.getClass()); // строковы литерал объекта
        // строковый литерал класса наследника
        Class cls;
        cls = child.getClass();
        System.out.println("child name " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("child extend " + cls.getName());

//        доступ к компонентам
        Class<Child> childClass = Child.class;
//        доступ к полям
        Field[] fields = childClass.getFields();
        System.out.println(Arrays.toString(fields));

//        доступ к declared полям
        Field[] declaredField = childClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredField));

//        доступ к методам
        Method[] methods = childClass.getMethods();
        System.out.println(Arrays.toString(methods));

        //        только метода объявленные в классе
        Method[] declaredMethod = childClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethod));

        //        доступ к конструкторам
        Constructor<?>[] declaredConstructor = childClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructor));

        //        доступ к конкретному полю, методу, конструктору
        Field field = childClass.getDeclaredField("name");
        //        получить доступ к полю
        field.setAccessible(true);
        field.set(child, "CHILD");
        System.out.println((String) field.get(child));

//        получить доступ к методу
        Method method = childClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(child);
        System.out.println(data);

        //получить доступ к конструктору
         Constructor<Child> childConstructor = childClass.getDeclaredConstructor(String.class, int.class);

         Child child1 = childConstructor.newInstance("CHILD 1", 3);
        System.out.println(child1);

        boolean isFinal = Modifier.isFinal(field.getModifiers());
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());

        Class<?>[] interfaces = childClass.getInterfaces();

    }
}
