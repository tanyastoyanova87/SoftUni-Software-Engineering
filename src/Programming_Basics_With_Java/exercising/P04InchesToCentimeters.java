package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        double inchToCm = num * 2.54;
        System.out.println(inchToCm);
    }
}
