package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoinCount = Integer.parseInt(scanner.nextLine());
        double chineseMoneyCount = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        int bitcoinTotal = bitcoinCount * 1168;
        double chineseTotal = (chineseMoneyCount * 0.15) * 1.76;
        double totalLeva = (bitcoinTotal + chineseTotal) / 1.95;
        double commissionTotal = (commission * totalLeva) / 100;
        double totalSum = totalLeva - commissionTotal;

        System.out.printf("%.2f%n", totalSum);

    }
}
