package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P03ALL_CAPITALS {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputPath))) {

            String line = bufferedReader.readLine();
            while (line != null) {

                bufferedWriter.write(line.toUpperCase());
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
