package Programming_Fundamentals_With_Java.BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String typeOfPeople = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0;
        if (dayOfWeek.equals("Friday")){

            if (typeOfPeople.equals("Students")){
                price = 8.45 * people;
                if (people >= 30){
                    price = price - (price * 0.15);
                }
            } else if (typeOfPeople.equals("Business")) {
                price = 10.90 * people;
                if (people >= 100){
                    price = (people - 10) * 10.90;
                }
            } else if (typeOfPeople.equals("Regular")) {
                price = 15 * people;
                if (people >= 10 && people <= 20){
                    price = price - (price * 0.05);
                }
            }

        } else if (dayOfWeek.equals("Saturday")) {

            if (typeOfPeople.equals("Students")){
                price = 9.80 * people;
                if (people >= 30){
                    price = price - (price * 0.15);
                }
            } else if (typeOfPeople.equals("Business")) {
                price = 15.60 * people;
                if (people >= 100){
                    price = (people - 10) * 15.60;
                }
            } else if (typeOfPeople.equals("Regular")) {
                price = 20 * people;
                if (people >= 10 && people <= 20){
                    price = price - (price * 0.05);
                }
            }
            
        } else if (dayOfWeek.equals("Sunday")) {

            if (typeOfPeople.equals("Students")){
                price = 10.46 * people;
                if (people >= 30){
                    price = price - (price * 0.15);
                }
            } else if (typeOfPeople.equals("Business")) {
                price = 16 * people;
                if (people >= 100){
                    price = (people - 10) * 16;
                }
            } else if (typeOfPeople.equals("Regular")) {
                price = 22.50 * people;
                if (people >= 10 && people <= 20){
                    price = price - (price * 0.05);
                }
            }
        }
        System.out.printf("Total price: %.2f%n", price);
    }
}
