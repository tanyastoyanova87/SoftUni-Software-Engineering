package Programming_Advanced_With_Java.L05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printWithSir = p -> System.out.println("Sir " + p);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printWithSir);

    }
}
