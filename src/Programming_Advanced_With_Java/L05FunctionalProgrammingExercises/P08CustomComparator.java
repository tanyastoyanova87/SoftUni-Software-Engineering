package Programming_Advanced_With_Java.L05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Comparator<Integer> sort = (first, second) -> {

            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
               return first.compareTo(second);
            }
        };

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(sort)
                .forEach(e -> System.out.print(e + " "));
    }
}
