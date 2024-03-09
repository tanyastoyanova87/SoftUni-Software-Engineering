package Programming_Advanced_With_Java.L05FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findSmallestNum = num -> Arrays.stream(num).min(Integer::compareTo).get();

        Integer[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(findSmallestNum.apply(numbers));

    }
}
