package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P06WordCount {
    public static void main(String[] args) {


        String inputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String containsPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        List<String> words = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputPath))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] lineSplit = line.split(" ");
                words.addAll(Arrays.asList(lineSplit));

                for (String word : words) {
                    if (containsPath.contains(word)) {

                    }
                }
                line = bufferedReader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
