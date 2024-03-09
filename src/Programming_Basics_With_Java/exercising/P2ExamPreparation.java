package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P2ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGrades = Integer.parseInt(scanner.nextLine());

        int poorGradesCount = 0;
        int sumGrades = 0;
        int gradesCount = 0;
        int taskCount = 0;
        String input = scanner.nextLine();
        String lastTask = "";
        while (!input.equals("Enough")){
            taskCount++;
            int grade = Integer.parseInt(scanner.nextLine());
            gradesCount++;

            if (grade <= 4){
                poorGradesCount++;
            }
            sumGrades += grade;
            lastTask = input;

            if (poorGradesCount == poorGrades){
                break;
            }
            input = scanner.nextLine();
        }
        double averageGrade = sumGrades * 1.0 / gradesCount;
        if (input.equals("Enough")){
            System.out.printf("Average score: %.2f%n", averageGrade);
            System.out.printf("Number of problems: %d%n", taskCount);
            System.out.printf("Last problem: %s%n", lastTask);
        }else {
            System.out.printf("You need a break, %d poor grades.%n", poorGradesCount);
        }
    }
}
