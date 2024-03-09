package Programming_Fundamentals_With_Java.L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;
        if (age >= 0 && age <= 18){
            if (dayType.equals("Weekday")){
                price = 12;
                System.out.printf("%d$%n", price);
            }else if (dayType.equals("Weekend")){
                price = 15;
                System.out.printf("%d$%n", price);
            }else if (dayType.equals("Holiday")){
                price = 5;
                System.out.printf("%d$%n", price);
            }
        }else if (age > 18 && age <= 64){
            if (dayType.equals("Weekday")){
                price = 18;
                System.out.printf("%d$%n", price);
            }else if (dayType.equals("Weekend")){
                price = 20;
                System.out.printf("%d$%n", price);
            }else if (dayType.equals("Holiday")){
                price = 12;
                System.out.printf("%d$%n", price);
            }
        }else if (age > 64 && age <= 122){
            if (dayType.equals("Weekday")){
                price = 12;
                System.out.printf("%d$%n", price);
            }else if (dayType.equals("Weekend")){
                price = 15;
                System.out.printf("%d$%n", price);
            }else if (dayType.equals("Holiday")){
                price = 10;
                System.out.printf("%d$%n", price);
            }
        }else {
            System.out.println("Error!");
        }
    }
}
