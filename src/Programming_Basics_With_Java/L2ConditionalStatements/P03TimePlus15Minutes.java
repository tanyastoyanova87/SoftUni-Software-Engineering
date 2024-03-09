package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P03TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int hoursInMinutes = hours * 60 + minutes + 15;

        int totalHours = hoursInMinutes / 60;
        int totalMinutes = hoursInMinutes % 60;

        if (totalHours < 24){
            System.out.printf("%d:%02d",totalHours, totalMinutes);
        } else {
            totalHours = 0;
            System.out.printf("%d:%02d", totalHours, totalMinutes);
        }
    }
}
