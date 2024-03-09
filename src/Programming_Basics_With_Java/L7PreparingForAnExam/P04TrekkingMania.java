package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P04TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupsCount = Integer.parseInt(scanner.nextLine());

        int peopleCount = 0;
        int countMusala = 0;
        int countMonblan = 0;
        int countKilimanjaro = 0;
        int countK2 = 0;
        int countEverest = 0;
        for (int i = 1; i <= groupsCount ; i++) {
            int peoplePerGroup = Integer.parseInt(scanner.nextLine());
            peopleCount += peoplePerGroup;

            if (peoplePerGroup <= 5){
                countMusala += peoplePerGroup;
            } else if (peoplePerGroup <= 12) {
                countMonblan += peoplePerGroup;
            } else if (peoplePerGroup <= 25) {
                countKilimanjaro += peoplePerGroup;
            } else if (peoplePerGroup <= 40) {
                countK2 += peoplePerGroup;
            } else {
                countEverest += peoplePerGroup;
            }
        }
        double musalaPercent = (countMusala * 1.0 / peopleCount) * 100;
        double monblanPercent = (countMonblan * 1.0 / peopleCount) * 100;
        double kilimanjaroPercent = (countKilimanjaro * 1.0 / peopleCount) * 100;
        double k2Percent = (countK2 * 1.0 / peopleCount) * 100;
        double everestPercent = (countEverest * 1.0 / peopleCount) * 100;

        System.out.printf("%.2f%%%n", musalaPercent);
        System.out.printf("%.2f%%%n", monblanPercent);
        System.out.printf("%.2f%%%n", kilimanjaroPercent);
        System.out.printf("%.2f%%%n", k2Percent);
        System.out.printf("%.2f%%%n", everestPercent);
    }
}
