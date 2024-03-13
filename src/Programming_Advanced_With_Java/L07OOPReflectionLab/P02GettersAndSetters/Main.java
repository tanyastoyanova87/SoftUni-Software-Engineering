package Programming_Advanced_With_Java.L07OOPReflectionLab.P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                        .filter(method -> method.getName()
                        .startsWith("get") && method.getParameterCount() == 0)
                        .sorted(Comparator.comparing(Method::getName))
                        .forEach(method -> System.out.printf("%s will return class %s%n",
                        method.getName(), method.getReturnType().getName()));

        Arrays.stream(declaredMethods)
                        .filter(method -> method.getName()
                        .startsWith("set") && method.getParameterCount() == 1)
                        .sorted(Comparator.comparing(Method::getName))
                        .forEach(method -> System.out.printf("%s and will set field of class %s%n",
                        method.getName(), method.getParameterTypes()[0].getName()));
    }
}
