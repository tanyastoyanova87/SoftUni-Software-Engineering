package Programming_Fundamentals_With_Java.BitwiseOperations;

import java.util.Scanner;

public class P04BitDestroyer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int mask = 1 << position;
        mask = ~mask;

        int result = num & mask;

        System.out.println(result);
    }
}
