package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\input.txt";
        String outputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\writeToFile.txt";

        List<String> inputData = Files.readAllLines(Paths.get(inputPath));

        for (int i = 0; i < inputData.size(); i++) {
            if ((i + 1) % 3 == 0) {
                Files.writeString(Paths.get(outputPath), inputData.get(i) + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        }

    }
}
