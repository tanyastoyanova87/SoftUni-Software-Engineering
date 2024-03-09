package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());


            if (maxNum < num){
                maxNum = num;
            }
            sum += num;

        }
        sum = sum - maxNum;

        if (maxNum == sum){
            System.out.println("Yes");
            System.out.printf("Sum = %d%n", sum );
        }else {
            int diff = Math.abs(sum - maxNum);
            System.out.println("No");
            System.out.printf("Diff = %d%n", diff);
        }
    }
}
