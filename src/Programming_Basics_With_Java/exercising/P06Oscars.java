package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double pointsAcademy = Double.parseDouble(scanner.nextLine());
        int estimators = Integer.parseInt(scanner.nextLine());

        double pointsGiven = pointsAcademy;
        for (int i = 1; i <= estimators; i++) {
            String estimatorName = scanner.nextLine();
            double pointsEstimator = Double.parseDouble(scanner.nextLine());

            pointsGiven = pointsGiven + ((estimatorName.length() * pointsEstimator) / 2);

            if (pointsGiven > 1250.5) {
                break;
            }
        }
        if (pointsGiven > 1250.5){
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!%n", actorName, pointsGiven);
        }else {
            double neededPoints = 1250.5 - pointsGiven;
            System.out.printf("Sorry, %s you need %.1f more!%n", actorName, neededPoints);
        }
    }
}
