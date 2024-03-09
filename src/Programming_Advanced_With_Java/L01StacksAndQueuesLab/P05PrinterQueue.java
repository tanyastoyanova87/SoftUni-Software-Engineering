package Programming_Advanced_With_Java.L01StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"print".equals(command)) {

            if (!"cancel".equals(command)) {
                queue.offer(command);
            } else {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", queue.poll());
                }
            }
            command = scanner.nextLine();
        }

        for (String file : queue) {
            System.out.println(file);
        }

        System.out.println();
    }
}
