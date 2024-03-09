package Programming_Basics_With_Java.L6NestedLoops;

import java.util.Scanner;

public class P03SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!input.equals("stop")){
            int currentNum = Integer.parseInt(input);

            boolean isPrime = true;
            if (currentNum < 0){
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

            for (int current = 2; current < currentNum; current++) {

                if (currentNum % current == 0){
                    isPrime = false;
                    nonPrimeSum += currentNum;
                    break;
                }
            }
            if (isPrime){
                primeSum += currentNum;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d%n", nonPrimeSum);
    }
}
