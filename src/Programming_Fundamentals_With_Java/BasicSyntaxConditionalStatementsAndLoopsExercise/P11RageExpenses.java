package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double expenses = 0;
        int keyboardTrash = 0;
        for (int i = 1; i <= lostGamesCount ; i++) {

            if (i % 2 == 0 && i % 3 == 0){
                expenses += headsetPrice;
                expenses += mousePrice;
                expenses += keyboardPrice;
                keyboardTrash++;
                if (keyboardTrash % 2 == 0){
                    expenses += displayPrice;
                }
            } else if (i % 3 == 0) {
                expenses += mousePrice;
            }else if (i % 2 == 0){
                expenses += headsetPrice;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.%n", expenses);
    }
}
