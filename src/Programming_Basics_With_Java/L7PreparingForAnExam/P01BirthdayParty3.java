package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P01BirthdayParty3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rentMoney = Double.parseDouble(scanner.nextLine());

        double cake = rentMoney * 0.20;
        double drinks = cake - (cake * 0.45);
        double animator = rentMoney / 3;

        double allPrice = rentMoney + cake + drinks + animator;
        System.out.println(allPrice);
    }
}
