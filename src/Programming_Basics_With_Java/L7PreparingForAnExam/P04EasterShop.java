package Programming_Basics_With_Java.L7PreparingForAnExam;

import java.util.Scanner;

public class P04EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsInStore = Integer.parseInt(scanner.nextLine());
        int eggsSold = 0;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Close")) {
                System.out.println("Store is closed!");
                System.out.printf("%d eggs sold.%n", eggsSold);
                break;
            }

            int eggs = Integer.parseInt(scanner.nextLine());

            if (command.equals("Fill")) {
                eggsInStore += eggs;
            } else if (command.equals("Buy")) {
                if (eggs <= eggsInStore) {
                    eggsInStore -= eggs;
                    eggsSold += eggs;
                } else {
                    System.out.println("Not enough eggs in store!");
                    System.out.printf("You can buy only %d.%n", eggsInStore);
                    eggsSold += eggsInStore;
                    eggsInStore = 0;
                    break;
                }
            }
        }
    }
}
