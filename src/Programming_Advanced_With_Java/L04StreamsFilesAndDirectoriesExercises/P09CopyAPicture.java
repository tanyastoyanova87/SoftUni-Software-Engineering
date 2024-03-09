package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {
    public static void main(String[] args) {

        String path = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
        String outputPath = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture-copy.jpg";

        try (FileInputStream fileInputStream = new FileInputStream(path);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            int oneByte = fileInputStream.read();

            while (oneByte != -1) {

                fileOutputStream.write(oneByte);

                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
