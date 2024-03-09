package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> namesAndEmails = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {

            String email = scanner.nextLine();
            if (!email.contains(".us") && !email.contains(".uk")
                    && !email.contains(".com")) {
                namesAndEmails.put(name, email);
            }

            name = scanner.nextLine();
        }

        namesAndEmails.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
