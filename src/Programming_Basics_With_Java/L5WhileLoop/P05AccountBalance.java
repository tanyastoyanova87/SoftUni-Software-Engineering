package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;
        while (!input.equals("NoMoreMoney")){
            double num = Double.parseDouble(input);

            if (num < 0){
                System.out.printf("Invalid operation!%n");
                break;
            }
            sum += num;
            System.out.printf("Increase: %.2f%n", num);
            input = scanner.nextLine();

        }
        System.out.printf("Total: %.2f%n",sum );
    }
}
