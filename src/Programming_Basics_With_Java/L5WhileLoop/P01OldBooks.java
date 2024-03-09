package Programming_Basics_With_Java.L5WhileLoop;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String favouriteBook = scanner.nextLine();
        String text = scanner.nextLine();
        int bookCounter = 0;

        while (!text.equals(favouriteBook)){
            text = scanner.nextLine();
            bookCounter++;

            if (text.equals("No More Books")){
                break;
            }
        }
        if (text.equals("No More Books")){
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.%n", bookCounter);
        } else {
            System.out.printf("You checked %d books and found it.%n", bookCounter);
        }
    }
}
