package Programming_Advanced_With_Java.L05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> notDivisibleByN = num -> num % n != 0;

        numbers.stream()
                .filter(notDivisibleByN)
                .forEach(num -> System.out.print(num + " "));
    }
}
