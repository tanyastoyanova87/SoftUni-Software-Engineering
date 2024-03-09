package Programming_Fundamentals_With_Java.L02DataTypesandVariablesExercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int sumSpiceConsumed = 0;
        int days = 0;
        while (startingYield >= 100){

            int spiceConsumed = startingYield - 26;
            sumSpiceConsumed += spiceConsumed;
            days++;
            startingYield -= 10;

        }
        sumSpiceConsumed -= 26;

        if (sumSpiceConsumed < 0){
            sumSpiceConsumed = 0;
        }

        System.out.println(days);
        System.out.println(sumSpiceConsumed);
    }
}
