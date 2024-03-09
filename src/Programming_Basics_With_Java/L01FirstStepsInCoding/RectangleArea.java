package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

/*
* 1. Създай скенер за четене от конзолата
* 2. Прочети от конзолата 2 цели числа и ги запази в променливи
* 3. Създай променлива която да изчисли лицето на правоъгълника
* 4. Принтирай резултата
* */


public class RectangleArea {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int area = a * b;

        System.out.println(area);
    }
}
