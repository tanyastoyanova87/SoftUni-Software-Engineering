package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01ChangeBureau3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double chineseMoney = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double chinesMoney = (chineseMoney * 0.15) * 1.76;
        double euro = (bitcoins * 1168 + chinesMoney) / 1.95;
        double withoutCommission = euro - (commission / 100 * euro);

        System.out.printf("%.2f ", withoutCommission);


    }
}
