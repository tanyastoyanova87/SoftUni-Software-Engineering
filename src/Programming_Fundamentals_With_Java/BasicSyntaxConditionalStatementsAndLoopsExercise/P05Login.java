package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();


        String reversedWholePass = "";
        for (int i = password.length() - 1; i >= 0  ; i--) {
            char reversedPass = password.charAt(i);
            reversedWholePass += reversedPass;
        }
        int tries = 0;
        String tryPass = scanner.nextLine();
        while (!tryPass.equals(reversedWholePass)){

            tries++;
            if (tries == 4){
                System.out.printf("User %s blocked!%n", password);
                return;
            }
            System.out.println("Incorrect password. Try again.");

            tryPass = scanner.nextLine();
        }
        System.out.printf("User %s logged in.%n", password);
    }
}
