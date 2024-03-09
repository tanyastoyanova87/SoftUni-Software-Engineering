package Programming_Fundamentals_With_Java.BitwiseOperations;

import java.util.Scanner;

public class P03PthBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int shiftedNum = num >> position;
        int lsb = shiftedNum & 1;

        System.out.println(lsb);
    }
}
