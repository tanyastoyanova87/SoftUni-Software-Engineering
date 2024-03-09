package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                resources.put(resource, resources.get(resource) + quantity);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> kvp : resources.entrySet()) {
            System.out.printf("%s -> %d%n", kvp.getKey(), kvp.getValue());
        }
    }
}
