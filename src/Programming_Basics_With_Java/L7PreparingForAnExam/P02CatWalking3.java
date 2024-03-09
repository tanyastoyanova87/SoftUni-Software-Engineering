package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02CatWalking3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesWalkPerDay = Integer.parseInt(scanner.nextLine());
        int walksCountPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesCatTakesPerDay = Integer.parseInt(scanner.nextLine());

        int walks = walksCountPerDay * minutesWalkPerDay;
        int caloriesBurnt = walks * 5;
        double takenCalories = caloriesCatTakesPerDay * 0.50;

        if (caloriesBurnt >= takenCalories){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.%n", caloriesBurnt);
        }else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.%n", caloriesBurnt);
        }

    }
}
