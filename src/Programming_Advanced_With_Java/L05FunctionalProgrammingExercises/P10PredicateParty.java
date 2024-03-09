package Programming_Advanced_With_Java.L05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        Predicate<String> isValid;

        String line = scanner.nextLine();
        while (!"Party!".equals(line)) {

            String[] tokens = line.split("\\s");
            String command = tokens[0];
            String criteria = tokens[1];
            String text = tokens[2];

            switch (criteria) {
                case "StartsWith":
                    isValid = s -> s.startsWith(text);
                    break;
                case "EndsWith":
                    isValid = s -> s.endsWith(text);
                    break;
                default:
                    isValid = s -> s.length() == Integer.parseInt(text);
                    break;
            }
            if ("Double".equals(command)) {
                List<String> result = guests.stream().filter(isValid).collect(Collectors.toList());
                guests.addAll(result);
            } else if ("Remove".equals(command)) {
                guests.removeIf(isValid);
            }
            line = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String collect = guests.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(collect + " are going to the party!");
        }
    }
}
