package Programming_Advanced_With_Java.L01OOPWorkingWithAbstractionLab.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] coordinate = Arrays.stream(scanner.nextLine()
                    .split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();


            Point point = new Point(coordinate[0], coordinate[1]);
            System.out.println(rectangle.contains(point));

        }
    }
}