package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> towns = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!towns.containsKey(continent)) {
                towns.put(continent, new LinkedHashMap<>() {{put(country, new ArrayList<>() {{add(city);}});}});
            } else {
                if (!towns.get(continent).containsKey(country)) {
                    towns.get(continent).put(country, new ArrayList<>(){{add(city);}});
                } else {
                    towns.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, Map<String, List<String>>> continent : towns.entrySet()) {
            System.out.printf("%s: %n", continent.getKey());
            for (Map.Entry<String, List<String>> countries : continent.getValue().entrySet()) {
                System.out.printf("%s -> ", countries.getKey());
                System.out.print(String.join(", ", countries.getValue()));
                System.out.println();
            }

        }
    }
}
