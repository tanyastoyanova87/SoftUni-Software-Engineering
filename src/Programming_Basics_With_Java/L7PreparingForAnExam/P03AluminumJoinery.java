package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P03AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int windowsCount = Integer.parseInt(scanner.nextLine());
        String windowsType = scanner.nextLine();
        String deliveryOrNot = scanner.nextLine();

        double price = 0;
        if (windowsType.equals("90X130")) {
            price = windowsCount * 110;
            if (windowsCount > 30 && windowsCount < 60) {
                price = price - price * 0.05;
            } else {
                price = price - price * 0.08;
            }
        } else if (windowsType.equals("100X150")) {
            price = windowsCount * 140;
            if (windowsCount > 40 && windowsCount < 80) {
                price = price - price * 0.06;
            } else {
                price = price - price * 0.10;
            }
        } else if (windowsType.equals("130X180")) {
            price = windowsCount * 190;
            if (windowsCount > 20 && windowsCount < 50) {
                price = price - price * 0.07;
            } else {
                price = price - price * 0.12;
            }
        } else if (windowsType.equals("200X300")) {
            price = windowsCount * 250;
            if (windowsCount > 25 && windowsCount < 50) {
                price = price - price * 0.09;
            } else {
                price = price - price * 0.14;
            }
        }

        if (deliveryOrNot.equals("With delivery")) {
            price = price + 60;
        }
        if (windowsCount > 99) {
            price = price - price * 0.04;
        }
        if (windowsCount < 10) {
            System.out.println("Invalid order");
        } else {
            System.out.printf("%.2f BGN%n", price);
        }
    }
}
