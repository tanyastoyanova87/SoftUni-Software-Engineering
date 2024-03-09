package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P04Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ballsCount = Integer.parseInt(scanner.nextLine());

        int points = 0;
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int others = 0;
        for (int i = 1; i <= ballsCount; i++) {
            String colors = scanner.nextLine();

            if (colors.equals("red")) {
                points += 5;
                red++;
            } else if (colors.equals("orange")) {
                points += 10;
                orange++;
            } else if (colors.equals("yellow")) {
                points += 15;
                yellow++;
            } else if (colors.equals("white")) {
                points += 20;
                white++;
            } else if (colors.equals("black")) {
                points = (points / 2);
                black++;
            }else {
                points += 0;
                others++;
            }
        }
        System.out.printf("Total points: %d%n", points);
        System.out.printf("Red balls: %d%n", red);
        System.out.printf("Orange balls: %d%n", orange);
        System.out.printf("Yellow balls: %d%n", yellow);
        System.out.printf("White balls: %d%n", white);
        System.out.printf("Other colors picked: %d%n", others);
        System.out.printf("Divides from black balls: %d%n", black);
    }
}
