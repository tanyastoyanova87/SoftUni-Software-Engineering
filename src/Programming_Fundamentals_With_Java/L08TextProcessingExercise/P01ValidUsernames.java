package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usernames = scanner.nextLine();
        String[] usernamesSplit = usernames.split(", ");

        for (String username : usernamesSplit) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    public static boolean isValid (String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }

        return true;
    }
}
