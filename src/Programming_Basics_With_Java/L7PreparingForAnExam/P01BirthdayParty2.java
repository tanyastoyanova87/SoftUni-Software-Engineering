package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01BirthdayParty2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());

        double cakePrice = 0.20 * rent;
        double drinks = cakePrice - (cakePrice * 0.45);
        double animator = rent / 3;

        double neededBudget = cakePrice + drinks + animator + rent;

        System.out.println(neededBudget);
    }
}
