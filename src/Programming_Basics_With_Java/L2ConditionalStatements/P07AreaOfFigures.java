package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figure = scanner.nextLine();

        double area = 0;
        if (figure.equals("square")) {
            double side = Double.parseDouble(scanner.nextLine());

            area = side * side;

        } else if (figure.equals("rectangle")) {
            double side1 = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());

            area = side1 * side2;

        } else if (figure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());

            area = Math.PI * radius * radius;

        } else if (figure.equals("triangle")) {
            double side = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());

            area = (side * h) / 2;
        }

        System.out.printf("%.3f", area);
    }
}
