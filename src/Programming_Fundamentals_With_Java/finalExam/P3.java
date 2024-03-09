package Programming_Fundamentals_With_Java.finalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> animalsFood = new LinkedHashMap<>();
        Map<String, String> animalsArea = new LinkedHashMap<>();
        Map<String, Integer> animalsAreaNumber = new LinkedHashMap<>();

        String commands = scanner.nextLine();
        while (!commands.equals("EndDay")) {

            String[] commandsSeparatedByParts = commands.split("[: -]");
            String command = commandsSeparatedByParts[0];
            String animalName = commandsSeparatedByParts[2];

            if (command.equals("Add")) {
                int neededFoodQuantity = Integer.parseInt(commandsSeparatedByParts[3]);
                String area = commandsSeparatedByParts[4];

                if (!animalsFood.containsKey(animalName)) {
                    animalsFood.put(animalName, neededFoodQuantity);
                } else {
                    animalsFood.put(animalName, animalsFood.get(animalName) + neededFoodQuantity);
                }

                animalsArea.putIfAbsent(animalName, area);

            } else if (command.equals("Feed")) {
                int food = Integer.parseInt(commandsSeparatedByParts[3]);

                if (animalsFood.containsKey(animalName)) {
                    animalsFood.put(animalName, animalsFood.get(animalName) - food);
                    if (animalsFood.get(animalName) <= 0) {
                        animalsFood.remove(animalName);
                        animalsArea.remove(animalName);
                        System.out.printf("%s was successfully fed%n", animalName);
                    }
                }
            }

            commands = scanner.nextLine();
        }


        System.out.println("Animals:");
        for (String animal : animalsFood.keySet()) {
            System.out.printf(" %s -> %dg%n", animal, animalsFood.get(animal));
        }

        System.out.println("Areas with hungry animals:");
        for (String animal : animalsArea.keySet()) {
            String area = animalsArea.get(animal);

            if (!animalsAreaNumber.containsKey(area)) {
                animalsAreaNumber.put(area, 1);
            } else {
                animalsAreaNumber.put(area, animalsAreaNumber.get(area) + 1);
            }

        }
        for (String area : animalsAreaNumber.keySet()) {
            System.out.printf("%s: %d%n", area, animalsAreaNumber.get(area));
        }
    }
}
