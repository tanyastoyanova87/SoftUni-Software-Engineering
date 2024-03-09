package Programming_Fundamentals_With_Java.L09RegularExpressionsExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+");

        for (int i = 1; i <= count; i++) {
            String password = scanner.nextLine();

            Matcher matcher = pattern.matcher(password);

            StringBuilder sb = new StringBuilder();
            if (matcher.find()) {
                for (char symbol : password.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        sb.append(symbol);
                    }
                }
                if (sb.length() == 0) {
                    System.out.println("Group: default");
                } else {
                    System.out.println("Group: " + sb);
                }

            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
