package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int depositMonths = Integer.parseInt(scanner.nextLine());
        double percentYear = Double.parseDouble(scanner.nextLine());

        double dividend = depositSum * (percentYear / 100);
        double dividendPerMonth = dividend / 12;


        double sum = depositSum + depositMonths * dividendPerMonth;

        System.out.println(sum);
    }
}
