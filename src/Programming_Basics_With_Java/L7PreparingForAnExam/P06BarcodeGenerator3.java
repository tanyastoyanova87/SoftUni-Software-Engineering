package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P06BarcodeGenerator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int finalNum = Integer.parseInt(scanner.nextLine());

        int firstDigit = firstNum / 1000 % 10;
        int secondDigit = firstNum / 100 % 10;
        int thirdDigit = firstNum / 10 % 10;
        int forthDigit = firstNum % 10;

        int firstDigitFinal = finalNum / 1000 % 10;
        int secondDigitFinal = finalNum / 100 % 10;
        int thirdDigitFinal = finalNum / 10 % 10;
        int forthDigitFinal = finalNum % 10;

        for (int i = firstDigit; i <= firstDigitFinal ; i++) {

            for (int j = secondDigit; j <= secondDigitFinal ; j++) {

                for (int k = thirdDigit; k <= thirdDigitFinal ; k++) {

                    for (int l = forthDigit; l <= forthDigitFinal ; l++) {

                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0){
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
