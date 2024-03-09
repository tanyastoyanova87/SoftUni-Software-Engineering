package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01ChangeBureau2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoints = Integer.parseInt(scanner.nextLine());
        double chineseMoney = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        int bitcoin = bitcoints * 1168;
        double chinese = chineseMoney * 0.15;
        double dollarstoleva = chinese * 1.76;
        double total = (bitcoin + dollarstoleva) / 1.95;

        double commissionTotal = (commission / 100) * total;
        double totalResult = total - commissionTotal;
        System.out.printf("%.2f%n", totalResult);
    }
}
