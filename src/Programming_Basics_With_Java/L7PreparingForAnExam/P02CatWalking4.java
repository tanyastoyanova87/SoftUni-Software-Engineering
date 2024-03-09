package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02CatWalking4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesWalkInADay = Integer.parseInt(scanner.nextLine());
        int walksCountPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesTakenPerDay = Integer.parseInt(scanner.nextLine());

        int minutes = walksCountPerDay * minutesWalkInADay;
        int burnedCalories = minutes * 5;

        double calories50Off = 0.50 * caloriesTakenPerDay;

        if (burnedCalories >= calories50Off){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.%n", burnedCalories);
        }else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.%n", burnedCalories);
        }

    }
}
