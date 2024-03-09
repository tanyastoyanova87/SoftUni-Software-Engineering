package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P07WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String daysOfWeek = scanner.nextLine();

        boolean isWorkingDays = daysOfWeek.equals("Monday") ||
                daysOfWeek.equals("Tuesday") ||
                daysOfWeek.equals("Wednesday") ||
                daysOfWeek.equals("Thursday") ||
                daysOfWeek.equals("Friday") ||
                daysOfWeek.equals("Saturday");

        boolean isHours = hour >= 10 && hour <= 18;

        if (isWorkingDays && isHours){
            System.out.println("open");
        }else {
            System.out.println("closed");
        }
    }
}
