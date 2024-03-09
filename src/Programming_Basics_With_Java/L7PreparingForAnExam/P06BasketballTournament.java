package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P06BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tournaments = scanner.nextLine();

        int wins = 0;
        int loses = 0;
        int totalGamesCount = 0;
        while (!tournaments.equals("End of tournaments")){
            int tournamentsCount = Integer.parseInt(scanner.nextLine());

            int gamesCount = 0;
            for (int i = 1; i <= tournamentsCount ; i++) {
                int desiTeamPoints = Integer.parseInt(scanner.nextLine());
                int otherTeam = Integer.parseInt(scanner.nextLine());

                gamesCount++;
                totalGamesCount++;
                int pointsDifference = Math.abs(desiTeamPoints - otherTeam);
                if (desiTeamPoints > otherTeam){
                    wins++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", gamesCount, tournaments, pointsDifference);
                }else {
                    loses++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", gamesCount, tournaments, pointsDifference);
                }
            }
            tournaments = scanner.nextLine();
        }
        double winsPercent = (wins * 1.0 / totalGamesCount) * 100;
        double losesPercent = (loses * 1.0 / totalGamesCount) * 100;

        System.out.printf("%.2f%% matches win%n", winsPercent);
        System.out.printf("%.2f%% matches lost%n", losesPercent);
    }
}
