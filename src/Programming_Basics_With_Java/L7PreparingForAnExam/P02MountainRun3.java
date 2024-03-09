package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02MountainRun3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double secondsFor1Meter = Double.parseDouble(scanner.nextLine());

        double seconds = distanceInMeters * secondsFor1Meter;
        double slower = (Math.floor(distanceInMeters / 50) * 30);
        double totalTime = seconds + slower;

        if (totalTime < recordInSeconds){
            System.out.printf("Yes! The new record is %.2f seconds.%n", totalTime);
        }
        else {
            double neededSeconds = totalTime - recordInSeconds;
            System.out.printf("No! He was %.2f seconds slower.%n", neededSeconds);
        }

    }
}
