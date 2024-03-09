package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class Perimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());

        double perimeter = a + b + c;

        System.out.println(perimeter);
    }
}
