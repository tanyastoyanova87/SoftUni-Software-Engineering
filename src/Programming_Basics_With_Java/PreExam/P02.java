package Programming_Basics_With_Java.PreExam;

import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());
        int foodInKg = Integer.parseInt(scanner.nextLine());
        double foodForOneDayFirstDeer = Double.parseDouble(scanner.nextLine());
        double foodForOneDaySecondDeer = Double.parseDouble(scanner.nextLine());
        double foodForOneDayThirdDeer = Double.parseDouble(scanner.nextLine());

        double firstDeer = daysOff * foodForOneDayFirstDeer;
        double secondDeer = daysOff * foodForOneDaySecondDeer;
        double thirdDeer = daysOff * foodForOneDayThirdDeer;

        double totalNeededFood = firstDeer + secondDeer + thirdDeer;

        if (foodInKg >= totalNeededFood){
            double diff = Math.floor(foodInKg - totalNeededFood);
            System.out.printf("%.0f kilos of food left.%n", diff);
        }else {
            double diff = Math.ceil(totalNeededFood - foodInKg);
            System.out.printf("%.0f more kilos of food are needed.%n", diff);
        }
    }
}
