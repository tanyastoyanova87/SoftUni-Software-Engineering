package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int primeSum = 0;
        int nonPrime = 0;

        while (!command.equals("stop")){
            int currentNum = Integer.parseInt(command);

            boolean isPrime = true;

            if (currentNum < 0){
                System.out.println("Number is negative.");
                command = scanner.nextLine();
                continue;
            }

            for (int current = 2; current <= currentNum - 1 ; current++) {

                if (currentNum % current == 0){
                    isPrime = false;
                    nonPrime += currentNum;
                    break;
                }
            }
            if (isPrime){
                primeSum += currentNum;
            }
            command = scanner.nextLine();
            }
        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d%n", nonPrime);
    }
}
