package Programming_Advanced_With_Java.P07OOPReflectionExercises.P02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int parameter = Integer.parseInt(tokens[1]);

            Method declaredMethod = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
            declaredMethod.setAccessible(true);

            declaredMethod.invoke(blackBoxInt, parameter);

            Field declaredField = blackBoxIntClass.getDeclaredField("innerValue");
            declaredField.setAccessible(true);

            System.out.println(declaredField.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
