package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    public static int getMultipleOfEvensAndOdds(String numbers) {
        int evenSum = getEvenSum(numbers);
        int oddSum = getOddSum(numbers);

        return evenSum * oddSum;
    }

    public static int getEvenSum(String numbers) {
        int evenSum = 0;
        int number = Math.abs(Integer.parseInt(numbers));

        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }
            number /= 10;
        }
        return evenSum;
    }

    public static int getOddSum(String numbers) {
        int oddSum = 0;
        int number = Math.abs(Integer.parseInt(numbers));

        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                oddSum += lastDigit;
            }
            number /= 10;
        }
        return oddSum;
    }
}
