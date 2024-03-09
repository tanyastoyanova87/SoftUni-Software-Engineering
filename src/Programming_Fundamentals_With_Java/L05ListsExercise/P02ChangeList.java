package Programming_Fundamentals_With_Java.L05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.contains("Delete")) {
                int numberToDelete = Integer.parseInt(command.split(" ")[1]);
                numbers.removeAll(List.of(numberToDelete));

            } else if (command.contains("Insert")) {
                int elementToInsert = Integer.parseInt(command.split(" ")[1]);
                int indexToInsert = Integer.parseInt(command.split(" ")[2]);
                numbers.add(indexToInsert, elementToInsert);
            }
                command = scanner.nextLine();
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
