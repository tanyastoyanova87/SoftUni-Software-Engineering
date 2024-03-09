package Programming_Fundamentals_With_Java.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<Double>> studentGrades = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (studentGrades.containsKey(name)) {
                List<Double> currentGrade = studentGrades.get(name);
                currentGrade.add(grade);
            } else {
                studentGrades.put(name, new ArrayList<>());
                studentGrades.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> kvp : studentGrades.entrySet()) {
            String name = kvp.getKey();
            List<Double> grades = kvp.getValue();
            double average = getAverageGrade(grades);

            if (average >= 4.5) {
                System.out.printf("%s -> %.2f%n", name, average);
            }
        }
    }

    private static double getAverageGrade(List<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
