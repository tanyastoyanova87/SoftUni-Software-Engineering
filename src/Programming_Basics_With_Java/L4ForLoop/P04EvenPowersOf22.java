package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P04EvenPowersOf22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int num = 1;

        for (int i = 0; i <= n; i+=2) {
            System.out.println(num);
            num = num * 2 * 2;

        }
    }
}
