package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int bearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());
        int allToysCount = puzzlesCount + dollsCount + bearsCount + minionsCount + trucksCount;

        double puzzlesPrice = puzzlesCount * 2.60;
        double dollPrice = dollsCount * 3;
        double bearsPrice = bearsCount * 4.10;
        double minionsPrice = minionsCount * 8.20;
        double trucksPrice = trucksCount * 2;
        double allToysPrice = puzzlesPrice + dollPrice + bearsPrice + minionsPrice + trucksPrice;

        if (allToysCount >= 50){
            allToysPrice = allToysPrice - (allToysPrice * 0.25);
        }
        allToysPrice = allToysPrice - (allToysPrice * 0.10);

        double leftOrNeededMoney = Math.abs(allToysPrice - tripPrice);
        if (allToysPrice >= tripPrice){
            System.out.printf("Yes! %.2f lv left.%n", leftOrNeededMoney);
        }else {
            System.out.printf("Not enough money! %.2f lv needed.%n", leftOrNeededMoney);
        }
    }
}
