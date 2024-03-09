package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isFailed = false;
        String name = scanner.nextLine();

        int failedCount = 0;
        double averageGrade = 0;
        double sum = 0;
        int year = 1;
        while (year <= 12){
            if (failedCount > 1){
                break;
            }
            double currentGrade = Double.parseDouble(scanner.nextLine());

            if (currentGrade < 4){
                isFailed = true;
                failedCount++;
                continue;
            }

            sum = sum + currentGrade;
            averageGrade = sum / 12;
            year++;

        }
        if (isFailed){
            System.out.printf("%s has been excluded at %d grade%n", name, year);
        }else {
            System.out.printf("%s graduated. Average grade: %.2f%n", name, averageGrade);
        }
    }
}
