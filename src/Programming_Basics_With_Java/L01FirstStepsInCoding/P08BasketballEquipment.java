package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearTax = Integer.parseInt(scanner.nextLine());

        double trainers = yearTax - (yearTax * 0.40);
        double suit = trainers - (trainers * 0.20);
        double ball = suit / 4;
        double accessories = ball / 5;

        double fullPrice = yearTax + trainers + suit + ball + accessories;

        System.out.println(fullPrice);
    }
}
