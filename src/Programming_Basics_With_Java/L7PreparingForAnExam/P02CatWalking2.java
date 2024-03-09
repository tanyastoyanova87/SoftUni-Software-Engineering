package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P02CatWalking2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesWalkPerDay = Integer.parseInt(scanner.nextLine());
        int walksCountPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesCatTakes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = minutesWalkPerDay * walksCountPerDay;
        int totalCalories = totalMinutes * 5;
        double off = 0.50 * caloriesCatTakes;

       if (totalCalories >= off){
           System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.%n", totalCalories);
       }else {
           System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.%n", totalCalories);
       }
    }
}
