package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figures = scanner.nextLine();

        if (figures.equals("square")){
            double length = Double.parseDouble(scanner.nextLine());
            double area = length * length;
            System.out.printf("%.3f", area);

        } else if (figures.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            double area = a * b;
            System.out.printf("%.3f", area);


        } else if (figures.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            double area = Math.PI * radius * radius;
            System.out.printf("%.3f", area);


        } else if (figures.equals("triangle")) {
            double length = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            double area = (length * h) / 2;
            System.out.printf("%.3f", area);
        }
    }
}
