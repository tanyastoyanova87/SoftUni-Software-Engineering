package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(input, repeatCount));
    }

    public static String repeatString(String input, int repeatCount){
        String[] result = new String[repeatCount];

        for (int i = 0; i < repeatCount; i++) {
            result[i] = input;
        }
        return String.join("", result);
    }
}
