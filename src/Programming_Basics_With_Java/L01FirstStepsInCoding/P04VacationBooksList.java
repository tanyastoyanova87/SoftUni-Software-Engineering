package Programming_Basics_With_Java.L01FirstStepsInCoding;

import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allPages = Integer.parseInt(scanner.nextLine());
        int pagesOneHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int totalTimeReading = allPages / pagesOneHour;
        int hoursForOneDay = totalTimeReading / days;

        System.out.println(hoursForOneDay);

    }
}
