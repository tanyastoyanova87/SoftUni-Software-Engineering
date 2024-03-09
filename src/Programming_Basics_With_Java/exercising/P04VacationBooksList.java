package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pagesInCurrentBook = Integer.parseInt(scanner.nextLine());
        int pagesReadInOneHour = Integer.parseInt(scanner.nextLine());
        int daysToReadTheBooks = Integer.parseInt(scanner.nextLine());

        int hours = (pagesInCurrentBook / pagesReadInOneHour) / daysToReadTheBooks;
        System.out.println(hours);

    }
}
