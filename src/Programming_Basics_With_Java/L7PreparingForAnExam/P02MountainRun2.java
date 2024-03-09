package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02MountainRun2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double timeInSecondsForOneMeter = Double.parseDouble(scanner.nextLine());

        double meters = distanceInMeters * timeInSecondsForOneMeter;
        double secondsSlower = (Math.floor(distanceInMeters / 50)) * 30;
        double totalTime = meters + secondsSlower;

        if (recordInSeconds > totalTime){
            System.out.printf("Yes! The new record is %.2f seconds.%n", totalTime);
        }else {
            double left = totalTime - recordInSeconds;
            System.out.printf("No! He was %.2f seconds slower.%n", left);
        }
    }
}
