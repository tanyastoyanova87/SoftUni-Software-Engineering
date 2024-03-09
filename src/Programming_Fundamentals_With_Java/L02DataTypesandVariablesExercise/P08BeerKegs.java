package Programming_Fundamentals_With_Java.L02DataTypesandVariablesExercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double maxNum = Integer.MIN_VALUE;
        String biggestKeg = "";
        for (int i = 1; i <= n ; i++) {

            String modelKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double result = Math.PI * radius * radius * height;

            if (result > maxNum){
                maxNum = result;
                biggestKeg = modelKeg;
            }
        }
        System.out.println(biggestKeg);
    }
}
