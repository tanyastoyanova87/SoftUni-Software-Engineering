package Programming_Advanced_With_Java.L05FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> function = x -> Integer.parseInt(x);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(", ")).map(function)
                .collect(Collectors.toList());

        int count = numbers.size();
        int sum = numbers.stream().mapToInt(x -> x).sum();
        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);

    }
}
