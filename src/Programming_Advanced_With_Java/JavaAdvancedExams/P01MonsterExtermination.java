package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;

public class P01MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> armorOfTheMonstersQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).forEach(armorOfTheMonstersQueue::offer);

        Deque<Integer> soldiersStrikingImpactStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).forEach(soldiersStrikingImpactStack::push);

        int killedMonsters = 0;
        while (!armorOfTheMonstersQueue.isEmpty() && !soldiersStrikingImpactStack.isEmpty()) {

            int currentArmor = armorOfTheMonstersQueue.peek();
            int currentStrikingImpact = soldiersStrikingImpactStack.peek();

            if (currentStrikingImpact >= currentArmor) {
                killedMonsters++;
                currentStrikingImpact -= currentArmor;

                if (currentStrikingImpact == 0) {
                    soldiersStrikingImpactStack.pop();
                    armorOfTheMonstersQueue.poll();
                } else {
                    armorOfTheMonstersQueue.poll();
                    if (soldiersStrikingImpactStack.size() == 1) {
                        soldiersStrikingImpactStack.pop();
                        soldiersStrikingImpactStack.push(currentStrikingImpact);
                    } else {
                        soldiersStrikingImpactStack.pop();
                        int temp = currentStrikingImpact;
                        int next = soldiersStrikingImpactStack.pop();
                        soldiersStrikingImpactStack.push(next + temp);
                    }
                }
            } else {
                currentArmor -= currentStrikingImpact;
                soldiersStrikingImpactStack.pop();
                armorOfTheMonstersQueue.poll();
                armorOfTheMonstersQueue.offer(currentArmor);

            }
        }

        if (armorOfTheMonstersQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldiersStrikingImpactStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d%n", killedMonsters);
    }
}
