package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (int currentNum = num; currentNum <= num2 ; currentNum++) {

            int firstDigit = currentNum / 100000;
            int secondDigit = currentNum / 10000 % 10;
            int thirdDigit = currentNum / 1000 % 10;
            int fourthDigit = currentNum / 100 % 10;
            int fifthDigit = currentNum / 10 % 10;
            int sixthDigit = currentNum % 10;

            if (firstDigit + thirdDigit + fifthDigit == secondDigit + fourthDigit + sixthDigit){
                System.out.printf("%d ", currentNum);
            }
        }
    }
}
