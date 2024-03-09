package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double poolChairPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double allPeopleTax = tax * people;
        double neededChairs = Math.ceil(people * 0.75);
        double allChairsPrice = neededChairs * poolChairPrice;
        double neededUmbrellas = Math.ceil(people * 0.50);
        double allUmbrellaPrice = neededUmbrellas * umbrellaPrice;

        double totalPrice = allPeopleTax + allChairsPrice + allUmbrellaPrice;

        System.out.printf("%.2f lv.%n", totalPrice);
    }
}
