package Programming_Basics_With_Java.L6NestedLoops;

import java.util.Scanner;

public class P03Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= n ; j++) {
                for (int k = 0; k <= n ; k++) {
                    int sum = i + k + j;
                    if (sum == n ){
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
