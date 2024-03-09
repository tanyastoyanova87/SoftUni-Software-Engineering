package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P06EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadCount = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        String name1 = "";
        for (int i = 1; i <= easterBreadCount ; i++) {
            String name = scanner.nextLine();
            String command = scanner.nextLine();


            int ratingCount = 0;
            while (!command.equals("Stop")){
                int rating = Integer.parseInt(command);
                ratingCount += rating;


                command = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", name, ratingCount);
                if (ratingCount > maxNum){
                    maxNum = ratingCount;
            System.out.printf("%s is the new number 1!%n", name);
            name1 = name;
                }
        }
            System.out.printf("%s won competition with %d points!%n", name1, maxNum );
    }
}
