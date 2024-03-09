package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class P01SumLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                int sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
