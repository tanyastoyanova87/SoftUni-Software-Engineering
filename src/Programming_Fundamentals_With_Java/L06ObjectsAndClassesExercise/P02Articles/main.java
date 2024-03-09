package Programming_Fundamentals_With_Java.L06ObjectsAndClassesExercise.P02Articles;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleData = scanner.nextLine().split(", ");
        String title = articleData[0];
        String content = articleData[1];
        String author = articleData[2];

        Article article = new Article(title, content, author);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= commandsCount; i++) {
            String[] currentCommand = scanner.nextLine().split(": ");
            String command = currentCommand[0];
            String text = currentCommand[1];

            switch (command) {
                case "Edit":
                    article.edit(text);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(text);
                    break;
                case "Rename":
                    article.rename(text);
                    break;
            }
        }

        System.out.println(article.toString());
    }
}
