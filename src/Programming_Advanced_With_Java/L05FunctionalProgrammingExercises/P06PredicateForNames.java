package Programming_Advanced_With_Java.L05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> isValidName = name -> name.length() <= n;

        Arrays.stream(names)
                .filter(isValidName)
                .forEach(System.out::println);
    }
}
