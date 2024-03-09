package Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises;

import java.io.File;
public class P08GetFolderSize {
    public static void main(String[] args) {

        String path = "C:\\Users\\Emo\\Desktop\\SoftUni Fundamentals\\Programming Advanced WIth Java\\Programming_Advanced_With_Java.L04StreamsFilesAndDirectoriesExercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);
        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                size += file.length();
            }
        }

        System.out.println("Folder size: " + size);
    }
}
