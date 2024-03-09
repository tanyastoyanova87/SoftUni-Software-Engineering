package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String variables = scanner.nextLine();

        if (variables.equals("int")) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());

            System.out.println(getMax(num1, num2));

        }else if (variables.equals("char")) {
            char letter1 = scanner.nextLine().charAt(0);
            char letter2 = scanner.nextLine().charAt(0);

            System.out.println(getMax(letter1, letter2));

        }else if (variables.equals("string")) {
            String text = scanner.nextLine();
            String text2 = scanner.nextLine();

            System.out.println(getMax(text, text2));
        }
    }

    public static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }

        return num2;
    }

    public static char getMax(char letter1, char letter2) {
        if (letter1 > letter2){
            return letter1;
        }
        return letter2;
    }

    public static String getMax(String text, String text2) {
        if (text.compareTo(text2) >= 0) {
            return text;
        }
        return text2;
    }
}
