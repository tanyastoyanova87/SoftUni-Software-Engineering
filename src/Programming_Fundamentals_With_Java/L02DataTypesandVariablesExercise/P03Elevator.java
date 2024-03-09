package Programming_Fundamentals_With_Java.L02DataTypesandVariablesExercise;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacityPeople = Integer.parseInt(scanner.nextLine());

        int result = (int) Math.ceil((double) people / capacityPeople);

        System.out.println(result);
    }
}
