package Programming_Basics_With_Java.L6NestedLoops;

import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int currentNum = firstNum; currentNum <= secondNum; currentNum++) {

            int firstDigit = currentNum / 100000;
            int secondDigit = currentNum / 10000 % 10;
            int thirdDigit = currentNum / 1000 % 10;
            int fourthDigit = currentNum / 100 % 10;
            int fifthDigit = currentNum / 10 % 10;
            int sixthDigit = currentNum % 10;

            int evenSum = secondDigit + fourthDigit + sixthDigit;
            int oddSum = firstDigit + thirdDigit + fifthDigit;

            if (evenSum == oddSum){
                System.out.printf("%d ", currentNum);
            }
        }
    }
}
