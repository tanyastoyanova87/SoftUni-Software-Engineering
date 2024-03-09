package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        while (sum < n){
            int num = Integer.parseInt(scanner.nextLine());

            sum += num;
        }
        System.out.println(sum);
    }
}
