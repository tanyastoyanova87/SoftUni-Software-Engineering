package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesLab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\input.txt";

        try (FileReader fileReader = new FileReader(inputPath)) {
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
