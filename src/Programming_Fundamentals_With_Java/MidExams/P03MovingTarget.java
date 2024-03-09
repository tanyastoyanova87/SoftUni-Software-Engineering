package Programming_Fundamentals_With_Java.MidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] commandSplit = command.split(" ");
            int index = Integer.parseInt(commandSplit[1]);
            int power = Integer.parseInt(commandSplit[2]);

            if (command.contains("Shoot")) {
                int shoot = 0;
                if (isInside(targets, index)) {
                    shoot = targets.get(index);
                    shoot -= power;
                    targets.set(index, shoot);
                    if (shoot <= 0) {
                        targets.remove(targets.get(index));
                    }
                }

            } else if (command.contains("Add")) {
                if (isInside(targets, index)) {
                    targets.add(index, power);
                } else {
                    System.out.println("Invalid placement!");
                }

            } else if (command.contains("Strike")) {
                int leftIndex = index - power;
                int rightIndex = index + power;
                if (isInside(targets, leftIndex) && isInside(targets, rightIndex)) {
                    int count = power * 2 + 1;
                    for (int i = 0; i < count; i++) {
                        targets.remove(leftIndex);
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            if (i != targets.size() - 1) {
                System.out.print(targets.get(i) + "|");
            } else {
                System.out.print(targets.get(i));
            }
        }
        System.out.println();
    }

    public static boolean isInside(List<Integer> list, int index) {
        return index >= 0 && index < list.size();
    }
}
