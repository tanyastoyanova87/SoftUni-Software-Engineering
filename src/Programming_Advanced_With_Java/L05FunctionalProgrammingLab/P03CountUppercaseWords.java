package Programming_Advanced_With_Java.L05FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> upperCase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = s -> System.out.println(s);

        List<String> upperCaseWords = Arrays.stream(scanner.nextLine()
                .split("\\s+")).filter(upperCase)
                .collect(Collectors.toList());

        print.accept(String.valueOf(upperCaseWords.size()));
        upperCaseWords.forEach(print);
    }
}
