package Programming_Fundamentals_With_Java.L03ArraysExersice;

import java.util.Arrays;
import java.util.Scanner;

public class P10TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());

        int[] liftState = Arrays.stream(scanner.nextLine()
                                .split(" "))
                        .mapToInt(e -> Integer.parseInt(e))
                        .toArray();

        boolean isFull = true;
        for (int i = 0; i < liftState.length; i++) {
            int availableSpace = 4 - liftState[i];

            if (availableSpace > 0){
                if (availableSpace > peopleWaiting){
                    liftState[i] += peopleWaiting;
                    peopleWaiting = 0;
                    isFull = false;

                }else {
                    liftState[i] = 4;
                    peopleWaiting -= availableSpace;
                }
            }
        }
        if (!isFull){
            System.out.println("The lift has empty spots!");
        }else if (peopleWaiting > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }
        for (int people : liftState) {
            System.out.print(people + " ");
        }
    }
}

