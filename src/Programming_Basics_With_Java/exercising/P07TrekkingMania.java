package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupsCount = Integer.parseInt(scanner.nextLine());

        int musalla = 0;
        int monblan = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;
        int allPeople = 0;
        for (int i = 1; i <= groupsCount ; i++) {
            int peopleInCurrentGroup = Integer.parseInt(scanner.nextLine());

            allPeople += peopleInCurrentGroup;

            if (peopleInCurrentGroup <= 5){
                musalla += peopleInCurrentGroup;
            } else if (peopleInCurrentGroup <= 12) {
                monblan += peopleInCurrentGroup;
            } else if (peopleInCurrentGroup <= 25) {
                kilimanjaro += peopleInCurrentGroup;
            } else if (peopleInCurrentGroup <= 40) {
                k2 += peopleInCurrentGroup;
            } else {
                everest += peopleInCurrentGroup;
            }
        }

        double mussallaPercent = (musalla * 1.0 / allPeople) * 100;
        double monblanPercent = (monblan * 1.0 / allPeople) * 100;
        double kilimanjaroPercent = (kilimanjaro * 1.0 / allPeople) * 100;
        double k2Percent = (k2 * 1.0 / allPeople) * 100;
        double everestPercent = (everest * 1.0 / allPeople) * 100;

        System.out.printf("%.2f%%%n", mussallaPercent);
        System.out.printf("%.2f%%%n", monblanPercent);
        System.out.printf("%.2f%%%n", kilimanjaroPercent);
        System.out.printf("%.2f%%%n", k2Percent);
        System.out.printf("%.2f%%%n", everestPercent);

    }
}
