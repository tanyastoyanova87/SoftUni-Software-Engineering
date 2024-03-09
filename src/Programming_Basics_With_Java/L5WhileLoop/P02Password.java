package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P02Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String regPassword = scanner.nextLine();

        String pass = scanner.nextLine();
        while (!pass.equals(regPassword)){
            pass = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", name);
    }
}
