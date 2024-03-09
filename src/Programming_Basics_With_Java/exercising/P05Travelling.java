package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")){
            double tripPrice = Double.parseDouble(scanner.nextLine());

            double sumTotal = 0;
                while (sumTotal < tripPrice){
                    double sum = Double.parseDouble(scanner.nextLine());
                    sumTotal += sum;
                }
            System.out.printf("Going to %s!%n", destination);

            destination = scanner.nextLine();
        }
    }
}
