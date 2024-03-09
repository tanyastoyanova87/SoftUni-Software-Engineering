package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P08NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(scanner.nextLine());


            if (num > maxNum){
                maxNum = num;
            }
            if (num < minNum){
                minNum = num;
            }
        }
        System.out.printf("Max number: %d%n", maxNum);
        System.out.printf("Min number: %d%n", minNum);
    }
}
