package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P07MergeTwoFiles {
    public static void main(String[] args) {

        String path1 = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputThree.txt";

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path1));
             BufferedReader bufferedReader2 = Files.newBufferedReader(Paths.get(path2));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputPath))) {

            String line = bufferedReader.readLine();
            while (line != null) {

                bufferedWriter.write(line);
                bufferedWriter.newLine();
                line = bufferedReader.readLine();

            }
            String line2 = bufferedReader2.readLine();
            while (line2 != null) {
                bufferedWriter.write(line2);
                bufferedWriter.newLine();

                line2 = bufferedReader2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
