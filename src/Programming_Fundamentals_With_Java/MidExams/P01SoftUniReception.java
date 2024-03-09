package Programming_Fundamentals_With_Java.MidExams;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int takenStudentsPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int hour = 0;
        while (studentsCount > 0) {
            hour++;
            if (hour % 4 != 0) {
                studentsCount -= takenStudentsPerHour;
            }
        }
        System.out.printf("Time needed: %dh.%n", hour);
    }
}
