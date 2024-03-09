package Programming_Basics_With_Java.L2ConditionalStatements;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double p1Fill = h * p1;
        double p2Fill = h * p2;
        double p1p2 = p1Fill + p2Fill;

        if (p1p2 < v){
            double poolFilled = p1p2 * 0.100;
            double p1Filled = (p1Fill * 100) / p1p2;
            double p2Filled = (p2Fill * 100) / p1p2;
            System.out.printf("The pool is %.2f %% full. Pipe 1: %.2f %%. Pipe 2: %.2f %%.", poolFilled, p1Filled, p2Filled);

        } else if (p1p2 > v){
            double overflowed = p1p2 - v;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, overflowed);
        }

    }
}
