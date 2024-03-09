package Programming_Fundamentals_With_Java.BitwiseOperations;

import java.util.Scanner;

public class P02BitAtPosition1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int shiftedNum = num >> 1;
        int lsb = shiftedNum & 1;

        System.out.println(lsb);
    }
}
