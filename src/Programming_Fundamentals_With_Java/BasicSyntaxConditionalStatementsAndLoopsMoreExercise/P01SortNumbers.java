package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int biggest = 0;
        int mid = 0;
        int smaller = 0;

        if (num > num2 && num > num3){
            biggest = num;
            if (num2 > num3){
                mid = num2;
                smaller = num3;
            }else {
                mid = num3;
                smaller = num2;
            }
        } else if (num2 > num && num2 > num3) {
            biggest = num2;
            if (num > num3){
                mid = num;
                smaller = num3;
            }else {
                mid = num3;
                smaller = num;
            }
        } else if (num3 > num && num3 > num2) {
            biggest = num3;
            if (num > num2){
                mid = num;
                smaller = num2;
            }else {
                mid = num2;
                smaller = num;
            }
        }
        System.out.println(biggest);
        System.out.println(mid);
        System.out.println(smaller);
    }
}
