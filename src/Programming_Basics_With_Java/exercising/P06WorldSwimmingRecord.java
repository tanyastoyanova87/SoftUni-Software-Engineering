package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double timeFor1Meter = Double.parseDouble(scanner.nextLine());

        double time = timeFor1Meter * distanceInMeters;
        double slower = Math.floor(distanceInMeters / 15) * 12.5;
        double totalTime = time + slower;

        if (totalTime < recordInSeconds){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.%n", totalTime);
        }else {
            double overTime = totalTime - recordInSeconds;
            System.out.printf("No, he failed! He was %.2f seconds slower.%n", overTime);
        }
    }
}
