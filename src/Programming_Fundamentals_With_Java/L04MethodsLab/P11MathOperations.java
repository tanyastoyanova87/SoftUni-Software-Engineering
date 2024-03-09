package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());


        System.out.println(new DecimalFormat("0.##").format(calculate(firstNum, operator, secondNum)));
    }

    public static double calculate (int num1, String operator, int num2){
        double result = 0;
        switch (operator){
            case "/":
                result = num1 * 1.0 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
        }
        return result;
    }
}
