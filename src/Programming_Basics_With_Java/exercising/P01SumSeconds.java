package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int allMinutes = num1 + num2 + num3;
        int minutes = allMinutes / 60;
        int seconds = allMinutes % 60;

        System.out.printf("%d:%02d%n", minutes, seconds);
    }
}
