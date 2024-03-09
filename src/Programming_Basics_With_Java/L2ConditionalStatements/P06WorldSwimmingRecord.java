package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMetres = Double.parseDouble(scanner.nextLine());
        double timeInSeconds = Double.parseDouble(scanner.nextLine());

        double swimmingTime = distanceInMetres * timeInSeconds;
        double waterResistance = Math.floor(distanceInMetres / 15) * 12.5;
        double fullTime = swimmingTime + waterResistance;

        if (fullTime < recordInSeconds){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", fullTime);
        } else {
            double neededSeconds = fullTime - recordInSeconds;
            System.out.printf("No, he failed! He was %.2f seconds slower.", neededSeconds);
        }
    }
}
