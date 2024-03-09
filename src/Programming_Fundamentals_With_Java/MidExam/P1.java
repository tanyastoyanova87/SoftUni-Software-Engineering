package Programming_Fundamentals_With_Java.MidExam;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperienceAmount = Double.parseDouble(scanner.nextLine());
        int battlesCount = Integer.parseInt(scanner.nextLine());

        double sumExperience = 0.0;
        int sumBattles = 0;
        for (int i = 1; i <= battlesCount; i++) {
            double experienceEarnedPerBattle = Double.parseDouble(scanner.nextLine());
            sumExperience += experienceEarnedPerBattle;


            if (i % 3 == 0) {
                sumExperience += experienceEarnedPerBattle * 0.15;
            } else if (i % 5 == 0) {
                sumExperience -= experienceEarnedPerBattle * 0.10;
            }

            if (i % 15 == 0) {
                sumExperience += experienceEarnedPerBattle * 0.05;
            }
            if (sumExperience >= neededExperienceAmount) {
                sumBattles = i;
                break;
            }
        }
        if (sumExperience >= neededExperienceAmount) {
            System.out.printf("Player successfully collected his needed experience for %d battles.%n", sumBattles);
        } else {
            double neededMore = neededExperienceAmount - sumExperience;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n", neededMore);
        }
    }
}
