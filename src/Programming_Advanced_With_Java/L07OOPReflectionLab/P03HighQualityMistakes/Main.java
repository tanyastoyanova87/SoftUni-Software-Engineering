package Programming_Advanced_With_Java.L07OOPReflectionLab.P03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredFields()).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName()));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() == 1)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName()));
    }
}
