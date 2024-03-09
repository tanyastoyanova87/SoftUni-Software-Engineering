package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbersAndAppearance = new LinkedHashMap<>();

        int count = 0;
        for (double num : numbers) {
            if (numbersAndAppearance.containsKey(num)) {
                numbersAndAppearance.put(num, numbersAndAppearance.get(num) + 1);
            } else {
                numbersAndAppearance.put(num, 1);
            }
        }

        numbersAndAppearance.entrySet().forEach(entry -> {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        });
    }
}
