package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P07HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heightOfTheHouse = Double.parseDouble(scanner.nextLine());
        double lengthOfTheSideWall = Double.parseDouble(scanner.nextLine());
        double heightOfTheTriangularWallOfTheRoof = Double.parseDouble(scanner.nextLine());

        double sideWallArea = heightOfTheHouse * lengthOfTheSideWall;
        double windowArea = 1.5 * 1.5;
        double areas = (2 * sideWallArea) - 2 * windowArea;
        double backWall = heightOfTheHouse * heightOfTheHouse;
        double backAndFrontWall = (2 * backWall) - 2.4;
        double totalArea = areas + backAndFrontWall;
        double greenPaint = totalArea / 3.4;

        double twoRectanglesOnTheRoof = 2 * (heightOfTheHouse * lengthOfTheSideWall);
        double twoTriangles = 2 * (heightOfTheHouse * heightOfTheTriangularWallOfTheRoof / 2);
        double totalAreaRoof = twoRectanglesOnTheRoof + twoTriangles;
        double redPaint = totalAreaRoof / 4.3;

        System.out.printf("%.2f", greenPaint);
        System.out.println();
        System.out.printf("%.2f", redPaint);

    }
}
