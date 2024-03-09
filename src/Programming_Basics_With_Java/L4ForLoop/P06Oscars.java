package Programming_Basics_With_Java.L4ForLoop;

import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int countJudges = Integer.parseInt(scanner.nextLine());
        double allPoints = 0;

        allPoints = academyPoints;
        for (int i = 1; i <= countJudges ; i++) {

            String judgeName = scanner.nextLine();
            double judgePoints = Double.parseDouble(scanner.nextLine());


            allPoints = allPoints + (judgeName.length() * judgePoints) / 2;

            if (allPoints >= 1250.5){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, allPoints);
                break;
            }
        }
        if (allPoints < 1250.5){
            double diff = Math.abs(1250.5 - allPoints);
            System.out.printf("Sorry, %s you need %.1f more!", actorName,diff);
        }
    }
}
