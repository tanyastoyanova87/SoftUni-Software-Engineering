package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P02RadiansToDegrees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radians = Double.parseDouble(scanner.nextLine());
        double degree = radians * 180/Math.PI;

        System.out.println(degree);
    }
}
