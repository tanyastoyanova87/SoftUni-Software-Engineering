package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P08TennisRankList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countTournament = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());
        int stagePoints = 0;
        int wins = 0;

        for (int i = 1; i <= countTournament; i++) {

            String tournamentStage = scanner.nextLine();

            if (tournamentStage.equals("W")) {
                wins++;
                stagePoints += 2000;
            } else if (tournamentStage.equals("F")) {
                stagePoints += 1200;
            } else if (tournamentStage.equals("SF")) {
                stagePoints += 720;
            }
        }
        int allPoints = startingPoints + stagePoints;
        int averagePoints = stagePoints / countTournament;
        double percent = (wins * 1.0 / countTournament) * 100;

        System.out.printf("Final points: %d%n", allPoints);
        System.out.printf("Average points: %d%n", averagePoints);
        System.out.printf("%.2f%%%n", percent);
    }
}
