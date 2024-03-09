package Programming_Fundamentals_With_Java.finalExam;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder textBuilder = new StringBuilder(text);

        String commands = scanner.nextLine();
        while (!commands.equals("Finish")) {

            String[] commandsSeparatedByParts = commands.split(" ");
            String command = commandsSeparatedByParts[0];

            if (command.equals("Replace")) {
                String currentChar = commandsSeparatedByParts[1];
                String newChar = commandsSeparatedByParts[2];

                if (text.contains(currentChar)) {
                    text = text.replaceAll(currentChar, newChar);
                }

                textBuilder = new StringBuilder(text);
                System.out.println(textBuilder);

            } else if (command.equals("Cut")) {
                int startIndex = Integer.parseInt(commandsSeparatedByParts[1]);
                int endIndex = Integer.parseInt(commandsSeparatedByParts[2]);

                if (startIndex >= 0 && startIndex < textBuilder.length() && endIndex >= 0 && endIndex < textBuilder.length()) {
                    textBuilder.delete(startIndex, endIndex + 1);
                    System.out.println(textBuilder);
                } else {
                    System.out.println("Invalid indices!");
                }


            } else if (command.equals("Make")) {
                String upperOrLower = commandsSeparatedByParts[1];

                text = String.valueOf(textBuilder);

                if (upperOrLower.equals("Upper")) {
                    text = text.replaceAll(text, text.toUpperCase());
                    System.out.println(text);
                } else if (upperOrLower.equals("Lower")) {
                    text = text.replaceAll(text, text.toLowerCase());
                    System.out.println(text);
                }
                textBuilder = new StringBuilder(text);

            } else if (command.equals("Check")) {
                String containsText = commandsSeparatedByParts[1];

                if (text.contains(containsText)) {
                    System.out.printf("Message contains %s%n", containsText);
                } else {
                    System.out.printf("Message doesn't contain %s%n", containsText);
                }

            } else if (command.equals("Sum")) {
                int startIndex = Integer.parseInt(commandsSeparatedByParts[1]);
                int endIndex = Integer.parseInt(commandsSeparatedByParts[2]);

                int sum = 0;
                if (startIndex < 0 || endIndex < 0 || startIndex > textBuilder.length() || endIndex > textBuilder.length()) {
                    System.out.println("Invalid indices!");
                } else {
                    String substring = textBuilder.substring(startIndex, endIndex + 1);
                    for (int i = 0; i < substring.length(); i++) {
                        char symbol = substring.charAt(i);
                        sum += symbol;
                    }
                    System.out.println(sum);
                }


            }

            commands = scanner.nextLine();
        }
    }

}
