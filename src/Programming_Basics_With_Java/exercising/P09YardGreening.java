package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double landscaped = Double.parseDouble(scanner.nextLine());

        double price = landscaped * 7.61;
        double discount = price * 0.18;
        double finalPrice = price - discount;

        System.out.printf("The final price is: %.2f lv.%n", finalPrice);
        System.out.printf("The discount is: %.2f lv.%n", discount);
    }
}
