package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P04FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());

        int dogFoodCount = 0;
        int catFoodCount = 0;
        double biscuits = 0;
        for (int i = 1; i <= days ; i++) {
            int dogEats = Integer.parseInt(scanner.nextLine());
            dogFoodCount += dogEats;
            int catEats = Integer.parseInt(scanner.nextLine());
            catFoodCount += catEats;

            if (i % 3 == 0){
                biscuits = 0.10 * dogEats + 0.10 * catEats;
            }
        }
            System.out.printf("Total eaten biscuits: %.0fgr.%n", biscuits);
            double totalEatenFood = dogFoodCount + catFoodCount;
            double percentEatenFood = (totalEatenFood / totalFood) * 100;
            double percentDogEats = (dogFoodCount / totalEatenFood) * 100;
            double percentCatEats = (catFoodCount / totalEatenFood) * 100;
            System.out.printf("%.2f%% of the food has been eaten.%n", percentEatenFood);
            System.out.printf("%.2f%% eaten from the dog.%n", percentDogEats);
            System.out.printf("%.2f%% eaten from the cat.%n", percentCatEats);
    }
}
