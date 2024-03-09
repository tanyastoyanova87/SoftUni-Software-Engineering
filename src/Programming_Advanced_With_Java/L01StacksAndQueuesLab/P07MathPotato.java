package Programming_Advanced_With_Java.L01StacksAndQueuesLab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String kid : children) {
            queue.offer(kid);
        }

        int circle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());

            }
            if (isPrime(circle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            circle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int circle) {
        if (circle <= 1) {
            return false;
        }
        for (int i = 2; i * i <= circle; i++) {
            if (circle % i == 0) {
                return false;
            }
        }

        return true;
    }
}
