package Programming_Basics_With_Java.PreExam;

import java.util.Scanner;

public class P06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int thirdDigit = num % 10;
        int secondDigit = num / 10 % 10;
        int firstDigit = num / 100 % 10;

        for (int i = 1; i <= thirdDigit; i++) {

            for (int j = 1; j <= secondDigit; j++) {

                for (int k = 1; k <= firstDigit; k++) {

                    int multiplication = i * j * k;
                        System.out.printf("%d * %d * %d = %d;%n", i, j, k, multiplication);
                    }
                }
            }
        }
    }

