package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearTax = Integer.parseInt(scanner.nextLine());

        double basketballShoesPrice = yearTax - (yearTax * 0.40);
        double basketballEquip = basketballShoesPrice - (basketballShoesPrice * 0.20);
        double basketBall = basketballEquip / 4;
        double basketAccessories = basketBall / 5;

        double totalPrice = basketballShoesPrice + basketballEquip + basketBall + basketAccessories + yearTax;

        System.out.println(totalPrice);

    }
}
