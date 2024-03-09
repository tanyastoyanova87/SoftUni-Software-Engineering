package Programming_Fundamentals_With_Java.MidExams;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceWithoutTaxes = 0;
        boolean isSpecial = false;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("special") || command.equals("regular")) {
                if (command.equals("special")) {
                    isSpecial = true;
                }
                break;
            }

            double currentNumber = Double.parseDouble(command);
            if (currentNumber < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += currentNumber;
            }
        }
        double taxes = priceWithoutTaxes * 0.20;
        double priceWithTax = priceWithoutTaxes + taxes;
        if (priceWithTax == 0) {
            System.out.println("Invalid order!");
        } else {
            if (isSpecial) {
                priceWithTax = priceWithTax - priceWithTax * 0.10;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", priceWithTax);

        }
    }
}
