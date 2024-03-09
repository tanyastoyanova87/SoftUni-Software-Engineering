package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double veg = Double.parseDouble(scanner.nextLine());
        double fruit = Double.parseDouble(scanner.nextLine());
        int  vegKg = Integer.parseInt(scanner.nextLine());
        int fruitKg = Integer.parseInt(scanner.nextLine());

        double euro = 1.94;
        double vegPr = veg * vegKg;
        double fruitPr = fruit * fruitKg;
        double all = (vegPr + fruitPr) / euro;

        System.out.printf("%.2f", all);
    }
}
