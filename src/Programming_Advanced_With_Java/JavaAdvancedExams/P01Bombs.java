package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bombEffectsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombEffectsQueue::offer);

        Deque<Integer> bombCasingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(bombCasingStack::push);

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        boolean bombPouch = false;
        while (!bombEffectsQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                bombPouch = true;
                break;
            }
            int currentBombEffect = bombEffectsQueue.peek();
            int currentBombCasing = bombCasingStack.peek();
            int sum = currentBombEffect + currentBombCasing;
            if (sum == 40) {
                daturaBombs++;
                bombEffectsQueue.poll();
                bombCasingStack.pop();
            } else if (sum == 60) {
                cherryBombs++;
                bombEffectsQueue.poll();
                bombCasingStack.pop();
            } else if (sum == 120) {
                smokeDecoyBombs++;
                bombEffectsQueue.poll();
                bombCasingStack.pop();
            } else {
                currentBombCasing -= 5;
                bombCasingStack.pop();
                bombCasingStack.push(currentBombCasing);
            }
        }
        if (bombPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            List<String> bombEffectsLeft = new ArrayList<>();
            bombEffectsQueue.forEach(e -> bombEffectsLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", bombEffectsLeft));
        }

        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            List<String> bombCasingsLeft = new ArrayList<>();
            bombCasingStack.forEach(e -> bombCasingsLeft.add(String.valueOf(e)));
            System.out.println(String.join(", ", bombCasingsLeft));
        }

        System.out.printf("Cherry Bombs: %d%n", cherryBombs);
        System.out.printf("Datura Bombs: %d%n", daturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeDecoyBombs);
    }
}
