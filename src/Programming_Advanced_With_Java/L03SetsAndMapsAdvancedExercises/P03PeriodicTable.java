package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicals = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] chemical = scanner.nextLine().split("\\s+");
            chemicals.addAll(Arrays.asList(chemical));

        }

        chemicals.forEach(s -> System.out.print(s + " "));
    }
}
