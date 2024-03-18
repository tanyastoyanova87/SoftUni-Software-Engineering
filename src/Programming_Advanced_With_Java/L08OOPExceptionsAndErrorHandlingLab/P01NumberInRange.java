package Programming_Advanced_With_Java.L08OOPExceptionsAndErrorHandlingLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01NumberInRange {

    private static int start = 0;
    private static int end = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        start = range[0];
        end = range[1];

        System.out.printf("Range: [%d...%d]%n", start, end);

        while (true) {
            String line = scanner.nextLine();
            try {
                int num = Integer.parseInt(line);
                if (isValid(num)) {
                    System.out.printf("Valid number: %d%n", num);
                    return;
                } else {
                    System.out.printf("Invalid number: %s%n", line);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid number: %s%n", line);
            }
        }

    }

    public static boolean isValid(int num) {
        return num >= start && num <= end;
    }
}
