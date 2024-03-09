package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inch = Double.parseDouble(scanner.nextLine());
        double cm = inch * 2.54;

        System.out.println(cm);
    }
}
