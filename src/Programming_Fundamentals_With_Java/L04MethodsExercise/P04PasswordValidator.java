package Programming_Fundamentals_With_Java.L04MethodsExercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValidLength = checkIfPassIsBetween6To10Characters(password);
        if (!isValidLength) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean isValidSymbols = checkIfPassConsistsOnlyLettersAndDigits(password);
        if (!isValidSymbols) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean isAtLeast2Digits = checkIfPassIsAtLeast2Digits(password);
        if (!isAtLeast2Digits) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength && isValidSymbols && isAtLeast2Digits) {
            System.out.println("Password is valid");
        }
    }

    public static boolean checkIfPassIsBetween6To10Characters(String password) {

        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean checkIfPassConsistsOnlyLettersAndDigits(String password) {

        for (char symbols : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbols)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfPassIsAtLeast2Digits(String password) {
        int digits = 0;

        for (char symbols : password.toCharArray()) {
            if (Character.isDigit(symbols)) {
                digits++;
            }
        }
        return digits >= 2;
    }
}
