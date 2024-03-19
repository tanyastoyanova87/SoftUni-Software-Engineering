package Programming_Advanced_With_Java.P07OOPReflectionExercises.P01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

        String input = scanner.nextLine();
        while (!"HARVEST".equals(input)) {

            Field[] declaredFields = richSoilLandClass.getDeclaredFields();

            if (input.equals("all")) {
                Arrays.stream(declaredFields).forEach(field -> {
                    System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
                });
            } else {
                String finalInput = input;
                Arrays.stream(declaredFields).filter(field -> Modifier.toString(field.getModifiers()).equals(finalInput))
                        .forEach(field -> System.out.printf("%s %s %s%n", finalInput, field.getType().getSimpleName(), field.getName()));
            }
            input = scanner.nextLine();
        }
    }
}

