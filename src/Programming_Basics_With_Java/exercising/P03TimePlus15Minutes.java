package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P03TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = hour * 60 + minutes + 15;
        int hours = allMinutes / 60;

        if (hours > 23){
            hours = 0;
        }
        int minutes2 = allMinutes % 60;

        System.out.printf("%d:%02d%n", hours, minutes2);

    }
}
