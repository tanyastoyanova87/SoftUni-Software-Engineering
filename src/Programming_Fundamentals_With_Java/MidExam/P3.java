package Programming_Fundamentals_With_Java.MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> bookShelf = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Done")) {

            String[] commandSplit = command.split(" \\| ");
            String action = commandSplit[0];

            if (action.equals("Add Book")) {
                String book = commandSplit[1];
                if (!bookShelf.contains(book)) {
                    bookShelf.add(0, book);
                }
                
            } else if (action.equals("Take Book")) {
                String book = commandSplit[1];
                if (bookShelf.contains(book)) {
                    bookShelf.remove(book);
                }

            } else if (action.equals("Swap Books")) {
                String book1 = commandSplit[1];
                String book2 = commandSplit[2];

                if (bookShelf.contains(book1) && bookShelf.contains(book2)) {
                    int indexBook1 = bookShelf.indexOf(book1);
                    int indexBook2 = bookShelf.indexOf(book2);
                    bookShelf.set(indexBook1, book2);
                    bookShelf.set(indexBook2, book1);
                }

            } else if (action.equals("Insert Book")) {
                String book = commandSplit[1];
                if (!bookShelf.contains(book)) {
                    bookShelf.add(book);
                }

            } else if (action.equals("Check Book")) {
                int index = Integer.parseInt(commandSplit[1]);

                if (index >= 0 && index < bookShelf.size()) {
                    String bookOnIndex = bookShelf.get(index);
                    System.out.println(bookOnIndex);
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", bookShelf));
    }
}
