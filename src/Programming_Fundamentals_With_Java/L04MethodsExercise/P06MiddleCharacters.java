package Programming_Fundamentals_With_Java.L04MethodsExercise;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacter(text);
    }

    public static void printMiddleCharacter(String text) {

        int length = text.length();

        if (length % 2 != 0) {
            int middleSymbol = length / 2;
            System.out.println(text.charAt(middleSymbol));
        } else {
            int firstMiddleSymbol = length / 2 - 1;
            int secondMiddleSymbol = firstMiddleSymbol + 1;
            System.out.print(text.charAt(firstMiddleSymbol));
            System.out.println(text.charAt(secondMiddleSymbol));
        }
    }
}
