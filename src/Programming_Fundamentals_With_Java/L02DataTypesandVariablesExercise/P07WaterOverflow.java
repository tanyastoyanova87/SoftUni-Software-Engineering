package Programming_Fundamentals_With_Java.L02DataTypesandVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= n ; i++) {

            int litres = Integer.parseInt(scanner.nextLine());
            sum += litres;

            if (sum > 255){
                System.out.println("Insufficient capacity!");
                sum -= litres;
            }
        }
        System.out.println(sum);
    }
}
