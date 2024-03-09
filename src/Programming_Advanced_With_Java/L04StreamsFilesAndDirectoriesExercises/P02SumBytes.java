package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {

            String line = bufferedReader.readLine();
            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
