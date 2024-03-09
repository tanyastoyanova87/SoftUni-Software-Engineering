package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int foodKg = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int counterGrams = 0;
        int foodInGrams = foodKg * 1000;
        while (!command.equals("Adopted")){
            int eatenFoodGrams = Integer.parseInt(command);
            counterGrams += eatenFoodGrams;


            command = scanner.nextLine();
        }
        int left = Math.abs(foodInGrams - counterGrams);
        if (counterGrams <= foodInGrams){
            System.out.printf("Food is enough! Leftovers: %d grams.%n",left);
        }else {
            System.out.printf("Food is not enough. You need %d grams more.%n", left);
        }
    }
}
