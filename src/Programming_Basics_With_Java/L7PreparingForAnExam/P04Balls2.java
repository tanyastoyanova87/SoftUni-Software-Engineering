package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P04Balls2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ballsCount = Integer.parseInt(scanner.nextLine());

        double points = 0;
        int redBalls = 0;
        int orangeBalls = 0;
        int yellowBalls = 0;
        int whiteBalls = 0;
        int otherColors = 0;
        int dividedCount = 0;
        for (int i = 1; i <= ballsCount; i++) {

            String colorsCount = scanner.nextLine();

            if (colorsCount.equals("red")){
                points += 5;
                redBalls++;
                
            } else if (colorsCount.equals("orange")) {
                points += 10;
                orangeBalls++;
                
            } else if (colorsCount.equals("yellow")) {
                points += 15;
                yellowBalls++;
                
            } else if (colorsCount.equals("white")) {
                points += 20;
                whiteBalls++;
                
            } else if (colorsCount.equals("black")) {
                points = Math.floor(points / 2);
                dividedCount++;

            }else {
                otherColors++;
            }
        }
        System.out.printf("Total points: %.0f%n", points);
        System.out.printf("Red balls: %d%n", redBalls);
        System.out.printf("Orange balls: %d%n", orangeBalls);
        System.out.printf("Yellow balls: %d%n", yellowBalls);
        System.out.printf("White balls: %d%n", whiteBalls);
        System.out.printf("Other colors picked: %d%n", otherColors);
        System.out.printf("Divides from black balls: %d%n", dividedCount);
    }
}
