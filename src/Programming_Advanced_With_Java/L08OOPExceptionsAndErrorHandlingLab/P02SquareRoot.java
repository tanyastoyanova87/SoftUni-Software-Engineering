package Programming_Advanced_With_Java.L08OOPExceptionsAndErrorHandlingLab;

import java.util.Scanner;

public class P02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            if (isValid(number)) {
                double result = Math.sqrt(number);
                System.out.printf("%.2f%n", result);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException exception) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    public static boolean isValid(int number) {
        return number > 0;
    }
}
