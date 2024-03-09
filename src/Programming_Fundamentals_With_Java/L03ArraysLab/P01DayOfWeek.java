package Programming_Fundamentals_With_Java.L03ArraysLab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int day = Integer.parseInt(scanner.nextLine());

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        if (day >= 1 && day <= days.length) {
            System.out.println(days[day - 1]);
        }else {
            System.out.println("Invalid day!");
        }
    }
}
