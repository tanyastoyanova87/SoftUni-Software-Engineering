package Programming_Fundamentals_With_Java.FinalExams;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        StringBuilder newActivationKey = new StringBuilder(activationKey);

        String[] instructions = scanner.nextLine().split(">>>");
        while (!instructions[0].equals("Generate")) {

            String command = instructions[0];

            if (command.equals("Contains")) {
                String substring = instructions[1];
                if (newActivationKey.toString().contains(substring)) {
                    System.out.printf("%s contains %s%n", newActivationKey, substring);
                } else {
                    System.out.println("Substring not found!");
                }

            } else if (command.equals("Flip")) {
                String upperOrLower = instructions[1];
                int startIndex = Integer.parseInt(instructions[2]);
                int endIndex = Integer.parseInt(instructions[3]);
                String flippedString = "";

                if (upperOrLower.equals("Upper")) {
                    flippedString = newActivationKey.substring(startIndex, endIndex).toUpperCase();
                } else if (upperOrLower.equals("Lower")) {
                    flippedString = newActivationKey.substring(startIndex, endIndex).toLowerCase();
                }

                newActivationKey.replace(startIndex, endIndex, flippedString);
                System.out.println(newActivationKey);

            } else if (command.equals("Slice")) {
                int startIndex = Integer.parseInt(instructions[1]);
                int endIndex = Integer.parseInt(instructions[2]);

                newActivationKey.delete(startIndex, endIndex);
                System.out.println(newActivationKey);
            }
            instructions = scanner.nextLine().split(">>>");
        }
        
        System.out.printf("Your activation key is: %s%n", newActivationKey);
    }
}
