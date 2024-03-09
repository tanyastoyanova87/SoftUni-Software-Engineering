package Programming_Fundamentals_With_Java.FinalExams;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(encryptedMessage);

        String commands = scanner.nextLine();
        while (!commands.equals("Decode")) {

            String command = commands.split("\\|")[0];

            if (command.equals("Move")) {
                int numberOfLetters = Integer.parseInt(commands.split("\\|")[1]);

                StringBuilder symbols = new StringBuilder();

                for (int i = 1; i <= numberOfLetters; i++) {
                    char symbol = messageBuilder.charAt(0);
                    symbols.append(symbol);
                    messageBuilder.deleteCharAt(0);
                }

                messageBuilder.append(symbols);


            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(commands.split("\\|")[1]);
                String value = commands.split("\\|")[2];

                messageBuilder.insert(index, value);


            } else if (command.equals("ChangeAll")) {
                String substring = commands.split("\\|")[1];
                String replacement = commands.split("\\|")[2];

                int index = messageBuilder.indexOf(substring);
                while (index != -1) {
                    messageBuilder.replace(index, index + substring.length(), replacement);
                    index = messageBuilder.indexOf(substring);
                }
            }

            commands = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s%n", messageBuilder);
    }
}
