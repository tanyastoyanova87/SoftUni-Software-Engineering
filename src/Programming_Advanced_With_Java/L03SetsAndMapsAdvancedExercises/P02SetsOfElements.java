package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> ns = new LinkedHashSet<>();
        Set<Integer> ms = new LinkedHashSet<>();

        int[] sizes = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int n = sizes[0];
        int m = sizes[1];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            ns.add(num);
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            ms.add(num);
        }

        for (int num : ns) {
            for (int num2 : ms) {
                if (num == num2) {
                    System.out.print(num + " ");
                }
            }
        }
    }
}
