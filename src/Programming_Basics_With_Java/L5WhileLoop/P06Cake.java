package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int allPieces = length * width;

        while (!command.equals("STOP")){
            int currentNumOfPieces = Integer.parseInt(command);
            allPieces -= currentNumOfPieces;

            if (allPieces <= 0){
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("STOP")){
            System.out.printf("%d pieces are left.%n", allPieces);
        }else {
            System.out.printf("No more cake left! You need %d pieces more.%n", Math.abs(allPieces));
        }
    }
}
