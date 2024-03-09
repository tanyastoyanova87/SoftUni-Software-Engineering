package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCm = Integer.parseInt(scanner.nextLine());
        int widthCm = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = lengthCm * widthCm * height;
        double volumeLitres = volume / 1000;
        double neededLitres = volumeLitres * (1 - percent / 100);

        System.out.println(neededLitres);



    }
}
