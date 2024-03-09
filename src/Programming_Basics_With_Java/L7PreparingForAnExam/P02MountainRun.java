package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMetres = Double.parseDouble(scanner.nextLine());
        double timeInSecondsForOneMeter = Double.parseDouble(scanner.nextLine());

        double totalSeconds = distanceInMetres * timeInSecondsForOneMeter;
        double plus30 = Math.floor(distanceInMetres / 50) * 30;
        double totalSecondPlus30 = totalSeconds + plus30;

        if (recordInSeconds > totalSecondPlus30){
            System.out.printf("Yes! The new record is %.2f seconds.%n", totalSecondPlus30);
        }else {
            double needed = totalSecondPlus30 - recordInSeconds;
            System.out.printf("No! He was %.2f seconds slower.%n", needed);
        }
    }
}
