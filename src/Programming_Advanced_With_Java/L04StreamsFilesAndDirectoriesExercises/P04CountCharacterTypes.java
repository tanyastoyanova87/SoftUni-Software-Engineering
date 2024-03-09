package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class P04CountCharacterTypes {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Set<Character> vowels = Set.of('e', 'a', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputPath))) {

            String line = bufferedReader.readLine();

            int vowelsCount = 0;
            int punCount = 0;
            int othersCount = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuation.contains(c)) {
                        punCount++;
                    } else if (c != ' ') {
                        othersCount++;
                    }
                }

                line = bufferedReader.readLine();
            }

            bufferedWriter.write(String.format("Vowels: %d%n", vowelsCount));
            bufferedWriter.write(String.format("Other symbols: %d%n", othersCount));
            bufferedWriter.write(String.format("Punctuation: %d%n", punCount));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
