package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01ChangeBureau4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double chinese = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double bitcoinInEuro = (bitcoins * 1168) / 1.95;
        double chineseInBgn = (chinese * 0.15) * 1.76;
        double chineseInEuro = chineseInBgn / 1.95;

        double euro = bitcoinInEuro + chineseInEuro;

        commission = (commission / 100) * euro;
        double result = euro - commission;

        System.out.printf("%.2f ", result);
    }
}
