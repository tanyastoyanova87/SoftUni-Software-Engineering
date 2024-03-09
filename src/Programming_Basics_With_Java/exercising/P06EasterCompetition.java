package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadCount = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        String winnerName = "";
        for (int i = 1; i <= easterBreadCount ; i++) {

            String name = scanner.nextLine();

            String input = scanner.nextLine();
            int rating = 0;
            while (!input.equals("Stop")){
                int rate = Integer.parseInt(input);
                rating += rate;


                input = scanner.nextLine();
            }
              System.out.printf("%s has %d points.%n", name, rating);
                if (rating > maxNum){
                    maxNum = rating;
                    winnerName = name;
                System.out.printf("%s is the new number 1!%n", name);
                }
        }
        System.out.printf("%s won competition with %d points!%n", winnerName, maxNum);
    }
}
