package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int cubicMetresAvailable = width * length * height;

        int boxesCount = 0;
        String command = scanner.nextLine();
        while (!command.equals("Done")){
            int boxes = Integer.parseInt(command);
            boxesCount += boxes;

            if (boxesCount >= cubicMetresAvailable){
                break;
            }
            command = scanner.nextLine();
        }
        if (boxesCount >= cubicMetresAvailable){
            System.out.printf("No more free space! You need %d Cubic meters more.%n", boxesCount - cubicMetresAvailable);
        }else {
            System.out.printf("%d Cubic meters left.%n", cubicMetresAvailable - boxesCount);
        }
    }
}
