package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sideA = Integer.parseInt(scanner.nextLine());
        int sideB = Integer.parseInt(scanner.nextLine());

        System.out.println(printArea(sideA,sideB));

    }

    public static int printArea(int sideA, int sideB){
        return sideA * sideB;
    }
}
