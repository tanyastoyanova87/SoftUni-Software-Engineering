package Programming_Fundamentals_With_Java.L04MethodsLab;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        orderPrice(product, quantity);
    }

    public static void orderPrice(String product, int quantity){
        double price = 0;
        if (product.equals("coffee")){
            price = quantity * 1.5;
        } else if (product.equals("water")) {
            price = quantity * 1.0;
        } else if (product.equals("coke")) {
            price = quantity * 1.4;
        } else if (product.equals("snacks")) {
            price = quantity * 2;
        }
        System.out.printf("%.2f%n", price);
    }
}
