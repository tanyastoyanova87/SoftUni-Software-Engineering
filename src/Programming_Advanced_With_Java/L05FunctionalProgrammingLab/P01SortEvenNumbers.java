package Programming_Advanced_With_Java.L05FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> even = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(even.toString().replaceAll("\\[|\\]", ""));

        Collections.sort(even);
        System.out.println(even.toString().replaceAll("\\[|\\]", ""));

    }
}
