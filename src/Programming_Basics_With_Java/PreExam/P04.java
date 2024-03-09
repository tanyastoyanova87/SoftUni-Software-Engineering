package Programming_Basics_With_Java.PreExam;

import java.util.Scanner;

public class P04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double litres = 0;
        double degreesAverage = 0;
        double countLitres = 0;

        for (int i = 1; i <= days ; i++) {
            double rakiaLitres = Double.parseDouble(scanner.nextLine());
            double degreeLiquid = Double.parseDouble(scanner.nextLine());

            litres += rakiaLitres;
            countLitres = countLitres + rakiaLitres * degreeLiquid;
            degreesAverage = countLitres / litres;
        }

        System.out.printf("Liter: %.2f%n", litres);
        System.out.printf("Degrees: %.2f%n", degreesAverage);

        if (degreesAverage < 38){
            System.out.println("Not good, you should baking!");
        }else if (degreesAverage >= 38 && degreesAverage <= 42){
            System.out.println("Super!");
        }else {
            System.out.println("Dilution with distilled water!");
        }
    }
}
