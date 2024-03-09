package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int piecesCount = width * length;

        String command = scanner.nextLine();
        while (!command.equals("STOP")){
            int pieces = Integer.parseInt(command);

            piecesCount -= pieces;

            if (piecesCount < 0){
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("STOP")){
            System.out.printf("%d pieces are left.%n", piecesCount);
        }else {
            System.out.printf("No more cake left! You need %d pieces more.%n", Math.abs(piecesCount));
        }
    }
}
