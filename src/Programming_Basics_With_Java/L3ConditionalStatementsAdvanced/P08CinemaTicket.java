package Programming_Basics_With_Java.L3ConditionalStatementsAdvanced;

import java.util.Scanner;

public class P08CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayOfWeek = scanner.nextLine();
        int price = 0;

        if (dayOfWeek.equals("Monday") || dayOfWeek.equals("Tuesday") || dayOfWeek.equals("Friday")){
            price = 12;
        }else if (dayOfWeek.equals("Wednesday") || dayOfWeek.equals("Thursday")){
            price = 14;
        }else {
            price = 16;
        }

        System.out.println(price);
    }
}
