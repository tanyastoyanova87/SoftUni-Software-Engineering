package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine());
        BigInteger secondNum2 = new BigInteger(scanner.nextLine());

        BigInteger result = firstNum.multiply(secondNum2);

        System.out.println(result);
    }
}
