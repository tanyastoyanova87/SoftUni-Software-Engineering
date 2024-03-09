package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P07TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countGroupsClimbers = Integer.parseInt(scanner.nextLine());
        int musala = 0;
        int monblan = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;
        for (int i = 1; i <= countGroupsClimbers ; i++) {
            int countPeopleInGroup = Integer.parseInt(scanner.nextLine());

            if (countPeopleInGroup <= 5) {
                musala += countPeopleInGroup;
            } else if (countPeopleInGroup <= 12) {
                monblan += countPeopleInGroup;
            } else if (countPeopleInGroup <= 25) {
                kilimanjaro += countPeopleInGroup;
            } else if (countPeopleInGroup <= 40) {
                k2 += countPeopleInGroup;
            } else {
                everest += countPeopleInGroup;
            }
        }
        int allClimbers = musala + monblan + kilimanjaro + k2 + everest;
        double percentMusala = (musala * 1.0 / allClimbers) * 100;
        double percentMonblan = (monblan * 1.0 / allClimbers) * 100;
        double percentKilimanjaro = (kilimanjaro * 1.0 / allClimbers) * 100;
        double percentK2 = (k2 * 1.0 / allClimbers) * 100;
        double percentEverest = (everest * 1.0 / allClimbers) * 100;

        System.out.printf("%.2f%%%n", percentMusala);
        System.out.printf("%.2f%%%n", percentMonblan);
        System.out.printf("%.2f%%%n", percentKilimanjaro);
        System.out.printf("%.2f%%%n", percentK2);
        System.out.printf("%.2f%%%n", percentEverest);
    }
}
