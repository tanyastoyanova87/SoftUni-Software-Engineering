package Programming_Fundamentals_With_Java.L05ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            }

            String[] commands = command.split(" ");

            if (commands[0].equals("Contains")) {
                int containsNum = Integer.parseInt(commands[1]);
                if (numbers.contains(containsNum)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }

            } else if (command.equals("Print even")) {
                for (int num : numbers) {
                    if (num % 2 == 0) {
                        System.out.printf("%d ", num);
                    }
                }
                System.out.println();
            } else if (command.equals("Print odd")) {
                for (int num : numbers) {
                    if (num % 2 != 0) {
                        System.out.printf("%d ", num);
                    }
                }
                System.out.println();

            } else if (command.equals("Get sum")) {
                int sum = 0;
                for (int num : numbers) {
                    sum += num;
                }
                System.out.println(sum);

            } else if (commands[0].contains("Filter")) {
                if (commands[1].equals("<")) {
                    for (int num : numbers) {
                        int number = Integer.parseInt(commands[2]);
                        if (num < number) {
                            System.out.print(num + " ");
                        }
                    }
                    System.out.println();
                } else if (commands[1].equals(">")) {
                    for (int num : numbers) {
                        int number = Integer.parseInt(commands[2]);
                        if (num > number) {
                            System.out.print(num + " ");
                        }
                    }
                    System.out.println();

                } else if (commands[1].equals("<=")) {
                    for (int num : numbers) {
                        int number = Integer.parseInt(commands[2]);
                        if (num <= number) {
                            System.out.print(num + " ");
                        }
                    }
                    System.out.println();

                } else if (commands[1].equals(">=")) {
                    for (int num : numbers) {
                        int number = Integer.parseInt(commands[2]);
                        if (num >= number) {
                            System.out.print(num + " ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
