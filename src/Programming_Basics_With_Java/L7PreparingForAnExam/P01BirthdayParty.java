package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());

        double cakePrice = rent * 0.20;
        double liquidPrice = cakePrice - cakePrice * 0.45;
        double animator = rent / 3;

        double sum = rent + cakePrice + liquidPrice + animator;

        System.out.println(sum);
    }
}
