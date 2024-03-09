package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03EnergyBooster3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String size = scanner.nextLine();
        int sets = Integer.parseInt(scanner.nextLine());

        double priceOfFruit = 0;
        if (fruit.equals("Watermelon")){

            if (size.equals("small")){
                priceOfFruit = 2 * 56;
            } else if (size.equals("big")) {
                priceOfFruit = 5 * 28.70;
            }
        } else if (fruit.equals("Mango")) {
            if (size.equals("small")){
                priceOfFruit = 2 * 36.66;
            } else if (size.equals("big")) {
                priceOfFruit = 5 * 19.60;

            }
        } else if (fruit.equals("Pineapple")) {
            if (size.equals("small")){
                priceOfFruit = 2 * 42.10;
            }else if (size.equals("big")){
                priceOfFruit = 5 * 24.80;
            }
        } else if (fruit.equals("Raspberry")) {
            if (size.equals("small")){
                priceOfFruit = 2 * 20;
            }else if (size.equals("big")){
                priceOfFruit = 5 * 15.20;

            }
        }
        double priseOfSets = sets * priceOfFruit;

        if (priseOfSets >= 400 && priseOfSets <= 1000){
            priceOfFruit = priseOfSets - (priseOfSets * 0.15);
        }else {
            priceOfFruit = priseOfSets - (priseOfSets * 0.50);
        }
        System.out.printf("%.2f lv.%n",priceOfFruit);
    }
}
