package Programming_Fundamentals_With_Java.FinalExams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> plantRarity = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> plantRating = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            if (!plantRarity.containsKey(plant)) {
                plantRarity.put(plant, rarity);
            } else {
                plantRarity.put(plant, rarity);
            }
            plantRating.putIfAbsent(plant, new ArrayList<>());
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String plant = command.split(" ")[1];
            if (!plantRarity.containsKey(plant)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }
            if (command.contains("Rate:")) {
                double rating = Integer.parseInt(command.split(" ")[3]);
                plantRating.get(plant).add(rating);
            } else if (command.contains("Update:")) {
                int rarity = Integer.parseInt(command.split(" ")[3]);
                plantRarity.put(plant, rarity);
            } else if (command.contains("Reset:")) {
                plantRating.get(plant).clear();
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantRarity.entrySet().forEach(entry -> {
            String plantName = entry.getKey();
            int rarity = entry.getValue();
            double average = plantRating.get(plantName).stream().mapToDouble(a -> a).average().orElse(0.0);
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, rarity, average);
        });
    }
}
