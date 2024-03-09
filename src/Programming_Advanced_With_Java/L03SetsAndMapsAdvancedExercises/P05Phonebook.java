package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"search".equals(input)) {

            String[] nameAndNumber = input.split("-");
            String name = nameAndNumber[0];
            String phoneNumber = nameAndNumber[1];

            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            name = scanner.nextLine();
        }
    }
}
