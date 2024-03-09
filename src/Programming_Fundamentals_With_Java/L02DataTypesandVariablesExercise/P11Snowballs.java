package Programming_Fundamentals_With_Java.L02DataTypesandVariablesExercise;

import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballs = Integer.parseInt(scanner.nextLine());

        int biggestSnowballSnow = 0;
        int biggestSnowballTime = 0;
        int biggestSnowballQuality = 0;
        double biggestValue = 0;
        double value = 0;

        double maxNum = Integer.MIN_VALUE;
        for (int i = 1; i <= snowballs ; i++) {

            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            value = Math.pow(snowballSnow * 1.0 / snowballTime, snowballQuality);

            if (value > maxNum){
                maxNum = value;
                biggestSnowballSnow = snowballSnow;
                biggestSnowballTime = snowballTime;
                biggestSnowballQuality = snowballQuality;
                biggestValue = value;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)%n", biggestSnowballSnow, biggestSnowballTime, biggestValue, biggestSnowballQuality);
    }
}
