package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cm = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = cm * width * height;
        double litres = volume / 1000;
        double neededLitres = litres * (1 - (percent / 100.0));

        System.out.println(neededLitres);
    }
}
