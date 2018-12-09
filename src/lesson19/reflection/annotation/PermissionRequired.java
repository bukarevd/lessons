package lesson19.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//описание
//В аннотациях методы не могут принимать параметры
//Возвращать только примитивы, enum, String, аннотации

//мета аннотация
//@Target(ElementType.FIELD) указывает к чемуможет быть применена аннотация(метод, поле, класс, конструктор)
//@Retention(RetentionPolicy.RUNTIME) указывает как долго хранить аннотации (к моменту выполнения, к байт-коду, к компиляции)
//@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {
    User.Permission value();
}
