package Programming_Basics_With_Java.L6NestedLoops;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String destination = input;
            double tripPrice = Double.parseDouble(scanner.nextLine());

            double sum = 0;
            while (sum < tripPrice){
                double currentNum = Double.parseDouble(scanner.nextLine());
                sum += currentNum;

            }
            System.out.printf("Going to %s!%n", destination);

            input = scanner.nextLine();
        }
    }
}
