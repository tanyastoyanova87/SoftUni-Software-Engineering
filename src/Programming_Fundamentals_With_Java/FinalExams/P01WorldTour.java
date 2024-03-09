package Programming_Fundamentals_With_Java.FinalExams;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String commands = scanner.nextLine();
        while (!commands.equals("Travel")) {
            String command = commands.split(":")[0];
            if (command.equals("Add Stop")) {
                int index = Integer.parseInt(commands.split(":")[1]);
                String textToAdd = commands.split(":")[2];
                if (indexIsValid(index, stops)) {
                    String left = stops.substring(0, index);
                    String right = stops.substring(index);
                    stops = left + textToAdd + right;
                }
                System.out.println(stops);
            } else if (command.equals("Remove Stop")) {
                int startIndex = Integer.parseInt(commands.split(":")[1]);
                int endIndex = Integer.parseInt(commands.split(":")[2]);
                if (indexIsValid(startIndex, stops) && indexIsValid(endIndex, stops)) {
                    String left = stops.substring(0, startIndex);
                    String right = stops.substring(endIndex + 1);
                    stops = left + right;
                }
                System.out.println(stops);
            } else if (command.equals("Switch")) {
                String oldString = commands.split(":")[1];
                String newString = commands.split(":")[2];
                if (stops.contains(oldString)) {
                    stops = stops.replace(oldString, newString);
                }
                System.out.println(stops);
            }
            commands = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }

    private static boolean indexIsValid(int index, String stops) {
        return index >= 0 && index < stops.length();
    }
}
