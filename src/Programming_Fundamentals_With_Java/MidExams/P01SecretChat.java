package Programming_Fundamentals_With_Java.MidExams;

import java.util.Scanner;


public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        for (int day = 1; day <= days; day++) {
            sum += dailyPlunder;
            if (day % 3 == 0) {
                sum += dailyPlunder * 0.5;
            }

            if (day % 5 == 0) {
                sum -= sum * 0.30;
            }
        }

        if (sum >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", sum);
        } else {
            double percentage = (sum / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.%n", percentage);
        }
    }
}
