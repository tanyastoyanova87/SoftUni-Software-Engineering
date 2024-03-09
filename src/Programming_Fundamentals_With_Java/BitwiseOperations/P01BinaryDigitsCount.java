package Programming_Fundamentals_With_Java.BitwiseOperations;

import java.util.Scanner;

public class P01BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while (n > 0) {
            int remainder = n % 2;
            n = n / 2;

            if (remainder == b) {
                count++;
            }
        }
        System.out.println(count);
    }
}
