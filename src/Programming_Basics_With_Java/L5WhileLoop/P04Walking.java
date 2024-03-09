package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int stepsSum = 0;

        while (!input.equals("Going home")){
            int currentNum = Integer.parseInt(input);

            stepsSum += currentNum;

            if (stepsSum >= 10000){
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            stepsSum += stepsToHome;
        }
        if (stepsSum < 10000){
            System.out.printf(" %d more steps to reach goal.%n", 10000 - stepsSum);
        }else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!%n", stepsSum - 10000);
        }
    }
}
