package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seralName = scanner.nextLine();
        int episodeTime = Integer.parseInt(scanner.nextLine());
        int breakTime = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakTime / 8.0;
        double rest = breakTime / 4.0;
        double leftTime = breakTime - (lunchTime + rest);

        double leftOrNeeded = Math.ceil(Math.abs(leftTime - episodeTime));
        if (leftTime >= episodeTime){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.%n", seralName, leftOrNeeded);
        }else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.%n", seralName, leftOrNeeded);
        }
    }
}
