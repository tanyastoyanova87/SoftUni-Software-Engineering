package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      int width = Integer.parseInt(scanner.nextLine());
      int length = Integer.parseInt(scanner.nextLine());
      int height = Integer.parseInt(scanner.nextLine());
      String command = scanner.nextLine();

      int allSpace = width * length * height;

      while (!command.equals("Done")){
          int boxes = Integer.parseInt(command);

          allSpace -= boxes;

          if (allSpace <= 0){
              System.out.printf("No more free space! You need %d Cubic meters more.%n", Math.abs(allSpace));
              break;
          }
          command = scanner.nextLine();
      }
      if (command.equals("Done")){
          System.out.printf("%d Cubic meters left.%n", allSpace);
      }
    }
}
