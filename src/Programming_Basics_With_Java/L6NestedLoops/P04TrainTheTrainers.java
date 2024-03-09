package Programming_Basics_With_Java.L6NestedLoops;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int judgesCount = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double totalGradesSum = 0;
        int countPresentations = 0;

        while (!input.equals("Finish")){
            String presentationName = input;
            double sumGrades = 0;

            for (int i = 1; i <= judgesCount ; i++) {
                double currentGrade = Double.parseDouble(scanner.nextLine());
                sumGrades += currentGrade;
            }
            double averageGradePerPresentation = sumGrades / judgesCount;
            totalGradesSum += averageGradePerPresentation;
            countPresentations++;
            System.out.printf("%s - %.2f.%n", presentationName, averageGradePerPresentation);


            input = scanner.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.%n", totalGradesSum / countPresentations);
    }
}
