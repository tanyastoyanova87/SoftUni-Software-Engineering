package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {

        Character[] punctuation = {',', '.', '!', '?'};
        Set<Character> pun = new HashSet<>(List.of(punctuation));

        String inputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\input.txt";
        String outputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\writeToFile.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                char ch = (char) oneByte;
                if (!pun.contains(ch)) {
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
