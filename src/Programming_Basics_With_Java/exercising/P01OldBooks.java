package Programming_Basics_With_Java.exercising;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String book = scanner.nextLine();

        boolean isFound = false;
        int checkedBooks = 0;
        String input = scanner.nextLine();
        while (!input.equals("No More Books")){
            if (input.equals(book)){
                isFound = true;
                break;
            }
            checkedBooks++;
            input = scanner.nextLine();
        }
        if (isFound){
            System.out.printf("You checked %d books and found it.%n", checkedBooks);
        }else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.%n", checkedBooks);
        }
    }
}
