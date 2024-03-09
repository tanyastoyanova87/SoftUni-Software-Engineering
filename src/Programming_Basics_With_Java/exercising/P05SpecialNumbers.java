package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1111; i <= 9999 ; i++) {

            int firstDigit = i / 1000;
            int secondDigit = i / 100 % 10;
            int thirdDigit = i / 10 % 10;
            int fourthDigit = i % 10;
            if (secondDigit == 0 || thirdDigit == 0 || fourthDigit == 0){
                continue;
            }
            if (num % firstDigit == 0 && num % secondDigit == 0 && num % thirdDigit == 0 && num % fourthDigit == 0) {
                System.out.printf("%d ", i);
            }
        }
    }
}
