package Programming_Fundamentals_With_Java.FinalExams;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(message);

        String commands = scanner.nextLine();
        while (!commands.equals("Reveal")) {

            String[] commandParts = commands.split(":\\|:");
            String command = commandParts[0];

            if (command.equals("InsertSpace")) {
                int index = Integer.parseInt(commandParts[1]);
                messageBuilder.insert(index, " ");

                System.out.println(messageBuilder);

            } else if (command.equals("Reverse")) {
                String substring = commandParts[1];

                if (!messageBuilder.toString().contains(substring)) {
                    System.out.println("error");
                } else {
                    messageBuilder.delete(messageBuilder.indexOf(substring), messageBuilder.length() + 1);
                    String reversedSubstring = new StringBuilder(substring).reverse().toString();
                    messageBuilder.append(reversedSubstring);

                    System.out.println(messageBuilder);
                }

            } else if (command.equals("ChangeAll")) {
                String substring = commandParts[1];
                String replacement = commandParts[2];

                messageBuilder = new StringBuilder(messageBuilder.toString().replaceAll(substring, replacement));
                System.out.println(messageBuilder);
            }

            commands = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", messageBuilder);
    }
}
