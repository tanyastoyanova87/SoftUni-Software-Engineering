package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P03DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int termDepositInMonths = Integer.parseInt(scanner.nextLine());
        double annualInterestRate = Double.parseDouble(scanner.nextLine());

        double dividend = depositSum * (annualInterestRate / 100);
        double dividendInOneMonth = dividend / 12;
        double sum = depositSum + termDepositInMonths * dividendInOneMonth;

        System.out.println(sum);
    }
}
