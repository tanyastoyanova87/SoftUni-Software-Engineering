package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        boolean isFailed = false;
        int year = 1;
        int failedYear = 0;
        double sumGrades = 0;
        while (year <= 12){
            if (failedYear > 1){
                isFailed = true;
                break;
            }
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade < 4){
                failedYear++;
                continue;
            }
            sumGrades += grade;
            year++;
        }
        if (isFailed){
            System.out.printf("%s has been excluded at %d grade", name, year);
        }else {
            double averageGrade = sumGrades / 12;
            System.out.printf("%s graduated. Average grade: %.2f%n", name, averageGrade);
        }
    }
}
