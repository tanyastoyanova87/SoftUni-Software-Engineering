package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int sumSteps = 0;
        while (!input.equals("Going home")){
            int steps = Integer.parseInt(input);
            sumSteps += steps;

            if (sumSteps >= 10000){
                break;
            }

            input = scanner.nextLine();
        }
        if (input.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            sumSteps += stepsToHome;
        }
        int neededOrOver = Math.abs(10000 - sumSteps);
        if (sumSteps >= 10000){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!%n", neededOrOver);
        }else {
            System.out.printf("%d more steps to reach goal.%n", neededOrOver);
        }
    }
}
