package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P02Convertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radian = Double.parseDouble(scanner.nextLine());
        double degree = radian * 180 / Math.PI;

        System.out.println(degree);
    }
}
