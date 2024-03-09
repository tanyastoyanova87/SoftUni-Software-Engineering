package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesWalk = Integer.parseInt(scanner.nextLine());
        int walksCounter = Integer.parseInt(scanner.nextLine());
        int caloriesCatTakes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = minutesWalk * walksCounter;
        int caloriesBurnedPerDay = totalMinutes * 5;

        if (caloriesBurnedPerDay >= caloriesCatTakes * 0.50){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.%n", caloriesBurnedPerDay);
        }else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.%n", caloriesBurnedPerDay);
        }
    }
}
