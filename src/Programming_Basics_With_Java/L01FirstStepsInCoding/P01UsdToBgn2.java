package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P01UsdToBgn2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usd = Double.parseDouble(scanner.nextLine());
        double convertor = usd * 1.79549;

        System.out.println(convertor);
    }
}
