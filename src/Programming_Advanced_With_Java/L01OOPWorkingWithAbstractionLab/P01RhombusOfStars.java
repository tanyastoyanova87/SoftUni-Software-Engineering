package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionLab;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int star = 1; star <= n; star++) {
            printRow(n, star);
        }

        for (int i = n - 1; i >= 1 ; i--) {
            printRow(n, i);
        }
        
    }

    private static void printRow(int n, int star) {
        for (int i = 0; i < n - star; i++) {
            System.out.print(" ");
        }
        for (int col = 1; col < star; col++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
