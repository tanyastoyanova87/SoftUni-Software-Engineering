package Programming_Fundamentals_With_Java.L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isEven = false;
        while (!isEven){
            int num = Math.abs(Integer.parseInt(scanner.nextLine()));
            if (num % 2 == 0){
                isEven = true;
                System.out.printf("The number is: %d%n", num);
            }else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
