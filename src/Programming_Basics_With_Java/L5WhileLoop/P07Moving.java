package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int space = width * length * height;

        while (!command.equals("Done")){
            int currentNum = Integer.parseInt(command);
            space -= currentNum;

            if (space <= 0){
                System.out.printf("No more free space! You need %d Cubic meters more.%n", Math.abs(space));
                break;
            }

            command = scanner.next();
        }

        if (command.equals("Done")){
            System.out.printf("%d Cubic meters left.%n", space);
        }
    }
}
