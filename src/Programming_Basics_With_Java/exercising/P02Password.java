package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String login = scanner.nextLine();

        while (!password.equals(login)){
            login = scanner.nextLine();
        }
        System.out.printf("Welcome %s!%n", username);
    }
}
