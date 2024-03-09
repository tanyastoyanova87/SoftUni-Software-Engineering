package Programming_Fundamentals_With_Java.MidExams;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodKg = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayKg = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverKg = Double.parseDouble(scanner.nextLine()) * 1000;
        double weightPig = Double.parseDouble(scanner.nextLine()) * 1000;

        for (int i = 1; i <= 30 ; i++) {
            foodKg -= 300;


            if (i % 2 == 0) {
                double hay = 0.05 * foodKg;
                hayKg -= hay;
            }

            if (i % 3 == 0) {
                coverKg -= weightPig / 3;
            }

            if (foodKg <= 0 ||hayKg <= 0 || coverKg <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }
        System.out.printf("Everything is fine! Puppy is happy!" +
                 " " + "Food: %.2f, Hay: %.2f, Cover: %.2f.%n"
                , foodKg / 1000, hayKg / 1000, coverKg / 1000);
    }
}
