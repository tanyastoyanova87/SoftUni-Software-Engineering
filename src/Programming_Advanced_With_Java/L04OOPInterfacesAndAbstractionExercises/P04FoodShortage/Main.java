package Programming_Advanced_With_Java.L04OOPInterfacesAndAbstractionExercises.P04FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> personMap = new HashMap<>();

        while (people-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                personMap.put(tokens[0], citizen);
            } else {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                personMap.put(tokens[0], rebel);
            }
        }

        String person = scanner.nextLine();
        while (!"End".equals(person)) {

            for (Map.Entry<String, Buyer> stringBuyerEntry : personMap.entrySet()) {
                if (stringBuyerEntry.getKey().equals(person)) {
                    stringBuyerEntry.getValue().buyFood();
                }
            }

            person = scanner.nextLine();
        }

        int sum = getSum(personMap);

        System.out.println(sum);
    }

    private static int getSum(Map<String, Buyer> personMap) {
        int sum = 0;
        for (Map.Entry<String, Buyer> stringBuyerEntry : personMap.entrySet()) {
            sum += stringBuyerEntry.getValue().getFood();
        }
        return sum;
    }
}
