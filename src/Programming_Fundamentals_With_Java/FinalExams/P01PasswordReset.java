package Programming_Fundamentals_With_Java.FinalExams;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder passBuilder = new StringBuilder(input);

        String commands = scanner.nextLine();
        while (!commands.equals("Done")) {
            String[] commandsSeparated = commands.split(" ");
            String command = commandsSeparated[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder oddChars = new StringBuilder();
                    for (int i = 1; i < passBuilder.length(); i += 2) {
                        char symbol = passBuilder.charAt(i);
                        oddChars.append(symbol);
                    }
                    passBuilder = oddChars;
                    System.out.println(passBuilder);
                    break;

                case "Cut":
                    int index = Integer.parseInt(commandsSeparated[1]);
                    int length = Integer.parseInt(commandsSeparated[2]);

                    if (index >= 0 && index + length <= passBuilder.length()) {
                        passBuilder.delete(index, index + length);
                        System.out.println(passBuilder);
                    }
                    break;

                case "Substitute":
                    String substring = commandsSeparated[1];
                    String substitute = commandsSeparated[2];

                    if (passBuilder.indexOf(substring) != -1) {
                        passBuilder = new StringBuilder(passBuilder.toString().replace(substring, substitute));
                        System.out.println(passBuilder);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commands = scanner.nextLine();
        }

        System.out.printf("Your password is: %s%n", passBuilder);
    }
}
