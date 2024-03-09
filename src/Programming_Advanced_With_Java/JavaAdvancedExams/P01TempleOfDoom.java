package Programming_Advanced_With_Java.JavaAdvancedExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tools = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> substances = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> challenges = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        while (!tools.isEmpty() && !substances.isEmpty() && !challenges.isEmpty()) {

            int result = tools.get(0) * substances.get(substances.size() - 1);


            boolean isFound = false;
            int indexFound = 0;
            for (int challenge : challenges) {
                if (result == challenge) {
                    isFound = true;
                    indexFound = challenges.indexOf(challenge);
                    tools.remove(0);
                    substances.remove(substances.size() - 1);
                    challenges.remove(indexFound);
                    break;
                }
            }

            if (!isFound) {
                int newValue = tools.get(0) + 1;
                tools.remove(0);
                tools.add(newValue);
                int index = substances.size() - 1;
                substances.set(index, substances.get(substances.size() - 1) - 1);
                if (substances.get(substances.size() - 1) == 0) {
                    substances.remove(index);
                }
            }
        }

        if (!challenges.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!tools.isEmpty()) {
            System.out.print("Tools: ");
            List<String> toolList = new ArrayList<>();
            for (Integer tool : tools) {
                toolList.add(tool.toString());
            }
            System.out.println(String.join(", ", toolList));
        }

        if (!substances.isEmpty()) {
            System.out.print("Substances: ");
            List<String> substanceList = new ArrayList<>();
            for (Integer substance : substances) {
                substanceList.add(substance.toString());
            }
            System.out.println(String.join(", ", substanceList));
        }

        if (!challenges.isEmpty()) {
            System.out.print("Challenges: ");
            List<String> challengesList = new ArrayList<>();
            for (Integer challenge : challenges) {
                challengesList.add(challenge.toString());
            }
            System.out.println(String.join(", ", challengesList));
        }
    }
}
