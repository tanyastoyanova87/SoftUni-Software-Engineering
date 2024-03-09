package Programming_Advanced_With_Java.L05FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = x -> x * 1.2;

        Double[] result = Arrays.stream(scanner.nextLine()
                .split(",\\s+")).map(Double::parseDouble)
                .map(addVat)
                .toArray(Double[]::new);

        Consumer<Double[]> printDoubleArray = r -> {
            System.out.println("Prices with VAT:");
            for (Double aDouble : r) {
                System.out.printf("%.2f%n", aDouble);
            }
        };

        printDoubleArray.accept(result);
    }
}
