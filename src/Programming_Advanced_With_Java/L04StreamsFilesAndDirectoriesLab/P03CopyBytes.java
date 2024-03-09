package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\input.txt";
        String outputPath = "C:\\Users\\Emo\\Downloads\\01. Read File_Resources\\writeToFile.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                char ch = (char) oneByte;
                if (ch == 10 || ch == 32) {
                    fileOutputStream.write(oneByte);
                    oneByte = fileInputStream.read();
                    continue;
                }
                String data = String.valueOf(oneByte);
                for (char c : data.toCharArray()) {
                    fileOutputStream.write(c);
                }
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
