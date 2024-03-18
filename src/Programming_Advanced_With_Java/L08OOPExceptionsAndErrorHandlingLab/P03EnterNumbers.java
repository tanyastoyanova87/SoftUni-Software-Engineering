package Programming_Advanced_With_Java.L08OOPExceptionsAndErrorHandlingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03EnterNumbers {
    private static int startNum = 1;
    private static int endNum = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> validNumbersList = new ArrayList<>();
        while (true) {
            readNumber(input, validNumbersList);

            if (validNumbersList.size() == 10) {
                break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", validNumbersList));
    }

    private static void readNumber(String input, List<String> validNumbersList) {
        try {
            int num = Integer.parseInt(input);
            if (num <= startNum || num >= endNum) {
                throw new IllegalArgumentException();
            } else {
                validNumbersList.add(String.valueOf(num));
                startNum = num;

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");
        } catch (IllegalArgumentException e) {
            System.out.printf("Your number is not in range %d - 100!%n", startNum);
        }
    }
}
