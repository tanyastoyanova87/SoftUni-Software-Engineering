package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int score = Integer.parseInt(scanner.nextLine());
        double bonusPoints;

        if (score <= 100) {
            bonusPoints = 5;

        } else if (score <= 1000) {
            bonusPoints = score * 0.2;

        } else {
            bonusPoints = score * 0.1;
        }

        if (score % 2 == 0) {
            bonusPoints = bonusPoints + 1;
        } else if (score % 10 == 5) {
            bonusPoints = bonusPoints + 2;
        }

        System.out.println(bonusPoints);
        System.out.println(score + bonusPoints);
    }
}
