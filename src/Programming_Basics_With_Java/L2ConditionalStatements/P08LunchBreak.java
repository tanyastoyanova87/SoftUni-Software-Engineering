package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serial = scanner.nextLine();
        int episodeTime = Integer.parseInt(scanner.nextLine());
        int lunchBreak = Integer.parseInt(scanner.nextLine());

        double timeForLunch = lunchBreak * (1.0 / 8.0);
        double timeForRest = lunchBreak * (1.0 / 4.0);
        double timeLeft = lunchBreak - timeForLunch - timeForRest;

        if (timeLeft >= episodeTime){
            timeLeft = Math.ceil(timeLeft - episodeTime);
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", serial, timeLeft);

        } else {
            timeLeft = Math.ceil(episodeTime - timeLeft);
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", serial, timeLeft);
        }
    }
}
