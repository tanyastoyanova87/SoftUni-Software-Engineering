package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int ratings = 0;
        double sumAllRatings = 0;
        while (!command.equals("Finish")){

            double sumRatings = 0;
            for (int i = 1; i <= jury ; i++) {
                double rate = Double.parseDouble(scanner.nextLine());
                sumRatings += rate;

                sumAllRatings += rate;
                ratings++;

            }
                double averageRate = sumRatings / jury;
                System.out.printf("%s - %.2f.%n", command, averageRate);

            command = scanner.nextLine();
        }
        double averageAllRatings = sumAllRatings / ratings;
        System.out.printf("Student's final assessment is %.2f.%n", averageAllRatings);
    }
}
