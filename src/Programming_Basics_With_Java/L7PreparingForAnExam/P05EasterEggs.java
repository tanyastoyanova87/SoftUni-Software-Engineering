package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P05EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paintedEggsCount = Integer.parseInt(scanner.nextLine());

        int red = 0;
        int orange = 0;
        int blue = 0;
        int green = 0;
        int maxNum = Integer.MIN_VALUE;
        String colorOfMaxEggs = "";
        for (int i = 1; i <= paintedEggsCount; i++) {
            String color = scanner.nextLine();

            switch (color) {
                case "red":
                    red++;
                    break;
                case "orange":
                    orange++;
                    break;
                case "blue":
                    blue++;
                    break;
                case "green":
                    green++;
                    break;
            }
            if (red > orange && red > blue && red > green) {
                maxNum = red;
                colorOfMaxEggs = "red";
            } else if (orange > red && orange > blue && orange > green) {
                maxNum = orange;
                colorOfMaxEggs = "orange";
            } else if (blue > red && blue > orange && blue > green) {
                maxNum = blue;
                colorOfMaxEggs = "blue";
            } else if (green > red && green > orange && green > blue) {
                maxNum = green;
                colorOfMaxEggs = "green";
            }
        }
            System.out.printf("Red eggs: %d%n", red);
            System.out.printf("Orange eggs: %d%n", orange);
            System.out.printf("Blue eggs: %d%n", blue);
            System.out.printf("Green eggs: %d%n", green);
            System.out.printf("Max eggs: %d -> %s%n", maxNum, colorOfMaxEggs);
    }
}