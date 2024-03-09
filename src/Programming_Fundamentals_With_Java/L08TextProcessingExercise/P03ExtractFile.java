package Programming_Fundamentals_With_Java.L08TextProcessingExercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePaths = scanner.nextLine();
        String[] paths = filePaths.split("\\\\");

        String file = paths[paths.length - 1];
        String[] fileSplit = file.split("\\.");

        String fileName = fileSplit[0];
        String extension = fileSplit[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);


    }
}
