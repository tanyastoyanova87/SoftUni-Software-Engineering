package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> company = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandSplit = command.split(" -> ");
            String companyName = commandSplit[0];
            String id = commandSplit[1];

            List<String> currentEmployees = company.get(companyName);
            boolean containsId = currentEmployees != null && currentEmployees.contains(id);

            if (!containsId) {
                company.putIfAbsent(companyName, new ArrayList<>());
                company.get(companyName).add(id);
            }

            command = scanner.nextLine();
        }

        company.entrySet().forEach(entry -> {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().forEach(kvp -> System.out.printf("-- %s%n", kvp));
        });
    }
}
