package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P08TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentsCount  = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        int pointsCounter = startingPoints;
        int wins = 0;
        for (int i = 1; i <= tournamentsCount ; i++) {
            String stage = scanner.nextLine();

            if (stage.equals("W")){
                pointsCounter += 2000;
                wins++;
            } else if (stage.equals("F")) {
                pointsCounter += 1200;
            } else if (stage.equals("SF")) {
                pointsCounter += 720;
            }
        }
        double averagePoints = Math.floor((pointsCounter * 1.0 - startingPoints) / tournamentsCount);
        double winsPercent = (wins * 1.0 / tournamentsCount) * 100;
        System.out.printf("Final points: %d%n", pointsCounter);
        System.out.printf("Average points: %.0f%n", averagePoints);
        System.out.printf("%.2f%%%n", winsPercent);
    }
}
