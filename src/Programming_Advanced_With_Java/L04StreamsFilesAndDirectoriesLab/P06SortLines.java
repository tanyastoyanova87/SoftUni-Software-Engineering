package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\input.txt";
        String outputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\writeToFile.txt";

        List<String> inputData = Files.readAllLines(Paths.get(inputPath));
        Collections.sort(inputData);
        Files.write(Paths.get(outputPath), inputData);
    }
}
