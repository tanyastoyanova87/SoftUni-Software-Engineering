package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] commandSplit = command.split(" ");
            if (command.contains("swap")) {
                int firstElement = Integer.parseInt(commandSplit[1]);
                int secondElement = Integer.parseInt(commandSplit[2]);

                int temp = numbers[firstElement];
                numbers[firstElement] = numbers[secondElement];
                numbers[secondElement] = temp;

            } else if (command.contains("multiply")) {
                int firstElement = Integer.parseInt(commandSplit[1]);
                int secondElement = Integer.parseInt(commandSplit[2]);

                int firstElementNum = numbers[firstElement];
                int secondElementNum = numbers[secondElement];

                int result = firstElementNum * secondElementNum;

                numbers[firstElement] = result;

            } else if (command.contains("decrease")) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]--;

                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int current = numbers[i];
            System.out.print(current+ ", ");
        }
        System.out.print(numbers[numbers.length - 1]);
    }
}
