package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int numSaved = num;

        int total = 0;
        while (num > 0){
            int lastDigit = num % 10;
            int sum = 1;
            for (int i = 1; i <= lastDigit ; i++) {
                sum = sum * i;
            }
            num = num / 10;
            total += sum;
        }
        if (numSaved == total){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}