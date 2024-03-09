package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> registeredUsers = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] commandSplit = command.split(" : ");
            String courseName = commandSplit[0];
            String studentName = commandSplit[1];

            if (registeredUsers.containsKey(courseName)) {
                List<String> currentName = registeredUsers.get(courseName);
                currentName.add(studentName);
            } else {
                registeredUsers.put(courseName, new ArrayList<>());
                registeredUsers.get(courseName).add(studentName);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> kvp : registeredUsers.entrySet()) {
            System.out.printf("%s: %d%n", kvp.getKey(), kvp.getValue().size());
            for (int i = 0; i < kvp.getValue().size(); i++) {
                System.out.printf("-- %s%n", kvp.getValue().get(i));
            }
        }
    }
}
