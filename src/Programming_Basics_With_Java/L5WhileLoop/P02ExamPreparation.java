package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int poorGrades = Integer.parseInt(scanner.nextLine());
        int tasksCounter = 0;
        int sumGrades = 0;
        int poorGradesCounter = 0;
        String taskName = scanner.nextLine();
        String lastTask = "";

        while (!taskName.equals("Enough")){

            int grade = Integer.parseInt(scanner.nextLine());

            if (grade <= 4){
                poorGradesCounter++;
                sumGrades += grade;
                tasksCounter++;
                if (poorGradesCounter >= poorGrades){
                    break;
                }

            }else {
                tasksCounter++;
                sumGrades += grade;

                lastTask = taskName;
            }
            taskName = scanner.nextLine();
        }
        if (taskName.equals("Enough")){
           double averageScore = sumGrades * 1.0/ tasksCounter;
            System.out.printf("Average score: %.2f%n", averageScore);
            System.out.printf("Number of problems: %d%n", tasksCounter);
            System.out.printf("Last problem: %s%n", lastTask);
        }else {
            System.out.printf("You need a break, %d poor grades.%n", poorGradesCounter);
        }
    }
}
