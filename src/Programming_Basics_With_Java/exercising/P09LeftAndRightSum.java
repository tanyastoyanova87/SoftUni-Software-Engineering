package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P09LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
        }

        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum2 += num;

        }
        if (sum == sum2){
            System.out.printf("Yes, sum = %d%n", sum);
        }else {
            int diff = Math.abs(sum - sum2);
            System.out.printf("No, diff = %d%n", diff);
        }

    }
}
