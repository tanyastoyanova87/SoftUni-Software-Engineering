package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> parkingData = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String command = commands[0];
            String name = commands[1];

            if (command.equals("register")) {
                String licensePlateNumber = commands[2];
                if (parkingData.containsKey(name)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                } else {
                    parkingData.put(name, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", name, licensePlateNumber);
                }
            } else if (command.equals("unregister")) {
                if (!parkingData.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    parkingData.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }
        }

        parkingData.entrySet().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
