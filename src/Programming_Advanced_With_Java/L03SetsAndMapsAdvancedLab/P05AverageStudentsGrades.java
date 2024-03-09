package Programming_Advanced_With_Java.L03SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] nameAndGrade = scanner.nextLine().split("\\s+");
            String name = nameAndGrade[0];
            double grade = Double.parseDouble(nameAndGrade[1]);

            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }

        Map<String, Double> average = studentsGrades.entrySet()
                .stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, e -> e.getValue()
                                .stream().mapToDouble(Double::doubleValue)
                                .average().orElse(0.0),
                                (e1, e2) -> e1,
                                TreeMap::new));


        average.forEach((key, value) -> {
            System.out.printf("%s -> ", key);
            studentsGrades.get(key).forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", value);
        });
    }
}
